package com.uploadcare.android.library.data;

import com.squareup.moshi.Json;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ0\u0010\u0012\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/uploadcare/android/library/data/WebhookOptionsData;", "", "targetUrl", "Ljava/net/URI;", "event", "", "isActive", "", "(Ljava/net/URI;Ljava/lang/String;Ljava/lang/Boolean;)V", "getEvent", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTargetUrl", "()Ljava/net/URI;", "component1", "component2", "component3", "copy", "(Ljava/net/URI;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/uploadcare/android/library/data/WebhookOptionsData;", "equals", "other", "hashCode", "", "toString", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: WebhookOptionsData.kt */
public final class WebhookOptionsData {
    private final String event;
    private final Boolean isActive;
    private final URI targetUrl;

    public static /* synthetic */ WebhookOptionsData copy$default(WebhookOptionsData webhookOptionsData, URI uri, String str, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = webhookOptionsData.targetUrl;
        }
        if ((i & 2) != 0) {
            str = webhookOptionsData.event;
        }
        if ((i & 4) != 0) {
            bool = webhookOptionsData.isActive;
        }
        return webhookOptionsData.copy(uri, str, bool);
    }

    public final URI component1() {
        return this.targetUrl;
    }

    public final String component2() {
        return this.event;
    }

    public final Boolean component3() {
        return this.isActive;
    }

    public final WebhookOptionsData copy(@Json(name = "target_url") URI uri, String str, @Json(name = "is_active") Boolean bool) {
        Intrinsics.checkNotNullParameter(uri, "targetUrl");
        return new WebhookOptionsData(uri, str, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebhookOptionsData)) {
            return false;
        }
        WebhookOptionsData webhookOptionsData = (WebhookOptionsData) obj;
        return Intrinsics.areEqual((Object) this.targetUrl, (Object) webhookOptionsData.targetUrl) && Intrinsics.areEqual((Object) this.event, (Object) webhookOptionsData.event) && Intrinsics.areEqual((Object) this.isActive, (Object) webhookOptionsData.isActive);
    }

    public int hashCode() {
        URI uri = this.targetUrl;
        int i = 0;
        int hashCode = (uri != null ? uri.hashCode() : 0) * 31;
        String str = this.event;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Boolean bool = this.isActive;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "WebhookOptionsData(targetUrl=" + this.targetUrl + ", event=" + this.event + ", isActive=" + this.isActive + ")";
    }

    public WebhookOptionsData(@Json(name = "target_url") URI uri, String str, @Json(name = "is_active") Boolean bool) {
        Intrinsics.checkNotNullParameter(uri, "targetUrl");
        this.targetUrl = uri;
        this.event = str;
        this.isActive = bool;
    }

    public final URI getTargetUrl() {
        return this.targetUrl;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WebhookOptionsData(URI uri, String str, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : bool);
    }

    public final String getEvent() {
        return this.event;
    }

    public final Boolean isActive() {
        return this.isActive;
    }
}
