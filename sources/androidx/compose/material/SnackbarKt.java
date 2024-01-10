package androidx.compose.material;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a3\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010\u0011\u001a3\u0010\u0012\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010\u0011\u001ac\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u0001H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"\u001a{\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u00012\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%\u001a \u0010&\u001a\u00020\f2\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010'\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\n\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"HeightToFirstLine", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalSpacing", "HorizontalSpacingButtonSide", "LongButtonVerticalOffset", "SeparateButtonExtraY", "SnackbarMinHeightOneLine", "SnackbarMinHeightTwoLines", "SnackbarVerticalPadding", "TextEndExtraSpacing", "NewLineButtonSnackbar", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "Snackbar", "snackbarData", "Landroidx/compose/material/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "actionColor", "elevation", "Snackbar-sPrSdHI", "(Landroidx/compose/material/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJFLandroidx/compose/runtime/Composer;II)V", "content", "Snackbar-7zSek6w", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TextOnlySnackbar", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Snackbar.kt */
public final class SnackbarKt {
    /* access modifiers changed from: private */
    public static final float HeightToFirstLine = Dp.m4704constructorimpl((float) 30);
    private static final float HorizontalSpacing = Dp.m4704constructorimpl((float) 16);
    private static final float HorizontalSpacingButtonSide;
    private static final float LongButtonVerticalOffset = Dp.m4704constructorimpl((float) 12);
    private static final float SeparateButtonExtraY = Dp.m4704constructorimpl((float) 2);
    /* access modifiers changed from: private */
    public static final float SnackbarMinHeightOneLine = Dp.m4704constructorimpl((float) 48);
    /* access modifiers changed from: private */
    public static final float SnackbarMinHeightTwoLines = Dp.m4704constructorimpl((float) 68);
    private static final float SnackbarVerticalPadding = Dp.m4704constructorimpl((float) 6);
    /* access modifiers changed from: private */
    public static final float TextEndExtraSpacing;

    /* JADX WARNING: Removed duplicated region for block: B:127:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x011c  */
    /* renamed from: Snackbar-7zSek6w  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1399Snackbar7zSek6w(androidx.compose.ui.Modifier r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, boolean r31, androidx.compose.ui.graphics.Shape r32, long r33, long r35, float r37, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r10 = r38
            r11 = r40
            r12 = r41
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -558258760(0xffffffffdeb9a5b8, float:-6.6886503E18)
            r1 = r39
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Snackbar)P(6!2,7,2:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.unit.Dp)84@3955L6,85@4015L15,86@4072L6,90@4158L631:Snackbar.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x0023
            r2 = r11 | 6
            r3 = r2
            r2 = r29
            goto L_0x0037
        L_0x0023:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0034
            r2 = r29
            boolean r3 = r0.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0031
            r3 = 4
            goto L_0x0032
        L_0x0031:
            r3 = 2
        L_0x0032:
            r3 = r3 | r11
            goto L_0x0037
        L_0x0034:
            r2 = r29
            r3 = r11
        L_0x0037:
            r4 = r12 & 2
            if (r4 == 0) goto L_0x003e
            r3 = r3 | 48
            goto L_0x0051
        L_0x003e:
            r5 = r11 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0051
            r5 = r30
            boolean r6 = r0.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x004d
            r6 = 32
            goto L_0x004f
        L_0x004d:
            r6 = 16
        L_0x004f:
            r3 = r3 | r6
            goto L_0x0053
        L_0x0051:
            r5 = r30
        L_0x0053:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x005a
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x006d
        L_0x005a:
            r7 = r11 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x006d
            r7 = r31
            boolean r8 = r0.changed((boolean) r7)
            if (r8 == 0) goto L_0x0069
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0069:
            r8 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r3 = r3 | r8
            goto L_0x006f
        L_0x006d:
            r7 = r31
        L_0x006f:
            r8 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0088
            r8 = r12 & 8
            if (r8 != 0) goto L_0x0082
            r8 = r32
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0084
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0086
        L_0x0082:
            r8 = r32
        L_0x0084:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0086:
            r3 = r3 | r9
            goto L_0x008a
        L_0x0088:
            r8 = r32
        L_0x008a:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r11
            if (r9 != 0) goto L_0x00a3
            r9 = r12 & 16
            r13 = r33
            if (r9 != 0) goto L_0x009f
            boolean r9 = r0.changed((long) r13)
            if (r9 == 0) goto L_0x009f
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a1
        L_0x009f:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x00a1:
            r3 = r3 | r9
            goto L_0x00a5
        L_0x00a3:
            r13 = r33
        L_0x00a5:
            r9 = 458752(0x70000, float:6.42848E-40)
            r15 = r11 & r9
            if (r15 != 0) goto L_0x00be
            r15 = r12 & 32
            r9 = r35
            if (r15 != 0) goto L_0x00ba
            boolean r15 = r0.changed((long) r9)
            if (r15 == 0) goto L_0x00ba
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00ba:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r3 = r3 | r15
            goto L_0x00c0
        L_0x00be:
            r9 = r35
        L_0x00c0:
            r15 = r12 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00cb
            r3 = r3 | r16
            r2 = r37
            goto L_0x00e0
        L_0x00cb:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r11 & r17
            r2 = r37
            if (r17 != 0) goto L_0x00e0
            boolean r17 = r0.changed((float) r2)
            if (r17 == 0) goto L_0x00dc
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00de
        L_0x00dc:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00de:
            r3 = r3 | r17
        L_0x00e0:
            r2 = r12 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00ea
            r2 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r2
            r10 = r38
            goto L_0x00fd
        L_0x00ea:
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r11
            r10 = r38
            if (r2 != 0) goto L_0x00fd
            boolean r2 = r0.changed((java.lang.Object) r10)
            if (r2 == 0) goto L_0x00fa
            r2 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fc
        L_0x00fa:
            r2 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fc:
            r3 = r3 | r2
        L_0x00fd:
            r2 = 23967451(0x16db6db, float:4.3661218E-38)
            r2 = r2 & r3
            r9 = 4793490(0x492492, float:6.71711E-39)
            if (r2 != r9) goto L_0x011c
            boolean r2 = r0.getSkipping()
            if (r2 != 0) goto L_0x010d
            goto L_0x011c
        L_0x010d:
            r0.skipToGroupEnd()
            r1 = r29
            r9 = r37
            r2 = r5
            r3 = r7
            r4 = r8
            r5 = r13
            r7 = r35
            goto L_0x01e5
        L_0x011c:
            r0.startDefaults()
            r2 = r11 & 1
            r9 = -458753(0xfffffffffff8ffff, float:NaN)
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            if (r2 == 0) goto L_0x014d
            boolean r2 = r0.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0130
            goto L_0x014d
        L_0x0130:
            r0.skipToGroupEnd()
            r1 = r12 & 8
            if (r1 == 0) goto L_0x0139
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0139:
            r1 = r12 & 16
            if (r1 == 0) goto L_0x013f
            r3 = r3 & r17
        L_0x013f:
            r1 = r12 & 32
            if (r1 == 0) goto L_0x0144
            r3 = r3 & r9
        L_0x0144:
            r1 = r29
            r25 = r35
            r4 = r37
            r6 = r3
            r2 = r13
            goto L_0x01a1
        L_0x014d:
            if (r1 == 0) goto L_0x0154
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x0156
        L_0x0154:
            r1 = r29
        L_0x0156:
            if (r4 == 0) goto L_0x015a
            r2 = 0
            r5 = r2
        L_0x015a:
            if (r6 == 0) goto L_0x015e
            r2 = 0
            r7 = 0
        L_0x015e:
            r2 = r12 & 8
            r4 = 6
            if (r2 == 0) goto L_0x0172
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r2 = r2.getShapes(r0, r4)
            androidx.compose.foundation.shape.CornerBasedShape r2 = r2.getSmall()
            androidx.compose.ui.graphics.Shape r2 = (androidx.compose.ui.graphics.Shape) r2
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            r8 = r2
        L_0x0172:
            r2 = r12 & 16
            if (r2 == 0) goto L_0x017e
            androidx.compose.material.SnackbarDefaults r2 = androidx.compose.material.SnackbarDefaults.INSTANCE
            long r13 = r2.getBackgroundColor(r0, r4)
            r3 = r3 & r17
        L_0x017e:
            r2 = r12 & 32
            if (r2 == 0) goto L_0x0190
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r2 = r2.getColors(r0, r4)
            long r17 = r2.m1218getSurface0d7_KjU()
            r2 = r3 & r9
            r3 = r2
            goto L_0x0192
        L_0x0190:
            r17 = r35
        L_0x0192:
            if (r15 == 0) goto L_0x019b
            float r2 = (float) r4
            float r2 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r2)
            r4 = r2
            goto L_0x019d
        L_0x019b:
            r4 = r37
        L_0x019d:
            r6 = r3
            r2 = r13
            r25 = r17
        L_0x01a1:
            r0.endDefaults()
            r19 = 0
            r9 = -2084221700(0xffffffff83c54cfc, float:-1.1596294E-36)
            androidx.compose.material.SnackbarKt$Snackbar$1 r13 = new androidx.compose.material.SnackbarKt$Snackbar$1
            r13.<init>(r5, r10, r6, r7)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r9, r14, r13)
            r21 = r9
            kotlin.jvm.functions.Function2 r21 = (kotlin.jvm.functions.Function2) r21
            r9 = r6 & 14
            r9 = r9 | r16
            int r13 = r6 >> 6
            r14 = r13 & 112(0x70, float:1.57E-43)
            r9 = r9 | r14
            r14 = r13 & 896(0x380, float:1.256E-42)
            r9 = r9 | r14
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | r13
            int r6 = r6 >> 3
            r13 = 458752(0x70000, float:6.42848E-40)
            r6 = r6 & r13
            r23 = r9 | r6
            r24 = 16
            r13 = r1
            r14 = r8
            r15 = r2
            r17 = r25
            r20 = r4
            r22 = r0
            androidx.compose.material.SurfaceKt.m1419SurfaceFjzlyU(r13, r14, r15, r17, r19, r20, r21, r22, r23, r24)
            r9 = r4
            r4 = r8
            r27 = r2
            r2 = r5
            r5 = r27
            r3 = r7
            r7 = r25
        L_0x01e5:
            androidx.compose.runtime.ScopeUpdateScope r13 = r0.endRestartGroup()
            if (r13 != 0) goto L_0x01ec
            goto L_0x01fd
        L_0x01ec:
            androidx.compose.material.SnackbarKt$Snackbar$2 r14 = new androidx.compose.material.SnackbarKt$Snackbar$2
            r0 = r14
            r10 = r38
            r11 = r40
            r12 = r41
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x01fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarKt.m1399Snackbar7zSek6w(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.graphics.Shape, long, long, float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:140:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x011a  */
    /* renamed from: Snackbar-sPrSdHI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1400SnackbarsPrSdHI(androidx.compose.material.SnackbarData r29, androidx.compose.ui.Modifier r30, boolean r31, androidx.compose.ui.graphics.Shape r32, long r33, long r35, long r37, float r39, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r1 = r29
            r12 = r41
            r13 = r42
            java.lang.String r0 = "snackbarData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = 258660814(0xf6ad9ce, float:1.15790384E-29)
            r2 = r40
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(Snackbar)P(7,5,1,6,2:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,4:c#ui.unit.Dp)155@7132L6,156@7192L15,157@7249L6,158@7307L18,173@7784L320:Snackbar.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = r13 & 1
            if (r2 == 0) goto L_0x0021
            r2 = r12 | 6
            goto L_0x0031
        L_0x0021:
            r2 = r12 & 14
            if (r2 != 0) goto L_0x0030
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x002d
            r2 = 4
            goto L_0x002e
        L_0x002d:
            r2 = 2
        L_0x002e:
            r2 = r2 | r12
            goto L_0x0031
        L_0x0030:
            r2 = r12
        L_0x0031:
            r3 = r13 & 2
            if (r3 == 0) goto L_0x0038
            r2 = r2 | 48
            goto L_0x004b
        L_0x0038:
            r4 = r12 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004b
            r4 = r30
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0047
            r5 = 32
            goto L_0x0049
        L_0x0047:
            r5 = 16
        L_0x0049:
            r2 = r2 | r5
            goto L_0x004d
        L_0x004b:
            r4 = r30
        L_0x004d:
            r5 = r13 & 4
            if (r5 == 0) goto L_0x0054
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0067
        L_0x0054:
            r6 = r12 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0067
            r6 = r31
            boolean r7 = r0.changed((boolean) r6)
            if (r7 == 0) goto L_0x0063
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0065
        L_0x0063:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0065:
            r2 = r2 | r7
            goto L_0x0069
        L_0x0067:
            r6 = r31
        L_0x0069:
            r7 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0082
            r7 = r13 & 8
            if (r7 != 0) goto L_0x007c
            r7 = r32
            boolean r8 = r0.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x007e
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007c:
            r7 = r32
        L_0x007e:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r2 = r2 | r8
            goto L_0x0084
        L_0x0082:
            r7 = r32
        L_0x0084:
            r8 = 57344(0xe000, float:8.0356E-41)
            r9 = r12 & r8
            if (r9 != 0) goto L_0x00a0
            r9 = r13 & 16
            if (r9 != 0) goto L_0x009a
            r9 = r33
            boolean r11 = r0.changed((long) r9)
            if (r11 == 0) goto L_0x009c
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009e
        L_0x009a:
            r9 = r33
        L_0x009c:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x009e:
            r2 = r2 | r11
            goto L_0x00a2
        L_0x00a0:
            r9 = r33
        L_0x00a2:
            r11 = 458752(0x70000, float:6.42848E-40)
            r14 = r12 & r11
            if (r14 != 0) goto L_0x00be
            r14 = r13 & 32
            if (r14 != 0) goto L_0x00b7
            r14 = r35
            boolean r16 = r0.changed((long) r14)
            if (r16 == 0) goto L_0x00b9
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bb
        L_0x00b7:
            r14 = r35
        L_0x00b9:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bb:
            r2 = r2 | r16
            goto L_0x00c0
        L_0x00be:
            r14 = r35
        L_0x00c0:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r17 = r12 & r16
            if (r17 != 0) goto L_0x00d9
            r17 = r13 & 64
            r8 = r37
            if (r17 != 0) goto L_0x00d5
            boolean r10 = r0.changed((long) r8)
            if (r10 == 0) goto L_0x00d5
            r10 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d7
        L_0x00d5:
            r10 = 524288(0x80000, float:7.34684E-40)
        L_0x00d7:
            r2 = r2 | r10
            goto L_0x00db
        L_0x00d9:
            r8 = r37
        L_0x00db:
            r10 = r13 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r10 == 0) goto L_0x00e6
            r2 = r2 | r17
            r11 = r39
            goto L_0x00fb
        L_0x00e6:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r12 & r18
            r11 = r39
            if (r18 != 0) goto L_0x00fb
            boolean r19 = r0.changed((float) r11)
            if (r19 == 0) goto L_0x00f7
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f9
        L_0x00f7:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f9:
            r2 = r2 | r19
        L_0x00fb:
            r19 = 23967451(0x16db6db, float:4.3661218E-38)
            r4 = r2 & r19
            r6 = 4793490(0x492492, float:6.71711E-39)
            if (r4 != r6) goto L_0x011a
            boolean r4 = r0.getSkipping()
            if (r4 != 0) goto L_0x010c
            goto L_0x011a
        L_0x010c:
            r0.skipToGroupEnd()
            r2 = r30
            r3 = r31
            r5 = r33
            r4 = r7
            r9 = r8
            r7 = r14
            goto L_0x023b
        L_0x011a:
            r0.startDefaults()
            r4 = r12 & 1
            r6 = -3670017(0xffffffffffc7ffff, float:NaN)
            r19 = -458753(0xfffffffffff8ffff, float:NaN)
            r20 = -57345(0xffffffffffff1fff, float:NaN)
            if (r4 == 0) goto L_0x015b
            boolean r4 = r0.getDefaultsInvalid()
            if (r4 == 0) goto L_0x0131
            goto L_0x015b
        L_0x0131:
            r0.skipToGroupEnd()
            r3 = r13 & 8
            if (r3 == 0) goto L_0x013a
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x013a:
            r3 = r13 & 16
            if (r3 == 0) goto L_0x0140
            r2 = r2 & r20
        L_0x0140:
            r3 = r13 & 32
            if (r3 == 0) goto L_0x0146
            r2 = r2 & r19
        L_0x0146:
            r3 = r13 & 64
            if (r3 == 0) goto L_0x014b
            r2 = r2 & r6
        L_0x014b:
            r3 = r30
            r4 = r31
            r5 = r7
            r6 = r33
            r27 = r14
            r14 = r2
            r2 = r11
            r10 = r8
            r8 = r27
            goto L_0x01c3
        L_0x015b:
            if (r3 == 0) goto L_0x0162
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x0164
        L_0x0162:
            r3 = r30
        L_0x0164:
            if (r5 == 0) goto L_0x0168
            r4 = 0
            goto L_0x016a
        L_0x0168:
            r4 = r31
        L_0x016a:
            r5 = r13 & 8
            r6 = 6
            if (r5 == 0) goto L_0x017e
            androidx.compose.material.MaterialTheme r5 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r5 = r5.getShapes(r0, r6)
            androidx.compose.foundation.shape.CornerBasedShape r5 = r5.getSmall()
            androidx.compose.ui.graphics.Shape r5 = (androidx.compose.ui.graphics.Shape) r5
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x017f
        L_0x017e:
            r5 = r7
        L_0x017f:
            r7 = r13 & 16
            if (r7 == 0) goto L_0x018c
            androidx.compose.material.SnackbarDefaults r7 = androidx.compose.material.SnackbarDefaults.INSTANCE
            long r22 = r7.getBackgroundColor(r0, r6)
            r2 = r2 & r20
            goto L_0x018e
        L_0x018c:
            r22 = r33
        L_0x018e:
            r7 = r13 & 32
            if (r7 == 0) goto L_0x019e
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r7 = r7.getColors(r0, r6)
            long r14 = r7.m1218getSurface0d7_KjU()
            r2 = r2 & r19
        L_0x019e:
            r7 = r13 & 64
            if (r7 == 0) goto L_0x01ad
            androidx.compose.material.SnackbarDefaults r7 = androidx.compose.material.SnackbarDefaults.INSTANCE
            long r7 = r7.getPrimaryActionColor(r0, r6)
            r9 = -3670017(0xffffffffffc7ffff, float:NaN)
            r2 = r2 & r9
            goto L_0x01ae
        L_0x01ad:
            r7 = r8
        L_0x01ae:
            if (r10 == 0) goto L_0x01ba
            float r6 = (float) r6
            float r6 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            r10 = r7
            r8 = r14
            r14 = r2
            r2 = r6
            goto L_0x01c1
        L_0x01ba:
            r27 = r14
            r14 = r2
            r2 = r11
            r10 = r7
            r8 = r27
        L_0x01c1:
            r6 = r22
        L_0x01c3:
            r0.endDefaults()
            java.lang.String r15 = r29.getActionLabel()
            if (r15 == 0) goto L_0x01e9
            androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1 r12 = new androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1
            r30 = r12
            r31 = r10
            r33 = r14
            r34 = r29
            r35 = r15
            r30.<init>(r31, r33, r34, r35)
            r30 = r10
            r10 = 1
            r15 = 1843479216(0x6de142b0, float:8.7143434E27)
            androidx.compose.runtime.internal.ComposableLambda r11 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r15, r10, r12)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r15 = r11
            goto L_0x01ef
        L_0x01e9:
            r30 = r10
            r10 = 0
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r15 = r10
        L_0x01ef:
            r10 = 12
            float r10 = (float) r10
            float r10 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r10)
            androidx.compose.ui.Modifier r10 = androidx.compose.foundation.layout.PaddingKt.m510padding3ABfNKs(r3, r10)
            r11 = -261845785(0xfffffffff0648ce7, float:-2.829317E29)
            androidx.compose.material.SnackbarKt$Snackbar$3 r12 = new androidx.compose.material.SnackbarKt$Snackbar$3
            r12.<init>(r1)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r11, r1, r12)
            r23 = r1
            kotlin.jvm.functions.Function2 r23 = (kotlin.jvm.functions.Function2) r23
            r1 = r14 & 896(0x380, float:1.256E-42)
            r1 = r1 | r17
            r11 = r14 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r11
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r14
            r1 = r1 | r11
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r14
            r1 = r1 | r11
            int r11 = r14 >> 3
            r11 = r11 & r16
            r25 = r1 | r11
            r26 = 0
            r14 = r10
            r16 = r4
            r17 = r5
            r18 = r6
            r20 = r8
            r22 = r2
            r24 = r0
            m1399Snackbar7zSek6w(r14, r15, r16, r17, r18, r20, r22, r23, r24, r25, r26)
            r11 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r7 = r8
            r9 = r30
        L_0x023b:
            androidx.compose.runtime.ScopeUpdateScope r14 = r0.endRestartGroup()
            if (r14 != 0) goto L_0x0242
            goto L_0x0253
        L_0x0242:
            androidx.compose.material.SnackbarKt$Snackbar$4 r15 = new androidx.compose.material.SnackbarKt$Snackbar$4
            r0 = r15
            r1 = r29
            r12 = r41
            r13 = r42
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r11, r12, r13)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r14.updateScope(r15)
        L_0x0253:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarKt.m1400SnackbarsPrSdHI(androidx.compose.material.SnackbarData, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void TextOnlySnackbar(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(917397959);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextOnlySnackbar)236@9927L1207:Snackbar.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !startRestartGroup.getSkipping()) {
            MeasurePolicy measurePolicy = SnackbarKt$TextOnlySnackbar$2.INSTANCE;
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
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
            Composer r10 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r10, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r10, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r10, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r10, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-266728784);
            ComposerKt.sourceInformation(startRestartGroup, "C237@9944L202:Snackbar.kt#jmzs0o");
            Modifier r4 = PaddingKt.m511paddingVpY3zN4(Modifier.Companion, HorizontalSpacing, SnackbarVerticalPadding);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density2 = (Density) consume4;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection2 = (LayoutDirection) consume5;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume6;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r4);
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
            Composer r7 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r7, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r7, density2, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r7, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r7, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(1392363114);
            ComposerKt.sourceInformation(startRestartGroup, "C243@10127L9:Snackbar.kt#jmzs0o");
            function2.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SnackbarKt$TextOnlySnackbar$3(function2, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void NewLineButtonSnackbar(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1229075900);
        ComposerKt.sourceInformation(startRestartGroup, "C(NewLineButtonSnackbar)P(1)274@11262L476:Snackbar.kt#jmzs0o");
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) function23) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) function24) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            Modifier r5 = PaddingKt.m514paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), HorizontalSpacing, 0.0f, HorizontalSpacingButtonSide, SeparateButtonExtraY, 2, (Object) null);
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r5);
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
            Composer r11 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r11, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r11, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r11, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r11, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1163856341);
            ComposerKt.sourceInformation(startRestartGroup, "C79@3994L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(-1214415430);
            ComposerKt.sourceInformation(startRestartGroup, "C282@11505L171,286@11685L47:Snackbar.kt#jmzs0o");
            Modifier r10 = PaddingKt.m514paddingqDBjuR0$default(AlignmentLineKt.m387paddingFromBaselineVpY3zN4(Modifier.Companion, HeightToFirstLine, LongButtonVerticalOffset), 0.0f, 0.0f, HorizontalSpacingButtonSide, 0.0f, 11, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density2 = (Density) consume4;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection2 = (LayoutDirection) consume5;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume6;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r10);
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
            Composer r7 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r7, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r7, density2, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r7, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r7, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(1193033152);
            ComposerKt.sourceInformation(startRestartGroup, "C285@11668L6:Snackbar.kt#jmzs0o");
            function23.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier align = columnScope.align(Modifier.Companion, Alignment.Companion.getEnd());
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume7 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density3 = (Density) consume7;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume8 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection3 = (LayoutDirection) consume8;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume9 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) consume9;
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(align);
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
            Composer r12 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r12, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r12, density3, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r12, layoutDirection3, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r12, viewConfiguration3, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf3.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(-2100387721);
            ComposerKt.sourceInformation(startRestartGroup, "C286@11722L8:Snackbar.kt#jmzs0o");
            function24.invoke(startRestartGroup, Integer.valueOf((i2 >> 3) & 14));
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
            endRestartGroup.updateScope(new SnackbarKt$NewLineButtonSnackbar$2(function23, function24, i3));
        }
    }

    /* access modifiers changed from: private */
    public static final void OneRowSnackbar(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-534813202);
        ComposerKt.sourceInformation(startRestartGroup, "C(OneRowSnackbar)P(1)297@11913L2543:Snackbar.kt#jmzs0o");
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) function23) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) function24) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            Modifier r7 = PaddingKt.m514paddingqDBjuR0$default(Modifier.Companion, HorizontalSpacing, 0.0f, HorizontalSpacingButtonSide, 0.0f, 10, (Object) null);
            MeasurePolicy snackbarKt$OneRowSnackbar$2 = new SnackbarKt$OneRowSnackbar$2("action", "text");
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r7);
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
            Composer r9 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r9, snackbarKt$OneRowSnackbar$2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r9, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r9, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r9, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-643033641);
            ComposerKt.sourceInformation(startRestartGroup, "C299@11943L86,300@12042L46:Snackbar.kt#jmzs0o");
            Modifier r5 = PaddingKt.m512paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "text"), 0.0f, SnackbarVerticalPadding, 1, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density2 = (Density) consume4;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection2 = (LayoutDirection) consume5;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume6;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r5);
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
            Composer r92 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r92, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r92, density2, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r92, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r92, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(1616738193);
            ComposerKt.sourceInformation(startRestartGroup, "C299@12021L6:Snackbar.kt#jmzs0o");
            function23.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, "action");
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume7 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density3 = (Density) consume7;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume8 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection3 = (LayoutDirection) consume8;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume9 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) consume9;
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(layoutId);
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
            Composer r12 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r12, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r12, density3, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r12, layoutDirection3, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r12, viewConfiguration3, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf3.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(-1690150342);
            ComposerKt.sourceInformation(startRestartGroup, "C300@12078L8:Snackbar.kt#jmzs0o");
            function24.invoke(startRestartGroup, Integer.valueOf((i2 >> 3) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SnackbarKt$OneRowSnackbar$3(function23, function24, i3));
        }
    }

    static {
        float f = (float) 8;
        HorizontalSpacingButtonSide = Dp.m4704constructorimpl(f);
        TextEndExtraSpacing = Dp.m4704constructorimpl(f);
    }
}
