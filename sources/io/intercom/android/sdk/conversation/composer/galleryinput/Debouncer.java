package io.intercom.android.sdk.conversation.composer.galleryinput;

import android.os.Handler;
import android.os.Looper;

class Debouncer {
    private final Handler handler = new Handler(Looper.getMainLooper());

    Debouncer() {
    }

    /* access modifiers changed from: package-private */
    public void call(Runnable runnable, long j) {
        this.handler.removeCallbacksAndMessages((Object) null);
        this.handler.postDelayed(runnable, j);
    }
}
