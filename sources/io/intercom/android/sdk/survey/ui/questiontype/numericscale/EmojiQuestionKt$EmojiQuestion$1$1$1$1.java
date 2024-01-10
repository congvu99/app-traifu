package io.intercom.android.sdk.survey.ui.questiontype.numericscale;

import io.intercom.android.sdk.survey.model.SurveyData;
import io.intercom.android.sdk.survey.ui.models.Answer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: EmojiQuestion.kt */
final class EmojiQuestionKt$EmojiQuestion$1$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<Answer, Unit> $onAnswer;
    final /* synthetic */ SurveyData.Step.Question.NumericRatingQuestionModel.RatingOption.EmojiRatingOption $option;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EmojiQuestionKt$EmojiQuestion$1$1$1$1(Function1<? super Answer, Unit> function1, SurveyData.Step.Question.NumericRatingQuestionModel.RatingOption.EmojiRatingOption emojiRatingOption) {
        super(0);
        this.$onAnswer = function1;
        this.$option = emojiRatingOption;
    }

    public final void invoke() {
        this.$onAnswer.invoke(new Answer.SingleAnswer(String.valueOf(this.$option.getValue())));
    }
}
