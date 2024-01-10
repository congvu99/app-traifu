package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ5\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011JA\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/gestures/snapping/DecayApproachAnimation;", "Landroidx/compose/foundation/gestures/snapping/ApproachAnimation;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/ui/unit/Density;)V", "approachAnimation", "Landroidx/compose/animation/core/AnimationState;", "scope", "Landroidx/compose/foundation/gestures/ScrollScope;", "offset", "velocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "halfStepAnimation", "previousAnimationState", "(Landroidx/compose/foundation/gestures/ScrollScope;FLandroidx/compose/animation/core/AnimationState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SnapFlingBehavior.kt */
final class DecayApproachAnimation implements ApproachAnimation<Float, AnimationVector1D> {
    private final DecayAnimationSpec<Float> decayAnimationSpec;
    private final Density density;
    private final SnapLayoutInfoProvider snapLayoutInfoProvider;

    public DecayApproachAnimation(DecayAnimationSpec<Float> decayAnimationSpec2, SnapLayoutInfoProvider snapLayoutInfoProvider2, Density density2) {
        Intrinsics.checkNotNullParameter(decayAnimationSpec2, "decayAnimationSpec");
        Intrinsics.checkNotNullParameter(snapLayoutInfoProvider2, "snapLayoutInfoProvider");
        Intrinsics.checkNotNullParameter(density2, "density");
        this.decayAnimationSpec = decayAnimationSpec2;
        this.snapLayoutInfoProvider = snapLayoutInfoProvider2;
        this.density = density2;
    }

    public /* bridge */ /* synthetic */ Object approachAnimation(ScrollScope scrollScope, Object obj, Object obj2, Continuation continuation) {
        return approachAnimation(scrollScope, ((Number) obj).floatValue(), ((Number) obj2).floatValue(), (Continuation<? super AnimationState<Float, AnimationVector1D>>) continuation);
    }

    public /* bridge */ /* synthetic */ Object halfStepAnimation(ScrollScope scrollScope, Object obj, AnimationState animationState, Continuation continuation) {
        return halfStepAnimation(scrollScope, ((Number) obj).floatValue(), (AnimationState<Float, AnimationVector1D>) animationState, (Continuation<? super AnimationState<Float, AnimationVector1D>>) continuation);
    }

    public Object approachAnimation(ScrollScope scrollScope, float f, float f2, Continuation<? super AnimationState<Float, AnimationVector1D>> continuation) {
        Object access$animateDecay = SnapFlingBehaviorKt.animateDecay(scrollScope, f, AnimationStateKt.AnimationState$default(0.0f, f2, 0, 0, false, 28, (Object) null), this.decayAnimationSpec, continuation);
        return access$animateDecay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? access$animateDecay : (AnimationState) access$animateDecay;
    }

    public Object halfStepAnimation(ScrollScope scrollScope, float f, AnimationState<Float, AnimationVector1D> animationState, Continuation<? super AnimationState<Float, AnimationVector1D>> continuation) {
        AnimationState copy$default = AnimationStateKt.copy$default((AnimationState) animationState, 0.0f, 0.0f, 0, 0, false, 30, (Object) null);
        Object access$animateDecay = SnapFlingBehaviorKt.animateDecay(scrollScope, SnapFlingBehaviorKt.halfStep(this.snapLayoutInfoProvider, this.density) * Math.signum(((Number) copy$default.getVelocity()).floatValue()), copy$default, this.decayAnimationSpec, continuation);
        return access$animateDecay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? access$animateDecay : (AnimationState) access$animateDecay;
    }
}
