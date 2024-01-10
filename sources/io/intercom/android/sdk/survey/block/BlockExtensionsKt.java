package io.intercom.android.sdk.survey.block;

import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import io.intercom.android.sdk.blocks.lib.BlockAlignment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"getTextAlign", "Landroidx/compose/ui/text/style/TextAlign;", "Lio/intercom/android/sdk/blocks/lib/BlockAlignment;", "(Lio/intercom/android/sdk/blocks/lib/BlockAlignment;)I", "toAnnotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "", "urlSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: BlockExtensions.kt */
public final class BlockExtensionsKt {
    public static final int getTextAlign(BlockAlignment blockAlignment) {
        Intrinsics.checkNotNullParameter(blockAlignment, "<this>");
        int gravity = blockAlignment.getGravity();
        if (gravity == 1) {
            return TextAlign.Companion.m4554getCentere0LSkKk();
        }
        if (gravity == 8388611) {
            return TextAlign.Companion.m4559getStarte0LSkKk();
        }
        if (gravity != 8388613) {
            return TextAlign.Companion.m4559getStarte0LSkKk();
        }
        return TextAlign.Companion.m4555getEnde0LSkKk();
    }

    public static /* synthetic */ AnnotatedString toAnnotatedString$default(CharSequence charSequence, SpanStyle spanStyle, int i, Object obj) {
        CharSequence charSequence2;
        SpanStyle spanStyle2;
        if ((i & 1) != 0) {
            spanStyle2 = new SpanStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, TextDecoration.Companion.getUnderline(), (Shadow) null, 12287, (DefaultConstructorMarker) null);
            charSequence2 = charSequence;
        } else {
            charSequence2 = charSequence;
            spanStyle2 = spanStyle;
        }
        return toAnnotatedString(charSequence2, spanStyle2);
    }

    public static final AnnotatedString toAnnotatedString(CharSequence charSequence, SpanStyle spanStyle) {
        CharSequence charSequence2 = charSequence;
        SpanStyle spanStyle2 = spanStyle;
        Intrinsics.checkNotNullParameter(charSequence2, "<this>");
        Intrinsics.checkNotNullParameter(spanStyle2, "urlSpanStyle");
        if (charSequence2 instanceof Spanned) {
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            builder.append(charSequence.toString());
            Spanned spanned = (Spanned) charSequence2;
            Object[] spans = spanned.getSpans(0, spanned.length(), URLSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans, "getSpans(start, end, T::class.java)");
            Object[] spans2 = spanned.getSpans(0, spanned.length(), StyleSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans2, "getSpans(start, end, T::class.java)");
            StyleSpan[] styleSpanArr = (StyleSpan[]) spans2;
            Object[] spans3 = spanned.getSpans(0, spanned.length(), UnderlineSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans3, "getSpans(start, end, T::class.java)");
            UnderlineSpan[] underlineSpanArr = (UnderlineSpan[]) spans3;
            Object[] spans4 = spanned.getSpans(0, spanned.length(), StrikethroughSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans4, "getSpans(start, end, T::class.java)");
            StrikethroughSpan[] strikethroughSpanArr = (StrikethroughSpan[]) spans4;
            Object[] spans5 = spanned.getSpans(0, spanned.length(), ForegroundColorSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans5, "getSpans(start, end, T::class.java)");
            ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spans5;
            for (URLSpan uRLSpan : (URLSpan[]) spans) {
                int spanStart = spanned.getSpanStart(uRLSpan);
                int spanEnd = spanned.getSpanEnd(uRLSpan);
                builder.addStyle(spanStyle2, spanStart, spanEnd);
                String url = uRLSpan.getURL();
                Intrinsics.checkNotNullExpressionValue(url, "urlSpan.url");
                builder.addStringAnnotation("url", url, spanStart, spanEnd);
            }
            for (StyleSpan styleSpan : styleSpanArr) {
                int spanStart2 = spanned.getSpanStart(styleSpan);
                int spanEnd2 = spanned.getSpanEnd(styleSpan);
                int style = styleSpan.getStyle();
                if (style == 1) {
                    builder.addStyle(new SpanStyle(0, 0, FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, 16379, (DefaultConstructorMarker) null), spanStart2, spanEnd2);
                } else if (style == 2) {
                    builder.addStyle(new SpanStyle(0, 0, (FontWeight) null, FontStyle.m4305boximpl(FontStyle.Companion.m4312getItalic_LCdwA()), (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, 16375, (DefaultConstructorMarker) null), spanStart2, spanEnd2);
                } else if (style == 3) {
                    builder.addStyle(new SpanStyle(0, 0, FontWeight.Companion.getBold(), FontStyle.m4305boximpl(FontStyle.Companion.m4312getItalic_LCdwA()), (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, 16371, (DefaultConstructorMarker) null), spanStart2, spanEnd2);
                }
            }
            for (UnderlineSpan underlineSpan : underlineSpanArr) {
                builder.addStyle(new SpanStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, TextDecoration.Companion.getUnderline(), (Shadow) null, 12287, (DefaultConstructorMarker) null), spanned.getSpanStart(underlineSpan), spanned.getSpanEnd(underlineSpan));
            }
            for (StrikethroughSpan strikethroughSpan : strikethroughSpanArr) {
                builder.addStyle(new SpanStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, TextDecoration.Companion.getLineThrough(), (Shadow) null, 12287, (DefaultConstructorMarker) null), spanned.getSpanStart(strikethroughSpan), spanned.getSpanEnd(strikethroughSpan));
            }
            for (ForegroundColorSpan foregroundColorSpan : foregroundColorSpanArr) {
                builder.addStyle(new SpanStyle(ColorKt.Color(foregroundColorSpan.getForegroundColor()), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, 16382, (DefaultConstructorMarker) null), spanned.getSpanStart(foregroundColorSpan), spanned.getSpanEnd(foregroundColorSpan));
            }
            return builder.toAnnotatedString();
        }
        AnnotatedString.Builder builder2 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
        builder2.append(builder2.toString());
        return builder2.toAnnotatedString();
    }
}
