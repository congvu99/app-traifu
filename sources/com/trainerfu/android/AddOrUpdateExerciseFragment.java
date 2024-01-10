package com.trainerfu.android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.loopj.android.image.SmartImageView;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.Constants;
import java.util.HashMap;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

public class AddOrUpdateExerciseFragment extends Fragment {
    private boolean focusNameET = false;
    private boolean forAdding = true;
    private boolean isSaving;
    private String thumbnailUrl;
    private String videoId;
    private String ytVideoTitle;

    public interface EventListener {
        void exerciseAddOrUpdateCancelled();

        void exerciseAdded(JSONObject jSONObject);

        void exerciseUpdated();

        void findYTVideoClicked(String str);

        void tagsClicked();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        final View inflate = layoutInflater.inflate(R.layout.add_exercise_view, viewGroup, false);
        if (bundle == null) {
            this.focusNameET = true;
        }
        inflate.findViewById(R.id.cancel_btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((EventListener) AddOrUpdateExerciseFragment.this.getActivity()).exerciseAddOrUpdateCancelled();
            }
        });
        inflate.findViewById(R.id.find_yt_btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((EventListener) AddOrUpdateExerciseFragment.this.getActivity()).findYTVideoClicked(((EditText) inflate.findViewById(R.id.name_et)).getText().toString().trim());
            }
        });
        inflate.findViewById(R.id.save_btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AddOrUpdateExerciseFragment.this.save();
            }
        });
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("for_adding")) {
            this.forAdding = arguments.getBoolean("for_adding");
        }
        if (bundle == null && !this.forAdding) {
            try {
                JSONObject jSONObject = new JSONObject(getArguments().getString("exercise"));
                if (!jSONObject.isNull("youtube_url")) {
                    String string = jSONObject.getString("youtube_url");
                    this.videoId = string;
                    this.thumbnailUrl = String.format("http://img.youtube.com/vi/%s/2.jpg", new Object[]{string});
                    this.ytVideoTitle = getString(R.string.Video);
                }
                bindFindYTVideoView(inflate);
                ((EditText) inflate.findViewById(R.id.name_et)).setText(jSONObject.getString("name"));
                if (!jSONObject.isNull(Constants.INSTRUCTIONS)) {
                    ((EditText) inflate.findViewById(R.id.note_et)).setText(jSONObject.getString(Constants.INSTRUCTIONS));
                }
                int i = jSONObject.getInt("scales");
                RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.radio_group);
                if (i == 14) {
                    radioGroup.check(R.id.radio_strength);
                } else {
                    radioGroup.check(R.id.radio_cardio);
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null && bundle.containsKey("video_id")) {
            this.videoId = bundle.getString("video_id");
            this.ytVideoTitle = bundle.getString("yt_video_title");
            this.thumbnailUrl = bundle.getString("thumbnail_url");
            bindFindYTVideoView(getView());
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String str = this.videoId;
        if (str != null) {
            bundle.putString("video_id", str);
            bundle.putString("yt_video_title", this.ytVideoTitle);
            bundle.putString("thumbnail_url", this.thumbnailUrl);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.focusNameET && getView().findViewById(R.id.name_et).requestFocus()) {
            ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(getView().findViewById(R.id.name_et), 1);
        }
    }

    public void ytVideoSelected(String str, String str2, String str3) {
        this.videoId = str;
        this.ytVideoTitle = str2;
        this.thumbnailUrl = str3;
        bindFindYTVideoView(getView());
    }

    private void bindFindYTVideoView(View view) {
        if (this.videoId != null) {
            SmartImageView smartImageView = (SmartImageView) view.findViewById(R.id.ytThumbnail);
            smartImageView.setImageUrl(this.thumbnailUrl);
            smartImageView.setVisibility(0);
            ((TextView) view.findViewById(R.id.titleLabel)).setText(this.ytVideoTitle);
        }
    }

    /* access modifiers changed from: private */
    public void save() {
        String str;
        if (!this.isSaving) {
            View view = getView();
            HashMap hashMap = new HashMap();
            hashMap.put("name", ((EditText) view.findViewById(R.id.name_et)).getText().toString().trim());
            hashMap.put("classification", Integer.valueOf(((RadioGroup) view.findViewById(R.id.radio_group)).getCheckedRadioButtonId() == R.id.radio_strength ? 1 : 2));
            hashMap.put(Constants.INSTRUCTIONS, ((EditText) view.findViewById(R.id.note_et)).getText().toString().trim());
            hashMap.put("is_active", true);
            String str2 = this.videoId;
            hashMap.put("youtube_url", str2 == null ? "" : String.format("https://www.youtube.com/watch?v=%s", new Object[]{str2}));
            this.isSaving = true;
            BaseHttpClient baseHttpClient = new BaseHttpClient(true, getActivity());
            if (this.forAdding) {
                baseHttpClient.put("/exercises/new", hashMap, new BaseResponseHandler() {
                    public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                        if (!AddOrUpdateExerciseFragment.this.isAdded()) {
                            return true;
                        }
                        ((EventListener) AddOrUpdateExerciseFragment.this.getActivity()).exerciseAdded(jSONObject);
                        return true;
                    }
                });
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(getArguments().getString("exercise"));
                int i = jSONObject.getInt("id");
                if (jSONObject.getBoolean("is_custom")) {
                    str = String.format("/exercises/%s", new Object[]{String.valueOf(i)});
                } else {
                    str = String.format("/exercises_overrides/%s", new Object[]{String.valueOf(i)});
                }
                baseHttpClient.post(str, hashMap, new BaseResponseHandler() {
                    public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                        if (!AddOrUpdateExerciseFragment.this.isAdded()) {
                            return true;
                        }
                        ((EventListener) AddOrUpdateExerciseFragment.this.getActivity()).exerciseUpdated();
                        return true;
                    }
                });
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
