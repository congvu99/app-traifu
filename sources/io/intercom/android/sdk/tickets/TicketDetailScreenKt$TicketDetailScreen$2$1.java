package io.intercom.android.sdk.tickets;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.tickets.TicketDetailScreenKt$TicketDetailScreen$2$1", f = "TicketDetailScreen.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TicketDetailScreen.kt */
final class TicketDetailScreenKt$TicketDetailScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<CardState> $cardState$delegate;
    final /* synthetic */ MutableState<Float> $submissionCardAlpha$delegate;
    final /* synthetic */ MutableState<Dp> $submissionCardOffset$delegate;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TicketDetailScreenKt$TicketDetailScreen$2$1(MutableState<Dp> mutableState, MutableState<Float> mutableState2, MutableState<CardState> mutableState3, Continuation<? super TicketDetailScreenKt$TicketDetailScreen$2$1> continuation) {
        super(2, continuation);
        this.$submissionCardOffset$delegate = mutableState;
        this.$submissionCardAlpha$delegate = mutableState2;
        this.$cardState$delegate = mutableState3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TicketDetailScreenKt$TicketDetailScreen$2$1(this.$submissionCardOffset$delegate, this.$submissionCardAlpha$delegate, this.$cardState$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TicketDetailScreenKt$TicketDetailScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TicketDetailScreenKt.m5376TicketDetailScreen$lambda5(this.$submissionCardOffset$delegate, Dp.m4704constructorimpl((float) 0));
            TicketDetailScreenKt.m5378TicketDetailScreen$lambda8(this.$submissionCardAlpha$delegate, 1.0f);
            this.label = 1;
            if (DelayKt.delay(5000, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        TicketDetailScreenKt.m5374TicketDetailScreen$lambda2(this.$cardState$delegate, CardState.TimelineCard);
        return Unit.INSTANCE;
    }
}
