package com.trainerfu.story;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

public class CommentBinder extends SectionPartBinder {
    private JSONObject comment;
    private Boolean expandedComments;

    public CommentBinder(Context context, JSONObject jSONObject, Boolean bool) {
        super(context);
        this.comment = jSONObject;
        this.expandedComments = bool;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof CommentView) {
            CommentView commentView = (CommentView) sectionPartView;
            try {
                commentView.setComment(this.comment.getString("first_name"), this.comment.getString("comment"));
                if (this.expandedComments.booleanValue()) {
                    commentView.changeBackground();
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalArgumentException("Invalid view");
        }
    }
}
