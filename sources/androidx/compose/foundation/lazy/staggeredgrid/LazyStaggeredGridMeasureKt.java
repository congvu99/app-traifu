package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u001c\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a\u001c\u0010\n\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a\f\u0010\u000b\u001a\u00020\u0006*\u00020\u0004H\u0002\u001a2\u0010\f\u001a\u00020\u0006\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00060\u0010H\b¢\u0006\u0002\u0010\u0011\u001a\f\u0010\u0012\u001a\u00020\u0006*\u00020\u0004H\u0000\u001a,\u0010\u0013\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0003\u001aq\u0010\u001a\u001a\u00020\u0014*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,\u001a\u0014\u0010-\u001a\u00020\u0001*\u00020\u00042\u0006\u0010.\u001a\u00020\u0006H\u0002\u001a!\u0010/\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0010H\b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00060"}, d2 = {"ensureIndicesInRange", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "indices", "", "itemCount", "", "findNextItemIndex", "item", "lane", "findPreviousItemIndex", "indexOfMaxValue", "indexOfMinBy", "T", "", "block", "Lkotlin/Function1;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMinValue", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "initialScrollDelta", "initialItemIndices", "initialItemOffsets", "canRestartMeasure", "", "measureStaggeredGrid", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "resolvedSlotSums", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "crossAxisSpacing", "beforeContentPadding", "afterContentPadding", "measureStaggeredGrid-yR9pz_M", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;[IJZJIIIII)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "offsetBy", "delta", "transform", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyStaggeredGridMeasure.kt */
public final class LazyStaggeredGridMeasureKt {
    @ExperimentalFoundationApi
    /* renamed from: measureStaggeredGrid-yR9pz_M  reason: not valid java name */
    public static final LazyStaggeredGridMeasureResult m809measureStaggeredGridyR9pz_M(LazyLayoutMeasureScope lazyLayoutMeasureScope, LazyStaggeredGridState lazyStaggeredGridState, LazyLayoutItemProvider lazyLayoutItemProvider, int[] iArr, long j, boolean z, long j2, int i, int i2, int i3, int i4, int i5) {
        Snapshot makeCurrent;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext;
        Object obj;
        Object obj2;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext2;
        int i6;
        int i7;
        int[] iArr2 = iArr;
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope2, "$this$measureStaggeredGrid");
        Intrinsics.checkNotNullParameter(lazyStaggeredGridState, "state");
        LazyLayoutItemProvider lazyLayoutItemProvider2 = lazyLayoutItemProvider;
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider2, "itemProvider");
        Intrinsics.checkNotNullParameter(iArr2, "resolvedSlotSums");
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext3 = r1;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext4 = new LazyStaggeredGridMeasureContext(lazyStaggeredGridState, lazyLayoutItemProvider2, iArr, j, z, lazyLayoutMeasureScope2, i, j2, i4, i5, i2, i3, (DefaultConstructorMarker) null);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            makeCurrent = createNonObservableSnapshot.makeCurrent();
            int[] indices = lazyStaggeredGridState.getScrollPosition$foundation_release().getIndices();
            int[] offsets = lazyStaggeredGridState.getScrollPosition$foundation_release().getOffsets();
            if (indices.length == iArr2.length) {
                lazyStaggeredGridMeasureContext = lazyStaggeredGridMeasureContext3;
                obj = indices;
            } else {
                lazyStaggeredGridMeasureContext3.getSpans().reset();
                int length = iArr2.length;
                int[] iArr3 = new int[length];
                int i8 = 0;
                while (i8 < length) {
                    if (i8 < indices.length) {
                        i7 = indices[i8];
                    } else if (i8 == 0) {
                        i7 = 0;
                    } else {
                        lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext3;
                        i6 = findNextItemIndex(lazyStaggeredGridMeasureContext2, iArr3[i8 - 1], i8);
                        iArr3[i8] = i6;
                        lazyStaggeredGridMeasureContext2.getSpans().setSpan(iArr3[i8], i8);
                        i8++;
                        lazyStaggeredGridMeasureContext3 = lazyStaggeredGridMeasureContext2;
                    }
                    lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext3;
                    i6 = i7;
                    iArr3[i8] = i6;
                    lazyStaggeredGridMeasureContext2.getSpans().setSpan(iArr3[i8], i8);
                    i8++;
                    lazyStaggeredGridMeasureContext3 = lazyStaggeredGridMeasureContext2;
                }
                lazyStaggeredGridMeasureContext = lazyStaggeredGridMeasureContext3;
                obj = iArr3;
            }
            objectRef.element = obj;
            if (offsets.length == iArr2.length) {
                obj2 = offsets;
            } else {
                int length2 = iArr2.length;
                int[] iArr4 = new int[length2];
                int i9 = 0;
                while (i9 < length2) {
                    iArr4[i9] = i9 < offsets.length ? offsets[i9] : i9 == 0 ? 0 : iArr4[i9 - 1];
                    i9++;
                }
                obj2 = iArr4;
            }
            objectRef2.element = obj2;
            Unit unit = Unit.INSTANCE;
            createNonObservableSnapshot.restoreCurrent(makeCurrent);
            createNonObservableSnapshot.dispose();
            return measure(lazyStaggeredGridMeasureContext, MathKt.roundToInt(lazyStaggeredGridState.getScrollToBeConsumed$foundation_release()), (int[]) objectRef.element, (int[]) objectRef2.element, true);
        } catch (Throwable th) {
            createNonObservableSnapshot.dispose();
            throw th;
        }
    }

    @ExperimentalFoundationApi
    private static final LazyStaggeredGridMeasureResult measure(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int[] iArr, int[] iArr2, boolean z) {
        int i2;
        int i3;
        boolean z2;
        boolean z3;
        int[] iArr3;
        int[] iArr4;
        int i4;
        float f;
        int i5;
        int i6;
        boolean z4;
        boolean z5;
        int i7;
        int i8;
        int i9;
        boolean z6;
        int i10;
        int i11;
        boolean z7;
        int i12;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
        int i13 = i;
        int[] iArr5 = iArr;
        int[] iArr6 = iArr2;
        LazyLayoutMeasureScope measureScope = lazyStaggeredGridMeasureContext.getMeasureScope();
        int itemCount = lazyStaggeredGridMeasureContext.getItemProvider().getItemCount();
        if (itemCount > 0) {
            if (!(lazyStaggeredGridMeasureContext.getResolvedSlotSums().length == 0)) {
                int[] copyOf = Arrays.copyOf(iArr5, iArr5.length);
                String str = "copyOf(this, size)";
                Intrinsics.checkNotNullExpressionValue(copyOf, str);
                int[] copyOf2 = Arrays.copyOf(iArr6, iArr6.length);
                Intrinsics.checkNotNullExpressionValue(copyOf2, str);
                ensureIndicesInRange(lazyStaggeredGridMeasureContext2, copyOf, itemCount);
                offsetBy(copyOf2, -i13);
                int length = lazyStaggeredGridMeasureContext.getResolvedSlotSums().length;
                ArrayDeque[] arrayDequeArr = new ArrayDeque[length];
                for (int i14 = 0; i14 < length; i14++) {
                    arrayDequeArr[i14] = new ArrayDeque();
                }
                offsetBy(copyOf2, -lazyStaggeredGridMeasureContext.getBeforeContentPadding());
                while (true) {
                    if (!m807measure$lambda17$hasSpaceBeforeFirst(copyOf, copyOf2, lazyStaggeredGridMeasureContext2)) {
                        i2 = -1;
                        break;
                    }
                    i2 = indexOfMinValue(copyOf2);
                    int findPreviousItemIndex = findPreviousItemIndex(lazyStaggeredGridMeasureContext2, copyOf[i2], i2);
                    if (findPreviousItemIndex < 0) {
                        break;
                    }
                    if (lazyStaggeredGridMeasureContext.getSpans().getSpan(findPreviousItemIndex) == -1) {
                        lazyStaggeredGridMeasureContext.getSpans().setSpan(findPreviousItemIndex, i2);
                    }
                    LazyStaggeredGridMeasuredItem andMeasure = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getAndMeasure(findPreviousItemIndex, i2);
                    arrayDequeArr[i2].addFirst(andMeasure);
                    copyOf[i2] = findPreviousItemIndex;
                    copyOf2[i2] = copyOf2[i2] + andMeasure.getSizeWithSpacings();
                }
                int i15 = -lazyStaggeredGridMeasureContext.getBeforeContentPadding();
                if (copyOf2[0] < i15) {
                    i3 = copyOf2[0] + i13;
                    offsetBy(copyOf2, i15 - copyOf2[0]);
                } else {
                    i3 = i13;
                }
                offsetBy(copyOf2, lazyStaggeredGridMeasureContext.getBeforeContentPadding());
                if (i2 == -1) {
                    i2 = ArraysKt.indexOf(copyOf, 0);
                }
                if (i2 == -1 || !m808measure$lambda17$misalignedStart(copyOf, lazyStaggeredGridMeasureContext2, copyOf2, i2) || !z) {
                    int[] copyOf3 = Arrays.copyOf(iArr5, iArr5.length);
                    Intrinsics.checkNotNullExpressionValue(copyOf3, str);
                    ensureIndicesInRange(lazyStaggeredGridMeasureContext2, copyOf3, itemCount);
                    Unit unit = Unit.INSTANCE;
                    int length2 = iArr6.length;
                    int[] iArr7 = new int[length2];
                    LazyLayoutMeasureScope lazyLayoutMeasureScope = measureScope;
                    int i16 = 0;
                    while (i16 < length2) {
                        iArr7[i16] = -(iArr6[i16] - i3);
                        i16++;
                        str = str;
                    }
                    String str2 = str;
                    int coerceAtLeast = RangesKt.coerceAtLeast(lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext.getAfterContentPadding(), 0);
                    int length3 = copyOf3.length;
                    int[] iArr8 = copyOf;
                    int i17 = i3;
                    int i18 = 0;
                    int i19 = 0;
                    while (i19 < length3) {
                        int i20 = length3;
                        int i21 = copyOf3[i19];
                        int i22 = i18 + 1;
                        int[] iArr9 = copyOf2;
                        if (i21 >= 0) {
                            LazyStaggeredGridMeasuredItem andMeasure2 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getAndMeasure(i21, i18);
                            iArr7[i18] = iArr7[i18] + andMeasure2.getSizeWithSpacings();
                            i12 = i15;
                            arrayDequeArr[i18].addLast(andMeasure2);
                            lazyStaggeredGridMeasureContext.getSpans().setSpan(i21, i18);
                        } else {
                            i12 = i15;
                        }
                        i19++;
                        length3 = i20;
                        i18 = i22;
                        copyOf2 = iArr9;
                        i15 = i12;
                    }
                    int[] iArr10 = copyOf2;
                    int i23 = i15;
                    while (true) {
                        int i24 = 0;
                        while (true) {
                            if (i24 >= length2) {
                                z2 = false;
                                break;
                            }
                            if (iArr7[i24] <= coerceAtLeast) {
                                z2 = true;
                                break;
                            }
                            i24++;
                        }
                        if (!z2) {
                            int i25 = 0;
                            while (true) {
                                if (i25 >= length) {
                                    z7 = true;
                                    break;
                                } else if (!arrayDequeArr[i25].isEmpty()) {
                                    z7 = false;
                                    break;
                                } else {
                                    i25++;
                                }
                            }
                            if (!z7) {
                                break;
                            }
                        }
                        int indexOfMinValue = indexOfMinValue(iArr7);
                        int findNextItemIndex = findNextItemIndex(lazyStaggeredGridMeasureContext2, copyOf3[indexOfMinValue], indexOfMinValue);
                        if (findNextItemIndex >= itemCount) {
                            int length4 = copyOf3.length;
                            int i26 = Integer.MAX_VALUE;
                            int i27 = 0;
                            int i28 = 0;
                            while (i27 < length4) {
                                int i29 = length4;
                                int i30 = copyOf3[i27];
                                int i31 = i28 + 1;
                                if (i28 != indexOfMinValue) {
                                    int findNextItemIndex2 = findNextItemIndex(lazyStaggeredGridMeasureContext2, i30, i28);
                                    while (findNextItemIndex2 < itemCount) {
                                        int min = Math.min(findNextItemIndex2, i26);
                                        lazyStaggeredGridMeasureContext.getSpans().setSpan(findNextItemIndex2, -1);
                                        findNextItemIndex2 = findNextItemIndex(lazyStaggeredGridMeasureContext2, findNextItemIndex2, i28);
                                        i26 = min;
                                        copyOf3 = copyOf3;
                                    }
                                }
                                i27++;
                                length4 = i29;
                                i28 = i31;
                                copyOf3 = copyOf3;
                            }
                            if (i26 != Integer.MAX_VALUE && z) {
                                iArr5[indexOfMinValue] = Math.min(iArr5[indexOfMinValue], i26);
                                return measure(lazyStaggeredGridMeasureContext2, i13, iArr5, iArr6, false);
                            }
                        } else {
                            int[] iArr11 = copyOf3;
                            int i32 = i17;
                            String str3 = str2;
                            int[] iArr12 = iArr8;
                            int[] iArr13 = iArr10;
                            int i33 = i23;
                            int i34 = length;
                            if (iArr12[indexOfMinValue] == -1) {
                                iArr12[indexOfMinValue] = findNextItemIndex;
                            }
                            lazyStaggeredGridMeasureContext.getSpans().setSpan(findNextItemIndex, indexOfMinValue);
                            LazyStaggeredGridMeasuredItem andMeasure3 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getAndMeasure(findNextItemIndex, indexOfMinValue);
                            iArr7[indexOfMinValue] = iArr7[indexOfMinValue] + andMeasure3.getSizeWithSpacings();
                            arrayDequeArr[indexOfMinValue].addLast(andMeasure3);
                            iArr11[indexOfMinValue] = findNextItemIndex;
                            str2 = str3;
                            iArr10 = iArr13;
                            iArr8 = iArr12;
                            i23 = i33;
                            length = i34;
                            copyOf3 = iArr11;
                            lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
                            i17 = i32;
                        }
                    }
                    for (int i35 = 0; i35 < length; i35++) {
                        ArrayDeque arrayDeque = arrayDequeArr[i35];
                        int i36 = iArr7[i35];
                        int lastIndex = CollectionsKt.getLastIndex(arrayDeque);
                        int i37 = 0;
                        int i38 = -1;
                        while (true) {
                            if (i38 >= lastIndex) {
                                lastIndex = i37;
                                break;
                            }
                            i36 -= ((LazyStaggeredGridMeasuredItem) arrayDeque.get(lastIndex)).getSizeWithSpacings();
                            if (i36 <= i23 + lazyStaggeredGridMeasureContext.getMainAxisSpacing()) {
                                break;
                            }
                            i38 = -1;
                            i37 = lastIndex;
                            lastIndex--;
                        }
                        for (int i39 = 0; i39 < lastIndex; i39++) {
                            iArr10[i35] = iArr10[i35] - ((LazyStaggeredGridMeasuredItem) arrayDeque.removeFirst()).getSizeWithSpacings();
                        }
                        if (!arrayDeque.isEmpty()) {
                            iArr8[i35] = ((LazyStaggeredGridMeasuredItem) arrayDeque.first()).getIndex();
                        }
                    }
                    int i40 = 0;
                    while (true) {
                        if (i40 >= length2) {
                            z3 = true;
                            break;
                        }
                        if (!(iArr7[i40] < lazyStaggeredGridMeasureContext.getMainAxisAvailableSize())) {
                            z3 = false;
                            break;
                        }
                        i40++;
                    }
                    if (z3) {
                        int mainAxisAvailableSize = lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() - iArr7[indexOfMaxValue(iArr7)];
                        iArr4 = iArr10;
                        offsetBy(iArr4, -mainAxisAvailableSize);
                        offsetBy(iArr7, mainAxisAvailableSize);
                        while (true) {
                            int length5 = iArr4.length;
                            int i41 = 0;
                            while (true) {
                                if (i41 >= length5) {
                                    z6 = false;
                                    break;
                                }
                                if (iArr4[i41] < lazyStaggeredGridMeasureContext.getBeforeContentPadding()) {
                                    z6 = true;
                                    break;
                                }
                                i41++;
                            }
                            if (!z6) {
                                i10 = i17;
                                iArr3 = iArr8;
                                break;
                            }
                            int indexOfMinValue2 = indexOfMinValue(iArr4);
                            if (iArr8[indexOfMinValue2] == -1) {
                                i11 = itemCount;
                            } else {
                                i11 = iArr8[indexOfMinValue2];
                            }
                            int findPreviousItemIndex2 = findPreviousItemIndex(lazyStaggeredGridMeasureContext2, i11, indexOfMinValue2);
                            if (findPreviousItemIndex2 < 0) {
                                iArr3 = iArr8;
                                if (!m808measure$lambda17$misalignedStart(iArr3, lazyStaggeredGridMeasureContext2, iArr4, indexOfMinValue2) || !z) {
                                    i10 = i17;
                                } else {
                                    lazyStaggeredGridMeasureContext.getSpans().reset();
                                    int length6 = iArr3.length;
                                    int[] iArr14 = new int[length6];
                                    for (int i42 = 0; i42 < length6; i42++) {
                                        iArr14[i42] = -1;
                                    }
                                    int length7 = iArr4.length;
                                    int[] iArr15 = new int[length7];
                                    for (int i43 = 0; i43 < length7; i43++) {
                                        iArr15[i43] = iArr4[indexOfMinValue2];
                                    }
                                    return measure(lazyStaggeredGridMeasureContext2, i17, iArr14, iArr15, false);
                                }
                            } else {
                                int i44 = i17;
                                lazyStaggeredGridMeasureContext.getSpans().setSpan(findPreviousItemIndex2, indexOfMinValue2);
                                LazyStaggeredGridMeasuredItem andMeasure4 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getAndMeasure(findPreviousItemIndex2, indexOfMinValue2);
                                arrayDequeArr[indexOfMinValue2].addFirst(andMeasure4);
                                iArr4[indexOfMinValue2] = iArr4[indexOfMinValue2] + andMeasure4.getSizeWithSpacings();
                                iArr8[indexOfMinValue2] = findPreviousItemIndex2;
                            }
                        }
                        i4 = i10 + mainAxisAvailableSize;
                        int indexOfMinValue3 = indexOfMinValue(iArr4);
                        if (iArr4[indexOfMinValue3] < 0) {
                            int i45 = iArr4[indexOfMinValue3];
                            i4 += i45;
                            offsetBy(iArr7, i45);
                            offsetBy(iArr4, -i45);
                        }
                    } else {
                        i4 = i17;
                        iArr3 = iArr8;
                        iArr4 = iArr10;
                    }
                    if (MathKt.getSign(MathKt.roundToInt(lazyStaggeredGridMeasureContext.getState().getScrollToBeConsumed$foundation_release())) != MathKt.getSign(i4) || Math.abs(MathKt.roundToInt(lazyStaggeredGridMeasureContext.getState().getScrollToBeConsumed$foundation_release())) < Math.abs(i4)) {
                        f = lazyStaggeredGridMeasureContext.getState().getScrollToBeConsumed$foundation_release();
                    } else {
                        f = (float) i4;
                    }
                    int[] copyOf4 = Arrays.copyOf(iArr4, iArr4.length);
                    Intrinsics.checkNotNullExpressionValue(copyOf4, str2);
                    int length8 = copyOf4.length;
                    for (int i46 = 0; i46 < length8; i46++) {
                        copyOf4[i46] = -copyOf4[i46];
                    }
                    if (lazyStaggeredGridMeasureContext.getBeforeContentPadding() > 0) {
                        int i47 = 0;
                        while (i47 < length) {
                            ArrayDeque arrayDeque2 = arrayDequeArr[i47];
                            int size = arrayDeque2.size();
                            int i48 = 0;
                            while (i48 < size) {
                                int sizeWithSpacings = ((LazyStaggeredGridMeasuredItem) arrayDeque2.get(i48)).getSizeWithSpacings();
                                if (i48 == CollectionsKt.getLastIndex(arrayDeque2) || iArr4[i47] == 0 || iArr4[i47] < sizeWithSpacings) {
                                    break;
                                }
                                iArr4[i47] = iArr4[i47] - sizeWithSpacings;
                                i48++;
                                iArr3[i47] = ((LazyStaggeredGridMeasuredItem) arrayDeque2.get(i48)).getIndex();
                                LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext3 = lazyStaggeredGridMeasureContext;
                            }
                            i47++;
                            LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext4 = lazyStaggeredGridMeasureContext;
                        }
                    }
                    if (lazyStaggeredGridMeasureContext.isVertical()) {
                        i5 = Constraints.m4624getMaxWidthimpl(lazyStaggeredGridMeasureContext.m805getConstraintsmsEJaDk());
                    } else {
                        i5 = ConstraintsKt.m4638constrainWidthK40F9xA(lazyStaggeredGridMeasureContext.m805getConstraintsmsEJaDk(), ArraysKt.maxOrThrow(iArr7));
                    }
                    if (lazyStaggeredGridMeasureContext.isVertical()) {
                        i6 = ConstraintsKt.m4637constrainHeightK40F9xA(lazyStaggeredGridMeasureContext.m805getConstraintsmsEJaDk(), ArraysKt.maxOrThrow(iArr7));
                    } else {
                        i6 = Constraints.m4623getMaxHeightimpl(lazyStaggeredGridMeasureContext.m805getConstraintsmsEJaDk());
                    }
                    int i49 = 0;
                    for (int i50 = 0; i50 < length; i50++) {
                        i49 += arrayDequeArr[i50].size();
                    }
                    MutableVector mutableVector = new MutableVector(new LazyStaggeredGridPositionedItem[i49], 0);
                    while (true) {
                        int i51 = 0;
                        while (true) {
                            if (i51 >= length) {
                                z4 = false;
                                break;
                            } else if (!arrayDequeArr[i51].isEmpty()) {
                                z4 = true;
                                break;
                            } else {
                                i51++;
                            }
                        }
                        if (!z4) {
                            break;
                        }
                        int i52 = -1;
                        int i53 = 0;
                        int i54 = Integer.MAX_VALUE;
                        while (i53 < length) {
                            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) arrayDequeArr[i53].firstOrNull();
                            if (lazyStaggeredGridMeasuredItem != null) {
                                int index = lazyStaggeredGridMeasuredItem.getIndex();
                                i8 = length;
                                i9 = index;
                            } else {
                                i8 = length;
                                i9 = Integer.MAX_VALUE;
                            }
                            if (i54 > i9) {
                                i52 = i53;
                                i54 = i9;
                            }
                            i53++;
                            length = i8;
                        }
                        int i55 = length;
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = (LazyStaggeredGridMeasuredItem) arrayDequeArr[i52].removeFirst();
                        int i56 = copyOf4[i52];
                        if (i52 == 0) {
                            i7 = 0;
                        } else {
                            i7 = lazyStaggeredGridMeasureContext.getResolvedSlotSums()[i52 - 1] + (lazyStaggeredGridMeasureContext.getCrossAxisSpacing() * i52);
                        }
                        mutableVector.add(lazyStaggeredGridMeasuredItem2.position(i52, i56, i7));
                        copyOf4[i52] = copyOf4[i52] + lazyStaggeredGridMeasuredItem2.getSizeWithSpacings();
                        length = i55;
                    }
                    boolean z8 = iArr3[0] != 0 || iArr4[0] > 0;
                    int i57 = 0;
                    while (true) {
                        if (i57 >= length2) {
                            z5 = false;
                            break;
                        }
                        if (iArr7[i57] > lazyStaggeredGridMeasureContext.getMainAxisAvailableSize()) {
                            z5 = true;
                            break;
                        }
                        i57++;
                    }
                    return new LazyStaggeredGridMeasureResult(iArr3, iArr4, f, MeasureScope.CC.layout$default(lazyLayoutMeasureScope, i5, i6, (Map) null, new LazyStaggeredGridMeasureKt$measure$1$13(mutableVector), 4, (Object) null), z5, z8, itemCount, mutableVector.asMutableList(), IntSizeKt.IntSize(i5, i6), i23, coerceAtLeast, lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), (DefaultConstructorMarker) null);
                }
                lazyStaggeredGridMeasureContext.getSpans().reset();
                int length9 = copyOf.length;
                int[] iArr16 = new int[length9];
                for (int i58 = 0; i58 < length9; i58++) {
                    iArr16[i58] = -1;
                }
                int length10 = copyOf2.length;
                int[] iArr17 = new int[length10];
                for (int i59 = 0; i59 < length10; i59++) {
                    iArr17[i59] = copyOf2[i2];
                }
                return measure(lazyStaggeredGridMeasureContext2, i3, iArr16, iArr17, false);
            }
        }
        return new LazyStaggeredGridMeasureResult(iArr, iArr2, 0.0f, MeasureScope.CC.layout$default(measureScope, Constraints.m4626getMinWidthimpl(lazyStaggeredGridMeasureContext.m805getConstraintsmsEJaDk()), Constraints.m4625getMinHeightimpl(lazyStaggeredGridMeasureContext.m805getConstraintsmsEJaDk()), (Map) null, LazyStaggeredGridMeasureKt$measure$1$1.INSTANCE, 4, (Object) null), false, false, itemCount, CollectionsKt.emptyList(), IntSizeKt.IntSize(Constraints.m4626getMinWidthimpl(lazyStaggeredGridMeasureContext.m805getConstraintsmsEJaDk()), Constraints.m4625getMinHeightimpl(lazyStaggeredGridMeasureContext.m805getConstraintsmsEJaDk())), -lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), (DefaultConstructorMarker) null);
    }

    /* renamed from: measure$lambda-17$hasSpaceBeforeFirst  reason: not valid java name */
    private static final boolean m807measure$lambda17$hasSpaceBeforeFirst(int[] iArr, int[] iArr2, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            if (iArr2[i] < (-lazyStaggeredGridMeasureContext.getMainAxisSpacing()) && i2 > 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0048 A[EDGE_INSN: B:43:0x0048->B:19:0x0048 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: measure$lambda-17$misalignedStart  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean m808measure$lambda17$misalignedStart(int[] r8, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext r9, int[] r10, int r11) {
        /*
            kotlin.ranges.IntRange r0 = kotlin.collections.ArraysKt.getIndices((int[]) r8)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            r2 = -1
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0018
            r5 = r0
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0018
        L_0x0016:
            r5 = 0
            goto L_0x003d
        L_0x0018:
            java.util.Iterator r5 = r0.iterator()
        L_0x001c:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0016
            r6 = r5
            kotlin.collections.IntIterator r6 = (kotlin.collections.IntIterator) r6
            int r6 = r6.nextInt()
            r7 = r8[r6]
            int r7 = findPreviousItemIndex(r9, r7, r6)
            if (r7 != r2) goto L_0x0039
            r6 = r10[r6]
            r7 = r10[r11]
            if (r6 == r7) goto L_0x0039
            r6 = 1
            goto L_0x003a
        L_0x0039:
            r6 = 0
        L_0x003a:
            if (r6 == 0) goto L_0x001c
            r5 = 1
        L_0x003d:
            if (r1 == 0) goto L_0x004a
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x004a
        L_0x0048:
            r8 = 0
            goto L_0x006f
        L_0x004a:
            java.util.Iterator r0 = r0.iterator()
        L_0x004e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0048
            r1 = r0
            kotlin.collections.IntIterator r1 = (kotlin.collections.IntIterator) r1
            int r1 = r1.nextInt()
            r6 = r8[r1]
            int r6 = findPreviousItemIndex(r9, r6, r1)
            if (r6 == r2) goto L_0x006b
            r1 = r10[r1]
            r6 = r10[r11]
            if (r1 < r6) goto L_0x006b
            r1 = 1
            goto L_0x006c
        L_0x006b:
            r1 = 0
        L_0x006c:
            if (r1 == 0) goto L_0x004e
            r8 = 1
        L_0x006f:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSpans r9 = r9.getSpans()
            int r9 = r9.getSpan(r4)
            if (r9 == 0) goto L_0x007b
            r9 = 1
            goto L_0x007c
        L_0x007b:
            r9 = 0
        L_0x007c:
            if (r5 != 0) goto L_0x0084
            if (r8 != 0) goto L_0x0084
            if (r9 == 0) goto L_0x0083
            goto L_0x0084
        L_0x0083:
            r3 = 0
        L_0x0084:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt.m808measure$lambda17$misalignedStart(int[], androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext, int[], int):boolean");
    }

    private static final void offsetBy(int[] iArr, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = iArr[i2] + i;
        }
    }

    public static final int indexOfMinValue(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        int i = -1;
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            if (i2 > iArr[i3]) {
                i2 = iArr[i3];
                i = i3;
            }
        }
        return i;
    }

    private static final <T> int indexOfMinBy(T[] tArr, Function1<? super T, Integer> function1) {
        int length = tArr.length;
        int i = -1;
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int intValue = function1.invoke(tArr[i3]).intValue();
            if (i2 > intValue) {
                i = i3;
                i2 = intValue;
            }
        }
        return i;
    }

    private static final int indexOfMaxValue(int[] iArr) {
        int length = iArr.length;
        int i = -1;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            if (i2 < iArr[i3]) {
                i2 = iArr[i3];
                i = i3;
            }
        }
        return i;
    }

    private static final int[] transform(int[] iArr, Function1<? super Integer, Integer> function1) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = function1.invoke(Integer.valueOf(iArr[i])).intValue();
        }
        return iArr;
    }

    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr, int i) {
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                while (iArr[length] >= i) {
                    iArr[length] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[length], length);
                }
                if (iArr[length] != -1) {
                    lazyStaggeredGridMeasureContext.getSpans().setSpan(iArr[length], length);
                }
                if (i2 >= 0) {
                    length = i2;
                } else {
                    return;
                }
            }
        }
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2) {
        return lazyStaggeredGridMeasureContext.getSpans().findPreviousItemIndex(i, i2);
    }

    private static final int findNextItemIndex(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2) {
        return lazyStaggeredGridMeasureContext.getSpans().findNextItemIndex(i, i2);
    }
}
