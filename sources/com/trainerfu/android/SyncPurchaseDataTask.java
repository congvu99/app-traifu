package com.trainerfu.android;

import android.os.AsyncTask;
import android.os.Bundle;
import com.android.billingclient.api.BillingClient;
import com.android.vending.billing.IInAppBillingService;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

public class SyncPurchaseDataTask extends AsyncTask<Void, Void, String> {
    private IInAppBillingService service;

    public SyncPurchaseDataTask(IInAppBillingService iInAppBillingService) {
        this.service = iInAppBillingService;
    }

    /* access modifiers changed from: protected */
    public String doInBackground(Void... voidArr) {
        IInAppBillingService iInAppBillingService = this.service;
        if (iInAppBillingService == null) {
            return null;
        }
        try {
            Bundle purchases = iInAppBillingService.getPurchases(3, BuildConfig.APPLICATION_ID, BillingClient.SkuType.SUBS, (String) null);
            if (purchases.getInt("RESPONSE_CODE") == 0) {
                ArrayList<String> stringArrayList = purchases.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = purchases.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                for (int i = 0; i < stringArrayList2.size(); i++) {
                    String str = stringArrayList2.get(i);
                    if (stringArrayList.get(i).equals("trainer_premium_monthly")) {
                        return str;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String str) {
        if (str != null) {
            HashMap hashMap = new HashMap();
            try {
                hashMap.put("purchase_data", new JSONObject(str));
                new BaseHttpClient().put("/in_app_transactions/new/android", hashMap, new BaseResponseHandler() {
                    public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                        return true;
                    }

                    public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                        return true;
                    }
                });
            } catch (JSONException unused) {
            }
        }
    }
}
