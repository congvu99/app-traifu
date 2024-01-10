package com.trainerfu.story;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.trainerfu.android.R;

public class SectionIconTextView extends SectionPartView {
    public SectionIconTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SectionIconTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SectionIconTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.section_icon_text_view, this);
    }

    public void setText(CharSequence charSequence) {
        TextView textView = (TextView) findViewById(R.id.icon_text_view);
        textView.setText(charSequence);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
