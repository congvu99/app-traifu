package com.anggrayudi.storage.permission;

import com.facebook.share.internal.ShareConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Lcom/anggrayudi/storage/permission/PermissionCallback;", "", "onDisplayConsentDialog", "", "request", "Lcom/anggrayudi/storage/permission/PermissionRequest;", "onPermissionsChecked", "result", "Lcom/anggrayudi/storage/permission/PermissionResult;", "fromSystemDialog", "", "onShouldRedirectToSystemSettings", "blockedPermissions", "", "Lcom/anggrayudi/storage/permission/PermissionReport;", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PermissionCallback.kt */
public interface PermissionCallback {
    void onDisplayConsentDialog(PermissionRequest permissionRequest);

    void onPermissionsChecked(PermissionResult permissionResult, boolean z);

    void onShouldRedirectToSystemSettings(List<PermissionReport> list);

    /* renamed from: com.anggrayudi.storage.permission.PermissionCallback$-CC  reason: invalid class name */
    /* compiled from: PermissionCallback.kt */
    public final /* synthetic */ class CC {
        public static void $default$onShouldRedirectToSystemSettings(PermissionCallback permissionCallback, List list) {
            Intrinsics.checkNotNullParameter(list, "blockedPermissions");
        }

        public static void $default$onDisplayConsentDialog(PermissionCallback _this, PermissionRequest permissionRequest) {
            Intrinsics.checkNotNullParameter(permissionRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            permissionRequest.continueToPermissionRequest();
        }
    }
}
