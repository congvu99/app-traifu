package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1", f = "Recomposer.kt", i = {}, l = {728}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Recomposer.kt */
final class Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProduceFrameSignal $frameSignal;
    final /* synthetic */ MonotonicFrameClock $parentFrameClock;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1(Recomposer recomposer, MonotonicFrameClock monotonicFrameClock, ProduceFrameSignal produceFrameSignal, Continuation<? super Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1> continuation) {
        super(2, continuation);
        this.this$0 = recomposer;
        this.$parentFrameClock = monotonicFrameClock;
        this.$frameSignal = produceFrameSignal;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1(this.this$0, this.$parentFrameClock, this.$frameSignal, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.runFrameLoop(this.$parentFrameClock, this.$frameSignal, this) == coroutine_suspended) {
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
