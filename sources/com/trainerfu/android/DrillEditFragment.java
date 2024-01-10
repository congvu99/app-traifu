package com.trainerfu.android;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.AppEventsConstants;
import com.trainerfu.android.DrillQuickEntryView;
import com.trainerfu.utils.DateUtils;
import com.trainerfu.utils.ExerciseStats;
import io.intercom.android.sdk.models.Part;
import java.util.Iterator;
import kotlinx.serialization.json.internal.JsonLexerKt;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DrillEditFragment extends Fragment implements View.OnClickListener {
    private LinearLayout btnsWrapper;
    private int clientId = 0;
    private boolean didLoadExerciseStats = false;
    /* access modifiers changed from: private */
    public EditText etWithFocus;
    /* access modifiers changed from: private */
    public JSONArray exerciseHistory = new JSONArray();
    private ExerciseHistoryAdapter exerciseHistoryAdapter;
    private ListView exerciseHistoryListView;
    private int exerciseId = 0;
    private String exerciseName;
    private LinearLayout historyView;
    private Bundle info;
    private Boolean isCustomActionBar = false;
    private Boolean isViewedByTrainer;
    private JSONObject measures;
    private Menu menu;
    private LinearLayout noHistoryView;
    private String note = "";
    private JSONObject recentlyLoggedExerciseStats = null;
    private JSONObject recentlyPlannedExerciseStats = null;
    private String rest;
    private boolean showRecentLoggedExerciseStats = false;
    private boolean showRecentPlannedExerciseStats = false;
    private ViewGroup view;
    private Toolbar workoutHeader;
    private TextView workoutTitleView;

    public interface EventListener {
        void drillEditCancelled();

        void drillEdited(Bundle bundle, JSONObject jSONObject, String str);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        EditText editText;
        super.onCreateView(layoutInflater, viewGroup, bundle);
        setHasOptionsMenu(true);
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.drill_edit_view, viewGroup, false);
        this.view = viewGroup2;
        Toolbar toolbar = (Toolbar) viewGroup2.findViewById(R.id.workoutHeader);
        this.workoutHeader = toolbar;
        this.workoutTitleView = (TextView) toolbar.findViewById(R.id.workoutTitle);
        this.btnsWrapper = (LinearLayout) this.view.findViewById(R.id.btns_wrapper);
        this.exerciseHistoryListView = (ListView) this.view.findViewById(R.id.exercise_history_list);
        this.historyView = (LinearLayout) this.view.findViewById(R.id.history_view);
        this.noHistoryView = (LinearLayout) this.view.findViewById(R.id.no_history_view);
        try {
            Bundle arguments = getArguments();
            this.info = arguments.getBundle("info");
            this.measures = new JSONObject(arguments.getString("measures"));
            String string = arguments.getString("history");
            if (string != null) {
                this.exerciseHistory = new JSONArray(string);
            }
            this.rest = arguments.getString("rest");
            this.note = this.info.getString(Part.NOTE_MESSAGE_STYLE);
            this.exerciseName = this.info.getString("exercise_name");
            this.exerciseId = this.info.getInt("exercise_id");
            this.isViewedByTrainer = Boolean.valueOf(this.info.getBoolean("viewed_by_trainer"));
            Boolean valueOf = Boolean.valueOf(arguments.getBoolean("custom_action_bar"));
            this.isCustomActionBar = valueOf;
            if (!valueOf.booleanValue()) {
                ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle((CharSequence) this.exerciseName);
                this.workoutHeader.setVisibility(8);
            } else {
                ((AppCompatActivity) getActivity()).setSupportActionBar(this.workoutHeader);
                this.workoutTitleView.setText(this.exerciseName);
                this.workoutHeader.setVisibility(0);
            }
            if (this.isViewedByTrainer.booleanValue()) {
                this.btnsWrapper.setVisibility(0);
            }
            this.clientId = this.info.getInt("clientId");
            if (arguments.getBoolean("show_history_view")) {
                if (this.exerciseHistory.length() == 0) {
                    this.noHistoryView.setVisibility(0);
                } else {
                    ExerciseHistoryAdapter exerciseHistoryAdapter2 = new ExerciseHistoryAdapter(getContext());
                    this.exerciseHistoryAdapter = exerciseHistoryAdapter2;
                    this.exerciseHistoryListView.setAdapter(exerciseHistoryAdapter2);
                    this.historyView.setVisibility(0);
                    this.exerciseHistoryAdapter.notifyDataSetChanged();
                    setListViewHeightBasedOnChildren(this.exerciseHistoryListView);
                }
            }
            Iterator<String> keys = this.measures.keys();
            boolean z = false;
            while (true) {
                boolean hasNext = keys.hasNext();
                i = R.id.dev_distance_value;
                if (!hasNext) {
                    break;
                }
                String next = keys.next();
                int parseInt = Integer.parseInt(next);
                View view2 = null;
                if (parseInt == 2) {
                    view2 = this.view.findViewById(R.id.dev_reps_wrapper);
                    editText = (EditText) this.view.findViewById(R.id.dev_reps_value);
                } else if (parseInt == 4) {
                    view2 = this.view.findViewById(R.id.dev_weight_wrapper);
                    editText = (EditText) this.view.findViewById(R.id.dev_weight_value);
                } else if (parseInt == 8) {
                    view2 = this.view.findViewById(R.id.dev_sets_wrapper);
                    EditText editText2 = (EditText) this.view.findViewById(R.id.dev_sets_value);
                    getQuickEntryView(editText2).setVisibility(0);
                    editText = editText2;
                    z = true;
                } else if (parseInt == 16) {
                    view2 = this.view.findViewById(R.id.dev_duration_wrapper);
                    editText = (EditText) this.view.findViewById(R.id.dev_duration_value);
                } else if (parseInt != 32) {
                    editText = null;
                } else {
                    view2 = this.view.findViewById(R.id.dev_distance_wrapper);
                    editText = (EditText) this.view.findViewById(R.id.dev_distance_value);
                    getQuickEntryView(editText).setVisibility(0);
                }
                setupET(view2, editText, this.measures.getString(next));
            }
            setupET(this.view.findViewById(R.id.dev_rest_wrapper), (EditText) this.view.findViewById(R.id.dev_rest_value), this.rest);
            EditText editText3 = (EditText) this.view.findViewById(R.id.dev_notes_value);
            this.view.findViewById(R.id.dev_notes_wrapper).setVisibility(0);
            editText3.setText((this.note == null || this.note.equals(JsonLexerKt.NULL)) ? "" : this.note);
            editText3.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i != 6) {
                        return false;
                    }
                    DrillEditFragment.this.syncWithUserEnteredData();
                    return true;
                }
            });
            this.view.findViewById(R.id.dev_save_btn).setOnClickListener(this);
            this.view.findViewById(R.id.dev_cancel_btn).setOnClickListener(this);
            if (bundle == null) {
                if (z) {
                    i = R.id.dev_sets_value;
                }
                EditText editText4 = (EditText) this.view.findViewById(i);
                editText4.requestFocus();
                this.etWithFocus = editText4;
                ((InputMethodManager) getActivity().getSystemService("input_method")).toggleSoftInput(2, 1);
            }
            for (int i2 = 0; i2 <= this.view.getChildCount(); i2++) {
                View childAt = this.view.getChildAt(i2);
                if (childAt instanceof DrillQuickEntryView) {
                    ((DrillQuickEntryView) childAt).setEventListener(new DrillQuickEntryView.EventListener() {
                        public void keyPressedWithText(String str) {
                            if (DrillEditFragment.this.etWithFocus != null) {
                                DrillEditFragment.this.etWithFocus.append(str);
                            }
                        }
                    });
                }
            }
            KeyboardVisibilityEvent.setEventListener(getActivity(), new KeyboardVisibilityEventListener() {
                public void onVisibilityChanged(boolean z) {
                    if (!z && DrillEditFragment.this.etWithFocus != null) {
                        DrillEditFragment drillEditFragment = DrillEditFragment.this;
                        if (drillEditFragment.getQuickEntryView(drillEditFragment.etWithFocus) != null) {
                            DrillEditFragment drillEditFragment2 = DrillEditFragment.this;
                            drillEditFragment2.getQuickEntryView(drillEditFragment2.etWithFocus).setVisibility(8);
                        }
                    }
                }
            });
            return this.view;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setupET(View view2, final EditText editText, String str) {
        view2.setVisibility(0);
        if (!str.trim().equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO) && !str.trim().equalsIgnoreCase("0.0")) {
            editText.setText(str);
            DrillQuickEntryView quickEntryView = getQuickEntryView(editText);
            if (quickEntryView != null) {
                quickEntryView.showPrefix(true);
            }
        }
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                DrillQuickEntryView access$100 = DrillEditFragment.this.getQuickEntryView(editText);
                if (z) {
                    if (access$100 != null) {
                        access$100.setVisibility(0);
                    }
                    EditText unused = DrillEditFragment.this.etWithFocus = editText;
                } else if (access$100 != null) {
                    access$100.setVisibility(8);
                }
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                DrillQuickEntryView access$100 = DrillEditFragment.this.getQuickEntryView(editText);
                String trim = editText.getText().toString().trim();
                if (access$100 == null) {
                    return;
                }
                if (trim.length() == 0 || trim.substring(trim.length() - 1).equals(",")) {
                    access$100.showPrefix(false);
                } else {
                    access$100.showPrefix(true);
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        if (this.didLoadExerciseStats) {
            return;
        }
        if (this.showRecentPlannedExerciseStats || this.showRecentLoggedExerciseStats) {
            this.didLoadExerciseStats = true;
            ExerciseStats.getInstance();
        }
    }

    public void onCreateOptionsMenu(Menu menu2, MenuInflater menuInflater) {
        if (!this.isCustomActionBar.booleanValue()) {
            menu2.findItem(R.id.action_pick_date).setVisible(false);
            menu2.findItem(R.id.action_save).setVisible(false);
        }
        menuInflater.inflate(R.menu.create_post_menu, menu2);
        this.menu = menu2;
        MenuItem findItem = menu2.findItem(R.id.mark_done_item);
        findItem.getIcon().setTint(getResources().getColor(R.color.iconColor));
        findItem.setVisible(true);
        super.onCreateOptionsMenu(menu2, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.mark_done_item) {
            syncWithUserEnteredData();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: private */
    public DrillQuickEntryView getQuickEntryView(EditText editText) {
        View view2;
        switch (editText.getId()) {
            case R.id.dev_distance_value /*2131362262*/:
                view2 = this.view.findViewById(R.id.qev_distance);
                break;
            case R.id.dev_duration_value /*2131362265*/:
                view2 = this.view.findViewById(R.id.qev_duration);
                break;
            case R.id.dev_reps_value /*2131362271*/:
                view2 = this.view.findViewById(R.id.qev_rep);
                break;
            case R.id.dev_rest_value /*2131362274*/:
                view2 = this.view.findViewById(R.id.qev_rest);
                break;
            case R.id.dev_sets_value /*2131362278*/:
                view2 = this.view.findViewById(R.id.qev_set);
                break;
            case R.id.dev_weight_value /*2131362281*/:
                view2 = this.view.findViewById(R.id.qev_weight);
                break;
            default:
                view2 = null;
                break;
        }
        return (DrillQuickEntryView) view2;
    }

    private EditText getEditText(DrillQuickEntryView drillQuickEntryView) {
        View view2;
        switch (drillQuickEntryView.getId()) {
            case R.id.qev_distance /*2131363007*/:
                view2 = this.view.findViewById(R.id.dev_distance_value);
                break;
            case R.id.qev_duration /*2131363008*/:
                view2 = this.view.findViewById(R.id.dev_duration_value);
                break;
            case R.id.qev_rep /*2131363009*/:
                view2 = this.view.findViewById(R.id.dev_reps_value);
                break;
            case R.id.qev_rest /*2131363010*/:
                view2 = this.view.findViewById(R.id.dev_rest_value);
                break;
            case R.id.qev_set /*2131363011*/:
                view2 = this.view.findViewById(R.id.dev_sets_value);
                break;
            case R.id.qev_weight /*2131363012*/:
                view2 = this.view.findViewById(R.id.dev_weight_value);
                break;
            default:
                view2 = null;
                break;
        }
        return (EditText) view2;
    }

    private String normalizeValue(TextView textView) {
        String trim = textView.getText().toString().trim();
        if (textView.getId() == R.id.dev_distance_value && trim.length() == 0) {
            return "0.0";
        }
        return trim.length() == 0 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : trim;
    }

    /* JADX WARNING: type inference failed for: r2v5, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r2v7, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r2v9, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r2v11, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r2v13, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void syncWithUserEnteredData() {
        /*
            r5 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            org.json.JSONObject r0 = r5.measures     // Catch:{ Exception -> 0x00c1 }
            java.util.Iterator r0 = r0.keys()     // Catch:{ Exception -> 0x00c1 }
        L_0x000b:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x00c1 }
            if (r1 == 0) goto L_0x0079
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x00c1 }
            int r2 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x00c1 }
            r3 = 0
            r4 = 2
            if (r2 == r4) goto L_0x0063
            r4 = 4
            if (r2 == r4) goto L_0x0056
            r4 = 8
            if (r2 == r4) goto L_0x0049
            r4 = 16
            if (r2 == r4) goto L_0x003c
            r4 = 32
            if (r2 == r4) goto L_0x002f
            goto L_0x006f
        L_0x002f:
            android.view.ViewGroup r2 = r5.view     // Catch:{ Exception -> 0x00c1 }
            r3 = 2131362262(0x7f0a01d6, float:1.83443E38)
            android.view.View r2 = r2.findViewById(r3)     // Catch:{ Exception -> 0x00c1 }
            r3 = r2
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ Exception -> 0x00c1 }
            goto L_0x006f
        L_0x003c:
            android.view.ViewGroup r2 = r5.view     // Catch:{ Exception -> 0x00c1 }
            r3 = 2131362265(0x7f0a01d9, float:1.8344306E38)
            android.view.View r2 = r2.findViewById(r3)     // Catch:{ Exception -> 0x00c1 }
            r3 = r2
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ Exception -> 0x00c1 }
            goto L_0x006f
        L_0x0049:
            android.view.ViewGroup r2 = r5.view     // Catch:{ Exception -> 0x00c1 }
            r3 = 2131362278(0x7f0a01e6, float:1.8344332E38)
            android.view.View r2 = r2.findViewById(r3)     // Catch:{ Exception -> 0x00c1 }
            r3 = r2
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ Exception -> 0x00c1 }
            goto L_0x006f
        L_0x0056:
            android.view.ViewGroup r2 = r5.view     // Catch:{ Exception -> 0x00c1 }
            r3 = 2131362281(0x7f0a01e9, float:1.8344338E38)
            android.view.View r2 = r2.findViewById(r3)     // Catch:{ Exception -> 0x00c1 }
            r3 = r2
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ Exception -> 0x00c1 }
            goto L_0x006f
        L_0x0063:
            android.view.ViewGroup r2 = r5.view     // Catch:{ Exception -> 0x00c1 }
            r3 = 2131362271(0x7f0a01df, float:1.8344318E38)
            android.view.View r2 = r2.findViewById(r3)     // Catch:{ Exception -> 0x00c1 }
            r3 = r2
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ Exception -> 0x00c1 }
        L_0x006f:
            org.json.JSONObject r2 = r5.measures     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r3 = r5.normalizeValue(r3)     // Catch:{ Exception -> 0x00c1 }
            r2.put(r1, r3)     // Catch:{ Exception -> 0x00c1 }
            goto L_0x000b
        L_0x0079:
            android.view.ViewGroup r0 = r5.view     // Catch:{ Exception -> 0x00c1 }
            r1 = 2131362274(0x7f0a01e2, float:1.8344324E38)
            android.view.View r0 = r0.findViewById(r1)     // Catch:{ Exception -> 0x00c1 }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r0 = r5.normalizeValue(r0)     // Catch:{ Exception -> 0x00c1 }
            r5.rest = r0     // Catch:{ Exception -> 0x00c1 }
            android.view.ViewGroup r0 = r5.view     // Catch:{ Exception -> 0x00c1 }
            r1 = 2131362268(0x7f0a01dc, float:1.8344312E38)
            android.view.View r0 = r0.findViewById(r1)     // Catch:{ Exception -> 0x00c1 }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x00c1 }
            java.lang.CharSequence r0 = r0.getText()     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x00c1 }
            android.os.Bundle r1 = r5.info     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r2 = "note"
            r1.putString(r2, r0)     // Catch:{ Exception -> 0x00c1 }
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()     // Catch:{ Exception -> 0x00c1 }
            com.trainerfu.android.DrillEditFragment$EventListener r0 = (com.trainerfu.android.DrillEditFragment.EventListener) r0     // Catch:{ Exception -> 0x00c1 }
            android.os.Bundle r1 = r5.info     // Catch:{ Exception -> 0x00c1 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x00c1 }
            org.json.JSONObject r3 = r5.measures     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00c1 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r3 = r5.rest     // Catch:{ Exception -> 0x00c1 }
            r0.drillEdited(r1, r2, r3)     // Catch:{ Exception -> 0x00c1 }
            return
        L_0x00c1:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.android.DrillEditFragment.syncWithUserEnteredData():void");
    }

    public void onClick(View view2) {
        try {
            int id = view2.getId();
            if (id == R.id.dev_cancel_btn) {
                ((EventListener) getActivity()).drillEditCancelled();
            } else if (id == R.id.dev_save_btn) {
                syncWithUserEnteredData();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private class ExerciseHistoryAdapter extends BaseAdapter {
        private Context context;

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }

        public ExerciseHistoryAdapter(Context context2) {
            this.context = context2;
        }

        public int getCount() {
            return DrillEditFragment.this.exerciseHistory.length();
        }

        public Object getItem(int i) {
            try {
                return DrillEditFragment.this.exerciseHistory.getJSONObject(i);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            try {
                View inflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.exercise_history_row, (ViewGroup) null);
                JSONObject jSONObject = (JSONObject) getItem(i);
                TextView textView = (TextView) inflate.findViewById(R.id.exercise_date);
                TextView textView2 = (TextView) inflate.findViewById(R.id.exercise_details);
                String string = jSONObject.getString("date");
                String detailText = DrillViewHelper.getDetailText(jSONObject, (JSONObject) null, this.context);
                if (TextUtils.isEmpty(detailText)) {
                    detailText = "Did Not Track";
                }
                String storyViewDisplayDate = DateUtils.getStoryViewDisplayDate(DrillEditFragment.this.getContext(), DateUtils.getDateFromISOFormat(string));
                textView2.setText(detailText);
                textView.setText(storyViewDisplayDate);
                return inflate;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter != null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), 0);
            View view2 = null;
            int i = 0;
            for (int i2 = 0; i2 < adapter.getCount(); i2++) {
                view2 = adapter.getView(i2, view2, listView);
                if (i2 == 0) {
                    view2.setLayoutParams(new ViewGroup.LayoutParams(makeMeasureSpec, -2));
                }
                JSONObject jSONObject = (JSONObject) adapter.getItem(i2);
                view2.measure(View.MeasureSpec.makeMeasureSpec((int) (listView.getResources().getDisplayMetrics().density * 325.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                i += view2.getMeasuredHeight();
            }
            ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = i + (listView.getDividerHeight() * (adapter.getCount() - 1));
            listView.setLayoutParams(layoutParams);
        }
    }
}
