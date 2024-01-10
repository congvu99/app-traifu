package com.facebook.appevents.suggestedevents;

import android.content.SharedPreferences;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

final class PredictionHistoryManager {
    private static final String CLICKED_PATH_STORE = "com.facebook.internal.SUGGESTED_EVENTS_HISTORY";
    private static final String SUGGESTED_EVENTS_HISTORY = "SUGGESTED_EVENTS_HISTORY";
    private static final Map<String, String> clickedViewPaths = new HashMap();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static SharedPreferences shardPreferences;

    PredictionHistoryManager() {
    }

    private static void initAndWait() {
        Class<PredictionHistoryManager> cls = PredictionHistoryManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (!initialized.get()) {
                    SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(CLICKED_PATH_STORE, 0);
                    shardPreferences = sharedPreferences;
                    clickedViewPaths.putAll(Utility.jsonStrToMap(sharedPreferences.getString(SUGGESTED_EVENTS_HISTORY, "")));
                    initialized.set(true);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    static void addPrediction(String str, String str2) {
        Class<PredictionHistoryManager> cls = PredictionHistoryManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (!initialized.get()) {
                    initAndWait();
                }
                clickedViewPaths.put(str, str2);
                shardPreferences.edit().putString(SUGGESTED_EVENTS_HISTORY, Utility.mapToJsonStr(clickedViewPaths)).apply();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:3|4|5|6|7|(1:9)|17|10|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0030 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String getPathID(android.view.View r4, java.lang.String r5) {
        /*
            java.lang.Class<com.facebook.appevents.suggestedevents.PredictionHistoryManager> r0 = com.facebook.appevents.suggestedevents.PredictionHistoryManager.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0039 }
            r1.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r3 = "text"
            r1.put(r3, r5)     // Catch:{ JSONException -> 0x0030 }
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0030 }
            r5.<init>()     // Catch:{ JSONException -> 0x0030 }
        L_0x0019:
            if (r4 == 0) goto L_0x002b
            java.lang.Class r3 = r4.getClass()     // Catch:{ JSONException -> 0x0030 }
            java.lang.String r3 = r3.getSimpleName()     // Catch:{ JSONException -> 0x0030 }
            r5.put(r3)     // Catch:{ JSONException -> 0x0030 }
            android.view.ViewGroup r4 = com.facebook.appevents.codeless.internal.ViewHierarchy.getParentOfView(r4)     // Catch:{ JSONException -> 0x0030 }
            goto L_0x0019
        L_0x002b:
            java.lang.String r4 = "classname"
            r1.put(r4, r5)     // Catch:{ JSONException -> 0x0030 }
        L_0x0030:
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0039 }
            java.lang.String r4 = com.facebook.internal.Utility.sha256hash((java.lang.String) r4)     // Catch:{ all -> 0x0039 }
            return r4
        L_0x0039:
            r4 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r4, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.suggestedevents.PredictionHistoryManager.getPathID(android.view.View, java.lang.String):java.lang.String");
    }

    static String queryEvent(String str) {
        Class<PredictionHistoryManager> cls = PredictionHistoryManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (clickedViewPaths.containsKey(str)) {
                return clickedViewPaths.get(str);
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }
}
