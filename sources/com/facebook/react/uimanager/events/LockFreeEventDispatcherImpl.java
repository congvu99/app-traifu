package com.facebook.react.uimanager.events;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.core.ChoreographerCompat;
import com.facebook.react.modules.core.ReactChoreographer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class LockFreeEventDispatcherImpl implements EventDispatcher, LifecycleEventListener {
    private final boolean DEBUG_MODE = false;
    private final String TAG = LockFreeEventDispatcherImpl.class.getSimpleName();
    /* access modifiers changed from: private */
    public final ScheduleDispatchFrameCallback mCurrentFrameCallback = new ScheduleDispatchFrameCallback();
    private final CopyOnWriteArrayList<EventDispatcherListener> mListeners = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<BatchEventDispatchedListener> mPostEventDispatchListeners = new CopyOnWriteArrayList<>();
    /* access modifiers changed from: private */
    public final ReactApplicationContext mReactContext;
    private volatile ReactEventEmitter mReactEventEmitter;

    public LockFreeEventDispatcherImpl(ReactApplicationContext reactApplicationContext) {
        this.mReactContext = reactApplicationContext;
        reactApplicationContext.addLifecycleEventListener(this);
        this.mReactEventEmitter = new ReactEventEmitter(this.mReactContext);
    }

    public void dispatchEvent(Event event) {
        Assertions.assertCondition(event.isInitialized(), "Dispatched event hasn't been initialized");
        Assertions.assertNotNull(this.mReactEventEmitter);
        Iterator<EventDispatcherListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onEventDispatch(event);
        }
        event.dispatchModernV2(this.mReactEventEmitter);
        event.dispose();
    }

    public void dispatchAllEvents() {
        maybePostFrameCallbackFromNonUI();
    }

    private void maybePostFrameCallbackFromNonUI() {
        if (this.mReactEventEmitter != null) {
            this.mCurrentFrameCallback.maybePostFromNonUI();
        }
    }

    public void addListener(EventDispatcherListener eventDispatcherListener) {
        this.mListeners.add(eventDispatcherListener);
    }

    public void removeListener(EventDispatcherListener eventDispatcherListener) {
        this.mListeners.remove(eventDispatcherListener);
    }

    public void addBatchEventDispatchedListener(BatchEventDispatchedListener batchEventDispatchedListener) {
        this.mPostEventDispatchListeners.add(batchEventDispatchedListener);
    }

    public void removeBatchEventDispatchedListener(BatchEventDispatchedListener batchEventDispatchedListener) {
        this.mPostEventDispatchListeners.remove(batchEventDispatchedListener);
    }

    public void onHostResume() {
        maybePostFrameCallbackFromNonUI();
    }

    public void onHostPause() {
        stopFrameCallback();
    }

    public void onHostDestroy() {
        stopFrameCallback();
    }

    public void onCatalystInstanceDestroyed() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                LockFreeEventDispatcherImpl.this.stopFrameCallback();
            }
        });
    }

    /* access modifiers changed from: private */
    public void stopFrameCallback() {
        UiThreadUtil.assertOnUiThread();
        this.mCurrentFrameCallback.stop();
    }

    public void registerEventEmitter(int i, RCTEventEmitter rCTEventEmitter) {
        this.mReactEventEmitter.register(i, rCTEventEmitter);
    }

    public void registerEventEmitter(int i, RCTModernEventEmitter rCTModernEventEmitter) {
        this.mReactEventEmitter.register(i, rCTModernEventEmitter);
    }

    public void unregisterEventEmitter(int i) {
        this.mReactEventEmitter.unregister(i);
    }

    private class ScheduleDispatchFrameCallback extends ChoreographerCompat.FrameCallback {
        private volatile boolean mIsPosted;
        private boolean mShouldStop;

        private ScheduleDispatchFrameCallback() {
            this.mIsPosted = false;
            this.mShouldStop = false;
        }

        public void doFrame(long j) {
            UiThreadUtil.assertOnUiThread();
            if (this.mShouldStop) {
                this.mIsPosted = false;
            } else {
                post();
            }
            LockFreeEventDispatcherImpl.this.driveEventBeats();
        }

        public void stop() {
            this.mShouldStop = true;
        }

        public void maybePost() {
            if (!this.mIsPosted) {
                this.mIsPosted = true;
                post();
            }
        }

        private void post() {
            ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, LockFreeEventDispatcherImpl.this.mCurrentFrameCallback);
        }

        public void maybePostFromNonUI() {
            if (!this.mIsPosted) {
                if (LockFreeEventDispatcherImpl.this.mReactContext.isOnUiQueueThread()) {
                    maybePost();
                } else {
                    LockFreeEventDispatcherImpl.this.mReactContext.runOnUiQueueThread(new Runnable() {
                        public void run() {
                            ScheduleDispatchFrameCallback.this.maybePost();
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void driveEventBeats() {
        Iterator<BatchEventDispatchedListener> it = this.mPostEventDispatchListeners.iterator();
        while (it.hasNext()) {
            it.next().onBatchEventDispatched();
        }
    }
}
