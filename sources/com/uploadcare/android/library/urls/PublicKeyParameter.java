package com.uploadcare.android.library.urls;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/uploadcare/android/library/urls/PublicKeyParameter;", "Lcom/uploadcare/android/library/urls/UrlParameter;", "publicKey", "", "(Ljava/lang/String;)V", "getParam", "getValue", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UrlParameters.kt */
public final class PublicKeyParameter implements UrlParameter {
    private final String publicKey;

    public String getParam() {
        return "pub_key";
    }

    public PublicKeyParameter(String str) {
        Intrinsics.checkNotNullParameter(str, "publicKey");
        this.publicKey = str;
    }

    public String getValue() {
        return this.publicKey;
    }
}
