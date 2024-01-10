package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010\"\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020#2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010$¨\u0006%"}, d2 = {"BasicTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: BasicTextField.kt */
public final class BasicTextFieldKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v0, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v1, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v2, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v3, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v4, resolved type: kotlin.jvm.functions.Function3<kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v5, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v6, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01b9, code lost:
        if (r3.changed((java.lang.Object) r51) != false) goto L_0x01c0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0495  */
    /* JADX WARNING: Removed duplicated region for block: B:247:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x013e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BasicTextField(java.lang.String r38, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r39, androidx.compose.ui.Modifier r40, boolean r41, boolean r42, androidx.compose.ui.text.TextStyle r43, androidx.compose.foundation.text.KeyboardOptions r44, androidx.compose.foundation.text.KeyboardActions r45, boolean r46, int r47, androidx.compose.ui.text.input.VisualTransformation r48, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r49, androidx.compose.foundation.interaction.MutableInteractionSource r50, androidx.compose.ui.graphics.Brush r51, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, androidx.compose.runtime.Composer r53, int r54, int r55, int r56) {
        /*
            r1 = r38
            r2 = r39
            r15 = r54
            r14 = r55
            r13 = r56
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r0 = -454732590(0xffffffffe4e554d2, float:-3.384333E22)
            r3 = r53
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r0)
            java.lang.String r4 = "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)134@7772L39,141@8166L57,147@8519L216,147@8508L227,156@9056L41,160@9174L373,158@9103L980:BasicTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r13 & 1
            if (r4 == 0) goto L_0x002b
            r4 = r15 | 6
            goto L_0x003b
        L_0x002b:
            r4 = r15 & 14
            if (r4 != 0) goto L_0x003a
            boolean r4 = r3.changed((java.lang.Object) r1)
            if (r4 == 0) goto L_0x0037
            r4 = 4
            goto L_0x0038
        L_0x0037:
            r4 = 2
        L_0x0038:
            r4 = r4 | r15
            goto L_0x003b
        L_0x003a:
            r4 = r15
        L_0x003b:
            r7 = r13 & 2
            if (r7 == 0) goto L_0x0042
            r4 = r4 | 48
            goto L_0x0052
        L_0x0042:
            r7 = r15 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x0052
            boolean r7 = r3.changed((java.lang.Object) r2)
            if (r7 == 0) goto L_0x004f
            r7 = 32
            goto L_0x0051
        L_0x004f:
            r7 = 16
        L_0x0051:
            r4 = r4 | r7
        L_0x0052:
            r7 = r13 & 4
            if (r7 == 0) goto L_0x0059
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x006d
        L_0x0059:
            r12 = r15 & 896(0x380, float:1.256E-42)
            if (r12 != 0) goto L_0x006d
            r12 = r40
            boolean r16 = r3.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x0068
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0068:
            r16 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r4 = r4 | r16
            goto L_0x006f
        L_0x006d:
            r12 = r40
        L_0x006f:
            r16 = r13 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x007a
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x008e
        L_0x007a:
            r5 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x008e
            r5 = r41
            boolean r19 = r3.changed((boolean) r5)
            if (r19 == 0) goto L_0x0089
            r19 = 2048(0x800, float:2.87E-42)
            goto L_0x008b
        L_0x0089:
            r19 = 1024(0x400, float:1.435E-42)
        L_0x008b:
            r4 = r4 | r19
            goto L_0x0090
        L_0x008e:
            r5 = r41
        L_0x0090:
            r19 = r13 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 57344(0xe000, float:8.0356E-41)
            r22 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x00a0
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            r8 = r42
            goto L_0x00b3
        L_0x00a0:
            r23 = r15 & r21
            r8 = r42
            if (r23 != 0) goto L_0x00b3
            boolean r24 = r3.changed((boolean) r8)
            if (r24 == 0) goto L_0x00af
            r24 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00b1
        L_0x00af:
            r24 = 8192(0x2000, float:1.14794E-41)
        L_0x00b1:
            r4 = r4 | r24
        L_0x00b3:
            r24 = r13 & 32
            if (r24 == 0) goto L_0x00be
            r25 = 196608(0x30000, float:2.75506E-40)
            r4 = r4 | r25
            r9 = r43
            goto L_0x00d3
        L_0x00be:
            r25 = 458752(0x70000, float:6.42848E-40)
            r25 = r15 & r25
            r9 = r43
            if (r25 != 0) goto L_0x00d3
            boolean r26 = r3.changed((java.lang.Object) r9)
            if (r26 == 0) goto L_0x00cf
            r26 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d1
        L_0x00cf:
            r26 = 65536(0x10000, float:9.18355E-41)
        L_0x00d1:
            r4 = r4 | r26
        L_0x00d3:
            r26 = r13 & 64
            if (r26 == 0) goto L_0x00de
            r27 = 1572864(0x180000, float:2.204052E-39)
            r4 = r4 | r27
            r10 = r44
            goto L_0x00f3
        L_0x00de:
            r27 = 3670016(0x380000, float:5.142788E-39)
            r27 = r15 & r27
            r10 = r44
            if (r27 != 0) goto L_0x00f3
            boolean r28 = r3.changed((java.lang.Object) r10)
            if (r28 == 0) goto L_0x00ef
            r28 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00f1
        L_0x00ef:
            r28 = 524288(0x80000, float:7.34684E-40)
        L_0x00f1:
            r4 = r4 | r28
        L_0x00f3:
            r11 = r13 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x00fe
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            r4 = r4 | r29
            r6 = r45
            goto L_0x0113
        L_0x00fe:
            r29 = 29360128(0x1c00000, float:7.052966E-38)
            r29 = r15 & r29
            r6 = r45
            if (r29 != 0) goto L_0x0113
            boolean r30 = r3.changed((java.lang.Object) r6)
            if (r30 == 0) goto L_0x010f
            r30 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0111
        L_0x010f:
            r30 = 4194304(0x400000, float:5.877472E-39)
        L_0x0111:
            r4 = r4 | r30
        L_0x0113:
            r0 = r13 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x011e
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            r4 = r4 | r31
            r5 = r46
            goto L_0x0133
        L_0x011e:
            r31 = 234881024(0xe000000, float:1.5777218E-30)
            r31 = r15 & r31
            r5 = r46
            if (r31 != 0) goto L_0x0133
            boolean r31 = r3.changed((boolean) r5)
            if (r31 == 0) goto L_0x012f
            r31 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0131
        L_0x012f:
            r31 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0131:
            r4 = r4 | r31
        L_0x0133:
            r5 = r13 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x013e
            r31 = 805306368(0x30000000, float:4.656613E-10)
            r4 = r4 | r31
            r6 = r47
            goto L_0x0153
        L_0x013e:
            r31 = 1879048192(0x70000000, float:1.58456325E29)
            r31 = r15 & r31
            r6 = r47
            if (r31 != 0) goto L_0x0153
            boolean r31 = r3.changed((int) r6)
            if (r31 == 0) goto L_0x014f
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0151
        L_0x014f:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0151:
            r4 = r4 | r31
        L_0x0153:
            r6 = r13 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x015c
            r31 = r14 | 6
            r8 = r48
            goto L_0x0172
        L_0x015c:
            r31 = r14 & 14
            r8 = r48
            if (r31 != 0) goto L_0x0170
            boolean r31 = r3.changed((java.lang.Object) r8)
            if (r31 == 0) goto L_0x016b
            r31 = 4
            goto L_0x016d
        L_0x016b:
            r31 = 2
        L_0x016d:
            r31 = r14 | r31
            goto L_0x0172
        L_0x0170:
            r31 = r14
        L_0x0172:
            r8 = r13 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x0179
            r31 = r31 | 48
            goto L_0x018c
        L_0x0179:
            r32 = r14 & 112(0x70, float:1.57E-43)
            r9 = r49
            if (r32 != 0) goto L_0x018c
            boolean r32 = r3.changed((java.lang.Object) r9)
            if (r32 == 0) goto L_0x0188
            r23 = 32
            goto L_0x018a
        L_0x0188:
            r23 = 16
        L_0x018a:
            r31 = r31 | r23
        L_0x018c:
            r9 = r31
            r10 = r13 & 4096(0x1000, float:5.74E-42)
            if (r10 == 0) goto L_0x0195
            r9 = r9 | 384(0x180, float:5.38E-43)
            goto L_0x01a9
        L_0x0195:
            r12 = r14 & 896(0x380, float:1.256E-42)
            if (r12 != 0) goto L_0x01a9
            r12 = r50
            boolean r23 = r3.changed((java.lang.Object) r12)
            if (r23 == 0) goto L_0x01a4
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x01a6
        L_0x01a4:
            r27 = 128(0x80, float:1.794E-43)
        L_0x01a6:
            r9 = r9 | r27
            goto L_0x01ab
        L_0x01a9:
            r12 = r50
        L_0x01ab:
            r12 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x01c3
            r12 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r12 != 0) goto L_0x01bc
            r12 = r51
            boolean r23 = r3.changed((java.lang.Object) r12)
            if (r23 == 0) goto L_0x01be
            goto L_0x01c0
        L_0x01bc:
            r12 = r51
        L_0x01be:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x01c0:
            r9 = r9 | r17
            goto L_0x01c5
        L_0x01c3:
            r12 = r51
        L_0x01c5:
            r12 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r12 == 0) goto L_0x01ce
            r9 = r9 | 24576(0x6000, float:3.4438E-41)
            r14 = r52
            goto L_0x01df
        L_0x01ce:
            r17 = r14 & r21
            r14 = r52
            if (r17 != 0) goto L_0x01df
            boolean r17 = r3.changed((java.lang.Object) r14)
            if (r17 == 0) goto L_0x01db
            goto L_0x01dd
        L_0x01db:
            r20 = 8192(0x2000, float:1.14794E-41)
        L_0x01dd:
            r9 = r9 | r20
        L_0x01df:
            r17 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r14 = r4 & r17
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r14 != r2) goto L_0x0219
            r2 = 46811(0xb6db, float:6.5596E-41)
            r2 = r2 & r9
            r14 = 9362(0x2492, float:1.3119E-41)
            if (r2 != r14) goto L_0x0219
            boolean r2 = r3.getSkipping()
            if (r2 != 0) goto L_0x01f8
            goto L_0x0219
        L_0x01f8:
            r3.skipToGroupEnd()
            r6 = r39
            r4 = r40
            r5 = r41
            r7 = r42
            r8 = r43
            r9 = r44
            r11 = r45
            r10 = r46
            r12 = r47
            r13 = r48
            r14 = r49
            r15 = r50
            r35 = r51
            r36 = r52
            goto L_0x048e
        L_0x0219:
            r3.startDefaults()
            r2 = r15 & 1
            r17 = 1
            if (r2 == 0) goto L_0x024c
            boolean r2 = r3.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0229
            goto L_0x024c
        L_0x0229:
            r3.skipToGroupEnd()
            r0 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0232
            r9 = r9 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0232:
            r2 = r40
            r7 = r41
            r0 = r42
            r5 = r43
            r6 = r44
            r11 = r45
            r8 = r46
            r10 = r48
            r12 = r49
            r14 = r50
            r35 = r51
            r36 = r52
            goto L_0x0313
        L_0x024c:
            if (r7 == 0) goto L_0x0253
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0255
        L_0x0253:
            r2 = r40
        L_0x0255:
            if (r16 == 0) goto L_0x0259
            r7 = 1
            goto L_0x025b
        L_0x0259:
            r7 = r41
        L_0x025b:
            if (r19 == 0) goto L_0x0260
            r16 = 0
            goto L_0x0262
        L_0x0260:
            r16 = r42
        L_0x0262:
            if (r24 == 0) goto L_0x026b
            androidx.compose.ui.text.TextStyle$Companion r18 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r18 = r18.getDefault()
            goto L_0x026d
        L_0x026b:
            r18 = r43
        L_0x026d:
            if (r26 == 0) goto L_0x0276
            androidx.compose.foundation.text.KeyboardOptions$Companion r19 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r19 = r19.getDefault()
            goto L_0x0278
        L_0x0276:
            r19 = r44
        L_0x0278:
            if (r11 == 0) goto L_0x0281
            androidx.compose.foundation.text.KeyboardActions$Companion r11 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r11 = r11.getDefault()
            goto L_0x0283
        L_0x0281:
            r11 = r45
        L_0x0283:
            if (r0 == 0) goto L_0x0287
            r0 = 0
            goto L_0x0289
        L_0x0287:
            r0 = r46
        L_0x0289:
            if (r5 == 0) goto L_0x028f
            r5 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0291
        L_0x028f:
            r5 = r47
        L_0x0291:
            if (r6 == 0) goto L_0x029a
            androidx.compose.ui.text.input.VisualTransformation$Companion r6 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r6 = r6.getNone()
            goto L_0x029c
        L_0x029a:
            r6 = r48
        L_0x029c:
            if (r8 == 0) goto L_0x02a3
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$1 r8 = androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$1.INSTANCE
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            goto L_0x02a5
        L_0x02a3:
            r8 = r49
        L_0x02a5:
            if (r10 == 0) goto L_0x02cb
            r10 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r3.startReplaceableGroup(r10)
            java.lang.String r10 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r10)
            java.lang.Object r10 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r20.getEmpty()
            if (r10 != r14) goto L_0x02c5
            androidx.compose.foundation.interaction.MutableInteractionSource r10 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r3.updateRememberedValue(r10)
        L_0x02c5:
            r3.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r10 = (androidx.compose.foundation.interaction.MutableInteractionSource) r10
            goto L_0x02cd
        L_0x02cb:
            r10 = r50
        L_0x02cd:
            r14 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x02ea
            androidx.compose.ui.graphics.SolidColor r14 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r20 = androidx.compose.ui.graphics.Color.Companion
            r40 = r5
            r41 = r6
            long r5 = r20.m1958getBlack0d7_KjU()
            r42 = r0
            r0 = 0
            r14.<init>(r5, r0)
            r0 = r14
            androidx.compose.ui.graphics.Brush r0 = (androidx.compose.ui.graphics.Brush) r0
            r5 = r9 & -7169(0xffffffffffffe3ff, float:NaN)
            r9 = r5
            goto L_0x02f2
        L_0x02ea:
            r42 = r0
            r40 = r5
            r41 = r6
            r0 = r51
        L_0x02f2:
            if (r12 == 0) goto L_0x0301
            androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt r5 = androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r5 = r5.m871getLambda1$foundation_release()
            r47 = r40
            r35 = r0
            r36 = r5
            goto L_0x0307
        L_0x0301:
            r47 = r40
            r36 = r52
            r35 = r0
        L_0x0307:
            r12 = r8
            r14 = r10
            r0 = r16
            r5 = r18
            r6 = r19
            r10 = r41
            r8 = r42
        L_0x0313:
            r3.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x0324
            java.lang.String r13 = "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:121)"
            r15 = -454732590(0xffffffffe4e554d2, float:-3.384333E22)
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r4, r9, r13)
        L_0x0324:
            r13 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r3.startReplaceableGroup(r13)
            java.lang.String r13 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r13)
            java.lang.Object r13 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r13 != r15) goto L_0x0360
            androidx.compose.ui.text.input.TextFieldValue r13 = new androidx.compose.ui.text.input.TextFieldValue
            r15 = 0
            r18 = 0
            r19 = 6
            r20 = 0
            r40 = r13
            r41 = r38
            r42 = r15
            r44 = r18
            r45 = r19
            r46 = r20
            r40.<init>((java.lang.String) r41, (long) r42, (androidx.compose.ui.text.TextRange) r44, (int) r45, (kotlin.jvm.internal.DefaultConstructorMarker) r46)
            r48 = r0
            r0 = 2
            r15 = 0
            androidx.compose.runtime.MutableState r13 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r13, r15, r0, r15)
            r3.updateRememberedValue(r13)
            goto L_0x0362
        L_0x0360:
            r48 = r0
        L_0x0362:
            r3.endReplaceableGroup()
            androidx.compose.runtime.MutableState r13 = (androidx.compose.runtime.MutableState) r13
            androidx.compose.ui.text.input.TextFieldValue r0 = m859BasicTextField$lambda2(r13)
            r15 = 0
            r18 = 0
            r19 = 6
            r20 = 0
            r40 = r0
            r41 = r38
            r42 = r15
            r44 = r18
            r45 = r19
            r46 = r20
            androidx.compose.ui.text.input.TextFieldValue r0 = androidx.compose.ui.text.input.TextFieldValue.m4418copy3r_uNRQ$default((androidx.compose.ui.text.input.TextFieldValue) r40, (java.lang.String) r41, (long) r42, (androidx.compose.ui.text.TextRange) r44, (int) r45, (java.lang.Object) r46)
            r15 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r3.startReplaceableGroup(r15)
            java.lang.String r15 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r15)
            boolean r15 = r3.changed((java.lang.Object) r0)
            boolean r16 = r3.changed((java.lang.Object) r13)
            r15 = r15 | r16
            r40 = r7
            java.lang.Object r7 = r3.rememberedValue()
            if (r15 != 0) goto L_0x03a8
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r7 != r15) goto L_0x03b2
        L_0x03a8:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1 r7 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
            r7.<init>(r0, r13)
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            r3.updateRememberedValue(r7)
        L_0x03b2:
            r3.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            r15 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r7, r3, r15)
            r7 = 1157296644(0x44faf204, float:2007.563)
            r3.startReplaceableGroup(r7)
            java.lang.String r7 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r7)
            boolean r7 = r3.changed((java.lang.Object) r1)
            java.lang.Object r15 = r3.rememberedValue()
            if (r7 != 0) goto L_0x03d8
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r15 != r7) goto L_0x03e1
        L_0x03d8:
            r7 = 0
            r15 = 2
            androidx.compose.runtime.MutableState r15 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r7, r15, r7)
            r3.updateRememberedValue(r15)
        L_0x03e1:
            r3.endReplaceableGroup()
            androidx.compose.runtime.MutableState r15 = (androidx.compose.runtime.MutableState) r15
            androidx.compose.ui.text.input.ImeOptions r26 = r6.toImeOptions$foundation_release(r8)
            r24 = r8 ^ 1
            if (r8 == 0) goto L_0x03f1
            r25 = 1
            goto L_0x03f3
        L_0x03f1:
            r25 = r47
        L_0x03f3:
            r7 = 1618982084(0x607fb4c4, float:7.370227E19)
            r3.startReplaceableGroup(r7)
            java.lang.String r7 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r7)
            boolean r7 = r3.changed((java.lang.Object) r13)
            boolean r16 = r3.changed((java.lang.Object) r15)
            r7 = r7 | r16
            r41 = r6
            r6 = r39
            boolean r16 = r3.changed((java.lang.Object) r6)
            r7 = r7 | r16
            java.lang.Object r1 = r3.rememberedValue()
            if (r7 != 0) goto L_0x0420
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r1 != r7) goto L_0x042a
        L_0x0420:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1 r1 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1
            r1.<init>(r6, r13, r15)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r3.updateRememberedValue(r1)
        L_0x042a:
            r3.endReplaceableGroup()
            r17 = r1
            kotlin.jvm.functions.Function1 r17 = (kotlin.jvm.functions.Function1) r17
            r1 = r4 & 896(0x380, float:1.256E-42)
            int r7 = r4 >> 6
            r7 = r7 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r7
            int r7 = r9 << 12
            r13 = r7 & r21
            r1 = r1 | r13
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r7
            r1 = r1 | r13
            r13 = 3670016(0x380000, float:5.142788E-39)
            r13 = r13 & r7
            r1 = r1 | r13
            r13 = 29360128(0x1c00000, float:7.052966E-38)
            r7 = r7 & r13
            r32 = r1 | r7
            int r1 = r4 >> 18
            r1 = r1 & 112(0x70, float:1.57E-43)
            int r4 = r4 >> 3
            r7 = r4 & 896(0x380, float:1.256E-42)
            r1 = r1 | r7
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r4
            r4 = r9 & r21
            r33 = r1 | r4
            r34 = 0
            r16 = r0
            r18 = r2
            r19 = r5
            r20 = r10
            r21 = r12
            r22 = r14
            r23 = r35
            r27 = r11
            r28 = r40
            r29 = r48
            r30 = r36
            r31 = r3
            androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0480
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0480:
            r9 = r41
            r7 = r48
            r4 = r2
            r13 = r10
            r15 = r14
            r10 = r8
            r14 = r12
            r12 = r47
            r8 = r5
            r5 = r40
        L_0x048e:
            androidx.compose.runtime.ScopeUpdateScope r3 = r3.endRestartGroup()
            if (r3 != 0) goto L_0x0495
            goto L_0x04c9
        L_0x0495:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$5 r19 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$5
            r0 = r19
            r1 = r38
            r2 = r39
            r6 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r8
            r8 = r11
            r11 = r9
            r9 = r10
            r10 = r12
            r12 = r11
            r11 = r13
            r13 = r12
            r12 = r14
            r14 = r13
            r13 = r15
            r15 = r14
            r14 = r35
            r37 = r15
            r15 = r36
            r16 = r54
            r17 = r55
            r18 = r56
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0 = r19
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r37
            r1.updateScope(r0)
        L_0x04c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: BasicTextField$lambda-2  reason: not valid java name */
    public static final TextFieldValue m859BasicTextField$lambda2(MutableState<TextFieldValue> mutableState) {
        return (TextFieldValue) mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: BasicTextField$lambda-6  reason: not valid java name */
    public static final String m861BasicTextField$lambda6(MutableState<String> mutableState) {
        return (String) mutableState.getValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v0, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v1, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v2, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v3, resolved type: kotlin.jvm.functions.Function3<kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v4, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01b9, code lost:
        if (r10.changed((java.lang.Object) r47) != false) goto L_0x01c0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x03eb  */
    /* JADX WARNING: Removed duplicated region for block: B:233:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x013e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BasicTextField(androidx.compose.ui.text.input.TextFieldValue r34, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r35, androidx.compose.ui.Modifier r36, boolean r37, boolean r38, androidx.compose.ui.text.TextStyle r39, androidx.compose.foundation.text.KeyboardOptions r40, androidx.compose.foundation.text.KeyboardActions r41, boolean r42, int r43, androidx.compose.ui.text.input.VisualTransformation r44, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r45, androidx.compose.foundation.interaction.MutableInteractionSource r46, androidx.compose.ui.graphics.Brush r47, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, androidx.compose.runtime.Composer r49, int r50, int r51, int r52) {
        /*
            r15 = r34
            r14 = r35
            r13 = r50
            r12 = r51
            r11 = r52
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -560482651(0xffffffffde97b6a5, float:-5.4660533E18)
            r1 = r49
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)277@15970L39,284@16272L90,282@16210L688:BasicTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r11 & 1
            if (r1 == 0) goto L_0x002b
            r1 = r13 | 6
            goto L_0x003b
        L_0x002b:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x003a
            boolean r1 = r10.changed((java.lang.Object) r15)
            if (r1 == 0) goto L_0x0037
            r1 = 4
            goto L_0x0038
        L_0x0037:
            r1 = 2
        L_0x0038:
            r1 = r1 | r13
            goto L_0x003b
        L_0x003a:
            r1 = r13
        L_0x003b:
            r4 = r11 & 2
            if (r4 == 0) goto L_0x0042
            r1 = r1 | 48
            goto L_0x0052
        L_0x0042:
            r4 = r13 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0052
            boolean r4 = r10.changed((java.lang.Object) r14)
            if (r4 == 0) goto L_0x004f
            r4 = 32
            goto L_0x0051
        L_0x004f:
            r4 = 16
        L_0x0051:
            r1 = r1 | r4
        L_0x0052:
            r4 = r11 & 4
            if (r4 == 0) goto L_0x0059
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x006d
        L_0x0059:
            r9 = r13 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x006d
            r9 = r36
            boolean r16 = r10.changed((java.lang.Object) r9)
            if (r16 == 0) goto L_0x0068
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0068:
            r16 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r1 = r1 | r16
            goto L_0x006f
        L_0x006d:
            r9 = r36
        L_0x006f:
            r16 = r11 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x007a
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x008e
        L_0x007a:
            r2 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x008e
            r2 = r37
            boolean r19 = r10.changed((boolean) r2)
            if (r19 == 0) goto L_0x0089
            r19 = 2048(0x800, float:2.87E-42)
            goto L_0x008b
        L_0x0089:
            r19 = 1024(0x400, float:1.435E-42)
        L_0x008b:
            r1 = r1 | r19
            goto L_0x0090
        L_0x008e:
            r2 = r37
        L_0x0090:
            r19 = r11 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 57344(0xe000, float:8.0356E-41)
            r22 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x00a0
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r3 = r38
            goto L_0x00b3
        L_0x00a0:
            r23 = r13 & r21
            r3 = r38
            if (r23 != 0) goto L_0x00b3
            boolean r24 = r10.changed((boolean) r3)
            if (r24 == 0) goto L_0x00af
            r24 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00b1
        L_0x00af:
            r24 = 8192(0x2000, float:1.14794E-41)
        L_0x00b1:
            r1 = r1 | r24
        L_0x00b3:
            r24 = r11 & 32
            r25 = 458752(0x70000, float:6.42848E-40)
            if (r24 == 0) goto L_0x00c0
            r26 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r26
            r5 = r39
            goto L_0x00d3
        L_0x00c0:
            r26 = r13 & r25
            r5 = r39
            if (r26 != 0) goto L_0x00d3
            boolean r27 = r10.changed((java.lang.Object) r5)
            if (r27 == 0) goto L_0x00cf
            r27 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d1
        L_0x00cf:
            r27 = 65536(0x10000, float:9.18355E-41)
        L_0x00d1:
            r1 = r1 | r27
        L_0x00d3:
            r27 = r11 & 64
            if (r27 == 0) goto L_0x00de
            r28 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r28
            r6 = r40
            goto L_0x00f3
        L_0x00de:
            r28 = 3670016(0x380000, float:5.142788E-39)
            r28 = r13 & r28
            r6 = r40
            if (r28 != 0) goto L_0x00f3
            boolean r29 = r10.changed((java.lang.Object) r6)
            if (r29 == 0) goto L_0x00ef
            r29 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00f1
        L_0x00ef:
            r29 = 524288(0x80000, float:7.34684E-40)
        L_0x00f1:
            r1 = r1 | r29
        L_0x00f3:
            r7 = r11 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x00fe
            r30 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r30
            r8 = r41
            goto L_0x0113
        L_0x00fe:
            r30 = 29360128(0x1c00000, float:7.052966E-38)
            r30 = r13 & r30
            r8 = r41
            if (r30 != 0) goto L_0x0113
            boolean r31 = r10.changed((java.lang.Object) r8)
            if (r31 == 0) goto L_0x010f
            r31 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0111
        L_0x010f:
            r31 = 4194304(0x400000, float:5.877472E-39)
        L_0x0111:
            r1 = r1 | r31
        L_0x0113:
            r0 = r11 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x011e
            r32 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r32
            r2 = r42
            goto L_0x0133
        L_0x011e:
            r32 = 234881024(0xe000000, float:1.5777218E-30)
            r32 = r13 & r32
            r2 = r42
            if (r32 != 0) goto L_0x0133
            boolean r32 = r10.changed((boolean) r2)
            if (r32 == 0) goto L_0x012f
            r32 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0131
        L_0x012f:
            r32 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0131:
            r1 = r1 | r32
        L_0x0133:
            r2 = r11 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x013e
            r32 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r32
            r3 = r43
            goto L_0x0153
        L_0x013e:
            r32 = 1879048192(0x70000000, float:1.58456325E29)
            r32 = r13 & r32
            r3 = r43
            if (r32 != 0) goto L_0x0153
            boolean r32 = r10.changed((int) r3)
            if (r32 == 0) goto L_0x014f
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0151
        L_0x014f:
            r32 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0151:
            r1 = r1 | r32
        L_0x0153:
            r3 = r11 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x015c
            r23 = r12 | 6
            r5 = r44
            goto L_0x0172
        L_0x015c:
            r32 = r12 & 14
            r5 = r44
            if (r32 != 0) goto L_0x0170
            boolean r32 = r10.changed((java.lang.Object) r5)
            if (r32 == 0) goto L_0x016b
            r23 = 4
            goto L_0x016d
        L_0x016b:
            r23 = 2
        L_0x016d:
            r23 = r12 | r23
            goto L_0x0172
        L_0x0170:
            r23 = r12
        L_0x0172:
            r5 = r11 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x0179
            r23 = r23 | 48
            goto L_0x018c
        L_0x0179:
            r32 = r12 & 112(0x70, float:1.57E-43)
            r6 = r45
            if (r32 != 0) goto L_0x018c
            boolean r32 = r10.changed((java.lang.Object) r6)
            if (r32 == 0) goto L_0x0188
            r26 = 32
            goto L_0x018a
        L_0x0188:
            r26 = 16
        L_0x018a:
            r23 = r23 | r26
        L_0x018c:
            r6 = r23
            r8 = r11 & 4096(0x1000, float:5.74E-42)
            if (r8 == 0) goto L_0x0195
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x01a9
        L_0x0195:
            r9 = r12 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x01a9
            r9 = r46
            boolean r23 = r10.changed((java.lang.Object) r9)
            if (r23 == 0) goto L_0x01a4
            r29 = 256(0x100, float:3.59E-43)
            goto L_0x01a6
        L_0x01a4:
            r29 = 128(0x80, float:1.794E-43)
        L_0x01a6:
            r6 = r6 | r29
            goto L_0x01ab
        L_0x01a9:
            r9 = r46
        L_0x01ab:
            r9 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x01c3
            r9 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r9 != 0) goto L_0x01bc
            r9 = r47
            boolean r23 = r10.changed((java.lang.Object) r9)
            if (r23 == 0) goto L_0x01be
            goto L_0x01c0
        L_0x01bc:
            r9 = r47
        L_0x01be:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x01c0:
            r6 = r6 | r17
            goto L_0x01c5
        L_0x01c3:
            r9 = r47
        L_0x01c5:
            r9 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r9 == 0) goto L_0x01ce
            r6 = r6 | 24576(0x6000, float:3.4438E-41)
            r12 = r48
            goto L_0x01df
        L_0x01ce:
            r17 = r12 & r21
            r12 = r48
            if (r17 != 0) goto L_0x01df
            boolean r17 = r10.changed((java.lang.Object) r12)
            if (r17 == 0) goto L_0x01db
            goto L_0x01dd
        L_0x01db:
            r20 = 8192(0x2000, float:1.14794E-41)
        L_0x01dd:
            r6 = r6 | r20
        L_0x01df:
            r17 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r12 = r1 & r17
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r12 != r14) goto L_0x0219
            r12 = 46811(0xb6db, float:6.5596E-41)
            r12 = r12 & r6
            r14 = 9362(0x2492, float:1.3119E-41)
            if (r12 != r14) goto L_0x0219
            boolean r12 = r10.getSkipping()
            if (r12 != 0) goto L_0x01f8
            goto L_0x0219
        L_0x01f8:
            r10.skipToGroupEnd()
            r3 = r36
            r4 = r37
            r5 = r38
            r6 = r39
            r7 = r40
            r8 = r41
            r9 = r42
            r11 = r44
            r12 = r45
            r13 = r46
            r14 = r47
            r15 = r48
            r21 = r10
            r10 = r43
            goto L_0x03e4
        L_0x0219:
            r10.startDefaults()
            r12 = r13 & 1
            if (r12 == 0) goto L_0x024c
            boolean r12 = r10.getDefaultsInvalid()
            if (r12 == 0) goto L_0x0227
            goto L_0x024c
        L_0x0227:
            r10.skipToGroupEnd()
            r0 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0230
            r6 = r6 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0230:
            r19 = r36
            r20 = r37
            r22 = r38
            r23 = r39
            r14 = r40
            r24 = r41
            r12 = r42
            r26 = r43
            r27 = r44
            r28 = r45
            r29 = r46
            r30 = r47
            r32 = r48
            goto L_0x031d
        L_0x024c:
            if (r4 == 0) goto L_0x0253
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x0255
        L_0x0253:
            r4 = r36
        L_0x0255:
            if (r16 == 0) goto L_0x0259
            r12 = 1
            goto L_0x025b
        L_0x0259:
            r12 = r37
        L_0x025b:
            if (r19 == 0) goto L_0x0260
            r16 = 0
            goto L_0x0262
        L_0x0260:
            r16 = r38
        L_0x0262:
            if (r24 == 0) goto L_0x026b
            androidx.compose.ui.text.TextStyle$Companion r17 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r17 = r17.getDefault()
            goto L_0x026d
        L_0x026b:
            r17 = r39
        L_0x026d:
            if (r27 == 0) goto L_0x0276
            androidx.compose.foundation.text.KeyboardOptions$Companion r18 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r18 = r18.getDefault()
            goto L_0x0278
        L_0x0276:
            r18 = r40
        L_0x0278:
            if (r7 == 0) goto L_0x0281
            androidx.compose.foundation.text.KeyboardActions$Companion r7 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r7 = r7.getDefault()
            goto L_0x0283
        L_0x0281:
            r7 = r41
        L_0x0283:
            if (r0 == 0) goto L_0x0287
            r0 = 0
            goto L_0x0289
        L_0x0287:
            r0 = r42
        L_0x0289:
            if (r2 == 0) goto L_0x028f
            r2 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0291
        L_0x028f:
            r2 = r43
        L_0x0291:
            if (r3 == 0) goto L_0x029a
            androidx.compose.ui.text.input.VisualTransformation$Companion r3 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r3 = r3.getNone()
            goto L_0x029c
        L_0x029a:
            r3 = r44
        L_0x029c:
            if (r5 == 0) goto L_0x02a3
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$6 r5 = androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$6.INSTANCE
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            goto L_0x02a5
        L_0x02a3:
            r5 = r45
        L_0x02a5:
            if (r8 == 0) goto L_0x02cb
            r8 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r8)
            java.lang.String r8 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r8)
            java.lang.Object r8 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r19.getEmpty()
            if (r8 != r14) goto L_0x02c5
            androidx.compose.foundation.interaction.MutableInteractionSource r8 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r10.updateRememberedValue(r8)
        L_0x02c5:
            r10.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r8 = (androidx.compose.foundation.interaction.MutableInteractionSource) r8
            goto L_0x02cd
        L_0x02cb:
            r8 = r46
        L_0x02cd:
            r14 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x02ea
            androidx.compose.ui.graphics.SolidColor r14 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r19 = androidx.compose.ui.graphics.Color.Companion
            r36 = r2
            r37 = r3
            long r2 = r19.m1958getBlack0d7_KjU()
            r38 = r0
            r0 = 0
            r14.<init>(r2, r0)
            r0 = r14
            androidx.compose.ui.graphics.Brush r0 = (androidx.compose.ui.graphics.Brush) r0
            r2 = r6 & -7169(0xffffffffffffe3ff, float:NaN)
            r6 = r2
            goto L_0x02f2
        L_0x02ea:
            r38 = r0
            r36 = r2
            r37 = r3
            r0 = r47
        L_0x02f2:
            if (r9 == 0) goto L_0x0303
            androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt r2 = androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r2 = r2.m872getLambda2$foundation_release()
            r26 = r36
            r27 = r37
            r30 = r0
            r32 = r2
            goto L_0x030b
        L_0x0303:
            r26 = r36
            r27 = r37
            r32 = r48
            r30 = r0
        L_0x030b:
            r19 = r4
            r28 = r5
            r24 = r7
            r29 = r8
            r20 = r12
            r22 = r16
            r23 = r17
            r14 = r18
            r12 = r38
        L_0x031d:
            r10.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x032e
            java.lang.String r0 = "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:264)"
            r2 = -560482651(0xffffffffde97b6a5, float:-5.4660533E18)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r6, r0)
        L_0x032e:
            androidx.compose.ui.text.input.ImeOptions r31 = r14.toImeOptions$foundation_release(r12)
            r8 = r12 ^ 1
            if (r12 == 0) goto L_0x0338
            r9 = 1
            goto L_0x033a
        L_0x0338:
            r9 = r26
        L_0x033a:
            r0 = r1 & 14
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            boolean r2 = r10.changed((java.lang.Object) r15)
            r7 = r35
            boolean r3 = r10.changed((java.lang.Object) r7)
            r2 = r2 | r3
            java.lang.Object r3 = r10.rememberedValue()
            if (r2 != 0) goto L_0x0360
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x036b
        L_0x0360:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1 r2 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1
            r2.<init>(r15, r7)
            r3 = r2
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r10.updateRememberedValue(r3)
        L_0x036b:
            r10.endReplaceableGroup()
            r2 = r3
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r3 = r1
            r1 = r2
            r2 = r3 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            int r2 = r3 >> 6
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r6 << 12
            r4 = r2 & r21
            r0 = r0 | r4
            r4 = r2 & r25
            r0 = r0 | r4
            r4 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r2
            r0 = r0 | r4
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r4
            r16 = r0 | r2
            int r0 = r3 >> 18
            r0 = r0 & 112(0x70, float:1.57E-43)
            int r2 = r3 >> 3
            r3 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            r2 = r6 & r21
            r17 = r0 | r2
            r18 = 0
            r0 = r34
            r2 = r19
            r3 = r23
            r4 = r27
            r5 = r28
            r6 = r29
            r7 = r30
            r21 = r10
            r10 = r31
            r11 = r24
            r25 = r12
            r12 = r20
            r13 = r22
            r31 = r14
            r14 = r32
            r15 = r21
            androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03ca
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03ca:
            r3 = r19
            r4 = r20
            r5 = r22
            r6 = r23
            r8 = r24
            r9 = r25
            r10 = r26
            r11 = r27
            r12 = r28
            r13 = r29
            r14 = r30
            r7 = r31
            r15 = r32
        L_0x03e4:
            androidx.compose.runtime.ScopeUpdateScope r2 = r21.endRestartGroup()
            if (r2 != 0) goto L_0x03eb
            goto L_0x0407
        L_0x03eb:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$9 r19 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$9
            r0 = r19
            r1 = r34
            r33 = r2
            r2 = r35
            r16 = r50
            r17 = r51
            r18 = r52
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0 = r19
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r33
            r1.updateScope(r0)
        L_0x0407:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: BasicTextField$lambda-3  reason: not valid java name */
    public static final void m860BasicTextField$lambda3(MutableState<TextFieldValue> mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
    }

    /* access modifiers changed from: private */
    /* renamed from: BasicTextField$lambda-7  reason: not valid java name */
    public static final void m862BasicTextField$lambda7(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }
}
