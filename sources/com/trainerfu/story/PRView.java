package com.trainerfu.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.trainerfu.android.R;

public class PRView extends SectionPartView {
    public PRView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PRView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PRView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeViews();
    }

    public void initializeViews() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.pr_view, this);
    }

    public void setRM(int i) {
        ((TextView) findViewById(R.id.rm_info)).setText("1RM");
        ((LinearLayout) findViewById(R.id.rm_view)).setVisibility(0);
    }

    public void setVol(int i) {
        ((TextView) findViewById(R.id.volume_info)).setText("Volume");
        ((LinearLayout) findViewById(R.id.vol_view)).setVisibility(0);
    }
}
