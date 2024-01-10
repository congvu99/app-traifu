package net.hockeyapp.android.utils;

import java.util.ArrayList;
import net.hockeyapp.android.objects.Feedback;
import net.hockeyapp.android.objects.FeedbackMessage;
import net.hockeyapp.android.objects.FeedbackResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedbackParser {
    private FeedbackParser() {
    }

    private static class FeedbackParserHolder {
        public static final FeedbackParser INSTANCE = new FeedbackParser();

        private FeedbackParserHolder() {
        }
    }

    public static FeedbackParser getInstance() {
        return FeedbackParserHolder.INSTANCE;
    }

    public FeedbackResponse parseFeedbackResponse(String str) {
        FeedbackResponse feedbackResponse;
        String str2;
        String str3;
        JSONObject jSONObject;
        String str4;
        String str5;
        JSONObject jSONObject2;
        ArrayList arrayList;
        Feedback feedback;
        String str6 = str;
        if (str6 == null) {
            return null;
        }
        try {
            JSONObject jSONObject3 = new JSONObject(str6);
            JSONObject jSONObject4 = jSONObject3.getJSONObject("feedback");
            Feedback feedback2 = new Feedback();
            JSONArray jSONArray = jSONObject4.getJSONArray("messages");
            String str7 = "token";
            String str8 = "created_at";
            String str9 = "id";
            String str10 = "name";
            if (jSONArray.length() > 0) {
                arrayList = new ArrayList();
                int i = 0;
                while (i < jSONArray.length()) {
                    String str11 = jSONArray.getJSONObject(i).getString("subject").toString();
                    String str12 = jSONArray.getJSONObject(i).getString("text").toString();
                    String str13 = jSONArray.getJSONObject(i).getString("oem").toString();
                    String str14 = jSONArray.getJSONObject(i).getString("model").toString();
                    String str15 = jSONArray.getJSONObject(i).getString("os_version").toString();
                    String str16 = jSONArray.getJSONObject(i).getString(str8).toString();
                    JSONObject jSONObject5 = jSONObject3;
                    int i2 = jSONArray.getJSONObject(i).getInt(str9);
                    String str17 = str8;
                    String str18 = jSONArray.getJSONObject(i).getString(str7).toString();
                    String str19 = str7;
                    String str20 = str9;
                    int i3 = jSONArray.getJSONObject(i).getInt("via");
                    JSONObject jSONObject6 = jSONObject4;
                    String str21 = jSONArray.getJSONObject(i).getString("user_string").toString();
                    Feedback feedback3 = feedback2;
                    String str22 = jSONArray.getJSONObject(i).getString("clean_text").toString();
                    String str23 = jSONArray.getJSONObject(i).getString(str10).toString();
                    String str24 = str10;
                    JSONArray jSONArray2 = jSONArray;
                    String str25 = jSONArray.getJSONObject(i).getString("app_id").toString();
                    FeedbackMessage feedbackMessage = new FeedbackMessage();
                    feedbackMessage.setAppId(str25);
                    feedbackMessage.setCleanText(str22);
                    feedbackMessage.setCreatedAt(str16);
                    feedbackMessage.setId(i2);
                    feedbackMessage.setModel(str14);
                    feedbackMessage.setName(str23);
                    feedbackMessage.setOem(str13);
                    feedbackMessage.setOsVersion(str15);
                    feedbackMessage.setSubjec(str11);
                    feedbackMessage.setText(str12);
                    feedbackMessage.setToken(str18);
                    feedbackMessage.setUserString(str21);
                    feedbackMessage.setVia(i3);
                    arrayList.add(feedbackMessage);
                    i++;
                    str8 = str17;
                    jSONObject3 = jSONObject5;
                    str7 = str19;
                    str9 = str20;
                    jSONObject4 = jSONObject6;
                    feedback2 = feedback3;
                    str10 = str24;
                    jSONArray = jSONArray2;
                }
                jSONObject2 = jSONObject3;
                jSONObject = jSONObject4;
                str5 = str7;
                str2 = str8;
                str4 = str9;
                str3 = str10;
                feedback = feedback2;
            } else {
                jSONObject2 = jSONObject3;
                jSONObject = jSONObject4;
                str5 = str7;
                str2 = str8;
                str4 = str9;
                str3 = str10;
                feedback = feedback2;
                arrayList = null;
            }
            feedback.setMessages(arrayList);
            JSONObject jSONObject7 = jSONObject;
            try {
                feedback.setName(jSONObject7.getString(str3).toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                feedback.setEmail(jSONObject7.getString("email").toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            try {
                feedback.setId(jSONObject7.getInt(str4));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            try {
                feedback.setCreatedAt(jSONObject7.getString(str2).toString());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            FeedbackResponse feedbackResponse2 = new FeedbackResponse();
            try {
                feedbackResponse2.setFeedback(feedback);
                JSONObject jSONObject8 = jSONObject2;
                try {
                    feedbackResponse2.setStatus(jSONObject8.getString("status").toString());
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
                try {
                    feedbackResponse2.setToken(jSONObject8.getString(str5).toString());
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
                return feedbackResponse2;
            } catch (JSONException e7) {
                e = e7;
                feedbackResponse = feedbackResponse2;
                e.printStackTrace();
                return feedbackResponse;
            }
        } catch (JSONException e8) {
            e = e8;
            feedbackResponse = null;
            e.printStackTrace();
            return feedbackResponse;
        }
    }
}
