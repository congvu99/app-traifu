package com.trainerfu.android;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import com.gigamole.navigationtabstrip.NavigationTabStrip;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.EntryXComparator;
import com.joanzapata.iconify.widget.IconTextView;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.DateUtils;
import com.trainerfu.utils.Util;
import io.intercom.android.sdk.metrics.MetricTracker;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AssessmentFragment extends Fragment implements NavigationTabStrip.OnTabStripSelectedIndexListener {
    /* access modifiers changed from: private */
    public static DecimalFormat df2 = new DecimalFormat(".##");
    private StableArrayAdapter adapter;
    private IconTextView addDataButton;
    /* access modifiers changed from: private */
    public JSONObject assessmentData;
    private Calendar cal;
    private View chartView;
    private String clientFirstName;
    private NavigationTabStrip durationPicker;
    private LinearLayout emptyAssessmentView;
    private LineChart lineChart;
    private ListView listView;
    private Menu menu;
    private int userId;
    private boolean viewedByTrainer;

    public interface EventListener {
        void onAddAssessmentClicked(JSONObject jSONObject);

        void onAssessmentDeleted();

        void onGoalDeleted(int i);

        void onSetGoalClicked(JSONObject jSONObject);
    }

    public void onEndTabSelected(String str, int i) {
    }

    public void onCreate(Bundle bundle) {
        setHasOptionsMenu(true);
        super.onCreate(bundle);
        this.cal = Calendar.getInstance();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.assessment_view, viewGroup, false);
        this.listView = (ListView) inflate.findViewById(R.id.assessment_list_view);
        this.adapter = new StableArrayAdapter(getActivity());
        View inflate2 = layoutInflater.inflate(R.layout.assessment_chart_view, (ViewGroup) null, false);
        this.chartView = inflate2;
        this.emptyAssessmentView = (LinearLayout) inflate2.findViewById(R.id.empty_assessment_view);
        this.listView.addHeaderView(this.chartView, (Object) null, false);
        this.listView.setAdapter(this.adapter);
        NavigationTabStrip navigationTabStrip = (NavigationTabStrip) this.chartView.findViewById(R.id.durationPicker);
        this.durationPicker = navigationTabStrip;
        navigationTabStrip.setTabIndex(0);
        this.durationPicker.setOnTabStripSelectedIndexListener(this);
        IconTextView iconTextView = (IconTextView) this.chartView.findViewById(R.id.addData);
        this.addDataButton = iconTextView;
        iconTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    EventListener eventListener = (EventListener) AssessmentFragment.this.getActivity();
                    if (AssessmentFragment.this.assessmentData != null) {
                        eventListener.onAddAssessmentClicked(AssessmentFragment.this.assessmentData);
                    }
                } catch (ClassCastException unused) {
                    throw new ClassCastException(AssessmentFragment.this.getActivity().toString() + " must implement OnAddDataClickedListener");
                }
            }
        });
        ((IconTextView) this.chartView.findViewById(R.id.set_goal_btn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((EventListener) AssessmentFragment.this.getActivity()).onSetGoalClicked(AssessmentFragment.this.assessmentData);
            }
        });
        LineChart lineChart2 = (LineChart) this.chartView.findViewById(R.id.chart);
        this.lineChart = lineChart2;
        lineChart2.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.chartBackground));
        this.lineChart.setNoDataText(getResources().getString(R.string.noData));
        this.lineChart.getDescription().setEnabled(false);
        this.lineChart.setDrawGridBackground(false);
        this.lineChart.getLegend().setEnabled(false);
        this.lineChart.setExtraOffsets(0.0f, 0.0f, 50.0f, 20.0f);
        this.lineChart.setTouchEnabled(true);
        this.lineChart.setScaleEnabled(true);
        this.lineChart.setScaleYEnabled(false);
        this.lineChart.setPinchZoom(true);
        this.lineChart.setDragEnabled(true);
        YAxis axisLeft = this.lineChart.getAxisLeft();
        axisLeft.setEnabled(false);
        axisLeft.setDrawLabels(false);
        this.lineChart.getAxisRight().setEnabled(false);
        XAxis xAxis = this.lineChart.getXAxis();
        xAxis.setEnabled(true);
        xAxis.setDrawLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(12.0f);
        xAxis.setTextColor(ContextCompat.getColor(getActivity(), R.color.lightTextColor));
        xAxis.setAvoidFirstLastClipping(true);
        xAxis.setLabelCount(2, true);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setValueFormatter(new ValueFormatter() {
            public String getFormattedValue(float f) {
                return DateUtils.getFeedDisplayDate(new Date(new Float(f).longValue()));
            }
        });
        registerForContextMenu(this.listView);
        registerForContextMenu(this.chartView.findViewById(R.id.goal_view));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setElevation(0.0f);
        setActionBarTitle();
        return inflate;
    }

    public void onStart() {
        super.onStart();
        if (this.assessmentData != null) {
            render();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            try {
                this.userId = bundle.getInt("user_id");
                this.assessmentData = new JSONObject(bundle.getString("assessment_data"));
                this.viewedByTrainer = bundle.getBoolean("viewed_by_trainer");
                render();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("user_id", this.userId);
        bundle.putString("assessment_data", this.assessmentData.toString());
        bundle.putBoolean("viewed_by_trainer", this.viewedByTrainer);
    }

    public void onCreateOptionsMenu(Menu menu2, MenuInflater menuInflater) {
        menu2.clear();
        menuInflater.inflate(R.menu.add_menu, menu2);
        this.menu = menu2;
        menu2.findItem(R.id.add_item).setVisible(true);
        super.onCreateOptionsMenu(menu2, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.add_item) {
            try {
                EventListener eventListener = (EventListener) getActivity();
                JSONObject jSONObject = this.assessmentData;
                if (jSONObject != null) {
                    eventListener.onAddAssessmentClicked(jSONObject);
                }
            } catch (ClassCastException unused) {
                throw new ClassCastException(getActivity().toString() + " must implement OnAddDataClickedListener");
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onDestroyView() {
        super.onDestroyView();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setElevation(10.0f);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle((CharSequence) String.format("%s's %s", new Object[]{this.clientFirstName, getString(R.string.assessments)}));
    }

    public void setActionBarTitle() {
        try {
            if (this.assessmentData != null) {
                ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle((CharSequence) String.format(getString(R.string.trackAssessmentX), new Object[]{this.assessmentData.getString("name")}));
                return;
            }
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle((CharSequence) String.format(getString(R.string.trackAssessmentX), new Object[]{"assessment"}));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void setData(int i, JSONObject jSONObject, boolean z, String str) {
        this.userId = i;
        this.assessmentData = jSONObject;
        this.viewedByTrainer = z;
        this.clientFirstName = str;
        render();
    }

    public JSONObject getAssessmentData() {
        return this.assessmentData;
    }

    private void render() {
        if (this.assessmentData != null && isAdded()) {
            this.adapter.notifyDataSetChanged();
            renderChart();
            try {
                String string = this.assessmentData.getString("name");
                if (string.length() < 24) {
                    this.addDataButton.setText(String.format("{fa-plus} Add %s", new Object[]{string}));
                }
                if (this.viewedByTrainer) {
                    this.chartView.findViewById(R.id.goal_wrapper_view).setVisibility(0);
                    if (this.assessmentData.has("goal")) {
                        this.chartView.findViewById(R.id.goal_view).setVisibility(0);
                        this.chartView.findViewById(R.id.set_goal_btn).setVisibility(8);
                    } else {
                        this.chartView.findViewById(R.id.goal_view).setVisibility(8);
                        this.chartView.findViewById(R.id.set_goal_btn).setVisibility(0);
                    }
                } else if (this.assessmentData.has("goal")) {
                    this.chartView.findViewById(R.id.goal_wrapper_view).setVisibility(0);
                    this.chartView.findViewById(R.id.goal_view).setVisibility(0);
                } else {
                    this.chartView.findViewById(R.id.goal_wrapper_view).setVisibility(8);
                    this.chartView.findViewById(R.id.goal_view).setVisibility(8);
                }
                if (this.assessmentData.has("goal")) {
                    JSONObject jSONObject = this.assessmentData.getJSONObject("goal");
                    int i = jSONObject.getInt(MetricTracker.Action.COMPLETED);
                    this.chartView.findViewById(R.id.completed_view).getLayoutParams().width = Util.sizeInPx(getActivity(), (int) (i == 0 ? 5.0d : ((double) i) * 2.2d));
                    ((TextView) this.chartView.findViewById(R.id.goal_detail_view)).setText(String.format(getString(R.string.goalDetail), new Object[]{String.valueOf(jSONObject.getDouble("goal")), String.valueOf(jSONObject.getInt("days_left"))}));
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void renderChart() {
        ArrayList arrayList;
        int tabIndex = this.durationPicker.getTabIndex();
        int i = 2;
        int i2 = (tabIndex == 0 ? 1 : tabIndex == 1 ? 3 : tabIndex == 2 ? 6 : 12) * 30;
        this.lineChart.getXAxis().setLabelCount(2, true);
        Date todaysDate = DateUtils.getTodaysDate();
        new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList2.add(new Entry((float) DateUtils.addDays(this.cal, todaysDate, ((i2 - 1) - i3) * -1).getTime(), 0.0f));
        }
        ArrayList arrayList3 = new ArrayList();
        try {
            JSONArray jSONArray = this.assessmentData.getJSONArray("assessments");
            int length = jSONArray.length();
            if (length > 0) {
                this.emptyAssessmentView.setVisibility(8);
                this.lineChart.setVisibility(0);
                int i4 = length - 1;
                double d = Double.MIN_VALUE;
                double d2 = Double.MAX_VALUE;
                while (true) {
                    if (i4 < 0) {
                        arrayList = arrayList3;
                        break;
                    }
                    JSONArray jSONArray2 = jSONArray.getJSONArray(i4);
                    Date dateFromISOFormat = DateUtils.getDateFromISOFormat(jSONArray2.getString(1));
                    ArrayList arrayList4 = arrayList3;
                    float time = (float) dateFromISOFormat.getTime();
                    if (DateUtils.dateDifferenceInDays(dateFromISOFormat, todaysDate) > i2 - 1) {
                        arrayList = arrayList4;
                        break;
                    }
                    double d3 = jSONArray2.getDouble(i);
                    ArrayList arrayList5 = arrayList4;
                    arrayList5.add(new Entry(time, (float) d3));
                    if (d3 > d) {
                        d = d3;
                    }
                    if (d3 < d2) {
                        d2 = d3;
                    }
                    i4--;
                    arrayList3 = arrayList5;
                    i = 2;
                }
                Collections.sort(arrayList, new EntryXComparator());
                this.lineChart.getAxisLeft().setAxisMaximum((float) d);
                this.lineChart.getAxisLeft().setAxisMinimum((float) d2);
            } else {
                arrayList = arrayList3;
                this.lineChart.setVisibility(8);
                this.emptyAssessmentView.setVisibility(0);
            }
            LineDataSet lineDataSet = new LineDataSet(arrayList, "Data Set");
            lineDataSet.setCubicIntensity(1.0f);
            lineDataSet.setDrawValues(true);
            lineDataSet.setValueTextColor(ViewCompat.MEASURED_STATE_MASK);
            lineDataSet.setValueTextSize(12.0f);
            lineDataSet.setColor(ContextCompat.getColor(getActivity(), R.color.chartLineColor));
            lineDataSet.setLineWidth(2.0f);
            lineDataSet.setCircleRadius(3.0f);
            lineDataSet.setCircleColor(ContextCompat.getColor(getActivity(), R.color.chartLineColor));
            lineDataSet.setCircleHoleColor(ContextCompat.getColor(getActivity(), R.color.chartLineColor));
            lineDataSet.setValueFormatter(new ValueFormatter() {
                public String getFormattedValue(float f) {
                    return AssessmentFragment.df2.format((double) f);
                }
            });
            ArrayList arrayList6 = new ArrayList();
            arrayList6.add(lineDataSet);
            this.lineChart.setData(new LineData((List<ILineDataSet>) arrayList6));
            LineDataSet lineDataSet2 = new LineDataSet(arrayList2, "Data Set");
            lineDataSet2.setDrawValues(true);
            lineDataSet2.setValueTextColor(0);
            lineDataSet2.setValueTextSize(12.0f);
            lineDataSet2.setColor(0);
            lineDataSet2.setLineWidth(2.0f);
            lineDataSet2.setCircleRadius(3.0f);
            lineDataSet2.setCircleColor(0);
            lineDataSet2.setCircleHoleColor(0);
            ((LineData) this.lineChart.getData()).addDataSet(lineDataSet2);
            if (arrayList.size() == 0) {
                this.lineChart.clear();
            }
            this.lineChart.invalidate();
            this.lineChart.notifyDataSetChanged();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void onStartTabSelected(String str, int i) {
        renderChart();
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        if (view.getId() == R.id.goal_view && this.viewedByTrainer) {
            getActivity().getMenuInflater().inflate(R.menu.delete_goal, contextMenu);
        } else if ((contextMenuInfo instanceof AdapterView.AdapterContextMenuInfo) && ((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position > 0) {
            getActivity().getMenuInflater().inflate(R.menu.lv_list_menu, contextMenu);
        }
        AnonymousClass5 r4 = new MenuItem.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                AssessmentFragment.this.onContextItemSelected(menuItem);
                return true;
            }
        };
        int size = contextMenu.size();
        for (int i = 0; i < size; i++) {
            contextMenu.getItem(i).setOnMenuItemClickListener(r4);
        }
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
        if (menuItem.getItemId() == R.id.delete_goal_item) {
            try {
                int i = this.assessmentData.getJSONObject("goal").getInt("id");
                this.assessmentData.remove("goal");
                render();
                ((EventListener) getActivity()).onGoalDeleted(i);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } else if (menuItem.getItemId() == R.id.lv_list_menu_delete) {
            int i2 = adapterContextMenuInfo.position - 1;
            try {
                JSONArray jSONArray = this.assessmentData.getJSONArray("assessments");
                int i3 = jSONArray.getJSONArray((jSONArray.length() - i2) - 1).getInt(0);
                BaseHttpClient baseHttpClient = new BaseHttpClient();
                baseHttpClient.delete("/assessment_measures/" + i3, new BaseResponseHandler() {
                    public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                        if (!AssessmentFragment.this.isAdded()) {
                            return true;
                        }
                        ((EventListener) AssessmentFragment.this.getActivity()).onAssessmentDeleted();
                        return true;
                    }
                });
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }
        return true;
    }

    private class StableArrayAdapter extends BaseAdapter {
        private Context context;

        public boolean hasStableIds() {
            return true;
        }

        public StableArrayAdapter(Context context2) {
            this.context = context2;
        }

        public int getCount() {
            if (!AssessmentFragment.this.isAdded()) {
                return 0;
            }
            try {
                if (AssessmentFragment.this.assessmentData == null) {
                    return 0;
                }
                return AssessmentFragment.this.assessmentData.getJSONArray("assessments").length();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public Object getItem(int i) {
            try {
                JSONArray jSONArray = AssessmentFragment.this.assessmentData.getJSONArray("assessments");
                return jSONArray.getJSONArray((jSONArray.length() - i) - 1);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public long getItemId(int i) {
            try {
                return (long) ((JSONArray) getItem(i)).getInt(0);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            try {
                JSONArray jSONArray = (JSONArray) getItem(i);
                String string = jSONArray.getString(1);
                double d = jSONArray.getDouble(2);
                String feedDisplayDate = DateUtils.getFeedDisplayDate(DateUtils.getDateFromISOFormat(string));
                View inflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.list_view_row_style_value1, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.label)).setText(Double.toString(d));
                ((TextView) inflate.findViewById(R.id.detailLabel)).setText(feedDisplayDate);
                return inflate;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
