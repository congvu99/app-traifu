package com.trainerfu.android;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.afollestad.materialdialogs.MaterialDialog;
import com.facebook.internal.NativeProtocol;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.DateUtils;
import com.trainerfu.utils.Util;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.apache.http.Header;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CopyFromPlanTemplateFragment extends Fragment {
    /* access modifiers changed from: private */
    public static int DPF_EVENT_REQUEST_CODE = 34658;
    /* access modifiers changed from: private */
    public static int SC_REQUEST_CODE = 58126;
    /* access modifiers changed from: private */
    public static int SPT_REQUEST_CODE = 47842;
    /* access modifiers changed from: private */
    public static int SS_REQUEST_CODE = 24006;
    /* access modifiers changed from: private */
    public ArrayList<Integer> clientIds = new ArrayList<>();
    /* access modifiers changed from: private */
    public boolean deleteExisting = true;
    private int orderedPlanListId = 0;
    /* access modifiers changed from: private */
    public int orderedPlanListLength = 0;
    private String orderedPlanListName = null;
    /* access modifiers changed from: private */
    public TextView sdDetailTV;
    private int segmentIdFilter = -1;
    /* access modifiers changed from: private */
    public ArrayList<Integer> segmentIds = new ArrayList<>();
    /* access modifiers changed from: private */
    public Date startDate = null;
    /* access modifiers changed from: private */
    public int startWeek = 1;
    /* access modifiers changed from: private */
    public CopyPlanTemplateTaskType taskType;
    private int userId = 0;
    private TextView weekSelectView;
    private Spinner weekSpinner;
    private LinearLayout weekView;
    List<String> weeks = new ArrayList();

    public interface EventListener {
        void handleWeekSelect(int i);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        this.taskType = CopyPlanTemplateTaskType.getCopyPlanTemplateTaskType(arguments.getInt("task_type"));
        this.segmentIdFilter = arguments.getInt("segmentIdFilter");
        if (this.taskType == CopyPlanTemplateTaskType.FOR_COPYING_A_TEMPLATE_TO_SINGLE_CLIENT) {
            this.userId = arguments.getInt("user_id");
        } else {
            this.orderedPlanListId = arguments.getInt("ordered_plan_list_id");
            this.orderedPlanListName = arguments.getString("ordered_plan_list_name");
            this.orderedPlanListLength = arguments.getInt("ordered_plan_list_length");
        }
        View inflate = layoutInflater.inflate(R.layout.copy_from_plan_template_view, viewGroup, false);
        this.weekView = (LinearLayout) inflate.findViewById(R.id.week_view);
        View findViewById = inflate.findViewById(R.id.selector_view);
        this.sdDetailTV = (TextView) inflate.findViewById(R.id.sd_detail_view);
        this.weekSelectView = (TextView) inflate.findViewById(R.id.week_select_view);
        if (this.orderedPlanListLength > 0) {
            this.weekView.setVisibility(0);
            this.weekSpinner = (Spinner) inflate.findViewById(R.id.week_spinner);
            for (int i = 1; i <= this.orderedPlanListLength; i++) {
                List<String> list = this.weeks;
                list.add("Week " + i);
            }
            this.weekSpinner.setDropDownHorizontalOffset(0);
            this.weekSpinner.setAdapter(new WeeksAdapter(getActivity()));
            this.weekSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    adapterView.getItemAtPosition(i).toString();
                    int unused = CopyFromPlanTemplateFragment.this.startWeek = i + 1;
                    if (CopyFromPlanTemplateFragment.this.startDate == null) {
                        TextView access$200 = CopyFromPlanTemplateFragment.this.sdDetailTV;
                        CopyFromPlanTemplateFragment copyFromPlanTemplateFragment = CopyFromPlanTemplateFragment.this;
                        access$200.setText(copyFromPlanTemplateFragment.getString(R.string.cptClientsStartDateDetail, String.valueOf(copyFromPlanTemplateFragment.startWeek)));
                    }
                }
            });
        }
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (CopyFromPlanTemplateFragment.this.taskType == CopyPlanTemplateTaskType.FOR_COPYING_A_TEMPLATE_TO_SINGLE_CLIENT) {
                    Intent intent = new Intent(CopyFromPlanTemplateFragment.this.getActivity(), PlanTemplateListActivity.class);
                    intent.putExtra("for_selection", true);
                    CopyFromPlanTemplateFragment.this.startActivityForResult(intent, CopyFromPlanTemplateFragment.SPT_REQUEST_CODE);
                    return;
                }
                String str = "";
                if (CopyFromPlanTemplateFragment.this.taskType == CopyPlanTemplateTaskType.FOR_COPYING_TO_MANY_CLIENTS) {
                    Intent intent2 = new Intent(CopyFromPlanTemplateFragment.this.getActivity(), RNHostActivity.class);
                    intent2.putExtra("entryRoute", RNEntryRoute.SELECT_CLIENTS.getMask());
                    Bundle bundle = new Bundle();
                    if (CopyFromPlanTemplateFragment.this.clientIds.size() > 0) {
                        str = TextUtils.join("-", CopyFromPlanTemplateFragment.this.clientIds);
                    }
                    bundle.putString("selected", str);
                    intent2.putExtra(NativeProtocol.WEB_DIALOG_PARAMS, bundle);
                    CopyFromPlanTemplateFragment.this.startActivityForResult(intent2, CopyFromPlanTemplateFragment.SC_REQUEST_CODE);
                } else if (CopyFromPlanTemplateFragment.this.taskType == CopyPlanTemplateTaskType.FOR_COPYING_A_PLAN_TEMPLATE_TO_GROUP) {
                    Intent intent3 = new Intent(CopyFromPlanTemplateFragment.this.getActivity(), PlanTemplateListActivity.class);
                    intent3.putExtra("for_selection", true);
                    CopyFromPlanTemplateFragment.this.startActivityForResult(intent3, CopyFromPlanTemplateFragment.SPT_REQUEST_CODE);
                } else {
                    Intent intent4 = new Intent(CopyFromPlanTemplateFragment.this.getActivity(), RNHostActivity.class);
                    intent4.putExtra("entryRoute", RNEntryRoute.SELECT_GROUPS.getMask());
                    Bundle bundle2 = new Bundle();
                    if (CopyFromPlanTemplateFragment.this.segmentIds.size() > 0) {
                        str = TextUtils.join("-", CopyFromPlanTemplateFragment.this.segmentIds);
                    }
                    bundle2.putString("selected", str);
                    intent4.putExtra(NativeProtocol.WEB_DIALOG_PARAMS, bundle2);
                    CopyFromPlanTemplateFragment.this.startActivityForResult(intent4, CopyFromPlanTemplateFragment.SS_REQUEST_CODE);
                }
            }
        });
        inflate.findViewById(R.id.start_date_view).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DatePickerFragment datePickerFragment = new DatePickerFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("request_code", CopyFromPlanTemplateFragment.DPF_EVENT_REQUEST_CODE);
                if (CopyFromPlanTemplateFragment.this.startDate != null) {
                    bundle.putString("date", DateUtils.getISOFormattedDate(CopyFromPlanTemplateFragment.this.startDate));
                } else {
                    bundle.putString("date", DateUtils.getISOFormattedDate(DateUtils.addDays(Calendar.getInstance(), DateUtils.getTodaysDate(), 6)));
                }
                bundle.putBoolean("enable_min_date", true);
                datePickerFragment.setArguments(bundle);
                datePickerFragment.show(CopyFromPlanTemplateFragment.this.getFragmentManager(), "dpf");
            }
        });
        ((CheckBox) inflate.findViewById(R.id.delete_cb)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                boolean unused = CopyFromPlanTemplateFragment.this.deleteExisting = z;
            }
        });
        inflate.findViewById(R.id.copy_btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CopyFromPlanTemplateFragment.this.copy();
            }
        });
        if (this.taskType == CopyPlanTemplateTaskType.FOR_COPYING_A_TEMPLATE_TO_SINGLE_CLIENT) {
            this.sdDetailTV.setText(getString(R.string.cptStartDateDetail));
        } else if (this.taskType == CopyPlanTemplateTaskType.FOR_COPYING_TO_MANY_CLIENTS) {
            this.sdDetailTV.setText(getString(R.string.cptClientsStartDateDetail, String.valueOf(this.startWeek)));
        } else {
            this.sdDetailTV.setText(getString(R.string.cptSegmentsStartDateDetail));
        }
        this.weekView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((EventListener) CopyFromPlanTemplateFragment.this.getActivity()).handleWeekSelect(CopyFromPlanTemplateFragment.this.orderedPlanListLength);
            }
        });
        bind(inflate);
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            int i = bundle.getInt("orderedPlanListId");
            this.orderedPlanListId = i;
            if (i != 0) {
                this.orderedPlanListName = bundle.getString("orderedPlanListName");
            }
            if (bundle.containsKey("startDate")) {
                this.startDate = DateUtils.getDateFromISOFormat(bundle.getString("startDate"));
            }
            this.deleteExisting = bundle.getBoolean("deleteExisting");
            bind(getView());
        }
    }

    private void bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.selector_title_view);
        TextView textView2 = (TextView) view.findViewById(R.id.selector_detail_view);
        if (this.taskType == CopyPlanTemplateTaskType.FOR_COPYING_A_TEMPLATE_TO_SINGLE_CLIENT) {
            String str = this.orderedPlanListName;
            if (str == null) {
                textView.setText(getString(R.string.selectAPlanTemplate));
            } else {
                textView.setText(str);
            }
        } else if (this.taskType == CopyPlanTemplateTaskType.FOR_COPYING_TO_MANY_CLIENTS) {
            if (this.clientIds.size() == 0) {
                textView.setText(getString(R.string.selectClients));
                textView2.setVisibility(8);
            } else {
                textView.setText(getString(R.string.Clients));
                textView2.setText(String.valueOf(this.clientIds.size()));
                textView2.setVisibility(0);
            }
        } else if (this.taskType == CopyPlanTemplateTaskType.FOR_COPYING_A_PLAN_TEMPLATE_TO_GROUP) {
            String str2 = this.orderedPlanListName;
            if (str2 == null) {
                textView.setText(getString(R.string.selectAPlanTemplate));
            } else {
                textView.setText(str2);
            }
        } else if (this.segmentIds.size() == 0) {
            textView.setText(getString(R.string.selectGroups));
            textView2.setVisibility(8);
        } else {
            textView.setText(getString(R.string.Groups));
            textView2.setText(String.valueOf(this.segmentIds.size()));
            textView2.setVisibility(0);
        }
        if (this.startDate != null) {
            ((TextView) getView().findViewById(R.id.sd_detail_view)).setText(DateUtils.getDisplayDate(getActivity(), this.startDate));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("orderedPlanListId", this.orderedPlanListId);
        String str = this.orderedPlanListName;
        if (str != null) {
            bundle.putString("orderedPlanListName", str);
        }
        Date date = this.startDate;
        if (date != null) {
            bundle.putString("startDate", DateUtils.getISOFormattedDate(date));
        }
        bundle.putBoolean("deleteExisting", this.deleteExisting);
    }

    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (isAdded() && i2 == -1) {
            int i3 = 0;
            if (i == SPT_REQUEST_CODE) {
                try {
                    JSONObject jSONObject = new JSONObject(intent.getStringExtra("template"));
                    this.orderedPlanListId = jSONObject.getInt("id");
                    this.orderedPlanListName = jSONObject.getString("name");
                    this.orderedPlanListLength = jSONObject.getInt("length_in_weeks");
                    this.segmentIds.add(Integer.valueOf(this.segmentIdFilter));
                    this.weekView.setVisibility(0);
                    this.weekSpinner = (Spinner) getView().findViewById(R.id.week_spinner);
                    for (int i4 = 1; i4 <= this.orderedPlanListLength; i4++) {
                        List<String> list = this.weeks;
                        list.add("Week " + i4);
                    }
                    this.weekSpinner.setDropDownHorizontalOffset(0);
                    this.weekSpinner.setAdapter(new WeeksAdapter(getActivity()));
                    this.weekSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }

                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                            adapterView.getItemAtPosition(i).toString();
                            int unused = CopyFromPlanTemplateFragment.this.startWeek = i + 1;
                            if (CopyFromPlanTemplateFragment.this.startDate == null) {
                                TextView access$200 = CopyFromPlanTemplateFragment.this.sdDetailTV;
                                CopyFromPlanTemplateFragment copyFromPlanTemplateFragment = CopyFromPlanTemplateFragment.this;
                                access$200.setText(copyFromPlanTemplateFragment.getString(R.string.cptClientsStartDateDetail, String.valueOf(copyFromPlanTemplateFragment.startWeek)));
                            }
                        }
                    });
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            } else if (i == SC_REQUEST_CODE) {
                int[] intArrayExtra = intent.getIntArrayExtra("clientIds");
                this.clientIds.clear();
                while (i3 < intArrayExtra.length) {
                    this.clientIds.add(Integer.valueOf(intArrayExtra[i3]));
                    i3++;
                }
            } else if (i == SS_REQUEST_CODE) {
                int[] intArrayExtra2 = intent.getIntArrayExtra("segmentIds");
                this.segmentIds.clear();
                while (i3 < intArrayExtra2.length) {
                    this.segmentIds.add(Integer.valueOf(intArrayExtra2[i3]));
                    i3++;
                }
            }
            bind(getView());
        }
    }

    @Subscribe
    public void handleDateSelectedEvent(DateSelectedEvent dateSelectedEvent) {
        TextView textView = (TextView) getView().findViewById(R.id.sd_detail_view);
        TextView textView2 = (TextView) getView().findViewById(R.id.warning_view);
        if (dateSelectedEvent.requestCode == DPF_EVENT_REQUEST_CODE) {
            Date todaysDate = DateUtils.getTodaysDate(-6);
            Date todaysDate2 = DateUtils.getTodaysDate();
            Date dateFromISOFormat = DateUtils.getDateFromISOFormat(dateSelectedEvent.date);
            if (dateFromISOFormat.before(todaysDate)) {
                new MaterialDialog.Builder(getActivity()).title((int) R.string.Error).content((int) R.string.invalidPlanActivationDate).positiveText((int) R.string.Ok).show();
                return;
            }
            if (dateFromISOFormat.before(todaysDate2)) {
                textView2.setVisibility(0);
                textView2.setText("Warning: Past date selected. Use past date only to assign or update programs that has already started.");
            } else {
                textView2.setVisibility(8);
            }
            this.startDate = dateFromISOFormat;
            textView.setText(DateUtils.getDisplayDate(getActivity(), dateFromISOFormat));
        }
    }

    /* access modifiers changed from: private */
    public void copy() {
        if (this.taskType == CopyPlanTemplateTaskType.FOR_COPYING_A_TEMPLATE_TO_SINGLE_CLIENT && this.orderedPlanListId == 0) {
            new MaterialDialog.Builder(getActivity()).title((int) R.string.Error).content((int) R.string.selectAPlanTemplate).positiveText((int) R.string.Ok).show();
        } else if (this.taskType == CopyPlanTemplateTaskType.FOR_COPYING_TO_MANY_CLIENTS && this.clientIds.size() == 0) {
            new MaterialDialog.Builder(getActivity()).title((int) R.string.Error).content((int) R.string.noClientsSelected).positiveText((int) R.string.Ok).show();
        } else if (this.taskType == CopyPlanTemplateTaskType.FOR_COPYING_TO_SEGMENTS && this.segmentIds.size() == 0) {
            new MaterialDialog.Builder(getActivity()).title((int) R.string.Error).content((int) R.string.noGroupsSelected).positiveText((int) R.string.Ok).show();
        } else if (this.startDate == null) {
            new MaterialDialog.Builder(getActivity()).title((int) R.string.Error).content((int) R.string.missingStartDate).positiveText((int) R.string.Ok).show();
        } else {
            BaseHttpClient baseHttpClient = new BaseHttpClient(true, getActivity());
            HashMap hashMap = new HashMap();
            if (this.taskType == CopyPlanTemplateTaskType.FOR_COPYING_A_TEMPLATE_TO_SINGLE_CLIENT) {
                hashMap.put("client_id", Integer.valueOf(this.userId));
            } else if (this.taskType == CopyPlanTemplateTaskType.FOR_COPYING_TO_MANY_CLIENTS) {
                hashMap.put("client_ids", new JSONArray(this.clientIds));
            } else if (this.taskType == CopyPlanTemplateTaskType.FOR_COPYING_A_PLAN_TEMPLATE_TO_GROUP) {
                hashMap.put("segment_ids", new JSONArray(this.segmentIds));
            } else {
                hashMap.put("segment_ids", new JSONArray(this.segmentIds));
            }
            hashMap.put("ordered_plan_list_id", Integer.valueOf(this.orderedPlanListId));
            hashMap.put("date", DateUtils.getISOFormattedDate(this.startDate));
            hashMap.put("delete_existing_data", Boolean.valueOf(this.deleteExisting));
            hashMap.put("start_week", Integer.valueOf(this.startWeek));
            baseHttpClient.put("/copy_plan_template_task/ver2", hashMap, new BaseResponseHandler() {
                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    try {
                        if (Boolean.valueOf(jSONObject.getBoolean("is_scheduled_for_later")).booleanValue()) {
                            new MaterialDialog.Builder(CopyFromPlanTemplateFragment.this.getActivity()).title((int) R.string.copyInProgress).content((int) R.string.copyNotifText).positiveText((int) R.string.gotIt).show();
                            return true;
                        }
                        Util.showToast(CopyFromPlanTemplateFragment.this.getActivity(), R.string.copiedSuccessfully);
                        CopyFromPlanTemplateFragment.this.getActivity().setResult(-1, new Intent());
                        CopyFromPlanTemplateFragment.this.getActivity().finish();
                        return true;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return true;
                    }
                }
            });
        }
    }

    public void weekSelected(int i) {
        this.startWeek = i;
        this.weekSelectView.setVisibility(0);
        TextView textView = this.weekSelectView;
        textView.setText("Week " + this.startWeek);
        if (this.startDate == null) {
            this.sdDetailTV.setText(getString(R.string.cptClientsStartDateDetail, String.valueOf(this.startWeek)));
        }
    }

    public class WeeksAdapter implements SpinnerAdapter {
        private Context context;

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            return 1;
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            return true;
        }

        public boolean isEmpty() {
            return false;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        }

        public WeeksAdapter(Context context2) {
            this.context = context2;
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            if (view == null) {
                view = layoutInflater.inflate(R.layout.simple_spinner_dropdown_item, (ViewGroup) null);
            }
            ((TextView) view.findViewById(R.id.spinner_item)).setText("Week " + (i + 1));
            return view;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            if (view == null) {
                view = layoutInflater.inflate(R.layout.simple_spinner_item, (ViewGroup) null);
            }
            ((TextView) view.findViewById(R.id.spinner_title)).setText("Week " + (i + 1));
            return view;
        }

        public int getCount() {
            return CopyFromPlanTemplateFragment.this.weeks.size();
        }

        public Object getItem(int i) {
            return CopyFromPlanTemplateFragment.this.weeks.get(i);
        }
    }
}
