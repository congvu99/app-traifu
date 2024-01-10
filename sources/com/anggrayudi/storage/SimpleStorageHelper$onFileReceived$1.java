package com.anggrayudi.storage;

import android.content.Intent;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.SimpleStorageHelper;
import com.anggrayudi.storage.callback.FileReceiverCallback;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/anggrayudi/storage/SimpleStorageHelper$onFileReceived$1", "Lcom/anggrayudi/storage/callback/FileReceiverCallback;", "onFileReceived", "", "files", "", "Landroidx/documentfile/provider/DocumentFile;", "onNonFileReceived", "intent", "Landroid/content/Intent;", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleStorageHelper.kt */
public final class SimpleStorageHelper$onFileReceived$1 implements FileReceiverCallback {
    final /* synthetic */ SimpleStorageHelper.OnFileReceived $callback;

    SimpleStorageHelper$onFileReceived$1(SimpleStorageHelper.OnFileReceived onFileReceived) {
        this.$callback = onFileReceived;
    }

    public void onFileReceived(List<? extends DocumentFile> list) {
        Intrinsics.checkNotNullParameter(list, "files");
        SimpleStorageHelper.OnFileReceived onFileReceived = this.$callback;
        if (onFileReceived != null) {
            onFileReceived.onFileReceived(list);
        }
    }

    public void onNonFileReceived(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        SimpleStorageHelper.OnFileReceived onFileReceived = this.$callback;
        if (onFileReceived != null) {
            onFileReceived.onNonFileReceived(intent);
        }
    }
}
