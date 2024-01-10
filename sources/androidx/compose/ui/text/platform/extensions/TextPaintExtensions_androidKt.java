package androidx.compose.ui.text.platform.extensions;

import androidx.compose.ui.text.SpanStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001aG\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00042&\u0010\u0007\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000ø\u0001\u0000\u001a\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0004H\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"correctBlurRadius", "", "blurRadius", "applySpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "style", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "density", "Landroidx/compose/ui/unit/Density;", "hasFontAttributes", "", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextPaintExtensions.android.kt */
public final class TextPaintExtensions_androidKt {
    public static final float correctBlurRadius(float f) {
        if (f == 0.0f) {
            return Float.MIN_VALUE;
        }
        return f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x020e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.text.SpanStyle applySpanStyle(androidx.compose.ui.text.platform.AndroidTextPaint r28, androidx.compose.ui.text.SpanStyle r29, kotlin.jvm.functions.Function4<? super androidx.compose.ui.text.font.FontFamily, ? super androidx.compose.ui.text.font.FontWeight, ? super androidx.compose.ui.text.font.FontStyle, ? super androidx.compose.ui.text.font.FontSynthesis, ? extends android.graphics.Typeface> r30, androidx.compose.ui.unit.Density r31) {
        /*
            r0 = r28
            r1 = r30
            r2 = r31
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "style"
            r4 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            java.lang.String r3 = "resolveTypeface"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "density"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            long r5 = r29.m4184getFontSizeXSAIIZE()
            long r5 = androidx.compose.ui.unit.TextUnit.m4884getTypeUIouoOA(r5)
            androidx.compose.ui.unit.TextUnitType$Companion r3 = androidx.compose.ui.unit.TextUnitType.Companion
            long r7 = r3.m4918getSpUIouoOA()
            boolean r3 = androidx.compose.ui.unit.TextUnitType.m4913equalsimpl0(r5, r7)
            if (r3 == 0) goto L_0x003e
            long r5 = r29.m4184getFontSizeXSAIIZE()
            float r2 = r2.m4648toPxR2X_6o(r5)
            r0.setTextSize(r2)
            goto L_0x005b
        L_0x003e:
            androidx.compose.ui.unit.TextUnitType$Companion r2 = androidx.compose.ui.unit.TextUnitType.Companion
            long r2 = r2.m4917getEmUIouoOA()
            boolean r2 = androidx.compose.ui.unit.TextUnitType.m4913equalsimpl0(r5, r2)
            if (r2 == 0) goto L_0x005b
            float r2 = r28.getTextSize()
            long r5 = r29.m4184getFontSizeXSAIIZE()
            float r3 = androidx.compose.ui.unit.TextUnit.m4885getValueimpl(r5)
            float r2 = r2 * r3
            r0.setTextSize(r2)
        L_0x005b:
            boolean r2 = hasFontAttributes(r29)
            if (r2 == 0) goto L_0x00a4
            androidx.compose.ui.text.font.FontFamily r2 = r29.getFontFamily()
            androidx.compose.ui.text.font.FontWeight r3 = r29.getFontWeight()
            if (r3 != 0) goto L_0x0071
            androidx.compose.ui.text.font.FontWeight$Companion r3 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r3 = r3.getNormal()
        L_0x0071:
            androidx.compose.ui.text.font.FontStyle r5 = r29.m4185getFontStyle4Lr2A7w()
            if (r5 == 0) goto L_0x007c
            int r5 = r5.m4311unboximpl()
            goto L_0x0082
        L_0x007c:
            androidx.compose.ui.text.font.FontStyle$Companion r5 = androidx.compose.ui.text.font.FontStyle.Companion
            int r5 = r5.m4313getNormal_LCdwA()
        L_0x0082:
            androidx.compose.ui.text.font.FontStyle r5 = androidx.compose.ui.text.font.FontStyle.m4305boximpl(r5)
            androidx.compose.ui.text.font.FontSynthesis r6 = r29.m4186getFontSynthesisZQGJjVo()
            if (r6 == 0) goto L_0x0091
            int r6 = r6.m4322unboximpl()
            goto L_0x0097
        L_0x0091:
            androidx.compose.ui.text.font.FontSynthesis$Companion r6 = androidx.compose.ui.text.font.FontSynthesis.Companion
            int r6 = r6.m4323getAllGVVA2EU()
        L_0x0097:
            androidx.compose.ui.text.font.FontSynthesis r6 = androidx.compose.ui.text.font.FontSynthesis.m4314boximpl(r6)
            java.lang.Object r1 = r1.invoke(r2, r3, r5, r6)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            r0.setTypeface(r1)
        L_0x00a4:
            androidx.compose.ui.text.intl.LocaleList r1 = r29.getLocaleList()
            r2 = 0
            if (r1 == 0) goto L_0x00eb
            androidx.compose.ui.text.intl.LocaleList r1 = r29.getLocaleList()
            androidx.compose.ui.text.intl.LocaleList$Companion r3 = androidx.compose.ui.text.intl.LocaleList.Companion
            androidx.compose.ui.text.intl.LocaleList r3 = r3.getCurrent()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 != 0) goto L_0x00eb
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r1 < r3) goto L_0x00cb
            androidx.compose.ui.text.platform.extensions.LocaleListHelperMethods r1 = androidx.compose.ui.text.platform.extensions.LocaleListHelperMethods.INSTANCE
            androidx.compose.ui.text.intl.LocaleList r3 = r29.getLocaleList()
            r1.setTextLocales(r0, r3)
            goto L_0x00eb
        L_0x00cb:
            androidx.compose.ui.text.intl.LocaleList r1 = r29.getLocaleList()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x00dc
            androidx.compose.ui.text.intl.Locale$Companion r1 = androidx.compose.ui.text.intl.Locale.Companion
            androidx.compose.ui.text.intl.Locale r1 = r1.getCurrent()
            goto L_0x00e4
        L_0x00dc:
            androidx.compose.ui.text.intl.LocaleList r1 = r29.getLocaleList()
            androidx.compose.ui.text.intl.Locale r1 = r1.get(r2)
        L_0x00e4:
            java.util.Locale r1 = androidx.compose.ui.text.platform.extensions.LocaleExtensions_androidKt.toJavaLocale(r1)
            r0.setTextLocale(r1)
        L_0x00eb:
            long r5 = r29.m4187getLetterSpacingXSAIIZE()
            long r5 = androidx.compose.ui.unit.TextUnit.m4884getTypeUIouoOA(r5)
            androidx.compose.ui.unit.TextUnitType$Companion r1 = androidx.compose.ui.unit.TextUnitType.Companion
            long r7 = r1.m4917getEmUIouoOA()
            boolean r1 = androidx.compose.ui.unit.TextUnitType.m4913equalsimpl0(r5, r7)
            if (r1 == 0) goto L_0x010b
            long r5 = r29.m4187getLetterSpacingXSAIIZE()
            float r1 = androidx.compose.ui.unit.TextUnit.m4885getValueimpl(r5)
            r0.setLetterSpacing(r1)
            goto L_0x0114
        L_0x010b:
            androidx.compose.ui.unit.TextUnitType$Companion r1 = androidx.compose.ui.unit.TextUnitType.Companion
            long r7 = r1.m4918getSpUIouoOA()
            androidx.compose.ui.unit.TextUnitType.m4913equalsimpl0(r5, r7)
        L_0x0114:
            java.lang.String r1 = r29.getFontFeatureSettings()
            if (r1 == 0) goto L_0x012d
            java.lang.String r1 = r29.getFontFeatureSettings()
            java.lang.String r3 = ""
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 != 0) goto L_0x012d
            java.lang.String r1 = r29.getFontFeatureSettings()
            r0.setFontFeatureSettings(r1)
        L_0x012d:
            androidx.compose.ui.text.style.TextGeometricTransform r1 = r29.getTextGeometricTransform()
            if (r1 == 0) goto L_0x0164
            androidx.compose.ui.text.style.TextGeometricTransform r1 = r29.getTextGeometricTransform()
            androidx.compose.ui.text.style.TextGeometricTransform$Companion r3 = androidx.compose.ui.text.style.TextGeometricTransform.Companion
            androidx.compose.ui.text.style.TextGeometricTransform r3 = r3.getNone$ui_text_release()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 != 0) goto L_0x0164
            float r1 = r28.getTextScaleX()
            androidx.compose.ui.text.style.TextGeometricTransform r3 = r29.getTextGeometricTransform()
            float r3 = r3.getScaleX()
            float r1 = r1 * r3
            r0.setTextScaleX(r1)
            float r1 = r28.getTextSkewX()
            androidx.compose.ui.text.style.TextGeometricTransform r3 = r29.getTextGeometricTransform()
            float r3 = r3.getSkewX()
            float r1 = r1 + r3
            r0.setTextSkewX(r1)
        L_0x0164:
            long r5 = r29.m4183getColor0d7_KjU()
            r0.m4440setColor8_81llA(r5)
            androidx.compose.ui.graphics.Brush r1 = r29.getBrush()
            androidx.compose.ui.geometry.Size$Companion r3 = androidx.compose.ui.geometry.Size.Companion
            long r5 = r3.m1760getUnspecifiedNHjbRc()
            float r3 = r29.getAlpha()
            r0.m4438setBrush12SF9DM(r1, r5, r3)
            androidx.compose.ui.graphics.Shadow r1 = r29.getShadow()
            r0.setShadow(r1)
            long r0 = r29.m4187getLetterSpacingXSAIIZE()
            long r0 = androidx.compose.ui.unit.TextUnit.m4884getTypeUIouoOA(r0)
            androidx.compose.ui.unit.TextUnitType$Companion r3 = androidx.compose.ui.unit.TextUnitType.Companion
            long r5 = r3.m4918getSpUIouoOA()
            boolean r0 = androidx.compose.ui.unit.TextUnitType.m4913equalsimpl0(r0, r5)
            r1 = 1
            if (r0 == 0) goto L_0x01af
            long r5 = r29.m4187getLetterSpacingXSAIIZE()
            float r0 = androidx.compose.ui.unit.TextUnit.m4885getValueimpl(r5)
            r3 = 0
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x01a7
            r0 = 1
            goto L_0x01a8
        L_0x01a7:
            r0 = 0
        L_0x01a8:
            if (r0 != 0) goto L_0x01af
            long r5 = r29.m4187getLetterSpacingXSAIIZE()
            goto L_0x01b5
        L_0x01af:
            androidx.compose.ui.unit.TextUnit$Companion r0 = androidx.compose.ui.unit.TextUnit.Companion
            long r5 = r0.m4896getUnspecifiedXSAIIZE()
        L_0x01b5:
            r17 = r5
            long r5 = r29.m4181getBackground0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r0 = androidx.compose.ui.graphics.Color.Companion
            long r7 = r0.m1967getTransparent0d7_KjU()
            boolean r0 = androidx.compose.ui.graphics.Color.m1933equalsimpl0(r5, r7)
            if (r0 == 0) goto L_0x01ce
            androidx.compose.ui.graphics.Color$Companion r0 = androidx.compose.ui.graphics.Color.Companion
            long r5 = r0.m1968getUnspecified0d7_KjU()
            goto L_0x01d2
        L_0x01ce:
            long r5 = r29.m4181getBackground0d7_KjU()
        L_0x01d2:
            r22 = r5
            androidx.compose.ui.text.style.BaselineShift r0 = r29.m4182getBaselineShift5SSeXJ0()
            androidx.compose.ui.text.style.BaselineShift$Companion r3 = androidx.compose.ui.text.style.BaselineShift.Companion
            float r3 = r3.m4472getNoney9eOQZs()
            if (r0 != 0) goto L_0x01e1
            goto L_0x01e9
        L_0x01e1:
            float r0 = r0.m4468unboximpl()
            boolean r2 = androidx.compose.ui.text.style.BaselineShift.m4465equalsimpl0(r0, r3)
        L_0x01e9:
            r0 = 0
            if (r2 == 0) goto L_0x01f0
            r2 = r0
            androidx.compose.ui.text.style.BaselineShift r2 = (androidx.compose.ui.text.style.BaselineShift) r2
            goto L_0x01f4
        L_0x01f0:
            androidx.compose.ui.text.style.BaselineShift r2 = r29.m4182getBaselineShift5SSeXJ0()
        L_0x01f4:
            r19 = r2
            androidx.compose.ui.text.style.TextDecoration r2 = r29.getTextDecoration()
            androidx.compose.ui.text.style.TextDecoration r3 = r29.getTextDecoration()
            androidx.compose.ui.text.style.TextDecoration$Companion r4 = androidx.compose.ui.text.style.TextDecoration.Companion
            androidx.compose.ui.text.style.TextDecoration r4 = r4.getNone()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            r1 = r1 ^ r3
            if (r1 == 0) goto L_0x020e
            r24 = r2
            goto L_0x0210
        L_0x020e:
            r24 = r0
        L_0x0210:
            androidx.compose.ui.text.SpanStyle r0 = new androidx.compose.ui.text.SpanStyle
            r7 = r0
            r8 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r20 = 0
            r21 = 0
            r25 = 0
            r26 = 9855(0x267f, float:1.381E-41)
            r27 = 0
            r7.<init>((long) r8, (long) r10, (androidx.compose.ui.text.font.FontWeight) r12, (androidx.compose.ui.text.font.FontStyle) r13, (androidx.compose.ui.text.font.FontSynthesis) r14, (androidx.compose.ui.text.font.FontFamily) r15, (java.lang.String) r16, (long) r17, (androidx.compose.ui.text.style.BaselineShift) r19, (androidx.compose.ui.text.style.TextGeometricTransform) r20, (androidx.compose.ui.text.intl.LocaleList) r21, (long) r22, (androidx.compose.ui.text.style.TextDecoration) r24, (androidx.compose.ui.graphics.Shadow) r25, (int) r26, (kotlin.jvm.internal.DefaultConstructorMarker) r27)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt.applySpanStyle(androidx.compose.ui.text.platform.AndroidTextPaint, androidx.compose.ui.text.SpanStyle, kotlin.jvm.functions.Function4, androidx.compose.ui.unit.Density):androidx.compose.ui.text.SpanStyle");
    }

    public static final boolean hasFontAttributes(SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "<this>");
        return (spanStyle.getFontFamily() == null && spanStyle.m4185getFontStyle4Lr2A7w() == null && spanStyle.getFontWeight() == null) ? false : true;
    }
}
