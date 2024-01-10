package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
/* compiled from: WebViewYouTubePlayer.kt */
final class WebViewYouTubePlayer$seekTo$1 implements Runnable {
    final /* synthetic */ float $time;
    final /* synthetic */ WebViewYouTubePlayer this$0;

    WebViewYouTubePlayer$seekTo$1(WebViewYouTubePlayer webViewYouTubePlayer, float f) {
        this.this$0 = webViewYouTubePlayer;
        this.$time = f;
    }

    public final void run() {
        WebViewYouTubePlayer webViewYouTubePlayer = this.this$0;
        webViewYouTubePlayer.loadUrl("javascript:seekTo(" + this.$time + ')');
    }
}
