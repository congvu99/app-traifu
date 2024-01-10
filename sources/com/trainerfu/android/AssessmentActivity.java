package com.trainerfu.android;

import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.afollestad.materialdialogs.MaterialDialog;
import com.trainerfu.android.AddAssessmentFragment;
import com.trainerfu.android.AssessmentFragment;
import com.trainerfu.android.AssessmentPickerFragment;
import com.trainerfu.android.EditNutritionFragment;
import com.trainerfu.android.NutritionFragment;
import com.trainerfu.android.ProgressPhotoViewFragment;
import com.trainerfu.android.ProgressPhotosFragment;
import com.trainerfu.android.SetGoalFragment;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.DateUtils;
import com.trainerfu.utils.Util;
import java.util.Date;
import java.util.HashMap;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AssessmentActivity extends BaseActivity implements AssessmentFragment.EventListener, AssessmentPickerFragment.EventListener, AddAssessmentFragment.EventListener, SetGoalFragment.EventListener, ProgressPhotosFragment.EventListener, ProgressPhotoViewFragment.EventListener, NutritionFragment.EventListener, EditNutritionFragment.EventListener {
    /* access modifiers changed from: private */
    public JSONObject assessmentData = null;
    private HashMap<Integer, JSONObject> assessmentDataByType = new HashMap<>();
    private String assessmentTitle;
    private String clientFirstName;
    private boolean forceReloadOnResume = false;
    private int userId;
    private boolean viewedByTrainer;

    public AssessmentActivity() {
        super(false);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.assessment_view_container);
        Bundle extras = getIntent().getExtras();
        this.userId = extras.getInt("userId");
        this.viewedByTrainer = extras.getBoolean("viewed_by_trainer");
        this.clientFirstName = extras.getString("context_user_first_name");
        setTitle(getString(R.string.trackProgress));
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            public void onBackStackChanged() {
                AssessmentActivity.this.onBackStackChanged();
            }
        });
        this.assessmentTitle = String.format("%s's %s", new Object[]{this.clientFirstName, getString(R.string.assessments)});
        getSupportActionBar().setTitle((CharSequence) this.assessmentTitle);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle.containsKey("assessment_data")) {
            try {
                this.assessmentData = new JSONObject(bundle.getString("assessment_data"));
                prepareAssessmentDataByType();
                this.forceReloadOnResume = false;
                reloadViews();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        JSONObject jSONObject = this.assessmentData;
        if (jSONObject != null) {
            bundle.putString("assessment_data", jSONObject.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.assessmentData == null || this.forceReloadOnResume) {
            this.forceReloadOnResume = false;
            reloadData();
        }
    }

    /* access modifiers changed from: private */
    public void reloadData() {
        reloadData(this.assessmentData == null);
    }

    /* access modifiers changed from: private */
    public void reloadData(boolean z) {
        BaseHttpClient baseHttpClient = new BaseHttpClient(Boolean.valueOf(z), this);
        HashMap hashMap = new HashMap();
        hashMap.put("today", DateUtils.getISOFormattedDate(DateUtils.getTodaysDate()));
        baseHttpClient.get(String.format("/users/%s/progress", new Object[]{Integer.valueOf(this.userId)}), hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                JSONObject unused = AssessmentActivity.this.assessmentData = jSONObject;
                AssessmentActivity.this.prepareAssessmentDataByType();
                AssessmentActivity.this.reloadViews();
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    public void prepareAssessmentDataByType() {
        try {
            JSONObject jSONObject = this.assessmentData.getJSONObject("weight");
            this.assessmentDataByType.put(Integer.valueOf(jSONObject.getInt("id")), jSONObject);
            JSONObject jSONObject2 = this.assessmentData.getJSONObject("bfp");
            this.assessmentDataByType.put(Integer.valueOf(jSONObject2.getInt("id")), jSONObject2);
            JSONArray jSONArray = this.assessmentData.getJSONArray("custom");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.assessmentDataByType.put(Integer.valueOf(jSONArray.getJSONObject(i).getInt("id")), jSONArray.getJSONObject(i));
            }
            JSONArray jSONArray2 = this.assessmentData.getJSONArray("sites");
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                this.assessmentDataByType.put(Integer.valueOf(jSONArray2.getJSONObject(i2).getInt("id")), jSONArray2.getJSONObject(i2));
            }
            JSONArray jSONArray3 = this.assessmentData.getJSONArray("girth");
            for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                this.assessmentDataByType.put(Integer.valueOf(jSONArray3.getJSONObject(i3).getInt("id")), jSONArray3.getJSONObject(i3));
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void reloadViews() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        AssessmentPickerFragment assessmentPickerFragment = (AssessmentPickerFragment) supportFragmentManager.findFragmentByTag("apf");
        if (assessmentPickerFragment == null) {
            assessmentPickerFragment = new AssessmentPickerFragment();
            getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) assessmentPickerFragment, "apf").commit();
        }
        assessmentPickerFragment.setData(this.userId, this.assessmentData, this.viewedByTrainer);
        AssessmentFragment assessmentFragment = (AssessmentFragment) supportFragmentManager.findFragmentByTag("af");
        if (assessmentFragment != null) {
            try {
                JSONObject assessmentData2 = assessmentFragment.getAssessmentData();
                if (assessmentData2 != null) {
                    assessmentFragment.setData(this.userId, this.assessmentDataByType.get(Integer.valueOf(assessmentData2.getInt("id"))), this.viewedByTrainer, this.clientFirstName);
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        ProgressPhotosFragment progressPhotosFragment = (ProgressPhotosFragment) supportFragmentManager.findFragmentByTag("ppf");
        if (progressPhotosFragment != null) {
            progressPhotosFragment.setData(this.userId, this.assessmentData, this.viewedByTrainer);
        }
    }

    public void onAssessmentTypePicked(JSONObject jSONObject) {
        AssessmentFragment assessmentFragment = new AssessmentFragment();
        assessmentFragment.setData(this.userId, jSONObject, this.viewedByTrainer, this.clientFirstName);
        getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) assessmentFragment, "af").addToBackStack("af").commit();
    }

    public void onProgressPhotosPicked() {
        ProgressPhotosFragment progressPhotosFragment = new ProgressPhotosFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("userId", this.userId);
        progressPhotosFragment.setArguments(bundle);
        progressPhotosFragment.setData(this.userId, this.assessmentData, this.viewedByTrainer);
        getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) progressPhotosFragment, "ppf").addToBackStack("ppf").commit();
    }

    public void onProgressPhotoClicked(JSONObject jSONObject) {
        ProgressPhotoViewFragment progressPhotoViewFragment = new ProgressPhotoViewFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("userId", this.userId);
        progressPhotoViewFragment.setArguments(bundle);
        progressPhotoViewFragment.setData(jSONObject);
        getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) progressPhotoViewFragment, "ppvf").addToBackStack("ppvf").commit();
    }

    public void onCreateNewAssessmentType() {
        new MaterialDialog.Builder(this).title((int) R.string.NewAssessmentType).content((CharSequence) "").inputType(16384).input((CharSequence) getString(R.string.Name), (CharSequence) "", (MaterialDialog.InputCallback) new MaterialDialog.InputCallback() {
            public void onInput(MaterialDialog materialDialog, CharSequence charSequence) {
                String trim = charSequence.toString().trim();
                if (trim.length() > 0) {
                    AssessmentActivity.this.createNewAssessmentType(trim);
                }
            }
        }).positiveText((int) R.string.Save).negativeText((int) R.string.cancel).positiveColor(ContextCompat.getColor(this, R.color.tintColor)).negativeColor(ContextCompat.getColor(this, R.color.grayColor)).show();
    }

    /* access modifiers changed from: private */
    public void createNewAssessmentType(String str) {
        BaseHttpClient baseHttpClient = new BaseHttpClient(true, this);
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        baseHttpClient.put("/assessment_types/new", hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                AssessmentActivity.this.reloadData(true);
                return true;
            }
        });
    }

    public void onDeleteAssessmentType(int i) {
        BaseHttpClient baseHttpClient = new BaseHttpClient(true, this);
        HashMap hashMap = new HashMap();
        hashMap.put("is_active", false);
        baseHttpClient.post(String.format("/assessment_types/%s", new Object[]{String.valueOf(i)}), hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                AssessmentActivity.this.reloadData(true);
                return true;
            }
        });
    }

    public void onNutritionPicked() {
        NutritionFragment nutritionFragment = new NutritionFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("userId", this.userId);
        bundle.putBoolean("viewed_by_trainer", this.viewedByTrainer);
        nutritionFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) nutritionFragment, "nf").addToBackStack("nf").commit();
    }

    public void onEditNutritionGoal(Bundle bundle) {
        EditNutritionFragment editNutritionFragment = new EditNutritionFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("userId", this.userId);
        bundle2.putBoolean("viewed_by_trainer", this.viewedByTrainer);
        bundle2.putBundle("info", bundle);
        editNutritionFragment.setArguments(bundle2);
        getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) editNutritionFragment, "enf").addToBackStack("enf").commit();
    }

    public void newAssessmentAdded(Date date, float f) {
        getSupportFragmentManager().popBackStack();
        reloadData();
    }

    public void addingAssessmentCancelled() {
        getSupportFragmentManager().popBackStack();
    }

    public void onAddAssessmentClicked(JSONObject jSONObject) {
        AddAssessmentFragment addAssessmentFragment = new AddAssessmentFragment();
        Bundle bundle = new Bundle();
        try {
            bundle.putString("assessmentTypeName", jSONObject.getString("name"));
            bundle.putInt("userId", this.userId);
            bundle.putInt("assessmentTypeId", jSONObject.getInt("id"));
            addAssessmentFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) addAssessmentFragment, "aaf").addToBackStack("aaf").commit();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void onAssessmentDeleted() {
        reloadData();
    }

    public void onSetGoalClicked(JSONObject jSONObject) {
        SetGoalFragment setGoalFragment = new SetGoalFragment();
        Bundle bundle = new Bundle();
        try {
            bundle.putString("assessment_type_name", jSONObject.getString("name"));
            bundle.putInt("user_id", this.userId);
            bundle.putInt("assessment_type_id", jSONObject.getInt("id"));
            JSONArray jSONArray = jSONObject.getJSONArray("assessments");
            if (jSONArray.length() > 0) {
                bundle.putDouble("current_measurement", jSONArray.getJSONArray(jSONArray.length() - 1).getDouble(2));
            }
            setGoalFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) setGoalFragment, "sgf").addToBackStack("sgf").commit();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void onGoalDeleted(int i) {
        new BaseHttpClient().delete(String.format("/users/%s/goals/%s", new Object[]{String.valueOf(this.userId), String.valueOf(i)}), new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                AssessmentActivity.this.reloadData();
                return true;
            }

            public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                AssessmentActivity.this.reloadData();
                return false;
            }
        });
    }

    public void onSettingGoalCancelled() {
        getSupportFragmentManager().popBackStack();
    }

    public void onSettingNewGoal() {
        getSupportFragmentManager().popBackStack();
        reloadData();
    }

    public void onEditNutritionCancel() {
        Util.hideKeyboard(this);
        getSupportFragmentManager().popBackStack();
    }

    public void onSaveNutrition() {
        Util.hideKeyboard(this);
        getSupportFragmentManager().popBackStack();
        NutritionFragment nutritionFragment = (NutritionFragment) getSupportFragmentManager().findFragmentByTag("nf");
        if (nutritionFragment != null) {
            nutritionFragment.onSaveNutrition();
        }
    }

    public void onDeletePhoto(boolean z) {
        if (z) {
            getSupportFragmentManager().popBackStack();
        }
        reloadData();
    }

    public void onAddNewPhoto() {
        reloadData();
    }

    public void onBackStackChanged() {
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        if (backStackEntryCount > 0) {
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName());
            if (findFragmentByTag instanceof AddAssessmentFragment) {
                ((AddAssessmentFragment) findFragmentByTag).setActionBarTitle();
            } else if (findFragmentByTag instanceof SetGoalFragment) {
                ((SetGoalFragment) findFragmentByTag).setActionBarTitle();
            } else if (findFragmentByTag instanceof AssessmentFragment) {
                ((AssessmentFragment) findFragmentByTag).setActionBarTitle();
            } else if (findFragmentByTag instanceof ProgressPhotoViewFragment) {
                ProgressPhotoViewFragment progressPhotoViewFragment = (ProgressPhotoViewFragment) findFragmentByTag;
            } else if (findFragmentByTag instanceof ProgressPhotosFragment) {
                getSupportActionBar().setTitle((int) R.string.progressPhotos);
                getSupportActionBar().setElevation(10.0f);
            } else if (findFragmentByTag instanceof NutritionFragment) {
                getSupportActionBar().setTitle((int) R.string.nutrition);
                getSupportActionBar().setElevation(10.0f);
            } else if (findFragmentByTag instanceof EditNutritionFragment) {
                getSupportActionBar().setTitle((int) R.string.dailyNutritionGoal);
                getSupportActionBar().setElevation(10.0f);
            } else {
                getSupportActionBar().setTitle((CharSequence) this.assessmentTitle);
            }
        }
        if (backStackEntryCount == 0) {
            getSupportActionBar().setTitle((CharSequence) this.assessmentTitle);
        }
    }
}
