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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SingleChoiceQuestion.kt */
final class SingleChoiceQuestionKt$SingleChoiceQuestionPreview$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ SurveyUiColors $surveyUiColors;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SingleChoiceQuestionKt$SingleChoiceQuestionPreview$1(SurveyUiColors surveyUiColors, int i) {
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
            List listOf = CollectionsKt.listOf(new Block.Builder().withText("Question title"));
            List listOf2 = CollectionsKt.listOf("Option 1", "Option 2", "Option 3", "Option 4");
            Intrinsics.checkNotNullExpressionValue(uuid, "toString()");
            SurveyData.Step.Question.SingleChoiceQuestionModel singleChoiceQuestionModel = new SurveyData.Step.Question.SingleChoiceQuestionModel(uuid, listOf, true, listOf2, false);
            SurveyData.Step.Question.SingleChoiceQuestionModel singleChoiceQuestionModel2 = singleChoiceQuestionModel;
            SingleChoiceQuestionKt.SingleChoiceQuestion((Modifier) null, singleChoiceQuestionModel2, new Answer.SingleAnswer("Option 2"), AnonymousClass1.INSTANCE, this.$surveyUiColors, (Function2<? super Composer, ? super Integer, Unit>) null, composer, (57344 & (this.$$dirty << 12)) | 3136, 33);
            return;
        }
        composer.skipToGroupEnd();
    }
}
