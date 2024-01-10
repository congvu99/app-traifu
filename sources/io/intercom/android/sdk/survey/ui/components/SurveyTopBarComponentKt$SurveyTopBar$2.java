package io.intercom.android.sdk.survey.ui.components;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.survey.TopBarState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyTopBarComponent.kt */
final class SurveyTopBarComponentKt$SurveyTopBar$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function0<Unit> $onClose;
    final /* synthetic */ TopBarState $topBarState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SurveyTopBarComponentKt$SurveyTopBar$2(TopBarState topBarState, Function0<Unit> function0, int i) {
        super(2);
        this.$topBarState = topBarState;
        this.$onClose = function0;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SurveyTopBarComponentKt.SurveyTopBar(this.$topBarState, this.$onClose, composer, this.$$changed | 1);
    }
}
