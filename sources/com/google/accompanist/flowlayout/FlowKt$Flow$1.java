package com.google.accompanist.flowlayout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Flow.kt */
final class FlowKt$Flow$1 implements MeasurePolicy {
    final /* synthetic */ FlowCrossAxisAlignment $crossAxisAlignment;
    final /* synthetic */ float $crossAxisSpacing;
    final /* synthetic */ MainAxisAlignment $lastLineMainAxisAlignment;
    final /* synthetic */ MainAxisAlignment $mainAxisAlignment;
    final /* synthetic */ SizeMode $mainAxisSize;
    final /* synthetic */ float $mainAxisSpacing;
    final /* synthetic */ LayoutOrientation $orientation;

    FlowKt$Flow$1(LayoutOrientation layoutOrientation, float f, SizeMode sizeMode, float f2, MainAxisAlignment mainAxisAlignment, MainAxisAlignment mainAxisAlignment2, FlowCrossAxisAlignment flowCrossAxisAlignment) {
        this.$orientation = layoutOrientation;
        this.$mainAxisSpacing = f;
        this.$mainAxisSize = sizeMode;
        this.$crossAxisSpacing = f2;
        this.$mainAxisAlignment = mainAxisAlignment;
        this.$lastLineMainAxisAlignment = mainAxisAlignment2;
        this.$crossAxisAlignment = flowCrossAxisAlignment;
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m5052measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        long j2;
        int i;
        Ref.IntRef intRef;
        Ref.IntRef intRef2;
        List list2;
        List list3;
        MeasureScope measureScope2 = measureScope;
        Intrinsics.checkNotNullParameter(measureScope2, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        Ref.IntRef intRef3 = new Ref.IntRef();
        Ref.IntRef intRef4 = new Ref.IntRef();
        List arrayList4 = new ArrayList();
        Ref.IntRef intRef5 = new Ref.IntRef();
        Ref.IntRef intRef6 = new Ref.IntRef();
        OrientationIndependentConstraints orientationIndependentConstraints = new OrientationIndependentConstraints(j, this.$orientation, (DefaultConstructorMarker) null);
        if (this.$orientation == LayoutOrientation.Horizontal) {
            j2 = ConstraintsKt.Constraints$default(0, orientationIndependentConstraints.getMainAxisMax(), 0, 0, 13, (Object) null);
        } else {
            j2 = ConstraintsKt.Constraints$default(0, 0, 0, orientationIndependentConstraints.getMainAxisMax(), 7, (Object) null);
        }
        long j3 = j2;
        for (Measurable r1 : list) {
            Placeable r24 = r1.m3649measureBRTryo0(j3);
            long j4 = j3;
            OrientationIndependentConstraints orientationIndependentConstraints2 = orientationIndependentConstraints;
            Ref.IntRef intRef7 = intRef6;
            if (!measure_3p2s80s$canAddToCurrentSequence(arrayList4, intRef5, measureScope, this.$mainAxisSpacing, orientationIndependentConstraints, this.$orientation, r24)) {
                intRef = intRef5;
                List list4 = arrayList3;
                list2 = arrayList3;
                list3 = arrayList4;
                intRef2 = intRef4;
                measure_3p2s80s$startNewSequence(arrayList, intRef4, measureScope, this.$crossAxisSpacing, arrayList4, arrayList2, intRef7, list4, intRef3, intRef);
            } else {
                intRef = intRef5;
                intRef2 = intRef4;
                list2 = arrayList3;
                list3 = arrayList4;
            }
            Ref.IntRef intRef8 = intRef;
            if (!list3.isEmpty()) {
                intRef8.element += measureScope2.m4643roundToPx0680j_4(this.$mainAxisSpacing);
            }
            Placeable placeable = r24;
            list3.add(placeable);
            intRef8.element += FlowKt.Flow_F4y8cZ0$mainAxisSize(placeable, this.$orientation);
            intRef6 = intRef7;
            intRef6.element = Math.max(intRef6.element, FlowKt.Flow_F4y8cZ0$crossAxisSize(placeable, this.$orientation));
            intRef5 = intRef8;
            arrayList4 = list3;
            arrayList3 = list2;
            orientationIndependentConstraints = orientationIndependentConstraints2;
            j3 = j4;
            intRef4 = intRef2;
        }
        OrientationIndependentConstraints orientationIndependentConstraints3 = orientationIndependentConstraints;
        Ref.IntRef intRef9 = intRef4;
        List list5 = arrayList3;
        Ref.IntRef intRef10 = intRef5;
        List list6 = arrayList4;
        if (!list6.isEmpty()) {
            measure_3p2s80s$startNewSequence(arrayList, intRef9, measureScope, this.$crossAxisSpacing, list6, arrayList2, intRef6, list5, intRef3, intRef10);
        }
        if (orientationIndependentConstraints3.getMainAxisMax() == Integer.MAX_VALUE || this.$mainAxisSize != SizeMode.Expand) {
            i = Math.max(intRef3.element, orientationIndependentConstraints3.getMainAxisMin());
        } else {
            i = orientationIndependentConstraints3.getMainAxisMax();
        }
        int i2 = i;
        int max = Math.max(intRef9.element, orientationIndependentConstraints3.getCrossAxisMin());
        return MeasureScope.CC.layout$default(measureScope, this.$orientation == LayoutOrientation.Horizontal ? i2 : max, this.$orientation == LayoutOrientation.Horizontal ? max : i2, (Map) null, new FlowKt$Flow$1$measure$1(arrayList, measureScope, this.$mainAxisSpacing, this.$mainAxisAlignment, this.$lastLineMainAxisAlignment, this.$orientation, i2, this.$crossAxisAlignment, arrayList2, list5), 4, (Object) null);
    }

    private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> list, Ref.IntRef intRef, MeasureScope measureScope, float f, OrientationIndependentConstraints orientationIndependentConstraints, LayoutOrientation layoutOrientation, Placeable placeable) {
        return list.isEmpty() || (intRef.element + measureScope.m4643roundToPx0680j_4(f)) + FlowKt.Flow_F4y8cZ0$mainAxisSize(placeable, layoutOrientation) <= orientationIndependentConstraints.getMainAxisMax();
    }

    private static final void measure_3p2s80s$startNewSequence(List<List<Placeable>> list, Ref.IntRef intRef, MeasureScope measureScope, float f, List<Placeable> list2, List<Integer> list3, Ref.IntRef intRef2, List<Integer> list4, Ref.IntRef intRef3, Ref.IntRef intRef4) {
        Collection collection = list;
        if (!collection.isEmpty()) {
            intRef.element += measureScope.m4643roundToPx0680j_4(f);
        }
        collection.add(CollectionsKt.toList(list2));
        list3.add(Integer.valueOf(intRef2.element));
        list4.add(Integer.valueOf(intRef.element));
        intRef.element += intRef2.element;
        intRef3.element = Math.max(intRef3.element, intRef4.element);
        list2.clear();
        intRef4.element = 0;
        intRef2.element = 0;
    }
}
