package com.anggrayudi.storage.callback;

import android.content.Intent;
import androidx.documentfile.provider.DocumentFile;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcom/anggrayudi/storage/callback/CreateFileCallback;", "", "onActivityHandlerNotFound", "", "requestCode", "", "intent", "Landroid/content/Intent;", "onCanceledByUser", "onFileCreated", "file", "Landroidx/documentfile/provider/DocumentFile;", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CreateFileCallback.kt */
public interface CreateFileCallback {

    /* renamed from: com.anggrayudi.storage.callback.CreateFileCallback$-CC  reason: invalid class name */
    /* compiled from: CreateFileCallback.kt */
    public final /* synthetic */ class CC {
        public static void $default$onActivityHandlerNotFound(CreateFileCallback createFileCallback, int i, Intent intent) {
            Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        }

        public static void $default$onCanceledByUser(CreateFileCallback createFileCallback, int i) {
        }
    }

    void onActivityHandlerNotFound(int i, Intent intent);

    void onCanceledByUser(int i);

    void onFileCreated(int i, DocumentFile documentFile);
}
