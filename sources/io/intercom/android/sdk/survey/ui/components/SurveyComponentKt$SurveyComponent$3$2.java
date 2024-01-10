package io.intercom.android.sdk.survey.ui.components;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.survey.SurveyState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyComponent.kt */
final class SurveyComponentKt$SurveyComponent$3$2 extends Lambda implements Function3<PaddingValues, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function0<Unit> $onAnswerUpdated;
    final /* synthetic */ Function1<CoroutineScope, Unit> $onContinue;
    final /* synthetic */ Function1<SurveyState.Content.SecondaryCta, Unit> $onSecondaryCtaClicked;
    final /* synthetic */ SurveyState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SurveyComponentKt$SurveyComponent$3$2(SurveyState surveyState, Function1<? super CoroutineScope, Unit> function1, Function0<Unit> function0, Function1<? super SurveyState.Content.SecondaryCta, Unit> function12, int i) {
        super(3);
        this.$state = surveyState;
        this.$onContinue = function1;
        this.$onAnswerUpdated = function0;
        this.$onSecondaryCtaClicked = function12;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((PaddingValues) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(PaddingValues paddingValues, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(paddingValues, "it");
        if ((i & 14) == 0) {
            i |= composer.changed((Object) paddingValues) ? 4 : 2;
        }
        if ((i & 91) != 18 || !composer.getSkipping()) {
            paddingValues.m520calculateBottomPaddingD9Ej5fM();
            SurveyState surveyState = this.$state;
            if (surveyState instanceof SurveyState.Content) {
                composer.startReplaceableGroup(-432078913);
                Function1<CoroutineScope, Unit> function1 = this.$onContinue;
                Function0<Unit> function0 = this.$onAnswerUpdated;
                Function1<SurveyState.Content.SecondaryCta, Unit> function12 = this.$onSecondaryCtaClicked;
                int i2 = this.$$dirty;
                SurveyComponentKt.SurveyContent((SurveyState.Content) this.$state, function1, function0, function12, composer, (i2 & 112) | 8 | ((i2 >> 3) & 896) | ((i2 >> 3) & 7168));
                composer.endReplaceableGroup();
            } else if (surveyState instanceof SurveyState.Error) {
                composer.startReplaceableGroup(-432078627);
                ErrorComponentKt.SurveyError((SurveyState.Error) this.$state, composer, 0);
                composer.endReplaceableGroup();
            } else if (surveyState instanceof SurveyState.Loading) {
                composer.startReplaceableGroup(-432078554);
                LoadingComponentKt.SurveyLoading((SurveyState.Loading) this.$state, composer, 0);
                composer.endReplaceableGroup();
            } else if (Intrinsics.areEqual((Object) surveyState, (Object) SurveyState.Initial.INSTANCE)) {
                composer.startReplaceableGroup(-432078482);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-432078462);
                composer.endReplaceableGroup();
            }
        } else {
            composer.skipToGroupEnd();
        }
    }
}
