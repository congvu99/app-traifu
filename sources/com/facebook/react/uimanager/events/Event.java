package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.SystemClock;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.events.Event;

public abstract class Event<T extends Event> {
    public static final long sInitialClockTimeUnixOffset = (SystemClock.currentTimeMillis() - SystemClock.uptimeMillis());
    private static int sUniqueID;
    private boolean mInitialized;
    private int mSurfaceId;
    private long mTimestampMs;
    private int mUIManagerType;
    private int mUniqueID;
    private int mViewTag;

    public boolean canCoalesce() {
        return true;
    }

    public short getCoalescingKey() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        return null;
    }

    public abstract String getEventName();

    public void onDispose() {
    }

    protected Event() {
        int i = sUniqueID;
        sUniqueID = i + 1;
        this.mUniqueID = i;
    }

    @Deprecated
    protected Event(int i) {
        int i2 = sUniqueID;
        sUniqueID = i2 + 1;
        this.mUniqueID = i2;
        init(i);
    }

    protected Event(int i, int i2) {
        int i3 = sUniqueID;
        sUniqueID = i3 + 1;
        this.mUniqueID = i3;
        init(i, i2);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void init(int i) {
        init(-1, i);
    }

    /* access modifiers changed from: protected */
    public void init(int i, int i2) {
        this.mSurfaceId = i;
        this.mViewTag = i2;
        this.mUIManagerType = i == -1 ? 1 : 2;
        this.mTimestampMs = SystemClock.uptimeMillis();
        this.mInitialized = true;
    }

    public final int getViewTag() {
        return this.mViewTag;
    }

    public final int getSurfaceId() {
        return this.mSurfaceId;
    }

    public final long getTimestampMs() {
        return this.mTimestampMs;
    }

    public final long getUnixTimestampMs() {
        return sInitialClockTimeUnixOffset + this.mTimestampMs;
    }

    public T coalesce(T t) {
        return getTimestampMs() >= t.getTimestampMs() ? this : t;
    }

    public int getUniqueID() {
        return this.mUniqueID;
    }

    /* access modifiers changed from: package-private */
    public boolean isInitialized() {
        return this.mInitialized;
    }

    /* access modifiers changed from: package-private */
    public final void dispose() {
        this.mInitialized = false;
        onDispose();
    }

    public final int getUIManagerType() {
        return this.mUIManagerType;
    }

    @Deprecated
    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        WritableMap eventData = getEventData();
        if (eventData != null) {
            rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), eventData);
            return;
        }
        throw new IllegalViewOperationException("Event: you must return a valid, non-null value from `getEventData`, or override `dispatch` and `disatchModern`. Event: " + getEventName());
    }

    @Deprecated
    public void dispatchModern(RCTModernEventEmitter rCTModernEventEmitter) {
        if (getSurfaceId() == -1 || getEventData() == null) {
            dispatch(rCTModernEventEmitter);
        } else {
            rCTModernEventEmitter.receiveEvent(getSurfaceId(), getViewTag(), getEventName(), getEventData());
        }
    }

    @Deprecated
    public void dispatchModernV2(RCTModernEventEmitter rCTModernEventEmitter) {
        if (getSurfaceId() == -1 || getEventData() == null) {
            dispatch(rCTModernEventEmitter);
            return;
        }
        rCTModernEventEmitter.receiveEvent(getSurfaceId(), getViewTag(), getEventName(), canCoalesce(), getCoalescingKey(), getEventData());
    }
}
