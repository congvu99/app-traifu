package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BasicTextField.kt */
final class BasicTextFieldKt$BasicTextField$3$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TextFieldValue $textFieldValue;
    final /* synthetic */ MutableState<TextFieldValue> $textFieldValueState$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextFieldKt$BasicTextField$3$1(TextFieldValue textFieldValue, MutableState<TextFieldValue> mutableState) {
        super(0);
        this.$textFieldValue = textFieldValue;
        this.$textFieldValueState$delegate = mutableState;
    }

    public final void invoke() {
        if (!TextRange.m4213equalsimpl0(this.$textFieldValue.m4422getSelectiond9O1mEE(), BasicTextFieldKt.m859BasicTextField$lambda2(this.$textFieldValueState$delegate).m4422getSelectiond9O1mEE()) || !Intrinsics.areEqual((Object) this.$textFieldValue.m4421getCompositionMzsxiRA(), (Object) BasicTextFieldKt.m859BasicTextField$lambda2(this.$textFieldValueState$delegate).m4421getCompositionMzsxiRA())) {
            BasicTextFieldKt.m860BasicTextField$lambda3(this.$textFieldValueState$delegate, this.$textFieldValue);
        }
    }
}
