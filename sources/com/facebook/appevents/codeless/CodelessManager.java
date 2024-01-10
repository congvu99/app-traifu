package com.facebook.appevents.codeless;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.codeless.ViewIndexingTrigger;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public final class CodelessManager {
    private static CodelessSessionChecker codelessSessionChecker = new CodelessSessionChecker() {
        public void checkCodelessSession(String str) {
            CodelessManager.checkCodelessSession(str);
        }
    };
    private static String deviceSessionID;
    private static final AtomicBoolean isAppIndexingEnabled = new AtomicBoolean(false);
    private static volatile Boolean isCheckingSession = false;
    private static final AtomicBoolean isCodelessEnabled = new AtomicBoolean(true);
    private static SensorManager sensorManager;
    private static ViewIndexer viewIndexer;
    private static final ViewIndexingTrigger viewIndexingTrigger = new ViewIndexingTrigger();

    public interface CodelessSessionChecker {
        void checkCodelessSession(String str);
    }

    static boolean isDebugOnEmulator() {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
        }
        return false;
    }

    static /* synthetic */ CodelessSessionChecker access$000() {
        Class<CodelessManager> cls = CodelessManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return codelessSessionChecker;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static /* synthetic */ AtomicBoolean access$100() {
        Class<CodelessManager> cls = CodelessManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return isAppIndexingEnabled;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static /* synthetic */ String access$202(String str) {
        Class<CodelessManager> cls = CodelessManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            deviceSessionID = str;
            return str;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static /* synthetic */ ViewIndexer access$300() {
        Class<CodelessManager> cls = CodelessManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return viewIndexer;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static /* synthetic */ Boolean access$402(Boolean bool) {
        Class<CodelessManager> cls = CodelessManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            isCheckingSession = bool;
            return bool;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static void onActivityResumed(Activity activity) {
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (isCodelessEnabled.get()) {
                    CodelessMatcher.getInstance().add(activity);
                    Context applicationContext = activity.getApplicationContext();
                    final String applicationId = FacebookSdk.getApplicationId();
                    final FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
                    if ((appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) || isDebugOnEmulator()) {
                        SensorManager sensorManager2 = (SensorManager) applicationContext.getSystemService("sensor");
                        sensorManager = sensorManager2;
                        if (sensorManager2 != null) {
                            Sensor defaultSensor = sensorManager2.getDefaultSensor(1);
                            viewIndexer = new ViewIndexer(activity);
                            viewIndexingTrigger.setOnShakeListener(new ViewIndexingTrigger.OnShakeListener() {
                                public void onShake() {
                                    FetchedAppSettings fetchedAppSettings = appSettingsWithoutQuery;
                                    boolean z = true;
                                    boolean z2 = fetchedAppSettings != null && fetchedAppSettings.getCodelessEventsEnabled();
                                    if (!FacebookSdk.getCodelessSetupEnabled()) {
                                        z = false;
                                    }
                                    if (z2 && z) {
                                        CodelessManager.access$000().checkCodelessSession(applicationId);
                                    }
                                }
                            });
                            sensorManager.registerListener(viewIndexingTrigger, defaultSensor, 2);
                            if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                                viewIndexer.schedule();
                            }
                        } else {
                            return;
                        }
                    }
                    if (isDebugOnEmulator() && !isAppIndexingEnabled.get()) {
                        codelessSessionChecker.checkCodelessSession(applicationId);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static void onActivityPaused(Activity activity) {
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (isCodelessEnabled.get()) {
                    CodelessMatcher.getInstance().remove(activity);
                    if (viewIndexer != null) {
                        viewIndexer.unschedule();
                    }
                    if (sensorManager != null) {
                        sensorManager.unregisterListener(viewIndexingTrigger);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static void onActivityDestroyed(Activity activity) {
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                CodelessMatcher.getInstance().destroy(activity);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static void enable() {
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                isCodelessEnabled.set(true);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static void disable() {
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                isCodelessEnabled.set(false);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    static void checkCodelessSession(final String str) {
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (!isCheckingSession.booleanValue()) {
                    isCheckingSession = true;
                    FacebookSdk.getExecutor().execute(new Runnable() {
                        public void run() {
                            String str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            if (!CrashShieldHandler.isObjectCrashing(this)) {
                                try {
                                    boolean z = true;
                                    GraphRequest newPostRequest = GraphRequest.newPostRequest((AccessToken) null, String.format(Locale.US, "%s/app_indexing_session", new Object[]{str}), (JSONObject) null, (GraphRequest.Callback) null);
                                    Bundle parameters = newPostRequest.getParameters();
                                    if (parameters == null) {
                                        parameters = new Bundle();
                                    }
                                    AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                                    JSONArray jSONArray = new JSONArray();
                                    jSONArray.put(Build.MODEL != null ? Build.MODEL : "");
                                    if (attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null) {
                                        jSONArray.put("");
                                    } else {
                                        jSONArray.put(attributionIdentifiers.getAndroidAdvertiserId());
                                    }
                                    jSONArray.put(str);
                                    if (AppEventUtility.isEmulator()) {
                                        str = "1";
                                    }
                                    jSONArray.put(str);
                                    Locale currentLocale = Utility.getCurrentLocale();
                                    jSONArray.put(currentLocale.getLanguage() + "_" + currentLocale.getCountry());
                                    String jSONArray2 = jSONArray.toString();
                                    parameters.putString(Constants.DEVICE_SESSION_ID, CodelessManager.getCurrentDeviceSessionID());
                                    parameters.putString(Constants.EXTINFO, jSONArray2);
                                    newPostRequest.setParameters(parameters);
                                    JSONObject jSONObject = newPostRequest.executeAndWait().getJSONObject();
                                    AtomicBoolean access$100 = CodelessManager.access$100();
                                    if (jSONObject == null || !jSONObject.optBoolean(Constants.APP_INDEXING_ENABLED, false)) {
                                        z = false;
                                    }
                                    access$100.set(z);
                                    if (!CodelessManager.access$100().get()) {
                                        CodelessManager.access$202((String) null);
                                    } else if (CodelessManager.access$300() != null) {
                                        CodelessManager.access$300().schedule();
                                    }
                                    CodelessManager.access$402(false);
                                } catch (Throwable th) {
                                    CrashShieldHandler.handleThrowable(th, this);
                                }
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    static String getCurrentDeviceSessionID() {
        Class<CodelessManager> cls = CodelessManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (deviceSessionID == null) {
                deviceSessionID = UUID.randomUUID().toString();
            }
            return deviceSessionID;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static boolean getIsAppIndexingEnabled() {
        Class<CodelessManager> cls = CodelessManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            return isAppIndexingEnabled.get();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    static void updateAppIndexing(Boolean bool) {
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                isAppIndexingEnabled.set(bool.booleanValue());
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    static void setCodelessSessionChecker(CodelessSessionChecker codelessSessionChecker2) {
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                codelessSessionChecker = codelessSessionChecker2;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }
}
