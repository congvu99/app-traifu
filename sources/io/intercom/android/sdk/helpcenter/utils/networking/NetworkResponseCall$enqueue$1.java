package io.intercom.android.sdk.helpcenter.utils.networking;

import androidx.core.app.NotificationCompat;
import io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¨\u0006\u000b"}, d2 = {"io/intercom/android/sdk/helpcenter/utils/networking/NetworkResponseCall$enqueue$1", "Lretrofit2/Callback;", "onFailure", "", "call", "Lretrofit2/Call;", "throwable", "", "onResponse", "response", "Lretrofit2/Response;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NetworkResponseCall.kt */
public final class NetworkResponseCall$enqueue$1 implements Callback<S> {
    final /* synthetic */ Callback<NetworkResponse<S>> $callback;
    final /* synthetic */ NetworkResponseCall<S> this$0;

    NetworkResponseCall$enqueue$1(Callback<NetworkResponse<S>> callback, NetworkResponseCall<S> networkResponseCall) {
        this.$callback = callback;
        this.this$0 = networkResponseCall;
    }

    public void onResponse(Call<S> call, Response<S> response) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(response, "response");
        S body = response.body();
        int code = response.code();
        if (!response.isSuccessful()) {
            this.$callback.onResponse(this.this$0, Response.success(new NetworkResponse.ServerError(code)));
        } else if (body != null) {
            this.$callback.onResponse(this.this$0, Response.success(new NetworkResponse.Success(body)));
        } else {
            this.$callback.onResponse(this.this$0, Response.success(new NetworkResponse.ClientError(new Throwable())));
        }
    }

    public void onFailure(Call<S> call, Throwable th) {
        NetworkResponse networkResponse;
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(th, "throwable");
        if (th instanceof IOException) {
            networkResponse = new NetworkResponse.NetworkError((IOException) th);
        } else {
            networkResponse = new NetworkResponse.ClientError(th);
        }
        this.$callback.onResponse(this.this$0, Response.success(networkResponse));
    }
}
