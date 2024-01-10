package com.trainerfu.android;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.facebook.appevents.AppEventsLogger;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.MaterialModule;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.BrandedIAPUtil;
import com.trainerfu.utils.DateUtils;
import io.intercom.android.sdk.Intercom;
import java.util.HashMap;
import java.util.List;
import org.apache.http.Header;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

public class MyApplication extends MultiDexApplication implements PurchasesUpdatedListener {
    private static Context context = null;
    public static boolean isRunningFastlaneTest = false;
    /* access modifiers changed from: private */
    public BillingClient billingClient;
    /* access modifiers changed from: private */
    public BrandedIAPTransaction currentBrandedIAPTransaction = null;
    /* access modifiers changed from: private */
    public boolean didSyncPurchaseData = false;
    private boolean isIAPActivityActive = false;
    private Activity mCurrentActivity = null;

    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        Iconify.with(new FontAwesomeModule()).with(new MaterialModule());
        AppEventsLogger.activateApp((Application) this);
        initializeBilling();
        Intercom.initialize(this, "android_sdk-df9cbb493de10c67effb621a4e6165a9d706987e", "y3yci76p");
    }

    public static Context getAppContext() {
        return context;
    }

    public Activity getCurrentActivity() {
        return this.mCurrentActivity;
    }

    public void setCurrentActivity(Activity activity) {
        this.mCurrentActivity = activity;
    }

    public void setCurrentBrandedIAPTransaction(BrandedIAPTransaction brandedIAPTransaction) {
        this.currentBrandedIAPTransaction = brandedIAPTransaction;
    }

    private void initializeBilling() {
        BillingClient build = BillingClient.newBuilder(this).setListener(this).enablePendingPurchases().build();
        this.billingClient = build;
        build.startConnection(new BillingClientStateListener() {
            public void onBillingServiceDisconnected() {
            }

            public void onBillingSetupFinished(BillingResult billingResult) {
                if (billingResult.getResponseCode() == 0 && !MyApplication.this.didSyncPurchaseData) {
                    MyApplication.this.syncPurchaseData();
                }
            }
        });
    }

    public BillingClient getBillingClient() {
        return this.billingClient;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context2) {
        super.attachBaseContext(context2);
        MultiDex.install(this);
    }

    public void onPurchasesUpdated(BillingResult billingResult, List<Purchase> list) {
        if (billingResult.getResponseCode() == 0) {
            handleTrainerfuIAP(billingResult, list);
        } else {
            billingResult.getResponseCode();
        }
    }

    private void handleTrainerfuIAP(BillingResult billingResult, List<Purchase> list) {
        if (list != null) {
            Purchase purchase = list.get(0);
            try {
                if (purchase.getPurchaseState() == 1) {
                    if (!purchase.isAcknowledged()) {
                        this.billingClient.acknowledgePurchase(AcknowledgePurchaseParams.newBuilder().setPurchaseToken(purchase.getPurchaseToken()).build(), new AcknowledgePurchaseResponseListener() {
                            public void onAcknowledgePurchaseResponse(BillingResult billingResult) {
                            }
                        });
                    }
                    JSONObject jSONObject = new JSONObject(purchase.getOriginalJson());
                    HashMap hashMap = new HashMap();
                    hashMap.put("purchase_data", jSONObject);
                    new BaseHttpClient(false, (Activity) null).put("/in_app_transactions/new/android", hashMap, new BaseResponseHandler() {
                        public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                            EventBus.getDefault().post(new SubscriptionPlanChangedEvent(true));
                            return true;
                        }

                        public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                            EventBus.getDefault().post(new SubscriptionPlanChangedEvent(false));
                            return true;
                        }
                    });
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void handleBrandedIAP(BillingResult billingResult, List<Purchase> list) {
        if (list != null) {
            final Purchase purchase = list.get(0);
            try {
                if (purchase.getPurchaseState() == 1) {
                    JSONObject jSONObject = new JSONObject(purchase.getOriginalJson());
                    HashMap hashMap = new HashMap();
                    hashMap.put("android_receipt", jSONObject);
                    hashMap.put("transaction_type", Integer.valueOf(this.currentBrandedIAPTransaction.transactionType.getMask()));
                    hashMap.put("internal_app_id", BrandedIAPUtil.getInternalAppId());
                    if (this.currentBrandedIAPTransaction.transactionType == BrandedIAPTransactionType.NEW_PURCHASE) {
                        hashMap.put("first_name", this.currentBrandedIAPTransaction.firstName);
                        hashMap.put("last_name", this.currentBrandedIAPTransaction.lastName);
                        hashMap.put("email", this.currentBrandedIAPTransaction.email);
                        hashMap.put("password", this.currentBrandedIAPTransaction.password);
                        hashMap.put("date", DateUtils.getISOFormattedDate(DateUtils.getTodaysDate()));
                    }
                    new BaseHttpClient(false, (Activity) null).put("/branded_in_app_transactions/new", hashMap, new BaseResponseHandler() {
                        public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                            if (!purchase.isAcknowledged()) {
                                MyApplication.this.billingClient.consumeAsync(ConsumeParams.newBuilder().setPurchaseToken(purchase.getPurchaseToken()).build(), new ConsumeResponseListener() {
                                    public void onConsumeResponse(BillingResult billingResult, String str) {
                                    }
                                });
                            }
                            EventBus.getDefault().post(new BrandedIAPCompleted(MyApplication.this.currentBrandedIAPTransaction.transactionType.getMask()));
                            BrandedIAPTransaction unused = MyApplication.this.currentBrandedIAPTransaction = null;
                            return true;
                        }

                        public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                            BrandedIAPTransaction unused = MyApplication.this.currentBrandedIAPTransaction = null;
                            return true;
                        }
                    });
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* access modifiers changed from: private */
    public void syncPurchaseData() {
        if (!this.didSyncPurchaseData) {
            this.billingClient.queryPurchasesAsync(BillingClient.SkuType.SUBS, new PurchasesResponseListener() {
                public void onQueryPurchasesResponse(BillingResult billingResult, final List<Purchase> list) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            int i = 0;
                            while (i < list.size()) {
                                try {
                                    JSONObject jSONObject = new JSONObject(((Purchase) list.get(i)).getOriginalJson());
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("purchase_data", jSONObject);
                                    new BaseHttpClient().put("/in_app_transactions/new/android", hashMap, new BaseResponseHandler() {
                                        public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                                            return true;
                                        }

                                        public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                                            boolean unused = MyApplication.this.didSyncPurchaseData = true;
                                            return true;
                                        }
                                    });
                                    i++;
                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    });
                }
            });
        }
    }

    public boolean getIsIAPActivityActive() {
        return this.isIAPActivityActive;
    }

    public void setIsIAPActivityActive(boolean z) {
        this.isIAPActivityActive = z;
    }
}
