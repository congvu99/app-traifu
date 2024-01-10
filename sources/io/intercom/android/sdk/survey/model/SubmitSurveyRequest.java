package io.intercom.android.sdk.survey.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lio/intercom/android/sdk/survey/model/SubmitSurveyRequest;", "", "surveyProgressId", "", "currentStepId", "responses", "", "Lio/intercom/android/sdk/survey/model/SubmitSurveyRequestItem;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCurrentStepId", "()Ljava/lang/String;", "getResponses", "()Ljava/util/List;", "getSurveyProgressId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubmitSurveyRequest.kt */
public final class SubmitSurveyRequest {
    @SerializedName("current_step_id")
    private final String currentStepId;
    @SerializedName("responses")
    private final List<SubmitSurveyRequestItem> responses;
    @SerializedName("survey_progress_id")
    private final String surveyProgressId;

    public static /* synthetic */ SubmitSurveyRequest copy$default(SubmitSurveyRequest submitSurveyRequest, String str, String str2, List<SubmitSurveyRequestItem> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = submitSurveyRequest.surveyProgressId;
        }
        if ((i & 2) != 0) {
            str2 = submitSurveyRequest.currentStepId;
        }
        if ((i & 4) != 0) {
            list = submitSurveyRequest.responses;
        }
        return submitSurveyRequest.copy(str, str2, list);
    }

    public final String component1() {
        return this.surveyProgressId;
    }

    public final String component2() {
        return this.currentStepId;
    }

    public final List<SubmitSurveyRequestItem> component3() {
        return this.responses;
    }

    public final SubmitSurveyRequest copy(String str, String str2, List<SubmitSurveyRequestItem> list) {
        Intrinsics.checkNotNullParameter(str, "surveyProgressId");
        Intrinsics.checkNotNullParameter(str2, "currentStepId");
        Intrinsics.checkNotNullParameter(list, "responses");
        return new SubmitSurveyRequest(str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubmitSurveyRequest)) {
            return false;
        }
        SubmitSurveyRequest submitSurveyRequest = (SubmitSurveyRequest) obj;
        return Intrinsics.areEqual((Object) this.surveyProgressId, (Object) submitSurveyRequest.surveyProgressId) && Intrinsics.areEqual((Object) this.currentStepId, (Object) submitSurveyRequest.currentStepId) && Intrinsics.areEqual((Object) this.responses, (Object) submitSurveyRequest.responses);
    }

    public int hashCode() {
        return (((this.surveyProgressId.hashCode() * 31) + this.currentStepId.hashCode()) * 31) + this.responses.hashCode();
    }

    public String toString() {
        return "SubmitSurveyRequest(surveyProgressId=" + this.surveyProgressId + ", currentStepId=" + this.currentStepId + ", responses=" + this.responses + ')';
    }

    public SubmitSurveyRequest(String str, String str2, List<SubmitSurveyRequestItem> list) {
        Intrinsics.checkNotNullParameter(str, "surveyProgressId");
        Intrinsics.checkNotNullParameter(str2, "currentStepId");
        Intrinsics.checkNotNullParameter(list, "responses");
        this.surveyProgressId = str;
        this.currentStepId = str2;
        this.responses = list;
    }

    public final String getSurveyProgressId() {
        return this.surveyProgressId;
    }

    public final String getCurrentStepId() {
        return this.currentStepId;
    }

    public final List<SubmitSurveyRequestItem> getResponses() {
        return this.responses;
    }
}
