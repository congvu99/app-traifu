package com.uploadcare.android.library.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/uploadcare/android/library/api/PublicKeyInterceptor;", "Lokhttp3/Interceptor;", "publicKey", "", "(Ljava/lang/String;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareClient.kt */
final class PublicKeyInterceptor implements Interceptor {
    private final String publicKey;

    public PublicKeyInterceptor(String str) {
        Intrinsics.checkNotNullParameter(str, "publicKey");
        this.publicKey = str;
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder newBuilder = chain.request().newBuilder();
        newBuilder.addHeader("X-Uploadcare-PublicKey", this.publicKey);
        return chain.proceed(newBuilder.build());
    }
}
