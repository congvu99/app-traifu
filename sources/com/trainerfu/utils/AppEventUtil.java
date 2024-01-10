package com.trainerfu.utils;

import com.trainerfu.android.AppEvent;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.json.JSONObject;

public class AppEventUtil {
    public static void sendAppLaunchEvent() {
        sendAppEvent(AppEvent.APP_LAUNCHED, (Map<String, Object>) null);
    }

    public static void sendClientInviteSentEvent(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("user_id", Integer.valueOf(i));
        sendAppEvent(AppEvent.CLIENT_INVITE_SENT, hashMap);
    }

    public static void sendAppEvent(AppEvent appEvent, Map<String, Object> map) {
        HashMap hashMap;
        BaseHttpClient baseHttpClient = new BaseHttpClient();
        String format = String.format("/app_events/new", new Object[0]);
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap(map);
        }
        hashMap.put("app_event_type", Integer.valueOf(appEvent.getMask()));
        baseHttpClient.put(format, hashMap, new BaseResponseHandler() {
            public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                return true;
            }

            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                return true;
            }
        });
    }
}
