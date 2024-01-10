package com.trainerfu.android;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.SkuDetails;
import com.squareup.picasso.Picasso;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BrandedIAPUtil;
import kotlinx.serialization.json.internal.JsonLexerKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppPurchaseActivity extends BaseActivity {
    /* access modifiers changed from: private */
    public TextView descriptionTV;
    private String email;
    private String firstName;
    private BrandedIAPTransactionType iapTransactionType;
    private String lastName;
    private String password;
    /* access modifiers changed from: private */
    public ImageView photoView;
    /* access modifiers changed from: private */
    public TextView priceTV;
    private RelativeLayout pricingBtn;
    /* access modifiers changed from: private */
    public SkuDetails skuDetails;
    /* access modifiers changed from: private */
    public TextView titleTV;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_in_app_purchase);
        this.titleTV = (TextView) findViewById(R.id.title_tv);
        this.descriptionTV = (TextView) findViewById(R.id.description);
        this.priceTV = (TextView) findViewById(R.id.price_tv);
        this.pricingBtn = (RelativeLayout) findViewById(R.id.pricing_btn);
        this.photoView = (ImageView) findViewById(R.id.photo_view);
        Bundle extras = getIntent().getExtras();
        BrandedIAPTransactionType brandedIAPTransactionType = BrandedIAPTransactionType.getBrandedIAPTransactionType(extras.getInt("transaction_type"));
        this.iapTransactionType = brandedIAPTransactionType;
        if (brandedIAPTransactionType == BrandedIAPTransactionType.NEW_PURCHASE) {
            this.firstName = extras.getString("first_name");
            this.lastName = extras.getString("last_name");
            this.email = extras.getString("email");
            this.password = extras.getString("password");
        }
        if (this.iapTransactionType == BrandedIAPTransactionType.NEW_PURCHASE) {
            setTitle("Premium (30 Days)");
        } else if (this.iapTransactionType == BrandedIAPTransactionType.EXTENSION) {
            setTitle("Extend Premium");
        } else {
            setTitle("Reactivate Premium");
        }
        BrandedIAPUtil instance = BrandedIAPUtil.getInstance();
        instance.getIAPInfo(new BrandedIAPUtil.BrandedIAPInfoHandler() {
            public void handleIAPInfo(JSONObject jSONObject) {
                try {
                    InAppPurchaseActivity.this.titleTV.setText(jSONObject.getString("title"));
                    InAppPurchaseActivity.this.descriptionTV.setText(Html.fromHtml(jSONObject.getString("description")));
                    InAppPurchaseActivity.this.descriptionTV.setMovementMethod(LinkMovementMethod.getInstance());
                    String string = jSONObject.getString("background_image_url");
                    if (!string.equals(JsonLexerKt.NULL)) {
                        Picasso.get().load(string).error((int) R.drawable.splash_image).into(InAppPurchaseActivity.this.photoView);
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        this.pricingBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                InAppPurchaseActivity.this.subscribeToPackage();
            }
        });
        instance.getSKU(new BrandedIAPUtil.BrandedSKUHandler() {
            public void handleSKU(SkuDetails skuDetails) {
                InAppPurchaseActivity.this.priceTV.setText(skuDetails.getPrice());
                SkuDetails unused = InAppPurchaseActivity.this.skuDetails = skuDetails;
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        if (this.iapTransactionType != BrandedIAPTransactionType.REACTIVATION) {
            return true;
        }
        getMenuInflater().inflate(R.menu.logout_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.logoutItem) {
            BaseHttpClient.logout((MyApplication) MyApplication.getAppContext(), this, false);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        ((MyApplication) MyApplication.getAppContext()).setIsIAPActivityActive(true);
    }

    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
        ((MyApplication) MyApplication.getAppContext()).setIsIAPActivityActive(false);
    }

    /* access modifiers changed from: private */
    public void subscribeToPackage() {
        if (this.skuDetails != null) {
            MyApplication myApplication = (MyApplication) MyApplication.getAppContext();
            myApplication.setCurrentBrandedIAPTransaction(new BrandedIAPTransaction(this.iapTransactionType, this.firstName, this.lastName, this.email, this.password));
            myApplication.getBillingClient().launchBillingFlow(this, BillingFlowParams.newBuilder().setSkuDetails(this.skuDetails).build());
        }
    }

    @Subscribe
    public void handleBrandedIAPCompleted(BrandedIAPCompleted brandedIAPCompleted) {
        BrandedIAPTransactionType brandedIAPTransactionType = BrandedIAPTransactionType.getBrandedIAPTransactionType(brandedIAPCompleted.brandedIAPTransactionTypeMask);
        if (brandedIAPTransactionType == BrandedIAPTransactionType.NEW_PURCHASE || brandedIAPTransactionType == BrandedIAPTransactionType.REACTIVATION) {
            startActivity(new Intent(this, MainClientActivity.class));
            finish();
            return;
        }
        finish();
    }
}
