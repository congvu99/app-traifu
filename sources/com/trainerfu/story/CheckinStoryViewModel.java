package com.trainerfu.story;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CheckinStoryViewModel extends StoryBaseViewModel {
    private static DecimalFormat df2 = new DecimalFormat(".##");

    public CheckinStoryViewModel(Context context, JSONObject jSONObject, Bundle bundle) {
        super(context, jSONObject, bundle);
    }

    public List<SectionPartDefinition> getParts() {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new SectionPartDefinition(StoryTitleView.class, new StoryTitleViewBinder(getContext(), this, isNewsModerated(), getStoryTitleViewEventListener())));
            addWhiteSpace(arrayList, 10);
            String obj = Html.fromHtml(getMeta().getString("m")).toString();
            if (obj.length() > 140) {
                obj = obj.substring(0, 140) + "...\n";
            }
            addWhiteSpace(arrayList, 25);
            arrayList.add(new SectionPartDefinition(SectionTextView.class, new SectionTextBinder(getContext(), obj)));
            arrayList.add(new SectionPartDefinition(CheckinView.class, new CheckinBinder(getContext(), !getMeta().isNull("dc") ? getMeta().getBoolean("dc") : false)));
            JSONArray jSONArray = getMeta().getJSONArray("rc");
            if (jSONArray.length() > 0) {
                addWhiteSpace(arrayList, 35);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new SectionPartDefinition(RecentCheckinView.class, new RecentCheckinsBinder(getContext(), jSONArray.getJSONObject(i), i)));
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
