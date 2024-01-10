package io.intercom.android.sdk.survey;

import io.intercom.android.sdk.survey.model.SurveyData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lio/intercom/android/sdk/survey/SurveyLaunchMode;", "", "()V", "Automatic", "Programmatic", "Lio/intercom/android/sdk/survey/SurveyLaunchMode$Automatic;", "Lio/intercom/android/sdk/survey/SurveyLaunchMode$Programmatic;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyViewModel.kt */
public abstract class SurveyLaunchMode {
    public /* synthetic */ SurveyLaunchMode(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lio/intercom/android/sdk/survey/SurveyLaunchMode$Automatic;", "Lio/intercom/android/sdk/survey/SurveyLaunchMode;", "surveyData", "Lio/intercom/android/sdk/survey/model/SurveyData;", "(Lio/intercom/android/sdk/survey/model/SurveyData;)V", "getSurveyData", "()Lio/intercom/android/sdk/survey/model/SurveyData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SurveyViewModel.kt */
    public static final class Automatic extends SurveyLaunchMode {
        public static final int $stable = 8;
        private final SurveyData surveyData;

        public static /* synthetic */ Automatic copy$default(Automatic automatic, SurveyData surveyData2, int i, Object obj) {
            if ((i & 1) != 0) {
                surveyData2 = automatic.surveyData;
            }
            return automatic.copy(surveyData2);
        }

        public final SurveyData component1() {
            return this.surveyData;
        }

        public final Automatic copy(SurveyData surveyData2) {
            Intrinsics.checkNotNullParameter(surveyData2, "surveyData");
            return new Automatic(surveyData2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Automatic) && Intrinsics.areEqual((Object) this.surveyData, (Object) ((Automatic) obj).surveyData);
        }

        public int hashCode() {
            return this.surveyData.hashCode();
        }

        public String toString() {
            return "Automatic(surveyData=" + this.surveyData + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Automatic(SurveyData surveyData2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(surveyData2, "surveyData");
            this.surveyData = surveyData2;
        }

        public final SurveyData getSurveyData() {
            return this.surveyData;
        }
    }

    private SurveyLaunchMode() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/survey/SurveyLaunchMode$Programmatic;", "Lio/intercom/android/sdk/survey/SurveyLaunchMode;", "surveyId", "", "(Ljava/lang/String;)V", "getSurveyId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SurveyViewModel.kt */
    public static final class Programmatic extends SurveyLaunchMode {
        public static final int $stable = 0;
        private final String surveyId;

        public static /* synthetic */ Programmatic copy$default(Programmatic programmatic, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = programmatic.surveyId;
            }
            return programmatic.copy(str);
        }

        public final String component1() {
            return this.surveyId;
        }

        public final Programmatic copy(String str) {
            Intrinsics.checkNotNullParameter(str, "surveyId");
            return new Programmatic(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Programmatic) && Intrinsics.areEqual((Object) this.surveyId, (Object) ((Programmatic) obj).surveyId);
        }

        public int hashCode() {
            return this.surveyId.hashCode();
        }

        public String toString() {
            return "Programmatic(surveyId=" + this.surveyId + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Programmatic(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "surveyId");
            this.surveyId = str;
        }

        public final String getSurveyId() {
            return this.surveyId;
        }
    }
}
