package com.trainerfu.story;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.trainerfu.android.R;

public class CommentView extends SectionPartView {
    public CommentView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CommentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeView(context);
    }

    public void initializeView(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.comment_view, this);
    }

    public void setComment(String str, String str2) {
        SpannableString spannableString = new SpannableString(str + " " + str2);
        spannableString.setSpan(new StyleSpan(1), 0, str.length(), 33);
        ((TextView) findViewById(R.id.comment_value_view)).setText(spannableString);
    }

    public void changeBackground() {
        ((LinearLayout) findViewById(R.id.comment_view)).setBackgroundColor(getResources().getColor(R.color.veryLightBackground));
    }
}
