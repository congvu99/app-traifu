package com.google.accompanist.placeholder;

import androidx.compose.animation.core.InfiniteRepeatableSpec;
import com.google.accompanist.placeholder.PlaceholderHighlight;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001a9\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0003\u0010\u000b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"fade", "Lcom/google/accompanist/placeholder/PlaceholderHighlight;", "Lcom/google/accompanist/placeholder/PlaceholderHighlight$Companion;", "highlightColor", "Landroidx/compose/ui/graphics/Color;", "animationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "", "fade-bw27NRU", "(Lcom/google/accompanist/placeholder/PlaceholderHighlight$Companion;JLandroidx/compose/animation/core/InfiniteRepeatableSpec;)Lcom/google/accompanist/placeholder/PlaceholderHighlight;", "shimmer", "progressForMaxAlpha", "shimmer-RPmYEkk", "(Lcom/google/accompanist/placeholder/PlaceholderHighlight$Companion;JLandroidx/compose/animation/core/InfiniteRepeatableSpec;F)Lcom/google/accompanist/placeholder/PlaceholderHighlight;", "placeholder_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: PlaceholderHighlight.kt */
public final class PlaceholderHighlightKt {
    /* renamed from: fade-bw27NRU$default  reason: not valid java name */
    public static /* synthetic */ PlaceholderHighlight m5059fadebw27NRU$default(PlaceholderHighlight.Companion companion, long j, InfiniteRepeatableSpec<Float> infiniteRepeatableSpec, int i, Object obj) {
        if ((i & 2) != 0) {
            infiniteRepeatableSpec = PlaceholderDefaults.INSTANCE.getFadeAnimationSpec();
        }
        return m5058fadebw27NRU(companion, j, infiniteRepeatableSpec);
    }

    /* renamed from: fade-bw27NRU  reason: not valid java name */
    public static final PlaceholderHighlight m5058fadebw27NRU(PlaceholderHighlight.Companion companion, long j, InfiniteRepeatableSpec<Float> infiniteRepeatableSpec) {
        Intrinsics.checkNotNullParameter(companion, "$this$fade");
        Intrinsics.checkNotNullParameter(infiniteRepeatableSpec, "animationSpec");
        return new Fade(j, infiniteRepeatableSpec, (DefaultConstructorMarker) null);
    }

    /* renamed from: shimmer-RPmYEkk$default  reason: not valid java name */
    public static /* synthetic */ PlaceholderHighlight m5061shimmerRPmYEkk$default(PlaceholderHighlight.Companion companion, long j, InfiniteRepeatableSpec<Float> infiniteRepeatableSpec, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            infiniteRepeatableSpec = PlaceholderDefaults.INSTANCE.getShimmerAnimationSpec();
        }
        if ((i & 4) != 0) {
            f = 0.6f;
        }
        return m5060shimmerRPmYEkk(companion, j, infiniteRepeatableSpec, f);
    }

    /* renamed from: shimmer-RPmYEkk  reason: not valid java name */
    public static final PlaceholderHighlight m5060shimmerRPmYEkk(PlaceholderHighlight.Companion companion, long j, InfiniteRepeatableSpec<Float> infiniteRepeatableSpec, float f) {
        Intrinsics.checkNotNullParameter(companion, "$this$shimmer");
        Intrinsics.checkNotNullParameter(infiniteRepeatableSpec, "animationSpec");
        return new Shimmer(j, infiniteRepeatableSpec, f, (DefaultConstructorMarker) null);
    }
}
