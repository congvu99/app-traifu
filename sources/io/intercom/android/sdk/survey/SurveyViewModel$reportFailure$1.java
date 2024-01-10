package io.intercom.android.sdk.survey;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.survey.SurveyViewModel", f = "SurveyViewModel.kt", i = {}, l = {443}, m = "reportFailure", n = {}, s = {})
/* compiled from: SurveyViewModel.kt */
final class SurveyViewModel$reportFailure$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SurveyViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SurveyViewModel$reportFailure$1(SurveyViewModel surveyViewModel, Continuation<? super SurveyViewModel$reportFailure$1> continuation) {
        super(continuation);
        this.this$0 = surveyViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.reportFailure((String) null, (String) null, this);
    }
}
