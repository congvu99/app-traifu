package com.uploadcare.android.library.api;

import com.uploadcare.android.library.callbacks.UploadcareFilesCallback;
import com.uploadcare.android.library.data.FilePageData;
import com.uploadcare.android.library.exceptions.UploadcareApiException;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/uploadcare/android/library/api/RequestHelper$executePaginatedQueryWithOffsetLimitAsync$1$onResponse$2$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: RequestHelper.kt */
final class RequestHelper$executePaginatedQueryWithOffsetLimitAsync$1$onResponse$$inlined$let$lambda$1 implements Runnable {
    final /* synthetic */ FilePageData $result;
    final /* synthetic */ RequestHelper$executePaginatedQueryWithOffsetLimitAsync$1 this$0;

    RequestHelper$executePaginatedQueryWithOffsetLimitAsync$1$onResponse$$inlined$let$lambda$1(FilePageData filePageData, RequestHelper$executePaginatedQueryWithOffsetLimitAsync$1 requestHelper$executePaginatedQueryWithOffsetLimitAsync$1) {
        this.$result = filePageData;
        this.this$0 = requestHelper$executePaginatedQueryWithOffsetLimitAsync$1;
    }

    public final void run() {
        Unit unit;
        FilePageData filePageData = this.$result;
        if (filePageData != null) {
            UploadcareFilesCallback uploadcareFilesCallback = this.this$0.$callback;
            if (uploadcareFilesCallback != null) {
                uploadcareFilesCallback.onSuccess(filePageData.getResultsData(), filePageData.getNextURI());
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        UploadcareFilesCallback uploadcareFilesCallback2 = this.this$0.$callback;
        if (uploadcareFilesCallback2 != null) {
            uploadcareFilesCallback2.onFailure(new UploadcareApiException("Can't parse result"));
            Unit unit2 = Unit.INSTANCE;
        }
    }
}
