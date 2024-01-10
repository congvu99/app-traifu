package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001aM\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u00022\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010\u001d\u001aC\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010\u001f\u001aK\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u0013\u001a\u00020\b2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"\u001aK\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u0013\u001a\u00020\n2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\"\u001aK\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\u0006\u0010\u0013\u001a\u00020\f2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010\"\u001aC\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010(\u001aK\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010\"\u001as\u0010+\u001a\b\u0012\u0004\u0012\u0002H,0\u0012\"\u0004\b\u0000\u0010,\"\b\b\u0001\u0010-*\u00020.2\u0006\u0010\u0013\u001a\u0002H,2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H-002\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H,0\u00152\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u0001H,2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u00101\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"defaultAnimation", "Landroidx/compose/animation/core/SpringSpec;", "", "dpDefaultSpring", "Landroidx/compose/ui/unit/Dp;", "intDefaultSpring", "", "intOffsetDefaultSpring", "Landroidx/compose/ui/unit/IntOffset;", "intSizeDefaultSpring", "Landroidx/compose/ui/unit/IntSize;", "offsetDefaultSpring", "Landroidx/compose/ui/geometry/Offset;", "rectDefaultSpring", "Landroidx/compose/ui/geometry/Rect;", "sizeDefaultSpring", "Landroidx/compose/ui/geometry/Size;", "animateDpAsState", "Landroidx/compose/runtime/State;", "targetValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "finishedListener", "Lkotlin/Function1;", "", "animateDpAsState-Kz89ssw", "(FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateFloatAsState", "visibilityThreshold", "(FLandroidx/compose/animation/core/AnimationSpec;FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntAsState", "(ILandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntOffsetAsState", "animateIntOffsetAsState-8f6pmRE", "(JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntSizeAsState", "animateIntSizeAsState-zTRF_AQ", "animateOffsetAsState", "animateOffsetAsState-N6fFfp4", "animateRectAsState", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateSizeAsState", "animateSizeAsState-LjSzlW0", "animateValueAsState", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animation-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnimateAsState.kt */
public final class AnimateAsStateKt {
    private static final SpringSpec<Float> defaultAnimation = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
    private static final SpringSpec<Dp> dpDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Dp.m4702boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Dp.Companion)), 3, (Object) null);
    private static final SpringSpec<Integer> intDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Integer.valueOf(VisibilityThresholdsKt.getVisibilityThreshold(IntCompanionObject.INSTANCE)), 3, (Object) null);
    private static final SpringSpec<IntOffset> intOffsetDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m4813boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, (Object) null);
    private static final SpringSpec<IntSize> intSizeDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, IntSize.m4856boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 3, (Object) null);
    private static final SpringSpec<Offset> offsetDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Offset.m1672boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Offset.Companion)), 3, (Object) null);
    private static final SpringSpec<Rect> rectDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.Companion), 3, (Object) null);
    private static final SpringSpec<Size> sizeDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Size.m1740boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Size.Companion)), 3, (Object) null);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: androidx.compose.animation.core.AnimationSpec<java.lang.Float>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.runtime.State<java.lang.Float> animateFloatAsState(float r9, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r10, float r11, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r12, androidx.compose.runtime.Composer r13, int r14, int r15) {
        /*
            r0 = 841393235(0x3226a453, float:9.699835E-9)
            r13.startReplaceableGroup(r0)
            java.lang.String r0 = "C(animateFloatAsState)P(2!1,3)72@3191L158:AnimateAsState.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
            r0 = r15 & 2
            if (r0 == 0) goto L_0x0013
            androidx.compose.animation.core.SpringSpec<java.lang.Float> r10 = defaultAnimation
            androidx.compose.animation.core.AnimationSpec r10 = (androidx.compose.animation.core.AnimationSpec) r10
        L_0x0013:
            r0 = r15 & 4
            if (r0 == 0) goto L_0x001a
            r11 = 1008981770(0x3c23d70a, float:0.01)
        L_0x001a:
            r15 = r15 & 8
            r0 = 0
            if (r15 == 0) goto L_0x0021
            r5 = r0
            goto L_0x0022
        L_0x0021:
            r5 = r12
        L_0x0022:
            r12 = 841393485(0x3226a54d, float:9.700057E-9)
            r13.startReplaceableGroup(r12)
            java.lang.String r12 = "68@3043L83"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r12)
            androidx.compose.animation.core.SpringSpec<java.lang.Float> r12 = defaultAnimation
            r15 = 3
            if (r10 != r12) goto L_0x0065
            java.lang.Float r10 = java.lang.Float.valueOf(r11)
            r12 = -3686930(0xffffffffffc7bdee, float:NaN)
            r13.startReplaceableGroup(r12)
            java.lang.String r12 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r12)
            boolean r10 = r13.changed((java.lang.Object) r10)
            java.lang.Object r12 = r13.rememberedValue()
            if (r10 != 0) goto L_0x0053
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r12 != r10) goto L_0x005f
        L_0x0053:
            java.lang.Float r10 = java.lang.Float.valueOf(r11)
            r12 = 0
            androidx.compose.animation.core.SpringSpec r12 = androidx.compose.animation.core.AnimationSpecKt.spring$default(r12, r12, r10, r15, r0)
            r13.updateRememberedValue(r12)
        L_0x005f:
            r13.endReplaceableGroup()
            r10 = r12
            androidx.compose.animation.core.AnimationSpec r10 = (androidx.compose.animation.core.AnimationSpec) r10
        L_0x0065:
            r3 = r10
            r13.endReplaceableGroup()
            java.lang.Float r1 = java.lang.Float.valueOf(r9)
            kotlin.jvm.internal.FloatCompanionObject r9 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r2 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r9)
            java.lang.Float r4 = java.lang.Float.valueOf(r11)
            r9 = r14 & 14
            int r10 = r14 << 3
            r11 = r10 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | r11
            r11 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r11
            r7 = r9 | r10
            r8 = 0
            r6 = r13
            androidx.compose.runtime.State r9 = animateValueAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            r13.endReplaceableGroup()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(float, androidx.compose.animation.core.AnimationSpec, float, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):androidx.compose.runtime.State");
    }

    /* renamed from: animateDpAsState-Kz89ssw  reason: not valid java name */
    public static final State<Dp> m102animateDpAsStateKz89ssw(float f, AnimationSpec<Dp> animationSpec, Function1<? super Dp, Unit> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1364859110);
        ComposerKt.sourceInformation(composer, "C(animateDpAsState)P(2:c#ui.unit.Dp)108@4762L142:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = dpDefaultSpring;
        }
        AnimationSpec<Dp> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        State<Dp> animateValueAsState = animateValueAsState(Dp.m4702boximpl(f), VectorConvertersKt.getVectorConverter(Dp.Companion), animationSpec2, (Dp) null, function1, composer, (i & 14) | ((i << 3) & 896) | (57344 & (i << 6)), 8);
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    /* renamed from: animateSizeAsState-LjSzlW0  reason: not valid java name */
    public static final State<Size> m106animateSizeAsStateLjSzlW0(long j, AnimationSpec<Size> animationSpec, Function1<? super Size, Unit> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1414928158);
        ComposerKt.sourceInformation(composer, "C(animateSizeAsState)P(2:c#ui.geometry.Size)146@6457L144:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = sizeDefaultSpring;
        }
        AnimationSpec<Size> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        State<Size> animateValueAsState = animateValueAsState(Size.m1740boximpl(j), VectorConvertersKt.getVectorConverter(Size.Companion), animationSpec2, (Size) null, function1, composer, (i & 14) | ((i << 3) & 896) | (57344 & (i << 6)), 8);
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    /* renamed from: animateOffsetAsState-N6fFfp4  reason: not valid java name */
    public static final State<Offset> m105animateOffsetAsStateN6fFfp4(long j, AnimationSpec<Offset> animationSpec, Function1<? super Offset, Unit> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-200212809);
        ComposerKt.sourceInformation(composer, "C(animateOffsetAsState)P(2:c#ui.geometry.Offset)183@8136L122:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = offsetDefaultSpring;
        }
        AnimationSpec<Offset> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        State<Offset> animateValueAsState = animateValueAsState(Offset.m1672boximpl(j), VectorConvertersKt.getVectorConverter(Offset.Companion), animationSpec2, (Offset) null, function1, composer, (i & 14) | ((i << 3) & 896) | (57344 & (i << 6)), 8);
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    public static final State<Rect> animateRectAsState(Rect rect, AnimationSpec<Rect> animationSpec, Function1<? super Rect, Unit> function1, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(rect, "targetValue");
        composer.startReplaceableGroup(231660788);
        ComposerKt.sourceInformation(composer, "C(animateRectAsState)P(2)218@9832L120:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = rectDefaultSpring;
        }
        AnimationSpec<Rect> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Rect rect2 = rect;
        State<Rect> animateValueAsState = animateValueAsState(rect2, VectorConvertersKt.getVectorConverter(Rect.Companion), animationSpec2, (Rect) null, function1, composer, (i & 14) | ((i << 3) & 896) | (57344 & (i << 6)), 8);
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    public static final State<Integer> animateIntAsState(int i, AnimationSpec<Integer> animationSpec, Function1<? super Integer, Unit> function1, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(-887370562);
        ComposerKt.sourceInformation(composer, "C(animateIntAsState)P(2)250@11387L119:AnimateAsState.kt#pdpnli");
        if ((i3 & 2) != 0) {
            animationSpec = intDefaultSpring;
        }
        AnimationSpec<Integer> animationSpec2 = animationSpec;
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        State<Integer> animateValueAsState = animateValueAsState(Integer.valueOf(i), VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), animationSpec2, (Integer) null, function1, composer, (i2 & 14) | ((i2 << 3) & 896) | (57344 & (i2 << 6)), 8);
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    /* renamed from: animateIntOffsetAsState-8f6pmRE  reason: not valid java name */
    public static final State<IntOffset> m103animateIntOffsetAsState8f6pmRE(long j, AnimationSpec<IntOffset> animationSpec, Function1<? super IntOffset, Unit> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1370676387);
        ComposerKt.sourceInformation(composer, "C(animateIntOffsetAsState)P(2:c#ui.unit.IntOffset)284@13067L125:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = intOffsetDefaultSpring;
        }
        AnimationSpec<IntOffset> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        State<IntOffset> animateValueAsState = animateValueAsState(IntOffset.m4813boximpl(j), VectorConvertersKt.getVectorConverter(IntOffset.Companion), animationSpec2, (IntOffset) null, function1, composer, (i & 14) | ((i << 3) & 896) | (57344 & (i << 6)), 8);
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    /* renamed from: animateIntSizeAsState-zTRF_AQ  reason: not valid java name */
    public static final State<IntSize> m104animateIntSizeAsStatezTRF_AQ(long j, AnimationSpec<IntSize> animationSpec, Function1<? super IntSize, Unit> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1724517475);
        ComposerKt.sourceInformation(composer, "C(animateIntSizeAsState)P(2:c#ui.unit.IntSize)316@14673L123:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = intSizeDefaultSpring;
        }
        AnimationSpec<IntSize> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        State<IntSize> animateValueAsState = animateValueAsState(IntSize.m4856boximpl(j), VectorConvertersKt.getVectorConverter(IntSize.Companion), animationSpec2, (IntSize) null, function1, composer, (i & 14) | ((i << 3) & 896) | (57344 & (i << 6)), 8);
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    public static final <T, V extends AnimationVector> State<T> animateValueAsState(T t, TwoWayConverter<T, V> twoWayConverter, AnimationSpec<T> animationSpec, T t2, Function1<? super T, Unit> function1, Composer composer, int i, int i2) {
        AnimationSpec<T> animationSpec2;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(twoWayConverter, "typeConverter");
        composer2.startReplaceableGroup(1824613323);
        ComposerKt.sourceInformation(composer2, "C(animateValueAsState)P(2,3!1,4)352@16556L74,359@16748L51,360@16820L38,361@16879L35,362@16933L42,363@16980L55,366@17040L721:AnimateAsState.kt#pdpnli");
        if ((i2 & 4) != 0) {
            composer2.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = AnimationSpecKt.spring$default(0.0f, 0.0f, t2, 3, (Object) null);
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            animationSpec2 = (AnimationSpec) rememberedValue;
        } else {
            animationSpec2 = animationSpec;
        }
        int i3 = i2 & 8;
        Function1<? super T, Unit> function12 = (i2 & 16) != 0 ? null : function1;
        composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        Animatable animatable = rememberedValue2;
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            Animatable animatable2 = new Animatable(t, twoWayConverter, (Object) null, 4, (DefaultConstructorMarker) null);
            composer2.updateRememberedValue(animatable2);
            animatable = animatable2;
        }
        composer.endReplaceableGroup();
        Animatable animatable3 = (Animatable) animatable;
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function12, composer2, (i >> 12) & 14);
        State<T> rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(animationSpec2, composer2, (i >> 6) & 14);
        composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = ChannelKt.Channel$default(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
            composer2.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        Channel channel = (Channel) rememberedValue3;
        EffectsKt.SideEffect(new AnimateAsStateKt$animateValueAsState$2(channel, t), composer2, 0);
        EffectsKt.LaunchedEffect((Object) channel, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new AnimateAsStateKt$animateValueAsState$3(channel, animatable3, rememberUpdatedState2, rememberUpdatedState, (Continuation<? super AnimateAsStateKt$animateValueAsState$3>) null), composer2, 8);
        State<T> asState = animatable3.asState();
        composer.endReplaceableGroup();
        return asState;
    }

    /* access modifiers changed from: private */
    /* renamed from: animateValueAsState$lambda-3  reason: not valid java name */
    public static final <T> Function1<T, Unit> m107animateValueAsState$lambda3(State<? extends Function1<? super T, Unit>> state) {
        return (Function1) state.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: animateValueAsState$lambda-4  reason: not valid java name */
    public static final <T> AnimationSpec<T> m108animateValueAsState$lambda4(State<? extends AnimationSpec<T>> state) {
        return (AnimationSpec) state.getValue();
    }
}
