package io.intercom.android.sdk;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;

class ActivityLifecycleHandler extends Handler {
    private static final int ESTIMATED_ACTIVITY_TRANSITION_DURATION_MS = 500;
    static final int PAUSED_CODE = 2;
    static final int READY_FOR_VIEW_CODE = 1;
    static final int RESUMED_CODE = 0;
    static final int STOPPED_CODE = 3;
    private final long readyForViewDelayMs;
    private final Store<State> store;

    ActivityLifecycleHandler(Looper looper, Store<State> store2, float f) {
        super(looper);
        this.store = store2;
        this.readyForViewDelayMs = (long) (f * 500.0f);
    }

    public void handleMessage(Message message) {
        Activity activity = (Activity) message.obj;
        int i = message.what;
        if (i == 0) {
            sendMessageAfterDelay(getMessage(1, activity), this.readyForViewDelayMs);
        } else if (i == 1) {
            this.store.dispatch(Actions.activityReadyForViewAttachment(activity));
        } else if (i == 2) {
            this.store.dispatch(Actions.activityPaused(activity));
        } else if (i == 3) {
            this.store.dispatch(Actions.activityStopped(activity));
        }
    }

    /* access modifiers changed from: package-private */
    public void sendMessageAfterDelay(Message message, long j) {
        sendMessageDelayed(message, j);
    }

    static Message getMessage(int i, Activity activity) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.obj = activity;
        return obtain;
    }
}
