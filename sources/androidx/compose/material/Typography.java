package androidx.compose.material;

import androidx.compose.ui.text.TextStyle;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0001\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005¢\u0006\u0002\u0010\u0012Bo\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0002\u0010\u0013J\u0001\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0005J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0016R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015¨\u0006*"}, d2 = {"Landroidx/compose/material/Typography;", "", "defaultFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "h1", "Landroidx/compose/ui/text/TextStyle;", "h2", "h3", "h4", "h5", "h6", "subtitle1", "subtitle2", "body1", "body2", "button", "caption", "overline", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;)V", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;)V", "getBody1", "()Landroidx/compose/ui/text/TextStyle;", "getBody2", "getButton", "getCaption", "getH1", "getH2", "getH3", "getH4", "getH5", "getH6", "getOverline", "getSubtitle1", "getSubtitle2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Typography.kt */
public final class Typography {
    private final TextStyle body1;
    private final TextStyle body2;
    private final TextStyle button;
    private final TextStyle caption;
    private final TextStyle h1;
    private final TextStyle h2;
    private final TextStyle h3;
    private final TextStyle h4;
    private final TextStyle h5;
    private final TextStyle h6;
    private final TextStyle overline;
    private final TextStyle subtitle1;
    private final TextStyle subtitle2;

    public Typography(TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13) {
        Intrinsics.checkNotNullParameter(textStyle, "h1");
        Intrinsics.checkNotNullParameter(textStyle2, "h2");
        Intrinsics.checkNotNullParameter(textStyle3, "h3");
        Intrinsics.checkNotNullParameter(textStyle4, "h4");
        Intrinsics.checkNotNullParameter(textStyle5, "h5");
        Intrinsics.checkNotNullParameter(textStyle6, "h6");
        Intrinsics.checkNotNullParameter(textStyle7, "subtitle1");
        Intrinsics.checkNotNullParameter(textStyle8, "subtitle2");
        Intrinsics.checkNotNullParameter(textStyle9, "body1");
        Intrinsics.checkNotNullParameter(textStyle10, "body2");
        Intrinsics.checkNotNullParameter(textStyle11, "button");
        Intrinsics.checkNotNullParameter(textStyle12, ShareConstants.FEED_CAPTION_PARAM);
        Intrinsics.checkNotNullParameter(textStyle13, "overline");
        this.h1 = textStyle;
        this.h2 = textStyle2;
        this.h3 = textStyle3;
        this.h4 = textStyle4;
        this.h5 = textStyle5;
        this.h6 = textStyle6;
        this.subtitle1 = textStyle7;
        this.subtitle2 = textStyle8;
        this.body1 = textStyle9;
        this.body2 = textStyle10;
        this.button = textStyle11;
        this.caption = textStyle12;
        this.overline = textStyle13;
    }

    public final TextStyle getH1() {
        return this.h1;
    }

    public final TextStyle getH2() {
        return this.h2;
    }

    public final TextStyle getH3() {
        return this.h3;
    }

    public final TextStyle getH4() {
        return this.h4;
    }

    public final TextStyle getH5() {
        return this.h5;
    }

    public final TextStyle getH6() {
        return this.h6;
    }

    public final TextStyle getSubtitle1() {
        return this.subtitle1;
    }

    public final TextStyle getSubtitle2() {
        return this.subtitle2;
    }

    public final TextStyle getBody1() {
        return this.body1;
    }

    public final TextStyle getBody2() {
        return this.body2;
    }

    public final TextStyle getButton() {
        return this.button;
    }

    public final TextStyle getCaption() {
        return this.caption;
    }

    public final TextStyle getOverline() {
        return this.overline;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Typography(androidx.compose.ui.text.font.FontFamily r42, androidx.compose.ui.text.TextStyle r43, androidx.compose.ui.text.TextStyle r44, androidx.compose.ui.text.TextStyle r45, androidx.compose.ui.text.TextStyle r46, androidx.compose.ui.text.TextStyle r47, androidx.compose.ui.text.TextStyle r48, androidx.compose.ui.text.TextStyle r49, androidx.compose.ui.text.TextStyle r50, androidx.compose.ui.text.TextStyle r51, androidx.compose.ui.text.TextStyle r52, androidx.compose.ui.text.TextStyle r53, androidx.compose.ui.text.TextStyle r54, androidx.compose.ui.text.TextStyle r55, int r56, kotlin.jvm.internal.DefaultConstructorMarker r57) {
        /*
            r41 = this;
            r0 = r56
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000f
            androidx.compose.ui.text.font.FontFamily$Companion r1 = androidx.compose.ui.text.font.FontFamily.Companion
            androidx.compose.ui.text.font.SystemFontFamily r1 = r1.getDefault()
            androidx.compose.ui.text.font.FontFamily r1 = (androidx.compose.ui.text.font.FontFamily) r1
            goto L_0x0011
        L_0x000f:
            r1 = r42
        L_0x0011:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x004c
            androidx.compose.ui.text.font.FontWeight$Companion r2 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r8 = r2.getLight()
            r2 = 96
            long r6 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r2)
            r2 = -4613937818241073152(0xbff8000000000000, double:-1.5)
            long r13 = androidx.compose.ui.unit.TextUnitKt.getSp((double) r2)
            androidx.compose.ui.text.TextStyle r2 = new androidx.compose.ui.text.TextStyle
            r3 = r2
            r4 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r26 = 0
            r27 = 262009(0x3ff79, float:3.67153E-40)
            r28 = 0
            r3.<init>((long) r4, (long) r6, (androidx.compose.ui.text.font.FontWeight) r8, (androidx.compose.ui.text.font.FontStyle) r9, (androidx.compose.ui.text.font.FontSynthesis) r10, (androidx.compose.ui.text.font.FontFamily) r11, (java.lang.String) r12, (long) r13, (androidx.compose.ui.text.style.BaselineShift) r15, (androidx.compose.ui.text.style.TextGeometricTransform) r16, (androidx.compose.ui.text.intl.LocaleList) r17, (long) r18, (androidx.compose.ui.text.style.TextDecoration) r20, (androidx.compose.ui.graphics.Shadow) r21, (androidx.compose.ui.text.style.TextAlign) r22, (androidx.compose.ui.text.style.TextDirection) r23, (long) r24, (androidx.compose.ui.text.style.TextIndent) r26, (int) r27, (kotlin.jvm.internal.DefaultConstructorMarker) r28)
            goto L_0x004e
        L_0x004c:
            r2 = r43
        L_0x004e:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x008a
            androidx.compose.ui.text.font.FontWeight$Companion r3 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r9 = r3.getLight()
            r3 = 60
            long r7 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r3)
            r3 = -4620693217682128896(0xbfe0000000000000, double:-0.5)
            long r14 = androidx.compose.ui.unit.TextUnitKt.getSp((double) r3)
            androidx.compose.ui.text.TextStyle r3 = new androidx.compose.ui.text.TextStyle
            r4 = r3
            r5 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r27 = 0
            r28 = 262009(0x3ff79, float:3.67153E-40)
            r29 = 0
            r4.<init>((long) r5, (long) r7, (androidx.compose.ui.text.font.FontWeight) r9, (androidx.compose.ui.text.font.FontStyle) r10, (androidx.compose.ui.text.font.FontSynthesis) r11, (androidx.compose.ui.text.font.FontFamily) r12, (java.lang.String) r13, (long) r14, (androidx.compose.ui.text.style.BaselineShift) r16, (androidx.compose.ui.text.style.TextGeometricTransform) r17, (androidx.compose.ui.text.intl.LocaleList) r18, (long) r19, (androidx.compose.ui.text.style.TextDecoration) r21, (androidx.compose.ui.graphics.Shadow) r22, (androidx.compose.ui.text.style.TextAlign) r23, (androidx.compose.ui.text.style.TextDirection) r24, (long) r25, (androidx.compose.ui.text.style.TextIndent) r27, (int) r28, (kotlin.jvm.internal.DefaultConstructorMarker) r29)
            goto L_0x008c
        L_0x008a:
            r3 = r44
        L_0x008c:
            r4 = r0 & 8
            r5 = 0
            if (r4 == 0) goto L_0x00c7
            androidx.compose.ui.text.font.FontWeight$Companion r4 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r11 = r4.getNormal()
            r4 = 48
            long r9 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r4)
            long r16 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r5)
            androidx.compose.ui.text.TextStyle r4 = new androidx.compose.ui.text.TextStyle
            r6 = r4
            r7 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r29 = 0
            r30 = 262009(0x3ff79, float:3.67153E-40)
            r31 = 0
            r6.<init>((long) r7, (long) r9, (androidx.compose.ui.text.font.FontWeight) r11, (androidx.compose.ui.text.font.FontStyle) r12, (androidx.compose.ui.text.font.FontSynthesis) r13, (androidx.compose.ui.text.font.FontFamily) r14, (java.lang.String) r15, (long) r16, (androidx.compose.ui.text.style.BaselineShift) r18, (androidx.compose.ui.text.style.TextGeometricTransform) r19, (androidx.compose.ui.text.intl.LocaleList) r20, (long) r21, (androidx.compose.ui.text.style.TextDecoration) r23, (androidx.compose.ui.graphics.Shadow) r24, (androidx.compose.ui.text.style.TextAlign) r25, (androidx.compose.ui.text.style.TextDirection) r26, (long) r27, (androidx.compose.ui.text.style.TextIndent) r29, (int) r30, (kotlin.jvm.internal.DefaultConstructorMarker) r31)
            goto L_0x00c9
        L_0x00c7:
            r4 = r45
        L_0x00c9:
            r6 = r0 & 16
            r7 = 4598175219545276416(0x3fd0000000000000, double:0.25)
            if (r6 == 0) goto L_0x0108
            androidx.compose.ui.text.font.FontWeight$Companion r6 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r14 = r6.getNormal()
            r6 = 34
            long r12 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r6)
            long r19 = androidx.compose.ui.unit.TextUnitKt.getSp((double) r7)
            androidx.compose.ui.text.TextStyle r6 = new androidx.compose.ui.text.TextStyle
            r9 = r6
            r10 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r32 = 0
            r33 = 262009(0x3ff79, float:3.67153E-40)
            r34 = 0
            r9.<init>((long) r10, (long) r12, (androidx.compose.ui.text.font.FontWeight) r14, (androidx.compose.ui.text.font.FontStyle) r15, (androidx.compose.ui.text.font.FontSynthesis) r16, (androidx.compose.ui.text.font.FontFamily) r17, (java.lang.String) r18, (long) r19, (androidx.compose.ui.text.style.BaselineShift) r21, (androidx.compose.ui.text.style.TextGeometricTransform) r22, (androidx.compose.ui.text.intl.LocaleList) r23, (long) r24, (androidx.compose.ui.text.style.TextDecoration) r26, (androidx.compose.ui.graphics.Shadow) r27, (androidx.compose.ui.text.style.TextAlign) r28, (androidx.compose.ui.text.style.TextDirection) r29, (long) r30, (androidx.compose.ui.text.style.TextIndent) r32, (int) r33, (kotlin.jvm.internal.DefaultConstructorMarker) r34)
            goto L_0x010a
        L_0x0108:
            r6 = r46
        L_0x010a:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x0148
            androidx.compose.ui.text.font.FontWeight$Companion r9 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r15 = r9.getNormal()
            r9 = 24
            long r13 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r9)
            long r20 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r5)
            androidx.compose.ui.text.TextStyle r5 = new androidx.compose.ui.text.TextStyle
            r10 = r5
            r11 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r33 = 0
            r34 = 262009(0x3ff79, float:3.67153E-40)
            r35 = 0
            r10.<init>((long) r11, (long) r13, (androidx.compose.ui.text.font.FontWeight) r15, (androidx.compose.ui.text.font.FontStyle) r16, (androidx.compose.ui.text.font.FontSynthesis) r17, (androidx.compose.ui.text.font.FontFamily) r18, (java.lang.String) r19, (long) r20, (androidx.compose.ui.text.style.BaselineShift) r22, (androidx.compose.ui.text.style.TextGeometricTransform) r23, (androidx.compose.ui.text.intl.LocaleList) r24, (long) r25, (androidx.compose.ui.text.style.TextDecoration) r27, (androidx.compose.ui.graphics.Shadow) r28, (androidx.compose.ui.text.style.TextAlign) r29, (androidx.compose.ui.text.style.TextDirection) r30, (long) r31, (androidx.compose.ui.text.style.TextIndent) r33, (int) r34, (kotlin.jvm.internal.DefaultConstructorMarker) r35)
            goto L_0x014a
        L_0x0148:
            r5 = r47
        L_0x014a:
            r9 = r0 & 64
            r10 = 4594572339843380019(0x3fc3333333333333, double:0.15)
            if (r9 == 0) goto L_0x018d
            androidx.compose.ui.text.font.FontWeight$Companion r9 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r17 = r9.getMedium()
            r9 = 20
            long r15 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r9)
            long r22 = androidx.compose.ui.unit.TextUnitKt.getSp((double) r10)
            androidx.compose.ui.text.TextStyle r9 = new androidx.compose.ui.text.TextStyle
            r12 = r9
            r13 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r35 = 0
            r36 = 262009(0x3ff79, float:3.67153E-40)
            r37 = 0
            r12.<init>((long) r13, (long) r15, (androidx.compose.ui.text.font.FontWeight) r17, (androidx.compose.ui.text.font.FontStyle) r18, (androidx.compose.ui.text.font.FontSynthesis) r19, (androidx.compose.ui.text.font.FontFamily) r20, (java.lang.String) r21, (long) r22, (androidx.compose.ui.text.style.BaselineShift) r24, (androidx.compose.ui.text.style.TextGeometricTransform) r25, (androidx.compose.ui.text.intl.LocaleList) r26, (long) r27, (androidx.compose.ui.text.style.TextDecoration) r29, (androidx.compose.ui.graphics.Shadow) r30, (androidx.compose.ui.text.style.TextAlign) r31, (androidx.compose.ui.text.style.TextDirection) r32, (long) r33, (androidx.compose.ui.text.style.TextIndent) r35, (int) r36, (kotlin.jvm.internal.DefaultConstructorMarker) r37)
            goto L_0x018f
        L_0x018d:
            r9 = r48
        L_0x018f:
            r12 = r0 & 128(0x80, float:1.794E-43)
            r13 = 16
            if (r12 == 0) goto L_0x01cd
            androidx.compose.ui.text.font.FontWeight$Companion r12 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r19 = r12.getNormal()
            long r17 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r13)
            long r24 = androidx.compose.ui.unit.TextUnitKt.getSp((double) r10)
            androidx.compose.ui.text.TextStyle r10 = new androidx.compose.ui.text.TextStyle
            r14 = r10
            r15 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r37 = 0
            r38 = 262009(0x3ff79, float:3.67153E-40)
            r39 = 0
            r14.<init>((long) r15, (long) r17, (androidx.compose.ui.text.font.FontWeight) r19, (androidx.compose.ui.text.font.FontStyle) r20, (androidx.compose.ui.text.font.FontSynthesis) r21, (androidx.compose.ui.text.font.FontFamily) r22, (java.lang.String) r23, (long) r24, (androidx.compose.ui.text.style.BaselineShift) r26, (androidx.compose.ui.text.style.TextGeometricTransform) r27, (androidx.compose.ui.text.intl.LocaleList) r28, (long) r29, (androidx.compose.ui.text.style.TextDecoration) r31, (androidx.compose.ui.graphics.Shadow) r32, (androidx.compose.ui.text.style.TextAlign) r33, (androidx.compose.ui.text.style.TextDirection) r34, (long) r35, (androidx.compose.ui.text.style.TextIndent) r37, (int) r38, (kotlin.jvm.internal.DefaultConstructorMarker) r39)
            goto L_0x01cf
        L_0x01cd:
            r10 = r49
        L_0x01cf:
            r11 = r0 & 256(0x100, float:3.59E-43)
            r12 = 14
            if (r11 == 0) goto L_0x0212
            androidx.compose.ui.text.font.FontWeight$Companion r11 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r19 = r11.getMedium()
            long r17 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r12)
            r14 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            long r24 = androidx.compose.ui.unit.TextUnitKt.getSp((double) r14)
            androidx.compose.ui.text.TextStyle r11 = new androidx.compose.ui.text.TextStyle
            r14 = r11
            r15 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r37 = 0
            r38 = 262009(0x3ff79, float:3.67153E-40)
            r39 = 0
            r14.<init>((long) r15, (long) r17, (androidx.compose.ui.text.font.FontWeight) r19, (androidx.compose.ui.text.font.FontStyle) r20, (androidx.compose.ui.text.font.FontSynthesis) r21, (androidx.compose.ui.text.font.FontFamily) r22, (java.lang.String) r23, (long) r24, (androidx.compose.ui.text.style.BaselineShift) r26, (androidx.compose.ui.text.style.TextGeometricTransform) r27, (androidx.compose.ui.text.intl.LocaleList) r28, (long) r29, (androidx.compose.ui.text.style.TextDecoration) r31, (androidx.compose.ui.graphics.Shadow) r32, (androidx.compose.ui.text.style.TextAlign) r33, (androidx.compose.ui.text.style.TextDirection) r34, (long) r35, (androidx.compose.ui.text.style.TextIndent) r37, (int) r38, (kotlin.jvm.internal.DefaultConstructorMarker) r39)
            goto L_0x0214
        L_0x0212:
            r11 = r50
        L_0x0214:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x0252
            androidx.compose.ui.text.font.FontWeight$Companion r14 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r20 = r14.getNormal()
            long r18 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r13)
            r13 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            long r25 = androidx.compose.ui.unit.TextUnitKt.getSp((double) r13)
            androidx.compose.ui.text.TextStyle r13 = new androidx.compose.ui.text.TextStyle
            r15 = r13
            r16 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r38 = 0
            r39 = 262009(0x3ff79, float:3.67153E-40)
            r40 = 0
            r15.<init>((long) r16, (long) r18, (androidx.compose.ui.text.font.FontWeight) r20, (androidx.compose.ui.text.font.FontStyle) r21, (androidx.compose.ui.text.font.FontSynthesis) r22, (androidx.compose.ui.text.font.FontFamily) r23, (java.lang.String) r24, (long) r25, (androidx.compose.ui.text.style.BaselineShift) r27, (androidx.compose.ui.text.style.TextGeometricTransform) r28, (androidx.compose.ui.text.intl.LocaleList) r29, (long) r30, (androidx.compose.ui.text.style.TextDecoration) r32, (androidx.compose.ui.graphics.Shadow) r33, (androidx.compose.ui.text.style.TextAlign) r34, (androidx.compose.ui.text.style.TextDirection) r35, (long) r36, (androidx.compose.ui.text.style.TextIndent) r38, (int) r39, (kotlin.jvm.internal.DefaultConstructorMarker) r40)
            goto L_0x0254
        L_0x0252:
            r13 = r51
        L_0x0254:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x0290
            androidx.compose.ui.text.font.FontWeight$Companion r14 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r20 = r14.getNormal()
            long r18 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r12)
            long r25 = androidx.compose.ui.unit.TextUnitKt.getSp((double) r7)
            androidx.compose.ui.text.TextStyle r7 = new androidx.compose.ui.text.TextStyle
            r15 = r7
            r16 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r38 = 0
            r39 = 262009(0x3ff79, float:3.67153E-40)
            r40 = 0
            r15.<init>((long) r16, (long) r18, (androidx.compose.ui.text.font.FontWeight) r20, (androidx.compose.ui.text.font.FontStyle) r21, (androidx.compose.ui.text.font.FontSynthesis) r22, (androidx.compose.ui.text.font.FontFamily) r23, (java.lang.String) r24, (long) r25, (androidx.compose.ui.text.style.BaselineShift) r27, (androidx.compose.ui.text.style.TextGeometricTransform) r28, (androidx.compose.ui.text.intl.LocaleList) r29, (long) r30, (androidx.compose.ui.text.style.TextDecoration) r32, (androidx.compose.ui.graphics.Shadow) r33, (androidx.compose.ui.text.style.TextAlign) r34, (androidx.compose.ui.text.style.TextDirection) r35, (long) r36, (androidx.compose.ui.text.style.TextIndent) r38, (int) r39, (kotlin.jvm.internal.DefaultConstructorMarker) r40)
            goto L_0x0292
        L_0x0290:
            r7 = r52
        L_0x0292:
            r8 = r0 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x02d0
            androidx.compose.ui.text.font.FontWeight$Companion r8 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r19 = r8.getMedium()
            long r17 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r12)
            r14 = 4608308318706860032(0x3ff4000000000000, double:1.25)
            long r24 = androidx.compose.ui.unit.TextUnitKt.getSp((double) r14)
            androidx.compose.ui.text.TextStyle r8 = new androidx.compose.ui.text.TextStyle
            r14 = r8
            r15 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r37 = 0
            r38 = 262009(0x3ff79, float:3.67153E-40)
            r39 = 0
            r14.<init>((long) r15, (long) r17, (androidx.compose.ui.text.font.FontWeight) r19, (androidx.compose.ui.text.font.FontStyle) r20, (androidx.compose.ui.text.font.FontSynthesis) r21, (androidx.compose.ui.text.font.FontFamily) r22, (java.lang.String) r23, (long) r24, (androidx.compose.ui.text.style.BaselineShift) r26, (androidx.compose.ui.text.style.TextGeometricTransform) r27, (androidx.compose.ui.text.intl.LocaleList) r28, (long) r29, (androidx.compose.ui.text.style.TextDecoration) r31, (androidx.compose.ui.graphics.Shadow) r32, (androidx.compose.ui.text.style.TextAlign) r33, (androidx.compose.ui.text.style.TextDirection) r34, (long) r35, (androidx.compose.ui.text.style.TextIndent) r37, (int) r38, (kotlin.jvm.internal.DefaultConstructorMarker) r39)
            goto L_0x02d2
        L_0x02d0:
            r8 = r53
        L_0x02d2:
            r12 = r0 & 4096(0x1000, float:5.74E-42)
            if (r12 == 0) goto L_0x0315
            androidx.compose.ui.text.font.FontWeight$Companion r12 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r19 = r12.getNormal()
            r12 = 12
            long r17 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r12)
            r14 = 4600877379321698714(0x3fd999999999999a, double:0.4)
            long r24 = androidx.compose.ui.unit.TextUnitKt.getSp((double) r14)
            androidx.compose.ui.text.TextStyle r12 = new androidx.compose.ui.text.TextStyle
            r14 = r12
            r15 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r37 = 0
            r38 = 262009(0x3ff79, float:3.67153E-40)
            r39 = 0
            r14.<init>((long) r15, (long) r17, (androidx.compose.ui.text.font.FontWeight) r19, (androidx.compose.ui.text.font.FontStyle) r20, (androidx.compose.ui.text.font.FontSynthesis) r21, (androidx.compose.ui.text.font.FontFamily) r22, (java.lang.String) r23, (long) r24, (androidx.compose.ui.text.style.BaselineShift) r26, (androidx.compose.ui.text.style.TextGeometricTransform) r27, (androidx.compose.ui.text.intl.LocaleList) r28, (long) r29, (androidx.compose.ui.text.style.TextDecoration) r31, (androidx.compose.ui.graphics.Shadow) r32, (androidx.compose.ui.text.style.TextAlign) r33, (androidx.compose.ui.text.style.TextDirection) r34, (long) r35, (androidx.compose.ui.text.style.TextIndent) r37, (int) r38, (kotlin.jvm.internal.DefaultConstructorMarker) r39)
            goto L_0x0317
        L_0x0315:
            r12 = r54
        L_0x0317:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0357
            androidx.compose.ui.text.font.FontWeight$Companion r0 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r19 = r0.getNormal()
            r0 = 10
            long r17 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r0)
            r14 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            long r24 = androidx.compose.ui.unit.TextUnitKt.getSp((double) r14)
            androidx.compose.ui.text.TextStyle r0 = new androidx.compose.ui.text.TextStyle
            r14 = r0
            r15 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r37 = 0
            r38 = 262009(0x3ff79, float:3.67153E-40)
            r39 = 0
            r14.<init>((long) r15, (long) r17, (androidx.compose.ui.text.font.FontWeight) r19, (androidx.compose.ui.text.font.FontStyle) r20, (androidx.compose.ui.text.font.FontSynthesis) r21, (androidx.compose.ui.text.font.FontFamily) r22, (java.lang.String) r23, (long) r24, (androidx.compose.ui.text.style.BaselineShift) r26, (androidx.compose.ui.text.style.TextGeometricTransform) r27, (androidx.compose.ui.text.intl.LocaleList) r28, (long) r29, (androidx.compose.ui.text.style.TextDecoration) r31, (androidx.compose.ui.graphics.Shadow) r32, (androidx.compose.ui.text.style.TextAlign) r33, (androidx.compose.ui.text.style.TextDirection) r34, (long) r35, (androidx.compose.ui.text.style.TextIndent) r37, (int) r38, (kotlin.jvm.internal.DefaultConstructorMarker) r39)
            goto L_0x0359
        L_0x0357:
            r0 = r55
        L_0x0359:
            r42 = r41
            r43 = r1
            r44 = r2
            r45 = r3
            r46 = r4
            r47 = r6
            r48 = r5
            r49 = r9
            r50 = r10
            r51 = r11
            r52 = r13
            r53 = r7
            r54 = r8
            r55 = r12
            r56 = r0
            r42.<init>(r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.Typography.<init>(androidx.compose.ui.text.font.FontFamily, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Typography(androidx.compose.ui.text.font.FontFamily r2, androidx.compose.ui.text.TextStyle r3, androidx.compose.ui.text.TextStyle r4, androidx.compose.ui.text.TextStyle r5, androidx.compose.ui.text.TextStyle r6, androidx.compose.ui.text.TextStyle r7, androidx.compose.ui.text.TextStyle r8, androidx.compose.ui.text.TextStyle r9, androidx.compose.ui.text.TextStyle r10, androidx.compose.ui.text.TextStyle r11, androidx.compose.ui.text.TextStyle r12, androidx.compose.ui.text.TextStyle r13, androidx.compose.ui.text.TextStyle r14, androidx.compose.ui.text.TextStyle r15) {
        /*
            r1 = this;
            java.lang.String r0 = "defaultFontFamily"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "h1"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "h2"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "h3"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "h4"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "h5"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "h6"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "subtitle1"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "subtitle2"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "body1"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "body2"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "button"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "caption"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "overline"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            androidx.compose.ui.text.TextStyle r3 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r3, r2)
            androidx.compose.ui.text.TextStyle r4 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r4, r2)
            androidx.compose.ui.text.TextStyle r5 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r5, r2)
            androidx.compose.ui.text.TextStyle r6 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r6, r2)
            androidx.compose.ui.text.TextStyle r7 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r7, r2)
            androidx.compose.ui.text.TextStyle r8 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r8, r2)
            androidx.compose.ui.text.TextStyle r9 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r9, r2)
            androidx.compose.ui.text.TextStyle r10 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r10, r2)
            androidx.compose.ui.text.TextStyle r11 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r11, r2)
            androidx.compose.ui.text.TextStyle r12 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r12, r2)
            androidx.compose.ui.text.TextStyle r13 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r13, r2)
            androidx.compose.ui.text.TextStyle r14 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r14, r2)
            androidx.compose.ui.text.TextStyle r15 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r15, r2)
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.Typography.<init>(androidx.compose.ui.text.font.FontFamily, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle):void");
    }

    public static /* synthetic */ Typography copy$default(Typography typography, TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13, int i, Object obj) {
        TextStyle textStyle14;
        Typography typography2 = typography;
        int i2 = i;
        TextStyle textStyle15 = (i2 & 1) != 0 ? typography2.h1 : textStyle;
        TextStyle textStyle16 = (i2 & 2) != 0 ? typography2.h2 : textStyle2;
        TextStyle textStyle17 = (i2 & 4) != 0 ? typography2.h3 : textStyle3;
        TextStyle textStyle18 = (i2 & 8) != 0 ? typography2.h4 : textStyle4;
        TextStyle textStyle19 = (i2 & 16) != 0 ? typography2.h5 : textStyle5;
        TextStyle textStyle20 = (i2 & 32) != 0 ? typography2.h6 : textStyle6;
        TextStyle textStyle21 = (i2 & 64) != 0 ? typography2.subtitle1 : textStyle7;
        TextStyle textStyle22 = (i2 & 128) != 0 ? typography2.subtitle2 : textStyle8;
        TextStyle textStyle23 = (i2 & 256) != 0 ? typography2.body1 : textStyle9;
        TextStyle textStyle24 = (i2 & 512) != 0 ? typography2.body2 : textStyle10;
        TextStyle textStyle25 = (i2 & 1024) != 0 ? typography2.button : textStyle11;
        TextStyle textStyle26 = (i2 & 2048) != 0 ? typography2.caption : textStyle12;
        if ((i2 & 4096) != 0) {
            textStyle14 = typography2.overline;
        } else {
            textStyle14 = textStyle13;
        }
        return typography.copy(textStyle15, textStyle16, textStyle17, textStyle18, textStyle19, textStyle20, textStyle21, textStyle22, textStyle23, textStyle24, textStyle25, textStyle26, textStyle14);
    }

    public final Typography copy(TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13) {
        TextStyle textStyle14 = textStyle;
        Intrinsics.checkNotNullParameter(textStyle14, "h1");
        TextStyle textStyle15 = textStyle2;
        Intrinsics.checkNotNullParameter(textStyle15, "h2");
        TextStyle textStyle16 = textStyle3;
        Intrinsics.checkNotNullParameter(textStyle16, "h3");
        TextStyle textStyle17 = textStyle4;
        Intrinsics.checkNotNullParameter(textStyle17, "h4");
        TextStyle textStyle18 = textStyle5;
        Intrinsics.checkNotNullParameter(textStyle18, "h5");
        TextStyle textStyle19 = textStyle6;
        Intrinsics.checkNotNullParameter(textStyle19, "h6");
        TextStyle textStyle20 = textStyle7;
        Intrinsics.checkNotNullParameter(textStyle20, "subtitle1");
        TextStyle textStyle21 = textStyle8;
        Intrinsics.checkNotNullParameter(textStyle21, "subtitle2");
        TextStyle textStyle22 = textStyle9;
        Intrinsics.checkNotNullParameter(textStyle22, "body1");
        TextStyle textStyle23 = textStyle10;
        Intrinsics.checkNotNullParameter(textStyle23, "body2");
        TextStyle textStyle24 = textStyle11;
        Intrinsics.checkNotNullParameter(textStyle24, "button");
        TextStyle textStyle25 = textStyle12;
        Intrinsics.checkNotNullParameter(textStyle25, ShareConstants.FEED_CAPTION_PARAM);
        TextStyle textStyle26 = textStyle13;
        Intrinsics.checkNotNullParameter(textStyle26, "overline");
        return new Typography(textStyle14, textStyle15, textStyle16, textStyle17, textStyle18, textStyle19, textStyle20, textStyle21, textStyle22, textStyle23, textStyle24, textStyle25, textStyle26);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Typography)) {
            return false;
        }
        Typography typography = (Typography) obj;
        return Intrinsics.areEqual((Object) this.h1, (Object) typography.h1) && Intrinsics.areEqual((Object) this.h2, (Object) typography.h2) && Intrinsics.areEqual((Object) this.h3, (Object) typography.h3) && Intrinsics.areEqual((Object) this.h4, (Object) typography.h4) && Intrinsics.areEqual((Object) this.h5, (Object) typography.h5) && Intrinsics.areEqual((Object) this.h6, (Object) typography.h6) && Intrinsics.areEqual((Object) this.subtitle1, (Object) typography.subtitle1) && Intrinsics.areEqual((Object) this.subtitle2, (Object) typography.subtitle2) && Intrinsics.areEqual((Object) this.body1, (Object) typography.body1) && Intrinsics.areEqual((Object) this.body2, (Object) typography.body2) && Intrinsics.areEqual((Object) this.button, (Object) typography.button) && Intrinsics.areEqual((Object) this.caption, (Object) typography.caption) && Intrinsics.areEqual((Object) this.overline, (Object) typography.overline);
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.h1.hashCode() * 31) + this.h2.hashCode()) * 31) + this.h3.hashCode()) * 31) + this.h4.hashCode()) * 31) + this.h5.hashCode()) * 31) + this.h6.hashCode()) * 31) + this.subtitle1.hashCode()) * 31) + this.subtitle2.hashCode()) * 31) + this.body1.hashCode()) * 31) + this.body2.hashCode()) * 31) + this.button.hashCode()) * 31) + this.caption.hashCode()) * 31) + this.overline.hashCode();
    }

    public String toString() {
        return "Typography(h1=" + this.h1 + ", h2=" + this.h2 + ", h3=" + this.h3 + ", h4=" + this.h4 + ", h5=" + this.h5 + ", h6=" + this.h6 + ", subtitle1=" + this.subtitle1 + ", subtitle2=" + this.subtitle2 + ", body1=" + this.body1 + ", body2=" + this.body2 + ", button=" + this.button + ", caption=" + this.caption + ", overline=" + this.overline + ')';
    }
}
