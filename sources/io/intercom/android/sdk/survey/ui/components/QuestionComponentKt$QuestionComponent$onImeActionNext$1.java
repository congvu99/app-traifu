package io.intercom.android.sdk.survey.ui.components;

import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import io.intercom.android.sdk.survey.QuestionState;
import io.intercom.android.sdk.survey.ValidationError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: QuestionComponent.kt */
final class QuestionComponentKt$QuestionComponent$onImeActionNext$1 extends Lambda implements Function1<KeyboardActionScope, Unit> {
    final /* synthetic */ FocusManager $focusManager;
    final /* synthetic */ SoftwareKeyboardController $keyboardController;
    final /* synthetic */ Function0<Unit> $onAnswerUpdated;
    final /* synthetic */ QuestionState $questionState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuestionComponentKt$QuestionComponent$onImeActionNext$1(QuestionState questionState, Function0<Unit> function0, SoftwareKeyboardController softwareKeyboardController, FocusManager focusManager) {
        super(1);
        this.$questionState = questionState;
        this.$onAnswerUpdated = function0;
        this.$keyboardController = softwareKeyboardController;
        this.$focusManager = focusManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KeyboardActionScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(KeyboardActionScope keyboardActionScope) {
        Intrinsics.checkNotNullParameter(keyboardActionScope, "$this$null");
        this.$questionState.validate();
        this.$onAnswerUpdated.invoke();
        if (this.$questionState.getValidationError() instanceof ValidationError.NoValidationError) {
            SoftwareKeyboardController softwareKeyboardController = this.$keyboardController;
            if (softwareKeyboardController != null) {
                softwareKeyboardController.hide();
            }
            FocusManager.CC.clearFocus$default(this.$focusManager, false, 1, (Object) null);
        }
    }
}
