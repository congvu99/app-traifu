package com.trainerfu.story;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.trainerfu.android.R;

public abstract class HView extends SectionPartView {
    public abstract void initializeHeadlineView(TextView textView);

    public HView(Context context) {
        this(context, (AttributeSet) null);
    }

    public HView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeViews();
    }

    public void initializeViews() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.headline_view, this);
        initializeHeadlineView((TextView) findViewById(R.id.h_view));
    }

    public void setHeadline(String str) {
        TextView textView = (TextView) findViewById(R.id.h_view);
        textView.setTypeface((Typeface) null, 1);
        textView.setText(str);
    }
}
