package com.trainerfu.story;

import android.content.Context;
import android.util.AttributeSet;

public abstract class StoryBasePartView extends SectionPartView {
    public StoryBasePartView(Context context) {
        this(context, (AttributeSet) null);
    }

    public StoryBasePartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StoryBasePartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
