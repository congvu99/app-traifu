package io.intercom.android.sdk.carousel.permission;

import android.os.Build;
import io.intercom.android.sdk.carousel.PermissionManager;

public final class PermissionRequestFactory {
    private PermissionRequestFactory() {
    }

    public static PermissionRequest create(PermissionManager permissionManager) {
        if (Build.VERSION.SDK_INT >= 30) {
            return new PermissionRequest30(permissionManager);
        }
        return new PermissionRequestBefore30(permissionManager);
    }
}
