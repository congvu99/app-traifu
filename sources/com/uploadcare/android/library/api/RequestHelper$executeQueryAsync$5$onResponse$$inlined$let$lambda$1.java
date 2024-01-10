package com.uploadcare.android.library.api;

import com.uploadcare.android.library.callbacks.BaseCallback;
import com.uploadcare.android.library.exceptions.UploadcareApiException;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "T", "", "run", "com/uploadcare/android/library/api/RequestHelper$executeQueryAsync$5$onResponse$2$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: RequestHelper.kt */
final class RequestHelper$executeQueryAsync$5$onResponse$$inlined$let$lambda$1 implements Runnable {
    final /* synthetic */ Object $result;
    final /* synthetic */ RequestHelper$executeQueryAsync$5 this$0;

    RequestHelper$executeQueryAsync$5$onResponse$$inlined$let$lambda$1(Object obj, RequestHelper$executeQueryAsync$5 requestHelper$executeQueryAsync$5) {
        this.$result = obj;
        this.this$0 = requestHelper$executeQueryAsync$5;
    }

    public final void run() {
        Unit unit;
        Object obj = this.$result;
        if (obj != null) {
            BaseCallback baseCallback = this.this$0.$callback;
            if (baseCallback != null) {
                baseCallback.onSuccess(obj);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        BaseCallback baseCallback2 = this.this$0.$callback;
        if (baseCallback2 != null) {
            baseCallback2.onFailure(new UploadcareApiException("Can't parse result"));
            Unit unit2 = Unit.INSTANCE;
        }
    }
}
