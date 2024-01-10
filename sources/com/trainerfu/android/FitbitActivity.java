package com.trainerfu.android;

import android.os.Bundle;

public class FitbitActivity extends BaseActivity {
    public FitbitActivity() {
        super(true);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FitbitFragment fitbitFragment = new FitbitFragment();
        fitbitFragment.setArguments(new Bundle());
        getFragmentManager().beginTransaction().add(16908290, fitbitFragment).commit();
    }
}
