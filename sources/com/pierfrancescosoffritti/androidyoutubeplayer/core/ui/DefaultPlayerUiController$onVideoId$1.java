package com.pierfrancescosoffritti.androidyoutubeplayer.core.ui;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 15})
/* compiled from: DefaultPlayerUiController.kt */
final class DefaultPlayerUiController$onVideoId$1 implements View.OnClickListener {
    final /* synthetic */ String $videoId;
    final /* synthetic */ DefaultPlayerUiController this$0;

    DefaultPlayerUiController$onVideoId$1(DefaultPlayerUiController defaultPlayerUiController, String str) {
        this.this$0 = defaultPlayerUiController;
        this.$videoId = str;
    }

    public final void onClick(View view) {
        try {
            this.this$0.youTubeButton.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + this.$videoId + "#t=" + this.this$0.youtubePlayerSeekBar.getSeekBar().getProgress())));
        } catch (Exception e) {
            String simpleName = this.this$0.getClass().getSimpleName();
            String message = e.getMessage();
            if (message == null) {
                message = "Can't open url to YouTube";
            }
            Log.e(simpleName, message);
        }
    }
}
