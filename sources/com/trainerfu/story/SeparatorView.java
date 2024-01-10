package com.trainerfu.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.trainerfu.android.R;
import com.trainerfu.utils.Util;

public class SeparatorView extends SectionPartView {
    private int height;

    public SeparatorView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SeparatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SeparatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.height = 0;
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.separator_view, this);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateLayout();
    }

    public void setHeight(int i) {
        this.height = i;
        updateLayout();
    }

    private void updateLayout() {
        int sizeInPx = Util.sizeInPx(getContext(), this.height);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = sizeInPx;
            setLayoutParams(layoutParams);
        }
    }
}
