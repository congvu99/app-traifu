package io.intercom.android.sdk.views.holder;

import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.models.SocialAccount;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B[\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\rHÆ\u0003Ja\u0010!\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012¨\u0006("}, d2 = {"Lio/intercom/android/sdk/views/holder/TeamPresenceState;", "", "avatars", "", "Lio/intercom/android/sdk/models/Avatar;", "title", "", "subtitle", "userBio", "caption", "groupParticipants", "Lio/intercom/android/sdk/views/holder/GroupParticipants;", "twitter", "Lio/intercom/android/sdk/models/SocialAccount;", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/intercom/android/sdk/views/holder/GroupParticipants;Lio/intercom/android/sdk/models/SocialAccount;)V", "getAvatars", "()Ljava/util/List;", "getCaption", "()Ljava/lang/String;", "getGroupParticipants", "()Lio/intercom/android/sdk/views/holder/GroupParticipants;", "getSubtitle", "getTitle", "getTwitter", "()Lio/intercom/android/sdk/models/SocialAccount;", "getUserBio", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TeamPresenceViewHolder.kt */
public final class TeamPresenceState {
    private final List<Avatar> avatars;
    private final String caption;
    private final GroupParticipants groupParticipants;
    private final String subtitle;
    private final String title;
    private final SocialAccount twitter;
    private final String userBio;

    public static /* synthetic */ TeamPresenceState copy$default(TeamPresenceState teamPresenceState, List<Avatar> list, String str, String str2, String str3, String str4, GroupParticipants groupParticipants2, SocialAccount socialAccount, int i, Object obj) {
        if ((i & 1) != 0) {
            list = teamPresenceState.avatars;
        }
        if ((i & 2) != 0) {
            str = teamPresenceState.title;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = teamPresenceState.subtitle;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = teamPresenceState.userBio;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = teamPresenceState.caption;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            groupParticipants2 = teamPresenceState.groupParticipants;
        }
        GroupParticipants groupParticipants3 = groupParticipants2;
        if ((i & 64) != 0) {
            socialAccount = teamPresenceState.twitter;
        }
        return teamPresenceState.copy(list, str5, str6, str7, str8, groupParticipants3, socialAccount);
    }

    public final List<Avatar> component1() {
        return this.avatars;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.subtitle;
    }

    public final String component4() {
        return this.userBio;
    }

    public final String component5() {
        return this.caption;
    }

    public final GroupParticipants component6() {
        return this.groupParticipants;
    }

    public final SocialAccount component7() {
        return this.twitter;
    }

    public final TeamPresenceState copy(List<? extends Avatar> list, String str, String str2, String str3, String str4, GroupParticipants groupParticipants2, SocialAccount socialAccount) {
        Intrinsics.checkNotNullParameter(list, "avatars");
        return new TeamPresenceState(list, str, str2, str3, str4, groupParticipants2, socialAccount);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TeamPresenceState)) {
            return false;
        }
        TeamPresenceState teamPresenceState = (TeamPresenceState) obj;
        return Intrinsics.areEqual((Object) this.avatars, (Object) teamPresenceState.avatars) && Intrinsics.areEqual((Object) this.title, (Object) teamPresenceState.title) && Intrinsics.areEqual((Object) this.subtitle, (Object) teamPresenceState.subtitle) && Intrinsics.areEqual((Object) this.userBio, (Object) teamPresenceState.userBio) && Intrinsics.areEqual((Object) this.caption, (Object) teamPresenceState.caption) && Intrinsics.areEqual((Object) this.groupParticipants, (Object) teamPresenceState.groupParticipants) && Intrinsics.areEqual((Object) this.twitter, (Object) teamPresenceState.twitter);
    }

    public int hashCode() {
        int hashCode = this.avatars.hashCode() * 31;
        String str = this.title;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.subtitle;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userBio;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.caption;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        GroupParticipants groupParticipants2 = this.groupParticipants;
        int hashCode6 = (hashCode5 + (groupParticipants2 == null ? 0 : groupParticipants2.hashCode())) * 31;
        SocialAccount socialAccount = this.twitter;
        if (socialAccount != null) {
            i = socialAccount.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "TeamPresenceState(avatars=" + this.avatars + ", title=" + this.title + ", subtitle=" + this.subtitle + ", userBio=" + this.userBio + ", caption=" + this.caption + ", groupParticipants=" + this.groupParticipants + ", twitter=" + this.twitter + ')';
    }

    public TeamPresenceState(List<? extends Avatar> list, String str, String str2, String str3, String str4, GroupParticipants groupParticipants2, SocialAccount socialAccount) {
        Intrinsics.checkNotNullParameter(list, "avatars");
        this.avatars = list;
        this.title = str;
        this.subtitle = str2;
        this.userBio = str3;
        this.caption = str4;
        this.groupParticipants = groupParticipants2;
        this.twitter = socialAccount;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TeamPresenceState(java.util.List r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, io.intercom.android.sdk.views.holder.GroupParticipants r13, io.intercom.android.sdk.models.SocialAccount r14, int r15, kotlin.jvm.internal.DefaultConstructorMarker r16) {
        /*
            r7 = this;
            r0 = r15 & 2
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0008
        L_0x0007:
            r0 = r9
        L_0x0008:
            r2 = r15 & 4
            if (r2 == 0) goto L_0x000e
            r2 = r1
            goto L_0x000f
        L_0x000e:
            r2 = r10
        L_0x000f:
            r3 = r15 & 8
            if (r3 == 0) goto L_0x0015
            r3 = r1
            goto L_0x0016
        L_0x0015:
            r3 = r11
        L_0x0016:
            r4 = r15 & 16
            if (r4 == 0) goto L_0x001c
            r4 = r1
            goto L_0x001d
        L_0x001c:
            r4 = r12
        L_0x001d:
            r5 = r15 & 32
            if (r5 == 0) goto L_0x0023
            r5 = r1
            goto L_0x0024
        L_0x0023:
            r5 = r13
        L_0x0024:
            r6 = r15 & 64
            if (r6 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r1 = r14
        L_0x002a:
            r9 = r7
            r10 = r8
            r11 = r0
            r12 = r2
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r1
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.views.holder.TeamPresenceState.<init>(java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, io.intercom.android.sdk.views.holder.GroupParticipants, io.intercom.android.sdk.models.SocialAccount, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<Avatar> getAvatars() {
        return this.avatars;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getUserBio() {
        return this.userBio;
    }

    public final String getCaption() {
        return this.caption;
    }

    public final GroupParticipants getGroupParticipants() {
        return this.groupParticipants;
    }

    public final SocialAccount getTwitter() {
        return this.twitter;
    }
}
