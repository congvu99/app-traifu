package io.intercom.android.sdk.survey;

import io.intercom.android.sdk.survey.model.StatsCtaRequestModel;
import io.intercom.android.sdk.survey.model.SurveyData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.survey.SurveyViewModel$onSecondaryCtaClicked$1", f = "SurveyViewModel.kt", i = {}, l = {288}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SurveyViewModel.kt */
final class SurveyViewModel$onSecondaryCtaClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SurveyViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SurveyViewModel$onSecondaryCtaClicked$1(SurveyViewModel surveyViewModel, Continuation<? super SurveyViewModel$onSecondaryCtaClicked$1> continuation) {
        super(2, continuation);
        this.this$0 = surveyViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SurveyViewModel$onSecondaryCtaClicked$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SurveyViewModel$onSecondaryCtaClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SurveyRepository access$getSurveyRepository$p = this.this$0.surveyRepository;
            String id = this.this$0.surveyData.getId();
            String surveyProgressId = this.this$0.surveyData.getSurveyProgressId();
            SurveyData.Step access$getCurrentStep$p = this.this$0.currentStep;
            if (access$getCurrentStep$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentStep");
                access$getCurrentStep$p = null;
            }
            this.label = 1;
            if (access$getSurveyRepository$p.submitCtaStat(id, new StatsCtaRequestModel(surveyProgressId, access$getCurrentStep$p.getId()), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
