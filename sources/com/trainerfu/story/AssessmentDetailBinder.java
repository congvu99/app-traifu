package com.trainerfu.story;

import android.content.Context;
import org.json.JSONObject;

public class AssessmentDetailBinder extends SectionPartBinder {
    private JSONObject assessment;

    public AssessmentDetailBinder(Context context, JSONObject jSONObject) {
        super(context);
        this.assessment = jSONObject;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof AssessmentDetailView) {
            ((AssessmentDetailView) sectionPartView).setAssessmentDetail(this.assessment);
            return;
        }
        throw new IllegalArgumentException("Invalid View");
    }
}
