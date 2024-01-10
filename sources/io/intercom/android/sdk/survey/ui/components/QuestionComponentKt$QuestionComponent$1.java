package io.intercom.android.sdk.survey.ui.components;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import io.intercom.android.sdk.survey.QuestionState;
import io.intercom.android.sdk.survey.SurveyUiColors;
import io.intercom.android.sdk.survey.model.SurveyData;
import io.intercom.android.sdk.survey.ui.models.Answer;
import io.intercom.android.sdk.survey.ui.questiontype.DatePickerQuestionKt;
import io.intercom.android.sdk.survey.ui.questiontype.choice.MultipleChoiceQuestionKt;
import io.intercom.android.sdk.survey.ui.questiontype.choice.SingleChoiceQuestionKt;
import io.intercom.android.sdk.survey.ui.questiontype.dropdown.DropDownQuestionKt;
import io.intercom.android.sdk.survey.ui.questiontype.numericscale.NumericRatingQuestionKt;
import io.intercom.android.sdk.survey.ui.questiontype.text.LongTextQuestionKt;
import io.intercom.android.sdk.survey.ui.questiontype.text.ShortTextQuestionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: QuestionComponent.kt */
final class QuestionComponentKt$QuestionComponent$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Modifier $contentModifier;
    final /* synthetic */ Function1<Answer, Unit> $onAnswer;
    final /* synthetic */ Function1<KeyboardActionScope, Unit> $onImeActionNext;
    final /* synthetic */ Function2<Composer, Integer, Unit> $questionHeader;
    final /* synthetic */ QuestionState $questionState;
    final /* synthetic */ SurveyUiColors $surveyUiColors;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuestionComponentKt$QuestionComponent$1(QuestionState questionState, Modifier modifier, Function1<? super Answer, Unit> function1, SurveyUiColors surveyUiColors, Function2<? super Composer, ? super Integer, Unit> function2, int i, Function1<? super KeyboardActionScope, Unit> function12) {
        super(2);
        this.$questionState = questionState;
        this.$contentModifier = modifier;
        this.$onAnswer = function1;
        this.$surveyUiColors = surveyUiColors;
        this.$questionHeader = function2;
        this.$$dirty = i;
        this.$onImeActionNext = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        if ((i & 11) != 2 || !composer.getSkipping()) {
            QuestionState questionState = this.$questionState;
            Modifier modifier = this.$contentModifier;
            Function1<Answer, Unit> function1 = this.$onAnswer;
            SurveyUiColors surveyUiColors = this.$surveyUiColors;
            Function2<Composer, Integer, Unit> function2 = this.$questionHeader;
            int i2 = this.$$dirty;
            Function1<KeyboardActionScope, Unit> function12 = this.$onImeActionNext;
            composer2.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(composer);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer r13 = Updater.m1543constructorimpl(composer);
            Updater.m1550setimpl(r13, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r13, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r13, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r13, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-1163856341);
            ComposerKt.sourceInformation(composer2, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            SurveyData.Step.Question.QuestionModel questionModel = questionState.getQuestionModel();
            if (questionModel instanceof SurveyData.Step.Question.DropDownQuestionModel) {
                composer2.startReplaceableGroup(466340482);
                DropDownQuestionKt.DropDownQuestion(modifier, (SurveyData.Step.Question.DropDownQuestionModel) questionModel, questionState.getAnswer(), function1, surveyUiColors, function2, composer, ((i2 >> 3) & 14) | 196672 | ((i2 << 3) & 57344), 0);
                composer.endReplaceableGroup();
            } else if (questionModel instanceof SurveyData.Step.Question.ShortTextQuestionModel) {
                composer2.startReplaceableGroup(466340919);
                ShortTextQuestionKt.ShortTextQuestion(modifier, (SurveyData.Step.Question.ShortTextQuestionModel) questionModel, questionState.getAnswer(), function1, surveyUiColors, questionState.getValidationError(), function12, function2, composer, ((i2 >> 3) & 14) | 12582912 | ((i2 << 3) & 57344), 0);
                composer.endReplaceableGroup();
            } else if (questionModel instanceof SurveyData.Step.Question.LongTextQuestionModel) {
                composer2.startReplaceableGroup(466341484);
                LongTextQuestionKt.LongTextQuestion(modifier, (SurveyData.Step.Question.LongTextQuestionModel) questionModel, questionState.getAnswer(), function1, surveyUiColors, questionState.getValidationError(), function12, function2, composer, ((i2 >> 3) & 14) | 12582912 | ((i2 << 3) & 57344), 0);
                composer.endReplaceableGroup();
            } else if (questionModel instanceof SurveyData.Step.Question.NumericRatingQuestionModel) {
                composer2.startReplaceableGroup(466342053);
                NumericRatingQuestionKt.NumericRatingQuestion(modifier, (SurveyData.Step.Question.NumericRatingQuestionModel) questionModel, questionState.getAnswer(), function1, surveyUiColors, function2, composer, ((i2 >> 3) & 14) | 196672 | ((i2 << 3) & 57344), 0);
                composer.endReplaceableGroup();
            } else if (questionModel instanceof SurveyData.Step.Question.SingleChoiceQuestionModel) {
                composer2.startReplaceableGroup(466342503);
                SingleChoiceQuestionKt.SingleChoiceQuestion(modifier, (SurveyData.Step.Question.SingleChoiceQuestionModel) questionModel, questionState.getAnswer(), function1, surveyUiColors, function2, composer, ((i2 >> 3) & 14) | 196672 | ((i2 << 3) & 57344), 0);
                composer.endReplaceableGroup();
            } else if (questionModel instanceof SurveyData.Step.Question.MultipleChoiceQuestionModel) {
                composer2.startReplaceableGroup(466342953);
                MultipleChoiceQuestionKt.MultipleChoiceQuestion(modifier, (SurveyData.Step.Question.MultipleChoiceQuestionModel) questionModel, questionState.getAnswer(), function1, surveyUiColors, function2, composer, ((i2 >> 3) & 14) | 196672 | ((i2 << 3) & 57344), 0);
                composer.endReplaceableGroup();
            } else if (questionModel instanceof SurveyData.Step.Question.DatePickerQuestionModel) {
                composer2.startReplaceableGroup(466343428);
                DatePickerQuestionKt.DatePickerQuestion(modifier, (SurveyData.Step.Question.DatePickerQuestionModel) questionModel, questionState.getAnswer(), function1, function2, composer, ((i2 >> 3) & 14) | 24576, 0);
                composer.endReplaceableGroup();
            } else if (Intrinsics.areEqual((Object) questionModel, (Object) SurveyData.Step.Question.UnsupportedQuestion.INSTANCE)) {
                composer2.startReplaceableGroup(466343804);
                composer.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(466343865);
                composer.endReplaceableGroup();
            }
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            return;
        }
        composer.skipToGroupEnd();
    }
}
