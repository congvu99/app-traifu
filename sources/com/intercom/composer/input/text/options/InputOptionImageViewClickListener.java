package com.intercom.composer.input.text.options;

import android.view.View;

public class InputOptionImageViewClickListener implements View.OnClickListener {
    private TextInputOption option;

    public InputOptionImageViewClickListener(TextInputOption textInputOption) {
        this.option = textInputOption;
    }

    public void onClick(View view) {
        this.option.inputOptionClicked();
    }
}
