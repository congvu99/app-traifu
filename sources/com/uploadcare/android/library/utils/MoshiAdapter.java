package com.uploadcare.android.library.utils;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/uploadcare/android/library/utils/MoshiAdapter;", "", "()V", "uriFromJson", "Ljava/net/URI;", "uriJson", "", "uriToJson", "uri", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: MoshiAdapter.kt */
public final class MoshiAdapter {
    @FromJson
    public final URI uriFromJson(String str) {
        Intrinsics.checkNotNullParameter(str, "uriJson");
        return new URI(str);
    }

    @ToJson
    public final String uriToJson(URI uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        return uri2;
    }
}
