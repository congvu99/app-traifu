package com.trainerfu.android;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.material.TextFieldImplKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.gigamole.navigationtabstrip.NavigationTabStrip;
import com.trainerfu.android.DrillEditFragment;
import com.trainerfu.android.EditGroupDrillFragment;
import com.trainerfu.android.SelectTimerDurationFragment;
import com.trainerfu.android.WorkoutPlanDayFragment;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.Constants;
import com.trainerfu.utils.CustomViewPager;
import com.trainerfu.utils.ExerciseStats;
import com.trainerfu.utils.Util;
import io.intercom.android.sdk.models.Part;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

public class WorkoutPlanDayActivity extends BaseActivity implements DrillEditFragment.EventListener, WorkoutPlanDayFragment.EventListener, EditGroupDrillFragment.EventListener, SelectTimerDurationFragment.EventListener, WorkoutPlanDayFragment.TrackingEventListener {
    /* access modifiers changed from: private */
    public ViewPagerAdapter adapter;
    /* access modifiers changed from: private */
    public int contextUserId = 0;
    /* access modifiers changed from: private */
    public int dayOfWeek;
    /* access modifiers changed from: private */
    public String dayOfWeekString;
    private NavigationTabStrip dayPicker;
    /* access modifiers changed from: private */
    public JSONObject history;
    /* access modifiers changed from: private */
    public Boolean isScrolledUp = true;
    private Boolean isTimerOn = false;
    /* access modifiers changed from: private */
    public ImageView stopWatchBtn;
    private CountDownTimer timer = null;
    /* access modifiers changed from: private */
    public ImageView timerOffBtn;
    /* access modifiers changed from: private */
    public CustomViewPager viewPager;
    /* access modifiers changed from: private */
    public WorkoutPlanDayViewType viewType = WorkoutPlanDayViewType.TRACKING;
    private Toolbar workoutHeader;
    /* access modifiers changed from: private */
    public TextView workoutTitleView;

    /* access modifiers changed from: private */
    public String getDayOfWeekString(int i) {
        switch (i) {
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            case 7:
                return "Saturday";
            default:
                return null;
        }
    }

    public WorkoutPlanDayActivity() {
        super(true);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.workoutplan_day_activity_view);
        Bundle extras = getIntent().getExtras();
        this.dayOfWeek = extras.getInt("dayOfWeek");
        if (extras.containsKey("context_user_id")) {
            this.contextUserId = extras.getInt("context_user_id");
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.workoutHeader);
        this.workoutHeader = toolbar;
        this.workoutTitleView = (TextView) toolbar.findViewById(R.id.workoutTitle);
        this.stopWatchBtn = (ImageView) this.workoutHeader.findViewById(R.id.stopWatch);
        this.timerOffBtn = (ImageView) this.workoutHeader.findViewById(R.id.timerOff);
        this.viewPager = (CustomViewPager) findViewById(R.id.viewpager);
        this.dayPicker = (NavigationTabStrip) findViewById(R.id.day_picker);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        this.adapter = viewPagerAdapter;
        this.viewPager.setAdapter(viewPagerAdapter);
        this.dayPicker.setViewPager(this.viewPager);
        this.dayPicker.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf"));
        this.viewPager.setCurrentItem(this.dayOfWeek - 1);
        if (extras.containsKey("view_type")) {
            WorkoutPlanDayViewType viewType2 = WorkoutPlanDayViewType.getViewType(extras.getInt("view_type"));
            this.viewType = viewType2;
            if (viewType2 == WorkoutPlanDayViewType.TRACKING) {
                this.viewPager.setPagingEnabled(false);
                this.dayPicker.setVisibility(8);
                this.stopWatchBtn.setVisibility(0);
                this.stopWatchBtn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        WorkoutPlanDayActivity.this.stopWatchClicked();
                    }
                });
                this.timerOffBtn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        WorkoutPlanDayActivity.this.stopTimer();
                    }
                });
            } else if (this.viewType == WorkoutPlanDayViewType.EDITING_TEMPLATE) {
                this.dayPicker.setVisibility(8);
                this.viewPager.setPagingEnabled(false);
            } else {
                this.viewPager.setPagingEnabled(true);
            }
        }
        this.adapter.notifyDataSetChanged();
        this.dayPicker.setOnTabStripSelectedIndexListener(new NavigationTabStrip.OnTabStripSelectedIndexListener() {
            public void onEndTabSelected(String str, int i) {
            }

            public void onStartTabSelected(String str, int i) {
                int unused = WorkoutPlanDayActivity.this.dayOfWeek = i + 1;
                WorkoutPlanDayActivity workoutPlanDayActivity = WorkoutPlanDayActivity.this;
                String unused2 = workoutPlanDayActivity.dayOfWeekString = workoutPlanDayActivity.getDayOfWeekString(workoutPlanDayActivity.dayOfWeek);
                WorkoutPlanDayActivity.this.adapter.getItem(WorkoutPlanDayActivity.this.viewPager.getCurrentItem());
                WorkoutPlanDayActivity.this.adapter.notifyDataSetChanged();
            }
        });
        this.dayPicker.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageSelected(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
                WorkoutPlanDayActivity workoutPlanDayActivity = WorkoutPlanDayActivity.this;
                String unused = workoutPlanDayActivity.dayOfWeekString = workoutPlanDayActivity.getDayOfWeekString(i + 1);
                TextView access$600 = WorkoutPlanDayActivity.this.workoutTitleView;
                access$600.setText(WorkoutPlanDayActivity.this.dayOfWeekString + "'s Workout");
                if (WorkoutPlanDayActivity.this.viewType == WorkoutPlanDayViewType.EDITING_TEMPLATE) {
                    WorkoutPlanDayActivity.this.workoutTitleView.setText("Workout");
                }
            }
        });
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if ((this.history == null && this.viewType == WorkoutPlanDayViewType.TRACKING) || (this.history == null && this.viewType == WorkoutPlanDayViewType.EDITING_CLIENT_PLAN && this.contextUserId != 0)) {
            fetchHistory();
        }
    }

    public JSONObject getHistory() {
        return this.history;
    }

    public void fetchHistory() {
        new BaseHttpClient().get(String.format("users/%s/exercise_stats/all_logged_exercises_history", new Object[]{Util.getUserIdForUrl(this.contextUserId)}), new HashMap(), new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                try {
                    JSONObject unused = WorkoutPlanDayActivity.this.history = jSONObject.getJSONObject("history");
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return true;
                }
            }
        });
    }

    public void drillEditClicked(Bundle bundle, JSONObject jSONObject, String str) {
        DrillEditFragment drillEditFragment = new DrillEditFragment();
        Bundle bundle2 = new Bundle();
        boolean z = true;
        if (this.viewType != WorkoutPlanDayViewType.EDITING_TEMPLATE) {
            bundle.putBoolean("showRecentLoggedExerciseStats", true);
            if (this.viewType == WorkoutPlanDayViewType.EDITING_CLIENT_PLAN) {
                bundle.putBoolean("showRecentPlannedExerciseStats", true);
                bundle.putBoolean("viewed_by_trainer", true);
            }
            bundle.putInt("clientId", this.contextUserId);
        }
        bundle2.putBundle("info", bundle);
        bundle2.putString("measures", jSONObject.toString());
        bundle2.putString("rest", str);
        bundle2.putBoolean("custom_action_bar", true);
        if (this.history == null) {
            z = false;
        }
        bundle2.putBoolean("show_history_view", z);
        bundle2.putString("history", ExerciseStats.getSerializedExerciseHistory(this.history, bundle.getInt("exercise_id")));
        drillEditFragment.setArguments(bundle2);
        getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) drillEditFragment, "def").addToBackStack((String) null).commit();
    }

    public void onVideoClicked(JSONObject jSONObject) {
        DrillVideoFragment drillVideoFragment = new DrillVideoFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.DRILL, jSONObject.toString());
        bundle.putBoolean("custom_action_bar", true);
        drillVideoFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) drillVideoFragment, "dvf").addToBackStack((String) null).commit();
    }

    public void editGroupDrillClicked(int i, JSONObject jSONObject, String str) {
        EditGroupDrillFragment editGroupDrillFragment = new EditGroupDrillFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("start_drill_id", i);
        bundle.putString("measures", jSONObject.toString());
        bundle.putString(Part.NOTE_MESSAGE_STYLE, str);
        editGroupDrillFragment.setArguments(bundle);
        editGroupDrillFragment.show(getFragmentManager(), "egdf");
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 1);
    }

    public void stopWatchClicked() {
        SelectTimerDurationFragment selectTimerDurationFragment = new SelectTimerDurationFragment();
        selectTimerDurationFragment.setArguments(new Bundle());
        selectTimerDurationFragment.show(getFragmentManager(), "stdf");
    }

    public void timerSurationSelected(int i, int i2) {
        startTimer(i, i2);
    }

    public void completedTracking() {
        Intent intent = new Intent();
        intent.putExtra("action", "completed_tracking");
        setResult(-1, intent);
        finish();
    }

    public void cancelTracking() {
        finish();
    }

    public void drillEdited(Bundle bundle, JSONObject jSONObject, String str) {
        getSupportFragmentManager().popBackStack();
        Util.hideKeyboard(this);
        WorkoutPlanDayFragment workoutPlanDayFragment = (WorkoutPlanDayFragment) this.adapter.getRegisteredFragment(this.viewPager.getCurrentItem());
        if (workoutPlanDayFragment != null) {
            workoutPlanDayFragment.drillEdited(bundle, jSONObject, str);
        }
        this.adapter.notifyDataSetChanged();
    }

    public void drillEditCancelled() {
        getSupportFragmentManager().popBackStack();
        Util.hideKeyboard(this);
    }

    private WorkoutPlanDayFragment getWPDF() {
        return (WorkoutPlanDayFragment) getSupportFragmentManager().findFragmentByTag("wpdf");
    }

    public void groupDrillEdited(int i, JSONObject jSONObject, String str) {
        WorkoutPlanDayFragment workoutPlanDayFragment = (WorkoutPlanDayFragment) this.adapter.getRegisteredFragment(this.viewPager.getCurrentItem());
        if (workoutPlanDayFragment != null) {
            workoutPlanDayFragment.groupDrillEdited(i, jSONObject, str);
        }
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            this.isScrolledUp = true;
            this.workoutHeader.setElevation(10.0f);
            if (this.isTimerOn.booleanValue()) {
                this.workoutTitleView.setTextSize(56.0f);
                this.workoutTitleView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 1));
                return;
            }
            return;
        }
        this.isScrolledUp = false;
        this.workoutHeader.setElevation(20.0f);
        this.workoutTitleView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 3));
        this.workoutTitleView.setTextSize(20.0f);
    }

    public void startTimer(int i, int i2) {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (WorkoutPlanDayActivity.this.isScrolledUp.booleanValue()) {
                    WorkoutPlanDayActivity.this.workoutTitleView.setTextSize(56.0f);
                    WorkoutPlanDayActivity.this.workoutTitleView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 1));
                }
                WorkoutPlanDayActivity.this.timerOffBtn.setVisibility(0);
                WorkoutPlanDayActivity.this.stopWatchBtn.setVisibility(8);
            }
        }, 1);
        this.timer = new CountDownTimer((long) ((i * 60 * 1000) + (i2 * 1000)), 1000) {
            public void onTick(long j) {
                TextView access$600 = WorkoutPlanDayActivity.this.workoutTitleView;
                access$600.setText("" + String.format("%02d:%02d", new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(j))), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j)))}));
            }

            public void onFinish() {
                WorkoutPlanDayActivity.this.stopTimer();
            }
        }.start();
        this.isTimerOn = true;
    }

    /* access modifiers changed from: private */
    public void stopTimer() {
        new ToneGenerator(3, 100).startTone(28, TextFieldImplKt.AnimationDuration);
        this.timer.cancel();
        this.workoutTitleView.setVisibility(0);
        this.workoutTitleView.setTextSize(20.0f);
        this.workoutTitleView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 3));
        TextView textView = this.workoutTitleView;
        textView.setText(this.dayOfWeekString + "'s Workout");
        this.timerOffBtn.setVisibility(8);
        this.stopWatchBtn.setVisibility(0);
        this.isTimerOn = false;
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList();
        private final List<String> mFragmentTitleList = new ArrayList();
        SparseArray<Fragment> registeredFragments = new SparseArray<>();

        public int getCount() {
            return 7;
        }

        public CharSequence getPageTitle(int i) {
            return null;
        }

        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public Fragment getItem(int i) {
            WorkoutPlanDayFragment workoutPlanDayFragment = new WorkoutPlanDayFragment();
            Bundle bundle = new Bundle();
            Bundle extras = WorkoutPlanDayActivity.this.getIntent().getExtras();
            int unused = WorkoutPlanDayActivity.this.dayOfWeek = extras.getInt("dayOfWeek");
            bundle.putInt("dayOfWeek", i + 1);
            if (extras.containsKey("context_user_id")) {
                int unused2 = WorkoutPlanDayActivity.this.contextUserId = extras.getInt("context_user_id");
                bundle.putInt("context_user_id", WorkoutPlanDayActivity.this.contextUserId);
            }
            if (extras.containsKey("program_id")) {
                bundle.putInt("program_id", extras.getInt("program_id"));
            }
            if (extras.containsKey("view_type")) {
                WorkoutPlanDayViewType unused3 = WorkoutPlanDayActivity.this.viewType = WorkoutPlanDayViewType.getViewType(extras.getInt("view_type"));
                bundle.putInt("view_type", extras.getInt("view_type"));
            }
            if (extras.containsKey("for_client_plan")) {
                bundle.putBoolean("for_client_plan", extras.getBoolean("for_client_plan"));
            }
            workoutPlanDayFragment.setArguments(bundle);
            return workoutPlanDayFragment;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            Fragment fragment = (Fragment) super.instantiateItem(viewGroup, i);
            this.registeredFragments.put(i, fragment);
            return fragment;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            this.registeredFragments.remove(i);
            super.destroyItem(viewGroup, i, obj);
        }

        public Fragment getRegisteredFragment(int i) {
            return this.registeredFragments.get(i);
        }
    }
}
