package com.trainerfu.story;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WorkoutSummaryBinder extends SectionPartBinder {
    private JSONObject meta;

    public WorkoutSummaryBinder(Context context, JSONObject jSONObject) {
        super(context);
        this.meta = jSONObject;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof SectionTextView) {
            try {
                SectionTextView sectionTextView = (SectionTextView) sectionPartView;
                JSONArray jSONArray = this.meta.getJSONArray(NotificationCompat.CATEGORY_WORKOUT);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getJSONObject(i).getString("en"));
                    if (i < jSONArray.length() - 1) {
                        arrayList.add("  •  ");
                    }
                }
                sectionTextView.setText(TextUtils.join("", arrayList));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalArgumentException("Invalid view");
        }
    }
}
