package io.intercom.android.sdk.middleware;

import io.intercom.android.sdk.IntercomStatusCallbackKt;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.api.UserUpdateRequest;
import io.intercom.android.sdk.api.UserUpdater;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;

public class UserUpdaterMiddleware implements Store.Middleware<State> {
    private final Provider<AppConfig> appConfigProvider;
    private final Provider<UserIdentity> userIdentityProvider;
    private final Provider<UserUpdater> userUpdater;

    public UserUpdaterMiddleware(Provider<UserUpdater> provider, Provider<AppConfig> provider2, Provider<UserIdentity> provider3) {
        this.appConfigProvider = provider2;
        this.userUpdater = provider;
        this.userIdentityProvider = provider3;
    }

    public void dispatch(Store<State> store, Action<?> action, Store.NextDispatcher nextDispatcher) {
        nextDispatcher.dispatch(action);
        if (AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()] == 1 && ((Long) action.value()).longValue() - store.state().hostAppState().backgroundedTimestamp() > this.appConfigProvider.get().getNewSessionThresholdMs() && this.userIdentityProvider.get().identityExists() && !((Boolean) store.select(Selectors.SESSION_STARTED_SINCE_LAST_BACKGROUNDED)).booleanValue()) {
            this.userUpdater.get().updateUser(UserUpdateRequest.create(true, ((Boolean) store.select(Selectors.APP_IS_BACKGROUNDED)).booleanValue(), true), IntercomStatusCallbackKt.getNoStatusCallback());
        }
    }

    /* renamed from: io.intercom.android.sdk.middleware.UserUpdaterMiddleware$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type;

        static {
            int[] iArr = new int[Action.Type.values().length];
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type = iArr;
            try {
                iArr[Action.Type.APP_ENTERED_FOREGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
