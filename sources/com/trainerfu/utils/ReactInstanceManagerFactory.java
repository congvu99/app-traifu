package com.trainerfu.utils;

import android.app.Application;
import com.brentvatne.react.ReactVideoPackage;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;
import com.imagepicker.ImagePickerPackage;
import com.learnium.RNDeviceInfo.RNDeviceInfo;
import com.reactnativecommunity.asyncstorage.AsyncStoragePackage;
import com.reactnativecommunity.netinfo.NetInfoPackage;
import com.reactnativecommunity.webview.RNCWebViewPackage;
import com.swmansion.gesturehandler.react.RNGestureHandlerPackage;
import com.th3rdwave.safeareacontext.SafeAreaContextPackage;
import com.trainerfu.android.RNModuleExporter;

public class ReactInstanceManagerFactory {
    private static ReactInstanceManagerFactory mInstance;
    private ReactInstanceManager mReactInstanceManager;

    private ReactInstanceManagerFactory() {
    }

    public static ReactInstanceManagerFactory getInstance() {
        if (mInstance == null) {
            mInstance = new ReactInstanceManagerFactory();
        }
        return mInstance;
    }

    public ReactInstanceManager getReactInstanceManager(Application application) {
        if (this.mReactInstanceManager == null) {
            this.mReactInstanceManager = ReactInstanceManager.builder().setApplication(application).setBundleAssetName("index.android.bundle").setJSMainModulePath("index.android").addPackage(new MainReactPackage()).addPackage(new RNModuleExporter()).addPackage(new ImagePickerPackage()).addPackage(new ReactVideoPackage()).addPackage(new RNGestureHandlerPackage()).addPackage(new RNCWebViewPackage()).addPackage(new NetInfoPackage()).addPackage(new SafeAreaContextPackage()).addPackage(new AsyncStoragePackage()).addPackage(new RNDeviceInfo()).setUseDeveloperSupport(false).setInitialLifecycleState(LifecycleState.BEFORE_CREATE).build();
        }
        return this.mReactInstanceManager;
    }

    public void clear() {
        this.mReactInstanceManager = null;
    }
}
