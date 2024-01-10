package com.anggrayudi.storage;

import android.widget.Toast;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"com/anggrayudi/storage/SimpleStorageHelper$permissionCallback$1", "Lcom/anggrayudi/storage/permission/PermissionCallback;", "onPermissionsChecked", "", "result", "Lcom/anggrayudi/storage/permission/PermissionResult;", "fromSystemDialog", "", "onShouldRedirectToSystemSettings", "blockedPermissions", "", "Lcom/anggrayudi/storage/permission/PermissionReport;", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleStorageHelper.kt */
public final class SimpleStorageHelper$permissionCallback$1 implements PermissionCallback {
    final /* synthetic */ SimpleStorageHelper this$0;

    public /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
        PermissionCallback.CC.$default$onDisplayConsentDialog(this, permissionRequest);
    }

    SimpleStorageHelper$permissionCallback$1(SimpleStorageHelper simpleStorageHelper) {
        this.this$0 = simpleStorageHelper;
    }

    public void onPermissionsChecked(PermissionResult permissionResult, boolean z) {
        Intrinsics.checkNotNullParameter(permissionResult, "result");
        boolean areAllPermissionsGranted = permissionResult.getAreAllPermissionsGranted();
        if (!areAllPermissionsGranted) {
            Toast.makeText(this.this$0.getStorage().getContext(), R.string.ss_please_grant_storage_permission, 0).show();
        }
        Function1 access$getOnPermissionsResult$p = this.this$0.onPermissionsResult;
        if (access$getOnPermissionsResult$p != null) {
            access$getOnPermissionsResult$p.invoke(Boolean.valueOf(areAllPermissionsGranted));
        }
        this.this$0.onPermissionsResult = null;
    }

    public void onShouldRedirectToSystemSettings(List<PermissionReport> list) {
        Intrinsics.checkNotNullParameter(list, "blockedPermissions");
        SimpleStorageHelper.Companion.redirectToSystemSettings(this.this$0.getStorage().getContext());
        Function1 access$getOnPermissionsResult$p = this.this$0.onPermissionsResult;
        if (access$getOnPermissionsResult$p != null) {
            access$getOnPermissionsResult$p.invoke(false);
        }
        this.this$0.onPermissionsResult = null;
    }
}
