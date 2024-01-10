package io.intercom.android.sdk.conversation.composer.textinput;

import android.widget.EditText;
import com.intercom.composer.input.IconProvider;
import com.intercom.composer.input.empty.EmptyFragment;
import com.intercom.composer.input.text.SendTextCallback;
import com.intercom.composer.input.text.TextInput;
import com.intercom.composer.input.text.options.TextInputOption;
import java.util.List;

public class MessengerTextInput extends TextInput<EmptyFragment> {
    private final EditText editText;

    public MessengerTextInput(String str, IconProvider iconProvider, CharSequence charSequence, Integer num, CharSequence charSequence2, SendTextCallback sendTextCallback, EditText editText2) {
        super(str, iconProvider, sendTextCallback, (List<TextInputOption>) null);
        this.editText = editText2;
        editText2.setHint(charSequence);
        editText2.setText(charSequence2);
        if (num != null) {
            editText2.setHintTextColor(num.intValue());
        }
    }

    public EditText createEditText() {
        return this.editText;
    }

    public EmptyFragment createFragment() {
        return new EmptyFragment();
    }
}
