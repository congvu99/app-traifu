package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyStaggeredGridMeasurePolicy.kt */
final class LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ LazyLayoutItemProvider $itemProvider;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ OverscrollEffect $overscrollEffect;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ Function2<Density, Constraints, int[]> $slotSizesSums;
    final /* synthetic */ LazyStaggeredGridState $state;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1(Orientation orientation, Function2<? super Density, ? super Constraints, int[]> function2, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, LazyLayoutItemProvider lazyLayoutItemProvider, OverscrollEffect overscrollEffect) {
        super(2);
        this.$orientation = orientation;
        this.$slotSizesSums = function2;
        this.$state = lazyStaggeredGridState;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$itemProvider = lazyLayoutItemProvider;
        this.$overscrollEffect = overscrollEffect;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m810invoke0kLqBqw((LazyLayoutMeasureScope) obj, ((Constraints) obj2).m4630unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final LazyStaggeredGridMeasureResult m810invoke0kLqBqw(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
        long j2;
        float f;
        float f2;
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        long j3 = j;
        Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope2, "$this$null");
        CheckScrollableContainerConstraintsKt.m192checkScrollableContainerConstraintsK40F9xA(j3, this.$orientation);
        int[] invoke = this.$slotSizesSums.invoke(lazyLayoutMeasureScope2, Constraints.m4612boximpl(j));
        boolean z = true;
        boolean z2 = this.$orientation == Orientation.Vertical;
        this.$state.setLaneWidthsPrefixSum$foundation_release(invoke);
        this.$state.setVertical$foundation_release(z2);
        int r13 = lazyLayoutMeasureScope2.m4643roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.beforePadding(this.$contentPadding, this.$orientation, this.$reverseLayout, lazyLayoutMeasureScope.getLayoutDirection()));
        int r14 = lazyLayoutMeasureScope2.m4643roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.afterPadding(this.$contentPadding, this.$orientation, this.$reverseLayout, lazyLayoutMeasureScope.getLayoutDirection()));
        int r4 = lazyLayoutMeasureScope2.m4643roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.startPadding(this.$contentPadding, this.$orientation, lazyLayoutMeasureScope.getLayoutDirection()));
        int r12 = ((z2 ? Constraints.m4623getMaxHeightimpl(j) : Constraints.m4624getMaxWidthimpl(j)) - r13) - r14;
        if (z2) {
            j2 = IntOffsetKt.IntOffset(r4, r13);
        } else {
            j2 = IntOffsetKt.IntOffset(r13, r4);
        }
        long j4 = j2;
        if (z2) {
            f = this.$verticalArrangement.m440getSpacingD9Ej5fM();
        } else {
            f = this.$horizontalArrangement.m422getSpacingD9Ej5fM();
        }
        int r19 = lazyLayoutMeasureScope2.m4643roundToPx0680j_4(f);
        if (z2) {
            f2 = this.$horizontalArrangement.m422getSpacingD9Ej5fM();
        } else {
            f2 = this.$verticalArrangement.m440getSpacingD9Ej5fM();
        }
        int r20 = lazyLayoutMeasureScope2.m4643roundToPx0680j_4(f2);
        PaddingValues paddingValues = this.$contentPadding;
        int r42 = lazyLayoutMeasureScope2.m4643roundToPx0680j_4(Dp.m4704constructorimpl(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()) + PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection())));
        PaddingValues paddingValues2 = this.$contentPadding;
        LazyStaggeredGridMeasureResult r1 = LazyStaggeredGridMeasureKt.m809measureStaggeredGridyR9pz_M(lazyLayoutMeasureScope, this.$state, this.$itemProvider, invoke, Constraints.m4615copyZbe2FdA$default(j, ConstraintsKt.m4638constrainWidthK40F9xA(j3, r42), 0, ConstraintsKt.m4637constrainHeightK40F9xA(j3, lazyLayoutMeasureScope2.m4643roundToPx0680j_4(Dp.m4704constructorimpl(paddingValues2.m523calculateTopPaddingD9Ej5fM() + paddingValues2.m520calculateBottomPaddingD9Ej5fM()))), 0, 10, (Object) null), z2, j4, r12, r19, r20, r13, r14);
        LazyStaggeredGridState lazyStaggeredGridState = this.$state;
        OverscrollEffect overscrollEffect = this.$overscrollEffect;
        lazyStaggeredGridState.applyMeasureResult$foundation_release(r1);
        if (!r1.getCanScrollForward() && !r1.getCanScrollBackward()) {
            z = false;
        }
        overscrollEffect.setEnabled(z);
        return r1;
    }
}
