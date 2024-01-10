package com.trainerfu.story;

import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class LinkStoryViewModel extends StoryBaseViewModel {
    public LinkStoryViewModel(Context context, JSONObject jSONObject, Bundle bundle) {
        super(context, jSONObject, bundle);
    }

    public List<SectionPartDefinition> getParts() {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new SectionPartDefinition(StoryTitleView.class, new StoryTitleViewBinder(getContext(), this, isNewsModerated(), getStoryTitleViewEventListener())));
            if (getMeta().has("no") && !getMeta().isNull("no")) {
                getMeta().getString("no");
                addWhiteSpace(arrayList, 25);
                arrayList.add(new SectionPartDefinition(SectionTextView.class, new SectionTextBinder(getContext(), getMeta().getString("no"))));
            }
            arrayList.add(new SectionPartDefinition(LinkView.class, new LinkBinder(getContext(), getMeta())));
            addFooter(arrayList);
            addSectionSeparator(arrayList);
            return arrayList;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
