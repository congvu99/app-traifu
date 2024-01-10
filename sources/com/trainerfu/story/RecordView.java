package com.trainerfu.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.trainerfu.android.R;

public class RecordView extends SectionPartView {
    public RecordView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RecordView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeViews();
    }

    public void initializeViews() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.record_view, this);
    }

    public void setRecord(String str) {
        ((TextView) findViewById(R.id.record_view)).setText(str);
    }
}
