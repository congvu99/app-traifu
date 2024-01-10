package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.layout.Placeable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyGrid.kt */
final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 implements MeasuredItemFactory {
    final /* synthetic */ int $afterContentPadding;
    final /* synthetic */ int $beforeContentPadding;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ LazyGridItemPlacementAnimator $placementAnimator;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyLayoutMeasureScope $this_null;
    final /* synthetic */ long $visualItemOffset;

    LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1(LazyLayoutMeasureScope lazyLayoutMeasureScope, boolean z, boolean z2, int i, int i2, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, long j) {
        this.$this_null = lazyLayoutMeasureScope;
        this.$isVertical = z;
        this.$reverseLayout = z2;
        this.$beforeContentPadding = i;
        this.$afterContentPadding = i2;
        this.$placementAnimator = lazyGridItemPlacementAnimator;
        this.$visualItemOffset = j;
    }

    /* renamed from: createItem-PU_OBEw  reason: not valid java name */
    public final LazyMeasuredItem m722createItemPU_OBEw(int i, Object obj, int i2, int i3, List<? extends Placeable> list) {
        Object obj2 = obj;
        Intrinsics.checkNotNullParameter(obj2, SDKConstants.PARAM_KEY);
        List<? extends Placeable> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "placeables");
        return new LazyMeasuredItem(i, obj2, this.$isVertical, i2, i3, this.$reverseLayout, this.$this_null.getLayoutDirection(), this.$beforeContentPadding, this.$afterContentPadding, list2, this.$placementAnimator, this.$visualItemOffset, (DefaultConstructorMarker) null);
    }
}
