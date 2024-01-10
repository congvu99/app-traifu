package androidx.compose.foundation.lazy.grid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyGridItemProvider.kt */
final class LazyGridItemProviderKt$rememberLazyGridItemProvider$nearestItemsRangeState$1$1 extends Lambda implements Function0<Integer> {
    final /* synthetic */ LazyGridState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridItemProviderKt$rememberLazyGridItemProvider$nearestItemsRangeState$1$1(LazyGridState lazyGridState) {
        super(0);
        this.$state = lazyGridState;
    }

    public final Integer invoke() {
        return Integer.valueOf(this.$state.getFirstVisibleItemIndex());
    }
}
