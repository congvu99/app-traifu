package com.pierfrancescosoffritti.androidyoutubeplayer.core.player;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
/* compiled from: YouTubePlayerBridge.kt */
final class YouTubePlayerBridge$sendVideoCurrentTime$1 implements Runnable {
    final /* synthetic */ float $currentTimeSeconds;
    final /* synthetic */ YouTubePlayerBridge this$0;

    YouTubePlayerBridge$sendVideoCurrentTime$1(YouTubePlayerBridge youTubePlayerBridge, float f) {
        this.this$0 = youTubePlayerBridge;
        this.$currentTimeSeconds = f;
    }

    public final void run() {
        for (YouTubePlayerListener onCurrentSecond : this.this$0.youTubePlayerOwner.getListeners()) {
            onCurrentSecond.onCurrentSecond(this.this$0.youTubePlayerOwner.getInstance(), this.$currentTimeSeconds);
        }
    }
}
