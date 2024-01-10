package com.trainerfu.android;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.afollestad.materialdialogs.MaterialDialog;
import org.json.JSONArray;
import org.json.JSONException;

public class LikesNamesFragment extends DialogFragment {
    private LikeNameAdapter likeNameAdapter;
    /* access modifiers changed from: private */
    public JSONArray likes;
    private ListView likesList;

    public static LikesNamesFragment newInstance() {
        return new LikesNamesFragment();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        try {
            this.likes = new JSONArray(getArguments().getString("likes"));
            MaterialDialog build = new MaterialDialog.Builder(getActivity()).customView((int) R.layout.like_names_view, false).positiveText((CharSequence) "").negativeText((CharSequence) "").build();
            this.likeNameAdapter = new LikeNameAdapter(getActivity());
            ListView listView = (ListView) build.getCustomView().findViewById(R.id.likes_list);
            this.likesList = listView;
            listView.setAdapter(this.likeNameAdapter);
            return build;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private class LikeNameAdapter extends BaseAdapter {
        private Context context;

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }

        public LikeNameAdapter(Context context2) {
            this.context = context2;
        }

        public int getCount() {
            return LikesNamesFragment.this.likes.length();
        }

        public Object getItem(int i) {
            try {
                return LikesNamesFragment.this.likes.getJSONObject(i);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            try {
                View inflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.like_name_row_view, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.client_name)).setText(LikesNamesFragment.this.likes.getJSONObject(i).getString("first_name"));
                return inflate;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
