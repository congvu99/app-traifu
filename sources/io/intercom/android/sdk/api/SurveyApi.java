package io.intercom.android.sdk.api;

import io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse;
import io.intercom.android.sdk.survey.model.FetchSurveyRequest;
import io.intercom.android.sdk.survey.model.SubmitSurveyResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ+\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ+\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ+\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ+\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/api/SurveyApi;", "", "dismissSurvey", "Lio/intercom/android/sdk/helpcenter/utils/networking/NetworkResponse;", "", "surveyId", "", "options", "Lokhttp3/RequestBody;", "(Ljava/lang/String;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchSurvey", "Lio/intercom/android/sdk/survey/model/FetchSurveyRequest;", "reportFailure", "submitCtaStat", "submitSurveyStep", "Lio/intercom/android/sdk/survey/model/SubmitSurveyResponse;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyApi.kt */
public interface SurveyApi {
    @POST("surveys/{surveyId}/dismiss")
    Object dismissSurvey(@Path("surveyId") String str, @Body RequestBody requestBody, Continuation<? super NetworkResponse<Unit>> continuation);

    @POST("surveys/{surveyId}/fetch")
    Object fetchSurvey(@Path("surveyId") String str, @Body RequestBody requestBody, Continuation<? super NetworkResponse<FetchSurveyRequest>> continuation);

    @POST("surveys/{survey_id}/failure")
    Object reportFailure(@Path("survey_id") String str, @Body RequestBody requestBody, Continuation<? super NetworkResponse<Unit>> continuation);

    @POST("surveys/{surveyId}/action_button_clicked")
    Object submitCtaStat(@Path("surveyId") String str, @Body RequestBody requestBody, Continuation<? super NetworkResponse<Unit>> continuation);

    @POST("surveys/{surveyId}/submit")
    Object submitSurveyStep(@Path("surveyId") String str, @Body RequestBody requestBody, Continuation<? super NetworkResponse<SubmitSurveyResponse>> continuation);
}
