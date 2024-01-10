package androidx.compose.ui.text;

import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B8\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tø\u0001\u0000¢\u0006\u0002\u0010\nBP\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fB\\\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011ø\u0001\u0000¢\u0006\u0002\u0010\u0012JA\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$JY\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&Jg\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010,\u001a\u00020-H\u0016J\u0014\u0010.\u001a\u00020\u00002\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0000H\u0007J\u0014\u0010/\u001a\u0004\u0018\u00010\f2\b\u0010+\u001a\u0004\u0018\u00010\fH\u0002J\u0011\u00100\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0000H\u0002J\b\u00101\u001a\u000202H\u0016R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00063"}, d2 = {"Landroidx/compose/ui/text/ParagraphStyle;", "", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "Landroidx/compose/ui/unit/TextUnit;", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "platformStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLineBreak", "()Landroidx/compose/ui/text/style/LineBreak;", "getLineHeight-XSAIIZE", "()J", "J", "getLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformParagraphStyle;", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "getTextDirection-mmuk1to", "()Landroidx/compose/ui/text/style/TextDirection;", "getTextIndent", "()Landroidx/compose/ui/text/style/TextIndent;", "copy", "copy-Elsmlbk", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-xPh5V4g", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-iMcjlh8", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;)Landroidx/compose/ui/text/ParagraphStyle;", "equals", "", "other", "hashCode", "", "merge", "mergePlatformStyle", "plus", "toString", "", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ParagraphStyle.kt */
public final class ParagraphStyle {
    private final LineBreak lineBreak;
    private final long lineHeight;
    private final LineHeightStyle lineHeightStyle;
    private final PlatformParagraphStyle platformStyle;
    private final TextAlign textAlign;
    private final TextDirection textDirection;
    private final TextIndent textIndent;

    @ExperimentalTextApi
    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign2, textDirection2, j, textIndent2, platformParagraphStyle, lineHeightStyle2, lineBreak2);
    }

    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign2, textDirection2, j, textIndent2, platformParagraphStyle, lineHeightStyle2);
    }

    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign2, textDirection2, j, textIndent2);
    }

    private ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2) {
        this.textAlign = textAlign2;
        this.textDirection = textDirection2;
        this.lineHeight = j;
        this.textIndent = textIndent2;
        this.platformStyle = platformParagraphStyle;
        this.lineHeightStyle = lineHeightStyle2;
        this.lineBreak = lineBreak2;
        if (!TextUnit.m4882equalsimpl0(j, TextUnit.Companion.m4896getUnspecifiedXSAIIZE())) {
            if (!(TextUnit.m4885getValueimpl(this.lineHeight) >= 0.0f)) {
                throw new IllegalStateException(("lineHeight can't be negative (" + TextUnit.m4885getValueimpl(this.lineHeight) + ')').toString());
            }
        }
    }

    /* renamed from: getTextAlign-buA522U  reason: not valid java name */
    public final TextAlign m4144getTextAlignbuA522U() {
        return this.textAlign;
    }

    /* renamed from: getTextDirection-mmuk1to  reason: not valid java name */
    public final TextDirection m4145getTextDirectionmmuk1to() {
        return this.textDirection;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ParagraphStyle(androidx.compose.ui.text.style.TextAlign r10, androidx.compose.ui.text.style.TextDirection r11, long r12, androidx.compose.ui.text.style.TextIndent r14, androidx.compose.ui.text.PlatformParagraphStyle r15, androidx.compose.ui.text.style.LineHeightStyle r16, androidx.compose.ui.text.style.LineBreak r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18 & 1
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0008
        L_0x0007:
            r0 = r10
        L_0x0008:
            r2 = r18 & 2
            if (r2 == 0) goto L_0x000e
            r2 = r1
            goto L_0x000f
        L_0x000e:
            r2 = r11
        L_0x000f:
            r3 = r18 & 4
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m4896getUnspecifiedXSAIIZE()
            goto L_0x001b
        L_0x001a:
            r3 = r12
        L_0x001b:
            r5 = r18 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r1
            goto L_0x0022
        L_0x0021:
            r5 = r14
        L_0x0022:
            r6 = r18 & 16
            if (r6 == 0) goto L_0x0028
            r6 = r1
            goto L_0x0029
        L_0x0028:
            r6 = r15
        L_0x0029:
            r7 = r18 & 32
            if (r7 == 0) goto L_0x002f
            r7 = r1
            goto L_0x0031
        L_0x002f:
            r7 = r16
        L_0x0031:
            r8 = r18 & 64
            if (r8 == 0) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r1 = r17
        L_0x0038:
            r8 = 0
            r10 = r9
            r11 = r0
            r12 = r2
            r13 = r3
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r1
            r19 = r8
            r10.<init>((androidx.compose.ui.text.style.TextAlign) r11, (androidx.compose.ui.text.style.TextDirection) r12, (long) r13, (androidx.compose.ui.text.style.TextIndent) r15, (androidx.compose.ui.text.PlatformParagraphStyle) r16, (androidx.compose.ui.text.style.LineHeightStyle) r17, (androidx.compose.ui.text.style.LineBreak) r18, (kotlin.jvm.internal.DefaultConstructorMarker) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.ParagraphStyle.<init>(androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformParagraphStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: getLineHeight-XSAIIZE  reason: not valid java name */
    public final long m4143getLineHeightXSAIIZE() {
        return this.lineHeight;
    }

    public final TextIndent getTextIndent() {
        return this.textIndent;
    }

    public final PlatformParagraphStyle getPlatformStyle() {
        return this.platformStyle;
    }

    public final LineHeightStyle getLineHeightStyle() {
        return this.lineHeightStyle;
    }

    @ExperimentalTextApi
    public final LineBreak getLineBreak() {
        return this.lineBreak;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textAlign2, (i & 2) != 0 ? null : textDirection2, (i & 4) != 0 ? TextUnit.Companion.m4896getUnspecifiedXSAIIZE() : j, (i & 8) != 0 ? null : textIndent2, (DefaultConstructorMarker) null);
    }

    private ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2) {
        this(textAlign2, textDirection2, j, textIndent2, (PlatformParagraphStyle) null, (LineHeightStyle) null, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ParagraphStyle(androidx.compose.ui.text.style.TextAlign r9, androidx.compose.ui.text.style.TextDirection r10, long r11, androidx.compose.ui.text.style.TextIndent r13, androidx.compose.ui.text.PlatformParagraphStyle r14, androidx.compose.ui.text.style.LineHeightStyle r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r8 = this;
            r0 = r16 & 1
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0008
        L_0x0007:
            r0 = r9
        L_0x0008:
            r2 = r16 & 2
            if (r2 == 0) goto L_0x000e
            r2 = r1
            goto L_0x000f
        L_0x000e:
            r2 = r10
        L_0x000f:
            r3 = r16 & 4
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m4896getUnspecifiedXSAIIZE()
            goto L_0x001b
        L_0x001a:
            r3 = r11
        L_0x001b:
            r5 = r16 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r1
            goto L_0x0022
        L_0x0021:
            r5 = r13
        L_0x0022:
            r6 = r16 & 16
            if (r6 == 0) goto L_0x0028
            r6 = r1
            goto L_0x0029
        L_0x0028:
            r6 = r14
        L_0x0029:
            r7 = r16 & 32
            if (r7 == 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r1 = r15
        L_0x002f:
            r7 = 0
            r9 = r8
            r10 = r0
            r11 = r2
            r12 = r3
            r14 = r5
            r15 = r6
            r16 = r1
            r17 = r7
            r9.<init>((androidx.compose.ui.text.style.TextAlign) r10, (androidx.compose.ui.text.style.TextDirection) r11, (long) r12, (androidx.compose.ui.text.style.TextIndent) r14, (androidx.compose.ui.text.PlatformParagraphStyle) r15, (androidx.compose.ui.text.style.LineHeightStyle) r16, (kotlin.jvm.internal.DefaultConstructorMarker) r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.ParagraphStyle.<init>(androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformParagraphStyle, androidx.compose.ui.text.style.LineHeightStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2) {
        this(textAlign2, textDirection2, j, textIndent2, platformParagraphStyle, lineHeightStyle2, (LineBreak) null, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ParagraphStyle merge$default(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            paragraphStyle2 = null;
        }
        return paragraphStyle.merge(paragraphStyle2);
    }

    public final ParagraphStyle merge(ParagraphStyle paragraphStyle) {
        long j;
        if (paragraphStyle == null) {
            return this;
        }
        if (TextUnitKt.m4903isUnspecifiedR2X_6o(paragraphStyle.lineHeight)) {
            j = this.lineHeight;
        } else {
            j = paragraphStyle.lineHeight;
        }
        long j2 = j;
        TextIndent textIndent2 = paragraphStyle.textIndent;
        if (textIndent2 == null) {
            textIndent2 = this.textIndent;
        }
        TextIndent textIndent3 = textIndent2;
        TextAlign textAlign2 = paragraphStyle.textAlign;
        if (textAlign2 == null) {
            textAlign2 = this.textAlign;
        }
        TextAlign textAlign3 = textAlign2;
        TextDirection textDirection2 = paragraphStyle.textDirection;
        if (textDirection2 == null) {
            textDirection2 = this.textDirection;
        }
        TextDirection textDirection3 = textDirection2;
        PlatformParagraphStyle mergePlatformStyle = mergePlatformStyle(paragraphStyle.platformStyle);
        LineHeightStyle lineHeightStyle2 = paragraphStyle.lineHeightStyle;
        if (lineHeightStyle2 == null) {
            lineHeightStyle2 = this.lineHeightStyle;
        }
        LineHeightStyle lineHeightStyle3 = lineHeightStyle2;
        LineBreak lineBreak2 = paragraphStyle.lineBreak;
        if (lineBreak2 == null) {
            lineBreak2 = this.lineBreak;
        }
        return new ParagraphStyle(textAlign3, textDirection3, j2, textIndent3, mergePlatformStyle, lineHeightStyle3, lineBreak2, (DefaultConstructorMarker) null);
    }

    private final PlatformParagraphStyle mergePlatformStyle(PlatformParagraphStyle platformParagraphStyle) {
        PlatformParagraphStyle platformParagraphStyle2 = this.platformStyle;
        if (platformParagraphStyle2 == null) {
            return platformParagraphStyle;
        }
        if (platformParagraphStyle == null) {
            return platformParagraphStyle2;
        }
        return platformParagraphStyle2.merge(platformParagraphStyle);
    }

    public final ParagraphStyle plus(ParagraphStyle paragraphStyle) {
        Intrinsics.checkNotNullParameter(paragraphStyle, "other");
        return merge(paragraphStyle);
    }

    /* renamed from: copy-Elsmlbk$default  reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m4137copyElsmlbk$default(ParagraphStyle paragraphStyle, TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, int i, Object obj) {
        if ((i & 1) != 0) {
            textAlign2 = paragraphStyle.textAlign;
        }
        if ((i & 2) != 0) {
            textDirection2 = paragraphStyle.textDirection;
        }
        TextDirection textDirection3 = textDirection2;
        if ((i & 4) != 0) {
            j = paragraphStyle.lineHeight;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            textIndent2 = paragraphStyle.textIndent;
        }
        return paragraphStyle.m4140copyElsmlbk(textAlign2, textDirection3, j2, textIndent2);
    }

    /* renamed from: copy-Elsmlbk  reason: not valid java name */
    public final ParagraphStyle m4140copyElsmlbk(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2) {
        return new ParagraphStyle(textAlign2, textDirection2, j, textIndent2, this.platformStyle, this.lineHeightStyle, this.lineBreak, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-xPh5V4g$default  reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m4139copyxPh5V4g$default(ParagraphStyle paragraphStyle, TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            textAlign2 = paragraphStyle.textAlign;
        }
        if ((i & 2) != 0) {
            textDirection2 = paragraphStyle.textDirection;
        }
        TextDirection textDirection3 = textDirection2;
        if ((i & 4) != 0) {
            j = paragraphStyle.lineHeight;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            textIndent2 = paragraphStyle.textIndent;
        }
        TextIndent textIndent3 = textIndent2;
        if ((i & 16) != 0) {
            platformParagraphStyle = paragraphStyle.platformStyle;
        }
        PlatformParagraphStyle platformParagraphStyle2 = platformParagraphStyle;
        if ((i & 32) != 0) {
            lineHeightStyle2 = paragraphStyle.lineHeightStyle;
        }
        return paragraphStyle.m4142copyxPh5V4g(textAlign2, textDirection3, j2, textIndent3, platformParagraphStyle2, lineHeightStyle2);
    }

    /* renamed from: copy-xPh5V4g  reason: not valid java name */
    public final ParagraphStyle m4142copyxPh5V4g(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2) {
        return new ParagraphStyle(textAlign2, textDirection2, j, textIndent2, platformParagraphStyle, lineHeightStyle2, this.lineBreak, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-iMcjlh8$default  reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m4138copyiMcjlh8$default(ParagraphStyle paragraphStyle, TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2, int i, Object obj) {
        LineBreak lineBreak3;
        ParagraphStyle paragraphStyle2 = paragraphStyle;
        TextAlign textAlign3 = (i & 1) != 0 ? paragraphStyle2.textAlign : textAlign2;
        TextDirection textDirection3 = (i & 2) != 0 ? paragraphStyle2.textDirection : textDirection2;
        long j2 = (i & 4) != 0 ? paragraphStyle2.lineHeight : j;
        TextIndent textIndent3 = (i & 8) != 0 ? paragraphStyle2.textIndent : textIndent2;
        PlatformParagraphStyle platformParagraphStyle2 = (i & 16) != 0 ? paragraphStyle2.platformStyle : platformParagraphStyle;
        LineHeightStyle lineHeightStyle3 = (i & 32) != 0 ? paragraphStyle2.lineHeightStyle : lineHeightStyle2;
        if ((i & 64) != 0) {
            lineBreak3 = paragraphStyle2.lineBreak;
        } else {
            lineBreak3 = lineBreak2;
        }
        return paragraphStyle.m4141copyiMcjlh8(textAlign3, textDirection3, j2, textIndent3, platformParagraphStyle2, lineHeightStyle3, lineBreak3);
    }

    @ExperimentalTextApi
    /* renamed from: copy-iMcjlh8  reason: not valid java name */
    public final ParagraphStyle m4141copyiMcjlh8(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2) {
        return new ParagraphStyle(textAlign2, textDirection2, j, textIndent2, platformParagraphStyle, lineHeightStyle2, lineBreak2, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParagraphStyle)) {
            return false;
        }
        ParagraphStyle paragraphStyle = (ParagraphStyle) obj;
        return Intrinsics.areEqual((Object) this.textAlign, (Object) paragraphStyle.textAlign) && Intrinsics.areEqual((Object) this.textDirection, (Object) paragraphStyle.textDirection) && TextUnit.m4882equalsimpl0(this.lineHeight, paragraphStyle.lineHeight) && Intrinsics.areEqual((Object) this.textIndent, (Object) paragraphStyle.textIndent) && Intrinsics.areEqual((Object) this.platformStyle, (Object) paragraphStyle.platformStyle) && Intrinsics.areEqual((Object) this.lineHeightStyle, (Object) paragraphStyle.lineHeightStyle) && Intrinsics.areEqual((Object) this.lineBreak, (Object) paragraphStyle.lineBreak);
    }

    public int hashCode() {
        TextAlign textAlign2 = this.textAlign;
        int i = 0;
        int r0 = (textAlign2 != null ? TextAlign.m4551hashCodeimpl(textAlign2.m4553unboximpl()) : 0) * 31;
        TextDirection textDirection2 = this.textDirection;
        int r02 = (((r0 + (textDirection2 != null ? TextDirection.m4564hashCodeimpl(textDirection2.m4566unboximpl()) : 0)) * 31) + TextUnit.m4886hashCodeimpl(this.lineHeight)) * 31;
        TextIndent textIndent2 = this.textIndent;
        int hashCode = (r02 + (textIndent2 != null ? textIndent2.hashCode() : 0)) * 31;
        PlatformParagraphStyle platformParagraphStyle = this.platformStyle;
        int hashCode2 = (hashCode + (platformParagraphStyle != null ? platformParagraphStyle.hashCode() : 0)) * 31;
        LineHeightStyle lineHeightStyle2 = this.lineHeightStyle;
        int hashCode3 = (hashCode2 + (lineHeightStyle2 != null ? lineHeightStyle2.hashCode() : 0)) * 31;
        LineBreak lineBreak2 = this.lineBreak;
        if (lineBreak2 != null) {
            i = lineBreak2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ParagraphStyle(textAlign=" + this.textAlign + ", textDirection=" + this.textDirection + ", lineHeight=" + TextUnit.m4892toStringimpl(this.lineHeight) + ", textIndent=" + this.textIndent + ", platformStyle=" + this.platformStyle + ", lineHeightStyle=" + this.lineHeightStyle + ", lineBreak=" + this.lineBreak + ')';
    }
}
