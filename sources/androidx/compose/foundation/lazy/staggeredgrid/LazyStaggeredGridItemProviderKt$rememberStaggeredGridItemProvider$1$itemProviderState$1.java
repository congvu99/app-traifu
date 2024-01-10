package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyStaggeredGridItemProvider.kt */
final class LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$1$itemProviderState$1 extends Lambda implements Function0<LazyLayoutItemProvider> {
    final /* synthetic */ State<Function1<LazyStaggeredGridScope, Unit>> $latestContent;
    final /* synthetic */ State<IntRange> $nearestItemsRangeState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$1$itemProviderState$1(State<? extends Function1<? super LazyStaggeredGridScope, Unit>> state, State<IntRange> state2) {
        super(0);
        this.$latestContent = state;
        this.$nearestItemsRangeState = state2;
    }

    public final LazyLayoutItemProvider invoke() {
        LazyStaggeredGridScopeImpl lazyStaggeredGridScopeImpl = new LazyStaggeredGridScopeImpl();
        this.$latestContent.getValue().invoke(lazyStaggeredGridScopeImpl);
        return LazyLayoutItemProviderKt.LazyLayoutItemProvider(lazyStaggeredGridScopeImpl.getIntervals(), this.$nearestItemsRangeState.getValue(), ComposableSingletons$LazyStaggeredGridItemProviderKt.INSTANCE.m798getLambda1$foundation_release());
    }
}
