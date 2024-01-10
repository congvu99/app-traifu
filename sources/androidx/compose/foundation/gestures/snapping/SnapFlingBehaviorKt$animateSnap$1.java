package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt", f = "SnapFlingBehavior.kt", i = {0, 0}, l = {330}, m = "animateSnap", n = {"animationState", "initialVelocity"}, s = {"L$0", "F$0"})
/* compiled from: SnapFlingBehavior.kt */
final class SnapFlingBehaviorKt$animateSnap$1 extends ContinuationImpl {
    float F$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    SnapFlingBehaviorKt$animateSnap$1(Continuation<? super SnapFlingBehaviorKt$animateSnap$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SnapFlingBehaviorKt.animateSnap((ScrollScope) null, 0.0f, 0.0f, (AnimationState<Float, AnimationVector1D>) null, (AnimationSpec<Float>) null, this);
    }
}
