package com.trainerfu.story;

import android.content.Context;

public class HBinder extends SectionPartBinder {
    private String headline;

    public HBinder(Context context, String str) {
        super(context);
        this.headline = str;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof HView) {
            ((HView) sectionPartView).setHeadline(this.headline);
            return;
        }
        throw new IllegalArgumentException("Invalid view");
    }
}
