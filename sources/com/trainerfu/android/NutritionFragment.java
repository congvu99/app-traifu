package com.trainerfu.android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.joanzapata.iconify.widget.IconTextView;
import com.trainerfu.story.StoryListActivity;
import com.trainerfu.story.StoryListViewType;
import com.trainerfu.story.StoryType;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.DateUtils;
import java.util.HashMap;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NutritionFragment extends Fragment {
    private LinearLayout btnWrapper;
    /* access modifiers changed from: private */
    public TextView caloriesGoal;
    /* access modifiers changed from: private */
    public String carbs;
    /* access modifiers changed from: private */
    public TextView carbsGoal;
    /* access modifiers changed from: private */
    public TextView carbsLabel;
    /* access modifiers changed from: private */
    public IconTextView editNutritionBtn;
    /* access modifiers changed from: private */
    public String fat;
    /* access modifiers changed from: private */
    public TextView fatGoal;
    /* access modifiers changed from: private */
    public TextView fatLabel;
    /* access modifiers changed from: private */
    public boolean isBreakDownInPercent = true;
    /* access modifiers changed from: private */
    public NutritionLogsAdapter nutritionLogsAdapter;
    /* access modifiers changed from: private */
    public ListView nutritionLogsListView;
    /* access modifiers changed from: private */
    public LinearLayout nutritionLogsView;
    /* access modifiers changed from: private */
    public String protein;
    /* access modifiers changed from: private */
    public TextView proteinGoal;
    /* access modifiers changed from: private */
    public TextView proteinLabel;
    /* access modifiers changed from: private */
    public JSONArray stories = new JSONArray();
    /* access modifiers changed from: private */
    public String totalCalories;
    private int userId;
    /* access modifiers changed from: private */
    public boolean viewedByTrainer;

    public interface EventListener {
        void onEditNutritionGoal(Bundle bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.userId = arguments.getInt("userId");
        this.viewedByTrainer = arguments.getBoolean("viewed_by_trainer");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.fragment_nutrition, viewGroup, false);
        this.proteinLabel = (TextView) inflate.findViewById(R.id.protein_label);
        this.fatLabel = (TextView) inflate.findViewById(R.id.fat_label);
        this.carbsLabel = (TextView) inflate.findViewById(R.id.carbs_label);
        this.caloriesGoal = (TextView) inflate.findViewById(R.id.calories_goal);
        this.proteinGoal = (TextView) inflate.findViewById(R.id.protein_goal);
        this.fatGoal = (TextView) inflate.findViewById(R.id.fat_goal);
        this.carbsGoal = (TextView) inflate.findViewById(R.id.carbs_goal);
        this.btnWrapper = (LinearLayout) inflate.findViewById(R.id.nutrition_btn_wrapper);
        this.editNutritionBtn = (IconTextView) inflate.findViewById(R.id.edit_daily_nutrition_btn);
        this.nutritionLogsView = (LinearLayout) inflate.findViewById(R.id.nutrition_logs_view);
        this.nutritionLogsListView = (ListView) inflate.findViewById(R.id.nutrition_logs_list);
        NutritionLogsAdapter nutritionLogsAdapter2 = new NutritionLogsAdapter(getContext());
        this.nutritionLogsAdapter = nutritionLogsAdapter2;
        this.nutritionLogsListView.setAdapter(nutritionLogsAdapter2);
        this.editNutritionBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("is_breakdown_in_percent", NutritionFragment.this.isBreakDownInPercent);
                bundle.putString("total_calories", NutritionFragment.this.totalCalories);
                bundle.putString("protein", NutritionFragment.this.protein);
                bundle.putString("fat", NutritionFragment.this.fat);
                bundle.putString("carbs", NutritionFragment.this.carbs);
                ((EventListener) NutritionFragment.this.getActivity()).onEditNutritionGoal(bundle);
            }
        });
        if (!this.viewedByTrainer) {
            this.nutritionLogsView.setVisibility(8);
            this.btnWrapper.setVisibility(8);
        }
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle((CharSequence) getString(R.string.nutrition));
        return inflate;
    }

    public void onResume() {
        super.onResume();
        getNutritionGoals(true);
        getUserMealLogs();
    }

    public void onSaveNutrition() {
        getNutritionGoals(true);
    }

    private void getNutritionGoals(boolean z) {
        new BaseHttpClient(Boolean.valueOf(z), getActivity()).get(String.format("/users/%d/nutrition_plan", new Object[]{Integer.valueOf(this.userId)}), new HashMap(), new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONArray jSONArray) {
                try {
                    if (!jSONArray.get(0).equals((Object) null)) {
                        JSONObject jSONObject = jSONArray.getJSONObject(0);
                        boolean unused = NutritionFragment.this.isBreakDownInPercent = jSONObject.getBoolean("is_breakdown_in_percent");
                        String unused2 = NutritionFragment.this.totalCalories = jSONObject.getString("total_calories");
                        String unused3 = NutritionFragment.this.protein = jSONObject.getString("protein");
                        String unused4 = NutritionFragment.this.fat = jSONObject.getString("fat");
                        String unused5 = NutritionFragment.this.carbs = jSONObject.getString("carbs");
                        String str = NutritionFragment.this.isBreakDownInPercent ? "(%)" : "(g)";
                        TextView access$500 = NutritionFragment.this.proteinLabel;
                        access$500.setText(NutritionFragment.this.getString(R.string.protein) + str);
                        TextView access$600 = NutritionFragment.this.fatLabel;
                        access$600.setText(NutritionFragment.this.getString(R.string.fat) + str);
                        TextView access$700 = NutritionFragment.this.carbsLabel;
                        access$700.setText(NutritionFragment.this.getString(R.string.carbs) + str);
                        NutritionFragment.this.caloriesGoal.setText(NutritionFragment.this.totalCalories);
                        NutritionFragment.this.proteinGoal.setText(NutritionFragment.this.protein);
                        NutritionFragment.this.fatGoal.setText(NutritionFragment.this.fat);
                        NutritionFragment.this.carbsGoal.setText(NutritionFragment.this.carbs);
                        NutritionFragment.this.editNutritionBtn.setText(NutritionFragment.this.getString(R.string.editDailyNutritionGoal));
                    } else {
                        String unused6 = NutritionFragment.this.totalCalories = null;
                        String unused7 = NutritionFragment.this.protein = null;
                        String unused8 = NutritionFragment.this.fat = null;
                        String unused9 = NutritionFragment.this.carbs = null;
                        boolean unused10 = NutritionFragment.this.isBreakDownInPercent = true;
                        NutritionFragment.this.caloriesGoal.setText("-");
                        NutritionFragment.this.proteinGoal.setText("-");
                        NutritionFragment.this.fatGoal.setText("-");
                        NutritionFragment.this.carbsGoal.setText("-");
                        NutritionFragment.this.editNutritionBtn.setText(NutritionFragment.this.getString(R.string.setDailyNutritionGoal));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return true;
            }
        });
    }

    private void getUserMealLogs() {
        HashMap hashMap = new HashMap();
        hashMap.put("diary_user_id", Integer.valueOf(this.userId));
        hashMap.put("story_type", Integer.valueOf(StoryType.MEAL_LOG.getMask()));
        hashMap.put("limit", 100);
        new BaseHttpClient(false, getActivity()).get("/stories2", hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                if (!NutritionFragment.this.isAdded()) {
                    return true;
                }
                try {
                    JSONArray unused = NutritionFragment.this.stories = jSONObject.getJSONArray("stories");
                    if (NutritionFragment.this.stories.length() == 0) {
                        NutritionFragment.this.nutritionLogsView.setVisibility(8);
                    } else if (NutritionFragment.this.viewedByTrainer) {
                        NutritionFragment.this.nutritionLogsView.setVisibility(0);
                        NutritionFragment.this.nutritionLogsAdapter.notifyDataSetChanged();
                        NutritionFragment.setListViewHeightBasedOnChildren(NutritionFragment.this.nutritionLogsListView);
                    }
                    return true;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }

            public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                return super.handleFailure(i, headerArr, th, jSONObject);
            }
        });
    }

    private class NutritionLogsAdapter extends BaseAdapter {
        private Context context;

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }

        public NutritionLogsAdapter(Context context2) {
            this.context = context2;
        }

        public int getCount() {
            return NutritionFragment.this.stories.length();
        }

        public Object getItem(int i) {
            try {
                return NutritionFragment.this.stories.getJSONObject(i);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            String str = null;
            View inflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.nutrition_log_row, (ViewGroup) null);
            final JSONObject jSONObject = (JSONObject) getItem(i);
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("story");
                String string = jSONObject2.getString("d");
                String string2 = jSONObject2.has("t") ? jSONObject2.getString("t") : null;
                String string3 = jSONObject2.has("tpr") ? jSONObject2.getString("tpr") : null;
                String string4 = jSONObject2.has("tfa") ? jSONObject2.getString("tfa") : null;
                String string5 = jSONObject2.has("tca") ? jSONObject2.getString("tca") : null;
                String string6 = jSONObject2.has("gc") ? jSONObject2.getString("gc") : null;
                String string7 = jSONObject2.has("gpr") ? jSONObject2.getString("gpr") : null;
                String string8 = jSONObject2.has("gfa") ? jSONObject2.getString("gfa") : null;
                if (jSONObject2.has("gca")) {
                    str = jSONObject2.getString("gca");
                }
                TextView textView = (TextView) inflate.findViewById(R.id.calories_total);
                TextView textView2 = (TextView) inflate.findViewById(R.id.protein_total);
                TextView textView3 = (TextView) inflate.findViewById(R.id.fat_total);
                String str2 = str;
                TextView textView4 = (TextView) inflate.findViewById(R.id.carbs_total);
                String str3 = string8;
                TextView textView5 = (TextView) inflate.findViewById(R.id.goal_header);
                TextView textView6 = (TextView) inflate.findViewById(R.id.calories_goal);
                TextView textView7 = (TextView) inflate.findViewById(R.id.protein_goal);
                TextView textView8 = (TextView) inflate.findViewById(R.id.fat_goal);
                TextView textView9 = (TextView) inflate.findViewById(R.id.carbs_goal);
                View view2 = inflate;
                ((IconTextView) inflate.findViewById(R.id.see_meal_log_btn)).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        try {
                            Intent intent = new Intent(NutritionFragment.this.getActivity(), StoryListActivity.class);
                            intent.putExtra("story_list_view_type", StoryListViewType.SINGLE_STORY_VIEW.getMask());
                            intent.putExtra("story_id", jSONObject.getInt("story_id"));
                            intent.putExtra("focusCommentView", false);
                            NutritionFragment.this.startActivity(intent);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                ((TextView) inflate.findViewById(R.id.date_val)).setText(DateUtils.getDisplayDate(NutritionFragment.this.getContext(), DateUtils.getDateFromISOFormat(string)));
                if (string2 == null) {
                    string2 = "-";
                }
                textView.setText(string2);
                if (string3 == null) {
                    string3 = "-";
                }
                textView2.setText(string3);
                if (string4 == null) {
                    string4 = "-";
                }
                textView3.setText(string4);
                if (string5 == null) {
                    string5 = "-";
                }
                textView4.setText(string5);
                if (!(string6 == null || string7 == null || str3 == null || str2 == null)) {
                    textView5.setVisibility(0);
                    TextView textView10 = textView6;
                    textView10.setVisibility(0);
                    TextView textView11 = textView7;
                    textView11.setVisibility(0);
                    TextView textView12 = textView8;
                    textView12.setVisibility(0);
                    TextView textView13 = textView9;
                    textView13.setVisibility(0);
                    textView10.setText(string6);
                    textView11.setText(string7);
                    textView12.setText(str3);
                    textView13.setText(str2);
                }
                return view2;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter != null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), 0);
            View view = null;
            int i = 0;
            for (int i2 = 0; i2 < adapter.getCount(); i2++) {
                view = adapter.getView(i2, view, listView);
                view.measure(makeMeasureSpec, 0);
                i += view.getMeasuredHeight();
            }
            ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = i + (listView.getDividerHeight() * (adapter.getCount() - 1));
            listView.setLayoutParams(layoutParams);
        }
    }
}
