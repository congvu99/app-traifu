package com.trainerfu.story;

import android.content.Context;
import android.view.View;
import com.trainerfu.android.R;
import org.json.JSONException;
import org.json.JSONObject;

public class ShowMealDetailsBinder extends SectionPartBinder implements View.OnClickListener {
    private EventListener listener;
    private Boolean showMealDetails;
    private JSONObject story;

    public interface EventListener {
        void onShowMealDetails(int i);
    }

    public ShowMealDetailsBinder(Context context, JSONObject jSONObject, EventListener eventListener, Boolean bool) {
        super(context);
        this.story = jSONObject;
        this.listener = eventListener;
        this.showMealDetails = bool;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof ClickableLabel) {
            ClickableLabel clickableLabel = (ClickableLabel) sectionPartView;
            if (this.showMealDetails.booleanValue()) {
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
        EventListener eventListener = this.listener;
        if (eventListener != null) {
            try {
                eventListener.onShowMealDetails(this.story.getInt("story_id"));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
