package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyStaggeredGridDsl.kt */
final class LazyStaggeredGridDslKt$rememberRowHeightSums$1$1 extends Lambda implements Function2<Density, Constraints, int[]> {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ StaggeredGridCells $rows;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridDslKt$rememberRowHeightSums$1$1(PaddingValues paddingValues, StaggeredGridCells staggeredGridCells, Arrangement.Vertical vertical) {
        super(2);
        this.$contentPadding = paddingValues;
        this.$rows = staggeredGridCells;
        this.$verticalArrangement = vertical;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m801invoke0kLqBqw((Density) obj, ((Constraints) obj2).m4630unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final int[] m801invoke0kLqBqw(Density density, long j) {
        Intrinsics.checkNotNullParameter(density, "$this$null");
        if (Constraints.m4623getMaxHeightimpl(j) != Integer.MAX_VALUE) {
            List<Integer> calculateCrossAxisCellSizes = this.$rows.calculateCrossAxisCellSizes(density, Constraints.m4623getMaxHeightimpl(j) - density.m4643roundToPx0680j_4(Dp.m4704constructorimpl(this.$contentPadding.m523calculateTopPaddingD9Ej5fM() + this.$contentPadding.m520calculateBottomPaddingD9Ej5fM())), density.m4643roundToPx0680j_4(this.$verticalArrangement.m440getSpacingD9Ej5fM()));
            int size = calculateCrossAxisCellSizes.size();
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                iArr[i] = calculateCrossAxisCellSizes.get(i).intValue();
            }
            int size2 = calculateCrossAxisCellSizes.size();
            for (int i2 = 1; i2 < size2; i2++) {
                iArr[i2] = iArr[i2] + iArr[i2 - 1];
            }
            return iArr;
        }
        throw new IllegalArgumentException("LazyHorizontalStaggeredGrid's height should be bound by parent.".toString());
    }
}
