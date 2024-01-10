package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.PinnableParent;
import androidx.compose.ui.layout.Remeasurement;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"androidx/compose/foundation/lazy/LazyListPinningModifier$pinItems$1$1", "Landroidx/compose/foundation/lazy/layout/PinnableParent$PinnedItemsHandle;", "interval", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;", "getInterval", "()Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;", "parentPinnedItemsHandle", "getParentPinnedItemsHandle", "()Landroidx/compose/foundation/lazy/layout/PinnableParent$PinnedItemsHandle;", "unpin", "", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyListPinningModifier.kt */
public final class LazyListPinningModifier$pinItems$1$1 implements PinnableParent.PinnedItemsHandle {
    final /* synthetic */ LazyListBeyondBoundsInfo $this_with;
    private final LazyListBeyondBoundsInfo.Interval interval;
    private final PinnableParent.PinnedItemsHandle parentPinnedItemsHandle;
    final /* synthetic */ LazyListPinningModifier this$0;

    LazyListPinningModifier$pinItems$1$1(LazyListPinningModifier lazyListPinningModifier, LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo) {
        this.this$0 = lazyListPinningModifier;
        this.$this_with = lazyListBeyondBoundsInfo;
        PinnableParent pinnableGrandParent = lazyListPinningModifier.getPinnableGrandParent();
        this.parentPinnedItemsHandle = pinnableGrandParent != null ? pinnableGrandParent.pinItems() : null;
        this.interval = lazyListBeyondBoundsInfo.addInterval(lazyListBeyondBoundsInfo.getStart(), lazyListBeyondBoundsInfo.getEnd());
    }

    public final PinnableParent.PinnedItemsHandle getParentPinnedItemsHandle() {
        return this.parentPinnedItemsHandle;
    }

    public final LazyListBeyondBoundsInfo.Interval getInterval() {
        return this.interval;
    }

    public void unpin() {
        this.$this_with.removeInterval(this.interval);
        PinnableParent.PinnedItemsHandle pinnedItemsHandle = this.parentPinnedItemsHandle;
        if (pinnedItemsHandle != null) {
            pinnedItemsHandle.unpin();
        }
        Remeasurement remeasurement$foundation_release = this.this$0.state.getRemeasurement$foundation_release();
        if (remeasurement$foundation_release != null) {
            remeasurement$foundation_release.forceRemeasure();
        }
    }
}
