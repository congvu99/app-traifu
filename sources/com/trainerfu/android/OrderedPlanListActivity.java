package com.trainerfu.android;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

public class OrderedPlanListActivity extends BaseActivity {
    public OrderedPlanListActivity() {
        super(false);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(getIntent().getExtras().getString("ordered_plan_list_name"));
        if (bundle == null) {
            WorkoutPlanListFragment workoutPlanListFragment = new WorkoutPlanListFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("viewed_by_client", false);
            bundle2.putBoolean("for_client_plan", false);
            bundle2.putInt("ordered_plan_list_id", getIntent().getExtras().getInt("ordered_plan_list_id"));
            bundle2.putString("ordered_plan_list_name", getIntent().getExtras().getString("ordered_plan_list_name"));
            bundle2.putInt("ordered_plan_list_length", getIntent().getExtras().getInt("ordered_plan_list_length"));
            workoutPlanListFragment.setArguments(bundle2);
            getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) workoutPlanListFragment, "wplf").commit();
        }
    }
}
