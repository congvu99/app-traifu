package com.trainerfu.story;

import android.content.Context;
import android.os.Bundle;
import com.trainerfu.utils.DateUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProgressPhotoStoryViewModel extends StoryBaseViewModel {
    private int afterPhotoIndex = -1;
    private int firstBeforePhotoIndex = -1;
    private boolean showProgressPhotoTooltip;
    private JSONArray userProgressPhotos;

    public ProgressPhotoStoryViewModel(Context context, JSONObject jSONObject, JSONObject jSONObject2, Bundle bundle) {
        super(context, jSONObject, bundle);
        int i = 0;
        this.showProgressPhotoTooltip = false;
        try {
            int i2 = getMeta().getJSONObject("photo").getInt("id");
            Date date = new Date();
            this.userProgressPhotos = jSONObject2.getJSONArray(String.valueOf(getUserId()));
            while (i < this.userProgressPhotos.length()) {
                JSONObject jSONObject3 = this.userProgressPhotos.getJSONObject(i);
                int i3 = jSONObject3.getInt("id");
                Date dateFromISOFormat = DateUtils.getDateFromISOFormat(jSONObject3.getString("d"));
                if (i2 == i3) {
                    this.afterPhotoIndex = i;
                    date = dateFromISOFormat;
                }
                if (this.afterPhotoIndex <= -1 || DateUtils.dateDifferenceInDays(dateFromISOFormat, date) < 7) {
                    i++;
                } else {
                    this.firstBeforePhotoIndex = i;
                    return;
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void setShowProgressPhotoTooltip(boolean z) {
        this.showProgressPhotoTooltip = z;
    }

    public boolean showProgressPhotoTooltip() {
        return this.showProgressPhotoTooltip;
    }

    public void goNext() {
        setSelectedIndex(getSelectedIndex() + 1);
    }

    public void goPrev() {
        setSelectedIndex(getSelectedIndex() - 1);
    }

    public boolean hasNext() {
        if (this.firstBeforePhotoIndex != -1 && this.userProgressPhotos.length() - (this.firstBeforePhotoIndex + getSelectedIndex()) > 0) {
            return true;
        }
        return false;
    }

    public boolean hasPrev() {
        return getSelectedIndex() > 0;
    }

    private void setSelectedIndex(int i) {
        try {
            getState().put("selected_index", i);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private int getSelectedIndex() {
        try {
            if (getState().has("selected_index")) {
                return getState().getInt("selected_index");
            }
            return 0;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SectionPartDefinition> getParts() {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new SectionPartDefinition(StoryTitleView.class, new StoryTitleViewBinder(getContext(), this, isNewsModerated(), getStoryTitleViewEventListener())));
            if (!getMeta().isNull("no")) {
                addWhiteSpace(arrayList, 25);
                arrayList.add(new SectionPartDefinition(SectionTextView.class, new SectionTextBinder(getContext(), getMeta().getString("no"))));
            }
            if (getSelectedIndex() == 0) {
                getMeta().getJSONObject("photo");
                arrayList.add(new SectionPartDefinition(PhotoView.class, new PhotoViewBinder(getContext(), getMeta().getJSONObject("photo"))));
            } else {
                arrayList.add(new SectionPartDefinition(BeforeAfterView.class, new BeforeAfterBinder(getContext(), this.userProgressPhotos.getJSONObject((this.firstBeforePhotoIndex + getSelectedIndex()) - 1), this.userProgressPhotos.getJSONObject(this.afterPhotoIndex))));
            }
            addFooter(arrayList);
            addSectionSeparator(arrayList);
            return arrayList;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
