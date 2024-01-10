package io.intercom.android.sdk.survey.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lio/intercom/android/sdk/survey/model/SubmitSurveyRequestItem;", "", "questionId", "", "response", "", "(Ljava/lang/String;Ljava/util/List;)V", "getQuestionId", "()Ljava/lang/String;", "getResponse", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubmitSurveyRequest.kt */
public final class SubmitSurveyRequestItem {
    @SerializedName("question_id")
    private final String questionId;
    @SerializedName("response")
    private final List<String> response;

    public static /* synthetic */ SubmitSurveyRequestItem copy$default(SubmitSurveyRequestItem submitSurveyRequestItem, String str, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = submitSurveyRequestItem.questionId;
        }
        if ((i & 2) != 0) {
            list = submitSurveyRequestItem.response;
        }
        return submitSurveyRequestItem.copy(str, list);
    }

    public final String component1() {
        return this.questionId;
    }

    public final List<String> component2() {
        return this.response;
    }

    public final SubmitSurveyRequestItem copy(String str, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "questionId");
        Intrinsics.checkNotNullParameter(list, "response");
        return new SubmitSurveyRequestItem(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubmitSurveyRequestItem)) {
            return false;
        }
        SubmitSurveyRequestItem submitSurveyRequestItem = (SubmitSurveyRequestItem) obj;
        return Intrinsics.areEqual((Object) this.questionId, (Object) submitSurveyRequestItem.questionId) && Intrinsics.areEqual((Object) this.response, (Object) submitSurveyRequestItem.response);
    }

    public int hashCode() {
        return (this.questionId.hashCode() * 31) + this.response.hashCode();
    }

    public String toString() {
        return "SubmitSurveyRequestItem(questionId=" + this.questionId + ", response=" + this.response + ')';
    }

    public SubmitSurveyRequestItem(String str, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "questionId");
        Intrinsics.checkNotNullParameter(list, "response");
        this.questionId = str;
        this.response = list;
    }

    public final String getQuestionId() {
        return this.questionId;
    }

    public final List<String> getResponse() {
        return this.response;
    }
}
