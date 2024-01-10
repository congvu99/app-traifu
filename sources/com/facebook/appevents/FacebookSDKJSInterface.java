package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

class FacebookSDKJSInterface {
    private static final String PARAMETER_FBSDK_PIXEL_REFERRAL = "_fb_pixel_referral_id";
    private static final String PROTOCOL = "fbmq-0.1";
    public static final String TAG = FacebookSDKJSInterface.class.getSimpleName();
    private Context context;

    public FacebookSDKJSInterface(Context context2) {
        this.context = context2;
    }

    private static Bundle jsonToBundle(JSONObject jSONObject) throws JSONException {
        Class<FacebookSDKJSInterface> cls = FacebookSDKJSInterface.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, jSONObject.getString(next));
            }
            return bundle;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        return new android.os.Bundle();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.os.Bundle jsonStringToBundle(java.lang.String r3) {
        /*
            java.lang.Class<com.facebook.appevents.FacebookSDKJSInterface> r0 = com.facebook.appevents.FacebookSDKJSInterface.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0016 }
            r1.<init>(r3)     // Catch:{ JSONException -> 0x0016 }
            android.os.Bundle r3 = jsonToBundle(r1)     // Catch:{ JSONException -> 0x0016 }
            return r3
        L_0x0014:
            r3 = move-exception
            goto L_0x001c
        L_0x0016:
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x0014 }
            r3.<init>()     // Catch:{ all -> 0x0014 }
            return r3
        L_0x001c:
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r3, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.FacebookSDKJSInterface.jsonStringToBundle(java.lang.String):android.os.Bundle");
    }

    @JavascriptInterface
    public void sendEvent(String str, String str2, String str3) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            if (str == null) {
                try {
                    Logger.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "Can't bridge an event without a referral Pixel ID. Check your webview Pixel configuration");
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            } else {
                InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(this.context);
                Bundle jsonStringToBundle = jsonStringToBundle(str3);
                jsonStringToBundle.putString(PARAMETER_FBSDK_PIXEL_REFERRAL, str);
                internalAppEventsLogger.logEvent(str2, jsonStringToBundle);
            }
        }
    }

    @JavascriptInterface
    public String getProtocol() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        return PROTOCOL;
    }
}
