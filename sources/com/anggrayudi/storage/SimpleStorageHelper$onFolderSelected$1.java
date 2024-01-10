package com.anggrayudi.storage;

import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FolderPickerCallback;
import com.anggrayudi.storage.file.StorageType;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.uploadcare.android.widget.data.Thing;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0010"}, d2 = {"com/anggrayudi/storage/SimpleStorageHelper$onFolderSelected$1", "Lcom/anggrayudi/storage/callback/FolderPickerCallback;", "onActivityHandlerNotFound", "", "requestCode", "", "intent", "Landroid/content/Intent;", "onCanceledByUser", "onFolderSelected", "folder", "Landroidx/documentfile/provider/DocumentFile;", "onStorageAccessDenied", "storageType", "Lcom/anggrayudi/storage/file/StorageType;", "onStoragePermissionDenied", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleStorageHelper.kt */
public final class SimpleStorageHelper$onFolderSelected$1 implements FolderPickerCallback {
    final /* synthetic */ Function2<Integer, DocumentFile, Unit> $callback;
    final /* synthetic */ SimpleStorageHelper this$0;

    SimpleStorageHelper$onFolderSelected$1(SimpleStorageHelper simpleStorageHelper, Function2<? super Integer, ? super DocumentFile, Unit> function2) {
        this.this$0 = simpleStorageHelper;
        this.$callback = function2;
    }

    public void onFolderSelected(int i, DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, Thing.TYPE_FOLDER);
        this.this$0.reset();
        Function2<Integer, DocumentFile, Unit> function2 = this.$callback;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(i), documentFile);
        }
    }

    public void onStorageAccessDenied(int i, DocumentFile documentFile, StorageType storageType) {
        Intrinsics.checkNotNullParameter(storageType, "storageType");
        if (storageType == StorageType.UNKNOWN) {
            onStoragePermissionDenied(i);
        } else {
            new AlertDialog.Builder(this.this$0.getStorage().getContext()).setCancelable(false).setMessage(R.string.ss_storage_access_denied_confirm).setNegativeButton(17039360, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SimpleStorageHelper$onFolderSelected$1.m5041onStorageAccessDenied$lambda0(SimpleStorageHelper.this, dialogInterface, i);
                }
            }).setPositiveButton(17039370, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(storageType) {
                public final /* synthetic */ StorageType f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    SimpleStorageHelper$onFolderSelected$1.m5042onStorageAccessDenied$lambda1(SimpleStorageHelper.this, this.f$1, dialogInterface, i);
                }
            }).show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onStorageAccessDenied$lambda-0  reason: not valid java name */
    public static final void m5041onStorageAccessDenied$lambda0(SimpleStorageHelper simpleStorageHelper, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(simpleStorageHelper, "this$0");
        simpleStorageHelper.reset();
    }

    /* access modifiers changed from: private */
    /* renamed from: onStorageAccessDenied$lambda-1  reason: not valid java name */
    public static final void m5042onStorageAccessDenied$lambda1(SimpleStorageHelper simpleStorageHelper, StorageType storageType, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(simpleStorageHelper, "this$0");
        Intrinsics.checkNotNullParameter(storageType, "$storageType");
        SimpleStorage.requestStorageAccess$default(simpleStorageHelper.getStorage(), 0, storageType, (StorageType) null, (String) null, 13, (Object) null);
    }

    public void onStoragePermissionDenied(int i) {
        SimpleStorageHelper simpleStorageHelper = this.this$0;
        simpleStorageHelper.requestStoragePermission(new SimpleStorageHelper$onFolderSelected$1$onStoragePermissionDenied$1(simpleStorageHelper));
    }

    public void onCanceledByUser(int i) {
        this.this$0.reset();
    }

    public void onActivityHandlerNotFound(int i, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        this.this$0.handleMissingActivityHandler();
    }
}
