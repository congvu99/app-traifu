package com.trainerfu.android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.joanzapata.iconify.widget.IconTextView;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.DateUtils;
import com.trainerfu.utils.Util;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import org.apache.http.Header;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;

public class SetGoalFragment extends Fragment {
    /* access modifiers changed from: private */
    public static int EVENT_REQUEST_CODE = 658723;
    private int assessmentTypeId;
    private String assessmentTypeName;
    /* access modifiers changed from: private */
    public boolean isSaving = false;
    /* access modifiers changed from: private */
    public Button saveBtn;
    /* access modifiers changed from: private */
    public Date targetDate;
    private int userId;

    public interface EventListener {
        void onSettingGoalCancelled();

        void onSettingNewGoal();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.userId = arguments.getInt("user_id");
        this.assessmentTypeId = arguments.getInt("assessment_type_id");
        this.assessmentTypeName = arguments.getString("assessment_type_name");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.set_goal_view, viewGroup, false);
        Bundle arguments = getArguments();
        this.targetDate = DateUtils.addMonths(Calendar.getInstance(), DateUtils.getTodaysDate(), 1);
        TextView textView = (TextView) inflate.findViewById(R.id.date_view);
        textView.setText(DateUtils.getLargeDisplayDate(this.targetDate));
        EditText editText = (EditText) inflate.findViewById(R.id.current_measure_edit_view);
        if (arguments.containsKey("current_measurement")) {
            editText.setText(String.valueOf(arguments.getDouble("current_measurement")));
        }
        setFocus(inflate);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DatePickerFragment datePickerFragment = new DatePickerFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("request_code", SetGoalFragment.EVENT_REQUEST_CODE);
                bundle.putString("info", "");
                if (SetGoalFragment.this.targetDate != null) {
                    bundle.putString("date", DateUtils.getISOFormattedDate(SetGoalFragment.this.targetDate));
                } else {
                    bundle.putString("date", DateUtils.getISOFormattedDate(DateUtils.addDays(Calendar.getInstance(), DateUtils.getTodaysDate(), 1)));
                }
                datePickerFragment.setArguments(bundle);
                datePickerFragment.show(SetGoalFragment.this.getFragmentManager(), "dpf");
            }
        });
        Button button = (Button) inflate.findViewById(R.id.save_btn);
        this.saveBtn = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SetGoalFragment.this.save();
            }
        });
        ((IconTextView) inflate.findViewById(R.id.cancel_btn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (SetGoalFragment.this.isAdded()) {
                    Util.hideKeyboard(SetGoalFragment.this.getActivity());
                    ((EventListener) SetGoalFragment.this.getActivity()).onSettingGoalCancelled();
                }
            }
        });
        return inflate;
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
    public void handleDateSelectedEvent(DateSelectedEvent dateSelectedEvent) {
        if (dateSelectedEvent.requestCode == EVENT_REQUEST_CODE) {
            Date todaysDate = DateUtils.getTodaysDate();
            Date dateFromISOFormat = DateUtils.getDateFromISOFormat(dateSelectedEvent.date);
            if (dateFromISOFormat.before(todaysDate) || dateFromISOFormat.equals(todaysDate)) {
                showInvalidDateError();
                return;
            }
            this.targetDate = dateFromISOFormat;
            ((TextView) getView().findViewById(R.id.date_view)).setText(DateUtils.getLargeDisplayDate(this.targetDate));
        }
    }

    public void onResume() {
        super.onResume();
        setFocus(getView());
    }

    public void setActionBarTitle() {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle((CharSequence) String.format(getString(R.string.setXGoal), new Object[]{this.assessmentTypeName}));
    }

    private void setFocus(View view) {
        Bundle arguments = getArguments();
        EditText editText = (EditText) view.findViewById(R.id.current_measure_edit_view);
        EditText editText2 = (EditText) view.findViewById(R.id.target_measure_edit_view);
        if (arguments.containsKey("current_measurement")) {
            if (editText2.requestFocus()) {
                ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(editText2, 1);
            }
        } else if (editText.requestFocus()) {
            ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(editText, 1);
        }
    }

    public void save() {
        if (!this.isSaving) {
            View view = getView();
            String obj = ((EditText) view.findViewById(R.id.current_measure_edit_view)).getText().toString();
            String obj2 = ((EditText) view.findViewById(R.id.target_measure_edit_view)).getText().toString();
            if (!Util.isNumeric(obj)) {
                showInvalidValueError(R.string.invalidCurrentAssessmentMeasure);
            } else if (!Util.isNumeric(obj2)) {
                showInvalidValueError(R.string.invalidTargetMeasure);
            } else {
                double parseDouble = Double.parseDouble(obj);
                double parseDouble2 = Double.parseDouble(obj2);
                if (parseDouble == parseDouble2) {
                    showInvalidValueError(R.string.currentTargetEqualError);
                    return;
                }
                this.isSaving = true;
                this.saveBtn.setEnabled(false);
                this.saveBtn.setBackgroundColor(getResources().getColor(R.color.disabledBtnColor));
                BaseHttpClient baseHttpClient = new BaseHttpClient(true, getActivity());
                String format = String.format("/users/%s/goals/new", new Object[]{Integer.valueOf(this.userId)});
                HashMap hashMap = new HashMap();
                hashMap.put("assessment_type_id", Integer.valueOf(this.assessmentTypeId));
                hashMap.put("start", Double.valueOf(parseDouble));
                hashMap.put("goal", Double.valueOf(parseDouble2));
                hashMap.put(FirebaseAnalytics.Param.START_DATE, DateUtils.getISOFormattedDate(DateUtils.getTodaysDate()));
                hashMap.put(FirebaseAnalytics.Param.END_DATE, DateUtils.getISOFormattedDate(this.targetDate));
                baseHttpClient.put(format, hashMap, new BaseResponseHandler() {
                    public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                        boolean unused = SetGoalFragment.this.isSaving = false;
                        SetGoalFragment.this.saveBtn.setEnabled(true);
                        SetGoalFragment.this.saveBtn.setBackgroundColor(SetGoalFragment.this.getResources().getColor(R.color.tintColor));
                        if (SetGoalFragment.this.isAdded()) {
                            ((EventListener) SetGoalFragment.this.getActivity()).onSettingNewGoal();
                            Util.hideKeyboard(SetGoalFragment.this.getActivity());
                        }
                        return true;
                    }

                    public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                        boolean unused = SetGoalFragment.this.isSaving = false;
                        SetGoalFragment.this.saveBtn.setEnabled(true);
                        SetGoalFragment.this.saveBtn.setBackgroundColor(SetGoalFragment.this.getResources().getColor(R.color.tintColor));
                        return super.handleFailure(i, headerArr, th, jSONObject);
                    }
                });
            }
        }
    }

    private void showInvalidValueError(int i) {
        new MaterialDialog.Builder(getActivity()).title((int) R.string.Error).content(i).positiveText((int) R.string.Ok).show();
    }

    private void showInvalidDateError() {
        new MaterialDialog.Builder(getActivity()).title((int) R.string.Error).content((int) R.string.invalidGoalDate).positiveText((int) R.string.Ok).show();
    }
}
