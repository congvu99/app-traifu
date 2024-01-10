package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.IntervalList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "IntervalContent", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "it", "Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyLayoutItemProvider.kt */
final class DefaultLazyLayoutItemsProvider$generateKeyToIndexMap$1$1 extends Lambda implements Function1<IntervalList.Interval<? extends LazyLayoutIntervalContent>, Unit> {
    final /* synthetic */ int $first;
    final /* synthetic */ int $last;
    final /* synthetic */ HashMap<Object, Integer> $map;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultLazyLayoutItemsProvider$generateKeyToIndexMap$1$1(int i, int i2, HashMap<Object, Integer> hashMap) {
        super(1);
        this.$first = i;
        this.$last = i2;
        this.$map = hashMap;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IntervalList.Interval<? extends LazyLayoutIntervalContent>) (IntervalList.Interval) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(IntervalList.Interval<? extends LazyLayoutIntervalContent> interval) {
        Intrinsics.checkNotNullParameter(interval, "it");
        if (((LazyLayoutIntervalContent) interval.getValue()).getKey() != null) {
            Function1<Integer, Object> key = ((LazyLayoutIntervalContent) interval.getValue()).getKey();
            if (key != null) {
                int max = Math.max(this.$first, interval.getStartIndex());
                int min = Math.min(this.$last, (interval.getStartIndex() + interval.getSize()) - 1);
                if (max <= min) {
                    while (true) {
                        this.$map.put(key.invoke(Integer.valueOf(max - interval.getStartIndex())), Integer.valueOf(max));
                        if (max != min) {
                            max++;
                        } else {
                            return;
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
    }
}
