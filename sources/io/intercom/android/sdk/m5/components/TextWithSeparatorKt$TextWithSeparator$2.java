package io.intercom.android.sdk.m5.components;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextWithSeparator.kt */
final class TextWithSeparatorKt$TextWithSeparator$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $color;
    final /* synthetic */ String $firstText;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ int $overflow;
    final /* synthetic */ String $secondText;
    final /* synthetic */ String $separator;
    final /* synthetic */ TextStyle $style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextWithSeparatorKt$TextWithSeparator$2(String str, String str2, Modifier modifier, String str3, TextStyle textStyle, long j, int i, int i2, int i3, int i4) {
        super(2);
        this.$firstText = str;
        this.$secondText = str2;
        this.$modifier = modifier;
        this.$separator = str3;
        this.$style = textStyle;
        this.$color = j;
        this.$overflow = i;
        this.$maxLines = i2;
        this.$$changed = i3;
        this.$$default = i4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TextWithSeparatorKt.m5179TextWithSeparatorljD6DUQ(this.$firstText, this.$secondText, this.$modifier, this.$separator, this.$style, this.$color, this.$overflow, this.$maxLines, composer, this.$$changed | 1, this.$$default);
    }
}
