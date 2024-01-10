package io.intercom.android.sdk.survey.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/survey/model/FetchSurveyRequest;", "", "survey", "Lio/intercom/android/sdk/survey/model/SurveyData;", "(Lio/intercom/android/sdk/survey/model/SurveyData;)V", "getSurvey", "()Lio/intercom/android/sdk/survey/model/SurveyData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FetchSurveyRequest.kt */
public final class FetchSurveyRequest {
    @SerializedName("survey")
    private final SurveyData survey;

    public static /* synthetic */ FetchSurveyRequest copy$default(FetchSurveyRequest fetchSurveyRequest, SurveyData surveyData, int i, Object obj) {
        if ((i & 1) != 0) {
            surveyData = fetchSurveyRequest.survey;
        }
        return fetchSurveyRequest.copy(surveyData);
    }

    public final SurveyData component1() {
        return this.survey;
    }

    public final FetchSurveyRequest copy(SurveyData surveyData) {
        Intrinsics.checkNotNullParameter(surveyData, "survey");
        return new FetchSurveyRequest(surveyData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FetchSurveyRequest) && Intrinsics.areEqual((Object) this.survey, (Object) ((FetchSurveyRequest) obj).survey);
    }

    public int hashCode() {
        return this.survey.hashCode();
    }

    public String toString() {
        return "FetchSurveyRequest(survey=" + this.survey + ')';
    }

    public FetchSurveyRequest(SurveyData surveyData) {
        Intrinsics.checkNotNullParameter(surveyData, "survey");
        this.survey = surveyData;
    }

    public final SurveyData getSurvey() {
        return this.survey;
    }
}
