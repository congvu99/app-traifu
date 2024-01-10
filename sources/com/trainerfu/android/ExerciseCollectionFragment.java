package com.trainerfu.android;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.afollestad.materialdialogs.MaterialDialog;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.ExerciseDataset;
import com.trainerfu.utils.ExerciseSearchTask;
import com.trainerfu.utils.Tuple;
import com.trainerfu.utils.Util;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

public class ExerciseCollectionFragment extends Fragment implements ExerciseSearchTask.SearchResultHandler, ExerciseDataset.ExerciseDatasetFetchedResponder {
    /* access modifiers changed from: private */
    public ExerciseListAdapter adapter;
    /* access modifiers changed from: private */
    public ArrayList<JSONObject> allExercises;
    private boolean allowAddExercise = false;
    private ExerciseSearchTask currentSearchTask = null;
    private String currentSearchTerm = null;
    private ListView exerciseListView;
    /* access modifiers changed from: private */
    public ArrayList<JSONObject> filteredExercises;
    private boolean forSelection = true;
    /* access modifiers changed from: private */
    public ArrayList<JSONObject> recentExercises;
    private View view;

    public interface EventListener {
        void createNewExerciseClicked();

        void exerciseSelected(JSONObject jSONObject);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("allow_add_exercise")) {
                this.allowAddExercise = arguments.getBoolean("allow_add_exercise");
            }
            if (arguments.containsKey("for_selection")) {
                this.forSelection = arguments.getBoolean("for_selection");
            }
        }
        View inflate = layoutInflater.inflate(R.layout.exercise_list_view, viewGroup, false);
        this.view = inflate;
        ListView listView = (ListView) inflate.findViewById(R.id.exercise_list);
        this.exerciseListView = listView;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ((EventListener) ExerciseCollectionFragment.this.getActivity()).exerciseSelected((JSONObject) ExerciseCollectionFragment.this.adapter.getItem(i));
                ExerciseDataset.getInstance().fetchRecentExercises((ExerciseDataset.ExerciseDatasetFetchedResponder) null);
            }
        });
        this.adapter = new ExerciseListAdapter(getActivity());
        if (!this.forSelection) {
            registerForContextMenu(this.exerciseListView);
        }
        this.exerciseListView.setAdapter(this.adapter);
        ExerciseDataset instance = ExerciseDataset.getInstance();
        ArrayList<JSONObject> allExercises2 = instance.getAllExercises();
        this.allExercises = allExercises2;
        if (allExercises2 == null) {
            instance.fetchAllExercises(this);
        }
        ArrayList<JSONObject> recentExercises2 = instance.getRecentExercises();
        this.recentExercises = recentExercises2;
        if (recentExercises2 == null) {
            instance.fetchRecentExercises(this);
        }
        if (this.allowAddExercise) {
            Util.setMargins(this.exerciseListView, 0, 0, 0, Util.sizeInPx(getActivity(), 55));
            this.view.findViewById(R.id.toolbar).setVisibility(0);
            this.view.findViewById(R.id.createExerciseBtn).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ((EventListener) ExerciseCollectionFragment.this.getActivity()).createNewExerciseClicked();
                }
            });
        }
        return this.view;
    }

    public void filter(String str) {
        if (this.allExercises != null) {
            String trim = str.trim();
            if (trim.length() == 0) {
                this.filteredExercises = null;
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
            exerciseSearchTask2.execute(new Tuple[]{new Tuple(trim, this.allExercises)});
            this.currentSearchTask = exerciseSearchTask2;
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view2, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view2, contextMenuInfo);
        new MenuInflater(getActivity()).inflate(R.menu.delete_exercise, contextMenu);
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.deleteExerciseItem) {
            return false;
        }
        deleteExerciseAtIndex(((AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo()).position);
        return false;
    }

    public void allExercisesFetched(ArrayList<JSONObject> arrayList) {
        this.allExercises = arrayList;
        this.adapter.notifyDataSetChanged();
    }

    public void recentExercisesFetched(ArrayList<JSONObject> arrayList) {
        this.recentExercises = arrayList;
        this.adapter.notifyDataSetChanged();
    }

    public void handleSearchResult(Tuple<String, ArrayList<JSONObject>> tuple) {
        if (isAdded()) {
            String str = (String) tuple.x;
            String str2 = this.currentSearchTerm;
            if (str2 != null && str2.equals(str)) {
                this.filteredExercises = (ArrayList) tuple.y;
                this.adapter.notifyDataSetChanged();
            }
        }
    }

    private void deleteExerciseAtIndex(int i) {
        try {
            JSONObject jSONObject = (JSONObject) this.adapter.getItem(i);
            int i2 = jSONObject.getInt("id");
            if (!jSONObject.getBoolean("is_custom")) {
                new MaterialDialog.Builder(getActivity()).title((int) R.string.Error).content((int) R.string.cantDeleteSystemExercise).positiveText((int) R.string.Ok).show();
                return;
            }
            ExerciseDataset.getInstance().removeExercise(jSONObject);
            if (this.filteredExercises != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= this.filteredExercises.size()) {
                        i3 = -1;
                        break;
                    } else if (this.filteredExercises.get(i3).getInt("id") == jSONObject.getInt("id")) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 > -1) {
                    this.filteredExercises.remove(i3);
                }
            }
            rebindExerciseCollection();
            BaseHttpClient baseHttpClient = new BaseHttpClient(true, getActivity());
            HashMap hashMap = new HashMap();
            hashMap.put("is_active", false);
            baseHttpClient.post(String.format("/exercises/%s/status", new Object[]{String.valueOf(i2)}), hashMap, new BaseResponseHandler() {
                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    return true;
                }
            });
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void rebindExerciseCollection() {
        this.recentExercises = ExerciseDataset.getInstance().getRecentExercises();
        this.allExercises = ExerciseDataset.getInstance().getAllExercises();
        this.adapter.notifyDataSetChanged();
    }

    private class ExerciseListAdapter extends BaseAdapter {
        private Context context;

        public boolean hasStableIds() {
            return true;
        }

        public ExerciseListAdapter(Context context2) {
            this.context = context2;
        }

        public int getCount() {
            int i = 0;
            if (ExerciseCollectionFragment.this.allExercises == null) {
                return 0;
            }
            if (ExerciseCollectionFragment.this.filteredExercises != null) {
                return ExerciseCollectionFragment.this.filteredExercises.size();
            }
            int size = ExerciseCollectionFragment.this.allExercises.size();
            if (ExerciseCollectionFragment.this.recentExercises != null) {
                i = ExerciseCollectionFragment.this.recentExercises.size();
            }
            return size + i;
        }

        public Object getItem(int i) {
            if (ExerciseCollectionFragment.this.filteredExercises != null) {
                return ExerciseCollectionFragment.this.filteredExercises.get(i);
            }
            int size = ExerciseCollectionFragment.this.recentExercises == null ? 0 : ExerciseCollectionFragment.this.recentExercises.size();
            if (i >= size) {
                return ExerciseCollectionFragment.this.allExercises.get(i - size);
            }
            return ExerciseCollectionFragment.this.recentExercises.get(i);
        }

        public long getItemId(int i) {
            try {
                return (long) ((JSONObject) getItem(i)).getInt("id");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            JSONObject jSONObject;
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            JSONObject jSONObject2 = null;
            if (view == null) {
                view = layoutInflater.inflate(R.layout.exercise_list_row_view, (ViewGroup) null);
            }
            TextView textView = (TextView) view.findViewById(R.id.titleLabel);
            try {
                jSONObject = (JSONObject) getItem(i);
                try {
                    if (!jSONObject.isNull("youtube_url")) {
                        String string = jSONObject.getString("youtube_url");
                        String format = String.format("http://img.youtube.com/vi/%s/2.jpg", new Object[]{string});
                        if (string != null) {
                            ImageView imageView = (ImageView) view.findViewById(R.id.ytThumbnail);
                            Picasso.get().load(format).error((int) R.drawable.ic_fitness_center_black_24dp).centerCrop().transform((Transformation) new CircleTransform(10, 0)).fit().into(imageView);
                            imageView.setVisibility(0);
                        }
                    } else {
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.ytThumbnail);
                        imageView2.setImageDrawable(ExerciseCollectionFragment.this.getResources().getDrawable(R.drawable.ic_fitness_center_black_24dp));
                        imageView2.setVisibility(0);
                    }
                } catch (JSONException e) {
                    e = e;
                    jSONObject2 = jSONObject;
                    e.printStackTrace();
                    jSONObject = jSONObject2;
                    textView.setText(jSONObject.getString("name"));
                    return view;
                }
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
                jSONObject = jSONObject2;
                textView.setText(jSONObject.getString("name"));
                return view;
            }
            try {
                textView.setText(jSONObject.getString("name"));
                return view;
            } catch (JSONException e3) {
                throw new RuntimeException(e3);
            }
        }
    }
}
