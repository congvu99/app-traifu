package io.intercom.android.sdk.survey;

import io.intercom.android.sdk.survey.ui.models.Answer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/intercom/android/sdk/survey/ui/models/Answer;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyViewModel.kt */
final class QuestionState$answer$2 extends Lambda implements Function0<Answer> {
    final /* synthetic */ QuestionState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuestionState$answer$2(QuestionState questionState) {
        super(0);
        this.this$0 = questionState;
    }

    public final Answer invoke() {
        return this.this$0.get_answer();
    }
}
