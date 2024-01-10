package com.trainerfu.story;

import android.content.Context;
import org.json.JSONObject;

public class RecentCheckinsBinder extends SectionPartBinder {
    private int index;
    private JSONObject recentCheckin;

    public RecentCheckinsBinder(Context context, JSONObject jSONObject, int i) {
        super(context);
        this.recentCheckin = jSONObject;
        this.index = i;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof RecentCheckinView) {
            ((RecentCheckinView) sectionPartView).setRecentCheckin(this.recentCheckin, this.index);
            return;
        }
        throw new IllegalArgumentException("Invalid view");
    }
}
