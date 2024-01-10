package io.intercom.android.sdk.api;

import io.intercom.android.sdk.IntercomStatusCallback;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.metrics.ops.OpsMetricTracker;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;

public class UserUpdater {
    private final Provider<Api> apiProvider;
    private OpsMetricTracker opsMetricTracker;
    private final Store<State> store;

    public UserUpdater(Provider<Api> provider, Store<State> store2, OpsMetricTracker opsMetricTracker2) {
        this.apiProvider = provider;
        this.store = store2;
        this.opsMetricTracker = opsMetricTracker2;
    }

    public synchronized void updateUser(UserUpdateRequest userUpdateRequest, IntercomStatusCallback intercomStatusCallback) {
        this.opsMetricTracker.trackEvent("start", OpsMetricTracker.TIME_TO_COMPLETE_PING);
        if (userUpdateRequest.isValidUpdate()) {
            if (userUpdateRequest.isNewSession()) {
                this.store.dispatch(Actions.sessionStarted());
            }
            this.apiProvider.get().updateUser(userUpdateRequest, intercomStatusCallback);
        }
    }
}
