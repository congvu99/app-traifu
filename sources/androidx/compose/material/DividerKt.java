package androidx.compose.material;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"DividerAlpha", "", "Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "thickness", "Landroidx/compose/ui/unit/Dp;", "startIndent", "Divider-oMI9zvI", "(Landroidx/compose/ui/Modifier;JFFLandroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Divider.kt */
public final class DividerKt {
    private static final float DividerAlpha = 0.12f;

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /* renamed from: Divider-oMI9zvI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1254DivideroMI9zvI(androidx.compose.ui.Modifier r21, long r22, float r24, float r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r6 = r27
            r0 = -1249392198(0xffffffffb587c9ba, float:-1.0116994E-6)
            r1 = r26
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Divider)P(1,0:c#ui.graphics.Color,3:c#ui.unit.Dp,2:c#ui.unit.Dp)45@1819L6,59@2200L147:Divider.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r28 & 1
            if (r1 == 0) goto L_0x001a
            r2 = r6 | 6
            r3 = r2
            r2 = r21
            goto L_0x002e
        L_0x001a:
            r2 = r6 & 14
            if (r2 != 0) goto L_0x002b
            r2 = r21
            boolean r3 = r0.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0028
            r3 = 4
            goto L_0x0029
        L_0x0028:
            r3 = 2
        L_0x0029:
            r3 = r3 | r6
            goto L_0x002e
        L_0x002b:
            r2 = r21
            r3 = r6
        L_0x002e:
            r4 = r6 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0047
            r4 = r28 & 2
            if (r4 != 0) goto L_0x0041
            r4 = r22
            boolean r7 = r0.changed((long) r4)
            if (r7 == 0) goto L_0x0043
            r7 = 32
            goto L_0x0045
        L_0x0041:
            r4 = r22
        L_0x0043:
            r7 = 16
        L_0x0045:
            r3 = r3 | r7
            goto L_0x0049
        L_0x0047:
            r4 = r22
        L_0x0049:
            r7 = r28 & 4
            if (r7 == 0) goto L_0x0050
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r8 = r6 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0063
            r8 = r24
            boolean r9 = r0.changed((float) r8)
            if (r9 == 0) goto L_0x005f
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r3 = r3 | r9
            goto L_0x0065
        L_0x0063:
            r8 = r24
        L_0x0065:
            r9 = r28 & 8
            if (r9 == 0) goto L_0x006c
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r10 = r6 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x007f
            r10 = r25
            boolean r11 = r0.changed((float) r10)
            if (r11 == 0) goto L_0x007b
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r3 = r3 | r11
            goto L_0x0081
        L_0x007f:
            r10 = r25
        L_0x0081:
            r3 = r3 & 5851(0x16db, float:8.199E-42)
            r11 = 1170(0x492, float:1.64E-42)
            if (r3 != r11) goto L_0x0097
            boolean r3 = r0.getSkipping()
            if (r3 != 0) goto L_0x008e
            goto L_0x0097
        L_0x008e:
            r0.skipToGroupEnd()
            r1 = r2
            r2 = r4
        L_0x0093:
            r4 = r8
            r5 = r10
            goto L_0x016e
        L_0x0097:
            r0.startDefaults()
            r3 = r6 & 1
            r11 = 0
            r12 = 1
            if (r3 == 0) goto L_0x00af
            boolean r3 = r0.getDefaultsInvalid()
            if (r3 == 0) goto L_0x00a7
            goto L_0x00af
        L_0x00a7:
            r0.skipToGroupEnd()
            r1 = r28 & 2
            r1 = r2
            r2 = r4
            goto L_0x00e9
        L_0x00af:
            if (r1 == 0) goto L_0x00b6
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x00b7
        L_0x00b6:
            r1 = r2
        L_0x00b7:
            r2 = r28 & 2
            if (r2 == 0) goto L_0x00d8
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            r3 = 6
            androidx.compose.material.Colors r2 = r2.getColors(r0, r3)
            long r13 = r2.m1213getOnSurface0d7_KjU()
            r15 = 1039516303(0x3df5c28f, float:0.12)
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 14
            r20 = 0
            long r2 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r13, r15, r16, r17, r18, r19, r20)
            goto L_0x00d9
        L_0x00d8:
            r2 = r4
        L_0x00d9:
            if (r7 == 0) goto L_0x00e1
            float r4 = (float) r12
            float r4 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            r8 = r4
        L_0x00e1:
            if (r9 == 0) goto L_0x00e9
            float r4 = (float) r11
            float r4 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            r10 = r4
        L_0x00e9:
            r0.endDefaults()
            r4 = 0
            int r5 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r5 != 0) goto L_0x00f3
            r5 = 1
            goto L_0x00f4
        L_0x00f3:
            r5 = 0
        L_0x00f4:
            if (r5 != 0) goto L_0x010a
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            r13 = r5
            androidx.compose.ui.Modifier r13 = (androidx.compose.ui.Modifier) r13
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 14
            r19 = 0
            r14 = r10
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.PaddingKt.m514paddingqDBjuR0$default(r13, r14, r15, r16, r17, r18, r19)
            goto L_0x010e
        L_0x010a:
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
        L_0x010e:
            r7 = 1228914189(0x493fbe0d, float:785376.8)
            r0.startReplaceableGroup(r7)
            java.lang.String r7 = "*55@2139L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r7)
            androidx.compose.ui.unit.Dp$Companion r7 = androidx.compose.ui.unit.Dp.Companion
            float r7 = r7.m4722getHairlineD9Ej5fM()
            boolean r7 = androidx.compose.ui.unit.Dp.m4709equalsimpl0(r8, r7)
            if (r7 == 0) goto L_0x0148
            r7 = 1065353216(0x3f800000, float:1.0)
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r14 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r14)
            java.lang.Object r9 = r0.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            float r9 = r9.getDensity()
            float r7 = r7 / r9
            float r7 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r7)
            goto L_0x0149
        L_0x0148:
            r7 = r8
        L_0x0149:
            r0.endReplaceableGroup()
            androidx.compose.ui.Modifier r5 = r1.then(r5)
            r9 = 0
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r5, r4, r12, r9)
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r4, r7)
            r5 = 0
            r7 = 2
            r21 = r4
            r22 = r2
            r24 = r5
            r25 = r7
            r26 = r9
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.BackgroundKt.m177backgroundbw27NRU$default(r21, r22, r24, r25, r26)
            androidx.compose.foundation.layout.BoxKt.Box(r4, r0, r11)
            goto L_0x0093
        L_0x016e:
            androidx.compose.runtime.ScopeUpdateScope r8 = r0.endRestartGroup()
            if (r8 != 0) goto L_0x0175
            goto L_0x0184
        L_0x0175:
            androidx.compose.material.DividerKt$Divider$1 r9 = new androidx.compose.material.DividerKt$Divider$1
            r0 = r9
            r6 = r27
            r7 = r28
            r0.<init>(r1, r2, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x0184:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DividerKt.m1254DivideroMI9zvI(androidx.compose.ui.Modifier, long, float, float, androidx.compose.runtime.Composer, int, int):void");
    }
}
