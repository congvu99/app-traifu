package com.trainerfu.story;

import android.content.Context;
import org.json.JSONArray;

public class AssessmentProgressBinder extends SectionPartBinder {
    private JSONArray progress;

    public AssessmentProgressBinder(Context context, JSONArray jSONArray) {
        super(context);
        this.progress = jSONArray;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof AssessmentProgressView) {
            ((AssessmentProgressView) sectionPartView).setProgress(this.progress);
            return;
        }
        throw new IllegalArgumentException("Invalid view");
    }
}
