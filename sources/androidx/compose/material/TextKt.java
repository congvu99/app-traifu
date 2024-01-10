package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aß\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(2\u0014\b\u0002\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00060,2\b\b\u0002\u0010.\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100\u001aÉ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020)2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00060,2\b\b\u0002\u0010.\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00063"}, d2 = {"LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/text/TextStyle;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Text", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Text--4IGK_g", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Text.kt */
public final class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), TextKt$LocalTextStyle$1.INSTANCE);

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x042f  */
    /* JADX WARNING: Removed duplicated region for block: B:243:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0138  */
    /* renamed from: Text-fLXpl1I  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1496TextfLXpl1I(java.lang.String r55, androidx.compose.ui.Modifier r56, long r57, long r59, androidx.compose.ui.text.font.FontStyle r61, androidx.compose.ui.text.font.FontWeight r62, androidx.compose.ui.text.font.FontFamily r63, long r64, androidx.compose.ui.text.style.TextDecoration r66, androidx.compose.ui.text.style.TextAlign r67, long r68, int r70, boolean r71, int r72, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r73, androidx.compose.ui.text.TextStyle r74, androidx.compose.runtime.Composer r75, int r76, int r77, int r78) {
        /*
            r1 = r55
            r14 = r76
            r15 = r77
            r13 = r78
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = -366126944(0xffffffffea2d58a0, float:-5.239067E25)
            r2 = r75
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(Text)P(13,8,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,15,14:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,10:c#ui.text.style.TextOverflow,11)106@5548L7,129@6306L145:Text.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = r13 & 1
            if (r2 == 0) goto L_0x0023
            r2 = r14 | 6
            goto L_0x0033
        L_0x0023:
            r2 = r14 & 14
            if (r2 != 0) goto L_0x0032
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x002f
            r2 = 4
            goto L_0x0030
        L_0x002f:
            r2 = 2
        L_0x0030:
            r2 = r2 | r14
            goto L_0x0033
        L_0x0032:
            r2 = r14
        L_0x0033:
            r5 = r13 & 2
            if (r5 == 0) goto L_0x003a
            r2 = r2 | 48
            goto L_0x004d
        L_0x003a:
            r8 = r14 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x004d
            r8 = r56
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0049
            r9 = 32
            goto L_0x004b
        L_0x0049:
            r9 = 16
        L_0x004b:
            r2 = r2 | r9
            goto L_0x004f
        L_0x004d:
            r8 = r56
        L_0x004f:
            r9 = r13 & 4
            if (r9 == 0) goto L_0x0058
            r2 = r2 | 384(0x180, float:5.38E-43)
            r3 = r57
            goto L_0x006b
        L_0x0058:
            r12 = r14 & 896(0x380, float:1.256E-42)
            r3 = r57
            if (r12 != 0) goto L_0x006b
            boolean r16 = r0.changed((long) r3)
            if (r16 == 0) goto L_0x0067
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0067:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0069:
            r2 = r2 | r16
        L_0x006b:
            r16 = r13 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0078
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r7 = r59
            goto L_0x008b
        L_0x0078:
            r6 = r14 & 7168(0x1c00, float:1.0045E-41)
            r7 = r59
            if (r6 != 0) goto L_0x008b
            boolean r20 = r0.changed((long) r7)
            if (r20 == 0) goto L_0x0087
            r20 = 2048(0x800, float:2.87E-42)
            goto L_0x0089
        L_0x0087:
            r20 = 1024(0x400, float:1.435E-42)
        L_0x0089:
            r2 = r2 | r20
        L_0x008b:
            r20 = r13 & 16
            r21 = 16384(0x4000, float:2.2959E-41)
            r22 = 8192(0x2000, float:1.14794E-41)
            r23 = 57344(0xe000, float:8.0356E-41)
            if (r20 == 0) goto L_0x009b
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            r6 = r61
            goto L_0x00ae
        L_0x009b:
            r24 = r14 & r23
            r6 = r61
            if (r24 != 0) goto L_0x00ae
            boolean r25 = r0.changed((java.lang.Object) r6)
            if (r25 == 0) goto L_0x00aa
            r25 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ac
        L_0x00aa:
            r25 = 8192(0x2000, float:1.14794E-41)
        L_0x00ac:
            r2 = r2 | r25
        L_0x00ae:
            r25 = r13 & 32
            r26 = 458752(0x70000, float:6.42848E-40)
            if (r25 == 0) goto L_0x00bb
            r27 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r27
            r10 = r62
            goto L_0x00ce
        L_0x00bb:
            r27 = r14 & r26
            r10 = r62
            if (r27 != 0) goto L_0x00ce
            boolean r28 = r0.changed((java.lang.Object) r10)
            if (r28 == 0) goto L_0x00ca
            r28 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cc
        L_0x00ca:
            r28 = 65536(0x10000, float:9.18355E-41)
        L_0x00cc:
            r2 = r2 | r28
        L_0x00ce:
            r28 = r13 & 64
            if (r28 == 0) goto L_0x00d9
            r29 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r29
            r11 = r63
            goto L_0x00ee
        L_0x00d9:
            r29 = 3670016(0x380000, float:5.142788E-39)
            r29 = r14 & r29
            r11 = r63
            if (r29 != 0) goto L_0x00ee
            boolean r30 = r0.changed((java.lang.Object) r11)
            if (r30 == 0) goto L_0x00ea
            r30 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ec
        L_0x00ea:
            r30 = 524288(0x80000, float:7.34684E-40)
        L_0x00ec:
            r2 = r2 | r30
        L_0x00ee:
            r12 = r13 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x00f9
            r31 = 12582912(0xc00000, float:1.7632415E-38)
            r2 = r2 | r31
            r3 = r64
            goto L_0x010e
        L_0x00f9:
            r31 = 29360128(0x1c00000, float:7.052966E-38)
            r31 = r14 & r31
            r3 = r64
            if (r31 != 0) goto L_0x010e
            boolean r31 = r0.changed((long) r3)
            if (r31 == 0) goto L_0x010a
            r31 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010c
        L_0x010a:
            r31 = 4194304(0x400000, float:5.877472E-39)
        L_0x010c:
            r2 = r2 | r31
        L_0x010e:
            r1 = r13 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0119
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            r2 = r2 | r31
            r3 = r66
            goto L_0x012d
        L_0x0119:
            r31 = 234881024(0xe000000, float:1.5777218E-30)
            r31 = r14 & r31
            r3 = r66
            if (r31 != 0) goto L_0x012d
            boolean r4 = r0.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x012a
            r4 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012c
        L_0x012a:
            r4 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012c:
            r2 = r2 | r4
        L_0x012d:
            r4 = r13 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0138
            r31 = 805306368(0x30000000, float:4.656613E-10)
            r2 = r2 | r31
            r3 = r67
            goto L_0x014d
        L_0x0138:
            r31 = 1879048192(0x70000000, float:1.58456325E29)
            r31 = r14 & r31
            r3 = r67
            if (r31 != 0) goto L_0x014d
            boolean r31 = r0.changed((java.lang.Object) r3)
            if (r31 == 0) goto L_0x0149
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x014b
        L_0x0149:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x014b:
            r2 = r2 | r31
        L_0x014d:
            r3 = r13 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0156
            r30 = r15 | 6
            r6 = r68
            goto L_0x016c
        L_0x0156:
            r31 = r15 & 14
            r6 = r68
            if (r31 != 0) goto L_0x016a
            boolean r8 = r0.changed((long) r6)
            if (r8 == 0) goto L_0x0165
            r30 = 4
            goto L_0x0167
        L_0x0165:
            r30 = 2
        L_0x0167:
            r30 = r15 | r30
            goto L_0x016c
        L_0x016a:
            r30 = r15
        L_0x016c:
            r8 = r13 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x0175
            r30 = r30 | 48
            r6 = r70
            goto L_0x0188
        L_0x0175:
            r31 = r15 & 112(0x70, float:1.57E-43)
            r6 = r70
            if (r31 != 0) goto L_0x0188
            boolean r7 = r0.changed((int) r6)
            if (r7 == 0) goto L_0x0184
            r24 = 32
            goto L_0x0186
        L_0x0184:
            r24 = 16
        L_0x0186:
            r30 = r30 | r24
        L_0x0188:
            r7 = r30
            r6 = r13 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x0191
            r7 = r7 | 384(0x180, float:5.38E-43)
            goto L_0x01a5
        L_0x0191:
            r10 = r15 & 896(0x380, float:1.256E-42)
            if (r10 != 0) goto L_0x01a5
            r10 = r71
            boolean r19 = r0.changed((boolean) r10)
            if (r19 == 0) goto L_0x01a0
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x01a2
        L_0x01a0:
            r27 = 128(0x80, float:1.794E-43)
        L_0x01a2:
            r7 = r7 | r27
            goto L_0x01a7
        L_0x01a5:
            r10 = r71
        L_0x01a7:
            r10 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r10 == 0) goto L_0x01ae
            r7 = r7 | 3072(0xc00, float:4.305E-42)
            goto L_0x01c0
        L_0x01ae:
            r11 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x01c0
            r11 = r72
            boolean r19 = r0.changed((int) r11)
            if (r19 == 0) goto L_0x01bb
            goto L_0x01bd
        L_0x01bb:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x01bd:
            r7 = r7 | r17
            goto L_0x01c2
        L_0x01c0:
            r11 = r72
        L_0x01c2:
            r11 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r11 == 0) goto L_0x01c9
            r7 = r7 | 24576(0x6000, float:3.4438E-41)
            goto L_0x01dd
        L_0x01c9:
            r17 = r15 & r23
            if (r17 != 0) goto L_0x01dd
            r17 = r11
            r11 = r73
            boolean r18 = r0.changed((java.lang.Object) r11)
            if (r18 == 0) goto L_0x01d8
            goto L_0x01da
        L_0x01d8:
            r21 = 8192(0x2000, float:1.14794E-41)
        L_0x01da:
            r7 = r7 | r21
            goto L_0x01e1
        L_0x01dd:
            r17 = r11
            r11 = r73
        L_0x01e1:
            r18 = r15 & r26
            r19 = 32768(0x8000, float:4.5918E-41)
            if (r18 != 0) goto L_0x01fc
            r18 = r13 & r19
            r11 = r74
            if (r18 != 0) goto L_0x01f7
            boolean r18 = r0.changed((java.lang.Object) r11)
            if (r18 == 0) goto L_0x01f7
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01f9
        L_0x01f7:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x01f9:
            r7 = r7 | r18
            goto L_0x01fe
        L_0x01fc:
            r11 = r74
        L_0x01fe:
            r18 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r11 = r2 & r18
            r15 = 306783378(0x12492492, float:6.3469493E-28)
            if (r11 != r15) goto L_0x023b
            r11 = 374491(0x5b6db, float:5.24774E-40)
            r11 = r11 & r7
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r11 != r15) goto L_0x023b
            boolean r11 = r0.getSkipping()
            if (r11 != 0) goto L_0x0218
            goto L_0x023b
        L_0x0218:
            r0.skipToGroupEnd()
            r2 = r56
            r3 = r57
            r5 = r59
            r7 = r61
            r8 = r62
            r9 = r63
            r10 = r64
            r12 = r66
            r13 = r67
            r14 = r68
            r16 = r70
            r17 = r71
            r18 = r72
            r19 = r73
            r20 = r74
            goto L_0x0428
        L_0x023b:
            r0.startDefaults()
            r11 = r14 & 1
            java.lang.String r15 = "C:CompositionLocal.kt#9igjgp"
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            r18 = 1
            if (r11 == 0) goto L_0x027d
            boolean r11 = r0.getDefaultsInvalid()
            if (r11 == 0) goto L_0x0250
            goto L_0x027d
        L_0x0250:
            r0.skipToGroupEnd()
            r1 = r13 & r19
            if (r1 == 0) goto L_0x025b
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r7 = r7 & r1
        L_0x025b:
            r5 = r56
            r21 = r57
            r3 = r59
            r11 = r61
            r16 = r62
            r20 = r63
            r24 = r64
            r1 = r66
            r9 = r67
            r8 = r70
            r10 = r71
            r12 = r72
            r17 = r73
            r66 = r74
            r19 = r7
            r6 = r68
            goto L_0x0327
        L_0x027d:
            if (r5 == 0) goto L_0x0284
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            goto L_0x0286
        L_0x0284:
            r5 = r56
        L_0x0286:
            if (r9 == 0) goto L_0x028f
            androidx.compose.ui.graphics.Color$Companion r9 = androidx.compose.ui.graphics.Color.Companion
            long r21 = r9.m1968getUnspecified0d7_KjU()
            goto L_0x0291
        L_0x028f:
            r21 = r57
        L_0x0291:
            if (r16 == 0) goto L_0x029a
            androidx.compose.ui.unit.TextUnit$Companion r9 = androidx.compose.ui.unit.TextUnit.Companion
            long r29 = r9.m4896getUnspecifiedXSAIIZE()
            goto L_0x029c
        L_0x029a:
            r29 = r59
        L_0x029c:
            r9 = 0
            if (r20 == 0) goto L_0x02a1
            r11 = r9
            goto L_0x02a3
        L_0x02a1:
            r11 = r61
        L_0x02a3:
            if (r25 == 0) goto L_0x02a8
            r16 = r9
            goto L_0x02aa
        L_0x02a8:
            r16 = r62
        L_0x02aa:
            if (r28 == 0) goto L_0x02af
            r20 = r9
            goto L_0x02b1
        L_0x02af:
            r20 = r63
        L_0x02b1:
            if (r12 == 0) goto L_0x02ba
            androidx.compose.ui.unit.TextUnit$Companion r12 = androidx.compose.ui.unit.TextUnit.Companion
            long r24 = r12.m4896getUnspecifiedXSAIIZE()
            goto L_0x02bc
        L_0x02ba:
            r24 = r64
        L_0x02bc:
            if (r1 == 0) goto L_0x02c0
            r1 = r9
            goto L_0x02c2
        L_0x02c0:
            r1 = r66
        L_0x02c2:
            if (r4 == 0) goto L_0x02c5
            goto L_0x02c7
        L_0x02c5:
            r9 = r67
        L_0x02c7:
            if (r3 == 0) goto L_0x02d0
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m4896getUnspecifiedXSAIIZE()
            goto L_0x02d2
        L_0x02d0:
            r3 = r68
        L_0x02d2:
            if (r8 == 0) goto L_0x02db
            androidx.compose.ui.text.style.TextOverflow$Companion r8 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r8 = r8.m4590getClipgIe3tQ8()
            goto L_0x02dd
        L_0x02db:
            r8 = r70
        L_0x02dd:
            if (r6 == 0) goto L_0x02e1
            r6 = 1
            goto L_0x02e3
        L_0x02e1:
            r6 = r71
        L_0x02e3:
            if (r10 == 0) goto L_0x02e9
            r10 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x02eb
        L_0x02e9:
            r10 = r72
        L_0x02eb:
            if (r17 == 0) goto L_0x02f2
            androidx.compose.material.TextKt$Text$1 r12 = androidx.compose.material.TextKt$Text$1.INSTANCE
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            goto L_0x02f4
        L_0x02f2:
            r12 = r73
        L_0x02f4:
            r17 = r13 & r19
            if (r17 == 0) goto L_0x031a
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.text.TextStyle> r17 = LocalTextStyle
            r56 = r1
            r1 = r17
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r14, r15)
            java.lang.Object r1 = r0.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.text.TextStyle r1 = (androidx.compose.ui.text.TextStyle) r1
            r17 = -458753(0xfffffffffff8ffff, float:NaN)
            r7 = r7 & r17
            r66 = r1
            r19 = r7
            r17 = r12
            r1 = r56
            goto L_0x0322
        L_0x031a:
            r56 = r1
            r66 = r74
            r19 = r7
            r17 = r12
        L_0x0322:
            r12 = r10
            r10 = r6
            r6 = r3
            r3 = r29
        L_0x0327:
            r0.endDefaults()
            r14 = 1557613088(0x5cd74a20, float:4.8478897E17)
            r0.startReplaceableGroup(r14)
            java.lang.String r14 = "*111@5663L7,111@5702L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r14)
            androidx.compose.ui.graphics.Color$Companion r14 = androidx.compose.ui.graphics.Color.Companion
            long r27 = r14.m1968getUnspecified0d7_KjU()
            int r14 = (r21 > r27 ? 1 : (r21 == r27 ? 0 : -1))
            if (r14 == 0) goto L_0x0341
            r14 = 1
            goto L_0x0342
        L_0x0341:
            r14 = 0
        L_0x0342:
            if (r14 == 0) goto L_0x0347
            r28 = r21
            goto L_0x03a6
        L_0x0347:
            long r27 = r66.m4238getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r14 = androidx.compose.ui.graphics.Color.Companion
            long r29 = r14.m1968getUnspecified0d7_KjU()
            int r14 = (r27 > r29 ? 1 : (r27 == r29 ? 0 : -1))
            if (r14 == 0) goto L_0x0356
            goto L_0x0358
        L_0x0356:
            r18 = 0
        L_0x0358:
            if (r18 == 0) goto L_0x035b
            goto L_0x03a4
        L_0x035b:
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r15)
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.graphics.Color r14 = (androidx.compose.ui.graphics.Color) r14
            long r27 = r14.m1942unboximpl()
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r15)
            java.lang.Object r13 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            java.lang.Number r13 = (java.lang.Number) r13
            float r13 = r13.floatValue()
            r14 = 0
            r15 = 0
            r18 = 0
            r29 = 14
            r30 = 0
            r56 = r27
            r58 = r13
            r59 = r14
            r60 = r15
            r61 = r18
            r62 = r29
            r63 = r30
            long r27 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r56, r58, r59, r60, r61, r62, r63)
        L_0x03a4:
            r28 = r27
        L_0x03a6:
            r0.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r13 = new androidx.compose.ui.text.TextStyle
            r27 = r13
            r34 = 0
            r36 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r45 = 0
            r47 = 0
            r50 = 0
            r51 = 175952(0x2af50, float:2.46561E-40)
            r52 = 0
            r30 = r3
            r32 = r16
            r33 = r11
            r35 = r20
            r37 = r24
            r44 = r1
            r46 = r9
            r48 = r6
            r27.<init>((long) r28, (long) r30, (androidx.compose.ui.text.font.FontWeight) r32, (androidx.compose.ui.text.font.FontStyle) r33, (androidx.compose.ui.text.font.FontSynthesis) r34, (androidx.compose.ui.text.font.FontFamily) r35, (java.lang.String) r36, (long) r37, (androidx.compose.ui.text.style.BaselineShift) r39, (androidx.compose.ui.text.style.TextGeometricTransform) r40, (androidx.compose.ui.text.intl.LocaleList) r41, (long) r42, (androidx.compose.ui.text.style.TextDecoration) r44, (androidx.compose.ui.graphics.Shadow) r45, (androidx.compose.ui.text.style.TextAlign) r46, (androidx.compose.ui.text.style.TextDirection) r47, (long) r48, (androidx.compose.ui.text.style.TextIndent) r50, (int) r51, (kotlin.jvm.internal.DefaultConstructorMarker) r52)
            r14 = r66
            androidx.compose.ui.text.TextStyle r13 = r14.merge((androidx.compose.ui.text.TextStyle) r13)
            r15 = r2 & 14
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | r15
            int r15 = r19 >> 3
            r15 = r15 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r15
            int r15 = r19 << 9
            r18 = r15 & r23
            r2 = r2 | r18
            r18 = r15 & r26
            r2 = r2 | r18
            r18 = 3670016(0x380000, float:5.142788E-39)
            r15 = r15 & r18
            r2 = r2 | r15
            r15 = 0
            r56 = r55
            r57 = r5
            r58 = r13
            r59 = r17
            r60 = r8
            r61 = r10
            r62 = r12
            r63 = r0
            r64 = r2
            r65 = r15
            androidx.compose.foundation.text.BasicTextKt.m868BasicTextBpD7jsM(r56, r57, r58, r59, r60, r61, r62, r63, r64, r65)
            r2 = r5
            r13 = r9
            r18 = r12
            r19 = r17
            r9 = r20
            r12 = r1
            r17 = r10
            r20 = r14
            r14 = r6
            r7 = r11
            r10 = r24
            r5 = r3
            r3 = r21
            r54 = r16
            r16 = r8
            r8 = r54
        L_0x0428:
            androidx.compose.runtime.ScopeUpdateScope r1 = r0.endRestartGroup()
            if (r1 != 0) goto L_0x042f
            goto L_0x0449
        L_0x042f:
            androidx.compose.material.TextKt$Text$2 r24 = new androidx.compose.material.TextKt$Text$2
            r0 = r24
            r53 = r1
            r1 = r55
            r21 = r76
            r22 = r77
            r23 = r78
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23)
            r0 = r24
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r53
            r1.updateScope(r0)
        L_0x0449:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m1496TextfLXpl1I(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0460  */
    /* JADX WARNING: Removed duplicated region for block: B:256:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0136  */
    /* renamed from: Text--4IGK_g  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1495Text4IGK_g(androidx.compose.ui.text.AnnotatedString r59, androidx.compose.ui.Modifier r60, long r61, long r63, androidx.compose.ui.text.font.FontStyle r65, androidx.compose.ui.text.font.FontWeight r66, androidx.compose.ui.text.font.FontFamily r67, long r68, androidx.compose.ui.text.style.TextDecoration r70, androidx.compose.ui.text.style.TextAlign r71, long r72, int r74, boolean r75, int r76, java.util.Map<java.lang.String, androidx.compose.foundation.text.InlineTextContent> r77, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r78, androidx.compose.ui.text.TextStyle r79, androidx.compose.runtime.Composer r80, int r81, int r82, int r83) {
        /*
            r1 = r59
            r14 = r81
            r15 = r82
            r13 = r83
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = -422393234(0xffffffffe6d2ca6e, float:-4.9771557E23)
            r2 = r80
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12,8)210@10653L7,232@11410L167:Text.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = r13 & 1
            if (r2 == 0) goto L_0x0023
            r2 = r14 | 6
            goto L_0x0033
        L_0x0023:
            r2 = r14 & 14
            if (r2 != 0) goto L_0x0032
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x002f
            r2 = 4
            goto L_0x0030
        L_0x002f:
            r2 = 2
        L_0x0030:
            r2 = r2 | r14
            goto L_0x0033
        L_0x0032:
            r2 = r14
        L_0x0033:
            r5 = r13 & 2
            if (r5 == 0) goto L_0x003a
            r2 = r2 | 48
            goto L_0x004d
        L_0x003a:
            r8 = r14 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x004d
            r8 = r60
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0049
            r9 = 32
            goto L_0x004b
        L_0x0049:
            r9 = 16
        L_0x004b:
            r2 = r2 | r9
            goto L_0x004f
        L_0x004d:
            r8 = r60
        L_0x004f:
            r9 = r13 & 4
            if (r9 == 0) goto L_0x0058
            r2 = r2 | 384(0x180, float:5.38E-43)
            r3 = r61
            goto L_0x006b
        L_0x0058:
            r12 = r14 & 896(0x380, float:1.256E-42)
            r3 = r61
            if (r12 != 0) goto L_0x006b
            boolean r16 = r0.changed((long) r3)
            if (r16 == 0) goto L_0x0067
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0067:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0069:
            r2 = r2 | r16
        L_0x006b:
            r16 = r13 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0078
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r7 = r63
            goto L_0x008b
        L_0x0078:
            r6 = r14 & 7168(0x1c00, float:1.0045E-41)
            r7 = r63
            if (r6 != 0) goto L_0x008b
            boolean r20 = r0.changed((long) r7)
            if (r20 == 0) goto L_0x0087
            r20 = 2048(0x800, float:2.87E-42)
            goto L_0x0089
        L_0x0087:
            r20 = 1024(0x400, float:1.435E-42)
        L_0x0089:
            r2 = r2 | r20
        L_0x008b:
            r20 = r13 & 16
            if (r20 == 0) goto L_0x0094
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            r10 = r65
            goto L_0x00aa
        L_0x0094:
            r22 = 57344(0xe000, float:8.0356E-41)
            r22 = r14 & r22
            r10 = r65
            if (r22 != 0) goto L_0x00aa
            boolean r23 = r0.changed((java.lang.Object) r10)
            if (r23 == 0) goto L_0x00a6
            r23 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a8
        L_0x00a6:
            r23 = 8192(0x2000, float:1.14794E-41)
        L_0x00a8:
            r2 = r2 | r23
        L_0x00aa:
            r23 = r13 & 32
            r24 = 458752(0x70000, float:6.42848E-40)
            r25 = 65536(0x10000, float:9.18355E-41)
            if (r23 == 0) goto L_0x00b9
            r26 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r26
            r11 = r66
            goto L_0x00cc
        L_0x00b9:
            r26 = r14 & r24
            r11 = r66
            if (r26 != 0) goto L_0x00cc
            boolean r27 = r0.changed((java.lang.Object) r11)
            if (r27 == 0) goto L_0x00c8
            r27 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ca
        L_0x00c8:
            r27 = 65536(0x10000, float:9.18355E-41)
        L_0x00ca:
            r2 = r2 | r27
        L_0x00cc:
            r27 = r13 & 64
            r28 = 3670016(0x380000, float:5.142788E-39)
            if (r27 == 0) goto L_0x00d9
            r29 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r29
            r12 = r67
            goto L_0x00ec
        L_0x00d9:
            r29 = r14 & r28
            r12 = r67
            if (r29 != 0) goto L_0x00ec
            boolean r30 = r0.changed((java.lang.Object) r12)
            if (r30 == 0) goto L_0x00e8
            r30 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ea
        L_0x00e8:
            r30 = 524288(0x80000, float:7.34684E-40)
        L_0x00ea:
            r2 = r2 | r30
        L_0x00ec:
            r6 = r13 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x00f7
            r31 = 12582912(0xc00000, float:1.7632415E-38)
            r2 = r2 | r31
            r3 = r68
            goto L_0x010c
        L_0x00f7:
            r31 = 29360128(0x1c00000, float:7.052966E-38)
            r31 = r14 & r31
            r3 = r68
            if (r31 != 0) goto L_0x010c
            boolean r31 = r0.changed((long) r3)
            if (r31 == 0) goto L_0x0108
            r31 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010a
        L_0x0108:
            r31 = 4194304(0x400000, float:5.877472E-39)
        L_0x010a:
            r2 = r2 | r31
        L_0x010c:
            r1 = r13 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0117
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            r2 = r2 | r31
            r3 = r70
            goto L_0x012b
        L_0x0117:
            r31 = 234881024(0xe000000, float:1.5777218E-30)
            r31 = r14 & r31
            r3 = r70
            if (r31 != 0) goto L_0x012b
            boolean r4 = r0.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0128
            r4 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012a
        L_0x0128:
            r4 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012a:
            r2 = r2 | r4
        L_0x012b:
            r4 = r13 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0136
            r31 = 805306368(0x30000000, float:4.656613E-10)
            r2 = r2 | r31
            r3 = r71
            goto L_0x014b
        L_0x0136:
            r31 = 1879048192(0x70000000, float:1.58456325E29)
            r31 = r14 & r31
            r3 = r71
            if (r31 != 0) goto L_0x014b
            boolean r31 = r0.changed((java.lang.Object) r3)
            if (r31 == 0) goto L_0x0147
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0149
        L_0x0147:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0149:
            r2 = r2 | r31
        L_0x014b:
            r3 = r13 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0154
            r29 = r15 | 6
            r7 = r72
            goto L_0x016a
        L_0x0154:
            r31 = r15 & 14
            r7 = r72
            if (r31 != 0) goto L_0x0168
            boolean r31 = r0.changed((long) r7)
            if (r31 == 0) goto L_0x0163
            r29 = 4
            goto L_0x0165
        L_0x0163:
            r29 = 2
        L_0x0165:
            r29 = r15 | r29
            goto L_0x016a
        L_0x0168:
            r29 = r15
        L_0x016a:
            r7 = r13 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x0171
            r29 = r29 | 48
            goto L_0x0187
        L_0x0171:
            r8 = r15 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x0185
            r8 = r74
            boolean r31 = r0.changed((int) r8)
            if (r31 == 0) goto L_0x0180
            r19 = 32
            goto L_0x0182
        L_0x0180:
            r19 = 16
        L_0x0182:
            r29 = r29 | r19
            goto L_0x0187
        L_0x0185:
            r8 = r74
        L_0x0187:
            r8 = r29
            r10 = r13 & 4096(0x1000, float:5.74E-42)
            if (r10 == 0) goto L_0x0190
            r8 = r8 | 384(0x180, float:5.38E-43)
            goto L_0x01a4
        L_0x0190:
            r11 = r15 & 896(0x380, float:1.256E-42)
            if (r11 != 0) goto L_0x01a4
            r11 = r75
            boolean r19 = r0.changed((boolean) r11)
            if (r19 == 0) goto L_0x019f
            r26 = 256(0x100, float:3.59E-43)
            goto L_0x01a1
        L_0x019f:
            r26 = 128(0x80, float:1.794E-43)
        L_0x01a1:
            r8 = r8 | r26
            goto L_0x01a6
        L_0x01a4:
            r11 = r75
        L_0x01a6:
            r11 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r11 == 0) goto L_0x01ad
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            goto L_0x01bf
        L_0x01ad:
            r12 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x01bf
            r12 = r76
            boolean r19 = r0.changed((int) r12)
            if (r19 == 0) goto L_0x01ba
            goto L_0x01bc
        L_0x01ba:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x01bc:
            r8 = r8 | r17
            goto L_0x01c1
        L_0x01bf:
            r12 = r76
        L_0x01c1:
            r12 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r12 == 0) goto L_0x01c7
            r8 = r8 | 8192(0x2000, float:1.14794E-41)
        L_0x01c7:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r13 & r17
            if (r17 == 0) goto L_0x01d3
            r18 = 196608(0x30000, float:2.75506E-40)
            r8 = r8 | r18
            goto L_0x01e9
        L_0x01d3:
            r18 = r15 & r24
            if (r18 != 0) goto L_0x01e9
            r18 = r11
            r11 = r78
            boolean r19 = r0.changed((java.lang.Object) r11)
            if (r19 == 0) goto L_0x01e4
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01e6
        L_0x01e4:
            r19 = 65536(0x10000, float:9.18355E-41)
        L_0x01e6:
            r8 = r8 | r19
            goto L_0x01ed
        L_0x01e9:
            r18 = r11
            r11 = r78
        L_0x01ed:
            r19 = r15 & r28
            if (r19 != 0) goto L_0x0205
            r19 = r13 & r25
            r11 = r79
            if (r19 != 0) goto L_0x0200
            boolean r19 = r0.changed((java.lang.Object) r11)
            if (r19 == 0) goto L_0x0200
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0202
        L_0x0200:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x0202:
            r8 = r8 | r19
            goto L_0x0207
        L_0x0205:
            r11 = r79
        L_0x0207:
            r11 = 16384(0x4000, float:2.2959E-41)
            if (r12 != r11) goto L_0x0249
            r11 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r11 = r11 & r2
            r15 = 306783378(0x12492492, float:6.3469493E-28)
            if (r11 != r15) goto L_0x0249
            r11 = 2995931(0x2db6db, float:4.198194E-39)
            r11 = r11 & r8
            r15 = 599186(0x92492, float:8.39638E-40)
            if (r11 != r15) goto L_0x0249
            boolean r11 = r0.getSkipping()
            if (r11 != 0) goto L_0x0224
            goto L_0x0249
        L_0x0224:
            r0.skipToGroupEnd()
            r2 = r60
            r3 = r61
            r5 = r63
            r7 = r65
            r8 = r66
            r9 = r67
            r10 = r68
            r12 = r70
            r13 = r71
            r14 = r72
            r16 = r74
            r17 = r75
            r18 = r76
            r19 = r77
            r20 = r78
            r21 = r79
            goto L_0x0459
        L_0x0249:
            r0.startDefaults()
            r11 = r14 & 1
            java.lang.String r15 = "C:CompositionLocal.kt#9igjgp"
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            r19 = 1
            if (r11 == 0) goto L_0x0293
            boolean r11 = r0.getDefaultsInvalid()
            if (r11 == 0) goto L_0x025e
            goto L_0x0293
        L_0x025e:
            r0.skipToGroupEnd()
            if (r12 == 0) goto L_0x0267
            r1 = -57345(0xffffffffffff1fff, float:NaN)
            r8 = r8 & r1
        L_0x0267:
            r1 = r13 & r25
            if (r1 == 0) goto L_0x026f
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r8 = r8 & r1
        L_0x026f:
            r5 = r60
            r21 = r61
            r3 = r63
            r11 = r65
            r16 = r66
            r20 = r67
            r26 = r68
            r1 = r70
            r9 = r71
            r6 = r72
            r10 = r75
            r12 = r76
            r17 = r77
            r18 = r78
            r71 = r79
            r23 = r8
            r8 = r74
            goto L_0x034e
        L_0x0293:
            if (r5 == 0) goto L_0x029a
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            goto L_0x029c
        L_0x029a:
            r5 = r60
        L_0x029c:
            if (r9 == 0) goto L_0x02a5
            androidx.compose.ui.graphics.Color$Companion r9 = androidx.compose.ui.graphics.Color.Companion
            long r21 = r9.m1968getUnspecified0d7_KjU()
            goto L_0x02a7
        L_0x02a5:
            r21 = r61
        L_0x02a7:
            if (r16 == 0) goto L_0x02b0
            androidx.compose.ui.unit.TextUnit$Companion r9 = androidx.compose.ui.unit.TextUnit.Companion
            long r29 = r9.m4896getUnspecifiedXSAIIZE()
            goto L_0x02b2
        L_0x02b0:
            r29 = r63
        L_0x02b2:
            r9 = 0
            if (r20 == 0) goto L_0x02b7
            r11 = r9
            goto L_0x02b9
        L_0x02b7:
            r11 = r65
        L_0x02b9:
            if (r23 == 0) goto L_0x02be
            r16 = r9
            goto L_0x02c0
        L_0x02be:
            r16 = r66
        L_0x02c0:
            if (r27 == 0) goto L_0x02c5
            r20 = r9
            goto L_0x02c7
        L_0x02c5:
            r20 = r67
        L_0x02c7:
            if (r6 == 0) goto L_0x02d0
            androidx.compose.ui.unit.TextUnit$Companion r6 = androidx.compose.ui.unit.TextUnit.Companion
            long r26 = r6.m4896getUnspecifiedXSAIIZE()
            goto L_0x02d2
        L_0x02d0:
            r26 = r68
        L_0x02d2:
            if (r1 == 0) goto L_0x02d6
            r1 = r9
            goto L_0x02d8
        L_0x02d6:
            r1 = r70
        L_0x02d8:
            if (r4 == 0) goto L_0x02db
            goto L_0x02dd
        L_0x02db:
            r9 = r71
        L_0x02dd:
            if (r3 == 0) goto L_0x02e6
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m4896getUnspecifiedXSAIIZE()
            goto L_0x02e8
        L_0x02e6:
            r3 = r72
        L_0x02e8:
            if (r7 == 0) goto L_0x02f1
            androidx.compose.ui.text.style.TextOverflow$Companion r6 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r6 = r6.m4590getClipgIe3tQ8()
            goto L_0x02f3
        L_0x02f1:
            r6 = r74
        L_0x02f3:
            if (r10 == 0) goto L_0x02f7
            r7 = 1
            goto L_0x02f9
        L_0x02f7:
            r7 = r75
        L_0x02f9:
            if (r18 == 0) goto L_0x02ff
            r10 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0301
        L_0x02ff:
            r10 = r76
        L_0x0301:
            if (r12 == 0) goto L_0x030d
            java.util.Map r12 = kotlin.collections.MapsKt.emptyMap()
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            r8 = r8 & r18
            goto L_0x030f
        L_0x030d:
            r12 = r77
        L_0x030f:
            if (r17 == 0) goto L_0x0316
            androidx.compose.material.TextKt$Text$3 r17 = androidx.compose.material.TextKt$Text$3.INSTANCE
            kotlin.jvm.functions.Function1 r17 = (kotlin.jvm.functions.Function1) r17
            goto L_0x0318
        L_0x0316:
            r17 = r78
        L_0x0318:
            r18 = r13 & r25
            if (r18 == 0) goto L_0x033e
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.text.TextStyle> r18 = LocalTextStyle
            r60 = r1
            r1 = r18
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r14, r15)
            java.lang.Object r1 = r0.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.text.TextStyle r1 = (androidx.compose.ui.text.TextStyle) r1
            r18 = -3670017(0xffffffffffc7ffff, float:NaN)
            r8 = r8 & r18
            r71 = r1
            r23 = r8
            r18 = r17
            r1 = r60
            goto L_0x0346
        L_0x033e:
            r60 = r1
            r71 = r79
            r23 = r8
            r18 = r17
        L_0x0346:
            r8 = r6
            r17 = r12
            r12 = r10
            r10 = r7
            r6 = r3
            r3 = r29
        L_0x034e:
            r0.endDefaults()
            r14 = 1557618192(0x5cd75e10, float:4.84964342E17)
            r0.startReplaceableGroup(r14)
            java.lang.String r14 = "*214@10767L7,214@10806L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r14)
            androidx.compose.ui.graphics.Color$Companion r14 = androidx.compose.ui.graphics.Color.Companion
            long r29 = r14.m1968getUnspecified0d7_KjU()
            int r14 = (r21 > r29 ? 1 : (r21 == r29 ? 0 : -1))
            if (r14 == 0) goto L_0x0368
            r14 = 1
            goto L_0x0369
        L_0x0368:
            r14 = 0
        L_0x0369:
            if (r14 == 0) goto L_0x036e
            r30 = r21
            goto L_0x03cd
        L_0x036e:
            long r29 = r71.m4238getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r14 = androidx.compose.ui.graphics.Color.Companion
            long r31 = r14.m1968getUnspecified0d7_KjU()
            int r14 = (r29 > r31 ? 1 : (r29 == r31 ? 0 : -1))
            if (r14 == 0) goto L_0x037d
            goto L_0x037f
        L_0x037d:
            r19 = 0
        L_0x037f:
            if (r19 == 0) goto L_0x0382
            goto L_0x03cb
        L_0x0382:
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r15)
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.graphics.Color r14 = (androidx.compose.ui.graphics.Color) r14
            long r29 = r14.m1942unboximpl()
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r15)
            java.lang.Object r13 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            java.lang.Number r13 = (java.lang.Number) r13
            float r13 = r13.floatValue()
            r14 = 0
            r15 = 0
            r19 = 0
            r25 = 14
            r31 = 0
            r60 = r29
            r62 = r13
            r63 = r14
            r64 = r15
            r65 = r19
            r66 = r25
            r67 = r31
            long r29 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r60, r62, r63, r64, r65, r66, r67)
        L_0x03cb:
            r30 = r29
        L_0x03cd:
            r0.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r13 = new androidx.compose.ui.text.TextStyle
            r29 = r13
            r36 = 0
            r38 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r47 = 0
            r49 = 0
            r52 = 0
            r53 = 175952(0x2af50, float:2.46561E-40)
            r54 = 0
            r32 = r3
            r34 = r16
            r35 = r11
            r37 = r20
            r39 = r26
            r46 = r1
            r48 = r9
            r50 = r6
            r29.<init>((long) r30, (long) r32, (androidx.compose.ui.text.font.FontWeight) r34, (androidx.compose.ui.text.font.FontStyle) r35, (androidx.compose.ui.text.font.FontSynthesis) r36, (androidx.compose.ui.text.font.FontFamily) r37, (java.lang.String) r38, (long) r39, (androidx.compose.ui.text.style.BaselineShift) r41, (androidx.compose.ui.text.style.TextGeometricTransform) r42, (androidx.compose.ui.text.intl.LocaleList) r43, (long) r44, (androidx.compose.ui.text.style.TextDecoration) r46, (androidx.compose.ui.graphics.Shadow) r47, (androidx.compose.ui.text.style.TextAlign) r48, (androidx.compose.ui.text.style.TextDirection) r49, (long) r50, (androidx.compose.ui.text.style.TextIndent) r52, (int) r53, (kotlin.jvm.internal.DefaultConstructorMarker) r54)
            r14 = r71
            androidx.compose.ui.text.TextStyle r13 = r14.merge((androidx.compose.ui.text.TextStyle) r13)
            r15 = 16777216(0x1000000, float:2.3509887E-38)
            r19 = r2 & 14
            r15 = r19 | r15
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | r15
            int r15 = r23 >> 6
            r15 = r15 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r15
            r15 = 57344(0xe000, float:8.0356E-41)
            int r19 = r23 << 9
            r15 = r19 & r15
            r2 = r2 | r15
            r15 = r19 & r24
            r2 = r2 | r15
            r15 = r19 & r28
            r2 = r2 | r15
            r15 = 0
            r60 = r59
            r61 = r5
            r62 = r13
            r63 = r18
            r64 = r8
            r65 = r10
            r66 = r12
            r67 = r17
            r68 = r0
            r69 = r2
            r70 = r15
            androidx.compose.foundation.text.BasicTextKt.m867BasicText4YKlhWE(r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70)
            r2 = r5
            r13 = r9
            r19 = r17
            r9 = r20
            r17 = r10
            r20 = r18
            r18 = r12
            r12 = r1
            r56 = r16
            r16 = r8
            r8 = r56
            r57 = r6
            r7 = r11
            r5 = r3
            r3 = r21
            r10 = r26
            r21 = r14
            r14 = r57
        L_0x0459:
            androidx.compose.runtime.ScopeUpdateScope r1 = r0.endRestartGroup()
            if (r1 != 0) goto L_0x0460
            goto L_0x047a
        L_0x0460:
            androidx.compose.material.TextKt$Text$4 r25 = new androidx.compose.material.TextKt$Text$4
            r0 = r25
            r55 = r1
            r1 = r59
            r22 = r81
            r23 = r82
            r24 = r83
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r0 = r25
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r55
            r1.updateScope(r0)
        L_0x047a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m1495Text4IGK_g(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }

    public static final void ProvideTextStyle(TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(textStyle, "value");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(1772272796);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProvideTextStyle)P(1)263@12533L7,264@12558L80:Text.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) textStyle) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) function2) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(LocalTextStyle);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{LocalTextStyle.provides(((TextStyle) consume).merge(textStyle))}, function2, startRestartGroup, (i2 & 112) | 8);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextKt$ProvideTextStyle$1(textStyle, function2, i));
        }
    }
}
