package com.trainerfu.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.HashMap;
import org.apache.http.Header;
import org.json.JSONObject;

public class Push {
    public static final String EXTRA_MESSAGE = "message";
    private static final String PROPERTY_APP_VERSION = "appVersion";
    public static final String PROPERTY_REG_ID = "registration_id";
    private static final String TAG = "MainActivity";
    private Context context;

    public Push(Context context2) {
        this.context = context2;
    }

    public void sendRegistrationIdToBackend() {
        String registrationId = getRegistrationId();
        if (registrationId.isEmpty()) {
            getFCMToken();
        } else {
            sendRegistrationIdToBackend(registrationId);
        }
    }

    public void checkAndRegister() {
        String registrationId = getRegistrationId();
        if (registrationId.isEmpty()) {
            getFCMToken();
        } else {
            sendRegistrationIdToBackend(registrationId);
        }
    }

    public String getRegistrationId() {
        SharedPreferences preferences = getPreferences(this.context);
        String string = preferences.getString(PROPERTY_REG_ID, "");
        if (!string.isEmpty() && preferences.getInt(PROPERTY_APP_VERSION, Integer.MIN_VALUE) == getAppVersion(this.context)) {
            return string;
        }
        return "";
    }

    private SharedPreferences getPreferences(Context context2) {
        return context2.getSharedPreferences(Push.class.getSimpleName(), 0);
    }

    private static int getAppVersion(Context context2) {
        try {
            return context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    private void getFCMToken() {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            public void onComplete(Task<String> task) {
                if (!task.isSuccessful()) {
                    Log.w(Push.TAG, "Fetching FCM registration token failed", task.getException());
                    return;
                }
                Push.this.sendRegistrationIdToBackend(task.getResult());
            }
        });
    }

    public void sendRegistrationIdToBackend(final String str) {
        BaseHttpClient baseHttpClient = new BaseHttpClient();
        HashMap hashMap = new HashMap();
        hashMap.put("device_token", str);
        hashMap.put("device_type", 2);
        hashMap.put("timezone_offset", Float.valueOf(DateUtils.getTimeZoneOffset()));
        baseHttpClient.post("/devices/my_device", hashMap, new BaseResponseHandler() {
            public boolean getUseSynchronousMode() {
                return false;
            }

            public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                return true;
            }

            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                Push.this.storeRegistrationId(str);
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    public void storeRegistrationId(String str) {
        SharedPreferences preferences = getPreferences(this.context);
        int appVersion = getAppVersion(this.context);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(PROPERTY_REG_ID, str);
        edit.putInt(PROPERTY_APP_VERSION, appVersion);
        edit.apply();
    }
}
