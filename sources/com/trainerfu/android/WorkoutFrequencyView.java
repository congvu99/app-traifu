package com.trainerfu.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.trainerfu.utils.DateUtils;
import java.util.Calendar;
import java.util.Date;

public class WorkoutFrequencyView extends LinearLayout {
    public WorkoutFrequencyView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WorkoutFrequencyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WorkoutFrequencyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(1);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.workout_frequency_view, this);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    public void setWeekNumber(int i) {
        Date dateOfLatestSunday = DateUtils.dateOfLatestSunday();
        TextView textView = (TextView) findViewById(R.id.date_tv);
        Calendar instance = Calendar.getInstance();
        if (i > 0) {
            textView.setText("");
            dateOfLatestSunday = DateUtils.addDays(instance, dateOfLatestSunday, i * 7 * -1);
        } else {
            textView.setText("▼");
        }
        textView.setText(DateUtils.getMonthDayFormattedDate(dateOfLatestSunday));
    }

    public void setFrequency(int i) {
        for (int i2 = 1; i2 <= 7; i2++) {
            View findViewById = findViewById(getResources().getIdentifier("w" + i2, "id", getContext().getPackageName()));
            if (i >= i2) {
                findViewById.setBackgroundColor(getResources().getColor(R.color.darkGreen));
            } else {
                findViewById.setBackgroundColor(getResources().getColor(R.color.lightBackground));
            }
        }
    }
}
