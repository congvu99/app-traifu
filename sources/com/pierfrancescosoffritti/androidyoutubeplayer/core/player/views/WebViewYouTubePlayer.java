package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pierfrancescosoffritti.androidyoutubeplayer.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerBridge;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.Utils;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\b\u0010!\u001a\u00020\u0002H\u0016J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180#H\u0016J\u0010\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&H\u0003J+\u0010'\u001a\u00020\u00152\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010%\u001a\u0004\u0018\u00010&H\u0000¢\u0006\u0002\b)J\u0018\u0010*\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010+\u001a\u00020\u0015H\u0016J\u0010\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\tH\u0014J\b\u0010.\u001a\u00020\u0015H\u0016J\b\u0010/\u001a\u00020\u0015H\u0016J\b\u00100\u001a\u00020\u0015H\u0016J\u0010\u00101\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0010\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u001fH\u0016J\u0010\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\tH\u0016J\b\u00106\u001a\u00020\u0015H\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150\u0014X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/WebViewYouTubePlayer;", "Landroid/webkit/WebView;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerBridge$YouTubePlayerBridgeCallbacks;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isBackgroundPlaybackEnabled", "", "isBackgroundPlaybackEnabled$core_release", "()Z", "setBackgroundPlaybackEnabled$core_release", "(Z)V", "mainThreadHandler", "Landroid/os/Handler;", "youTubePlayerInitListener", "Lkotlin/Function1;", "", "youTubePlayerListeners", "Ljava/util/HashSet;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerListener;", "addListener", "listener", "cueVideo", "videoId", "", "startSeconds", "", "destroy", "getInstance", "getListeners", "", "initWebView", "playerOptions", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions;", "initialize", "initListener", "initialize$core_release", "loadVideo", "mute", "onWindowVisibilityChanged", "visibility", "onYouTubeIFrameAPIReady", "pause", "play", "removeListener", "seekTo", "time", "setVolume", "volumePercent", "unMute", "core_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: WebViewYouTubePlayer.kt */
public final class WebViewYouTubePlayer extends WebView implements YouTubePlayer, YouTubePlayerBridge.YouTubePlayerBridgeCallbacks {
    private boolean isBackgroundPlaybackEnabled;
    private final Handler mainThreadHandler;
    private Function1<? super YouTubePlayer, Unit> youTubePlayerInitListener;
    private final HashSet<YouTubePlayerListener> youTubePlayerListeners;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WebViewYouTubePlayer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebViewYouTubePlayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.youTubePlayerListeners = new HashSet<>();
        this.mainThreadHandler = new Handler(Looper.getMainLooper());
    }

    public final boolean isBackgroundPlaybackEnabled$core_release() {
        return this.isBackgroundPlaybackEnabled;
    }

    public final void setBackgroundPlaybackEnabled$core_release(boolean z) {
        this.isBackgroundPlaybackEnabled = z;
    }

    public final void initialize$core_release(Function1<? super YouTubePlayer, Unit> function1, IFramePlayerOptions iFramePlayerOptions) {
        Intrinsics.checkParameterIsNotNull(function1, "initListener");
        this.youTubePlayerInitListener = function1;
        if (iFramePlayerOptions == null) {
            iFramePlayerOptions = IFramePlayerOptions.Companion.getDefault();
        }
        initWebView(iFramePlayerOptions);
    }

    public void onYouTubeIFrameAPIReady() {
        Function1<? super YouTubePlayer, Unit> function1 = this.youTubePlayerInitListener;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("youTubePlayerInitListener");
        }
        function1.invoke(this);
    }

    public YouTubePlayer getInstance() {
        return this;
    }

    public void loadVideo(String str, float f) {
        Intrinsics.checkParameterIsNotNull(str, "videoId");
        this.mainThreadHandler.post(new WebViewYouTubePlayer$loadVideo$1(this, str, f));
    }

    public void cueVideo(String str, float f) {
        Intrinsics.checkParameterIsNotNull(str, "videoId");
        this.mainThreadHandler.post(new WebViewYouTubePlayer$cueVideo$1(this, str, f));
    }

    public void play() {
        this.mainThreadHandler.post(new WebViewYouTubePlayer$play$1(this));
    }

    public void pause() {
        this.mainThreadHandler.post(new WebViewYouTubePlayer$pause$1(this));
    }

    public void mute() {
        this.mainThreadHandler.post(new WebViewYouTubePlayer$mute$1(this));
    }

    public void unMute() {
        this.mainThreadHandler.post(new WebViewYouTubePlayer$unMute$1(this));
    }

    public void setVolume(int i) {
        if (i >= 0 && i <= 100) {
            this.mainThreadHandler.post(new WebViewYouTubePlayer$setVolume$2(this, i));
            return;
        }
        throw new IllegalArgumentException("Volume must be between 0 and 100".toString());
    }

    public void seekTo(float f) {
        this.mainThreadHandler.post(new WebViewYouTubePlayer$seekTo$1(this, f));
    }

    public void destroy() {
        this.youTubePlayerListeners.clear();
        this.mainThreadHandler.removeCallbacksAndMessages((Object) null);
        super.destroy();
    }

    public Collection<YouTubePlayerListener> getListeners() {
        Collection<YouTubePlayerListener> unmodifiableCollection = Collections.unmodifiableCollection(new HashSet(this.youTubePlayerListeners));
        Intrinsics.checkExpressionValueIsNotNull(unmodifiableCollection, "Collections.unmodifiable…(youTubePlayerListeners))");
        return unmodifiableCollection;
    }

    public boolean addListener(YouTubePlayerListener youTubePlayerListener) {
        Intrinsics.checkParameterIsNotNull(youTubePlayerListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.youTubePlayerListeners.add(youTubePlayerListener);
    }

    public boolean removeListener(YouTubePlayerListener youTubePlayerListener) {
        Intrinsics.checkParameterIsNotNull(youTubePlayerListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.youTubePlayerListeners.remove(youTubePlayerListener);
    }

    private final void initWebView(IFramePlayerOptions iFramePlayerOptions) {
        WebSettings settings = getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings, "settings");
        settings.setJavaScriptEnabled(true);
        WebSettings settings2 = getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings2, "settings");
        settings2.setMediaPlaybackRequiresUserGesture(false);
        WebSettings settings3 = getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings3, "settings");
        settings3.setCacheMode(2);
        addJavascriptInterface(new YouTubePlayerBridge(this), "YouTubePlayerBridge");
        Utils utils = Utils.INSTANCE;
        InputStream openRawResource = getResources().openRawResource(R.raw.ayp_youtube_player);
        Intrinsics.checkExpressionValueIsNotNull(openRawResource, "resources.openRawResourc…R.raw.ayp_youtube_player)");
        String replace$default = StringsKt.replace$default(utils.readHTMLFromUTF8File(openRawResource), "<<injectedPlayerVars>>", iFramePlayerOptions.toString(), false, 4, (Object) null);
        loadDataWithBaseURL(iFramePlayerOptions.getOrigin$core_release(), replace$default, "text/html", "utf-8", (String) null);
        setWebChromeClient(new WebViewYouTubePlayer$initWebView$1());
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        if (!this.isBackgroundPlaybackEnabled || !(i == 8 || i == 4)) {
            super.onWindowVisibilityChanged(i);
        }
    }
}
