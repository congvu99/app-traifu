package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aá\u0002\u0010\u0003\u001a\u00020\u00042\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f¢\u0006\u0002\b\b2\u0019\b\u0002\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\b2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f¢\u0006\u0002\b\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u00012 \b\u0002\u0010\u001e\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\u0002\b\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u001f\u001a\u00020\u00162\b\b\u0002\u0010 \u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u00012\b\b\u0002\u0010\"\u001a\u00020\u001b2\b\b\u0002\u0010#\u001a\u00020\u001b2\b\b\u0002\u0010$\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020\u001b2\b\b\u0002\u0010&\u001a\u00020\u001b2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*\u001aÈ\u0001\u0010+\u001a\u00020\u00042\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f¢\u0006\u0002\b\b2&\u0010,\u001a\"\u0012\u0013\u0012\u00110(¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\b2&\u00100\u001a\"\u0012\u0013\u0012\u001101¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\b2\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f¢\u0006\u0002\b\b2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\b2\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\f\u00103\u001a\b\u0012\u0004\u0012\u000205042\u0006\u00106\u001a\u000207H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00109\u001a+\u0010:\u001a\u00020\r2\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u0002072\b\b\u0002\u0010>\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010?\u001a;\u0010@\u001a\u0002072\u0006\u0010A\u001a\u00020B2\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u0002050D2\u0014\b\u0002\u0010E\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u00160\u0006H\u0007¢\u0006\u0002\u0010F\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006G"}, d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "BottomSheetScaffold", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/BottomSheetScaffoldState;", "topBar", "Lkotlin/Function0;", "snackbarHost", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "sheetGesturesEnabled", "", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetPeekHeight", "drawerContent", "drawerGesturesEnabled", "drawerShape", "drawerElevation", "drawerBackgroundColor", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-bGncdBI", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomSheetScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLandroidx/compose/ui/graphics/Shape;FJJFLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;IIII)V", "BottomSheetScaffoldLayout", "body", "Lkotlin/ParameterName;", "name", "innerPadding", "bottomSheet", "", "layoutHeight", "sheetOffset", "Landroidx/compose/runtime/State;", "", "sheetState", "Landroidx/compose/material/BottomSheetState;", "BottomSheetScaffoldLayout-KCBPh4w", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FILandroidx/compose/runtime/State;Landroidx/compose/material/BottomSheetState;Landroidx/compose/runtime/Composer;I)V", "rememberBottomSheetScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "bottomSheetState", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/BottomSheetState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetScaffoldState;", "rememberBottomSheetState", "initialValue", "Landroidx/compose/material/BottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetState;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
public final class BottomSheetScaffoldKt {
    /* access modifiers changed from: private */
    public static final float FabSpacing = Dp.m4704constructorimpl((float) 16);

    @ExperimentalMaterialApi
    public static final BottomSheetState rememberBottomSheetState(BottomSheetValue bottomSheetValue, AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> function1, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(bottomSheetValue, "initialValue");
        composer.startReplaceableGroup(1808153344);
        ComposerKt.sourceInformation(composer, "C(rememberBottomSheetState)P(2)163@5857L371:BottomSheetScaffold.kt#jmzs0o");
        AnimationSpec<Float> animationSpec2 = animationSpec;
        if ((i2 & 2) != 0) {
            animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        Function1<? super BottomSheetValue, Boolean> function12 = function1;
        if ((i2 & 4) != 0) {
            function12 = BottomSheetScaffoldKt$rememberBottomSheetState$1.INSTANCE;
        }
        BottomSheetState bottomSheetState = (BottomSheetState) RememberSaveableKt.rememberSaveable(new Object[]{animationSpec2}, BottomSheetState.Companion.Saver(animationSpec2, function12), (String) null, new BottomSheetScaffoldKt$rememberBottomSheetState$2(bottomSheetValue, animationSpec2, function12), composer, 72, 4);
        composer.endReplaceableGroup();
        return bottomSheetState;
    }

    @ExperimentalMaterialApi
    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(DrawerState drawerState, BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1353009744);
        ComposerKt.sourceInformation(composer, "C(rememberBottomSheetScaffoldState)P(1)203@7102L39,204@7184L35,205@7264L32,207@7338L248:BottomSheetScaffold.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, (Function1<? super DrawerValue, Boolean>) null, composer, 6, 2);
        }
        if ((i2 & 2) != 0) {
            bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed, (AnimationSpec<Float>) null, (Function1<? super BottomSheetValue, Boolean>) null, composer, 6, 6);
        }
        if ((i2 & 4) != 0) {
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) rememberedValue;
        }
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) drawerState) | composer.changed((Object) bottomSheetState) | composer.changed((Object) snackbarHostState);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new BottomSheetScaffoldState(drawerState, bottomSheetState, snackbarHostState);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) rememberedValue2;
        composer.endReplaceableGroup();
        return bottomSheetScaffoldState;
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x024d  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x02a0  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x02c8  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x02f7  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0324  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x06ba  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:370:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x014a  */
    @androidx.compose.material.ExperimentalMaterialApi
    /* renamed from: BottomSheetScaffold-bGncdBI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1155BottomSheetScaffoldbGncdBI(kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, androidx.compose.ui.Modifier r44, androidx.compose.material.BottomSheetScaffoldState r45, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, int r49, boolean r50, androidx.compose.ui.graphics.Shape r51, float r52, long r53, long r55, float r57, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, boolean r59, androidx.compose.ui.graphics.Shape r60, float r61, long r62, long r64, long r66, long r68, long r70, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r72, androidx.compose.runtime.Composer r73, int r74, int r75, int r76, int r77) {
        /*
            r1 = r43
            r15 = r72
            r13 = r74
            r14 = r75
            r11 = r76
            r12 = r77
            java.lang.String r0 = "sheetContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = 46422755(0x2c45ae3, float:2.8851778E-37)
            r2 = r73
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(BottomSheetScaffold)P(15,12,13,22,21,10,11:c#material.FabPosition,18,20,17:c#ui.unit.Dp,14:c#ui.graphics.Color,16:c#ui.graphics.Color,19:c#ui.unit.Dp,4,7,9,6:c#ui.unit.Dp,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,0:c#ui.graphics.Color,2:c#ui.graphics.Color)269@11027L34,275@11396L6,277@11527L6,278@11574L37,282@11831L6,284@11946L6,285@11994L38,286@12079L10,287@12134L6,288@12179L32,291@12282L24,*292@12348L7,293@12413L41,374@16003L713:BottomSheetScaffold.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = r12 & 1
            if (r2 == 0) goto L_0x002c
            r2 = r13 | 6
            goto L_0x003c
        L_0x002c:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x003b
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0038
            r2 = 4
            goto L_0x0039
        L_0x0038:
            r2 = 2
        L_0x0039:
            r2 = r2 | r13
            goto L_0x003c
        L_0x003b:
            r2 = r13
        L_0x003c:
            r4 = r12 & 2
            if (r4 == 0) goto L_0x0043
            r2 = r2 | 48
            goto L_0x0056
        L_0x0043:
            r7 = r13 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x0056
            r7 = r44
            boolean r9 = r0.changed((java.lang.Object) r7)
            if (r9 == 0) goto L_0x0052
            r9 = 32
            goto L_0x0054
        L_0x0052:
            r9 = 16
        L_0x0054:
            r2 = r2 | r9
            goto L_0x0058
        L_0x0056:
            r7 = r44
        L_0x0058:
            r9 = r13 & 896(0x380, float:1.256E-42)
            r16 = 256(0x100, float:3.59E-43)
            if (r9 != 0) goto L_0x0074
            r9 = r12 & 4
            if (r9 != 0) goto L_0x006d
            r9 = r45
            boolean r17 = r0.changed((java.lang.Object) r9)
            if (r17 == 0) goto L_0x006f
            r17 = 256(0x100, float:3.59E-43)
            goto L_0x0071
        L_0x006d:
            r9 = r45
        L_0x006f:
            r17 = 128(0x80, float:1.794E-43)
        L_0x0071:
            r2 = r2 | r17
            goto L_0x0076
        L_0x0074:
            r9 = r45
        L_0x0076:
            r17 = r12 & 8
            r18 = 2048(0x800, float:2.87E-42)
            r19 = 1024(0x400, float:1.435E-42)
            if (r17 == 0) goto L_0x0081
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0095
        L_0x0081:
            r3 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x0095
            r3 = r46
            boolean r20 = r0.changed((java.lang.Object) r3)
            if (r20 == 0) goto L_0x0090
            r20 = 2048(0x800, float:2.87E-42)
            goto L_0x0092
        L_0x0090:
            r20 = 1024(0x400, float:1.435E-42)
        L_0x0092:
            r2 = r2 | r20
            goto L_0x0097
        L_0x0095:
            r3 = r46
        L_0x0097:
            r20 = r12 & 16
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r20 == 0) goto L_0x00a2
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            r10 = r47
            goto L_0x00b8
        L_0x00a2:
            r22 = 57344(0xe000, float:8.0356E-41)
            r22 = r13 & r22
            r10 = r47
            if (r22 != 0) goto L_0x00b8
            boolean r23 = r0.changed((java.lang.Object) r10)
            if (r23 == 0) goto L_0x00b4
            r23 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00b6
        L_0x00b4:
            r23 = 8192(0x2000, float:1.14794E-41)
        L_0x00b6:
            r2 = r2 | r23
        L_0x00b8:
            r23 = r12 & 32
            r24 = 131072(0x20000, float:1.83671E-40)
            if (r23 == 0) goto L_0x00c5
            r25 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r25
            r8 = r48
            goto L_0x00da
        L_0x00c5:
            r25 = 458752(0x70000, float:6.42848E-40)
            r25 = r13 & r25
            r8 = r48
            if (r25 != 0) goto L_0x00da
            boolean r26 = r0.changed((java.lang.Object) r8)
            if (r26 == 0) goto L_0x00d6
            r26 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d8
        L_0x00d6:
            r26 = 65536(0x10000, float:9.18355E-41)
        L_0x00d8:
            r2 = r2 | r26
        L_0x00da:
            r26 = r12 & 64
            r27 = 1048576(0x100000, float:1.469368E-39)
            r28 = 524288(0x80000, float:7.34684E-40)
            if (r26 == 0) goto L_0x00e9
            r29 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r29
            r7 = r49
            goto L_0x00fe
        L_0x00e9:
            r29 = 3670016(0x380000, float:5.142788E-39)
            r29 = r13 & r29
            r7 = r49
            if (r29 != 0) goto L_0x00fe
            boolean r29 = r0.changed((int) r7)
            if (r29 == 0) goto L_0x00fa
            r29 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00fc
        L_0x00fa:
            r29 = 524288(0x80000, float:7.34684E-40)
        L_0x00fc:
            r2 = r2 | r29
        L_0x00fe:
            r7 = r12 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0107
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            r2 = r2 | r29
            goto L_0x011f
        L_0x0107:
            r29 = 29360128(0x1c00000, float:7.052966E-38)
            r29 = r13 & r29
            if (r29 != 0) goto L_0x011f
            r29 = r7
            r7 = r50
            boolean r30 = r0.changed((boolean) r7)
            if (r30 == 0) goto L_0x011a
            r30 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x011c
        L_0x011a:
            r30 = 4194304(0x400000, float:5.877472E-39)
        L_0x011c:
            r2 = r2 | r30
            goto L_0x0123
        L_0x011f:
            r29 = r7
            r7 = r50
        L_0x0123:
            r30 = 234881024(0xe000000, float:1.5777218E-30)
            r30 = r13 & r30
            if (r30 != 0) goto L_0x013f
            r5 = r12 & 256(0x100, float:3.59E-43)
            if (r5 != 0) goto L_0x0138
            r5 = r51
            boolean r31 = r0.changed((java.lang.Object) r5)
            if (r31 == 0) goto L_0x013a
            r31 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x013c
        L_0x0138:
            r5 = r51
        L_0x013a:
            r31 = 33554432(0x2000000, float:9.403955E-38)
        L_0x013c:
            r2 = r2 | r31
            goto L_0x0141
        L_0x013f:
            r5 = r51
        L_0x0141:
            r7 = r12 & 512(0x200, float:7.175E-43)
            if (r7 == 0) goto L_0x014a
            r31 = 805306368(0x30000000, float:4.656613E-10)
            r2 = r2 | r31
            goto L_0x0162
        L_0x014a:
            r31 = 1879048192(0x70000000, float:1.58456325E29)
            r31 = r13 & r31
            if (r31 != 0) goto L_0x0162
            r31 = r7
            r7 = r52
            boolean r32 = r0.changed((float) r7)
            if (r32 == 0) goto L_0x015d
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x015f
        L_0x015d:
            r32 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x015f:
            r2 = r2 | r32
            goto L_0x0166
        L_0x0162:
            r31 = r7
            r7 = r52
        L_0x0166:
            r32 = r14 & 14
            if (r32 != 0) goto L_0x017b
            r6 = r12 & 1024(0x400, float:1.435E-42)
            r7 = r53
            if (r6 != 0) goto L_0x0178
            boolean r6 = r0.changed((long) r7)
            if (r6 == 0) goto L_0x0178
            r6 = 4
            goto L_0x0179
        L_0x0178:
            r6 = 2
        L_0x0179:
            r6 = r6 | r14
            goto L_0x017e
        L_0x017b:
            r7 = r53
            r6 = r14
        L_0x017e:
            r33 = r14 & 112(0x70, float:1.57E-43)
            if (r33 != 0) goto L_0x0195
            r1 = r12 & 2048(0x800, float:2.87E-42)
            r7 = r55
            if (r1 != 0) goto L_0x0191
            boolean r1 = r0.changed((long) r7)
            if (r1 == 0) goto L_0x0191
            r1 = 32
            goto L_0x0193
        L_0x0191:
            r1 = 16
        L_0x0193:
            r6 = r6 | r1
            goto L_0x0197
        L_0x0195:
            r7 = r55
        L_0x0197:
            r1 = r12 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x019e
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x01b2
        L_0x019e:
            r3 = r14 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x01b2
            r3 = r57
            boolean r33 = r0.changed((float) r3)
            if (r33 == 0) goto L_0x01ad
            r33 = 256(0x100, float:3.59E-43)
            goto L_0x01af
        L_0x01ad:
            r33 = 128(0x80, float:1.794E-43)
        L_0x01af:
            r6 = r6 | r33
            goto L_0x01b4
        L_0x01b2:
            r3 = r57
        L_0x01b4:
            r7 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r7 == 0) goto L_0x01bb
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x01cd
        L_0x01bb:
            r8 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x01cd
            r8 = r58
            boolean r33 = r0.changed((java.lang.Object) r8)
            if (r33 == 0) goto L_0x01c8
            goto L_0x01ca
        L_0x01c8:
            r18 = 1024(0x400, float:1.435E-42)
        L_0x01ca:
            r6 = r6 | r18
            goto L_0x01cf
        L_0x01cd:
            r8 = r58
        L_0x01cf:
            r18 = r7
            r7 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r7 == 0) goto L_0x01d8
            r6 = r6 | 24576(0x6000, float:3.4438E-41)
            goto L_0x01ee
        L_0x01d8:
            r19 = 57344(0xe000, float:8.0356E-41)
            r19 = r14 & r19
            if (r19 != 0) goto L_0x01ee
            r19 = r7
            r7 = r59
            boolean r33 = r0.changed((boolean) r7)
            if (r33 == 0) goto L_0x01eb
            r21 = 16384(0x4000, float:2.2959E-41)
        L_0x01eb:
            r6 = r6 | r21
            goto L_0x01f2
        L_0x01ee:
            r19 = r7
            r7 = r59
        L_0x01f2:
            r21 = 458752(0x70000, float:6.42848E-40)
            r21 = r14 & r21
            if (r21 != 0) goto L_0x020f
            r21 = 32768(0x8000, float:4.5918E-41)
            r21 = r12 & r21
            r7 = r60
            if (r21 != 0) goto L_0x020a
            boolean r21 = r0.changed((java.lang.Object) r7)
            if (r21 == 0) goto L_0x020a
            r21 = 131072(0x20000, float:1.83671E-40)
            goto L_0x020c
        L_0x020a:
            r21 = 65536(0x10000, float:9.18355E-41)
        L_0x020c:
            r6 = r6 | r21
            goto L_0x0211
        L_0x020f:
            r7 = r60
        L_0x0211:
            r21 = 65536(0x10000, float:9.18355E-41)
            r21 = r12 & r21
            if (r21 == 0) goto L_0x021e
            r33 = 1572864(0x180000, float:2.204052E-39)
            r6 = r6 | r33
            r7 = r61
            goto L_0x0233
        L_0x021e:
            r33 = 3670016(0x380000, float:5.142788E-39)
            r33 = r14 & r33
            r7 = r61
            if (r33 != 0) goto L_0x0233
            boolean r33 = r0.changed((float) r7)
            if (r33 == 0) goto L_0x022f
            r33 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0231
        L_0x022f:
            r33 = 524288(0x80000, float:7.34684E-40)
        L_0x0231:
            r6 = r6 | r33
        L_0x0233:
            r33 = 29360128(0x1c00000, float:7.052966E-38)
            r33 = r14 & r33
            if (r33 != 0) goto L_0x024d
            r33 = r12 & r24
            r7 = r62
            if (r33 != 0) goto L_0x0248
            boolean r33 = r0.changed((long) r7)
            if (r33 == 0) goto L_0x0248
            r33 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x024a
        L_0x0248:
            r33 = 4194304(0x400000, float:5.877472E-39)
        L_0x024a:
            r6 = r6 | r33
            goto L_0x024f
        L_0x024d:
            r7 = r62
        L_0x024f:
            r33 = 234881024(0xe000000, float:1.5777218E-30)
            r33 = r14 & r33
            if (r33 != 0) goto L_0x026b
            r33 = 262144(0x40000, float:3.67342E-40)
            r33 = r12 & r33
            r7 = r64
            if (r33 != 0) goto L_0x0266
            boolean r33 = r0.changed((long) r7)
            if (r33 == 0) goto L_0x0266
            r33 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0268
        L_0x0266:
            r33 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0268:
            r6 = r6 | r33
            goto L_0x026d
        L_0x026b:
            r7 = r64
        L_0x026d:
            r33 = 1879048192(0x70000000, float:1.58456325E29)
            r33 = r14 & r33
            if (r33 != 0) goto L_0x0287
            r33 = r12 & r28
            r7 = r66
            if (r33 != 0) goto L_0x0282
            boolean r33 = r0.changed((long) r7)
            if (r33 == 0) goto L_0x0282
            r33 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0284
        L_0x0282:
            r33 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0284:
            r6 = r6 | r33
            goto L_0x0289
        L_0x0287:
            r7 = r66
        L_0x0289:
            r33 = r6
            r6 = r11 & 14
            if (r6 != 0) goto L_0x02a0
            r6 = r12 & r27
            r7 = r68
            if (r6 != 0) goto L_0x029d
            boolean r6 = r0.changed((long) r7)
            if (r6 == 0) goto L_0x029d
            r6 = 4
            goto L_0x029e
        L_0x029d:
            r6 = 2
        L_0x029e:
            r6 = r6 | r11
            goto L_0x02a3
        L_0x02a0:
            r7 = r68
            r6 = r11
        L_0x02a3:
            r34 = r11 & 112(0x70, float:1.57E-43)
            if (r34 != 0) goto L_0x02bd
            r34 = 2097152(0x200000, float:2.938736E-39)
            r34 = r12 & r34
            r7 = r70
            if (r34 != 0) goto L_0x02b8
            boolean r34 = r0.changed((long) r7)
            if (r34 == 0) goto L_0x02b8
            r30 = 32
            goto L_0x02ba
        L_0x02b8:
            r30 = 16
        L_0x02ba:
            r6 = r6 | r30
            goto L_0x02bf
        L_0x02bd:
            r7 = r70
        L_0x02bf:
            r30 = 4194304(0x400000, float:5.877472E-39)
            r30 = r12 & r30
            if (r30 == 0) goto L_0x02c8
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x02d7
        L_0x02c8:
            r3 = r11 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x02d7
            boolean r3 = r0.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x02d3
            goto L_0x02d5
        L_0x02d3:
            r16 = 128(0x80, float:1.794E-43)
        L_0x02d5:
            r6 = r6 | r16
        L_0x02d7:
            r3 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r3 = r3 & r2
            r5 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r5) goto L_0x0324
            r3 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r3 = r33 & r3
            r5 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r5) goto L_0x0324
            r3 = r6 & 731(0x2db, float:1.024E-42)
            r5 = 146(0x92, float:2.05E-43)
            if (r3 != r5) goto L_0x0324
            boolean r3 = r0.getSkipping()
            if (r3 != 0) goto L_0x02f7
            goto L_0x0324
        L_0x02f7:
            r0.skipToGroupEnd()
            r2 = r44
            r4 = r46
            r6 = r48
            r11 = r53
            r13 = r55
            r15 = r57
            r16 = r58
            r17 = r59
            r18 = r60
            r19 = r61
            r20 = r62
            r22 = r64
            r24 = r66
            r26 = r68
            r28 = r7
            r3 = r9
            r5 = r10
            r7 = r49
            r8 = r50
            r9 = r51
            r10 = r52
            goto L_0x06b3
        L_0x0324:
            r0.startDefaults()
            r3 = r13 & 1
            r16 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r5 = 0
            r7 = 6
            if (r3 == 0) goto L_0x03af
            boolean r3 = r0.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0338
            goto L_0x03af
        L_0x0338:
            r0.skipToGroupEnd()
            r1 = r12 & 4
            if (r1 == 0) goto L_0x0341
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0341:
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0347
            r2 = r2 & r16
        L_0x0347:
            r1 = r12 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x034d
            r33 = r33 & -15
        L_0x034d:
            r1 = r12 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0353
            r33 = r33 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0353:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r12
            if (r1 == 0) goto L_0x035e
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r33 = r33 & r1
        L_0x035e:
            r1 = r12 & r24
            if (r1 == 0) goto L_0x0367
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r33 = r33 & r1
        L_0x0367:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r12
            if (r1 == 0) goto L_0x036e
            r33 = r33 & r16
        L_0x036e:
            r1 = r12 & r28
            if (r1 == 0) goto L_0x0377
            r1 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r33 = r33 & r1
        L_0x0377:
            r1 = r12 & r27
            if (r1 == 0) goto L_0x037d
            r6 = r6 & -15
        L_0x037d:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r12
            if (r1 == 0) goto L_0x0384
            r6 = r6 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0384:
            r1 = r44
            r4 = r46
            r7 = r49
            r3 = r51
            r18 = r52
            r29 = r53
            r31 = r55
            r8 = r57
            r16 = r58
            r20 = r59
            r21 = r60
            r22 = r61
            r23 = r62
            r26 = r64
            r34 = r66
            r36 = r68
            r38 = r70
            r28 = r6
            r5 = r10
            r6 = r48
            r10 = r50
            goto L_0x0558
        L_0x03af:
            if (r4 == 0) goto L_0x03b8
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r22 = r3
            goto L_0x03ba
        L_0x03b8:
            r22 = r44
        L_0x03ba:
            r3 = r12 & 4
            if (r3 == 0) goto L_0x03e6
            r3 = 0
            r4 = 0
            r9 = 0
            r30 = 0
            r32 = 7
            r8 = r2
            r2 = r3
            r3 = r4
            r4 = r9
            r9 = r5
            r5 = r0
            r34 = r6
            r6 = r30
            r30 = r19
            r19 = r31
            r9 = 6
            r42 = r29
            r29 = r18
            r18 = r42
            r7 = r32
            androidx.compose.material.BottomSheetScaffoldState r2 = rememberBottomSheetScaffoldState(r2, r3, r4, r5, r6, r7)
            r3 = r8 & -897(0xfffffffffffffc7f, float:NaN)
            r8 = r3
            r3 = r2
            r2 = 0
            goto L_0x03f7
        L_0x03e6:
            r8 = r2
            r2 = r5
            r34 = r6
            r30 = r19
            r19 = r31
            r9 = 6
            r42 = r29
            r29 = r18
            r18 = r42
            r3 = r45
        L_0x03f7:
            if (r17 == 0) goto L_0x03fb
            r4 = r2
            goto L_0x03fd
        L_0x03fb:
            r4 = r46
        L_0x03fd:
            if (r20 == 0) goto L_0x0406
            androidx.compose.material.ComposableSingletons$BottomSheetScaffoldKt r5 = androidx.compose.material.ComposableSingletons$BottomSheetScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function3 r5 = r5.m1239getLambda1$material_release()
            goto L_0x0407
        L_0x0406:
            r5 = r10
        L_0x0407:
            if (r23 == 0) goto L_0x040b
            r6 = r2
            goto L_0x040d
        L_0x040b:
            r6 = r48
        L_0x040d:
            if (r26 == 0) goto L_0x0416
            androidx.compose.material.FabPosition$Companion r7 = androidx.compose.material.FabPosition.Companion
            int r7 = r7.m1304getEnd5ygKITE()
            goto L_0x0418
        L_0x0416:
            r7 = r49
        L_0x0418:
            if (r18 == 0) goto L_0x041c
            r10 = 1
            goto L_0x041e
        L_0x041c:
            r10 = r50
        L_0x041e:
            r2 = r12 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0431
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r2 = r2.getShapes(r0, r9)
            androidx.compose.foundation.shape.CornerBasedShape r2 = r2.getLarge()
            androidx.compose.ui.graphics.Shape r2 = (androidx.compose.ui.graphics.Shape) r2
            r8 = r8 & r16
            goto L_0x0433
        L_0x0431:
            r2 = r51
        L_0x0433:
            if (r19 == 0) goto L_0x043c
            androidx.compose.material.BottomSheetScaffoldDefaults r18 = androidx.compose.material.BottomSheetScaffoldDefaults.INSTANCE
            float r18 = r18.m1153getSheetElevationD9Ej5fM()
            goto L_0x043e
        L_0x043c:
            r18 = r52
        L_0x043e:
            r9 = r12 & 1024(0x400, float:1.435E-42)
            if (r9 == 0) goto L_0x0456
            androidx.compose.material.MaterialTheme r9 = androidx.compose.material.MaterialTheme.INSTANCE
            r44 = r2
            r2 = 6
            androidx.compose.material.Colors r9 = r9.getColors(r0, r2)
            long r31 = r9.m1218getSurface0d7_KjU()
            r33 = r33 & -15
            r45 = r3
            r2 = r31
            goto L_0x045c
        L_0x0456:
            r44 = r2
            r45 = r3
            r2 = r53
        L_0x045c:
            r9 = r12 & 2048(0x800, float:2.87E-42)
            if (r9 == 0) goto L_0x0469
            r9 = r33 & 14
            long r31 = androidx.compose.material.ColorsKt.m1232contentColorForek8zF_U(r2, r0, r9)
            r33 = r33 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x046b
        L_0x0469:
            r31 = r55
        L_0x046b:
            if (r1 == 0) goto L_0x0474
            androidx.compose.material.BottomSheetScaffoldDefaults r1 = androidx.compose.material.BottomSheetScaffoldDefaults.INSTANCE
            float r1 = r1.m1154getSheetPeekHeightD9Ej5fM()
            goto L_0x0476
        L_0x0474:
            r1 = r57
        L_0x0476:
            if (r29 == 0) goto L_0x047a
            r9 = 0
            goto L_0x047c
        L_0x047a:
            r9 = r58
        L_0x047c:
            if (r30 == 0) goto L_0x0481
            r20 = 1
            goto L_0x0483
        L_0x0481:
            r20 = r59
        L_0x0483:
            r23 = 32768(0x8000, float:4.5918E-41)
            r23 = r12 & r23
            r46 = r1
            if (r23 == 0) goto L_0x04a1
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            r29 = r2
            r2 = 6
            androidx.compose.material.Shapes r1 = r1.getShapes(r0, r2)
            androidx.compose.foundation.shape.CornerBasedShape r1 = r1.getLarge()
            androidx.compose.ui.graphics.Shape r1 = (androidx.compose.ui.graphics.Shape) r1
            r2 = -458753(0xfffffffffff8ffff, float:NaN)
            r33 = r33 & r2
            goto L_0x04a5
        L_0x04a1:
            r29 = r2
            r1 = r60
        L_0x04a5:
            if (r21 == 0) goto L_0x04ae
            androidx.compose.material.DrawerDefaults r2 = androidx.compose.material.DrawerDefaults.INSTANCE
            float r2 = r2.m1259getElevationD9Ej5fM()
            goto L_0x04b0
        L_0x04ae:
            r2 = r61
        L_0x04b0:
            r3 = r12 & r24
            if (r3 == 0) goto L_0x04cb
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            r47 = r1
            r1 = 6
            androidx.compose.material.Colors r3 = r3.getColors(r0, r1)
            long r23 = r3.m1218getSurface0d7_KjU()
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r33 = r33 & r1
            r48 = r2
            r1 = r23
            goto L_0x04d1
        L_0x04cb:
            r47 = r1
            r48 = r2
            r1 = r62
        L_0x04d1:
            r3 = 262144(0x40000, float:3.67342E-40)
            r3 = r3 & r12
            if (r3 == 0) goto L_0x04e1
            int r3 = r33 >> 21
            r3 = r3 & 14
            long r23 = androidx.compose.material.ColorsKt.m1232contentColorForek8zF_U(r1, r0, r3)
            r33 = r33 & r16
            goto L_0x04e3
        L_0x04e1:
            r23 = r64
        L_0x04e3:
            r3 = r12 & r28
            if (r3 == 0) goto L_0x04f8
            androidx.compose.material.DrawerDefaults r3 = androidx.compose.material.DrawerDefaults.INSTANCE
            r49 = r1
            r1 = 6
            long r2 = r3.getScrimColor(r0, r1)
            r16 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r16 = r33 & r16
            r33 = r16
            goto L_0x04fd
        L_0x04f8:
            r49 = r1
            r1 = 6
            r2 = r66
        L_0x04fd:
            r16 = r12 & r27
            r51 = r2
            if (r16 == 0) goto L_0x0512
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r2 = r2.getColors(r0, r1)
            long r1 = r2.m1207getBackground0d7_KjU()
            r3 = r34 & -15
            r34 = r3
            goto L_0x0514
        L_0x0512:
            r1 = r68
        L_0x0514:
            r3 = 2097152(0x200000, float:2.938736E-39)
            r3 = r3 & r12
            if (r3 == 0) goto L_0x053d
            r3 = r34 & 14
            long r26 = androidx.compose.material.ColorsKt.m1232contentColorForek8zF_U(r1, r0, r3)
            r3 = r34 & -113(0xffffffffffffff8f, float:NaN)
            r21 = r47
            r34 = r51
            r36 = r1
            r28 = r3
            r2 = r8
            r16 = r9
            r1 = r22
            r38 = r26
            r3 = r44
            r9 = r45
            r8 = r46
            r22 = r48
            r26 = r23
            r23 = r49
            goto L_0x0558
        L_0x053d:
            r3 = r44
            r21 = r47
            r38 = r70
            r36 = r1
            r2 = r8
            r16 = r9
            r1 = r22
            r26 = r23
            r28 = r34
            r9 = r45
            r8 = r46
            r22 = r48
            r23 = r49
            r34 = r51
        L_0x0558:
            r0.endDefaults()
            r11 = 773894976(0x2e20b340, float:3.6538994E-11)
            r0.startReplaceableGroup(r11)
            java.lang.String r11 = "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r11)
            r11 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r11)
            java.lang.String r11 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r11)
            java.lang.Object r11 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r40 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r40.getEmpty()
            if (r11 != r12) goto L_0x058e
            kotlin.coroutines.EmptyCoroutineContext r11 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11
            kotlinx.coroutines.CoroutineScope r11 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r11, r0)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r12 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r12.<init>(r11)
            r0.updateRememberedValue(r12)
            r11 = r12
        L_0x058e:
            r0.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r11 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r11
            kotlinx.coroutines.CoroutineScope r11 = r11.getCoroutineScope()
            r0.endReplaceableGroup()
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r14 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r14)
            java.lang.Object r12 = r0.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r12 = (androidx.compose.ui.unit.Density) r12
            float r12 = r12.m4649toPx0680j_4(r8)
            r13 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r13)
            java.lang.String r13 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r13)
            java.lang.Object r13 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r13 != r14) goto L_0x05d7
            r13 = 0
            r14 = 2
            androidx.compose.runtime.MutableState r14 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r13, r13, r14, r13)
            r0.updateRememberedValue(r14)
            r13 = r14
            goto L_0x05d9
        L_0x05d7:
            r44 = r13
        L_0x05d9:
            r0.endReplaceableGroup()
            androidx.compose.runtime.MutableState r13 = (androidx.compose.runtime.MutableState) r13
            java.lang.Float r14 = m1157BottomSheetScaffold_bGncdBI$lambda4(r13)
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((float) r12, (java.lang.Float) r14)
            if (r14 != 0) goto L_0x0600
            androidx.compose.ui.Modifier$Companion r14 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r14 = (androidx.compose.ui.Modifier) r14
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$semantics$1 r15 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$semantics$1
            r15.<init>(r9, r11)
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            r40 = r0
            r25 = r1
            r0 = 1
            r1 = 0
            r11 = 0
            androidx.compose.ui.Modifier r11 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r14, r11, r15, r0, r1)
            r0 = r11
            goto L_0x0608
        L_0x0600:
            r40 = r0
            r25 = r1
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x0608:
            r1 = 893101063(0x353ba407, float:6.990162E-7)
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$child$1 r11 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$child$1
            r44 = r11
            r45 = r9
            r46 = r4
            r47 = r72
            r48 = r6
            r49 = r8
            r50 = r7
            r51 = r2
            r52 = r28
            r53 = r33
            r54 = r12
            r55 = r10
            r56 = r0
            r57 = r13
            r58 = r3
            r59 = r29
            r61 = r31
            r63 = r18
            r64 = r43
            r65 = r5
            r44.<init>(r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r61, r63, r64, r65)
            r0 = r40
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r1, r2, r11)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r11 = 0
            r12 = r25
            r13 = 0
            androidx.compose.ui.Modifier r11 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r12, r11, r2, r13)
            r2 = 0
            r15 = 1273816607(0x4bece61f, float:3.1050814E7)
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1 r14 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1
            r44 = r14
            r45 = r16
            r46 = r1
            r47 = r9
            r48 = r20
            r49 = r21
            r50 = r22
            r51 = r23
            r53 = r26
            r55 = r34
            r57 = r33
            r44.<init>(r45, r46, r47, r48, r49, r50, r51, r53, r55, r57)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r15, r1, r14)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r14 = 1572864(0x180000, float:2.204052E-39)
            r15 = 6
            int r15 = r28 << 6
            r13 = r15 & 896(0x380, float:1.256E-42)
            r13 = r13 | r14
            r14 = r15 & 7168(0x1c00, float:1.0045E-41)
            r13 = r13 | r14
            r14 = 50
            r44 = r11
            r45 = r2
            r46 = r36
            r48 = r38
            r2 = 0
            r50 = r2
            r2 = 0
            r51 = r2
            r52 = r1
            r53 = r0
            r54 = r13
            r55 = r14
            androidx.compose.material.SurfaceKt.m1419SurfaceFjzlyU(r44, r45, r46, r48, r50, r51, r52, r53, r54, r55)
            r15 = r8
            r8 = r10
            r2 = r12
            r10 = r18
            r17 = r20
            r18 = r21
            r19 = r22
            r20 = r23
            r22 = r26
            r11 = r29
            r13 = r31
            r24 = r34
            r26 = r36
            r28 = r38
            r42 = r9
            r9 = r3
            r3 = r42
        L_0x06b3:
            androidx.compose.runtime.ScopeUpdateScope r1 = r0.endRestartGroup()
            if (r1 != 0) goto L_0x06ba
            goto L_0x06d8
        L_0x06ba:
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2 r35 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2
            r0 = r35
            r41 = r1
            r1 = r43
            r30 = r72
            r31 = r74
            r32 = r75
            r33 = r76
            r34 = r77
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r15, r16, r17, r18, r19, r20, r22, r24, r26, r28, r30, r31, r32, r33, r34)
            r0 = r35
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r41
            r1.updateScope(r0)
        L_0x06d8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.m1155BottomSheetScaffoldbGncdBI(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.BottomSheetScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, androidx.compose.ui.graphics.Shape, float, long, long, float, kotlin.jvm.functions.Function3, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: BottomSheetScaffold_bGncdBI$lambda-4  reason: not valid java name */
    public static final Float m1157BottomSheetScaffold_bGncdBI$lambda4(MutableState<Float> mutableState) {
        return (Float) mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: BottomSheetScaffoldLayout-KCBPh4w  reason: not valid java name */
    public static final void m1156BottomSheetScaffoldLayoutKCBPh4w(Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Function3<? super Integer, ? super Composer, ? super Integer, Unit> function32, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, float f, int i, State<Float> state, BottomSheetState bottomSheetState, Composer composer, int i2) {
        int i3;
        Composer composer2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function2;
        Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33 = function3;
        Function3<? super Integer, ? super Composer, ? super Integer, Unit> function34 = function32;
        Function2<? super Composer, ? super Integer, Unit> function25 = function22;
        Function2<? super Composer, ? super Integer, Unit> function26 = function23;
        State<Float> state2 = state;
        BottomSheetState bottomSheetState2 = bottomSheetState;
        int i4 = i2;
        Composer startRestartGroup = composer.startRestartGroup(499725572);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomSheetScaffoldLayout)P(8!3,7,5:c#ui.unit.Dp,3:c#material.FabPosition)429@17635L2479,429@17618L2496:BottomSheetScaffold.kt#jmzs0o");
        if ((i4 & 14) == 0) {
            i3 = (startRestartGroup.changed((Object) function24) ? 4 : 2) | i4;
        } else {
            i3 = i4;
        }
        if ((i4 & 112) == 0) {
            i3 |= startRestartGroup.changed((Object) function33) ? 32 : 16;
        }
        if ((i4 & 896) == 0) {
            i3 |= startRestartGroup.changed((Object) function34) ? 256 : 128;
        }
        if ((i4 & 7168) == 0) {
            i3 |= startRestartGroup.changed((Object) function25) ? 2048 : 1024;
        }
        if ((57344 & i4) == 0) {
            i3 |= startRestartGroup.changed((Object) function26) ? 16384 : 8192;
        }
        float f2 = f;
        if ((458752 & i4) == 0) {
            i3 |= startRestartGroup.changed(f2) ? 131072 : 65536;
        }
        int i5 = i;
        if ((3670016 & i4) == 0) {
            i3 |= startRestartGroup.changed(i5) ? 1048576 : 524288;
        }
        if ((29360128 & i4) == 0) {
            i3 |= startRestartGroup.changed((Object) state2) ? 8388608 : 4194304;
        }
        if ((234881024 & i4) == 0) {
            i3 |= startRestartGroup.changed((Object) bottomSheetState2) ? 67108864 : 33554432;
        }
        int i6 = i3;
        if ((i6 & 191739611) != 38347922 || !startRestartGroup.getSkipping()) {
            Object[] objArr = {function34, state2, function24, function33, Dp.m4702boximpl(f), function25, FabPosition.m1296boximpl(i), function26, bottomSheetState2};
            startRestartGroup.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean z = false;
            for (int i7 = 0; i7 < 9; i7++) {
                z |= startRestartGroup.changed(objArr[i7]);
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                composer2 = startRestartGroup;
                rememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(state, function2, function22, i, f, function23, bottomSheetState, function32, i6, function3);
                composer2.updateRememberedValue(rememberedValue);
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout((Modifier) null, (Function2) rememberedValue, composer2, 0, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2(function2, function3, function32, function22, function23, f, i, state, bottomSheetState, i2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: BottomSheetScaffold_bGncdBI$lambda-5  reason: not valid java name */
    public static final void m1158BottomSheetScaffold_bGncdBI$lambda5(MutableState<Float> mutableState, Float f) {
        mutableState.setValue(f);
    }
}
