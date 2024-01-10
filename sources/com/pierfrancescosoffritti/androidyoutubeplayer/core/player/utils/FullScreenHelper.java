package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils;

import android.view.View;
import android.view.ViewGroup;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/FullScreenHelper;", "", "targetView", "Landroid/view/View;", "(Landroid/view/View;)V", "fullScreenListeners", "", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerFullScreenListener;", "<set-?>", "", "isFullScreen", "()Z", "addFullScreenListener", "fullScreenListener", "enterFullScreen", "", "exitFullScreen", "removeFullScreenListener", "toggleFullScreen", "core_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: FullScreenHelper.kt */
public final class FullScreenHelper {
    private final Set<YouTubePlayerFullScreenListener> fullScreenListeners = new HashSet();
    private boolean isFullScreen;
    private final View targetView;

    public FullScreenHelper(View view) {
        Intrinsics.checkParameterIsNotNull(view, "targetView");
        this.targetView = view;
    }

    public final boolean isFullScreen() {
        return this.isFullScreen;
    }

    public final void enterFullScreen() {
        if (!this.isFullScreen) {
            this.isFullScreen = true;
            ViewGroup.LayoutParams layoutParams = this.targetView.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -1;
            this.targetView.setLayoutParams(layoutParams);
            for (YouTubePlayerFullScreenListener onYouTubePlayerEnterFullScreen : this.fullScreenListeners) {
                onYouTubePlayerEnterFullScreen.onYouTubePlayerEnterFullScreen();
            }
        }
    }

    public final void exitFullScreen() {
        if (this.isFullScreen) {
            this.isFullScreen = false;
            ViewGroup.LayoutParams layoutParams = this.targetView.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -1;
            this.targetView.setLayoutParams(layoutParams);
            for (YouTubePlayerFullScreenListener onYouTubePlayerExitFullScreen : this.fullScreenListeners) {
                onYouTubePlayerExitFullScreen.onYouTubePlayerExitFullScreen();
            }
        }
    }

    public final void toggleFullScreen() {
        if (this.isFullScreen) {
            exitFullScreen();
        } else {
            enterFullScreen();
        }
    }

    public final boolean addFullScreenListener(YouTubePlayerFullScreenListener youTubePlayerFullScreenListener) {
        Intrinsics.checkParameterIsNotNull(youTubePlayerFullScreenListener, "fullScreenListener");
        return this.fullScreenListeners.add(youTubePlayerFullScreenListener);
    }

    public final boolean removeFullScreenListener(YouTubePlayerFullScreenListener youTubePlayerFullScreenListener) {
        Intrinsics.checkParameterIsNotNull(youTubePlayerFullScreenListener, "fullScreenListener");
        return this.fullScreenListeners.remove(youTubePlayerFullScreenListener);
    }
}
