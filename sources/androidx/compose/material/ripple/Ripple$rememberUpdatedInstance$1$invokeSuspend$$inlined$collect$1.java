package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Collect.kt */
public final class Ripple$rememberUpdatedInstance$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<Interaction> {
    final /* synthetic */ CoroutineScope $$this$LaunchedEffect$inlined;
    final /* synthetic */ RippleIndicationInstance $instance$inlined;

    public Ripple$rememberUpdatedInstance$1$invokeSuspend$$inlined$collect$1(RippleIndicationInstance rippleIndicationInstance, CoroutineScope coroutineScope) {
        this.$instance$inlined = rippleIndicationInstance;
        this.$$this$LaunchedEffect$inlined = coroutineScope;
    }

    public Object emit(Interaction interaction, Continuation<? super Unit> continuation) {
        Interaction interaction2 = interaction;
        if (interaction2 instanceof PressInteraction.Press) {
            this.$instance$inlined.addRipple((PressInteraction.Press) interaction2, this.$$this$LaunchedEffect$inlined);
        } else if (interaction2 instanceof PressInteraction.Release) {
            this.$instance$inlined.removeRipple(((PressInteraction.Release) interaction2).getPress());
        } else if (interaction2 instanceof PressInteraction.Cancel) {
            this.$instance$inlined.removeRipple(((PressInteraction.Cancel) interaction2).getPress());
        } else {
            this.$instance$inlined.updateStateLayer$material_ripple_release(interaction2, this.$$this$LaunchedEffect$inlined);
        }
        return Unit.INSTANCE;
    }
}
