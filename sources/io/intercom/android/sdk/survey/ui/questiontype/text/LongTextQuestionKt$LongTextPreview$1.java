package io.intercom.android.sdk.survey.ui.questiontype.text;

import io.intercom.android.sdk.survey.ui.models.Answer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LongTextQuestion.kt */
final class LongTextQuestionKt$LongTextPreview$1 extends Lambda implements Function1<Answer, Unit> {
    public static final LongTextQuestionKt$LongTextPreview$1 INSTANCE = new LongTextQuestionKt$LongTextPreview$1();

    LongTextQuestionKt$LongTextPreview$1() {
        super(1);
    }

    public final void invoke(Answer answer) {
        Intrinsics.checkNotNullParameter(answer, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Answer) obj);
        return Unit.INSTANCE;
    }
}
