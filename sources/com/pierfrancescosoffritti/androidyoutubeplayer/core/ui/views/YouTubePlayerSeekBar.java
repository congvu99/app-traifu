package com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.pierfrancescosoffritti.androidyoutubeplayer.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.utils.TimeUtilities;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010*\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0016J\u0018\u0010-\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u00101\u001a\u000202H\u0016J \u00103\u001a\u00020$2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\nH\u0016J\u0010\u00106\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u00107\u001a\u00020$2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u00108\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020$2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010<\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010=\u001a\u00020)H\u0016J\u0018\u0010>\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010?\u001a\u00020@H\u0016J\u0018\u0010A\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010B\u001a\u00020)H\u0016J\b\u0010C\u001a\u00020$H\u0002J\u0010\u0010D\u001a\u00020$2\b\b\u0001\u0010E\u001a\u00020\fJ\u000e\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020)J\u0010\u0010H\u001a\u00020$2\u0006\u00109\u001a\u00020:H\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006I"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/views/YouTubePlayerSeekBar;", "Landroid/widget/LinearLayout;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isPlaying", "", "newSeekBarProgress", "", "seekBar", "Landroid/widget/SeekBar;", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBarTouchStarted", "showBufferingProgress", "getShowBufferingProgress", "()Z", "setShowBufferingProgress", "(Z)V", "videoCurrentTimeTextView", "Landroid/widget/TextView;", "getVideoCurrentTimeTextView", "()Landroid/widget/TextView;", "videoDurationTextView", "getVideoDurationTextView", "youtubePlayerSeekBarListener", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/views/YouTubePlayerSeekBarListener;", "getYoutubePlayerSeekBarListener", "()Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/views/YouTubePlayerSeekBarListener;", "setYoutubePlayerSeekBarListener", "(Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/views/YouTubePlayerSeekBarListener;)V", "onApiChange", "", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "onCurrentSecond", "second", "", "onError", "error", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerError;", "onPlaybackQualityChange", "playbackQuality", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackQuality;", "onPlaybackRateChange", "playbackRate", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackRate;", "onProgressChanged", "progress", "fromUser", "onReady", "onStartTrackingTouch", "onStateChange", "state", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "onStopTrackingTouch", "onVideoDuration", "duration", "onVideoId", "videoId", "", "onVideoLoadedFraction", "loadedFraction", "resetUi", "setColor", "color", "setFontSize", "fontSize", "updateState", "core_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: YouTubePlayerSeekBar.kt */
public final class YouTubePlayerSeekBar extends LinearLayout implements SeekBar.OnSeekBarChangeListener, YouTubePlayerListener {
    private boolean isPlaying;
    private int newSeekBarProgress;
    private final SeekBar seekBar;
    private boolean seekBarTouchStarted;
    private boolean showBufferingProgress;
    private final TextView videoCurrentTimeTextView;
    private final TextView videoDurationTextView;
    private YouTubePlayerSeekBarListener youtubePlayerSeekBarListener;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayerConstants.PlayerState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PlayerConstants.PlayerState.ENDED.ordinal()] = 1;
            $EnumSwitchMapping$0[PlayerConstants.PlayerState.PAUSED.ordinal()] = 2;
            $EnumSwitchMapping$0[PlayerConstants.PlayerState.PLAYING.ordinal()] = 3;
            $EnumSwitchMapping$0[PlayerConstants.PlayerState.UNSTARTED.ordinal()] = 4;
        }
    }

    public void onApiChange(YouTubePlayer youTubePlayer) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
    }

    public void onError(YouTubePlayer youTubePlayer, PlayerConstants.PlayerError playerError) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
        Intrinsics.checkParameterIsNotNull(playerError, "error");
    }

    public void onPlaybackQualityChange(YouTubePlayer youTubePlayer, PlayerConstants.PlaybackQuality playbackQuality) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
        Intrinsics.checkParameterIsNotNull(playbackQuality, "playbackQuality");
    }

    public void onPlaybackRateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlaybackRate playbackRate) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
        Intrinsics.checkParameterIsNotNull(playbackRate, "playbackRate");
    }

    public void onReady(YouTubePlayer youTubePlayer) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
    }

    public void onVideoId(YouTubePlayer youTubePlayer, String str) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
        Intrinsics.checkParameterIsNotNull(str, "videoId");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public YouTubePlayerSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.newSeekBarProgress = -1;
        this.showBufferingProgress = true;
        this.videoCurrentTimeTextView = new TextView(context);
        this.videoDurationTextView = new TextView(context);
        this.seekBar = new SeekBar(context);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.YouTubePlayerSeekBar, 0, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.YouTubePlayerSeekBar_fontSize, getResources().getDimensionPixelSize(R.dimen.ayp_12sp));
        int color = obtainStyledAttributes.getColor(R.styleable.YouTubePlayerSeekBar_color, ContextCompat.getColor(context, R.color.ayp_red));
        obtainStyledAttributes.recycle();
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ayp_8dp);
        this.videoCurrentTimeTextView.setText(getResources().getString(R.string.ayp_null_time));
        this.videoCurrentTimeTextView.setPadding(dimensionPixelSize2, dimensionPixelSize2, 0, dimensionPixelSize2);
        this.videoCurrentTimeTextView.setTextColor(ContextCompat.getColor(context, 17170443));
        this.videoCurrentTimeTextView.setGravity(16);
        this.videoDurationTextView.setText(getResources().getString(R.string.ayp_null_time));
        this.videoDurationTextView.setPadding(0, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
        this.videoDurationTextView.setTextColor(ContextCompat.getColor(context, 17170443));
        this.videoDurationTextView.setGravity(16);
        setFontSize((float) dimensionPixelSize);
        int i = dimensionPixelSize2 * 2;
        this.seekBar.setPadding(i, dimensionPixelSize2, i, dimensionPixelSize2);
        setColor(color);
        addView(this.videoCurrentTimeTextView, new LinearLayout.LayoutParams(-2, -2));
        addView(this.seekBar, new LinearLayout.LayoutParams(0, -2, 1.0f));
        addView(this.videoDurationTextView, new LinearLayout.LayoutParams(-2, -2));
        setGravity(16);
        this.seekBar.setOnSeekBarChangeListener(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ YouTubePlayerSeekBar(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final boolean getShowBufferingProgress() {
        return this.showBufferingProgress;
    }

    public final void setShowBufferingProgress(boolean z) {
        this.showBufferingProgress = z;
    }

    public final YouTubePlayerSeekBarListener getYoutubePlayerSeekBarListener() {
        return this.youtubePlayerSeekBarListener;
    }

    public final void setYoutubePlayerSeekBarListener(YouTubePlayerSeekBarListener youTubePlayerSeekBarListener) {
        this.youtubePlayerSeekBarListener = youTubePlayerSeekBarListener;
    }

    public final TextView getVideoCurrentTimeTextView() {
        return this.videoCurrentTimeTextView;
    }

    public final TextView getVideoDurationTextView() {
        return this.videoDurationTextView;
    }

    public final SeekBar getSeekBar() {
        return this.seekBar;
    }

    public final void setFontSize(float f) {
        this.videoCurrentTimeTextView.setTextSize(0, f);
        this.videoDurationTextView.setTextSize(0, f);
    }

    public final void setColor(int i) {
        DrawableCompat.setTint(this.seekBar.getThumb(), i);
        DrawableCompat.setTint(this.seekBar.getProgressDrawable(), i);
    }

    private final void updateState(PlayerConstants.PlayerState playerState) {
        int i = WhenMappings.$EnumSwitchMapping$0[playerState.ordinal()];
        if (i == 1) {
            this.isPlaying = false;
        } else if (i == 2) {
            this.isPlaying = false;
        } else if (i == 3) {
            this.isPlaying = true;
        } else if (i == 4) {
            resetUi();
        }
    }

    private final void resetUi() {
        this.seekBar.setProgress(0);
        this.seekBar.setMax(0);
        this.videoDurationTextView.post(new YouTubePlayerSeekBar$resetUi$1(this));
    }

    public void onProgressChanged(SeekBar seekBar2, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(seekBar2, "seekBar");
        this.videoCurrentTimeTextView.setText(TimeUtilities.formatTime((float) i));
    }

    public void onStartTrackingTouch(SeekBar seekBar2) {
        Intrinsics.checkParameterIsNotNull(seekBar2, "seekBar");
        this.seekBarTouchStarted = true;
    }

    public void onStopTrackingTouch(SeekBar seekBar2) {
        Intrinsics.checkParameterIsNotNull(seekBar2, "seekBar");
        if (this.isPlaying) {
            this.newSeekBarProgress = seekBar2.getProgress();
        }
        YouTubePlayerSeekBarListener youTubePlayerSeekBarListener = this.youtubePlayerSeekBarListener;
        if (youTubePlayerSeekBarListener != null) {
            youTubePlayerSeekBarListener.seekTo((float) seekBar2.getProgress());
        }
        this.seekBarTouchStarted = false;
    }

    public void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState playerState) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
        Intrinsics.checkParameterIsNotNull(playerState, "state");
        this.newSeekBarProgress = -1;
        updateState(playerState);
    }

    public void onCurrentSecond(YouTubePlayer youTubePlayer, float f) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
        if (!this.seekBarTouchStarted) {
            if (this.newSeekBarProgress <= 0 || !(!Intrinsics.areEqual((Object) TimeUtilities.formatTime(f), (Object) TimeUtilities.formatTime((float) this.newSeekBarProgress)))) {
                this.newSeekBarProgress = -1;
                this.seekBar.setProgress((int) f);
            }
        }
    }

    public void onVideoDuration(YouTubePlayer youTubePlayer, float f) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
        this.videoDurationTextView.setText(TimeUtilities.formatTime(f));
        this.seekBar.setMax((int) f);
    }

    public void onVideoLoadedFraction(YouTubePlayer youTubePlayer, float f) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
        if (this.showBufferingProgress) {
            SeekBar seekBar2 = this.seekBar;
            seekBar2.setSecondaryProgress((int) (f * ((float) seekBar2.getMax())));
            return;
        }
        this.seekBar.setSecondaryProgress(0);
    }
}
