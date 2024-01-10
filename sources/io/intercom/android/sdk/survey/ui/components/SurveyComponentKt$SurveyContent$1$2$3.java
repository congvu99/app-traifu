package io.intercom.android.sdk.survey.ui.components;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyComponent.kt */
final class SurveyComponentKt$SurveyContent$1$2$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ Function1<CoroutineScope, Unit> $onContinue;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SurveyComponentKt$SurveyContent$1$2$3(Function1<? super CoroutineScope, Unit> function1, CoroutineScope coroutineScope) {
        super(0);
        this.$onContinue = function1;
        this.$coroutineScope = coroutineScope;
    }

    public final void invoke() {
        this.$onContinue.invoke(this.$coroutineScope);
    }
}
