package com.trainerfu.story;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

public class PRViewBinder extends SectionPartBinder {
    private JSONObject exercise;

    public PRViewBinder(Context context, JSONObject jSONObject) {
        super(context);
        this.exercise = jSONObject;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof PRView) {
            PRView pRView = (PRView) sectionPartView;
            try {
                if (this.exercise.getBoolean("is_pr_rm")) {
                    pRView.setRM((int) this.exercise.getDouble("rm"));
                }
                if (this.exercise.getBoolean("is_pr_vol")) {
                    pRView.setVol((int) this.exercise.getDouble("vol"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Invalid view");
        }
    }
}
