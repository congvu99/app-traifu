package io.intercom.android.sdk.survey.ui.questiontype.dropdown;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: DropDownQuestion.kt */
final class DropDownQuestionKt$DropDownQuestion$1$1$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MutableState<Boolean> $expanded$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DropDownQuestionKt$DropDownQuestion$1$1$1$1$1(MutableState<Boolean> mutableState) {
        super(0);
        this.$expanded$delegate = mutableState;
    }

    public final void invoke() {
        DropDownQuestionKt.m5338DropDownQuestion$lambda2(this.$expanded$delegate, true);
    }
}
