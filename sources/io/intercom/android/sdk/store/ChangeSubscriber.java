package io.intercom.android.sdk.store;

import android.os.Handler;
import android.os.Looper;
import io.intercom.android.sdk.store.Store;

class ChangeSubscriber<S, T> implements Store.Subscriber<S> {
    private T last;
    private final Handler mainHandler;
    private final Store.Selector<S, T> selector;
    final Store.Subscriber<T> subscriber;

    ChangeSubscriber(Store.Selector<S, T> selector2, Store.Subscriber<T> subscriber2) {
        this(selector2, subscriber2, new Handler(Looper.getMainLooper()));
    }

    ChangeSubscriber(Store.Selector<S, T> selector2, Store.Subscriber<T> subscriber2, Handler handler) {
        this.last = null;
        this.selector = selector2;
        this.subscriber = subscriber2;
        this.mainHandler = handler;
    }

    public void onStateChange(S s) {
        final T transform = this.selector.transform(s);
        if (this.last != transform) {
            this.last = transform;
            runOnMainThread(new Runnable() {
                public void run() {
                    ChangeSubscriber.this.subscriber.onStateChange(transform);
                }
            }, this.mainHandler);
        }
    }

    static void runOnMainThread(Runnable runnable, Handler handler) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }
}
