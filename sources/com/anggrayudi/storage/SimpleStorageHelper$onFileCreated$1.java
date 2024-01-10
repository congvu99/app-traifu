package com.anggrayudi.storage;

import android.content.Intent;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.CreateFileCallback;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/anggrayudi/storage/SimpleStorageHelper$onFileCreated$1", "Lcom/anggrayudi/storage/callback/CreateFileCallback;", "onActivityHandlerNotFound", "", "requestCode", "", "intent", "Landroid/content/Intent;", "onCanceledByUser", "onFileCreated", "file", "Landroidx/documentfile/provider/DocumentFile;", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleStorageHelper.kt */
public final class SimpleStorageHelper$onFileCreated$1 implements CreateFileCallback {
    final /* synthetic */ Function2<Integer, DocumentFile, Unit> $callback;
    final /* synthetic */ SimpleStorageHelper this$0;

    SimpleStorageHelper$onFileCreated$1(SimpleStorageHelper simpleStorageHelper, Function2<? super Integer, ? super DocumentFile, Unit> function2) {
        this.this$0 = simpleStorageHelper;
        this.$callback = function2;
    }

    public void onCanceledByUser(int i) {
        this.this$0.reset();
    }

    public void onActivityHandlerNotFound(int i, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        this.this$0.handleMissingActivityHandler();
    }

    public void onFileCreated(int i, DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "file");
        this.this$0.reset();
        Function2<Integer, DocumentFile, Unit> function2 = this.$callback;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(i), documentFile);
        }
    }
}
