package io.intercom.android.sdk.survey;

import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse;
import io.intercom.android.sdk.survey.SurveyEffects;
import io.intercom.android.sdk.survey.model.SurveyData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.survey.SurveyViewModel$onCloseClicked$1", f = "SurveyViewModel.kt", i = {}, l = {275}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SurveyViewModel.kt */
final class SurveyViewModel$onCloseClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CloseEventTrigger $triggerType;
    int label;
    final /* synthetic */ SurveyViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SurveyViewModel$onCloseClicked$1(SurveyViewModel surveyViewModel, CloseEventTrigger closeEventTrigger, Continuation<? super SurveyViewModel$onCloseClicked$1> continuation) {
        super(2, continuation);
        this.this$0 = surveyViewModel;
        this.$triggerType = closeEventTrigger;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SurveyViewModel$onCloseClicked$1(this.this$0, this.$triggerType, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SurveyViewModel$onCloseClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.sendDismissedEvent(this.$triggerType);
            final SurveyViewModel surveyViewModel = this.this$0;
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            this.this$0.store.dispatch(Actions.surveyDismissed());
            this.label = 1;
            if (this.this$0.getEffects().emit(SurveyEffects.ExitSurvey.INSTANCE, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.intercom.android.sdk.survey.SurveyViewModel$onCloseClicked$1$1", f = "SurveyViewModel.kt", i = {}, l = {259, 264}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.intercom.android.sdk.survey.SurveyViewModel$onCloseClicked$1$1  reason: invalid class name */
    /* compiled from: SurveyViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(surveyViewModel, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!surveyViewModel.surveyData.getSteps().isEmpty()) {
                    SurveyData.Step access$getCurrentStep$p = surveyViewModel.currentStep;
                    if (access$getCurrentStep$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentStep");
                        access$getCurrentStep$p = null;
                    }
                    if (access$getCurrentStep$p.getType() != SurveyData.StepType.THANK_YOU) {
                        this.label = 1;
                        obj = surveyViewModel.surveyRepository.dismissSurvey(surveyViewModel.surveyData.getId(), surveyViewModel.surveyData.getSurveyProgressId(), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                return Unit.INSTANCE;
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (((NetworkResponse) obj) instanceof NetworkResponse.ClientError) {
                SurveyViewModel surveyViewModel = surveyViewModel;
                this.label = 2;
                if (surveyViewModel.reportFailure(surveyViewModel.surveyData.getId(), surveyViewModel.surveyData.getSurveyProgressId(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }
}
