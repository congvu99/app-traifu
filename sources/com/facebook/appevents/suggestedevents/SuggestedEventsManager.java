package com.facebook.appevents.suggestedevents;

import android.app.Activity;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public final class SuggestedEventsManager {
    private static final String ELIGIBLE_EVENTS_KEY = "eligible_for_prediction_events";
    private static final String PRODUCTION_EVENTS_KEY = "production_events";
    private static final Set<String> eligibleEvents = new HashSet();
    private static final AtomicBoolean enabled = new AtomicBoolean(false);
    private static final Set<String> productionEvents = new HashSet();

    static /* synthetic */ AtomicBoolean access$000() {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return enabled;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static /* synthetic */ void access$100() {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                initialize();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static synchronized void enable() {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        synchronized (cls) {
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    FacebookSdk.getExecutor().execute(new Runnable() {
                        public void run() {
                            if (!CrashShieldHandler.isObjectCrashing(this)) {
                                try {
                                    if (!SuggestedEventsManager.access$000().get()) {
                                        SuggestedEventsManager.access$000().set(true);
                                        SuggestedEventsManager.access$100();
                                    }
                                } catch (Throwable th) {
                                    CrashShieldHandler.handleThrowable(th, this);
                                }
                            }
                        }
                    });
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
        }
    }

    private static void initialize() {
        String suggestedEventsSetting;
        File ruleFile;
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if (queryAppSettings != null && (suggestedEventsSetting = queryAppSettings.getSuggestedEventsSetting()) != null) {
                    populateEventsFromRawJsonString(suggestedEventsSetting);
                    if ((!productionEvents.isEmpty() || !eligibleEvents.isEmpty()) && (ruleFile = ModelManager.getRuleFile(ModelManager.Task.MTML_APP_EVENT_PREDICTION)) != null) {
                        FeatureExtractor.initialize(ruleFile);
                        Activity currentActivity = ActivityLifecycleTracker.getCurrentActivity();
                        if (currentActivity != null) {
                            trackActivity(currentActivity);
                        }
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    protected static void populateEventsFromRawJsonString(String str) {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(PRODUCTION_EVENTS_KEY)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(PRODUCTION_EVENTS_KEY);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        productionEvents.add(jSONArray.getString(i));
                    }
                }
                if (jSONObject.has(ELIGIBLE_EVENTS_KEY)) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray(ELIGIBLE_EVENTS_KEY);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        eligibleEvents.add(jSONArray2.getString(i2));
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static void trackActivity(Activity activity) {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (!enabled.get() || !FeatureExtractor.isInitialized() || (productionEvents.isEmpty() && eligibleEvents.isEmpty())) {
                    ViewObserver.stopTrackingActivity(activity);
                } else {
                    ViewObserver.startTrackingActivity(activity);
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static boolean isEnabled() {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            return enabled.get();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    static boolean isProductionEvents(String str) {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            return productionEvents.contains(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    static boolean isEligibleEvents(String str) {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            return eligibleEvents.contains(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }
}
