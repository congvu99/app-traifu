package com.trainerfu.story;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public abstract class SectionPartView extends LinearLayout {
    public SectionPartView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SectionPartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SectionPartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
