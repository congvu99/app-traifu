package com.uploadcare.android.library.api;

import com.uploadcare.android.library.callbacks.UploadcareGroupsCallback;
import com.uploadcare.android.library.data.GroupPageData;
import com.uploadcare.android.library.exceptions.UploadcareApiException;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/uploadcare/android/library/api/RequestHelper$executeGroupsPaginatedQueryWithOffsetLimitAsync$1$onResponse$2$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: RequestHelper.kt */
final class RequestHelper$executeGroupsPaginatedQueryWithOffsetLimitAsync$1$onResponse$$inlined$let$lambda$1 implements Runnable {
    final /* synthetic */ GroupPageData $result;
    final /* synthetic */ RequestHelper$executeGroupsPaginatedQueryWithOffsetLimitAsync$1 this$0;

    RequestHelper$executeGroupsPaginatedQueryWithOffsetLimitAsync$1$onResponse$$inlined$let$lambda$1(GroupPageData groupPageData, RequestHelper$executeGroupsPaginatedQueryWithOffsetLimitAsync$1 requestHelper$executeGroupsPaginatedQueryWithOffsetLimitAsync$1) {
        this.$result = groupPageData;
        this.this$0 = requestHelper$executeGroupsPaginatedQueryWithOffsetLimitAsync$1;
    }

    public final void run() {
        Unit unit;
        GroupPageData groupPageData = this.$result;
        if (groupPageData != null) {
            UploadcareGroupsCallback uploadcareGroupsCallback = this.this$0.$callback;
            if (uploadcareGroupsCallback != null) {
                uploadcareGroupsCallback.onSuccess(groupPageData.getResultsData(), groupPageData.getNextURI());
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        UploadcareGroupsCallback uploadcareGroupsCallback2 = this.this$0.$callback;
        if (uploadcareGroupsCallback2 != null) {
            uploadcareGroupsCallback2.onFailure(new UploadcareApiException("Can't parse result"));
            Unit unit2 = Unit.INSTANCE;
        }
    }
}
