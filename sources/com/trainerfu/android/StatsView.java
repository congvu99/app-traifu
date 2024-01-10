package com.trainerfu.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StatsView extends RelativeLayout {
    public StatsView(Context context) {
        this(context, (AttributeSet) null);
    }

    public StatsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StatsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.stats_view, this);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    public void setStats(int[] iArr, int i, int i2) {
        WorkoutFrequencyView workoutFrequencyView = (WorkoutFrequencyView) findViewById(R.id.frequencyViewWeek1);
        workoutFrequencyView.setFrequency(iArr[0]);
        workoutFrequencyView.setWeekNumber(0);
        WorkoutFrequencyView workoutFrequencyView2 = (WorkoutFrequencyView) findViewById(R.id.frequencyViewWeek2);
        workoutFrequencyView2.setFrequency(iArr[1]);
        workoutFrequencyView2.setWeekNumber(1);
        WorkoutFrequencyView workoutFrequencyView3 = (WorkoutFrequencyView) findViewById(R.id.frequencyViewWeek3);
        workoutFrequencyView3.setFrequency(iArr[2]);
        workoutFrequencyView3.setWeekNumber(2);
        WorkoutFrequencyView workoutFrequencyView4 = (WorkoutFrequencyView) findViewById(R.id.frequencyViewWeek4);
        workoutFrequencyView4.setFrequency(iArr[3]);
        workoutFrequencyView4.setWeekNumber(3);
        WorkoutFrequencyView workoutFrequencyView5 = (WorkoutFrequencyView) findViewById(R.id.frequencyViewWeek5);
        workoutFrequencyView5.setFrequency(iArr[4]);
        workoutFrequencyView5.setWeekNumber(4);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.recentValueWrapper);
        ((TextView) findViewById(R.id.totalValueTV)).setText(String.valueOf(i));
        ((TextView) findViewById(R.id.recentValueTV)).setText(String.valueOf(i2));
    }
}
