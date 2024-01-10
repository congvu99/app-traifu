package com.trainerfu.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.trainerfu.utils.ReactInstanceManagerFactory;

public abstract class BaseReactActivity extends BaseActivity implements DefaultHardwareBackBtnHandler {
    private static final int OVERLAY_PERMISSION_REQUEST_CODE = 2;
    private ReactInstanceManager mReactInstanceManager;

    private void _askForOverlayPermission() {
    }

    public BaseReactActivity() {
        this(false);
    }

    public BaseReactActivity(boolean z) {
        super(z);
        this.mReactInstanceManager = null;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        _askForOverlayPermission();
        this.mReactInstanceManager = ReactInstanceManagerFactory.getInstance().getReactInstanceManager(getApplication());
    }

    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager != null) {
            reactInstanceManager.onHostPause(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager != null) {
            reactInstanceManager.onHostResume(this, this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager != null) {
            reactInstanceManager.onHostDestroy(this);
        }
    }

    /* access modifiers changed from: protected */
    public ReactInstanceManager getReactInstanceManager() {
        return this.mReactInstanceManager;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mReactInstanceManager.onActivityResult(this, i, i2, intent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        ReactInstanceManager reactInstanceManager;
        if (i != 82 || (reactInstanceManager = this.mReactInstanceManager) == null) {
            return super.onKeyUp(i, keyEvent);
        }
        reactInstanceManager.showDevOptionsDialog();
        return true;
    }
}
