package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000\u001a5\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001aK\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001aS\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u001f\u001aI\u0010 \u001a\u00020!*\u00020\u00182\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00170%2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010&\u001a\u0014\u0010'\u001a\u00020\u0006*\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0002\u001a(\u0010)\u001a\u0002H*\"\u000e\b\u0000\u0010**\b\u0012\u0004\u0012\u0002H*0+*\b\u0012\u0004\u0012\u0002H*0,H\u0002¢\u0006\u0002\u0010-\u001a(\u0010.\u001a\u0002H*\"\u000e\b\u0000\u0010**\b\u0012\u0004\u0012\u0002H*0+*\b\u0012\u0004\u0012\u0002H*0,H\u0002¢\u0006\u0002\u0010-\u001a\u0014\u0010/\u001a\u00020\u0006*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"MinFlingVelocityDp", "Landroidx/compose/ui/unit/Dp;", "getMinFlingVelocityDp", "()F", "F", "NoDistance", "", "NoVelocity", "findClosestOffset", "velocity", "snapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "density", "Landroidx/compose/ui/unit/Density;", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "approachAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "animateDecay", "Landroidx/compose/animation/core/AnimationState;", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/foundation/gestures/ScrollScope;", "targetOffset", "animationState", "decayAnimationSpec", "(Landroidx/compose/foundation/gestures/ScrollScope;FLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateSnap", "cancelOffset", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "approach", "Landroidx/compose/foundation/gestures/snapping/ApproachStepResult;", "initialTargetOffset", "initialVelocity", "animation", "Landroidx/compose/foundation/gestures/snapping/ApproachAnimation;", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLandroidx/compose/foundation/gestures/snapping/ApproachAnimation;Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/ui/unit/Density;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coerceToTarget", "target", "component1", "T", "", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "component2", "halfStep", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: SnapFlingBehavior.kt */
public final class SnapFlingBehaviorKt {
    private static final float MinFlingVelocityDp = Dp.m4704constructorimpl((float) 400);
    public static final float NoDistance = 0.0f;
    public static final float NoVelocity = 0.0f;

    private static final boolean findClosestOffset$isValidDistance(float f) {
        if (!(f == Float.POSITIVE_INFINITY)) {
            if (!(f == Float.NEGATIVE_INFINITY)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior} */
    /* JADX WARNING: type inference failed for: r11v6 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0075, code lost:
        if (r11 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0077;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.foundation.ExperimentalFoundationApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.gestures.snapping.SnapFlingBehavior rememberSnapFlingBehavior(androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider r9, androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r10, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r11, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            java.lang.String r0 = "snapLayoutInfoProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 1790335832(0x6ab65b58, float:1.1022793E26)
            r12.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberSnapFlingBehavior)P(2)175@7491L26,178@7665L7,179@7684L271:SnapFlingBehavior.kt#ppz6w6"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r14 & 2
            if (r1 == 0) goto L_0x001a
            r10 = 0
            androidx.compose.animation.core.DecayAnimationSpec r10 = androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(r12, r10)
        L_0x001a:
            r3 = r10
            r10 = r14 & 4
            if (r10 == 0) goto L_0x002b
            r10 = 0
            r11 = 1137180672(0x43c80000, float:400.0)
            r14 = 5
            r1 = 0
            androidx.compose.animation.core.SpringSpec r10 = androidx.compose.animation.core.AnimationSpecKt.spring$default(r10, r11, r1, r14, r1)
            r11 = r10
            androidx.compose.animation.core.AnimationSpec r11 = (androidx.compose.animation.core.AnimationSpec) r11
        L_0x002b:
            r4 = r11
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x0038
            r10 = -1
            java.lang.String r11 = "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (SnapFlingBehavior.kt:173)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r13, r10, r11)
        L_0x0038:
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r13 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r11, r13)
            java.lang.Object r10 = r12.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r5 = r10
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            r10 = 1618982084(0x607fb4c4, float:7.370227E19)
            r12.startReplaceableGroup(r10)
            java.lang.String r10 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r10)
            boolean r10 = r12.changed((java.lang.Object) r9)
            boolean r11 = r12.changed((java.lang.Object) r3)
            r10 = r10 | r11
            boolean r11 = r12.changed((java.lang.Object) r4)
            r10 = r10 | r11
            java.lang.Object r11 = r12.rememberedValue()
            if (r10 != 0) goto L_0x0077
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r11 != r10) goto L_0x0085
        L_0x0077:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r11 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehavior
            r6 = 0
            r7 = 16
            r8 = 0
            r1 = r11
            r2 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r12.updateRememberedValue(r11)
        L_0x0085:
            r12.endReplaceableGroup()
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r11 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehavior) r11
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x0093
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0093:
            r12.endReplaceableGroup()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.rememberSnapFlingBehavior(androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider, androidx.compose.animation.core.DecayAnimationSpec, androidx.compose.animation.core.AnimationSpec, androidx.compose.runtime.Composer, int, int):androidx.compose.foundation.gestures.snapping.SnapFlingBehavior");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: androidx.compose.ui.unit.Density} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: androidx.compose.foundation.gestures.snapping.ApproachAnimation<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object approach(androidx.compose.foundation.gestures.ScrollScope r5, float r6, float r7, androidx.compose.foundation.gestures.snapping.ApproachAnimation<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r8, androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider r9, androidx.compose.ui.unit.Density r10, kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.snapping.ApproachStepResult> r11) {
        /*
            boolean r0 = r11 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$approach$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$approach$1 r0 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$approach$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$approach$1 r0 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$approach$1
            r0.<init>(r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0050
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            float r5 = r0.F$1
            float r6 = r0.F$0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00a3
        L_0x0031:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0039:
            java.lang.Object r5 = r0.L$3
            r10 = r5
            androidx.compose.ui.unit.Density r10 = (androidx.compose.ui.unit.Density) r10
            java.lang.Object r5 = r0.L$2
            r9 = r5
            androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider r9 = (androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider) r9
            java.lang.Object r5 = r0.L$1
            r8 = r5
            androidx.compose.foundation.gestures.snapping.ApproachAnimation r8 = (androidx.compose.foundation.gestures.snapping.ApproachAnimation) r8
            java.lang.Object r5 = r0.L$0
            androidx.compose.foundation.gestures.ScrollScope r5 = (androidx.compose.foundation.gestures.ScrollScope) r5
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x006c
        L_0x0050:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Float r6 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r6)
            java.lang.Float r7 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r7)
            r0.L$0 = r5
            r0.L$1 = r8
            r0.L$2 = r9
            r0.L$3 = r10
            r0.label = r4
            java.lang.Object r11 = r8.approachAnimation(r5, r6, r7, r0)
            if (r11 != r1) goto L_0x006c
            return r1
        L_0x006c:
            androidx.compose.animation.core.AnimationState r11 = (androidx.compose.animation.core.AnimationState) r11
            java.lang.Object r6 = r11.getVelocity()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            float r6 = findClosestOffset(r6, r9, r10)
            float r7 = halfStep(r9, r10)
            float r9 = java.lang.Math.abs(r6)
            int r9 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x00ba
            java.lang.Float r9 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r6)
            r10 = 0
            r0.L$0 = r10
            r0.L$1 = r10
            r0.L$2 = r10
            r0.L$3 = r10
            r0.F$0 = r6
            r0.F$1 = r7
            r0.label = r3
            java.lang.Object r11 = r8.halfStepAnimation(r5, r9, r11, r0)
            if (r11 != r1) goto L_0x00a2
            return r1
        L_0x00a2:
            r5 = r7
        L_0x00a3:
            androidx.compose.animation.core.AnimationState r11 = (androidx.compose.animation.core.AnimationState) r11
            float r6 = java.lang.Math.abs(r6)
            float r6 = r6 - r5
            java.lang.Object r5 = r11.getVelocity()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            float r5 = java.lang.Math.signum(r5)
            float r6 = r6 * r5
        L_0x00ba:
            androidx.compose.foundation.gestures.snapping.ApproachStepResult r5 = new androidx.compose.foundation.gestures.snapping.ApproachStepResult
            r5.<init>(r6, r11)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.approach(androidx.compose.foundation.gestures.ScrollScope, float, float, androidx.compose.foundation.gestures.snapping.ApproachAnimation, androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider, androidx.compose.ui.unit.Density, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003d, code lost:
        if (java.lang.Math.abs(r5) <= java.lang.Math.abs(r6)) goto L_0x004b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final float findClosestOffset(float r4, androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider r5, androidx.compose.ui.unit.Density r6) {
        /*
            java.lang.String r0 = "snapLayoutInfoProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "density"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlin.ranges.ClosedFloatingPointRange r5 = r5.calculateSnappingOffsetBounds(r6)
            java.lang.Comparable r6 = component1(r5)
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            java.lang.Comparable r5 = component2(r5)
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            float r4 = java.lang.Math.signum(r4)
            r0 = 1
            r1 = 0
            r2 = 0
            int r3 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r3 != 0) goto L_0x0030
            r3 = 1
            goto L_0x0031
        L_0x0030:
            r3 = 0
        L_0x0031:
            if (r3 == 0) goto L_0x0040
            float r4 = java.lang.Math.abs(r5)
            float r0 = java.lang.Math.abs(r6)
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 > 0) goto L_0x0059
            goto L_0x004b
        L_0x0040:
            r3 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x0048
            r3 = 1
            goto L_0x0049
        L_0x0048:
            r3 = 0
        L_0x0049:
            if (r3 == 0) goto L_0x004d
        L_0x004b:
            r6 = r5
            goto L_0x0059
        L_0x004d:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x0054
            goto L_0x0055
        L_0x0054:
            r0 = 0
        L_0x0055:
            if (r0 == 0) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r6 = 0
        L_0x0059:
            boolean r4 = findClosestOffset$isValidDistance(r6)
            if (r4 == 0) goto L_0x0060
            r2 = r6
        L_0x0060:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.findClosestOffset(float, androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider, androidx.compose.ui.unit.Density):float");
    }

    private static final <T extends Comparable<? super T>> T component1(ClosedFloatingPointRange<T> closedFloatingPointRange) {
        Intrinsics.checkNotNullParameter(closedFloatingPointRange, "<this>");
        return closedFloatingPointRange.getStart();
    }

    private static final <T extends Comparable<? super T>> T component2(ClosedFloatingPointRange<T> closedFloatingPointRange) {
        Intrinsics.checkNotNullParameter(closedFloatingPointRange, "<this>");
        return closedFloatingPointRange.getEndInclusive();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object animateDecay(androidx.compose.foundation.gestures.ScrollScope r5, float r6, androidx.compose.animation.core.AnimationState<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r7, androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r8, kotlin.coroutines.Continuation<? super androidx.compose.animation.core.AnimationState<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r9) {
        /*
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1 r0 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1 r0 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1
            r0.<init>(r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r5 = r0.L$0
            r7 = r5
            androidx.compose.animation.core.AnimationState r7 = (androidx.compose.animation.core.AnimationState) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0064
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.jvm.internal.Ref$FloatRef r9 = new kotlin.jvm.internal.Ref$FloatRef
            r9.<init>()
            java.lang.Object r2 = r7.getVelocity()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0050
            r2 = 1
            goto L_0x0051
        L_0x0050:
            r2 = 0
        L_0x0051:
            r2 = r2 ^ r3
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$2 r4 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$2
            r4.<init>(r6, r9, r5)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r5 = androidx.compose.animation.core.SuspendAnimationKt.animateDecay(r7, r8, (boolean) r2, r4, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r5 != r1) goto L_0x0064
            return r1
        L_0x0064:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.animateDecay(androidx.compose.foundation.gestures.ScrollScope, float, androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.DecayAnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void animateDecay$consumeDelta(AnimationScope<Float, AnimationVector1D> animationScope, ScrollScope scrollScope, float f) {
        if (Math.abs(f - scrollScope.scrollBy(f)) > 0.5f) {
            animationScope.cancelAnimation();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: androidx.compose.animation.core.AnimationState<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object animateSnap(androidx.compose.foundation.gestures.ScrollScope r10, float r11, float r12, androidx.compose.animation.core.AnimationState<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r13, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r14, kotlin.coroutines.Continuation<? super androidx.compose.animation.core.AnimationState<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r15) {
        /*
            boolean r0 = r15 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$1 r0 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$1 r0 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$1
            r0.<init>(r15)
        L_0x0019:
            r6 = r0
            java.lang.Object r15 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x003b
            if (r1 != r2) goto L_0x0033
            float r10 = r6.F$0
            java.lang.Object r11 = r6.L$0
            r13 = r11
            androidx.compose.animation.core.AnimationState r13 = (androidx.compose.animation.core.AnimationState) r13
            kotlin.ResultKt.throwOnFailure(r15)
            r0 = r13
            goto L_0x007f
        L_0x0033:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r15)
            kotlin.jvm.internal.Ref$FloatRef r15 = new kotlin.jvm.internal.Ref$FloatRef
            r15.<init>()
            java.lang.Object r1 = r13.getVelocity()
            java.lang.Number r1 = (java.lang.Number) r1
            float r7 = r1.floatValue()
            java.lang.Float r11 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r11)
            java.lang.Object r1 = r13.getVelocity()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0062
            r1 = 1
            goto L_0x0063
        L_0x0062:
            r1 = 0
        L_0x0063:
            r4 = r1 ^ 1
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$2 r1 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$2
            r1.<init>(r12, r15, r10)
            r5 = r1
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r6.L$0 = r13
            r6.F$0 = r7
            r6.label = r2
            r1 = r13
            r2 = r11
            r3 = r14
            java.lang.Object r10 = androidx.compose.animation.core.SuspendAnimationKt.animateTo(r1, r2, r3, r4, r5, r6)
            if (r10 != r0) goto L_0x007d
            return r0
        L_0x007d:
            r0 = r13
            r10 = r7
        L_0x007f:
            java.lang.Object r11 = r0.getVelocity()
            java.lang.Number r11 = (java.lang.Number) r11
            float r11 = r11.floatValue()
            float r2 = coerceToTarget(r11, r10)
            r1 = 0
            r3 = 0
            r5 = 0
            r7 = 0
            r8 = 29
            r9 = 0
            androidx.compose.animation.core.AnimationState r10 = androidx.compose.animation.core.AnimationStateKt.copy$default((androidx.compose.animation.core.AnimationState) r0, (float) r1, (float) r2, (long) r3, (long) r5, (boolean) r7, (int) r8, (java.lang.Object) r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.animateSnap(androidx.compose.foundation.gestures.ScrollScope, float, float, androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final float coerceToTarget(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        return f2 > 0.0f ? RangesKt.coerceAtMost(f, f2) : RangesKt.coerceAtLeast(f, f2);
    }

    /* access modifiers changed from: private */
    public static final float halfStep(SnapLayoutInfoProvider snapLayoutInfoProvider, Density density) {
        return snapLayoutInfoProvider.snapStepSize(density) / 2.0f;
    }

    public static final float getMinFlingVelocityDp() {
        return MinFlingVelocityDp;
    }
}
