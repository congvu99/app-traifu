package net.hockeyapp.android.utils;

import android.content.Context;
import android.content.SharedPreferences;
import net.hockeyapp.android.Constants;
import okhttp3.HttpUrl;

public class VersionCache {
    private static String VERSION_INFO_KEY = "versionInfo";

    public static void setVersionInfo(Context context, String str) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.TAG, 0).edit();
            edit.putString(VERSION_INFO_KEY, str);
            PrefsUtil.applyChanges(edit);
        }
    }

    public static String getVersionInfo(Context context) {
        if (context != null) {
            return context.getSharedPreferences(Constants.TAG, 0).getString(VERSION_INFO_KEY, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }
}
