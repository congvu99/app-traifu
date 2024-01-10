package com.trainerfu.story;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.trainerfu.android.R;
import org.json.JSONException;
import org.json.JSONObject;

public class ExerciseCountBinder extends SectionPartBinder {
    private JSONObject meta;

    public ExerciseCountBinder(Context context, JSONObject jSONObject) {
        super(context);
        this.meta = jSONObject;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof H4ViewLight) {
            try {
                H4ViewLight h4ViewLight = (H4ViewLight) sectionPartView;
                int length = this.meta.getJSONArray(NotificationCompat.CATEGORY_WORKOUT).length();
                if (length == 1) {
                    h4ViewLight.setHeadline(getContext().getString(R.string.completed_1_exercise));
                    return;
                }
                h4ViewLight.setHeadline(String.format(getContext().getString(R.string.completed_n_exercise), new Object[]{Integer.valueOf(length)}));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalArgumentException("Invalid view");
        }
    }
}
