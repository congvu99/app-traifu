package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"androidx/compose/foundation/lazy/LazyListBeyondBoundsModifierLocal$layout$2", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "hasMoreContent", "", "getHasMoreContent", "()Z", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyBeyondBoundsModifier.kt */
public final class LazyListBeyondBoundsModifierLocal$layout$2 implements BeyondBoundsLayout.BeyondBoundsScope {
    final /* synthetic */ int $direction;
    final /* synthetic */ Ref.ObjectRef<LazyListBeyondBoundsInfo.Interval> $interval;
    final /* synthetic */ LazyListBeyondBoundsModifierLocal this$0;

    LazyListBeyondBoundsModifierLocal$layout$2(LazyListBeyondBoundsModifierLocal lazyListBeyondBoundsModifierLocal, Ref.ObjectRef<LazyListBeyondBoundsInfo.Interval> objectRef, int i) {
        this.this$0 = lazyListBeyondBoundsModifierLocal;
        this.$interval = objectRef;
        this.$direction = i;
    }

    public boolean getHasMoreContent() {
        return this.this$0.m652hasMoreContentFR3nfPY((LazyListBeyondBoundsInfo.Interval) this.$interval.element, this.$direction);
    }
}
