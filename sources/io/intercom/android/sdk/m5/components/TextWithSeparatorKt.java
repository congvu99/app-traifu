package io.intercom.android.sdk.m5.components;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"TextWithSeparator", "", "firstText", "", "secondText", "modifier", "Landroidx/compose/ui/Modifier;", "separator", "style", "Landroidx/compose/ui/text/TextStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "", "TextWithSeparator-ljD6DUQ", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;JIILandroidx/compose/runtime/Composer;II)V", "TextWithSeparatorEmptyPreview", "(Landroidx/compose/runtime/Composer;I)V", "TextWithSeparatorPreview", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextWithSeparator.kt */
public final class TextWithSeparatorKt {
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x011c  */
    /* renamed from: TextWithSeparator-ljD6DUQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5179TextWithSeparatorljD6DUQ(java.lang.String r38, java.lang.String r39, androidx.compose.ui.Modifier r40, java.lang.String r41, androidx.compose.ui.text.TextStyle r42, long r43, int r45, int r46, androidx.compose.runtime.Composer r47, int r48, int r49) {
        /*
            r1 = r38
            r2 = r39
            r10 = r48
            r11 = r49
            java.lang.String r0 = "firstText"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "secondText"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r0 = 711254559(0x2a64e21f, float:2.032892E-13)
            r3 = r47
            androidx.compose.runtime.Composer r0 = r3.startRestartGroup(r0)
            r3 = r11 & 1
            if (r3 == 0) goto L_0x0022
            r3 = r10 | 6
            goto L_0x0032
        L_0x0022:
            r3 = r10 & 14
            if (r3 != 0) goto L_0x0031
            boolean r3 = r0.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x002e
            r3 = 4
            goto L_0x002f
        L_0x002e:
            r3 = 2
        L_0x002f:
            r3 = r3 | r10
            goto L_0x0032
        L_0x0031:
            r3 = r10
        L_0x0032:
            r4 = r11 & 2
            if (r4 == 0) goto L_0x0039
            r3 = r3 | 48
            goto L_0x0049
        L_0x0039:
            r4 = r10 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0049
            boolean r4 = r0.changed((java.lang.Object) r2)
            if (r4 == 0) goto L_0x0046
            r4 = 32
            goto L_0x0048
        L_0x0046:
            r4 = 16
        L_0x0048:
            r3 = r3 | r4
        L_0x0049:
            r4 = r11 & 4
            if (r4 == 0) goto L_0x0050
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r6 = r10 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0063
            r6 = r40
            boolean r7 = r0.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x005f
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r3 = r3 | r7
            goto L_0x0065
        L_0x0063:
            r6 = r40
        L_0x0065:
            r7 = r11 & 8
            if (r7 == 0) goto L_0x006c
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r8 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x007f
            r8 = r41
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x007b
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r3 = r3 | r9
            goto L_0x0081
        L_0x007f:
            r8 = r41
        L_0x0081:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r10
            if (r9 != 0) goto L_0x009c
            r9 = r11 & 16
            if (r9 != 0) goto L_0x0096
            r9 = r42
            boolean r12 = r0.changed((java.lang.Object) r9)
            if (r12 == 0) goto L_0x0098
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0096:
            r9 = r42
        L_0x0098:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r3 = r3 | r12
            goto L_0x009e
        L_0x009c:
            r9 = r42
        L_0x009e:
            r12 = r11 & 32
            r14 = 458752(0x70000, float:6.42848E-40)
            if (r12 == 0) goto L_0x00aa
            r13 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r13
            r14 = r43
            goto L_0x00bc
        L_0x00aa:
            r13 = r10 & r14
            r14 = r43
            if (r13 != 0) goto L_0x00bc
            boolean r13 = r0.changed((long) r14)
            if (r13 == 0) goto L_0x00b9
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bb
        L_0x00b9:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00bb:
            r3 = r3 | r13
        L_0x00bc:
            r13 = r11 & 64
            if (r13 == 0) goto L_0x00c7
            r16 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r16
            r5 = r45
            goto L_0x00dc
        L_0x00c7:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r10 & r16
            r5 = r45
            if (r16 != 0) goto L_0x00dc
            boolean r17 = r0.changed((int) r5)
            if (r17 == 0) goto L_0x00d8
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00da
        L_0x00d8:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00da:
            r3 = r3 | r17
        L_0x00dc:
            r5 = r11 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x00e7
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r17
            r6 = r46
            goto L_0x00fc
        L_0x00e7:
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r10 & r17
            r6 = r46
            if (r17 != 0) goto L_0x00fc
            boolean r17 = r0.changed((int) r6)
            if (r17 == 0) goto L_0x00f8
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fa
        L_0x00f8:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fa:
            r3 = r3 | r17
        L_0x00fc:
            r17 = 23967451(0x16db6db, float:4.3661218E-38)
            r6 = r3 & r17
            r8 = 4793490(0x492492, float:6.71711E-39)
            if (r6 != r8) goto L_0x011c
            boolean r6 = r0.getSkipping()
            if (r6 != 0) goto L_0x010d
            goto L_0x011c
        L_0x010d:
            r0.skipToGroupEnd()
            r3 = r40
            r4 = r41
            r8 = r45
            r5 = r9
            r6 = r14
            r9 = r46
            goto L_0x023a
        L_0x011c:
            r0.startDefaults()
            r6 = r10 & 1
            r8 = -57345(0xffffffffffff1fff, float:NaN)
            if (r6 == 0) goto L_0x0141
            boolean r6 = r0.getDefaultsInvalid()
            if (r6 == 0) goto L_0x012d
            goto L_0x0141
        L_0x012d:
            r0.skipToGroupEnd()
            r4 = r11 & 16
            if (r4 == 0) goto L_0x0135
            r3 = r3 & r8
        L_0x0135:
            r4 = r40
            r6 = r41
            r5 = r46
            r12 = r3
            r7 = r9
            r8 = r14
            r3 = r45
            goto L_0x0187
        L_0x0141:
            if (r4 == 0) goto L_0x0148
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x014a
        L_0x0148:
            r4 = r40
        L_0x014a:
            if (r7 == 0) goto L_0x0150
            java.lang.String r6 = "•"
            goto L_0x0152
        L_0x0150:
            r6 = r41
        L_0x0152:
            r7 = r11 & 16
            if (r7 == 0) goto L_0x0164
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            r9 = 8
            androidx.compose.material.Typography r7 = r7.getTypography(r0, r9)
            androidx.compose.ui.text.TextStyle r7 = r7.getBody1()
            r3 = r3 & r8
            goto L_0x0165
        L_0x0164:
            r7 = r9
        L_0x0165:
            if (r12 == 0) goto L_0x016e
            androidx.compose.ui.graphics.Color$Companion r8 = androidx.compose.ui.graphics.Color.Companion
            long r8 = r8.m1968getUnspecified0d7_KjU()
            goto L_0x016f
        L_0x016e:
            r8 = r14
        L_0x016f:
            if (r13 == 0) goto L_0x0178
            androidx.compose.ui.text.style.TextOverflow$Companion r12 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r12 = r12.m4590getClipgIe3tQ8()
            goto L_0x017a
        L_0x0178:
            r12 = r45
        L_0x017a:
            if (r5 == 0) goto L_0x0180
            r5 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0182
        L_0x0180:
            r5 = r46
        L_0x0182:
            r36 = r12
            r12 = r3
            r3 = r36
        L_0x0187:
            r0.endDefaults()
            r13 = r1
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            boolean r13 = kotlin.text.StringsKt.isBlank(r13)
            r14 = 1
            r13 = r13 ^ r14
            if (r13 == 0) goto L_0x01aa
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r15 = 32
            r13.append(r15)
            r13.append(r6)
            r13.append(r15)
            java.lang.String r13 = r13.toString()
            goto L_0x01ac
        L_0x01aa:
            java.lang.String r13 = ""
        L_0x01ac:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r1)
            r15.append(r13)
            r15.append(r2)
            java.lang.String r15 = r15.toString()
            r13 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r0.startReplaceableGroup(r13)
            java.lang.String r13 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r13)
            boolean r13 = r0.changed((java.lang.Object) r1)
            boolean r16 = r0.changed((java.lang.Object) r2)
            r13 = r13 | r16
            java.lang.Object r14 = r0.rememberedValue()
            if (r13 != 0) goto L_0x01e1
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r14 != r13) goto L_0x01ec
        L_0x01e1:
            io.intercom.android.sdk.m5.components.TextWithSeparatorKt$TextWithSeparator$1$1 r13 = new io.intercom.android.sdk.m5.components.TextWithSeparatorKt$TextWithSeparator$1$1
            r13.<init>(r1, r2)
            r14 = r13
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            r0.updateRememberedValue(r14)
        L_0x01ec:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            r13 = 0
            r1 = 0
            r2 = 1
            androidx.compose.ui.Modifier r13 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r4, r1, r14, r2, r13)
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r28 = 0
            r30 = 0
            int r1 = r12 >> 9
            r1 = r1 & 896(0x380, float:1.256E-42)
            r33 = r1
            int r1 = r12 >> 15
            r1 = r1 & 112(0x70, float:1.57E-43)
            int r2 = r12 >> 12
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r12 << 3
            r12 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r12
            r34 = r1 | r2
            r35 = 22520(0x57f8, float:3.1557E-41)
            r12 = r15
            r14 = r8
            r27 = r3
            r29 = r5
            r31 = r7
            r32 = r0
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r12, r13, r14, r16, r18, r19, r20, r21, r23, r24, r25, r27, r28, r29, r30, r31, r32, r33, r34, r35)
            r36 = r8
            r8 = r3
            r3 = r4
            r9 = r5
            r4 = r6
            r5 = r7
            r6 = r36
        L_0x023a:
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 != 0) goto L_0x0241
            goto L_0x0254
        L_0x0241:
            io.intercom.android.sdk.m5.components.TextWithSeparatorKt$TextWithSeparator$2 r13 = new io.intercom.android.sdk.m5.components.TextWithSeparatorKt$TextWithSeparator$2
            r0 = r13
            r1 = r38
            r2 = r39
            r10 = r48
            r11 = r49
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x0254:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.components.TextWithSeparatorKt.m5179TextWithSeparatorljD6DUQ(java.lang.String, java.lang.String, androidx.compose.ui.Modifier, java.lang.String, androidx.compose.ui.text.TextStyle, long, int, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void TextWithSeparatorPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1364601736);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$TextWithSeparatorKt.INSTANCE.m5169getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextWithSeparatorKt$TextWithSeparatorPreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void TextWithSeparatorEmptyPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1132854723);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$TextWithSeparatorKt.INSTANCE.m5170getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextWithSeparatorKt$TextWithSeparatorEmptyPreview$1(i));
        }
    }
}
