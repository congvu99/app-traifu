package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.pierfrancescosoffritti.androidyoutubeplayer.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.FullScreenHelper;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.PlayerUiController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010\u001f\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u001dJ\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020'2\b\b\u0001\u0010(\u001a\u00020\nJ\u000e\u0010)\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010)\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\rJ \u0010)\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010,J\u0016\u0010-\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\rJ\u0006\u0010.\u001a\u00020\rJ\b\u0010/\u001a\u00020\u001dH\u0003J\b\u00100\u001a\u00020\u001dH\u0003J\b\u00101\u001a\u00020\u001dH\u0007J\u000e\u00102\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u00103\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u00104\u001a\u00020\u001dR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/SixteenByNineFrameLayout;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "enableAutomaticInitialization", "", "getEnableAutomaticInitialization", "()Z", "setEnableAutomaticInitialization", "(Z)V", "fullScreenHelper", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/FullScreenHelper;", "legacyTubePlayerView", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/LegacyYouTubePlayerView;", "addFullScreenListener", "fullScreenListener", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerFullScreenListener;", "addYouTubePlayerListener", "youTubePlayerListener", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerListener;", "enableBackgroundPlayback", "", "enable", "enterFullScreen", "exitFullScreen", "getPlayerUiController", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/PlayerUiController;", "getYouTubePlayerWhenReady", "youTubePlayerCallback", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerCallback;", "inflateCustomPlayerUi", "Landroid/view/View;", "layoutId", "initialize", "handleNetworkEvents", "playerOptions", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions;", "initializeWithWebUi", "isFullScreen", "onResume", "onStop", "release", "removeFullScreenListener", "removeYouTubePlayerListener", "toggleFullScreen", "core_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: YouTubePlayerView.kt */
public final class YouTubePlayerView extends SixteenByNineFrameLayout implements LifecycleObserver {
    private boolean enableAutomaticInitialization;
    /* access modifiers changed from: private */
    public final FullScreenHelper fullScreenHelper;
    /* access modifiers changed from: private */
    public final LegacyYouTubePlayerView legacyTubePlayerView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ YouTubePlayerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public YouTubePlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.legacyTubePlayerView = new LegacyYouTubePlayerView(context);
        this.fullScreenHelper = new FullScreenHelper(this);
        addView(this.legacyTubePlayerView, new FrameLayout.LayoutParams(-1, -1));
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.YouTubePlayerView, 0, 0);
        this.enableAutomaticInitialization = obtainStyledAttributes.getBoolean(R.styleable.YouTubePlayerView_enableAutomaticInitialization, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.YouTubePlayerView_autoPlay, false);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.YouTubePlayerView_handleNetworkEvents, true);
        String string = obtainStyledAttributes.getString(R.styleable.YouTubePlayerView_videoId);
        boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.YouTubePlayerView_useWebUi, false);
        boolean z4 = obtainStyledAttributes.getBoolean(R.styleable.YouTubePlayerView_enableLiveVideoUi, false);
        boolean z5 = obtainStyledAttributes.getBoolean(R.styleable.YouTubePlayerView_showYouTubeButton, true);
        boolean z6 = obtainStyledAttributes.getBoolean(R.styleable.YouTubePlayerView_showFullScreenButton, true);
        boolean z7 = obtainStyledAttributes.getBoolean(R.styleable.YouTubePlayerView_showVideoCurrentTime, true);
        boolean z8 = obtainStyledAttributes.getBoolean(R.styleable.YouTubePlayerView_showVideoDuration, true);
        boolean z9 = obtainStyledAttributes.getBoolean(R.styleable.YouTubePlayerView_showSeekBar, true);
        obtainStyledAttributes.recycle();
        if (!this.enableAutomaticInitialization && z3) {
            throw new IllegalStateException("YouTubePlayerView: 'enableAutomaticInitialization' is false and 'useWebUi' is set to true. This is not possible, if you want to manually initialize YouTubePlayerView and use the web ui, you should manually initialize the YouTubePlayerView using 'initializeWithWebUi'");
        } else if (string != null || !z) {
            if (!z3) {
                this.legacyTubePlayerView.getPlayerUiController().enableLiveVideoUi(z4).showYouTubeButton(z5).showFullscreenButton(z6).showCurrentTime(z7).showDuration(z8).showSeekBar(z9);
            }
            YouTubePlayerView$youTubePlayerListener$1 youTubePlayerView$youTubePlayerListener$1 = new YouTubePlayerView$youTubePlayerListener$1(this, string, z);
            if (this.enableAutomaticInitialization) {
                if (z3) {
                    this.legacyTubePlayerView.initializeWithWebUi(youTubePlayerView$youTubePlayerListener$1, z2);
                } else {
                    this.legacyTubePlayerView.initialize(youTubePlayerView$youTubePlayerListener$1, z2);
                }
            }
            this.legacyTubePlayerView.addFullScreenListener(new YouTubePlayerFullScreenListener(this) {
                final /* synthetic */ YouTubePlayerView this$0;

                {
                    this.this$0 = r1;
                }

                public void onYouTubePlayerEnterFullScreen() {
                    this.this$0.fullScreenHelper.enterFullScreen();
                }

                public void onYouTubePlayerExitFullScreen() {
                    this.this$0.fullScreenHelper.exitFullScreen();
                }
            });
        } else {
            throw new IllegalStateException("YouTubePlayerView: videoId is not set but autoPlay is set to true. This combination is not possible.");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public YouTubePlayerView(Context context) {
        this(context, (AttributeSet) null, 0);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public YouTubePlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ YouTubePlayerView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final boolean getEnableAutomaticInitialization() {
        return this.enableAutomaticInitialization;
    }

    public final void setEnableAutomaticInitialization(boolean z) {
        this.enableAutomaticInitialization = z;
    }

    public final void initialize(YouTubePlayerListener youTubePlayerListener, boolean z, IFramePlayerOptions iFramePlayerOptions) {
        Intrinsics.checkParameterIsNotNull(youTubePlayerListener, "youTubePlayerListener");
        if (!this.enableAutomaticInitialization) {
            this.legacyTubePlayerView.initialize(youTubePlayerListener, z, iFramePlayerOptions);
            return;
        }
        throw new IllegalStateException("YouTubePlayerView: If you want to initialize this view manually, you need to set 'enableAutomaticInitialization' to false");
    }

    public final void initialize(YouTubePlayerListener youTubePlayerListener, boolean z) {
        Intrinsics.checkParameterIsNotNull(youTubePlayerListener, "youTubePlayerListener");
        if (!this.enableAutomaticInitialization) {
            this.legacyTubePlayerView.initialize(youTubePlayerListener, z, (IFramePlayerOptions) null);
            return;
        }
        throw new IllegalStateException("YouTubePlayerView: If you want to initialize this view manually, you need to set 'enableAutomaticInitialization' to false");
    }

    public final void initialize(YouTubePlayerListener youTubePlayerListener) {
        Intrinsics.checkParameterIsNotNull(youTubePlayerListener, "youTubePlayerListener");
        if (!this.enableAutomaticInitialization) {
            this.legacyTubePlayerView.initialize(youTubePlayerListener, true);
            return;
        }
        throw new IllegalStateException("YouTubePlayerView: If you want to initialize this view manually, you need to set 'enableAutomaticInitialization' to false");
    }

    public final void initializeWithWebUi(YouTubePlayerListener youTubePlayerListener, boolean z) {
        Intrinsics.checkParameterIsNotNull(youTubePlayerListener, "youTubePlayerListener");
        if (!this.enableAutomaticInitialization) {
            this.legacyTubePlayerView.initializeWithWebUi(youTubePlayerListener, z);
            return;
        }
        throw new IllegalStateException("YouTubePlayerView: If you want to initialize this view manually, you need to set 'enableAutomaticInitialization' to false");
    }

    public final void getYouTubePlayerWhenReady(YouTubePlayerCallback youTubePlayerCallback) {
        Intrinsics.checkParameterIsNotNull(youTubePlayerCallback, "youTubePlayerCallback");
        this.legacyTubePlayerView.getYouTubePlayerWhenReady(youTubePlayerCallback);
    }

    public final View inflateCustomPlayerUi(int i) {
        return this.legacyTubePlayerView.inflateCustomPlayerUi(i);
    }

    public final PlayerUiController getPlayerUiController() {
        return this.legacyTubePlayerView.getPlayerUiController();
    }

    public final void enableBackgroundPlayback(boolean z) {
        this.legacyTubePlayerView.enableBackgroundPlayback(z);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void release() {
        this.legacyTubePlayerView.release();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private final void onResume() {
        this.legacyTubePlayerView.onResume$core_release();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private final void onStop() {
        this.legacyTubePlayerView.onStop$core_release();
    }

    public final boolean addYouTubePlayerListener(YouTubePlayerListener youTubePlayerListener) {
        Intrinsics.checkParameterIsNotNull(youTubePlayerListener, "youTubePlayerListener");
        return this.legacyTubePlayerView.getYouTubePlayer$core_release().addListener(youTubePlayerListener);
    }

    public final boolean removeYouTubePlayerListener(YouTubePlayerListener youTubePlayerListener) {
        Intrinsics.checkParameterIsNotNull(youTubePlayerListener, "youTubePlayerListener");
        return this.legacyTubePlayerView.getYouTubePlayer$core_release().removeListener(youTubePlayerListener);
    }

    public final void enterFullScreen() {
        this.legacyTubePlayerView.enterFullScreen();
    }

    public final void exitFullScreen() {
        this.legacyTubePlayerView.exitFullScreen();
    }

    public final void toggleFullScreen() {
        this.legacyTubePlayerView.toggleFullScreen();
    }

    public final boolean isFullScreen() {
        return this.fullScreenHelper.isFullScreen();
    }

    public final boolean addFullScreenListener(YouTubePlayerFullScreenListener youTubePlayerFullScreenListener) {
        Intrinsics.checkParameterIsNotNull(youTubePlayerFullScreenListener, "fullScreenListener");
        return this.fullScreenHelper.addFullScreenListener(youTubePlayerFullScreenListener);
    }

    public final boolean removeFullScreenListener(YouTubePlayerFullScreenListener youTubePlayerFullScreenListener) {
        Intrinsics.checkParameterIsNotNull(youTubePlayerFullScreenListener, "fullScreenListener");
        return this.fullScreenHelper.removeFullScreenListener(youTubePlayerFullScreenListener);
    }
}
