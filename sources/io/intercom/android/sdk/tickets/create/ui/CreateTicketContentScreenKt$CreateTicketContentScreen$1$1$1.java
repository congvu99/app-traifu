package io.intercom.android.sdk.tickets.create.ui;

import androidx.compose.ui.focus.FocusState;
import io.intercom.android.sdk.survey.QuestionState;
import io.intercom.android.sdk.survey.model.SurveyData;
import io.intercom.android.sdk.survey.ui.models.Answer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: CreateTicketContentScreen.kt */
final class CreateTicketContentScreenKt$CreateTicketContentScreen$1$1$1 extends Lambda implements Function1<FocusState, Unit> {
    final /* synthetic */ QuestionState $questionState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateTicketContentScreenKt$CreateTicketContentScreen$1$1$1(QuestionState questionState) {
        super(1);
        this.$questionState = questionState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FocusState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "it");
        if ((this.$questionState.getQuestionModel() instanceof SurveyData.Step.Question.ShortTextQuestionModel) && !(this.$questionState.getAnswer() instanceof Answer.NoAnswer.InitialNoAnswer) && !focusState.getHasFocus()) {
            this.$questionState.validate();
        }
    }
}
