package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\tH\u0003¢\u0006\u0002\u0010\u000b\u001aõ\u0001\u0010\f\u001a\u00020\u00042\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001a2\b\b\u0002\u0010 \u001a\u00020\u001a2\b\b\u0002\u0010!\u001a\u00020\u001a2\u0019\b\u0002\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00040#¢\u0006\u0002\b\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&\u001ah\u0010'\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t¢\u0006\u0002\b)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+0#2\"\u0010,\u001a\u001e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00040-¢\u0006\u0002\b\t¢\u0006\u0002\b)H\u0003ø\u0001\u0000¢\u0006\u0002\u0010/\u001a3\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u001a2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u00103\u001a\u00020\u0014H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105\u001aE\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u00062\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020.092\u0014\b\u0002\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140#2\b\b\u0002\u0010;\u001a\u00020$H\u0007¢\u0006\u0002\u0010<\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"AnimationSlideOffset", "Landroidx/compose/ui/unit/Dp;", "F", "BackLayerTransition", "", "target", "Landroidx/compose/material/BackdropValue;", "appBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "(Landroidx/compose/material/BackdropValue;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "BackdropScaffold", "backLayerContent", "frontLayerContent", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/BackdropScaffoldState;", "gesturesEnabled", "", "peekHeight", "headerHeight", "persistentAppBar", "stickyFrontLayer", "backLayerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "backLayerContentColor", "frontLayerShape", "Landroidx/compose/ui/graphics/Shape;", "frontLayerElevation", "frontLayerBackgroundColor", "frontLayerContentColor", "frontLayerScrimColor", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "BackdropScaffold-BZszfkY", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BackdropScaffoldState;ZFFZZJJLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BackdropStack", "backLayer", "Landroidx/compose/ui/UiComposable;", "calculateBackLayerConstraints", "Landroidx/compose/ui/unit/Constraints;", "frontLayer", "Lkotlin/Function2;", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "Scrim", "color", "onDismiss", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberBackdropScaffoldState", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "snackbarHostState", "(Landroidx/compose/material/BackdropValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BackdropScaffoldState;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BackdropScaffold.kt */
public final class BackdropScaffoldKt {
    private static final float AnimationSlideOffset = Dp.m4704constructorimpl((float) 20);

    @ExperimentalMaterialApi
    public static final BackdropScaffoldState rememberBackdropScaffoldState(BackdropValue backdropValue, AnimationSpec<Float> animationSpec, Function1<? super BackdropValue, Boolean> function1, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(backdropValue, "initialValue");
        composer.startReplaceableGroup(-862178912);
        ComposerKt.sourceInformation(composer, "C(rememberBackdropScaffoldState)P(2)171@6447L32,173@6518L538:BackdropScaffold.kt#jmzs0o");
        AnimationSpec<Float> animationSpec2 = animationSpec;
        if ((i2 & 2) != 0) {
            animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        Function1<? super BackdropValue, Boolean> function12 = function1;
        if ((i2 & 4) != 0) {
            function12 = BackdropScaffoldKt$rememberBackdropScaffoldState$1.INSTANCE;
        }
        if ((i2 & 8) != 0) {
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
        BackdropScaffoldState backdropScaffoldState = (BackdropScaffoldState) RememberSaveableKt.rememberSaveable(new Object[]{animationSpec2, function12, snackbarHostState}, BackdropScaffoldState.Companion.Saver(animationSpec2, function12, snackbarHostState), (String) null, new BackdropScaffoldKt$rememberBackdropScaffoldState$3(backdropValue, animationSpec2, function12, snackbarHostState), composer, 72, 4);
        composer.endReplaceableGroup();
        return backdropScaffoldState;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r41v0, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r41v1, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r41v2, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r41v3, resolved type: kotlin.jvm.functions.Function3<androidx.compose.material.SnackbarHostState, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r41v4, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01a6, code lost:
        if (r12.changed((java.lang.Object) r8) != false) goto L_0x01ad;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x0529  */
    /* JADX WARNING: Removed duplicated region for block: B:281:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0147  */
    @androidx.compose.material.ExperimentalMaterialApi
    /* renamed from: BackdropScaffold-BZszfkY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1128BackdropScaffoldBZszfkY(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, androidx.compose.ui.Modifier r55, androidx.compose.material.BackdropScaffoldState r56, boolean r57, float r58, float r59, boolean r60, boolean r61, long r62, long r64, androidx.compose.ui.graphics.Shape r66, float r67, long r68, long r70, long r72, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r74, androidx.compose.runtime.Composer r75, int r76, int r77, int r78) {
        /*
            r1 = r52
            r2 = r53
            r0 = r54
            r14 = r76
            r15 = r77
            r13 = r78
            java.lang.String r3 = "appBar"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "backLayerContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            java.lang.String r3 = "frontLayerContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            r3 = 1397420093(0x534af03d, float:8.7161392E11)
            r4 = r75
            androidx.compose.runtime.Composer r12 = r4.startRestartGroup(r3)
            java.lang.String r3 = "C(BackdropScaffold)P(!1,2,5,12,15,10,13:c#ui.unit.Dp,11:c#ui.unit.Dp,14,17,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9,7:c#ui.unit.Dp,4:c#ui.graphics.Color,6:c#ui.graphics.Color,8:c#ui.graphics.Color)260@11766L40,266@12093L6,267@12144L41,268@12241L15,270@12387L6,271@12439L42,272@12542L20,*275@12690L7,276@12764L7,288@13147L100,293@13271L3282:BackdropScaffold.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r3)
            r3 = r13 & 1
            if (r3 == 0) goto L_0x0030
            r3 = r14 | 6
            goto L_0x0040
        L_0x0030:
            r3 = r14 & 14
            if (r3 != 0) goto L_0x003f
            boolean r3 = r12.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x003c
            r3 = 4
            goto L_0x003d
        L_0x003c:
            r3 = 2
        L_0x003d:
            r3 = r3 | r14
            goto L_0x0040
        L_0x003f:
            r3 = r14
        L_0x0040:
            r6 = r13 & 2
            if (r6 == 0) goto L_0x0047
            r3 = r3 | 48
            goto L_0x0057
        L_0x0047:
            r6 = r14 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0057
            boolean r6 = r12.changed((java.lang.Object) r2)
            if (r6 == 0) goto L_0x0054
            r6 = 32
            goto L_0x0056
        L_0x0054:
            r6 = 16
        L_0x0056:
            r3 = r3 | r6
        L_0x0057:
            r6 = r13 & 4
            r9 = 256(0x100, float:3.59E-43)
            if (r6 == 0) goto L_0x0060
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0070
        L_0x0060:
            r6 = r14 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0070
            boolean r6 = r12.changed((java.lang.Object) r0)
            if (r6 == 0) goto L_0x006d
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x006f
        L_0x006d:
            r6 = 128(0x80, float:1.794E-43)
        L_0x006f:
            r3 = r3 | r6
        L_0x0070:
            r6 = r13 & 8
            r16 = 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x0079
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x008d
        L_0x0079:
            r4 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x008d
            r4 = r55
            boolean r17 = r12.changed((java.lang.Object) r4)
            if (r17 == 0) goto L_0x0088
            r17 = 2048(0x800, float:2.87E-42)
            goto L_0x008a
        L_0x0088:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x008a:
            r3 = r3 | r17
            goto L_0x008f
        L_0x008d:
            r4 = r55
        L_0x008f:
            r17 = 57344(0xe000, float:8.0356E-41)
            r17 = r14 & r17
            r18 = 8192(0x2000, float:1.14794E-41)
            r19 = 16384(0x4000, float:2.2959E-41)
            if (r17 != 0) goto L_0x00ae
            r17 = r13 & 16
            r5 = r56
            if (r17 != 0) goto L_0x00a9
            boolean r20 = r12.changed((java.lang.Object) r5)
            if (r20 == 0) goto L_0x00a9
            r20 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ab
        L_0x00a9:
            r20 = 8192(0x2000, float:1.14794E-41)
        L_0x00ab:
            r3 = r3 | r20
            goto L_0x00b0
        L_0x00ae:
            r5 = r56
        L_0x00b0:
            r20 = r13 & 32
            r21 = 131072(0x20000, float:1.83671E-40)
            r22 = 65536(0x10000, float:9.18355E-41)
            if (r20 == 0) goto L_0x00bf
            r23 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r23
            r11 = r57
            goto L_0x00d4
        L_0x00bf:
            r23 = 458752(0x70000, float:6.42848E-40)
            r23 = r14 & r23
            r11 = r57
            if (r23 != 0) goto L_0x00d4
            boolean r24 = r12.changed((boolean) r11)
            if (r24 == 0) goto L_0x00d0
            r24 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d2
        L_0x00d0:
            r24 = 65536(0x10000, float:9.18355E-41)
        L_0x00d2:
            r3 = r3 | r24
        L_0x00d4:
            r24 = r13 & 64
            if (r24 == 0) goto L_0x00df
            r25 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r25
            r10 = r58
            goto L_0x00f4
        L_0x00df:
            r25 = 3670016(0x380000, float:5.142788E-39)
            r25 = r14 & r25
            r10 = r58
            if (r25 != 0) goto L_0x00f4
            boolean r26 = r12.changed((float) r10)
            if (r26 == 0) goto L_0x00f0
            r26 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00f2
        L_0x00f0:
            r26 = 524288(0x80000, float:7.34684E-40)
        L_0x00f2:
            r3 = r3 | r26
        L_0x00f4:
            r10 = r13 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x00fd
            r26 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r26
            goto L_0x0115
        L_0x00fd:
            r26 = 29360128(0x1c00000, float:7.052966E-38)
            r26 = r14 & r26
            if (r26 != 0) goto L_0x0115
            r26 = r10
            r10 = r59
            boolean r27 = r12.changed((float) r10)
            if (r27 == 0) goto L_0x0110
            r27 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0112
        L_0x0110:
            r27 = 4194304(0x400000, float:5.877472E-39)
        L_0x0112:
            r3 = r3 | r27
            goto L_0x0119
        L_0x0115:
            r26 = r10
            r10 = r59
        L_0x0119:
            r10 = r13 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0122
            r27 = 100663296(0x6000000, float:2.4074124E-35)
            r3 = r3 | r27
            goto L_0x013a
        L_0x0122:
            r27 = 234881024(0xe000000, float:1.5777218E-30)
            r27 = r14 & r27
            if (r27 != 0) goto L_0x013a
            r27 = r10
            r10 = r60
            boolean r28 = r12.changed((boolean) r10)
            if (r28 == 0) goto L_0x0135
            r28 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0137
        L_0x0135:
            r28 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0137:
            r3 = r3 | r28
            goto L_0x013e
        L_0x013a:
            r27 = r10
            r10 = r60
        L_0x013e:
            r10 = r13 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x0147
            r28 = 805306368(0x30000000, float:4.656613E-10)
            r3 = r3 | r28
            goto L_0x015f
        L_0x0147:
            r28 = 1879048192(0x70000000, float:1.58456325E29)
            r28 = r14 & r28
            if (r28 != 0) goto L_0x015f
            r28 = r10
            r10 = r61
            boolean r29 = r12.changed((boolean) r10)
            if (r29 == 0) goto L_0x015a
            r29 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x015c
        L_0x015a:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x015c:
            r3 = r3 | r29
            goto L_0x0163
        L_0x015f:
            r28 = r10
            r10 = r61
        L_0x0163:
            r29 = r15 & 14
            if (r29 != 0) goto L_0x017b
            r7 = r13 & 1024(0x400, float:1.435E-42)
            r10 = r62
            if (r7 != 0) goto L_0x0176
            boolean r7 = r12.changed((long) r10)
            if (r7 == 0) goto L_0x0176
            r17 = 4
            goto L_0x0178
        L_0x0176:
            r17 = 2
        L_0x0178:
            r7 = r15 | r17
            goto L_0x017e
        L_0x017b:
            r10 = r62
            r7 = r15
        L_0x017e:
            r17 = r15 & 112(0x70, float:1.57E-43)
            if (r17 != 0) goto L_0x0196
            r8 = r13 & 2048(0x800, float:2.87E-42)
            r10 = r64
            if (r8 != 0) goto L_0x0191
            boolean r8 = r12.changed((long) r10)
            if (r8 == 0) goto L_0x0191
            r29 = 32
            goto L_0x0193
        L_0x0191:
            r29 = 16
        L_0x0193:
            r7 = r7 | r29
            goto L_0x0198
        L_0x0196:
            r10 = r64
        L_0x0198:
            r8 = r15 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x01af
            r8 = r13 & 4096(0x1000, float:5.74E-42)
            if (r8 != 0) goto L_0x01a9
            r8 = r66
            boolean r17 = r12.changed((java.lang.Object) r8)
            if (r17 == 0) goto L_0x01ab
            goto L_0x01ad
        L_0x01a9:
            r8 = r66
        L_0x01ab:
            r9 = 128(0x80, float:1.794E-43)
        L_0x01ad:
            r7 = r7 | r9
            goto L_0x01b1
        L_0x01af:
            r8 = r66
        L_0x01b1:
            r9 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r9 == 0) goto L_0x01b8
            r7 = r7 | 3072(0xc00, float:4.305E-42)
            goto L_0x01cc
        L_0x01b8:
            r0 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r0 != 0) goto L_0x01cc
            r0 = r67
            boolean r17 = r12.changed((float) r0)
            if (r17 == 0) goto L_0x01c7
            r23 = 2048(0x800, float:2.87E-42)
            goto L_0x01c9
        L_0x01c7:
            r23 = 1024(0x400, float:1.435E-42)
        L_0x01c9:
            r7 = r7 | r23
            goto L_0x01ce
        L_0x01cc:
            r0 = r67
        L_0x01ce:
            r16 = 57344(0xe000, float:8.0356E-41)
            r16 = r15 & r16
            if (r16 != 0) goto L_0x01e6
            r0 = r13 & 16384(0x4000, float:2.2959E-41)
            r10 = r68
            if (r0 != 0) goto L_0x01e3
            boolean r0 = r12.changed((long) r10)
            if (r0 == 0) goto L_0x01e3
            r18 = 16384(0x4000, float:2.2959E-41)
        L_0x01e3:
            r7 = r7 | r18
            goto L_0x01e8
        L_0x01e6:
            r10 = r68
        L_0x01e8:
            r0 = 458752(0x70000, float:6.42848E-40)
            r0 = r0 & r15
            r16 = 32768(0x8000, float:4.5918E-41)
            if (r0 != 0) goto L_0x0203
            r0 = r13 & r16
            r10 = r70
            if (r0 != 0) goto L_0x01ff
            boolean r0 = r12.changed((long) r10)
            if (r0 == 0) goto L_0x01ff
            r0 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0201
        L_0x01ff:
            r0 = 65536(0x10000, float:9.18355E-41)
        L_0x0201:
            r7 = r7 | r0
            goto L_0x0205
        L_0x0203:
            r10 = r70
        L_0x0205:
            r0 = 3670016(0x380000, float:5.142788E-39)
            r0 = r0 & r15
            if (r0 != 0) goto L_0x021d
            r0 = r13 & r22
            r10 = r72
            if (r0 != 0) goto L_0x0219
            boolean r0 = r12.changed((long) r10)
            if (r0 == 0) goto L_0x0219
            r0 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x021b
        L_0x0219:
            r0 = 524288(0x80000, float:7.34684E-40)
        L_0x021b:
            r7 = r7 | r0
            goto L_0x021f
        L_0x021d:
            r10 = r72
        L_0x021f:
            r0 = r13 & r21
            if (r0 == 0) goto L_0x022a
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r7 = r7 | r17
            r10 = r74
            goto L_0x023e
        L_0x022a:
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r15 & r17
            r10 = r74
            if (r17 != 0) goto L_0x023e
            boolean r11 = r12.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x023b
            r11 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x023d
        L_0x023b:
            r11 = 4194304(0x400000, float:5.877472E-39)
        L_0x023d:
            r7 = r7 | r11
        L_0x023e:
            r11 = r7
            r7 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r7 = r7 & r3
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r7 != r1) goto L_0x0277
            r1 = 23967451(0x16db6db, float:4.3661218E-38)
            r1 = r1 & r11
            r7 = 4793490(0x492492, float:6.71711E-39)
            if (r1 != r7) goto L_0x0277
            boolean r1 = r12.getSkipping()
            if (r1 != 0) goto L_0x0258
            goto L_0x0277
        L_0x0258:
            r12.skipToGroupEnd()
            r6 = r57
            r7 = r58
            r9 = r60
            r13 = r64
            r16 = r67
            r17 = r68
            r19 = r70
            r21 = r72
            r15 = r8
            r23 = r10
            r0 = r12
            r8 = r59
            r10 = r61
            r11 = r62
            goto L_0x0522
        L_0x0277:
            r12.startDefaults()
            r1 = r14 & 1
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r7 = 6
            r10 = 1
            if (r1 == 0) goto L_0x02dd
            boolean r1 = r12.getDefaultsInvalid()
            if (r1 == 0) goto L_0x028a
            goto L_0x02dd
        L_0x028a:
            r12.skipToGroupEnd()
            r0 = r13 & 16
            if (r0 == 0) goto L_0x0293
            r3 = r3 & r17
        L_0x0293:
            r0 = r13 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0299
            r11 = r11 & -15
        L_0x0299:
            r0 = r13 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x029f
            r11 = r11 & -113(0xffffffffffffff8f, float:NaN)
        L_0x029f:
            r0 = r13 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x02a5
            r11 = r11 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x02a5:
            r0 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x02ab
            r11 = r11 & r17
        L_0x02ab:
            r0 = r13 & r16
            if (r0 == 0) goto L_0x02b3
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r11 = r11 & r0
        L_0x02b3:
            r0 = r13 & r22
            if (r0 == 0) goto L_0x02bb
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r11 = r11 & r0
        L_0x02bb:
            r2 = r57
            r10 = r59
            r27 = r60
            r28 = r61
            r30 = r62
            r32 = r64
            r34 = r67
            r35 = r68
            r37 = r70
            r39 = r72
            r41 = r74
            r16 = r3
            r0 = r4
            r1 = r5
            r29 = r8
            r42 = r11
            r11 = r58
            goto L_0x0417
        L_0x02dd:
            if (r6 == 0) goto L_0x02e4
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x02e5
        L_0x02e4:
            r1 = r4
        L_0x02e5:
            r4 = r13 & 16
            if (r4 == 0) goto L_0x030d
            androidx.compose.material.BackdropValue r4 = androidx.compose.material.BackdropValue.Concealed
            r5 = 0
            r6 = 0
            r18 = 0
            r19 = 6
            r21 = 14
            r7 = r18
            r8 = r12
            r18 = r9
            r9 = r19
            r55 = r1
            r19 = r26
            r23 = r27
            r25 = r28
            r1 = 1
            r10 = r21
            androidx.compose.material.BackdropScaffoldState r4 = rememberBackdropScaffoldState(r4, r5, r6, r7, r8, r9, r10)
            r3 = r3 & r17
            r5 = r4
            goto L_0x0318
        L_0x030d:
            r55 = r1
            r18 = r9
            r19 = r26
            r23 = r27
            r25 = r28
            r1 = 1
        L_0x0318:
            if (r20 == 0) goto L_0x031c
            r4 = 1
            goto L_0x031e
        L_0x031c:
            r4 = r57
        L_0x031e:
            if (r24 == 0) goto L_0x0327
            androidx.compose.material.BackdropScaffoldDefaults r6 = androidx.compose.material.BackdropScaffoldDefaults.INSTANCE
            float r6 = r6.m1126getPeekHeightD9Ej5fM()
            goto L_0x0329
        L_0x0327:
            r6 = r58
        L_0x0329:
            if (r19 == 0) goto L_0x0332
            androidx.compose.material.BackdropScaffoldDefaults r7 = androidx.compose.material.BackdropScaffoldDefaults.INSTANCE
            float r7 = r7.m1125getHeaderHeightD9Ej5fM()
            goto L_0x0334
        L_0x0332:
            r7 = r59
        L_0x0334:
            if (r23 == 0) goto L_0x0338
            r8 = 1
            goto L_0x033a
        L_0x0338:
            r8 = r60
        L_0x033a:
            if (r25 == 0) goto L_0x033e
            r9 = 1
            goto L_0x0340
        L_0x033e:
            r9 = r61
        L_0x0340:
            r10 = r13 & 1024(0x400, float:1.435E-42)
            if (r10 == 0) goto L_0x0358
            androidx.compose.material.MaterialTheme r10 = androidx.compose.material.MaterialTheme.INSTANCE
            r1 = 6
            androidx.compose.material.Colors r10 = r10.getColors(r12, r1)
            long r19 = r10.m1214getPrimary0d7_KjU()
            r11 = r11 & -15
            r50 = r19
            r19 = r11
            r10 = r50
            goto L_0x035d
        L_0x0358:
            r1 = 6
            r19 = r11
            r10 = r62
        L_0x035d:
            r1 = r13 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x036a
            r1 = r19 & 14
            long r20 = androidx.compose.material.ColorsKt.m1232contentColorForek8zF_U(r10, r12, r1)
            r19 = r19 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x036c
        L_0x036a:
            r20 = r64
        L_0x036c:
            r1 = r19
            r2 = r13 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x037e
            androidx.compose.material.BackdropScaffoldDefaults r2 = androidx.compose.material.BackdropScaffoldDefaults.INSTANCE
            r56 = r3
            r3 = 6
            androidx.compose.ui.graphics.Shape r2 = r2.getFrontLayerShape(r12, r3)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0382
        L_0x037e:
            r56 = r3
            r2 = r66
        L_0x0382:
            if (r18 == 0) goto L_0x038b
            androidx.compose.material.BackdropScaffoldDefaults r3 = androidx.compose.material.BackdropScaffoldDefaults.INSTANCE
            float r3 = r3.m1124getFrontLayerElevationD9Ej5fM()
            goto L_0x038d
        L_0x038b:
            r3 = r67
        L_0x038d:
            r57 = r2
            r2 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x03a3
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            r58 = r3
            r3 = 6
            androidx.compose.material.Colors r2 = r2.getColors(r12, r3)
            long r2 = r2.m1218getSurface0d7_KjU()
            r1 = r1 & r17
            goto L_0x03a7
        L_0x03a3:
            r58 = r3
            r2 = r68
        L_0x03a7:
            r16 = r13 & r16
            if (r16 == 0) goto L_0x03ba
            int r16 = r1 >> 12
            r75 = r4
            r4 = r16 & 14
            long r16 = androidx.compose.material.ColorsKt.m1232contentColorForek8zF_U(r2, r12, r4)
            r4 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r4
            goto L_0x03be
        L_0x03ba:
            r75 = r4
            r16 = r70
        L_0x03be:
            r4 = r13 & r22
            if (r4 == 0) goto L_0x03d0
            androidx.compose.material.BackdropScaffoldDefaults r4 = androidx.compose.material.BackdropScaffoldDefaults.INSTANCE
            r18 = r2
            r2 = 6
            long r3 = r4.getFrontLayerScrimColor(r12, r2)
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r2
            goto L_0x03d4
        L_0x03d0:
            r18 = r2
            r3 = r72
        L_0x03d4:
            if (r0 == 0) goto L_0x03f8
            androidx.compose.material.ComposableSingletons$BackdropScaffoldKt r0 = androidx.compose.material.ComposableSingletons$BackdropScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function3 r0 = r0.m1238getLambda1$material_release()
            r29 = r57
            r34 = r58
            r2 = r75
            r41 = r0
            r42 = r1
            r39 = r3
            r1 = r5
            r27 = r8
            r28 = r9
            r30 = r10
            r37 = r16
            r35 = r18
            r32 = r20
            r0 = r55
            goto L_0x0413
        L_0x03f8:
            r0 = r55
            r29 = r57
            r34 = r58
            r41 = r74
            r2 = r75
            r42 = r1
            r39 = r3
            r1 = r5
            r27 = r8
            r28 = r9
            r30 = r10
            r37 = r16
            r35 = r18
            r32 = r20
        L_0x0413:
            r16 = r56
            r11 = r6
            r10 = r7
        L_0x0417:
            r12.endDefaults()
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r4, r5)
            java.lang.Object r3 = r12.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            float r17 = r3.m4649toPx0680j_4(r11)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            java.lang.String r5 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r4, r5)
            java.lang.Object r3 = r12.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            float r7 = r3.m4649toPx0680j_4(r10)
            r3 = 1744778315(0x67ff344b, float:2.4103362E24)
            androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$backLayer$1 r4 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$backLayer$1
            r55 = r4
            r56 = r27
            r57 = r1
            r58 = r52
            r59 = r53
            r60 = r16
            r55.<init>(r56, r57, r58, r59, r60)
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r3, r5, r4)
            r5 = r3
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            java.lang.Float r3 = java.lang.Float.valueOf(r7)
            r4 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r4)
            java.lang.String r4 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r4)
            boolean r3 = r12.changed((java.lang.Object) r3)
            java.lang.Object r4 = r12.rememberedValue()
            if (r3 != 0) goto L_0x048a
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x0495
        L_0x048a:
            androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1 r3 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1
            r3.<init>(r7)
            r4 = r3
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r12.updateRememberedValue(r4)
        L_0x0495:
            r12.endReplaceableGroup()
            r6 = r4
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r9 = -1049909631(0xffffffffc16ba681, float:-14.72815)
            androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1 r8 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1
            r3 = r8
            r4 = r0
            r67 = r0
            r0 = r8
            r8 = r28
            r55 = r0
            r0 = -1049909631(0xffffffffc16ba681, float:-14.72815)
            r9 = r2
            r47 = r10
            r10 = r1
            r48 = r11
            r11 = r17
            r0 = r12
            r12 = r16
            r13 = r29
            r14 = r35
            r16 = r37
            r18 = r34
            r19 = r42
            r20 = r47
            r21 = r48
            r22 = r54
            r23 = r39
            r25 = r41
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r16, r18, r19, r20, r21, r22, r23, r25)
            r4 = r55
            r3 = -1049909631(0xffffffffc16ba681, float:-14.72815)
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r3, r5, r4)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = 1572864(0x180000, float:2.204052E-39)
            r5 = 6
            int r5 = r42 << 6
            r6 = r5 & 896(0x380, float:1.256E-42)
            r4 = r4 | r6
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r5
            r5 = 51
            r55 = r43
            r56 = r44
            r57 = r30
            r59 = r32
            r61 = r45
            r62 = r46
            r63 = r3
            r64 = r0
            r65 = r4
            r66 = r5
            androidx.compose.material.SurfaceKt.m1419SurfaceFjzlyU(r55, r56, r57, r59, r61, r62, r63, r64, r65, r66)
            r4 = r67
            r5 = r1
            r6 = r2
            r9 = r27
            r10 = r28
            r15 = r29
            r11 = r30
            r13 = r32
            r16 = r34
            r17 = r35
            r19 = r37
            r21 = r39
            r23 = r41
            r8 = r47
            r7 = r48
        L_0x0522:
            androidx.compose.runtime.ScopeUpdateScope r3 = r0.endRestartGroup()
            if (r3 != 0) goto L_0x0529
            goto L_0x0547
        L_0x0529:
            androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2 r27 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2
            r0 = r27
            r1 = r52
            r2 = r53
            r49 = r3
            r3 = r54
            r24 = r76
            r25 = r77
            r26 = r78
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r15, r16, r17, r19, r21, r23, r24, r25, r26)
            r0 = r27
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r49
            r1.updateScope(r0)
        L_0x0547:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BackdropScaffoldKt.m1128BackdropScaffoldBZszfkY(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.material.BackdropScaffoldState, boolean, float, float, boolean, boolean, long, long, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: Scrim-3J-VO9M  reason: not valid java name */
    public static final void m1129Scrim3JVO9M(long j, Function0<Unit> function0, boolean z, Composer composer, int i) {
        int i2;
        Modifier modifier;
        long j2 = j;
        Function0<Unit> function02 = function0;
        boolean z2 = z;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-92141505);
        ComposerKt.sourceInformation(startRestartGroup, "C(Scrim)P(0:c#ui.graphics.Color)388@16708L121,401@17118L62,397@17009L171:BackdropScaffold.kt#jmzs0o");
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
                startRestartGroup.startReplaceableGroup(1010547004);
                ComposerKt.sourceInformation(startRestartGroup, "393@16915L37");
                if (z2) {
                    Modifier modifier2 = Modifier.Companion;
                    Unit unit = Unit.INSTANCE;
                    startRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    boolean changed = startRestartGroup.changed((Object) function02);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new BackdropScaffoldKt$Scrim$dismissModifier$1$1(function02, (Continuation<? super BackdropScaffoldKt$Scrim$dismissModifier$1$1>) null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    modifier = SuspendingPointerInputFilterKt.pointerInput(modifier2, (Object) unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue);
                } else {
                    modifier = Modifier.Companion;
                }
                startRestartGroup.endReplaceableGroup();
                Modifier then = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null).then(modifier);
                Color r8 = Color.m1922boximpl(j);
                startRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                boolean changed2 = startRestartGroup.changed((Object) r8) | startRestartGroup.changed((Object) animateFloatAsState);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new BackdropScaffoldKt$Scrim$1$1(j2, animateFloatAsState);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(then, (Function1) rememberedValue2, startRestartGroup, 0);
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BackdropScaffoldKt$Scrim$2(j, function0, z, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void BackLayerTransition(BackdropValue backdropValue, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i) {
        int i2;
        BackdropValue backdropValue2 = backdropValue;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-950970976);
        ComposerKt.sourceInformation(startRestartGroup, "C(BackLayerTransition)P(2)421@17840L112,*424@18002L7,429@18176L486:BackdropScaffold.kt#jmzs0o");
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) backdropValue2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) function23) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i2 |= startRestartGroup.changed((Object) function24) ? 256 : 128;
        }
        int i4 = i2;
        if ((i4 & 731) != 146 || !startRestartGroup.getSkipping()) {
            State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(backdropValue2 == BackdropValue.Revealed ? 0.0f : 2.0f, new TweenSpec(0, 0, (Easing) null, 7, (DefaultConstructorMarker) null), 0.0f, (Function1<? super Float, Unit>) null, startRestartGroup, 0, 12);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            float r6 = ((Density) consume).m4649toPx0680j_4(AnimationSlideOffset);
            float f = (float) 1;
            float coerceIn = RangesKt.coerceIn(m1127BackLayerTransition$lambda7(animateFloatAsState) - f, 0.0f, 1.0f);
            float coerceIn2 = RangesKt.coerceIn(f - m1127BackLayerTransition$lambda7(animateFloatAsState), 0.0f, 1.0f);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume3;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume4;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
            float f2 = coerceIn2;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r5 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r5, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r5, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r5, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r5, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(2065804710);
            ComposerKt.sourceInformation(startRestartGroup, "C430@18190L226,438@18425L231:BackdropScaffold.kt#jmzs0o");
            Modifier r52 = GraphicsLayerModifierKt.m2069graphicsLayerpANQ8Wg$default(ZIndexModifierKt.zIndex(Modifier.Companion, coerceIn), 0.0f, 0.0f, coerceIn, 0.0f, (f - coerceIn) * r6, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Shape) null, false, (RenderEffect) null, 0, 0, 65515, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density2 = (Density) consume5;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection2 = (LayoutDirection) consume6;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume7 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume7;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r52);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r0 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r0, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r0, density2, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r0, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r0, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(-1057690836);
            ComposerKt.sourceInformation(startRestartGroup, "C436@18398L8:BackdropScaffold.kt#jmzs0o");
            function23.invoke(startRestartGroup, Integer.valueOf((i4 >> 3) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            float f3 = f2;
            Modifier r02 = GraphicsLayerModifierKt.m2069graphicsLayerpANQ8Wg$default(ZIndexModifierKt.zIndex(Modifier.Companion, f3), 0.0f, 0.0f, f3, 0.0f, (f - f3) * (-r6), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Shape) null, false, (RenderEffect) null, 0, 0, 65515, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume8 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density3 = (Density) consume8;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume9 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection3 = (LayoutDirection) consume9;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume10 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) consume10;
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(r02);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r8 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r8, rememberBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r8, density3, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r8, layoutDirection3, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r8, viewConfiguration3, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf3.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(-676544093);
            ComposerKt.sourceInformation(startRestartGroup, "C444@18637L9:BackdropScaffold.kt#jmzs0o");
            function24 = function22;
            function24.invoke(startRestartGroup, Integer.valueOf((i4 >> 6) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BackdropScaffoldKt$BackLayerTransition$2(backdropValue, function23, function24, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void BackdropStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function1<? super Constraints, Constraints> function1, Function4<? super Constraints, ? super Float, ? super Composer, ? super Integer, Unit> function4, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1248995194);
        ComposerKt.sourceInformation(startRestartGroup, "C(BackdropStack)P(3)457@18967L890,457@18940L917:BackdropScaffold.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) function2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed((Object) function1) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changed((Object) function4) ? 2048 : 1024;
        }
        if ((i2 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) function2) | startRestartGroup.changed((Object) function1) | startRestartGroup.changed((Object) function4);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new BackdropScaffoldKt$BackdropStack$1$1(function2, function1, function4, i2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(modifier, (Function2) rememberedValue, startRestartGroup, i2 & 14, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BackdropScaffoldKt$BackdropStack$2(modifier, function2, function1, function4, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Scrim_3J_VO9M$lambda-4  reason: not valid java name */
    public static final float m1130Scrim_3J_VO9M$lambda4(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* renamed from: BackLayerTransition$lambda-7  reason: not valid java name */
    private static final float m1127BackLayerTransition$lambda7(State<Float> state) {
        return state.getValue().floatValue();
    }
}
