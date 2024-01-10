package com.trainerfu.story;

import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PostStoryViewModel extends StoryBaseViewModel {
    public PostStoryViewModel(Context context, JSONObject jSONObject, Bundle bundle) {
        super(context, jSONObject, bundle);
    }

    public List<SectionPartDefinition> getParts() {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new SectionPartDefinition(StoryTitleView.class, new StoryTitleViewBinder(getContext(), this, isNewsModerated(), getStoryTitleViewEventListener())));
            if (getMeta().has("no") && !getMeta().isNull("no")) {
                addWhiteSpace(arrayList, 25);
                arrayList.add(new SectionPartDefinition(SectionTextView.class, new SectionTextBinder(getContext(), getMeta().getString("no"))));
            }
            if (!getMeta().isNull("photo")) {
                arrayList.add(new SectionPartDefinition(PhotoView.class, new PhotoViewBinder(getContext(), getMeta().getJSONObject("photo"))));
            }
            if (getMeta().has("files")) {
                JSONArray jSONArray = getMeta().getJSONArray("files");
                addWhiteSpace(arrayList, 10);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new SectionPartDefinition(DownloadFileView.class, new DownloadFileBinder(getContext(), jSONArray.getJSONObject(i))));
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
