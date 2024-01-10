package net.hockeyapp.android;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import net.hockeyapp.android.utils.PrefsUtil;

public class Tracking {
    private static final String START_TIME_KEY = "startTime";
    private static final String USAGE_TIME_KEY = "usageTime";

    public static void startUsage(Activity activity) {
        long currentTimeMillis = System.currentTimeMillis();
        if (activity != null) {
            SharedPreferences.Editor edit = getPreferences(activity).edit();
            edit.putLong(START_TIME_KEY + activity.hashCode(), currentTimeMillis);
            PrefsUtil.applyChanges(edit);
        }
    }

    public static void stopUsage(Activity activity) {
        long currentTimeMillis = System.currentTimeMillis();
        if (activity != null && checkVersion(activity)) {
            SharedPreferences preferences = getPreferences(activity);
            long j = preferences.getLong(START_TIME_KEY + activity.hashCode(), 0);
            long j2 = preferences.getLong(USAGE_TIME_KEY + Constants.APP_VERSION, 0);
            if (j > 0) {
                SharedPreferences.Editor edit = preferences.edit();
                edit.putLong(USAGE_TIME_KEY + Constants.APP_VERSION, j2 + (currentTimeMillis - j));
                PrefsUtil.applyChanges(edit);
            }
        }
    }

    public static long getUsageTime(Context context) {
        if (!checkVersion(context)) {
            return 0;
        }
        SharedPreferences preferences = getPreferences(context);
        return preferences.getLong(USAGE_TIME_KEY + Constants.APP_VERSION, 0) / 1000;
    }

    private static boolean checkVersion(Context context) {
        if (Constants.APP_VERSION != null) {
            return true;
        }
        Constants.loadFromContext(context);
        return Constants.APP_VERSION != null;
    }

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(Constants.TAG, 0);
    }
}
