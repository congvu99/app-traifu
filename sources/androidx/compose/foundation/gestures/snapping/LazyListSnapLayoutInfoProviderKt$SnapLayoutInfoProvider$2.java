package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b*\u00020\bH\u0016J\f\u0010\f\u001a\u00020\u0007*\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\r"}, d2 = {"androidx/compose/foundation/gestures/snapping/LazyListSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$2", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "calculateApproachOffset", "", "Landroidx/compose/ui/unit/Density;", "initialVelocity", "calculateSnappingOffsetBounds", "Lkotlin/ranges/ClosedFloatingPointRange;", "snapStepSize", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyListSnapLayoutInfoProvider.kt */
public final class LazyListSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$2 implements SnapLayoutInfoProvider {
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ Function3<Density, Float, Float, Float> $positionInLayout;

    public float calculateApproachOffset(Density density, float f) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        return 0.0f;
    }

    LazyListSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$2(LazyListState lazyListState, Function3<? super Density, ? super Float, ? super Float, Float> function3) {
        this.$lazyListState = lazyListState;
        this.$positionInLayout = function3;
    }

    private final LazyListLayoutInfo getLayoutInfo() {
        return this.$lazyListState.getLayoutInfo();
    }

    public ClosedFloatingPointRange<Float> calculateSnappingOffsetBounds(Density density) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        List<LazyListItemInfo> visibleItemsInfo = getLayoutInfo().getVisibleItemsInfo();
        Function3<Density, Float, Float, Float> function3 = this.$positionInLayout;
        int size = visibleItemsInfo.size();
        float f = Float.NEGATIVE_INFINITY;
        float f2 = Float.POSITIVE_INFINITY;
        for (int i = 0; i < size; i++) {
            float calculateDistanceToDesiredSnapPosition = LazyListSnapLayoutInfoProviderKt.calculateDistanceToDesiredSnapPosition(density, getLayoutInfo(), visibleItemsInfo.get(i), function3);
            if (calculateDistanceToDesiredSnapPosition <= 0.0f && calculateDistanceToDesiredSnapPosition > f) {
                f = calculateDistanceToDesiredSnapPosition;
            }
            if (calculateDistanceToDesiredSnapPosition >= 0.0f && calculateDistanceToDesiredSnapPosition < f2) {
                f2 = calculateDistanceToDesiredSnapPosition;
            }
        }
        return RangesKt.rangeTo(f, f2);
    }

    public float snapStepSize(Density density) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        LazyListLayoutInfo layoutInfo = getLayoutInfo();
        if (!(!layoutInfo.getVisibleItemsInfo().isEmpty())) {
            return 0.0f;
        }
        List<LazyListItemInfo> visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += visibleItemsInfo.get(i2).getSize();
        }
        return ((float) i) / ((float) layoutInfo.getVisibleItemsInfo().size());
    }
}
