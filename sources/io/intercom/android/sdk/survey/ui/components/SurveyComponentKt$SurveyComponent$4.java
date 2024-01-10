package io.intercom.android.sdk.survey.ui.components;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.survey.SurveyState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyComponent.kt */
final class SurveyComponentKt$SurveyComponent$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function0<Unit> $onAnswerUpdated;
    final /* synthetic */ Function0<Unit> $onClose;
    final /* synthetic */ Function1<CoroutineScope, Unit> $onContinue;
    final /* synthetic */ Function1<SurveyState.Content.SecondaryCta, Unit> $onSecondaryCtaClicked;
    final /* synthetic */ SurveyState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SurveyComponentKt$SurveyComponent$4(SurveyState surveyState, Function1<? super CoroutineScope, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function1<? super SurveyState.Content.SecondaryCta, Unit> function12, int i, int i2) {
        super(2);
        this.$state = surveyState;
        this.$onContinue = function1;
        this.$onClose = function0;
        this.$onAnswerUpdated = function02;
        this.$onSecondaryCtaClicked = function12;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SurveyComponentKt.SurveyComponent(this.$state, this.$onContinue, this.$onClose, this.$onAnswerUpdated, this.$onSecondaryCtaClicked, composer, this.$$changed | 1, this.$$default);
    }
}
