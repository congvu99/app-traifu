package com.trainerfu.android;

import android.view.View;
import org.json.JSONObject;

public interface StoryViewEventListener {
    void addCommentClicked(JSONObject jSONObject);

    void likeitClicked(JSONObject jSONObject, boolean z);

    void showMoreOptionsClicked(View view, JSONObject jSONObject);
}
