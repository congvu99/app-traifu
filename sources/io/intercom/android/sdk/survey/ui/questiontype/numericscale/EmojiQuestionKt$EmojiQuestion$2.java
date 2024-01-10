package io.intercom.android.sdk.survey.ui.questiontype.numericscale;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.survey.model.SurveyData;
import io.intercom.android.sdk.survey.ui.models.Answer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: EmojiQuestion.kt */
final class EmojiQuestionKt$EmojiQuestion$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Answer $answer;
    final /* synthetic */ Function1<Answer, Unit> $onAnswer;
    final /* synthetic */ List<SurveyData.Step.Question.NumericRatingQuestionModel.RatingOption.EmojiRatingOption> $options;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EmojiQuestionKt$EmojiQuestion$2(List<SurveyData.Step.Question.NumericRatingQuestionModel.RatingOption.EmojiRatingOption> list, Answer answer, Function1<? super Answer, Unit> function1, int i) {
        super(2);
        this.$options = list;
        this.$answer = answer;
        this.$onAnswer = function1;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        EmojiQuestionKt.EmojiQuestion(this.$options, this.$answer, this.$onAnswer, composer, this.$$changed | 1);
    }
}
