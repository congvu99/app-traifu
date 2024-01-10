package com.trainerfu.story;

import android.content.Context;

public class CheckinBinder extends SectionPartBinder {
    private boolean didCheckin;

    public CheckinBinder(Context context, boolean z) {
        super(context);
        this.didCheckin = z;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof CheckinView) {
            ((CheckinView) sectionPartView).setCheckin(this.didCheckin);
            return;
        }
        throw new IllegalArgumentException("Invalid view");
    }
}
