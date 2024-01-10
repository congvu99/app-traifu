package io.intercom.android.sdk.m5.home.components;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: WrapReportingText.kt */
final class WrapReportingTextKt$WrapReportingText$3$1 extends Lambda implements Function1<TextLayoutResult, Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $onTextWrap;
    final /* synthetic */ MutableState<Boolean> $readyToDraw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WrapReportingTextKt$WrapReportingText$3$1(Function1<? super Boolean, Unit> function1, MutableState<Boolean> mutableState) {
        super(1);
        this.$onTextWrap = function1;
        this.$readyToDraw = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextLayoutResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TextLayoutResult textLayoutResult) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        this.$onTextWrap.invoke(Boolean.valueOf(textLayoutResult.getLineCount() > 1));
        this.$readyToDraw.setValue(true);
    }
}
