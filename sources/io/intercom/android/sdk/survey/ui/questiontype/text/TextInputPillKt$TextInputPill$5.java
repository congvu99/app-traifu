package io.intercom.android.sdk.survey.ui.questiontype.text;

import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextInputPill.kt */
final class TextInputPillKt$TextInputPill$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $cursorColor;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ int $imeAction;
    final /* synthetic */ int $keyboardType;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ float $minHeight;
    final /* synthetic */ Function1<KeyboardActionScope, Unit> $onImeActionNext;
    final /* synthetic */ Function1<String, Unit> $onTextChanged;
    final /* synthetic */ String $placeholderText;
    final /* synthetic */ boolean $showTrailingIcon;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ Color $strokeColor;
    final /* synthetic */ String $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextInputPillKt$TextInputPill$5(String str, String str2, Function1<? super String, Unit> function1, Color color, long j, int i, boolean z, Function1<? super KeyboardActionScope, Unit> function12, int i2, int i3, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, boolean z3, float f, int i4, int i5, int i6) {
        super(2);
        this.$text = str;
        this.$placeholderText = str2;
        this.$onTextChanged = function1;
        this.$strokeColor = color;
        this.$cursorColor = j;
        this.$maxLines = i;
        this.$singleLine = z;
        this.$onImeActionNext = function12;
        this.$keyboardType = i2;
        this.$imeAction = i3;
        this.$showTrailingIcon = z2;
        this.$leadingIcon = function2;
        this.$enabled = z3;
        this.$minHeight = f;
        this.$$changed = i4;
        this.$$changed1 = i5;
        this.$$default = i6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        String str = this.$text;
        String str2 = str;
        TextInputPillKt.m5354TextInputPillg5ZjG94(str2, this.$placeholderText, this.$onTextChanged, this.$strokeColor, this.$cursorColor, this.$maxLines, this.$singleLine, this.$onImeActionNext, this.$keyboardType, this.$imeAction, this.$showTrailingIcon, this.$leadingIcon, this.$enabled, this.$minHeight, composer2, this.$$changed | 1, this.$$changed1, this.$$default);
    }
}
