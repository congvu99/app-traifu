package io.intercom.android.sdk.m5.home.screens;

import android.content.Context;
import com.facebook.shimmer.ShimmerFrameLayout;
import io.intercom.android.sdk.survey.ui.components.LoadingComponentKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeLoadingContent.kt */
final class HomeLoadingContentKt$HomeLoadingContent$1$1 extends Lambda implements Function1<Context, ShimmerFrameLayout> {
    final /* synthetic */ int $shimmerDrawable;
    final /* synthetic */ long $tintColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeLoadingContentKt$HomeLoadingContent$1$1(long j, int i) {
        super(1);
        this.$tintColor = j;
        this.$shimmerDrawable = i;
    }

    public final ShimmerFrameLayout invoke(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ShimmerFrameLayout buildLoadingContainer = LoadingComponentKt.buildLoadingContainer(context);
        buildLoadingContainer.addView(LoadingComponentKt.m5310buildLoadingContentbw27NRU(context, this.$tintColor, this.$shimmerDrawable));
        return buildLoadingContainer;
    }
}
