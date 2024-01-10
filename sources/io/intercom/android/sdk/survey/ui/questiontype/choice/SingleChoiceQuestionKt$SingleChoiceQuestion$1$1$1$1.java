package io.intercom.android.sdk.survey.ui.questiontype.choice;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.focus.FocusManager;
import io.intercom.android.sdk.survey.ui.models.Answer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SingleChoiceQuestion.kt */
final class SingleChoiceQuestionKt$SingleChoiceQuestion$1$1$1$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ FocusManager $focusManager;
    final /* synthetic */ Function1<Answer, Unit> $onAnswer;
    final /* synthetic */ MutableState<Boolean> $otherOptionSelectionState;
    final /* synthetic */ String $unparsedOption;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SingleChoiceQuestionKt$SingleChoiceQuestion$1$1$1$1(FocusManager focusManager, MutableState<Boolean> mutableState, Function1<? super Answer, Unit> function1, String str) {
        super(1);
        this.$focusManager = focusManager;
        this.$otherOptionSelectionState = mutableState;
        this.$onAnswer = function1;
        this.$unparsedOption = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        FocusManager.CC.clearFocus$default(this.$focusManager, false, 1, (Object) null);
        this.$otherOptionSelectionState.setValue(false);
        this.$onAnswer.invoke(new Answer.SingleAnswer(this.$unparsedOption));
    }
}
