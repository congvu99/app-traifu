package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "anchors", "", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Swipeable.kt */
final class SwipeableState$performFling$2 implements FlowCollector<Map<Float, ? extends T>> {
    final /* synthetic */ float $velocity;
    final /* synthetic */ SwipeableState<T> this$0;

    SwipeableState$performFling$2(SwipeableState<T> swipeableState, float f) {
        this.this$0 = swipeableState;
        this.$velocity = f;
    }

    public final Object emit(Map<Float, ? extends T> map, Continuation<? super Unit> continuation) {
        Float access$getOffset = SwipeableKt.getOffset(map, this.this$0.getCurrentValue());
        Intrinsics.checkNotNull(access$getOffset);
        float floatValue = access$getOffset.floatValue();
        Object obj = map.get(Boxing.boxFloat(SwipeableKt.computeTarget(this.this$0.getOffset().getValue().floatValue(), floatValue, map.keySet(), this.this$0.getThresholds$material_release(), this.$velocity, this.this$0.getVelocityThreshold$material_release())));
        if (obj == null || !this.this$0.getConfirmStateChange$material_release().invoke(obj).booleanValue()) {
            SwipeableState<T> swipeableState = this.this$0;
            Object access$animateInternalToOffset = swipeableState.animateInternalToOffset(floatValue, swipeableState.getAnimationSpec$material_release(), continuation);
            return access$animateInternalToOffset == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? access$animateInternalToOffset : Unit.INSTANCE;
        }
        Object animateTo$default = SwipeableState.animateTo$default(this.this$0, obj, (AnimationSpec) null, continuation, 2, (Object) null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }
}
