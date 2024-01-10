package com.facebook.react.fabric;

import com.facebook.react.bridge.JSIModuleProvider;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.common.mapbuffer.ReadableMapBufferSoLoader;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.fabric.events.EventBeatManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.systrace.Systrace;

public class FabricJSIModuleProvider implements JSIModuleProvider<UIManager> {
    private final ComponentFactory mComponentFactory;
    private final ReactNativeConfig mConfig;
    private final ReactApplicationContext mReactApplicationContext;
    private final ViewManagerRegistry mViewManagerRegistry;

    public FabricJSIModuleProvider(ReactApplicationContext reactApplicationContext, ComponentFactory componentFactory, ReactNativeConfig reactNativeConfig, ViewManagerRegistry viewManagerRegistry) {
        this.mReactApplicationContext = reactApplicationContext;
        this.mComponentFactory = componentFactory;
        this.mConfig = reactNativeConfig;
        this.mViewManagerRegistry = viewManagerRegistry;
    }

    public UIManager get() {
        Systrace.beginSection(0, "FabricJSIModuleProvider.get");
        EventBeatManager eventBeatManager = new EventBeatManager(this.mReactApplicationContext);
        FabricUIManager createUIManager = createUIManager(eventBeatManager);
        Systrace.beginSection(0, "FabricJSIModuleProvider.registerBinding");
        Binding binding = new Binding();
        if (ReactFeatureFlags.enableEagerInitializeMapBufferSoFile) {
            ReadableMapBufferSoLoader.staticInit();
        }
        FabricUIManager fabricUIManager = createUIManager;
        binding.register(this.mReactApplicationContext.getCatalystInstance().getRuntimeExecutor(), fabricUIManager, eventBeatManager, this.mReactApplicationContext.getCatalystInstance().getReactQueueConfiguration().getJSQueueThread(), this.mComponentFactory, this.mConfig);
        Systrace.endSection(0);
        Systrace.endSection(0);
        return createUIManager;
    }

    private FabricUIManager createUIManager(EventBeatManager eventBeatManager) {
        Systrace.beginSection(0, "FabricJSIModuleProvider.createUIManager");
        FabricUIManager fabricUIManager = new FabricUIManager(this.mReactApplicationContext, this.mViewManagerRegistry, eventBeatManager);
        Systrace.endSection(0);
        return fabricUIManager;
    }
}
