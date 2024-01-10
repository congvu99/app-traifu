package io.intercom.android.sdk.survey;

import io.intercom.android.sdk.R;
import io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.survey.SurveyState;
import io.intercom.android.sdk.survey.TopBarState;
import io.intercom.android.sdk.survey.model.FetchSurveyRequest;
import io.intercom.android.sdk.survey.model.SurveyData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.survey.SurveyViewModel$fetchAndShowSurvey$1", f = "SurveyViewModel.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SurveyViewModel.kt */
final class SurveyViewModel$fetchAndShowSurvey$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $surveyId;
    final /* synthetic */ SurveyUiColors $uiColors;
    int label;
    final /* synthetic */ SurveyViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SurveyViewModel$fetchAndShowSurvey$1(String str, SurveyViewModel surveyViewModel, SurveyUiColors surveyUiColors, Continuation<? super SurveyViewModel$fetchAndShowSurvey$1> continuation) {
        super(2, continuation);
        this.$surveyId = str;
        this.this$0 = surveyViewModel;
        this.$uiColors = surveyUiColors;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SurveyViewModel$fetchAndShowSurvey$1(this.$surveyId, this.this$0, this.$uiColors, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SurveyViewModel$fetchAndShowSurvey$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (StringsKt.isBlank(this.$surveyId)) {
                this.this$0.getState().setValue(new SurveyState.Error.WithoutCTA(0, this.$uiColors, new TopBarState.NoTopBarState(true, this.$uiColors, (ProgressBarState) null, 4, (DefaultConstructorMarker) null), 1, (DefaultConstructorMarker) null));
                return Unit.INSTANCE;
            }
            this.this$0.emitLoading();
            this.label = 1;
            obj = this.this$0.surveyRepository.fetchSurvey(this.$surveyId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NetworkResponse networkResponse = (NetworkResponse) obj;
        if (networkResponse instanceof NetworkResponse.Success) {
            this.this$0.surveyData = ((FetchSurveyRequest) ((NetworkResponse.Success) networkResponse).getBody()).getSurvey();
            if (!this.this$0.surveyData.getSteps().isEmpty()) {
                this.this$0.metricTracker.surveyOpened("opened", "survey", MetricTracker.Context.FROM_PROGRAMMATIC, this.this$0.surveyData.getId(), this.this$0.surveyData.getFormatMetric());
                SurveyViewModel surveyViewModel = this.this$0;
                surveyViewModel.currentStep = (SurveyData.Step) CollectionsKt.first(surveyViewModel.surveyData.getSteps());
                MutableStateFlow<SurveyState> state = this.this$0.getState();
                SurveyViewModel surveyViewModel2 = this.this$0;
                state.setValue(surveyViewModel2.buildContentState(surveyViewModel2.surveyData));
            } else {
                this.this$0.getState().setValue(new SurveyState.Error.WithoutCTA(0, this.$uiColors, new TopBarState.NoTopBarState(true, this.$uiColors, (ProgressBarState) null, 4, (DefaultConstructorMarker) null), 1, (DefaultConstructorMarker) null));
            }
        } else if (networkResponse instanceof NetworkResponse.ClientError) {
            this.this$0.getState().setValue(new SurveyState.Error.WithoutCTA(0, this.$uiColors, new TopBarState.NoTopBarState(true, this.$uiColors, (ProgressBarState) null, 4, (DefaultConstructorMarker) null), 1, (DefaultConstructorMarker) null));
        } else if (networkResponse instanceof NetworkResponse.NetworkError) {
            MutableStateFlow<SurveyState> state2 = this.this$0.getState();
            TopBarState.NoTopBarState noTopBarState = new TopBarState.NoTopBarState(true, this.$uiColors, (ProgressBarState) null, 4, (DefaultConstructorMarker) null);
            final SurveyViewModel surveyViewModel3 = this.this$0;
            final String str = this.$surveyId;
            state2.setValue(new SurveyState.Error.WithCTA(0, this.$uiColors, noTopBarState, new Function0<Unit>() {
                public final void invoke() {
                    surveyViewModel3.fetchAndShowSurvey(str);
                }
            }, 1, (DefaultConstructorMarker) null));
        } else if (networkResponse instanceof NetworkResponse.ServerError) {
            this.this$0.getState().setValue(new SurveyState.Error.WithoutCTA(R.string.intercom_page_not_found, this.$uiColors, new TopBarState.NoTopBarState(true, this.$uiColors, (ProgressBarState) null, 4, (DefaultConstructorMarker) null)));
        }
        return Unit.INSTANCE;
    }
}
