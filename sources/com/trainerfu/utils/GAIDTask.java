package com.trainerfu.utils;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.Header;
import org.json.JSONObject;

public class GAIDTask extends AsyncTask<Void, Void, String> {
    private Context context;

    public GAIDTask(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: protected */
    public String doInBackground(Void... voidArr) {
        AdvertisingIdClient.Info info;
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(this.context);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            info = null;
        }
        try {
            return info.getId();
        } catch (NullPointerException unused2) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String str) {
        if (str != null) {
            BaseHttpClient baseHttpClient = new BaseHttpClient();
            String format = String.format("/users/myself/id_for_ad", new Object[0]);
            HashMap hashMap = new HashMap();
            hashMap.put("gaid", str);
            baseHttpClient.put(format, hashMap, new BaseResponseHandler() {
                public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                    return true;
                }

                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    return true;
                }
            });
        }
    }
}
