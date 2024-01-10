package com.trainerfu.story;

import android.content.Context;
import android.os.Bundle;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class AssessmentStoryViewModel extends StoryBaseViewModel {
    private static DecimalFormat df2 = new DecimalFormat(".##");

    public AssessmentStoryViewModel(Context context, JSONObject jSONObject, Bundle bundle) {
        super(context, jSONObject, bundle);
    }

    public List<SectionPartDefinition> getParts() {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new SectionPartDefinition(StoryTitleView.class, new StoryTitleViewBinder(getContext(), this, isNewsModerated(), getStoryTitleViewEventListener())));
            arrayList.add(new SectionPartDefinition(AssessmentDetailView.class, new AssessmentDetailBinder(getContext(), getMeta())));
            if (getMeta().has("pr")) {
                arrayList.add(new SectionPartDefinition(AssessmentProgressView.class, new AssessmentProgressBinder(getContext(), getMeta().getJSONArray("pr"))));
            }
            if (getMeta().has("go")) {
                JSONObject jSONObject = getMeta().getJSONObject("go");
                if (jSONObject.getInt("pc") >= 100) {
                    addWhiteSpace(arrayList, 10);
                    jSONObject.put("type", AchievementType.GOAL_UNLOCKED.getMask());
                    arrayList.add(new SectionPartDefinition(AchievementView.class, new AchievementBinder(getContext(), jSONObject)));
                }
            }
            addFooter(arrayList);
            addSectionSeparator(arrayList);
            return arrayList;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
