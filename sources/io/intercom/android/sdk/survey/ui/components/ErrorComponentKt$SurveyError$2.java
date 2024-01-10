package io.intercom.android.sdk.survey.ui.components;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.survey.SurveyState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ErrorComponent.kt */
final class ErrorComponentKt$SurveyError$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ SurveyState.Error $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ErrorComponentKt$SurveyError$2(SurveyState.Error error, int i) {
        super(2);
        this.$state = error;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ErrorComponentKt.SurveyError(this.$state, composer, this.$$changed | 1);
    }
}
