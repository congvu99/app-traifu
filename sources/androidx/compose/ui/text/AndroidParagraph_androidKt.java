package androidx.compose.ui.text;

import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.style.IndentationFixSpan;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u001d\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\t\u001a\u001d\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\r\u001a\u001d\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0011\u001a\u001d\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0015\u001a\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0017H\u0002\u001a\u0014\u0010\u0018\u001a\u00020\u0006*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006H\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"shouldAttachIndentationFixSpan", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "ellipsis", "toLayoutAlign", "", "align", "Landroidx/compose/ui/text/style/TextAlign;", "toLayoutAlign-AMY3VfE", "toLayoutBreakStrategy", "breakStrategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "toLayoutBreakStrategy-u6PBz3U", "toLayoutLineBreakStyle", "lineBreakStrictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "toLayoutLineBreakStyle-4a2g8L8", "toLayoutLineBreakWordStyle", "lineBreakWordStyle", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "toLayoutLineBreakWordStyle-gvcdTPQ", "attachIndentationFixSpan", "", "numberOfLinesThatFitMaxHeight", "Landroidx/compose/ui/text/android/TextLayout;", "maxHeight", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidParagraph.android.kt */
public final class AndroidParagraph_androidKt {
    /* access modifiers changed from: private */
    /* renamed from: toLayoutAlign-AMY3VfE  reason: not valid java name */
    public static final int m4116toLayoutAlignAMY3VfE(TextAlign textAlign) {
        if (textAlign == null ? false : TextAlign.m4550equalsimpl0(textAlign.m4553unboximpl(), TextAlign.Companion.m4557getLefte0LSkKk())) {
            return 3;
        }
        if (textAlign == null ? false : TextAlign.m4550equalsimpl0(textAlign.m4553unboximpl(), TextAlign.Companion.m4558getRighte0LSkKk())) {
            return 4;
        }
        if (textAlign == null ? false : TextAlign.m4550equalsimpl0(textAlign.m4553unboximpl(), TextAlign.Companion.m4554getCentere0LSkKk())) {
            return 2;
        }
        if (textAlign == null ? false : TextAlign.m4550equalsimpl0(textAlign.m4553unboximpl(), TextAlign.Companion.m4559getStarte0LSkKk())) {
            return 0;
        }
        if (textAlign == null ? false : TextAlign.m4550equalsimpl0(textAlign.m4553unboximpl(), TextAlign.Companion.m4555getEnde0LSkKk())) {
            return 1;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: toLayoutBreakStrategy-u6PBz3U  reason: not valid java name */
    public static final int m4117toLayoutBreakStrategyu6PBz3U(LineBreak.Strategy strategy) {
        if (strategy == null ? false : LineBreak.Strategy.m4490equalsimpl0(strategy.m4493unboximpl(), LineBreak.Strategy.Companion.m4496getSimplefcGXIks())) {
            return 0;
        }
        if (strategy == null ? false : LineBreak.Strategy.m4490equalsimpl0(strategy.m4493unboximpl(), LineBreak.Strategy.Companion.m4495getHighQualityfcGXIks())) {
            return 1;
        }
        if (strategy == null ? false : LineBreak.Strategy.m4490equalsimpl0(strategy.m4493unboximpl(), LineBreak.Strategy.Companion.m4494getBalancedfcGXIks())) {
            return 2;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakStyle-4a2g8L8  reason: not valid java name */
    public static final int m4118toLayoutLineBreakStyle4a2g8L8(LineBreak.Strictness strictness) {
        if (strictness == null ? false : LineBreak.Strictness.m4500equalsimpl0(strictness.m4503unboximpl(), LineBreak.Strictness.Companion.m4504getDefaultusljTpc())) {
            return 0;
        }
        if (strictness == null ? false : LineBreak.Strictness.m4500equalsimpl0(strictness.m4503unboximpl(), LineBreak.Strictness.Companion.m4505getLooseusljTpc())) {
            return 1;
        }
        if (strictness == null ? false : LineBreak.Strictness.m4500equalsimpl0(strictness.m4503unboximpl(), LineBreak.Strictness.Companion.m4506getNormalusljTpc())) {
            return 2;
        }
        if (strictness == null ? false : LineBreak.Strictness.m4500equalsimpl0(strictness.m4503unboximpl(), LineBreak.Strictness.Companion.m4507getStrictusljTpc())) {
            return 3;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakWordStyle-gvcdTPQ  reason: not valid java name */
    public static final int m4119toLayoutLineBreakWordStylegvcdTPQ(LineBreak.WordBreak wordBreak) {
        if (wordBreak == null ? false : LineBreak.WordBreak.m4511equalsimpl0(wordBreak.m4514unboximpl(), LineBreak.WordBreak.Companion.m4515getDefaultjp8hJ3c())) {
            return 0;
        }
        if (wordBreak == null ? false : LineBreak.WordBreak.m4511equalsimpl0(wordBreak.m4514unboximpl(), LineBreak.WordBreak.Companion.m4516getPhrasejp8hJ3c())) {
            return 1;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public static final int numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i) {
        int lineCount = textLayout.getLineCount();
        for (int i2 = 0; i2 < lineCount; i2++) {
            if (textLayout.getLineBottom(i2) > ((float) i)) {
                return i2;
            }
        }
        return textLayout.getLineCount();
    }

    /* access modifiers changed from: private */
    public static final boolean shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z) {
        if (!z || TextUnit.m4882equalsimpl0(textStyle.m4242getLetterSpacingXSAIIZE(), TextUnitKt.getSp(0)) || TextUnit.m4882equalsimpl0(textStyle.m4242getLetterSpacingXSAIIZE(), TextUnit.Companion.m4896getUnspecifiedXSAIIZE()) || textStyle.m4244getTextAlignbuA522U() == null) {
            return false;
        }
        TextAlign r6 = textStyle.m4244getTextAlignbuA522U();
        if (r6 == null ? false : TextAlign.m4550equalsimpl0(r6.m4553unboximpl(), TextAlign.Companion.m4559getStarte0LSkKk())) {
            return false;
        }
        TextAlign r5 = textStyle.m4244getTextAlignbuA522U();
        if (!(r5 == null ? false : TextAlign.m4550equalsimpl0(r5.m4553unboximpl(), TextAlign.Companion.m4556getJustifye0LSkKk()))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final CharSequence attachIndentationFixSpan(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return charSequence;
        }
        Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
        SpannableExtensions_androidKt.setSpan(spannableString, new IndentationFixSpan(), spannableString.length() - 1, spannableString.length() - 1);
        return spannableString;
    }
}
