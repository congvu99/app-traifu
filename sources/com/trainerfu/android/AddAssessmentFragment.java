package com.trainerfu.android;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.material.textfield.TextInputLayout;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.DatePickerFragmentOld;
import com.trainerfu.utils.DateUtils;
import com.trainerfu.utils.Util;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

public class AddAssessmentFragment extends Fragment {
    /* access modifiers changed from: private */
    public Date assessmentDate;
    private int assessmentTypeId;
    private String assessmentTypeName;
    /* access modifiers changed from: private */
    public TextView dateTV;
    /* access modifiers changed from: private */
    public boolean isSaving = false;
    private EditText measureET;
    private Menu menu;
    /* access modifiers changed from: private */
    public boolean overwriteAssessment = false;
    private int userId;

    public interface EventListener {
        void addingAssessmentCancelled();

        void newAssessmentAdded(Date date, float f);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        Bundle arguments = getArguments();
        this.userId = arguments.getInt("userId");
        this.assessmentTypeId = arguments.getInt("assessmentTypeId");
        this.assessmentTypeName = arguments.getString("assessmentTypeName");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.add_assessment_view, viewGroup, false);
        this.assessmentDate = DateUtils.getTodaysDate();
        if (this.assessmentTypeName.length() < 24) {
            ((TextInputLayout) inflate.findViewById(R.id.dataTV)).setHint((CharSequence) this.assessmentTypeName);
        }
        TextView textView = (TextView) inflate.findViewById(R.id.dateTV);
        this.dateTV = textView;
        textView.setText(DateUtils.getLargeDisplayDate(this.assessmentDate));
        EditText editText = (EditText) inflate.findViewById(R.id.measureET);
        this.measureET = editText;
        if (editText.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
        this.measureET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6) {
                    return false;
                }
                AddAssessmentFragment.this.save();
                return true;
            }
        });
        ((TextInputLayout) inflate.findViewById(R.id.dataTV)).setHint((CharSequence) this.assessmentTypeName);
        this.dateTV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DatePickerFragmentOld datePickerFragmentOld = new DatePickerFragmentOld();
                datePickerFragmentOld.setOnDateSetListener(new DatePickerFragmentOld.OnDateSetListener() {
                    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                        if (AddAssessmentFragment.this.isAdded()) {
                            Calendar instance = Calendar.getInstance();
                            instance.set(i, i2, i3, 0, 0);
                            Date unused = AddAssessmentFragment.this.assessmentDate = instance.getTime();
                            AddAssessmentFragment.this.dateTV.setText(DateUtils.getLargeDisplayDate(AddAssessmentFragment.this.assessmentDate));
                        }
                    }
                });
                Bundle bundle = new Bundle();
                bundle.putLong("max_date", DateUtils.getTodaysDate().getTime());
                datePickerFragmentOld.setArguments(bundle);
                datePickerFragmentOld.show(AddAssessmentFragment.this.getActivity().getFragmentManager(), "datePicker");
            }
        });
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle((CharSequence) String.format(getString(R.string.addMeasureX), new Object[]{this.assessmentTypeName}));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setElevation(10.0f);
        return inflate;
    }

    public void onResume() {
        super.onResume();
        if (getView().findViewById(R.id.measureET).requestFocus()) {
            ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(getView().findViewById(R.id.measureET), 1);
        }
    }

    public void onCreateOptionsMenu(Menu menu2, MenuInflater menuInflater) {
        menu2.clear();
        menuInflater.inflate(R.menu.create_post_menu, menu2);
        this.menu = menu2;
        menu2.findItem(R.id.mark_done_item).setVisible(true);
        super.onCreateOptionsMenu(menu2, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.mark_done_item) {
            save();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onDestroyView() {
        super.onDestroyView();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setElevation(0.0f);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle((CharSequence) String.format(getString(R.string.trackAssessmentX), new Object[]{this.assessmentTypeName}));
    }

    public void setActionBarTitle() {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle((CharSequence) String.format(getString(R.string.addMeasureX), new Object[]{this.assessmentTypeName}));
    }

    public void save() {
        if (!this.isSaving) {
            String obj = this.measureET.getText().toString();
            if (!Util.isNumeric(obj)) {
                showInvalidValueError();
                return;
            }
            final double parseDouble = Double.parseDouble(obj);
            if (parseDouble < Utils.DOUBLE_EPSILON) {
                showInvalidValueError();
                return;
            }
            if (this.assessmentDate.compareTo(DateUtils.getTodaysDate()) > 0) {
                showInvalidDateError();
                return;
            }
            this.isSaving = true;
            BaseHttpClient baseHttpClient = new BaseHttpClient(true, getActivity());
            String format = String.format("/users/%s/assessment_measures/new", new Object[]{Integer.valueOf(this.userId)});
            HashMap hashMap = new HashMap();
            hashMap.put("assessment_type_id", Integer.valueOf(this.assessmentTypeId));
            hashMap.put("measure", Double.valueOf(parseDouble));
            hashMap.put("date", DateUtils.getISOFormattedDate(this.assessmentDate));
            hashMap.put("today", DateUtils.getISOFormattedDate(DateUtils.getTodaysDate()));
            hashMap.put("overwrite", Boolean.valueOf(this.overwriteAssessment));
            this.overwriteAssessment = false;
            baseHttpClient.put(format, hashMap, new BaseResponseHandler() {
                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    boolean unused = AddAssessmentFragment.this.isSaving = false;
                    BaseHttpClient baseHttpClient = new BaseHttpClient();
                    HashMap hashMap = new HashMap();
                    try {
                        hashMap.put("id", Integer.valueOf(jSONObject.getInt("id")));
                        baseHttpClient.put("/tasks/new/post_process_assessment_story_task", hashMap, new BaseResponseHandler() {
                            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                                return true;
                            }
                        });
                        if (!AddAssessmentFragment.this.isAdded()) {
                            return true;
                        }
                        ((EventListener) AddAssessmentFragment.this.getActivity()).newAssessmentAdded(AddAssessmentFragment.this.assessmentDate, (float) parseDouble);
                        Util.hideKeyboard(AddAssessmentFragment.this.getActivity());
                        return true;
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }

                public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                    boolean unused = AddAssessmentFragment.this.isSaving = false;
                    if (jSONObject != null && jSONObject.has("error_code")) {
                        try {
                            if (jSONObject.getInt("error_code") == 24 && AddAssessmentFragment.this.isAdded()) {
                                AddAssessmentFragment.this.showOverwriteDialog();
                                return true;
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    return false;
                }
            });
        }
    }

    private void showInvalidValueError() {
        new MaterialDialog.Builder(getActivity()).title((int) R.string.Error).content((int) R.string.invalidAssessmentMeasure).positiveText((int) R.string.Ok).show();
    }

    private void showInvalidDateError() {
        new MaterialDialog.Builder(getActivity()).title((int) R.string.Error).content((int) R.string.invalidAssessmentDate).positiveText((int) R.string.Ok).show();
    }

    /* access modifiers changed from: private */
    public void showOverwriteDialog() {
        new MaterialDialog.Builder(getActivity()).title((int) R.string.Error).content((int) R.string.overwriteAssessment).positiveText((int) R.string.Ok).negativeText((int) R.string.Cancel).onPositive(new MaterialDialog.SingleButtonCallback() {
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                boolean unused = AddAssessmentFragment.this.overwriteAssessment = true;
                this.save();
            }
        }).show();
    }
}
