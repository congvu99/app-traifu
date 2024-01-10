package io.intercom.android.sdk.survey.ui.questiontype.numericscale;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NumericRatingCell.kt */
final class NumericRatingCellKt$NumericRatingCell$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ String $content;
    final /* synthetic */ long $fontColor;
    final /* synthetic */ FontWeight $fontWeight;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ long $strokeColor;
    final /* synthetic */ float $strokeWidth;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NumericRatingCellKt$NumericRatingCell$2(String str, Modifier modifier, long j, float f, long j2, FontWeight fontWeight, long j3, int i, int i2) {
        super(2);
        this.$content = str;
        this.$modifier = modifier;
        this.$strokeColor = j;
        this.$strokeWidth = f;
        this.$backgroundColor = j2;
        this.$fontWeight = fontWeight;
        this.$fontColor = j3;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        NumericRatingCellKt.m5341NumericRatingCellchV7uOw(this.$content, this.$modifier, this.$strokeColor, this.$strokeWidth, this.$backgroundColor, this.$fontWeight, this.$fontColor, composer, this.$$changed | 1, this.$$default);
    }
}
