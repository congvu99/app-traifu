package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import android.os.Build;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LocaleSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import androidx.compose.ui.text.android.style.FontFeatureSpan;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import androidx.compose.ui.text.android.style.LineHeightSpan;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.ui.text.android.style.ShadowSpan;
import androidx.compose.ui.text.android.style.SkewXSpan;
import androidx.compose.ui.text.android.style.TextDecorationSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000Ò\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a'\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001aF\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000e0\r2\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t0\u0010H\u0000\u001a-\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a\f\u0010\u0018\u001a\u00020\u0019*\u00020\u001aH\u0002\u001a\u0016\u0010\u001b\u001a\u00020\u000b*\u0004\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002\u001a1\u0010\u001d\u001a\u00020\t*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$\u001a1\u0010%\u001a\u00020\t*\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b(\u001a.\u0010)\u001a\u00020\t*\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0002\u001a1\u0010-\u001a\u00020\t*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010$\u001aS\u0010/\u001a\u00020\t*\u00020\u001e2\u0006\u00100\u001a\u00020\u001a2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000e0\r2&\u00101\u001a\"\u0012\u0006\u0012\u0004\u0018\u000103\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020702H\u0002ø\u0001\u0001\u001a&\u00108\u001a\u00020\t*\u00020\u001e2\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0002\u001a9\u0010;\u001a\u00020\t*\u00020\u001e2\u0006\u0010<\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b=\u0010>\u001a&\u0010?\u001a\u00020\t*\u00020\u001e2\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0002\u001a1\u0010B\u001a\u00020\t*\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010D\u001a9\u0010B\u001a\u00020\t*\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010E\u001a\u00020FH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010H\u001a&\u0010I\u001a\u00020\t*\u00020\u001e2\b\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0000\u001a&\u0010L\u001a\u00020\t*\u00020\u001e2\b\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0002\u001a$\u0010O\u001a\u00020\t*\u00020\u001e2\u0006\u0010P\u001a\u00020Q2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0000\u001a:\u0010R\u001a\u00020\t*\u00020\u001e2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010T\u001a\u0012\u0012\u0004\u0012\u00020V0Uj\b\u0012\u0004\u0012\u00020V`WH\u0002\u001a[\u0010X\u001a\u00020\t*\u00020\u001e2\u0006\u00100\u001a\u00020\u001a2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000e0\r2\u0006\u0010\u0004\u001a\u00020\u00052&\u00101\u001a\"\u0012\u0006\u0012\u0004\u0018\u000103\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020702H\u0000ø\u0001\u0001\u001a&\u0010Y\u001a\u00020\t*\u00020\u001e2\b\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0000\u001a&\u0010\\\u001a\u00020\t*\u00020\u001e2\b\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006_"}, d2 = {"createLetterSpacingSpan", "Landroid/text/style/MetricAffectingSpan;", "letterSpacing", "Landroidx/compose/ui/unit/TextUnit;", "density", "Landroidx/compose/ui/unit/Density;", "createLetterSpacingSpan-eAf_CNQ", "(JLandroidx/compose/ui/unit/Density;)Landroid/text/style/MetricAffectingSpan;", "flattenFontStylesAndApply", "", "contextFontSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "block", "Lkotlin/Function3;", "", "resolveLineHeightInPx", "", "lineHeight", "contextFontSize", "resolveLineHeightInPx-o2QH7mI", "(JFLandroidx/compose/ui/unit/Density;)F", "hasFontAttributes", "", "Landroidx/compose/ui/text/TextStyle;", "merge", "spanStyle", "setBackground", "Landroid/text/Spannable;", "color", "Landroidx/compose/ui/graphics/Color;", "start", "end", "setBackground-RPmYEkk", "(Landroid/text/Spannable;JII)V", "setBaselineShift", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "setBaselineShift-0ocSgnM", "setBrush", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "setColor", "setColor-RPmYEkk", "setFontAttributes", "contextTextStyle", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "setFontFeatureSettings", "fontFeatureSettings", "", "setFontSize", "fontSize", "setFontSize-KmRG4DE", "(Landroid/text/Spannable;JLandroidx/compose/ui/unit/Density;II)V", "setGeometricTransform", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "setLineHeight", "setLineHeight-r9BaKPg", "(Landroid/text/Spannable;JFLandroidx/compose/ui/unit/Density;)V", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "setLineHeight-KmRG4DE", "(Landroid/text/Spannable;JFLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/style/LineHeightStyle;)V", "setLocaleList", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "setShadow", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "setSpan", "span", "", "setSpanStyle", "spanStyleRange", "lowPrioritySpans", "Ljava/util/ArrayList;", "Landroidx/compose/ui/text/platform/extensions/SpanRange;", "Lkotlin/collections/ArrayList;", "setSpanStyles", "setTextDecoration", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "setTextIndent", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: SpannableExtensions.android.kt */
public final class SpannableExtensions_androidKt {
    public static final void setSpan(Spannable spannable, Object obj, int i, int i2) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Intrinsics.checkNotNullParameter(obj, "span");
        spannable.setSpan(obj, i, i2, 33);
    }

    public static final void setTextIndent(Spannable spannable, TextIndent textIndent, float f, Density density) {
        float f2;
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Intrinsics.checkNotNullParameter(density, "density");
        if (textIndent == null) {
            return;
        }
        if ((!TextUnit.m4882equalsimpl0(textIndent.m4578getFirstLineXSAIIZE(), TextUnitKt.getSp(0)) || !TextUnit.m4882equalsimpl0(textIndent.m4579getRestLineXSAIIZE(), TextUnitKt.getSp(0))) && !TextUnitKt.m4903isUnspecifiedR2X_6o(textIndent.m4578getFirstLineXSAIIZE()) && !TextUnitKt.m4903isUnspecifiedR2X_6o(textIndent.m4579getRestLineXSAIIZE())) {
            long r0 = TextUnit.m4884getTypeUIouoOA(textIndent.m4578getFirstLineXSAIIZE());
            float f3 = 0.0f;
            if (TextUnitType.m4913equalsimpl0(r0, TextUnitType.Companion.m4918getSpUIouoOA())) {
                f2 = density.m4648toPxR2X_6o(textIndent.m4578getFirstLineXSAIIZE());
            } else {
                f2 = TextUnitType.m4913equalsimpl0(r0, TextUnitType.Companion.m4917getEmUIouoOA()) ? TextUnit.m4885getValueimpl(textIndent.m4578getFirstLineXSAIIZE()) * f : 0.0f;
            }
            long r5 = TextUnit.m4884getTypeUIouoOA(textIndent.m4579getRestLineXSAIIZE());
            if (TextUnitType.m4913equalsimpl0(r5, TextUnitType.Companion.m4918getSpUIouoOA())) {
                f3 = density.m4648toPxR2X_6o(textIndent.m4579getRestLineXSAIIZE());
            } else if (TextUnitType.m4913equalsimpl0(r5, TextUnitType.Companion.m4917getEmUIouoOA())) {
                f3 = TextUnit.m4885getValueimpl(textIndent.m4579getRestLineXSAIIZE()) * f;
            }
            setSpan(spannable, new LeadingMarginSpan.Standard((int) ((float) Math.ceil((double) f2)), (int) ((float) Math.ceil((double) f3))), 0, spannable.length());
        }
    }

    /* renamed from: setLineHeight-KmRG4DE  reason: not valid java name */
    public static final void m4458setLineHeightKmRG4DE(Spannable spannable, long j, float f, Density density, LineHeightStyle lineHeightStyle) {
        Intrinsics.checkNotNullParameter(spannable, "$this$setLineHeight");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(lineHeightStyle, "lineHeightStyle");
        float r2 = m4453resolveLineHeightInPxo2QH7mI(j, f, density);
        if (!Float.isNaN(r2)) {
            CharSequence charSequence = spannable;
            setSpan(spannable, new LineHeightStyleSpan(r2, 0, ((charSequence.length() == 0) || StringsKt.last(charSequence) == 10) ? spannable.length() + 1 : spannable.length(), LineHeightStyle.Trim.m4539isTrimFirstLineTopimpl$ui_text_release(lineHeightStyle.m4518getTrimEVpEnUU()), LineHeightStyle.Trim.m4540isTrimLastLineBottomimpl$ui_text_release(lineHeightStyle.m4518getTrimEVpEnUU()), lineHeightStyle.m4517getAlignmentPIaL0Z0()), 0, spannable.length());
        }
    }

    /* renamed from: setLineHeight-r9BaKPg  reason: not valid java name */
    public static final void m4459setLineHeightr9BaKPg(Spannable spannable, long j, float f, Density density) {
        Intrinsics.checkNotNullParameter(spannable, "$this$setLineHeight");
        Intrinsics.checkNotNullParameter(density, "density");
        float r2 = m4453resolveLineHeightInPxo2QH7mI(j, f, density);
        if (!Float.isNaN(r2)) {
            setSpan(spannable, new LineHeightSpan(r2), 0, spannable.length());
        }
    }

    /* renamed from: resolveLineHeightInPx-o2QH7mI  reason: not valid java name */
    private static final float m4453resolveLineHeightInPxo2QH7mI(long j, float f, Density density) {
        long r0 = TextUnit.m4884getTypeUIouoOA(j);
        if (TextUnitType.m4913equalsimpl0(r0, TextUnitType.Companion.m4918getSpUIouoOA())) {
            return density.m4648toPxR2X_6o(j);
        }
        if (TextUnitType.m4913equalsimpl0(r0, TextUnitType.Companion.m4917getEmUIouoOA())) {
            return TextUnit.m4885getValueimpl(j) * f;
        }
        return Float.NaN;
    }

    public static final void setSpanStyles(Spannable spannable, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, Density density, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Intrinsics.checkNotNullParameter(textStyle, "contextTextStyle");
        Intrinsics.checkNotNullParameter(list, "spanStyles");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(function4, "resolveTypeface");
        setFontAttributes(spannable, textStyle, list, function4);
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range range = list.get(i);
            int start = range.getStart();
            int end = range.getEnd();
            if (start >= 0 && start < spannable.length() && end > start && end <= spannable.length()) {
                setSpanStyle(spannable, range, density, arrayList);
            }
        }
        List list2 = arrayList;
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            SpanRange spanRange = (SpanRange) list2.get(i2);
            setSpan(spannable, spanRange.component1(), spanRange.component2(), spanRange.component3());
        }
    }

    private static final void setSpanStyle(Spannable spannable, AnnotatedString.Range<SpanStyle> range, Density density, ArrayList<SpanRange> arrayList) {
        int start = range.getStart();
        int end = range.getEnd();
        SpanStyle item = range.getItem();
        m4455setBaselineShift0ocSgnM(spannable, item.m4182getBaselineShift5SSeXJ0(), start, end);
        m4456setColorRPmYEkk(spannable, item.m4183getColor0d7_KjU(), start, end);
        setBrush(spannable, item.getBrush(), item.getAlpha(), start, end);
        setTextDecoration(spannable, item.getTextDecoration(), start, end);
        m4457setFontSizeKmRG4DE(spannable, item.m4184getFontSizeXSAIIZE(), density, start, end);
        setFontFeatureSettings(spannable, item.getFontFeatureSettings(), start, end);
        setGeometricTransform(spannable, item.getTextGeometricTransform(), start, end);
        setLocaleList(spannable, item.getLocaleList(), start, end);
        m4454setBackgroundRPmYEkk(spannable, item.m4181getBackground0d7_KjU(), start, end);
        setShadow(spannable, item.getShadow(), start, end);
        MetricAffectingSpan r8 = m4452createLetterSpacingSpaneAf_CNQ(item.m4187getLetterSpacingXSAIIZE(), density);
        if (r8 != null) {
            arrayList.add(new SpanRange(r8, start, end));
        }
    }

    public static final void flattenFontStylesAndApply(SpanStyle spanStyle, List<AnnotatedString.Range<SpanStyle>> list, Function3<? super SpanStyle, ? super Integer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(list, "spanStyles");
        Intrinsics.checkNotNullParameter(function3, "block");
        if (list.size() > 1) {
            int size = list.size();
            int i = size * 2;
            Integer[] numArr = new Integer[i];
            for (int i2 = 0; i2 < i; i2++) {
                numArr[i2] = 0;
            }
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                AnnotatedString.Range range = list.get(i3);
                numArr[i3] = Integer.valueOf(range.getStart());
                numArr[i3 + size] = Integer.valueOf(range.getEnd());
            }
            ArraysKt.sort((T[]) (Object[]) ((Comparable[]) numArr));
            int intValue = ((Number) ArraysKt.first((T[]) numArr)).intValue();
            for (int i4 = 0; i4 < i; i4++) {
                int intValue2 = numArr[i4].intValue();
                if (intValue2 != intValue) {
                    int size3 = list.size();
                    SpanStyle spanStyle2 = spanStyle;
                    for (int i5 = 0; i5 < size3; i5++) {
                        AnnotatedString.Range range2 = list.get(i5);
                        if (range2.getStart() != range2.getEnd() && AnnotatedStringKt.intersect(intValue, intValue2, range2.getStart(), range2.getEnd())) {
                            spanStyle2 = merge(spanStyle2, (SpanStyle) range2.getItem());
                        }
                    }
                    if (spanStyle2 != null) {
                        function3.invoke(spanStyle2, Integer.valueOf(intValue), Integer.valueOf(intValue2));
                    }
                    intValue = intValue2;
                }
            }
        } else if (!list.isEmpty()) {
            function3.invoke(merge(spanStyle, (SpanStyle) list.get(0).getItem()), Integer.valueOf(list.get(0).getStart()), Integer.valueOf(list.get(0).getEnd()));
        }
    }

    /* renamed from: createLetterSpacingSpan-eAf_CNQ  reason: not valid java name */
    private static final MetricAffectingSpan m4452createLetterSpacingSpaneAf_CNQ(long j, Density density) {
        long r0 = TextUnit.m4884getTypeUIouoOA(j);
        if (TextUnitType.m4913equalsimpl0(r0, TextUnitType.Companion.m4918getSpUIouoOA())) {
            return new LetterSpacingSpanPx(density.m4648toPxR2X_6o(j));
        }
        if (TextUnitType.m4913equalsimpl0(r0, TextUnitType.Companion.m4917getEmUIouoOA())) {
            return new LetterSpacingSpanEm(TextUnit.m4885getValueimpl(j));
        }
        return null;
    }

    private static final void setShadow(Spannable spannable, Shadow shadow, int i, int i2) {
        if (shadow != null) {
            setSpan(spannable, new ShadowSpan(ColorKt.m1987toArgb8_81llA(shadow.m2264getColor0d7_KjU()), Offset.m1683getXimpl(shadow.m2265getOffsetF1C5BW0()), Offset.m1684getYimpl(shadow.m2265getOffsetF1C5BW0()), TextPaintExtensions_androidKt.correctBlurRadius(shadow.getBlurRadius())), i, i2);
        }
    }

    public static final void setLocaleList(Spannable spannable, LocaleList localeList, int i, int i2) {
        Object obj;
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        if (localeList != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                obj = LocaleListHelperMethods.INSTANCE.localeSpan(localeList);
            } else {
                obj = new LocaleSpan(LocaleExtensions_androidKt.toJavaLocale(localeList.isEmpty() ? Locale.Companion.getCurrent() : localeList.get(0)));
            }
            setSpan(spannable, obj, i, i2);
        }
    }

    private static final void setGeometricTransform(Spannable spannable, TextGeometricTransform textGeometricTransform, int i, int i2) {
        if (textGeometricTransform != null) {
            setSpan(spannable, new ScaleXSpan(textGeometricTransform.getScaleX()), i, i2);
            setSpan(spannable, new SkewXSpan(textGeometricTransform.getSkewX()), i, i2);
        }
    }

    private static final void setFontFeatureSettings(Spannable spannable, String str, int i, int i2) {
        if (str != null) {
            setSpan(spannable, new FontFeatureSpan(str), i, i2);
        }
    }

    /* renamed from: setFontSize-KmRG4DE  reason: not valid java name */
    public static final void m4457setFontSizeKmRG4DE(Spannable spannable, long j, Density density, int i, int i2) {
        Intrinsics.checkNotNullParameter(spannable, "$this$setFontSize");
        Intrinsics.checkNotNullParameter(density, "density");
        long r0 = TextUnit.m4884getTypeUIouoOA(j);
        if (TextUnitType.m4913equalsimpl0(r0, TextUnitType.Companion.m4918getSpUIouoOA())) {
            setSpan(spannable, new AbsoluteSizeSpan(MathKt.roundToInt(density.m4648toPxR2X_6o(j)), false), i, i2);
        } else if (TextUnitType.m4913equalsimpl0(r0, TextUnitType.Companion.m4917getEmUIouoOA())) {
            setSpan(spannable, new RelativeSizeSpan(TextUnit.m4885getValueimpl(j)), i, i2);
        }
    }

    public static final void setTextDecoration(Spannable spannable, TextDecoration textDecoration, int i, int i2) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        if (textDecoration != null) {
            setSpan(spannable, new TextDecorationSpan(textDecoration.contains(TextDecoration.Companion.getUnderline()), textDecoration.contains(TextDecoration.Companion.getLineThrough())), i, i2);
        }
    }

    /* renamed from: setBaselineShift-0ocSgnM  reason: not valid java name */
    private static final void m4455setBaselineShift0ocSgnM(Spannable spannable, BaselineShift baselineShift, int i, int i2) {
        if (baselineShift != null) {
            setSpan(spannable, new BaselineShiftSpan(baselineShift.m4468unboximpl()), i, i2);
        }
    }

    private static final void setBrush(Spannable spannable, Brush brush, float f, int i, int i2) {
        if (brush == null) {
            return;
        }
        if (brush instanceof SolidColor) {
            m4456setColorRPmYEkk(spannable, ((SolidColor) brush).m2269getValue0d7_KjU(), i, i2);
        } else if (brush instanceof ShaderBrush) {
            setSpan(spannable, new ShaderBrushSpan((ShaderBrush) brush, f), i, i2);
        }
    }

    private static final boolean hasFontAttributes(TextStyle textStyle) {
        return TextPaintExtensions_androidKt.hasFontAttributes(textStyle.toSpanStyle()) || textStyle.m4241getFontSynthesisZQGJjVo() != null;
    }

    private static final SpanStyle merge(SpanStyle spanStyle, SpanStyle spanStyle2) {
        return spanStyle == null ? spanStyle2 : spanStyle.merge(spanStyle2);
    }

    private static final void setFontAttributes(Spannable spannable, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4) {
        SpanStyle spanStyle;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<SpanStyle> range = list.get(i);
            AnnotatedString.Range range2 = range;
            if (TextPaintExtensions_androidKt.hasFontAttributes((SpanStyle) range2.getItem()) || ((SpanStyle) range2.getItem()).m4186getFontSynthesisZQGJjVo() != null) {
                arrayList.add(range);
            }
        }
        List list2 = arrayList;
        if (hasFontAttributes(textStyle)) {
            spanStyle = new SpanStyle(0, 0, textStyle.getFontWeight(), textStyle.m4240getFontStyle4Lr2A7w(), textStyle.m4241getFontSynthesisZQGJjVo(), textStyle.getFontFamily(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, 16323, (DefaultConstructorMarker) null);
        } else {
            spanStyle = null;
        }
        flattenFontStylesAndApply(spanStyle, list2, new SpannableExtensions_androidKt$setFontAttributes$1(spannable, function4));
    }

    /* renamed from: setBackground-RPmYEkk  reason: not valid java name */
    public static final void m4454setBackgroundRPmYEkk(Spannable spannable, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(spannable, "$this$setBackground");
        if (j != Color.Companion.m1968getUnspecified0d7_KjU()) {
            setSpan(spannable, new BackgroundColorSpan(ColorKt.m1987toArgb8_81llA(j)), i, i2);
        }
    }

    /* renamed from: setColor-RPmYEkk  reason: not valid java name */
    public static final void m4456setColorRPmYEkk(Spannable spannable, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(spannable, "$this$setColor");
        if (j != Color.Companion.m1968getUnspecified0d7_KjU()) {
            setSpan(spannable, new ForegroundColorSpan(ColorKt.m1987toArgb8_81llA(j)), i, i2);
        }
    }
}
