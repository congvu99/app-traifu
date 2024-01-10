package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyGrid.kt */
final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult> {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ LazyGridItemProvider $itemProvider;
    final /* synthetic */ OverscrollEffect $overscrollEffect;
    final /* synthetic */ LazyGridItemPlacementAnimator $placementAnimator;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ Function2<Density, Constraints, List<Integer>> $slotSizesSums;
    final /* synthetic */ LazyGridState $state;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridKt$rememberLazyGridMeasurePolicy$1$1(boolean z, PaddingValues paddingValues, boolean z2, LazyGridState lazyGridState, LazyGridItemProvider lazyGridItemProvider, Function2<? super Density, ? super Constraints, ? extends List<Integer>> function2, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, OverscrollEffect overscrollEffect) {
        super(2);
        this.$isVertical = z;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z2;
        this.$state = lazyGridState;
        this.$itemProvider = lazyGridItemProvider;
        this.$slotSizesSums = function2;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$placementAnimator = lazyGridItemPlacementAnimator;
        this.$overscrollEffect = overscrollEffect;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m720invoke0kLqBqw((LazyLayoutMeasureScope) obj, ((Constraints) obj2).m4630unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final LazyGridMeasureResult m720invoke0kLqBqw(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
        int i;
        int i2;
        int i3;
        float f;
        float f2;
        int i4;
        long j2;
        Snapshot makeCurrent;
        int i5;
        int i6;
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
        int i7 = r4 + r5;
        int i8 = i + i2;
        int i9 = this.$isVertical ? i7 : i8;
        if (this.$isVertical && !this.$reverseLayout) {
            i3 = r4;
        } else if (!this.$isVertical || !this.$reverseLayout) {
            i3 = (this.$isVertical || this.$reverseLayout) ? i2 : i;
        } else {
            i3 = r5;
        }
        int i10 = i9 - i3;
        long r25 = ConstraintsKt.m4640offsetNN6EwU(j3, -i8, -i7);
        this.$state.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(this.$itemProvider);
        LazyGridSpanLayoutProvider spanLayoutProvider = this.$itemProvider.getSpanLayoutProvider();
        List invoke = this.$slotSizesSums.invoke(lazyLayoutMeasureScope2, Constraints.m4612boximpl(j));
        spanLayoutProvider.setSlotsPerLine(invoke.size());
        Density density = lazyLayoutMeasureScope2;
        this.$state.setDensity$foundation_release(density);
        this.$state.setSlotsPerLine$foundation_release(invoke.size());
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
        int r8 = lazyLayoutMeasureScope2.m4643roundToPx0680j_4(f);
        if (this.$isVertical) {
            Arrangement.Horizontal horizontal2 = this.$horizontalArrangement;
            f2 = horizontal2 != null ? horizontal2.m422getSpacingD9Ej5fM() : Dp.m4704constructorimpl((float) 0);
        } else {
            Arrangement.Vertical vertical2 = this.$verticalArrangement;
            f2 = vertical2 != null ? vertical2.m440getSpacingD9Ej5fM() : Dp.m4704constructorimpl((float) 0);
        }
        int r6 = lazyLayoutMeasureScope2.m4643roundToPx0680j_4(f2);
        int itemCount = this.$itemProvider.getItemCount();
        if (this.$isVertical) {
            i4 = Constraints.m4623getMaxHeightimpl(j) - i7;
        } else {
            i4 = Constraints.m4624getMaxWidthimpl(j) - i8;
        }
        int i11 = i4;
        if (!this.$reverseLayout || i11 > 0) {
            j2 = IntOffsetKt.IntOffset(i, r4);
        } else {
            if (!this.$isVertical) {
                i += i11;
            }
            if (this.$isVertical) {
                r4 += i11;
            }
            j2 = IntOffsetKt.IntOffset(i, r4);
        }
        int i12 = itemCount;
        int i13 = i7;
        int i14 = r6;
        int i15 = i8;
        int i16 = r8;
        Density density2 = density;
        LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider = spanLayoutProvider;
        List list = invoke;
        LazyMeasuredItemProvider lazyMeasuredItemProvider = new LazyMeasuredItemProvider(this.$itemProvider, lazyLayoutMeasureScope2, i16, new LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1(lazyLayoutMeasureScope, this.$isVertical, this.$reverseLayout, i3, i10, this.$placementAnimator, j2));
        boolean z = this.$isVertical;
        final LazyMeasuredLineProvider lazyMeasuredLineProvider = new LazyMeasuredLineProvider(z, list, i14, i12, i16, lazyMeasuredItemProvider, lazyGridSpanLayoutProvider, new LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1(z, list, lazyLayoutMeasureScope2, i14));
        final LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider2 = lazyGridSpanLayoutProvider;
        this.$state.setPrefetchInfoRetriever$foundation_release(new Function1<LineIndex, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m721invokebKFJvoY(((LineIndex) obj).m758unboximpl());
            }

            /* renamed from: invoke-bKFJvoY  reason: not valid java name */
            public final ArrayList<Pair<Integer, Constraints>> m721invokebKFJvoY(int i) {
                LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = lazyGridSpanLayoutProvider2.getLineConfiguration(i);
                int r0 = ItemIndex.m692constructorimpl(lineConfiguration.getFirstItemIndex());
                ArrayList<Pair<Integer, Constraints>> arrayList = new ArrayList<>(lineConfiguration.getSpans().size());
                List<GridItemSpan> spans = lineConfiguration.getSpans();
                LazyMeasuredLineProvider lazyMeasuredLineProvider = lazyMeasuredLineProvider;
                int size = spans.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    int r6 = GridItemSpan.m686getCurrentLineSpanimpl(spans.get(i3).m689unboximpl());
                    arrayList.add(TuplesKt.to(Integer.valueOf(r0), Constraints.m4612boximpl(lazyMeasuredLineProvider.m744childConstraintsJhjzzOo$foundation_release(i2, r6))));
                    r0 = ItemIndex.m692constructorimpl(r0 + 1);
                    i2 += r6;
                }
                return arrayList;
            }
        });
        Snapshot.Companion companion = Snapshot.Companion;
        LazyGridState lazyGridState = this.$state;
        Snapshot createNonObservableSnapshot = companion.createNonObservableSnapshot();
        try {
            makeCurrent = createNonObservableSnapshot.makeCurrent();
            int i17 = i12;
            if (lazyGridState.getFirstVisibleItemIndex() >= i17) {
                if (i17 > 0) {
                    i6 = lazyGridSpanLayoutProvider2.m738getLineIndexOfItem_Ze7BM(i17 - 1);
                    i5 = 0;
                    Unit unit = Unit.INSTANCE;
                    createNonObservableSnapshot.restoreCurrent(makeCurrent);
                    createNonObservableSnapshot.dispose();
                    final LazyLayoutMeasureScope lazyLayoutMeasureScope3 = lazyLayoutMeasureScope;
                    final long j4 = j;
                    final int i18 = i15;
                    final int i19 = i13;
                    LazyGridMeasureResult r0 = LazyGridMeasureKt.m725measureLazyGridzIfe3eg(i17, lazyMeasuredLineProvider, lazyMeasuredItemProvider, i11, list.size(), i3, i10, i6, i5, this.$state.getScrollToBeConsumed$foundation_release(), r25, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, density2, this.$placementAnimator, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (Function1<? super Placeable.PlacementScope, Unit>) (Function1) obj3);
                        }

                        public final MeasureResult invoke(int i, int i2, Function1<? super Placeable.PlacementScope, Unit> function1) {
                            Intrinsics.checkNotNullParameter(function1, "placement");
                            return lazyLayoutMeasureScope3.layout(ConstraintsKt.m4638constrainWidthK40F9xA(j4, i + i18), ConstraintsKt.m4637constrainHeightK40F9xA(j4, i2 + i19), MapsKt.emptyMap(), function1);
                        }
                    });
                    LazyGridState lazyGridState2 = this.$state;
                    OverscrollEffect overscrollEffect = this.$overscrollEffect;
                    lazyGridState2.applyMeasureResult$foundation_release(r0);
                    LazyGridKt.refreshOverscrollInfo(overscrollEffect, r0);
                    return r0;
                }
            }
            int r42 = lazyGridSpanLayoutProvider2.m738getLineIndexOfItem_Ze7BM(lazyGridState.getFirstVisibleItemIndex());
            i5 = lazyGridState.getFirstVisibleItemScrollOffset();
            i6 = r42;
            Unit unit2 = Unit.INSTANCE;
            createNonObservableSnapshot.restoreCurrent(makeCurrent);
            createNonObservableSnapshot.dispose();
            final LazyLayoutMeasureScope lazyLayoutMeasureScope32 = lazyLayoutMeasureScope;
            final long j42 = j;
            final int i182 = i15;
            final int i192 = i13;
            LazyGridMeasureResult r02 = LazyGridMeasureKt.m725measureLazyGridzIfe3eg(i17, lazyMeasuredLineProvider, lazyMeasuredItemProvider, i11, list.size(), i3, i10, i6, i5, this.$state.getScrollToBeConsumed$foundation_release(), r25, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, density2, this.$placementAnimator, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (Function1<? super Placeable.PlacementScope, Unit>) (Function1) obj3);
                }

                public final MeasureResult invoke(int i, int i2, Function1<? super Placeable.PlacementScope, Unit> function1) {
                    Intrinsics.checkNotNullParameter(function1, "placement");
                    return lazyLayoutMeasureScope32.layout(ConstraintsKt.m4638constrainWidthK40F9xA(j42, i + i182), ConstraintsKt.m4637constrainHeightK40F9xA(j42, i2 + i192), MapsKt.emptyMap(), function1);
                }
            });
            LazyGridState lazyGridState22 = this.$state;
            OverscrollEffect overscrollEffect2 = this.$overscrollEffect;
            lazyGridState22.applyMeasureResult$foundation_release(r02);
            LazyGridKt.refreshOverscrollInfo(overscrollEffect2, r02);
            return r02;
        } catch (Throwable th) {
            createNonObservableSnapshot.dispose();
            throw th;
        }
    }
}
