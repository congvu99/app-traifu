package io.intercom.android.sdk.state;

import io.intercom.android.sdk.survey.model.SurveyData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/state/SurveyState;", "", "surveyData", "Lio/intercom/android/sdk/survey/model/SurveyData;", "(Lio/intercom/android/sdk/survey/model/SurveyData;)V", "getSurveyData", "()Lio/intercom/android/sdk/survey/model/SurveyData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyState.kt */
public final class SurveyState {
    private final SurveyData surveyData;

    public SurveyState() {
        this((SurveyData) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SurveyState copy$default(SurveyState surveyState, SurveyData surveyData2, int i, Object obj) {
        if ((i & 1) != 0) {
            surveyData2 = surveyState.surveyData;
        }
        return surveyState.copy(surveyData2);
    }

    public final SurveyData component1() {
        return this.surveyData;
    }

    public final SurveyState copy(SurveyData surveyData2) {
        Intrinsics.checkNotNullParameter(surveyData2, "surveyData");
        return new SurveyState(surveyData2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SurveyState) && Intrinsics.areEqual((Object) this.surveyData, (Object) ((SurveyState) obj).surveyData);
    }

    public int hashCode() {
        return this.surveyData.hashCode();
    }

    public String toString() {
        return "SurveyState(surveyData=" + this.surveyData + ')';
    }

    public SurveyState(SurveyData surveyData2) {
        Intrinsics.checkNotNullParameter(surveyData2, "surveyData");
        this.surveyData = surveyData2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SurveyState(SurveyData surveyData2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SurveyData.Companion.getNULL() : surveyData2);
    }

    public final SurveyData getSurveyData() {
        return this.surveyData;
    }
}
