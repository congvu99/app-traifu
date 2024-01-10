package com.trainerfu.android;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.afollestad.materialdialogs.MaterialDialog;
import com.trainerfu.android.DrillEditFragment;
import com.trainerfu.android.WorkoutLogFragment;
import com.trainerfu.utils.DatePickerFragmentOld;
import com.trainerfu.utils.DateUtils;
import com.trainerfu.utils.ExerciseStats;
import com.trainerfu.utils.Util;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class WorkoutLogActivity extends BaseActivity implements DrillEditFragment.EventListener, WorkoutLogFragment.EventListener, FragmentManager.OnBackStackChangedListener {
    private static int SELECT_EXERCISE_REQUEST_CODE = 102;
    private int clientId = 0;
    /* access modifiers changed from: private */
    public Date logDate = DateUtils.getTodaysDate();
    private Menu menu;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            WorkoutLogFragment workoutLogFragment = new WorkoutLogFragment();
            Bundle extras = getIntent().getExtras();
            this.clientId = extras.getInt("user_id");
            workoutLogFragment.setArguments(extras);
            getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) workoutLogFragment, "wlf").commit();
        }
        setTitle(DateUtils.getTodaysDate());
        getSupportFragmentManager().addOnBackStackChangedListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu2) {
        getMenuInflater().inflate(R.menu.workout_log, menu2);
        this.menu = menu2;
        return super.onCreateOptionsMenu(menu2);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        WorkoutLogFragment wlf = getWLF();
        int itemId = menuItem.getItemId();
        if (itemId != R.id.action_save) {
            if (itemId == R.id.change_date && wlf != null) {
                selectDate();
            }
        } else if (wlf != null) {
            wlf.save();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: private */
    public void selectDate() {
        DatePickerFragmentOld datePickerFragmentOld = new DatePickerFragmentOld();
        datePickerFragmentOld.setOnDateSetListener(new DatePickerFragmentOld.OnDateSetListener() {
            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                Calendar instance = Calendar.getInstance();
                instance.set(i, i2, i3, 0, 0);
                instance.set(13, 0);
                instance.set(14, 0);
                Date unused = WorkoutLogActivity.this.logDate = instance.getTime();
                if (DateUtils.getTodaysDate().before(WorkoutLogActivity.this.logDate)) {
                    new MaterialDialog.Builder(WorkoutLogActivity.this).title((int) R.string.Error).content((int) R.string.invalidLogDate).positiveText((int) R.string.Ok).show();
                    return;
                }
                WorkoutLogFragment access$100 = WorkoutLogActivity.this.getWLF();
                if (access$100 != null) {
                    access$100.changeDate(WorkoutLogActivity.this.logDate);
                }
                WorkoutLogActivity workoutLogActivity = WorkoutLogActivity.this;
                workoutLogActivity.setTitle(workoutLogActivity.logDate);
            }
        });
        Bundle bundle = new Bundle();
        bundle.putLong("max_date", DateUtils.getTodaysDate().getTime());
        datePickerFragmentOld.setArguments(bundle);
        datePickerFragmentOld.show(getFragmentManager(), "datePicker");
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("logDate", DateUtils.getISOFormattedDate(this.logDate));
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        Date dateFromISOFormat = DateUtils.getDateFromISOFormat(bundle.getString("logDate"));
        this.logDate = dateFromISOFormat;
        setTitle(dateFromISOFormat);
    }

    public void drillEdited(Bundle bundle, JSONObject jSONObject, String str) {
        getSupportFragmentManager().popBackStack();
        Util.hideKeyboard(this);
        WorkoutLogFragment wlf = getWLF();
        if (wlf != null) {
            wlf.drillEdited(bundle, jSONObject, str);
        }
    }

    public void drillEditCancelled() {
        getSupportFragmentManager().popBackStack();
        Util.hideKeyboard(this);
    }

    /* access modifiers changed from: private */
    public WorkoutLogFragment getWLF() {
        return (WorkoutLogFragment) getSupportFragmentManager().findFragmentByTag("wlf");
    }

    public void drillEditClicked(Bundle bundle, JSONObject jSONObject, String str, JSONObject jSONObject2) {
        DrillEditFragment drillEditFragment = new DrillEditFragment();
        Bundle bundle2 = new Bundle();
        boolean z = true;
        bundle.putBoolean("showRecentLoggedExerciseStats", true);
        bundle.putBoolean("showRecentPlannedExerciseStats", false);
        bundle.putInt("clientId", this.clientId);
        bundle2.putBundle("info", bundle);
        bundle2.putString("measures", jSONObject.toString());
        bundle2.putString("rest", str);
        bundle2.putBoolean("custom_action_bar", false);
        if (jSONObject2 == null) {
            z = false;
        }
        bundle2.putBoolean("show_history_view", z);
        bundle2.putString("history", ExerciseStats.getSerializedExerciseHistory(jSONObject2, bundle.getInt("exercise_id")));
        drillEditFragment.setArguments(bundle2);
        getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) drillEditFragment, "def").addToBackStack((String) null).commit();
    }

    public void logSaved() {
        Intent intent = new Intent();
        intent.putExtra("action", "workout_log_saved");
        setResult(-1, intent);
        finish();
    }

    public void logSaveCancelled() {
        Intent intent = new Intent();
        intent.putExtra("action", "workout_logging_cancelled");
        setResult(-1, intent);
        finish();
    }

    public void addExerciseClicked() {
        Intent intent = new Intent(this, ExerciseCollectionActivity.class);
        Bundle extras = getIntent().getExtras();
        intent.putExtra("allow_add_exercise", (extras == null || !extras.containsKey("is_viewed_by_trainer")) ? false : extras.getBoolean("is_viewed_by_trainer"));
        startActivityForResult(intent, SELECT_EXERCISE_REQUEST_CODE);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == SELECT_EXERCISE_REQUEST_CODE) {
            try {
                getWLF().addExerciseToLog(new JSONObject(intent.getExtras().getString("exercise")));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackStackChanged() {
        resetMenu();
    }

    private void resetMenu() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            this.menu.findItem(R.id.action_save).setVisible(true);
            setTitle(this.logDate);
            return;
        }
        this.menu.findItem(R.id.action_save).setVisible(false);
    }

    public void setTitle(Date date) {
        String feedDisplayDate = DateUtils.getFeedDisplayDate(date);
        if (DateUtils.isTodayDate(date)) {
            feedDisplayDate = "Today's";
        }
        SpannableString spannableString = new SpannableString(feedDisplayDate + " Workout");
        spannableString.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                WorkoutLogActivity.this.selectDate();
            }
        }, 0, feedDisplayDate.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tintColor)), 0, feedDisplayDate.length(), 33);
        spannableString.setSpan(new UnderlineSpan(), 0, feedDisplayDate.length(), 0);
        ((TextView) ((Toolbar) findViewById(R.id.action_bar)).getChildAt(0)).setMovementMethod(LinkMovementMethod.getInstance());
        getSupportActionBar().setTitle((CharSequence) spannableString);
    }

    public void focusEditText(View view) {
        getWLF().focusEditText(view);
    }
}
