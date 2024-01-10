package androidx.compose.animation.core;

import androidx.compose.animation.core.InfiniteTransition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: InfiniteTransition.kt */
final class InfiniteTransitionKt$animateValue$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ InfiniteRepeatableSpec<T> $animationSpec;
    final /* synthetic */ T $initialValue;
    final /* synthetic */ T $targetValue;
    final /* synthetic */ InfiniteTransition.TransitionAnimationState<T, V> $transitionAnimation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InfiniteTransitionKt$animateValue$1(T t, InfiniteTransition.TransitionAnimationState<T, V> transitionAnimationState, T t2, InfiniteRepeatableSpec<T> infiniteRepeatableSpec) {
        super(0);
        this.$initialValue = t;
        this.$transitionAnimation = transitionAnimationState;
        this.$targetValue = t2;
        this.$animationSpec = infiniteRepeatableSpec;
    }

    public final void invoke() {
        if (!Intrinsics.areEqual((Object) this.$initialValue, (Object) this.$transitionAnimation.getInitialValue()) || !Intrinsics.areEqual((Object) this.$targetValue, (Object) this.$transitionAnimation.getTargetValue())) {
            this.$transitionAnimation.updateValues(this.$initialValue, this.$targetValue, this.$animationSpec);
        }
    }
}
