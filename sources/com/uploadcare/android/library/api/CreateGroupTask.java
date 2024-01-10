package com.uploadcare.android.library.api;

import android.os.AsyncTask;
import com.uploadcare.android.library.callbacks.UploadcareGroupCallback;
import com.uploadcare.android.library.exceptions.UploadFailureException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001BK\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ'\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0011\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0014R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/uploadcare/android/library/api/CreateGroupTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "Lcom/uploadcare/android/library/api/UploadcareGroup;", "client", "Lcom/uploadcare/android/library/api/UploadcareClient;", "fileIds", "", "", "jsonpCallback", "signature", "expire", "callback", "Lcom/uploadcare/android/library/callbacks/UploadcareGroupCallback;", "(Lcom/uploadcare/android/library/api/UploadcareClient;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/uploadcare/android/library/callbacks/UploadcareGroupCallback;)V", "doInBackground", "p0", "", "([Ljava/lang/Void;)Lcom/uploadcare/android/library/api/UploadcareGroup;", "onPostExecute", "", "result", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareClient.kt */
final class CreateGroupTask extends AsyncTask<Void, Void, UploadcareGroup> {
    private final UploadcareGroupCallback callback;
    private final UploadcareClient client;
    private final String expire;
    private final List<String> fileIds;
    private final String jsonpCallback;
    private final String signature;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CreateGroupTask(UploadcareClient uploadcareClient, List list, String str, String str2, String str3, UploadcareGroupCallback uploadcareGroupCallback, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uploadcareClient, list, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : uploadcareGroupCallback);
    }

    public CreateGroupTask(UploadcareClient uploadcareClient, List<String> list, String str, String str2, String str3, UploadcareGroupCallback uploadcareGroupCallback) {
        Intrinsics.checkNotNullParameter(uploadcareClient, "client");
        Intrinsics.checkNotNullParameter(list, "fileIds");
        this.client = uploadcareClient;
        this.fileIds = list;
        this.jsonpCallback = str;
        this.signature = str2;
        this.expire = str3;
        this.callback = uploadcareGroupCallback;
    }

    /* access modifiers changed from: protected */
    public UploadcareGroup doInBackground(Void... voidArr) {
        Intrinsics.checkNotNullParameter(voidArr, "p0");
        try {
            return this.client.createGroupInternal$library_release(this.fileIds, this.jsonpCallback, this.signature, this.expire);
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(UploadcareGroup uploadcareGroup) {
        if (uploadcareGroup != null) {
            UploadcareGroupCallback uploadcareGroupCallback = this.callback;
            if (uploadcareGroupCallback != null) {
                uploadcareGroupCallback.onSuccess(uploadcareGroup);
                return;
            }
            return;
        }
        UploadcareGroupCallback uploadcareGroupCallback2 = this.callback;
        if (uploadcareGroupCallback2 != null) {
            uploadcareGroupCallback2.onFailure(new UploadFailureException((String) null, 1, (DefaultConstructorMarker) null));
        }
    }
}
