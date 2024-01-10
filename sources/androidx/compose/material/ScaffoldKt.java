package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a¢\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\u0019\b\u0002\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192 \b\u0002\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"2\b\b\u0002\u0010&\u001a\u00020\"2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*\u001a£\u0001\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00172\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102\u001a!\u00103\u001a\u00020\r2\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u0014H\u0007¢\u0006\u0002\u00107\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00068"}, d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/FabPlacement;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Scaffold", "", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/ScaffoldState;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "isFloatingActionButtonDocked", "", "drawerContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "drawerGesturesEnabled", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-27mzLpw", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ScaffoldLayout", "isFabDocked", "fabPosition", "Landroidx/compose/ui/UiComposable;", "snackbar", "fab", "ScaffoldLayout-MDYNRJg", "(ZILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "rememberScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ScaffoldState;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Scaffold.kt */
public final class ScaffoldKt {
    /* access modifiers changed from: private */
    public static final float FabSpacing = Dp.m4704constructorimpl((float) 16);
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(ScaffoldKt$LocalFabPlacement$1.INSTANCE);

    public static final ScaffoldState rememberScaffoldState(DrawerState drawerState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1569641925);
        ComposerKt.sourceInformation(composer, "C(rememberScaffoldState)63@2263L39,64@2347L32,65@2399L62:Scaffold.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, (Function1<? super DrawerValue, Boolean>) null, composer, 6, 2);
        }
        if ((i2 & 2) != 0) {
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
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new ScaffoldState(drawerState, snackbarHostState);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        ScaffoldState scaffoldState = (ScaffoldState) rememberedValue2;
        composer.endReplaceableGroup();
        return scaffoldState;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v1, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r56v0, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v28, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v20, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v22, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v32, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v32, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v35, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v38, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v43, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v47, resolved type: boolean} */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x01bd, code lost:
        if (r0.changed(r53) != false) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x01d7, code lost:
        if (r0.changed(r55) != false) goto L_0x01de;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x04da  */
    /* JADX WARNING: Removed duplicated region for block: B:287:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0144  */
    /* renamed from: Scaffold-27mzLpw  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1388Scaffold27mzLpw(androidx.compose.ui.Modifier r39, androidx.compose.material.ScaffoldState r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, int r45, boolean r46, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, boolean r48, androidx.compose.ui.graphics.Shape r49, float r50, long r51, long r53, long r55, long r57, long r59, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r61, androidx.compose.runtime.Composer r62, int r63, int r64, int r65) {
        /*
            r15 = r61
            r13 = r63
            r14 = r64
            r12 = r65
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = 1037492569(0x3dd6e159, float:0.104922004)
            r1 = r62
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Scaffold)P(14,15,17,1,16,11,12:c#material.FabPosition,13,5,8,10,7:c#ui.unit.Dp,4:c#ui.graphics.Color,6:c#ui.graphics.Color,9:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color)160@7052L23,169@7562L6,171@7677L6,172@7725L38,173@7810L10,174@7865L6,175@7910L32:Scaffold.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x0025
            r4 = r13 | 6
            r5 = r4
            r4 = r39
            goto L_0x0039
        L_0x0025:
            r4 = r13 & 14
            if (r4 != 0) goto L_0x0036
            r4 = r39
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0033
            r5 = 4
            goto L_0x0034
        L_0x0033:
            r5 = 2
        L_0x0034:
            r5 = r5 | r13
            goto L_0x0039
        L_0x0036:
            r4 = r39
            r5 = r13
        L_0x0039:
            r6 = r13 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0052
            r6 = r12 & 2
            if (r6 != 0) goto L_0x004c
            r6 = r40
            boolean r9 = r0.changed((java.lang.Object) r6)
            if (r9 == 0) goto L_0x004e
            r9 = 32
            goto L_0x0050
        L_0x004c:
            r6 = r40
        L_0x004e:
            r9 = 16
        L_0x0050:
            r5 = r5 | r9
            goto L_0x0054
        L_0x0052:
            r6 = r40
        L_0x0054:
            r9 = r12 & 4
            if (r9 == 0) goto L_0x005b
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x006f
        L_0x005b:
            r2 = r13 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x006f
            r2 = r41
            boolean r16 = r0.changed((java.lang.Object) r2)
            if (r16 == 0) goto L_0x006a
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x006c
        L_0x006a:
            r16 = 128(0x80, float:1.794E-43)
        L_0x006c:
            r5 = r5 | r16
            goto L_0x0071
        L_0x006f:
            r2 = r41
        L_0x0071:
            r16 = r12 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x007c
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x0090
        L_0x007c:
            r3 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x0090
            r3 = r42
            boolean r20 = r0.changed((java.lang.Object) r3)
            if (r20 == 0) goto L_0x008b
            r20 = 2048(0x800, float:2.87E-42)
            goto L_0x008d
        L_0x008b:
            r20 = 1024(0x400, float:1.435E-42)
        L_0x008d:
            r5 = r5 | r20
            goto L_0x0092
        L_0x0090:
            r3 = r42
        L_0x0092:
            r20 = r12 & 16
            r21 = 57344(0xe000, float:8.0356E-41)
            r22 = 16384(0x4000, float:2.2959E-41)
            r23 = 8192(0x2000, float:1.14794E-41)
            if (r20 == 0) goto L_0x00a2
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            r7 = r43
            goto L_0x00b5
        L_0x00a2:
            r24 = r13 & r21
            r7 = r43
            if (r24 != 0) goto L_0x00b5
            boolean r25 = r0.changed((java.lang.Object) r7)
            if (r25 == 0) goto L_0x00b1
            r25 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00b3
        L_0x00b1:
            r25 = 8192(0x2000, float:1.14794E-41)
        L_0x00b3:
            r5 = r5 | r25
        L_0x00b5:
            r25 = r12 & 32
            r26 = 131072(0x20000, float:1.83671E-40)
            r27 = 458752(0x70000, float:6.42848E-40)
            r28 = 65536(0x10000, float:9.18355E-41)
            if (r25 == 0) goto L_0x00c6
            r29 = 196608(0x30000, float:2.75506E-40)
            r5 = r5 | r29
            r8 = r44
            goto L_0x00d9
        L_0x00c6:
            r29 = r13 & r27
            r8 = r44
            if (r29 != 0) goto L_0x00d9
            boolean r30 = r0.changed((java.lang.Object) r8)
            if (r30 == 0) goto L_0x00d5
            r30 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d7
        L_0x00d5:
            r30 = 65536(0x10000, float:9.18355E-41)
        L_0x00d7:
            r5 = r5 | r30
        L_0x00d9:
            r30 = r12 & 64
            r31 = 3670016(0x380000, float:5.142788E-39)
            if (r30 == 0) goto L_0x00e6
            r32 = 1572864(0x180000, float:2.204052E-39)
            r5 = r5 | r32
            r10 = r45
            goto L_0x00f9
        L_0x00e6:
            r32 = r13 & r31
            r10 = r45
            if (r32 != 0) goto L_0x00f9
            boolean r33 = r0.changed((int) r10)
            if (r33 == 0) goto L_0x00f5
            r33 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00f7
        L_0x00f5:
            r33 = 524288(0x80000, float:7.34684E-40)
        L_0x00f7:
            r5 = r5 | r33
        L_0x00f9:
            r11 = r12 & 128(0x80, float:1.794E-43)
            r34 = 29360128(0x1c00000, float:7.052966E-38)
            if (r11 == 0) goto L_0x0106
            r35 = 12582912(0xc00000, float:1.7632415E-38)
            r5 = r5 | r35
            r2 = r46
            goto L_0x0119
        L_0x0106:
            r35 = r13 & r34
            r2 = r46
            if (r35 != 0) goto L_0x0119
            boolean r35 = r0.changed((boolean) r2)
            if (r35 == 0) goto L_0x0115
            r35 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0117
        L_0x0115:
            r35 = 4194304(0x400000, float:5.877472E-39)
        L_0x0117:
            r5 = r5 | r35
        L_0x0119:
            r2 = r12 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0124
            r35 = 100663296(0x6000000, float:2.4074124E-35)
            r5 = r5 | r35
            r3 = r47
            goto L_0x0139
        L_0x0124:
            r35 = 234881024(0xe000000, float:1.5777218E-30)
            r35 = r13 & r35
            r3 = r47
            if (r35 != 0) goto L_0x0139
            boolean r35 = r0.changed((java.lang.Object) r3)
            if (r35 == 0) goto L_0x0135
            r35 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0137
        L_0x0135:
            r35 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0137:
            r5 = r5 | r35
        L_0x0139:
            r3 = r12 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x0144
            r35 = 805306368(0x30000000, float:4.656613E-10)
            r5 = r5 | r35
            r4 = r48
            goto L_0x0159
        L_0x0144:
            r35 = 1879048192(0x70000000, float:1.58456325E29)
            r35 = r13 & r35
            r4 = r48
            if (r35 != 0) goto L_0x0159
            boolean r35 = r0.changed((boolean) r4)
            if (r35 == 0) goto L_0x0155
            r35 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0157
        L_0x0155:
            r35 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0157:
            r5 = r5 | r35
        L_0x0159:
            r35 = r14 & 14
            if (r35 != 0) goto L_0x0173
            r4 = r12 & 1024(0x400, float:1.435E-42)
            if (r4 != 0) goto L_0x016c
            r4 = r49
            boolean r35 = r0.changed((java.lang.Object) r4)
            if (r35 == 0) goto L_0x016e
            r19 = 4
            goto L_0x0170
        L_0x016c:
            r4 = r49
        L_0x016e:
            r19 = 2
        L_0x0170:
            r19 = r14 | r19
            goto L_0x0177
        L_0x0173:
            r4 = r49
            r19 = r14
        L_0x0177:
            r4 = r12 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x0180
            r19 = r19 | 48
            r6 = r50
            goto L_0x0193
        L_0x0180:
            r35 = r14 & 112(0x70, float:1.57E-43)
            r6 = r50
            if (r35 != 0) goto L_0x0193
            boolean r35 = r0.changed((float) r6)
            if (r35 == 0) goto L_0x018f
            r24 = 32
            goto L_0x0191
        L_0x018f:
            r24 = 16
        L_0x0191:
            r19 = r19 | r24
        L_0x0193:
            r6 = r14 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x01ad
            r6 = r12 & 4096(0x1000, float:5.74E-42)
            if (r6 != 0) goto L_0x01a6
            r6 = r51
            boolean r24 = r0.changed((long) r6)
            if (r24 == 0) goto L_0x01a8
            r32 = 256(0x100, float:3.59E-43)
            goto L_0x01aa
        L_0x01a6:
            r6 = r51
        L_0x01a8:
            r32 = 128(0x80, float:1.794E-43)
        L_0x01aa:
            r19 = r19 | r32
            goto L_0x01af
        L_0x01ad:
            r6 = r51
        L_0x01af:
            r6 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x01c7
            r6 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r6 != 0) goto L_0x01c0
            r6 = r53
            boolean r24 = r0.changed((long) r6)
            if (r24 == 0) goto L_0x01c2
            goto L_0x01c4
        L_0x01c0:
            r6 = r53
        L_0x01c2:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x01c4:
            r19 = r19 | r17
            goto L_0x01c9
        L_0x01c7:
            r6 = r53
        L_0x01c9:
            r17 = r14 & r21
            if (r17 != 0) goto L_0x01e1
            r6 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r6 != 0) goto L_0x01da
            r6 = r55
            boolean r17 = r0.changed((long) r6)
            if (r17 == 0) goto L_0x01dc
            goto L_0x01de
        L_0x01da:
            r6 = r55
        L_0x01dc:
            r22 = 8192(0x2000, float:1.14794E-41)
        L_0x01de:
            r19 = r19 | r22
            goto L_0x01e3
        L_0x01e1:
            r6 = r55
        L_0x01e3:
            r17 = r14 & r27
            if (r17 != 0) goto L_0x01fe
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r12 & r17
            r6 = r57
            if (r17 != 0) goto L_0x01f9
            boolean r17 = r0.changed((long) r6)
            if (r17 == 0) goto L_0x01f9
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01fb
        L_0x01f9:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x01fb:
            r19 = r19 | r17
            goto L_0x0200
        L_0x01fe:
            r6 = r57
        L_0x0200:
            r17 = r14 & r31
            if (r17 != 0) goto L_0x0218
            r17 = r12 & r28
            r6 = r59
            if (r17 != 0) goto L_0x0213
            boolean r17 = r0.changed((long) r6)
            if (r17 == 0) goto L_0x0213
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0215
        L_0x0213:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x0215:
            r19 = r19 | r17
            goto L_0x021a
        L_0x0218:
            r6 = r59
        L_0x021a:
            r17 = r12 & r26
            if (r17 == 0) goto L_0x0223
            r17 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x0220:
            r19 = r19 | r17
            goto L_0x0233
        L_0x0223:
            r17 = r14 & r34
            if (r17 != 0) goto L_0x0233
            boolean r17 = r0.changed((java.lang.Object) r15)
            if (r17 == 0) goto L_0x0230
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0220
        L_0x0230:
            r17 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x0220
        L_0x0233:
            r17 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r6 = r5 & r17
            r7 = 306783378(0x12492492, float:6.3469493E-28)
            if (r6 != r7) goto L_0x0273
            r6 = 23967451(0x16db6db, float:4.3661218E-38)
            r6 = r19 & r6
            r7 = 4793490(0x492492, float:6.71711E-39)
            if (r6 != r7) goto L_0x0273
            boolean r6 = r0.getSkipping()
            if (r6 != 0) goto L_0x024e
            goto L_0x0273
        L_0x024e:
            r0.skipToGroupEnd()
            r1 = r39
            r2 = r40
            r3 = r41
            r4 = r42
            r5 = r43
            r9 = r47
            r11 = r49
            r12 = r50
            r18 = r51
            r22 = r53
            r24 = r55
            r28 = r57
            r32 = r59
            r6 = r8
            r7 = r10
            r8 = r46
            r10 = r48
            goto L_0x04d3
        L_0x0273:
            r0.startDefaults()
            r6 = r13 & 1
            if (r6 == 0) goto L_0x02dd
            boolean r6 = r0.getDefaultsInvalid()
            if (r6 == 0) goto L_0x0281
            goto L_0x02dd
        L_0x0281:
            r0.skipToGroupEnd()
            r1 = r12 & 2
            if (r1 == 0) goto L_0x028a
            r5 = r5 & -113(0xffffffffffffff8f, float:NaN)
        L_0x028a:
            r1 = r12 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0290
            r19 = r19 & -15
        L_0x0290:
            r1 = r19
            r2 = r12 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x0298
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0298:
            r2 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x029e
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x029e:
            r2 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x02a6
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r2
        L_0x02a6:
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r12
            if (r2 == 0) goto L_0x02b0
            r2 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r2
        L_0x02b0:
            r2 = r12 & r28
            if (r2 == 0) goto L_0x02b8
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r2
        L_0x02b8:
            r2 = r40
            r6 = r41
            r7 = r42
            r11 = r46
            r3 = r47
            r4 = r48
            r16 = r50
            r18 = r51
            r22 = r53
            r24 = r55
            r28 = r57
            r32 = r59
            r17 = r1
            r20 = r5
            r9 = r8
            r1 = r39
            r8 = r43
            r5 = r49
            goto L_0x040a
        L_0x02dd:
            if (r1 == 0) goto L_0x02e4
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x02e6
        L_0x02e4:
            r1 = r39
        L_0x02e6:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x02f7
            r6 = 0
            r7 = 0
            r39 = r1
            r1 = 0
            r8 = 3
            androidx.compose.material.ScaffoldState r1 = rememberScaffoldState(r6, r7, r0, r1, r8)
            r5 = r5 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x02fb
        L_0x02f7:
            r39 = r1
            r1 = r40
        L_0x02fb:
            if (r9 == 0) goto L_0x0304
            androidx.compose.material.ComposableSingletons$ScaffoldKt r6 = androidx.compose.material.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r6 = r6.m1240getLambda1$material_release()
            goto L_0x0306
        L_0x0304:
            r6 = r41
        L_0x0306:
            if (r16 == 0) goto L_0x030f
            androidx.compose.material.ComposableSingletons$ScaffoldKt r7 = androidx.compose.material.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r7 = r7.m1241getLambda2$material_release()
            goto L_0x0311
        L_0x030f:
            r7 = r42
        L_0x0311:
            if (r20 == 0) goto L_0x031a
            androidx.compose.material.ComposableSingletons$ScaffoldKt r8 = androidx.compose.material.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function3 r8 = r8.m1242getLambda3$material_release()
            goto L_0x031c
        L_0x031a:
            r8 = r43
        L_0x031c:
            if (r25 == 0) goto L_0x0325
            androidx.compose.material.ComposableSingletons$ScaffoldKt r9 = androidx.compose.material.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r9 = r9.m1243getLambda4$material_release()
            goto L_0x0327
        L_0x0325:
            r9 = r44
        L_0x0327:
            if (r30 == 0) goto L_0x032f
            androidx.compose.material.FabPosition$Companion r10 = androidx.compose.material.FabPosition.Companion
            int r10 = r10.m1304getEnd5ygKITE()
        L_0x032f:
            if (r11 == 0) goto L_0x0333
            r11 = 0
            goto L_0x0335
        L_0x0333:
            r11 = r46
        L_0x0335:
            if (r2 == 0) goto L_0x0339
            r2 = 0
            goto L_0x033b
        L_0x0339:
            r2 = r47
        L_0x033b:
            if (r3 == 0) goto L_0x033f
            r3 = 1
            goto L_0x0341
        L_0x033f:
            r3 = r48
        L_0x0341:
            r40 = r1
            r1 = r12 & 1024(0x400, float:1.435E-42)
            r41 = r2
            r2 = 6
            if (r1 == 0) goto L_0x0359
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r1 = r1.getShapes(r0, r2)
            androidx.compose.foundation.shape.CornerBasedShape r1 = r1.getLarge()
            androidx.compose.ui.graphics.Shape r1 = (androidx.compose.ui.graphics.Shape) r1
            r19 = r19 & -15
            goto L_0x035b
        L_0x0359:
            r1 = r49
        L_0x035b:
            r36 = r19
            if (r4 == 0) goto L_0x0366
            androidx.compose.material.DrawerDefaults r4 = androidx.compose.material.DrawerDefaults.INSTANCE
            float r4 = r4.m1259getElevationD9Ej5fM()
            goto L_0x0368
        L_0x0366:
            r4 = r50
        L_0x0368:
            r2 = r12 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x0387
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            r43 = r1
            r1 = 6
            androidx.compose.material.Colors r2 = r2.getColors(r0, r1)
            long r1 = r2.m1218getSurface0d7_KjU()
            r44 = r1
            r1 = r36
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r38 = r3
            r3 = r1
            r1 = r44
            r44 = r38
            goto L_0x0390
        L_0x0387:
            r43 = r1
            r1 = r36
            r44 = r3
            r3 = r1
            r1 = r51
        L_0x0390:
            r45 = r4
            r4 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r4 == 0) goto L_0x03a1
            int r4 = r3 >> 6
            r4 = r4 & 14
            long r16 = androidx.compose.material.ColorsKt.m1232contentColorForek8zF_U(r1, r0, r4)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x03a3
        L_0x03a1:
            r16 = r53
        L_0x03a3:
            r4 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r4 == 0) goto L_0x03b5
            androidx.compose.material.DrawerDefaults r4 = androidx.compose.material.DrawerDefaults.INSTANCE
            r18 = r1
            r1 = 6
            long r22 = r4.getScrimColor(r0, r1)
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            r3 = r3 & r2
            goto L_0x03ba
        L_0x03b5:
            r18 = r1
            r1 = 6
            r22 = r55
        L_0x03ba:
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r12
            if (r2 == 0) goto L_0x03cf
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r1 = r2.getColors(r0, r1)
            long r1 = r1.m1207getBackground0d7_KjU()
            r4 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r4
            goto L_0x03d1
        L_0x03cf:
            r1 = r57
        L_0x03d1:
            r4 = r12 & r28
            if (r4 == 0) goto L_0x03f2
            int r4 = r3 >> 15
            r4 = r4 & 14
            long r24 = androidx.compose.material.ColorsKt.m1232contentColorForek8zF_U(r1, r0, r4)
            r4 = -3670017(0xffffffffffc7ffff, float:NaN)
            r3 = r3 & r4
            r4 = r44
            r28 = r1
            r20 = r5
            r32 = r24
            r1 = r39
            r2 = r40
            r5 = r43
            r24 = r22
            goto L_0x0402
        L_0x03f2:
            r4 = r44
            r32 = r59
            r28 = r1
            r20 = r5
            r24 = r22
            r1 = r39
            r2 = r40
            r5 = r43
        L_0x0402:
            r22 = r16
            r16 = r45
            r17 = r3
            r3 = r41
        L_0x040a:
            r0.endDefaults()
            androidx.compose.material.ScaffoldKt$Scaffold$child$1 r12 = new androidx.compose.material.ScaffoldKt$Scaffold$child$1
            r39 = r12
            r40 = r28
            r42 = r32
            r44 = r17
            r45 = r11
            r46 = r10
            r47 = r6
            r48 = r61
            r49 = r9
            r50 = r7
            r51 = r20
            r52 = r8
            r53 = r2
            r39.<init>(r40, r42, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53)
            r55 = r6
            r56 = r7
            r6 = 1823402604(0x6caeea6c, float:1.691681E27)
            r7 = 1
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r6, r7, r12)
            kotlin.jvm.functions.Function3 r6 = (kotlin.jvm.functions.Function3) r6
            if (r3 == 0) goto L_0x04a6
            r12 = -1013848234(0xffffffffc391e756, float:-291.8073)
            r0.startReplaceableGroup(r12)
            java.lang.String r12 = "195@8636L487"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            androidx.compose.material.DrawerState r12 = r2.getDrawerState()
            r7 = 100842932(0x602bdb4, float:2.4589654E-35)
            r57 = r2
            androidx.compose.material.ScaffoldKt$Scaffold$1 r2 = new androidx.compose.material.ScaffoldKt$Scaffold$1
            r2.<init>(r6)
            r6 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r7, r6, r2)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r6 = 805306368(0x30000000, float:4.656613E-10)
            int r7 = r20 >> 24
            r7 = r7 & 14
            r6 = r6 | r7
            int r7 = r20 << 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            r6 = r6 | r7
            int r7 = r20 >> 18
            r7 = r7 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | r7
            int r7 = r17 << 12
            r17 = r7 & r21
            r6 = r6 | r17
            r17 = r7 & r27
            r6 = r6 | r17
            r17 = r7 & r31
            r6 = r6 | r17
            r17 = r7 & r34
            r6 = r6 | r17
            r17 = 234881024(0xe000000, float:1.5777218E-30)
            r7 = r7 & r17
            r6 = r6 | r7
            r7 = 0
            r39 = r3
            r40 = r1
            r41 = r12
            r42 = r4
            r43 = r5
            r44 = r16
            r45 = r18
            r47 = r22
            r49 = r24
            r51 = r2
            r52 = r0
            r53 = r6
            r54 = r7
            androidx.compose.material.DrawerKt.m1263ModalDrawerGs3lGvM(r39, r40, r41, r42, r43, r44, r45, r47, r49, r51, r52, r53, r54)
            r0.endReplaceableGroup()
            goto L_0x04c1
        L_0x04a6:
            r57 = r2
            r2 = -1013847725(0xffffffffc391e953, float:-291.82285)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "208@9145L15"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = r20 & 14
            r2 = r2 | 48
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.invoke(r1, r0, r2)
            r0.endReplaceableGroup()
        L_0x04c1:
            r2 = r57
            r6 = r9
            r7 = r10
            r12 = r16
            r9 = r3
            r10 = r4
            r3 = r55
            r4 = r56
            r38 = r11
            r11 = r5
            r5 = r8
            r8 = r38
        L_0x04d3:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 != 0) goto L_0x04da
            goto L_0x04fe
        L_0x04da:
            androidx.compose.material.ScaffoldKt$Scaffold$2 r27 = new androidx.compose.material.ScaffoldKt$Scaffold$2
            r37 = r0
            r0 = r27
            r13 = r18
            r15 = r22
            r17 = r24
            r19 = r28
            r21 = r32
            r23 = r61
            r24 = r63
            r25 = r64
            r26 = r65
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r17, r19, r21, r23, r24, r25, r26)
            r0 = r27
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r37
            r1.updateScope(r0)
        L_0x04fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt.m1388Scaffold27mzLpw(androidx.compose.ui.Modifier, androidx.compose.material.ScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, kotlin.jvm.functions.Function3, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: ScaffoldLayout-MDYNRJg  reason: not valid java name */
    public static final void m1389ScaffoldLayoutMDYNRJg(boolean z, int i, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, int i2) {
        int i3;
        Modifier modifier;
        Function2<? super Composer, ? super Integer, Unit> function25 = function2;
        Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32 = function3;
        Function2<? super Composer, ? super Integer, Unit> function26 = function22;
        Function2<? super Composer, ? super Integer, Unit> function27 = function23;
        Function2<? super Composer, ? super Integer, Unit> function28 = function24;
        int i4 = i2;
        Composer startRestartGroup = composer.startRestartGroup(-1401632215);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScaffoldLayout)P(4,3:c#material.FabPosition,6,1,5,2)236@10234L4498,236@10217L4515:Scaffold.kt#jmzs0o");
        boolean z2 = z;
        if ((i4 & 14) == 0) {
            i3 = (startRestartGroup.changed(z2) ? 4 : 2) | i4;
        } else {
            i3 = i4;
        }
        int i5 = i;
        if ((i4 & 112) == 0) {
            i3 |= startRestartGroup.changed(i5) ? 32 : 16;
        }
        if ((i4 & 896) == 0) {
            i3 |= startRestartGroup.changed((Object) function25) ? 256 : 128;
        }
        if ((i4 & 7168) == 0) {
            i3 |= startRestartGroup.changed((Object) function32) ? 2048 : 1024;
        }
        if ((57344 & i4) == 0) {
            i3 |= startRestartGroup.changed((Object) function26) ? 16384 : 8192;
        }
        if ((458752 & i4) == 0) {
            i3 |= startRestartGroup.changed((Object) function27) ? 131072 : 65536;
        }
        if ((3670016 & i4) == 0) {
            i3 |= startRestartGroup.changed((Object) function28) ? 1048576 : 524288;
        }
        int i6 = i3;
        if ((i6 & 2995931) != 599186 || !startRestartGroup.getSkipping()) {
            Object[] objArr = {function25, function26, function27, FabPosition.m1296boximpl(i), Boolean.valueOf(z), function28, function32};
            startRestartGroup.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            int i7 = 0;
            boolean z3 = false;
            for (int i8 = 7; i7 < i8; i8 = 7) {
                z3 |= startRestartGroup.changed(objArr[i7]);
                i7++;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                modifier = null;
                rememberedValue = new ScaffoldKt$ScaffoldLayout$1$1(function2, function22, function23, i, z, function24, i6, function3);
                startRestartGroup.updateRememberedValue(rememberedValue);
            } else {
                modifier = null;
            }
            startRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(modifier, (Function2) rememberedValue, startRestartGroup, 0, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ScaffoldKt$ScaffoldLayout$2(z, i, function2, function3, function22, function23, function24, i2));
        }
    }

    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }
}
