package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
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
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0001\u0010\b\u001a\u00020\t2\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a3\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00192\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\u0006\u0010#\u001a\u00020\u0014H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%\u001a\u0001\u0010&\u001a\u00020\t2\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020'2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)\u001aA\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u00142\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d2\u0006\u0010!\u001a\u00020\u0019H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/\u001a \u00100\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u0002H\u0002\u001a+\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u0002062\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00140\u000bH\u0007¢\u0006\u0002\u00108\u001a+\u00109\u001a\u00020'2\u0006\u00105\u001a\u00020:2\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u00140\u000bH\u0007¢\u0006\u0002\u0010;\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006<"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomDrawerOpenFraction", "DrawerVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "EndDrawerPadding", "BottomDrawer", "", "drawerContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "drawerState", "Landroidx/compose/material/BottomDrawerState;", "gesturesEnabled", "", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "scrimColor", "content", "Lkotlin/Function0;", "BottomDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomDrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "BottomDrawerScrim", "color", "onDismiss", "visible", "BottomDrawerScrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "ModalDrawer", "Landroidx/compose/material/DrawerState;", "ModalDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/DrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "open", "onClose", "fraction", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "calculateFraction", "a", "b", "pos", "rememberBottomDrawerState", "initialValue", "Landroidx/compose/material/BottomDrawerValue;", "confirmStateChange", "(Landroidx/compose/material/BottomDrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomDrawerState;", "rememberDrawerState", "Landroidx/compose/material/DrawerValue;", "(Landroidx/compose/material/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DrawerState;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Drawer.kt */
public final class DrawerKt {
    /* access modifiers changed from: private */
    public static final TweenSpec<Float> AnimationSpec = new TweenSpec(256, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    private static final float BottomDrawerOpenFraction = 0.5f;
    /* access modifiers changed from: private */
    public static final float DrawerVelocityThreshold = Dp.m4704constructorimpl((float) 400);
    /* access modifiers changed from: private */
    public static final float EndDrawerPadding = Dp.m4704constructorimpl((float) 56);

    public static final DrawerState rememberDrawerState(DrawerValue drawerValue, Function1<? super DrawerValue, Boolean> function1, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(drawerValue, "initialValue");
        composer.startReplaceableGroup(-1435874229);
        ComposerKt.sourceInformation(composer, "C(rememberDrawerState)P(1)320@10387L125:Drawer.kt#jmzs0o");
        Function1 function12 = function1;
        if ((i2 & 2) != 0) {
            function12 = DrawerKt$rememberDrawerState$1.INSTANCE;
        }
        DrawerState drawerState = (DrawerState) RememberSaveableKt.rememberSaveable(new Object[0], DrawerState.Companion.Saver(function12), (String) null, new DrawerKt$rememberDrawerState$2(drawerValue, function12), composer, 72, 4);
        composer.endReplaceableGroup();
        return drawerState;
    }

    @ExperimentalMaterialApi
    public static final BottomDrawerState rememberBottomDrawerState(BottomDrawerValue bottomDrawerValue, Function1<? super BottomDrawerValue, Boolean> function1, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(bottomDrawerValue, "initialValue");
        composer.startReplaceableGroup(-598115156);
        ComposerKt.sourceInformation(composer, "C(rememberBottomDrawerState)P(1)337@10933L137:Drawer.kt#jmzs0o");
        Function1 function12 = function1;
        if ((i2 & 2) != 0) {
            function12 = DrawerKt$rememberBottomDrawerState$1.INSTANCE;
        }
        BottomDrawerState bottomDrawerState = (BottomDrawerState) RememberSaveableKt.rememberSaveable(new Object[0], BottomDrawerState.Companion.Saver(function12), (String) null, new DrawerKt$rememberBottomDrawerState$2(bottomDrawerValue, function12), composer, 72, 4);
        composer.endReplaceableGroup();
        return bottomDrawerState;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x011f  */
    /* renamed from: ModalDrawer-Gs3lGvM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1263ModalDrawerGs3lGvM(kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.ui.Modifier r33, androidx.compose.material.DrawerState r34, boolean r35, androidx.compose.ui.graphics.Shape r36, float r37, long r38, long r40, long r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, androidx.compose.runtime.Composer r45, int r46, int r47) {
        /*
            r15 = r32
            r14 = r44
            r13 = r46
            r12 = r47
            java.lang.String r0 = "drawerContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1305806945(0x4dd50861, float:4.46762016E8)
            r1 = r45
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(ModalDrawer)P(2,8,6,7,5,4:c#ui.unit.Dp,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9:c#ui.graphics.Color)376@12880L39,378@12997L6,380@13112L6,381@13160L38,382@13239L10,385@13307L24,386@13336L3205:Drawer.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0027
            r0 = r13 | 6
            goto L_0x0037
        L_0x0027:
            r0 = r13 & 14
            if (r0 != 0) goto L_0x0036
            boolean r0 = r11.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0033
            r0 = 4
            goto L_0x0034
        L_0x0033:
            r0 = 2
        L_0x0034:
            r0 = r0 | r13
            goto L_0x0037
        L_0x0036:
            r0 = r13
        L_0x0037:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x003e
            r0 = r0 | 48
            goto L_0x0051
        L_0x003e:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0051
            r3 = r33
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x004d
            r4 = 32
            goto L_0x004f
        L_0x004d:
            r4 = 16
        L_0x004f:
            r0 = r0 | r4
            goto L_0x0053
        L_0x0051:
            r3 = r33
        L_0x0053:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x006c
            r4 = r12 & 4
            if (r4 != 0) goto L_0x0066
            r4 = r34
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0068
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0066:
            r4 = r34
        L_0x0068:
            r5 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r0 = r0 | r5
            goto L_0x006e
        L_0x006c:
            r4 = r34
        L_0x006e:
            r5 = r12 & 8
            if (r5 == 0) goto L_0x0075
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0088
        L_0x0075:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0088
            r6 = r35
            boolean r7 = r11.changed((boolean) r6)
            if (r7 == 0) goto L_0x0084
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0086
        L_0x0084:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0086:
            r0 = r0 | r7
            goto L_0x008a
        L_0x0088:
            r6 = r35
        L_0x008a:
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r13
            if (r7 != 0) goto L_0x00a5
            r7 = r12 & 16
            if (r7 != 0) goto L_0x009f
            r7 = r36
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x00a1
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x009f:
            r7 = r36
        L_0x00a1:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r0 = r0 | r8
            goto L_0x00a7
        L_0x00a5:
            r7 = r36
        L_0x00a7:
            r8 = r12 & 32
            if (r8 == 0) goto L_0x00af
            r9 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r9
            goto L_0x00c3
        L_0x00af:
            r9 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r13
            if (r9 != 0) goto L_0x00c3
            r9 = r37
            boolean r10 = r11.changed((float) r9)
            if (r10 == 0) goto L_0x00bf
            r10 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c1
        L_0x00bf:
            r10 = 65536(0x10000, float:9.18355E-41)
        L_0x00c1:
            r0 = r0 | r10
            goto L_0x00c5
        L_0x00c3:
            r9 = r37
        L_0x00c5:
            r10 = 3670016(0x380000, float:5.142788E-39)
            r10 = r10 & r13
            if (r10 != 0) goto L_0x00e2
            r10 = r12 & 64
            if (r10 != 0) goto L_0x00da
            r10 = r2
            r1 = r38
            boolean r16 = r11.changed((long) r1)
            if (r16 == 0) goto L_0x00dd
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00df
        L_0x00da:
            r10 = r2
            r1 = r38
        L_0x00dd:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00df:
            r0 = r0 | r16
            goto L_0x00e5
        L_0x00e2:
            r10 = r2
            r1 = r38
        L_0x00e5:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x0101
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 != 0) goto L_0x00fa
            r1 = r40
            boolean r16 = r11.changed((long) r1)
            if (r16 == 0) goto L_0x00fc
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fe
        L_0x00fa:
            r1 = r40
        L_0x00fc:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fe:
            r0 = r0 | r16
            goto L_0x0103
        L_0x0101:
            r1 = r40
        L_0x0103:
            r16 = 234881024(0xe000000, float:1.5777218E-30)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x011f
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 != 0) goto L_0x0118
            r1 = r42
            boolean r16 = r11.changed((long) r1)
            if (r16 == 0) goto L_0x011a
            r16 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011c
        L_0x0118:
            r1 = r42
        L_0x011a:
            r16 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011c:
            r0 = r0 | r16
            goto L_0x0121
        L_0x011f:
            r1 = r42
        L_0x0121:
            r1 = r12 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0129
            r1 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0127:
            r0 = r0 | r1
            goto L_0x013a
        L_0x0129:
            r1 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r13
            if (r1 != 0) goto L_0x013a
            boolean r1 = r11.changed((java.lang.Object) r14)
            if (r1 == 0) goto L_0x0137
            r1 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0127
        L_0x0137:
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0127
        L_0x013a:
            r1 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r1 = r1 & r0
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x015b
            boolean r1 = r11.getSkipping()
            if (r1 != 0) goto L_0x014a
            goto L_0x015b
        L_0x014a:
            r11.skipToGroupEnd()
            r2 = r3
            r3 = r4
            r4 = r6
            r5 = r7
            r6 = r9
            r15 = r11
            r7 = r38
            r9 = r40
            r11 = r42
            goto L_0x02d0
        L_0x015b:
            r11.startDefaults()
            r1 = r13 & 1
            r16 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            if (r1 == 0) goto L_0x01a7
            boolean r1 = r11.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0172
            goto L_0x01a7
        L_0x0172:
            r11.skipToGroupEnd()
            r1 = r12 & 4
            if (r1 == 0) goto L_0x017b
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x017b:
            r1 = r12 & 16
            if (r1 == 0) goto L_0x0181
            r0 = r0 & r18
        L_0x0181:
            r1 = r12 & 64
            if (r1 == 0) goto L_0x0187
            r0 = r0 & r17
        L_0x0187:
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x018d
            r0 = r0 & r16
        L_0x018d:
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0195
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r1
        L_0x0195:
            r21 = r38
            r23 = r40
            r25 = r42
            r16 = r4
            r17 = r6
            r18 = r7
            r19 = r9
            r9 = r3
        L_0x01a4:
            r3 = r0
            goto L_0x0230
        L_0x01a7:
            if (r10 == 0) goto L_0x01ae
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x01af
        L_0x01ae:
            r1 = r3
        L_0x01af:
            r3 = r12 & 4
            r10 = 6
            if (r3 == 0) goto L_0x01bf
            androidx.compose.material.DrawerValue r3 = androidx.compose.material.DrawerValue.Closed
            r2 = 2
            r4 = 0
            androidx.compose.material.DrawerState r2 = rememberDrawerState(r3, r4, r11, r10, r2)
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x01c0
        L_0x01bf:
            r2 = r4
        L_0x01c0:
            if (r5 == 0) goto L_0x01c3
            r6 = 1
        L_0x01c3:
            r3 = r12 & 16
            if (r3 == 0) goto L_0x01d6
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r3 = r3.getShapes(r11, r10)
            androidx.compose.foundation.shape.CornerBasedShape r3 = r3.getLarge()
            androidx.compose.ui.graphics.Shape r3 = (androidx.compose.ui.graphics.Shape) r3
            r0 = r0 & r18
            goto L_0x01d7
        L_0x01d6:
            r3 = r7
        L_0x01d7:
            if (r8 == 0) goto L_0x01e0
            androidx.compose.material.DrawerDefaults r4 = androidx.compose.material.DrawerDefaults.INSTANCE
            float r4 = r4.m1259getElevationD9Ej5fM()
            goto L_0x01e1
        L_0x01e0:
            r4 = r9
        L_0x01e1:
            r5 = r12 & 64
            if (r5 == 0) goto L_0x01f2
            androidx.compose.material.MaterialTheme r5 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r5 = r5.getColors(r11, r10)
            long r7 = r5.m1218getSurface0d7_KjU()
            r0 = r0 & r17
            goto L_0x01f4
        L_0x01f2:
            r7 = r38
        L_0x01f4:
            r5 = r12 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x0203
            int r5 = r0 >> 18
            r5 = r5 & 14
            long r17 = androidx.compose.material.ColorsKt.m1232contentColorForek8zF_U(r7, r11, r5)
            r0 = r0 & r16
            goto L_0x0205
        L_0x0203:
            r17 = r40
        L_0x0205:
            r5 = r12 & 256(0x100, float:3.59E-43)
            if (r5 == 0) goto L_0x021f
            androidx.compose.material.DrawerDefaults r5 = androidx.compose.material.DrawerDefaults.INSTANCE
            long r9 = r5.getScrimColor(r11, r10)
            r5 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r5
            r16 = r2
            r19 = r4
            r21 = r7
            r25 = r9
            r23 = r17
            r9 = r1
            goto L_0x022a
        L_0x021f:
            r25 = r42
            r9 = r1
            r16 = r2
            r19 = r4
            r21 = r7
            r23 = r17
        L_0x022a:
            r18 = r3
            r17 = r6
            goto L_0x01a4
        L_0x0230:
            r11.endDefaults()
            r0 = 773894976(0x2e20b340, float:3.6538994E-11)
            r11.startReplaceableGroup(r0)
            java.lang.String r0 = "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            java.lang.Object r0 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x0266
            kotlin.coroutines.EmptyCoroutineContext r0 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r11)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r0)
            r11.updateRememberedValue(r1)
            r0 = r1
        L_0x0266:
            r11.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r27 = r0.getCoroutineScope()
            r11.endReplaceableGroup()
            r0 = 0
            r1 = 0
            r2 = 1
            androidx.compose.ui.Modifier r20 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r9, r0, r2, r1)
            r28 = 0
            r29 = 0
            r10 = 816674999(0x30ad78b7, float:1.2621716E-9)
            androidx.compose.material.DrawerKt$ModalDrawer$1 r7 = new androidx.compose.material.DrawerKt$ModalDrawer$1
            r0 = r7
            r1 = r16
            r8 = 1
            r2 = r17
            r4 = r25
            r6 = r18
            r33 = r7
            r15 = 1
            r7 = r21
            r30 = r9
            r15 = 816674999(0x30ad78b7, float:1.2621716E-9)
            r9 = r23
            r15 = r11
            r11 = r19
            r12 = r44
            r13 = r27
            r14 = r32
            r0.<init>(r1, r2, r3, r4, r6, r7, r9, r11, r12, r13, r14)
            r1 = r33
            r0 = 816674999(0x30ad78b7, float:1.2621716E-9)
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r2, r1)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r1 = 3072(0xc00, float:4.305E-42)
            r2 = 6
            r33 = r20
            r34 = r28
            r35 = r29
            r36 = r0
            r37 = r15
            r38 = r1
            r39 = r2
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r33, r34, r35, r36, r37, r38, r39)
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r11 = r25
            r2 = r30
        L_0x02d0:
            androidx.compose.runtime.ScopeUpdateScope r15 = r15.endRestartGroup()
            if (r15 != 0) goto L_0x02d7
            goto L_0x02f1
        L_0x02d7:
            androidx.compose.material.DrawerKt$ModalDrawer$2 r16 = new androidx.compose.material.DrawerKt$ModalDrawer$2
            r0 = r16
            r1 = r32
            r13 = r44
            r14 = r46
            r31 = r15
            r15 = r47
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r11, r13, r14, r15)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r31
            r1.updateScope(r0)
        L_0x02f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.m1263ModalDrawerGs3lGvM(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.DrawerState, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x02dd  */
    /* JADX WARNING: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x011f  */
    @androidx.compose.material.ExperimentalMaterialApi
    /* renamed from: BottomDrawer-Gs3lGvM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1260BottomDrawerGs3lGvM(kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.ui.Modifier r33, androidx.compose.material.BottomDrawerState r34, boolean r35, androidx.compose.ui.graphics.Shape r36, float r37, long r38, long r40, long r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, androidx.compose.runtime.Composer r45, int r46, int r47) {
        /*
            r15 = r32
            r14 = r44
            r13 = r46
            r12 = r47
            java.lang.String r0 = "drawerContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 625649286(0x254aa686, float:1.7577127E-16)
            r1 = r45
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(BottomDrawer)P(2,8,6,7,5,4:c#ui.unit.Dp,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9:c#ui.graphics.Color)499@18420L51,501@18549L6,503@18664L6,504@18712L38,505@18791L10,508@18859L24,510@18889L3335:Drawer.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0027
            r0 = r13 | 6
            goto L_0x0037
        L_0x0027:
            r0 = r13 & 14
            if (r0 != 0) goto L_0x0036
            boolean r0 = r10.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0033
            r0 = 4
            goto L_0x0034
        L_0x0033:
            r0 = 2
        L_0x0034:
            r0 = r0 | r13
            goto L_0x0037
        L_0x0036:
            r0 = r13
        L_0x0037:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x003e
            r0 = r0 | 48
            goto L_0x0051
        L_0x003e:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0051
            r3 = r33
            boolean r4 = r10.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x004d
            r4 = 32
            goto L_0x004f
        L_0x004d:
            r4 = 16
        L_0x004f:
            r0 = r0 | r4
            goto L_0x0053
        L_0x0051:
            r3 = r33
        L_0x0053:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x006c
            r4 = r12 & 4
            if (r4 != 0) goto L_0x0066
            r4 = r34
            boolean r5 = r10.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0068
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0066:
            r4 = r34
        L_0x0068:
            r5 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r0 = r0 | r5
            goto L_0x006e
        L_0x006c:
            r4 = r34
        L_0x006e:
            r5 = r12 & 8
            if (r5 == 0) goto L_0x0075
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0088
        L_0x0075:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0088
            r6 = r35
            boolean r7 = r10.changed((boolean) r6)
            if (r7 == 0) goto L_0x0084
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0086
        L_0x0084:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0086:
            r0 = r0 | r7
            goto L_0x008a
        L_0x0088:
            r6 = r35
        L_0x008a:
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r13
            if (r7 != 0) goto L_0x00a5
            r7 = r12 & 16
            if (r7 != 0) goto L_0x009f
            r7 = r36
            boolean r8 = r10.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x00a1
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x009f:
            r7 = r36
        L_0x00a1:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r0 = r0 | r8
            goto L_0x00a7
        L_0x00a5:
            r7 = r36
        L_0x00a7:
            r8 = r12 & 32
            if (r8 == 0) goto L_0x00af
            r9 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r9
            goto L_0x00c3
        L_0x00af:
            r9 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r13
            if (r9 != 0) goto L_0x00c3
            r9 = r37
            boolean r11 = r10.changed((float) r9)
            if (r11 == 0) goto L_0x00bf
            r11 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c1
        L_0x00bf:
            r11 = 65536(0x10000, float:9.18355E-41)
        L_0x00c1:
            r0 = r0 | r11
            goto L_0x00c5
        L_0x00c3:
            r9 = r37
        L_0x00c5:
            r11 = 3670016(0x380000, float:5.142788E-39)
            r11 = r11 & r13
            if (r11 != 0) goto L_0x00e2
            r11 = r12 & 64
            if (r11 != 0) goto L_0x00da
            r11 = r2
            r1 = r38
            boolean r16 = r10.changed((long) r1)
            if (r16 == 0) goto L_0x00dd
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00df
        L_0x00da:
            r11 = r2
            r1 = r38
        L_0x00dd:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00df:
            r0 = r0 | r16
            goto L_0x00e5
        L_0x00e2:
            r11 = r2
            r1 = r38
        L_0x00e5:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x0101
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 != 0) goto L_0x00fa
            r1 = r40
            boolean r16 = r10.changed((long) r1)
            if (r16 == 0) goto L_0x00fc
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fe
        L_0x00fa:
            r1 = r40
        L_0x00fc:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fe:
            r0 = r0 | r16
            goto L_0x0103
        L_0x0101:
            r1 = r40
        L_0x0103:
            r16 = 234881024(0xe000000, float:1.5777218E-30)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x011f
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 != 0) goto L_0x0118
            r1 = r42
            boolean r16 = r10.changed((long) r1)
            if (r16 == 0) goto L_0x011a
            r16 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011c
        L_0x0118:
            r1 = r42
        L_0x011a:
            r16 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011c:
            r0 = r0 | r16
            goto L_0x0121
        L_0x011f:
            r1 = r42
        L_0x0121:
            r1 = r12 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0129
            r1 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0127:
            r0 = r0 | r1
            goto L_0x013a
        L_0x0129:
            r1 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r13
            if (r1 != 0) goto L_0x013a
            boolean r1 = r10.changed((java.lang.Object) r14)
            if (r1 == 0) goto L_0x0137
            r1 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0127
        L_0x0137:
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0127
        L_0x013a:
            r1 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r1 = r1 & r0
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x015b
            boolean r1 = r10.getSkipping()
            if (r1 != 0) goto L_0x014a
            goto L_0x015b
        L_0x014a:
            r10.skipToGroupEnd()
            r11 = r42
            r2 = r3
            r3 = r4
            r4 = r6
            r5 = r7
            r6 = r9
            r15 = r10
            r7 = r38
            r9 = r40
            goto L_0x02d6
        L_0x015b:
            r10.startDefaults()
            r1 = r13 & 1
            r16 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            if (r1 == 0) goto L_0x01a7
            boolean r1 = r10.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0172
            goto L_0x01a7
        L_0x0172:
            r10.skipToGroupEnd()
            r1 = r12 & 4
            if (r1 == 0) goto L_0x017b
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x017b:
            r1 = r12 & 16
            if (r1 == 0) goto L_0x0181
            r0 = r0 & r18
        L_0x0181:
            r1 = r12 & 64
            if (r1 == 0) goto L_0x0187
            r0 = r0 & r17
        L_0x0187:
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x018d
            r0 = r0 & r16
        L_0x018d:
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0195
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r1
        L_0x0195:
            r21 = r38
            r23 = r40
            r25 = r42
            r11 = r3
            r16 = r4
            r17 = r6
            r18 = r7
            r19 = r9
            r4 = r0
            goto L_0x0234
        L_0x01a7:
            if (r11 == 0) goto L_0x01ae
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x01af
        L_0x01ae:
            r1 = r3
        L_0x01af:
            r3 = r12 & 4
            r11 = 6
            if (r3 == 0) goto L_0x01bf
            androidx.compose.material.BottomDrawerValue r3 = androidx.compose.material.BottomDrawerValue.Closed
            r2 = 2
            r4 = 0
            androidx.compose.material.BottomDrawerState r2 = rememberBottomDrawerState(r3, r4, r10, r11, r2)
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x01c0
        L_0x01bf:
            r2 = r4
        L_0x01c0:
            if (r5 == 0) goto L_0x01c3
            r6 = 1
        L_0x01c3:
            r3 = r12 & 16
            if (r3 == 0) goto L_0x01d6
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r3 = r3.getShapes(r10, r11)
            androidx.compose.foundation.shape.CornerBasedShape r3 = r3.getLarge()
            androidx.compose.ui.graphics.Shape r3 = (androidx.compose.ui.graphics.Shape) r3
            r0 = r0 & r18
            goto L_0x01d7
        L_0x01d6:
            r3 = r7
        L_0x01d7:
            if (r8 == 0) goto L_0x01e0
            androidx.compose.material.DrawerDefaults r4 = androidx.compose.material.DrawerDefaults.INSTANCE
            float r4 = r4.m1259getElevationD9Ej5fM()
            goto L_0x01e1
        L_0x01e0:
            r4 = r9
        L_0x01e1:
            r5 = r12 & 64
            if (r5 == 0) goto L_0x01f2
            androidx.compose.material.MaterialTheme r5 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r5 = r5.getColors(r10, r11)
            long r7 = r5.m1218getSurface0d7_KjU()
            r0 = r0 & r17
            goto L_0x01f4
        L_0x01f2:
            r7 = r38
        L_0x01f4:
            r5 = r12 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x0203
            int r5 = r0 >> 18
            r5 = r5 & 14
            long r17 = androidx.compose.material.ColorsKt.m1232contentColorForek8zF_U(r7, r10, r5)
            r0 = r0 & r16
            goto L_0x0205
        L_0x0203:
            r17 = r40
        L_0x0205:
            r5 = r12 & 256(0x100, float:3.59E-43)
            if (r5 == 0) goto L_0x0224
            androidx.compose.material.DrawerDefaults r5 = androidx.compose.material.DrawerDefaults.INSTANCE
            long r21 = r5.getScrimColor(r10, r11)
            r5 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r5
            r11 = r1
            r16 = r2
            r19 = r4
            r23 = r17
            r25 = r21
            r4 = r0
            r18 = r3
            r17 = r6
            r21 = r7
            goto L_0x0234
        L_0x0224:
            r25 = r42
            r11 = r1
            r16 = r2
            r19 = r4
            r21 = r7
            r23 = r17
            r4 = r0
            r18 = r3
            r17 = r6
        L_0x0234:
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
            if (r0 != r1) goto L_0x026a
            kotlin.coroutines.EmptyCoroutineContext r0 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r10)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r0)
            r10.updateRememberedValue(r1)
            r0 = r1
        L_0x026a:
            r10.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r27 = r0.getCoroutineScope()
            r10.endReplaceableGroup()
            r0 = 0
            r1 = 0
            r2 = 1
            androidx.compose.ui.Modifier r20 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r11, r0, r2, r1)
            r28 = 0
            r29 = 0
            r8 = 1220102512(0x48b94970, float:379467.5)
            androidx.compose.material.DrawerKt$BottomDrawer$1 r9 = new androidx.compose.material.DrawerKt$BottomDrawer$1
            r0 = r9
            r1 = r17
            r7 = 1
            r2 = r16
            r3 = r44
            r5 = r25
            r15 = 1
            r7 = r18
            r15 = r9
            r8 = r21
            r30 = r11
            r34 = r15
            r15 = r10
            r10 = r23
            r12 = r19
            r13 = r27
            r14 = r32
            r0.<init>(r1, r2, r3, r4, r5, r7, r8, r10, r12, r13, r14)
            r1 = r34
            r0 = 1220102512(0x48b94970, float:379467.5)
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r2, r1)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r1 = 3072(0xc00, float:4.305E-42)
            r2 = 6
            r33 = r20
            r34 = r28
            r35 = r29
            r36 = r0
            r37 = r15
            r38 = r1
            r39 = r2
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r33, r34, r35, r36, r37, r38, r39)
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r21
            r9 = r23
            r11 = r25
            r2 = r30
        L_0x02d6:
            androidx.compose.runtime.ScopeUpdateScope r15 = r15.endRestartGroup()
            if (r15 != 0) goto L_0x02dd
            goto L_0x02f7
        L_0x02dd:
            androidx.compose.material.DrawerKt$BottomDrawer$2 r16 = new androidx.compose.material.DrawerKt$BottomDrawer$2
            r0 = r16
            r1 = r32
            r13 = r44
            r14 = r46
            r31 = r15
            r15 = r47
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r11, r13, r14, r15)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r31
            r1.updateScope(r0)
        L_0x02f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.m1260BottomDrawerGs3lGvM(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.BottomDrawerState, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final float calculateFraction(float f, float f2, float f3) {
        return RangesKt.coerceIn((f3 - f) / (f2 - f), 0.0f, 1.0f);
    }

    /* access modifiers changed from: private */
    /* renamed from: BottomDrawerScrim-3J-VO9M  reason: not valid java name */
    public static final void m1261BottomDrawerScrim3JVO9M(long j, Function0<Unit> function0, boolean z, Composer composer, int i) {
        int i2;
        Modifier modifier;
        long j2 = j;
        Function0<Unit> function02 = function0;
        boolean z2 = z;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-513067266);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomDrawerScrim)P(0:c#ui.graphics.Color)625@22930L121,629@23078L30,647@23631L62,643@23522L171:Drawer.kt#jmzs0o");
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
                String r7 = Strings_androidKt.m1417getString4foXLRw(Strings.Companion.m1410getCloseDrawerUdPEhr4(), startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-1298949409);
                ComposerKt.sourceInformation(startRestartGroup, "632@23216L73,635@23342L122");
                if (z2) {
                    Modifier modifier2 = Modifier.Companion;
                    startRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    boolean changed = startRestartGroup.changed((Object) function02);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new DrawerKt$BottomDrawerScrim$dismissModifier$1$1(function02, (Continuation<? super DrawerKt$BottomDrawerScrim$dismissModifier$1$1>) null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier2, (Object) function02, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue);
                    startRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    boolean changed2 = startRestartGroup.changed((Object) r7) | startRestartGroup.changed((Object) function02);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new DrawerKt$BottomDrawerScrim$dismissModifier$2$1(r7, function02);
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
                    rememberedValue3 = new DrawerKt$BottomDrawerScrim$1$1(j2, animateFloatAsState);
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
            endRestartGroup.updateScope(new DrawerKt$BottomDrawerScrim$2(j, function0, z, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Scrim-Bx497Mc  reason: not valid java name */
    public static final void m1264ScrimBx497Mc(boolean z, Function0<Unit> function0, Function0<Float> function02, long j, Composer composer, int i) {
        int i2;
        Modifier modifier;
        Composer startRestartGroup = composer.startRestartGroup(1983403750);
        ComposerKt.sourceInformation(startRestartGroup, "C(Scrim)P(3,2,1,0:c#ui.graphics.Color)660@23848L30,676@24292L51,672@24201L142:Drawer.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed((Object) function02) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changed(j) ? 2048 : 1024;
        }
        if ((i2 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            String r0 = Strings_androidKt.m1417getString4foXLRw(Strings.Companion.m1410getCloseDrawerUdPEhr4(), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(1010554047);
            ComposerKt.sourceInformation(startRestartGroup, "663@23967L35,664@24051L108");
            if (z) {
                Modifier modifier2 = Modifier.Companion;
                startRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                boolean changed = startRestartGroup.changed((Object) function0);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new DrawerKt$Scrim$dismissDrawer$1$1(function0, (Continuation<? super DrawerKt$Scrim$dismissDrawer$1$1>) null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier2, (Object) function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue);
                startRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                boolean changed2 = startRestartGroup.changed((Object) r0) | startRestartGroup.changed((Object) function0);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new DrawerKt$Scrim$dismissDrawer$2$1(r0, function0);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                modifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) rememberedValue2);
            } else {
                modifier = Modifier.Companion;
            }
            startRestartGroup.endReplaceableGroup();
            Modifier then = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null).then(modifier);
            Color r3 = Color.m1922boximpl(j);
            startRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
            boolean changed3 = startRestartGroup.changed((Object) r3) | startRestartGroup.changed((Object) function02);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new DrawerKt$Scrim$1$1(j, function02);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(then, (Function1) rememberedValue3, startRestartGroup, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DrawerKt$Scrim$2(z, function0, function02, j, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: BottomDrawerScrim_3J_VO9M$lambda-0  reason: not valid java name */
    public static final float m1262BottomDrawerScrim_3J_VO9M$lambda0(State<Float> state) {
        return state.getValue().floatValue();
    }
}
