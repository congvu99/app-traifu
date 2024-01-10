package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.layout.Placeable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\n"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "index", "", "lane", "key", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyStaggeredGridMeasure.kt */
final class LazyStaggeredGridMeasureContext$measuredItemProvider$1 implements MeasuredItemFactory {
    final /* synthetic */ LazyStaggeredGridMeasureContext this$0;

    LazyStaggeredGridMeasureContext$measuredItemProvider$1(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        this.this$0 = lazyStaggeredGridMeasureContext;
    }

    public final LazyStaggeredGridMeasuredItem createItem(int i, int i2, Object obj, List<? extends Placeable> list) {
        int i3;
        Intrinsics.checkNotNullParameter(obj, SDKConstants.PARAM_KEY);
        Intrinsics.checkNotNullParameter(list, "placeables");
        boolean z = this.this$0.getSpans().findNextItemIndex(i, i2) >= this.this$0.getItemProvider().getItemCount();
        boolean isVertical = this.this$0.isVertical();
        long r7 = this.this$0.m806getContentOffsetnOccac();
        if (z) {
            i3 = 0;
        } else {
            i3 = this.this$0.getMainAxisSpacing();
        }
        return new LazyStaggeredGridMeasuredItem(i, obj, list, isVertical, r7, i3, (DefaultConstructorMarker) null);
    }
}
