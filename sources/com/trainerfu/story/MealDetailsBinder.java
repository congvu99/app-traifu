package com.trainerfu.story;

import android.content.Context;
import org.json.JSONObject;

public class MealDetailsBinder extends SectionPartBinder {
    private JSONObject mealDetail;

    public MealDetailsBinder(Context context, JSONObject jSONObject) {
        super(context);
        this.mealDetail = jSONObject;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof MealHeaderView) {
            ((MealHeaderView) sectionPartView).setMealDetails(this.mealDetail);
            return;
        }
        throw new IllegalArgumentException("Invalid View");
    }
}
