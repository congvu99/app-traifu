package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'J3\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.JG\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102J3\u00103\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105J3\u00106\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b7\u00105R\u0019\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0013\u0010\rR\u000e\u0010\u0014\u001a\u00020\u0015XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0017\u0010\rR\u0011\u0010\u0018\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\nR\u0019\u0010\u001a\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u001b\u001a\u00020\u001c8G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00068"}, d2 = {"Landroidx/compose/material/ButtonDefaults;", "", "()V", "ButtonHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonVerticalPadding", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "IconSize", "getIconSize-D9Ej5fM", "()F", "IconSpacing", "getIconSpacing-D9Ej5fM", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "OutlinedBorderOpacity", "", "OutlinedBorderSize", "getOutlinedBorderSize-D9Ej5fM", "TextButtonContentPadding", "getTextButtonContentPadding", "TextButtonHorizontalPadding", "outlinedBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "buttonColors", "Landroidx/compose/material/ButtonColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledBackgroundColor", "disabledContentColor", "buttonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonColors;", "elevation", "Landroidx/compose/material/ButtonElevation;", "defaultElevation", "pressedElevation", "disabledElevation", "elevation-yajeYGU", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonElevation;", "hoveredElevation", "focusedElevation", "elevation-R_JCAzs", "(FFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonElevation;", "outlinedButtonColors", "outlinedButtonColors-RGew2ao", "(JJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonColors;", "textButtonColors", "textButtonColors-RGew2ao", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Button.kt */
public final class ButtonDefaults {
    public static final int $stable = 0;
    private static final float ButtonHorizontalPadding = Dp.m4704constructorimpl((float) 16);
    private static final float ButtonVerticalPadding;
    private static final PaddingValues ContentPadding;
    public static final ButtonDefaults INSTANCE = new ButtonDefaults();
    private static final float IconSize = Dp.m4704constructorimpl((float) 18);
    private static final float IconSpacing;
    private static final float MinHeight = Dp.m4704constructorimpl((float) 36);
    private static final float MinWidth = Dp.m4704constructorimpl((float) 64);
    public static final float OutlinedBorderOpacity = 0.12f;
    private static final float OutlinedBorderSize = Dp.m4704constructorimpl((float) 1);
    private static final PaddingValues TextButtonContentPadding;
    private static final float TextButtonHorizontalPadding;

    private ButtonDefaults() {
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m1170getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m1169getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1167getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* renamed from: getIconSpacing-D9Ej5fM  reason: not valid java name */
    public final float m1168getIconSpacingD9Ej5fM() {
        return IconSpacing;
    }

    /* renamed from: buttonColors-ro_MJ88  reason: not valid java name */
    public final ButtonColors m1164buttonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1870371134);
        ComposerKt.sourceInformation(composer2, "C(buttonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)403@16701L6,404@16747L32,405@16836L6,406@16914L6,407@16983L6,408@17039L8:Button.kt#jmzs0o");
        long r6 = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1214getPrimary0d7_KjU() : j;
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(r6, (i2 & 2) != 0 ? ColorsKt.m1232contentColorForek8zF_U(r6, composer2, i & 14) : j2, (i2 & 4) != 0 ? ColorKt.m1978compositeOverOWjLjI(Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer2, 6).m1218getSurface0d7_KjU()) : j3, (i2 & 8) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j4, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    /* renamed from: outlinedButtonColors-RGew2ao  reason: not valid java name */
    public final ButtonColors m1172outlinedButtonColorsRGew2ao(long j, long j2, long j3, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-2124406093);
        ComposerKt.sourceInformation(composer2, "C(outlinedButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color)426@17786L6,427@17846L6,428@17914L6,429@17970L8:Button.kt#jmzs0o");
        long r10 = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1218getSurface0d7_KjU() : j;
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(r10, (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1214getPrimary0d7_KjU() : j2, r10, (i2 & 4) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    /* renamed from: textButtonColors-RGew2ao  reason: not valid java name */
    public final ButtonColors m1173textButtonColorsRGew2ao(long j, long j2, long j3, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(182742216);
        ComposerKt.sourceInformation(composer2, "C(textButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color)448@18737L6,449@18805L6,450@18861L8:Button.kt#jmzs0o");
        long r8 = (i2 & 1) != 0 ? Color.Companion.m1967getTransparent0d7_KjU() : j;
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(r8, (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1214getPrimary0d7_KjU() : j2, r8, (i2 & 4) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    /* renamed from: getOutlinedBorderSize-D9Ej5fM  reason: not valid java name */
    public final float m1171getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    public final BorderStroke getOutlinedBorder(Composer composer, int i) {
        composer.startReplaceableGroup(-2091313033);
        ComposerKt.sourceInformation(composer, "C474@19565L6:Button.kt#jmzs0o");
        BorderStroke r11 = BorderStrokeKt.m191BorderStrokecXLIe8U(OutlinedBorderSize, Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1213getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null));
        composer.endReplaceableGroup();
        return r11;
    }

    public final PaddingValues getTextButtonContentPadding() {
        return TextButtonContentPadding;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another overload of elevation")
    /* renamed from: elevation-yajeYGU  reason: not valid java name */
    public final /* synthetic */ ButtonElevation m1166elevationyajeYGU(float f, float f2, float f3, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1428576874);
        ComposerKt.sourceInformation(composer, "C(elevation)P(0:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp)346@14503L161:Button.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            f = Dp.m4704constructorimpl((float) 2);
        }
        float f4 = f;
        if ((i2 & 2) != 0) {
            f2 = Dp.m4704constructorimpl((float) 8);
        }
        float f5 = f2;
        if ((i2 & 4) != 0) {
            f3 = Dp.m4704constructorimpl((float) 0);
        }
        float f6 = (float) 4;
        ButtonElevation r10 = m1165elevationR_JCAzs(f4, f5, f3, Dp.m4704constructorimpl(f6), Dp.m4704constructorimpl(f6), composer, (i & 14) | 27648 | (i & 112) | (i & 896) | (458752 & (i << 6)), 0);
        composer.endReplaceableGroup();
        return r10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0096, code lost:
        if (r3 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0098;
     */
    /* renamed from: elevation-R_JCAzs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.material.ButtonElevation m1165elevationR_JCAzs(float r14, float r15, float r16, float r17, float r18, androidx.compose.runtime.Composer r19, int r20, int r21) {
        /*
            r13 = this;
            r0 = r19
            r1 = -737170518(0xffffffffd40fabaa, float:-2.46824147E12)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "C(elevation)P(0:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,3:c#ui.unit.Dp,2:c#ui.unit.Dp)375@15635L497:Button.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r21 & 1
            r2 = 2
            if (r1 == 0) goto L_0x0019
            float r1 = (float) r2
            float r1 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r1)
            r4 = r1
            goto L_0x001a
        L_0x0019:
            r4 = r14
        L_0x001a:
            r1 = r21 & 2
            if (r1 == 0) goto L_0x0027
            r1 = 8
            float r1 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r1)
            r5 = r1
            goto L_0x0028
        L_0x0027:
            r5 = r15
        L_0x0028:
            r1 = r21 & 4
            r3 = 0
            if (r1 == 0) goto L_0x0034
            float r1 = (float) r3
            float r1 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r1)
            r6 = r1
            goto L_0x0036
        L_0x0034:
            r6 = r16
        L_0x0036:
            r1 = r21 & 8
            r7 = 4
            if (r1 == 0) goto L_0x0041
            float r1 = (float) r7
            float r1 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r1)
            goto L_0x0043
        L_0x0041:
            r1 = r17
        L_0x0043:
            r8 = r21 & 16
            if (r8 == 0) goto L_0x004d
            float r8 = (float) r7
            float r8 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r8)
            goto L_0x004f
        L_0x004d:
            r8 = r18
        L_0x004f:
            r9 = 5
            java.lang.Object[] r10 = new java.lang.Object[r9]
            androidx.compose.ui.unit.Dp r11 = androidx.compose.ui.unit.Dp.m4702boximpl(r4)
            r10[r3] = r11
            androidx.compose.ui.unit.Dp r11 = androidx.compose.ui.unit.Dp.m4702boximpl(r5)
            r12 = 1
            r10[r12] = r11
            androidx.compose.ui.unit.Dp r11 = androidx.compose.ui.unit.Dp.m4702boximpl(r6)
            r10[r2] = r11
            r2 = 3
            androidx.compose.ui.unit.Dp r11 = androidx.compose.ui.unit.Dp.m4702boximpl(r1)
            r10[r2] = r11
            androidx.compose.ui.unit.Dp r2 = androidx.compose.ui.unit.Dp.m4702boximpl(r8)
            r10[r7] = r2
            r2 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = 0
        L_0x007e:
            if (r3 >= r9) goto L_0x008a
            r7 = r10[r3]
            boolean r7 = r0.changed((java.lang.Object) r7)
            r2 = r2 | r7
            int r3 = r3 + 1
            goto L_0x007e
        L_0x008a:
            java.lang.Object r3 = r19.rememberedValue()
            if (r2 != 0) goto L_0x0098
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x00a3
        L_0x0098:
            androidx.compose.material.DefaultButtonElevation r2 = new androidx.compose.material.DefaultButtonElevation
            r9 = 0
            r3 = r2
            r7 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r0.updateRememberedValue(r2)
        L_0x00a3:
            r19.endReplaceableGroup()
            androidx.compose.material.DefaultButtonElevation r3 = (androidx.compose.material.DefaultButtonElevation) r3
            r19.endReplaceableGroup()
            androidx.compose.material.ButtonElevation r3 = (androidx.compose.material.ButtonElevation) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ButtonDefaults.m1165elevationR_JCAzs(float, float, float, float, float, androidx.compose.runtime.Composer, int, int):androidx.compose.material.ButtonElevation");
    }

    static {
        float f = (float) 8;
        float r1 = Dp.m4704constructorimpl(f);
        ButtonVerticalPadding = r1;
        float f2 = ButtonHorizontalPadding;
        ContentPadding = PaddingKt.m506PaddingValuesa9UjIt4(f2, r1, f2, r1);
        IconSpacing = Dp.m4704constructorimpl(f);
        float r0 = Dp.m4704constructorimpl(f);
        TextButtonHorizontalPadding = r0;
        TextButtonContentPadding = PaddingKt.m506PaddingValuesa9UjIt4(r0, ContentPadding.m523calculateTopPaddingD9Ej5fM(), TextButtonHorizontalPadding, ContentPadding.m520calculateBottomPaddingD9Ej5fM());
    }
}
