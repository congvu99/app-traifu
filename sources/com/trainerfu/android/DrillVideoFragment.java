package com.trainerfu.android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.trainerfu.utils.Constants;
import kotlinx.serialization.json.internal.JsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

public class DrillVideoFragment extends Fragment {
    private JSONObject drill;
    private String exerciseInstructions;
    private String exerciseName;
    private Boolean isCustomActionBar = false;
    private String mParam1;
    private String mParam2;
    private ViewGroup view;
    private Toolbar workoutHeader;
    private TextView workoutTitleView;
    private YouTubePlayerListener youTubePlayerListener;
    private YouTubePlayerView youTubePlayerView;
    /* access modifiers changed from: private */
    public String youtubeVideoId;

    public static DrillVideoFragment newInstance(String str, String str2) {
        DrillVideoFragment drillVideoFragment = new DrillVideoFragment();
        drillVideoFragment.setArguments(new Bundle());
        return drillVideoFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_drill_video, viewGroup, false);
        this.view = viewGroup2;
        this.youTubePlayerView = (YouTubePlayerView) viewGroup2.findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(this.youTubePlayerView);
        try {
            Bundle arguments = getArguments();
            this.isCustomActionBar = Boolean.valueOf(arguments.getBoolean("custom_action_bar"));
            JSONObject jSONObject = new JSONObject(arguments.getString(Constants.DRILL));
            this.drill = jSONObject;
            this.youtubeVideoId = jSONObject.getString("youtube_url");
            this.exerciseName = this.drill.getString("exercise_name");
            this.exerciseName = this.exerciseName.substring(0, 1).toUpperCase() + this.exerciseName.substring(1).toLowerCase();
            this.exerciseInstructions = this.drill.getString(Constants.INSTRUCTIONS);
            TextView textView = (TextView) this.view.findViewById(R.id.exercise_description);
            ((TextView) this.view.findViewById(R.id.exercise_title)).setText(this.exerciseName);
            if (!this.exerciseInstructions.equals(JsonLexerKt.NULL) && this.exerciseInstructions.trim().length() > 0) {
                textView.setText(this.exerciseInstructions);
            }
            if (!this.youtubeVideoId.equals(JsonLexerKt.NULL)) {
                this.youTubePlayerView.setVisibility(0);
                this.youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    public void onReady(YouTubePlayer youTubePlayer) {
                        youTubePlayer.loadVideo(DrillVideoFragment.this.youtubeVideoId, 0.0f);
                    }
                });
            } else {
                this.youTubePlayerView.setVisibility(8);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.view;
    }

    public void onDestroyView() {
        super.onDestroyView();
    }
}
