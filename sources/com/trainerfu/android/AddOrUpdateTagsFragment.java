package com.trainerfu.android;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AddOrUpdateTagsFragment extends Fragment {
    private TagsAdapter adapter;
    /* access modifiers changed from: private */
    public JSONArray selectedTags = new JSONArray();
    /* access modifiers changed from: private */
    public ArrayList<JSONObject> tags = new ArrayList<>();
    private ListView tagsList;
    private ViewGroup view;

    public static AddOrUpdateTagsFragment newInstance(String str, String str2) {
        AddOrUpdateTagsFragment addOrUpdateTagsFragment = new AddOrUpdateTagsFragment();
        addOrUpdateTagsFragment.setArguments(new Bundle());
        return addOrUpdateTagsFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        int i = 0;
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_add_or_update_tags, viewGroup, false);
        this.view = viewGroup2;
        this.tagsList = (ListView) viewGroup2.findViewById(R.id.tags_list_new);
        while (i < 10) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tag_id", i);
                jSONObject.put("name", "dumbell" + i);
                this.tags.add(jSONObject);
                i++;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        TagsAdapter tagsAdapter = new TagsAdapter(getActivity());
        this.adapter = tagsAdapter;
        this.tagsList.setAdapter(tagsAdapter);
        this.adapter.notifyDataSetChanged();
        return this.view;
    }

    private class TagsAdapter extends BaseAdapter implements CompoundButton.OnCheckedChangeListener {
        public final int TYPE_HEADER = 1;
        private Context context;

        private boolean isPositionHeader(int i) {
            return i == 7;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public TagsAdapter(Context context2) {
            this.context = context2;
        }

        public int getCount() {
            return AddOrUpdateTagsFragment.this.tags.size();
        }

        public Object getItem(int i) {
            return AddOrUpdateTagsFragment.this.tags.get(i);
        }

        public int getItemViewType(int i) {
            if (isPositionHeader(i)) {
                return 1;
            }
            return i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            if (getItemViewType(i) == 1) {
                return layoutInflater.inflate(R.layout.tag_header, (ViewGroup) null);
            }
            View inflate = layoutInflater.inflate(R.layout.tag_item, (ViewGroup) null);
            try {
                JSONObject jSONObject = (JSONObject) getItem(i);
                CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.group_cb);
                checkBox.setTag(Integer.valueOf(i));
                checkBox.setOnCheckedChangeListener(this);
                int i2 = 0;
                checkBox.setChecked(false);
                ((TextView) inflate.findViewById(R.id.group_name)).setText(jSONObject.getString("name"));
                while (true) {
                    if (i2 >= AddOrUpdateTagsFragment.this.selectedTags.length()) {
                        break;
                    } else if (AddOrUpdateTagsFragment.this.selectedTags.getJSONObject(i2).getInt("tag_id") == jSONObject.getInt("tag_id")) {
                        checkBox.setChecked(true);
                        break;
                    } else {
                        i2++;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return inflate;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton.isPressed()) {
                JSONObject jSONObject = (JSONObject) getItem(((Integer) compoundButton.getTag()).intValue());
                try {
                    int i = jSONObject.getInt("tag_id");
                    int i2 = 0;
                    while (true) {
                        if (i2 >= AddOrUpdateTagsFragment.this.selectedTags.length()) {
                            i2 = -1;
                            break;
                        } else if (AddOrUpdateTagsFragment.this.selectedTags.getJSONObject(i2).getInt("tag_id") == i) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 == -1) {
                        AddOrUpdateTagsFragment.this.selectedTags.put(jSONObject);
                    } else {
                        AddOrUpdateTagsFragment.this.selectedTags.remove(i2);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
