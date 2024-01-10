package io.intercom.android.sdk.survey.ui.questiontype.choice;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.font.FontWeight;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ChoicePill.kt */
final class ChoicePillKt$ChoicePill$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ long $fontColor;
    final /* synthetic */ FontWeight $fontWeight;
    final /* synthetic */ Function1<String, Unit> $onClicked;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ long $strokeColor;
    final /* synthetic */ float $strokeWidth;
    final /* synthetic */ String $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChoicePillKt$ChoicePill$4(boolean z, Function1<? super String, Unit> function1, String str, long j, float f, long j2, FontWeight fontWeight, long j3, int i, int i2) {
        super(2);
        this.$selected = z;
        this.$onClicked = function1;
        this.$text = str;
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
        ChoicePillKt.m5322ChoicePillUdaoDFU(this.$selected, this.$onClicked, this.$text, this.$strokeColor, this.$strokeWidth, this.$backgroundColor, this.$fontWeight, this.$fontColor, composer, this.$$changed | 1, this.$$default);
    }
}
