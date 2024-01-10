package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J\"\u0010\t\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016J/\u0010\u000b\u001a\u00020\f*\u00020\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0013\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J\"\u0010\u0014\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"androidx/compose/foundation/layout/RowColumnImplKt$rowColumnMeasurePolicy$1", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RowColumnImpl.kt */
public final class RowColumnImplKt$rowColumnMeasurePolicy$1 implements MeasurePolicy {
    final /* synthetic */ Function5<Integer, int[], LayoutDirection, Density, int[], Unit> $arrangement;
    final /* synthetic */ float $arrangementSpacing;
    final /* synthetic */ CrossAxisAlignment $crossAxisAlignment;
    final /* synthetic */ SizeMode $crossAxisSize;
    final /* synthetic */ LayoutOrientation $orientation;

    RowColumnImplKt$rowColumnMeasurePolicy$1(LayoutOrientation layoutOrientation, float f, SizeMode sizeMode, Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> function5, CrossAxisAlignment crossAxisAlignment) {
        this.$orientation = layoutOrientation;
        this.$arrangementSpacing = f;
        this.$crossAxisSize = sizeMode;
        this.$arrangement = function5;
        this.$crossAxisAlignment = crossAxisAlignment;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m554measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f;
        int i6;
        int i7;
        RowColumnParentData[] rowColumnParentDataArr;
        int i8;
        int i9;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        Intrinsics.checkNotNullParameter(measureScope2, "$this$measure");
        Intrinsics.checkNotNullParameter(list2, "measurables");
        OrientationIndependentConstraints orientationIndependentConstraints = new OrientationIndependentConstraints(j, this.$orientation, (DefaultConstructorMarker) null);
        int r11 = measureScope2.m4643roundToPx0680j_4(this.$arrangementSpacing);
        int size = list.size();
        Placeable[] placeableArr = new Placeable[size];
        int size2 = list.size();
        RowColumnParentData[] rowColumnParentDataArr2 = new RowColumnParentData[size2];
        for (int i10 = 0; i10 < size2; i10++) {
            rowColumnParentDataArr2[i10] = RowColumnImplKt.getData((IntrinsicMeasurable) list2.get(i10));
        }
        int size3 = list.size();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        float f2 = 0.0f;
        int i15 = 0;
        boolean z = false;
        while (i13 < size3) {
            Measurable measurable = (Measurable) list2.get(i13);
            RowColumnParentData rowColumnParentData = rowColumnParentDataArr2[i13];
            float access$getWeight = RowColumnImplKt.getWeight(rowColumnParentData);
            if (access$getWeight > 0.0f) {
                f2 += access$getWeight;
                i14++;
                i9 = i13;
                i8 = size3;
                rowColumnParentDataArr = rowColumnParentDataArr2;
            } else {
                int mainAxisMax = orientationIndependentConstraints.getMainAxisMax();
                int i16 = mainAxisMax;
                i9 = i13;
                i8 = size3;
                rowColumnParentDataArr = rowColumnParentDataArr2;
                Placeable r3 = measurable.m3649measureBRTryo0(OrientationIndependentConstraints.copy$default(orientationIndependentConstraints, 0, mainAxisMax == Integer.MAX_VALUE ? Integer.MAX_VALUE : mainAxisMax - i15, 0, 0, 8, (Object) null).m502toBoxConstraintsOenEA2s(this.$orientation));
                int min = Math.min(r11, (i16 - i15) - RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(r3, this.$orientation));
                i15 += RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(r3, this.$orientation) + min;
                i12 = Math.max(i12, RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(r3, this.$orientation));
                boolean z2 = z || RowColumnImplKt.isRelative(rowColumnParentData);
                placeableArr[i9] = r3;
                i11 = min;
                z = z2;
            }
            i13 = i9 + 1;
            size3 = i8;
            rowColumnParentDataArr2 = rowColumnParentDataArr;
        }
        int i17 = i12;
        RowColumnParentData[] rowColumnParentDataArr3 = rowColumnParentDataArr2;
        if (i14 == 0) {
            i15 -= i11;
            i2 = i17;
            i = 0;
        } else {
            int i18 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i18 <= 0 || orientationIndependentConstraints.getMainAxisMax() == Integer.MAX_VALUE) {
                i5 = orientationIndependentConstraints.getMainAxisMin();
            } else {
                i5 = orientationIndependentConstraints.getMainAxisMax();
            }
            int i19 = r11 * (i14 - 1);
            int i20 = (i5 - i15) - i19;
            float f3 = i18 > 0 ? ((float) i20) / f2 : 0.0f;
            int i21 = 0;
            for (int i22 = 0; i22 < size2; i22++) {
                i21 += MathKt.roundToInt(RowColumnImplKt.getWeight(rowColumnParentDataArr3[i22]) * f3);
            }
            int size4 = list.size();
            int i23 = i20 - i21;
            i2 = i17;
            int i24 = 0;
            int i25 = 0;
            while (i24 < size4) {
                if (placeableArr[i24] == null) {
                    Measurable measurable2 = (Measurable) list2.get(i24);
                    RowColumnParentData rowColumnParentData2 = rowColumnParentDataArr3[i24];
                    float access$getWeight2 = RowColumnImplKt.getWeight(rowColumnParentData2);
                    if (access$getWeight2 > 0.0f) {
                        int sign = MathKt.getSign(i23);
                        int i26 = i23 - sign;
                        int max = Math.max(0, MathKt.roundToInt(access$getWeight2 * f3) + sign);
                        f = f3;
                        if (!RowColumnImplKt.getFill(rowColumnParentData2) || max == Integer.MAX_VALUE) {
                            i6 = size4;
                            i7 = 0;
                        } else {
                            i7 = max;
                            i6 = size4;
                        }
                        int i27 = i26;
                        Placeable r2 = measurable2.m3649measureBRTryo0(new OrientationIndependentConstraints(i7, max, 0, orientationIndependentConstraints.getCrossAxisMax()).m502toBoxConstraintsOenEA2s(this.$orientation));
                        i25 += RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(r2, this.$orientation);
                        i2 = Math.max(i2, RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(r2, this.$orientation));
                        boolean z3 = z || RowColumnImplKt.isRelative(rowColumnParentData2);
                        placeableArr[i24] = r2;
                        z = z3;
                        i23 = i27;
                    } else {
                        throw new IllegalStateException("All weights <= 0 should have placeables".toString());
                    }
                } else {
                    f = f3;
                    i6 = size4;
                }
                i24++;
                list2 = list;
                f3 = f;
                size4 = i6;
            }
            i = RangesKt.coerceAtMost(i25 + i19, orientationIndependentConstraints.getMainAxisMax() - i15);
        }
        Ref.IntRef intRef = new Ref.IntRef();
        if (z) {
            i3 = 0;
            for (int i28 = 0; i28 < size; i28++) {
                Placeable placeable = placeableArr[i28];
                Intrinsics.checkNotNull(placeable);
                CrossAxisAlignment access$getCrossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(rowColumnParentDataArr3[i28]);
                Integer calculateAlignmentLinePosition$foundation_layout_release = access$getCrossAxisAlignment != null ? access$getCrossAxisAlignment.calculateAlignmentLinePosition$foundation_layout_release(placeable) : null;
                if (calculateAlignmentLinePosition$foundation_layout_release != null) {
                    int i29 = intRef.element;
                    Number number = calculateAlignmentLinePosition$foundation_layout_release;
                    int intValue = number.intValue();
                    if (intValue == Integer.MIN_VALUE) {
                        intValue = 0;
                    }
                    intRef.element = Math.max(i29, intValue);
                    int access$rowColumnMeasurePolicy_TDGSqEk$crossAxisSize = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeable, this.$orientation);
                    LayoutOrientation layoutOrientation = this.$orientation;
                    int intValue2 = number.intValue();
                    if (intValue2 == Integer.MIN_VALUE) {
                        intValue2 = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeable, layoutOrientation);
                    }
                    i3 = Math.max(i3, access$rowColumnMeasurePolicy_TDGSqEk$crossAxisSize - intValue2);
                }
            }
        } else {
            i3 = 0;
        }
        int max2 = Math.max(i15 + i, orientationIndependentConstraints.getMainAxisMin());
        if (orientationIndependentConstraints.getCrossAxisMax() == Integer.MAX_VALUE || this.$crossAxisSize != SizeMode.Expand) {
            i4 = Math.max(i2, Math.max(orientationIndependentConstraints.getCrossAxisMin(), intRef.element + i3));
        } else {
            i4 = orientationIndependentConstraints.getCrossAxisMax();
        }
        int i30 = i4;
        int i31 = this.$orientation == LayoutOrientation.Horizontal ? max2 : i30;
        int i32 = this.$orientation == LayoutOrientation.Horizontal ? i30 : max2;
        int size5 = list.size();
        int[] iArr = new int[size5];
        for (int i33 = 0; i33 < size5; i33++) {
            iArr[i33] = 0;
        }
        return MeasureScope.CC.layout$default(measureScope, i31, i32, (Map) null, new RowColumnImplKt$rowColumnMeasurePolicy$1$measure$4(list, placeableArr, this.$arrangement, max2, measureScope, iArr, this.$orientation, rowColumnParentDataArr3, this.$crossAxisAlignment, i30, intRef), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return ((Number) RowColumnImplKt.MinIntrinsicWidthMeasureBlock(this.$orientation).invoke(list, Integer.valueOf(i), Integer.valueOf(intrinsicMeasureScope.m4643roundToPx0680j_4(this.$arrangementSpacing)))).intValue();
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return ((Number) RowColumnImplKt.MinIntrinsicHeightMeasureBlock(this.$orientation).invoke(list, Integer.valueOf(i), Integer.valueOf(intrinsicMeasureScope.m4643roundToPx0680j_4(this.$arrangementSpacing)))).intValue();
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return ((Number) RowColumnImplKt.MaxIntrinsicWidthMeasureBlock(this.$orientation).invoke(list, Integer.valueOf(i), Integer.valueOf(intrinsicMeasureScope.m4643roundToPx0680j_4(this.$arrangementSpacing)))).intValue();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return ((Number) RowColumnImplKt.MaxIntrinsicHeightMeasureBlock(this.$orientation).invoke(list, Integer.valueOf(i), Integer.valueOf(intrinsicMeasureScope.m4643roundToPx0680j_4(this.$arrangementSpacing)))).intValue();
    }
}
