package com.trainerfu.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.trainerfu.android.R;

public class EmptyView extends SectionPartView {
    public EmptyView(Context context) {
        this(context, (AttributeSet) null);
    }

    public EmptyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmptyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeViews(context);
    }

    public void initializeViews(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.empty_view, this);
    }

    public void setEmptyViewText(String str) {
        ((TextView) findViewById(R.id.empty_view_text)).setText(str);
    }
}
