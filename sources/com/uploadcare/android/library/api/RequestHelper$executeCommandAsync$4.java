package com.uploadcare.android.library.api;

import android.content.Context;
import android.os.Handler;
import androidx.core.app.NotificationCompat;
import com.uploadcare.android.library.callbacks.RequestCallback;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"com/uploadcare/android/library/api/RequestHelper$executeCommandAsync$4", "Lokhttp3/Callback;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: RequestHelper.kt */
public final class RequestHelper$executeCommandAsync$4 implements Callback {
    final /* synthetic */ RequestCallback $callback;
    final /* synthetic */ Context $context;
    private final Handler mainHandler;
    final /* synthetic */ RequestHelper this$0;

    RequestHelper$executeCommandAsync$4(RequestHelper requestHelper, RequestCallback requestCallback, Context context) {
        this.this$0 = requestHelper;
        this.$callback = requestCallback;
        this.$context = context;
        this.mainHandler = new Handler(context.getMainLooper());
    }

    public final Handler getMainHandler() {
        return this.mainHandler;
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(iOException, "e");
        if (this.$callback != null) {
            this.mainHandler.post(new RequestHelper$executeCommandAsync$4$onFailure$1(this, iOException));
        }
    }

    public void onResponse(Call call, Response response) throws IOException {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(response, "response");
        if (!response.isSuccessful() && this.$callback != null) {
            this.mainHandler.post(new RequestHelper$executeCommandAsync$4$onResponse$1(this, response));
        }
        RequestCallback requestCallback = this.$callback;
        if (requestCallback != null) {
            this.this$0.checkResponseStatus(response, requestCallback);
            this.mainHandler.post(new RequestHelper$executeCommandAsync$4$onResponse$$inlined$let$lambda$1(requestCallback, this, response));
        }
    }
}
