package com.trainerfu.android;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.trainerfu.android.CopyFromPlanTemplateFragment;
import com.trainerfu.android.SelectWeekFragment;
import com.trainerfu.utils.Util;

public class CopyFromPlanTemplateActivity extends BaseActivity implements CopyFromPlanTemplateFragment.EventListener, SelectWeekFragment.EventListener, FragmentManager.OnBackStackChangedListener {
    private String title;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CopyPlanTemplateTaskType copyPlanTemplateTaskType = CopyPlanTemplateTaskType.getCopyPlanTemplateTaskType(getIntent().getIntExtra("task_type", 1));
        if (copyPlanTemplateTaskType == CopyPlanTemplateTaskType.FOR_COPYING_A_TEMPLATE_TO_SINGLE_CLIENT) {
            String string = getString(R.string.copyFromPlanTemplate);
            this.title = string;
            setTitle(string);
        } else if (copyPlanTemplateTaskType == CopyPlanTemplateTaskType.FOR_COPYING_TO_MANY_CLIENTS) {
            String string2 = getString(R.string.copyToClients);
            this.title = string2;
            setTitle(string2);
        } else if (copyPlanTemplateTaskType == CopyPlanTemplateTaskType.FOR_COPYING_TO_SEGMENTS) {
            String string3 = getString(R.string.copyToGroups);
            this.title = string3;
            setTitle(string3);
        } else if (copyPlanTemplateTaskType == CopyPlanTemplateTaskType.FOR_COPYING_A_PLAN_TEMPLATE_TO_GROUP) {
            String string4 = getString(R.string.copyFromPlanTemplate);
            this.title = string4;
            setTitle(string4);
        }
        if (bundle == null) {
            CopyFromPlanTemplateFragment copyFromPlanTemplateFragment = new CopyFromPlanTemplateFragment();
            copyFromPlanTemplateFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) copyFromPlanTemplateFragment, "cfpt").commit();
        }
        getSupportFragmentManager().addOnBackStackChangedListener(this);
    }

    public void handleWeekSelect(int i) {
        SelectWeekFragment selectWeekFragment = new SelectWeekFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("ordered_plan_list_length", i);
        selectWeekFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) selectWeekFragment, "swf").addToBackStack((String) null).commit();
    }

    public void weekSelected(int i) {
        getSupportFragmentManager().popBackStack();
        Util.hideKeyboard(this);
        CopyFromPlanTemplateFragment copyFromPlanTemplateFragment = (CopyFromPlanTemplateFragment) getSupportFragmentManager().findFragmentByTag("cfpt");
        if (copyFromPlanTemplateFragment != null) {
            copyFromPlanTemplateFragment.weekSelected(i);
        }
    }

    public void onBackStackChanged() {
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        if (backStackEntryCount == 0) {
            setTitle(this.title);
        } else if (backStackEntryCount == 1) {
            setTitle("Select Week");
        }
    }
}
