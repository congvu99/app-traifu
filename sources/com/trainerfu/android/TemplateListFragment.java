package com.trainerfu.android;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.gigamole.navigationtabstrip.NavigationTabStrip;
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

public class TemplateListFragment extends Fragment implements NavigationTabStrip.OnTabStripSelectedIndexListener, ExerciseSearchTask.SearchResultHandler {
    /* access modifiers changed from: private */
    public TemplateListAdapter adapter;
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
    private NavigationTabStrip ownerPicker;
    /* access modifiers changed from: private */
    public ListView templateList;
    /* access modifiers changed from: private */
    public ArrayList<JSONObject> templates = null;

    public interface EventListener {
        void templateSelected(JSONObject jSONObject);
    }

    public void onEndTabSelected(String str, int i) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.forSelection = getArguments().getBoolean("for_selection");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.template_list_view, viewGroup, false);
        this.templateList = (ListView) inflate.findViewById(R.id.template_list);
        View inflate2 = layoutInflater.inflate(R.layout.template_list_view_header, (ViewGroup) null, false);
        this.templateList.addHeaderView(inflate2, (Object) null, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.empty_state);
        this.emptyStateView = linearLayout;
        this.emptyStateDescription = (TextView) linearLayout.findViewById(R.id.empty_state_description);
        registerForContextMenu(this.templateList);
        getArguments();
        if (!this.forSelection) {
            View findViewById = inflate.findViewById(R.id.fab);
            this.addTemplateBtn = findViewById;
            findViewById.setVisibility(0);
            this.addTemplateBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TemplateListFragment.this.showAddTemplateDialog("", false, 0);
                }
            });
        }
        TemplateListAdapter templateListAdapter = new TemplateListAdapter(getActivity());
        this.adapter = templateListAdapter;
        this.templateList.setAdapter(templateListAdapter);
        this.templateList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (TemplateListFragment.this.forSelection) {
                    ((EventListener) TemplateListFragment.this.getActivity()).templateSelected((JSONObject) TemplateListFragment.this.templates.get(i - 1));
                    return;
                }
                JSONObject jSONObject = (JSONObject) TemplateListFragment.this.templates.get(i - 1);
                Intent intent = new Intent(TemplateListFragment.this.getActivity(), WorkoutPlanDayActivity.class);
                intent.putExtra("dayOfWeek", 1);
                try {
                    intent.putExtra("program_id", jSONObject.getInt("id"));
                    intent.putExtra("view_type", WorkoutPlanDayViewType.EDITING_TEMPLATE.getMask());
                    TemplateListFragment.this.startActivity(intent);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        NavigationTabStrip navigationTabStrip = (NavigationTabStrip) inflate2.findViewById(R.id.ownerPicker);
        this.ownerPicker = navigationTabStrip;
        navigationTabStrip.setTabIndex(0);
        this.ownerPicker.setOnTabStripSelectedIndexListener(this);
        return inflate;
    }

    public void onResume() {
        super.onResume();
        reloadData(false);
    }

    /* access modifiers changed from: private */
    public void reloadData(final Boolean bool) {
        int tabIndex = this.ownerPicker.getTabIndex();
        HashMap hashMap = new HashMap();
        hashMap.put("include_all_programs", Boolean.valueOf(tabIndex == 1));
        hashMap.put("program_type", 2);
        new BaseHttpClient(true, getActivity()).get("/programs", hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                if (!TemplateListFragment.this.isAdded()) {
                    return true;
                }
                if (!TemplateListFragment.this.forSelection) {
                    TemplateListFragment.this.addTemplateBtn.setVisibility(0);
                }
                try {
                    if (TemplateListFragment.this.templates == null) {
                        ArrayList unused = TemplateListFragment.this.templates = new ArrayList();
                    }
                    TemplateListFragment.this.templates.clear();
                    JSONArray jSONArray = jSONObject.getJSONArray("programs");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        TemplateListFragment.this.templates.add((JSONObject) jSONArray.get(i2));
                    }
                    ArrayList unused2 = TemplateListFragment.this.allTemplates = TemplateListFragment.this.templates;
                    TemplateListFragment.this.adapter.notifyDataSetChanged();
                    if (bool.booleanValue()) {
                        TemplateListFragment.this.templateList.smoothScrollToPosition(TemplateListFragment.this.allTemplates.size());
                    }
                    if (TemplateListFragment.this.allTemplates.size() == 0) {
                        if (TemplateListFragment.this.forSelection) {
                            TemplateListFragment.this.emptyStateDescription.setText("Create Template first by selecting last tab on home screen");
                        } else {
                            TemplateListFragment.this.emptyStateDescription.setText("Create Template using the button below ");
                        }
                        TemplateListFragment.this.emptyStateView.setVisibility(0);
                        TemplateListFragment.this.templateList.setVisibility(8);
                    } else {
                        TemplateListFragment.this.emptyStateView.setVisibility(8);
                        TemplateListFragment.this.templateList.setVisibility(0);
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
                this.adapter.notifyDataSetChanged();
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
                this.adapter.notifyDataSetChanged();
            }
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        new MenuInflater(getActivity()).inflate(R.menu.delete_template, contextMenu);
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.deleteTemplateItem) {
            return false;
        }
        deleteTemplateAtIndex(((AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo()).position - 1);
        return false;
    }

    private void deleteTemplateAtIndex(int i) {
        try {
            int i2 = this.templates.get(i).getInt("id");
            this.templates.remove(i);
            this.adapter.notifyDataSetChanged();
            if (this.templates.size() == 0) {
                if (this.forSelection) {
                    this.emptyStateDescription.setText("Create Template first by selecting last tab on home screen");
                } else {
                    this.emptyStateDescription.setText("Create Template using the button below ");
                }
                this.emptyStateView.setVisibility(0);
                this.templateList.setVisibility(8);
            } else {
                this.emptyStateView.setVisibility(8);
                this.templateList.setVisibility(0);
            }
            new BaseHttpClient().delete(String.format("/programs/%s", new Object[]{String.valueOf(i2)}), (Map<String, Object>) null, new BaseResponseHandler() {
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
        hashMap.put("program_type", 2);
        new BaseHttpClient(true, getActivity()).put("/users/myself/programs/new", hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                TemplateListFragment.this.reloadData(true);
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    public void editTemplate(String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        new BaseHttpClient(true, getActivity()).post(String.format("/programs/%d/name", new Object[]{Integer.valueOf(i)}), hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                TemplateListFragment.this.reloadData(false);
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    public void showAddTemplateDialog(String str, final boolean z, final int i) {
        new MaterialDialog.Builder(getActivity()).title((CharSequence) z ? "Edit Workout Template" : getString(R.string.addTemplate)).content((CharSequence) "").inputType(16384).input((CharSequence) getString(R.string.templateName), (CharSequence) str, (MaterialDialog.InputCallback) new MaterialDialog.InputCallback() {
            public void onInput(MaterialDialog materialDialog, CharSequence charSequence) {
                String trim = charSequence.toString().trim();
                if (trim.length() <= 0) {
                    return;
                }
                if (z) {
                    TemplateListFragment.this.editTemplate(trim, i);
                } else {
                    TemplateListFragment.this.addTemplate(trim);
                }
            }
        }).positiveText((CharSequence) z ? "Update" : "Save").negativeText((int) R.string.cancel).positiveColor(ContextCompat.getColor(getActivity(), R.color.tintColor)).negativeColor(ContextCompat.getColor(getActivity(), R.color.grayColor)).show();
    }

    public void onStartTabSelected(String str, int i) {
        reloadData(false);
    }

    private class TemplateListAdapter extends BaseAdapter {
        private Context context;

        public boolean hasStableIds() {
            return true;
        }

        public TemplateListAdapter(Context context2) {
            this.context = context2;
        }

        public int getCount() {
            if (TemplateListFragment.this.templates == null) {
                return 0;
            }
            return TemplateListFragment.this.templates.size();
        }

        public Object getItem(int i) {
            return TemplateListFragment.this.templates.get(i);
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
                view = layoutInflater.inflate(R.layout.template_list_row_view, (ViewGroup) null);
            }
            TextView textView = (TextView) view.findViewById(R.id.titleLabel);
            IconTextView iconTextView = (IconTextView) view.findViewById(R.id.edit_btn);
            TextView textView2 = (TextView) view.findViewById(R.id.workout_details);
            final JSONObject jSONObject = (JSONObject) getItem(i);
            try {
                textView.setText(jSONObject.getString("name"));
                textView2.setText(jSONObject.getString("details"));
                iconTextView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        try {
                            TemplateListFragment.this.showAddTemplateDialog(jSONObject.getString("name"), true, jSONObject.getInt("id"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
                return view;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
