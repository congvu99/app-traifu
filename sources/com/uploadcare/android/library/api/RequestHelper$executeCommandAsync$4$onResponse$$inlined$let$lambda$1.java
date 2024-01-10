package com.uploadcare.android.library.api;

import com.uploadcare.android.library.callbacks.RequestCallback;
import kotlin.Metadata;
import okhttp3.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/uploadcare/android/library/api/RequestHelper$executeCommandAsync$4$onResponse$2$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: RequestHelper.kt */
final class RequestHelper$executeCommandAsync$4$onResponse$$inlined$let$lambda$1 implements Runnable {
    final /* synthetic */ RequestCallback $it;
    final /* synthetic */ Response $response$inlined;
    final /* synthetic */ RequestHelper$executeCommandAsync$4 this$0;

    RequestHelper$executeCommandAsync$4$onResponse$$inlined$let$lambda$1(RequestCallback requestCallback, RequestHelper$executeCommandAsync$4 requestHelper$executeCommandAsync$4, Response response) {
        this.$it = requestCallback;
        this.this$0 = requestHelper$executeCommandAsync$4;
        this.$response$inlined = response;
    }

    public final void run() {
        this.$it.onSuccess(this.$response$inlined);
    }
}
