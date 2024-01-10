package io.intercom.android.sdk.survey.ui.components;

import androidx.compose.foundation.ScrollState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.survey.ui.components.SurveyComponentKt$SurveyContent$1$1$1", f = "SurveyComponent.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SurveyComponent.kt */
final class SurveyComponentKt$SurveyContent$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ScrollState $scrollState;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SurveyComponentKt$SurveyContent$1$1$1(ScrollState scrollState, Continuation<? super SurveyComponentKt$SurveyContent$1$1$1> continuation) {
        super(2, continuation);
        this.$scrollState = scrollState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SurveyComponentKt$SurveyContent$1$1$1(this.$scrollState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SurveyComponentKt$SurveyContent$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$scrollState.scrollTo(0, this) == coroutine_suspended) {
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
