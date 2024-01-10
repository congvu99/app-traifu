package com.trainerfu.android;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import com.trainerfu.utils.Util;
import io.intercom.android.sdk.metrics.MetricTracker;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AssessmentPickerFragment extends Fragment {
    /* access modifiers changed from: private */
    public static int ADD_CUSTOM_CT = 6;
    /* access modifiers changed from: private */
    public static int BFP_CT = 3;
    /* access modifiers changed from: private */
    public static int CUSTOM_CT = 5;
    /* access modifiers changed from: private */
    public static int GIRTH_CT = 8;
    /* access modifiers changed from: private */
    public static int HEADER_CT = 1;
    /* access modifiers changed from: private */
    public static int NUTRITION_CT = 9;
    /* access modifiers changed from: private */
    public static int PROGRESS_PHOTO_CT = 4;
    /* access modifiers changed from: private */
    public static int SITES_CT = 7;
    /* access modifiers changed from: private */
    public static int WEIGHT_CT = 2;
    /* access modifiers changed from: private */
    public static Drawable addDrawable;
    /* access modifiers changed from: private */
    public static Drawable bfpDrawable;
    /* access modifiers changed from: private */
    public static Drawable customDrawable;
    /* access modifiers changed from: private */
    public static Drawable girthDrawable;
    /* access modifiers changed from: private */
    public static Drawable nutritionDrawable;
    /* access modifiers changed from: private */
    public static Drawable photoDrawable;
    /* access modifiers changed from: private */
    public static Drawable sitesDrawable;
    /* access modifiers changed from: private */
    public static Drawable weightDrawable;
    private StableArrayAdapter adapter;
    private JSONObject assessmentData;
    /* access modifiers changed from: private */
    public ArrayList<CellDefinition> pickerList = new ArrayList<>();
    private int userId;
    private boolean viewedByTrainer;

    public interface EventListener {
        void onAssessmentTypePicked(JSONObject jSONObject);

        void onCreateNewAssessmentType();

        void onDeleteAssessmentType(int i);

        void onNutritionPicked();

        void onProgressPhotosPicked();
    }

    private static class CellDefinition {
        public int cellType;
        public Object data;

        public CellDefinition(int i, Object obj) {
            this.cellType = i;
            this.data = obj;
        }
    }

    static {
        Context appContext = MyApplication.getAppContext();
        weightDrawable = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.weight_icon, (Resources.Theme) null);
        bfpDrawable = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.body_fat_icon, (Resources.Theme) null);
        nutritionDrawable = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.icon_nutrition, (Resources.Theme) null);
        Drawable drawable = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.outline_2_scale_up, (Resources.Theme) null);
        customDrawable = drawable;
        drawable.setColorFilter(ContextCompat.getColor(appContext, R.color.iconColor), PorterDuff.Mode.SRC_IN);
        Drawable drawable2 = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.outline_design, (Resources.Theme) null);
        sitesDrawable = drawable2;
        drawable2.setColorFilter(ContextCompat.getColor(appContext, R.color.iconColor), PorterDuff.Mode.SRC_IN);
        Drawable drawable3 = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.outline_measure_big, (Resources.Theme) null);
        girthDrawable = drawable3;
        drawable3.setColorFilter(ContextCompat.getColor(appContext, R.color.iconColor), PorterDuff.Mode.SRC_IN);
        Drawable drawable4 = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.outline_1_bold_add, (Resources.Theme) null);
        addDrawable = drawable4;
        drawable4.setColorFilter(ContextCompat.getColor(appContext, R.color.iconColor), PorterDuff.Mode.SRC_IN);
        photoDrawable = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.image_icon, (Resources.Theme) null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.assessment_picker_view, viewGroup, false);
        layoutInflater.inflate(R.layout.listview_header, (ViewGroup) null, false);
        ListView listView = (ListView) inflate.findViewById(R.id.assessment_picker_view);
        StableArrayAdapter stableArrayAdapter = new StableArrayAdapter(getActivity());
        this.adapter = stableArrayAdapter;
        listView.setAdapter(stableArrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                EventListener eventListener = (EventListener) AssessmentPickerFragment.this.getActivity();
                CellDefinition cellDefinition = (CellDefinition) AssessmentPickerFragment.this.pickerList.get(i);
                if (cellDefinition.cellType == AssessmentPickerFragment.WEIGHT_CT || cellDefinition.cellType == AssessmentPickerFragment.BFP_CT || cellDefinition.cellType == AssessmentPickerFragment.CUSTOM_CT || cellDefinition.cellType == AssessmentPickerFragment.SITES_CT || cellDefinition.cellType == AssessmentPickerFragment.GIRTH_CT) {
                    eventListener.onAssessmentTypePicked((JSONObject) cellDefinition.data);
                } else if (cellDefinition.cellType == AssessmentPickerFragment.PROGRESS_PHOTO_CT) {
                    eventListener.onProgressPhotosPicked();
                } else if (cellDefinition.cellType == AssessmentPickerFragment.ADD_CUSTOM_CT) {
                    eventListener.onCreateNewAssessmentType();
                } else if (cellDefinition.cellType == AssessmentPickerFragment.NUTRITION_CT) {
                    eventListener.onNutritionPicked();
                }
            }
        });
        registerForContextMenu(listView);
        return inflate;
    }

    public void onResume() {
        super.onResume();
        buildViewModel();
        this.adapter.notifyDataSetChanged();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            try {
                this.userId = bundle.getInt("user_id");
                this.assessmentData = new JSONObject(bundle.getString("assessment_data"));
                this.viewedByTrainer = bundle.getBoolean("viewed_by_trainer");
                buildViewModel();
                this.adapter.notifyDataSetChanged();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("user_id", this.userId);
        bundle.putString("assessment_data", this.assessmentData.toString());
        bundle.putBoolean("viewed_by_trainer", this.viewedByTrainer);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        CellDefinition cellDefinition = this.pickerList.get(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position);
        if (!this.viewedByTrainer) {
            return;
        }
        if (cellDefinition.cellType == CUSTOM_CT || cellDefinition.cellType == SITES_CT || cellDefinition.cellType == GIRTH_CT) {
            getActivity().getMenuInflater().inflate(R.menu.delete_assessment_type, contextMenu);
        }
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
        if (menuItem.getItemId() != R.id.delete_assessment_type_item) {
            return true;
        }
        CellDefinition cellDefinition = this.pickerList.get(adapterContextMenuInfo.position);
        try {
            ((EventListener) getActivity()).onDeleteAssessmentType(((JSONObject) cellDefinition.data).getInt("id"));
            return true;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void buildViewModel() {
        this.pickerList.clear();
        try {
            this.pickerList.add(new CellDefinition(WEIGHT_CT, this.assessmentData.getJSONObject("weight")));
            this.pickerList.add(new CellDefinition(BFP_CT, this.assessmentData.getJSONObject("bfp")));
            this.pickerList.add(new CellDefinition(PROGRESS_PHOTO_CT, Integer.valueOf(this.assessmentData.getInt("progress_photos"))));
            this.pickerList.add(new CellDefinition(NUTRITION_CT, getString(R.string.nutrition)));
            JSONArray jSONArray = this.assessmentData.getJSONArray("custom");
            if (this.viewedByTrainer) {
                this.pickerList.add(new CellDefinition(HEADER_CT, getString(R.string.CustomAssessments)));
                this.pickerList.add(new CellDefinition(ADD_CUSTOM_CT, (Object) null));
            } else if (jSONArray.length() > 0) {
                this.pickerList.add(new CellDefinition(HEADER_CT, getString(R.string.CustomAssessments)));
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                this.pickerList.add(new CellDefinition(CUSTOM_CT, jSONArray.getJSONObject(i)));
            }
            JSONArray jSONArray2 = this.assessmentData.getJSONArray("sites");
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                if (i2 == 0) {
                    this.pickerList.add(new CellDefinition(HEADER_CT, getString(R.string.Sites)));
                }
                this.pickerList.add(new CellDefinition(SITES_CT, jSONArray2.getJSONObject(i2)));
            }
            JSONArray jSONArray3 = this.assessmentData.getJSONArray("girth");
            for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                if (i3 == 0) {
                    this.pickerList.add(new CellDefinition(HEADER_CT, getString(R.string.Girth)));
                }
                this.pickerList.add(new CellDefinition(GIRTH_CT, jSONArray3.getJSONObject(i3)));
            }
        } catch (JSONException unused) {
            throw new RuntimeException();
        }
    }

    public void setData(int i, JSONObject jSONObject, boolean z) {
        this.userId = i;
        this.assessmentData = jSONObject;
        this.viewedByTrainer = z;
        if (isAdded()) {
            buildViewModel();
            this.adapter.notifyDataSetChanged();
        }
    }

    private class StableArrayAdapter extends BaseAdapter {
        private Context context;

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return false;
        }

        public StableArrayAdapter(Context context2) {
            this.context = context2;
        }

        public int getCount() {
            if (!AssessmentPickerFragment.this.isAdded()) {
                return 0;
            }
            return AssessmentPickerFragment.this.pickerList.size();
        }

        public Object getItem(int i) {
            return AssessmentPickerFragment.this.pickerList.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            CellDefinition cellDefinition = (CellDefinition) AssessmentPickerFragment.this.pickerList.get(i);
            try {
                if (cellDefinition.cellType == AssessmentPickerFragment.HEADER_CT) {
                    LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.list_section_header_view, (ViewGroup) null);
                    ((TextView) linearLayout.findViewById(R.id.section_header_view)).setText((String) cellDefinition.data);
                    return linearLayout;
                }
                LinearLayout linearLayout2 = (LinearLayout) layoutInflater.inflate(R.layout.assessment_picker_row_view, (ViewGroup) null);
                ImageView imageView = (ImageView) linearLayout2.findViewById(R.id.iconView);
                TextView textView = (TextView) linearLayout2.findViewById(R.id.nameView);
                TextView textView2 = (TextView) linearLayout2.findViewById(R.id.latestValueView);
                View findViewById = linearLayout2.findViewById(R.id.dividerView);
                int i2 = i + 1;
                if (i2 < getCount() && ((CellDefinition) AssessmentPickerFragment.this.pickerList.get(i2)).cellType == AssessmentPickerFragment.HEADER_CT) {
                    findViewById.setVisibility(8);
                }
                if (i == getCount() - 1) {
                    findViewById.setVisibility(8);
                }
                if (cellDefinition.cellType == AssessmentPickerFragment.ADD_CUSTOM_CT) {
                    imageView.setImageDrawable(AssessmentPickerFragment.addDrawable);
                    textView.setText(AssessmentPickerFragment.this.getString(R.string.CreateACustomAssessment));
                    findViewById.setVisibility(8);
                } else if (cellDefinition.cellType == AssessmentPickerFragment.PROGRESS_PHOTO_CT) {
                    imageView.setImageDrawable(AssessmentPickerFragment.photoDrawable);
                    textView.setText(AssessmentPickerFragment.this.getString(R.string.ProgressPhotos));
                    textView2.setText(String.valueOf(cellDefinition.data));
                } else if (cellDefinition.cellType == AssessmentPickerFragment.NUTRITION_CT) {
                    imageView.setImageDrawable(AssessmentPickerFragment.nutritionDrawable);
                    textView.setText(AssessmentPickerFragment.this.getString(R.string.nutrition));
                    findViewById.setVisibility(8);
                } else {
                    JSONObject jSONObject = (JSONObject) cellDefinition.data;
                    textView.setText(jSONObject.getString("name"));
                    JSONArray jSONArray = jSONObject.getJSONArray("assessments");
                    if (jSONArray.length() > 0) {
                        textView2.setText(jSONArray.getJSONArray(jSONArray.length() - 1).getString(2));
                    }
                    if (jSONObject.has("goal")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("goal");
                        linearLayout2.findViewById(R.id.goalView).setVisibility(0);
                        int i3 = jSONObject2.getInt(MetricTracker.Action.COMPLETED);
                        linearLayout2.findViewById(R.id.completedView).getLayoutParams().width = Util.sizeInPx(AssessmentPickerFragment.this.getActivity(), (int) (i3 == 0 ? 1.0d : ((double) i3) * 1.8d));
                        linearLayout2.findViewById(R.id.contentView).setPadding(0, Util.sizeInPx(AssessmentPickerFragment.this.getActivity(), 10), 0, 0);
                        ((TextView) linearLayout2.findViewById(R.id.goalDetailView)).setText(String.format(AssessmentPickerFragment.this.getString(R.string.goalDetail), new Object[]{String.valueOf(jSONObject2.getDouble("goal")), String.valueOf(jSONObject2.getInt("days_left"))}));
                    }
                    if (cellDefinition.cellType == AssessmentPickerFragment.WEIGHT_CT) {
                        imageView.setImageDrawable(AssessmentPickerFragment.weightDrawable);
                    } else if (cellDefinition.cellType == AssessmentPickerFragment.BFP_CT) {
                        imageView.setImageDrawable(AssessmentPickerFragment.bfpDrawable);
                    } else if (cellDefinition.cellType == AssessmentPickerFragment.SITES_CT) {
                        imageView.setImageDrawable(AssessmentPickerFragment.sitesDrawable);
                    } else if (cellDefinition.cellType == AssessmentPickerFragment.GIRTH_CT) {
                        imageView.setImageDrawable(AssessmentPickerFragment.girthDrawable);
                    } else if (cellDefinition.cellType == AssessmentPickerFragment.CUSTOM_CT) {
                        imageView.setImageDrawable(AssessmentPickerFragment.customDrawable);
                    }
                }
                return linearLayout2;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
