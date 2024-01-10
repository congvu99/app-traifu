package com.anggrayudi.storage.callback;

import android.content.Intent;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.file.StorageType;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\"\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lcom/anggrayudi/storage/callback/FolderPickerCallback;", "", "onActivityHandlerNotFound", "", "requestCode", "", "intent", "Landroid/content/Intent;", "onCanceledByUser", "onFolderSelected", "folder", "Landroidx/documentfile/provider/DocumentFile;", "onStorageAccessDenied", "storageType", "Lcom/anggrayudi/storage/file/StorageType;", "onStoragePermissionDenied", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FolderPickerCallback.kt */
public interface FolderPickerCallback {

    /* renamed from: com.anggrayudi.storage.callback.FolderPickerCallback$-CC  reason: invalid class name */
    /* compiled from: FolderPickerCallback.kt */
    public final /* synthetic */ class CC {
        public static void $default$onActivityHandlerNotFound(FolderPickerCallback folderPickerCallback, int i, Intent intent) {
            Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        }

        public static void $default$onCanceledByUser(FolderPickerCallback folderPickerCallback, int i) {
        }
    }

    void onActivityHandlerNotFound(int i, Intent intent);

    void onCanceledByUser(int i);

    void onFolderSelected(int i, DocumentFile documentFile);

    void onStorageAccessDenied(int i, DocumentFile documentFile, StorageType storageType);

    void onStoragePermissionDenied(int i);
}
