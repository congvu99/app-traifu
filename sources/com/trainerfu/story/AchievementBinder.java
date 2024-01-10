package com.trainerfu.story;

import android.content.Context;
import org.json.JSONObject;

public class AchievementBinder extends SectionPartBinder {
    private JSONObject achievement;

    public AchievementBinder(Context context, JSONObject jSONObject) {
        super(context);
        this.achievement = jSONObject;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof AchievementView) {
            ((AchievementView) sectionPartView).setAchievement(this.achievement);
            return;
        }
        throw new IllegalArgumentException("Invalid view");
    }
}
