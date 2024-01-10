package com.facebook.appevents;

import android.content.SharedPreferences;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PerformanceGuardian {
    private static final Integer ACTIVITY_PROCESS_TIME_THRESHOLD = 40;
    private static final String BANNED_ACTIVITY_STORE = "com.facebook.internal.BANNED_ACTIVITY";
    private static final String CACHE_APP_VERSION = "app_version";
    private static final Integer MAX_EXCEED_LIMIT_COUNT = 3;
    private static final Map<String, Integer> activityProcessTimeMapCodeless = new HashMap();
    private static final Map<String, Integer> activityProcessTimeMapSe = new HashMap();
    private static final Set<String> bannedCodelessActivitySet = new HashSet();
    private static final Set<String> bannedSuggestedEventActivitySet = new HashSet();
    private static boolean initialized = false;
    private static SharedPreferences sharedPreferences;

    public enum UseCase {
        CODELESS,
        SUGGESTED_EVENT
    }

    private static synchronized void initializeIfNotYet() {
        Class<PerformanceGuardian> cls = PerformanceGuardian.class;
        synchronized (cls) {
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    if (!initialized) {
                        SharedPreferences sharedPreferences2 = FacebookSdk.getApplicationContext().getSharedPreferences(BANNED_ACTIVITY_STORE, 0);
                        sharedPreferences = sharedPreferences2;
                        if (!isCacheValid(sharedPreferences2.getString(CACHE_APP_VERSION, ""))) {
                            sharedPreferences.edit().clear().apply();
                        } else {
                            bannedCodelessActivitySet.addAll(sharedPreferences.getStringSet(UseCase.CODELESS.toString(), new HashSet()));
                            bannedSuggestedEventActivitySet.addAll(sharedPreferences.getStringSet(UseCase.SUGGESTED_EVENT.toString(), new HashSet()));
                        }
                        initialized = true;
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
        }
    }

    public static boolean isBannedActivity(String str, UseCase useCase) {
        Class<PerformanceGuardian> cls = PerformanceGuardian.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            initializeIfNotYet();
            int i = AnonymousClass1.$SwitchMap$com$facebook$appevents$PerformanceGuardian$UseCase[useCase.ordinal()];
            if (i == 1) {
                return bannedCodelessActivitySet.contains(str);
            }
            if (i != 2) {
                return false;
            }
            return bannedSuggestedEventActivitySet.contains(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    /* renamed from: com.facebook.appevents.PerformanceGuardian$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$appevents$PerformanceGuardian$UseCase;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.facebook.appevents.PerformanceGuardian$UseCase[] r0 = com.facebook.appevents.PerformanceGuardian.UseCase.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$appevents$PerformanceGuardian$UseCase = r0
                com.facebook.appevents.PerformanceGuardian$UseCase r1 = com.facebook.appevents.PerformanceGuardian.UseCase.CODELESS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$appevents$PerformanceGuardian$UseCase     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.appevents.PerformanceGuardian$UseCase r1 = com.facebook.appevents.PerformanceGuardian.UseCase.SUGGESTED_EVENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.PerformanceGuardian.AnonymousClass1.<clinit>():void");
        }
    }

    public static void limitProcessTime(String str, UseCase useCase, long j, long j2) {
        Class<PerformanceGuardian> cls = PerformanceGuardian.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                initializeIfNotYet();
                long j3 = j2 - j;
                if (str == null) {
                    return;
                }
                if (j3 >= ((long) ACTIVITY_PROCESS_TIME_THRESHOLD.intValue())) {
                    int i = AnonymousClass1.$SwitchMap$com$facebook$appevents$PerformanceGuardian$UseCase[useCase.ordinal()];
                    if (i == 1) {
                        updateActivityMap(useCase, str, activityProcessTimeMapCodeless, bannedCodelessActivitySet);
                    } else if (i == 2) {
                        updateActivityMap(useCase, str, activityProcessTimeMapSe, bannedSuggestedEventActivitySet);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private static void updateActivityMap(UseCase useCase, String str, Map<String, Integer> map, Set<String> set) {
        Class<PerformanceGuardian> cls = PerformanceGuardian.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            int i = 0;
            try {
                if (map.containsKey(str)) {
                    i = map.get(str).intValue();
                }
                int i2 = i + 1;
                map.put(str, Integer.valueOf(i2));
                if (i2 >= MAX_EXCEED_LIMIT_COUNT.intValue()) {
                    set.add(str);
                    sharedPreferences.edit().putStringSet(useCase.toString(), set).putString(CACHE_APP_VERSION, Utility.getAppVersion()).apply();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private static boolean isCacheValid(String str) {
        Class<PerformanceGuardian> cls = PerformanceGuardian.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            String appVersion = Utility.getAppVersion();
            if (appVersion != null) {
                if (!str.isEmpty()) {
                    return str.equals(appVersion);
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }
}
