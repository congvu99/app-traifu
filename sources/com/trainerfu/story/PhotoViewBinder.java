package com.trainerfu.story;

import android.content.Context;
import org.json.JSONObject;

public class PhotoViewBinder extends SectionPartBinder {
    private JSONObject photo;

    public PhotoViewBinder(Context context, JSONObject jSONObject) {
        super(context);
        this.photo = jSONObject;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof PhotoView) {
            ((PhotoView) sectionPartView).setPhoto(this.photo);
            return;
        }
        throw new IllegalArgumentException("Invalid view");
    }
}
