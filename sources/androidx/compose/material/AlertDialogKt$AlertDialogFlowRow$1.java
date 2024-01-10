package androidx.compose.material;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlertDialog.kt */
final class AlertDialogKt$AlertDialogFlowRow$1 implements MeasurePolicy {
    final /* synthetic */ float $crossAxisSpacing;
    final /* synthetic */ float $mainAxisSpacing;

    AlertDialogKt$AlertDialogFlowRow$1(float f, float f2) {
        this.$mainAxisSpacing = f;
        this.$crossAxisSpacing = f2;
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
    public final MeasureResult m1113measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int i;
        Ref.IntRef intRef;
        List list2;
        Ref.IntRef intRef2;
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
        long Constraints$default = ConstraintsKt.Constraints$default(0, Constraints.m4624getMaxWidthimpl(j), 0, 0, 13, (Object) null);
        for (Measurable r1 : list) {
            Placeable r25 = r1.m3649measureBRTryo0(Constraints$default);
            long j2 = Constraints$default;
            Ref.IntRef intRef7 = intRef6;
            if (!measure_3p2s80s$canAddToCurrentSequence(arrayList4, intRef5, measureScope, this.$mainAxisSpacing, j, r25)) {
                intRef2 = intRef5;
                List list4 = arrayList3;
                list2 = arrayList3;
                list3 = arrayList4;
                intRef = intRef4;
                measure_3p2s80s$startNewSequence(arrayList, intRef4, measureScope, this.$crossAxisSpacing, arrayList4, arrayList2, intRef7, list4, intRef3, intRef2);
            } else {
                intRef2 = intRef5;
                intRef = intRef4;
                list2 = arrayList3;
                list3 = arrayList4;
            }
            Ref.IntRef intRef8 = intRef2;
            if (!list3.isEmpty()) {
                intRef8.element += measureScope2.m4643roundToPx0680j_4(this.$mainAxisSpacing);
            }
            Placeable placeable = r25;
            list3.add(placeable);
            intRef8.element += placeable.getWidth();
            intRef6 = intRef7;
            intRef6.element = Math.max(intRef6.element, placeable.getHeight());
            intRef5 = intRef8;
            arrayList4 = list3;
            Constraints$default = j2;
            arrayList3 = list2;
            intRef4 = intRef;
        }
        Ref.IntRef intRef9 = intRef4;
        List list5 = arrayList3;
        Ref.IntRef intRef10 = intRef5;
        List list6 = arrayList4;
        if (!list6.isEmpty()) {
            measure_3p2s80s$startNewSequence(arrayList, intRef9, measureScope, this.$crossAxisSpacing, list6, arrayList2, intRef6, list5, intRef3, intRef10);
        }
        if (Constraints.m4624getMaxWidthimpl(j) != Integer.MAX_VALUE) {
            i = Constraints.m4624getMaxWidthimpl(j);
        } else {
            i = Math.max(intRef3.element, Constraints.m4626getMinWidthimpl(j));
        }
        int i2 = i;
        return MeasureScope.CC.layout$default(measureScope, i2, Math.max(intRef9.element, Constraints.m4625getMinHeightimpl(j)), (Map) null, new AlertDialogKt$AlertDialogFlowRow$1$measure$1(arrayList, measureScope, this.$mainAxisSpacing, i2, list5), 4, (Object) null);
    }

    private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> list, Ref.IntRef intRef, MeasureScope measureScope, float f, long j, Placeable placeable) {
        return list.isEmpty() || (intRef.element + measureScope.m4643roundToPx0680j_4(f)) + placeable.getWidth() <= Constraints.m4624getMaxWidthimpl(j);
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
