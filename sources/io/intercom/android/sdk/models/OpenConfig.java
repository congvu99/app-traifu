package io.intercom.android.sdk.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/models/OpenConfig;", "", "openTo", "Lio/intercom/android/sdk/models/OpenToSpace;", "(Lio/intercom/android/sdk/models/OpenToSpace;)V", "getOpenTo", "()Lio/intercom/android/sdk/models/OpenToSpace;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConfigModules.kt */
public final class OpenConfig {
    @SerializedName("open_to")
    private final OpenToSpace openTo;

    public OpenConfig() {
        this((OpenToSpace) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OpenConfig copy$default(OpenConfig openConfig, OpenToSpace openToSpace, int i, Object obj) {
        if ((i & 1) != 0) {
            openToSpace = openConfig.openTo;
        }
        return openConfig.copy(openToSpace);
    }

    public final OpenToSpace component1() {
        return this.openTo;
    }

    public final OpenConfig copy(OpenToSpace openToSpace) {
        Intrinsics.checkNotNullParameter(openToSpace, "openTo");
        return new OpenConfig(openToSpace);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OpenConfig) && this.openTo == ((OpenConfig) obj).openTo;
    }

    public int hashCode() {
        return this.openTo.hashCode();
    }

    public String toString() {
        return "OpenConfig(openTo=" + this.openTo + ')';
    }

    public OpenConfig(OpenToSpace openToSpace) {
        Intrinsics.checkNotNullParameter(openToSpace, "openTo");
        this.openTo = openToSpace;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OpenConfig(OpenToSpace openToSpace, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? OpenToSpace.HOME : openToSpace);
    }

    public final OpenToSpace getOpenTo() {
        return this.openTo;
    }
}
