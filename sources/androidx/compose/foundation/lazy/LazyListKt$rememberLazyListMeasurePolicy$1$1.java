package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyList.kt */
final class LazyListKt$rememberLazyListMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult> {
    final /* synthetic */ LazyListBeyondBoundsInfo $beyondBoundsInfo;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ LazyListItemProvider $itemProvider;
    final /* synthetic */ OverscrollEffect $overscrollEffect;
    final /* synthetic */ LazyListItemPlacementAnimator $placementAnimator;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyListState $state;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListKt$rememberLazyListMeasurePolicy$1$1(boolean z, PaddingValues paddingValues, boolean z2, LazyListState lazyListState, LazyListItemProvider lazyListItemProvider, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, Alignment.Horizontal horizontal2, Alignment.Vertical vertical2, OverscrollEffect overscrollEffect) {
        super(2);
        this.$isVertical = z;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z2;
        this.$state = lazyListState;
        this.$itemProvider = lazyListItemProvider;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$placementAnimator = lazyListItemPlacementAnimator;
        this.$beyondBoundsInfo = lazyListBeyondBoundsInfo;
        this.$horizontalAlignment = horizontal2;
        this.$verticalAlignment = vertical2;
        this.$overscrollEffect = overscrollEffect;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m658invoke0kLqBqw((LazyLayoutMeasureScope) obj, ((Constraints) obj2).m4630unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final LazyListMeasureResult m658invoke0kLqBqw(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        long j2;
        Snapshot makeCurrent;
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        long j3 = j;
        Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope2, "$this$null");
        CheckScrollableContainerConstraintsKt.m192checkScrollableContainerConstraintsK40F9xA(j3, this.$isVertical ? Orientation.Vertical : Orientation.Horizontal);
        if (this.$isVertical) {
            i = lazyLayoutMeasureScope2.m4643roundToPx0680j_4(this.$contentPadding.m521calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i = lazyLayoutMeasureScope2.m4643roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        if (this.$isVertical) {
            i2 = lazyLayoutMeasureScope2.m4643roundToPx0680j_4(this.$contentPadding.m522calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i2 = lazyLayoutMeasureScope2.m4643roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        int r4 = lazyLayoutMeasureScope2.m4643roundToPx0680j_4(this.$contentPadding.m523calculateTopPaddingD9Ej5fM());
        int r5 = lazyLayoutMeasureScope2.m4643roundToPx0680j_4(this.$contentPadding.m520calculateBottomPaddingD9Ej5fM());
        int i5 = r4 + r5;
        int i6 = i + i2;
        int i7 = this.$isVertical ? i5 : i6;
        if (this.$isVertical && !this.$reverseLayout) {
            i3 = r4;
        } else if (!this.$isVertical || !this.$reverseLayout) {
            i3 = (this.$isVertical || this.$reverseLayout) ? i2 : i;
        } else {
            i3 = r5;
        }
        int i8 = i7 - i3;
        long r24 = ConstraintsKt.m4640offsetNN6EwU(j3, -i6, -i5);
        this.$state.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(this.$itemProvider);
        Density density = lazyLayoutMeasureScope2;
        this.$state.setDensity$foundation_release(density);
        this.$itemProvider.getItemScope().setMaxSize(Constraints.m4624getMaxWidthimpl(r24), Constraints.m4623getMaxHeightimpl(r24));
        if (this.$isVertical) {
            Arrangement.Vertical vertical = this.$verticalArrangement;
            if (vertical != null) {
                f = vertical.m440getSpacingD9Ej5fM();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            Arrangement.Horizontal horizontal = this.$horizontalArrangement;
            if (horizontal != null) {
                f = horizontal.m422getSpacingD9Ej5fM();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        int r52 = lazyLayoutMeasureScope2.m4643roundToPx0680j_4(f);
        int itemCount = this.$itemProvider.getItemCount();
        if (this.$isVertical) {
            i4 = Constraints.m4623getMaxHeightimpl(j) - i5;
        } else {
            i4 = Constraints.m4624getMaxWidthimpl(j) - i6;
        }
        int i9 = i4;
        if (!this.$reverseLayout || i9 > 0) {
            j2 = IntOffsetKt.IntOffset(i, r4);
        } else {
            if (!this.$isVertical) {
                i += i9;
            }
            if (this.$isVertical) {
                r4 += i9;
            }
            j2 = IntOffsetKt.IntOffset(i, r4);
        }
        boolean z = this.$isVertical;
        Density density2 = density;
        int i10 = i6;
        LazyMeasuredItemProvider lazyMeasuredItemProvider = new LazyMeasuredItemProvider(r24, z, this.$itemProvider, lazyLayoutMeasureScope, new LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1(itemCount, r52, lazyLayoutMeasureScope, z, this.$horizontalAlignment, this.$verticalAlignment, this.$reverseLayout, i3, i8, this.$placementAnimator, j2), (DefaultConstructorMarker) null);
        this.$state.m673setPremeasureConstraintsBRTryo0$foundation_release(lazyMeasuredItemProvider.m675getChildConstraintsmsEJaDk());
        Snapshot.Companion companion = Snapshot.Companion;
        LazyListState lazyListState = this.$state;
        Snapshot createNonObservableSnapshot = companion.createNonObservableSnapshot();
        try {
            makeCurrent = createNonObservableSnapshot.makeCurrent();
            int r21 = DataIndex.m636constructorimpl(lazyListState.getFirstVisibleItemIndex());
            int firstVisibleItemScrollOffset = lazyListState.getFirstVisibleItemScrollOffset();
            Unit unit = Unit.INSTANCE;
            createNonObservableSnapshot.restoreCurrent(makeCurrent);
            createNonObservableSnapshot.dispose();
            final LazyLayoutMeasureScope lazyLayoutMeasureScope3 = lazyLayoutMeasureScope;
            final long j4 = j;
            final int i11 = i10;
            final int i12 = i5;
            LazyListMeasureResult r0 = LazyListMeasureKt.m664measureLazyList7Xnphek(itemCount, lazyMeasuredItemProvider, i9, i3, i8, r21, firstVisibleItemScrollOffset, this.$state.getScrollToBeConsumed$foundation_release(), r24, this.$isVertical, this.$itemProvider.getHeaderIndexes(), this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, density2, this.$placementAnimator, this.$beyondBoundsInfo, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (Function1<? super Placeable.PlacementScope, Unit>) (Function1) obj3);
                }

                public final MeasureResult invoke(int i, int i2, Function1<? super Placeable.PlacementScope, Unit> function1) {
                    Intrinsics.checkNotNullParameter(function1, "placement");
                    return lazyLayoutMeasureScope3.layout(ConstraintsKt.m4638constrainWidthK40F9xA(j4, i + i11), ConstraintsKt.m4637constrainHeightK40F9xA(j4, i2 + i12), MapsKt.emptyMap(), function1);
                }
            });
            LazyListState lazyListState2 = this.$state;
            OverscrollEffect overscrollEffect = this.$overscrollEffect;
            lazyListState2.applyMeasureResult$foundation_release(r0);
            LazyListKt.refreshOverscrollInfo(overscrollEffect, r0);
            return r0;
        } catch (Throwable th) {
            createNonObservableSnapshot.dispose();
            throw th;
        }
    }
}
