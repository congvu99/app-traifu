package com.anggrayudi.storage.callback;

import android.content.Intent;
import androidx.documentfile.provider.DocumentFile;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcom/anggrayudi/storage/callback/FileReceiverCallback;", "", "onFileReceived", "", "files", "", "Landroidx/documentfile/provider/DocumentFile;", "onNonFileReceived", "intent", "Landroid/content/Intent;", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FileReceiverCallback.kt */
public interface FileReceiverCallback {
    void onFileReceived(List<? extends DocumentFile> list);

    void onNonFileReceived(Intent intent);
}