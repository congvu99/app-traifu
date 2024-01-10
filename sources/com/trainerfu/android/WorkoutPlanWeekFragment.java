package com.trainerfu.android;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import com.trainerfu.android.WorkoutPlanDayFragment;
import com.trainerfu.utils.DateUtils;
import com.trainerfu.utils.Util;
import io.intercom.android.sdk.models.Part;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WorkoutPlanWeekFragment extends Fragment {
    private static int WORKOUT_TRACKING_REQUEST_CODE = 57291;
    private static int toBeDeletetedPlanId = -1;
    private ListViewAdapter adapter;
    private String contextUserFirstName = "";
    private int contextUserId = 0;
    /* access modifiers changed from: private */
    public List<String> daysList;
    /* access modifiers changed from: private */
    public boolean[] expanded = new boolean[7];
    private View footerView;
    /* access modifiers changed from: private */
    public boolean forClientPlan = true;
    private View headerView;
    private JSONObject history;
    private ListView listView;
    private TextView noteTV;
    private Fragment parentFragment;
    /* access modifiers changed from: private */
    public JSONObject plan;
    /* access modifiers changed from: private */
    public WorkoutPlanStage planStage = WorkoutPlanStage.CURRENT_PLAN;
    private boolean showWebAppBanner = false;
    /* access modifiers changed from: private */
    public JSONObject summary;
    /* access modifiers changed from: private */
    public boolean viewedByClient = true;
    private int weekNum = 1;

    public interface EventListener {
        void copyPlanClicked(int i);

        void copyWorkoutClicked(int i, int i2);

        void deletePlanClicked(int i);

        void editNoteClicked(int i, String str);

        void emailPlanClicked(int i);

        void pastePlanClicked(int i);

        void pasteWorkoutClicked(int i, int i2);

        void updateStartDateClicked(int i, Date date);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        Arrays.fill(this.expanded, Boolean.FALSE.booleanValue());
        if (bundle != null && bundle.containsKey("expanded_position")) {
            this.expanded = bundle.getBooleanArray("expanded_position");
        }
        boolean z = arguments.getBoolean("viewed_by_client");
        this.viewedByClient = z;
        if (!z) {
            this.forClientPlan = arguments.getBoolean("for_client_plan");
        }
        if (this.forClientPlan) {
            this.contextUserId = arguments.getInt("context_user_id");
            this.planStage = WorkoutPlanStage.getWorkoutPlanStage(arguments.getInt("plan_stage"));
            if (!this.viewedByClient) {
                this.contextUserFirstName = arguments.getString("context_user_first_name");
                this.showWebAppBanner = arguments.getBoolean("show_web_app_banner");
            }
        } else {
            this.weekNum = arguments.getInt("week_num");
        }
        try {
            this.plan = new JSONObject(arguments.getString("plan"));
            if (arguments.getString("summary") != null) {
                this.summary = new JSONObject(arguments.getString("summary"));
            }
            if (arguments.getString("history") != null) {
                this.history = new JSONObject(arguments.getString("history"));
            }
            View inflate = layoutInflater.inflate(R.layout.workout_plan_week_view, viewGroup, false);
            this.daysList = new LinkedList();
            this.listView = (ListView) inflate.findViewById(R.id.week_view_list);
            loadDays();
            View inflate2 = ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(R.layout.week_view_header, (ViewGroup) null, false);
            this.headerView = inflate2;
            this.listView.addHeaderView(inflate2, (Object) null, false);
            this.footerView = ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(R.layout.week_view_footer, (ViewGroup) null, false);
            if ((this.forClientPlan && this.planStage != WorkoutPlanStage.CURRENT_PLAN) || (!this.forClientPlan && this.weekNum != 1)) {
                this.footerView.findViewById(R.id.moreBtn).setVisibility(0);
                this.footerView.findViewById(R.id.pasteBtnDivider).setVisibility(0);
            }
            this.listView.addFooterView(this.footerView, (Object) null, false);
            this.headerView.findViewById(R.id.headerWrapper).setVisibility(0);
            setNoteAndPlanHeader();
            setupFooter();
            ListViewAdapter listViewAdapter = new ListViewAdapter(getActivity());
            this.adapter = listViewAdapter;
            this.listView.setAdapter(listViewAdapter);
            this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i >= 8) {
                        try {
                            if (WorkoutPlanWeekFragment.this.forClientPlan) {
                                if (WorkoutPlanWeekFragment.this.planStage == WorkoutPlanStage.UPCOMING_PLAN && i == 8) {
                                    Date date = null;
                                    String string = WorkoutPlanWeekFragment.this.plan.isNull("activation_date") ? null : WorkoutPlanWeekFragment.this.plan.getString("activation_date");
                                    EventListener eventListener = (EventListener) WorkoutPlanWeekFragment.this.getParentFragment();
                                    int i2 = WorkoutPlanWeekFragment.this.plan.getInt("id");
                                    if (string != null) {
                                        date = DateUtils.getDateFromISOFormat(string);
                                    }
                                    eventListener.updateStartDateClicked(i2, date);
                                    return;
                                }
                            }
                            if (!WorkoutPlanWeekFragment.this.plan.isNull(Part.NOTE_MESSAGE_STYLE)) {
                                WorkoutPlanWeekFragment.this.plan.getString(Part.NOTE_MESSAGE_STYLE);
                            }
                            ((EventListener) WorkoutPlanWeekFragment.this.getParentFragment()).editNoteClicked(WorkoutPlanWeekFragment.this.plan.getInt("id"), WorkoutPlanWeekFragment.this.getNote());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
            return inflate;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.parentFragment = getParentFragment();
    }

    public void onResume() {
        super.onResume();
        bind();
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        try {
            toBeDeletetedPlanId = this.plan.getInt("id");
            getActivity().getMenuInflater().inflate(R.menu.plan_cm, contextMenu);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
        if (menuItem.getItemId() != R.id.deletePlanItem) {
            toBeDeletetedPlanId = -1;
            return true;
        } else if (toBeDeletetedPlanId == -1) {
            return true;
        } else {
            ((EventListener) getParentFragment()).deletePlanClicked(toBeDeletetedPlanId);
            toBeDeletetedPlanId = -1;
            return true;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBooleanArray("expanded_position", this.expanded);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == WORKOUT_TRACKING_REQUEST_CODE && intent.getStringExtra("action").equals("completed_tracking")) {
            ((WorkoutPlanDayFragment.TrackingEventListener) getActivity()).completedTracking();
        }
    }

    private void bind() {
        try {
            this.adapter.notifyDataSetChanged();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void loadDays() {
        this.daysList.add("SUN");
        this.daysList.add("MON");
        this.daysList.add("TUE");
        this.daysList.add("WED");
        this.daysList.add("THU");
        this.daysList.add("FRI");
        this.daysList.add("SAT");
    }

    /* access modifiers changed from: private */
    public String getNote() {
        JSONObject jSONObject = this.plan;
        if (jSONObject == null) {
            return null;
        }
        try {
            if (jSONObject.isNull(Part.NOTE_MESSAGE_STYLE) || this.plan.getString(Part.NOTE_MESSAGE_STYLE).trim().length() == 0) {
                return null;
            }
            return this.plan.getString(Part.NOTE_MESSAGE_STYLE).trim();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: private */
    public String getDayDetail(int i) {
        JSONObject jSONObject = this.plan;
        if (jSONObject == null) {
            return "";
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("days").getJSONObject(i).getJSONArray("drills");
            if (jSONArray.length() == 0) {
                return getString(R.string.noWorkout);
            }
            int length = jSONArray.length();
            String str = "";
            for (int i2 = 0; i2 < length; i2++) {
                if (jSONArray.getJSONObject(i2).getInt("exercise_id") != 1) {
                    str = str + jSONArray.getJSONObject(i2).getString("exercise_name");
                    if (i2 != length - 1) {
                        str = str + " • ";
                    }
                }
            }
            return str;
        } catch (JSONException unused) {
            return "";
        }
    }

    /* access modifiers changed from: private */
    public String getActivationDateDisplayStr() {
        if (!(!this.plan.isNull("activation_date"))) {
            return null;
        }
        try {
            return DateUtils.getDayAndDate(DateUtils.getDateFromISOFormat(this.plan.getString("activation_date")));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void setNoteAndPlanHeader() {
        TextView textView = (TextView) this.headerView.findViewById(R.id.titleLbl);
        TextView textView2 = (TextView) this.headerView.findViewById(R.id.detailLbl);
        TextView textView3 = (TextView) this.headerView.findViewById(R.id.dateLbl);
        LinearLayout linearLayout = (LinearLayout) this.headerView.findViewById(R.id.noteViewWrapper);
        TextView textView4 = (TextView) linearLayout.findViewById(R.id.noteTV);
        if (this.viewedByClient) {
            if (getNote() == null) {
                linearLayout.setVisibility(8);
                textView4.setText(getString(R.string.addNote));
                textView4.setTextColor(ContextCompat.getColor(getActivity(), R.color.black50PercentColor));
            } else {
                linearLayout.setVisibility(0);
                textView4.setText(String.format("%s", new Object[]{getNote()}));
                final String charSequence = textView4.getText().toString();
                if (charSequence.length() > 140) {
                    SpannableString spannableString = new SpannableString((charSequence.substring(0, 140) + "...") + " Read More");
                    final TextView textView5 = textView4;
                    AnonymousClass2 r10 = r0;
                    final SpannableString spannableString2 = spannableString;
                    AnonymousClass2 r0 = new ClickableSpan(" Read Less") {
                        public void onClick(View view) {
                            SpannableString spannableString = new SpannableString(charSequence + " Read Less");
                            spannableString.setSpan(new ClickableSpan() {
                                public void onClick(View view) {
                                    textView5.setText(spannableString2);
                                    textView5.setMovementMethod(LinkMovementMethod.getInstance());
                                }

                                public void updateDrawState(TextPaint textPaint) {
                                    super.updateDrawState(textPaint);
                                    textPaint.setUnderlineText(false);
                                }
                            }, charSequence.length(), spannableString.length(), 33);
                            spannableString.setSpan(new ForegroundColorSpan(WorkoutPlanWeekFragment.this.getResources().getColor(R.color.tintColor)), charSequence.length(), spannableString.length(), 33);
                            textView5.setText(spannableString);
                            textView5.setMovementMethod(LinkMovementMethod.getInstance());
                        }

                        public void updateDrawState(TextPaint textPaint) {
                            super.updateDrawState(textPaint);
                            textPaint.setUnderlineText(false);
                        }
                    };
                    spannableString.setSpan(r10, 143, 153, 33);
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tintColor)), 143, 153, 33);
                    textView4.setText(spannableString);
                    textView4.setMovementMethod(LinkMovementMethod.getInstance());
                } else {
                    textView4.setText(charSequence);
                }
            }
            textView.setVisibility(8);
            String activationDateDisplayStr = getActivationDateDisplayStr();
            if (this.planStage == WorkoutPlanStage.CURRENT_PLAN) {
                textView2.setText(String.format("This is your current workout plan. You started this plan on %s", new Object[]{activationDateDisplayStr}));
            } else if (this.planStage != WorkoutPlanStage.UPCOMING_PLAN) {
                textView2.setText(String.format("This is your past workout plan. You started this plan on %s", new Object[]{activationDateDisplayStr}));
            } else if (activationDateDisplayStr != null) {
                textView2.setText(String.format("This is your upcoming plan. You will start this plan on %s", new Object[]{activationDateDisplayStr}));
            } else {
                textView2.setText(getString(R.string.upcomingPlanMissingDate));
                textView2.setTextColor(ContextCompat.getColor(getActivity(), R.color.strawberryColor));
            }
        } else {
            int sizeInPx = Util.sizeInPx(getActivity(), 10);
            this.listView.setPadding(sizeInPx, sizeInPx, sizeInPx, sizeInPx);
            if (this.forClientPlan) {
                String activationDateDisplayStr2 = getActivationDateDisplayStr();
                if (this.planStage == WorkoutPlanStage.CURRENT_PLAN) {
                    textView.setText(getString(R.string.currentPlan));
                    textView2.setText(String.format(getString(R.string.currentPlanDetail), new Object[]{this.contextUserFirstName}));
                } else if (this.planStage == WorkoutPlanStage.UPCOMING_PLAN) {
                    textView.setText(getString(R.string.upcomingPlan));
                    if (activationDateDisplayStr2 != null) {
                        textView2.setText(String.format(getString(R.string.upcomingPlanDetail), new Object[]{this.contextUserFirstName, activationDateDisplayStr2}));
                        return;
                    }
                    textView2.setText(getString(R.string.upcomingPlanMissingDate));
                    textView2.setTextColor(ContextCompat.getColor(getActivity(), R.color.strawberryColor));
                } else {
                    textView.setText(getString(R.string.pastPlan));
                    textView2.setText(String.format(getString(R.string.pastPlanDetail), new Object[]{this.contextUserFirstName}));
                    textView3.setVisibility(0);
                    textView3.setText(String.format("Started on %s", new Object[]{activationDateDisplayStr2}));
                }
            } else {
                textView.setText(String.format(getString(R.string.weekNPlan), new Object[]{String.valueOf(this.weekNum)}));
            }
        }
    }

    public void setupFooter() {
        if (!this.viewedByClient) {
            this.footerView.findViewById(R.id.toolbar).setVisibility(0);
            this.footerView.findViewById(R.id.copyPlanBtn).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    try {
                        ((EventListener) WorkoutPlanWeekFragment.this.getParentFragment()).copyPlanClicked(WorkoutPlanWeekFragment.this.plan.getInt("id"));
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            this.footerView.findViewById(R.id.pastePlanBtn).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    try {
                        ((EventListener) WorkoutPlanWeekFragment.this.getParentFragment()).pastePlanClicked(WorkoutPlanWeekFragment.this.plan.getInt("id"));
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            final TextView textView = (TextView) this.footerView.findViewById(R.id.moreBtn);
            registerForContextMenu(textView);
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    WorkoutPlanWeekFragment.this.getActivity().openContextMenu(textView);
                }
            });
            this.footerView.findViewById(R.id.emailPlanBtn).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    try {
                        ((EventListener) WorkoutPlanWeekFragment.this.getParentFragment()).emailPlanClicked(WorkoutPlanWeekFragment.this.plan.getInt("id"));
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void onDayClick(int i) {
        if (i < 8) {
            try {
                Intent intent = new Intent(getActivity(), WorkoutPlanDayActivity.class);
                intent.putExtra("program_id", this.plan.getInt("id"));
                intent.putExtra("dayOfWeek", i + 1);
                intent.putExtra("context_user_id", this.contextUserId);
                intent.putExtra("for_client_plan", this.forClientPlan);
                intent.putExtra("view_type", (this.viewedByClient ? WorkoutPlanDayViewType.TRACKING : WorkoutPlanDayViewType.EDITING_CLIENT_PLAN).getMask());
                startActivityForResult(intent, WORKOUT_TRACKING_REQUEST_CODE);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (this.forClientPlan && this.planStage == WorkoutPlanStage.UPCOMING_PLAN && i == 8) {
            Date date = null;
            String string = this.plan.isNull("activation_date") ? null : this.plan.getString("activation_date");
            EventListener eventListener = (EventListener) getParentFragment();
            int i2 = this.plan.getInt("id");
            if (string != null) {
                date = DateUtils.getDateFromISOFormat(string);
            }
            eventListener.updateStartDateClicked(i2, date);
        } else {
            if (!this.plan.isNull(Part.NOTE_MESSAGE_STYLE)) {
                this.plan.getString(Part.NOTE_MESSAGE_STYLE);
            }
            ((EventListener) getParentFragment()).editNoteClicked(this.plan.getInt("id"), getNote());
        }
    }

    public void copyWorkout(int i) {
        try {
            ((EventListener) this.parentFragment).copyWorkoutClicked(i, this.plan.getInt("id"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void pasteWorkout(int i) {
        try {
            ((EventListener) this.parentFragment).pasteWorkoutClicked(i, this.plan.getInt("id"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private class ListViewAdapter extends BaseAdapter {
        private Context context;
        private int nextPlannedDay;

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }

        public ListViewAdapter(Context context2) {
            this.context = context2;
        }

        public int getCount() {
            if (WorkoutPlanWeekFragment.this.viewedByClient) {
                if (WorkoutPlanWeekFragment.this.plan == null || WorkoutPlanWeekFragment.this.getNote() == null) {
                    return 7;
                }
                return 8;
            } else if (!WorkoutPlanWeekFragment.this.forClientPlan || WorkoutPlanWeekFragment.this.planStage != WorkoutPlanStage.UPCOMING_PLAN) {
                return 8;
            } else {
                return 9;
            }
        }

        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        /* JADX WARNING: Removed duplicated region for block: B:41:0x01e4 A[Catch:{ JSONException -> 0x0255 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.view.View getView(int r22, android.view.View r23, android.view.ViewGroup r24) {
            /*
                r21 = this;
                r8 = r21
                r9 = r22
                java.lang.String r10 = "next_due_workout_planned_day"
                java.lang.String r0 = "days"
                r1 = 7
                r2 = 0
                java.lang.String r3 = "layout_inflater"
                if (r9 >= r1) goto L_0x025a
                android.content.Context r1 = r8.context
                java.lang.Object r1 = r1.getSystemService(r3)
                android.view.LayoutInflater r1 = (android.view.LayoutInflater) r1
                r3 = 2131558837(0x7f0d01b5, float:1.8743001E38)
                android.view.View r14 = r1.inflate(r3, r2)
                r1 = 2131362214(0x7f0a01a6, float:1.8344202E38)
                android.view.View r1 = r14.findViewById(r1)
                android.widget.TextView r1 = (android.widget.TextView) r1
                r2 = 2131362323(0x7f0a0213, float:1.8344423E38)
                android.view.View r2 = r14.findViewById(r2)
                r15 = r2
                android.widget.TextView r15 = (android.widget.TextView) r15
                r2 = 2131362324(0x7f0a0214, float:1.8344425E38)
                android.view.View r2 = r14.findViewById(r2)
                r7 = r2
                androidx.cardview.widget.CardView r7 = (androidx.cardview.widget.CardView) r7
                com.trainerfu.android.WorkoutPlanWeekFragment r2 = com.trainerfu.android.WorkoutPlanWeekFragment.this
                java.util.List r2 = r2.daysList
                java.lang.Object r2 = r2.get(r9)
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r1.setText(r2)
                r1 = 2131363357(0x7f0a061d, float:1.834652E38)
                android.view.View r1 = r14.findViewById(r1)
                r6 = r1
                android.widget.TextView r6 = (android.widget.TextView) r6
                r1 = 2131362215(0x7f0a01a7, float:1.8344204E38)
                android.view.View r1 = r14.findViewById(r1)
                android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
                r2 = 2131362218(0x7f0a01aa, float:1.834421E38)
                android.view.View r2 = r14.findViewById(r2)
                android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
                r2 = 2131362216(0x7f0a01a8, float:1.8344206E38)
                android.view.View r2 = r14.findViewById(r2)
                r5 = r2
                android.widget.ListView r5 = (android.widget.ListView) r5
                r2 = 2131362258(0x7f0a01d2, float:1.8344292E38)
                android.view.View r2 = r14.findViewById(r2)
                android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
                r3 = 2131362257(0x7f0a01d1, float:1.834429E38)
                android.view.View r3 = r14.findViewById(r3)
                r4 = r3
                android.widget.ImageView r4 = (android.widget.ImageView) r4
                r3 = 2131362105(0x7f0a0139, float:1.8343981E38)
                android.view.View r3 = r14.findViewById(r3)
                android.widget.ImageView r3 = (android.widget.ImageView) r3
                r11 = 2131362856(0x7f0a0428, float:1.8345504E38)
                android.view.View r11 = r14.findViewById(r11)
                android.widget.TextView r11 = (android.widget.TextView) r11
                r12 = 2131362786(0x7f0a03e2, float:1.8345362E38)
                android.view.View r12 = r14.findViewById(r12)
                android.widget.ImageView r12 = (android.widget.ImageView) r12
                com.trainerfu.android.WorkoutPlanWeekFragment r13 = com.trainerfu.android.WorkoutPlanWeekFragment.this
                boolean[] r13 = r13.expanded
                boolean r13 = r13[r9]
                if (r13 == 0) goto L_0x00ba
                r13 = 0
                r5.setVisibility(r13)
                r13 = 8
                r6.setVisibility(r13)
                r4.setVisibility(r13)
                r13 = 0
                r3.setVisibility(r13)
                r16 = r7
                goto L_0x00cb
            L_0x00ba:
                r16 = r7
                r7 = 8
                r13 = 0
                r5.setVisibility(r7)
                r6.setVisibility(r13)
                r4.setVisibility(r13)
                r3.setVisibility(r7)
            L_0x00cb:
                com.trainerfu.android.WorkoutPlanWeekFragment r7 = com.trainerfu.android.WorkoutPlanWeekFragment.this
                boolean r7 = r7.viewedByClient
                if (r7 == 0) goto L_0x00d7
                r7 = 4
                r12.setVisibility(r7)
            L_0x00d7:
                com.trainerfu.android.WorkoutPlanWeekFragment r7 = com.trainerfu.android.WorkoutPlanWeekFragment.this     // Catch:{ JSONException -> 0x01d2 }
                org.json.JSONObject r7 = r7.plan     // Catch:{ JSONException -> 0x01d2 }
                org.json.JSONArray r7 = r7.getJSONArray(r0)     // Catch:{ JSONException -> 0x01d2 }
                org.json.JSONObject r7 = r7.getJSONObject(r9)     // Catch:{ JSONException -> 0x01d2 }
                java.lang.String r13 = "drills"
                org.json.JSONArray r7 = r7.getJSONArray(r13)     // Catch:{ JSONException -> 0x01d2 }
                com.trainerfu.android.WorkoutPlanWeekFragment r13 = com.trainerfu.android.WorkoutPlanWeekFragment.this     // Catch:{ JSONException -> 0x01d2 }
                org.json.JSONObject r13 = r13.plan     // Catch:{ JSONException -> 0x01d2 }
                org.json.JSONArray r0 = r13.getJSONArray(r0)     // Catch:{ JSONException -> 0x01d2 }
                org.json.JSONObject r0 = r0.getJSONObject(r9)     // Catch:{ JSONException -> 0x01d2 }
                com.trainerfu.android.WorkoutPlanWeekFragment$DayDetailListAdapter r13 = new com.trainerfu.android.WorkoutPlanWeekFragment$DayDetailListAdapter     // Catch:{ JSONException -> 0x01d2 }
                r17 = r3
                com.trainerfu.android.WorkoutPlanWeekFragment r3 = com.trainerfu.android.WorkoutPlanWeekFragment.this     // Catch:{ JSONException -> 0x01d2 }
                r18 = r15
                com.trainerfu.android.WorkoutPlanWeekFragment r15 = com.trainerfu.android.WorkoutPlanWeekFragment.this     // Catch:{ JSONException -> 0x01ce }
                android.content.Context r15 = r15.getContext()     // Catch:{ JSONException -> 0x01ce }
                r13.<init>(r15, r0)     // Catch:{ JSONException -> 0x01ce }
                r5.setAdapter(r13)     // Catch:{ JSONException -> 0x01ce }
                r13.notifyDataSetChanged()     // Catch:{ JSONException -> 0x01ce }
                com.trainerfu.android.WorkoutPlanWeekFragment r0 = com.trainerfu.android.WorkoutPlanWeekFragment.this     // Catch:{ JSONException -> 0x01ce }
                boolean r0 = r0.viewedByClient     // Catch:{ JSONException -> 0x01ce }
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ JSONException -> 0x01ce }
                com.trainerfu.android.WorkoutPlanWeekFragment.setListViewHeightBasedOnChildren(r5, r0)     // Catch:{ JSONException -> 0x01ce }
                com.trainerfu.android.WorkoutPlanWeekFragment r0 = com.trainerfu.android.WorkoutPlanWeekFragment.this     // Catch:{ JSONException -> 0x01ce }
                boolean[] r0 = r0.expanded     // Catch:{ JSONException -> 0x01ce }
                boolean r0 = r0[r9]     // Catch:{ JSONException -> 0x01ce }
                if (r0 != 0) goto L_0x0129
                r0 = 0
                goto L_0x012b
            L_0x0129:
                r0 = 8
            L_0x012b:
                r4.setVisibility(r0)     // Catch:{ JSONException -> 0x01ce }
                r0 = 2131362335(0x7f0a021f, float:1.8344448E38)
                android.view.View r0 = r14.findViewById(r0)     // Catch:{ JSONException -> 0x01ce }
                com.joanzapata.iconify.widget.IconTextView r0 = (com.joanzapata.iconify.widget.IconTextView) r0     // Catch:{ JSONException -> 0x01ce }
                int r3 = r7.length()     // Catch:{ JSONException -> 0x01ce }
                if (r3 != 0) goto L_0x016f
                r3 = 0
                r1.setVisibility(r3)     // Catch:{ JSONException -> 0x01ce }
                r11.setVisibility(r3)     // Catch:{ JSONException -> 0x01ce }
                r3 = 8
                r2.setVisibility(r3)     // Catch:{ JSONException -> 0x01ce }
                r5.setVisibility(r3)     // Catch:{ JSONException -> 0x01ce }
                r6.setVisibility(r3)     // Catch:{ JSONException -> 0x01ce }
                com.trainerfu.android.WorkoutPlanWeekFragment r2 = com.trainerfu.android.WorkoutPlanWeekFragment.this     // Catch:{ JSONException -> 0x01ce }
                boolean r2 = r2.viewedByClient     // Catch:{ JSONException -> 0x01ce }
                if (r2 == 0) goto L_0x016a
                r1.setVisibility(r3)     // Catch:{ JSONException -> 0x01ce }
                r11.setVisibility(r3)     // Catch:{ JSONException -> 0x01ce }
                r1 = 0
                r6.setVisibility(r1)     // Catch:{ JSONException -> 0x01ce }
                com.trainerfu.android.WorkoutPlanWeekFragment r1 = com.trainerfu.android.WorkoutPlanWeekFragment.this     // Catch:{ JSONException -> 0x01ce }
                java.lang.String r1 = r1.getDayDetail(r9)     // Catch:{ JSONException -> 0x01ce }
                r6.setText(r1)     // Catch:{ JSONException -> 0x01ce }
            L_0x016a:
                r20 = r14
                r14 = r16
                goto L_0x01bb
            L_0x016f:
                r3 = 0
                r2.setVisibility(r3)     // Catch:{ JSONException -> 0x01ce }
                com.trainerfu.android.WorkoutPlanWeekFragment r2 = com.trainerfu.android.WorkoutPlanWeekFragment.this     // Catch:{ JSONException -> 0x01ce }
                java.lang.String r2 = r2.getDayDetail(r9)     // Catch:{ JSONException -> 0x01ce }
                r6.setText(r2)     // Catch:{ JSONException -> 0x01ce }
                r1.setVisibility(r3)     // Catch:{ JSONException -> 0x01ce }
                com.trainerfu.android.WorkoutPlanWeekFragment r1 = com.trainerfu.android.WorkoutPlanWeekFragment.this     // Catch:{ JSONException -> 0x01ce }
                boolean r1 = r1.viewedByClient     // Catch:{ JSONException -> 0x01ce }
                if (r1 == 0) goto L_0x018c
                java.lang.String r1 = "Start This Workout"
                r0.setText(r1)     // Catch:{ JSONException -> 0x01ce }
            L_0x018c:
                com.trainerfu.android.WorkoutPlanWeekFragment$ListViewAdapter$1 r11 = new com.trainerfu.android.WorkoutPlanWeekFragment$ListViewAdapter$1     // Catch:{ JSONException -> 0x01ce }
                r1 = r11
                r2 = r21
                r13 = r17
                r3 = r5
                r15 = r4
                r4 = r6
                r17 = r5
                r5 = r15
                r19 = r6
                r6 = r13
                r20 = r14
                r14 = r16
                r7 = r22
                r1.<init>(r3, r4, r5, r6, r7)     // Catch:{ JSONException -> 0x01cc }
                r15.setOnClickListener(r11)     // Catch:{ JSONException -> 0x01cc }
                com.trainerfu.android.WorkoutPlanWeekFragment$ListViewAdapter$2 r11 = new com.trainerfu.android.WorkoutPlanWeekFragment$ListViewAdapter$2     // Catch:{ JSONException -> 0x01cc }
                r1 = r11
                r2 = r21
                r3 = r17
                r4 = r19
                r5 = r15
                r6 = r13
                r7 = r22
                r1.<init>(r3, r4, r5, r6, r7)     // Catch:{ JSONException -> 0x01cc }
                r13.setOnClickListener(r11)     // Catch:{ JSONException -> 0x01cc }
            L_0x01bb:
                com.trainerfu.android.WorkoutPlanWeekFragment$ListViewAdapter$3 r1 = new com.trainerfu.android.WorkoutPlanWeekFragment$ListViewAdapter$3     // Catch:{ JSONException -> 0x01cc }
                r1.<init>(r9)     // Catch:{ JSONException -> 0x01cc }
                r0.setOnClickListener(r1)     // Catch:{ JSONException -> 0x01cc }
                com.trainerfu.android.WorkoutPlanWeekFragment$ListViewAdapter$4 r0 = new com.trainerfu.android.WorkoutPlanWeekFragment$ListViewAdapter$4     // Catch:{ JSONException -> 0x01cc }
                r0.<init>(r9)     // Catch:{ JSONException -> 0x01cc }
                r12.setOnClickListener(r0)     // Catch:{ JSONException -> 0x01cc }
                goto L_0x01dc
            L_0x01cc:
                r0 = move-exception
                goto L_0x01d9
            L_0x01ce:
                r0 = move-exception
                r20 = r14
                goto L_0x01d7
            L_0x01d2:
                r0 = move-exception
                r20 = r14
                r18 = r15
            L_0x01d7:
                r14 = r16
            L_0x01d9:
                r0.printStackTrace()
            L_0x01dc:
                com.trainerfu.android.WorkoutPlanWeekFragment r0 = com.trainerfu.android.WorkoutPlanWeekFragment.this     // Catch:{ JSONException -> 0x0255 }
                org.json.JSONObject r0 = r0.summary     // Catch:{ JSONException -> 0x0255 }
                if (r0 == 0) goto L_0x0259
                com.trainerfu.android.WorkoutPlanWeekFragment r0 = com.trainerfu.android.WorkoutPlanWeekFragment.this     // Catch:{ JSONException -> 0x0255 }
                org.json.JSONObject r0 = r0.summary     // Catch:{ JSONException -> 0x0255 }
                java.lang.String r1 = "next_workout_schedule"
                org.json.JSONObject r0 = r0.getJSONObject(r1)     // Catch:{ JSONException -> 0x0255 }
                int r1 = r0.getInt(r10)     // Catch:{ JSONException -> 0x0255 }
                r8.nextPlannedDay = r1     // Catch:{ JSONException -> 0x0255 }
                boolean r1 = r0.isNull(r10)     // Catch:{ JSONException -> 0x0255 }
                if (r1 == 0) goto L_0x0200
                r0 = -1
                r8.nextPlannedDay = r0     // Catch:{ JSONException -> 0x0255 }
                goto L_0x0259
            L_0x0200:
                int r1 = r8.nextPlannedDay     // Catch:{ JSONException -> 0x0255 }
                r2 = 1
                int r3 = r9 + 1
                if (r1 != r3) goto L_0x020c
                r1 = 0
                r14.setVisibility(r1)     // Catch:{ JSONException -> 0x0255 }
                goto L_0x0211
            L_0x020c:
                r1 = 8
                r14.setVisibility(r1)     // Catch:{ JSONException -> 0x0255 }
            L_0x0211:
                java.lang.String r1 = "due_in_days"
                int r0 = r0.getInt(r1)     // Catch:{ JSONException -> 0x0255 }
                if (r0 != 0) goto L_0x0228
                com.trainerfu.android.WorkoutPlanWeekFragment r0 = com.trainerfu.android.WorkoutPlanWeekFragment.this     // Catch:{ JSONException -> 0x0255 }
                r1 = 2131952022(0x7f130196, float:1.9540475E38)
                java.lang.String r0 = r0.getString(r1)     // Catch:{ JSONException -> 0x0255 }
                r2 = r18
                r2.setText(r0)     // Catch:{ JSONException -> 0x0255 }
                goto L_0x0259
            L_0x0228:
                r2 = r18
                r1 = 1
                if (r0 != r1) goto L_0x023a
                com.trainerfu.android.WorkoutPlanWeekFragment r0 = com.trainerfu.android.WorkoutPlanWeekFragment.this     // Catch:{ JSONException -> 0x0255 }
                r1 = 2131952023(0x7f130197, float:1.9540477E38)
                java.lang.String r0 = r0.getString(r1)     // Catch:{ JSONException -> 0x0255 }
                r2.setText(r0)     // Catch:{ JSONException -> 0x0255 }
                goto L_0x0259
            L_0x023a:
                com.trainerfu.android.WorkoutPlanWeekFragment r1 = com.trainerfu.android.WorkoutPlanWeekFragment.this     // Catch:{ JSONException -> 0x0255 }
                r3 = 2131952021(0x7f130195, float:1.9540473E38)
                java.lang.String r1 = r1.getString(r3)     // Catch:{ JSONException -> 0x0255 }
                r3 = 1
                java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ JSONException -> 0x0255 }
                java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ JSONException -> 0x0255 }
                r4 = 0
                r3[r4] = r0     // Catch:{ JSONException -> 0x0255 }
                java.lang.String r0 = java.lang.String.format(r1, r3)     // Catch:{ JSONException -> 0x0255 }
                r2.setText(r0)     // Catch:{ JSONException -> 0x0255 }
                goto L_0x0259
            L_0x0255:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0259:
                return r20
            L_0x025a:
                com.trainerfu.android.WorkoutPlanWeekFragment r0 = com.trainerfu.android.WorkoutPlanWeekFragment.this
                boolean r0 = r0.forClientPlan
                if (r0 == 0) goto L_0x02af
                com.trainerfu.android.WorkoutPlanWeekFragment r0 = com.trainerfu.android.WorkoutPlanWeekFragment.this
                com.trainerfu.android.WorkoutPlanStage r0 = r0.planStage
                com.trainerfu.android.WorkoutPlanStage r4 = com.trainerfu.android.WorkoutPlanStage.UPCOMING_PLAN
                if (r0 != r4) goto L_0x02af
                if (r9 != r1) goto L_0x02af
                android.content.Context r0 = r8.context
                java.lang.Object r0 = r0.getSystemService(r3)
                android.view.LayoutInflater r0 = (android.view.LayoutInflater) r0
                r1 = 2131558838(0x7f0d01b6, float:1.8743003E38)
                android.view.View r0 = r0.inflate(r1, r2)
                r1 = 2131363213(0x7f0a058d, float:1.8346228E38)
                android.view.View r1 = r0.findViewById(r1)
                android.widget.TextView r1 = (android.widget.TextView) r1
                com.trainerfu.android.WorkoutPlanWeekFragment r2 = com.trainerfu.android.WorkoutPlanWeekFragment.this
                java.lang.String r2 = r2.getActivationDateDisplayStr()
                if (r2 == 0) goto L_0x0292
                r1.setText(r2)
                goto L_0x02ae
            L_0x0292:
                com.trainerfu.android.WorkoutPlanWeekFragment r2 = com.trainerfu.android.WorkoutPlanWeekFragment.this
                r3 = 2131951723(0x7f13006b, float:1.9539869E38)
                java.lang.String r2 = r2.getString(r3)
                r1.setText(r2)
                com.trainerfu.android.WorkoutPlanWeekFragment r2 = com.trainerfu.android.WorkoutPlanWeekFragment.this
                androidx.fragment.app.FragmentActivity r2 = r2.getActivity()
                r3 = 2131100500(0x7f060354, float:1.7813383E38)
                int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)
                r1.setTextColor(r2)
            L_0x02ae:
                return r0
            L_0x02af:
                android.content.Context r0 = r8.context
                java.lang.Object r0 = r0.getSystemService(r3)
                android.view.LayoutInflater r0 = (android.view.LayoutInflater) r0
                r1 = 2131558836(0x7f0d01b4, float:1.8743E38)
                android.view.View r0 = r0.inflate(r1, r2)
                r1 = 2131362866(0x7f0a0432, float:1.8345525E38)
                android.view.View r1 = r0.findViewById(r1)
                android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
                r2 = 2131362865(0x7f0a0431, float:1.8345523E38)
                android.view.View r3 = r0.findViewById(r2)
                android.widget.TextView r3 = (android.widget.TextView) r3
                r4 = 2131362864(0x7f0a0430, float:1.834552E38)
                android.view.View r4 = r0.findViewById(r4)
                android.widget.TextView r4 = (android.widget.TextView) r4
                com.trainerfu.android.WorkoutPlanWeekFragment r5 = com.trainerfu.android.WorkoutPlanWeekFragment.this
                java.lang.String r5 = r5.getNote()
                if (r5 != 0) goto L_0x02ff
                com.trainerfu.android.WorkoutPlanWeekFragment r4 = com.trainerfu.android.WorkoutPlanWeekFragment.this
                r5 = 2131951799(0x7f1300b7, float:1.9540023E38)
                java.lang.String r4 = r4.getString(r5)
                r3.setText(r4)
                com.trainerfu.android.WorkoutPlanWeekFragment r4 = com.trainerfu.android.WorkoutPlanWeekFragment.this
                androidx.fragment.app.FragmentActivity r4 = r4.getActivity()
                r5 = 2131099696(0x7f060030, float:1.7811752E38)
                int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
                r3.setTextColor(r4)
                r5 = 0
                goto L_0x0317
            L_0x02ff:
                r5 = 0
                r4.setVisibility(r5)
                r4 = 1
                java.lang.Object[] r4 = new java.lang.Object[r4]
                com.trainerfu.android.WorkoutPlanWeekFragment r6 = com.trainerfu.android.WorkoutPlanWeekFragment.this
                java.lang.String r6 = r6.getNote()
                r4[r5] = r6
                java.lang.String r6 = "%s"
                java.lang.String r4 = java.lang.String.format(r6, r4)
                r3.setText(r4)
            L_0x0317:
                com.trainerfu.android.WorkoutPlanWeekFragment r3 = com.trainerfu.android.WorkoutPlanWeekFragment.this
                boolean r3 = r3.viewedByClient
                if (r3 != 0) goto L_0x0331
                r1 = 2131361927(0x7f0a0087, float:1.834362E38)
                android.view.View r1 = r0.findViewById(r1)
                r1.setVisibility(r5)
                android.view.View r1 = r0.findViewById(r2)
                r1.setVisibility(r5)
                goto L_0x0336
            L_0x0331:
                r2 = 8
                r1.setVisibility(r2)
            L_0x0336:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.android.WorkoutPlanWeekFragment.ListViewAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }
    }

    private class DayDetailListAdapter extends BaseAdapter {
        private Context context;
        private JSONArray drills;
        private JSONObject exerciseDetail;
        private boolean isGroupDrill = false;
        private int nextPlannedDay;

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }

        public DayDetailListAdapter(Context context2, JSONObject jSONObject) {
            this.context = context2;
            this.exerciseDetail = jSONObject;
            try {
                this.drills = jSONObject.getJSONArray("drills");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public int getCount() {
            return this.drills.length();
        }

        public JSONObject getItem(int i) {
            try {
                return this.drills.getJSONObject(i);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.day_detail_list_row, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.exercise_name);
            TextView textView2 = (TextView) inflate.findViewById(R.id.exercise_detail);
            try {
                JSONObject jSONObject = this.drills.getJSONObject(i);
                ProgramDrillType programDrillType = ProgramDrillType.get(jSONObject.optInt("program_drill_type", 1));
                String detailText = DrillViewHelper.getDetailText(jSONObject, (JSONObject) null, WorkoutPlanWeekFragment.this.getContext(), true, true);
                String text = WorkoutPlanWeekFragment.this.getText(jSONObject);
                if (text != "") {
                    textView.setText(text);
                } else {
                    textView.setVisibility(8);
                    textView2.setVisibility(8);
                    inflate.setVisibility(8);
                }
                if (!TextUtils.isEmpty(detailText)) {
                    textView2.setText(detailText);
                } else {
                    textView2.setVisibility(8);
                }
                if (programDrillType == ProgramDrillType.START_CIRCUIT || programDrillType == ProgramDrillType.START_SUPERSET) {
                    this.isGroupDrill = true;
                    textView.setTextColor(WorkoutPlanWeekFragment.this.getResources().getColor(R.color.lightTextColor));
                    textView.setTypeface(textView.getTypeface(), 1);
                }
                if (programDrillType == ProgramDrillType.END_CIRCUIT || programDrillType == ProgramDrillType.END_SUPERSET) {
                    this.isGroupDrill = false;
                    inflate.setPadding(0, 0, 0, 0);
                }
                if (this.isGroupDrill) {
                    inflate.setBackground(ResourcesCompat.getDrawable(this.context.getResources(), R.drawable.left_border, (Resources.Theme) null));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return inflate;
        }
    }

    public static void setListViewHeightBasedOnChildren(ListView listView2, Boolean bool) {
        float f;
        ListAdapter adapter2 = listView2.getAdapter();
        if (adapter2 != null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(listView2.getWidth(), 0);
            View view = null;
            int i = 0;
            for (int i2 = 0; i2 < adapter2.getCount(); i2++) {
                view = adapter2.getView(i2, view, listView2);
                if (i2 == 0) {
                    view.setLayoutParams(new ViewGroup.LayoutParams(makeMeasureSpec, -2));
                }
                if (bool.booleanValue()) {
                    f = (float) Resources.getSystem().getDisplayMetrics().widthPixels;
                } else {
                    f = 325.0f * listView2.getResources().getDisplayMetrics().density;
                }
                ProgramDrillType programDrillType = ProgramDrillType.get(((JSONObject) adapter2.getItem(i2)).optInt("program_drill_type", 1));
                if (!(programDrillType == ProgramDrillType.END_CIRCUIT || programDrillType == ProgramDrillType.END_SUPERSET)) {
                    view.measure(View.MeasureSpec.makeMeasureSpec((int) f, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                    i += view.getMeasuredHeight();
                }
            }
            ViewGroup.LayoutParams layoutParams = listView2.getLayoutParams();
            layoutParams.height = i + (listView2.getDividerHeight() * (adapter2.getCount() - 1));
            listView2.setLayoutParams(layoutParams);
        }
    }

    public String getText(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("program_drill_type", 1);
            if (optInt == 1) {
                return jSONObject.getString("exercise_name");
            }
            if (optInt == 2) {
                String sets = getSets(jSONObject);
                if (sets != null) {
                    if (!sets.isEmpty()) {
                    }
                }
                return "SUPERSET:";
            } else if (optInt != 4) {
                return "";
            } else {
                String sets2 = getSets(jSONObject);
                if (sets2 != null) {
                    if (!sets2.isEmpty()) {
                    }
                }
                return "CIRCUIT:";
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String getSets(JSONObject jSONObject) {
        String str;
        JSONException e;
        try {
            str = ((JSONObject) jSONObject.get("measures")).getString("8");
            if (str != null) {
                try {
                    if (!str.isEmpty()) {
                        return str;
                    }
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    return str;
                }
            }
            return null;
        } catch (JSONException e3) {
            e = e3;
            str = null;
            e.printStackTrace();
            return str;
        }
    }
}
