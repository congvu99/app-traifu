package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.Transition;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\u0004\b\u0002\u0010\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "S", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreviewAnimationClock.kt */
final class PreviewAnimationClock$createTransitionInfo$values$2 extends Lambda implements Function0<Map<Long, T>> {
    final /* synthetic */ long $endTimeMs;
    final /* synthetic */ Lazy<Long> $startTimeMs$delegate;
    final /* synthetic */ long $stepMs;
    final /* synthetic */ Transition<S>.TransitionAnimationState<T, V> $this_createTransitionInfo;
    final /* synthetic */ PreviewAnimationClock this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreviewAnimationClock$createTransitionInfo$values$2(Transition<S>.TransitionAnimationState<T, V> transitionAnimationState, PreviewAnimationClock previewAnimationClock, long j, long j2, Lazy<Long> lazy) {
        super(0);
        this.$this_createTransitionInfo = transitionAnimationState;
        this.this$0 = previewAnimationClock;
        this.$endTimeMs = j;
        this.$stepMs = j2;
        this.$startTimeMs$delegate = lazy;
    }

    public final Map<Long, T> invoke() {
        Map<Long, T> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(Long.valueOf(PreviewAnimationClock.m4607createTransitionInfo$lambda20(this.$startTimeMs$delegate)), this.$this_createTransitionInfo.getAnimation().getValueFromNanos(this.this$0.millisToNanos(PreviewAnimationClock.m4607createTransitionInfo$lambda20(this.$startTimeMs$delegate))));
        linkedHashMap.put(Long.valueOf(this.$endTimeMs), this.$this_createTransitionInfo.getAnimation().getValueFromNanos(this.this$0.millisToNanos(this.$endTimeMs)));
        long r8 = PreviewAnimationClock.m4607createTransitionInfo$lambda20(this.$startTimeMs$delegate);
        long j = this.$stepMs;
        if (j > 0) {
            long progressionLastElement = ProgressionUtilKt.getProgressionLastElement(r8, this.$endTimeMs, j);
            if (r8 <= progressionLastElement) {
                while (true) {
                    linkedHashMap.put(Long.valueOf(r8), this.$this_createTransitionInfo.getAnimation().getValueFromNanos(this.this$0.millisToNanos(r8)));
                    if (r8 == progressionLastElement) {
                        break;
                    }
                    r8 += this.$stepMs;
                }
            }
            return linkedHashMap;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + this.$stepMs + '.');
    }
}
