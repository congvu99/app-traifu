package com.uploadcare.android.library.api;

import android.os.AsyncTask;
import com.facebook.internal.NativeProtocol;
import com.uploadcare.android.library.callbacks.RequestCallback;
import com.uploadcare.android.library.exceptions.UploadcareApiException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ'\u0010\r\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u000f\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/uploadcare/android/library/api/SaveDeleteBatchTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "Lokhttp3/Response;", "client", "Lcom/uploadcare/android/library/api/UploadcareClient;", "requestType", "", "fileIds", "", "callback", "Lcom/uploadcare/android/library/callbacks/RequestCallback;", "(Lcom/uploadcare/android/library/api/UploadcareClient;Ljava/lang/String;Ljava/util/List;Lcom/uploadcare/android/library/callbacks/RequestCallback;)V", "doInBackground", "params", "", "([Ljava/lang/Void;)Lokhttp3/Response;", "onPostExecute", "", "result", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareClient.kt */
final class SaveDeleteBatchTask extends AsyncTask<Void, Void, Response> {
    private final RequestCallback callback;
    private final UploadcareClient client;
    private final List<String> fileIds;
    private final String requestType;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SaveDeleteBatchTask(UploadcareClient uploadcareClient, String str, List list, RequestCallback requestCallback, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uploadcareClient, str, list, (i & 8) != 0 ? null : requestCallback);
    }

    public SaveDeleteBatchTask(UploadcareClient uploadcareClient, String str, List<String> list, RequestCallback requestCallback) {
        Intrinsics.checkNotNullParameter(uploadcareClient, "client");
        Intrinsics.checkNotNullParameter(str, "requestType");
        Intrinsics.checkNotNullParameter(list, "fileIds");
        this.client = uploadcareClient;
        this.requestType = str;
        this.fileIds = list;
        this.callback = requestCallback;
    }

    /* access modifiers changed from: protected */
    public Response doInBackground(Void... voidArr) {
        Intrinsics.checkNotNullParameter(voidArr, NativeProtocol.WEB_DIALOG_PARAMS);
        try {
            return this.client.executeSaveDeleteBatchCommand$library_release(this.requestType, this.fileIds);
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Response response) {
        if (response != null) {
            RequestCallback requestCallback = this.callback;
            if (requestCallback != null) {
                requestCallback.onSuccess(response);
                return;
            }
            return;
        }
        RequestCallback requestCallback2 = this.callback;
        if (requestCallback2 != null) {
            requestCallback2.onFailure(new UploadcareApiException((String) null, 1, (DefaultConstructorMarker) null));
        }
    }
}
