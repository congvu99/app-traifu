package io.intercom.android.sdk.survey.ui.questiontype.choice;

import io.intercom.android.sdk.survey.ui.models.Answer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: MultipleChoiceQuestion.kt */
final class MultipleChoiceQuestionKt$MultipleChoiceQuestion$1$1$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Answer $answer;
    final /* synthetic */ boolean $isOtherSelected;
    final /* synthetic */ Function1<Answer, Unit> $onAnswer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultipleChoiceQuestionKt$MultipleChoiceQuestion$1$1$2$1(boolean z, Answer answer, Function1<? super Answer, Unit> function1) {
        super(0);
        this.$isOtherSelected = z;
        this.$answer = answer;
        this.$onAnswer = function1;
    }

    public final void invoke() {
        if (!this.$isOtherSelected) {
            MultipleChoiceQuestionKt.m5330MultipleChoiceQuestion$lambda5$lambda4$switchOtherAnswer(this.$answer, this.$onAnswer, Answer.MultipleAnswer.OtherAnswer.SelectedNoText.INSTANCE);
        } else {
            MultipleChoiceQuestionKt.m5330MultipleChoiceQuestion$lambda5$lambda4$switchOtherAnswer(this.$answer, this.$onAnswer, Answer.MultipleAnswer.OtherAnswer.NotSelected.INSTANCE);
        }
    }
}
