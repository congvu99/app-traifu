package androidx.compose.material;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JG\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"Landroidx/compose/material/CheckboxDefaults;", "", "()V", "colors", "Landroidx/compose/material/CheckboxColors;", "checkedColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedColor", "checkmarkColor", "disabledColor", "disabledIndeterminateColor", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/CheckboxColors;", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Checkbox.kt */
public final class CheckboxDefaults {
    public static final int $stable = 0;
    public static final CheckboxDefaults INSTANCE = new CheckboxDefaults();

    private CheckboxDefaults() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: androidx.compose.material.DefaultCheckboxColors} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: androidx.compose.material.DefaultCheckboxColors} */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f5, code lost:
        if (r1 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x00f7;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: colors-zjMxDiM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.material.CheckboxColors m1179colorszjMxDiM(long r30, long r32, long r34, long r36, long r38, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r29 = this;
            r0 = r40
            r1 = 469524104(0x1bfc5e88, float:4.1750992E-22)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "C(colors)P(0:c#ui.graphics.Color,4:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)221@9467L6,222@9531L6,223@9614L6,224@9675L6,224@9718L8,225@9812L8,227@9861L922:Checkbox.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r42 & 1
            r2 = 6
            if (r1 == 0) goto L_0x001f
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r1 = r1.getColors(r0, r2)
            long r3 = r1.m1216getSecondary0d7_KjU()
            r20 = r3
            goto L_0x0021
        L_0x001f:
            r20 = r30
        L_0x0021:
            r1 = r42 & 2
            if (r1 == 0) goto L_0x003f
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r1 = r1.getColors(r0, r2)
            long r3 = r1.m1213getOnSurface0d7_KjU()
            r5 = 1058642330(0x3f19999a, float:0.6)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 14
            r10 = 0
            long r3 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r3, r5, r6, r7, r8, r9, r10)
            r22 = r3
            goto L_0x0041
        L_0x003f:
            r22 = r32
        L_0x0041:
            r1 = r42 & 4
            if (r1 == 0) goto L_0x0051
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r1 = r1.getColors(r0, r2)
            long r3 = r1.m1218getSurface0d7_KjU()
            r6 = r3
            goto L_0x0053
        L_0x0051:
            r6 = r34
        L_0x0053:
            r1 = r42 & 8
            if (r1 == 0) goto L_0x0082
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r1 = r1.getColors(r0, r2)
            long r3 = r1.m1213getOnSurface0d7_KjU()
            androidx.compose.material.ContentAlpha r1 = androidx.compose.material.ContentAlpha.INSTANCE
            float r1 = r1.getDisabled(r0, r2)
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 14
            r11 = 0
            r30 = r3
            r32 = r1
            r33 = r5
            r34 = r8
            r35 = r9
            r36 = r10
            r37 = r11
            long r3 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r30, r32, r33, r34, r35, r36, r37)
            r24 = r3
            goto L_0x0084
        L_0x0082:
            r24 = r36
        L_0x0084:
            r1 = r42 & 16
            if (r1 == 0) goto L_0x00a9
            androidx.compose.material.ContentAlpha r1 = androidx.compose.material.ContentAlpha.INSTANCE
            float r1 = r1.getDisabled(r0, r2)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 14
            r8 = 0
            r30 = r20
            r32 = r1
            r33 = r2
            r34 = r3
            r35 = r4
            r36 = r5
            r37 = r8
            long r1 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r30, r32, r33, r34, r35, r36, r37)
            r26 = r1
            goto L_0x00ab
        L_0x00a9:
            r26 = r38
        L_0x00ab:
            r1 = 5
            java.lang.Object[] r2 = new java.lang.Object[r1]
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m1922boximpl(r20)
            r4 = 0
            r2[r4] = r3
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m1922boximpl(r22)
            r5 = 1
            r2[r5] = r3
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m1922boximpl(r6)
            r5 = 2
            r2[r5] = r3
            r3 = 3
            androidx.compose.ui.graphics.Color r5 = androidx.compose.ui.graphics.Color.m1922boximpl(r24)
            r2[r3] = r5
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m1922boximpl(r26)
            r5 = 4
            r2[r5] = r3
            r3 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r0.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            r3 = 0
        L_0x00dd:
            if (r4 >= r1) goto L_0x00e9
            r5 = r2[r4]
            boolean r5 = r0.changed((java.lang.Object) r5)
            r3 = r3 | r5
            int r4 = r4 + 1
            goto L_0x00dd
        L_0x00e9:
            java.lang.Object r1 = r40.rememberedValue()
            if (r3 != 0) goto L_0x00f7
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x0130
        L_0x00f7:
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 14
            r8 = 0
            r30 = r6
            r32 = r1
            r33 = r2
            r34 = r3
            r35 = r4
            r36 = r5
            r37 = r8
            long r8 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r30, r32, r33, r34, r35, r36, r37)
            r10 = 0
            r30 = r20
            r37 = r10
            long r12 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r30, r32, r33, r34, r35, r36, r37)
            r30 = r24
            long r16 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r30, r32, r33, r34, r35, r36, r37)
            androidx.compose.material.DefaultCheckboxColors r1 = new androidx.compose.material.DefaultCheckboxColors
            r5 = r1
            r28 = 0
            r10 = r20
            r14 = r24
            r18 = r26
            r5.<init>(r6, r8, r10, r12, r14, r16, r18, r20, r22, r24, r26, r28)
            r0.updateRememberedValue(r1)
        L_0x0130:
            r40.endReplaceableGroup()
            androidx.compose.material.DefaultCheckboxColors r1 = (androidx.compose.material.DefaultCheckboxColors) r1
            r40.endReplaceableGroup()
            androidx.compose.material.CheckboxColors r1 = (androidx.compose.material.CheckboxColors) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.CheckboxDefaults.m1179colorszjMxDiM(long, long, long, long, long, androidx.compose.runtime.Composer, int, int):androidx.compose.material.CheckboxColors");
    }
}
