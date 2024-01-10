package androidx.compose.foundation;

import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.MutableState;
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
@DebugMetadata(c = "androidx.compose.foundation.HoverableKt$hoverable$2$2$1", f = "Hoverable.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Hoverable.kt */
final class HoverableKt$hoverable$2$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableState<HoverInteraction.Enter> $hoverInteraction$delegate;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HoverableKt$hoverable$2$2$1(boolean z, MutableState<HoverInteraction.Enter> mutableState, MutableInteractionSource mutableInteractionSource, Continuation<? super HoverableKt$hoverable$2$2$1> continuation) {
        super(2, continuation);
        this.$enabled = z;
        this.$hoverInteraction$delegate = mutableState;
        this.$interactionSource = mutableInteractionSource;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HoverableKt$hoverable$2$2$1(this.$enabled, this.$hoverInteraction$delegate, this.$interactionSource, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HoverableKt$hoverable$2$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.$enabled) {
                this.label = 1;
                if (HoverableKt$hoverable$2.invoke$emitExit(this.$hoverInteraction$delegate, this.$interactionSource, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
