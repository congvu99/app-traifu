package io.intercom.android.sdk.survey.ui.questiontype.choice;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.survey.SurveyUiColors;
import io.intercom.android.sdk.survey.model.SurveyData;
import io.intercom.android.sdk.survey.ui.models.Answer;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: MultipleChoiceQuestion.kt */
final class MultipleChoiceQuestionKt$PreviewQuestion$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ SurveyUiColors $surveyUiColors;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultipleChoiceQuestionKt$PreviewQuestion$1(SurveyUiColors surveyUiColors, int i) {
        super(2);
        this.$surveyUiColors = surveyUiColors;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            String uuid = UUID.randomUUID().toString();
            List listOf = CollectionsKt.listOf(new Block.Builder().withText("Question Title"));
            List listOf2 = CollectionsKt.listOf("Option A", "Option B", "Option C", "Option D", "Option E");
            Intrinsics.checkNotNullExpressionValue(uuid, "toString()");
            SurveyData.Step.Question.MultipleChoiceQuestionModel multipleChoiceQuestionModel = new SurveyData.Step.Question.MultipleChoiceQuestionModel(uuid, listOf, true, listOf2, true, 2, 3);
            SurveyData.Step.Question.MultipleChoiceQuestionModel multipleChoiceQuestionModel2 = multipleChoiceQuestionModel;
            MultipleChoiceQuestionKt.MultipleChoiceQuestion((Modifier) null, multipleChoiceQuestionModel2, new Answer.MultipleAnswer(SetsKt.setOf("Option B", "Option D"), Answer.MultipleAnswer.OtherAnswer.SelectedNoText.INSTANCE), AnonymousClass1.INSTANCE, this.$surveyUiColors, (Function2<? super Composer, ? super Integer, Unit>) null, composer, (57344 & (this.$$dirty << 12)) | 3648, 33);
            return;
        }
        composer.skipToGroupEnd();
    }
}
