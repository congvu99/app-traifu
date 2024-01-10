package io.intercom.android.sdk.carousel;

import android.os.Build;
import android.text.TextUtils;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.carousel.Carousel;
import io.intercom.android.sdk.models.carousel.CarouselScreen;
import io.intercom.android.sdk.models.carousel.ScreenAction;
import io.intercom.android.sdk.state.OverlayState;
import io.intercom.android.sdk.state.ProgrammaticCarouselState;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.utilities.StoreUtils;
import java.util.Iterator;
import java.util.List;

public final class CarouselPresenter {
    private final Api api;
    private Carousel carousel;
    private String carouselId = null;
    private String carouselSource = MetricTracker.CarouselSource.PROGRAMMATIC;
    private int initialNumberOfScreens;
    private final MetricTracker metricTracker;
    private final PermissionManager permissionManager;
    private Store.Subscription programmaticCarouselSubscription = null;
    private final Store<State> store;
    private UserIdentity userIdentity;
    private CarouselView view = null;

    public CarouselPresenter(Store<State> store2, Api api2, UserIdentity userIdentity2, MetricTracker metricTracker2, PermissionManager permissionManager2) {
        Carousel carousel2 = Carousel.NULL;
        this.carousel = carousel2;
        this.store = store2;
        this.api = api2;
        this.userIdentity = userIdentity2;
        this.metricTracker = metricTracker2;
        this.permissionManager = permissionManager2;
        filterCarouselScreens(carousel2);
    }

    public void attachView(CarouselView carouselView) {
        this.view = carouselView;
    }

    public void detachView() {
        StoreUtils.safeUnsubscribe(this.programmaticCarouselSubscription);
        this.view = null;
    }

    public String getCarouselSource() {
        return this.carouselSource;
    }

    public void fetchCarousel(String str) {
        this.carouselId = str;
        setSource(str);
        if (!MetricTracker.CarouselSource.PROGRAMMATIC.equals(this.carouselSource)) {
            fetchAutomaticCarousel();
        } else if (TextUtils.isEmpty(str)) {
            this.view.logEmptyCarouselError();
            this.view.showNotFoundError();
        } else if (noUserRegistered()) {
            this.view.logUserNotRegisteredError();
            this.view.showNotFoundError();
        } else {
            fetchProgrammaticCarousel(str);
        }
    }

    private boolean noUserRegistered() {
        return !this.userIdentity.identityExists() || this.userIdentity.isSoftReset();
    }

    public void retryFetch(String str) {
        if (TextUtils.isEmpty(str)) {
            CarouselView carouselView = this.view;
            if (carouselView != null) {
                carouselView.showNotFoundError();
                return;
            }
            return;
        }
        this.metricTracker.retriedCarouselFetching(str, this.carouselSource);
        fetchProgrammaticCarousel(str);
    }

    public Carousel getCarousel() {
        return this.carousel;
    }

    public void resetPersistedCarousel() {
        this.store.dispatch(Actions.carouselDismissed());
    }

    public void recordDismissedOrCompletedStats(boolean z) {
        String instanceId = getCarousel().getInstanceId();
        if (!TextUtils.isEmpty(instanceId)) {
            if (z) {
                this.api.markCarouselAsCompleted(instanceId, isTriggeredFromCode());
            } else {
                this.api.markCarouselAsDismissed(instanceId, isTriggeredFromCode());
            }
        }
    }

    public void recordScreenSeenStats(String str) {
        this.api.markCarouselScreenViewed(getCarousel().getInstanceId(), str, isTriggeredFromCode());
    }

    public void recordActionButtonTappedStats(String str) {
        this.api.markCarouselActionButtonTapped(getCarousel().getInstanceId(), str, isTriggeredFromCode());
    }

    public void recordOpenMetric() {
        this.metricTracker.openedCarousel(getCarousel().getInstanceId(), this.carouselSource, this.initialNumberOfScreens, getCarousel().getScreens().size());
    }

    public void recordDismissedOrCompletedMetric(String str, boolean z, int i) {
        String instanceId = getCarousel().getInstanceId();
        if (!TextUtils.isEmpty(instanceId)) {
            int size = getCarousel().getScreens().size();
            if (z) {
                this.metricTracker.completedCarousel(str, instanceId, this.carouselSource, this.initialNumberOfScreens, size);
                return;
            }
            this.metricTracker.dismissedCarousel(str, instanceId, this.carouselSource, this.initialNumberOfScreens, size, i);
        } else if (!TextUtils.isEmpty(this.carouselId)) {
            this.metricTracker.dismissedCarouselFetching(str, this.carouselId, this.carouselSource);
        }
    }

    public void recordPermissionRequestedMetric(String str, int[] iArr, String str2) {
        String instanceId = getCarousel().getInstanceId();
        int length = iArr.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (iArr[i] == 0) {
                this.api.markPermissionGranted(instanceId, str2, isTriggeredFromCode());
                z = true;
                break;
            } else {
                i++;
            }
        }
        this.metricTracker.requestedPermission(str, instanceId, this.carouselSource, z);
    }

    public void recordSentToPermissionSettingsMetric(ScreenAction screenAction, String str) {
        String type = screenAction.getType();
        boolean permissionsGranted = this.permissionManager.permissionsGranted(screenAction.getValidPermissions(this.permissionManager));
        String instanceId = getCarousel().getInstanceId();
        if (permissionsGranted) {
            this.api.markPermissionGranted(instanceId, str, isTriggeredFromCode());
        }
        this.metricTracker.sentToPermissionSettings(type, instanceId, this.carouselSource, permissionsGranted);
    }

    /* access modifiers changed from: package-private */
    public void filterCarouselScreens(Carousel carousel2) {
        Iterator<CarouselScreen> it = carousel2.getScreens().iterator();
        while (it.hasNext()) {
            if (screenShouldBeRemoved(it.next())) {
                it.remove();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean screenShouldBeRemoved(CarouselScreen carouselScreen) {
        ScreenAction permissionAction = carouselScreen.getPermissionAction();
        if (ScreenAction.NULL.equals(permissionAction)) {
            return false;
        }
        List<String> validPermissions = permissionAction.getValidPermissions(this.permissionManager);
        if (Build.VERSION.SDK_INT < 23 || validPermissions.isEmpty() || this.permissionManager.permissionsGranted(validPermissions)) {
            return true;
        }
        return false;
    }

    private void fetchAutomaticCarousel() {
        Carousel carousel2 = ((OverlayState) this.store.select(Selectors.OVERLAY)).carousel();
        this.carousel = carousel2;
        this.initialNumberOfScreens = carousel2.getScreens().size();
        filterCarouselScreens(this.carousel);
        CarouselView carouselView = this.view;
        if (carouselView != null) {
            carouselView.showSuccess(this.carousel);
        }
    }

    private void fetchProgrammaticCarousel(String str) {
        StoreUtils.safeUnsubscribe(this.programmaticCarouselSubscription);
        this.store.dispatch(Actions.openProgrammaticCarousel(str));
        this.programmaticCarouselSubscription = this.store.subscribeToChanges(Selectors.PROGRAMMATIC_CAROUSEL_STATE, new Store.Subscriber(str) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onStateChange(Object obj) {
                CarouselPresenter.this.lambda$fetchProgrammaticCarousel$0$CarouselPresenter(this.f$1, (ProgrammaticCarouselState) obj);
            }
        });
    }

    public /* synthetic */ void lambda$fetchProgrammaticCarousel$0$CarouselPresenter(String str, ProgrammaticCarouselState programmaticCarouselState) {
        if (programmaticCarouselState instanceof ProgrammaticCarouselState.Loading) {
            this.metricTracker.startedCarouselFetching(str, this.carouselSource);
            CarouselView carouselView = this.view;
            if (carouselView != null) {
                carouselView.showLoading();
            }
        } else if (programmaticCarouselState instanceof ProgrammaticCarouselState.Success) {
            StoreUtils.safeUnsubscribe(this.programmaticCarouselSubscription);
            Carousel carousel2 = ((ProgrammaticCarouselState.Success) programmaticCarouselState).carousel();
            this.carousel = carousel2;
            CarouselView carouselView2 = this.view;
            if (carouselView2 != null) {
                carouselView2.showSuccess(carousel2);
            }
        } else if (programmaticCarouselState instanceof ProgrammaticCarouselState.Error) {
            StoreUtils.safeUnsubscribe(this.programmaticCarouselSubscription);
            ProgrammaticCarouselState.Error error = (ProgrammaticCarouselState.Error) programmaticCarouselState;
            this.metricTracker.failedCarousel(str, this.carouselSource, error.errorCode());
            if (this.view == null) {
                return;
            }
            if (error.errorCode() == 404) {
                this.view.showNotFoundError();
            } else {
                this.view.showGenericError();
            }
        }
    }

    private boolean isTriggeredFromCode() {
        return this.carouselSource.equals(MetricTracker.CarouselSource.PROGRAMMATIC);
    }

    private void setSource(String str) {
        this.carouselSource = str == null ? "automatic" : MetricTracker.CarouselSource.PROGRAMMATIC;
    }
}
