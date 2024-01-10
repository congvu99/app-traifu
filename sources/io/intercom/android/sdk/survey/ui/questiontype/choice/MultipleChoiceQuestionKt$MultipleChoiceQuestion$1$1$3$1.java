package io.intercom.android.sdk.survey.ui.questiontype.choice;

import io.intercom.android.sdk.survey.ui.models.Answer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: MultipleChoiceQuestion.kt */
final class MultipleChoiceQuestionKt$MultipleChoiceQuestion$1$1$3$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ Answer $answer;
    final /* synthetic */ Function1<Answer, Unit> $onAnswer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultipleChoiceQuestionKt$MultipleChoiceQuestion$1$1$3$1(Answer answer, Function1<? super Answer, Unit> function1) {
        super(1);
        this.$answer = answer;
        this.$onAnswer = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        MultipleChoiceQuestionKt.m5330MultipleChoiceQuestion$lambda5$lambda4$switchOtherAnswer(this.$answer, this.$onAnswer, new Answer.MultipleAnswer.OtherAnswer.SelectedWithText(str));
    }
}
