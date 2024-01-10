package io.intercom.android.sdk.survey;

import com.google.gson.Gson;
import io.intercom.android.sdk.api.MessengerApiHelper;
import io.intercom.android.sdk.api.SurveyApi;
import io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse;
import io.intercom.android.sdk.survey.model.FetchSurveyRequest;
import io.intercom.android.sdk.survey.model.StatsCtaRequestModel;
import io.intercom.android.sdk.survey.model.SubmitSurveyRequest;
import io.intercom.android.sdk.survey.model.SubmitSurveyResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ'\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ!\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J'\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lio/intercom/android/sdk/survey/SurveyRepository;", "", "surveyApi", "Lio/intercom/android/sdk/api/SurveyApi;", "(Lio/intercom/android/sdk/api/SurveyApi;)V", "dismissSurvey", "Lio/intercom/android/sdk/helpcenter/utils/networking/NetworkResponse;", "", "surveyId", "", "surveyProgressId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchSurvey", "Lio/intercom/android/sdk/survey/model/FetchSurveyRequest;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportFailure", "submitCtaStat", "statsCtaRequestModel", "Lio/intercom/android/sdk/survey/model/StatsCtaRequestModel;", "(Ljava/lang/String;Lio/intercom/android/sdk/survey/model/StatsCtaRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitSurvey", "Lio/intercom/android/sdk/survey/model/SubmitSurveyResponse;", "submitSurveyRequest", "Lio/intercom/android/sdk/survey/model/SubmitSurveyRequest;", "id", "(Lio/intercom/android/sdk/survey/model/SubmitSurveyRequest;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyRepository.kt */
public final class SurveyRepository {
    private final SurveyApi surveyApi;

    public SurveyRepository() {
        this((SurveyApi) null, 1, (DefaultConstructorMarker) null);
    }

    public SurveyRepository(SurveyApi surveyApi2) {
        Intrinsics.checkNotNullParameter(surveyApi2, "surveyApi");
        this.surveyApi = surveyApi2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SurveyRepository(io.intercom.android.sdk.api.SurveyApi r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto L_0x0011
            io.intercom.android.sdk.Injector r1 = io.intercom.android.sdk.Injector.get()
            io.intercom.android.sdk.api.SurveyApi r1 = r1.getSurveyApi()
            java.lang.String r2 = "get().surveyApi"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        L_0x0011:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.SurveyRepository.<init>(io.intercom.android.sdk.api.SurveyApi, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Object submitSurvey(SubmitSurveyRequest submitSurveyRequest, String str, Continuation<? super NetworkResponse<SubmitSurveyResponse>> continuation) {
        Object fromJson = new Gson().fromJson(new Gson().toJson((Object) submitSurveyRequest), Map.class);
        Intrinsics.checkNotNull(fromJson, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        return this.surveyApi.submitSurveyStep(str, MessengerApiHelper.INSTANCE.getDefaultRequestBody$intercom_sdk_base_release((Map) fromJson), continuation);
    }

    public final Object dismissSurvey(String str, String str2, Continuation<? super NetworkResponse<Unit>> continuation) {
        return this.surveyApi.dismissSurvey(str, MessengerApiHelper.INSTANCE.getDefaultRequestBody$intercom_sdk_base_release(MapsKt.mapOf(TuplesKt.to("survey_progress_id", str2))), continuation);
    }

    public final Object fetchSurvey(String str, Continuation<? super NetworkResponse<FetchSurveyRequest>> continuation) {
        return this.surveyApi.fetchSurvey(str, MessengerApiHelper.getDefaultRequestBody$intercom_sdk_base_release$default(MessengerApiHelper.INSTANCE, (Map) null, 1, (Object) null), continuation);
    }

    public final Object reportFailure(String str, String str2, Continuation<? super NetworkResponse<Unit>> continuation) {
        return this.surveyApi.reportFailure(str, MessengerApiHelper.INSTANCE.getDefaultRequestBody$intercom_sdk_base_release(MapsKt.mapOf(TuplesKt.to("survey_progress_id", str2))), continuation);
    }

    public final Object submitCtaStat(String str, StatsCtaRequestModel statsCtaRequestModel, Continuation<? super Unit> continuation) {
        Object fromJson = new Gson().fromJson(new Gson().toJson((Object) statsCtaRequestModel), Map.class);
        Intrinsics.checkNotNull(fromJson, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        Object submitCtaStat = this.surveyApi.submitCtaStat(str, MessengerApiHelper.INSTANCE.getDefaultRequestBody$intercom_sdk_base_release((Map) fromJson), continuation);
        return submitCtaStat == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? submitCtaStat : Unit.INSTANCE;
    }
}
