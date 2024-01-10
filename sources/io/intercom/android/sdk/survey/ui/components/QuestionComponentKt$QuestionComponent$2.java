package io.intercom.android.sdk.survey.ui.components;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import io.intercom.android.sdk.survey.QuestionState;
import io.intercom.android.sdk.survey.SurveyUiColors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: QuestionComponent.kt */
final class QuestionComponentKt$QuestionComponent$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ Modifier $contentModifier;
    final /* synthetic */ float $elevation;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onAnswerUpdated;
    final /* synthetic */ long $questionFontSize;
    final /* synthetic */ FontWeight $questionFontWeight;
    final /* synthetic */ QuestionState $questionState;
    final /* synthetic */ SurveyUiColors $surveyUiColors;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuestionComponentKt$QuestionComponent$2(Modifier modifier, Modifier modifier2, QuestionState questionState, SurveyUiColors surveyUiColors, Function0<Unit> function0, long j, float f, FontWeight fontWeight, long j2, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$contentModifier = modifier2;
        this.$questionState = questionState;
        this.$surveyUiColors = surveyUiColors;
        this.$onAnswerUpdated = function0;
        this.$backgroundColor = j;
        this.$elevation = f;
        this.$questionFontWeight = fontWeight;
        this.$questionFontSize = j2;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        QuestionComponentKt.m5311QuestionComponent3mDWlBA(this.$modifier, this.$contentModifier, this.$questionState, this.$surveyUiColors, this.$onAnswerUpdated, this.$backgroundColor, this.$elevation, this.$questionFontWeight, this.$questionFontSize, composer, this.$$changed | 1, this.$$default);
    }
}
