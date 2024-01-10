package com.trainerfu.story;

import android.content.Context;
import org.json.JSONObject;

public class MealHeaderBinder extends SectionPartBinder {
    public MealHeaderBinder(Context context) {
        super(context);
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof MealHeaderView) {
            ((MealHeaderView) sectionPartView).setMealDetails((JSONObject) null);
            return;
        }
        throw new IllegalArgumentException("Invalid View");
    }
}
