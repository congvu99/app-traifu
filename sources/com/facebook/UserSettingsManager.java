package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.facebook.GraphRequest;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

final class UserSettingsManager {
    private static final String ADVERTISERID_COLLECTION_FALSE_WARNING = "The value for AdvertiserIDCollectionEnabled is currently set to FALSE so you're sending app events without collecting Advertiser ID. This can affect the quality of your advertising and analytics results.";
    private static final String ADVERTISERID_COLLECTION_NOT_SET_WARNING = "You haven't set a value for AdvertiserIDCollectionEnabled. Set the flag to TRUE if you want to collect Advertiser ID for better advertising and analytics results. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.";
    private static final String ADVERTISER_ID_KEY = "advertiser_id";
    private static final String APPLICATION_FIELDS = "fields";
    private static final String AUTOLOG_APPEVENT_NOT_SET_WARNING = "Please set a value for AutoLogAppEventsEnabled. Set the flag to TRUE if you want to collect app install, app launch and in-app purchase events automatically. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.";
    private static final String AUTO_APP_LINK_WARNING = "You haven't set the Auto App Link URL scheme: fb<YOUR APP ID> in AndroidManifest";
    private static final String EVENTS_CODELESS_SETUP_ENABLED = "auto_event_setup_enabled";
    private static final String LAST_TIMESTAMP = "last_timestamp";
    private static final String TAG = UserSettingsManager.class.getName();
    private static final long TIMEOUT_7D = 604800000;
    private static final String USER_SETTINGS = "com.facebook.sdk.USER_SETTINGS";
    private static final String USER_SETTINGS_BITMASK = "com.facebook.sdk.USER_SETTINGS_BITMASK";
    private static final String VALUE = "value";
    private static UserSetting advertiserIDCollectionEnabled = new UserSetting(true, FacebookSdk.ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY);
    private static UserSetting autoInitEnabled = new UserSetting(true, FacebookSdk.AUTO_INIT_ENABLED_PROPERTY);
    private static UserSetting autoLogAppEventsEnabled = new UserSetting(true, FacebookSdk.AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY);
    private static UserSetting codelessSetupEnabled = new UserSetting(false, EVENTS_CODELESS_SETUP_ENABLED);
    private static AtomicBoolean isFetchingCodelessStatus = new AtomicBoolean(false);
    private static AtomicBoolean isInitialized = new AtomicBoolean(false);
    private static UserSetting monitorEnabled = new UserSetting(true, FacebookSdk.MONITOR_ENABLED_PROPERTY);
    private static SharedPreferences userSettingPref;

    UserSettingsManager() {
    }

    static /* synthetic */ UserSetting access$000() {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return advertiserIDCollectionEnabled;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static /* synthetic */ UserSetting access$100() {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return codelessSetupEnabled;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static /* synthetic */ void access$200(UserSetting userSetting) {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                writeSettingToCache(userSetting);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    static /* synthetic */ AtomicBoolean access$300() {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return isFetchingCodelessStatus;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static void initializeIfNotInitialized() {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (FacebookSdk.isInitialized() && isInitialized.compareAndSet(false, true)) {
                    userSettingPref = FacebookSdk.getApplicationContext().getSharedPreferences(USER_SETTINGS, 0);
                    initializeUserSetting(autoLogAppEventsEnabled, advertiserIDCollectionEnabled, autoInitEnabled);
                    initializeCodelessSetupEnabledAsync();
                    logWarnings();
                    logIfSDKSettingsChanged();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private static void initializeUserSetting(UserSetting... userSettingArr) {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            int i = 0;
            while (i < userSettingArr.length) {
                try {
                    UserSetting userSetting = userSettingArr[i];
                    if (userSetting == codelessSetupEnabled) {
                        initializeCodelessSetupEnabledAsync();
                    } else if (userSetting.value == null) {
                        readSettingFromCache(userSetting);
                        if (userSetting.value == null) {
                            loadSettingFromManifest(userSetting);
                        }
                    } else {
                        writeSettingToCache(userSetting);
                    }
                    i++;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                    return;
                }
            }
        }
    }

    private static void initializeCodelessSetupEnabledAsync() {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                readSettingFromCache(codelessSetupEnabled);
                final long currentTimeMillis = System.currentTimeMillis();
                if (codelessSetupEnabled.value == null || currentTimeMillis - codelessSetupEnabled.lastTS >= TIMEOUT_7D) {
                    codelessSetupEnabled.value = null;
                    codelessSetupEnabled.lastTS = 0;
                    if (isFetchingCodelessStatus.compareAndSet(false, true)) {
                        FacebookSdk.getExecutor().execute(new Runnable() {
                            public void run() {
                                FetchedAppSettings queryAppSettings;
                                if (!CrashShieldHandler.isObjectCrashing(this)) {
                                    try {
                                        if (UserSettingsManager.access$000().getValue() && (queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false)) != null && queryAppSettings.getCodelessEventsEnabled()) {
                                            AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                                            if (((attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null) ? null : attributionIdentifiers.getAndroidAdvertiserId()) != null) {
                                                Bundle bundle = new Bundle();
                                                bundle.putString(UserSettingsManager.ADVERTISER_ID_KEY, attributionIdentifiers.getAndroidAdvertiserId());
                                                bundle.putString("fields", UserSettingsManager.EVENTS_CODELESS_SETUP_ENABLED);
                                                GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest((AccessToken) null, FacebookSdk.getApplicationId(), (GraphRequest.Callback) null);
                                                newGraphPathRequest.setSkipClientToken(true);
                                                newGraphPathRequest.setParameters(bundle);
                                                JSONObject jSONObject = newGraphPathRequest.executeAndWait().getJSONObject();
                                                if (jSONObject != null) {
                                                    UserSettingsManager.access$100().value = Boolean.valueOf(jSONObject.optBoolean(UserSettingsManager.EVENTS_CODELESS_SETUP_ENABLED, false));
                                                    UserSettingsManager.access$100().lastTS = currentTimeMillis;
                                                    UserSettingsManager.access$200(UserSettingsManager.access$100());
                                                }
                                            }
                                        }
                                        UserSettingsManager.access$300().set(false);
                                    } catch (Throwable th) {
                                        CrashShieldHandler.handleThrowable(th, this);
                                    }
                                }
                            }
                        });
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private static void writeSettingToCache(UserSetting userSetting) {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                validateInitialized();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("value", userSetting.value);
                jSONObject.put(LAST_TIMESTAMP, userSetting.lastTS);
                userSettingPref.edit().putString(userSetting.key, jSONObject.toString()).commit();
                logIfSDKSettingsChanged();
            } catch (Exception e) {
                Utility.logd(TAG, e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private static void readSettingFromCache(UserSetting userSetting) {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                validateInitialized();
                String string = userSettingPref.getString(userSetting.key, "");
                if (!string.isEmpty()) {
                    JSONObject jSONObject = new JSONObject(string);
                    userSetting.value = Boolean.valueOf(jSONObject.getBoolean("value"));
                    userSetting.lastTS = jSONObject.getLong(LAST_TIMESTAMP);
                }
            } catch (JSONException e) {
                Utility.logd(TAG, (Exception) e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private static void loadSettingFromManifest(UserSetting userSetting) {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                validateInitialized();
                Context applicationContext = FacebookSdk.getApplicationContext();
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                if (applicationInfo != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey(userSetting.key)) {
                    userSetting.value = Boolean.valueOf(applicationInfo.metaData.getBoolean(userSetting.key, userSetting.defaultVal));
                }
            } catch (PackageManager.NameNotFoundException e) {
                Utility.logd(TAG, (Exception) e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private static void logWarnings() {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Context applicationContext = FacebookSdk.getApplicationContext();
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    if (!applicationInfo.metaData.containsKey(FacebookSdk.AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY)) {
                        Log.w(TAG, AUTOLOG_APPEVENT_NOT_SET_WARNING);
                    }
                    if (!applicationInfo.metaData.containsKey(FacebookSdk.ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY)) {
                        Log.w(TAG, ADVERTISERID_COLLECTION_NOT_SET_WARNING);
                    }
                    if (!getAdvertiserIDCollectionEnabled()) {
                        Log.w(TAG, ADVERTISERID_COLLECTION_FALSE_WARNING);
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private static void logIfSDKSettingsChanged() {
        int i;
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (isInitialized.get() && FacebookSdk.isInitialized()) {
                    Context applicationContext = FacebookSdk.getApplicationContext();
                    int i2 = 0;
                    int i3 = ((autoInitEnabled.getValue() ? 1 : 0) << 0) | 0 | ((autoLogAppEventsEnabled.getValue() ? 1 : 0) << 1) | ((advertiserIDCollectionEnabled.getValue() ? 1 : 0) << 2) | ((monitorEnabled.getValue() ? 1 : 0) << 3);
                    int i4 = userSettingPref.getInt(USER_SETTINGS_BITMASK, 0);
                    if (i4 != i3) {
                        userSettingPref.edit().putInt(USER_SETTINGS_BITMASK, i3).commit();
                        try {
                            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                                String[] strArr = {FacebookSdk.AUTO_INIT_ENABLED_PROPERTY, FacebookSdk.AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY, FacebookSdk.ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY, FacebookSdk.MONITOR_ENABLED_PROPERTY};
                                boolean[] zArr = {true, true, true, true};
                                int i5 = 0;
                                i = 0;
                                int i6 = 0;
                                while (i5 < 4) {
                                    try {
                                        i6 |= (applicationInfo.metaData.containsKey(strArr[i5]) ? 1 : 0) << i5;
                                        i |= (applicationInfo.metaData.getBoolean(strArr[i5], zArr[i5]) ? 1 : 0) << i5;
                                        i5++;
                                    } catch (PackageManager.NameNotFoundException unused) {
                                    }
                                }
                                i2 = i6;
                                InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(applicationContext);
                                Bundle bundle = new Bundle();
                                bundle.putInt("usage", i2);
                                bundle.putInt("initial", i);
                                bundle.putInt("previous", i4);
                                bundle.putInt("current", i3);
                                internalAppEventsLogger.logChangedSettingsEvent(bundle);
                            }
                        } catch (PackageManager.NameNotFoundException unused2) {
                        }
                        i = 0;
                        InternalAppEventsLogger internalAppEventsLogger2 = new InternalAppEventsLogger(applicationContext);
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("usage", i2);
                        bundle2.putInt("initial", i);
                        bundle2.putInt("previous", i4);
                        bundle2.putInt("current", i3);
                        internalAppEventsLogger2.logChangedSettingsEvent(bundle2);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    static void logIfAutoAppLinkEnabled() {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Context applicationContext = FacebookSdk.getApplicationContext();
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                if (applicationInfo != null && applicationInfo.metaData != null && applicationInfo.metaData.getBoolean("com.facebook.sdk.AutoAppLinkEnabled", false)) {
                    InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(applicationContext);
                    Bundle bundle = new Bundle();
                    if (!Utility.isAutoAppLinkSetup()) {
                        bundle.putString("SchemeWarning", AUTO_APP_LINK_WARNING);
                        Log.w(TAG, AUTO_APP_LINK_WARNING);
                    }
                    internalAppEventsLogger.logEvent("fb_auto_applink", bundle);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private static void validateInitialized() {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (!isInitialized.get()) {
                    throw new FacebookSdkNotInitializedException("The UserSettingManager has not been initialized successfully");
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static void setAutoInitEnabled(boolean z) {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                autoInitEnabled.value = Boolean.valueOf(z);
                autoInitEnabled.lastTS = System.currentTimeMillis();
                if (isInitialized.get()) {
                    writeSettingToCache(autoInitEnabled);
                } else {
                    initializeIfNotInitialized();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static boolean getAutoInitEnabled() {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            initializeIfNotInitialized();
            return autoInitEnabled.getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static void setAutoLogAppEventsEnabled(boolean z) {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                autoLogAppEventsEnabled.value = Boolean.valueOf(z);
                autoLogAppEventsEnabled.lastTS = System.currentTimeMillis();
                if (isInitialized.get()) {
                    writeSettingToCache(autoLogAppEventsEnabled);
                } else {
                    initializeIfNotInitialized();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static boolean getAutoLogAppEventsEnabled() {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            initializeIfNotInitialized();
            return autoLogAppEventsEnabled.getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static void setAdvertiserIDCollectionEnabled(boolean z) {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                advertiserIDCollectionEnabled.value = Boolean.valueOf(z);
                advertiserIDCollectionEnabled.lastTS = System.currentTimeMillis();
                if (isInitialized.get()) {
                    writeSettingToCache(advertiserIDCollectionEnabled);
                } else {
                    initializeIfNotInitialized();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static boolean getAdvertiserIDCollectionEnabled() {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            initializeIfNotInitialized();
            return advertiserIDCollectionEnabled.getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static boolean getCodelessSetupEnabled() {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            initializeIfNotInitialized();
            return codelessSetupEnabled.getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static void setMonitorEnabled(boolean z) {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                monitorEnabled.value = Boolean.valueOf(z);
                monitorEnabled.lastTS = System.currentTimeMillis();
                if (isInitialized.get()) {
                    writeSettingToCache(monitorEnabled);
                } else {
                    initializeIfNotInitialized();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static boolean getMonitorEnabled() {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            initializeIfNotInitialized();
            return monitorEnabled.getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    private static class UserSetting {
        boolean defaultVal;
        String key;
        long lastTS;
        Boolean value;

        UserSetting(boolean z, String str) {
            this.defaultVal = z;
            this.key = str;
        }

        /* access modifiers changed from: package-private */
        public boolean getValue() {
            Boolean bool = this.value;
            return bool == null ? this.defaultVal : bool.booleanValue();
        }
    }
}