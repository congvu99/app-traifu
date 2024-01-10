package io.intercom.android.sdk.api;

import android.content.Context;
import android.util.Base64;
import com.facebook.internal.security.CertificateUtil;
import com.intercom.commons.utilities.DeviceUtils;
import io.intercom.android.sdk.BuildConfig;
import io.intercom.android.sdk.identity.AppIdentity;
import java.io.IOException;
import java.util.Random;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

class HeaderInterceptor implements Interceptor {
    private static final String ACCEPT_LANGUAGE = "Accept-Language";
    private static final String ANDROID_HEADER = "intercom-android-sdk/";
    private static final String AUTHORIZATION = "Authorization";
    private static final String CONTENT_TYPE_KEY = "Content-Type";
    private static final String CONTENT_TYPE_VALUE = "application/json";
    private static final String CORDOVA_HEADER = "intercom-sdk-cordova/";
    private static final String CORDOVA_VERSION = "cordova_version";
    private static final String HOST_APP_VERSION_KEY = "X-INTERCOM-HOST-APP-VERSION";
    private static final String IDEMPOTENCY_KEY = "Idempotency-Key";
    private static final String INTERCOM_AGENT = "X-INTERCOM-AGENT";
    private static final String INTERCOM_AGENT_WRAPPER = "X-INTERCOM-AGENT-WRAPPER";
    private static final String REACT_NATIVE_HEADER = "intercom-sdk-react-native/";
    private static final String REACT_NATIVE_VERSION = "react_native_version";
    private static final String SUPPORTED_LANGUAGES_KEY = "X-INTERCOM-SUPPORTED-LANGUAGES";
    private static final String SUPPORTED_LANGUAGE_LIST = "ar,bg,bs,ca,cs,da,de,de-form,el,es,et,fi,fr,he,hr,hu,id,it,ja,ko,lt,lv,mn,nb,nl,pl,pt-PT,pt-BR,ro,ru,sl,sr,sv,tr,uk,vi,zh-Hant,zh-Hans";
    private static final String WRAPPER_PREFS = "intercomsdk_wrapper_prefs";
    private final AppIdentity appIdentity;
    private final String appVersion;
    private final String cordovaVersion;
    private final Random random;
    private final String reactNativeVersion;
    private final String userLocale;
    private final String versionName;

    public static HeaderInterceptor create(Context context, AppIdentity appIdentity2) {
        return new HeaderInterceptor(context.getSharedPreferences(WRAPPER_PREFS, 0).getString(CORDOVA_VERSION, ""), context.getSharedPreferences(WRAPPER_PREFS, 0).getString(REACT_NATIVE_VERSION, ""), BuildConfig.VERSION_NAME, appIdentity2, UserLocaleUtilKt.getUserLocaleString(context), DeviceUtils.getAppVersion(context), new Random());
    }

    HeaderInterceptor(String str, String str2, String str3, AppIdentity appIdentity2, String str4, String str5, Random random2) {
        this.cordovaVersion = str;
        this.reactNativeVersion = str2;
        this.versionName = str3;
        this.appIdentity = appIdentity2;
        this.userLocale = str4;
        this.appVersion = str5;
        this.random = random2;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request.Builder header = chain.request().newBuilder().header("Content-Type", "application/json").header("Authorization", getBasicAuth()).header(IDEMPOTENCY_KEY, Long.toHexString(this.random.nextLong()));
        Request.Builder header2 = header.header(INTERCOM_AGENT, ANDROID_HEADER + this.versionName).header("Accept-Language", this.userLocale).header(SUPPORTED_LANGUAGES_KEY, SUPPORTED_LANGUAGE_LIST).header(HOST_APP_VERSION_KEY, this.appVersion);
        if (!this.cordovaVersion.isEmpty()) {
            header2.header(INTERCOM_AGENT_WRAPPER, CORDOVA_HEADER + this.cordovaVersion);
        }
        if (!this.reactNativeVersion.isEmpty()) {
            header2.header(INTERCOM_AGENT_WRAPPER, REACT_NATIVE_HEADER + this.reactNativeVersion);
        }
        return chain.proceed(header2.build());
    }

    private String getBasicAuth() {
        String str = this.appIdentity.appId() + CertificateUtil.DELIMITER + this.appIdentity.apiKey();
        return "Basic " + Base64.encodeToString(str.getBytes(), 2);
    }

    public static void setCordovaVersion(Context context, String str) {
        context.getSharedPreferences(WRAPPER_PREFS, 0).edit().putString(CORDOVA_VERSION, str).apply();
    }

    public static void setReactNativeVersion(Context context, String str) {
        context.getSharedPreferences(WRAPPER_PREFS, 0).edit().putString(REACT_NATIVE_VERSION, str).apply();
    }
}
