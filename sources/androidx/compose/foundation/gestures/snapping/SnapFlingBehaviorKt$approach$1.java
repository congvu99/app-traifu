package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt", f = "SnapFlingBehavior.kt", i = {0, 0, 0, 0, 1, 1}, l = {216, 224}, m = "approach", n = {"$this$approach", "animation", "snapLayoutInfoProvider", "density", "remainingOffset", "currentHalfStep"}, s = {"L$0", "L$1", "L$2", "L$3", "F$0", "F$1"})
/* compiled from: SnapFlingBehavior.kt */
final class SnapFlingBehaviorKt$approach$1 extends ContinuationImpl {
    float F$0;
    float F$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    SnapFlingBehaviorKt$approach$1(Continuation<? super SnapFlingBehaviorKt$approach$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SnapFlingBehaviorKt.approach((ScrollScope) null, 0.0f, 0.0f, (ApproachAnimation<Float, AnimationVector1D>) null, (SnapLayoutInfoProvider) null, (Density) null, this);
    }
}
