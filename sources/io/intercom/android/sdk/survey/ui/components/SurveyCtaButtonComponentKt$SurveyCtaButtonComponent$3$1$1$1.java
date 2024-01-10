package io.intercom.android.sdk.survey.ui.components;

import io.intercom.android.sdk.survey.SurveyState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyCtaButtonComponent.kt */
final class SurveyCtaButtonComponentKt$SurveyCtaButtonComponent$3$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SurveyState.Content.SecondaryCta $it;
    final /* synthetic */ Function1<SurveyState.Content.SecondaryCta, Unit> $onSecondaryCtaClicked;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SurveyCtaButtonComponentKt$SurveyCtaButtonComponent$3$1$1$1(Function1<? super SurveyState.Content.SecondaryCta, Unit> function1, SurveyState.Content.SecondaryCta secondaryCta) {
        super(0);
        this.$onSecondaryCtaClicked = function1;
        this.$it = secondaryCta;
    }

    public final void invoke() {
        this.$onSecondaryCtaClicked.invoke(this.$it);
    }
}
