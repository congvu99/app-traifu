package com.trainerfu.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LearnFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    /* access modifiers changed from: private */
    public ResourcesAdapter adapter;
    /* access modifiers changed from: private */
    public boolean didLoadOnce = false;
    private String mParam1;
    private String mParam2;
    /* access modifiers changed from: private */
    public ArrayList<JSONObject> resources = null;
    private ListView resourcesList;

    public static LearnFragment newInstance(String str, String str2) {
        LearnFragment learnFragment = new LearnFragment();
        learnFragment.setArguments(new Bundle());
        return learnFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_learn, viewGroup, false);
        this.resourcesList = (ListView) inflate.findViewById(R.id.resources_list);
        ResourcesAdapter resourcesAdapter = new ResourcesAdapter(getActivity());
        this.adapter = resourcesAdapter;
        this.resourcesList.setAdapter(resourcesAdapter);
        this.adapter.notifyDataSetChanged();
        return inflate;
    }

    public void onResume() {
        super.onResume();
        new BaseHttpClient(Boolean.valueOf(!this.didLoadOnce), getActivity()).get("/content/learning-resources", (Map<String, Object>) null, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                try {
                    if (!jSONObject.isNull("links")) {
                        ArrayList unused = LearnFragment.this.resources = new ArrayList();
                        JSONArray jSONArray = jSONObject.getJSONArray("links");
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            LearnFragment.this.resources.add((JSONObject) jSONArray.get(i2));
                        }
                        LearnFragment.this.adapter.notifyDataSetChanged();
                        boolean unused2 = LearnFragment.this.didLoadOnce = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }
        });
    }

    private class ResourcesAdapter extends BaseAdapter {
        private Context context;

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }

        public ResourcesAdapter(Context context2) {
            this.context = context2;
        }

        public int getCount() {
            if (LearnFragment.this.resources == null) {
                return 0;
            }
            return LearnFragment.this.resources.size();
        }

        public Object getItem(int i) {
            return LearnFragment.this.resources.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            if (view == null) {
                view = layoutInflater.inflate(R.layout.resource_row_view, (ViewGroup) null);
            }
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.playWrapper);
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.readWrapper);
            TextView textView = (TextView) view.findViewById(R.id.titleLabel);
            JSONObject jSONObject = (JSONObject) getItem(i);
            try {
                String string = jSONObject.getString("title");
                if (jSONObject.has("video_url")) {
                    final String string2 = jSONObject.getString("video_url");
                    linearLayout.setVisibility(0);
                    linearLayout.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Uri parse = Uri.parse(string2);
                            Intent makeMainSelectorActivity = Intent.makeMainSelectorActivity("android.intent.action.MAIN", "android.intent.category.APP_BROWSER");
                            makeMainSelectorActivity.setData(parse);
                            LearnFragment.this.startActivity(makeMainSelectorActivity);
                        }
                    });
                }
                if (jSONObject.has("article_url")) {
                    final String string3 = jSONObject.getString("article_url");
                    linearLayout2.setVisibility(0);
                    linearLayout2.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Uri parse = Uri.parse(string3);
                            Intent makeMainSelectorActivity = Intent.makeMainSelectorActivity("android.intent.action.MAIN", "android.intent.category.APP_BROWSER");
                            makeMainSelectorActivity.setData(parse);
                            LearnFragment.this.startActivity(makeMainSelectorActivity);
                        }
                    });
                }
                textView.setText(string);
                return view;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
