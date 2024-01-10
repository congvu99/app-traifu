package com.facebook.react.views.scroll;

import androidx.core.util.Pools;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.events.Event;
import com.github.mikephil.charting.utils.Utils;

public class ScrollEvent extends Event<ScrollEvent> {
    private static final Pools.SynchronizedPool<ScrollEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(3);
    private static String TAG = ScrollEvent.class.getSimpleName();
    private int mContentHeight;
    private int mContentWidth;
    private ScrollEventType mScrollEventType;
    private int mScrollViewHeight;
    private int mScrollViewWidth;
    private int mScrollX;
    private int mScrollY;
    private double mXVelocity;
    private double mYVelocity;

    @Deprecated
    public static ScrollEvent obtain(int i, ScrollEventType scrollEventType, int i2, int i3, float f, float f2, int i4, int i5, int i6, int i7) {
        return obtain(-1, i, scrollEventType, i2, i3, f, f2, i4, i5, i6, i7);
    }

    public static ScrollEvent obtain(int i, int i2, ScrollEventType scrollEventType, int i3, int i4, float f, float f2, int i5, int i6, int i7, int i8) {
        ScrollEvent acquire = EVENTS_POOL.acquire();
        if (acquire == null) {
            acquire = new ScrollEvent();
        }
        acquire.init(i, i2, scrollEventType, i3, i4, f, f2, i5, i6, i7, i8);
        return acquire;
    }

    public void onDispose() {
        try {
            EVENTS_POOL.release(this);
        } catch (IllegalStateException e) {
            ReactSoftExceptionLogger.logSoftException(TAG, e);
        }
    }

    private ScrollEvent() {
    }

    private void init(int i, int i2, ScrollEventType scrollEventType, int i3, int i4, float f, float f2, int i5, int i6, int i7, int i8) {
        super.init(i, i2);
        this.mScrollEventType = scrollEventType;
        this.mScrollX = i3;
        this.mScrollY = i4;
        this.mXVelocity = (double) f;
        this.mYVelocity = (double) f2;
        this.mContentWidth = i5;
        this.mContentHeight = i6;
        this.mScrollViewWidth = i7;
        this.mScrollViewHeight = i8;
    }

    public String getEventName() {
        return ScrollEventType.getJSEventName((ScrollEventType) Assertions.assertNotNull(this.mScrollEventType));
    }

    public boolean canCoalesce() {
        return this.mScrollEventType == ScrollEventType.SCROLL;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("top", Utils.DOUBLE_EPSILON);
        createMap.putDouble("bottom", Utils.DOUBLE_EPSILON);
        createMap.putDouble("left", Utils.DOUBLE_EPSILON);
        createMap.putDouble("right", Utils.DOUBLE_EPSILON);
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble("x", (double) PixelUtil.toDIPFromPixel((float) this.mScrollX));
        createMap2.putDouble("y", (double) PixelUtil.toDIPFromPixel((float) this.mScrollY));
        WritableMap createMap3 = Arguments.createMap();
        createMap3.putDouble("width", (double) PixelUtil.toDIPFromPixel((float) this.mContentWidth));
        createMap3.putDouble("height", (double) PixelUtil.toDIPFromPixel((float) this.mContentHeight));
        WritableMap createMap4 = Arguments.createMap();
        createMap4.putDouble("width", (double) PixelUtil.toDIPFromPixel((float) this.mScrollViewWidth));
        createMap4.putDouble("height", (double) PixelUtil.toDIPFromPixel((float) this.mScrollViewHeight));
        WritableMap createMap5 = Arguments.createMap();
        createMap5.putDouble("x", this.mXVelocity);
        createMap5.putDouble("y", this.mYVelocity);
        WritableMap createMap6 = Arguments.createMap();
        createMap6.putMap("contentInset", createMap);
        createMap6.putMap("contentOffset", createMap2);
        createMap6.putMap("contentSize", createMap3);
        createMap6.putMap("layoutMeasurement", createMap4);
        createMap6.putMap("velocity", createMap5);
        createMap6.putInt("target", getViewTag());
        createMap6.putBoolean("responderIgnoreScroll", true);
        return createMap6;
    }
}
