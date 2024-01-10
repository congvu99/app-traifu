package androidx.compose.foundation.lazy.grid;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(I)Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyGridItemPlacementAnimator.kt */
final class LazyGridItemPlacementAnimator$onMeasured$averageLineMainAxisSize$1$lineOf$1 extends Lambda implements Function1<Integer, Integer> {
    final /* synthetic */ List<LazyGridPositionedItem> $positionedItems;
    final /* synthetic */ LazyGridItemPlacementAnimator $this_run;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridItemPlacementAnimator$onMeasured$averageLineMainAxisSize$1$lineOf$1(LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, List<LazyGridPositionedItem> list) {
        super(1);
        this.$this_run = lazyGridItemPlacementAnimator;
        this.$positionedItems = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final Integer invoke(int i) {
        return Integer.valueOf(this.$this_run.isVertical ? this.$positionedItems.get(i).getRow() : this.$positionedItems.get(i).getColumn());
    }
}
