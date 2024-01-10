package com.trainerfu.story;

import android.content.Context;

public class EmptyViewBinder extends SectionPartBinder {
    private Boolean showCheckinText = false;

    public EmptyViewBinder(Context context, Boolean bool) {
        super(context);
        this.showCheckinText = bool;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof EmptyView) {
            EmptyView emptyView = (EmptyView) sectionPartView;
            if (this.showCheckinText.booleanValue()) {
                emptyView.setEmptyViewText("Client is not assigned any habits");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid View");
    }
}
