package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.RepeatableSpec;
import androidx.compose.animation.core.SnapSpec;
import androidx.compose.animation.core.StartOffset;
import androidx.compose.animation.core.StartOffsetType;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004\"\u0004\b\u0002\u0010\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "S", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreviewAnimationClock.kt */
final class PreviewAnimationClock$createTransitionInfo$startTimeMs$2 extends Lambda implements Function0<Long> {
    final /* synthetic */ Transition<S>.TransitionAnimationState<T, V> $this_createTransitionInfo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreviewAnimationClock$createTransitionInfo$startTimeMs$2(Transition<S>.TransitionAnimationState<T, V> transitionAnimationState) {
        super(0);
        this.$this_createTransitionInfo = transitionAnimationState;
    }

    public final Long invoke() {
        long j;
        FiniteAnimationSpec<T> animationSpec = this.$this_createTransitionInfo.getAnimationSpec();
        if (animationSpec instanceof TweenSpec) {
            j = Integer.valueOf(((TweenSpec) animationSpec).getDelay());
        } else if (animationSpec instanceof SnapSpec) {
            j = Integer.valueOf(((SnapSpec) animationSpec).getDelay());
        } else if (animationSpec instanceof KeyframesSpec) {
            j = Integer.valueOf(((KeyframesSpec) animationSpec).getConfig().getDelayMillis());
        } else if (animationSpec instanceof RepeatableSpec) {
            RepeatableSpec repeatableSpec = (RepeatableSpec) animationSpec;
            if (StartOffsetType.m142equalsimpl0(StartOffset.m135getOffsetTypeEo1U57Q(repeatableSpec.m125getInitialStartOffsetRmkjzm4()), StartOffsetType.Companion.m146getDelayEo1U57Q())) {
                j = Integer.valueOf(StartOffset.m134getOffsetMillisimpl(repeatableSpec.m125getInitialStartOffsetRmkjzm4()));
            } else {
                j = 0L;
            }
        } else if (animationSpec instanceof InfiniteRepeatableSpec) {
            InfiniteRepeatableSpec infiniteRepeatableSpec = (InfiniteRepeatableSpec) animationSpec;
            if (StartOffsetType.m142equalsimpl0(StartOffset.m135getOffsetTypeEo1U57Q(infiniteRepeatableSpec.m113getInitialStartOffsetRmkjzm4()), StartOffsetType.Companion.m146getDelayEo1U57Q())) {
                j = Integer.valueOf(StartOffset.m134getOffsetMillisimpl(infiniteRepeatableSpec.m113getInitialStartOffsetRmkjzm4()));
            } else {
                j = 0L;
            }
        } else if (animationSpec instanceof VectorizedDurationBasedAnimationSpec) {
            j = Integer.valueOf(((VectorizedDurationBasedAnimationSpec) animationSpec).getDelayMillis());
        } else {
            j = 0L;
        }
        return Long.valueOf(j.longValue());
    }
}
