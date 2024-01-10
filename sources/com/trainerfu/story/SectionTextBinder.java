package com.trainerfu.story;

import android.content.Context;

public class SectionTextBinder extends SectionPartBinder {
    private String text;

    public SectionTextBinder(Context context, String str) {
        super(context);
        this.text = str;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof SectionTextView) {
            ((SectionTextView) sectionPartView).setText(this.text.replaceAll("\n\\s*\n", ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE));
            return;
        }
        throw new IllegalArgumentException("Invalid view");
    }
}
