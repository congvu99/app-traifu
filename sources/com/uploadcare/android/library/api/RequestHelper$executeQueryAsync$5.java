package com.uploadcare.android.library.api;

import android.content.Context;
import android.os.Handler;
import androidx.core.app.NotificationCompat;
import com.uploadcare.android.library.callbacks.BaseCallback;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"com/uploadcare/android/library/api/RequestHelper$executeQueryAsync$5", "Lokhttp3/Callback;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: RequestHelper.kt */
public final class RequestHelper$executeQueryAsync$5 implements Callback {
    final /* synthetic */ BaseCallback $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ Class $dataClass;
    private final Handler mainHandler;
    final /* synthetic */ RequestHelper this$0;

    RequestHelper$executeQueryAsync$5(RequestHelper requestHelper, BaseCallback baseCallback, Class cls, Context context) {
        this.this$0 = requestHelper;
        this.$callback = baseCallback;
        this.$dataClass = cls;
        this.$context = context;
        this.mainHandler = new Handler(context.getMainLooper());
    }

    public final Handler getMainHandler() {
        return this.mainHandler;
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(iOException, "e");
        iOException.printStackTrace();
        this.mainHandler.post(new RequestHelper$executeQueryAsync$5$onFailure$1(this, iOException));
    }

    public void onResponse(Call call, Response response) throws IOException {
        String string;
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(response, "response");
        if (!response.isSuccessful()) {
            this.mainHandler.post(new RequestHelper$executeQueryAsync$5$onResponse$1(this, response));
        }
        try {
            this.this$0.checkResponseStatus$library_release(response);
            ResponseBody body = response.body();
            if (body == null || (string = body.string()) == null) {
                this.mainHandler.post(new RequestHelper$executeQueryAsync$5$onResponse$3(this));
                return;
            }
            this.mainHandler.post(new RequestHelper$executeQueryAsync$5$onResponse$$inlined$let$lambda$1(this.this$0.client.getObjectMapper().fromJson(string, this.$dataClass), this));
        } catch (Exception e) {
            e.printStackTrace();
            this.mainHandler.post(new RequestHelper$executeQueryAsync$5$onResponse$4(this, e));
        }
    }
}
