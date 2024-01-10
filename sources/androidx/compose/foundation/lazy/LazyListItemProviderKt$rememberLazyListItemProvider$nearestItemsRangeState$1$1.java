package androidx.compose.foundation.lazy;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyListItemProvider.kt */
final class LazyListItemProviderKt$rememberLazyListItemProvider$nearestItemsRangeState$1$1 extends Lambda implements Function0<Integer> {
    final /* synthetic */ LazyListState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListItemProviderKt$rememberLazyListItemProvider$nearestItemsRangeState$1$1(LazyListState lazyListState) {
        super(0);
        this.$state = lazyListState;
    }

    public final Integer invoke() {
        return Integer.valueOf(this.$state.getFirstVisibleItemIndex());
    }
}
