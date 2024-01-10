package com.intercom.composer.watcher;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

public class SendButtonTextWatcher implements TextWatcher {
    private final OnSendButtonStateChangedListener listener;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public SendButtonTextWatcher(OnSendButtonStateChangedListener onSendButtonStateChangedListener) {
        this.listener = onSendButtonStateChangedListener;
    }

    public void afterTextChanged(Editable editable) {
        this.listener.animateSendButtonVisibility(!TextUtils.isEmpty(editable.toString().trim()));
    }
}
