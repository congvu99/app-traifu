package io.intercom.android.sdk.m5.home.components;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: WrapReportingText.kt */
final class WrapReportingTextKt$WrapReportingText$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $color;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Boolean, Unit> $onTextWrap;
    final /* synthetic */ TextStyle $style;
    final /* synthetic */ String $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WrapReportingTextKt$WrapReportingText$4(Modifier modifier, String str, long j, TextStyle textStyle, Function1<? super Boolean, Unit> function1, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$text = str;
        this.$color = j;
        this.$style = textStyle;
        this.$onTextWrap = function1;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        WrapReportingTextKt.m5217WrapReportingTextT042LqI(this.$modifier, this.$text, this.$color, this.$style, this.$onTextWrap, composer, this.$$changed | 1, this.$$default);
    }
}
