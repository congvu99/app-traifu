package io.intercom.android.sdk.survey.ui.questiontype.numericscale;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.survey.model.SurveyData;
import io.intercom.android.sdk.survey.ui.models.Answer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NumericRatingQuestion.kt */
final class NumericRatingQuestionKt$GeneratePreview$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Answer $answer;
    final /* synthetic */ int $end;
    final /* synthetic */ SurveyData.Step.Question.QuestionData.QuestionSubType $questionSubType;
    final /* synthetic */ int $start;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NumericRatingQuestionKt$GeneratePreview$2(int i, int i2, SurveyData.Step.Question.QuestionData.QuestionSubType questionSubType, Answer answer, int i3) {
        super(2);
        this.$start = i;
        this.$end = i2;
        this.$questionSubType = questionSubType;
        this.$answer = answer;
        this.$$changed = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        NumericRatingQuestionKt.GeneratePreview(this.$start, this.$end, this.$questionSubType, this.$answer, composer, this.$$changed | 1);
    }
}
