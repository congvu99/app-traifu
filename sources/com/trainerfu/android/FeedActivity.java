package com.trainerfu.android;

import android.app.NotificationManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

public class FeedActivity extends BaseActivity {
    public FeedActivity() {
        super(true);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            FeedFragment feedFragment = new FeedFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("is_viewed_by_trainer", getIntent().getBooleanExtra("is_viewed_by_trainer", false));
            feedFragment.setArguments(bundle2);
            getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) feedFragment).commit();
            ((NotificationManager) getApplicationContext().getSystemService("notification")).cancelAll();
        }
    }
}
