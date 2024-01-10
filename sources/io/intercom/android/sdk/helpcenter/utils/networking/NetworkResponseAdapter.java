package io.intercom.android.sdk.helpcenter.utils.networking;

import androidx.core.app.NotificationCompat;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.CallAdapter;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u001a\u0012\u0004\u0012\u0002H\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00050\u00040\u0003B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\"\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lio/intercom/android/sdk/helpcenter/utils/networking/NetworkResponseAdapter;", "S", "", "Lretrofit2/CallAdapter;", "Lretrofit2/Call;", "Lio/intercom/android/sdk/helpcenter/utils/networking/NetworkResponse;", "successType", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "adapt", "call", "responseType", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NetworkResponseAdapter.kt */
public final class NetworkResponseAdapter<S> implements CallAdapter<S, Call<NetworkResponse<? extends S>>> {
    private final Type successType;

    public NetworkResponseAdapter(Type type) {
        Intrinsics.checkNotNullParameter(type, "successType");
        this.successType = type;
    }

    public Type responseType() {
        return this.successType;
    }

    public Call<NetworkResponse<S>> adapt(Call<S> call) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        return new NetworkResponseCall<>(call);
    }
}