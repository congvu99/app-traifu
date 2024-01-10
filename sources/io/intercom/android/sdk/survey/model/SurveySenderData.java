package io.intercom.android.sdk.survey.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveySenderData;", "", "firstName", "", "name", "initials", "avatar", "Lio/intercom/android/sdk/survey/model/SurveySenderAvatar;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/intercom/android/sdk/survey/model/SurveySenderAvatar;)V", "getAvatar", "()Lio/intercom/android/sdk/survey/model/SurveySenderAvatar;", "getFirstName", "()Ljava/lang/String;", "getInitials", "getName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyData.kt */
public final class SurveySenderData {
    @SerializedName("avatar")
    private final SurveySenderAvatar avatar;
    @SerializedName("first_name")
    private final String firstName;
    @SerializedName("initial")
    private final String initials;
    @SerializedName("name")
    private final String name;

    public SurveySenderData() {
        this((String) null, (String) null, (String) null, (SurveySenderAvatar) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SurveySenderData copy$default(SurveySenderData surveySenderData, String str, String str2, String str3, SurveySenderAvatar surveySenderAvatar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = surveySenderData.firstName;
        }
        if ((i & 2) != 0) {
            str2 = surveySenderData.name;
        }
        if ((i & 4) != 0) {
            str3 = surveySenderData.initials;
        }
        if ((i & 8) != 0) {
            surveySenderAvatar = surveySenderData.avatar;
        }
        return surveySenderData.copy(str, str2, str3, surveySenderAvatar);
    }

    public final String component1() {
        return this.firstName;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.initials;
    }

    public final SurveySenderAvatar component4() {
        return this.avatar;
    }

    public final SurveySenderData copy(String str, String str2, String str3, SurveySenderAvatar surveySenderAvatar) {
        return new SurveySenderData(str, str2, str3, surveySenderAvatar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SurveySenderData)) {
            return false;
        }
        SurveySenderData surveySenderData = (SurveySenderData) obj;
        return Intrinsics.areEqual((Object) this.firstName, (Object) surveySenderData.firstName) && Intrinsics.areEqual((Object) this.name, (Object) surveySenderData.name) && Intrinsics.areEqual((Object) this.initials, (Object) surveySenderData.initials) && Intrinsics.areEqual((Object) this.avatar, (Object) surveySenderData.avatar);
    }

    public int hashCode() {
        String str = this.firstName;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.initials;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        SurveySenderAvatar surveySenderAvatar = this.avatar;
        if (surveySenderAvatar != null) {
            i = surveySenderAvatar.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "SurveySenderData(firstName=" + this.firstName + ", name=" + this.name + ", initials=" + this.initials + ", avatar=" + this.avatar + ')';
    }

    public SurveySenderData(String str, String str2, String str3, SurveySenderAvatar surveySenderAvatar) {
        this.firstName = str;
        this.name = str2;
        this.initials = str3;
        this.avatar = surveySenderAvatar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SurveySenderData(String str, String str2, String str3, SurveySenderAvatar surveySenderAvatar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : surveySenderAvatar);
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getName() {
        return this.name;
    }

    public final String getInitials() {
        return this.initials;
    }

    public final SurveySenderAvatar getAvatar() {
        return this.avatar;
    }
}
