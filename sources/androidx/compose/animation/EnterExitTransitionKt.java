package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aT\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001aT\u0010\u001b\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b0\u0016H\u0007ø\u0001\u0000\u001aT\u0010\u001f\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u0010\u0011\u001a\u00020 2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a\"\u0010#\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010$\u001a\u00020\u0002H\u0007\u001a\"\u0010%\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010'\u001a\u00020\u0002H\u0007\u001a9\u0010(\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,\u001a9\u0010-\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010.\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100\u001aT\u00101\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u00102\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u00103\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001aT\u00104\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u00102\u001a\u00020\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u00105\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b0\u0016H\u0007ø\u0001\u0000\u001aT\u00106\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u00102\u001a\u00020 2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u00107\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a>\u00108\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102!\u00109\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00060\u0016H\u0007ø\u0001\u0000\u001a@\u0010:\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a@\u0010<\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010=\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a>\u0010>\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102!\u0010?\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00060\u0016H\u0007ø\u0001\u0000\u001a@\u0010@\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010A\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a@\u0010B\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010C\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a/\u0010D\u001a\u00020E*\b\u0012\u0004\u0012\u00020G0F2\u0006\u0010H\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020&2\u0006\u0010J\u001a\u00020KH\u0001¢\u0006\u0002\u0010L\u001aB\u0010M\u001a\u00020E*\u00020E2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020G0F2\u000e\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q0P2\u000e\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q0P2\u0006\u0010S\u001a\u00020KH\u0002\u001aB\u0010T\u001a\u00020E*\u00020E2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020G0F2\u000e\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0P2\u000e\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0P2\u0006\u0010S\u001a\u00020KH\u0002\u001a\f\u0010V\u001a\u00020\u001c*\u00020\u0012H\u0002\u001a\f\u0010V\u001a\u00020\u001c*\u00020 H\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006W"}, d2 = {"DefaultAlpha", "Landroidx/compose/runtime/MutableState;", "", "DefaultAlphaAndScaleSpring", "Landroidx/compose/animation/core/SpringSpec;", "DefaultOffsetAnimationSpec", "Landroidx/compose/ui/unit/IntOffset;", "DefaultSizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "TransformOriginVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/graphics/TransformOrigin;", "Landroidx/compose/animation/core/AnimationVector2D;", "expandHorizontally", "Landroidx/compose/animation/EnterTransition;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "expandFrom", "Landroidx/compose/ui/Alignment$Horizontal;", "clip", "", "initialWidth", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "fullWidth", "expandIn", "Landroidx/compose/ui/Alignment;", "initialSize", "fullSize", "expandVertically", "Landroidx/compose/ui/Alignment$Vertical;", "initialHeight", "fullHeight", "fadeIn", "initialAlpha", "fadeOut", "Landroidx/compose/animation/ExitTransition;", "targetAlpha", "scaleIn", "initialScale", "transformOrigin", "scaleIn-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/EnterTransition;", "scaleOut", "targetScale", "scaleOut-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/ExitTransition;", "shrinkHorizontally", "shrinkTowards", "targetWidth", "shrinkOut", "targetSize", "shrinkVertically", "targetHeight", "slideIn", "initialOffset", "slideInHorizontally", "initialOffsetX", "slideInVertically", "initialOffsetY", "slideOut", "targetOffset", "slideOutHorizontally", "targetOffsetX", "slideOutVertically", "targetOffsetY", "createModifier", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "enter", "exit", "label", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "shrinkExpand", "transition", "expand", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/ChangeSize;", "shrink", "labelPrefix", "slideInOut", "Landroidx/compose/animation/Slide;", "toAlignment", "animation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
public final class EnterExitTransitionKt {
    private static final MutableState<Float> DefaultAlpha = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
    /* access modifiers changed from: private */
    public static final SpringSpec<Float> DefaultAlphaAndScaleSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
    /* access modifiers changed from: private */
    public static final SpringSpec<IntOffset> DefaultOffsetAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m4813boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
    /* access modifiers changed from: private */
    public static final SpringSpec<IntSize> DefaultSizeAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m4856boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
    private static final TwoWayConverter<TransformOrigin, AnimationVector2D> TransformOriginVectorConverter = VectorConvertersKt.TwoWayConverter(EnterExitTransitionKt$TransformOriginVectorConverter$1.INSTANCE, EnterExitTransitionKt$TransformOriginVectorConverter$2.INSTANCE);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EnterExitTransition.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnterExitState.values().length];
            iArr[EnterExitState.Visible.ordinal()] = 1;
            iArr[EnterExitState.PreEnter.ordinal()] = 2;
            iArr[EnterExitState.PostExit.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ EnterTransition fadeIn$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeIn(finiteAnimationSpec, f);
    }

    public static final EnterTransition fadeIn(FiniteAnimationSpec<Float> finiteAnimationSpec, float f) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        return new EnterTransitionImpl(new TransitionData(new Fade(f, finiteAnimationSpec), (Slide) null, (ChangeSize) null, (Scale) null, 14, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ ExitTransition fadeOut$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeOut(finiteAnimationSpec, f);
    }

    public static final ExitTransition fadeOut(FiniteAnimationSpec<Float> finiteAnimationSpec, float f) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        return new ExitTransitionImpl(new TransitionData(new Fade(f, finiteAnimationSpec), (Slide) null, (ChangeSize) null, (Scale) null, 14, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ EnterTransition slideIn$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m4813boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        return slideIn(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideIn(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super IntSize, IntOffset> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "initialOffset");
        return new EnterTransitionImpl(new TransitionData((Fade) null, new Slide(function1, finiteAnimationSpec), (ChangeSize) null, (Scale) null, 13, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ ExitTransition slideOut$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m4813boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        return slideOut(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOut(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super IntSize, IntOffset> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "targetOffset");
        return new ExitTransitionImpl(new TransitionData((Fade) null, new Slide(function1, finiteAnimationSpec), (ChangeSize) null, (Scale) null, 13, (DefaultConstructorMarker) null));
    }

    /* renamed from: scaleIn-L8ZKh-E$default  reason: not valid java name */
    public static /* synthetic */ EnterTransition m57scaleInL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.Companion.m2326getCenterSzJe1aQ();
        }
        return m56scaleInL8ZKhE(finiteAnimationSpec, f, j);
    }

    @ExperimentalAnimationApi
    /* renamed from: scaleIn-L8ZKh-E  reason: not valid java name */
    public static final EnterTransition m56scaleInL8ZKhE(FiniteAnimationSpec<Float> finiteAnimationSpec, float f, long j) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        return new EnterTransitionImpl(new TransitionData((Fade) null, (Slide) null, (ChangeSize) null, new Scale(f, j, finiteAnimationSpec, (DefaultConstructorMarker) null), 7, (DefaultConstructorMarker) null));
    }

    /* renamed from: scaleOut-L8ZKh-E$default  reason: not valid java name */
    public static /* synthetic */ ExitTransition m59scaleOutL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.Companion.m2326getCenterSzJe1aQ();
        }
        return m58scaleOutL8ZKhE(finiteAnimationSpec, f, j);
    }

    @ExperimentalAnimationApi
    /* renamed from: scaleOut-L8ZKh-E  reason: not valid java name */
    public static final ExitTransition m58scaleOutL8ZKhE(FiniteAnimationSpec<Float> finiteAnimationSpec, float f, long j) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        return new ExitTransitionImpl(new TransitionData((Fade) null, (Slide) null, (ChangeSize) null, new Scale(f, j, finiteAnimationSpec, (DefaultConstructorMarker) null), 7, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ EnterTransition expandIn$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m4856boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.Companion.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$expandIn$1.INSTANCE;
        }
        return expandIn(finiteAnimationSpec, alignment, z, function1);
    }

    public static final EnterTransition expandIn(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment alignment, boolean z, Function1<? super IntSize, IntSize> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(alignment, "expandFrom");
        Intrinsics.checkNotNullParameter(function1, "initialSize");
        return new EnterTransitionImpl(new TransitionData((Fade) null, (Slide) null, new ChangeSize(alignment, function1, finiteAnimationSpec, z), (Scale) null, 11, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ ExitTransition shrinkOut$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m4856boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.Companion.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$shrinkOut$1.INSTANCE;
        }
        return shrinkOut(finiteAnimationSpec, alignment, z, function1);
    }

    public static final ExitTransition shrinkOut(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment alignment, boolean z, Function1<? super IntSize, IntSize> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(alignment, "shrinkTowards");
        Intrinsics.checkNotNullParameter(function1, "targetSize");
        return new ExitTransitionImpl(new TransitionData((Fade) null, (Slide) null, new ChangeSize(alignment, function1, finiteAnimationSpec, z), (Scale) null, 11, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ EnterTransition expandHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m4856boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.Companion.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$expandHorizontally$1.INSTANCE;
        }
        return expandHorizontally(finiteAnimationSpec, horizontal, z, function1);
    }

    public static final EnterTransition expandHorizontally(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(horizontal, "expandFrom");
        Intrinsics.checkNotNullParameter(function1, "initialWidth");
        return expandIn(finiteAnimationSpec, toAlignment(horizontal), z, new EnterExitTransitionKt$expandHorizontally$2(function1));
    }

    public static /* synthetic */ EnterTransition expandVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m4856boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.Companion.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$expandVertically$1.INSTANCE;
        }
        return expandVertically(finiteAnimationSpec, vertical, z, function1);
    }

    public static final EnterTransition expandVertically(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(vertical, "expandFrom");
        Intrinsics.checkNotNullParameter(function1, "initialHeight");
        return expandIn(finiteAnimationSpec, toAlignment(vertical), z, new EnterExitTransitionKt$expandVertically$2(function1));
    }

    public static /* synthetic */ ExitTransition shrinkHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m4856boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.Companion.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$shrinkHorizontally$1.INSTANCE;
        }
        return shrinkHorizontally(finiteAnimationSpec, horizontal, z, function1);
    }

    public static final ExitTransition shrinkHorizontally(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(horizontal, "shrinkTowards");
        Intrinsics.checkNotNullParameter(function1, "targetWidth");
        return shrinkOut(finiteAnimationSpec, toAlignment(horizontal), z, new EnterExitTransitionKt$shrinkHorizontally$2(function1));
    }

    public static /* synthetic */ ExitTransition shrinkVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m4856boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.Companion.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = EnterExitTransitionKt$shrinkVertically$1.INSTANCE;
        }
        return shrinkVertically(finiteAnimationSpec, vertical, z, function1);
    }

    public static final ExitTransition shrinkVertically(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(vertical, "shrinkTowards");
        Intrinsics.checkNotNullParameter(function1, "targetHeight");
        return shrinkOut(finiteAnimationSpec, toAlignment(vertical), z, new EnterExitTransitionKt$shrinkVertically$2(function1));
    }

    public static /* synthetic */ EnterTransition slideInHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m4813boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            function1 = EnterExitTransitionKt$slideInHorizontally$1.INSTANCE;
        }
        return slideInHorizontally(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideInHorizontally(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "initialOffsetX");
        return slideIn(finiteAnimationSpec, new EnterExitTransitionKt$slideInHorizontally$2(function1));
    }

    public static /* synthetic */ EnterTransition slideInVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m4813boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            function1 = EnterExitTransitionKt$slideInVertically$1.INSTANCE;
        }
        return slideInVertically(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideInVertically(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "initialOffsetY");
        return slideIn(finiteAnimationSpec, new EnterExitTransitionKt$slideInVertically$2(function1));
    }

    public static /* synthetic */ ExitTransition slideOutHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m4813boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            function1 = EnterExitTransitionKt$slideOutHorizontally$1.INSTANCE;
        }
        return slideOutHorizontally(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOutHorizontally(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "targetOffsetX");
        return slideOut(finiteAnimationSpec, new EnterExitTransitionKt$slideOutHorizontally$2(function1));
    }

    public static /* synthetic */ ExitTransition slideOutVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m4813boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            function1 = EnterExitTransitionKt$slideOutVertically$1.INSTANCE;
        }
        return slideOutVertically(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOutVertically(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "targetOffsetY");
        return slideOut(finiteAnimationSpec, new EnterExitTransitionKt$slideOutVertically$2(function1));
    }

    private static final Alignment toAlignment(Alignment.Horizontal horizontal) {
        if (Intrinsics.areEqual((Object) horizontal, (Object) Alignment.Companion.getStart())) {
            return Alignment.Companion.getCenterStart();
        }
        if (Intrinsics.areEqual((Object) horizontal, (Object) Alignment.Companion.getEnd())) {
            return Alignment.Companion.getCenterEnd();
        }
        return Alignment.Companion.getCenter();
    }

    private static final Alignment toAlignment(Alignment.Vertical vertical) {
        if (Intrinsics.areEqual((Object) vertical, (Object) Alignment.Companion.getTop())) {
            return Alignment.Companion.getTopCenter();
        }
        if (Intrinsics.areEqual((Object) vertical, (Object) Alignment.Companion.getBottom())) {
            return Alignment.Companion.getBottomCenter();
        }
        return Alignment.Companion.getCenter();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: androidx.compose.runtime.MutableState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: androidx.compose.runtime.MutableState} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x03e2  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0438  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x049c  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x049f  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x04a6  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x04ca  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x052f  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0536  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0349  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x03b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.Modifier createModifier(androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r31, androidx.compose.animation.EnterTransition r32, androidx.compose.animation.ExitTransition r33, java.lang.String r34, androidx.compose.runtime.Composer r35, int r36) {
        /*
            r8 = r31
            r9 = r32
            r10 = r33
            r11 = r34
            r12 = r35
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "enter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "exit"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "label"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 1657239113(0x62c77649, float:1.8397127E21)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "C(createModifier)806@35287L38,807@35335L37,811@35430L43,812@35483L42,819@35854L40,820@35925L40,867@37800L27,857@37277L800,883@38570L536:EnterExitTransition.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.animation.TransitionData r1 = r32.getData$animation_release()
            androidx.compose.animation.Slide r1 = r1.getSlide()
            r2 = 0
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r1, r12, r2)
            androidx.compose.animation.TransitionData r4 = r33.getData$animation_release()
            androidx.compose.animation.Slide r4 = r4.getSlide()
            androidx.compose.runtime.State r4 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r4, r12, r2)
            androidx.compose.ui.Modifier r0 = slideInOut(r0, r8, r1, r4, r11)
            androidx.compose.animation.TransitionData r1 = r32.getData$animation_release()
            androidx.compose.animation.ChangeSize r1 = r1.getChangeSize()
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r1, r12, r2)
            androidx.compose.animation.TransitionData r4 = r33.getData$animation_release()
            androidx.compose.animation.ChangeSize r4 = r4.getChangeSize()
            androidx.compose.runtime.State r4 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r4, r12, r2)
            androidx.compose.ui.Modifier r13 = shrinkExpand(r0, r8, r1, r4, r11)
            r14 = r36 & 14
            r0 = -3686930(0xffffffffffc7bdee, float:NaN)
            r12.startReplaceableGroup(r0)
            java.lang.String r1 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            boolean r4 = r12.changed((java.lang.Object) r8)
            java.lang.Object r5 = r35.rememberedValue()
            r15 = 2
            r7 = 0
            if (r4 != 0) goto L_0x008b
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x0092
        L_0x008b:
            androidx.compose.runtime.MutableState r5 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r3, r7, r15, r7)
            r12.updateRememberedValue(r5)
        L_0x0092:
            r35.endReplaceableGroup()
            r6 = r5
            androidx.compose.runtime.MutableState r6 = (androidx.compose.runtime.MutableState) r6
            r12.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            boolean r0 = r12.changed((java.lang.Object) r8)
            java.lang.Object r1 = r35.rememberedValue()
            if (r0 != 0) goto L_0x00b0
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x00b7
        L_0x00b0:
            androidx.compose.runtime.MutableState r1 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r3, r7, r15, r7)
            r12.updateRememberedValue(r1)
        L_0x00b7:
            r35.endReplaceableGroup()
            r5 = r1
            androidx.compose.runtime.MutableState r5 = (androidx.compose.runtime.MutableState) r5
            java.lang.Object r0 = r31.getCurrentState()
            java.lang.Object r1 = r31.getTargetState()
            r4 = 1
            if (r0 != r1) goto L_0x00d5
            boolean r0 = r31.isSeeking()
            if (r0 != 0) goto L_0x00d5
            m52createModifier$lambda2(r6, r2)
            m54createModifier$lambda5(r5, r2)
            goto L_0x0103
        L_0x00d5:
            androidx.compose.animation.TransitionData r0 = r32.getData$animation_release()
            androidx.compose.animation.Fade r0 = r0.getFade()
            if (r0 != 0) goto L_0x00e9
            androidx.compose.animation.TransitionData r0 = r33.getData$animation_release()
            androidx.compose.animation.Fade r0 = r0.getFade()
            if (r0 == 0) goto L_0x00ec
        L_0x00e9:
            m52createModifier$lambda2(r6, r4)
        L_0x00ec:
            androidx.compose.animation.TransitionData r0 = r32.getData$animation_release()
            androidx.compose.animation.Scale r0 = r0.getScale()
            if (r0 != 0) goto L_0x0100
            androidx.compose.animation.TransitionData r0 = r33.getData$animation_release()
            androidx.compose.animation.Scale r0 = r0.getScale()
            if (r0 == 0) goto L_0x0103
        L_0x0100:
            m54createModifier$lambda5(r5, r4)
        L_0x0103:
            r0 = 1657240548(0x62c77be4, float:1.8399147E21)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "844@36909L27,834@36388L796"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            boolean r0 = m49createModifier$lambda1(r6)
            java.lang.String r3 = "C(animateFloat)P(2)925@36712L78:Transition.kt#pdpnli"
            java.lang.String r1 = "C(remember):Composables.kt#9igjgp"
            r16 = 458752(0x70000, float:6.42848E-40)
            java.lang.String r4 = "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli"
            r19 = 57344(0xe000, float:8.0356E-41)
            java.lang.String r2 = "C:EnterExitTransition.kt#xbi5r1"
            r21 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto L_0x026f
            androidx.compose.animation.EnterExitTransitionKt$createModifier$alpha$2 r0 = new androidx.compose.animation.EnterExitTransitionKt$createModifier$alpha$2
            r0.<init>(r9, r10)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r7 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r12.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            java.lang.Object r7 = r35.rememberedValue()
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r23.getEmpty()
            if (r7 != r15) goto L_0x0148
            java.lang.String r7 = " alpha"
            java.lang.String r7 = kotlin.jvm.internal.Intrinsics.stringPlus(r11, r7)
            r12.updateRememberedValue(r7)
        L_0x0148:
            r35.endReplaceableGroup()
            java.lang.String r7 = (java.lang.String) r7
            r15 = r14 | 384(0x180, float:5.38E-43)
            r23 = r5
            r5 = 1399891485(0x5370a61d, float:1.03357907E12)
            r12.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r3)
            kotlin.jvm.internal.FloatCompanionObject r18 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r18 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r18)
            r25 = r15 & 14
            r24 = 3
            int r15 = r15 << 3
            r5 = r15 & 896(0x380, float:1.256E-42)
            r5 = r25 | r5
            r25 = r1
            r1 = r15 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r5
            r5 = r15 & r19
            r1 = r1 | r5
            r5 = 1847725064(0x6e220c08, float:1.2537779E28)
            r12.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r4)
            java.lang.Object r15 = r31.getCurrentState()
            androidx.compose.animation.EnterExitState r15 = (androidx.compose.animation.EnterExitState) r15
            r5 = -9519786(0xffffffffff6ebd56, float:-3.1733935E38)
            r12.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r2)
            int[] r5 = androidx.compose.animation.EnterExitTransitionKt.WhenMappings.$EnumSwitchMapping$0
            int r15 = r15.ordinal()
            r5 = r5[r15]
            r15 = 1
            if (r5 == r15) goto L_0x01c1
            r15 = 2
            if (r5 == r15) goto L_0x01b1
            r15 = 3
            if (r5 != r15) goto L_0x01ab
            androidx.compose.animation.TransitionData r5 = r33.getData$animation_release()
            androidx.compose.animation.Fade r5 = r5.getFade()
            if (r5 != 0) goto L_0x01a6
            goto L_0x01c1
        L_0x01a6:
            float r5 = r5.getAlpha()
            goto L_0x01c3
        L_0x01ab:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x01b1:
            androidx.compose.animation.TransitionData r5 = r32.getData$animation_release()
            androidx.compose.animation.Fade r5 = r5.getFade()
            if (r5 != 0) goto L_0x01bc
            goto L_0x01c1
        L_0x01bc:
            float r5 = r5.getAlpha()
            goto L_0x01c3
        L_0x01c1:
            r5 = 1065353216(0x3f800000, float:1.0)
        L_0x01c3:
            r35.endReplaceableGroup()
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            java.lang.Object r15 = r31.getTargetState()
            androidx.compose.animation.EnterExitState r15 = (androidx.compose.animation.EnterExitState) r15
            r26 = r3
            r3 = -9519786(0xffffffffff6ebd56, float:-3.1733935E38)
            r12.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r2)
            int[] r3 = androidx.compose.animation.EnterExitTransitionKt.WhenMappings.$EnumSwitchMapping$0
            int r15 = r15.ordinal()
            r3 = r3[r15]
            r15 = 1
            if (r3 == r15) goto L_0x0212
            r15 = 2
            if (r3 == r15) goto L_0x0202
            r15 = 3
            if (r3 != r15) goto L_0x01fc
            androidx.compose.animation.TransitionData r3 = r33.getData$animation_release()
            androidx.compose.animation.Fade r3 = r3.getFade()
            if (r3 != 0) goto L_0x01f7
            goto L_0x0212
        L_0x01f7:
            float r3 = r3.getAlpha()
            goto L_0x0214
        L_0x01fc:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0202:
            androidx.compose.animation.TransitionData r3 = r32.getData$animation_release()
            androidx.compose.animation.Fade r3 = r3.getFade()
            if (r3 != 0) goto L_0x020d
            goto L_0x0212
        L_0x020d:
            float r3 = r3.getAlpha()
            goto L_0x0214
        L_0x0212:
            r3 = 1065353216(0x3f800000, float:1.0)
        L_0x0214:
            r35.endReplaceableGroup()
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            androidx.compose.animation.core.Transition$Segment r15 = r31.getSegment()
            int r27 = r1 >> 3
            r27 = r27 & 112(0x70, float:1.57E-43)
            r28 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r27)
            java.lang.Object r0 = r0.invoke(r15, r12, r2)
            r15 = r0
            androidx.compose.animation.core.FiniteAnimationSpec r15 = (androidx.compose.animation.core.FiniteAnimationSpec) r15
            r0 = r1 & 14
            int r2 = r1 << 9
            r2 = r2 & r19
            r0 = r0 | r2
            int r1 = r1 << 6
            r1 = r1 & r16
            r27 = r0 | r1
            r0 = r31
            r2 = r25
            r1 = r5
            r8 = r2
            r20 = r13
            r29 = r28
            r5 = 1399891485(0x5370a61d, float:1.03357907E12)
            r13 = 1847725064(0x6e220c08, float:1.2537779E28)
            r2 = r3
            r13 = r26
            r3 = r15
            r15 = r4
            r4 = r18
            r18 = r15
            r17 = r23
            r15 = 1399891485(0x5370a61d, float:1.03357907E12)
            r5 = r7
            r23 = r6
            r6 = r35
            r22 = 0
            r7 = r27
            androidx.compose.runtime.State r0 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r0, r1, r2, r3, r4, r5, r6, r7)
            r35.endReplaceableGroup()
            r35.endReplaceableGroup()
            goto L_0x0284
        L_0x026f:
            r8 = r1
            r29 = r2
            r18 = r4
            r17 = r5
            r23 = r6
            r22 = r7
            r20 = r13
            r15 = 1399891485(0x5370a61d, float:1.03357907E12)
            r13 = r3
            androidx.compose.runtime.MutableState<java.lang.Float> r0 = DefaultAlpha
            androidx.compose.runtime.State r0 = (androidx.compose.runtime.State) r0
        L_0x0284:
            r7 = r0
            r35.endReplaceableGroup()
            boolean r0 = m53createModifier$lambda4(r17)
            if (r0 == 0) goto L_0x0582
            androidx.compose.animation.EnterExitTransitionKt$createModifier$scale$2 r0 = new androidx.compose.animation.EnterExitTransitionKt$createModifier$scale$2
            r0.<init>(r9, r10)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r1 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r12.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r8)
            java.lang.Object r1 = r35.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x02b3
            java.lang.String r1 = " scale"
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r11, r1)
            r12.updateRememberedValue(r1)
        L_0x02b3:
            r35.endReplaceableGroup()
            r5 = r1
            java.lang.String r5 = (java.lang.String) r5
            r1 = r14 | 384(0x180, float:5.38E-43)
            r12.startReplaceableGroup(r15)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r13)
            kotlin.jvm.internal.FloatCompanionObject r2 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r4 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r2)
            r2 = r1 & 14
            r3 = 3
            int r1 = r1 << r3
            r3 = r1 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            r3 = r1 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            r1 = r1 & r19
            r1 = r1 | r2
            r2 = 1847725064(0x6e220c08, float:1.2537779E28)
            r12.startReplaceableGroup(r2)
            r8 = r18
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r8)
            java.lang.Object r2 = r31.getCurrentState()
            androidx.compose.animation.EnterExitState r2 = (androidx.compose.animation.EnterExitState) r2
            r3 = -9518895(0xffffffffff6ec0d1, float:-3.1735742E38)
            r12.startReplaceableGroup(r3)
            r11 = r29
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r11)
            int[] r3 = androidx.compose.animation.EnterExitTransitionKt.WhenMappings.$EnumSwitchMapping$0
            int r2 = r2.ordinal()
            r2 = r3[r2]
            r13 = 1
            if (r2 == r13) goto L_0x0327
            r3 = 2
            if (r2 == r3) goto L_0x0317
            r3 = 3
            if (r2 != r3) goto L_0x0311
            androidx.compose.animation.TransitionData r2 = r33.getData$animation_release()
            androidx.compose.animation.Scale r2 = r2.getScale()
            if (r2 != 0) goto L_0x030c
            goto L_0x0327
        L_0x030c:
            float r2 = r2.getScale()
            goto L_0x0329
        L_0x0311:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0317:
            androidx.compose.animation.TransitionData r2 = r32.getData$animation_release()
            androidx.compose.animation.Scale r2 = r2.getScale()
            if (r2 != 0) goto L_0x0322
            goto L_0x0327
        L_0x0322:
            float r2 = r2.getScale()
            goto L_0x0329
        L_0x0327:
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x0329:
            r35.endReplaceableGroup()
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            java.lang.Object r3 = r31.getTargetState()
            androidx.compose.animation.EnterExitState r3 = (androidx.compose.animation.EnterExitState) r3
            r6 = -9518895(0xffffffffff6ec0d1, float:-3.1735742E38)
            r12.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r11)
            int[] r6 = androidx.compose.animation.EnterExitTransitionKt.WhenMappings.$EnumSwitchMapping$0
            int r3 = r3.ordinal()
            r3 = r6[r3]
            if (r3 == r13) goto L_0x0374
            r6 = 2
            if (r3 == r6) goto L_0x0365
            r6 = 3
            if (r3 != r6) goto L_0x035f
            androidx.compose.animation.TransitionData r3 = r33.getData$animation_release()
            androidx.compose.animation.Scale r3 = r3.getScale()
            if (r3 != 0) goto L_0x035a
            goto L_0x0374
        L_0x035a:
            float r21 = r3.getScale()
            goto L_0x0374
        L_0x035f:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0365:
            androidx.compose.animation.TransitionData r3 = r32.getData$animation_release()
            androidx.compose.animation.Scale r3 = r3.getScale()
            if (r3 != 0) goto L_0x0370
            goto L_0x0374
        L_0x0370:
            float r21 = r3.getScale()
        L_0x0374:
            r35.endReplaceableGroup()
            java.lang.Float r3 = java.lang.Float.valueOf(r21)
            androidx.compose.animation.core.Transition$Segment r6 = r31.getSegment()
            int r15 = r1 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            java.lang.Object r0 = r0.invoke(r6, r12, r15)
            r6 = r0
            androidx.compose.animation.core.FiniteAnimationSpec r6 = (androidx.compose.animation.core.FiniteAnimationSpec) r6
            r0 = r1 & 14
            int r15 = r1 << 9
            r15 = r15 & r19
            r0 = r0 | r15
            int r1 = r1 << 6
            r1 = r1 & r16
            r15 = r0 | r1
            r0 = r31
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r35
            r30 = r7
            r7 = r15
            androidx.compose.runtime.State r15 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r0, r1, r2, r3, r4, r5, r6, r7)
            r35.endReplaceableGroup()
            r35.endReplaceableGroup()
            java.lang.Object r0 = r31.getCurrentState()
            androidx.compose.animation.EnterExitState r1 = androidx.compose.animation.EnterExitState.PreEnter
            if (r0 != r1) goto L_0x03e2
            androidx.compose.animation.TransitionData r0 = r32.getData$animation_release()
            androidx.compose.animation.Scale r0 = r0.getScale()
            if (r0 != 0) goto L_0x03c4
            r7 = r22
            goto L_0x03cc
        L_0x03c4:
            long r0 = r0.m84getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r7 = androidx.compose.ui.graphics.TransformOrigin.m2313boximpl(r0)
        L_0x03cc:
            if (r7 != 0) goto L_0x040e
            androidx.compose.animation.TransitionData r0 = r33.getData$animation_release()
            androidx.compose.animation.Scale r0 = r0.getScale()
            if (r0 != 0) goto L_0x03d9
            goto L_0x0403
        L_0x03d9:
            long r0 = r0.m84getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r7 = androidx.compose.ui.graphics.TransformOrigin.m2313boximpl(r0)
            goto L_0x040e
        L_0x03e2:
            androidx.compose.animation.TransitionData r0 = r33.getData$animation_release()
            androidx.compose.animation.Scale r0 = r0.getScale()
            if (r0 != 0) goto L_0x03ef
            r7 = r22
            goto L_0x03f7
        L_0x03ef:
            long r0 = r0.m84getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r7 = androidx.compose.ui.graphics.TransformOrigin.m2313boximpl(r0)
        L_0x03f7:
            if (r7 != 0) goto L_0x040e
            androidx.compose.animation.TransitionData r0 = r32.getData$animation_release()
            androidx.compose.animation.Scale r0 = r0.getScale()
            if (r0 != 0) goto L_0x0406
        L_0x0403:
            r7 = r22
            goto L_0x040e
        L_0x0406:
            long r0 = r0.m84getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r7 = androidx.compose.ui.graphics.TransformOrigin.m2313boximpl(r0)
        L_0x040e:
            androidx.compose.animation.core.TwoWayConverter<androidx.compose.ui.graphics.TransformOrigin, androidx.compose.animation.core.AnimationVector2D> r4 = TransformOriginVectorConverter
            r0 = r14 | 3136(0xc40, float:4.394E-42)
            r1 = 1847725064(0x6e220c08, float:1.2537779E28)
            r12.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r8)
            androidx.compose.animation.EnterExitTransitionKt$createModifier$$inlined$animateValue$1 r1 = androidx.compose.animation.EnterExitTransitionKt$createModifier$$inlined$animateValue$1.INSTANCE
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            java.lang.Object r2 = r31.getCurrentState()
            androidx.compose.animation.EnterExitState r2 = (androidx.compose.animation.EnterExitState) r2
            r3 = -9518037(0xffffffffff6ec42b, float:-3.1737483E38)
            r12.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r11)
            int[] r3 = androidx.compose.animation.EnterExitTransitionKt.WhenMappings.$EnumSwitchMapping$0
            int r2 = r2.ordinal()
            r2 = r3[r2]
            if (r2 == r13) goto L_0x049c
            r3 = 2
            if (r2 == r3) goto L_0x046f
            r3 = 3
            if (r2 != r3) goto L_0x0469
            androidx.compose.animation.TransitionData r2 = r33.getData$animation_release()
            androidx.compose.animation.Scale r2 = r2.getScale()
            if (r2 != 0) goto L_0x044b
            r2 = r22
            goto L_0x0453
        L_0x044b:
            long r2 = r2.m84getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r2 = androidx.compose.ui.graphics.TransformOrigin.m2313boximpl(r2)
        L_0x0453:
            if (r2 != 0) goto L_0x049d
            androidx.compose.animation.TransitionData r2 = r32.getData$animation_release()
            androidx.compose.animation.Scale r2 = r2.getScale()
            if (r2 != 0) goto L_0x0460
            goto L_0x0490
        L_0x0460:
            long r2 = r2.m84getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r2 = androidx.compose.ui.graphics.TransformOrigin.m2313boximpl(r2)
            goto L_0x049d
        L_0x0469:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x046f:
            androidx.compose.animation.TransitionData r2 = r32.getData$animation_release()
            androidx.compose.animation.Scale r2 = r2.getScale()
            if (r2 != 0) goto L_0x047c
            r2 = r22
            goto L_0x0484
        L_0x047c:
            long r2 = r2.m84getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r2 = androidx.compose.ui.graphics.TransformOrigin.m2313boximpl(r2)
        L_0x0484:
            if (r2 != 0) goto L_0x049d
            androidx.compose.animation.TransitionData r2 = r33.getData$animation_release()
            androidx.compose.animation.Scale r2 = r2.getScale()
            if (r2 != 0) goto L_0x0493
        L_0x0490:
            r2 = r22
            goto L_0x049d
        L_0x0493:
            long r2 = r2.m84getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r2 = androidx.compose.ui.graphics.TransformOrigin.m2313boximpl(r2)
            goto L_0x049d
        L_0x049c:
            r2 = r7
        L_0x049d:
            if (r2 != 0) goto L_0x04a6
            androidx.compose.ui.graphics.TransformOrigin$Companion r2 = androidx.compose.ui.graphics.TransformOrigin.Companion
            long r2 = r2.m2326getCenterSzJe1aQ()
            goto L_0x04aa
        L_0x04a6:
            long r2 = r2.m2325unboximpl()
        L_0x04aa:
            r35.endReplaceableGroup()
            androidx.compose.ui.graphics.TransformOrigin r2 = androidx.compose.ui.graphics.TransformOrigin.m2313boximpl(r2)
            java.lang.Object r3 = r31.getTargetState()
            androidx.compose.animation.EnterExitState r3 = (androidx.compose.animation.EnterExitState) r3
            r5 = -9518037(0xffffffffff6ec42b, float:-3.1737483E38)
            r12.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r11)
            int[] r5 = androidx.compose.animation.EnterExitTransitionKt.WhenMappings.$EnumSwitchMapping$0
            int r3 = r3.ordinal()
            r3 = r5[r3]
            if (r3 == r13) goto L_0x052d
            r5 = 2
            if (r3 == r5) goto L_0x0501
            r5 = 3
            if (r3 != r5) goto L_0x04fb
            androidx.compose.animation.TransitionData r3 = r33.getData$animation_release()
            androidx.compose.animation.Scale r3 = r3.getScale()
            if (r3 != 0) goto L_0x04dd
            r7 = r22
            goto L_0x04e5
        L_0x04dd:
            long r5 = r3.m84getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r7 = androidx.compose.ui.graphics.TransformOrigin.m2313boximpl(r5)
        L_0x04e5:
            if (r7 != 0) goto L_0x052d
            androidx.compose.animation.TransitionData r3 = r32.getData$animation_release()
            androidx.compose.animation.Scale r3 = r3.getScale()
            if (r3 != 0) goto L_0x04f2
            goto L_0x0522
        L_0x04f2:
            long r5 = r3.m84getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r7 = androidx.compose.ui.graphics.TransformOrigin.m2313boximpl(r5)
            goto L_0x052d
        L_0x04fb:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0501:
            androidx.compose.animation.TransitionData r3 = r32.getData$animation_release()
            androidx.compose.animation.Scale r3 = r3.getScale()
            if (r3 != 0) goto L_0x050e
            r7 = r22
            goto L_0x0516
        L_0x050e:
            long r5 = r3.m84getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r7 = androidx.compose.ui.graphics.TransformOrigin.m2313boximpl(r5)
        L_0x0516:
            if (r7 != 0) goto L_0x052d
            androidx.compose.animation.TransitionData r3 = r33.getData$animation_release()
            androidx.compose.animation.Scale r3 = r3.getScale()
            if (r3 != 0) goto L_0x0525
        L_0x0522:
            r7 = r22
            goto L_0x052d
        L_0x0525:
            long r5 = r3.m84getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r7 = androidx.compose.ui.graphics.TransformOrigin.m2313boximpl(r5)
        L_0x052d:
            if (r7 != 0) goto L_0x0536
            androidx.compose.ui.graphics.TransformOrigin$Companion r3 = androidx.compose.ui.graphics.TransformOrigin.Companion
            long r5 = r3.m2326getCenterSzJe1aQ()
            goto L_0x053a
        L_0x0536:
            long r5 = r7.m2325unboximpl()
        L_0x053a:
            r35.endReplaceableGroup()
            androidx.compose.ui.graphics.TransformOrigin r3 = androidx.compose.ui.graphics.TransformOrigin.m2313boximpl(r5)
            androidx.compose.animation.core.Transition$Segment r5 = r31.getSegment()
            int r6 = r0 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r1 = r1.invoke(r5, r12, r6)
            r5 = r1
            androidx.compose.animation.core.FiniteAnimationSpec r5 = (androidx.compose.animation.core.FiniteAnimationSpec) r5
            r1 = r0 & 14
            int r6 = r0 << 9
            r6 = r6 & r19
            r1 = r1 | r6
            int r0 = r0 << 6
            r0 = r0 & r16
            r7 = r1 | r0
            java.lang.String r6 = "TransformOriginInterruptionHandling"
            r0 = r31
            r1 = r2
            r2 = r3
            r3 = r5
            r5 = r6
            r6 = r35
            androidx.compose.runtime.State r0 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r0, r1, r2, r3, r4, r5, r6, r7)
            r35.endReplaceableGroup()
            androidx.compose.animation.EnterExitTransitionKt$createModifier$1 r1 = new androidx.compose.animation.EnterExitTransitionKt$createModifier$1
            r2 = r30
            r1.<init>(r2, r15, r0)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r0 = r20
            androidx.compose.ui.Modifier r13 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.graphicsLayer(r0, r1)
            goto L_0x0598
        L_0x0582:
            r2 = r7
            r0 = r20
            boolean r1 = m49createModifier$lambda1(r23)
            if (r1 == 0) goto L_0x0597
            androidx.compose.animation.EnterExitTransitionKt$createModifier$2 r1 = new androidx.compose.animation.EnterExitTransitionKt$createModifier$2
            r1.<init>(r2)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.ui.Modifier r13 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.graphicsLayer(r0, r1)
            goto L_0x0598
        L_0x0597:
            r13 = r0
        L_0x0598:
            r35.endReplaceableGroup()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt.createModifier(androidx.compose.animation.core.Transition, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }

    /* renamed from: createModifier$lambda-1  reason: not valid java name */
    private static final boolean m49createModifier$lambda1(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* renamed from: createModifier$lambda-2  reason: not valid java name */
    private static final void m52createModifier$lambda2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* renamed from: createModifier$lambda-4  reason: not valid java name */
    private static final boolean m53createModifier$lambda4(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* renamed from: createModifier$lambda-5  reason: not valid java name */
    private static final void m54createModifier$lambda5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Modifier slideInOut(Modifier modifier, Transition<EnterExitState> transition, State<Slide> state, State<Slide> state2, String str) {
        return ComposedModifierKt.composed$default(modifier, (Function1) null, new EnterExitTransitionKt$slideInOut$1(transition, state, state2, str), 1, (Object) null);
    }

    private static final Modifier shrinkExpand(Modifier modifier, Transition<EnterExitState> transition, State<ChangeSize> state, State<ChangeSize> state2, String str) {
        return ComposedModifierKt.composed$default(modifier, (Function1) null, new EnterExitTransitionKt$shrinkExpand$1(transition, state, state2, str), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: createModifier$lambda-8  reason: not valid java name */
    public static final float m55createModifier$lambda8(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: createModifier$lambda-11  reason: not valid java name */
    public static final float m50createModifier$lambda11(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: createModifier$lambda-13  reason: not valid java name */
    public static final long m51createModifier$lambda13(State<TransformOrigin> state) {
        return state.getValue().m2325unboximpl();
    }
}
