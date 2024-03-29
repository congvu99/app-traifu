package com.intercom.composer.input.text;

import android.widget.EditText;
import com.intercom.composer.input.IconProvider;
import com.intercom.composer.input.Input;
import com.intercom.composer.input.InputFragment;
import com.intercom.composer.input.text.options.TextInputOption;
import java.util.List;

public abstract class TextInput<T extends InputFragment> extends Input<T> {
    private EditText editText;
    private final List<TextInputOption> options;
    private SendTextCallback sendTextCallback;

    /* access modifiers changed from: protected */
    public abstract EditText createEditText();

    public TextInput(String str, IconProvider iconProvider, SendTextCallback sendTextCallback2) {
        this(str, iconProvider, sendTextCallback2, (List<TextInputOption>) null);
    }

    public TextInput(String str, IconProvider iconProvider, SendTextCallback sendTextCallback2, List<TextInputOption> list) {
        super(str, iconProvider);
        this.sendTextCallback = sendTextCallback2;
        this.options = list;
    }

    public EditText getEditText() {
        if (this.editText == null) {
            this.editText = createEditText();
        }
        return this.editText;
    }

    public void sendTextBack(CharSequence charSequence) {
        this.sendTextCallback.textToBeSent(this, charSequence);
    }

    public List<TextInputOption> getOptions() {
        return this.options;
    }
}
