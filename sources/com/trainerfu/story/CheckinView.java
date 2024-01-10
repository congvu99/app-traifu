package com.trainerfu.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.trainerfu.android.R;

public class CheckinView extends SectionPartView {
    public CheckinView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CheckinView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckinView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeViews();
    }

    public void initializeViews() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.checkin_view, this);
    }

    public void setCheckin(boolean z) {
        TextView textView = (TextView) findViewById(R.id.checkin_label);
        ImageView imageView = (ImageView) findViewById(R.id.checkin_yes_icon_view);
        ImageView imageView2 = (ImageView) findViewById(R.id.checkin_no_icon_view);
        if (z) {
            textView.setText("YES");
            imageView.setVisibility(0);
            imageView2.setVisibility(8);
            return;
        }
        textView.setText("NO");
        imageView.setVisibility(8);
        imageView2.setVisibility(0);
    }
}
