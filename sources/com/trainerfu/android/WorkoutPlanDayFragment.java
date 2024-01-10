package com.trainerfu.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.material.TextFieldImplKt;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.gigamole.navigationtabstrip.NavigationTabStrip;
import com.github.mikephil.charting.utils.Utils;
import com.joanzapata.iconify.widget.IconTextView;
import com.sdsmdg.tastytoast.SuccessToastView;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.DateUtils;
import com.trainerfu.utils.DrillLocation;
import com.trainerfu.utils.ResultCode;
import com.trainerfu.utils.Util;
import com.trainerfu.utils.ZipUtil;
import io.intercom.android.sdk.models.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.JsonLexerKt;
import org.apache.http.Header;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WorkoutPlanDayFragment extends Fragment implements DrillViewEventsListener, StartDragListener {
    private static int EVENT_REQUEST_CODE = 34783;
    private static int WORKOUT_FEEDBACK_REQUEST_CODE = 22454;
    private static int WORKOUT_TRACKING_REQUEST_CODE = 345345;
    /* access modifiers changed from: private */
    public IconTextView cancelWorkoutBtn;
    /* access modifiers changed from: private */
    public JSONObject completedDrills = new JSONObject();
    /* access modifiers changed from: private */
    public boolean completedDrillsLoaded = false;
    private int contextUserId = 0;
    /* access modifiers changed from: private */
    public int dayOfWeek;
    private String dayOfWeekString;
    private NavigationTabStrip dayPicker;
    /* access modifiers changed from: private */
    public ArrayList<JSONObject> drills;
    private JSONObject editedDrills = new JSONObject();
    /* access modifiers changed from: private */
    public TextView emptyStateDecription;
    /* access modifiers changed from: private */
    public TextView emptyStateTitle;
    /* access modifiers changed from: private */
    public LinearLayout emptyStateView;
    /* access modifiers changed from: private */
    public IconTextView endWorkoutBtn;
    /* access modifiers changed from: private */
    public View footerView;
    /* access modifiers changed from: private */
    public Boolean forClientPlan = true;
    private boolean gotFeedback = false;
    private View headerView;
    private LinearLayout headerWrapper;
    /* access modifiers changed from: private */
    public Boolean isScrolledUp = true;
    private Boolean isTimerOn = false;
    /* access modifiers changed from: private */
    public LinearLayoutManager linearLayoutManager;
    private ListView listView;
    private CheckBox markAllDoneCB;
    /* access modifiers changed from: private */
    public String note;
    private TextView noteView;
    /* access modifiers changed from: private */
    public LinearLayout noteViewContainer;
    /* access modifiers changed from: private */
    public View noteViewWrapper;
    private PlanDayAdapter planDayAdapter;
    /* access modifiers changed from: private */
    public int programId = 0;
    /* access modifiers changed from: private */
    public double progress = Utils.DOUBLE_EPSILON;
    private boolean progressChanged = false;
    /* access modifiers changed from: private */
    public RecyclerView recyclerView;
    private TextView reorderOrDeleteBtn;
    /* access modifiers changed from: private */
    public boolean reorderOrDeleteMode = false;
    private Boolean showSpinner = false;
    private StableArrayAdapter stableArrayAdapter;
    /* access modifiers changed from: private */
    public ImageView stopWatchBtn;
    private CountDownTimer timer = null;
    /* access modifiers changed from: private */
    public ImageView timerOffBtn;
    private LinearLayout toolbar;
    private ItemTouchHelper touchHelper;
    /* access modifiers changed from: private */
    public LinearLayout trackingToolbar;
    /* access modifiers changed from: private */
    public View view;
    /* access modifiers changed from: private */
    public WorkoutPlanDayViewType viewType;
    private Toolbar workoutHeader;
    /* access modifiers changed from: private */
    public TextView workoutNoteView;
    /* access modifiers changed from: private */
    public LinearLayout workoutOptionsWrapper;
    /* access modifiers changed from: private */
    public TextView workoutTitleView;

    public interface EventListener {
        void cancelTracking();

        void drillEditClicked(Bundle bundle, JSONObject jSONObject, String str);

        void editGroupDrillClicked(int i, JSONObject jSONObject, String str);

        void onScrollStateChanged(int i);

        void onVideoClicked(JSONObject jSONObject);

        void stopWatchClicked();
    }

    public interface TrackingEventListener {
        void completedTracking();
    }

    private String getDayOfWeekString(int i) {
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

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        int i = arguments.getInt("dayOfWeek");
        this.dayOfWeek = i;
        this.dayOfWeekString = getDayOfWeekString(i);
        if (arguments.containsKey("context_user_id")) {
            this.contextUserId = arguments.getInt("context_user_id");
        }
        this.programId = arguments.getInt("program_id");
        if (arguments.containsKey("view_type")) {
            this.viewType = WorkoutPlanDayViewType.getViewType(arguments.getInt("view_type"));
        }
        if (arguments.containsKey("for_client_plan")) {
            this.forClientPlan = Boolean.valueOf(arguments.getBoolean("for_client_plan"));
        }
        View inflate = layoutInflater.inflate(R.layout.workout_plan_day_view, viewGroup, false);
        this.view = inflate;
        registerForContextMenu(inflate);
        this.listView = (ListView) this.view.findViewById(R.id.day_view_list);
        this.recyclerView = (RecyclerView) this.view.findViewById(R.id.day_view_list_rv);
        this.headerView = layoutInflater.inflate(R.layout.workout_plan_day_view_header, (ViewGroup) null, false);
        this.workoutOptionsWrapper = (LinearLayout) this.view.findViewById(R.id.workout_options_wrapper);
        this.headerWrapper = (LinearLayout) this.headerView.findViewById(R.id.header_wrapper);
        View inflate2 = layoutInflater.inflate(R.layout.workout_plan_day_view_footer, (ViewGroup) null, false);
        this.footerView = inflate2;
        inflate2.setVisibility(8);
        this.noteViewWrapper = this.footerView.findViewById(R.id.noteViewWrapper);
        this.noteView = (TextView) this.footerView.findViewById(R.id.noteView);
        if (this.viewType == WorkoutPlanDayViewType.EDITING_CLIENT_PLAN || this.viewType == WorkoutPlanDayViewType.EDITING_TEMPLATE) {
            LinearLayout linearLayout = (LinearLayout) this.footerView.findViewById(R.id.toolbar);
            this.toolbar = linearLayout;
            linearLayout.setVisibility(8);
            this.reorderOrDeleteBtn = (TextView) this.toolbar.findViewById(R.id.reorderOrDeleteBtn);
            this.view.findViewById(R.id.addExerciseBtn).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutPlanDayFragment.this.getActivity(), ExerciseCollectionActivity.class);
                    intent.putExtra("allow_add_exercise", true);
                    WorkoutPlanDayFragment.this.startActivityForResult(intent, ResultCode.WORKOUT_PLAN_DAY_FRAGMENT_SELECT_EXERCISE);
                }
            });
            this.view.findViewById(R.id.more_btn).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("view_type", WorkoutPlanDayFragment.this.viewType.getMask());
                    bundle.putBoolean("for_client_plan", WorkoutPlanDayFragment.this.forClientPlan.booleanValue());
                    bundle.putString(Part.NOTE_MESSAGE_STYLE, WorkoutPlanDayFragment.this.note);
                    WorkoutOptionsDialogFragment newInstance = WorkoutOptionsDialogFragment.newInstance();
                    newInstance.setArguments(bundle);
                    newInstance.setTargetFragment(WorkoutPlanDayFragment.this, 1);
                    newInstance.show(WorkoutPlanDayFragment.this.getActivity().getSupportFragmentManager(), "bottomSheet");
                }
            });
            setupSaveToNewTemplateBtn();
        } else {
            LinearLayout linearLayout2 = (LinearLayout) this.footerView.findViewById(R.id.tracking_toolbar);
            this.trackingToolbar = linearLayout2;
            linearLayout2.setVisibility(0);
            this.workoutOptionsWrapper.setVisibility(8);
            this.endWorkoutBtn = (IconTextView) this.trackingToolbar.findViewById(R.id.end_workout_btn);
            this.cancelWorkoutBtn = (IconTextView) this.trackingToolbar.findViewById(R.id.cancel_workout_btn);
        }
        this.listView.addHeaderView(this.headerView, (Object) null, false);
        this.listView.addFooterView(this.footerView, (Object) null, false);
        StableArrayAdapter stableArrayAdapter2 = new StableArrayAdapter(getActivity());
        this.stableArrayAdapter = stableArrayAdapter2;
        this.listView.setAdapter(stableArrayAdapter2);
        PlanDayAdapter planDayAdapter2 = new PlanDayAdapter(this);
        this.planDayAdapter = planDayAdapter2;
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemMoveCallback(planDayAdapter2));
        this.touchHelper = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(this.recyclerView);
        this.recyclerView.setAdapter(this.planDayAdapter);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity());
        this.linearLayoutManager = linearLayoutManager2;
        this.recyclerView.setLayoutManager(linearLayoutManager2);
        this.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int mLastFirstVisibleItem = 0;

            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                ((EventListener) WorkoutPlanDayFragment.this.getActivity()).onScrollStateChanged(((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition());
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
            }
        });
        ((Button) this.view.findViewById(R.id.endRDBtn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean unused = WorkoutPlanDayFragment.this.reorderOrDeleteMode = false;
                WorkoutPlanDayFragment.this.footerView.setVisibility(0);
                WorkoutPlanDayFragment.this.view.findViewById(R.id.endRDWrapper).setVisibility(8);
                WorkoutPlanDayFragment.this.workoutOptionsWrapper.setVisibility(0);
                WorkoutPlanDayFragment.this.bind(true);
                if (WorkoutPlanDayFragment.this.drills != null && WorkoutPlanDayFragment.this.drills.size() != 0) {
                    JSONArray jSONArray = new JSONArray();
                    int i = 0;
                    while (i < WorkoutPlanDayFragment.this.drills.size()) {
                        try {
                            jSONArray.put(((JSONObject) WorkoutPlanDayFragment.this.drills.get(i)).getInt("drill_id"));
                            i++;
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("drills_order", jSONArray);
                    new BaseHttpClient().post(String.format("/programs/%s/days/%s/drills/order", new Object[]{Integer.valueOf(WorkoutPlanDayFragment.this.programId), Integer.valueOf(WorkoutPlanDayFragment.this.dayOfWeek)}), hashMap, new BaseResponseHandler() {
                        public boolean handleSuccess(int i, Header[] headerArr, JSONArray jSONArray) {
                            return true;
                        }
                    });
                }
            }
        });
        return this.view;
    }

    public void requestDrag(RecyclerView.ViewHolder viewHolder) {
        this.touchHelper.startDrag(viewHolder);
    }

    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    public void onDestroyView() {
        super.onDestroyView();
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Subscribe
    public void handleTextEditedEvent(TextEditedEvent textEditedEvent) {
        if (textEditedEvent.requestCode == EVENT_REQUEST_CODE) {
            try {
                JSONObject jSONObject = new JSONObject(textEditedEvent.info);
                if (jSONObject.getInt("program_id") == this.programId && jSONObject.getInt("dayOfWeek") == this.dayOfWeek) {
                    if (textEditedEvent.text.length() > 0) {
                        this.note = textEditedEvent.text;
                    } else {
                        this.note = null;
                    }
                    bind(true);
                    saveNotes(textEditedEvent.text);
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void setupSaveToNewTemplateBtn() {
        this.toolbar.findViewById(R.id.saveToTemplateBtn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkoutPlanDayFragment.this.saveToNewTemplate();
            }
        });
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            if (bundle.containsKey("drills")) {
                try {
                    byte[] byteArray = bundle.getByteArray("drills");
                    if (byteArray != null) {
                        JSONArray jSONArray = new JSONArray(ZipUtil.decompress(byteArray));
                        this.drills = new ArrayList<>();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            this.drills.add((JSONObject) jSONArray.get(i));
                        }
                    }
                } catch (IOException unused) {
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            if (bundle.containsKey(Part.NOTE_MESSAGE_STYLE)) {
                this.note = bundle.getString(Part.NOTE_MESSAGE_STYLE);
            }
            this.completedDrillsLoaded = bundle.getBoolean("completed_drills_loaded");
            try {
                this.completedDrills = new JSONObject(bundle.getString("completed_drills"));
                this.progressChanged = false;
                this.gotFeedback = bundle.getBoolean("gotFeedback");
                if (this.drills != null && this.viewType == WorkoutPlanDayViewType.TRACKING) {
                    loadComplatedDrills();
                }
                bind(true);
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.drills != null) {
            byte[] bArr = null;
            try {
                bArr = ZipUtil.compress(new JSONArray(this.drills).toString());
            } catch (IOException unused) {
            }
            bundle.putByteArray("drills", bArr);
        }
        String str = this.note;
        if (str != null) {
            bundle.putString(Part.NOTE_MESSAGE_STYLE, str);
        }
        bundle.putBoolean("completed_drills_loaded", this.completedDrillsLoaded);
        JSONObject jSONObject = this.completedDrills;
        if (jSONObject != null) {
            bundle.putString("completed_drills", jSONObject.toString());
        }
        bundle.putBoolean("progressChanged", this.progressChanged);
        bundle.putBoolean("gotFeedback", this.gotFeedback);
    }

    public void onResume() {
        super.onResume();
        if (this.drills == null || (this.viewType == WorkoutPlanDayViewType.TRACKING && !this.completedDrillsLoaded)) {
            fetchData(getActivity());
        }
        getActivity().setTitle("");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003e A[Catch:{ JSONException -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0053 A[Catch:{ JSONException -> 0x005e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r8, int r9, android.content.Intent r10) {
        /*
            r7 = this;
            java.lang.String r0 = "for_group_drill"
            java.lang.String r1 = "info"
            r2 = -1
            if (r9 != r2) goto L_0x0114
            r2 = 3001(0xbb9, float:4.205E-42)
            java.lang.String r3 = "id"
            r4 = 0
            if (r8 != r2) goto L_0x0065
            android.os.Bundle r2 = r10.getExtras()     // Catch:{ JSONException -> 0x005e }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x005e }
            java.lang.String r6 = "exercise"
            java.lang.String r6 = r2.getString(r6)     // Catch:{ JSONException -> 0x005e }
            r5.<init>(r6)     // Catch:{ JSONException -> 0x005e }
            boolean r6 = r2.containsKey(r1)     // Catch:{ JSONException -> 0x005e }
            if (r6 == 0) goto L_0x003a
            android.os.Bundle r1 = r2.getBundle(r1)     // Catch:{ JSONException -> 0x005e }
            boolean r2 = r1.containsKey(r0)     // Catch:{ JSONException -> 0x005e }
            if (r2 == 0) goto L_0x003a
            boolean r0 = r1.getBoolean(r0)     // Catch:{ JSONException -> 0x005e }
            if (r0 == 0) goto L_0x003b
            java.lang.String r2 = "start_group_drill_id"
            int r1 = r1.getInt(r2)     // Catch:{ JSONException -> 0x005e }
            goto L_0x003c
        L_0x003a:
            r0 = 0
        L_0x003b:
            r1 = 0
        L_0x003c:
            if (r0 == 0) goto L_0x0053
            org.json.JSONObject r0 = r7.findEndDrill(r1)     // Catch:{ JSONException -> 0x005e }
            int r1 = r5.getInt(r3)     // Catch:{ JSONException -> 0x005e }
            com.trainerfu.android.ProgramDrillType r2 = com.trainerfu.android.ProgramDrillType.EXERCISE     // Catch:{ JSONException -> 0x005e }
            java.lang.String r3 = "drill_id"
            int r0 = r0.getInt(r3)     // Catch:{ JSONException -> 0x005e }
            r7.addExercise(r1, r2, r0)     // Catch:{ JSONException -> 0x005e }
            goto L_0x0114
        L_0x0053:
            int r0 = r5.getInt(r3)     // Catch:{ JSONException -> 0x005e }
            com.trainerfu.android.ProgramDrillType r1 = com.trainerfu.android.ProgramDrillType.EXERCISE     // Catch:{ JSONException -> 0x005e }
            r7.addExercise(r0, r1, r4)     // Catch:{ JSONException -> 0x005e }
            goto L_0x0114
        L_0x005e:
            r8 = move-exception
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            r9.<init>(r8)
            throw r9
        L_0x0065:
            r0 = 3002(0xbba, float:4.207E-42)
            if (r8 != r0) goto L_0x00e2
            android.os.Bundle r0 = r10.getExtras()     // Catch:{ JSONException -> 0x00db }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00db }
            java.lang.String r2 = "template"
            java.lang.String r0 = r0.getString(r2)     // Catch:{ JSONException -> 0x00db }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x00db }
            java.util.ArrayList<org.json.JSONObject> r0 = r7.drills     // Catch:{ JSONException -> 0x00db }
            if (r0 == 0) goto L_0x0114
            int r0 = r1.getInt(r3)     // Catch:{ JSONException -> 0x00db }
            java.util.ArrayList<org.json.JSONObject> r1 = r7.drills     // Catch:{ JSONException -> 0x00db }
            int r1 = r1.size()     // Catch:{ JSONException -> 0x00db }
            if (r1 <= 0) goto L_0x00d7
            com.afollestad.materialdialogs.MaterialDialog$Builder r1 = new com.afollestad.materialdialogs.MaterialDialog$Builder     // Catch:{ JSONException -> 0x00db }
            androidx.fragment.app.FragmentActivity r2 = r7.getActivity()     // Catch:{ JSONException -> 0x00db }
            r1.<init>(r2)     // Catch:{ JSONException -> 0x00db }
            r2 = 2131951994(0x7f13017a, float:1.9540418E38)
            com.afollestad.materialdialogs.MaterialDialog$Builder r1 = r1.content((int) r2)     // Catch:{ JSONException -> 0x00db }
            r2 = 2131951694(0x7f13004e, float:1.953981E38)
            com.afollestad.materialdialogs.MaterialDialog$Builder r1 = r1.positiveText((int) r2)     // Catch:{ JSONException -> 0x00db }
            r2 = 2131951741(0x7f13007d, float:1.9539905E38)
            com.afollestad.materialdialogs.MaterialDialog$Builder r1 = r1.negativeText((int) r2)     // Catch:{ JSONException -> 0x00db }
            androidx.fragment.app.FragmentActivity r2 = r7.getActivity()     // Catch:{ JSONException -> 0x00db }
            r3 = 2131100514(0x7f060362, float:1.7813412E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)     // Catch:{ JSONException -> 0x00db }
            com.afollestad.materialdialogs.MaterialDialog$Builder r1 = r1.positiveColor((int) r2)     // Catch:{ JSONException -> 0x00db }
            androidx.fragment.app.FragmentActivity r2 = r7.getActivity()     // Catch:{ JSONException -> 0x00db }
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)     // Catch:{ JSONException -> 0x00db }
            com.afollestad.materialdialogs.MaterialDialog$Builder r1 = r1.negativeColor((int) r2)     // Catch:{ JSONException -> 0x00db }
            com.trainerfu.android.WorkoutPlanDayFragment$7 r2 = new com.trainerfu.android.WorkoutPlanDayFragment$7     // Catch:{ JSONException -> 0x00db }
            r2.<init>(r0)     // Catch:{ JSONException -> 0x00db }
            com.afollestad.materialdialogs.MaterialDialog$Builder r1 = r1.onPositive(r2)     // Catch:{ JSONException -> 0x00db }
            com.trainerfu.android.WorkoutPlanDayFragment$6 r2 = new com.trainerfu.android.WorkoutPlanDayFragment$6     // Catch:{ JSONException -> 0x00db }
            r2.<init>(r0)     // Catch:{ JSONException -> 0x00db }
            com.afollestad.materialdialogs.MaterialDialog$Builder r0 = r1.onNegative(r2)     // Catch:{ JSONException -> 0x00db }
            r0.show()     // Catch:{ JSONException -> 0x00db }
            goto L_0x0114
        L_0x00d7:
            r7.copyWorkoutFromTemplate(r0, r4)     // Catch:{ JSONException -> 0x00db }
            goto L_0x0114
        L_0x00db:
            r8 = move-exception
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            r9.<init>(r8)
            throw r9
        L_0x00e2:
            int r0 = WORKOUT_FEEDBACK_REQUEST_CODE
            if (r8 == r0) goto L_0x00ea
            int r0 = WORKOUT_TRACKING_REQUEST_CODE
            if (r8 != r0) goto L_0x0114
        L_0x00ea:
            java.lang.String r0 = "action"
            java.lang.String r0 = r10.getStringExtra(r0)
            java.lang.String r1 = "compose_object_saved"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0108
            java.lang.String r1 = "compose_cancelled"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0108
            java.lang.String r1 = "completed_tracking"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0114
        L_0x0108:
            r7.getActivity()
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            com.trainerfu.android.WorkoutPlanDayFragment$TrackingEventListener r0 = (com.trainerfu.android.WorkoutPlanDayFragment.TrackingEventListener) r0
            r0.completedTracking()
        L_0x0114:
            super.onActivityResult(r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.android.WorkoutPlanDayFragment.onActivityResult(int, int, android.content.Intent):void");
    }

    public void fetchData(Activity activity) {
        String str;
        this.showSpinner = true;
        BaseHttpClient baseHttpClient = new BaseHttpClient(Boolean.valueOf(this.drills == null || this.showSpinner.booleanValue()), activity);
        HashMap hashMap = new HashMap();
        hashMap.put("date", DateUtils.getISOFormattedDate(DateUtils.getTodaysDate()));
        if (this.viewType == WorkoutPlanDayViewType.EDITING_TEMPLATE) {
            str = String.format("/programs/%s/days/1/drills", new Object[]{String.valueOf(this.programId)});
        } else {
            str = String.format("/programs/%s/days/%s/drills", new Object[]{String.valueOf(this.programId), String.valueOf(this.dayOfWeek)});
        }
        baseHttpClient.get(str, hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                try {
                    int unused = WorkoutPlanDayFragment.this.programId = jSONObject.getInt("program_id");
                    WorkoutPlanDayFragment.this.normalizePlanData(jSONObject);
                    if (WorkoutPlanDayFragment.this.isAdded()) {
                        WorkoutPlanDayFragment.this.bind(true);
                    }
                    return true;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        if (this.viewType == WorkoutPlanDayViewType.TRACKING) {
            loadComplatedDrills();
        }
        this.showSpinner = false;
    }

    private void loadComplatedDrills() {
        String iSOFormattedDate = DateUtils.getISOFormattedDate(new Date(System.currentTimeMillis()));
        new BaseHttpClient().get(String.format("/users/%s/day_logs/%s", new Object[]{Util.getUserIdForUrl(this.contextUserId), iSOFormattedDate}), (Map<String, Object>) null, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("drills");
                    JSONObject jSONObject2 = new JSONObject();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject3 = (JSONObject) jSONArray.get(i2);
                        if (!jSONObject3.isNull("ref_program_drill_id")) {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("measures", jSONObject3.getJSONObject("measures"));
                            jSONObject4.put("rest_time", jSONObject3.getString("rest_time"));
                            jSONObject4.put(Part.NOTE_MESSAGE_STYLE, jSONObject3.getString(Part.NOTE_MESSAGE_STYLE));
                            jSONObject2.put(String.valueOf(jSONObject3.getInt("ref_program_drill_id")), jSONObject4);
                        }
                    }
                    JSONObject unused = WorkoutPlanDayFragment.this.completedDrills = jSONObject2;
                    boolean unused2 = WorkoutPlanDayFragment.this.completedDrillsLoaded = true;
                    if (WorkoutPlanDayFragment.this.isAdded()) {
                        WorkoutPlanDayFragment.this.bind(true);
                    }
                    return true;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void saveNotes(String str) {
        String str2;
        if (this.viewType == WorkoutPlanDayViewType.EDITING_TEMPLATE) {
            str2 = String.format("programs/%s/days/1/note", new Object[]{String.valueOf(this.programId)});
        } else {
            str2 = String.format("programs/%s/days/%s/note", new Object[]{String.valueOf(this.programId), String.valueOf(this.dayOfWeek)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Part.NOTE_MESSAGE_STYLE, str);
        hashMap.put("date", DateUtils.getISOFormattedDate(DateUtils.getTodaysDate()));
        new BaseHttpClient().post(str2, hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONArray jSONArray) {
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    public void normalizePlanData(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("drills");
            this.drills = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.drills.add((JSONObject) jSONArray.get(i));
            }
            if (jSONObject.isNull(Part.NOTE_MESSAGE_STYLE) || jSONObject.getString(Part.NOTE_MESSAGE_STYLE).trim().length() == 0) {
                this.note = null;
            } else {
                this.note = jSONObject.getString(Part.NOTE_MESSAGE_STYLE).trim();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: private */
    public void bind(boolean z) {
        if (this.drills != null) {
            if (!this.reorderOrDeleteMode) {
                this.footerView.setVisibility(0);
            }
            if (this.viewType == WorkoutPlanDayViewType.TRACKING && this.drills.size() == 0) {
                this.footerView.findViewById(R.id.mark_all_done_btn).setVisibility(8);
                this.footerView.findViewById(R.id.cancel_workout_btn).setVisibility(8);
                this.footerView.findViewById(R.id.end_workout_btn).setVisibility(8);
            }
            if (this.viewType == WorkoutPlanDayViewType.EDITING_CLIENT_PLAN) {
                if (this.drills.size() == 0) {
                    if (this.reorderOrDeleteMode) {
                        this.reorderOrDeleteMode = false;
                        this.footerView.setVisibility(0);
                        this.view.findViewById(R.id.endRDWrapper).setVisibility(8);
                        this.workoutOptionsWrapper.setVisibility(0);
                    }
                    this.footerView.setVisibility(8);
                    this.reorderOrDeleteBtn.setVisibility(8);
                } else {
                    this.reorderOrDeleteBtn.setVisibility(0);
                }
            }
            this.stableArrayAdapter.notifyDataSetChanged();
            resetRecycleView();
            if (this.completedDrillsLoaded && z) {
                refreshProgress();
            }
        }
    }

    /* access modifiers changed from: private */
    public void getWorkoutFeedback() {
        Intent intent = new Intent(getActivity(), ComposeActivity.class);
        intent.putExtra("client_id", this.contextUserId);
        intent.putExtra("compose_type", ComposeType.WORKOUT_FEEDBACK.getMask());
        startActivityForResult(intent, WORKOUT_FEEDBACK_REQUEST_CODE);
    }

    private class StableArrayAdapter extends BaseAdapter {
        private Context context;

        public boolean hasStableIds() {
            return false;
        }

        public boolean isEnabled(int i) {
            return false;
        }

        public StableArrayAdapter(Context context2) {
            this.context = context2;
        }

        public int getCount() {
            if (WorkoutPlanDayFragment.this.drills != null) {
                return WorkoutPlanDayFragment.this.drills.size();
            }
            return 0;
        }

        public Object getItem(int i) {
            return WorkoutPlanDayFragment.this.drills.get(i);
        }

        public long getItemId(int i) {
            try {
                return (long) ((JSONObject) WorkoutPlanDayFragment.this.drills.get(i)).getInt("drill_id");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        private boolean shouldShowMarkDoneTooltip(int i) {
            Boolean bool = false;
            if (WorkoutPlanDayFragment.this.completedDrillsLoaded && !WorkoutPlanDayFragment.this.completedDrills.keys().hasNext() && ((i == 0 || i == 1) && ((JSONObject) WorkoutPlanDayFragment.this.drills.get(i)).optInt("program_drill_type", 1) == 1)) {
                if (i == 0) {
                    bool = true;
                } else if (((JSONObject) WorkoutPlanDayFragment.this.drills.get(0)).optInt("program_drill_type", 1) != 1) {
                    bool = true;
                }
            }
            return bool.booleanValue();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            new DrillViewHelper().getDrillLocation(WorkoutPlanDayFragment.this.drills, i);
            try {
                int i2 = ((JSONObject) WorkoutPlanDayFragment.this.drills.get(i)).getInt("drill_id");
                WorkoutPlanDayFragment.this.completedDrills.has(String.valueOf(i2));
                Boolean.valueOf(shouldShowMarkDoneTooltip(i));
                try {
                    if (WorkoutPlanDayFragment.this.completedDrills.has(String.valueOf(i2))) {
                        WorkoutPlanDayFragment.this.completedDrills.getJSONObject(String.valueOf(i2));
                    }
                    if (WorkoutPlanDayFragment.this.viewType == WorkoutPlanDayViewType.TRACKING) {
                        PlanDrillViewType planDrillViewType = PlanDrillViewType.FOR_TRACKING;
                        return null;
                    } else if (WorkoutPlanDayFragment.this.reorderOrDeleteMode) {
                        PlanDrillViewType planDrillViewType2 = PlanDrillViewType.FOR_DELETING_AND_REORDERING;
                        return null;
                    } else {
                        PlanDrillViewType planDrillViewType3 = PlanDrillViewType.FOR_EDITING;
                        return null;
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private class PlanDayAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ItemMoveCallback.ItemTouchHelperContract {
        public final int TYPE_FOOTER = 2;
        public final int TYPE_HEADER = 0;
        public final int TYPE_ITEM = 1;
        int dragFrom = -1;
        int dragTo = -1;
        private final StartDragListener mStartDragListener;

        private boolean isPositionHeader(int i) {
            return i == 0;
        }

        public PlanDayAdapter(StartDragListener startDragListener) {
            this.mStartDragListener = startDragListener;
        }

        private boolean shouldShowMarkDoneTooltip(int i) {
            Boolean bool = false;
            if (WorkoutPlanDayFragment.this.completedDrillsLoaded && !WorkoutPlanDayFragment.this.completedDrills.keys().hasNext() && ((i == 0 || i == 1) && ((JSONObject) WorkoutPlanDayFragment.this.drills.get(i)).optInt("program_drill_type", 1) == 1)) {
                if (i == 0) {
                    bool = true;
                } else if (((JSONObject) WorkoutPlanDayFragment.this.drills.get(0)).optInt("program_drill_type", 1) != 1) {
                    bool = true;
                }
            }
            return bool.booleanValue();
        }

        public void onRowMoved(int i, int i2) {
            if (!(i == i2 || i2 == 0)) {
                FragmentActivity activity = WorkoutPlanDayFragment.this.getActivity();
                Toast.makeText(activity, "End - position: " + i2, 0).show();
            }
            if (this.dragFrom == -1) {
                this.dragFrom = i;
            }
            this.dragTo = i2;
        }

        public void onRowSelected(ViewHolder viewHolder) {
            viewHolder.itemView.setBackgroundColor(-7829368);
        }

        public void onRowClear(ViewHolder viewHolder) {
            int i;
            int i2 = this.dragFrom;
            if (!(i2 == -1 || (i = this.dragTo) == -1 || i2 == i)) {
                WorkoutPlanDayFragment.this.moveDrill(i2 - 1, i - 1);
            }
            this.dragTo = -1;
            this.dragFrom = -1;
            viewHolder.itemView.setBackgroundColor(-1);
        }

        public int getItemViewType(int i) {
            if (isPositionHeader(i)) {
                return 0;
            }
            if (isPositionFooter(i)) {
            }
            return i;
        }

        private boolean isPositionFooter(int i) {
            return i == getItemCount() - 1;
        }

        public long getItemId(int i) {
            try {
                return (long) ((JSONObject) WorkoutPlanDayFragment.this.drills.get(i)).getInt("drill_id");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public void setHasStableIds(boolean z) {
            super.setHasStableIds(false);
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            View inflate = from.inflate(R.layout.day_view_single_row, viewGroup, false);
            View inflate2 = from.inflate(R.layout.workout_plan_day_view_header, viewGroup, false);
            View inflate3 = from.inflate(R.layout.workout_plan_day_view_footer, viewGroup, false);
            if (i == 0) {
                return new VHHeader(inflate2);
            }
            if (i == getItemCount() - 1) {
                return new VHFooter(inflate3);
            }
            return new ViewHolder(inflate);
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            PlanDrillViewType planDrillViewType;
            if (viewHolder instanceof ViewHolder) {
                int i2 = i - 1;
                DrillViewHelper drillViewHelper = new DrillViewHelper();
                View view = viewHolder.itemView;
                Context context = view.getContext();
                DrillLocation drillLocation = drillViewHelper.getDrillLocation(WorkoutPlanDayFragment.this.drills, i2);
                JSONObject jSONObject = (JSONObject) WorkoutPlanDayFragment.this.drills.get(i2);
                try {
                    int i3 = ((JSONObject) WorkoutPlanDayFragment.this.drills.get(i2)).getInt("drill_id");
                    boolean has = WorkoutPlanDayFragment.this.completedDrills.has(String.valueOf(i3));
                    Boolean valueOf = Boolean.valueOf(shouldShowMarkDoneTooltip(i2));
                    try {
                        JSONObject jSONObject2 = WorkoutPlanDayFragment.this.completedDrills.has(String.valueOf(i3)) ? WorkoutPlanDayFragment.this.completedDrills.getJSONObject(String.valueOf(i3)) : null;
                        if (WorkoutPlanDayFragment.this.viewType == WorkoutPlanDayViewType.TRACKING) {
                            planDrillViewType = PlanDrillViewType.FOR_TRACKING;
                        } else if (WorkoutPlanDayFragment.this.reorderOrDeleteMode) {
                            planDrillViewType = PlanDrillViewType.FOR_DELETING_AND_REORDERING;
                        } else {
                            planDrillViewType = PlanDrillViewType.FOR_EDITING;
                        }
                        boolean booleanValue = valueOf.booleanValue();
                        WorkoutPlanDayFragment workoutPlanDayFragment = WorkoutPlanDayFragment.this;
                        drillViewHelper.getView(context, planDrillViewType, (JSONObject) WorkoutPlanDayFragment.this.drills.get(i2), jSONObject2, drillLocation, has, booleanValue, workoutPlanDayFragment, view, workoutPlanDayFragment, viewHolder);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                } catch (JSONException e2) {
                    throw new RuntimeException(e2);
                }
            } else if (viewHolder instanceof VHHeader) {
                View view2 = viewHolder.itemView;
                if (WorkoutPlanDayFragment.this.drills.size() == 0) {
                    view2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                }
                TextView unused = WorkoutPlanDayFragment.this.workoutNoteView = (TextView) view2.findViewById(R.id.workoutNoteView);
                LinearLayout unused2 = WorkoutPlanDayFragment.this.noteViewContainer = (LinearLayout) view2.findViewById(R.id.noteViewContainer);
                LinearLayout unused3 = WorkoutPlanDayFragment.this.emptyStateView = (LinearLayout) view2.findViewById(R.id.empty_state);
                TextView unused4 = WorkoutPlanDayFragment.this.emptyStateTitle = (TextView) view2.findViewById(R.id.empty_state_title);
                TextView unused5 = WorkoutPlanDayFragment.this.emptyStateDecription = (TextView) view2.findViewById(R.id.empty_state_description);
                View findViewById = view2.findViewById(R.id.edit_note_btn);
                if (WorkoutPlanDayFragment.this.viewType != WorkoutPlanDayViewType.TRACKING) {
                    findViewById.setVisibility(0);
                    findViewById.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            WorkoutPlanDayFragment.this.addNotes();
                        }
                    });
                } else {
                    findViewById.setVisibility(8);
                }
                if (WorkoutPlanDayFragment.this.drills.size() == 0) {
                    if (WorkoutPlanDayFragment.this.viewType == WorkoutPlanDayViewType.TRACKING) {
                        WorkoutPlanDayFragment.this.emptyStateTitle.setText("No Workout");
                        WorkoutPlanDayFragment.this.emptyStateDecription.setText("Enjoy your rest day");
                    } else {
                        WorkoutPlanDayFragment.this.emptyStateTitle.setText("No Exercises");
                        WorkoutPlanDayFragment.this.emptyStateDecription.setText("Create workout using the buttons below");
                    }
                    WorkoutPlanDayFragment.this.emptyStateView.setVisibility(0);
                } else {
                    WorkoutPlanDayFragment.this.emptyStateView.setVisibility(8);
                }
                if (WorkoutPlanDayFragment.this.note != null) {
                    if (WorkoutPlanDayFragment.this.noteViewContainer != null && WorkoutPlanDayFragment.this.workoutNoteView != null) {
                        WorkoutPlanDayFragment.this.noteViewContainer.setVisibility(0);
                        WorkoutPlanDayFragment.this.workoutNoteView.setVisibility(0);
                        WorkoutPlanDayFragment.this.workoutNoteView.setText(String.format("%s", new Object[]{WorkoutPlanDayFragment.this.note}));
                        final String charSequence = WorkoutPlanDayFragment.this.workoutNoteView.getText().toString();
                        if (charSequence.length() > 135) {
                            final SpannableString spannableString = new SpannableString((charSequence.substring(0, 135) + "...") + " Read More");
                            spannableString.setSpan(new ClickableSpan(" Read Less") {
                                public void onClick(View view) {
                                    SpannableString spannableString = new SpannableString(charSequence + " Read Less");
                                    spannableString.setSpan(new ClickableSpan() {
                                        public void onClick(View view) {
                                            WorkoutPlanDayFragment.this.workoutNoteView.setText(spannableString);
                                            WorkoutPlanDayFragment.this.workoutNoteView.setMovementMethod(LinkMovementMethod.getInstance());
                                        }

                                        public void updateDrawState(TextPaint textPaint) {
                                            super.updateDrawState(textPaint);
                                            textPaint.setUnderlineText(false);
                                        }
                                    }, charSequence.length(), spannableString.length(), 33);
                                    spannableString.setSpan(new ForegroundColorSpan(WorkoutPlanDayFragment.this.getResources().getColor(R.color.tintColor)), charSequence.length(), spannableString.length(), 33);
                                    WorkoutPlanDayFragment.this.workoutNoteView.setText(spannableString);
                                    WorkoutPlanDayFragment.this.workoutNoteView.setMovementMethod(LinkMovementMethod.getInstance());
                                }

                                public void updateDrawState(TextPaint textPaint) {
                                    super.updateDrawState(textPaint);
                                    textPaint.setUnderlineText(false);
                                }
                            }, 138, 148, 33);
                            spannableString.setSpan(new ForegroundColorSpan(WorkoutPlanDayFragment.this.getResources().getColor(R.color.tintColor)), 138, 148, 33);
                            WorkoutPlanDayFragment.this.workoutNoteView.setText(spannableString);
                            WorkoutPlanDayFragment.this.workoutNoteView.setMovementMethod(LinkMovementMethod.getInstance());
                            return;
                        }
                        WorkoutPlanDayFragment.this.workoutNoteView.setText(charSequence);
                    }
                } else if (WorkoutPlanDayFragment.this.noteViewContainer != null && WorkoutPlanDayFragment.this.workoutNoteView != null) {
                    WorkoutPlanDayFragment.this.noteViewContainer.setVisibility(8);
                    WorkoutPlanDayFragment.this.workoutNoteView.setVisibility(8);
                    WorkoutPlanDayFragment.this.noteViewWrapper.setVisibility(8);
                }
            } else if (viewHolder instanceof VHFooter) {
                View view3 = viewHolder.itemView;
                LinearLayout unused6 = WorkoutPlanDayFragment.this.trackingToolbar = (LinearLayout) view3.findViewById(R.id.tracking_toolbar);
                if (WorkoutPlanDayFragment.this.viewType != WorkoutPlanDayViewType.TRACKING || WorkoutPlanDayFragment.this.drills.size() <= 0) {
                    WorkoutPlanDayFragment.this.trackingToolbar.setVisibility(8);
                    return;
                }
                WorkoutPlanDayFragment.this.trackingToolbar.setVisibility(0);
                WorkoutPlanDayFragment workoutPlanDayFragment2 = WorkoutPlanDayFragment.this;
                IconTextView unused7 = workoutPlanDayFragment2.cancelWorkoutBtn = (IconTextView) workoutPlanDayFragment2.trackingToolbar.findViewById(R.id.cancel_workout_btn);
                WorkoutPlanDayFragment workoutPlanDayFragment3 = WorkoutPlanDayFragment.this;
                IconTextView unused8 = workoutPlanDayFragment3.endWorkoutBtn = (IconTextView) workoutPlanDayFragment3.trackingToolbar.findViewById(R.id.end_workout_btn);
                WorkoutPlanDayFragment.this.cancelWorkoutBtn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        ((EventListener) WorkoutPlanDayFragment.this.getActivity()).cancelTracking();
                    }
                });
                WorkoutPlanDayFragment.this.endWorkoutBtn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        WorkoutPlanDayFragment.this.getWorkoutFeedback();
                    }
                });
                ((IconTextView) view3.findViewById(R.id.mark_all_done_btn)).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        WorkoutPlanDayFragment.this.markAllDone();
                    }
                });
                if (WorkoutPlanDayFragment.this.progress <= Utils.DOUBLE_EPSILON || WorkoutPlanDayFragment.this.progress >= 100.0d) {
                    WorkoutPlanDayFragment.this.endWorkoutBtn.setVisibility(8);
                    WorkoutPlanDayFragment.this.cancelWorkoutBtn.setVisibility(0);
                    return;
                }
                WorkoutPlanDayFragment.this.endWorkoutBtn.setVisibility(0);
                WorkoutPlanDayFragment.this.cancelWorkoutBtn.setVisibility(8);
            }
        }

        public int getItemCount() {
            if (WorkoutPlanDayFragment.this.drills != null) {
                return WorkoutPlanDayFragment.this.drills.size() + 2;
            }
            return 0;
        }

        private class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(View view) {
                super(view);
            }
        }

        private class VHHeader extends RecyclerView.ViewHolder {
            public VHHeader(View view) {
                super(view);
            }
        }

        private class VHFooter extends RecyclerView.ViewHolder {
            public VHFooter(View view) {
                super(view);
            }
        }
    }

    public static class ItemMoveCallback extends ItemTouchHelper.Callback {
        private final ItemTouchHelperContract mAdapter;

        public interface ItemTouchHelperContract {
            void onRowClear(PlanDayAdapter.ViewHolder viewHolder);

            void onRowMoved(int i, int i2);

            void onRowSelected(PlanDayAdapter.ViewHolder viewHolder);
        }

        public boolean isItemViewSwipeEnabled() {
            return false;
        }

        public boolean isLongPressDragEnabled() {
            return false;
        }

        public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        }

        public ItemMoveCallback(ItemTouchHelperContract itemTouchHelperContract) {
            this.mAdapter = itemTouchHelperContract;
        }

        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            if (viewHolder instanceof PlanDayAdapter.VHHeader) {
                return 0;
            }
            return makeMovementFlags(3, 0);
        }

        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.mAdapter.onRowMoved(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
            return false;
        }

        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
            if (i != 0 && (viewHolder instanceof PlanDayAdapter.ViewHolder)) {
                this.mAdapter.onRowSelected((PlanDayAdapter.ViewHolder) viewHolder);
            }
            super.onSelectedChanged(viewHolder, i);
        }

        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            super.clearView(recyclerView, viewHolder);
            if (viewHolder instanceof PlanDayAdapter.ViewHolder) {
                this.mAdapter.onRowClear((PlanDayAdapter.ViewHolder) viewHolder);
            }
        }
    }

    public void drillEdited(Bundle bundle, JSONObject jSONObject, String str) {
        if (this.viewType == WorkoutPlanDayViewType.TRACKING) {
            this.progressChanged = true;
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("measures", jSONObject);
                jSONObject2.put("rest_time", str);
                jSONObject2.put(Part.NOTE_MESSAGE_STYLE, bundle.getString(Part.NOTE_MESSAGE_STYLE));
                this.completedDrills.put(String.valueOf(bundle.getInt("drill_id")), jSONObject2);
                this.editedDrills.put(String.valueOf(bundle.getInt("drill_id")), jSONObject2);
                bind(true);
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        hashMap.put(next, jSONObject.getString(next));
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
                String string = bundle.getString(Part.NOTE_MESSAGE_STYLE);
                hashMap.put("rest_time", str);
                hashMap.put("exercise_id", Integer.valueOf(bundle.getInt("exercise_id")));
                hashMap.put("ref_program_drill_id", Integer.valueOf(bundle.getInt("drill_id")));
                if (string.equals(JsonLexerKt.NULL)) {
                    string = null;
                }
                hashMap.put(Part.NOTE_MESSAGE_STYLE, string);
                new BaseHttpClient(false, getActivity()).put(String.format("/users/%s/day_logs/%s/new", new Object[]{Util.getUserIdForUrl(this.contextUserId), DateUtils.getTodaysFormattedDate()}), hashMap, new BaseResponseHandler() {
                    public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                        return true;
                    }
                });
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        } else {
            JSONObject findDrill = findDrill(bundle.getInt("drill_id"));
            if (findDrill != null) {
                try {
                    findDrill.put("measures", jSONObject);
                    findDrill.put("rest_time", str);
                    findDrill.put(Part.NOTE_MESSAGE_STYLE, bundle.getString(Part.NOTE_MESSAGE_STYLE));
                    this.stableArrayAdapter.notifyDataSetChanged();
                    resetRecycleView();
                    saveProgramDrill(findDrill);
                } catch (JSONException e3) {
                    throw new RuntimeException(e3);
                }
            }
        }
    }

    public void groupDrillEdited(int i, JSONObject jSONObject, String str) {
        JSONObject findDrill = findDrill(i);
        if (findDrill != null) {
            try {
                findDrill.put("measures", jSONObject);
                findDrill.put(Part.NOTE_MESSAGE_STYLE, str);
                this.stableArrayAdapter.notifyDataSetChanged();
                resetRecycleView();
                saveProgramDrill(findDrill);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void startTimer(int i, int i2) {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (WorkoutPlanDayFragment.this.isScrolledUp.booleanValue()) {
                    WorkoutPlanDayFragment.this.workoutTitleView.setTextSize(56.0f);
                    WorkoutPlanDayFragment.this.workoutTitleView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 1));
                }
                WorkoutPlanDayFragment.this.timerOffBtn.setVisibility(0);
                WorkoutPlanDayFragment.this.stopWatchBtn.setVisibility(8);
            }
        }, 1);
        this.timer = new CountDownTimer((long) ((i * 60 * 1000) + (i2 * 1000)), 1000) {
            public void onTick(long j) {
                TextView access$2800 = WorkoutPlanDayFragment.this.workoutTitleView;
                access$2800.setText("" + String.format("%02d:%02d", new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(j))), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j)))}));
            }

            public void onFinish() {
                WorkoutPlanDayFragment.this.stopTimer();
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

    private void saveProgramDrill(JSONObject jSONObject) {
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject2 = jSONObject.getJSONObject("measures");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject2.getString(next));
            }
            hashMap.put(Part.NOTE_MESSAGE_STYLE, jSONObject.getString(Part.NOTE_MESSAGE_STYLE));
            hashMap.put("rest_time", jSONObject.getString("rest_time"));
            new BaseHttpClient(false, getActivity()).post(String.format("/program_drills/%s", new Object[]{String.valueOf(jSONObject.getInt("drill_id"))}), hashMap, new BaseResponseHandler() {
                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    return true;
                }
            });
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void addExercise(int i, ProgramDrillType programDrillType, final int i2) {
        String str;
        if (this.viewType == WorkoutPlanDayViewType.EDITING_TEMPLATE) {
            str = String.format("programs/%s/days/1/drills/new", new Object[]{String.valueOf(this.programId)});
        } else {
            str = String.format("programs/%s/days/%s/drills/new", new Object[]{String.valueOf(this.programId), String.valueOf(this.dayOfWeek)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("exercise_id", Integer.valueOf(i));
        hashMap.put("program_drill_type", Integer.valueOf(programDrillType.getMask()));
        hashMap.put("date", DateUtils.getISOFormattedDate(DateUtils.getTodaysDate()));
        if (i2 != 0) {
            hashMap.put("insert_before_drill_id", Integer.valueOf(i2));
        }
        new BaseHttpClient(true, getActivity()).put(str, hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONArray jSONArray) {
                WorkoutPlanDayFragment.this.bindUpdatePlanData(jSONArray);
                int i2 = i2;
                if (i2 == 0) {
                    WorkoutPlanDayFragment workoutPlanDayFragment = WorkoutPlanDayFragment.this;
                    LinearLayoutManager unused = workoutPlanDayFragment.linearLayoutManager = new LinearLayoutManager(workoutPlanDayFragment.getActivity());
                    WorkoutPlanDayFragment.this.recyclerView.setLayoutManager(WorkoutPlanDayFragment.this.linearLayoutManager);
                    WorkoutPlanDayFragment.this.linearLayoutManager.scrollToPosition(WorkoutPlanDayFragment.this.drills.size() - 1);
                } else {
                    int access$3600 = WorkoutPlanDayFragment.this.findDrillIndex(WorkoutPlanDayFragment.this.findDrill(i2));
                    WorkoutPlanDayFragment workoutPlanDayFragment2 = WorkoutPlanDayFragment.this;
                    LinearLayoutManager unused2 = workoutPlanDayFragment2.linearLayoutManager = new LinearLayoutManager(workoutPlanDayFragment2.getActivity());
                    WorkoutPlanDayFragment.this.recyclerView.setLayoutManager(WorkoutPlanDayFragment.this.linearLayoutManager);
                    WorkoutPlanDayFragment.this.linearLayoutManager.scrollToPosition(access$3600);
                }
                return true;
            }
        });
    }

    public void addNotes() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("program_id", this.programId);
            jSONObject.put("dayOfWeek", this.dayOfWeek);
            Bundle bundle = new Bundle();
            bundle.putString("info", jSONObject.toString());
            bundle.putString("text", this.note == null ? "" : this.note);
            bundle.putString(ViewHierarchyConstants.HINT_KEY, getString(R.string.note));
            bundle.putInt("request_code", EVENT_REQUEST_CODE);
            EditTextDialogFragment editTextDialogFragment = new EditTextDialogFragment();
            editTextDialogFragment.setArguments(bundle);
            editTextDialogFragment.show(getFragmentManager(), "enf");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveToNewTemplate() {
        new MaterialDialog.Builder(getActivity()).title((int) R.string.addTemplate).content((CharSequence) "").inputType(16384).input((CharSequence) getString(R.string.templateName), (CharSequence) "", (MaterialDialog.InputCallback) new MaterialDialog.InputCallback() {
            public void onInput(MaterialDialog materialDialog, CharSequence charSequence) {
                String trim = charSequence.toString().trim();
                if (trim.length() > 0) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("from_program_id", Integer.valueOf(WorkoutPlanDayFragment.this.programId));
                    hashMap.put("from_day", Integer.valueOf(WorkoutPlanDayFragment.this.dayOfWeek));
                    hashMap.put("to_new_program_with_name", trim);
                    hashMap.put("to_day", 1);
                    new BaseHttpClient(true, WorkoutPlanDayFragment.this.getActivity()).put("/copy_program_day_task", hashMap, new BaseResponseHandler() {
                        public boolean handleSuccess(int i, Header[] headerArr, JSONArray jSONArray) {
                            return true;
                        }
                    });
                }
            }
        }).positiveText((int) R.string.Save).negativeText((int) R.string.cancel).positiveColor(ContextCompat.getColor(getActivity(), R.color.tintColor)).negativeColor(ContextCompat.getColor(getActivity(), R.color.grayColor)).show();
    }

    public void trackClientWorkout() {
        ArrayList<JSONObject> arrayList = this.drills;
        if (arrayList == null || arrayList.size() == 0) {
            new MaterialDialog.Builder(getActivity()).title((int) R.string.emptyWorkoutTitle).content((int) R.string.emptyWorkoutDetail).positiveText((int) R.string.Ok).positiveColor(ContextCompat.getColor(getActivity(), R.color.tintColor)).show();
            return;
        }
        Intent intent = new Intent(getActivity(), WorkoutPlanDayActivity.class);
        intent.putExtra("dayOfWeek", this.dayOfWeek);
        intent.putExtra("context_user_id", this.contextUserId);
        intent.putExtra("program_id", this.programId);
        intent.putExtra("view_type", WorkoutPlanDayViewType.TRACKING.getMask());
        startActivityForResult(intent, WORKOUT_FEEDBACK_REQUEST_CODE);
    }

    public void copyWorkoutFromTemplate() {
        Intent intent = new Intent(getActivity(), TemplateListActivity.class);
        intent.putExtra("for_selection", true);
        intent.putExtra("for_workout_templates", true);
        startActivityForResult(intent, ResultCode.WORKOUT_PLAN_DAY_FRAGMENT_SELECT_TEMPLATE);
    }

    public void deleteOrReorder() {
        this.reorderOrDeleteMode = true;
        this.footerView.setVisibility(8);
        this.noteViewWrapper.setVisibility(8);
        this.toolbar.setVisibility(8);
        this.view.findViewById(R.id.endRDWrapper).setVisibility(0);
        this.workoutOptionsWrapper.setVisibility(8);
        bind(true);
        this.recyclerView.invalidate();
        this.listView.setSelection(0);
    }

    /* access modifiers changed from: private */
    public void bindUpdatePlanData(JSONArray jSONArray) {
        if (isAdded()) {
            try {
                normalizePlanData((JSONObject) jSONArray.get(this.dayOfWeek - 1));
                bind(true);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* access modifiers changed from: private */
    public void copyWorkoutFromTemplate(int i, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("from_program_id", Integer.valueOf(i));
        hashMap.put("from_day", 1);
        hashMap.put("to_program_id", Integer.valueOf(this.programId));
        hashMap.put("to_day", Integer.valueOf(this.dayOfWeek));
        hashMap.put("delete_existing_data", Boolean.valueOf(z));
        new BaseHttpClient(true, getActivity()).put("/copy_program_day_task", hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONArray jSONArray) {
                WorkoutPlanDayFragment.this.bindUpdatePlanData(jSONArray);
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    public JSONObject findDrill(int i) {
        if (this.drills == null) {
            return null;
        }
        int i2 = 0;
        while (i2 < this.drills.size()) {
            JSONObject jSONObject = this.drills.get(i2);
            try {
                if (jSONObject.getInt("drill_id") == i) {
                    return jSONObject;
                }
                i2++;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    private boolean isStartGroupDrill(JSONObject jSONObject) {
        ProgramDrillType programDrillType = ProgramDrillType.get(jSONObject.optInt("program_drill_type", 1));
        if (programDrillType == ProgramDrillType.START_CIRCUIT || programDrillType == ProgramDrillType.START_SUPERSET) {
            return true;
        }
        return false;
    }

    private boolean isEndGroupDrill(JSONObject jSONObject) {
        ProgramDrillType programDrillType = ProgramDrillType.get(jSONObject.optInt("program_drill_type", 1));
        if (programDrillType == ProgramDrillType.END_CIRCUIT || programDrillType == ProgramDrillType.END_SUPERSET) {
            return true;
        }
        return false;
    }

    private void updateWithCorrectSetsValueIfGroupDrill(JSONObject jSONObject) {
        JSONObject startGroupDrillForDrillAtIndex = startGroupDrillForDrillAtIndex(findDrillIndex(jSONObject));
        if (startGroupDrillForDrillAtIndex != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("measures");
                String string = startGroupDrillForDrillAtIndex.getJSONObject("measures").getString("8");
                boolean has = jSONObject2.has("8");
                if (string.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    return;
                }
                if (!has) {
                    String string2 = jSONObject2.getString("32");
                    if (string2.equals("0.0")) {
                        jSONObject2.put("32", String.format("%s %s", new Object[]{string, getString(R.string.rounds)}));
                        return;
                    }
                    jSONObject2.put("32", String.format("%s x %s", new Object[]{string, string2}));
                } else if (jSONObject2.getString("8").equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    jSONObject2.put("8", string);
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private JSONObject startGroupDrillForDrillAtIndex(int i) {
        if (i == 0) {
            return null;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            JSONObject jSONObject = this.drills.get(i2);
            if (isStartGroupDrill(jSONObject)) {
                return jSONObject;
            }
            if (isEndGroupDrill(jSONObject)) {
                return null;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public int findDrillIndex(JSONObject jSONObject) {
        try {
            int i = jSONObject.getInt("drill_id");
            for (int i2 = 0; i2 < this.drills.size(); i2++) {
                if (this.drills.get(i2).getInt("drill_id") == i) {
                    return i2;
                }
            }
            return -1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private JSONObject findEndDrill(int i) {
        if (this.drills == null) {
            return null;
        }
        int i2 = 0;
        boolean z = false;
        while (i2 < this.drills.size()) {
            JSONObject jSONObject = this.drills.get(i2);
            try {
                if (jSONObject.getInt("drill_id") == i) {
                    z = true;
                }
                ProgramDrillType programDrillType = ProgramDrillType.get(jSONObject.optInt("program_drill_type", 1));
                if (z && (programDrillType == ProgramDrillType.END_CIRCUIT || programDrillType == ProgramDrillType.END_SUPERSET)) {
                    return jSONObject;
                }
                i2++;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public void playVideoClicked(JSONObject jSONObject) {
        ((EventListener) getActivity()).onVideoClicked(jSONObject);
    }

    public void drillStatusChanged(JSONObject jSONObject, boolean z) {
        int optInt = jSONObject.optInt("drill_id", -1);
        if (optInt != -1) {
            this.progressChanged = true;
            BaseHttpClient baseHttpClient = new BaseHttpClient();
            if (z) {
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                    String string = jSONObject2.getString(Part.NOTE_MESSAGE_STYLE);
                    updateWithCorrectSetsValueIfGroupDrill(jSONObject2);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("measures", jSONObject2.getJSONObject("measures"));
                    jSONObject3.put("rest_time", jSONObject2.getString("rest_time"));
                    if (string.equals(JsonLexerKt.NULL)) {
                        string = null;
                    }
                    jSONObject3.put(Part.NOTE_MESSAGE_STYLE, string);
                    this.completedDrills.put(String.valueOf(optInt), jSONObject3);
                    baseHttpClient.put(String.format("/users/%s/day_logs/%s/new", new Object[]{Util.getUserIdForUrl(this.contextUserId), DateUtils.getTodaysFormattedDate()}), serializeDrill(jSONObject2), new BaseResponseHandler() {
                        public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                            return true;
                        }
                    });
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            } else {
                this.completedDrills.remove(String.valueOf(optInt));
                this.editedDrills.remove(String.valueOf(optInt));
                String format = String.format("/users/%s/day_logs/%s", new Object[]{Util.getUserIdForUrl(this.contextUserId), DateUtils.getTodaysFormattedDate()});
                HashMap hashMap = new HashMap();
                hashMap.put("ref_program_drill_id", Integer.valueOf(optInt));
                baseHttpClient.delete(format, hashMap, new BaseResponseHandler() {
                    public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                        return true;
                    }
                });
            }
            this.stableArrayAdapter.notifyDataSetChanged();
            resetRecycleView();
            refreshProgress();
        }
    }

    public void updateStatsClicked(JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2;
        Bundle bundle = new Bundle();
        try {
            int i = jSONObject.getInt("drill_id");
            bundle.putInt("drill_id", i);
            bundle.putInt("exercise_id", jSONObject.getInt("exercise_id"));
            bundle.putString("exercise_name", jSONObject.getString("exercise_name"));
            bundle.putInt("view_type", this.viewType.getMask());
            if (this.completedDrills.has(String.valueOf(i))) {
                JSONObject jSONObject3 = this.completedDrills.getJSONObject(String.valueOf(i));
                jSONObject2 = (JSONObject) jSONObject3.get("measures");
                str = (String) jSONObject3.get("rest_time");
                if (this.editedDrills.has(String.valueOf(i))) {
                    bundle.putString(Part.NOTE_MESSAGE_STYLE, jSONObject3.getString(Part.NOTE_MESSAGE_STYLE));
                }
            } else {
                JSONObject jSONObject4 = new JSONObject(jSONObject.toString());
                updateWithCorrectSetsValueIfGroupDrill(jSONObject4);
                jSONObject2 = jSONObject4.getJSONObject("measures");
                str = jSONObject4.getString("rest_time");
            }
            ((EventListener) getActivity()).drillEditClicked(bundle, jSONObject2, str);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void moveDrillUpClicked(JSONObject jSONObject) {
        int findDrillIndex = findDrillIndex(jSONObject);
        if (findDrillIndex != -1 && findDrillIndex != 0) {
            int i = findDrillIndex - 1;
            this.drills.set(i, jSONObject);
            this.drills.set(findDrillIndex, this.drills.get(i));
            this.stableArrayAdapter.notifyDataSetChanged();
            resetRecycleView();
        }
    }

    public void moveDrill(int i, int i2) {
        if (i != -1 && i2 != -1) {
            JSONObject jSONObject = this.drills.get(i2);
            JSONObject jSONObject2 = this.drills.get(i);
            ProgramDrillType programDrillType = ProgramDrillType.get(jSONObject.optInt("program_drill_type", 1));
            ProgramDrillType programDrillType2 = ProgramDrillType.get(jSONObject2.optInt("program_drill_type", 1));
            if (programDrillType == ProgramDrillType.EXERCISE && programDrillType2 == ProgramDrillType.EXERCISE) {
                this.drills.set(i2, jSONObject2);
                this.drills.set(i, jSONObject);
                Parcelable onSaveInstanceState = this.recyclerView.getLayoutManager().onSaveInstanceState();
                this.recyclerView.setAdapter((RecyclerView.Adapter) null);
                this.recyclerView.setLayoutManager((RecyclerView.LayoutManager) null);
                this.recyclerView.setAdapter(this.planDayAdapter);
                this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                this.planDayAdapter.notifyItemMoved(i, i2);
                this.recyclerView.getLayoutManager().onRestoreInstanceState(onSaveInstanceState);
            }
        }
    }

    public void moveDrillDownClicked(JSONObject jSONObject) {
        int findDrillIndex = findDrillIndex(jSONObject);
        if (findDrillIndex != -1 && findDrillIndex != this.drills.size() - 1) {
            int i = findDrillIndex + 1;
            this.drills.set(i, jSONObject);
            this.drills.set(findDrillIndex, this.drills.get(i));
            this.stableArrayAdapter.notifyDataSetChanged();
            resetRecycleView();
        }
    }

    public void deleteDrillClicked(JSONObject jSONObject) {
        deleteDrill(jSONObject, false);
    }

    public void editDrillClicked(JSONObject jSONObject) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("drill_id", jSONObject.getInt("drill_id"));
            bundle.putInt("exercise_id", jSONObject.getInt("exercise_id"));
            bundle.putString("exercise_name", jSONObject.getString("exercise_name"));
            bundle.putString(Part.NOTE_MESSAGE_STYLE, jSONObject.getString(Part.NOTE_MESSAGE_STYLE));
            bundle.putInt("view_type", this.viewType.getMask());
            ((EventListener) getActivity()).drillEditClicked(bundle, jSONObject.getJSONObject("measures"), jSONObject.getString("rest_time"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void editGroupDrillClicked(JSONObject jSONObject) {
        try {
            ((EventListener) getActivity()).editGroupDrillClicked(jSONObject.getInt("drill_id"), jSONObject.getJSONObject("measures"), jSONObject.isNull(Part.NOTE_MESSAGE_STYLE) ? "" : jSONObject.getString(Part.NOTE_MESSAGE_STYLE).trim());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteGroupDrillClicked(JSONObject jSONObject) {
        deleteDrill(jSONObject, true);
    }

    private void deleteDrill(JSONObject jSONObject, final boolean z) {
        int findDrillIndex = findDrillIndex(jSONObject);
        if (findDrillIndex != -1) {
            if (!z) {
                this.drills.remove(findDrillIndex);
                bind(true);
            }
            try {
                new BaseHttpClient(Boolean.valueOf(z), getActivity()).delete(String.format("/program_drills/%s", new Object[]{String.valueOf(jSONObject.getInt("drill_id"))}), (Map<String, Object>) null, new BaseResponseHandler() {
                    public boolean handleSuccess(int i, Header[] headerArr, JSONArray jSONArray) {
                        if (!z) {
                            return true;
                        }
                        WorkoutPlanDayFragment.this.bindUpdatePlanData(jSONArray);
                        return true;
                    }
                });
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addToGroupDrillClicked(JSONObject jSONObject) {
        Intent intent = new Intent(getActivity(), ExerciseCollectionActivity.class);
        intent.putExtra("allow_add_exercise", true);
        Bundle bundle = new Bundle();
        try {
            bundle.putBoolean("for_group_drill", true);
            bundle.putInt("start_group_drill_id", jSONObject.getInt("drill_id"));
            intent.putExtra("info", bundle);
            startActivityForResult(intent, ResultCode.WORKOUT_PLAN_DAY_FRAGMENT_SELECT_EXERCISE);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: private */
    public void markAllDone() {
        if (this.drills != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<JSONObject> it = this.drills.iterator();
            while (it.hasNext()) {
                JSONObject next = it.next();
                try {
                    int i = next.getInt("drill_id");
                    if (next.getInt("exercise_id") != 1 && !this.completedDrills.has(String.valueOf(i))) {
                        JSONObject jSONObject = new JSONObject(next.toString());
                        updateWithCorrectSetsValueIfGroupDrill(jSONObject);
                        this.completedDrills.put(String.valueOf(i), jSONObject);
                        arrayList.add(new JSONObject(serializeDrill(jSONObject)));
                        this.progressChanged = true;
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            if (arrayList.size() > 0) {
                this.stableArrayAdapter.notifyDataSetChanged();
                resetRecycleView();
                refreshProgress();
                BaseHttpClient baseHttpClient = new BaseHttpClient();
                String format = String.format("/users/%s/day_logs/%s/new_many", new Object[]{Util.getUserIdForUrl(this.contextUserId), DateUtils.getISOFormattedDate(DateUtils.getTodaysDate())});
                HashMap hashMap = new HashMap();
                hashMap.put("drills", new JSONArray(arrayList));
                baseHttpClient.put(format, hashMap, new BaseResponseHandler() {
                    public boolean handleSuccess(int i, Header[] headerArr, JSONArray jSONArray) {
                        return true;
                    }
                });
                return;
            }
            this.progressChanged = true;
            this.stableArrayAdapter.notifyDataSetChanged();
            resetRecycleView();
            refreshProgress();
        }
    }

    private HashMap<String, Object> serializeDrill(JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject2 = (JSONObject) jSONObject.get("measures");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject2.getString(next));
            }
            String string = jSONObject.getString(Part.NOTE_MESSAGE_STYLE);
            hashMap.put("rest_time", jSONObject.getString("rest_time"));
            hashMap.put("exercise_id", Integer.valueOf(jSONObject.getInt("exercise_id")));
            hashMap.put("ref_program_drill_id", Integer.valueOf(jSONObject.getInt("drill_id")));
            if (this.editedDrills.has(String.valueOf(jSONObject.getInt("drill_id")))) {
                if (string == null || string.equals(JsonLexerKt.NULL)) {
                    string = null;
                }
                hashMap.put(Part.NOTE_MESSAGE_STYLE, string);
            }
            return hashMap;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void refreshProgress() {
        ArrayList<JSONObject> arrayList = this.drills;
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i < this.drills.size()) {
                try {
                    JSONObject jSONObject = this.drills.get(i);
                    if (jSONObject.getInt("exercise_id") != 1) {
                        i2++;
                        if (this.completedDrills.has(String.valueOf(jSONObject.getInt("drill_id")))) {
                            i3++;
                        }
                    }
                    i++;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            this.progress = Utils.DOUBLE_EPSILON;
            if (i2 > 0) {
                this.progress = (((double) i3) * 100.0d) / ((double) i2);
            }
            ProgressBar progressBar = (ProgressBar) this.view.findViewById(R.id.progressBar);
            if (this.viewType == WorkoutPlanDayViewType.TRACKING) {
                progressBar.setVisibility(0);
            } else {
                progressBar.setVisibility(8);
            }
            progressBar.setProgress((int) Math.round(this.progress));
            double d = this.progress;
            if (d <= Utils.DOUBLE_EPSILON || d >= 100.0d) {
                this.endWorkoutBtn.setVisibility(8);
                this.cancelWorkoutBtn.setVisibility(0);
            } else {
                this.endWorkoutBtn.setVisibility(0);
                this.cancelWorkoutBtn.setVisibility(8);
            }
            if (this.progress == 100.0d && this.progressChanged && !this.gotFeedback) {
                getActivity().getLayoutInflater().inflate(R.layout.success_toast, (ViewGroup) null, false);
                showSuccessToast();
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if (WorkoutPlanDayFragment.this.isAdded()) {
                            WorkoutPlanDayFragment.this.getWorkoutFeedback();
                        }
                    }
                }, 1000);
            }
        }
    }

    private Toast showSuccessToast() {
        Toast toast = new Toast(getActivity());
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.success_toast_layout, (ViewGroup) null, false);
        ((LinearLayout) inflate.findViewById(R.id.base_layout)).setBackground(ResourcesCompat.getDrawable(getActivity().getResources(), R.drawable.background_toast, (Resources.Theme) null));
        TextView textView = (TextView) inflate.findViewById(R.id.toastMessage);
        textView.setText(getString(R.string.successMessage));
        ((SuccessToastView) inflate.findViewById(R.id.successView)).startAnim();
        textView.setBackgroundResource(R.drawable.success_toast);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        toast.setView(inflate);
        toast.setDuration(0);
        toast.show();
        return toast;
    }

    private void resetRecycleView() {
        Parcelable onSaveInstanceState = this.recyclerView.getLayoutManager().onSaveInstanceState();
        this.recyclerView.setAdapter((RecyclerView.Adapter) null);
        this.recyclerView.setLayoutManager((RecyclerView.LayoutManager) null);
        this.recyclerView.setAdapter(this.planDayAdapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.planDayAdapter.notifyDataSetChanged();
        this.recyclerView.getLayoutManager().onRestoreInstanceState(onSaveInstanceState);
    }
}
