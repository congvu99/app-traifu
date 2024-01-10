package io.intercom.android.sdk.views.holder;

import io.intercom.android.sdk.models.Avatar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lio/intercom/android/sdk/views/holder/GroupParticipants;", "", "avatars", "", "Lio/intercom/android/sdk/models/Avatar;", "title", "", "(Ljava/util/List;Ljava/lang/String;)V", "getAvatars", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TeamPresenceViewHolder.kt */
public final class GroupParticipants {
    private final List<Avatar> avatars;
    private final String title;

    public static /* synthetic */ GroupParticipants copy$default(GroupParticipants groupParticipants, List<Avatar> list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = groupParticipants.avatars;
        }
        if ((i & 2) != 0) {
            str = groupParticipants.title;
        }
        return groupParticipants.copy(list, str);
    }

    public final List<Avatar> component1() {
        return this.avatars;
    }

    public final String component2() {
        return this.title;
    }

    public final GroupParticipants copy(List<? extends Avatar> list, String str) {
        Intrinsics.checkNotNullParameter(list, "avatars");
        Intrinsics.checkNotNullParameter(str, "title");
        return new GroupParticipants(list, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GroupParticipants)) {
            return false;
        }
        GroupParticipants groupParticipants = (GroupParticipants) obj;
        return Intrinsics.areEqual((Object) this.avatars, (Object) groupParticipants.avatars) && Intrinsics.areEqual((Object) this.title, (Object) groupParticipants.title);
    }

    public int hashCode() {
        return (this.avatars.hashCode() * 31) + this.title.hashCode();
    }

    public String toString() {
        return "GroupParticipants(avatars=" + this.avatars + ", title=" + this.title + ')';
    }

    public GroupParticipants(List<? extends Avatar> list, String str) {
        Intrinsics.checkNotNullParameter(list, "avatars");
        Intrinsics.checkNotNullParameter(str, "title");
        this.avatars = list;
        this.title = str;
    }

    public final List<Avatar> getAvatars() {
        return this.avatars;
    }

    public final String getTitle() {
        return this.title;
    }
}
