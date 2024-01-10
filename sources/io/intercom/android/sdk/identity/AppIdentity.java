package io.intercom.android.sdk.identity;

import android.content.Context;
import android.content.SharedPreferences;
import io.intercom.android.sdk.utilities.PreferenceKeys;

public abstract class AppIdentity {
    private static final String PREFS_API_KEY = "ApiKey";
    private static final String PREFS_APP_ID = "AppId";

    public abstract String apiKey();

    public abstract String appId();

    public static AppIdentity create(String str, String str2) {
        return new AutoValue_AppIdentity(str, str2);
    }

    public static AppIdentity loadFromDevice(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PreferenceKeys.INTERCOM_PREFS, 0);
        return create(sharedPreferences.getString(PREFS_API_KEY, ""), sharedPreferences.getString(PREFS_APP_ID, ""));
    }

    public void persist(Context context) {
        context.getSharedPreferences(PreferenceKeys.INTERCOM_PREFS, 0).edit().putString(PREFS_API_KEY, apiKey()).putString(PREFS_APP_ID, appId()).apply();
    }
}
