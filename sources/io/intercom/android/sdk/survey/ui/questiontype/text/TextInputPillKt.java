package io.intercom.android.sdk.survey.ui.questiontype.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.survey.ui.ThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001aÉ\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0019\b\u0002\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\r2\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a\r\u0010\u001e\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u001f\u001a\r\u0010 \u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u001f\u001a\r\u0010!\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u001f\u001a\r\u0010\"\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u001f\u001a\r\u0010#\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u001f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006$"}, d2 = {"TextInputPill", "", "text", "", "placeholderText", "onTextChanged", "Lkotlin/Function1;", "strokeColor", "Landroidx/compose/ui/graphics/Color;", "cursorColor", "maxLines", "", "singleLine", "", "onImeActionNext", "Landroidx/compose/foundation/text/KeyboardActionScope;", "Lkotlin/ExtensionFunctionType;", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "showTrailingIcon", "leadingIcon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "enabled", "minHeight", "Landroidx/compose/ui/unit/Dp;", "TextInputPill-g5ZjG94", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Color;JIZLkotlin/jvm/functions/Function1;IIZLkotlin/jvm/functions/Function2;ZFLandroidx/compose/runtime/Composer;III)V", "TextInputPillDisabled", "(Landroidx/compose/runtime/Composer;I)V", "TextInputPillError", "TextInputPillPlaceholder", "TextInputPillUnchecked", "TextInputPillValidated", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextInputPill.kt */
public final class TextInputPillKt {
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x04f5  */
    /* JADX WARNING: Removed duplicated region for block: B:222:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x012d  */
    /* renamed from: TextInputPill-g5ZjG94  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5354TextInputPillg5ZjG94(java.lang.String r76, java.lang.String r77, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r78, androidx.compose.ui.graphics.Color r79, long r80, int r82, boolean r83, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.text.KeyboardActionScope, kotlin.Unit> r84, int r85, int r86, boolean r87, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r88, boolean r89, float r90, androidx.compose.runtime.Composer r91, int r92, int r93, int r94) {
        /*
            r15 = r78
            r14 = r92
            r8 = r93
            r3 = r94
            java.lang.String r0 = "onTextChanged"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = -1682278702(0xffffffff9bba76d2, float:-3.0847905E-22)
            r1 = r91
            androidx.compose.runtime.Composer r2 = r1.startRestartGroup(r0)
            r0 = r3 & 1
            if (r0 == 0) goto L_0x0020
            r5 = r14 | 6
            r6 = r5
            r5 = r76
            goto L_0x0034
        L_0x0020:
            r5 = r14 & 14
            if (r5 != 0) goto L_0x0031
            r5 = r76
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x002e
            r6 = 4
            goto L_0x002f
        L_0x002e:
            r6 = 2
        L_0x002f:
            r6 = r6 | r14
            goto L_0x0034
        L_0x0031:
            r5 = r76
            r6 = r14
        L_0x0034:
            r7 = r3 & 2
            if (r7 == 0) goto L_0x003b
            r6 = r6 | 48
            goto L_0x004e
        L_0x003b:
            r11 = r14 & 112(0x70, float:1.57E-43)
            if (r11 != 0) goto L_0x004e
            r11 = r77
            boolean r12 = r2.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x004a
            r12 = 32
            goto L_0x004c
        L_0x004a:
            r12 = 16
        L_0x004c:
            r6 = r6 | r12
            goto L_0x0050
        L_0x004e:
            r11 = r77
        L_0x0050:
            r12 = r3 & 4
            r16 = 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x0059
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x0069
        L_0x0059:
            r12 = r14 & 896(0x380, float:1.256E-42)
            if (r12 != 0) goto L_0x0069
            boolean r12 = r2.changed((java.lang.Object) r15)
            if (r12 == 0) goto L_0x0066
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r12 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r6 = r6 | r12
        L_0x0069:
            r12 = r3 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0074
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x0088
        L_0x0074:
            r1 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r1 != 0) goto L_0x0088
            r1 = r79
            boolean r19 = r2.changed((java.lang.Object) r1)
            if (r19 == 0) goto L_0x0083
            r19 = 2048(0x800, float:2.87E-42)
            goto L_0x0085
        L_0x0083:
            r19 = 1024(0x400, float:1.435E-42)
        L_0x0085:
            r6 = r6 | r19
            goto L_0x008a
        L_0x0088:
            r1 = r79
        L_0x008a:
            r19 = r3 & 16
            r64 = 57344(0xe000, float:8.0356E-41)
            if (r19 == 0) goto L_0x0096
            r6 = r6 | 24576(0x6000, float:3.4438E-41)
            r10 = r80
            goto L_0x00a9
        L_0x0096:
            r19 = r14 & r64
            r10 = r80
            if (r19 != 0) goto L_0x00a9
            boolean r20 = r2.changed((long) r10)
            if (r20 == 0) goto L_0x00a5
            r20 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a7
        L_0x00a5:
            r20 = 8192(0x2000, float:1.14794E-41)
        L_0x00a7:
            r6 = r6 | r20
        L_0x00a9:
            r20 = r3 & 32
            r65 = 458752(0x70000, float:6.42848E-40)
            if (r20 == 0) goto L_0x00b6
            r21 = 196608(0x30000, float:2.75506E-40)
            r6 = r6 | r21
            r4 = r82
            goto L_0x00c9
        L_0x00b6:
            r21 = r14 & r65
            r4 = r82
            if (r21 != 0) goto L_0x00c9
            boolean r22 = r2.changed((int) r4)
            if (r22 == 0) goto L_0x00c5
            r22 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c7
        L_0x00c5:
            r22 = 65536(0x10000, float:9.18355E-41)
        L_0x00c7:
            r6 = r6 | r22
        L_0x00c9:
            r22 = r3 & 64
            if (r22 == 0) goto L_0x00d4
            r23 = 1572864(0x180000, float:2.204052E-39)
            r6 = r6 | r23
            r9 = r83
            goto L_0x00e9
        L_0x00d4:
            r23 = 3670016(0x380000, float:5.142788E-39)
            r23 = r14 & r23
            r9 = r83
            if (r23 != 0) goto L_0x00e9
            boolean r24 = r2.changed((boolean) r9)
            if (r24 == 0) goto L_0x00e5
            r24 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e7
        L_0x00e5:
            r24 = 524288(0x80000, float:7.34684E-40)
        L_0x00e7:
            r6 = r6 | r24
        L_0x00e9:
            r13 = r3 & 128(0x80, float:1.794E-43)
            if (r13 == 0) goto L_0x00f4
            r25 = 12582912(0xc00000, float:1.7632415E-38)
            r6 = r6 | r25
            r1 = r84
            goto L_0x0109
        L_0x00f4:
            r25 = 29360128(0x1c00000, float:7.052966E-38)
            r25 = r14 & r25
            r1 = r84
            if (r25 != 0) goto L_0x0109
            boolean r25 = r2.changed((java.lang.Object) r1)
            if (r25 == 0) goto L_0x0105
            r25 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0107
        L_0x0105:
            r25 = 4194304(0x400000, float:5.877472E-39)
        L_0x0107:
            r6 = r6 | r25
        L_0x0109:
            r25 = 234881024(0xe000000, float:1.5777218E-30)
            r25 = r14 & r25
            if (r25 != 0) goto L_0x0125
            r1 = r3 & 256(0x100, float:3.59E-43)
            if (r1 != 0) goto L_0x011e
            r1 = r85
            boolean r25 = r2.changed((int) r1)
            if (r25 == 0) goto L_0x0120
            r25 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0122
        L_0x011e:
            r1 = r85
        L_0x0120:
            r25 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0122:
            r6 = r6 | r25
            goto L_0x0127
        L_0x0125:
            r1 = r85
        L_0x0127:
            r25 = 1879048192(0x70000000, float:1.58456325E29)
            r25 = r14 & r25
            if (r25 != 0) goto L_0x0143
            r1 = r3 & 512(0x200, float:7.175E-43)
            if (r1 != 0) goto L_0x013c
            r1 = r86
            boolean r25 = r2.changed((int) r1)
            if (r25 == 0) goto L_0x013e
            r25 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0140
        L_0x013c:
            r1 = r86
        L_0x013e:
            r25 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0140:
            r6 = r6 | r25
            goto L_0x0145
        L_0x0143:
            r1 = r86
        L_0x0145:
            r1 = r3 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x014e
            r21 = r8 | 6
            r4 = r87
            goto L_0x0164
        L_0x014e:
            r25 = r8 & 14
            r4 = r87
            if (r25 != 0) goto L_0x0162
            boolean r25 = r2.changed((boolean) r4)
            if (r25 == 0) goto L_0x015d
            r21 = 4
            goto L_0x015f
        L_0x015d:
            r21 = 2
        L_0x015f:
            r21 = r8 | r21
            goto L_0x0164
        L_0x0162:
            r21 = r8
        L_0x0164:
            r4 = r3 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x016b
            r21 = r21 | 48
            goto L_0x017e
        L_0x016b:
            r25 = r8 & 112(0x70, float:1.57E-43)
            r5 = r88
            if (r25 != 0) goto L_0x017e
            boolean r25 = r2.changed((java.lang.Object) r5)
            if (r25 == 0) goto L_0x017a
            r19 = 32
            goto L_0x017c
        L_0x017a:
            r19 = 16
        L_0x017c:
            r21 = r21 | r19
        L_0x017e:
            r5 = r21
            r9 = r3 & 4096(0x1000, float:5.74E-42)
            if (r9 == 0) goto L_0x0187
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0199
        L_0x0187:
            r10 = r8 & 896(0x380, float:1.256E-42)
            if (r10 != 0) goto L_0x0199
            r10 = r89
            boolean r11 = r2.changed((boolean) r10)
            if (r11 == 0) goto L_0x0194
            goto L_0x0196
        L_0x0194:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0196:
            r5 = r5 | r16
            goto L_0x019b
        L_0x0199:
            r10 = r89
        L_0x019b:
            r11 = r3 & 8192(0x2000, float:1.14794E-41)
            if (r11 == 0) goto L_0x01a2
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x01b4
        L_0x01a2:
            r10 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x01b4
            r10 = r90
            boolean r16 = r2.changed((float) r10)
            if (r16 == 0) goto L_0x01af
            goto L_0x01b1
        L_0x01af:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x01b1:
            r5 = r5 | r17
            goto L_0x01b6
        L_0x01b4:
            r10 = r90
        L_0x01b6:
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r8 = r6 & r16
            r10 = 306783378(0x12492492, float:6.3469493E-28)
            if (r8 != r10) goto L_0x01ec
            r8 = r5 & 5851(0x16db, float:8.199E-42)
            r10 = 1170(0x492, float:1.64E-42)
            if (r8 != r10) goto L_0x01ec
            boolean r8 = r2.getSkipping()
            if (r8 != 0) goto L_0x01cd
            goto L_0x01ec
        L_0x01cd:
            r2.skipToGroupEnd()
            r1 = r76
            r4 = r79
            r7 = r82
            r8 = r83
            r9 = r84
            r10 = r85
            r11 = r86
            r12 = r87
            r13 = r88
            r14 = r89
            r15 = r90
            r25 = r2
            r2 = r77
            goto L_0x04ee
        L_0x01ec:
            r2.startDefaults()
            r8 = r14 & 1
            if (r8 == 0) goto L_0x0228
            boolean r8 = r2.getDefaultsInvalid()
            if (r8 == 0) goto L_0x01fa
            goto L_0x0228
        L_0x01fa:
            r2.skipToGroupEnd()
            r0 = r3 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0205
            r0 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r6 = r6 & r0
        L_0x0205:
            r0 = r3 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x020d
            r0 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r6 = r6 & r0
        L_0x020d:
            r66 = r76
            r8 = r77
            r67 = r79
            r68 = r82
            r69 = r83
            r70 = r84
            r71 = r85
            r72 = r86
            r1 = r87
            r73 = r88
            r74 = r89
            r0 = r90
            r11 = r6
            goto L_0x02bf
        L_0x0228:
            if (r0 == 0) goto L_0x022d
            java.lang.String r0 = ""
            goto L_0x022f
        L_0x022d:
            r0 = r76
        L_0x022f:
            if (r7 == 0) goto L_0x0234
            java.lang.String r7 = ""
            goto L_0x0236
        L_0x0234:
            r7 = r77
        L_0x0236:
            if (r12 == 0) goto L_0x023a
            r8 = 0
            goto L_0x023c
        L_0x023a:
            r8 = r79
        L_0x023c:
            if (r20 == 0) goto L_0x0242
            r12 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0244
        L_0x0242:
            r12 = r82
        L_0x0244:
            if (r22 == 0) goto L_0x0249
            r16 = 0
            goto L_0x024b
        L_0x0249:
            r16 = r83
        L_0x024b:
            if (r13 == 0) goto L_0x0252
            io.intercom.android.sdk.survey.ui.questiontype.text.TextInputPillKt$TextInputPill$1 r13 = io.intercom.android.sdk.survey.ui.questiontype.text.TextInputPillKt$TextInputPill$1.INSTANCE
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            goto L_0x0254
        L_0x0252:
            r13 = r84
        L_0x0254:
            r10 = r3 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0264
            androidx.compose.ui.text.input.KeyboardType$Companion r10 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r10 = r10.m4415getTextPjHm6EE()
            r17 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r6 = r6 & r17
            goto L_0x0266
        L_0x0264:
            r10 = r85
        L_0x0266:
            r76 = r0
            r0 = r3 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0278
            androidx.compose.ui.text.input.ImeAction$Companion r0 = androidx.compose.ui.text.input.ImeAction.Companion
            int r0 = r0.m4375getDefaulteUduSuo()
            r17 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r6 = r6 & r17
            goto L_0x027a
        L_0x0278:
            r0 = r86
        L_0x027a:
            if (r1 == 0) goto L_0x027e
            r1 = 0
            goto L_0x0280
        L_0x027e:
            r1 = r87
        L_0x0280:
            if (r4 == 0) goto L_0x0284
            r4 = 0
            goto L_0x0286
        L_0x0284:
            r4 = r88
        L_0x0286:
            if (r9 == 0) goto L_0x028a
            r9 = 1
            goto L_0x028c
        L_0x028a:
            r9 = r89
        L_0x028c:
            if (r11 == 0) goto L_0x02a9
            androidx.compose.ui.unit.Dp$Companion r11 = androidx.compose.ui.unit.Dp.Companion
            float r11 = r11.m4724getUnspecifiedD9Ej5fM()
            r66 = r76
            r72 = r0
            r73 = r4
            r67 = r8
            r74 = r9
            r71 = r10
            r0 = r11
            r68 = r12
            r70 = r13
            r69 = r16
            r11 = r6
            goto L_0x02be
        L_0x02a9:
            r66 = r76
            r72 = r0
            r73 = r4
            r11 = r6
            r67 = r8
            r74 = r9
            r71 = r10
            r68 = r12
            r70 = r13
            r69 = r16
            r0 = r90
        L_0x02be:
            r8 = r7
        L_0x02bf:
            r2.endDefaults()
            r4 = -1960698368(0xffffffff8b221e00, float:-3.1222635E-32)
            r2.startReplaceableGroup(r4)
            r4 = 8
            if (r67 != 0) goto L_0x02f3
            androidx.compose.material.MaterialTheme r6 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r6 = r6.getColors(r2, r4)
            long r6 = r6.m1213getOnSurface0d7_KjU()
            r9 = 1036831949(0x3dcccccd, float:0.1)
            r10 = 0
            r12 = 0
            r13 = 0
            r16 = 14
            r17 = 0
            r82 = r6
            r84 = r9
            r85 = r10
            r86 = r12
            r87 = r13
            r88 = r16
            r89 = r17
            long r6 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r82, r84, r85, r86, r87, r88, r89)
            goto L_0x02f7
        L_0x02f3:
            long r6 = r67.m1942unboximpl()
        L_0x02f7:
            r2.endReplaceableGroup()
            r9 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r2.startReplaceableGroup(r9)
            java.lang.String r9 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r9)
            java.lang.Object r9 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r9 != r10) goto L_0x0318
            androidx.compose.foundation.relocation.BringIntoViewRequester r9 = androidx.compose.foundation.relocation.BringIntoViewRequesterKt.BringIntoViewRequester()
            r2.updateRememberedValue(r9)
        L_0x0318:
            r2.endReplaceableGroup()
            androidx.compose.foundation.relocation.BringIntoViewRequester r9 = (androidx.compose.foundation.relocation.BringIntoViewRequester) r9
            r10 = 773894976(0x2e20b340, float:3.6538994E-11)
            r2.startReplaceableGroup(r10)
            java.lang.String r10 = "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r10)
            r10 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r2.startReplaceableGroup(r10)
            java.lang.String r10 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r10)
            java.lang.Object r10 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r10 != r12) goto L_0x0350
            kotlin.coroutines.EmptyCoroutineContext r10 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10
            kotlinx.coroutines.CoroutineScope r10 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r10, r2)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r12 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r12.<init>(r10)
            r2.updateRememberedValue(r12)
            r10 = r12
        L_0x0350:
            r2.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r10 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r10
            kotlinx.coroutines.CoroutineScope r10 = r10.getCoroutineScope()
            r2.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r12 = (androidx.compose.ui.Modifier) r12
            r13 = 0
            r3 = 1
            r4 = 0
            androidx.compose.ui.Modifier r12 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r12, r13, r3, r4)
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.m567defaultMinSizeVpY3zN4$default(r12, r13, r0, r3, r4)
            float r12 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r12)
            androidx.compose.material.MaterialTheme r12 = androidx.compose.material.MaterialTheme.INSTANCE
            r13 = 8
            androidx.compose.material.Shapes r12 = r12.getShapes(r2, r13)
            androidx.compose.foundation.shape.CornerBasedShape r12 = r12.getMedium()
            androidx.compose.ui.graphics.Shape r12 = (androidx.compose.ui.graphics.Shape) r12
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.BorderKt.m182borderxT4_qwU(r4, r3, r6, r12)
            androidx.compose.material.MaterialTheme r4 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r4 = r4.getShapes(r2, r13)
            androidx.compose.foundation.shape.CornerBasedShape r4 = r4.getMedium()
            androidx.compose.ui.graphics.Shape r4 = (androidx.compose.ui.graphics.Shape) r4
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.draw.ClipKt.clip(r3, r4)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.relocation.BringIntoViewRequesterKt.bringIntoViewRequester(r3, r9)
            io.intercom.android.sdk.survey.ui.questiontype.text.TextInputPillKt$TextInputPill$2 r4 = new io.intercom.android.sdk.survey.ui.questiontype.text.TextInputPillKt$TextInputPill$2
            r4.<init>(r10, r9)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.focus.FocusEventModifierKt.onFocusEvent(r3, r4)
            androidx.compose.material.TextFieldDefaults r16 = androidx.compose.material.TextFieldDefaults.INSTANCE
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.Companion
            long r27 = r4.m1967getTransparent0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.Companion
            long r29 = r4.m1967getTransparent0d7_KjU()
            r4 = -1960697141(0xffffffff8b2222cb, float:-3.122624E-32)
            r2.startReplaceableGroup(r4)
            if (r74 == 0) goto L_0x03c4
            androidx.compose.material.MaterialTheme r4 = androidx.compose.material.MaterialTheme.INSTANCE
            r6 = 8
            androidx.compose.material.Colors r4 = r4.getColors(r2, r6)
            long r6 = r4.m1218getSurface0d7_KjU()
            goto L_0x03cd
        L_0x03c4:
            r6 = 4294638330(0xfffafafa, double:2.12183326E-314)
            long r6 = androidx.compose.ui.graphics.ColorKt.Color((long) r6)
        L_0x03cd:
            r21 = r6
            r2.endReplaceableGroup()
            r6 = 4285756278(0xff737376, double:2.1174449434E-314)
            long r19 = androidx.compose.ui.graphics.ColorKt.Color((long) r6)
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.Companion
            long r31 = r4.m1967getTransparent0d7_KjU()
            r17 = 0
            r25 = 0
            r33 = 0
            r35 = 0
            r37 = 0
            r39 = 0
            r41 = 0
            r43 = 0
            r45 = 0
            r47 = 0
            r49 = 0
            r51 = 0
            r53 = 0
            r55 = 0
            r57 = 0
            r4 = 14352432(0xdb0030, float:2.0112041E-38)
            int r10 = r11 >> 3
            r6 = r10 & 7168(0x1c00, float:1.0045E-41)
            r60 = r6 | r4
            r61 = 0
            r62 = 48
            r63 = 2096913(0x1fff11, float:2.938401E-39)
            r23 = r80
            r59 = r2
            androidx.compose.material.TextFieldColors r18 = r16.m1475textFieldColorsdx8h9Zs(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r60, r61, r62, r63)
            androidx.compose.foundation.text.KeyboardOptions r4 = new androidx.compose.foundation.text.KeyboardOptions
            r12 = r4
            r6 = 0
            r7 = 0
            r9 = 3
            r13 = 0
            r82 = r4
            r83 = r6
            r84 = r7
            r85 = r71
            r86 = r72
            r87 = r9
            r88 = r13
            r82.<init>(r83, r84, r85, r86, r87, r88)
            androidx.compose.foundation.text.KeyboardActions r4 = new androidx.compose.foundation.text.KeyboardActions
            r13 = r4
            r6 = 0
            r7 = 0
            r9 = 0
            r16 = 0
            r17 = 0
            r19 = 59
            r20 = 0
            r82 = r4
            r83 = r6
            r84 = r7
            r85 = r70
            r86 = r9
            r87 = r16
            r88 = r17
            r89 = r19
            r90 = r20
            r82.<init>(r83, r84, r85, r86, r87, r88, r89, r90)
            androidx.compose.material.MaterialTheme r4 = androidx.compose.material.MaterialTheme.INSTANCE
            r6 = 8
            androidx.compose.material.Shapes r4 = r4.getShapes(r2, r6)
            androidx.compose.foundation.shape.CornerBasedShape r17 = r4.getMedium()
            androidx.compose.material.MaterialTheme r4 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Typography r4 = r4.getTypography(r2, r6)
            androidx.compose.ui.text.TextStyle r4 = r4.getBody2()
            r19 = r5
            r5 = r4
            r4 = 0
            r6 = 0
            r7 = 818000439(0x30c1b237, float:1.409325E-9)
            io.intercom.android.sdk.survey.ui.questiontype.text.TextInputPillKt$TextInputPill$3 r9 = new io.intercom.android.sdk.survey.ui.questiontype.text.TextInputPillKt$TextInputPill$3
            r9.<init>(r8, r11)
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r7, r4, r9)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r9 = -1623457351(0xffffffff9f3c01b9, float:-3.9811973E-20)
            io.intercom.android.sdk.survey.ui.questiontype.text.TextInputPillKt$TextInputPill$4 r6 = new io.intercom.android.sdk.survey.ui.questiontype.text.TextInputPillKt$TextInputPill$4
            r6.<init>(r1)
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r9, r4, r6)
            r9 = r4
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r4 = 0
            r6 = r10
            r10 = r4
            r4 = 0
            r21 = r11
            r11 = r4
            androidx.compose.ui.graphics.Shape r17 = (androidx.compose.ui.graphics.Shape) r17
            r4 = 817889280(0x30c00000, float:1.3969839E-9)
            r20 = r21 & 14
            r4 = r20 | r4
            r6 = r6 & 112(0x70, float:1.57E-43)
            r4 = r4 | r6
            int r6 = r19 << 3
            r6 = r6 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r6
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            int r19 = r19 << 21
            r6 = r19 & r6
            r20 = r4 | r6
            int r4 = androidx.compose.foundation.text.KeyboardActions.$stable
            int r4 = r4 << 9
            int r6 = r21 >> 6
            r6 = r6 & r64
            r4 = r4 | r6
            r6 = r21 & r65
            r21 = r4 | r6
            r22 = 68688(0x10c50, float:9.6252E-41)
            r23 = r0
            r0 = r66
            r24 = r1
            r1 = r78
            r25 = r2
            r2 = r3
            r3 = r74
            r26 = r8
            r8 = r73
            r14 = r69
            r15 = r68
            r19 = r25
            r4 = 0
            r6 = 0
            androidx.compose.material.TextFieldKt.TextField((java.lang.String) r0, (kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (boolean) r4, (androidx.compose.ui.text.TextStyle) r5, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r6, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r7, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r8, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r9, (boolean) r10, (androidx.compose.ui.text.input.VisualTransformation) r11, (androidx.compose.foundation.text.KeyboardOptions) r12, (androidx.compose.foundation.text.KeyboardActions) r13, (boolean) r14, (int) r15, (androidx.compose.foundation.interaction.MutableInteractionSource) r16, (androidx.compose.ui.graphics.Shape) r17, (androidx.compose.material.TextFieldColors) r18, (androidx.compose.runtime.Composer) r19, (int) r20, (int) r21, (int) r22)
            r15 = r23
            r12 = r24
            r2 = r26
            r1 = r66
            r4 = r67
            r7 = r68
            r8 = r69
            r9 = r70
            r10 = r71
            r11 = r72
            r13 = r73
            r14 = r74
        L_0x04ee:
            androidx.compose.runtime.ScopeUpdateScope r5 = r25.endRestartGroup()
            if (r5 != 0) goto L_0x04f5
            goto L_0x0511
        L_0x04f5:
            io.intercom.android.sdk.survey.ui.questiontype.text.TextInputPillKt$TextInputPill$5 r19 = new io.intercom.android.sdk.survey.ui.questiontype.text.TextInputPillKt$TextInputPill$5
            r0 = r19
            r3 = r78
            r75 = r5
            r5 = r80
            r16 = r92
            r17 = r93
            r18 = r94
            r0.<init>(r1, r2, r3, r4, r5, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0 = r19
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r75
            r1.updateScope(r0)
        L_0x0511:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.ui.questiontype.text.TextInputPillKt.m5354TextInputPillg5ZjG94(java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.graphics.Color, long, int, boolean, kotlin.jvm.functions.Function1, int, int, boolean, kotlin.jvm.functions.Function2, boolean, float, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final void TextInputPillPlaceholder(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1437391364);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            ThemeKt.IntercomSurveyTheme(false, ComposableSingletons$TextInputPillKt.INSTANCE.m5349getLambda1$intercom_sdk_base_release(), startRestartGroup, 48, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextInputPillKt$TextInputPillPlaceholder$1(i));
        }
    }

    public static final void TextInputPillUnchecked(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-869352961);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            ThemeKt.IntercomSurveyTheme(false, ComposableSingletons$TextInputPillKt.INSTANCE.m5350getLambda2$intercom_sdk_base_release(), startRestartGroup, 48, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextInputPillKt$TextInputPillUnchecked$1(i));
        }
    }

    public static final void TextInputPillValidated(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(559292703);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            ThemeKt.IntercomSurveyTheme(false, ComposableSingletons$TextInputPillKt.INSTANCE.m5351getLambda3$intercom_sdk_base_release(), startRestartGroup, 48, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextInputPillKt$TextInputPillValidated$1(i));
        }
    }

    public static final void TextInputPillError(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-175520743);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            ThemeKt.IntercomSurveyTheme(false, ComposableSingletons$TextInputPillKt.INSTANCE.m5352getLambda4$intercom_sdk_base_release(), startRestartGroup, 48, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextInputPillKt$TextInputPillError$1(i));
        }
    }

    public static final void TextInputPillDisabled(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1100722979);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            ThemeKt.IntercomSurveyTheme(false, ComposableSingletons$TextInputPillKt.INSTANCE.m5353getLambda5$intercom_sdk_base_release(), startRestartGroup, 48, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextInputPillKt$TextInputPillDisabled$1(i));
        }
    }
}
