package com.trainerfu.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.facebook.internal.ServerProtocol;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;
import com.trainerfu.android.BuildConfig;
import com.trainerfu.android.HelloActivity;
import com.trainerfu.android.MyApplication;
import com.trainerfu.android.R;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

public class BaseHttpClient {
    public static final String API_VERSION = "13";
    private static String version;
    private AsyncHttpClient client;
    private Boolean showSpinner;
    private Activity spinnerContext;

    public BaseHttpClient() {
        this(false, (Activity) null);
    }

    public BaseHttpClient(Boolean bool, Activity activity) {
        if (!bool.booleanValue() || activity != null) {
            AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
            this.client = asyncHttpClient;
            asyncHttpClient.setTimeout(HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
            this.client.setCookieStore(new PersistentCookieStore(MyApplication.getAppContext()));
            this.showSpinner = bool;
            this.spinnerContext = activity;
            if (version == null) {
                Context appContext = MyApplication.getAppContext();
                try {
                    version = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0).versionName;
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
        } else {
            throw new IllegalArgumentException("progressContext cannot be null");
        }
    }

    private void onStart(BaseResponseHandler baseResponseHandler) {
        if (this.showSpinner.booleanValue()) {
            View inflate = View.inflate(this.spinnerContext, R.layout.progressbar_view, (ViewGroup) null);
            ((ViewGroup) this.spinnerContext.getWindow().getDecorView().findViewById(16908290)).addView(inflate);
            ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.progress);
            int color = this.spinnerContext.getResources().getColor(R.color.lightGrayColor);
            progressBar.setIndeterminateTintList(ColorStateList.valueOf(color));
            ProgressBar progressBar2 = (ProgressBar) this.spinnerContext.getWindow().getDecorView().findViewById(R.id.progress);
            if (progressBar2 != null) {
                progressBar2.setVisibility(0);
                progressBar2.setIndeterminateTintList(ColorStateList.valueOf(color));
            } else {
                progressBar.setVisibility(0);
            }
            baseResponseHandler.setSpinnerContext(this.spinnerContext);
            baseResponseHandler.setProgressBarView(progressBar);
        }
    }

    public RequestHandle getExternal(String str, Map<String, Object> map, BaseResponseHandler baseResponseHandler) {
        onStart(baseResponseHandler);
        return this.client.get(str, getParams(map), (ResponseHandlerInterface) baseResponseHandler);
    }

    public RequestHandle get(String str, Map<String, Object> map, BaseResponseHandler baseResponseHandler) {
        onStart(baseResponseHandler);
        return this.client.get(getUrl(str), getParams(map), (ResponseHandlerInterface) baseResponseHandler);
    }

    public RequestHandle put(String str, Map<String, Object> map, BaseResponseHandler baseResponseHandler) {
        onStart(baseResponseHandler);
        return this.client.put(MyApplication.getAppContext(), getUrl(str), getJsonEntity(map), RequestParams.APPLICATION_JSON, baseResponseHandler);
    }

    public RequestHandle post(String str, Map<String, Object> map, BaseResponseHandler baseResponseHandler) {
        onStart(baseResponseHandler);
        return this.client.post(MyApplication.getAppContext(), getUrl(str), getJsonEntity(map), RequestParams.APPLICATION_JSON, baseResponseHandler);
    }

    public RequestHandle postWithImage(String str, Map<String, Object> map, Bitmap bitmap, BaseResponseHandler baseResponseHandler) {
        onStart(baseResponseHandler);
        RequestParams params = getParams(map);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        params.put("image", (InputStream) new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), "image.jpg");
        return this.client.post(MyApplication.getAppContext(), getUrl(str), params, baseResponseHandler);
    }

    public RequestHandle delete(String str, BaseResponseHandler baseResponseHandler) {
        onStart(baseResponseHandler);
        return delete(str, (Map<String, Object>) null, baseResponseHandler);
    }

    public RequestHandle delete(String str, Map<String, Object> map, BaseResponseHandler baseResponseHandler) {
        onStart(baseResponseHandler);
        RequestParams requestParams = new RequestParams();
        requestParams.put(GC.API_VERSION, API_VERSION);
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                requestParams.put((String) next.getKey(), next.getValue());
            }
        }
        return this.client.delete(MyApplication.getAppContext(), getUrl(str), (Header[]) null, requestParams, (ResponseHandlerInterface) baseResponseHandler);
    }

    private String getUrl(String str) {
        try {
            return new URL(new URL(BuildConfig.ROOT_URL), str).toString();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private StringEntity getJsonEntity(Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(GC.API_VERSION, API_VERSION);
        String str = version;
        if (str != null) {
            map.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, str);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry next : map.entrySet()) {
                jSONObject.put((String) next.getKey(), next.getValue());
            }
            return new StringEntity(jSONObject.toString(), "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private RequestParams getParams(Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(GC.API_VERSION, API_VERSION);
        String str = version;
        if (str != null) {
            map.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, str);
        }
        RequestParams requestParams = new RequestParams();
        for (Map.Entry next : map.entrySet()) {
            String str2 = (String) next.getKey();
            next.getValue();
            requestParams.put((String) next.getKey(), next.getValue());
        }
        return requestParams;
    }

    public static void clearCookies() {
        new PersistentCookieStore(MyApplication.getAppContext()).clear();
    }

    public static void logout(final Context context, final Activity activity, boolean z) {
        HashMap hashMap;
        String registrationId = new Push(context).getRegistrationId();
        if (!registrationId.isEmpty()) {
            hashMap = new HashMap();
            hashMap.put("device_token", registrationId);
        } else {
            hashMap = null;
        }
        new BaseHttpClient(Boolean.valueOf(z), activity).delete("access_tokens/my_token", hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                Intent intent = new Intent(context, HelloActivity.class);
                intent.addFlags(268468224);
                context.startActivity(intent);
                Activity activity = activity;
                if (activity == null) {
                    return true;
                }
                activity.finish();
                return true;
            }
        });
    }
}
