package com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.utils;

import android.os.Handler;
import android.view.View;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 92\u00020\u0001:\u00019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001dH\u0016J\u0018\u0010#\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010&\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010'\u001a\u00020(H\u0016J\u0018\u0010)\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010-\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00101\u001a\u00020\u001dH\u0016J\u0018\u00102\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00106\u001a\u00020\u001dH\u0016J\u0006\u00107\u001a\u00020\u001bJ\u0010\u00108\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020/H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\u001a\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006:"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/utils/FadeViewHelper;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerListener;", "targetView", "Landroid/view/View;", "(Landroid/view/View;)V", "animationDuration", "", "getAnimationDuration", "()J", "setAnimationDuration", "(J)V", "canFade", "", "fadeOut", "Ljava/lang/Runnable;", "fadeOutDelay", "getFadeOutDelay", "setFadeOutDelay", "isDisabled", "()Z", "setDisabled", "(Z)V", "isPlaying", "isVisible", "getTargetView", "()Landroid/view/View;", "fade", "", "finalAlpha", "", "onApiChange", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "onCurrentSecond", "second", "onError", "error", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerError;", "onPlaybackQualityChange", "playbackQuality", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackQuality;", "onPlaybackRateChange", "playbackRate", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackRate;", "onReady", "onStateChange", "state", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "onVideoDuration", "duration", "onVideoId", "videoId", "", "onVideoLoadedFraction", "loadedFraction", "toggleVisibility", "updateState", "Companion", "core_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: FadeViewHelper.kt */
public final class FadeViewHelper implements YouTubePlayerListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long DEFAULT_ANIMATION_DURATION = 300;
    public static final long DEFAULT_FADE_OUT_DELAY = 3000;
    private long animationDuration = 300;
    private boolean canFade;
    private Runnable fadeOut = new FadeViewHelper$fadeOut$1(this);
    private long fadeOutDelay = DEFAULT_FADE_OUT_DELAY;
    private boolean isDisabled;
    private boolean isPlaying;
    private boolean isVisible = true;
    private final View targetView;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PlayerConstants.PlayerState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PlayerConstants.PlayerState.ENDED.ordinal()] = 1;
            $EnumSwitchMapping$0[PlayerConstants.PlayerState.PAUSED.ordinal()] = 2;
            $EnumSwitchMapping$0[PlayerConstants.PlayerState.PLAYING.ordinal()] = 3;
            $EnumSwitchMapping$0[PlayerConstants.PlayerState.UNSTARTED.ordinal()] = 4;
            int[] iArr2 = new int[PlayerConstants.PlayerState.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[PlayerConstants.PlayerState.PLAYING.ordinal()] = 1;
            $EnumSwitchMapping$1[PlayerConstants.PlayerState.PAUSED.ordinal()] = 2;
            $EnumSwitchMapping$1[PlayerConstants.PlayerState.VIDEO_CUED.ordinal()] = 3;
            $EnumSwitchMapping$1[PlayerConstants.PlayerState.BUFFERING.ordinal()] = 4;
            $EnumSwitchMapping$1[PlayerConstants.PlayerState.UNSTARTED.ordinal()] = 5;
            $EnumSwitchMapping$1[PlayerConstants.PlayerState.UNKNOWN.ordinal()] = 6;
            $EnumSwitchMapping$1[PlayerConstants.PlayerState.ENDED.ordinal()] = 7;
        }
    }

    public void onApiChange(YouTubePlayer youTubePlayer) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
    }

    public void onCurrentSecond(YouTubePlayer youTubePlayer, float f) {
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

    public void onVideoDuration(YouTubePlayer youTubePlayer, float f) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
    }

    public void onVideoId(YouTubePlayer youTubePlayer, String str) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
        Intrinsics.checkParameterIsNotNull(str, "videoId");
    }

    public void onVideoLoadedFraction(YouTubePlayer youTubePlayer, float f) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/utils/FadeViewHelper$Companion;", "", "()V", "DEFAULT_ANIMATION_DURATION", "", "DEFAULT_FADE_OUT_DELAY", "core_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: FadeViewHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FadeViewHelper(View view) {
        Intrinsics.checkParameterIsNotNull(view, "targetView");
        this.targetView = view;
    }

    public final View getTargetView() {
        return this.targetView;
    }

    public final boolean isDisabled() {
        return this.isDisabled;
    }

    public final void setDisabled(boolean z) {
        this.isDisabled = z;
    }

    public final long getAnimationDuration() {
        return this.animationDuration;
    }

    public final void setAnimationDuration(long j) {
        this.animationDuration = j;
    }

    public final long getFadeOutDelay() {
        return this.fadeOutDelay;
    }

    public final void setFadeOutDelay(long j) {
        this.fadeOutDelay = j;
    }

    public final void toggleVisibility() {
        fade(this.isVisible ? 0.0f : 1.0f);
    }

    /* access modifiers changed from: private */
    public final void fade(float f) {
        if (this.canFade && !this.isDisabled) {
            this.isVisible = f != 0.0f;
            if (f != 1.0f || !this.isPlaying) {
                Handler handler = this.targetView.getHandler();
                if (handler != null) {
                    handler.removeCallbacks(this.fadeOut);
                }
            } else {
                Handler handler2 = this.targetView.getHandler();
                if (handler2 != null) {
                    handler2.postDelayed(this.fadeOut, this.fadeOutDelay);
                }
            }
            this.targetView.animate().alpha(f).setDuration(this.animationDuration).setListener(new FadeViewHelper$fade$1(this, f)).start();
        }
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
    }

    public void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState playerState) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
        Intrinsics.checkParameterIsNotNull(playerState, "state");
        updateState(playerState);
        switch (WhenMappings.$EnumSwitchMapping$1[playerState.ordinal()]) {
            case 1:
            case 2:
            case 3:
                this.canFade = true;
                if (playerState == PlayerConstants.PlayerState.PLAYING) {
                    Handler handler = this.targetView.getHandler();
                    if (handler != null) {
                        handler.postDelayed(this.fadeOut, this.fadeOutDelay);
                        return;
                    }
                    return;
                }
                Handler handler2 = this.targetView.getHandler();
                if (handler2 != null) {
                    handler2.removeCallbacks(this.fadeOut);
                    return;
                }
                return;
            case 4:
            case 5:
                fade(1.0f);
                this.canFade = false;
                return;
            case 6:
                fade(1.0f);
                return;
            case 7:
                fade(1.0f);
                return;
            default:
                return;
        }
    }
}
