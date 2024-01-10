package com.trainerfu.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.trainerfu.android.BuildConfig;
import com.trainerfu.android.MyApplication;
import com.trainerfu.android.R;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class BrandedIAPUtil {
    private static BrandedIAPUtil mInstance;
    private JSONObject iapInfo = null;
    /* access modifiers changed from: private */
    public SkuDetails skuDetails = null;

    public interface BrandedIAPInfoHandler {
        void handleIAPInfo(JSONObject jSONObject);
    }

    public interface BrandedSKUHandler {
        void handleSKU(SkuDetails skuDetails);
    }

    public void getIAPInfo(BrandedIAPInfoHandler brandedIAPInfoHandler) {
    }

    public boolean hasIAP(JSONObject jSONObject) {
        return false;
    }

    private BrandedIAPUtil() {
    }

    public static BrandedIAPUtil getInstance() {
        if (mInstance == null) {
            mInstance = new BrandedIAPUtil();
        }
        return mInstance;
    }

    public static String getInternalAppId() {
        return BuildConfig.APPLICATION_ID.split(Pattern.quote("."))[2];
    }

    public void getSKU(final BrandedSKUHandler brandedSKUHandler) {
        SkuDetails skuDetails2 = this.skuDetails;
        if (skuDetails2 != null) {
            brandedSKUHandler.handleSKU(skuDetails2);
            return;
        }
        BillingClient billingClient = ((MyApplication) MyApplication.getAppContext()).getBillingClient();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add("branded_app_premium");
            SkuDetailsParams.Builder newBuilder = SkuDetailsParams.newBuilder();
            newBuilder.setSkusList(arrayList).setType(BillingClient.SkuType.INAPP);
            billingClient.querySkuDetailsAsync(newBuilder.build(), new SkuDetailsResponseListener() {
                public void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> list) {
                    if (list != null && list.size() != 0) {
                        final SkuDetails skuDetails = list.get(0);
                        SkuDetails unused = BrandedIAPUtil.this.skuDetails = skuDetails;
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                brandedSKUHandler.handleSKU(skuDetails);
                            }
                        });
                    }
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void handleExpiredIAPAccount(final Context context) {
        BrandedIAPUtil instance = getInstance();
        instance.getIAPInfo(new BrandedIAPInfoHandler(instance) {
            final /* synthetic */ BrandedIAPUtil val$brandedIAPUtil;

            {
                this.val$brandedIAPUtil = r1;
            }

            public void handleIAPInfo(JSONObject jSONObject) {
                this.val$brandedIAPUtil.hasIAP(jSONObject);
                BaseHttpClient.logout(context, (Activity) null, false);
                Util.showToast(context, R.string.AccountDeActivated);
            }
        });
    }
}
