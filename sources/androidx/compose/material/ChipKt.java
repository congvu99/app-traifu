package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0001\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\b\u001b¢\u0006\u0002\b\u001fH\u0007¢\u0006\u0002\u0010 \u001aÄ\u0001\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00112\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020#2\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u0015\b\u0002\u0010%\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\b\u001b¢\u0006\u0002\b\u001fH\u0007¢\u0006\u0002\u0010&\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u0013\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"HorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "LeadingIconEndSpacing", "LeadingIconStartSpacing", "SelectedIconContainerSize", "SelectedOverlayOpacity", "", "SurfaceOverlayOpacity", "TrailingIconSpacing", "Chip", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "border", "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ChipColors;", "leadingIcon", "Landroidx/compose/runtime/Composable;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "selected", "Landroidx/compose/material/SelectableChipColors;", "selectedIcon", "trailingIcon", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/SelectableChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Chip.kt */
public final class ChipKt {
    /* access modifiers changed from: private */
    public static final float HorizontalPadding = Dp.m4704constructorimpl((float) 12);
    /* access modifiers changed from: private */
    public static final float LeadingIconEndSpacing;
    /* access modifiers changed from: private */
    public static final float LeadingIconStartSpacing = Dp.m4704constructorimpl((float) 4);
    /* access modifiers changed from: private */
    public static final float SelectedIconContainerSize = Dp.m4704constructorimpl((float) 24);
    private static final float SelectedOverlayOpacity = 0.16f;
    private static final float SurfaceOverlayOpacity = 0.12f;
    /* access modifiers changed from: private */
    public static final float TrailingIconSpacing;

    /* JADX WARNING: Removed duplicated region for block: B:100:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x010c  */
    @androidx.compose.material.ExperimentalMaterialApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Chip(kotlin.jvm.functions.Function0<kotlin.Unit> r35, androidx.compose.ui.Modifier r36, boolean r37, androidx.compose.foundation.interaction.MutableInteractionSource r38, androidx.compose.ui.graphics.Shape r39, androidx.compose.foundation.BorderStroke r40, androidx.compose.material.ChipColors r41, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, androidx.compose.runtime.Composer r44, int r45, int r46) {
        /*
            r15 = r35
            r14 = r43
            r13 = r45
            r12 = r46
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -368396408(0xffffffffea0ab788, float:-4.1924616E25)
            r1 = r44
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(Chip)P(7,6,3,4,8!2,5)91@4163L39,92@4237L6,94@4354L12,98@4499L21,104@4663L24,99@4525L1754:Chip.kt#jmzs0o"
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
            r1 = r12 & 2
            if (r1 == 0) goto L_0x003e
            r0 = r0 | 48
            goto L_0x0051
        L_0x003e:
            r2 = r13 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0051
            r2 = r36
            boolean r3 = r11.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x004d
            r3 = 32
            goto L_0x004f
        L_0x004d:
            r3 = 16
        L_0x004f:
            r0 = r0 | r3
            goto L_0x0053
        L_0x0051:
            r2 = r36
        L_0x0053:
            r3 = r12 & 4
            if (r3 == 0) goto L_0x005a
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006d
        L_0x005a:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x006d
            r4 = r37
            boolean r5 = r11.changed((boolean) r4)
            if (r5 == 0) goto L_0x0069
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0069:
            r5 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r0 = r0 | r5
            goto L_0x006f
        L_0x006d:
            r4 = r37
        L_0x006f:
            r5 = r12 & 8
            if (r5 == 0) goto L_0x0076
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0089
        L_0x0076:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0089
            r6 = r38
            boolean r7 = r11.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0085
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0087
        L_0x0085:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0087:
            r0 = r0 | r7
            goto L_0x008b
        L_0x0089:
            r6 = r38
        L_0x008b:
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r13
            if (r7 != 0) goto L_0x00a6
            r7 = r12 & 16
            if (r7 != 0) goto L_0x00a0
            r7 = r39
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x00a2
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a4
        L_0x00a0:
            r7 = r39
        L_0x00a2:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x00a4:
            r0 = r0 | r8
            goto L_0x00a8
        L_0x00a6:
            r7 = r39
        L_0x00a8:
            r8 = r12 & 32
            if (r8 == 0) goto L_0x00b0
            r9 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r9
            goto L_0x00c4
        L_0x00b0:
            r9 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r13
            if (r9 != 0) goto L_0x00c4
            r9 = r40
            boolean r10 = r11.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x00c0
            r10 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c2
        L_0x00c0:
            r10 = 65536(0x10000, float:9.18355E-41)
        L_0x00c2:
            r0 = r0 | r10
            goto L_0x00c6
        L_0x00c4:
            r9 = r40
        L_0x00c6:
            r10 = 3670016(0x380000, float:5.142788E-39)
            r16 = r13 & r10
            if (r16 != 0) goto L_0x00e0
            r16 = r12 & 64
            r10 = r41
            if (r16 != 0) goto L_0x00db
            boolean r16 = r11.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x00db
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00dd
        L_0x00db:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00dd:
            r0 = r0 | r16
            goto L_0x00e2
        L_0x00e0:
            r10 = r41
        L_0x00e2:
            r2 = r12 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00ed
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r16
            r4 = r42
            goto L_0x0102
        L_0x00ed:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r13 & r16
            r4 = r42
            if (r16 != 0) goto L_0x0102
            boolean r16 = r11.changed((java.lang.Object) r4)
            if (r16 == 0) goto L_0x00fe
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0100
        L_0x00fe:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x0100:
            r0 = r0 | r16
        L_0x0102:
            r4 = r12 & 256(0x100, float:3.59E-43)
            r32 = 234881024(0xe000000, float:1.5777218E-30)
            if (r4 == 0) goto L_0x010c
            r4 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x010a:
            r0 = r0 | r4
            goto L_0x011c
        L_0x010c:
            r4 = r13 & r32
            if (r4 != 0) goto L_0x011c
            boolean r4 = r11.changed((java.lang.Object) r14)
            if (r4 == 0) goto L_0x0119
            r4 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010a
        L_0x0119:
            r4 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x010a
        L_0x011c:
            r4 = 191739611(0xb6db6db, float:4.5782105E-32)
            r4 = r4 & r0
            r6 = 38347922(0x2492492, float:1.4777643E-37)
            if (r4 != r6) goto L_0x013e
            boolean r4 = r11.getSkipping()
            if (r4 != 0) goto L_0x012c
            goto L_0x013e
        L_0x012c:
            r11.skipToGroupEnd()
            r2 = r36
            r3 = r37
            r4 = r38
            r8 = r42
            r5 = r7
            r6 = r9
            r7 = r10
            r25 = r11
            goto L_0x02a1
        L_0x013e:
            r11.startDefaults()
            r4 = r13 & 1
            r33 = -3670017(0xffffffffffc7ffff, float:NaN)
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            r6 = 1
            if (r4 == 0) goto L_0x0171
            boolean r4 = r11.getDefaultsInvalid()
            if (r4 == 0) goto L_0x0153
            goto L_0x0171
        L_0x0153:
            r11.skipToGroupEnd()
            r1 = r12 & 16
            if (r1 == 0) goto L_0x015c
            r0 = r0 & r16
        L_0x015c:
            r1 = r12 & 64
            if (r1 == 0) goto L_0x0162
            r0 = r0 & r33
        L_0x0162:
            r16 = r36
            r17 = r38
            r34 = r42
            r18 = r7
            r19 = r9
            r9 = r10
            r10 = r37
            goto L_0x0204
        L_0x0171:
            if (r1 == 0) goto L_0x0178
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x017a
        L_0x0178:
            r1 = r36
        L_0x017a:
            if (r3 == 0) goto L_0x017e
            r3 = 1
            goto L_0x0180
        L_0x017e:
            r3 = r37
        L_0x0180:
            if (r5 == 0) goto L_0x01a6
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r4)
            java.lang.String r4 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r4)
            java.lang.Object r4 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r4 != r5) goto L_0x01a0
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r4)
        L_0x01a0:
            r11.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = (androidx.compose.foundation.interaction.MutableInteractionSource) r4
            goto L_0x01a8
        L_0x01a6:
            r4 = r38
        L_0x01a8:
            r5 = r12 & 16
            if (r5 == 0) goto L_0x01c6
            androidx.compose.material.MaterialTheme r5 = androidx.compose.material.MaterialTheme.INSTANCE
            r7 = 6
            androidx.compose.material.Shapes r5 = r5.getShapes(r11, r7)
            androidx.compose.foundation.shape.CornerBasedShape r5 = r5.getSmall()
            r7 = 50
            androidx.compose.foundation.shape.CornerSize r7 = androidx.compose.foundation.shape.CornerSizeKt.CornerSize((int) r7)
            androidx.compose.foundation.shape.CornerBasedShape r5 = r5.copy(r7)
            androidx.compose.ui.graphics.Shape r5 = (androidx.compose.ui.graphics.Shape) r5
            r0 = r0 & r16
            goto L_0x01c7
        L_0x01c6:
            r5 = r7
        L_0x01c7:
            if (r8 == 0) goto L_0x01ca
            r9 = 0
        L_0x01ca:
            r7 = r12 & 64
            if (r7 == 0) goto L_0x01e9
            androidx.compose.material.ChipDefaults r16 = androidx.compose.material.ChipDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r30 = 1572864(0x180000, float:2.204052E-39)
            r31 = 63
            r29 = r11
            androidx.compose.material.ChipColors r7 = r16.m1194chipColors5tl4gsc(r17, r19, r21, r23, r25, r27, r29, r30, r31)
            r0 = r0 & r33
            goto L_0x01ea
        L_0x01e9:
            r7 = r10
        L_0x01ea:
            if (r2 == 0) goto L_0x01f8
            r16 = r1
            r10 = r3
            r17 = r4
            r18 = r5
            r19 = r9
            r34 = 0
            goto L_0x0203
        L_0x01f8:
            r34 = r42
            r16 = r1
            r10 = r3
            r17 = r4
            r18 = r5
            r19 = r9
        L_0x0203:
            r9 = r7
        L_0x0204:
            r11.endDefaults()
            int r1 = r0 >> 6
            r1 = r1 & 14
            int r2 = r0 >> 15
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            androidx.compose.runtime.State r2 = r9.contentColor(r10, r11, r1)
            androidx.compose.runtime.State r1 = r9.backgroundColor(r10, r11, r1)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r4 = r1.m1942unboximpl()
            long r20 = m1202Chip$lambda1(r2)
            r22 = 1065353216(0x3f800000, float:1.0)
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 14
            r27 = 0
            long r7 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r20, r22, r23, r24, r25, r26, r27)
            r20 = 0
            r1 = 139076687(0x84a244f, float:6.0829844E-34)
            androidx.compose.material.ChipKt$Chip$2 r3 = new androidx.compose.material.ChipKt$Chip$2
            r36 = r3
            r37 = r2
            r38 = r34
            r39 = r9
            r40 = r10
            r41 = r0
            r42 = r43
            r36.<init>(r37, r38, r39, r40, r41, r42)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r1, r6, r3)
            r21 = r1
            kotlin.jvm.functions.Function2 r21 = (kotlin.jvm.functions.Function2) r21
            r1 = 805306368(0x30000000, float:4.656613E-10)
            r2 = r0 & 14
            r1 = r1 | r2
            r2 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r0 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r0 >> 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r0 << 3
            r3 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r3
            r1 = r1 | r2
            int r0 = r0 << 15
            r0 = r0 & r32
            r22 = r1 | r0
            r23 = 128(0x80, float:1.794E-43)
            r0 = r35
            r1 = r16
            r2 = r10
            r3 = r18
            r6 = r7
            r8 = r19
            r24 = r9
            r9 = r20
            r20 = r10
            r10 = r17
            r25 = r11
            r11 = r21
            r12 = r25
            r13 = r22
            r14 = r23
            androidx.compose.material.SurfaceKt.m1420SurfaceLPr_se0(r0, r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13, r14)
            r2 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r3 = r20
            r7 = r24
            r8 = r34
        L_0x02a1:
            androidx.compose.runtime.ScopeUpdateScope r12 = r25.endRestartGroup()
            if (r12 != 0) goto L_0x02a8
            goto L_0x02bb
        L_0x02a8:
            androidx.compose.material.ChipKt$Chip$3 r13 = new androidx.compose.material.ChipKt$Chip$3
            r0 = r13
            r1 = r35
            r9 = r43
            r10 = r45
            r11 = r46
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x02bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ChipKt.Chip(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.foundation.BorderStroke, androidx.compose.material.ChipColors, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0362  */
    /* JADX WARNING: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012e  */
    @androidx.compose.material.ExperimentalMaterialApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void FilterChip(boolean r43, kotlin.jvm.functions.Function0<kotlin.Unit> r44, androidx.compose.ui.Modifier r45, boolean r46, androidx.compose.foundation.interaction.MutableInteractionSource r47, androidx.compose.ui.graphics.Shape r48, androidx.compose.foundation.BorderStroke r49, androidx.compose.material.SelectableChipColors r50, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, androidx.compose.runtime.Composer r55, int r56, int r57, int r58) {
        /*
            r15 = r43
            r12 = r44
            r11 = r54
            r10 = r56
            r9 = r58
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -1259208246(0xffffffffb4f201ca, float:-4.5077314E-7)
            r1 = r55
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(FilterChip)P(8,7,6,3,4,10!2,5,9,11)188@8670L39,189@8744L6,191@8871L18,198@9202L31,204@9413L34,199@9238L4010:Chip.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            r0 = r9 & 1
            if (r0 == 0) goto L_0x0029
            r0 = r10 | 6
            goto L_0x0039
        L_0x0029:
            r0 = r10 & 14
            if (r0 != 0) goto L_0x0038
            boolean r0 = r8.changed((boolean) r15)
            if (r0 == 0) goto L_0x0035
            r0 = 4
            goto L_0x0036
        L_0x0035:
            r0 = 2
        L_0x0036:
            r0 = r0 | r10
            goto L_0x0039
        L_0x0038:
            r0 = r10
        L_0x0039:
            r3 = r9 & 2
            if (r3 == 0) goto L_0x0040
            r0 = r0 | 48
            goto L_0x0050
        L_0x0040:
            r3 = r10 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0050
            boolean r3 = r8.changed((java.lang.Object) r12)
            if (r3 == 0) goto L_0x004d
            r3 = 32
            goto L_0x004f
        L_0x004d:
            r3 = 16
        L_0x004f:
            r0 = r0 | r3
        L_0x0050:
            r3 = r9 & 4
            if (r3 == 0) goto L_0x0057
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006a
        L_0x0057:
            r6 = r10 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x006a
            r6 = r45
            boolean r7 = r8.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0066
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r0 = r0 | r7
            goto L_0x006c
        L_0x006a:
            r6 = r45
        L_0x006c:
            r7 = r9 & 8
            if (r7 == 0) goto L_0x0073
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0086
        L_0x0073:
            r13 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r13 != 0) goto L_0x0086
            r13 = r46
            boolean r14 = r8.changed((boolean) r13)
            if (r14 == 0) goto L_0x0082
            r14 = 2048(0x800, float:2.87E-42)
            goto L_0x0084
        L_0x0082:
            r14 = 1024(0x400, float:1.435E-42)
        L_0x0084:
            r0 = r0 | r14
            goto L_0x0088
        L_0x0086:
            r13 = r46
        L_0x0088:
            r14 = r9 & 16
            r38 = 57344(0xe000, float:8.0356E-41)
            if (r14 == 0) goto L_0x0094
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r1 = r47
            goto L_0x00a7
        L_0x0094:
            r16 = r10 & r38
            r1 = r47
            if (r16 != 0) goto L_0x00a7
            boolean r16 = r8.changed((java.lang.Object) r1)
            if (r16 == 0) goto L_0x00a3
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a5
        L_0x00a3:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00a5:
            r0 = r0 | r16
        L_0x00a7:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r10 & r16
            if (r16 != 0) goto L_0x00c1
            r16 = r9 & 32
            r2 = r48
            if (r16 != 0) goto L_0x00bc
            boolean r17 = r8.changed((java.lang.Object) r2)
            if (r17 == 0) goto L_0x00bc
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00be
        L_0x00bc:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00be:
            r0 = r0 | r17
            goto L_0x00c3
        L_0x00c1:
            r2 = r48
        L_0x00c3:
            r17 = r9 & 64
            if (r17 == 0) goto L_0x00ce
            r18 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r18
            r4 = r49
            goto L_0x00e3
        L_0x00ce:
            r18 = 3670016(0x380000, float:5.142788E-39)
            r18 = r10 & r18
            r4 = r49
            if (r18 != 0) goto L_0x00e3
            boolean r19 = r8.changed((java.lang.Object) r4)
            if (r19 == 0) goto L_0x00df
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e1
        L_0x00df:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00e1:
            r0 = r0 | r19
        L_0x00e3:
            r39 = 29360128(0x1c00000, float:7.052966E-38)
            r19 = r10 & r39
            if (r19 != 0) goto L_0x00ff
            r5 = r9 & 128(0x80, float:1.794E-43)
            if (r5 != 0) goto L_0x00f8
            r5 = r50
            boolean r20 = r8.changed((java.lang.Object) r5)
            if (r20 == 0) goto L_0x00fa
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fc
        L_0x00f8:
            r5 = r50
        L_0x00fa:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fc:
            r0 = r0 | r20
            goto L_0x0101
        L_0x00ff:
            r5 = r50
        L_0x0101:
            r1 = r9 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x010c
            r20 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r20
            r2 = r51
            goto L_0x0121
        L_0x010c:
            r20 = 234881024(0xe000000, float:1.5777218E-30)
            r20 = r10 & r20
            r2 = r51
            if (r20 != 0) goto L_0x0121
            boolean r20 = r8.changed((java.lang.Object) r2)
            if (r20 == 0) goto L_0x011d
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011f
        L_0x011d:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011f:
            r0 = r0 | r20
        L_0x0121:
            r2 = r9 & 512(0x200, float:7.175E-43)
            r40 = 1879048192(0x70000000, float:1.58456325E29)
            if (r2 == 0) goto L_0x012e
            r20 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r20
            r4 = r52
            goto L_0x0141
        L_0x012e:
            r20 = r10 & r40
            r4 = r52
            if (r20 != 0) goto L_0x0141
            boolean r20 = r8.changed((java.lang.Object) r4)
            if (r20 == 0) goto L_0x013d
            r20 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013f
        L_0x013d:
            r20 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013f:
            r0 = r0 | r20
        L_0x0141:
            r4 = r9 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x014a
            r16 = r57 | 6
            r5 = r53
            goto L_0x0160
        L_0x014a:
            r20 = r57 & 14
            r5 = r53
            if (r20 != 0) goto L_0x015e
            boolean r20 = r8.changed((java.lang.Object) r5)
            if (r20 == 0) goto L_0x0159
            r16 = 4
            goto L_0x015b
        L_0x0159:
            r16 = 2
        L_0x015b:
            r16 = r57 | r16
            goto L_0x0160
        L_0x015e:
            r16 = r57
        L_0x0160:
            r5 = r9 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x0169
            r5 = r16 | 48
        L_0x0166:
            r41 = r5
            goto L_0x017d
        L_0x0169:
            r5 = r57 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x017b
            boolean r5 = r8.changed((java.lang.Object) r11)
            if (r5 == 0) goto L_0x0176
            r18 = 32
            goto L_0x0178
        L_0x0176:
            r18 = 16
        L_0x0178:
            r5 = r16 | r18
            goto L_0x0166
        L_0x017b:
            r41 = r16
        L_0x017d:
            r5 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r5 = r5 & r0
            r6 = 306783378(0x12492492, float:6.3469493E-28)
            if (r5 != r6) goto L_0x01aa
            r5 = r41 & 91
            r6 = 18
            if (r5 != r6) goto L_0x01aa
            boolean r5 = r8.getSkipping()
            if (r5 != 0) goto L_0x0193
            goto L_0x01aa
        L_0x0193:
            r8.skipToGroupEnd()
            r3 = r45
            r5 = r47
            r6 = r48
            r7 = r49
            r9 = r51
            r10 = r52
            r11 = r53
            r0 = r8
            r4 = r13
            r8 = r50
            goto L_0x035b
        L_0x01aa:
            r8.startDefaults()
            r5 = r10 & 1
            r16 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r5 == 0) goto L_0x01e1
            boolean r5 = r8.getDefaultsInvalid()
            if (r5 == 0) goto L_0x01bb
            goto L_0x01e1
        L_0x01bb:
            r8.skipToGroupEnd()
            r1 = r9 & 32
            if (r1 == 0) goto L_0x01c4
            r0 = r0 & r16
        L_0x01c4:
            r1 = r9 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x01cc
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r0 = r0 & r1
        L_0x01cc:
            r7 = r45
            r28 = r47
            r29 = r48
            r30 = r49
            r5 = r50
            r31 = r51
            r32 = r52
            r33 = r53
            r20 = r0
            r6 = r13
            goto L_0x0295
        L_0x01e1:
            if (r3 == 0) goto L_0x01e8
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x01ea
        L_0x01e8:
            r3 = r45
        L_0x01ea:
            if (r7 == 0) goto L_0x01ed
            r13 = 1
        L_0x01ed:
            if (r14 == 0) goto L_0x0213
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r8.startReplaceableGroup(r5)
            java.lang.String r5 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r5)
            java.lang.Object r5 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r5 != r7) goto L_0x020d
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r8.updateRememberedValue(r5)
        L_0x020d:
            r8.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = (androidx.compose.foundation.interaction.MutableInteractionSource) r5
            goto L_0x0215
        L_0x0213:
            r5 = r47
        L_0x0215:
            r7 = r9 & 32
            if (r7 == 0) goto L_0x0233
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            r14 = 6
            androidx.compose.material.Shapes r7 = r7.getShapes(r8, r14)
            androidx.compose.foundation.shape.CornerBasedShape r7 = r7.getSmall()
            r14 = 50
            androidx.compose.foundation.shape.CornerSize r14 = androidx.compose.foundation.shape.CornerSizeKt.CornerSize((int) r14)
            androidx.compose.foundation.shape.CornerBasedShape r7 = r7.copy(r14)
            androidx.compose.ui.graphics.Shape r7 = (androidx.compose.ui.graphics.Shape) r7
            r0 = r0 & r16
            goto L_0x0235
        L_0x0233:
            r7 = r48
        L_0x0235:
            if (r17 == 0) goto L_0x0239
            r14 = 0
            goto L_0x023b
        L_0x0239:
            r14 = r49
        L_0x023b:
            r6 = r9 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x0263
            androidx.compose.material.ChipDefaults r16 = androidx.compose.material.ChipDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r36 = 805306368(0x30000000, float:4.656613E-10)
            r37 = 511(0x1ff, float:7.16E-43)
            r35 = r8
            androidx.compose.material.SelectableChipColors r6 = r16.m1195filterChipColorsJ08w3E(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r36, r37)
            r16 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r0 = r0 & r16
            goto L_0x0265
        L_0x0263:
            r6 = r50
        L_0x0265:
            if (r1 == 0) goto L_0x0269
            r1 = 0
            goto L_0x026b
        L_0x0269:
            r1 = r51
        L_0x026b:
            if (r2 == 0) goto L_0x026f
            r2 = 0
            goto L_0x0271
        L_0x026f:
            r2 = r52
        L_0x0271:
            if (r4 == 0) goto L_0x0284
            r20 = r0
            r31 = r1
            r32 = r2
            r28 = r5
            r5 = r6
            r29 = r7
            r6 = r13
            r30 = r14
            r33 = 0
            goto L_0x0294
        L_0x0284:
            r33 = r53
            r20 = r0
            r31 = r1
            r32 = r2
            r28 = r5
            r5 = r6
            r29 = r7
            r6 = r13
            r30 = r14
        L_0x0294:
            r7 = r3
        L_0x0295:
            r8.endDefaults()
            int r0 = r20 >> 9
            r0 = r0 & 14
            int r22 = r20 << 3
            r1 = r22 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r20 >> 15
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            androidx.compose.runtime.State r1 = r5.contentColor(r6, r15, r8, r0)
            r2 = 0
            androidx.compose.material.ChipKt$FilterChip$2 r3 = androidx.compose.material.ChipKt$FilterChip$2.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r4 = 0
            r14 = 1
            androidx.compose.ui.Modifier r13 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r7, r2, r3, r14, r4)
            androidx.compose.runtime.State r0 = r5.backgroundColor(r6, r15, r8, r0)
            java.lang.Object r0 = r0.getValue()
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r16 = r0.m1942unboximpl()
            java.lang.Object r0 = r1.getValue()
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r2 = r0.m1942unboximpl()
            r0 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            r18 = 0
            r19 = 0
            r21 = 14
            r23 = 0
            r45 = r2
            r47 = r0
            r48 = r4
            r49 = r18
            r50 = r19
            r51 = r21
            r52 = r23
            long r18 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r45, r47, r48, r49, r50, r51, r52)
            r0 = 0
            r23 = 1
            r14 = r0
            r21 = 0
            r4 = 722126431(0x2b0ac65f, float:4.9302744E-13)
            androidx.compose.material.ChipKt$FilterChip$3 r3 = new androidx.compose.material.ChipKt$FilterChip$3
            r0 = r3
            r2 = r31
            r14 = r3
            r3 = r43
            r11 = 722126431(0x2b0ac65f, float:4.9302744E-13)
            r4 = r32
            r34 = r5
            r5 = r33
            r35 = r6
            r11 = 1
            r6 = r54
            r36 = r7
            r7 = r41
            r11 = r8
            r8 = r34
            r9 = r35
            r10 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = 722126431(0x2b0ac65f, float:4.9302744E-13)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r0, r1, r14)
            r23 = r0
            kotlin.jvm.functions.Function2 r23 = (kotlin.jvm.functions.Function2) r23
            r0 = r20 & 14
            r1 = r20 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r20 >> 3
            r1 = r1 & r38
            r0 = r0 | r1
            r1 = r22 & r39
            r0 = r0 | r1
            int r1 = r20 << 15
            r1 = r1 & r40
            r25 = r0 | r1
            r26 = 6
            r27 = 264(0x108, float:3.7E-43)
            r0 = r11
            r11 = r43
            r12 = r44
            r15 = r29
            r20 = r30
            r22 = r28
            r24 = r0
            r14 = 0
            androidx.compose.material.SurfaceKt.m1421SurfaceNy5ogXk((boolean) r11, (kotlin.jvm.functions.Function0<kotlin.Unit>) r12, (androidx.compose.ui.Modifier) r13, (boolean) r14, (androidx.compose.ui.graphics.Shape) r15, (long) r16, (long) r18, (androidx.compose.foundation.BorderStroke) r20, (float) r21, (androidx.compose.foundation.interaction.MutableInteractionSource) r22, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r23, (androidx.compose.runtime.Composer) r24, (int) r25, (int) r26, (int) r27)
            r5 = r28
            r6 = r29
            r7 = r30
            r9 = r31
            r10 = r32
            r11 = r33
            r4 = r35
            r3 = r36
        L_0x035b:
            androidx.compose.runtime.ScopeUpdateScope r15 = r0.endRestartGroup()
            if (r15 != 0) goto L_0x0362
            goto L_0x0380
        L_0x0362:
            androidx.compose.material.ChipKt$FilterChip$4 r16 = new androidx.compose.material.ChipKt$FilterChip$4
            r0 = r16
            r1 = r43
            r2 = r44
            r12 = r54
            r13 = r56
            r14 = r57
            r42 = r15
            r15 = r58
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r42
            r1.updateScope(r0)
        L_0x0380:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ChipKt.FilterChip(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.foundation.BorderStroke, androidx.compose.material.SelectableChipColors, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: Chip$lambda-1  reason: not valid java name */
    public static final long m1202Chip$lambda1(State<Color> state) {
        return state.getValue().m1942unboximpl();
    }

    static {
        float f = (float) 8;
        LeadingIconEndSpacing = Dp.m4704constructorimpl(f);
        TrailingIconSpacing = Dp.m4704constructorimpl(f);
    }
}
