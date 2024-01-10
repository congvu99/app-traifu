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

public class AssessmentDetailView extends SectionPartView {
    private static DecimalFormat df2 = new DecimalFormat(".##");

    public AssessmentDetailView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AssessmentDetailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AssessmentDetailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.assessment_detail_view, this);
    }

    public void setAssessmentDetail(JSONObject jSONObject) {
        try {
            TextView textView = (TextView) findViewById(R.id.goal_value);
            TextView textView2 = (TextView) findViewById(R.id.days_left);
            TextView textView3 = (TextView) findViewById(R.id.percent_complete);
            DonutProgress donutProgress = (DonutProgress) findViewById(R.id.donut_progress_view);
            ((TextView) findViewById(R.id.assessment_name)).setText(jSONObject.getString("na"));
            ((TextView) findViewById(R.id.assessment_measure)).setText(df2.format(jSONObject.getDouble("me")));
            if (jSONObject.has("go")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("go");
                int i = jSONObject2.getInt("pc");
                int i2 = jSONObject2.getInt("dl");
                textView.setText(df2.format(jSONObject2.getDouble("ta")));
                textView2.setText(String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i2)}));
                donutProgress.setProgress((float) i);
                if (i <= 0 || i >= 100) {
                    textView3.setText(R.string.dash);
                    return;
                }
                textView3.setText(i + "%");
                return;
            }
            textView.setText(R.string.dash);
            textView2.setText(R.string.dash);
            textView3.setText(R.string.dash);
            donutProgress.setProgress(0.0f);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
