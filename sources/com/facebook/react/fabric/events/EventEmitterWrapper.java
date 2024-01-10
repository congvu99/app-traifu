package com.facebook.react.fabric.events;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.fabric.FabricSoLoader;

public class EventEmitterWrapper {
    private final HybridData mHybridData = initHybrid();

    private static native HybridData initHybrid();

    private native void invokeEvent(String str, NativeMap nativeMap);

    private native void invokeUniqueEvent(String str, NativeMap nativeMap, int i);

    static {
        FabricSoLoader.staticInit();
    }

    private EventEmitterWrapper() {
    }

    public synchronized void invoke(String str, WritableMap writableMap) {
        if (isValid()) {
            invokeEvent(str, writableMap == null ? new WritableNativeMap() : (NativeMap) writableMap);
        }
    }

    public synchronized void invokeUnique(String str, WritableMap writableMap, int i) {
        if (isValid()) {
            invokeUniqueEvent(str, writableMap == null ? new WritableNativeMap() : (NativeMap) writableMap, i);
        }
    }

    public synchronized void destroy() {
        if (this.mHybridData != null) {
            this.mHybridData.resetNative();
        }
    }

    private boolean isValid() {
        HybridData hybridData = this.mHybridData;
        if (hybridData != null) {
            return hybridData.isValid();
        }
        return false;
    }
}
