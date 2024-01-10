package io.intercom.android.sdk.survey.ui.questiontype.choice;

import androidx.compose.runtime.MutableState;
import io.intercom.android.sdk.survey.ui.models.Answer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SingleChoiceQuestion.kt */
final class SingleChoiceQuestionKt$SingleChoiceQuestion$1$1$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<Answer, Unit> $onAnswer;
    final /* synthetic */ MutableState<Boolean> $otherOptionSelectionState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SingleChoiceQuestionKt$SingleChoiceQuestion$1$1$2$1(Function1<? super Answer, Unit> function1, MutableState<Boolean> mutableState) {
        super(0);
        this.$onAnswer = function1;
        this.$otherOptionSelectionState = mutableState;
    }

    public final void invoke() {
        this.$onAnswer.invoke(Answer.NoAnswer.ResetNoAnswer.INSTANCE);
        MutableState<Boolean> mutableState = this.$otherOptionSelectionState;
        mutableState.setValue(Boolean.valueOf(!mutableState.getValue().booleanValue()));
    }
}
