package com.trainerfu.android;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.compose.material.TextFieldImplKt;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

public class PricingFragment extends Fragment {
    /* access modifiers changed from: private */
    public static Map<String, SkuDetails> productPrices;
    /* access modifiers changed from: private */
    public PricingListAdapter adapter;
    /* access modifiers changed from: private */
    public SubscriptionPlanType currentSubscriptionPlan;
    /* access modifiers changed from: private */
    public String currentSubscriptionPurchaseToken = null;
    /* access modifiers changed from: private */
    public SubscriptionStatus currentSubscriptionStatus = SubscriptionStatus.TRAILING;
    private ListView pricingList;
    /* access modifiers changed from: private */
    public ArrayList<PlanObj> trainerPlans = new ArrayList<>();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.fragment_pricing, viewGroup, false);
        this.pricingList = (ListView) inflate.findViewById(R.id.pricing_list);
        this.pricingList.addHeaderView(layoutInflater.inflate(R.layout.pricing_list_view_header, (ViewGroup) null, false));
        PricingListAdapter pricingListAdapter = new PricingListAdapter(getActivity());
        this.adapter = pricingListAdapter;
        this.pricingList.setAdapter(pricingListAdapter);
        PlanObj planObj = new PlanObj(1, SubscriptionPlanType.APP_TRAINER_BASIC, "Trainer Basic", 10);
        PlanObj planObj2 = new PlanObj(2, SubscriptionPlanType.APP_TRAINER_STANDARD, "Trainer Standard", 20);
        PlanObj planObj3 = new PlanObj(3, SubscriptionPlanType.APP_TRAINER_PLUS, "Tainer Plus", 40);
        PlanObj planObj4 = new PlanObj(4, SubscriptionPlanType.APP_STUDIO_BASIC, "Studio Basic", 60);
        PlanObj planObj5 = new PlanObj(5, SubscriptionPlanType.APP_STUDIO_STANDARD, "Studio Standard", 80);
        PlanObj planObj6 = new PlanObj(6, SubscriptionPlanType.APP_STUDIO_PLUS, "Studio Plus", 100);
        PlanObj planObj7 = new PlanObj(7, SubscriptionPlanType.APP_GYM, "Gym", TextFieldImplKt.AnimationDuration);
        this.trainerPlans.add(planObj);
        this.trainerPlans.add(planObj2);
        this.trainerPlans.add(planObj3);
        this.trainerPlans.add(planObj4);
        this.trainerPlans.add(planObj5);
        this.trainerPlans.add(planObj6);
        this.trainerPlans.add(planObj7);
        this.adapter.notifyDataSetChanged();
        return inflate;
    }

    public void onResume() {
        super.onResume();
        loadPricingData();
        loadSubscription();
    }

    private void loadPricingData() {
        BillingClient billingClient = ((MyApplication) MyApplication.getAppContext()).getBillingClient();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(SubscriptionPlanType.getProductId(SubscriptionPlanType.APP_TRAINER_BASIC));
            arrayList.add(SubscriptionPlanType.getProductId(SubscriptionPlanType.APP_TRAINER_STANDARD));
            arrayList.add(SubscriptionPlanType.getProductId(SubscriptionPlanType.APP_TRAINER_PLUS));
            arrayList.add(SubscriptionPlanType.getProductId(SubscriptionPlanType.APP_STUDIO_BASIC));
            arrayList.add(SubscriptionPlanType.getProductId(SubscriptionPlanType.APP_STUDIO_STANDARD));
            arrayList.add(SubscriptionPlanType.getProductId(SubscriptionPlanType.APP_STUDIO_PLUS));
            arrayList.add(SubscriptionPlanType.getProductId(SubscriptionPlanType.APP_GYM));
            SkuDetailsParams.Builder newBuilder = SkuDetailsParams.newBuilder();
            newBuilder.setSkusList(arrayList).setType(BillingClient.SkuType.SUBS);
            billingClient.querySkuDetailsAsync(newBuilder.build(), new SkuDetailsResponseListener() {
                public void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> list) {
                    if (PricingFragment.this.isAdded() && list != null && list.size() != 0) {
                        Map unused = PricingFragment.productPrices = new HashMap();
                        for (int i = 0; i < list.size(); i++) {
                            SkuDetails skuDetails = list.get(i);
                            PricingFragment.productPrices.put(skuDetails.getSku(), skuDetails);
                        }
                        PricingFragment.this.getActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                PricingFragment.this.adapter.notifyDataSetChanged();
                            }
                        });
                    }
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void loadSubscription() {
        new BaseHttpClient(false, getActivity()).get("/subscription", (Map<String, Object>) null, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                if (!PricingFragment.this.isAdded()) {
                    return true;
                }
                try {
                    SubscriptionPlanType unused = PricingFragment.this.currentSubscriptionPlan = SubscriptionPlanType.getSubscriptionPlanType(jSONObject.getInt("plan"));
                    String unused2 = PricingFragment.this.currentSubscriptionPurchaseToken = jSONObject.getString("purchase_token");
                    SubscriptionStatus unused3 = PricingFragment.this.currentSubscriptionStatus = SubscriptionStatus.getSubscriptionStatus(jSONObject.getInt("status"));
                    PricingFragment.this.adapter.notifyDataSetChanged();
                    return true;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void changePlan(SubscriptionPlanType subscriptionPlanType) {
        BillingClient billingClient = ((MyApplication) MyApplication.getAppContext()).getBillingClient();
        BillingFlowParams.Builder skuDetails = BillingFlowParams.newBuilder().setSkuDetails(productPrices.get(SubscriptionPlanType.getProductId(subscriptionPlanType)));
        if (SubscriptionPlanType.isAppPremiumPlan(this.currentSubscriptionPlan) && this.currentSubscriptionStatus == SubscriptionStatus.ACTIVE) {
            skuDetails = skuDetails.setSubscriptionUpdateParams(BillingFlowParams.SubscriptionUpdateParams.newBuilder().setOldSkuPurchaseToken(this.currentSubscriptionPurchaseToken).setReplaceSkusProrationMode(1).build());
        }
        billingClient.launchBillingFlow(getActivity(), skuDetails.build());
    }

    private class PricingListAdapter extends BaseAdapter {
        private final Context context;

        public boolean hasStableIds() {
            return true;
        }

        public PricingListAdapter(Context context2) {
            this.context = context2;
        }

        public int getCount() {
            if (PricingFragment.this.trainerPlans == null) {
                return 0;
            }
            return PricingFragment.this.trainerPlans.size();
        }

        public PlanObj getItem(int i) {
            return (PlanObj) PricingFragment.this.trainerPlans.get(i);
        }

        public long getItemId(int i) {
            return (long) getItem(i).getId();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            final PlanObj item = getItem(i);
            View inflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.plan_view, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.plan_name);
            TextView textView2 = (TextView) inflate.findViewById(R.id.plan_price);
            TextView textView3 = (TextView) inflate.findViewById(R.id.plan_clients);
            Button button = (Button) inflate.findViewById(R.id.choosePlanBtn);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    PricingFragment.this.changePlan(item.getType());
                }
            });
            if (PricingFragment.this.currentSubscriptionPlan == null) {
                button.setVisibility(8);
            } else if (PricingFragment.this.currentSubscriptionPlan == item.type && PricingFragment.this.currentSubscriptionStatus == SubscriptionStatus.ACTIVE) {
                button.setBackgroundColor(-3355444);
                button.setText(PricingFragment.this.getActivity().getString(R.string.currentPlan));
                button.setEnabled(false);
            } else if (PricingFragment.this.currentSubscriptionPlan == SubscriptionPlanType.APP_FREEMIUM) {
                button.setText(R.string.sevenDayFreeTrial);
            } else {
                button.setText(R.string.choosePlan);
            }
            if (PricingFragment.productPrices == null) {
                textView2.setText("--");
            } else {
                textView2.setText(String.format("%s/month", new Object[]{((SkuDetails) PricingFragment.productPrices.get(SubscriptionPlanType.getProductId(item.getType()))).getPrice()}));
            }
            textView.setText(item.getPlanName());
            textView3.setText(String.format("%s Clients", new Object[]{Integer.valueOf(item.getClients())}));
            return inflate;
        }
    }

    private static class PlanObj {
        private final int clients;
        private final int id;
        private final String name;
        /* access modifiers changed from: private */
        public final SubscriptionPlanType type;

        public PlanObj(int i, SubscriptionPlanType subscriptionPlanType, String str, int i2) {
            this.id = i;
            this.type = subscriptionPlanType;
            this.name = str;
            this.clients = i2;
        }

        public int getId() {
            return this.id;
        }

        public SubscriptionPlanType getType() {
            return this.type;
        }

        public String getPlanName() {
            return this.name;
        }

        public int getClients() {
            return this.clients;
        }
    }
}
