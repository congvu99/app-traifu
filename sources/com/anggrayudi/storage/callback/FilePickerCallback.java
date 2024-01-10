package com.anggrayudi.storage.callback;

import android.content.Intent;
import androidx.documentfile.provider.DocumentFile;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001e\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lcom/anggrayudi/storage/callback/FilePickerCallback;", "", "onActivityHandlerNotFound", "", "requestCode", "", "intent", "Landroid/content/Intent;", "onCanceledByUser", "onFileSelected", "files", "", "Landroidx/documentfile/provider/DocumentFile;", "onStoragePermissionDenied", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FilePickerCallback.kt */
public interface FilePickerCallback {

    /* renamed from: com.anggrayudi.storage.callback.FilePickerCallback$-CC  reason: invalid class name */
    /* compiled from: FilePickerCallback.kt */
    public final /* synthetic */ class CC {
        public static void $default$onActivityHandlerNotFound(FilePickerCallback filePickerCallback, int i, Intent intent) {
            Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        }

        public static void $default$onCanceledByUser(FilePickerCallback filePickerCallback, int i) {
        }
    }

    void onActivityHandlerNotFound(int i, Intent intent);

    void onCanceledByUser(int i);

    void onFileSelected(int i, List<? extends DocumentFile> list);

    void onStoragePermissionDenied(int i, List<? extends DocumentFile> list);
}
