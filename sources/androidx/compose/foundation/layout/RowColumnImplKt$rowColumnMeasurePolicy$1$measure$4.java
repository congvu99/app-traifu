package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: RowColumnImpl.kt */
final class RowColumnImplKt$rowColumnMeasurePolicy$1$measure$4 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Function5<Integer, int[], LayoutDirection, Density, int[], Unit> $arrangement;
    final /* synthetic */ Ref.IntRef $beforeCrossAxisAlignmentLine;
    final /* synthetic */ CrossAxisAlignment $crossAxisAlignment;
    final /* synthetic */ int $crossAxisLayoutSize;
    final /* synthetic */ int $mainAxisLayoutSize;
    final /* synthetic */ int[] $mainAxisPositions;
    final /* synthetic */ List<Measurable> $measurables;
    final /* synthetic */ LayoutOrientation $orientation;
    final /* synthetic */ Placeable[] $placeables;
    final /* synthetic */ RowColumnParentData[] $rowColumnParentData;
    final /* synthetic */ MeasureScope $this_measure;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RowColumnImplKt$rowColumnMeasurePolicy$1$measure$4(List<? extends Measurable> list, Placeable[] placeableArr, Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> function5, int i, MeasureScope measureScope, int[] iArr, LayoutOrientation layoutOrientation, RowColumnParentData[] rowColumnParentDataArr, CrossAxisAlignment crossAxisAlignment, int i2, Ref.IntRef intRef) {
        super(1);
        this.$measurables = list;
        this.$placeables = placeableArr;
        this.$arrangement = function5;
        this.$mainAxisLayoutSize = i;
        this.$this_measure = measureScope;
        this.$mainAxisPositions = iArr;
        this.$orientation = layoutOrientation;
        this.$rowColumnParentData = rowColumnParentDataArr;
        this.$crossAxisAlignment = crossAxisAlignment;
        this.$crossAxisLayoutSize = i2;
        this.$beforeCrossAxisAlignmentLine = intRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        LayoutDirection layoutDirection;
        int i;
        int i2;
        int[] iArr;
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        int size = this.$measurables.size();
        int[] iArr2 = new int[size];
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Placeable placeable = this.$placeables[i4];
            Intrinsics.checkNotNull(placeable);
            iArr2[i4] = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(placeable, this.$orientation);
        }
        this.$arrangement.invoke(Integer.valueOf(this.$mainAxisLayoutSize), iArr2, this.$this_measure.getLayoutDirection(), this.$this_measure, this.$mainAxisPositions);
        Placeable[] placeableArr = this.$placeables;
        RowColumnParentData[] rowColumnParentDataArr = this.$rowColumnParentData;
        CrossAxisAlignment crossAxisAlignment = this.$crossAxisAlignment;
        int i5 = this.$crossAxisLayoutSize;
        LayoutOrientation layoutOrientation = this.$orientation;
        MeasureScope measureScope = this.$this_measure;
        Ref.IntRef intRef = this.$beforeCrossAxisAlignmentLine;
        int[] iArr3 = this.$mainAxisPositions;
        int length = placeableArr.length;
        int i6 = 0;
        while (i3 < length) {
            Placeable placeable2 = placeableArr[i3];
            int i7 = i6 + 1;
            Intrinsics.checkNotNull(placeable2);
            CrossAxisAlignment access$getCrossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(rowColumnParentDataArr[i6]);
            if (access$getCrossAxisAlignment == null) {
                access$getCrossAxisAlignment = crossAxisAlignment;
            }
            int access$rowColumnMeasurePolicy_TDGSqEk$crossAxisSize = i5 - RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeable2, layoutOrientation);
            if (layoutOrientation == LayoutOrientation.Horizontal) {
                layoutDirection = LayoutDirection.Ltr;
            } else {
                layoutDirection = measureScope.getLayoutDirection();
            }
            Placeable[] placeableArr2 = placeableArr;
            int align$foundation_layout_release = access$getCrossAxisAlignment.align$foundation_layout_release(access$rowColumnMeasurePolicy_TDGSqEk$crossAxisSize, layoutDirection, placeable2, intRef.element);
            if (layoutOrientation == LayoutOrientation.Horizontal) {
                i = length;
                iArr = iArr3;
                i2 = i3;
                Placeable.PlacementScope.place$default(placementScope, placeable2, iArr3[i6], align$foundation_layout_release, 0.0f, 4, (Object) null);
            } else {
                i = length;
                iArr = iArr3;
                i2 = i3;
                Placeable.PlacementScope.place$default(placementScope, placeable2, align$foundation_layout_release, iArr[i6], 0.0f, 4, (Object) null);
            }
            i3 = i2 + 1;
            iArr3 = iArr;
            i6 = i7;
            placeableArr = placeableArr2;
            length = i;
        }
    }
}
