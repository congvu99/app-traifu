package com.facebook.appevents.ml;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ModelManager {
    private static final String ASSET_URI_KEY = "asset_uri";
    private static final String CACHE_KEY_MODELS = "models";
    private static final String CACHE_KEY_REQUEST_TIMESTAMP = "model_request_timestamp";
    private static final String MODEL_ASSERT_STORE = "com.facebook.internal.MODEL_STORE";
    private static final Integer MODEL_REQUEST_INTERVAL_MILLISECONDS = Integer.valueOf(UrlImageViewHelper.CACHE_DURATION_THREE_DAYS);
    private static final List<String> MTML_INTEGRITY_DETECT_PREDICTION = Arrays.asList(new String[]{"none", IntegrityManager.INTEGRITY_TYPE_ADDRESS, IntegrityManager.INTEGRITY_TYPE_HEALTH});
    private static final List<String> MTML_SUGGESTED_EVENTS_PREDICTION = Arrays.asList(new String[]{"other", AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION, AppEventsConstants.EVENT_NAME_ADDED_TO_CART, AppEventsConstants.EVENT_NAME_PURCHASED, AppEventsConstants.EVENT_NAME_INITIATED_CHECKOUT});
    private static final String MTML_USE_CASE = "MTML";
    private static final String RULES_URI_KEY = "rules_uri";
    private static final String SDK_MODEL_ASSET = "%s/model_asset";
    private static final String THRESHOLD_KEY = "thresholds";
    private static final String USE_CASE_KEY = "use_case";
    private static final String VERSION_ID_KEY = "version_id";
    private static final Map<String, TaskHandler> mTaskHandlers = new ConcurrentHashMap();

    static /* synthetic */ boolean access$000(long j) {
        Class<ModelManager> cls = ModelManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            return isValidTimestamp(j);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    static /* synthetic */ JSONObject access$100() {
        Class<ModelManager> cls = ModelManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return fetchModels();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static /* synthetic */ void access$200(JSONObject jSONObject) {
        Class<ModelManager> cls = ModelManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                addModels(jSONObject);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    static /* synthetic */ void access$300() {
        Class<ModelManager> cls = ModelManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                enableMTML();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    static /* synthetic */ float[] access$400(JSONArray jSONArray) {
        Class<ModelManager> cls = ModelManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return parseJsonArray(jSONArray);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    /* renamed from: com.facebook.appevents.ml.ModelManager$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$appevents$ml$ModelManager$Task;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.facebook.appevents.ml.ModelManager$Task[] r0 = com.facebook.appevents.ml.ModelManager.Task.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$appevents$ml$ModelManager$Task = r0
                com.facebook.appevents.ml.ModelManager$Task r1 = com.facebook.appevents.ml.ModelManager.Task.MTML_INTEGRITY_DETECT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$appevents$ml$ModelManager$Task     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.appevents.ml.ModelManager$Task r1 = com.facebook.appevents.ml.ModelManager.Task.MTML_APP_EVENT_PREDICTION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.ml.ModelManager.AnonymousClass4.<clinit>():void");
        }
    }

    public enum Task {
        MTML_INTEGRITY_DETECT,
        MTML_APP_EVENT_PREDICTION;

        public String toKey() {
            int i = AnonymousClass4.$SwitchMap$com$facebook$appevents$ml$ModelManager$Task[ordinal()];
            if (i != 1) {
                return i != 2 ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : "app_event_pred";
            }
            return "integrity_detect";
        }

        public String toUseCase() {
            int i = AnonymousClass4.$SwitchMap$com$facebook$appevents$ml$ModelManager$Task[ordinal()];
            if (i == 1) {
                return "MTML_INTEGRITY_DETECT";
            }
            if (i != 2) {
                return null;
            }
            return "MTML_APP_EVENT_PRED";
        }
    }

    public static void enable() {
        Class<ModelManager> cls = ModelManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Utility.runOnNonUiThread(new Runnable() {
                    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f A[Catch:{ Exception -> 0x0072, all -> 0x006e }, RETURN] */
                    /* JADX WARNING: Removed duplicated region for block: B:20:0x0050 A[Catch:{ Exception -> 0x0072, all -> 0x006e }] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r7 = this;
                            java.lang.String r0 = "model_request_timestamp"
                            java.lang.String r1 = "models"
                            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r7)
                            if (r2 == 0) goto L_0x000b
                            return
                        L_0x000b:
                            android.content.Context r2 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ Exception -> 0x0072, all -> 0x006e }
                            java.lang.String r3 = "com.facebook.internal.MODEL_STORE"
                            r4 = 0
                            android.content.SharedPreferences r2 = r2.getSharedPreferences(r3, r4)     // Catch:{ Exception -> 0x0072, all -> 0x006e }
                            r3 = 0
                            java.lang.String r3 = r2.getString(r1, r3)     // Catch:{ Exception -> 0x0072, all -> 0x006e }
                            if (r3 == 0) goto L_0x002a
                            boolean r4 = r3.isEmpty()     // Catch:{ Exception -> 0x0072, all -> 0x006e }
                            if (r4 == 0) goto L_0x0024
                            goto L_0x002a
                        L_0x0024:
                            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0072, all -> 0x006e }
                            r4.<init>(r3)     // Catch:{ Exception -> 0x0072, all -> 0x006e }
                            goto L_0x002f
                        L_0x002a:
                            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0072, all -> 0x006e }
                            r4.<init>()     // Catch:{ Exception -> 0x0072, all -> 0x006e }
                        L_0x002f:
                            r5 = 0
                            long r5 = r2.getLong(r0, r5)     // Catch:{ Exception -> 0x0072, all -> 0x006e }
                            com.facebook.internal.FeatureManager$Feature r3 = com.facebook.internal.FeatureManager.Feature.ModelRequest     // Catch:{ Exception -> 0x0072, all -> 0x006e }
                            boolean r3 = com.facebook.internal.FeatureManager.isEnabled(r3)     // Catch:{ Exception -> 0x0072, all -> 0x006e }
                            if (r3 == 0) goto L_0x0049
                            int r3 = r4.length()     // Catch:{ Exception -> 0x0072, all -> 0x006e }
                            if (r3 == 0) goto L_0x0049
                            boolean r3 = com.facebook.appevents.ml.ModelManager.access$000(r5)     // Catch:{ Exception -> 0x0072, all -> 0x006e }
                            if (r3 != 0) goto L_0x0067
                        L_0x0049:
                            org.json.JSONObject r4 = com.facebook.appevents.ml.ModelManager.access$100()     // Catch:{ Exception -> 0x0072, all -> 0x006e }
                            if (r4 != 0) goto L_0x0050
                            return
                        L_0x0050:
                            android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch:{ Exception -> 0x0072, all -> 0x006e }
                            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0072, all -> 0x006e }
                            android.content.SharedPreferences$Editor r1 = r2.putString(r1, r3)     // Catch:{ Exception -> 0x0072, all -> 0x006e }
                            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0072, all -> 0x006e }
                            android.content.SharedPreferences$Editor r0 = r1.putLong(r0, r2)     // Catch:{ Exception -> 0x0072, all -> 0x006e }
                            r0.apply()     // Catch:{ Exception -> 0x0072, all -> 0x006e }
                        L_0x0067:
                            com.facebook.appevents.ml.ModelManager.access$200(r4)     // Catch:{ Exception -> 0x0072, all -> 0x006e }
                            com.facebook.appevents.ml.ModelManager.access$300()     // Catch:{ Exception -> 0x0072, all -> 0x006e }
                            goto L_0x0072
                        L_0x006e:
                            r0 = move-exception
                            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r7)
                        L_0x0072:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.ml.ModelManager.AnonymousClass1.run():void");
                    }
                });
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private static boolean isValidTimestamp(long j) {
        Class<ModelManager> cls = ModelManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls) || j == 0) {
            return false;
        }
        try {
            return System.currentTimeMillis() - j < ((long) MODEL_REQUEST_INTERVAL_MILLISECONDS.intValue());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    private static void addModels(JSONObject jSONObject) {
        Class<ModelManager> cls = ModelManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        TaskHandler build = TaskHandler.build(jSONObject.getJSONObject(keys.next()));
                        if (build != null) {
                            mTaskHandlers.put(build.useCase, build);
                        }
                    } catch (JSONException unused) {
                        return;
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:16|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
        return new org.json.JSONObject();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0065 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static org.json.JSONObject parseRawJsonObject(org.json.JSONObject r12) {
        /*
            java.lang.String r0 = "asset_uri"
            java.lang.String r1 = "thresholds"
            java.lang.String r2 = "version_id"
            java.lang.Class<com.facebook.appevents.ml.ModelManager> r3 = com.facebook.appevents.ml.ModelManager.class
            java.lang.String r4 = "rules_uri"
            java.lang.String r5 = "use_case"
            boolean r6 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r3)
            r7 = 0
            if (r6 == 0) goto L_0x0016
            return r7
        L_0x0016:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x006b }
            r6.<init>()     // Catch:{ all -> 0x006b }
            java.lang.String r8 = "data"
            org.json.JSONArray r12 = r12.getJSONArray(r8)     // Catch:{ JSONException -> 0x0065 }
            r8 = 0
        L_0x0022:
            int r9 = r12.length()     // Catch:{ JSONException -> 0x0065 }
            if (r8 >= r9) goto L_0x0064
            org.json.JSONObject r9 = r12.getJSONObject(r8)     // Catch:{ JSONException -> 0x0065 }
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0065 }
            r10.<init>()     // Catch:{ JSONException -> 0x0065 }
            java.lang.String r11 = r9.getString(r2)     // Catch:{ JSONException -> 0x0065 }
            r10.put(r2, r11)     // Catch:{ JSONException -> 0x0065 }
            java.lang.String r11 = r9.getString(r5)     // Catch:{ JSONException -> 0x0065 }
            r10.put(r5, r11)     // Catch:{ JSONException -> 0x0065 }
            org.json.JSONArray r11 = r9.getJSONArray(r1)     // Catch:{ JSONException -> 0x0065 }
            r10.put(r1, r11)     // Catch:{ JSONException -> 0x0065 }
            java.lang.String r11 = r9.getString(r0)     // Catch:{ JSONException -> 0x0065 }
            r10.put(r0, r11)     // Catch:{ JSONException -> 0x0065 }
            boolean r11 = r9.has(r4)     // Catch:{ JSONException -> 0x0065 }
            if (r11 == 0) goto L_0x005a
            java.lang.String r11 = r9.getString(r4)     // Catch:{ JSONException -> 0x0065 }
            r10.put(r4, r11)     // Catch:{ JSONException -> 0x0065 }
        L_0x005a:
            java.lang.String r9 = r9.getString(r5)     // Catch:{ JSONException -> 0x0065 }
            r6.put(r9, r10)     // Catch:{ JSONException -> 0x0065 }
            int r8 = r8 + 1
            goto L_0x0022
        L_0x0064:
            return r6
        L_0x0065:
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ all -> 0x006b }
            r12.<init>()     // Catch:{ all -> 0x006b }
            return r12
        L_0x006b:
            r12 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r12, r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.ml.ModelManager.parseRawJsonObject(org.json.JSONObject):org.json.JSONObject");
    }

    private static JSONObject fetchModels() {
        Class<ModelManager> cls = ModelManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            String[] strArr = {USE_CASE_KEY, VERSION_ID_KEY, ASSET_URI_KEY, RULES_URI_KEY, THRESHOLD_KEY};
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, TextUtils.join(",", strArr));
            GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest((AccessToken) null, String.format(SDK_MODEL_ASSET, new Object[]{FacebookSdk.getApplicationId()}), (GraphRequest.Callback) null);
            newGraphPathRequest.setSkipClientToken(true);
            newGraphPathRequest.setParameters(bundle);
            JSONObject jSONObject = newGraphPathRequest.executeAndWait().getJSONObject();
            if (jSONObject == null) {
                return null;
            }
            return parseRawJsonObject(jSONObject);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private static void enableMTML() {
        Class<ModelManager> cls = ModelManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                ArrayList arrayList = new ArrayList();
                String str = null;
                int i = 0;
                for (Map.Entry next : mTaskHandlers.entrySet()) {
                    String str2 = (String) next.getKey();
                    if (str2.equals(Task.MTML_APP_EVENT_PREDICTION.toUseCase())) {
                        TaskHandler taskHandler = (TaskHandler) next.getValue();
                        str = taskHandler.assetUri;
                        i = Math.max(i, taskHandler.versionId);
                        if (FeatureManager.isEnabled(FeatureManager.Feature.SuggestedEvents) && isLocaleEnglish()) {
                            arrayList.add(taskHandler.setOnPostExecute(new Runnable() {
                                public void run() {
                                    if (!CrashShieldHandler.isObjectCrashing(this)) {
                                        try {
                                            SuggestedEventsManager.enable();
                                        } catch (Throwable th) {
                                            CrashShieldHandler.handleThrowable(th, this);
                                        }
                                    }
                                }
                            }));
                        }
                    }
                    if (str2.equals(Task.MTML_INTEGRITY_DETECT.toUseCase())) {
                        TaskHandler taskHandler2 = (TaskHandler) next.getValue();
                        String str3 = taskHandler2.assetUri;
                        int max = Math.max(i, taskHandler2.versionId);
                        if (FeatureManager.isEnabled(FeatureManager.Feature.IntelligentIntegrity)) {
                            arrayList.add(taskHandler2.setOnPostExecute(new Runnable() {
                                public void run() {
                                    if (!CrashShieldHandler.isObjectCrashing(this)) {
                                        try {
                                            IntegrityManager.enable();
                                        } catch (Throwable th) {
                                            CrashShieldHandler.handleThrowable(th, this);
                                        }
                                    }
                                }
                            }));
                        }
                        str = str3;
                        i = max;
                    }
                }
                if (str != null && i > 0 && !arrayList.isEmpty()) {
                    TaskHandler.execute(new TaskHandler(MTML_USE_CASE, str, (String) null, i, (float[]) null), arrayList);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private static boolean isLocaleEnglish() {
        Class<ModelManager> cls = ModelManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            Locale resourceLocale = Utility.getResourceLocale();
            if (resourceLocale == null || resourceLocale.getLanguage().contains("en")) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    private static float[] parseJsonArray(JSONArray jSONArray) {
        Class<ModelManager> cls = ModelManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls) || jSONArray == null) {
            return null;
        }
        try {
            float[] fArr = new float[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    fArr[i] = Float.parseFloat(jSONArray.getString(i));
                } catch (JSONException unused) {
                }
            }
            return fArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static File getRuleFile(Task task) {
        Class<ModelManager> cls = ModelManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            TaskHandler taskHandler = mTaskHandlers.get(task.toUseCase());
            if (taskHandler == null) {
                return null;
            }
            return taskHandler.ruleFile;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static String[] predict(Task task, float[][] fArr, String[] strArr) {
        Class<ModelManager> cls = ModelManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            TaskHandler taskHandler = mTaskHandlers.get(task.toUseCase());
            if (taskHandler != null) {
                if (taskHandler.model != null) {
                    int length = strArr.length;
                    int length2 = fArr[0].length;
                    MTensor mTensor = new MTensor(new int[]{length, length2});
                    for (int i = 0; i < length; i++) {
                        System.arraycopy(fArr[i], 0, mTensor.getData(), i * length2, length2);
                    }
                    MTensor predictOnMTML = taskHandler.model.predictOnMTML(mTensor, strArr, task.toKey());
                    float[] fArr2 = taskHandler.thresholds;
                    if (!(predictOnMTML == null || fArr2 == null || predictOnMTML.getData().length == 0)) {
                        if (fArr2.length != 0) {
                            int i2 = AnonymousClass4.$SwitchMap$com$facebook$appevents$ml$ModelManager$Task[task.ordinal()];
                            if (i2 == 1) {
                                return processIntegrityDetectionResult(predictOnMTML, fArr2);
                            }
                            if (i2 != 2) {
                                return null;
                            }
                            return processSuggestedEventResult(predictOnMTML, fArr2);
                        }
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private static String[] processSuggestedEventResult(MTensor mTensor, float[] fArr) {
        Class<ModelManager> cls = ModelManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            int shape = mTensor.getShape(0);
            int shape2 = mTensor.getShape(1);
            float[] data = mTensor.getData();
            String[] strArr = new String[shape];
            if (shape2 != fArr.length) {
                return null;
            }
            for (int i = 0; i < shape; i++) {
                strArr[i] = "other";
                for (int i2 = 0; i2 < fArr.length; i2++) {
                    if (data[(i * shape2) + i2] >= fArr[i2]) {
                        strArr[i] = MTML_SUGGESTED_EVENTS_PREDICTION.get(i2);
                    }
                }
            }
            return strArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private static String[] processIntegrityDetectionResult(MTensor mTensor, float[] fArr) {
        Class<ModelManager> cls = ModelManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            int shape = mTensor.getShape(0);
            int shape2 = mTensor.getShape(1);
            float[] data = mTensor.getData();
            String[] strArr = new String[shape];
            if (shape2 != fArr.length) {
                return null;
            }
            for (int i = 0; i < shape; i++) {
                strArr[i] = "none";
                for (int i2 = 0; i2 < fArr.length; i2++) {
                    if (data[(i * shape2) + i2] >= fArr[i2]) {
                        strArr[i] = MTML_INTEGRITY_DETECT_PREDICTION.get(i2);
                    }
                }
            }
            return strArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private static class TaskHandler {
        String assetUri;
        Model model;
        /* access modifiers changed from: private */
        public Runnable onPostExecute;
        File ruleFile;
        String ruleUri;
        float[] thresholds;
        String useCase;
        int versionId;

        TaskHandler(String str, String str2, String str3, int i, float[] fArr) {
            this.useCase = str;
            this.assetUri = str2;
            this.ruleUri = str3;
            this.versionId = i;
            this.thresholds = fArr;
        }

        /* access modifiers changed from: package-private */
        public TaskHandler setOnPostExecute(Runnable runnable) {
            this.onPostExecute = runnable;
            return this;
        }

        static TaskHandler build(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            try {
                return new TaskHandler(jSONObject.getString(ModelManager.USE_CASE_KEY), jSONObject.getString(ModelManager.ASSET_URI_KEY), jSONObject.optString(ModelManager.RULES_URI_KEY, (String) null), jSONObject.getInt(ModelManager.VERSION_ID_KEY), ModelManager.access$400(jSONObject.getJSONArray(ModelManager.THRESHOLD_KEY)));
            } catch (Exception unused) {
                return null;
            }
        }

        static void execute(TaskHandler taskHandler) {
            execute(taskHandler, Collections.singletonList(taskHandler));
        }

        static void execute(TaskHandler taskHandler, final List<TaskHandler> list) {
            deleteOldFiles(taskHandler.useCase, taskHandler.versionId);
            download(taskHandler.assetUri, taskHandler.useCase + "_" + taskHandler.versionId, new FileDownloadTask.Callback() {
                public void onComplete(File file) {
                    final Model build = Model.build(file);
                    if (build != null) {
                        for (final TaskHandler taskHandler : list) {
                            TaskHandler.download(taskHandler.ruleUri, taskHandler.useCase + "_" + taskHandler.versionId + "_rule", new FileDownloadTask.Callback() {
                                public void onComplete(File file) {
                                    taskHandler.model = build;
                                    taskHandler.ruleFile = file;
                                    if (taskHandler.onPostExecute != null) {
                                        taskHandler.onPostExecute.run();
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }

        private static void deleteOldFiles(String str, int i) {
            File[] listFiles;
            File mlDir = Utils.getMlDir();
            if (mlDir != null && (listFiles = mlDir.listFiles()) != null && listFiles.length != 0) {
                String str2 = str + "_" + i;
                for (File file : listFiles) {
                    String name = file.getName();
                    if (name.startsWith(str) && !name.startsWith(str2)) {
                        file.delete();
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public static void download(String str, String str2, FileDownloadTask.Callback callback) {
            File file = new File(Utils.getMlDir(), str2);
            if (str == null || file.exists()) {
                callback.onComplete(file);
            } else {
                new FileDownloadTask(str, file, callback).execute(new String[0]);
            }
        }
    }
}
