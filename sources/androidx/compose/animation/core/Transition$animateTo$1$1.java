package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.Transition$animateTo$1$1", f = "Transition.kt", i = {}, l = {432}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Transition.kt */
final class Transition$animateTo$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ Transition<S> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Transition$animateTo$1$1(Transition<S> transition, Continuation<? super Transition$animateTo$1$1> continuation) {
        super(2, continuation);
        this.this$0 = transition;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Transition$animateTo$1$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Transition$animateTo$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        final Transition<S> transition;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0 || i == 1) {
            ResultKt.throwOnFailure(obj);
            do {
                transition = this.this$0;
                this.label = 1;
            } while (MonotonicFrameClockKt.withFrameNanos(new Function1<Long, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j) {
                    if (!transition.isSeeking()) {
                        transition.onFrame$animation_core_release(j / 1);
                    }
                }
            }, this) != coroutine_suspended);
            return coroutine_suspended;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
