package com.uploadcare.android.library.api;

import com.uploadcare.android.library.callbacks.BaseCallback;
import com.uploadcare.android.library.exceptions.UploadcareApiException;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: RequestHelper.kt */
final class RequestHelper$executeQueryAsync$5$onFailure$1 implements Runnable {
    final /* synthetic */ IOException $e;
    final /* synthetic */ RequestHelper$executeQueryAsync$5 this$0;

    RequestHelper$executeQueryAsync$5$onFailure$1(RequestHelper$executeQueryAsync$5 requestHelper$executeQueryAsync$5, IOException iOException) {
        this.this$0 = requestHelper$executeQueryAsync$5;
        this.$e = iOException;
    }

    public final void run() {
        BaseCallback baseCallback = this.this$0.$callback;
        if (baseCallback != null) {
            baseCallback.onFailure(new UploadcareApiException(this.$e.getMessage()));
        }
    }
}
