package com.pierfrancescosoffritti.androidyoutubeplayer.core.player;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
/* compiled from: YouTubePlayerBridge.kt */
final class YouTubePlayerBridge$sendPlaybackQualityChange$1 implements Runnable {
    final /* synthetic */ PlayerConstants.PlaybackQuality $playbackQuality;
    final /* synthetic */ YouTubePlayerBridge this$0;

    YouTubePlayerBridge$sendPlaybackQualityChange$1(YouTubePlayerBridge youTubePlayerBridge, PlayerConstants.PlaybackQuality playbackQuality) {
        this.this$0 = youTubePlayerBridge;
        this.$playbackQuality = playbackQuality;
    }

    public final void run() {
        for (YouTubePlayerListener onPlaybackQualityChange : this.this$0.youTubePlayerOwner.getListeners()) {
            onPlaybackQualityChange.onPlaybackQualityChange(this.this$0.youTubePlayerOwner.getInstance(), this.$playbackQuality);
        }
    }
}
