package com.trainerfu.android;

import org.json.JSONObject;

public interface DrillViewEventsListener {
    void addToGroupDrillClicked(JSONObject jSONObject);

    void deleteDrillClicked(JSONObject jSONObject);

    void deleteGroupDrillClicked(JSONObject jSONObject);

    void drillStatusChanged(JSONObject jSONObject, boolean z);

    void editDrillClicked(JSONObject jSONObject);

    void editGroupDrillClicked(JSONObject jSONObject);

    void moveDrillDownClicked(JSONObject jSONObject);

    void moveDrillUpClicked(JSONObject jSONObject);

    void playVideoClicked(JSONObject jSONObject);

    void updateStatsClicked(JSONObject jSONObject);
}
