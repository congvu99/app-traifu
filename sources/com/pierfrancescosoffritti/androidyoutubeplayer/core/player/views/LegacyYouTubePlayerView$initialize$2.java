package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 15})
/* compiled from: LegacyYouTubePlayerView.kt */
final class LegacyYouTubePlayerView$initialize$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ IFramePlayerOptions $playerOptions;
    final /* synthetic */ YouTubePlayerListener $youTubePlayerListener;
    final /* synthetic */ LegacyYouTubePlayerView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LegacyYouTubePlayerView$initialize$2(LegacyYouTubePlayerView legacyYouTubePlayerView, YouTubePlayerListener youTubePlayerListener, IFramePlayerOptions iFramePlayerOptions) {
        super(0);
        this.this$0 = legacyYouTubePlayerView;
        this.$youTubePlayerListener = youTubePlayerListener;
        this.$playerOptions = iFramePlayerOptions;
    }

    public final void invoke() {
        this.this$0.getYouTubePlayer$core_release().initialize$core_release(new Function1<YouTubePlayer, Unit>(this) {
            final /* synthetic */ LegacyYouTubePlayerView$initialize$2 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((YouTubePlayer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(YouTubePlayer youTubePlayer) {
                Intrinsics.checkParameterIsNotNull(youTubePlayer, "it");
                youTubePlayer.addListener(this.this$0.$youTubePlayerListener);
            }
        }, this.$playerOptions);
    }
}
