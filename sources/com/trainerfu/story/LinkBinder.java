package com.trainerfu.story;

import android.content.Context;
import org.json.JSONObject;

public class LinkBinder extends SectionPartBinder {
    private JSONObject meta;

    public LinkBinder(Context context, JSONObject jSONObject) {
        super(context);
        this.meta = jSONObject;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof LinkView) {
            ((LinkView) sectionPartView).setMeta(this.meta);
            return;
        }
        throw new IllegalArgumentException("Invalid view");
    }
}
