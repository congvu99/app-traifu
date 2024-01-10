package com.trainerfu.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.trainerfu.android.R;
import org.json.JSONArray;
import org.json.JSONException;

public class AssessmentProgressView extends SectionPartView {
    public AssessmentProgressView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AssessmentProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AssessmentProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.assessment_progress_view, this);
    }

    public void setProgress(JSONArray jSONArray) {
        AssessmentProgressCellView assessmentProgressCellView = (AssessmentProgressCellView) findViewById(R.id.thirty_view);
        AssessmentProgressCellView assessmentProgressCellView2 = (AssessmentProgressCellView) findViewById(R.id.sixty_view);
        AssessmentProgressCellView assessmentProgressCellView3 = (AssessmentProgressCellView) findViewById(R.id.ninety_view);
        AssessmentProgressCellView assessmentProgressCellView4 = (AssessmentProgressCellView) findViewById(R.id.overall_view);
        try {
            if (jSONArray.isNull(0)) {
                assessmentProgressCellView.setProgress((Double) null, 30);
            } else {
                assessmentProgressCellView.setProgress(Double.valueOf(jSONArray.getDouble(0)), 30);
            }
            if (jSONArray.isNull(1)) {
                assessmentProgressCellView2.setProgress((Double) null, 60);
            } else {
                assessmentProgressCellView2.setProgress(Double.valueOf(jSONArray.getDouble(1)), 60);
            }
            if (jSONArray.isNull(2)) {
                assessmentProgressCellView3.setProgress((Double) null, 90);
            } else {
                assessmentProgressCellView3.setProgress(Double.valueOf(jSONArray.getDouble(2)), 90);
            }
            if (jSONArray.isNull(3)) {
                assessmentProgressCellView4.setProgress((Double) null, (Integer) null);
            } else {
                assessmentProgressCellView4.setProgress(Double.valueOf(jSONArray.getJSONArray(3).getDouble(0)));
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
