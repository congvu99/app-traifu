package io.intercom.android.sdk.carousel.permission;

import io.intercom.android.sdk.carousel.PermissionManager;
import io.intercom.android.sdk.models.carousel.ScreenAction;
import java.util.Arrays;
import java.util.List;

class PermissionRequestBefore30 implements PermissionRequest {
    private final PermissionResultListener nullListener = new NullPermissionResultListener();
    protected final PermissionManager permissionManager;
    private PermissionResultListener permissionResultListener;

    PermissionRequestBefore30(PermissionManager permissionManager2) {
        this.permissionManager = permissionManager2;
    }

    public void attach(PermissionResultListener permissionResultListener2) {
        this.permissionResultListener = permissionResultListener2;
    }

    public void detach() {
        this.permissionResultListener = null;
    }

    public void request(ScreenAction screenAction, int i) {
        List<String> validPermissions = screenAction.getValidPermissions(this.permissionManager);
        if (!validPermissions.isEmpty()) {
            handleRequest(validPermissions, i);
        }
    }

    public void handleResult(String[] strArr, int[] iArr) {
        handleRequestResult(strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void handleGranted(String[] strArr) {
        getListener().showGranted();
    }

    /* access modifiers changed from: protected */
    public void handleRequest(List<String> list, int i) {
        this.permissionManager.requestPermissions((String[]) list.toArray(new String[0]), i);
    }

    /* access modifiers changed from: package-private */
    public PermissionResultListener getListener() {
        PermissionResultListener permissionResultListener2 = this.permissionResultListener;
        return permissionResultListener2 == null ? this.nullListener : permissionResultListener2;
    }

    private void handleRequestResult(String[] strArr, int[] iArr) {
        if (this.permissionManager.anyPermissionPermanentlyDeniedInResult(strArr, iArr)) {
            getListener().showDeniedPermanently();
        } else if (this.permissionManager.permissionsGranted(Arrays.asList(strArr))) {
            handleGranted(strArr);
        } else {
            getListener().showDeniedTemporarily();
        }
    }

    private static final class NullPermissionResultListener implements PermissionResultListener {
        public void requestBackgroundLocationPermission() {
        }

        public void showDeniedPermanently() {
        }

        public void showDeniedTemporarily() {
        }

        public void showGranted() {
        }

        private NullPermissionResultListener() {
        }
    }
}
