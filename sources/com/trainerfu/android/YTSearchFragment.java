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
import androidx.fragment.app.FragmentActivity;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.loopj.android.image.SmartImageView;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.Constants;
import com.trainerfu.utils.Duration;
import com.trainerfu.utils.ExerciseDataset;
import com.trainerfu.utils.Util;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.IOException;
import java.util.HashMap;
import kotlinx.serialization.json.internal.JsonLexerKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class YTSearchFragment extends Fragment {
    /* access modifiers changed from: private */
    public YTSearchResultAdapter adapter;
    /* access modifiers changed from: private */
    public String currentSearchTerm = "";
    private ListView listView;
    /* access modifiers changed from: private */
    public JSONArray result = null;
    /* access modifiers changed from: private */
    public String resultSearchTerm = "";
    /* access modifiers changed from: private */
    public View view;
    /* access modifiers changed from: private */
    public String youtubeApiKey;

    public interface EventListener {
        void ytThumbnailClicked(JSONObject jSONObject);

        void ytVideoSelected(String str, String str2, String str3);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.yt_search_view, viewGroup, false);
        this.view = inflate;
        this.listView = (ListView) inflate.findViewById(R.id.search_result_view);
        YTSearchResultAdapter yTSearchResultAdapter = new YTSearchResultAdapter(getActivity());
        this.adapter = yTSearchResultAdapter;
        this.listView.setAdapter(yTSearchResultAdapter);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                String str = "id";
                try {
                    JSONObject jSONObject = YTSearchFragment.this.result.getJSONObject(i);
                    if (!jSONObject.has(str)) {
                        str = "videoId";
                    }
                    ((EventListener) YTSearchFragment.this.getActivity()).ytVideoSelected(jSONObject.getString(str), YTSearchFragment.getVideoTitle(jSONObject), YTSearchFragment.getVideoThumbnailUrl(jSONObject, YTSearchFragment.this.youtubeApiKey));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        this.youtubeApiKey = ExerciseDataset.getInstance().getApiKey();
        return this.view;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            this.currentSearchTerm = bundle.getString("current_st");
            this.resultSearchTerm = bundle.getString("result_st");
            if (bundle.containsKey("result")) {
                try {
                    this.result = new JSONArray(bundle.getString("result"));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            this.currentSearchTerm = getArguments().getString("current_st");
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("current_st", this.currentSearchTerm);
        bundle.putString("result_st", this.resultSearchTerm);
        JSONArray jSONArray = this.result;
        if (jSONArray != null) {
            bundle.putString("result", jSONArray.toString());
        }
    }

    public void onResume() {
        super.onResume();
        if (this.currentSearchTerm.length() > 0 && !this.currentSearchTerm.equalsIgnoreCase(this.resultSearchTerm)) {
            search(this.currentSearchTerm);
        }
    }

    public void search(String str) {
        final String trim = str.trim();
        if (trim.length() == 0) {
            ((SmoothProgressBar) this.view.findViewById(R.id.progress_bar)).setVisibility(8);
        } else if (!trim.equalsIgnoreCase(this.resultSearchTerm)) {
            this.currentSearchTerm = trim;
            ((SmoothProgressBar) this.view.findViewById(R.id.progress_bar)).setVisibility(0);
            String str2 = this.youtubeApiKey;
            if (str2 == null || str2.isEmpty() || this.youtubeApiKey.equals(JsonLexerKt.NULL)) {
                BaseHttpClient baseHttpClient = new BaseHttpClient();
                HashMap hashMap = new HashMap();
                hashMap.put(FirebaseAnalytics.Param.SEARCH_TERM, this.currentSearchTerm);
                baseHttpClient.get("/search_exercise_videos", hashMap, new BaseResponseHandler() {
                    public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                        return true;
                    }

                    public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                        ((SmoothProgressBar) YTSearchFragment.this.view.findViewById(R.id.progress_bar)).setVisibility(8);
                        try {
                            JSONArray unused = YTSearchFragment.this.result = jSONObject.getJSONArray(FirebaseAnalytics.Param.ITEMS);
                            YTSearchFragment.this.adapter.notifyDataSetChanged();
                            Util.hideKeyboard(YTSearchFragment.this.getActivity());
                            return true;
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                return;
            }
            HttpUrl build = new HttpUrl.Builder().scheme("https").host("www.googleapis.com").addPathSegment("youtube").addPathSegment("v3").addPathSegment(FirebaseAnalytics.Event.SEARCH).addQueryParameter(SDKConstants.PARAM_KEY, this.youtubeApiKey).addQueryParameter("q", trim).addQueryParameter("part", "snippet").addQueryParameter("type", "video").addQueryParameter("maxResults", "50").addQueryParameter("videoDuration", "short").build();
            OkHttpClient okHttpClient = new OkHttpClient();
            Request build2 = new Request.Builder().url(build).build();
            final FragmentActivity activity = getActivity();
            okHttpClient.newCall(build2).enqueue(new Callback() {
                public void onFailure(Call call, IOException iOException) {
                    if (YTSearchFragment.this.isAdded()) {
                        activity.runOnUiThread(new Runnable() {
                            public void run() {
                                if (trim.equalsIgnoreCase(YTSearchFragment.this.currentSearchTerm)) {
                                    ((SmoothProgressBar) YTSearchFragment.this.view.findViewById(R.id.progress_bar)).setVisibility(8);
                                }
                            }
                        });
                    }
                }

                public void onResponse(Call call, Response response) throws IOException {
                    if (YTSearchFragment.this.isAdded()) {
                        if (!response.isSuccessful()) {
                            activity.runOnUiThread(new Runnable() {
                                public void run() {
                                    ((SmoothProgressBar) YTSearchFragment.this.view.findViewById(R.id.progress_bar)).setVisibility(8);
                                }
                            });
                            return;
                        }
                        try {
                            if (!trim.equalsIgnoreCase(YTSearchFragment.this.currentSearchTerm)) {
                                return;
                            }
                            if (YTSearchFragment.this.isAdded()) {
                                JSONArray jSONArray = new JSONObject(response.body().string()).getJSONArray(FirebaseAnalytics.Param.ITEMS);
                                StringBuilder sb = new StringBuilder();
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                                    if (i > 0) {
                                        sb.append(",");
                                    }
                                    sb.append(jSONObject.getJSONObject("id").getString("videoId"));
                                }
                                new OkHttpClient().newCall(new Request.Builder().url(new HttpUrl.Builder().scheme("https").host("www.googleapis.com").addPathSegment("youtube").addPathSegment("v3").addPathSegment("videos").addQueryParameter(SDKConstants.PARAM_KEY, YTSearchFragment.this.youtubeApiKey).addQueryParameter("q", trim).addQueryParameter("part", "snippet,contentDetails,statistics").addQueryParameter("id", sb.toString()).build()).build()).enqueue(new Callback() {
                                    public void onFailure(Call call, IOException iOException) {
                                        if (YTSearchFragment.this.isAdded()) {
                                            activity.runOnUiThread(new Runnable() {
                                                public void run() {
                                                    if (trim.equalsIgnoreCase(YTSearchFragment.this.currentSearchTerm)) {
                                                        ((SmoothProgressBar) YTSearchFragment.this.view.findViewById(R.id.progress_bar)).setVisibility(8);
                                                    }
                                                }
                                            });
                                        }
                                    }

                                    public void onResponse(Call call, final Response response) throws IOException {
                                        if (trim.equalsIgnoreCase(YTSearchFragment.this.currentSearchTerm) && YTSearchFragment.this.isAdded()) {
                                            activity.runOnUiThread(new Runnable() {
                                                public void run() {
                                                    ((SmoothProgressBar) YTSearchFragment.this.view.findViewById(R.id.progress_bar)).setVisibility(8);
                                                    String unused = YTSearchFragment.this.resultSearchTerm = trim;
                                                    try {
                                                        JSONArray unused2 = YTSearchFragment.this.result = new JSONObject(response.body().string()).getJSONArray(FirebaseAnalytics.Param.ITEMS);
                                                        YTSearchFragment.this.adapter.notifyDataSetChanged();
                                                        Util.hideKeyboard(YTSearchFragment.this.getActivity());
                                                    } catch (JSONException e) {
                                                        throw new RuntimeException(e);
                                                    } catch (IOException e2) {
                                                        throw new RuntimeException(e2);
                                                    }
                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static String getVideoTitle(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("snippet")) {
            return jSONObject.getJSONObject("snippet").getString("title");
        }
        return jSONObject.getString("title");
    }

    /* access modifiers changed from: private */
    public static String getVideoThumbnailUrl(JSONObject jSONObject, String str) throws JSONException {
        String str2 = "id";
        if (!jSONObject.has(str2)) {
            str2 = "videoId";
        }
        return String.format("http://img.youtube.com/vi/%s/2.jpg", new Object[]{jSONObject.getString(str2)});
    }

    /* access modifiers changed from: private */
    public String getYoutubeVideoId(JSONObject jSONObject) {
        String str = "id";
        try {
            if (!jSONObject.has(str)) {
                str = "videoId";
            }
            return jSONObject.getString(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private class YTSearchResultAdapter extends BaseAdapter {
        private Context context;

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return false;
        }

        public YTSearchResultAdapter(Context context2) {
            this.context = context2;
        }

        public int getCount() {
            if (YTSearchFragment.this.result == null || !YTSearchFragment.this.isAdded()) {
                return 0;
            }
            return YTSearchFragment.this.result.length();
        }

        public Object getItem(int i) {
            try {
                return YTSearchFragment.this.result.get(i);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            int i2;
            String str = "id";
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            if (view == null) {
                view = layoutInflater.inflate(R.layout.yt_search_row_view, (ViewGroup) null);
            }
            final JSONObject jSONObject = (JSONObject) getItem(i);
            SmartImageView smartImageView = (SmartImageView) view.findViewById(R.id.ytThumbnail);
            TextView textView = (TextView) view.findViewById(R.id.titleLabel);
            TextView textView2 = (TextView) view.findViewById(R.id.detailLabel);
            try {
                if (!jSONObject.has(str)) {
                    str = "videoId";
                }
                jSONObject.getString(str);
                smartImageView.setImageUrl(YTSearchFragment.getVideoThumbnailUrl(jSONObject, YTSearchFragment.this.youtubeApiKey));
                textView.setText(YTSearchFragment.getVideoTitle(jSONObject));
                if (jSONObject.has("statistics")) {
                    i2 = jSONObject.getJSONObject("statistics").getInt("viewCount");
                } else {
                    i2 = jSONObject.getInt("views");
                }
                String str2 = "-:-";
                if (jSONObject.has("contentDetails")) {
                    String string = jSONObject.getJSONObject("contentDetails").getString("duration");
                    Duration duration = new Duration();
                    try {
                        duration.parse(string);
                        str2 = String.format("%s:%s", new Object[]{Integer.valueOf(duration.minutes), Integer.valueOf(duration.seconds)});
                    } catch (Exception unused) {
                    }
                } else {
                    str2 = jSONObject.getString("duration");
                }
                textView2.setText(String.format("%s  |  %s: %s", new Object[]{str2, YTSearchFragment.this.getString(R.string.views), String.valueOf(i2)}));
                view.findViewById(R.id.videoIVWrapper).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("youtube_url", YTSearchFragment.this.getYoutubeVideoId(jSONObject));
                            jSONObject.put("exercise_name", YTSearchFragment.getVideoTitle(jSONObject));
                            jSONObject.put(Constants.INSTRUCTIONS, "");
                            ((EventListener) YTSearchFragment.this.getActivity()).ytThumbnailClicked(jSONObject);
                        } catch (Exception unused) {
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
