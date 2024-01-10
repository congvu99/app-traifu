package io.intercom.android.sdk.m5.home.topbars;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeHeader.kt */
final class HomeHeaderKt$HomeHeader$2$2$1$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ TextStyle $h4TextStyle;
    final /* synthetic */ MutableState<Boolean> $hasEitherTextWrapped;
    final /* synthetic */ MutableState<TextStyle> $textStyle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeHeaderKt$HomeHeader$2$2$1$1(MutableState<Boolean> mutableState, MutableState<TextStyle> mutableState2, TextStyle textStyle) {
        super(1);
        this.$hasEitherTextWrapped = mutableState;
        this.$textStyle = mutableState2;
        this.$h4TextStyle = textStyle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        MutableState<Boolean> mutableState = this.$hasEitherTextWrapped;
        mutableState.setValue(Boolean.valueOf(z | mutableState.getValue().booleanValue()));
        HomeHeaderKt.HomeHeader_942rkJo$updateTextStyle(this.$hasEitherTextWrapped, this.$textStyle, this.$h4TextStyle);
    }
}
