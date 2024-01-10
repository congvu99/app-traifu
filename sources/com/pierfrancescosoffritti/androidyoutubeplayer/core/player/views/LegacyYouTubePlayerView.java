package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views;

import android.content.Context;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.pierfrancescosoffritti.androidyoutubeplayer.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.FullScreenHelper;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.NetworkListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.PlaybackResumer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.DefaultPlayerUiController;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.PlayerUiController;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\rJ\u0006\u0010.\u001a\u00020\u0017J\u0006\u0010/\u001a\u00020\u0017J\u0006\u00100\u001a\u000201J\u000e\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020'J\u0010\u00104\u001a\u0002052\b\b\u0001\u00106\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u00172\u0006\u00107\u001a\u000208J\u0016\u0010\u0015\u001a\u00020\u00172\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\rJ \u0010\u0015\u001a\u00020\u00172\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\r2\b\u0010:\u001a\u0004\u0018\u00010;J\u0016\u0010<\u001a\u00020\u00172\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\rJ\r\u0010=\u001a\u00020\rH\u0000¢\u0006\u0002\b>J\u0006\u0010?\u001a\u00020\rJ\r\u0010@\u001a\u00020\u0017H\u0001¢\u0006\u0002\bAJ\r\u0010B\u001a\u00020\u0017H\u0001¢\u0006\u0002\bCJ\b\u0010D\u001a\u00020\u0017H\u0007J\u000e\u0010E\u001a\u00020\r2\u0006\u0010*\u001a\u00020+J\u0006\u0010F\u001a\u00020\u0017R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u001a\u0010\u0019\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\"X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001e\u0010%\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(X\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/LegacyYouTubePlayerView;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/SixteenByNineFrameLayout;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "canPlay", "getCanPlay$core_release", "()Z", "defaultPlayerUiController", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/DefaultPlayerUiController;", "fullScreenHelper", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/FullScreenHelper;", "initialize", "Lkotlin/Function0;", "", "isUsingCustomUi", "isYouTubePlayerReady", "isYouTubePlayerReady$core_release", "setYouTubePlayerReady$core_release", "(Z)V", "networkListener", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/NetworkListener;", "playbackResumer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/PlaybackResumer;", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/WebViewYouTubePlayer;", "getYouTubePlayer$core_release", "()Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/WebViewYouTubePlayer;", "youTubePlayerCallbacks", "Ljava/util/HashSet;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerCallback;", "Lkotlin/collections/HashSet;", "addFullScreenListener", "fullScreenListener", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerFullScreenListener;", "enableBackgroundPlayback", "enable", "enterFullScreen", "exitFullScreen", "getPlayerUiController", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/PlayerUiController;", "getYouTubePlayerWhenReady", "youTubePlayerCallback", "inflateCustomPlayerUi", "Landroid/view/View;", "layoutId", "youTubePlayerListener", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerListener;", "handleNetworkEvents", "playerOptions", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions;", "initializeWithWebUi", "isEligibleForPlayback", "isEligibleForPlayback$core_release", "isFullScreen", "onResume", "onResume$core_release", "onStop", "onStop$core_release", "release", "removeFullScreenListener", "toggleFullScreen", "core_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: LegacyYouTubePlayerView.kt */
public final class LegacyYouTubePlayerView extends SixteenByNineFrameLayout implements LifecycleObserver {
    private boolean canPlay;
    private final DefaultPlayerUiController defaultPlayerUiController;
    private final FullScreenHelper fullScreenHelper;
    /* access modifiers changed from: private */
    public Function0<Unit> initialize;
    private boolean isUsingCustomUi;
    private boolean isYouTubePlayerReady;
    private final NetworkListener networkListener;
    /* access modifiers changed from: private */
    public final PlaybackResumer playbackResumer;
    private final WebViewYouTubePlayer youTubePlayer;
    /* access modifiers changed from: private */
    public final HashSet<YouTubePlayerCallback> youTubePlayerCallbacks;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LegacyYouTubePlayerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LegacyYouTubePlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.youTubePlayer = new WebViewYouTubePlayer(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.networkListener = new NetworkListener();
        this.playbackResumer = new PlaybackResumer();
        this.fullScreenHelper = new FullScreenHelper(this);
        this.initialize = LegacyYouTubePlayerView$initialize$1.INSTANCE;
        this.youTubePlayerCallbacks = new HashSet<>();
        this.canPlay = true;
        addView(this.youTubePlayer, new FrameLayout.LayoutParams(-1, -1));
        DefaultPlayerUiController defaultPlayerUiController2 = new DefaultPlayerUiController(this, this.youTubePlayer);
        this.defaultPlayerUiController = defaultPlayerUiController2;
        this.fullScreenHelper.addFullScreenListener(defaultPlayerUiController2);
        this.youTubePlayer.addListener(this.defaultPlayerUiController);
        this.youTubePlayer.addListener(this.playbackResumer);
        this.youTubePlayer.addListener(new AbstractYouTubePlayerListener(this) {
            final /* synthetic */ LegacyYouTubePlayerView this$0;

            {
                this.this$0 = r1;
            }

            public void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState playerState) {
                Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
                Intrinsics.checkParameterIsNotNull(playerState, "state");
                if (playerState == PlayerConstants.PlayerState.PLAYING && !this.this$0.isEligibleForPlayback$core_release()) {
                    youTubePlayer.pause();
                }
            }
        });
        this.youTubePlayer.addListener(new AbstractYouTubePlayerListener(this) {
            final /* synthetic */ LegacyYouTubePlayerView this$0;

            {
                this.this$0 = r1;
            }

            public void onReady(YouTubePlayer youTubePlayer) {
                Intrinsics.checkParameterIsNotNull(youTubePlayer, "youTubePlayer");
                this.this$0.setYouTubePlayerReady$core_release(true);
                for (YouTubePlayerCallback onYouTubePlayer : this.this$0.youTubePlayerCallbacks) {
                    onYouTubePlayer.onYouTubePlayer(youTubePlayer);
                }
                this.this$0.youTubePlayerCallbacks.clear();
                youTubePlayer.removeListener(this);
            }
        });
        this.networkListener.setOnNetworkAvailable(new Function0<Unit>(this) {
            final /* synthetic */ LegacyYouTubePlayerView this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                if (!this.this$0.isYouTubePlayerReady$core_release()) {
                    this.this$0.initialize.invoke();
                } else {
                    this.this$0.playbackResumer.resume(this.this$0.getYouTubePlayer$core_release());
                }
            }
        });
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LegacyYouTubePlayerView(Context context) {
        this(context, (AttributeSet) null, 0);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LegacyYouTubePlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LegacyYouTubePlayerView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final WebViewYouTubePlayer getYouTubePlayer$core_release() {
        return this.youTubePlayer;
    }

    public final boolean isYouTubePlayerReady$core_release() {
        return this.isYouTubePlayerReady;
    }

    public final void setYouTubePlayerReady$core_release(boolean z) {
        this.isYouTubePlayerReady = z;
    }

    public final boolean getCanPlay$core_release() {
        return this.canPlay;
    }

    public final boolean isUsingCustomUi() {
        return this.isUsingCustomUi;
    }

    public final void initialize(YouTubePlayerListener youTubePlayerListener, boolean z, IFramePlayerOptions iFramePlayerOptions) {
        Intrinsics.checkParameterIsNotNull(youTubePlayerListener, "youTubePlayerListener");
        if (!this.isYouTubePlayerReady) {
            if (z) {
                getContext().registerReceiver(this.networkListener, new IntentFilter(BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION));
            }
            Function0<Unit> legacyYouTubePlayerView$initialize$2 = new LegacyYouTubePlayerView$initialize$2(this, youTubePlayerListener, iFramePlayerOptions);
            this.initialize = legacyYouTubePlayerView$initialize$2;
            if (!z) {
                legacyYouTubePlayerView$initialize$2.invoke();
                return;
            }
            return;
        }
        throw new IllegalStateException("This YouTubePlayerView has already been initialized.");
    }

    public final void initialize(YouTubePlayerListener youTubePlayerListener, boolean z) {
        Intrinsics.checkParameterIsNotNull(youTubePlayerListener, "youTubePlayerListener");
        initialize(youTubePlayerListener, z, (IFramePlayerOptions) null);
    }

    public final void initialize(YouTubePlayerListener youTubePlayerListener) {
        Intrinsics.checkParameterIsNotNull(youTubePlayerListener, "youTubePlayerListener");
        initialize(youTubePlayerListener, true);
    }

    public final void initializeWithWebUi(YouTubePlayerListener youTubePlayerListener, boolean z) {
        Intrinsics.checkParameterIsNotNull(youTubePlayerListener, "youTubePlayerListener");
        IFramePlayerOptions build = new IFramePlayerOptions.Builder().controls(1).build();
        inflateCustomPlayerUi(R.layout.ayp_empty_layout);
        initialize(youTubePlayerListener, z, build);
    }

    public final void getYouTubePlayerWhenReady(YouTubePlayerCallback youTubePlayerCallback) {
        Intrinsics.checkParameterIsNotNull(youTubePlayerCallback, "youTubePlayerCallback");
        if (this.isYouTubePlayerReady) {
            youTubePlayerCallback.onYouTubePlayer(this.youTubePlayer);
        } else {
            this.youTubePlayerCallbacks.add(youTubePlayerCallback);
        }
    }

    public final View inflateCustomPlayerUi(int i) {
        removeViews(1, getChildCount() - 1);
        if (!this.isUsingCustomUi) {
            this.youTubePlayer.removeListener(this.defaultPlayerUiController);
            this.fullScreenHelper.removeFullScreenListener(this.defaultPlayerUiController);
        }
        this.isUsingCustomUi = true;
        View inflate = View.inflate(getContext(), i, this);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "View.inflate(context, layoutId, this)");
        return inflate;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void release() {
        removeView(this.youTubePlayer);
        this.youTubePlayer.removeAllViews();
        this.youTubePlayer.destroy();
        try {
            getContext().unregisterReceiver(this.networkListener);
        } catch (Exception unused) {
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume$core_release() {
        this.playbackResumer.onLifecycleResume();
        this.canPlay = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop$core_release() {
        this.youTubePlayer.pause();
        this.playbackResumer.onLifecycleStop();
        this.canPlay = false;
    }

    public final boolean isEligibleForPlayback$core_release() {
        return this.canPlay || this.youTubePlayer.isBackgroundPlaybackEnabled$core_release();
    }

    public final void enableBackgroundPlayback(boolean z) {
        this.youTubePlayer.setBackgroundPlaybackEnabled$core_release(z);
    }

    public final PlayerUiController getPlayerUiController() {
        if (!this.isUsingCustomUi) {
            return this.defaultPlayerUiController;
        }
        throw new RuntimeException("You have inflated a custom player Ui. You must manage it with your own controller.");
    }

    public final void enterFullScreen() {
        this.fullScreenHelper.enterFullScreen();
    }

    public final void exitFullScreen() {
        this.fullScreenHelper.exitFullScreen();
    }

    public final void toggleFullScreen() {
        this.fullScreenHelper.toggleFullScreen();
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
