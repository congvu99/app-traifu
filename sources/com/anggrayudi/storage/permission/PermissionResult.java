package com.anggrayudi.storage.permission;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/anggrayudi/storage/permission/PermissionResult;", "", "permissions", "", "Lcom/anggrayudi/storage/permission/PermissionReport;", "(Ljava/util/List;)V", "areAllPermissionsGranted", "", "getAreAllPermissionsGranted", "()Z", "getPermissions", "()Ljava/util/List;", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PermissionResult.kt */
public final class PermissionResult {
    private final List<PermissionReport> permissions;

    public PermissionResult(List<PermissionReport> list) {
        Intrinsics.checkNotNullParameter(list, "permissions");
        this.permissions = list;
    }

    public final List<PermissionReport> getPermissions() {
        return this.permissions;
    }

    public final boolean getAreAllPermissionsGranted() {
        Iterable<PermissionReport> iterable = this.permissions;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        for (PermissionReport isGranted : iterable) {
            if (!isGranted.isGranted()) {
                return false;
            }
        }
        return true;
    }
}
