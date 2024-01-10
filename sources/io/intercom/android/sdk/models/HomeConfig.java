package io.intercom.android.sdk.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lio/intercom/android/sdk/models/HomeConfig;", "", "header", "Lio/intercom/android/sdk/models/HeaderConfig;", "openConfig", "Lio/intercom/android/sdk/models/OpenConfig;", "(Lio/intercom/android/sdk/models/HeaderConfig;Lio/intercom/android/sdk/models/OpenConfig;)V", "getHeader", "()Lio/intercom/android/sdk/models/HeaderConfig;", "getOpenConfig", "()Lio/intercom/android/sdk/models/OpenConfig;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConfigModules.kt */
public final class HomeConfig {
    @SerializedName("header")
    private final HeaderConfig header;
    @SerializedName("open_config")
    private final OpenConfig openConfig;

    public HomeConfig() {
        this((HeaderConfig) null, (OpenConfig) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ HomeConfig copy$default(HomeConfig homeConfig, HeaderConfig headerConfig, OpenConfig openConfig2, int i, Object obj) {
        if ((i & 1) != 0) {
            headerConfig = homeConfig.header;
        }
        if ((i & 2) != 0) {
            openConfig2 = homeConfig.openConfig;
        }
        return homeConfig.copy(headerConfig, openConfig2);
    }

    public final HeaderConfig component1() {
        return this.header;
    }

    public final OpenConfig component2() {
        return this.openConfig;
    }

    public final HomeConfig copy(HeaderConfig headerConfig, OpenConfig openConfig2) {
        Intrinsics.checkNotNullParameter(headerConfig, "header");
        Intrinsics.checkNotNullParameter(openConfig2, "openConfig");
        return new HomeConfig(headerConfig, openConfig2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeConfig)) {
            return false;
        }
        HomeConfig homeConfig = (HomeConfig) obj;
        return Intrinsics.areEqual((Object) this.header, (Object) homeConfig.header) && Intrinsics.areEqual((Object) this.openConfig, (Object) homeConfig.openConfig);
    }

    public int hashCode() {
        return (this.header.hashCode() * 31) + this.openConfig.hashCode();
    }

    public String toString() {
        return "HomeConfig(header=" + this.header + ", openConfig=" + this.openConfig + ')';
    }

    public HomeConfig(HeaderConfig headerConfig, OpenConfig openConfig2) {
        Intrinsics.checkNotNullParameter(headerConfig, "header");
        Intrinsics.checkNotNullParameter(openConfig2, "openConfig");
        this.header = headerConfig;
        this.openConfig = openConfig2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeConfig(HeaderConfig headerConfig, OpenConfig openConfig2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new HeaderConfig((HeaderBackgroundModel) null, (HeaderContentModel) null, false, 7, (DefaultConstructorMarker) null) : headerConfig, (i & 2) != 0 ? new OpenConfig((OpenToSpace) null, 1, (DefaultConstructorMarker) null) : openConfig2);
    }

    public final HeaderConfig getHeader() {
        return this.header;
    }

    public final OpenConfig getOpenConfig() {
        return this.openConfig;
    }
}
