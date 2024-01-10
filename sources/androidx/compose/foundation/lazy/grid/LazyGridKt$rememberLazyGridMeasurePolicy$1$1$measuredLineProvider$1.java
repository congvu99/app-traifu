package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyGrid.kt */
final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 implements MeasuredLineFactory {
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ List<Integer> $resolvedSlotSizesSums;
    final /* synthetic */ int $spaceBetweenSlots;
    final /* synthetic */ LazyLayoutMeasureScope $this_null;

    LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1(boolean z, List<Integer> list, LazyLayoutMeasureScope lazyLayoutMeasureScope, int i) {
        this.$isVertical = z;
        this.$resolvedSlotSizesSums = list;
        this.$this_null = lazyLayoutMeasureScope;
        this.$spaceBetweenSlots = i;
    }

    /* renamed from: createLine-H9FfpSk  reason: not valid java name */
    public final LazyMeasuredLine m723createLineH9FfpSk(int i, LazyMeasuredItem[] lazyMeasuredItemArr, List<GridItemSpan> list, int i2) {
        Intrinsics.checkNotNullParameter(lazyMeasuredItemArr, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(list, "spans");
        return new LazyMeasuredLine(i, lazyMeasuredItemArr, list, this.$isVertical, this.$resolvedSlotSizesSums.size(), this.$this_null.getLayoutDirection(), i2, this.$spaceBetweenSlots, (DefaultConstructorMarker) null);
    }
}
