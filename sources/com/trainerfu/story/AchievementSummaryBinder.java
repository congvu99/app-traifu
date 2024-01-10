package com.trainerfu.story;

import android.content.Context;
import java.util.List;
import org.json.JSONObject;

public class AchievementSummaryBinder extends SectionPartBinder {
    private List<JSONObject> achievements;

    public AchievementSummaryBinder(Context context, List<JSONObject> list) {
        super(context);
        this.achievements = list;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof AchievementSummaryView) {
            ((AchievementSummaryView) sectionPartView).setAchievements(this.achievements);
            return;
        }
        throw new IllegalArgumentException("Invalid view");
    }
}
