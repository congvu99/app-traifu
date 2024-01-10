package io.intercom.android.sdk.middleware;

import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.models.BaseResponse;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;

public class UserIdentityMiddleware implements Store.Middleware<State> {
    private final Provider<UserIdentity> userIdentityProvider;

    public UserIdentityMiddleware(Provider<UserIdentity> provider) {
        this.userIdentityProvider = provider;
    }

    public void dispatch(Store<State> store, Action<?> action, Store.NextDispatcher nextDispatcher) {
        nextDispatcher.dispatch(action);
        int i = AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()];
        if (i == 1) {
            this.userIdentityProvider.get().update(((BaseResponse) action.value()).getUser());
        } else if (i == 2) {
            this.userIdentityProvider.get().softReset();
        } else if (i == 3) {
            this.userIdentityProvider.get().hardReset();
        }
    }

    /* renamed from: io.intercom.android.sdk.middleware.UserIdentityMiddleware$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.intercom.android.sdk.actions.Action$Type[] r0 = io.intercom.android.sdk.actions.Action.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$intercom$android$sdk$actions$Action$Type = r0
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.BASE_RESPONSE_RECEIVED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.SOFT_RESET     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.HARD_RESET     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.middleware.UserIdentityMiddleware.AnonymousClass1.<clinit>():void");
        }
    }
}
