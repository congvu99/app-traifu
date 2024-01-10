package io.intercom.android.sdk.survey.ui;

import io.intercom.android.sdk.survey.SurveyViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/intercom/android/sdk/survey/SurveyViewModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomSurveyActivity.kt */
final class IntercomSurveyActivity$viewModel$2 extends Lambda implements Function0<SurveyViewModel> {
    final /* synthetic */ IntercomSurveyActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomSurveyActivity$viewModel$2(IntercomSurveyActivity intercomSurveyActivity) {
        super(0);
        this.this$0 = intercomSurveyActivity;
    }

    public final SurveyViewModel invoke() {
        return this.this$0.createVM();
    }
}
