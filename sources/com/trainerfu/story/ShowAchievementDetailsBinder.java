package com.trainerfu.story;

import android.content.Context;
import android.view.View;
import com.trainerfu.android.R;
import org.json.JSONException;
import org.json.JSONObject;

public class ShowAchievementDetailsBinder extends SectionPartBinder implements View.OnClickListener {
    private EventHandler eventHandler;
    private Boolean showAchievementDetails;
    private JSONObject story;

    public interface EventHandler {
        void onShowAchievementDetails(int i);
    }

    public ShowAchievementDetailsBinder(Context context, JSONObject jSONObject, EventHandler eventHandler2, Boolean bool) {
        super(context);
        this.story = jSONObject;
        this.eventHandler = eventHandler2;
        this.showAchievementDetails = bool;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof ClickableLabel) {
            ClickableLabel clickableLabel = (ClickableLabel) sectionPartView;
            if (this.showAchievementDetails.booleanValue()) {
                clickableLabel.setTitle(getContext().getString(R.string.hideDetails));
            } else {
                clickableLabel.setTitle(getContext().getString(R.string.showWorkoutDetails));
            }
            clickableLabel.setColor(R.color.showDetails);
            clickableLabel.setOnClickListener(this);
            return;
        }
        throw new IllegalArgumentException("Invalid view");
    }

    public void onClick(View view) {
        EventHandler eventHandler2 = this.eventHandler;
        if (eventHandler2 != null) {
            try {
                eventHandler2.onShowAchievementDetails(this.story.getInt("story_id"));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
