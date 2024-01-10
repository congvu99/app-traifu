package com.trainerfu.android;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.trainerfu.utils.RNUtil;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = "RNEventModule")
public class RNEventModule extends ReactContextBaseJavaModule {
    public String getName() {
        return "RNEventModule";
    }

    public RNEventModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void handleRNEvent(String str, ReadableMap readableMap) {
        try {
            JSONObject jSONObject = RNUtil.toJSONObject(readableMap);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event_name", str);
            jSONObject2.put("data", jSONObject);
            EventBus.getDefault().post(new RNEvent(jSONObject2.toString()));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
