package io.intercom.android.sdk.survey.ui.questiontype.text;

import androidx.compose.foundation.text.KeyboardActionScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LongTextQuestion.kt */
final class LongTextQuestionKt$LongTextQuestion$1 extends Lambda implements Function1<KeyboardActionScope, Unit> {
    public static final LongTextQuestionKt$LongTextQuestion$1 INSTANCE = new LongTextQuestionKt$LongTextQuestion$1();

    LongTextQuestionKt$LongTextQuestion$1() {
        super(1);
    }

    public final void invoke(KeyboardActionScope keyboardActionScope) {
        Intrinsics.checkNotNullParameter(keyboardActionScope, "$this$null");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KeyboardActionScope) obj);
        return Unit.INSTANCE;
    }
}
