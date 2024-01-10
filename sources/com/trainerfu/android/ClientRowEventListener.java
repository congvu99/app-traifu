package com.trainerfu.android;

import org.json.JSONObject;

public interface ClientRowEventListener {
    void assessmentBtnClicked(JSONObject jSONObject);

    void chatBtnClicked(JSONObject jSONObject);

    void coBtnClicked(JSONObject jSONObject);

    void deleteBtnClicked(int i);

    void diaryBtnClicked(JSONObject jSONObject);

    void diaryBtnClicked(JSONObject jSONObject, int i);

    void moreBtnClicked(JSONObject jSONObject, int i);

    void notesBtnClicked(JSONObject jSONObject);

    void planBtnClicked(JSONObject jSONObject);

    void sendInviteBtnClicked(JSONObject jSONObject);

    void settingsBtnClicked(JSONObject jSONObject);

    void trackWorkoutClicked(JSONObject jSONObject);
}
