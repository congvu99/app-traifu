package io.intercom.android.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.api.UserUpdater;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.overlay.OverlayPresenter;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.user.DeviceData;
import io.intercom.android.sdk.utilities.ActivityFinisher;

public class ResetManager {
    private final ActivityFinisher activityFinisher;
    private final Provider<Api> apiProvider;
    private final Provider<AppConfig> appConfigProvider;
    private final Context context;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable hardResetTask = new Runnable() {
        public void run() {
            ResetManager.this.hardReset();
        }
    };
    private final OverlayPresenter overlayPresenter;
    private final Store<State> store;
    private final Twig twig = LumberMill.getLogger();
    private final UserIdentity userIdentity;
    private final UserUpdater userUpdater;

    public ResetManager(Provider<Api> provider, UserIdentity userIdentity2, OverlayPresenter overlayPresenter2, Provider<AppConfig> provider2, Store<State> store2, UserUpdater userUpdater2, Context context2, ActivityFinisher activityFinisher2) {
        this.apiProvider = provider;
        this.userIdentity = userIdentity2;
        this.overlayPresenter = overlayPresenter2;
        this.appConfigProvider = provider2;
        this.store = store2;
        this.userUpdater = userUpdater2;
        this.context = context2;
        this.activityFinisher = activityFinisher2;
    }

    public void softReset() {
        this.activityFinisher.finishActivities();
        this.overlayPresenter.softReset();
        this.handler.postDelayed(this.hardResetTask, this.appConfigProvider.get().getSoftResetTimeoutMs());
        this.store.dispatch(Actions.softReset());
        this.twig.i("Successfully reset the user. To resume communicating with Intercom, you can register a user", new Object[0]);
    }

    public void hardReset() {
        this.handler.removeCallbacks(this.hardResetTask);
        if (isSoftReset()) {
            String deviceToken = DeviceData.getDeviceToken(this.context);
            if (TextUtils.isEmpty(deviceToken)) {
                this.twig.internal("There is no device token to remove.");
            } else {
                this.apiProvider.get().removeDeviceToken(deviceToken, this.userIdentity);
            }
            this.store.dispatch(Actions.hardReset());
        }
    }

    public void clear() {
        this.handler.removeCallbacks(this.hardResetTask);
    }

    /* access modifiers changed from: package-private */
    public boolean isSoftReset() {
        return this.userIdentity.isSoftReset();
    }
}