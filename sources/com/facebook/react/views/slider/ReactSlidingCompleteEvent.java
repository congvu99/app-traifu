package com.facebook.react.views.slider;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

public class ReactSlidingCompleteEvent extends Event<ReactSlidingCompleteEvent> {
    public static final String EVENT_NAME = "topSlidingComplete";
    private final double mValue;

    public boolean canCoalesce() {
        return false;
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    @Deprecated
    public ReactSlidingCompleteEvent(int i, double d) {
        this(-1, i, d);
    }

    public ReactSlidingCompleteEvent(int i, int i2, double d) {
        super(i, i2);
        this.mValue = d;
    }

    public double getValue() {
        return this.mValue;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("target", getViewTag());
        createMap.putDouble("value", getValue());
        return createMap;
    }
}
