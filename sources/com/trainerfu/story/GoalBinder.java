package com.trainerfu.story;

import android.content.Context;
import org.json.JSONObject;

public class GoalBinder extends SectionPartBinder {
    private JSONObject goal;

    public GoalBinder(Context context, JSONObject jSONObject) {
        super(context);
        this.goal = jSONObject;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof GoalView) {
            ((GoalView) sectionPartView).setGoal(this.goal);
            return;
        }
        throw new IllegalArgumentException("Invalid view");
    }
}
