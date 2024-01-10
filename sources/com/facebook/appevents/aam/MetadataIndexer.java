package com.facebook.appevents.aam;

import android.app.Activity;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;

public final class MetadataIndexer {
    private static final String TAG = MetadataIndexer.class.getCanonicalName();
    private static Boolean enabled = false;

    static /* synthetic */ void access$000() {
        Class<MetadataIndexer> cls = MetadataIndexer.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                updateRules();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    static /* synthetic */ Boolean access$102(Boolean bool) {
        Class<MetadataIndexer> cls = MetadataIndexer.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            enabled = bool;
            return bool;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static void onActivityResumed(Activity activity) {
        Class<MetadataIndexer> cls = MetadataIndexer.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (!enabled.booleanValue()) {
                    return;
                }
                if (!MetadataRule.getRules().isEmpty()) {
                    MetadataViewObserver.startTrackingActivity(activity);
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private static void updateRules() {
        String rawAamRules;
        Class<MetadataIndexer> cls = MetadataIndexer.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if (queryAppSettings != null && (rawAamRules = queryAppSettings.getRawAamRules()) != null) {
                    MetadataRule.updateRules(rawAamRules);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static void enable() {
        Class<MetadataIndexer> cls = MetadataIndexer.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                FacebookSdk.getExecutor().execute(new Runnable() {
                    public void run() {
                        if (!CrashShieldHandler.isObjectCrashing(this)) {
                            try {
                                if (!AttributionIdentifiers.isTrackingLimited(FacebookSdk.getApplicationContext())) {
                                    MetadataIndexer.access$000();
                                    MetadataIndexer.access$102(true);
                                }
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(th, this);
                            }
                        }
                    }
                });
            } catch (Exception e) {
                Utility.logd(TAG, e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }
}
