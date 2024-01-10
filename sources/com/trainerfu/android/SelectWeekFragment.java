package com.trainerfu.android;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

public class SelectWeekFragment extends Fragment {
    private int orderedPlanListLength = 0;
    List<String> weeks = new ArrayList();

    public interface EventListener {
        void weekSelected(int i);
    }

    public static SelectWeekFragment newInstance(String str, String str2) {
        SelectWeekFragment selectWeekFragment = new SelectWeekFragment();
        selectWeekFragment.setArguments(new Bundle());
        return selectWeekFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getArguments();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.orderedPlanListLength = getArguments().getInt("ordered_plan_list_length");
        View inflate = layoutInflater.inflate(R.layout.fragment_select_week, viewGroup, false);
        ListView listView = (ListView) inflate.findViewById(R.id.week_list);
        for (int i = 1; i <= this.orderedPlanListLength; i++) {
            List<String> list = this.weeks;
            list.add("Week " + i);
        }
        listView.setAdapter(new WeeksAdapter(getActivity()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ((EventListener) SelectWeekFragment.this.getActivity()).weekSelected(i + 1);
            }
        });
        return inflate;
    }

    public class WeeksAdapter extends BaseAdapter {
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

        public WeeksAdapter(Context context2) {
            this.context = context2;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            if (view == null) {
                view = layoutInflater.inflate(R.layout.simple_spinner_dropdown_item, (ViewGroup) null);
            }
            ((TextView) view.findViewById(R.id.spinner_item)).setText("Week " + (i + 1));
            return view;
        }

        public int getCount() {
            return SelectWeekFragment.this.weeks.size();
        }

        public Object getItem(int i) {
            return SelectWeekFragment.this.weeks.get(i);
        }
    }
}
