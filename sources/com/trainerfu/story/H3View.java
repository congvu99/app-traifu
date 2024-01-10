package com.trainerfu.story;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class H3View extends HView {
    public void initializeHeadlineView(TextView textView) {
    }

    public H3View(Context context) {
        this(context, (AttributeSet) null);
    }

    public H3View(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public H3View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
