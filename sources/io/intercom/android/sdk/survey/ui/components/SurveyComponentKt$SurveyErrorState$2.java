package io.intercom.android.sdk.survey.ui.components;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyComponent.kt */
final class SurveyComponentKt$SurveyErrorState$2 extends Lambda implements Function1<CoroutineScope, Unit> {
    public static final SurveyComponentKt$SurveyErrorState$2 INSTANCE = new SurveyComponentKt$SurveyErrorState$2();

    SurveyComponentKt$SurveyErrorState$2() {
        super(1);
    }

    public final void invoke(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CoroutineScope) obj);
        return Unit.INSTANCE;
    }
}
