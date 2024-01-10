package io.intercom.android.sdk.m5.home.data;

import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lio/intercom/android/sdk/m5/home/data/SpaceItem;", "", "badge", "Lio/intercom/android/sdk/m5/home/data/Badge;", "label", "", "type", "Lio/intercom/android/sdk/m5/home/data/SpaceItemType;", "(Lio/intercom/android/sdk/m5/home/data/Badge;Ljava/lang/String;Lio/intercom/android/sdk/m5/home/data/SpaceItemType;)V", "getBadge", "()Lio/intercom/android/sdk/m5/home/data/Badge;", "getLabel", "()Ljava/lang/String;", "getType", "()Lio/intercom/android/sdk/m5/home/data/SpaceItemType;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeV2Response.kt */
public final class SpaceItem {
    @SerializedName("badge")
    private final Badge badge;
    @SerializedName("label")
    private final String label;
    @SerializedName("type")
    private final SpaceItemType type;

    public static /* synthetic */ SpaceItem copy$default(SpaceItem spaceItem, Badge badge2, String str, SpaceItemType spaceItemType, int i, Object obj) {
        if ((i & 1) != 0) {
            badge2 = spaceItem.badge;
        }
        if ((i & 2) != 0) {
            str = spaceItem.label;
        }
        if ((i & 4) != 0) {
            spaceItemType = spaceItem.type;
        }
        return spaceItem.copy(badge2, str, spaceItemType);
    }

    public final Badge component1() {
        return this.badge;
    }

    public final String component2() {
        return this.label;
    }

    public final SpaceItemType component3() {
        return this.type;
    }

    public final SpaceItem copy(Badge badge2, String str, SpaceItemType spaceItemType) {
        Intrinsics.checkNotNullParameter(str, Constants.ScionAnalytics.PARAM_LABEL);
        Intrinsics.checkNotNullParameter(spaceItemType, "type");
        return new SpaceItem(badge2, str, spaceItemType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpaceItem)) {
            return false;
        }
        SpaceItem spaceItem = (SpaceItem) obj;
        return Intrinsics.areEqual((Object) this.badge, (Object) spaceItem.badge) && Intrinsics.areEqual((Object) this.label, (Object) spaceItem.label) && this.type == spaceItem.type;
    }

    public int hashCode() {
        Badge badge2 = this.badge;
        return ((((badge2 == null ? 0 : badge2.hashCode()) * 31) + this.label.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "SpaceItem(badge=" + this.badge + ", label=" + this.label + ", type=" + this.type + ')';
    }

    public SpaceItem(Badge badge2, String str, SpaceItemType spaceItemType) {
        Intrinsics.checkNotNullParameter(str, Constants.ScionAnalytics.PARAM_LABEL);
        Intrinsics.checkNotNullParameter(spaceItemType, "type");
        this.badge = badge2;
        this.label = str;
        this.type = spaceItemType;
    }

    public final Badge getBadge() {
        return this.badge;
    }

    public final String getLabel() {
        return this.label;
    }

    public final SpaceItemType getType() {
        return this.type;
    }
}
