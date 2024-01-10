package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import javax.annotation.Nullable;

public interface StateWrapper {
    void destroyState();

    @Nullable
    ReadableMapBuffer getStatDataMapBuffer();

    @Nullable
    ReadableNativeMap getStateData();

    void updateState(WritableMap writableMap);
}
