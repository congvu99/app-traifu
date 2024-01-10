package com.pierfrancescosoffritti.androidyoutubeplayer.core.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.LegacyYouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.menu.YouTubePlayerMenu;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.menu.defaultMenu.DefaultYouTubePlayerMenu;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.utils.FadeViewHelper;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.views.YouTubePlayerSeekBar;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.views.YouTubePlayerSeekBarListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010)\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u000bH\u0016J\u0010\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u0015H\u0016J\b\u0010-\u001a\u00020&H\u0016J\b\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020/2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u00101\u001a\u00020/2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00102\u001a\u000203H\u0016J\u0018\u00104\u001a\u00020/2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020/H\u0002J\u0018\u00108\u001a\u00020/2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00109\u001a\u00020:H\u0016J\u0018\u0010;\u001a\u00020/2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020/2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010?\u001a\u00020/2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010@\u001a\u00020AH\u0016J\u0018\u0010B\u001a\u00020/2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010C\u001a\u000203H\u0016J\u0018\u0010D\u001a\u00020/2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010E\u001a\u00020FH\u0016J\u0018\u0010G\u001a\u00020/2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010H\u001a\u000203H\u0016J\b\u0010I\u001a\u00020/H\u0016J\b\u0010J\u001a\u00020/H\u0016J\u0010\u0010K\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u000bH\u0016J\u0010\u0010L\u001a\u00020/2\u0006\u0010M\u001a\u000203H\u0016J\u001a\u0010N\u001a\u00020\u00012\u0006\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010R\u001a\u00020\u00012\u0006\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010S\u001a\u00020\u00012\u0006\u0010T\u001a\u00020\u001dH\u0016J\u0010\u0010U\u001a\u00020\u00012\u0006\u0010V\u001a\u00020\u001dH\u0016J\u0010\u0010W\u001a\u00020\u00012\u0006\u0010#\u001a\u00020FH\u0016J\u0010\u0010X\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0015H\u0016J\u0010\u0010Z\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0015H\u0016J\u0010\u0010[\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0015H\u0016J\u0010\u0010\\\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0015H\u0016J\u0010\u0010]\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0015H\u0016J\u0010\u0010^\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0015H\u0016J\u0010\u0010_\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0015H\u0016J\u0010\u0010`\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0015H\u0016J\u0010\u0010a\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0015H\u0016J\u0010\u0010b\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0015H\u0016J\u0010\u0010c\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0015H\u0016J\u0010\u0010d\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0015H\u0016J\u0010\u0010e\u001a\u00020/2\u0006\u0010f\u001a\u00020\u0015H\u0002J\u0010\u0010g\u001a\u00020/2\u0006\u0010@\u001a\u00020AH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000¨\u0006h"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/DefaultPlayerUiController;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/PlayerUiController;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerListener;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerFullScreenListener;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/views/YouTubePlayerSeekBarListener;", "youTubePlayerView", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/LegacyYouTubePlayerView;", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "(Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/LegacyYouTubePlayerView;Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;)V", "controlsContainer", "Landroid/view/View;", "customActionLeft", "Landroid/widget/ImageView;", "customActionRight", "extraViewsContainer", "Landroid/widget/LinearLayout;", "fadeControlsContainer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/utils/FadeViewHelper;", "fullScreenButton", "isCustomActionLeftEnabled", "", "isCustomActionRightEnabled", "isPlayPauseButtonEnabled", "isPlaying", "liveVideoIndicator", "Landroid/widget/TextView;", "menuButton", "onFullScreenButtonListener", "Landroid/view/View$OnClickListener;", "onMenuButtonClickListener", "panel", "playPauseButton", "progressBar", "Landroid/widget/ProgressBar;", "videoTitle", "youTubeButton", "youTubePlayerMenu", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/menu/YouTubePlayerMenu;", "youtubePlayerSeekBar", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/views/YouTubePlayerSeekBar;", "addView", "view", "enableLiveVideoUi", "enable", "getMenu", "initClickListeners", "", "onApiChange", "onCurrentSecond", "second", "", "onError", "error", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerError;", "onPlayButtonPressed", "onPlaybackQualityChange", "playbackQuality", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackQuality;", "onPlaybackRateChange", "playbackRate", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackRate;", "onReady", "onStateChange", "state", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "onVideoDuration", "duration", "onVideoId", "videoId", "", "onVideoLoadedFraction", "loadedFraction", "onYouTubePlayerEnterFullScreen", "onYouTubePlayerExitFullScreen", "removeView", "seekTo", "time", "setCustomAction1", "icon", "Landroid/graphics/drawable/Drawable;", "clickListener", "setCustomAction2", "setFullScreenButtonClickListener", "customFullScreenButtonClickListener", "setMenuButtonClickListener", "customMenuButtonClickListener", "setVideoTitle", "showBufferingProgress", "show", "showCurrentTime", "showCustomAction1", "showCustomAction2", "showDuration", "showFullscreenButton", "showMenuButton", "showPlayPauseButton", "showSeekBar", "showUi", "showVideoTitle", "showYouTubeButton", "updatePlayPauseButtonIcon", "playing", "updateState", "core_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: DefaultPlayerUiController.kt */
public final class DefaultPlayerUiController implements PlayerUiController, YouTubePlayerListener, YouTubePlayerFullScreenListener, YouTubePlayerSeekBarListener {
    private final View controlsContainer;
    private final ImageView customActionLeft;
    private final ImageView customActionRight;
    private final LinearLayout extraViewsContainer;
    /* access modifiers changed from: private */
    public final FadeViewHelper fadeControlsContainer;
    /* access modifiers changed from: private */
    public final ImageView fullScreenButton;
    private boolean isCustomActionLeftEnabled;
    private boolean isCustomActionRightEnabled;
    private boolean isPlayPauseButtonEnabled = true;
    private boolean isPlaying;
    private final TextView liveVideoIndicator;
    /* access modifiers changed from: private */
    public final ImageView menuButton;
    /* access modifiers changed from: private */
    public View.OnClickListener onFullScreenButtonListener;
    /* access modifiers changed from: private */
    public View.OnClickListener onMenuButtonClickListener;
    private final View panel;
    private final ImageView playPauseButton;
    private final ProgressBar progressBar;
    private final TextView videoTitle;
    /* access modifiers changed from: private */
    public final ImageView youTubeButton;
    private final YouTubePlayer youTubePlayer;
    /* access modifiers changed from: private */
    public YouTubePlayerMenu youTubePlayerMenu;
    /* access modifiers changed from: private */
    public final LegacyYouTubePlayerView youTubePlayerView;
    /* access modifiers changed from: private */
    public final YouTubePlayerSeekBar youtubePlayerSeekBar;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayerConstants.PlayerState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PlayerConstants.PlayerState.ENDED.ordinal()] = 1;
            $EnumSwitchMapping$0[PlayerConstants.PlayerState.PAUSED.ordinal()] = 2;
            $EnumSwitchMapping$0[PlayerConstants.PlayerState.PLAYING.ordinal()] = 3;
        }
    }

    public void onApiChange(YouTubePlayer youTubePlayer2) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer2, "youTubePlayer");
    }

    public void onCurrentSecond(YouTubePlayer youTubePlayer2, float f) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer2, "youTubePlayer");
    }

    public void onError(YouTubePlayer youTubePlayer2, PlayerConstants.PlayerError playerError) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer2, "youTubePlayer");
        Intrinsics.checkParameterIsNotNull(playerError, "error");
    }

    public void onPlaybackQualityChange(YouTubePlayer youTubePlayer2, PlayerConstants.PlaybackQuality playbackQuality) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer2, "youTubePlayer");
        Intrinsics.checkParameterIsNotNull(playbackQuality, "playbackQuality");
    }

    public void onPlaybackRateChange(YouTubePlayer youTubePlayer2, PlayerConstants.PlaybackRate playbackRate) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer2, "youTubePlayer");
        Intrinsics.checkParameterIsNotNull(playbackRate, "playbackRate");
    }

    public void onReady(YouTubePlayer youTubePlayer2) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer2, "youTubePlayer");
    }

    public void onVideoDuration(YouTubePlayer youTubePlayer2, float f) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer2, "youTubePlayer");
    }

    public void onVideoLoadedFraction(YouTubePlayer youTubePlayer2, float f) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer2, "youTubePlayer");
    }

    public DefaultPlayerUiController(LegacyYouTubePlayerView legacyYouTubePlayerView, YouTubePlayer youTubePlayer2) {
        Intrinsics.checkParameterIsNotNull(legacyYouTubePlayerView, "youTubePlayerView");
        Intrinsics.checkParameterIsNotNull(youTubePlayer2, "youTubePlayer");
        this.youTubePlayerView = legacyYouTubePlayerView;
        this.youTubePlayer = youTubePlayer2;
        View inflate = View.inflate(legacyYouTubePlayerView.getContext(), R.layout.ayp_default_player_ui, this.youTubePlayerView);
        Context context = this.youTubePlayerView.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "youTubePlayerView.context");
        this.youTubePlayerMenu = new DefaultYouTubePlayerMenu(context);
        View findViewById = inflate.findViewById(R.id.panel);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "controlsView.findViewById(R.id.panel)");
        this.panel = findViewById;
        View findViewById2 = inflate.findViewById(R.id.controls_container);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "controlsView.findViewById(R.id.controls_container)");
        this.controlsContainer = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.extra_views_container);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "controlsView.findViewByI…id.extra_views_container)");
        this.extraViewsContainer = (LinearLayout) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.video_title);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "controlsView.findViewById(R.id.video_title)");
        this.videoTitle = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.live_video_indicator);
        Intrinsics.checkExpressionValueIsNotNull(findViewById5, "controlsView.findViewByI….id.live_video_indicator)");
        this.liveVideoIndicator = (TextView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.progress);
        Intrinsics.checkExpressionValueIsNotNull(findViewById6, "controlsView.findViewById(R.id.progress)");
        this.progressBar = (ProgressBar) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.menu_button);
        Intrinsics.checkExpressionValueIsNotNull(findViewById7, "controlsView.findViewById(R.id.menu_button)");
        this.menuButton = (ImageView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.play_pause_button);
        Intrinsics.checkExpressionValueIsNotNull(findViewById8, "controlsView.findViewById(R.id.play_pause_button)");
        this.playPauseButton = (ImageView) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.youtube_button);
        Intrinsics.checkExpressionValueIsNotNull(findViewById9, "controlsView.findViewById(R.id.youtube_button)");
        this.youTubeButton = (ImageView) findViewById9;
        View findViewById10 = inflate.findViewById(R.id.fullscreen_button);
        Intrinsics.checkExpressionValueIsNotNull(findViewById10, "controlsView.findViewById(R.id.fullscreen_button)");
        this.fullScreenButton = (ImageView) findViewById10;
        View findViewById11 = inflate.findViewById(R.id.custom_action_left_button);
        Intrinsics.checkExpressionValueIsNotNull(findViewById11, "controlsView.findViewByI…ustom_action_left_button)");
        this.customActionLeft = (ImageView) findViewById11;
        View findViewById12 = inflate.findViewById(R.id.custom_action_right_button);
        Intrinsics.checkExpressionValueIsNotNull(findViewById12, "controlsView.findViewByI…stom_action_right_button)");
        this.customActionRight = (ImageView) findViewById12;
        View findViewById13 = inflate.findViewById(R.id.youtube_player_seekbar);
        Intrinsics.checkExpressionValueIsNotNull(findViewById13, "controlsView.findViewByI…d.youtube_player_seekbar)");
        this.youtubePlayerSeekBar = (YouTubePlayerSeekBar) findViewById13;
        this.fadeControlsContainer = new FadeViewHelper(this.controlsContainer);
        this.onFullScreenButtonListener = new View.OnClickListener(this) {
            final /* synthetic */ DefaultPlayerUiController this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.youTubePlayerView.toggleFullScreen();
            }
        };
        this.onMenuButtonClickListener = new View.OnClickListener(this) {
            final /* synthetic */ DefaultPlayerUiController this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.youTubePlayerMenu.show(this.this$0.menuButton);
            }
        };
        initClickListeners();
    }

    private final void initClickListeners() {
        this.youTubePlayer.addListener(this.youtubePlayerSeekBar);
        this.youTubePlayer.addListener(this.fadeControlsContainer);
        this.youtubePlayerSeekBar.setYoutubePlayerSeekBarListener(this);
        this.panel.setOnClickListener(new DefaultPlayerUiController$initClickListeners$1(this));
        this.playPauseButton.setOnClickListener(new DefaultPlayerUiController$initClickListeners$2(this));
        this.fullScreenButton.setOnClickListener(new DefaultPlayerUiController$initClickListeners$3(this));
        this.menuButton.setOnClickListener(new DefaultPlayerUiController$initClickListeners$4(this));
    }

    public PlayerUiController showVideoTitle(boolean z) {
        this.videoTitle.setVisibility(z ? 0 : 8);
        return this;
    }

    public PlayerUiController setVideoTitle(String str) {
        Intrinsics.checkParameterIsNotNull(str, "videoTitle");
        this.videoTitle.setText(str);
        return this;
    }

    public PlayerUiController showUi(boolean z) {
        this.fadeControlsContainer.setDisabled(!z);
        this.controlsContainer.setVisibility(z ? 0 : 4);
        return this;
    }

    public PlayerUiController showPlayPauseButton(boolean z) {
        this.playPauseButton.setVisibility(z ? 0 : 8);
        this.isPlayPauseButtonEnabled = z;
        return this;
    }

    public PlayerUiController enableLiveVideoUi(boolean z) {
        int i = 0;
        this.youtubePlayerSeekBar.setVisibility(z ? 4 : 0);
        TextView textView = this.liveVideoIndicator;
        if (!z) {
            i = 8;
        }
        textView.setVisibility(i);
        return this;
    }

    public PlayerUiController setCustomAction1(Drawable drawable, View.OnClickListener onClickListener) {
        Intrinsics.checkParameterIsNotNull(drawable, "icon");
        this.customActionLeft.setImageDrawable(drawable);
        this.customActionLeft.setOnClickListener(onClickListener);
        showCustomAction1(true);
        return this;
    }

    public PlayerUiController setCustomAction2(Drawable drawable, View.OnClickListener onClickListener) {
        Intrinsics.checkParameterIsNotNull(drawable, "icon");
        this.customActionRight.setImageDrawable(drawable);
        this.customActionRight.setOnClickListener(onClickListener);
        showCustomAction2(true);
        return this;
    }

    public PlayerUiController showCustomAction1(boolean z) {
        this.isCustomActionLeftEnabled = z;
        this.customActionLeft.setVisibility(z ? 0 : 8);
        return this;
    }

    public PlayerUiController showCustomAction2(boolean z) {
        this.isCustomActionRightEnabled = z;
        this.customActionRight.setVisibility(z ? 0 : 8);
        return this;
    }

    public PlayerUiController showMenuButton(boolean z) {
        this.menuButton.setVisibility(z ? 0 : 8);
        return this;
    }

    public PlayerUiController setMenuButtonClickListener(View.OnClickListener onClickListener) {
        Intrinsics.checkParameterIsNotNull(onClickListener, "customMenuButtonClickListener");
        this.onMenuButtonClickListener = onClickListener;
        return this;
    }

    public PlayerUiController showCurrentTime(boolean z) {
        this.youtubePlayerSeekBar.getVideoCurrentTimeTextView().setVisibility(z ? 0 : 8);
        return this;
    }

    public PlayerUiController showDuration(boolean z) {
        this.youtubePlayerSeekBar.getVideoDurationTextView().setVisibility(z ? 0 : 8);
        return this;
    }

    public PlayerUiController showSeekBar(boolean z) {
        this.youtubePlayerSeekBar.getSeekBar().setVisibility(z ? 0 : 4);
        return this;
    }

    public PlayerUiController showBufferingProgress(boolean z) {
        this.youtubePlayerSeekBar.setShowBufferingProgress(z);
        return this;
    }

    public PlayerUiController showYouTubeButton(boolean z) {
        this.youTubeButton.setVisibility(z ? 0 : 8);
        return this;
    }

    public PlayerUiController addView(View view) {
        Intrinsics.checkParameterIsNotNull(view, ViewHierarchyConstants.VIEW_KEY);
        this.extraViewsContainer.addView(view, 0);
        return this;
    }

    public PlayerUiController removeView(View view) {
        Intrinsics.checkParameterIsNotNull(view, ViewHierarchyConstants.VIEW_KEY);
        this.extraViewsContainer.removeView(view);
        return this;
    }

    public YouTubePlayerMenu getMenu() {
        return this.youTubePlayerMenu;
    }

    public PlayerUiController showFullscreenButton(boolean z) {
        this.fullScreenButton.setVisibility(z ? 0 : 8);
        return this;
    }

    public PlayerUiController setFullScreenButtonClickListener(View.OnClickListener onClickListener) {
        Intrinsics.checkParameterIsNotNull(onClickListener, "customFullScreenButtonClickListener");
        this.onFullScreenButtonListener = onClickListener;
        return this;
    }

    /* access modifiers changed from: private */
    public final void onPlayButtonPressed() {
        if (this.isPlaying) {
            this.youTubePlayer.pause();
        } else {
            this.youTubePlayer.play();
        }
    }

    public void onYouTubePlayerEnterFullScreen() {
        this.fullScreenButton.setImageResource(R.drawable.ayp_ic_fullscreen_exit_24dp);
    }

    public void onYouTubePlayerExitFullScreen() {
        this.fullScreenButton.setImageResource(R.drawable.ayp_ic_fullscreen_24dp);
    }

    private final void updateState(PlayerConstants.PlayerState playerState) {
        int i = WhenMappings.$EnumSwitchMapping$0[playerState.ordinal()];
        if (i == 1) {
            this.isPlaying = false;
        } else if (i == 2) {
            this.isPlaying = false;
        } else if (i == 3) {
            this.isPlaying = true;
        }
        updatePlayPauseButtonIcon(!this.isPlaying);
    }

    private final void updatePlayPauseButtonIcon(boolean z) {
        this.playPauseButton.setImageResource(z ? R.drawable.ayp_ic_pause_36dp : R.drawable.ayp_ic_play_36dp);
    }

    public void seekTo(float f) {
        this.youTubePlayer.seekTo(f);
    }

    public void onStateChange(YouTubePlayer youTubePlayer2, PlayerConstants.PlayerState playerState) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer2, "youTubePlayer");
        Intrinsics.checkParameterIsNotNull(playerState, "state");
        updateState(playerState);
        boolean z = false;
        if (playerState == PlayerConstants.PlayerState.PLAYING || playerState == PlayerConstants.PlayerState.PAUSED || playerState == PlayerConstants.PlayerState.VIDEO_CUED) {
            View view = this.panel;
            view.setBackgroundColor(ContextCompat.getColor(view.getContext(), 17170445));
            this.progressBar.setVisibility(8);
            if (this.isPlayPauseButtonEnabled) {
                this.playPauseButton.setVisibility(0);
            }
            if (this.isCustomActionLeftEnabled) {
                this.customActionLeft.setVisibility(0);
            }
            if (this.isCustomActionRightEnabled) {
                this.customActionRight.setVisibility(0);
            }
            if (playerState == PlayerConstants.PlayerState.PLAYING) {
                z = true;
            }
            updatePlayPauseButtonIcon(z);
            return;
        }
        updatePlayPauseButtonIcon(false);
        if (playerState == PlayerConstants.PlayerState.BUFFERING) {
            this.progressBar.setVisibility(0);
            View view2 = this.panel;
            view2.setBackgroundColor(ContextCompat.getColor(view2.getContext(), 17170445));
            if (this.isPlayPauseButtonEnabled) {
                this.playPauseButton.setVisibility(4);
            }
            this.customActionLeft.setVisibility(8);
            this.customActionRight.setVisibility(8);
        }
        if (playerState == PlayerConstants.PlayerState.UNSTARTED) {
            this.progressBar.setVisibility(8);
            if (this.isPlayPauseButtonEnabled) {
                this.playPauseButton.setVisibility(0);
            }
        }
    }

    public void onVideoId(YouTubePlayer youTubePlayer2, String str) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer2, "youTubePlayer");
        Intrinsics.checkParameterIsNotNull(str, "videoId");
        this.youTubeButton.setOnClickListener(new DefaultPlayerUiController$onVideoId$1(this, str));
    }
}
