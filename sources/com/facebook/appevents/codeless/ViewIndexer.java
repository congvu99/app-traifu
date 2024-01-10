package com.facebook.appevents.codeless;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewIndexer {
    private static final String APP_VERSION_PARAM = "app_version";
    private static final String PLATFORM_PARAM = "platform";
    private static final String REQUEST_TYPE = "request_type";
    private static final String SUCCESS = "success";
    private static final String TAG = ViewIndexer.class.getCanonicalName();
    private static final String TREE_PARAM = "tree";
    private static ViewIndexer instance;
    private WeakReference<Activity> activityReference;
    private Timer indexingTimer;
    private String previousDigest = null;
    private final Handler uiThreadHandler = new Handler(Looper.getMainLooper());

    static /* synthetic */ WeakReference access$000(ViewIndexer viewIndexer) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return viewIndexer.activityReference;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static /* synthetic */ Handler access$100(ViewIndexer viewIndexer) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return viewIndexer.uiThreadHandler;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static /* synthetic */ String access$200() {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static /* synthetic */ void access$300(ViewIndexer viewIndexer, String str) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                viewIndexer.sendToServer(str);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    static /* synthetic */ Timer access$400(ViewIndexer viewIndexer) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return viewIndexer.indexingTimer;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static /* synthetic */ Timer access$402(ViewIndexer viewIndexer, Timer timer) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            viewIndexer.indexingTimer = timer;
            return timer;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static /* synthetic */ String access$500(ViewIndexer viewIndexer) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return viewIndexer.previousDigest;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static /* synthetic */ String access$502(ViewIndexer viewIndexer, String str) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            viewIndexer.previousDigest = str;
            return str;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public ViewIndexer(Activity activity) {
        this.activityReference = new WeakReference<>(activity);
        instance = this;
    }

    public void schedule() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                final AnonymousClass1 r0 = new TimerTask() {
                    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x007c */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r7 = this;
                            com.facebook.appevents.codeless.ViewIndexer r0 = com.facebook.appevents.codeless.ViewIndexer.this     // Catch:{ Exception -> 0x0090 }
                            java.lang.ref.WeakReference r0 = com.facebook.appevents.codeless.ViewIndexer.access$000(r0)     // Catch:{ Exception -> 0x0090 }
                            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0090 }
                            android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ Exception -> 0x0090 }
                            android.view.View r1 = com.facebook.appevents.internal.AppEventUtility.getRootView(r0)     // Catch:{ Exception -> 0x0090 }
                            if (r0 == 0) goto L_0x008f
                            if (r1 != 0) goto L_0x0016
                            goto L_0x008f
                        L_0x0016:
                            java.lang.Class r0 = r0.getClass()     // Catch:{ Exception -> 0x0090 }
                            java.lang.String r0 = r0.getSimpleName()     // Catch:{ Exception -> 0x0090 }
                            boolean r2 = com.facebook.appevents.codeless.CodelessManager.getIsAppIndexingEnabled()     // Catch:{ Exception -> 0x0090 }
                            if (r2 != 0) goto L_0x0025
                            return
                        L_0x0025:
                            boolean r2 = com.facebook.internal.InternalSettings.isUnityApp()     // Catch:{ Exception -> 0x0090 }
                            if (r2 == 0) goto L_0x002f
                            com.facebook.appevents.codeless.internal.UnityReflection.captureViewHierarchy()     // Catch:{ Exception -> 0x0090 }
                            return
                        L_0x002f:
                            java.util.concurrent.FutureTask r2 = new java.util.concurrent.FutureTask     // Catch:{ Exception -> 0x0090 }
                            com.facebook.appevents.codeless.ViewIndexer$ScreenshotTaker r3 = new com.facebook.appevents.codeless.ViewIndexer$ScreenshotTaker     // Catch:{ Exception -> 0x0090 }
                            r3.<init>(r1)     // Catch:{ Exception -> 0x0090 }
                            r2.<init>(r3)     // Catch:{ Exception -> 0x0090 }
                            com.facebook.appevents.codeless.ViewIndexer r3 = com.facebook.appevents.codeless.ViewIndexer.this     // Catch:{ Exception -> 0x0090 }
                            android.os.Handler r3 = com.facebook.appevents.codeless.ViewIndexer.access$100(r3)     // Catch:{ Exception -> 0x0090 }
                            r3.post(r2)     // Catch:{ Exception -> 0x0090 }
                            java.lang.String r3 = ""
                            r4 = 1
                            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception -> 0x0050 }
                            java.lang.Object r2 = r2.get(r4, r6)     // Catch:{ Exception -> 0x0050 }
                            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0050 }
                            r3 = r2
                            goto L_0x005a
                        L_0x0050:
                            r2 = move-exception
                            java.lang.String r4 = com.facebook.appevents.codeless.ViewIndexer.access$200()     // Catch:{ Exception -> 0x0090 }
                            java.lang.String r5 = "Failed to take screenshot."
                            android.util.Log.e(r4, r5, r2)     // Catch:{ Exception -> 0x0090 }
                        L_0x005a:
                            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0090 }
                            r2.<init>()     // Catch:{ Exception -> 0x0090 }
                            java.lang.String r4 = "screenname"
                            r2.put(r4, r0)     // Catch:{ JSONException -> 0x007c }
                            java.lang.String r0 = "screenshot"
                            r2.put(r0, r3)     // Catch:{ JSONException -> 0x007c }
                            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x007c }
                            r0.<init>()     // Catch:{ JSONException -> 0x007c }
                            org.json.JSONObject r1 = com.facebook.appevents.codeless.internal.ViewHierarchy.getDictionaryOfView(r1)     // Catch:{ JSONException -> 0x007c }
                            r0.put(r1)     // Catch:{ JSONException -> 0x007c }
                            java.lang.String r1 = "view"
                            r2.put(r1, r0)     // Catch:{ JSONException -> 0x007c }
                            goto L_0x0085
                        L_0x007c:
                            java.lang.String r0 = com.facebook.appevents.codeless.ViewIndexer.access$200()     // Catch:{ Exception -> 0x0090 }
                            java.lang.String r1 = "Failed to create JSONObject"
                            android.util.Log.e(r0, r1)     // Catch:{ Exception -> 0x0090 }
                        L_0x0085:
                            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0090 }
                            com.facebook.appevents.codeless.ViewIndexer r1 = com.facebook.appevents.codeless.ViewIndexer.this     // Catch:{ Exception -> 0x0090 }
                            com.facebook.appevents.codeless.ViewIndexer.access$300(r1, r0)     // Catch:{ Exception -> 0x0090 }
                            goto L_0x009a
                        L_0x008f:
                            return
                        L_0x0090:
                            r0 = move-exception
                            java.lang.String r1 = com.facebook.appevents.codeless.ViewIndexer.access$200()
                            java.lang.String r2 = "UI Component tree indexing failure!"
                            android.util.Log.e(r1, r2, r0)
                        L_0x009a:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.ViewIndexer.AnonymousClass1.run():void");
                    }
                };
                FacebookSdk.getExecutor().execute(new Runnable() {
                    public void run() {
                        if (!CrashShieldHandler.isObjectCrashing(this)) {
                            try {
                                if (ViewIndexer.access$400(ViewIndexer.this) != null) {
                                    ViewIndexer.access$400(ViewIndexer.this).cancel();
                                }
                                ViewIndexer.access$502(ViewIndexer.this, (String) null);
                                ViewIndexer.access$402(ViewIndexer.this, new Timer());
                                ViewIndexer.access$400(ViewIndexer.this).scheduleAtFixedRate(r0, 0, 1000);
                            } catch (Exception e) {
                                Log.e(ViewIndexer.access$200(), "Error scheduling indexing job", e);
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(th, this);
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException e) {
                Log.e(TAG, "Error scheduling indexing job", e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void unschedule() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (((Activity) this.activityReference.get()) != null && this.indexingTimer != null) {
                    this.indexingTimer.cancel();
                    this.indexingTimer = null;
                }
            } catch (Exception e) {
                Log.e(TAG, "Error unscheduling indexing job", e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public static void sendToServerUnityInstance(String str) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (instance != null) {
                    instance.sendToServerUnity(str);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @Deprecated
    public void sendToServerUnity(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                instance.sendToServer(str);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String getPreviousDigest() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.previousDigest;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private void sendToServer(final String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FacebookSdk.getExecutor().execute(new Runnable() {
                    public void run() {
                        if (!CrashShieldHandler.isObjectCrashing(this)) {
                            try {
                                String md5hash = Utility.md5hash(str);
                                AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                                if (md5hash == null || !md5hash.equals(ViewIndexer.access$500(ViewIndexer.this))) {
                                    ViewIndexer.this.processRequest(ViewIndexer.buildAppIndexingRequest(str, currentAccessToken, FacebookSdk.getApplicationId(), Constants.APP_INDEXING), md5hash);
                                }
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(th, this);
                            }
                        }
                    }
                });
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void processRequest(GraphRequest graphRequest, String str) {
        if (!CrashShieldHandler.isObjectCrashing(this) && graphRequest != null) {
            try {
                GraphResponse executeAndWait = graphRequest.executeAndWait();
                JSONObject jSONObject = executeAndWait.getJSONObject();
                if (jSONObject != null) {
                    if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(jSONObject.optString("success"))) {
                        Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Successfully send UI component tree to server");
                        this.previousDigest = str;
                    }
                    if (jSONObject.has(Constants.APP_INDEXING_ENABLED)) {
                        CodelessManager.updateAppIndexing(Boolean.valueOf(jSONObject.getBoolean(Constants.APP_INDEXING_ENABLED)));
                        return;
                    }
                    return;
                }
                String str2 = TAG;
                Log.e(str2, "Error sending UI component tree to Facebook: " + executeAndWait.getError());
            } catch (JSONException e) {
                Log.e(TAG, "Error decoding server response.", e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public static GraphRequest buildAppIndexingRequest(String str, AccessToken accessToken, String str2, String str3) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (CrashShieldHandler.isObjectCrashing(cls) || str == null) {
            return null;
        }
        try {
            GraphRequest newPostRequest = GraphRequest.newPostRequest(accessToken, String.format(Locale.US, "%s/app_indexing", new Object[]{str2}), (JSONObject) null, (GraphRequest.Callback) null);
            Bundle parameters = newPostRequest.getParameters();
            if (parameters == null) {
                parameters = new Bundle();
            }
            parameters.putString(TREE_PARAM, str);
            parameters.putString(APP_VERSION_PARAM, AppEventUtility.getAppVersion());
            parameters.putString(PLATFORM_PARAM, Constants.PLATFORM);
            parameters.putString(REQUEST_TYPE, str3);
            if (str3.equals(Constants.APP_INDEXING)) {
                parameters.putString(Constants.DEVICE_SESSION_ID, CodelessManager.getCurrentDeviceSessionID());
            }
            newPostRequest.setParameters(parameters);
            newPostRequest.setCallback(new GraphRequest.Callback() {
                public void onCompleted(GraphResponse graphResponse) {
                    Logger.log(LoggingBehavior.APP_EVENTS, ViewIndexer.access$200(), "App index sent to FB!");
                }
            });
            return newPostRequest;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private static class ScreenshotTaker implements Callable<String> {
        private WeakReference<View> rootView;

        ScreenshotTaker(View view) {
            this.rootView = new WeakReference<>(view);
        }

        public String call() {
            View view = (View) this.rootView.get();
            if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
                return "";
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            view.draw(new Canvas(createBitmap));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        }
    }
}
