package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt", f = "SnapFlingBehavior.kt", i = {0}, l = {300}, m = "animateDecay", n = {"animationState"}, s = {"L$0"})
/* compiled from: SnapFlingBehavior.kt */
final class SnapFlingBehaviorKt$animateDecay$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    SnapFlingBehaviorKt$animateDecay$1(Continuation<? super SnapFlingBehaviorKt$animateDecay$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SnapFlingBehaviorKt.animateDecay((ScrollScope) null, 0.0f, (AnimationState<Float, AnimationVector1D>) null, (DecayAnimationSpec<Float>) null, this);
    }
}
