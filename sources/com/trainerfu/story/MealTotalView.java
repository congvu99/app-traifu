package com.trainerfu.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.trainerfu.android.R;

public class MealTotalView extends SectionPartView {
    public MealTotalView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MealTotalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MealTotalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeViews();
    }

    public void initializeViews() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.meal_total_view, this);
    }

    public void setTotal(int i, Boolean bool) {
        TextView textView = (TextView) findViewById(R.id.total_value);
        ((TextView) findViewById(R.id.total_text)).setText(bool.booleanValue() ? "Total:" : "Total Calories:");
        textView.setText(bool.booleanValue() ? String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i)}) : String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i)}));
        ((LinearLayout) findViewById(R.id.total_container_view)).setWeightSum(bool.booleanValue() ? 5.0f : 2.0f);
    }

    public void setTotalCarbs(int i, Boolean bool) {
        TextView textView = (TextView) findViewById(R.id.total_carbs);
        int i2 = 0;
        textView.setText(String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i)}));
        if (!bool.booleanValue()) {
            i2 = 8;
        }
        textView.setVisibility(i2);
    }

    public void setTotalProteins(int i, Boolean bool) {
        TextView textView = (TextView) findViewById(R.id.total_protein);
        int i2 = 0;
        textView.setText(String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i)}));
        if (!bool.booleanValue()) {
            i2 = 8;
        }
        textView.setVisibility(i2);
    }

    public void setTotalFats(int i, Boolean bool) {
        TextView textView = (TextView) findViewById(R.id.total_fats);
        int i2 = 0;
        textView.setText(String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i)}));
        if (!bool.booleanValue()) {
            i2 = 8;
        }
        textView.setVisibility(i2);
    }
}
