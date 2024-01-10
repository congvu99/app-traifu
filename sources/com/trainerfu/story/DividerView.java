package com.trainerfu.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.trainerfu.android.R;
import com.trainerfu.utils.Util;

public class DividerView extends SectionPartView {
    private Context context;

    public DividerView(Context context2) {
        this(context2, (AttributeSet) null);
    }

    public DividerView(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public DividerView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
        initializeViews(context2);
    }

    private void initializeViews(Context context2) {
        ((LayoutInflater) context2.getSystemService("layout_inflater")).inflate(R.layout.divider_view, this);
    }

    public void setFullWidth() {
        Util.setMargins(findViewById(R.id.divider_view), 0, 0, 0, 0);
    }
}
