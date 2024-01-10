package com.trainerfu.story;

import android.content.Context;
import androidx.core.content.ContextCompat;

public class SeparatorBinder extends SectionPartBinder {
    private int backgroundColor;
    private int height;

    public SeparatorBinder(Context context, int i, int i2) {
        super(context);
        this.height = i;
        this.backgroundColor = i2;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof SeparatorView) {
            SeparatorView separatorView = (SeparatorView) sectionPartView;
            separatorView.setHeight(this.height);
            separatorView.setBackgroundColor(ContextCompat.getColor(getContext(), this.backgroundColor));
            return;
        }
        throw new IllegalArgumentException("Invalid view");
    }
}
