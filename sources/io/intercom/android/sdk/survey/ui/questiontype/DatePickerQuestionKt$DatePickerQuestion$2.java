package io.intercom.android.sdk.survey.ui.questiontype;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.survey.model.SurveyData;
import io.intercom.android.sdk.survey.ui.models.Answer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: DatePickerQuestion.kt */
final class DatePickerQuestionKt$DatePickerQuestion$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Answer $answer;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Answer, Unit> $onAnswer;
    final /* synthetic */ Function2<Composer, Integer, Unit> $questionHeader;
    final /* synthetic */ SurveyData.Step.Question.DatePickerQuestionModel $questionModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerQuestionKt$DatePickerQuestion$2(Modifier modifier, SurveyData.Step.Question.DatePickerQuestionModel datePickerQuestionModel, Answer answer, Function1<? super Answer, Unit> function1, Function2<? super Composer, ? super Integer, Unit> function2, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$questionModel = datePickerQuestionModel;
        this.$answer = answer;
        this.$onAnswer = function1;
        this.$questionHeader = function2;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        DatePickerQuestionKt.DatePickerQuestion(this.$modifier, this.$questionModel, this.$answer, this.$onAnswer, this.$questionHeader, composer, this.$$changed | 1, this.$$default);
    }
}
