package com.trainerfu.story;

import android.content.Context;

public class DividerBinder extends SectionPartBinder {
    private Boolean fullWidth;

    public DividerBinder(Context context, Boolean bool) {
        super(context);
        this.fullWidth = bool;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof DividerView) {
            DividerView dividerView = (DividerView) sectionPartView;
            if (this.fullWidth.booleanValue()) {
                dividerView.setFullWidth();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid View");
    }
}
