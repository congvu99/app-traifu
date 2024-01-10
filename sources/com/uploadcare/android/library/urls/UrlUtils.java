package com.uploadcare.android.library.urls;

import android.net.Uri;
import java.net.URI;
import java.net.URISyntaxException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/uploadcare/android/library/urls/UrlUtils;", "", "()V", "Companion", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UrlUtils.kt */
public final class UrlUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/uploadcare/android/library/urls/UrlUtils$Companion;", "", "()V", "trustedBuild", "Ljava/net/URI;", "builder", "Landroid/net/Uri$Builder;", "library_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: UrlUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final URI trustedBuild(Uri.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            try {
                return new URI(builder.build().toString());
            } catch (URISyntaxException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }
}
