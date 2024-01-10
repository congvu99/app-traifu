package io.intercom.android.sdk.api;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lio/intercom/android/sdk/api/IntercomFlipperClient;", "", "()V", "addInterceptor", "", "builder", "Lokhttp3/OkHttpClient$Builder;", "context", "Landroid/content/Context;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomFlipperClient.kt */
public final class IntercomFlipperClient {
    public static final int $stable = 0;
    public static final IntercomFlipperClient INSTANCE = new IntercomFlipperClient();

    public final void addInterceptor(OkHttpClient.Builder builder, Context context) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private IntercomFlipperClient() {
    }
}
