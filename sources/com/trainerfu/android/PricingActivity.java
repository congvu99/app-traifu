package com.trainerfu.android;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class PricingActivity extends BaseActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle((CharSequence) "Plans");
        supportActionBar.setElevation(0.0f);
        if (bundle == null) {
            PricingFragment pricingFragment = new PricingFragment();
            pricingFragment.setArguments(new Bundle());
            getFragmentManager().beginTransaction().add(16908290, pricingFragment, "prf").commit();
        }
        setContentView((int) R.layout.activity_pricing);
    }

    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe
    public void handleSubscriptionPlanChangedEvent(SubscriptionPlanChangedEvent subscriptionPlanChangedEvent) {
        if (subscriptionPlanChangedEvent.savedToServerSuccessfully) {
            new MaterialDialog.Builder(this).title((int) R.string.success).content((CharSequence) getString(R.string.upgradeSuccessful)).positiveText((int) R.string.Ok).onPositive(new MaterialDialog.SingleButtonCallback() {
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    PricingActivity.this.finish();
                }
            }).build().show();
        } else {
            new MaterialDialog.Builder(this).title((int) R.string.Error).content((CharSequence) getString(R.string.upgradeError)).positiveText((int) R.string.Ok).onPositive(new MaterialDialog.SingleButtonCallback() {
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    PricingActivity.this.finish();
                }
            }).build().show();
        }
    }
}
