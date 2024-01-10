package io.intercom.android.sdk.m5.home.data;

import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lio/intercom/android/sdk/m5/home/data/Action;", "", "label", "", "icon", "Lio/intercom/android/sdk/m5/home/data/IconType;", "subtitle", "(Ljava/lang/String;Lio/intercom/android/sdk/m5/home/data/IconType;Ljava/lang/String;)V", "getIcon", "()Lio/intercom/android/sdk/m5/home/data/IconType;", "getLabel", "()Ljava/lang/String;", "getSubtitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeV2Response.kt */
public final class Action {
    @SerializedName("icon")
    private final IconType icon;
    @SerializedName("label")
    private final String label;
    @SerializedName("subtitle")
    private final String subtitle;

    public static /* synthetic */ Action copy$default(Action action, String str, IconType iconType, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = action.label;
        }
        if ((i & 2) != 0) {
            iconType = action.icon;
        }
        if ((i & 4) != 0) {
            str2 = action.subtitle;
        }
        return action.copy(str, iconType, str2);
    }

    public final String component1() {
        return this.label;
    }

    public final IconType component2() {
        return this.icon;
    }

    public final String component3() {
        return this.subtitle;
    }

    public final Action copy(String str, IconType iconType, String str2) {
        Intrinsics.checkNotNullParameter(str, Constants.ScionAnalytics.PARAM_LABEL);
        return new Action(str, iconType, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Action)) {
            return false;
        }
        Action action = (Action) obj;
        return Intrinsics.areEqual((Object) this.label, (Object) action.label) && this.icon == action.icon && Intrinsics.areEqual((Object) this.subtitle, (Object) action.subtitle);
    }

    public int hashCode() {
        int hashCode = this.label.hashCode() * 31;
        IconType iconType = this.icon;
        int i = 0;
        int hashCode2 = (hashCode + (iconType == null ? 0 : iconType.hashCode())) * 31;
        String str = this.subtitle;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "Action(label=" + this.label + ", icon=" + this.icon + ", subtitle=" + this.subtitle + ')';
    }

    public Action(String str, IconType iconType, String str2) {
        Intrinsics.checkNotNullParameter(str, Constants.ScionAnalytics.PARAM_LABEL);
        this.label = str;
        this.icon = iconType;
        this.subtitle = str2;
    }

    public final String getLabel() {
        return this.label;
    }

    public final IconType getIcon() {
        return this.icon;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }
}
