package com.trainerfu.story;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.trainerfu.android.R;

public class H4ViewLight extends HView {
    public H4ViewLight(Context context) {
        this(context, (AttributeSet) null);
    }

    public H4ViewLight(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public H4ViewLight(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void initializeHeadlineView(TextView textView) {
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.lightGrayColor));
        textView.setTypeface((Typeface) null, 1);
    }
}
