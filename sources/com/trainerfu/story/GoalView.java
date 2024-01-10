package com.trainerfu.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.github.lzyzsd.circleprogress.DonutProgress;
import com.trainerfu.android.R;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class GoalView extends SectionPartView {
    private static DecimalFormat df2 = new DecimalFormat(".##");

    public GoalView(Context context) {
        this(context, (AttributeSet) null);
    }

    public GoalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GoalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeViews(context);
    }

    public void initializeViews(Context context) {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.goal_view, this);
    }

    public void setGoal(JSONObject jSONObject) {
        try {
            ((DonutProgress) findViewById(R.id.donut_progress_view)).setProgress((float) jSONObject.getInt("pc"));
            ((TextView) findViewById(R.id.title_view)).setText(String.format("%s : %s", new Object[]{getContext().getString(R.string.Goal), df2.format(jSONObject.getDouble("ta"))}));
            ((TextView) findViewById(R.id.days_left_view)).setText(String.format(getContext().getString(R.string.nDaysLeft), new Object[]{Integer.valueOf(jSONObject.getInt("dl"))}));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
