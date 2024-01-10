package io.intercom.android.sdk.survey.ui.questiontype;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.survey.ui.models.Answer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: DatePickerQuestion.kt */
final class DatePickerQuestionKt$TimePicker$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Answer $answer;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Answer, Unit> $onAnswer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerQuestionKt$TimePicker$3(Modifier modifier, Answer answer, Function1<? super Answer, Unit> function1, int i) {
        super(2);
        this.$modifier = modifier;
        this.$answer = answer;
        this.$onAnswer = function1;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        DatePickerQuestionKt.TimePicker(this.$modifier, this.$answer, this.$onAnswer, composer, this.$$changed | 1);
    }
}
