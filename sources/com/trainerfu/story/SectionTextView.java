package com.trainerfu.story;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.trainerfu.android.R;

public class SectionTextView extends SectionPartView {
    public SectionTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SectionTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SectionTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.section_text_view, this);
    }

    public void setText(String str) {
        TextView textView = (TextView) findViewById(R.id.text_view);
        textView.setTypeface((Typeface) null, 0);
        textView.setText(str);
    }

    public void setBoldText(String str) {
        TextView textView = (TextView) findViewById(R.id.text_view);
        textView.setLineSpacing(TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics()), 1.0f);
        textView.setTypeface((Typeface) null, 1);
        textView.setText(str);
    }
}
