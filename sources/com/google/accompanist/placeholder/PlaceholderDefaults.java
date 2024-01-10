package com.google.accompanist.placeholder;

import androidx.compose.animation.core.InfiniteRepeatableSpec;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/google/accompanist/placeholder/PlaceholderDefaults;", "", "()V", "fadeAnimationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "", "getFadeAnimationSpec", "()Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "fadeAnimationSpec$delegate", "Lkotlin/Lazy;", "shimmerAnimationSpec", "getShimmerAnimationSpec", "shimmerAnimationSpec$delegate", "placeholder_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Placeholder.kt */
public final class PlaceholderDefaults {
    public static final int $stable = 8;
    public static final PlaceholderDefaults INSTANCE = new PlaceholderDefaults();
    private static final Lazy fadeAnimationSpec$delegate = LazyKt.lazy(PlaceholderDefaults$fadeAnimationSpec$2.INSTANCE);
    private static final Lazy shimmerAnimationSpec$delegate = LazyKt.lazy(PlaceholderDefaults$shimmerAnimationSpec$2.INSTANCE);

    private PlaceholderDefaults() {
    }

    public final InfiniteRepeatableSpec<Float> getFadeAnimationSpec() {
        return (InfiniteRepeatableSpec) fadeAnimationSpec$delegate.getValue();
    }

    public final InfiniteRepeatableSpec<Float> getShimmerAnimationSpec() {
        return (InfiniteRepeatableSpec) shimmerAnimationSpec$delegate.getValue();
    }
}
