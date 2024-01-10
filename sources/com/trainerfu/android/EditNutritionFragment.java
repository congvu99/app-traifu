package com.trainerfu.android;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.material.textfield.TextInputLayout;
import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.Util;
import java.util.HashMap;
import org.apache.http.Header;
import org.json.JSONObject;

public class EditNutritionFragment extends Fragment {
    /* access modifiers changed from: private */
    public EditText caloriesEditText;
    /* access modifiers changed from: private */
    public EditText caloriesEditTextBottom;
    private TextInputLayout caloriesWrapper;
    private TextInputLayout caloriesWrapperBottom;
    private Button cancelBtn;
    /* access modifiers changed from: private */
    public String carbs;
    /* access modifiers changed from: private */
    public EditText carbsEditText;
    /* access modifiers changed from: private */
    public String carbsGrams;
    private TextInputLayout carbsWrapper;
    /* access modifiers changed from: private */
    public String fat;
    /* access modifiers changed from: private */
    public EditText fatEditText;
    /* access modifiers changed from: private */
    public String fatGrams;
    private TextInputLayout fatWrapper;
    /* access modifiers changed from: private */
    public boolean isBreakDownInPercent;
    /* access modifiers changed from: private */
    public boolean isSaving;
    /* access modifiers changed from: private */
    public String protein;
    /* access modifiers changed from: private */
    public EditText proteinEditText;
    /* access modifiers changed from: private */
    public String proteinGrams;
    private TextInputLayout proteinWrapper;
    private Button saveBtn;
    /* access modifiers changed from: private */
    public String totalCalories;
    /* access modifiers changed from: private */
    public String totalCaloriesGrams;
    private int userId;

    public interface EventListener {
        void onEditNutritionCancel();

        void onSaveNutrition();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Bundle bundle2 = arguments.getBundle("info");
        boolean z = bundle2.getBoolean("is_breakdown_in_percent");
        this.isBreakDownInPercent = z;
        if (z) {
            this.totalCalories = bundle2.getString("total_calories");
            this.protein = bundle2.getString("protein");
            this.fat = bundle2.getString("fat");
            this.carbs = bundle2.getString("carbs");
        } else {
            this.totalCaloriesGrams = bundle2.getString("total_calories");
            this.proteinGrams = bundle2.getString("protein");
            this.fatGrams = bundle2.getString("fat");
            this.carbsGrams = bundle2.getString("carbs");
        }
        this.userId = arguments.getInt("userId");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_edit_nutrition, viewGroup, false);
        setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle((CharSequence) "Daily Nutrition Goal");
        this.caloriesWrapper = (TextInputLayout) inflate.findViewById(R.id.calories_wrapper);
        this.caloriesWrapperBottom = (TextInputLayout) inflate.findViewById(R.id.calories_wrapper_bottom);
        this.caloriesEditText = (EditText) inflate.findViewById(R.id.calories_goal);
        this.caloriesEditTextBottom = (EditText) inflate.findViewById(R.id.calories_goal_bottom);
        this.proteinWrapper = (TextInputLayout) inflate.findViewById(R.id.protein_wrapper);
        this.proteinEditText = (EditText) inflate.findViewById(R.id.protein_goal);
        this.fatWrapper = (TextInputLayout) inflate.findViewById(R.id.fat_wrapper);
        this.fatEditText = (EditText) inflate.findViewById(R.id.fat_goal);
        this.carbsWrapper = (TextInputLayout) inflate.findViewById(R.id.carbs_wrapper);
        this.carbsEditText = (EditText) inflate.findViewById(R.id.carbs_goal);
        this.cancelBtn = (Button) inflate.findViewById(R.id.cancel_btn);
        this.saveBtn = (Button) inflate.findViewById(R.id.save_btn);
        RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.radio_group);
        RadioButton radioButton = (RadioButton) inflate.findViewById(R.id.radio_button_grams);
        RadioButton radioButton2 = (RadioButton) inflate.findViewById(R.id.radio_button_percentage);
        if (this.isBreakDownInPercent) {
            radioButton2.setChecked(true);
        } else {
            radioButton.setChecked(true);
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radio_button_grams /*2131363017*/:
                        EditNutritionFragment editNutritionFragment = EditNutritionFragment.this;
                        String unused = editNutritionFragment.totalCalories = editNutritionFragment.caloriesEditText.getText().toString().trim();
                        EditNutritionFragment editNutritionFragment2 = EditNutritionFragment.this;
                        String unused2 = editNutritionFragment2.protein = editNutritionFragment2.proteinEditText.getText().toString().trim();
                        EditNutritionFragment editNutritionFragment3 = EditNutritionFragment.this;
                        String unused3 = editNutritionFragment3.fat = editNutritionFragment3.fatEditText.getText().toString().trim();
                        EditNutritionFragment editNutritionFragment4 = EditNutritionFragment.this;
                        String unused4 = editNutritionFragment4.carbs = editNutritionFragment4.carbsEditText.getText().toString().trim();
                        boolean unused5 = EditNutritionFragment.this.isBreakDownInPercent = false;
                        EditNutritionFragment.this.resetViews();
                        return;
                    case R.id.radio_button_percentage /*2131363018*/:
                        EditNutritionFragment editNutritionFragment5 = EditNutritionFragment.this;
                        String unused6 = editNutritionFragment5.totalCaloriesGrams = editNutritionFragment5.caloriesEditTextBottom.getText().toString().trim();
                        EditNutritionFragment editNutritionFragment6 = EditNutritionFragment.this;
                        String unused7 = editNutritionFragment6.proteinGrams = editNutritionFragment6.proteinEditText.getText().toString().trim();
                        EditNutritionFragment editNutritionFragment7 = EditNutritionFragment.this;
                        String unused8 = editNutritionFragment7.fatGrams = editNutritionFragment7.fatEditText.getText().toString().trim();
                        EditNutritionFragment editNutritionFragment8 = EditNutritionFragment.this;
                        String unused9 = editNutritionFragment8.carbsGrams = editNutritionFragment8.carbsEditText.getText().toString().trim();
                        boolean unused10 = EditNutritionFragment.this.isBreakDownInPercent = true;
                        EditNutritionFragment.this.resetViews();
                        return;
                    default:
                        return;
                }
            }
        });
        resetViews();
        this.cancelBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (EditNutritionFragment.this.isAdded()) {
                    Util.hideKeyboard(EditNutritionFragment.this.getActivity());
                    ((EventListener) EditNutritionFragment.this.getActivity()).onEditNutritionCancel();
                }
            }
        });
        this.proteinEditText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence.length() > 0) {
                    EditNutritionFragment.this.updateValues();
                }
            }
        });
        this.fatEditText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence.length() > 0) {
                    EditNutritionFragment.this.updateValues();
                }
            }
        });
        this.carbsEditText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence.length() > 0) {
                    EditNutritionFragment.this.updateValues();
                }
            }
        });
        this.saveBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditNutritionFragment.this.saveNutritionGoal();
            }
        });
        if (this.isBreakDownInPercent) {
            this.caloriesEditText.setText(this.totalCalories);
            this.proteinEditText.setText(this.protein);
            this.fatEditText.setText(this.fat);
            this.carbsEditText.setText(this.carbs);
        } else {
            this.caloriesEditText.setText(this.totalCaloriesGrams);
            this.proteinEditText.setText(this.proteinGrams);
            this.fatEditText.setText(this.fatGrams);
            this.carbsEditText.setText(this.carbsGrams);
        }
        return inflate;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.save_nutriton_menu, menu);
        MenuItem findItem = menu.findItem(R.id.delete_nutrition);
        findItem.setIcon(new IconDrawable(getContext(), (Icon) FontAwesomeIcons.fa_trash_o).colorRes(R.color.dangerColor).actionBarSize());
        Drawable icon = findItem.getIcon();
        if (this.totalCalories == null && this.totalCaloriesGrams == null) {
            findItem.setEnabled(false);
            if (icon != null) {
                icon.mutate();
                icon.setColorFilter(getResources().getColor(R.color.disabledBtnColor), PorterDuff.Mode.SRC_ATOP);
                return;
            }
            return;
        }
        findItem.setEnabled(true);
        if (icon != null) {
            icon.mutate();
            icon.setColorFilter(getResources().getColor(R.color.dangerColor), PorterDuff.Mode.SRC_ATOP);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.save_nutriton) {
            saveNutritionGoal();
            return true;
        } else if (menuItem.getItemId() != R.id.delete_nutrition) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            deleteNutritionClicked();
            return true;
        }
    }

    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: private */
    public void resetViews() {
        if (this.isBreakDownInPercent) {
            this.caloriesWrapper.setVisibility(0);
            this.caloriesWrapperBottom.setVisibility(8);
            TextInputLayout textInputLayout = this.proteinWrapper;
            textInputLayout.setHint((CharSequence) getString(R.string.Protein) + "(%)");
            TextInputLayout textInputLayout2 = this.fatWrapper;
            textInputLayout2.setHint((CharSequence) getString(R.string.fat) + "(%)");
            TextInputLayout textInputLayout3 = this.carbsWrapper;
            textInputLayout3.setHint((CharSequence) getString(R.string.carbs) + "(%)");
            this.caloriesEditText.setText(this.totalCalories);
            this.proteinEditText.setText(this.protein);
            this.fatEditText.setText(this.fat);
            this.carbsEditText.setText(this.carbs);
            this.caloriesEditText.requestFocus();
            EditText editText = this.caloriesEditText;
            editText.setSelection(editText.getText().toString().length());
            ((InputMethodManager) getActivity().getSystemService("input_method")).toggleSoftInput(2, 1);
            return;
        }
        this.caloriesWrapperBottom.setVisibility(0);
        this.caloriesWrapper.setVisibility(8);
        TextInputLayout textInputLayout4 = this.proteinWrapper;
        textInputLayout4.setHint((CharSequence) getString(R.string.Protein) + "(g)");
        TextInputLayout textInputLayout5 = this.fatWrapper;
        textInputLayout5.setHint((CharSequence) getString(R.string.fat) + "(g)");
        TextInputLayout textInputLayout6 = this.carbsWrapper;
        textInputLayout6.setHint((CharSequence) getString(R.string.carbs) + "(g)");
        this.caloriesEditTextBottom.setText(this.totalCaloriesGrams);
        this.proteinEditText.setText(this.proteinGrams);
        this.fatEditText.setText(this.fatGrams);
        this.carbsEditText.setText(this.carbsGrams);
        this.proteinEditText.requestFocus();
        EditText editText2 = this.proteinEditText;
        editText2.setSelection(editText2.getText().toString().length());
        ((InputMethodManager) getActivity().getSystemService("input_method")).toggleSoftInput(2, 1);
    }

    /* access modifiers changed from: private */
    public void updateValues() {
        String trim = this.proteinEditText.getText().toString().trim();
        String trim2 = this.fatEditText.getText().toString().trim();
        String trim3 = this.carbsEditText.getText().toString().trim();
        if (!trim.isEmpty() && !trim2.isEmpty() && !trim3.isEmpty()) {
            this.caloriesEditTextBottom.setText(String.valueOf((Integer.parseInt(trim) * 4) + (Integer.parseInt(trim2) * 9) + (Integer.parseInt(trim3) * 4)));
        }
    }

    /* access modifiers changed from: private */
    public void saveNutritionGoal() {
        if (!this.isSaving) {
            BaseHttpClient baseHttpClient = new BaseHttpClient(true, getActivity());
            HashMap hashMap = new HashMap();
            String trim = (this.isBreakDownInPercent ? this.caloriesEditText : this.caloriesEditTextBottom).getText().toString().trim();
            String trim2 = this.proteinEditText.getText().toString().trim();
            String trim3 = this.fatEditText.getText().toString().trim();
            String trim4 = this.carbsEditText.getText().toString().trim();
            int parseInt = trim2.isEmpty() ? 0 : Integer.parseInt(trim2);
            int parseInt2 = trim3.isEmpty() ? 0 : Integer.parseInt(trim3);
            int parseInt3 = trim4.isEmpty() ? 0 : Integer.parseInt(trim4);
            int parseInt4 = trim.isEmpty() ? 0 : Integer.parseInt(trim);
            if (parseInt4 <= 0) {
                new MaterialDialog.Builder(getActivity()).title((int) R.string.Error).content((CharSequence) "Missing value. All fields are required").positiveText((int) R.string.Ok).show();
            } else if (!this.isBreakDownInPercent || parseInt + parseInt2 + parseInt3 == 100) {
                this.isSaving = true;
                hashMap.put("total_calories", Integer.valueOf(parseInt4));
                hashMap.put("protein", Integer.valueOf(parseInt));
                hashMap.put("fat", Integer.valueOf(parseInt2));
                hashMap.put("carbs", Integer.valueOf(parseInt3));
                hashMap.put("is_breakdown_in_percent", Boolean.valueOf(this.isBreakDownInPercent));
                baseHttpClient.post(String.format("/users/%d/nutrition_plan/0", new Object[]{Integer.valueOf(this.userId)}), hashMap, new BaseResponseHandler() {
                    public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                        boolean unused = EditNutritionFragment.this.isSaving = false;
                        ((EventListener) EditNutritionFragment.this.getActivity()).onSaveNutrition();
                        return true;
                    }

                    public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                        boolean unused = EditNutritionFragment.this.isSaving = false;
                        return true;
                    }
                });
            } else {
                new MaterialDialog.Builder(getActivity()).title((int) R.string.Error).content((CharSequence) "All percent values should add up to 100").positiveText((int) R.string.Ok).show();
            }
        }
    }

    private void deleteNutritionClicked() {
        new MaterialDialog.Builder(getActivity()).title((CharSequence) "Delete Nutrition").content((CharSequence) "Are you sure you want to delete nutrition goal?").positiveText((CharSequence) getString(R.string.Yes)).negativeText((CharSequence) getString(R.string.No)).onPositive(new MaterialDialog.SingleButtonCallback() {
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                EditNutritionFragment.this.deleteNutrition();
            }
        }).build().show();
    }

    /* access modifiers changed from: private */
    public void deleteNutrition() {
        new BaseHttpClient().delete(String.format("/users/%d/nutrition_plan/0", new Object[]{Integer.valueOf(this.userId)}), new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                ((EventListener) EditNutritionFragment.this.getActivity()).onSaveNutrition();
                return true;
            }
        });
    }
}
