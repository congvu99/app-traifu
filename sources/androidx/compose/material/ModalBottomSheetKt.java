package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a3\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a;\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001b0\u0003H\u0007¢\u0006\u0002\u0010%\u001aC\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010&\u001a\u00020\u001b2\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001b0\u0003H\u0007¢\u0006\u0002\u0010'\u001a,\u0010(\u001a\u00020\b*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010)\u001a\u00020#2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0+H\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006,"}, d2 = {"ModalBottomSheetLayout", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material/ModalBottomSheetState;", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "Landroidx/compose/ui/unit/Dp;", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "scrimColor", "content", "Lkotlin/Function0;", "ModalBottomSheetLayout-BzaUkTc", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ModalBottomSheetState;Landroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "color", "onDismiss", "visible", "", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberModalBottomSheetState", "initialValue", "Landroidx/compose/material/ModalBottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "skipHalfExpanded", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "bottomSheetSwipeable", "fullHeight", "sheetHeightState", "Landroidx/compose/runtime/State;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModalBottomSheet.kt */
public final class ModalBottomSheetKt {
    @ExperimentalMaterialApi
    public static final ModalBottomSheetState rememberModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec<Float> animationSpec, boolean z, Function1<? super ModalBottomSheetValue, Boolean> function1, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(modalBottomSheetValue, "initialValue");
        composer.startReplaceableGroup(-409288536);
        ComposerKt.sourceInformation(composer, "C(rememberModalBottomSheetState)P(2!1,3)245@9606L533:ModalBottomSheet.kt#jmzs0o");
        AnimationSpec<Float> animationSpec2 = animationSpec;
        if ((i2 & 2) != 0) {
            animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        Function1<? super ModalBottomSheetValue, Boolean> function12 = function1;
        if ((i2 & 8) != 0) {
            function12 = ModalBottomSheetKt$rememberModalBottomSheetState$1.INSTANCE;
        }
        ModalBottomSheetState modalBottomSheetState = (ModalBottomSheetState) RememberSaveableKt.rememberSaveable(new Object[]{modalBottomSheetValue, animationSpec2, Boolean.valueOf(z), function12}, ModalBottomSheetState.Companion.Saver(animationSpec2, z, function12), (String) null, new ModalBottomSheetKt$rememberModalBottomSheetState$2(modalBottomSheetValue, animationSpec2, z, function12), composer, 72, 4);
        composer.endReplaceableGroup();
        return modalBottomSheetState;
    }

    @ExperimentalMaterialApi
    public static final ModalBottomSheetState rememberModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> function1, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(modalBottomSheetValue, "initialValue");
        composer.startReplaceableGroup(-1928569212);
        ComposerKt.sourceInformation(composer, "C(rememberModalBottomSheetState)P(2)275@10738L174:ModalBottomSheet.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        AnimationSpec<Float> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = ModalBottomSheetKt$rememberModalBottomSheetState$3.INSTANCE;
        }
        ModalBottomSheetState rememberModalBottomSheetState = rememberModalBottomSheetState(modalBottomSheetValue, animationSpec2, false, function1, composer, (i & 14) | 448 | ((i << 3) & 7168), 0);
        composer.endReplaceableGroup();
        return rememberModalBottomSheetState;
    }

    /* JADX WARNING: Removed duplicated region for block: B:151:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x012d  */
    @androidx.compose.material.ExperimentalMaterialApi
    /* renamed from: ModalBottomSheetLayout-BzaUkTc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1332ModalBottomSheetLayoutBzaUkTc(kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.ui.Modifier r31, androidx.compose.material.ModalBottomSheetState r32, androidx.compose.ui.graphics.Shape r33, float r34, long r35, long r37, long r39, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, androidx.compose.runtime.Composer r42, int r43, int r44) {
        /*
            r14 = r30
            r15 = r41
            r13 = r43
            r12 = r44
            java.lang.String r0 = "sheetContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = -1633763156(0xffffffff9e9ec0ac, float:-1.6808588E-20)
            r1 = r42
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(ModalBottomSheetLayout)P(4,1,8,7,6:c#ui.unit.Dp,3:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color)316@12777L37,317@12854L6,319@12977L6,320@13024L37,321@13112L10,324@13180L24,325@13209L2723:ModalBottomSheet.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0028
            r0 = r13 | 6
            goto L_0x0038
        L_0x0028:
            r0 = r13 & 14
            if (r0 != 0) goto L_0x0037
            boolean r0 = r10.changed((java.lang.Object) r14)
            if (r0 == 0) goto L_0x0034
            r0 = 4
            goto L_0x0035
        L_0x0034:
            r0 = 2
        L_0x0035:
            r0 = r0 | r13
            goto L_0x0038
        L_0x0037:
            r0 = r13
        L_0x0038:
            r1 = r12 & 2
            if (r1 == 0) goto L_0x003f
            r0 = r0 | 48
            goto L_0x0052
        L_0x003f:
            r2 = r13 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0052
            r2 = r31
            boolean r3 = r10.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x004e
            r3 = 32
            goto L_0x0050
        L_0x004e:
            r3 = 16
        L_0x0050:
            r0 = r0 | r3
            goto L_0x0054
        L_0x0052:
            r2 = r31
        L_0x0054:
            r3 = r13 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x006d
            r3 = r12 & 4
            if (r3 != 0) goto L_0x0067
            r3 = r32
            boolean r4 = r10.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0069
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0067:
            r3 = r32
        L_0x0069:
            r4 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r0 = r0 | r4
            goto L_0x006f
        L_0x006d:
            r3 = r32
        L_0x006f:
            r4 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0086
            r4 = r12 & 8
            r7 = r33
            if (r4 != 0) goto L_0x0082
            boolean r4 = r10.changed((java.lang.Object) r7)
            if (r4 == 0) goto L_0x0082
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x0084
        L_0x0082:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x0084:
            r0 = r0 | r4
            goto L_0x0088
        L_0x0086:
            r7 = r33
        L_0x0088:
            r8 = r12 & 16
            if (r8 == 0) goto L_0x0091
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r9 = r34
            goto L_0x00a5
        L_0x0091:
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r13
            r9 = r34
            if (r4 != 0) goto L_0x00a5
            boolean r4 = r10.changed((float) r9)
            if (r4 == 0) goto L_0x00a2
            r4 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a4
        L_0x00a2:
            r4 = 8192(0x2000, float:1.14794E-41)
        L_0x00a4:
            r0 = r0 | r4
        L_0x00a5:
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r13
            if (r4 != 0) goto L_0x00bd
            r4 = r12 & 32
            r5 = r35
            if (r4 != 0) goto L_0x00b9
            boolean r4 = r10.changed((long) r5)
            if (r4 == 0) goto L_0x00b9
            r4 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bb
        L_0x00b9:
            r4 = 65536(0x10000, float:9.18355E-41)
        L_0x00bb:
            r0 = r0 | r4
            goto L_0x00bf
        L_0x00bd:
            r5 = r35
        L_0x00bf:
            r4 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r13
            if (r4 != 0) goto L_0x00d7
            r4 = r12 & 64
            r6 = r37
            if (r4 != 0) goto L_0x00d3
            boolean r4 = r10.changed((long) r6)
            if (r4 == 0) goto L_0x00d3
            r4 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d5
        L_0x00d3:
            r4 = 524288(0x80000, float:7.34684E-40)
        L_0x00d5:
            r0 = r0 | r4
            goto L_0x00d9
        L_0x00d7:
            r6 = r37
        L_0x00d9:
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r13
            if (r4 != 0) goto L_0x00f3
            r4 = r12 & 128(0x80, float:1.794E-43)
            if (r4 != 0) goto L_0x00ed
            r4 = r39
            boolean r11 = r10.changed((long) r4)
            if (r11 == 0) goto L_0x00ef
            r11 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f1
        L_0x00ed:
            r4 = r39
        L_0x00ef:
            r11 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f1:
            r0 = r0 | r11
            goto L_0x00f5
        L_0x00f3:
            r4 = r39
        L_0x00f5:
            r11 = r12 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x00fd
            r11 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x00fb:
            r0 = r0 | r11
            goto L_0x010e
        L_0x00fd:
            r11 = 234881024(0xe000000, float:1.5777218E-30)
            r11 = r11 & r13
            if (r11 != 0) goto L_0x010e
            boolean r11 = r10.changed((java.lang.Object) r15)
            if (r11 == 0) goto L_0x010b
            r11 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00fb
        L_0x010b:
            r11 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x00fb
        L_0x010e:
            r11 = 191739611(0xb6db6db, float:4.5782105E-32)
            r11 = r11 & r0
            r2 = 38347922(0x2492492, float:1.4777643E-37)
            if (r11 != r2) goto L_0x012d
            boolean r2 = r10.getSkipping()
            if (r2 != 0) goto L_0x011e
            goto L_0x012d
        L_0x011e:
            r10.skipToGroupEnd()
            r2 = r31
            r15 = r10
            r10 = r4
            r5 = r9
            r4 = r33
            r8 = r6
            r6 = r35
            goto L_0x029d
        L_0x012d:
            r10.startDefaults()
            r2 = r13 & 1
            r11 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r16 = -3670017(0xffffffffffc7ffff, float:NaN)
            r17 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r2 == 0) goto L_0x0176
            boolean r2 = r10.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0144
            goto L_0x0176
        L_0x0144:
            r10.skipToGroupEnd()
            r1 = r12 & 4
            if (r1 == 0) goto L_0x014d
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x014d:
            r1 = r12 & 8
            if (r1 == 0) goto L_0x0153
            r0 = r0 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0153:
            r1 = r12 & 32
            if (r1 == 0) goto L_0x0159
            r0 = r0 & r17
        L_0x0159:
            r1 = r12 & 64
            if (r1 == 0) goto L_0x015f
            r0 = r0 & r16
        L_0x015f:
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0164
            r0 = r0 & r11
        L_0x0164:
            r18 = r31
            r17 = r33
            r20 = r35
            r26 = r0
            r16 = r3
            r24 = r4
            r22 = r6
            r19 = r9
            goto L_0x0206
        L_0x0176:
            if (r1 == 0) goto L_0x017f
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r18 = r1
            goto L_0x0181
        L_0x017f:
            r18 = r31
        L_0x0181:
            r1 = r12 & 4
            if (r1 == 0) goto L_0x0199
            androidx.compose.material.ModalBottomSheetValue r1 = androidx.compose.material.ModalBottomSheetValue.Hidden
            r2 = 0
            r3 = 0
            r19 = 6
            r20 = 6
            r4 = r10
            r5 = r19
            r6 = r20
            androidx.compose.material.ModalBottomSheetState r1 = rememberModalBottomSheetState(r1, r2, r3, r4, r5, r6)
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x019a
        L_0x0199:
            r1 = r3
        L_0x019a:
            r2 = r12 & 8
            r3 = 6
            if (r2 == 0) goto L_0x01ae
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r2 = r2.getShapes(r10, r3)
            androidx.compose.foundation.shape.CornerBasedShape r2 = r2.getLarge()
            androidx.compose.ui.graphics.Shape r2 = (androidx.compose.ui.graphics.Shape) r2
            r0 = r0 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x01b0
        L_0x01ae:
            r2 = r33
        L_0x01b0:
            if (r8 == 0) goto L_0x01b9
            androidx.compose.material.ModalBottomSheetDefaults r4 = androidx.compose.material.ModalBottomSheetDefaults.INSTANCE
            float r4 = r4.m1331getElevationD9Ej5fM()
            goto L_0x01ba
        L_0x01b9:
            r4 = r9
        L_0x01ba:
            r5 = r12 & 32
            if (r5 == 0) goto L_0x01cb
            androidx.compose.material.MaterialTheme r5 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r5 = r5.getColors(r10, r3)
            long r5 = r5.m1218getSurface0d7_KjU()
            r0 = r0 & r17
            goto L_0x01cd
        L_0x01cb:
            r5 = r35
        L_0x01cd:
            r7 = r12 & 64
            if (r7 == 0) goto L_0x01dc
            int r7 = r0 >> 15
            r7 = r7 & 14
            long r7 = androidx.compose.material.ColorsKt.m1232contentColorForek8zF_U(r5, r10, r7)
            r0 = r0 & r16
            goto L_0x01de
        L_0x01dc:
            r7 = r37
        L_0x01de:
            r9 = r12 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x01f8
            androidx.compose.material.ModalBottomSheetDefaults r9 = androidx.compose.material.ModalBottomSheetDefaults.INSTANCE
            long r16 = r9.getScrimColor(r10, r3)
            r0 = r0 & r11
            r26 = r0
            r19 = r4
            r20 = r5
            r22 = r7
            r24 = r16
            r16 = r1
            r17 = r2
            goto L_0x0206
        L_0x01f8:
            r24 = r39
            r26 = r0
            r16 = r1
            r17 = r2
            r19 = r4
            r20 = r5
            r22 = r7
        L_0x0206:
            r10.endDefaults()
            r0 = 773894976(0x2e20b340, float:3.6538994E-11)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            java.lang.Object r0 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x023c
            kotlin.coroutines.EmptyCoroutineContext r0 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r10)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r0)
            r10.updateRememberedValue(r1)
            r0 = r1
        L_0x023c:
            r10.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r27 = r0.getCoroutineScope()
            r10.endReplaceableGroup()
            r28 = 0
            r29 = 0
            r11 = 1607356310(0x5fce4f96, float:2.9732532E19)
            androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1 r9 = new androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1
            r0 = r9
            r1 = r16
            r2 = r26
            r3 = r17
            r4 = r20
            r6 = r22
            r8 = r19
            r14 = r9
            r9 = r41
            r15 = r10
            r31 = r14
            r14 = 1607356310(0x5fce4f96, float:2.9732532E19)
            r10 = r24
            r12 = r27
            r13 = r30
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r12, r13)
            r0 = 1
            r1 = r31
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r14, r0, r1)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            int r1 = r26 >> 3
            r1 = r1 & 14
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r2 = 6
            r31 = r18
            r32 = r28
            r33 = r29
            r34 = r0
            r35 = r15
            r36 = r1
            r37 = r2
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r31, r32, r33, r34, r35, r36, r37)
            r3 = r16
            r4 = r17
            r2 = r18
            r5 = r19
            r6 = r20
            r8 = r22
        L_0x029d:
            androidx.compose.runtime.ScopeUpdateScope r15 = r15.endRestartGroup()
            if (r15 != 0) goto L_0x02a4
            goto L_0x02ba
        L_0x02a4:
            androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2 r16 = new androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2
            r0 = r16
            r1 = r30
            r12 = r41
            r13 = r43
            r14 = r44
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r12, r13, r14)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x02ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ModalBottomSheetKt.m1332ModalBottomSheetLayoutBzaUkTc(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.ModalBottomSheetState, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final Modifier bottomSheetSwipeable(Modifier modifier, ModalBottomSheetState modalBottomSheetState, float f, State<Float> state) {
        Modifier modifier2;
        Map map;
        Float value = state.getValue();
        if (value != null) {
            float f2 = f / ((float) 2);
            if (value.floatValue() < f2 || modalBottomSheetState.isSkipHalfExpanded$material_release()) {
                map = MapsKt.mapOf(TuplesKt.to(Float.valueOf(f), ModalBottomSheetValue.Hidden), TuplesKt.to(Float.valueOf(f - value.floatValue()), ModalBottomSheetValue.Expanded));
            } else {
                map = MapsKt.mapOf(TuplesKt.to(Float.valueOf(f), ModalBottomSheetValue.Hidden), TuplesKt.to(Float.valueOf(f2), ModalBottomSheetValue.HalfExpanded), TuplesKt.to(Float.valueOf(Math.max(0.0f, f - value.floatValue())), ModalBottomSheetValue.Expanded));
            }
            modifier2 = SwipeableKt.m1430swipeablepPrIpRY$default(Modifier.Companion, modalBottomSheetState, map, Orientation.Vertical, modalBottomSheetState.getCurrentValue() != ModalBottomSheetValue.Hidden, false, (MutableInteractionSource) null, (Function2) null, (ResistanceConfig) null, 0.0f, 368, (Object) null);
        } else {
            modifier2 = Modifier.Companion;
        }
        return modifier.then(modifier2);
    }

    /* access modifiers changed from: private */
    /* renamed from: Scrim-3J-VO9M  reason: not valid java name */
    public static final void m1333Scrim3JVO9M(long j, Function0<Unit> function0, boolean z, Composer composer, int i) {
        int i2;
        Modifier modifier;
        long j2 = j;
        Function0<Unit> function02 = function0;
        boolean z2 = z;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-526532668);
        ComposerKt.sourceInformation(startRestartGroup, "C(Scrim)P(0:c#ui.graphics.Color)435@17137L121,439@17284L29,455@17799L62,451@17690L171:ModalBottomSheet.kt#jmzs0o");
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed(j2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) function02) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (j2 != Color.Companion.m1968getUnspecified0d7_KjU()) {
                State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z2 ? 1.0f : 0.0f, new TweenSpec(0, 0, (Easing) null, 7, (DefaultConstructorMarker) null), 0.0f, (Function1<? super Float, Unit>) null, startRestartGroup, 0, 12);
                String r7 = Strings_androidKt.m1417getString4foXLRw(Strings.Companion.m1411getCloseSheetUdPEhr4(), startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(1010547488);
                ComposerKt.sourceInformation(startRestartGroup, "442@17421L37,443@17511L121");
                if (z2) {
                    Modifier modifier2 = Modifier.Companion;
                    startRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    boolean changed = startRestartGroup.changed((Object) function02);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new ModalBottomSheetKt$Scrim$dismissModifier$1$1(function02, (Continuation<? super ModalBottomSheetKt$Scrim$dismissModifier$1$1>) null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier2, (Object) function02, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue);
                    startRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    boolean changed2 = startRestartGroup.changed((Object) r7) | startRestartGroup.changed((Object) function02);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new ModalBottomSheetKt$Scrim$dismissModifier$2$1(r7, function02);
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceableGroup();
                    modifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) rememberedValue2);
                } else {
                    modifier = Modifier.Companion;
                }
                startRestartGroup.endReplaceableGroup();
                Modifier then = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null).then(modifier);
                Color r10 = Color.m1922boximpl(j);
                startRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                boolean changed3 = startRestartGroup.changed((Object) r10) | startRestartGroup.changed((Object) animateFloatAsState);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new ModalBottomSheetKt$Scrim$1$1(j2, animateFloatAsState);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(then, (Function1) rememberedValue3, startRestartGroup, 0);
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ModalBottomSheetKt$Scrim$2(j, function0, z, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Scrim_3J_VO9M$lambda-0  reason: not valid java name */
    public static final float m1334Scrim_3J_VO9M$lambda0(State<Float> state) {
        return state.getValue().floatValue();
    }
}
