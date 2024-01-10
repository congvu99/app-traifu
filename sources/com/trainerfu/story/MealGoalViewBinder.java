package com.trainerfu.story;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

public class MealGoalViewBinder extends SectionPartBinder {
    private JSONObject meta;
    private Boolean showMealDetails;
    private int total;

    public MealGoalViewBinder(Context context, JSONObject jSONObject, Boolean bool) {
        super(context);
        this.meta = jSONObject;
        this.showMealDetails = bool;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof MealGoalView) {
            MealGoalView mealGoalView = (MealGoalView) sectionPartView;
            try {
                mealGoalView.setTotal(this.meta.getInt("gc"), this.showMealDetails);
                mealGoalView.setTotalCarbs(this.meta.getInt("gca"), this.showMealDetails);
                mealGoalView.setTotalProteins(this.meta.getInt("gpr"), this.showMealDetails);
                mealGoalView.setTotalFats(this.meta.getInt("gfa"), this.showMealDetails);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Invalid View");
        }
    }
}
