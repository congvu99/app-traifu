package io.intercom.android.sdk.survey.ui.questiontype.choice;

import io.intercom.android.sdk.survey.ui.models.Answer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SingleChoiceQuestion.kt */
final class SingleChoiceQuestionKt$SingleChoiceQuestion$1$1$3$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ Function1<Answer, Unit> $onAnswer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SingleChoiceQuestionKt$SingleChoiceQuestion$1$1$3$1(Function1<? super Answer, Unit> function1) {
        super(1);
        this.$onAnswer = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        this.$onAnswer.invoke(new Answer.SingleAnswer(str));
    }
}
