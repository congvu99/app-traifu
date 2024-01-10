package io.intercom.android.sdk.carousel.permission;

import io.intercom.android.sdk.carousel.PermissionManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class PermissionRequest30 extends PermissionRequestBefore30 {
    PermissionRequest30(PermissionManager permissionManager) {
        super(permissionManager);
    }

    /* access modifiers changed from: protected */
    public void handleRequest(List<String> list, int i) {
        list.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
        super.handleRequest(list, i);
    }

    /* access modifiers changed from: protected */
    public void handleGranted(String[] strArr) {
        if (!askForBackgroundPermission(Arrays.asList(strArr))) {
            getListener().showGranted();
        } else if (isBackgroundPermissionDeniedPermanently()) {
            getListener().showDeniedPermanently();
        } else {
            getListener().requestBackgroundLocationPermission();
        }
    }

    private boolean askForBackgroundPermission(List<String> list) {
        return isLocationPermission(list) && isBackgroundPermissionInManifest();
    }

    private boolean isLocationPermission(List<String> list) {
        return list.contains("android.permission.ACCESS_COARSE_LOCATION") || list.contains("android.permission.ACCESS_FINE_LOCATION");
    }

    private boolean isBackgroundPermissionInManifest() {
        return !this.permissionManager.permissionsExistInManifest(Collections.singletonList("android.permission.ACCESS_BACKGROUND_LOCATION")).isEmpty();
    }

    private boolean isBackgroundPermissionDeniedPermanently() {
        return this.permissionManager.getPermissionStatus("android.permission.ACCESS_BACKGROUND_LOCATION") == 2;
    }
}
