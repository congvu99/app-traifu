package io.intercom.android.sdk.survey.ui;

import io.intercom.android.sdk.survey.SurveyEffects;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.survey.ui.IntercomSurveyActivity$onStart$1", f = "IntercomSurveyActivity.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: IntercomSurveyActivity.kt */
final class IntercomSurveyActivity$onStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ IntercomSurveyActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomSurveyActivity$onStart$1(IntercomSurveyActivity intercomSurveyActivity, Continuation<? super IntercomSurveyActivity$onStart$1> continuation) {
        super(2, continuation);
        this.this$0 = intercomSurveyActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IntercomSurveyActivity$onStart$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IntercomSurveyActivity$onStart$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableSharedFlow<SurveyEffects> effects = this.this$0.getViewModel().getEffects();
            final IntercomSurveyActivity intercomSurveyActivity = this.this$0;
            this.label = 1;
            if (effects.collect(new FlowCollector<SurveyEffects>() {
                public final Object emit(SurveyEffects surveyEffects, Continuation<? super Unit> continuation) {
                    if (Intrinsics.areEqual((Object) surveyEffects, (Object) SurveyEffects.ExitSurvey.INSTANCE)) {
                        intercomSurveyActivity.finish();
                    }
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
