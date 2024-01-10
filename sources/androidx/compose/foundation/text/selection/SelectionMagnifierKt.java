package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0003ø\u0001\u0000¢\u0006\u0002\u0010\r\u001aF\u0010\u000e\u001a\u00020\u000f*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\f2'\u0010\u0011\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00020\f¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000f0\u0012H\u0000ø\u0001\u0000\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0002X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\"\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\bX\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"MagnifierSpringSpec", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/geometry/Offset;", "OffsetDisplacementThreshold", "J", "UnspecifiedAnimationVector2D", "Landroidx/compose/animation/core/AnimationVector2D;", "UnspecifiedSafeOffsetVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "rememberAnimatedMagnifierPosition", "Landroidx/compose/runtime/State;", "targetCalculation", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animatedSelectionMagnifier", "Landroidx/compose/ui/Modifier;", "magnifierCenter", "platformMagnifier", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animatedCenter", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: SelectionMagnifier.kt */
public final class SelectionMagnifierKt {
    /* access modifiers changed from: private */
    public static final SpringSpec<Offset> MagnifierSpringSpec;
    /* access modifiers changed from: private */
    public static final long OffsetDisplacementThreshold;
    /* access modifiers changed from: private */
    public static final AnimationVector2D UnspecifiedAnimationVector2D = new AnimationVector2D(Float.NaN, Float.NaN);
    /* access modifiers changed from: private */
    public static final TwoWayConverter<Offset, AnimationVector2D> UnspecifiedSafeOffsetVectorConverter = VectorConvertersKt.TwoWayConverter(SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1.INSTANCE, SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$2.INSTANCE);

    static {
        long Offset = OffsetKt.Offset(0.01f, 0.01f);
        OffsetDisplacementThreshold = Offset;
        MagnifierSpringSpec = new SpringSpec(0.0f, 0.0f, Offset.m1672boximpl(Offset), 3, (DefaultConstructorMarker) null);
    }

    public static final Modifier animatedSelectionMagnifier(Modifier modifier, Function0<Offset> function0, Function1<? super Function0<Offset>, ? extends Modifier> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function0, "magnifierCenter");
        Intrinsics.checkNotNullParameter(function1, "platformMagnifier");
        return ComposedModifierKt.composed$default(modifier, (Function1) null, new SelectionMagnifierKt$animatedSelectionMagnifier$1(function0, function1), 1, (Object) null);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [kotlin.jvm.functions.Function0<androidx.compose.ui.geometry.Offset>, kotlin.jvm.functions.Function0] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.runtime.State<androidx.compose.ui.geometry.Offset> rememberAnimatedMagnifierPosition(kotlin.jvm.functions.Function0<androidx.compose.ui.geometry.Offset> r4, androidx.compose.runtime.Composer r5, int r6) {
        /*
            r0 = -1589795249(0xffffffffa13da64f, float:-6.42558E-19)
            r5.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberAnimatedMagnifierPosition)79@3044L46,80@3112L208,84@3325L1186:SelectionMagnifier.kt#eksfi3"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0017
            r1 = -1
            java.lang.String r2 = "androidx.compose.foundation.text.selection.rememberAnimatedMagnifierPosition (SelectionMagnifier.kt:76)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r6, r1, r2)
        L_0x0017:
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r5.startReplaceableGroup(r6)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r0)
            java.lang.Object r1 = r5.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x0035
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r4)
            r5.updateRememberedValue(r1)
        L_0x0035:
            r5.endReplaceableGroup()
            androidx.compose.runtime.State r1 = (androidx.compose.runtime.State) r1
            r5.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r0)
            java.lang.Object r4 = r5.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r4 != r6) goto L_0x0068
            androidx.compose.animation.core.Animatable r4 = new androidx.compose.animation.core.Animatable
            long r2 = m1019rememberAnimatedMagnifierPosition$lambda1(r1)
            androidx.compose.ui.geometry.Offset r6 = androidx.compose.ui.geometry.Offset.m1672boximpl(r2)
            androidx.compose.animation.core.TwoWayConverter r0 = UnspecifiedSafeOffsetVectorConverter
            long r2 = OffsetDisplacementThreshold
            androidx.compose.ui.geometry.Offset r2 = androidx.compose.ui.geometry.Offset.m1672boximpl(r2)
            r4.<init>(r6, r0, r2)
            r5.updateRememberedValue(r4)
        L_0x0068:
            r5.endReplaceableGroup()
            androidx.compose.animation.core.Animatable r4 = (androidx.compose.animation.core.Animatable) r4
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            androidx.compose.foundation.text.selection.SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1 r0 = new androidx.compose.foundation.text.selection.SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1
            r2 = 0
            r0.<init>(r1, r4, r2)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = 64
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r6, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r0, (androidx.compose.runtime.Composer) r5, (int) r1)
            androidx.compose.runtime.State r4 = r4.asState()
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x0089
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0089:
            r5.endReplaceableGroup()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionMagnifierKt.rememberAnimatedMagnifierPosition(kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):androidx.compose.runtime.State");
    }

    /* access modifiers changed from: private */
    /* renamed from: rememberAnimatedMagnifierPosition$lambda-1  reason: not valid java name */
    public static final long m1019rememberAnimatedMagnifierPosition$lambda1(State<Offset> state) {
        return state.getValue().m1693unboximpl();
    }
}
