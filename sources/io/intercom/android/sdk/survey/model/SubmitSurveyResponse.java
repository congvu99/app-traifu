package io.intercom.android.sdk.survey.model;

import com.google.gson.annotations.SerializedName;
import io.intercom.android.sdk.survey.model.SurveyData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lio/intercom/android/sdk/survey/model/SubmitSurveyResponse;", "", "complete", "", "nextStep", "Lio/intercom/android/sdk/survey/model/SurveyData$Step;", "surveyId", "", "(ZLio/intercom/android/sdk/survey/model/SurveyData$Step;Ljava/lang/String;)V", "getComplete", "()Z", "getNextStep", "()Lio/intercom/android/sdk/survey/model/SurveyData$Step;", "getSurveyId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubmitSurveyResponse.kt */
public final class SubmitSurveyResponse {
    @SerializedName("complete")
    private final boolean complete;
    @SerializedName("next_step")
    private final SurveyData.Step nextStep;
    @SerializedName("survey_id")
    private final String surveyId;

    public static /* synthetic */ SubmitSurveyResponse copy$default(SubmitSurveyResponse submitSurveyResponse, boolean z, SurveyData.Step step, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = submitSurveyResponse.complete;
        }
        if ((i & 2) != 0) {
            step = submitSurveyResponse.nextStep;
        }
        if ((i & 4) != 0) {
            str = submitSurveyResponse.surveyId;
        }
        return submitSurveyResponse.copy(z, step, str);
    }

    public final boolean component1() {
        return this.complete;
    }

    public final SurveyData.Step component2() {
        return this.nextStep;
    }

    public final String component3() {
        return this.surveyId;
    }

    public final SubmitSurveyResponse copy(boolean z, SurveyData.Step step, String str) {
        Intrinsics.checkNotNullParameter(step, "nextStep");
        Intrinsics.checkNotNullParameter(str, "surveyId");
        return new SubmitSurveyResponse(z, step, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubmitSurveyResponse)) {
            return false;
        }
        SubmitSurveyResponse submitSurveyResponse = (SubmitSurveyResponse) obj;
        return this.complete == submitSurveyResponse.complete && Intrinsics.areEqual((Object) this.nextStep, (Object) submitSurveyResponse.nextStep) && Intrinsics.areEqual((Object) this.surveyId, (Object) submitSurveyResponse.surveyId);
    }

    public int hashCode() {
        boolean z = this.complete;
        if (z) {
            z = true;
        }
        return ((((z ? 1 : 0) * true) + this.nextStep.hashCode()) * 31) + this.surveyId.hashCode();
    }

    public String toString() {
        return "SubmitSurveyResponse(complete=" + this.complete + ", nextStep=" + this.nextStep + ", surveyId=" + this.surveyId + ')';
    }

    public SubmitSurveyResponse(boolean z, SurveyData.Step step, String str) {
        Intrinsics.checkNotNullParameter(step, "nextStep");
        Intrinsics.checkNotNullParameter(str, "surveyId");
        this.complete = z;
        this.nextStep = step;
        this.surveyId = str;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final SurveyData.Step getNextStep() {
        return this.nextStep;
    }

    public final String getSurveyId() {
        return this.surveyId;
    }
}
