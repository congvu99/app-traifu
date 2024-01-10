package io.intercom.android.sdk.survey.block;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextBlock.kt */
final class TextBlockKt$TextBlock$3$3$1 extends Lambda implements Function1<TextLayoutResult, Unit> {
    final /* synthetic */ MutableState<TextLayoutResult> $layoutResult;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextBlockKt$TextBlock$3$3$1(MutableState<TextLayoutResult> mutableState) {
        super(1);
        this.$layoutResult = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextLayoutResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TextLayoutResult textLayoutResult) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "it");
        this.$layoutResult.setValue(textLayoutResult);
    }
}
