package com.trainerfu.story;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

public class MealTotalViewBinder extends SectionPartBinder {
    private JSONObject meta;
    private Boolean showMealDetails;
    private int total;

    public MealTotalViewBinder(Context context, JSONObject jSONObject, Boolean bool) {
        super(context);
        this.meta = jSONObject;
        this.showMealDetails = bool;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof MealTotalView) {
            MealTotalView mealTotalView = (MealTotalView) sectionPartView;
            try {
                mealTotalView.setTotal(this.meta.getInt("t"), this.showMealDetails);
                mealTotalView.setTotalCarbs(this.meta.getInt("tca"), this.showMealDetails);
                mealTotalView.setTotalProteins(this.meta.getInt("tpr"), this.showMealDetails);
                mealTotalView.setTotalFats(this.meta.getInt("tfa"), this.showMealDetails);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Invalid View");
        }
    }
}
