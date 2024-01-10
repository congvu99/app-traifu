package io.intercom.android.sdk.survey.ui.components;

import io.intercom.android.sdk.survey.QuestionState;
import io.intercom.android.sdk.survey.model.SurveyData;
import io.intercom.android.sdk.survey.ui.models.Answer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: QuestionComponent.kt */
final class QuestionComponentKt$QuestionComponent$onAnswer$1 extends Lambda implements Function1<Answer, Unit> {
    final /* synthetic */ Function0<Unit> $onAnswerUpdated;
    final /* synthetic */ QuestionState $questionState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuestionComponentKt$QuestionComponent$onAnswer$1(QuestionState questionState, Function0<Unit> function0) {
        super(1);
        this.$questionState = questionState;
        this.$onAnswerUpdated = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Answer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Answer answer) {
        Intrinsics.checkNotNullParameter(answer, "it");
        this.$questionState.setAnswer(answer);
        if (!(this.$questionState.getQuestionModel() instanceof SurveyData.Step.Question.ShortTextQuestionModel) && !(this.$questionState.getQuestionModel() instanceof SurveyData.Step.Question.LongTextQuestionModel)) {
            this.$questionState.validate();
        }
        this.$onAnswerUpdated.invoke();
    }
}
