package net.hockeyapp.android.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

public class PrefsUtil {
    private SharedPreferences feedbackTokenPrefs;
    private SharedPreferences.Editor feedbackTokenPrefsEditor;
    private SharedPreferences nameEmailSubjectPrefs;
    private SharedPreferences.Editor nameEmailSubjectPrefsEditor;

    private PrefsUtil() {
    }

    private static class PrefsUtilHolder {
        public static final PrefsUtil INSTANCE = new PrefsUtil();

        private PrefsUtilHolder() {
        }
    }

    public static PrefsUtil getInstance() {
        return PrefsUtilHolder.INSTANCE;
    }

    public void saveFeedbackTokenToPrefs(Context context, String str) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Util.PREFS_FEEDBACK_TOKEN, 0);
            this.feedbackTokenPrefs = sharedPreferences;
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                this.feedbackTokenPrefsEditor = edit;
                edit.putString(Util.PREFS_KEY_FEEDBACK_TOKEN, str);
                applyChanges(this.feedbackTokenPrefsEditor);
            }
        }
    }

    public String getFeedbackTokenFromPrefs(Context context) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(Util.PREFS_FEEDBACK_TOKEN, 0);
        this.feedbackTokenPrefs = sharedPreferences;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString(Util.PREFS_KEY_FEEDBACK_TOKEN, (String) null);
    }

    public void saveNameEmailSubjectToPrefs(Context context, String str, String str2, String str3) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Util.PREFS_NAME_EMAIL_SUBJECT, 0);
            this.nameEmailSubjectPrefs = sharedPreferences;
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                this.nameEmailSubjectPrefsEditor = edit;
                if (str == null || str2 == null || str3 == null) {
                    this.nameEmailSubjectPrefsEditor.putString(Util.PREFS_KEY_NAME_EMAIL_SUBJECT, (String) null);
                } else {
                    edit.putString(Util.PREFS_KEY_NAME_EMAIL_SUBJECT, String.format("%s|%s|%s", new Object[]{str, str2, str3}));
                }
                applyChanges(this.nameEmailSubjectPrefsEditor);
            }
        }
    }

    public String getNameEmailFromPrefs(Context context) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(Util.PREFS_NAME_EMAIL_SUBJECT, 0);
        this.nameEmailSubjectPrefs = sharedPreferences;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString(Util.PREFS_KEY_NAME_EMAIL_SUBJECT, (String) null);
    }

    public static void applyChanges(SharedPreferences.Editor editor) {
        if (applySupported().booleanValue()) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public static Boolean applySupported() {
        try {
            return Boolean.valueOf(Build.VERSION.SDK_INT >= 9);
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }
}
