package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views;

import android.graphics.Bitmap;
import android.webkit.WebChromeClient;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/WebViewYouTubePlayer$initWebView$1", "Landroid/webkit/WebChromeClient;", "getDefaultVideoPoster", "Landroid/graphics/Bitmap;", "core_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: WebViewYouTubePlayer.kt */
public final class WebViewYouTubePlayer$initWebView$1 extends WebChromeClient {
    WebViewYouTubePlayer$initWebView$1() {
    }

    public Bitmap getDefaultVideoPoster() {
        Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
        return defaultVideoPoster != null ? defaultVideoPoster : Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
    }
}
