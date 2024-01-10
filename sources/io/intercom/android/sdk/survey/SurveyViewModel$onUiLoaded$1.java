package io.intercom.android.sdk.survey;

import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.survey.SurveyLaunchMode;
import io.intercom.android.sdk.survey.SurveyState;
import io.intercom.android.sdk.survey.TopBarState;
import io.intercom.android.sdk.survey.model.SurveyData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.survey.SurveyViewModel$onUiLoaded$1", f = "SurveyViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SurveyViewModel.kt */
final class SurveyViewModel$onUiLoaded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SurveyViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SurveyViewModel$onUiLoaded$1(SurveyViewModel surveyViewModel, Continuation<? super SurveyViewModel$onUiLoaded$1> continuation) {
        super(2, continuation);
        this.this$0 = surveyViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SurveyViewModel$onUiLoaded$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SurveyViewModel$onUiLoaded$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SurveyLaunchMode access$getLaunchMode$p = this.this$0.launchMode;
            if (access$getLaunchMode$p instanceof SurveyLaunchMode.Automatic) {
                SurveyViewModel surveyViewModel = this.this$0;
                surveyViewModel.surveyData = ((SurveyLaunchMode.Automatic) surveyViewModel.launchMode).getSurveyData();
                if (!this.this$0.surveyData.getSteps().isEmpty()) {
                    this.this$0.metricTracker.surveyOpened("opened", "survey", MetricTracker.Context.FROM_AUTOMATIC, this.this$0.surveyData.getId(), this.this$0.surveyData.getFormatMetric());
                    SurveyViewModel surveyViewModel2 = this.this$0;
                    surveyViewModel2.currentStep = (SurveyData.Step) CollectionsKt.first(surveyViewModel2.surveyData.getSteps());
                    MutableStateFlow<SurveyState> state = this.this$0.getState();
                    SurveyViewModel surveyViewModel3 = this.this$0;
                    state.setValue(surveyViewModel3.buildContentState(surveyViewModel3.surveyData));
                } else {
                    SurveyUiColors surveyUiColors = SurveyViewModelKt.toSurveyUiColors(this.this$0.surveyData.getCustomization());
                    this.this$0.getState().setValue(new SurveyState.Error.WithoutCTA(0, surveyUiColors, new TopBarState.NoTopBarState(true, surveyUiColors, (ProgressBarState) null, 4, (DefaultConstructorMarker) null), 1, (DefaultConstructorMarker) null));
                }
            } else if (access$getLaunchMode$p instanceof SurveyLaunchMode.Programmatic) {
                SurveyViewModel surveyViewModel4 = this.this$0;
                surveyViewModel4.fetchAndShowSurvey(((SurveyLaunchMode.Programmatic) surveyViewModel4.launchMode).getSurveyId());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
