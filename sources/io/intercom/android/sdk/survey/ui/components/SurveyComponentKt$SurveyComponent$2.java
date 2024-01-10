package io.intercom.android.sdk.survey.ui.components;

import io.intercom.android.sdk.survey.SurveyState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyComponent.kt */
final class SurveyComponentKt$SurveyComponent$2 extends Lambda implements Function1<SurveyState.Content.SecondaryCta, Unit> {
    public static final SurveyComponentKt$SurveyComponent$2 INSTANCE = new SurveyComponentKt$SurveyComponent$2();

    SurveyComponentKt$SurveyComponent$2() {
        super(1);
    }

    public final void invoke(SurveyState.Content.SecondaryCta secondaryCta) {
        Intrinsics.checkNotNullParameter(secondaryCta, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SurveyState.Content.SecondaryCta) obj);
        return Unit.INSTANCE;
    }
}
