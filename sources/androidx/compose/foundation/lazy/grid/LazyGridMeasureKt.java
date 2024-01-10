package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ap\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001aÒ\u0001\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010'\u001a\u00020(2/\u0010)\u001a+\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+¢\u0006\u0002\b.\u0012\u0004\u0012\u00020/0*H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00062"}, d2 = {"calculateItemsOffsets", "", "Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", "lines", "", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredLine;", "layoutWidth", "", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "itemsCount", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredLineProvider;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;", "mainAxisAvailableSize", "slotsPerLine", "beforeContentPadding", "afterContentPadding", "firstVisibleLineIndex", "Landroidx/compose/foundation/lazy/grid/LineIndex;", "firstVisibleLineScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyGrid-zIfe3eg", "(ILandroidx/compose/foundation/lazy/grid/LazyMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyGridMeasure.kt */
public final class LazyGridMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* renamed from: measureLazyGrid-zIfe3eg  reason: not valid java name */
    public static final LazyGridMeasureResult m725measureLazyGridzIfe3eg(int i, LazyMeasuredLineProvider lazyMeasuredLineProvider, LazyMeasuredItemProvider lazyMeasuredItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int i8;
        LazyMeasuredLine lazyMeasuredLine;
        int i9;
        int i10;
        Orientation orientation;
        int i11;
        Orientation orientation2;
        LazyMeasuredLineProvider lazyMeasuredLineProvider2 = lazyMeasuredLineProvider;
        int i12 = i2;
        int i13 = i4;
        long j2 = j;
        Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function32 = function3;
        Intrinsics.checkNotNullParameter(lazyMeasuredLineProvider2, "measuredLineProvider");
        Intrinsics.checkNotNullParameter(lazyMeasuredItemProvider, "measuredItemProvider");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(lazyGridItemPlacementAnimator, "placementAnimator");
        Intrinsics.checkNotNullParameter(function32, "layout");
        if (i13 >= 0) {
            if (!(i5 >= 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            } else if (i <= 0) {
                MeasureResult measureResult = (MeasureResult) function32.invoke(Integer.valueOf(Constraints.m4626getMinWidthimpl(j)), Integer.valueOf(Constraints.m4625getMinHeightimpl(j)), LazyGridMeasureKt$measureLazyGrid$1.INSTANCE);
                List emptyList = CollectionsKt.emptyList();
                int i14 = -i13;
                int i15 = i12 + i5;
                if (z) {
                    orientation2 = Orientation.Vertical;
                } else {
                    orientation2 = Orientation.Horizontal;
                }
                return new LazyGridMeasureResult((LazyMeasuredLine) null, 0, false, 0.0f, measureResult, emptyList, i14, i15, 0, z2, orientation2, i5);
            } else {
                int roundToInt = MathKt.roundToInt(f);
                int i16 = i7 - roundToInt;
                int i17 = i6;
                if (LineIndex.m751equalsimpl0(i17, LineIndex.m748constructorimpl(0)) && i16 < 0) {
                    roundToInt += i16;
                    i16 = 0;
                }
                List arrayList = new ArrayList();
                int i18 = i16 - i13;
                int i19 = -i13;
                while (i18 < 0 && i17 - LineIndex.m748constructorimpl(0) > 0) {
                    i17 = LineIndex.m748constructorimpl(i17 - 1);
                    LazyMeasuredLine r8 = lazyMeasuredLineProvider2.m745getAndMeasurebKFJvoY(i17);
                    arrayList.add(0, r8);
                    i18 += r8.getMainAxisSizeWithSpacings();
                }
                if (i18 < i19) {
                    roundToInt += i18;
                    i18 = i19;
                }
                int i20 = i18 + i13;
                int i21 = i12 + i5;
                int i22 = i17;
                int coerceAtLeast = RangesKt.coerceAtLeast(i21, 0);
                int i23 = -i20;
                int i24 = i20;
                int size = arrayList.size();
                int i25 = i22;
                int i26 = i21;
                for (int i27 = 0; i27 < size; i27++) {
                    i25 = LineIndex.m748constructorimpl(i25 + 1);
                    i23 += ((LazyMeasuredLine) arrayList.get(i27)).getMainAxisSizeWithSpacings();
                }
                int i28 = i24;
                int i29 = i25;
                while (true) {
                    if (i23 > coerceAtLeast && !arrayList.isEmpty()) {
                        break;
                    }
                    int i30 = coerceAtLeast;
                    LazyMeasuredLine r7 = lazyMeasuredLineProvider2.m745getAndMeasurebKFJvoY(i29);
                    if (r7.isEmpty()) {
                        LineIndex.m748constructorimpl(i29 - 1);
                        break;
                    }
                    int i31 = i19;
                    int i32 = i26;
                    i23 += r7.getMainAxisSizeWithSpacings();
                    if (i23 > i31 || ((LazyMeasuredItem) ArraysKt.last((T[]) r7.getItems())).m740getIndexVZbfaAc() == i - 1) {
                        arrayList.add(r7);
                        i11 = i22;
                    } else {
                        i11 = LineIndex.m748constructorimpl(i29 + 1);
                        i28 -= r7.getMainAxisSizeWithSpacings();
                    }
                    i29 = LineIndex.m748constructorimpl(i29 + 1);
                    coerceAtLeast = i30;
                    i22 = i11;
                    i19 = i31;
                    i26 = i32;
                    lazyMeasuredLineProvider2 = lazyMeasuredLineProvider;
                    LazyMeasuredItemProvider lazyMeasuredItemProvider2 = lazyMeasuredItemProvider;
                }
                if (i23 < i12) {
                    int i33 = i12 - i23;
                    i28 -= i33;
                    i23 += i33;
                    int i34 = i22;
                    while (i28 < i13 && i34 - LineIndex.m748constructorimpl(0) > 0) {
                        i34 = LineIndex.m748constructorimpl(i34 - 1);
                        int i35 = i19;
                        LazyMeasuredLine r9 = lazyMeasuredLineProvider2.m745getAndMeasurebKFJvoY(i34);
                        arrayList.add(0, r9);
                        i28 += r9.getMainAxisSizeWithSpacings();
                        LazyMeasuredItemProvider lazyMeasuredItemProvider3 = lazyMeasuredItemProvider;
                        i19 = i35;
                    }
                    i8 = i19;
                    roundToInt += i33;
                    if (i28 < 0) {
                        roundToInt += i28;
                        i23 += i28;
                        i28 = 0;
                    }
                } else {
                    i8 = i19;
                }
                float f2 = (MathKt.getSign(MathKt.roundToInt(f)) != MathKt.getSign(roundToInt) || Math.abs(MathKt.roundToInt(f)) < Math.abs(roundToInt)) ? f : (float) roundToInt;
                int i36 = -i28;
                LazyMeasuredLine lazyMeasuredLine2 = (LazyMeasuredLine) CollectionsKt.first(arrayList);
                if (i13 > 0) {
                    int size2 = arrayList.size();
                    LazyMeasuredLine lazyMeasuredLine3 = lazyMeasuredLine2;
                    int i37 = 0;
                    while (i37 < size2) {
                        int mainAxisSizeWithSpacings = ((LazyMeasuredLine) arrayList.get(i37)).getMainAxisSizeWithSpacings();
                        if (i28 == 0 || mainAxisSizeWithSpacings > i28 || i37 == CollectionsKt.getLastIndex(arrayList)) {
                            break;
                        }
                        i28 -= mainAxisSizeWithSpacings;
                        i37++;
                        lazyMeasuredLine3 = (LazyMeasuredLine) arrayList.get(i37);
                    }
                    lazyMeasuredLine = lazyMeasuredLine3;
                } else {
                    lazyMeasuredLine = lazyMeasuredLine2;
                }
                int i38 = i28;
                if (z) {
                    i9 = Constraints.m4624getMaxWidthimpl(j);
                } else {
                    i9 = ConstraintsKt.m4638constrainWidthK40F9xA(j2, i23);
                }
                int i39 = i9;
                if (z) {
                    i10 = ConstraintsKt.m4637constrainHeightK40F9xA(j2, i23);
                } else {
                    i10 = Constraints.m4623getMaxHeightimpl(j);
                }
                int i40 = i10;
                int i41 = i26;
                float f3 = f2;
                List<LazyGridPositionedItem> calculateItemsOffsets = calculateItemsOffsets(arrayList, i39, i40, i23, i2, i36, z, vertical, horizontal, z2, density);
                int i42 = i23;
                int i43 = i8;
                lazyGridItemPlacementAnimator.onMeasured((int) f3, i39, i40, i3, z2, calculateItemsOffsets, lazyMeasuredItemProvider);
                boolean z3 = i42 > i12;
                float f4 = f3;
                MeasureResult measureResult2 = (MeasureResult) function3.invoke(Integer.valueOf(i39), Integer.valueOf(i40), new LazyGridMeasureKt$measureLazyGrid$3(calculateItemsOffsets));
                if (z) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                return new LazyGridMeasureResult(lazyMeasuredLine, i38, z3, f4, measureResult2, calculateItemsOffsets, i43, i41, i, z2, orientation, i5);
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private static final List<LazyGridPositionedItem> calculateItemsOffsets(List<LazyMeasuredLine> list, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        List<LazyMeasuredLine> list2 = list;
        int i6 = i2;
        Arrangement.Vertical vertical2 = vertical;
        boolean z3 = z2;
        int i7 = i4;
        int i8 = z ? i6 : i;
        boolean z4 = true;
        boolean z5 = i3 < Math.min(i8, i7);
        if (z5) {
            if (i5 != 0) {
                z4 = false;
            }
            if (!z4) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        int size = list.size();
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            i9 += list.get(i10).getItems().length;
        }
        ArrayList arrayList = new ArrayList(i9);
        if (z5) {
            int size2 = list.size();
            int[] iArr = new int[size2];
            for (int i11 = 0; i11 < size2; i11++) {
                iArr[i11] = list.get(calculateItemsOffsets$reverseAware(i11, z3, size2)).getMainAxisSize();
            }
            int[] iArr2 = new int[size2];
            for (int i12 = 0; i12 < size2; i12++) {
                iArr2[i12] = 0;
            }
            if (!z) {
                Density density2 = density;
                if (horizontal != null) {
                    horizontal.arrange(density, i8, iArr, LayoutDirection.Ltr, iArr2);
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else if (vertical2 != null) {
                vertical2.arrange(density, i8, iArr, iArr2);
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            IntProgression indices = ArraysKt.getIndices(iArr2);
            if (z3) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int i13 = iArr2[first];
                    LazyMeasuredLine lazyMeasuredLine = list.get(calculateItemsOffsets$reverseAware(first, z3, size2));
                    if (z3) {
                        i13 = (i8 - i13) - lazyMeasuredLine.getMainAxisSize();
                    }
                    arrayList.addAll(lazyMeasuredLine.position(i13, i, i6));
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size3 = list.size();
            int i14 = i5;
            for (int i15 = 0; i15 < size3; i15++) {
                LazyMeasuredLine lazyMeasuredLine2 = list.get(i15);
                arrayList.addAll(lazyMeasuredLine2.position(i14, i, i6));
                i14 += lazyMeasuredLine2.getMainAxisSizeWithSpacings();
            }
        }
        return arrayList;
    }
}
