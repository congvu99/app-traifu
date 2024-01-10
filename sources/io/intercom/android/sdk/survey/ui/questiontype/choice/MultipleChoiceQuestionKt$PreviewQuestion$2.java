package io.intercom.android.sdk.survey.ui.questiontype.choice;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.survey.SurveyUiColors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: MultipleChoiceQuestion.kt */
final class MultipleChoiceQuestionKt$PreviewQuestion$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ SurveyUiColors $surveyUiColors;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultipleChoiceQuestionKt$PreviewQuestion$2(SurveyUiColors surveyUiColors, int i) {
        super(2);
        this.$surveyUiColors = surveyUiColors;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        MultipleChoiceQuestionKt.PreviewQuestion(this.$surveyUiColors, composer, this.$$changed | 1);
    }
}
