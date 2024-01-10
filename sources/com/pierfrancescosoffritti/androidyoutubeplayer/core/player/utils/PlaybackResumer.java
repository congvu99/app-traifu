package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0006\u0010\u0012\u001a\u00020\rJ\u0006\u0010\u0013\u001a\u00020\rJ\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/PlaybackResumer;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/AbstractYouTubePlayerListener;", "()V", "canLoad", "", "currentSecond", "", "currentVideoId", "", "error", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerError;", "isPlaying", "onCurrentSecond", "", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "second", "onError", "onLifecycleResume", "onLifecycleStop", "onStateChange", "state", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "onVideoId", "videoId", "resume", "core_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: PlaybackResumer.kt */
public final class PlaybackResumer extends AbstractYouTubePlayerListener {
    private boolean canLoad;
    private float currentSecond;
    private String currentVideoId;
    private PlayerConstants.PlayerError error;
    private boolean isPlaying;

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

    public final void resume(YouTubePlayer youTubePlayer) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
        String str = this.currentVideoId;
        if (str != null) {
            if (this.isPlaying && this.error == PlayerConstants.PlayerError.HTML_5_PLAYER) {
                YouTubePlayerUtils.loadOrCueVideo(youTubePlayer, this.canLoad, str, this.currentSecond);
            } else if (!this.isPlaying && this.error == PlayerConstants.PlayerError.HTML_5_PLAYER) {
                youTubePlayer.cueVideo(str, this.currentSecond);
            }
        }
        this.error = null;
    }

    public void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState playerState) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
        Intrinsics.checkParameterIsNotNull(playerState, "state");
        int i = WhenMappings.$EnumSwitchMapping$0[playerState.ordinal()];
        if (i == 1) {
            this.isPlaying = false;
        } else if (i == 2) {
            this.isPlaying = false;
        } else if (i == 3) {
            this.isPlaying = true;
        }
    }

    public void onError(YouTubePlayer youTubePlayer, PlayerConstants.PlayerError playerError) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
        Intrinsics.checkParameterIsNotNull(playerError, "error");
        if (playerError == PlayerConstants.PlayerError.HTML_5_PLAYER) {
            this.error = playerError;
        }
    }

    public void onCurrentSecond(YouTubePlayer youTubePlayer, float f) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
        this.currentSecond = f;
    }

    public void onVideoId(YouTubePlayer youTubePlayer, String str) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
        Intrinsics.checkParameterIsNotNull(str, "videoId");
        this.currentVideoId = str;
    }

    public final void onLifecycleResume() {
        this.canLoad = true;
    }

    public final void onLifecycleStop() {
        this.canLoad = false;
    }
}
