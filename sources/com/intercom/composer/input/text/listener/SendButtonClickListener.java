package com.intercom.composer.input.text.listener;

import android.view.View;
import android.widget.EditText;

public class SendButtonClickListener implements View.OnClickListener {
    private final EditText editText;
    private final OnSendButtonClickedListener listener;

    public SendButtonClickListener(OnSendButtonClickedListener onSendButtonClickedListener, EditText editText2) {
        this.listener = onSendButtonClickedListener;
        this.editText = editText2;
    }

    public void onClick(View view) {
        this.listener.onSendButtonClicked(this.editText.getText());
        clearEditText();
    }

    /* access modifiers changed from: package-private */
    public void clearEditText() {
        this.editText.setText("");
    }
}
