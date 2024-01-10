package io.intercom.android.sdk.survey.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveySenderAvatar;", "", "squareImg128", "", "(Ljava/lang/String;)V", "getSquareImg128", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyData.kt */
public final class SurveySenderAvatar {
    @SerializedName("square_128")
    private final String squareImg128;

    public SurveySenderAvatar() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SurveySenderAvatar copy$default(SurveySenderAvatar surveySenderAvatar, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = surveySenderAvatar.squareImg128;
        }
        return surveySenderAvatar.copy(str);
    }

    public final String component1() {
        return this.squareImg128;
    }

    public final SurveySenderAvatar copy(String str) {
        Intrinsics.checkNotNullParameter(str, "squareImg128");
        return new SurveySenderAvatar(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SurveySenderAvatar) && Intrinsics.areEqual((Object) this.squareImg128, (Object) ((SurveySenderAvatar) obj).squareImg128);
    }

    public int hashCode() {
        return this.squareImg128.hashCode();
    }

    public String toString() {
        return "SurveySenderAvatar(squareImg128=" + this.squareImg128 + ')';
    }

    public SurveySenderAvatar(String str) {
        Intrinsics.checkNotNullParameter(str, "squareImg128");
        this.squareImg128 = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SurveySenderAvatar(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    public final String getSquareImg128() {
        return this.squareImg128;
    }
}
