package io.intercom.android.sdk.m5.home.data;

import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lio/intercom/android/sdk/m5/home/data/Badge;", "", "badgeType", "", "label", "(Ljava/lang/String;Ljava/lang/String;)V", "getBadgeType", "()Ljava/lang/String;", "getLabel", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeV2Response.kt */
public final class Badge {
    @SerializedName("badge_type")
    private final String badgeType;
    @SerializedName("label")
    private final String label;

    public static /* synthetic */ Badge copy$default(Badge badge, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = badge.badgeType;
        }
        if ((i & 2) != 0) {
            str2 = badge.label;
        }
        return badge.copy(str, str2);
    }

    public final String component1() {
        return this.badgeType;
    }

    public final String component2() {
        return this.label;
    }

    public final Badge copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "badgeType");
        Intrinsics.checkNotNullParameter(str2, Constants.ScionAnalytics.PARAM_LABEL);
        return new Badge(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Badge)) {
            return false;
        }
        Badge badge = (Badge) obj;
        return Intrinsics.areEqual((Object) this.badgeType, (Object) badge.badgeType) && Intrinsics.areEqual((Object) this.label, (Object) badge.label);
    }

    public int hashCode() {
        return (this.badgeType.hashCode() * 31) + this.label.hashCode();
    }

    public String toString() {
        return "Badge(badgeType=" + this.badgeType + ", label=" + this.label + ')';
    }

    public Badge(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "badgeType");
        Intrinsics.checkNotNullParameter(str2, Constants.ScionAnalytics.PARAM_LABEL);
        this.badgeType = str;
        this.label = str2;
    }

    public final String getBadgeType() {
        return this.badgeType;
    }

    public final String getLabel() {
        return this.label;
    }
}
