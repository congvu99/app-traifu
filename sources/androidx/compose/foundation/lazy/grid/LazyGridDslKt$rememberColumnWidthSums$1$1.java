package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyGridDsl.kt */
final class LazyGridDslKt$rememberColumnWidthSums$1$1 extends Lambda implements Function2<Density, Constraints, List<Integer>> {
    final /* synthetic */ GridCells $columns;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridDslKt$rememberColumnWidthSums$1$1(PaddingValues paddingValues, GridCells gridCells, Arrangement.Horizontal horizontal) {
        super(2);
        this.$contentPadding = paddingValues;
        this.$columns = gridCells;
        this.$horizontalArrangement = horizontal;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m709invoke0kLqBqw((Density) obj, ((Constraints) obj2).m4630unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final List<Integer> m709invoke0kLqBqw(Density density, long j) {
        Intrinsics.checkNotNullParameter(density, "$this$null");
        if (Constraints.m4624getMaxWidthimpl(j) != Integer.MAX_VALUE) {
            List<Integer> mutableList = CollectionsKt.toMutableList(this.$columns.calculateCrossAxisCellSizes(density, Constraints.m4624getMaxWidthimpl(j) - density.m4643roundToPx0680j_4(Dp.m4704constructorimpl(PaddingKt.calculateStartPadding(this.$contentPadding, LayoutDirection.Ltr) + PaddingKt.calculateEndPadding(this.$contentPadding, LayoutDirection.Ltr))), density.m4643roundToPx0680j_4(this.$horizontalArrangement.m422getSpacingD9Ej5fM())));
            int size = mutableList.size();
            for (int i = 1; i < size; i++) {
                mutableList.set(i, Integer.valueOf(mutableList.get(i).intValue() + mutableList.get(i - 1).intValue()));
            }
            return mutableList;
        }
        throw new IllegalArgumentException("LazyVerticalGrid's width should be bound by parent.".toString());
    }
}
