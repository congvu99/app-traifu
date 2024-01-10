package io.intercom.android.sdk.survey.ui.components;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.survey.SurveyState;
import io.intercom.android.sdk.survey.SurveyUiColors;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyCtaButtonComponent.kt */
final class SurveyCtaButtonComponentKt$SurveyCtaButtonComponent$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onPrimaryCtaClicked;
    final /* synthetic */ Function1<SurveyState.Content.SecondaryCta, Unit> $onSecondaryCtaClicked;
    final /* synthetic */ String $primaryCtaText;
    final /* synthetic */ List<SurveyState.Content.SecondaryCta> $secondaryCtas;
    final /* synthetic */ SurveyUiColors $surveyUiColors;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SurveyCtaButtonComponentKt$SurveyCtaButtonComponent$4(Modifier modifier, String str, List<SurveyState.Content.SecondaryCta> list, Function0<Unit> function0, Function1<? super SurveyState.Content.SecondaryCta, Unit> function1, SurveyUiColors surveyUiColors, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$primaryCtaText = str;
        this.$secondaryCtas = list;
        this.$onPrimaryCtaClicked = function0;
        this.$onSecondaryCtaClicked = function1;
        this.$surveyUiColors = surveyUiColors;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SurveyCtaButtonComponentKt.SurveyCtaButtonComponent(this.$modifier, this.$primaryCtaText, this.$secondaryCtas, this.$onPrimaryCtaClicked, this.$onSecondaryCtaClicked, this.$surveyUiColors, composer, this.$$changed | 1, this.$$default);
    }
}
