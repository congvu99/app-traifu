package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView$youTubePlayerListener$1", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/AbstractYouTubePlayerListener;", "onReady", "", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "core_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: YouTubePlayerView.kt */
public final class YouTubePlayerView$youTubePlayerListener$1 extends AbstractYouTubePlayerListener {
    final /* synthetic */ boolean $autoPlay;
    final /* synthetic */ String $videoId;
    final /* synthetic */ YouTubePlayerView this$0;

    YouTubePlayerView$youTubePlayerListener$1(YouTubePlayerView youTubePlayerView, String str, boolean z) {
        this.this$0 = youTubePlayerView;
        this.$videoId = str;
        this.$autoPlay = z;
    }

    public void onReady(YouTubePlayer youTubePlayer) {
        Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
        if (this.$videoId != null) {
            YouTubePlayerUtils.loadOrCueVideo(youTubePlayer, this.this$0.legacyTubePlayerView.getCanPlay$core_release() && this.$autoPlay, this.$videoId, 0.0f);
        }
        youTubePlayer.removeListener(this);
    }
}
