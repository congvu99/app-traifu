package com.trainerfu.android;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.module.annotations.ReactModule;
import com.loopj.android.http.PersistentCookieStore;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.Cookie;

@ReactModule(name = "RNConstants")
public class RNConstants extends ReactContextBaseJavaModule {
    private static String AUTH_COOKIE_NAME = "authtkt";
    private String AUTH_TOKEN = null;

    public String getName() {
        return "RNConstants";
    }

    public RNConstants(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        Date date = null;
        for (Cookie next : new PersistentCookieStore(MyApplication.getAppContext()).getCookies()) {
            if (next.getName().equals(AUTH_COOKIE_NAME)) {
                Date expiryDate = next.getExpiryDate();
                if (date == null || expiryDate.after(date)) {
                    this.AUTH_TOKEN = next.getValue();
                    date = expiryDate;
                }
            }
        }
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("ROOT_URL", BuildConfig.ROOT_URL);
        hashMap.put("PUSHER_KEY", BuildConfig.PUSHER_KEY);
        hashMap.put("TINT_COLOR", "#" + getCurrentActivity().getResources().getString(R.color.tintColor).substring(3));
        String str = this.AUTH_TOKEN;
        if (str != null) {
            hashMap.put("AUTH_TOKEN", str);
            hashMap.put("APP_NAME", getReactApplicationContext().getString(R.string.app_name));
        }
        return hashMap;
    }
}
