package io.intercom.android.sdk.survey.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lio/intercom/android/sdk/survey/model/StatsCtaRequestModel;", "", "surveyProgressId", "", "stepId", "(Ljava/lang/String;Ljava/lang/String;)V", "getStepId", "()Ljava/lang/String;", "getSurveyProgressId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: StatsCtaRequestModel.kt */
public final class StatsCtaRequestModel {
    @SerializedName("step_id")
    private final String stepId;
    @SerializedName("survey_progress_id")
    private final String surveyProgressId;

    public static /* synthetic */ StatsCtaRequestModel copy$default(StatsCtaRequestModel statsCtaRequestModel, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = statsCtaRequestModel.surveyProgressId;
        }
        if ((i & 2) != 0) {
            str2 = statsCtaRequestModel.stepId;
        }
        return statsCtaRequestModel.copy(str, str2);
    }

    public final String component1() {
        return this.surveyProgressId;
    }

    public final String component2() {
        return this.stepId;
    }

    public final StatsCtaRequestModel copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "surveyProgressId");
        Intrinsics.checkNotNullParameter(str2, "stepId");
        return new StatsCtaRequestModel(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StatsCtaRequestModel)) {
            return false;
        }
        StatsCtaRequestModel statsCtaRequestModel = (StatsCtaRequestModel) obj;
        return Intrinsics.areEqual((Object) this.surveyProgressId, (Object) statsCtaRequestModel.surveyProgressId) && Intrinsics.areEqual((Object) this.stepId, (Object) statsCtaRequestModel.stepId);
    }

    public int hashCode() {
        return (this.surveyProgressId.hashCode() * 31) + this.stepId.hashCode();
    }

    public String toString() {
        return "StatsCtaRequestModel(surveyProgressId=" + this.surveyProgressId + ", stepId=" + this.stepId + ')';
    }

    public StatsCtaRequestModel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "surveyProgressId");
        Intrinsics.checkNotNullParameter(str2, "stepId");
        this.surveyProgressId = str;
        this.stepId = str2;
    }

    public final String getSurveyProgressId() {
        return this.surveyProgressId;
    }

    public final String getStepId() {
        return this.stepId;
    }
}
