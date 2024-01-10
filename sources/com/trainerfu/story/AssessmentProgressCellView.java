package com.trainerfu.story;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.github.mikephil.charting.utils.Utils;
import com.trainerfu.android.R;

public class AssessmentProgressCellView extends LinearLayout {
    public AssessmentProgressCellView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AssessmentProgressCellView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AssessmentProgressCellView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeViews(context);
    }

    public void initializeViews(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.assessment_progress_cell_view, this);
    }

    public void setProgress(Double d, Integer num) {
        TextView textView = (TextView) findViewById(R.id.progress_view);
        if (d == null) {
            textView.setText("-");
        } else if (d.doubleValue() < Utils.DOUBLE_EPSILON) {
            textView.setText(String.valueOf(d));
        } else {
            textView.setText(String.format("+%.1f", new Object[]{d}));
        }
        TextView textView2 = (TextView) findViewById(R.id.days_view);
        if (num == null) {
            textView2.setText("-");
            return;
        }
        textView2.setText(String.format("%d days", new Object[]{num}));
    }

    public void setProgress(Double d) {
        TextView textView = (TextView) findViewById(R.id.progress_view);
        textView.setTypeface((Typeface) null, 1);
        if (d == null) {
            textView.setText("-");
        } else if (d.doubleValue() < Utils.DOUBLE_EPSILON) {
            textView.setText(String.valueOf(d));
        } else {
            textView.setText(String.format("+%.1f", new Object[]{d}));
        }
        TextView textView2 = (TextView) findViewById(R.id.days_view);
        textView2.setTypeface((Typeface) null, 1);
        textView2.setText(String.format("Overall", new Object[0]));
    }
}
