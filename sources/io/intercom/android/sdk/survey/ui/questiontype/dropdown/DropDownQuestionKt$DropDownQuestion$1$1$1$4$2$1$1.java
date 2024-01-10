package io.intercom.android.sdk.survey.ui.questiontype.dropdown;

import androidx.compose.runtime.MutableState;
import io.intercom.android.sdk.survey.ui.models.Answer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: DropDownQuestion.kt */
final class DropDownQuestionKt$DropDownQuestion$1$1$1$4$2$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MutableState<Boolean> $expanded$delegate;
    final /* synthetic */ Function1<Answer, Unit> $onAnswer;
    final /* synthetic */ String $optionText;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DropDownQuestionKt$DropDownQuestion$1$1$1$4$2$1$1(Function1<? super Answer, Unit> function1, String str, MutableState<Boolean> mutableState) {
        super(0);
        this.$onAnswer = function1;
        this.$optionText = str;
        this.$expanded$delegate = mutableState;
    }

    public final void invoke() {
        this.$onAnswer.invoke(new Answer.SingleAnswer(this.$optionText));
        DropDownQuestionKt.m5338DropDownQuestion$lambda2(this.$expanded$delegate, false);
    }
}
