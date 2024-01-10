package com.trainerfu.story;

import android.content.Context;
import org.json.JSONObject;

public class BeforeAfterBinder extends SectionPartBinder {
    private JSONObject afterPhoto;
    private JSONObject beforePhoto;

    public BeforeAfterBinder(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        super(context);
        this.beforePhoto = jSONObject;
        this.afterPhoto = jSONObject2;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof BeforeAfterView) {
            ((BeforeAfterView) sectionPartView).setPhotos(this.beforePhoto, this.afterPhoto);
            return;
        }
        throw new IllegalArgumentException("Invalid view");
    }
}
