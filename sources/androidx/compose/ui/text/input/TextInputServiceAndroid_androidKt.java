package androidx.compose.ui.text.input;

import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.TextRange;
import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"DEBUG_CLASS", "", "hasFlag", "", "bits", "", "flag", "update", "", "Landroid/view/inputmethod/EditorInfo;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextInputServiceAndroid.android.kt */
public final class TextInputServiceAndroid_androidKt {
    private static final String DEBUG_CLASS = "TextInputServiceAndroid";

    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    public static final void update(EditorInfo editorInfo, ImeOptions imeOptions, TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(editorInfo, "<this>");
        Intrinsics.checkNotNullParameter(imeOptions, "imeOptions");
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        int r0 = imeOptions.m4386getImeActioneUduSuo();
        int i = 6;
        if (ImeAction.m4371equalsimpl0(r0, ImeAction.Companion.m4375getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i = 0;
            }
        } else if (ImeAction.m4371equalsimpl0(r0, ImeAction.Companion.m4379getNoneeUduSuo())) {
            i = 1;
        } else if (ImeAction.m4371equalsimpl0(r0, ImeAction.Companion.m4377getGoeUduSuo())) {
            i = 2;
        } else if (ImeAction.m4371equalsimpl0(r0, ImeAction.Companion.m4378getNexteUduSuo())) {
            i = 5;
        } else if (ImeAction.m4371equalsimpl0(r0, ImeAction.Companion.m4380getPreviouseUduSuo())) {
            i = 7;
        } else if (ImeAction.m4371equalsimpl0(r0, ImeAction.Companion.m4381getSearcheUduSuo())) {
            i = 3;
        } else if (ImeAction.m4371equalsimpl0(r0, ImeAction.Companion.m4382getSendeUduSuo())) {
            i = 4;
        } else if (!ImeAction.m4371equalsimpl0(r0, ImeAction.Companion.m4376getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        editorInfo.imeOptions = i;
        int r02 = imeOptions.m4387getKeyboardTypePjHm6EE();
        if (KeyboardType.m4404equalsimpl0(r02, KeyboardType.Companion.m4415getTextPjHm6EE())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.m4404equalsimpl0(r02, KeyboardType.Companion.m4408getAsciiPjHm6EE())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m4404equalsimpl0(r02, KeyboardType.Companion.m4411getNumberPjHm6EE())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.m4404equalsimpl0(r02, KeyboardType.Companion.m4414getPhonePjHm6EE())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.m4404equalsimpl0(r02, KeyboardType.Companion.m4416getUriPjHm6EE())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.m4404equalsimpl0(r02, KeyboardType.Companion.m4410getEmailPjHm6EE())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.m4404equalsimpl0(r02, KeyboardType.Companion.m4413getPasswordPjHm6EE())) {
            editorInfo.inputType = 129;
        } else if (KeyboardType.m4404equalsimpl0(r02, KeyboardType.Companion.m4412getNumberPasswordPjHm6EE())) {
            editorInfo.inputType = 18;
        } else if (KeyboardType.m4404equalsimpl0(r02, KeyboardType.Companion.m4409getDecimalPjHm6EE())) {
            editorInfo.inputType = 8194;
        } else {
            throw new IllegalStateException("Invalid Keyboard Type".toString());
        }
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m4371equalsimpl0(imeOptions.m4386getImeActioneUduSuo(), ImeAction.Companion.m4375getDefaulteUduSuo())) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int r03 = imeOptions.m4385getCapitalizationIUNYP9k();
            if (KeyboardCapitalization.m4393equalsimpl0(r03, KeyboardCapitalization.Companion.m4397getCharactersIUNYP9k())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.m4393equalsimpl0(r03, KeyboardCapitalization.Companion.m4400getWordsIUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.m4393equalsimpl0(r03, KeyboardCapitalization.Companion.m4399getSentencesIUNYP9k())) {
                editorInfo.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = TextRange.m4220getStartimpl(textFieldValue.m4422getSelectiond9O1mEE());
        editorInfo.initialSelEnd = TextRange.m4215getEndimpl(textFieldValue.m4422getSelectiond9O1mEE());
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textFieldValue.getText());
        editorInfo.imeOptions |= 33554432;
    }
}
