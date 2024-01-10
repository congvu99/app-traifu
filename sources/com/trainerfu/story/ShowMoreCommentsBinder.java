package com.trainerfu.story;

import android.content.Context;
import android.view.View;
import com.trainerfu.android.R;
import org.json.JSONException;
import org.json.JSONObject;

public class ShowMoreCommentsBinder extends SectionPartBinder implements View.OnClickListener {
    private EventListener eventListener;
    private int noOfComments;
    private JSONObject story;

    public interface EventListener {
        void onShowMoreComments(int i, Boolean bool);
    }

    public ShowMoreCommentsBinder(Context context, JSONObject jSONObject, EventListener eventListener2, int i) {
        super(context);
        this.story = jSONObject;
        this.eventListener = eventListener2;
        this.noOfComments = i;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof ClickableLabel) {
            ClickableLabel clickableLabel = (ClickableLabel) sectionPartView;
            clickableLabel.setTitle(String.format("%d more %s", new Object[]{Integer.valueOf(this.noOfComments), this.noOfComments > 1 ? "comments" : "comment"}));
            clickableLabel.setColor(R.color.showDetails);
            clickableLabel.setOnClickListener(this);
            return;
        }
        throw new IllegalArgumentException("Invalid View");
    }

    public void onClick(View view) {
        EventListener eventListener2 = this.eventListener;
        if (eventListener2 != null) {
            try {
                eventListener2.onShowMoreComments(this.story.getInt("story_id"), false);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
