package com.uploadcare.android.library.api;

import com.uploadcare.android.library.callbacks.UploadcareGroupsCallback;
import com.uploadcare.android.library.exceptions.UploadcareApiException;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: RequestHelper.kt */
final class RequestHelper$executeGroupsPaginatedQueryWithOffsetLimitAsync$1$onFailure$1 implements Runnable {
    final /* synthetic */ IOException $e;
    final /* synthetic */ RequestHelper$executeGroupsPaginatedQueryWithOffsetLimitAsync$1 this$0;

    RequestHelper$executeGroupsPaginatedQueryWithOffsetLimitAsync$1$onFailure$1(RequestHelper$executeGroupsPaginatedQueryWithOffsetLimitAsync$1 requestHelper$executeGroupsPaginatedQueryWithOffsetLimitAsync$1, IOException iOException) {
        this.this$0 = requestHelper$executeGroupsPaginatedQueryWithOffsetLimitAsync$1;
        this.$e = iOException;
    }

    public final void run() {
        UploadcareGroupsCallback uploadcareGroupsCallback = this.this$0.$callback;
        if (uploadcareGroupsCallback != null) {
            uploadcareGroupsCallback.onFailure(new UploadcareApiException(this.$e.getMessage()));
        }
    }
}
