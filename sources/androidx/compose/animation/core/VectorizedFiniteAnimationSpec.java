package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "isInfinite", "", "()Z", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VectorizedAnimationSpec.kt */
public interface VectorizedFiniteAnimationSpec<V extends AnimationVector> extends VectorizedAnimationSpec<V> {
    boolean isInfinite();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VectorizedAnimationSpec.kt */
    public static final class DefaultImpls {
        public static <V extends AnimationVector> boolean isInfinite(VectorizedFiniteAnimationSpec<V> vectorizedFiniteAnimationSpec) {
            Intrinsics.checkNotNullParameter(vectorizedFiniteAnimationSpec, "this");
            return false;
        }

        public static <V extends AnimationVector> V getEndVelocity(VectorizedFiniteAnimationSpec<V> vectorizedFiniteAnimationSpec, V v, V v2, V v3) {
            Intrinsics.checkNotNullParameter(vectorizedFiniteAnimationSpec, "this");
            Intrinsics.checkNotNullParameter(v, "initialValue");
            Intrinsics.checkNotNullParameter(v2, "targetValue");
            Intrinsics.checkNotNullParameter(v3, "initialVelocity");
            return VectorizedAnimationSpec.DefaultImpls.getEndVelocity(vectorizedFiniteAnimationSpec, v, v2, v3);
        }
    }
}
