package com.trainerfu.android;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.joanzapata.iconify.widget.IconTextView;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.ExerciseSearchTask;
import com.trainerfu.utils.Tuple;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlanTemplateListFragment extends Fragment implements ExerciseSearchTask.SearchResultHandler {
    /* access modifiers changed from: private */
    public PlanTemplateListAdapter adapter;
    /* access modifiers changed from: private */
    public View addTemplateBtn;
    /* access modifiers changed from: private */
    public ArrayList<JSONObject> allTemplates;
    private ExerciseSearchTask currentSearchTask = null;
    private String currentSearchTerm = null;
    /* access modifiers changed from: private */
    public TextView emptyStateDescription;
    /* access modifiers changed from: private */
    public LinearLayout emptyStateView;
    /* access modifiers changed from: private */
    public boolean forSelection;
    /* access modifiers changed from: private */
    public PlanListAdapter planListAdapter;
    /* access modifiers changed from: private */
    public RecyclerView planTemplateListView;
    private SearchView searchView;
    /* access modifiers changed from: private */
    public ArrayList<JSONObject> templates = null;

    public interface EventListener {
        void planTemplateSelected(JSONObject jSONObject);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.forSelection = getArguments().getBoolean("for_selection");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.plan_template_list_view, viewGroup, false);
        ListView listView = (ListView) inflate.findViewById(R.id.template_list);
        this.planTemplateListView = (RecyclerView) inflate.findViewById(R.id.template_list_rv);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.empty_state);
        this.emptyStateView = linearLayout;
        this.emptyStateDescription = (TextView) linearLayout.findViewById(R.id.empty_state_description);
        registerForContextMenu(listView);
        registerForContextMenu(this.planTemplateListView);
        if (!this.forSelection) {
            View findViewById = inflate.findViewById(R.id.fab);
            this.addTemplateBtn = findViewById;
            findViewById.setVisibility(0);
            this.addTemplateBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    PlanTemplateListFragment.this.showAddTemplateDialog("", false, 0);
                }
            });
        }
        PlanTemplateListAdapter planTemplateListAdapter = new PlanTemplateListAdapter(getActivity());
        this.adapter = planTemplateListAdapter;
        listView.setAdapter(planTemplateListAdapter);
        PlanListAdapter planListAdapter2 = new PlanListAdapter();
        this.planListAdapter = planListAdapter2;
        this.planTemplateListView.setAdapter(planListAdapter2);
        this.planTemplateListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PlanTemplateListFragment.this.forSelection) {
                    ((EventListener) PlanTemplateListFragment.this.getActivity()).planTemplateSelected((JSONObject) PlanTemplateListFragment.this.templates.get(i));
                    return;
                }
                JSONObject jSONObject = (JSONObject) PlanTemplateListFragment.this.templates.get(i);
                Intent intent = new Intent(PlanTemplateListFragment.this.getActivity(), OrderedPlanListActivity.class);
                try {
                    intent.putExtra("ordered_plan_list_id", jSONObject.getInt("id"));
                    intent.putExtra("ordered_plan_list_name", jSONObject.getString("name"));
                    PlanTemplateListFragment.this.startActivity(intent);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return inflate;
    }

    public void onResume() {
        super.onResume();
        reloadData(0);
    }

    /* access modifiers changed from: private */
    public void reloadData(final int i) {
        new BaseHttpClient(true, getActivity()).get("/ordered_program_lists", (Map<String, Object>) null, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                if (!PlanTemplateListFragment.this.isAdded()) {
                    return true;
                }
                if (!PlanTemplateListFragment.this.forSelection) {
                    PlanTemplateListFragment.this.addTemplateBtn.setVisibility(0);
                }
                try {
                    if (PlanTemplateListFragment.this.templates == null) {
                        ArrayList unused = PlanTemplateListFragment.this.templates = new ArrayList();
                    }
                    PlanTemplateListFragment.this.templates.clear();
                    JSONArray jSONArray = jSONObject.getJSONArray("programs");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        PlanTemplateListFragment.this.templates.add((JSONObject) jSONArray.get(i2));
                    }
                    ArrayList unused2 = PlanTemplateListFragment.this.allTemplates = PlanTemplateListFragment.this.templates;
                    PlanTemplateListFragment.this.adapter.notifyDataSetChanged();
                    PlanTemplateListFragment.this.planListAdapter.notifyDataSetChanged();
                    if (i > 0) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= PlanTemplateListFragment.this.allTemplates.size()) {
                                break;
                            } else if (((JSONObject) PlanTemplateListFragment.this.allTemplates.get(i3)).getInt("id") == i) {
                                PlanTemplateListFragment.this.planTemplateListView.getLayoutManager().scrollToPosition(i3);
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                    if (PlanTemplateListFragment.this.allTemplates.size() == 0) {
                        if (PlanTemplateListFragment.this.forSelection) {
                            PlanTemplateListFragment.this.emptyStateDescription.setText("Create Template first by selecting last tab on home screen");
                        } else {
                            PlanTemplateListFragment.this.emptyStateDescription.setText("Create Template using the button below ");
                        }
                        PlanTemplateListFragment.this.emptyStateView.setVisibility(0);
                        PlanTemplateListFragment.this.planTemplateListView.setVisibility(8);
                    } else {
                        PlanTemplateListFragment.this.emptyStateView.setVisibility(8);
                        PlanTemplateListFragment.this.planTemplateListView.setVisibility(0);
                    }
                    return true;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void searchPlanList(String str) {
        if (this.templates != null) {
            String trim = str.trim();
            if (trim.length() == 0) {
                this.templates = this.allTemplates;
                this.currentSearchTerm = null;
                this.planListAdapter.notifyDataSetChanged();
                return;
            }
            ExerciseSearchTask exerciseSearchTask = this.currentSearchTask;
            if (exerciseSearchTask != null) {
                exerciseSearchTask.cancel(true);
            }
            this.currentSearchTerm = trim;
            ExerciseSearchTask exerciseSearchTask2 = new ExerciseSearchTask(this);
            exerciseSearchTask2.execute(new Tuple[]{new Tuple(trim, this.allTemplates)});
            this.currentSearchTask = exerciseSearchTask2;
        }
    }

    public void handleSearchResult(Tuple<String, ArrayList<JSONObject>> tuple) {
        if (isAdded()) {
            String str = (String) tuple.x;
            String str2 = this.currentSearchTerm;
            if (str2 != null && str2.equals(str)) {
                this.templates = (ArrayList) tuple.y;
                this.planListAdapter.notifyDataSetChanged();
            }
        }
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        int order = menuItem.getOrder();
        if (menuItem.getItemId() != R.id.deleteTemplateItem) {
            return false;
        }
        deleteTemplateAtIndex(order);
        return false;
    }

    private void deleteTemplateAtIndex(int i) {
        try {
            int i2 = this.templates.get(i).getInt("id");
            this.templates.remove(i);
            this.adapter.notifyDataSetChanged();
            this.planListAdapter.notifyDataSetChanged();
            if (this.templates.size() == 0) {
                if (this.forSelection) {
                    this.emptyStateDescription.setText("Create Template first by selecting last tab on home screen");
                } else {
                    this.emptyStateDescription.setText("Create Template using the button below ");
                }
                this.emptyStateView.setVisibility(0);
                this.planTemplateListView.setVisibility(8);
            } else {
                this.emptyStateView.setVisibility(8);
                this.planTemplateListView.setVisibility(0);
            }
            new BaseHttpClient().delete(String.format("/ordered_program_lists/%s", new Object[]{String.valueOf(i2)}), (Map<String, Object>) null, new BaseResponseHandler() {
                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    return true;
                }
            });
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: private */
    public void addTemplate(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        new BaseHttpClient(true, getActivity()).put("/ordered_program_lists/new", hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                try {
                    PlanTemplateListFragment.this.reloadData(jSONObject.getInt("id"));
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return true;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void editTemplate(String str, final int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        new BaseHttpClient(true, getActivity()).post(String.format("/ordered_program_lists/%d", new Object[]{Integer.valueOf(i)}), hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                PlanTemplateListFragment.this.reloadData(i);
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    public void showAddTemplateDialog(String str, final boolean z, final int i) {
        new MaterialDialog.Builder(getActivity()).title((CharSequence) z ? "Edit Template name" : "New Plan Template").content((CharSequence) "").inputType(16384).input((CharSequence) getString(R.string.templateName), (CharSequence) str, (MaterialDialog.InputCallback) new MaterialDialog.InputCallback() {
            public void onInput(MaterialDialog materialDialog, CharSequence charSequence) {
                String trim = charSequence.toString().trim();
                if (trim.length() <= 0) {
                    return;
                }
                if (z) {
                    PlanTemplateListFragment.this.editTemplate(trim, i);
                } else {
                    PlanTemplateListFragment.this.addTemplate(trim);
                }
            }
        }).positiveText((CharSequence) z ? "Update" : "Save").negativeText((int) R.string.cancel).positiveColor(ContextCompat.getColor(getActivity(), R.color.tintColor)).negativeColor(ContextCompat.getColor(getActivity(), R.color.grayColor)).show();
    }

    private class PlanTemplateListAdapter extends BaseAdapter {
        private Context context;

        public boolean hasStableIds() {
            return true;
        }

        public PlanTemplateListAdapter(Context context2) {
            this.context = context2;
        }

        public int getCount() {
            if (PlanTemplateListFragment.this.templates == null) {
                return 0;
            }
            return PlanTemplateListFragment.this.templates.size();
        }

        public Object getItem(int i) {
            return PlanTemplateListFragment.this.templates.get(i);
        }

        public long getItemId(int i) {
            try {
                return (long) ((JSONObject) getItem(i)).getInt("id");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            if (view == null) {
                view = layoutInflater.inflate(R.layout.plan_template_list_row_view, (ViewGroup) null);
            }
            try {
                ((TextView) view.findViewById(R.id.titleLabel)).setText(((JSONObject) getItem(i)).getString("name"));
                return view;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public class PlanListAdapter extends RecyclerView.Adapter<ViewHolder> {
        public PlanListAdapter() {
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.plan_template_list_row_view, (ViewGroup) null));
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            final JSONObject jSONObject = (JSONObject) PlanTemplateListFragment.this.templates.get(i);
            TextView access$1300 = viewHolder.titleTV;
            IconTextView access$1400 = viewHolder.editBtn;
            try {
                access$1300.setText(jSONObject.getString("name"));
                access$1400.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        try {
                            PlanTemplateListFragment.this.showAddTemplateDialog(jSONObject.getString("name"), true, jSONObject.getInt("id"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public int getItemCount() {
            if (PlanTemplateListFragment.this.templates == null) {
                return 0;
            }
            return PlanTemplateListFragment.this.templates.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener {
            /* access modifiers changed from: private */
            public IconTextView editBtn;
            public Button messageButton;
            public TextView nameTextView;
            /* access modifiers changed from: private */
            public TextView titleTV;

            public ViewHolder(View view) {
                super(view);
                this.titleTV = (TextView) view.findViewById(R.id.titleLabel);
                this.editBtn = (IconTextView) view.findViewById(R.id.edit_plan_btn);
                view.setOnClickListener(this);
                view.setOnCreateContextMenuListener(this);
            }

            public void onClick(View view) {
                int adapterPosition = getAdapterPosition();
                if (adapterPosition == -1) {
                    return;
                }
                if (PlanTemplateListFragment.this.forSelection) {
                    ((EventListener) PlanTemplateListFragment.this.getActivity()).planTemplateSelected((JSONObject) PlanTemplateListFragment.this.templates.get(adapterPosition));
                    return;
                }
                JSONObject jSONObject = (JSONObject) PlanTemplateListFragment.this.templates.get(adapterPosition);
                Intent intent = new Intent(PlanTemplateListFragment.this.getActivity(), OrderedPlanListActivity.class);
                try {
                    intent.putExtra("ordered_plan_list_id", jSONObject.getInt("id"));
                    intent.putExtra("ordered_plan_list_name", jSONObject.getString("name"));
                    intent.putExtra("ordered_plan_list_length", jSONObject.getInt("length_in_weeks"));
                    PlanTemplateListFragment.this.startActivity(intent);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }

            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                contextMenu.add(0, R.id.deleteTemplateItem, getAdapterPosition(), R.string.deleteTemplate);
                contextMenu.add(0, R.id.cancelItem, getAdapterPosition(), R.string.cancel);
            }
        }
    }
}
