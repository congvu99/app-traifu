package com.trainerfu.story;

import android.content.Context;

public class MealSummaryBinder extends SectionPartBinder {
    private String mealSummary;

    public MealSummaryBinder(Context context, String str) {
        super(context);
        this.mealSummary = str;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof SectionTextView) {
            ((SectionTextView) sectionPartView).setText(this.mealSummary);
            return;
        }
        throw new IllegalArgumentException("Invalid View");
    }
}
