package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0001\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0001\u0010\u001b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001c"}, d2 = {"Button", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "elevation", "Landroidx/compose/material/ButtonElevation;", "shape", "Landroidx/compose/ui/graphics/Shape;", "border", "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ButtonColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/ButtonElevation;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ButtonColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedButton", "TextButton", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Button.kt */
public final class ButtonKt {
    /* JADX WARNING: Removed duplicated region for block: B:100:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0311  */
    /* JADX WARNING: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0128  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Button(kotlin.jvm.functions.Function0<kotlin.Unit> r37, androidx.compose.ui.Modifier r38, boolean r39, androidx.compose.foundation.interaction.MutableInteractionSource r40, androidx.compose.material.ButtonElevation r41, androidx.compose.ui.graphics.Shape r42, androidx.compose.foundation.BorderStroke r43, androidx.compose.material.ButtonColors r44, androidx.compose.foundation.layout.PaddingValues r45, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, androidx.compose.runtime.Composer r47, int r48, int r49) {
        /*
            r15 = r37
            r14 = r46
            r13 = r48
            r12 = r49
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -2116133464(0xffffffff81de5da8, float:-8.168431E-38)
            r1 = r47
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(Button)P(8,7,5,6,4,9!2,3)94@4533L39,95@4623L11,96@4669L6,98@4759L14,102@4922L21,108@5086L24,111@5228L37,103@4948L1086:Button.kt#jmzs0o"
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
            r2 = r38
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
            r2 = r38
        L_0x0053:
            r3 = r12 & 4
            if (r3 == 0) goto L_0x005a
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006d
        L_0x005a:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x006d
            r4 = r39
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
            r4 = r39
        L_0x006f:
            r5 = r12 & 8
            if (r5 == 0) goto L_0x0076
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0089
        L_0x0076:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0089
            r6 = r40
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
            r6 = r40
        L_0x008b:
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r13
            if (r7 != 0) goto L_0x00a6
            r7 = r12 & 16
            if (r7 != 0) goto L_0x00a0
            r7 = r41
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x00a2
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a4
        L_0x00a0:
            r7 = r41
        L_0x00a2:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x00a4:
            r0 = r0 | r8
            goto L_0x00a8
        L_0x00a6:
            r7 = r41
        L_0x00a8:
            r8 = 458752(0x70000, float:6.42848E-40)
            r8 = r8 & r13
            if (r8 != 0) goto L_0x00c0
            r8 = r12 & 32
            r10 = r42
            if (r8 != 0) goto L_0x00bc
            boolean r8 = r11.changed((java.lang.Object) r10)
            if (r8 == 0) goto L_0x00bc
            r8 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00be
        L_0x00bc:
            r8 = 65536(0x10000, float:9.18355E-41)
        L_0x00be:
            r0 = r0 | r8
            goto L_0x00c2
        L_0x00c0:
            r10 = r42
        L_0x00c2:
            r16 = r12 & 64
            r28 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00ce
            r8 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r8
            r9 = r43
            goto L_0x00e0
        L_0x00ce:
            r8 = r13 & r28
            r9 = r43
            if (r8 != 0) goto L_0x00e0
            boolean r8 = r11.changed((java.lang.Object) r9)
            if (r8 == 0) goto L_0x00dd
            r8 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00df
        L_0x00dd:
            r8 = 524288(0x80000, float:7.34684E-40)
        L_0x00df:
            r0 = r0 | r8
        L_0x00e0:
            r8 = 29360128(0x1c00000, float:7.052966E-38)
            r8 = r8 & r13
            if (r8 != 0) goto L_0x00fb
            r8 = r12 & 128(0x80, float:1.794E-43)
            if (r8 != 0) goto L_0x00f4
            r8 = r44
            boolean r17 = r11.changed((java.lang.Object) r8)
            if (r17 == 0) goto L_0x00f6
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f8
        L_0x00f4:
            r8 = r44
        L_0x00f6:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f8:
            r0 = r0 | r17
            goto L_0x00fd
        L_0x00fb:
            r8 = r44
        L_0x00fd:
            r9 = r12 & 256(0x100, float:3.59E-43)
            r29 = 234881024(0xe000000, float:1.5777218E-30)
            if (r9 == 0) goto L_0x0108
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r17
            goto L_0x011e
        L_0x0108:
            r17 = r13 & r29
            if (r17 != 0) goto L_0x011e
            r17 = r9
            r9 = r45
            boolean r18 = r11.changed((java.lang.Object) r9)
            if (r18 == 0) goto L_0x0119
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011b
        L_0x0119:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011b:
            r0 = r0 | r18
            goto L_0x0122
        L_0x011e:
            r17 = r9
            r9 = r45
        L_0x0122:
            r2 = r12 & 512(0x200, float:7.175E-43)
            r30 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x012b
            r0 = r0 | r30
            goto L_0x013c
        L_0x012b:
            r2 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r13
            if (r2 != 0) goto L_0x013c
            boolean r2 = r11.changed((java.lang.Object) r14)
            if (r2 == 0) goto L_0x0139
            r2 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013b
        L_0x0139:
            r2 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013b:
            r0 = r0 | r2
        L_0x013c:
            r2 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r2 = r2 & r0
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r4) goto L_0x015c
            boolean r2 = r11.getSkipping()
            if (r2 != 0) goto L_0x014c
            goto L_0x015c
        L_0x014c:
            r11.skipToGroupEnd()
            r2 = r38
            r3 = r39
            r4 = r6
            r5 = r7
            r6 = r10
            r21 = r11
            r7 = r43
            goto L_0x030a
        L_0x015c:
            r11.startDefaults()
            r2 = r13 & 1
            r31 = 0
            r32 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            r19 = -57345(0xffffffffffff1fff, float:NaN)
            r4 = 1
            if (r2 == 0) goto L_0x0199
            boolean r2 = r11.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0176
            goto L_0x0199
        L_0x0176:
            r11.skipToGroupEnd()
            r1 = r12 & 16
            if (r1 == 0) goto L_0x017f
            r0 = r0 & r19
        L_0x017f:
            r1 = r12 & 32
            if (r1 == 0) goto L_0x0185
            r0 = r0 & r18
        L_0x0185:
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x018b
            r0 = r0 & r32
        L_0x018b:
            r33 = r38
            r17 = r43
            r35 = r6
            r6 = r9
            r16 = r10
            r10 = r39
            r9 = r7
            goto L_0x0247
        L_0x0199:
            if (r1 == 0) goto L_0x01a2
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r33 = r1
            goto L_0x01a4
        L_0x01a2:
            r33 = r38
        L_0x01a4:
            if (r3 == 0) goto L_0x01a9
            r34 = 1
            goto L_0x01ab
        L_0x01a9:
            r34 = r39
        L_0x01ab:
            if (r5 == 0) goto L_0x01d3
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            java.lang.Object r1 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x01cb
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r1)
        L_0x01cb:
            r11.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            r35 = r1
            goto L_0x01d5
        L_0x01d3:
            r35 = r6
        L_0x01d5:
            r1 = r12 & 16
            if (r1 == 0) goto L_0x01f6
            androidx.compose.material.ButtonDefaults r1 = androidx.compose.material.ButtonDefaults.INSTANCE
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r20 = 196608(0x30000, float:2.75506E-40)
            r21 = 31
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r11
            r8 = r20
            r36 = r17
            r9 = r21
            androidx.compose.material.ButtonElevation r1 = r1.m1165elevationR_JCAzs(r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = r0 & r19
            r7 = r1
            goto L_0x01f8
        L_0x01f6:
            r36 = r17
        L_0x01f8:
            r1 = r12 & 32
            if (r1 == 0) goto L_0x020c
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            r2 = 6
            androidx.compose.material.Shapes r1 = r1.getShapes(r11, r2)
            androidx.compose.foundation.shape.CornerBasedShape r1 = r1.getSmall()
            androidx.compose.ui.graphics.Shape r1 = (androidx.compose.ui.graphics.Shape) r1
            r0 = r0 & r18
            r10 = r1
        L_0x020c:
            if (r16 == 0) goto L_0x0211
            r1 = r31
            goto L_0x0213
        L_0x0211:
            r1 = r43
        L_0x0213:
            r2 = r12 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x022e
            androidx.compose.material.ButtonDefaults r16 = androidx.compose.material.ButtonDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r26 = 24576(0x6000, float:3.4438E-41)
            r27 = 15
            r25 = r11
            androidx.compose.material.ButtonColors r2 = r16.m1164buttonColorsro_MJ88(r17, r19, r21, r23, r25, r26, r27)
            r0 = r0 & r32
            goto L_0x0230
        L_0x022e:
            r2 = r44
        L_0x0230:
            if (r36 == 0) goto L_0x023d
            androidx.compose.material.ButtonDefaults r3 = androidx.compose.material.ButtonDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r3 = r3.getContentPadding()
            r17 = r1
            r8 = r2
            r6 = r3
            goto L_0x0242
        L_0x023d:
            r6 = r45
            r17 = r1
            r8 = r2
        L_0x0242:
            r9 = r7
            r16 = r10
            r10 = r34
        L_0x0247:
            r11.endDefaults()
            int r1 = r0 >> 6
            r2 = r1 & 14
            int r3 = r0 >> 18
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | r2
            androidx.compose.runtime.State r4 = r8.contentColor(r10, r11, r3)
            androidx.compose.runtime.State r3 = r8.backgroundColor(r10, r11, r3)
            java.lang.Object r3 = r3.getValue()
            androidx.compose.ui.graphics.Color r3 = (androidx.compose.ui.graphics.Color) r3
            long r18 = r3.m1942unboximpl()
            long r20 = m1174Button$lambda1(r4)
            r3 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            r7 = 0
            r22 = 0
            r23 = 14
            r24 = 0
            r38 = r20
            r40 = r3
            r41 = r5
            r42 = r7
            r43 = r22
            r44 = r23
            r45 = r24
            long r20 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r38, r40, r41, r42, r43, r44, r45)
            if (r9 != 0) goto L_0x0288
            goto L_0x0296
        L_0x0288:
            r3 = r35
            androidx.compose.foundation.interaction.InteractionSource r3 = (androidx.compose.foundation.interaction.InteractionSource) r3
            r5 = r1 & 112(0x70, float:1.57E-43)
            r2 = r2 | r5
            r5 = r1 & 896(0x380, float:1.256E-42)
            r2 = r2 | r5
            androidx.compose.runtime.State r31 = r9.elevation(r10, r3, r11, r2)
        L_0x0296:
            if (r31 == 0) goto L_0x02a3
            java.lang.Object r2 = r31.getValue()
            androidx.compose.ui.unit.Dp r2 = (androidx.compose.ui.unit.Dp) r2
            float r2 = r2.m4718unboximpl()
            goto L_0x02a9
        L_0x02a3:
            r2 = 0
            float r2 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r2)
        L_0x02a9:
            r22 = r2
            r2 = 7524271(0x72cfaf, float:1.054375E-38)
            androidx.compose.material.ButtonKt$Button$2 r3 = new androidx.compose.material.ButtonKt$Button$2
            r3.<init>(r4, r6, r14, r0)
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r2, r4, r3)
            r23 = r2
            kotlin.jvm.functions.Function2 r23 = (kotlin.jvm.functions.Function2) r23
            r2 = r0 & 14
            r2 = r2 | r30
            r3 = r0 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            r3 = r0 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = r0 & r28
            r1 = r1 | r2
            int r0 = r0 << 15
            r0 = r0 & r29
            r24 = r1 | r0
            r25 = 0
            r0 = r37
            r1 = r33
            r2 = r10
            r3 = r16
            r4 = r18
            r18 = r6
            r6 = r20
            r19 = r8
            r8 = r17
            r20 = r9
            r9 = r22
            r34 = r10
            r10 = r35
            r21 = r11
            r11 = r23
            r12 = r21
            r13 = r24
            r14 = r25
            androidx.compose.material.SurfaceKt.m1420SurfaceLPr_se0(r0, r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13, r14)
            r6 = r16
            r7 = r17
            r9 = r18
            r8 = r19
            r5 = r20
            r2 = r33
            r3 = r34
            r4 = r35
        L_0x030a:
            androidx.compose.runtime.ScopeUpdateScope r13 = r21.endRestartGroup()
            if (r13 != 0) goto L_0x0311
            goto L_0x0324
        L_0x0311:
            androidx.compose.material.ButtonKt$Button$3 r14 = new androidx.compose.material.ButtonKt$Button$3
            r0 = r14
            r1 = r37
            r10 = r46
            r11 = r48
            r12 = r49
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x0324:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ButtonKt.Button(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.ButtonElevation, androidx.compose.ui.graphics.Shape, androidx.compose.foundation.BorderStroke, androidx.compose.material.ButtonColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void OutlinedButton(Function0<Unit> function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2 = composer;
        int i3 = i;
        int i4 = i2;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function3, "content");
        composer2.startReplaceableGroup(-1776134358);
        ComposerKt.sourceInformation(composer2, "C(OutlinedButton)P(8,7,5,6,4,9!2,3)168@7956L39,170@8070L6,171@8127L14,172@8185L22,175@8325L270:Button.kt#jmzs0o");
        Modifier modifier2 = (i4 & 2) != 0 ? Modifier.Companion : modifier;
        boolean z2 = (i4 & 4) != 0 ? true : z;
        if ((i4 & 8) != 0) {
            composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        Button(function0, modifier2, z2, mutableInteractionSource2, (i4 & 16) != 0 ? null : buttonElevation, (i4 & 32) != 0 ? MaterialTheme.INSTANCE.getShapes(composer2, 6).getSmall() : shape, (i4 & 64) != 0 ? ButtonDefaults.INSTANCE.getOutlinedBorder(composer2, 6) : borderStroke, (i4 & 128) != 0 ? ButtonDefaults.INSTANCE.m1172outlinedButtonColorsRGew2ao(0, 0, 0, composer, 3072, 7) : buttonColors, (i4 & 256) != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues, function3, composer, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (29360128 & i3) | (234881024 & i3) | (1879048192 & i3), 0);
        composer.endReplaceableGroup();
    }

    public static final void TextButton(Function0<Unit> function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2 = composer;
        int i3 = i;
        int i4 = i2;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function3, "content");
        composer2.startReplaceableGroup(288797557);
        ComposerKt.sourceInformation(composer2, "C(TextButton)P(8,7,5,6,4,9!2,3)222@10527L39,224@10641L6,226@10731L18,229@10877L270:Button.kt#jmzs0o");
        Modifier modifier2 = (i4 & 2) != 0 ? Modifier.Companion : modifier;
        boolean z2 = (i4 & 4) != 0 ? true : z;
        if ((i4 & 8) != 0) {
            composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        Button(function0, modifier2, z2, mutableInteractionSource2, (i4 & 16) != 0 ? null : buttonElevation, (i4 & 32) != 0 ? MaterialTheme.INSTANCE.getShapes(composer2, 6).getSmall() : shape, (i4 & 64) != 0 ? null : borderStroke, (i4 & 128) != 0 ? ButtonDefaults.INSTANCE.m1173textButtonColorsRGew2ao(0, 0, 0, composer, 3072, 7) : buttonColors, (i4 & 256) != 0 ? ButtonDefaults.INSTANCE.getTextButtonContentPadding() : paddingValues, function3, composer, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (29360128 & i3) | (234881024 & i3) | (1879048192 & i3), 0);
        composer.endReplaceableGroup();
    }

    /* access modifiers changed from: private */
    /* renamed from: Button$lambda-1  reason: not valid java name */
    public static final long m1174Button$lambda1(State<Color> state) {
        return state.getValue().m1942unboximpl();
    }
}
