package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntSize;", "S", "Landroidx/compose/animation/core/Transition$Segment;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
final class AnimatedContentScope$SizeModifier$measure$size$1 extends Lambda implements Function1<Transition.Segment<S>, FiniteAnimationSpec<IntSize>> {
    final /* synthetic */ AnimatedContentScope<S> this$0;
    final /* synthetic */ AnimatedContentScope<S>.SizeModifier this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimatedContentScope$SizeModifier$measure$size$1(AnimatedContentScope<S> animatedContentScope, AnimatedContentScope<S>.SizeModifier sizeModifier) {
        super(1);
        this.this$0 = animatedContentScope;
        this.this$1 = sizeModifier;
    }

    public final FiniteAnimationSpec<IntSize> invoke(Transition.Segment<S> segment) {
        Intrinsics.checkNotNullParameter(segment, "$this$animate");
        State state = this.this$0.getTargetSizeMap$animation_release().get(segment.getInitialState());
        IntSize intSize = state == null ? null : (IntSize) state.getValue();
        long r2 = intSize == null ? IntSize.Companion.m4869getZeroYbymL2g() : intSize.m4868unboximpl();
        State state2 = this.this$0.getTargetSizeMap$animation_release().get(segment.getTargetState());
        IntSize intSize2 = state2 == null ? null : (IntSize) state2.getValue();
        long r4 = intSize2 == null ? IntSize.Companion.m4869getZeroYbymL2g() : intSize2.m4868unboximpl();
        SizeTransform value = this.this$1.getSizeTransform().getValue();
        FiniteAnimationSpec<IntSize> r7 = value == null ? null : value.m94createAnimationSpecTemP2vQ(r2, r4);
        return r7 == null ? AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null) : r7;
    }
}
