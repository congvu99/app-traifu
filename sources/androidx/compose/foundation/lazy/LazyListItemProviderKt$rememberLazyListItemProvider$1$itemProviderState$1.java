package androidx.compose.foundation.lazy;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyListItemProvider.kt */
final class LazyListItemProviderKt$rememberLazyListItemProvider$1$itemProviderState$1 extends Lambda implements Function0<LazyListItemProviderImpl> {
    final /* synthetic */ LazyItemScopeImpl $itemScope;
    final /* synthetic */ State<Function1<LazyListScope, Unit>> $latestContent;
    final /* synthetic */ State<IntRange> $nearestItemsRangeState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListItemProviderKt$rememberLazyListItemProvider$1$itemProviderState$1(State<? extends Function1<? super LazyListScope, Unit>> state, State<IntRange> state2, LazyItemScopeImpl lazyItemScopeImpl) {
        super(0);
        this.$latestContent = state;
        this.$nearestItemsRangeState = state2;
        this.$itemScope = lazyItemScopeImpl;
    }

    public final LazyListItemProviderImpl invoke() {
        LazyListScopeImpl lazyListScopeImpl = new LazyListScopeImpl();
        this.$latestContent.getValue().invoke(lazyListScopeImpl);
        return new LazyListItemProviderImpl(lazyListScopeImpl.getIntervals(), this.$nearestItemsRangeState.getValue(), lazyListScopeImpl.getHeaderIndexes(), this.$itemScope);
    }
}
