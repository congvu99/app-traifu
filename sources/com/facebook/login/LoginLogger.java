package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginClient;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

class LoginLogger {
    static final String EVENT_EXTRAS_DEFAULT_AUDIENCE = "default_audience";
    static final String EVENT_EXTRAS_FACEBOOK_VERSION = "facebookVersion";
    static final String EVENT_EXTRAS_FAILURE = "failure";
    static final String EVENT_EXTRAS_IS_REAUTHORIZE = "isReauthorize";
    static final String EVENT_EXTRAS_LOGIN_BEHAVIOR = "login_behavior";
    static final String EVENT_EXTRAS_MISSING_INTERNET_PERMISSION = "no_internet_permission";
    static final String EVENT_EXTRAS_NEW_PERMISSIONS = "new_permissions";
    static final String EVENT_EXTRAS_NOT_TRIED = "not_tried";
    static final String EVENT_EXTRAS_PERMISSIONS = "permissions";
    static final String EVENT_EXTRAS_REQUEST_CODE = "request_code";
    static final String EVENT_EXTRAS_TRY_LOGIN_ACTIVITY = "try_login_activity";
    static final String EVENT_NAME_LOGIN_COMPLETE = "fb_mobile_login_complete";
    static final String EVENT_NAME_LOGIN_HEARTBEAT = "fb_mobile_login_heartbeat";
    static final String EVENT_NAME_LOGIN_METHOD_COMPLETE = "fb_mobile_login_method_complete";
    static final String EVENT_NAME_LOGIN_METHOD_NOT_TRIED = "fb_mobile_login_method_not_tried";
    static final String EVENT_NAME_LOGIN_METHOD_START = "fb_mobile_login_method_start";
    static final String EVENT_NAME_LOGIN_START = "fb_mobile_login_start";
    static final String EVENT_NAME_LOGIN_STATUS_COMPLETE = "fb_mobile_login_status_complete";
    static final String EVENT_NAME_LOGIN_STATUS_START = "fb_mobile_login_status_start";
    static final String EVENT_PARAM_AUTH_LOGGER_ID = "0_auth_logger_id";
    static final String EVENT_PARAM_CHALLENGE = "7_challenge";
    static final String EVENT_PARAM_ERROR_CODE = "4_error_code";
    static final String EVENT_PARAM_ERROR_MESSAGE = "5_error_message";
    static final String EVENT_PARAM_EXTRAS = "6_extras";
    static final String EVENT_PARAM_LOGIN_RESULT = "2_result";
    static final String EVENT_PARAM_METHOD = "3_method";
    static final String EVENT_PARAM_METHOD_RESULT_SKIPPED = "skipped";
    static final String EVENT_PARAM_TIMESTAMP = "1_timestamp_ms";
    static final String FACEBOOK_PACKAGE_NAME = "com.facebook.katana";
    private static final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
    private String applicationId;
    private String facebookVersion;
    private final InternalAppEventsLogger logger;

    static /* synthetic */ InternalAppEventsLogger access$000(LoginLogger loginLogger) {
        Class<LoginLogger> cls = LoginLogger.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return loginLogger.logger;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    LoginLogger(Context context, String str) {
        PackageInfo packageInfo;
        this.applicationId = str;
        this.logger = new InternalAppEventsLogger(context, str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(FACEBOOK_PACKAGE_NAME, 0)) != null) {
                this.facebookVersion = packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public String getApplicationId() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.applicationId;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    static Bundle newAuthorizationLoggingBundle(String str) {
        Class<LoginLogger> cls = LoginLogger.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putLong(EVENT_PARAM_TIMESTAMP, System.currentTimeMillis());
            bundle.putString(EVENT_PARAM_AUTH_LOGGER_ID, str);
            bundle.putString(EVENT_PARAM_METHOD, "");
            bundle.putString(EVENT_PARAM_LOGIN_RESULT, "");
            bundle.putString(EVENT_PARAM_ERROR_MESSAGE, "");
            bundle.putString(EVENT_PARAM_ERROR_CODE, "");
            bundle.putString(EVENT_PARAM_EXTRAS, "");
            return bundle;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:3|4|5|6|(1:8)|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0063 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void logStartLogin(com.facebook.login.LoginClient.Request r6) {
        /*
            r5 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r5)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.String r0 = r6.getAuthId()     // Catch:{ all -> 0x006c }
            android.os.Bundle r0 = newAuthorizationLoggingBundle(r0)     // Catch:{ all -> 0x006c }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0063 }
            r1.<init>()     // Catch:{ JSONException -> 0x0063 }
            java.lang.String r2 = "login_behavior"
            com.facebook.login.LoginBehavior r3 = r6.getLoginBehavior()     // Catch:{ JSONException -> 0x0063 }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x0063 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0063 }
            java.lang.String r2 = "request_code"
            int r3 = com.facebook.login.LoginClient.getLoginRequestCode()     // Catch:{ JSONException -> 0x0063 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0063 }
            java.lang.String r2 = "permissions"
            java.lang.String r3 = ","
            java.util.Set r4 = r6.getPermissions()     // Catch:{ JSONException -> 0x0063 }
            java.lang.String r3 = android.text.TextUtils.join(r3, r4)     // Catch:{ JSONException -> 0x0063 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0063 }
            java.lang.String r2 = "default_audience"
            com.facebook.login.DefaultAudience r3 = r6.getDefaultAudience()     // Catch:{ JSONException -> 0x0063 }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x0063 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0063 }
            java.lang.String r2 = "isReauthorize"
            boolean r6 = r6.isRerequest()     // Catch:{ JSONException -> 0x0063 }
            r1.put(r2, r6)     // Catch:{ JSONException -> 0x0063 }
            java.lang.String r6 = r5.facebookVersion     // Catch:{ JSONException -> 0x0063 }
            if (r6 == 0) goto L_0x005a
            java.lang.String r6 = "facebookVersion"
            java.lang.String r2 = r5.facebookVersion     // Catch:{ JSONException -> 0x0063 }
            r1.put(r6, r2)     // Catch:{ JSONException -> 0x0063 }
        L_0x005a:
            java.lang.String r6 = "6_extras"
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x0063 }
            r0.putString(r6, r1)     // Catch:{ JSONException -> 0x0063 }
        L_0x0063:
            com.facebook.appevents.InternalAppEventsLogger r6 = r5.logger     // Catch:{ all -> 0x006c }
            java.lang.String r1 = "fb_mobile_login_start"
            r2 = 0
            r6.logEventImplicitly(r1, r2, r0)     // Catch:{ all -> 0x006c }
            return
        L_0x006c:
            r6 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginLogger.logStartLogin(com.facebook.login.LoginClient$Request):void");
    }

    public void logCompleteLogin(String str, Map<String, String> map, LoginClient.Result.Code code, Map<String, String> map2, Exception exc) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
                if (code != null) {
                    newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, code.getLoggingValue());
                }
                if (!(exc == null || exc.getMessage() == null)) {
                    newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, exc.getMessage());
                }
                JSONObject jSONObject = null;
                if (!map.isEmpty()) {
                    jSONObject = new JSONObject(map);
                }
                if (map2 != null) {
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    try {
                        for (Map.Entry next : map2.entrySet()) {
                            jSONObject.put((String) next.getKey(), next.getValue());
                        }
                    } catch (JSONException unused) {
                    }
                }
                if (jSONObject != null) {
                    newAuthorizationLoggingBundle.putString(EVENT_PARAM_EXTRAS, jSONObject.toString());
                }
                this.logger.logEventImplicitly(EVENT_NAME_LOGIN_COMPLETE, newAuthorizationLoggingBundle);
                if (code == LoginClient.Result.Code.SUCCESS) {
                    logHeartbeatEvent(str);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private void logHeartbeatEvent(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                final Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
                worker.schedule(new Runnable() {
                    public void run() {
                        if (!CrashShieldHandler.isObjectCrashing(this)) {
                            try {
                                LoginLogger.access$000(LoginLogger.this).logEventImplicitly(LoginLogger.EVENT_NAME_LOGIN_HEARTBEAT, newAuthorizationLoggingBundle);
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(th, this);
                            }
                        }
                    }
                }, 5, TimeUnit.SECONDS);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void logAuthorizationMethodStart(String str, String str2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
                this.logger.logEventImplicitly(EVENT_NAME_LOGIN_METHOD_START, newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void logAuthorizationMethodComplete(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
                if (str3 != null) {
                    newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, str3);
                }
                if (str4 != null) {
                    newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, str4);
                }
                if (str5 != null) {
                    newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_CODE, str5);
                }
                if (map != null && !map.isEmpty()) {
                    newAuthorizationLoggingBundle.putString(EVENT_PARAM_EXTRAS, new JSONObject(map).toString());
                }
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
                this.logger.logEventImplicitly(EVENT_NAME_LOGIN_METHOD_COMPLETE, newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void logAuthorizationMethodNotTried(String str, String str2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
                this.logger.logEventImplicitly(EVENT_NAME_LOGIN_METHOD_NOT_TRIED, newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void logLoginStatusStart(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_START, newAuthorizationLoggingBundle(str));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void logLoginStatusSuccess(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, LoginClient.Result.Code.SUCCESS.getLoggingValue());
                this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_COMPLETE, newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void logLoginStatusFailure(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, EVENT_EXTRAS_FAILURE);
                this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_COMPLETE, newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void logLoginStatusError(String str, Exception exc) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, LoginClient.Result.Code.ERROR.getLoggingValue());
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, exc.toString());
                this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_COMPLETE, newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void logUnexpectedError(String str, String str2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                logUnexpectedError(str, str2, "");
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void logUnexpectedError(String str, String str2, String str3) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle("");
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, LoginClient.Result.Code.ERROR.getLoggingValue());
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, str2);
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str3);
                this.logger.logEventImplicitly(str, newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
