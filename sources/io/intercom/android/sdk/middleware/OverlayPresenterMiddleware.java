package io.intercom.android.sdk.middleware;

import android.app.Activity;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.overlay.OverlayPresenter;
import io.intercom.android.sdk.state.OverlayState;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;

public class OverlayPresenterMiddleware implements Store.Middleware<State> {
    private final Provider<OverlayPresenter> presenterProvider;

    public OverlayPresenterMiddleware(Provider<OverlayPresenter> provider) {
        this.presenterProvider = provider;
    }

    public void dispatch(Store<State> store, Action<?> action, Store.NextDispatcher nextDispatcher) {
        OverlayState overlayState = (OverlayState) store.select(Selectors.OVERLAY);
        Activity pausedHostActivity = overlayState.pausedHostActivity();
        Activity resumedHostActivity = overlayState.resumedHostActivity();
        int i = AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()];
        if (i != 1) {
            if (i == 2) {
                removeOverlays(pausedHostActivity);
            } else if (i != 3) {
                if (i == 4) {
                    presenter().cancelAnimations();
                    removeOverlays(pausedHostActivity);
                    removeOverlays(resumedHostActivity);
                }
            } else if (((Activity) action.value()) == pausedHostActivity) {
                removeOverlays(pausedHostActivity);
            }
        } else if (((Activity) action.value()) != pausedHostActivity) {
            removeOverlays(pausedHostActivity);
        }
        nextDispatcher.dispatch(action);
    }

    /* renamed from: io.intercom.android.sdk.middleware.OverlayPresenterMiddleware$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.intercom.android.sdk.actions.Action$Type[] r0 = io.intercom.android.sdk.actions.Action.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$intercom$android$sdk$actions$Action$Type = r0
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.ACTIVITY_READY_FOR_VIEW_ATTACHMENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.ACTIVITY_PAUSED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.ACTIVITY_STOPPED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.APP_ENTERED_BACKGROUND     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.middleware.OverlayPresenterMiddleware.AnonymousClass1.<clinit>():void");
        }
    }

    private void removeOverlays(Activity activity) {
        if (activity != null) {
            presenter().removeOverlaysIfPresent(activity);
        }
    }

    private OverlayPresenter presenter() {
        return this.presenterProvider.get();
    }
}
