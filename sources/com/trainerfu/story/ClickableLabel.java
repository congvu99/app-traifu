package com.trainerfu.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.trainerfu.android.R;
import com.trainerfu.utils.Util;

public class ClickableLabel extends SectionPartView implements View.OnClickListener {
    private View.OnClickListener clickListener;
    private TextView label;

    public ClickableLabel(Context context) {
        this(context, (AttributeSet) null);
    }

    public ClickableLabel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClickableLabel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeViews();
    }

    public void initializeViews() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.clickable_label, this);
        TextView textView = (TextView) findViewById(R.id.clickable_label);
        this.label = textView;
        textView.setOnClickListener(this);
    }

    public void setTitle(String str) {
        ((TextView) findViewById(R.id.clickable_label)).setText(str);
    }

    public void setColor(int i) {
        ((TextView) findViewById(R.id.clickable_label)).setTextColor(getResources().getColor(i));
    }

    public void setUnderline() {
        TextView textView = (TextView) findViewById(R.id.clickable_label);
        textView.setPaintFlags(textView.getPaintFlags() | 8);
    }

    public void setMargin(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.label.getLayoutParams();
        layoutParams.setMargins(Util.sizeInPx(getContext(), i), 0, 0, 0);
        this.label.setLayoutParams(layoutParams);
    }

    public void setTextSize(float f) {
        this.label.setTextSize(f);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.clickListener = onClickListener;
    }

    public void onClick(View view) {
        View.OnClickListener onClickListener = this.clickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }
}
