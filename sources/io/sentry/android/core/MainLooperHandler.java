package io.sentry.android.core;

import android.os.Handler;
import android.os.Looper;

final class MainLooperHandler implements IHandler {
    private final Handler handler = new Handler(Looper.getMainLooper());

    MainLooperHandler() {
    }

    public void post(Runnable runnable) {
        this.handler.post(runnable);
    }

    public Thread getThread() {
        return this.handler.getLooper().getThread();
    }
}
