package com.trainerfu.story;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.trainerfu.android.MealType;
import com.trainerfu.android.R;
import com.trainerfu.story.ShowMealDetailsBinder;
import com.trainerfu.utils.Tuple;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MealStoryViewModel extends StoryBaseViewModel {
    private static List<Tuple<Integer, String>> mealTypes;
    private ShowMealDetailsBinder.EventListener showMealDetailsListener;

    public MealStoryViewModel(Context context, JSONObject jSONObject, Bundle bundle) {
        super(context, jSONObject, bundle);
        if (mealTypes == null) {
            ArrayList arrayList = new ArrayList();
            mealTypes = arrayList;
            arrayList.add(new Tuple(Integer.valueOf(MealType.BREAKFAST.getMask()), getContext().getString(R.string.Breakfast)));
            mealTypes.add(new Tuple(Integer.valueOf(MealType.LUNCH.getMask()), getContext().getString(R.string.Lunch)));
            mealTypes.add(new Tuple(Integer.valueOf(MealType.DINNER.getMask()), getContext().getString(R.string.Dinner)));
            mealTypes.add(new Tuple(Integer.valueOf(MealType.SNACK.getMask()), getContext().getString(R.string.Snacks)));
        }
    }

    public void setShowMealDetails(boolean z) {
        try {
            getState().put("show_meal_details", z);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void setShowMealDetailsListener(ShowMealDetailsBinder.EventListener eventListener) {
        this.showMealDetailsListener = eventListener;
    }

    public boolean showMealDetails() {
        try {
            if (getState().has("show_meal_details")) {
                return getState().getBoolean("show_meal_details");
            }
            return false;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SectionPartDefinition> getParts() {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new SectionPartDefinition(StoryTitleView.class, new StoryTitleViewBinder(getContext(), this, isNewsModerated(), getStoryTitleViewEventListener())));
            addWhiteSpace(arrayList, 20);
            if (showMealDetails()) {
                arrayList.add(new SectionPartDefinition(MealHeaderView.class, new MealHeaderBinder(getContext())));
                arrayList.add(new SectionPartDefinition(DividerView.class, new SectionPartBinder(getContext())));
            }
            getMeta().getInt("t");
            for (Tuple next : mealTypes) {
                JSONArray jSONArray = getMeta().getJSONArray(String.valueOf(next.x));
                if (jSONArray.length() > 0) {
                    if (showMealDetails()) {
                        addWhiteSpace(arrayList, 4);
                        arrayList.add(new SectionPartDefinition(H3View.class, new HBinder(getContext(), (String) next.y)));
                        addWhiteSpace(arrayList, 7);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            arrayList.add(new SectionPartDefinition(SectionTextView.class, new MealSummaryBinder(getContext(), jSONObject.getString("na"))));
                            addWhiteSpace(arrayList, 5);
                            arrayList.add(new SectionPartDefinition(MealHeaderView.class, new MealDetailsBinder(getContext(), jSONObject)));
                            addWhiteSpace(arrayList, 7);
                            arrayList.add(new SectionPartDefinition(DividerView.class, new SectionPartBinder(getContext())));
                            addWhiteSpace(arrayList, 7);
                        }
                    } else {
                        addWhiteSpace(arrayList, 4);
                        ArrayList arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            arrayList2.add(jSONArray.getJSONObject(i2).getString("na"));
                        }
                        arrayList.add(new SectionPartDefinition(H3View.class, new HBinder(getContext(), (String) next.y)));
                        addWhiteSpace(arrayList, 7);
                        arrayList.add(new SectionPartDefinition(SectionTextView.class, new MealSummaryBinder(getContext(), String.format("%s", new Object[]{TextUtils.join(", ", arrayList2)}))));
                        addWhiteSpace(arrayList, 10);
                        arrayList.add(new SectionPartDefinition(DividerView.class, new SectionPartBinder(getContext())));
                        addWhiteSpace(arrayList, 7);
                    }
                }
            }
            if (showMealDetails() && getMeta().has("gc") && getMeta().getInt("gc") != 0) {
                arrayList.add(new SectionPartDefinition(MealGoalView.class, new MealGoalViewBinder(getContext(), getMeta(), Boolean.valueOf(showMealDetails()))));
                addWhiteSpace(arrayList, 10);
            }
            arrayList.add(new SectionPartDefinition(MealTotalView.class, new MealTotalViewBinder(getContext(), getMeta(), Boolean.valueOf(showMealDetails()))));
            addWhiteSpace(arrayList, 7);
            arrayList.add(new SectionPartDefinition(DividerView.class, new SectionPartBinder(getContext())));
            addWhiteSpace(arrayList, 4);
            arrayList.add(new SectionPartDefinition(ClickableLabel.class, new ShowMealDetailsBinder(getContext(), getState(), this.showMealDetailsListener, Boolean.valueOf(showMealDetails()))));
            addFooter(arrayList);
            addSectionSeparator(arrayList);
            return arrayList;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
