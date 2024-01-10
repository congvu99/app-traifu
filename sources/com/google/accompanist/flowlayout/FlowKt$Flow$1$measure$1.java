package com.google.accompanist.flowlayout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Flow.kt */
final class FlowKt$Flow$1$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ FlowCrossAxisAlignment $crossAxisAlignment;
    final /* synthetic */ List<Integer> $crossAxisPositions;
    final /* synthetic */ List<Integer> $crossAxisSizes;
    final /* synthetic */ MainAxisAlignment $lastLineMainAxisAlignment;
    final /* synthetic */ MainAxisAlignment $mainAxisAlignment;
    final /* synthetic */ int $mainAxisLayoutSize;
    final /* synthetic */ float $mainAxisSpacing;
    final /* synthetic */ LayoutOrientation $orientation;
    final /* synthetic */ List<List<Placeable>> $sequences;
    final /* synthetic */ MeasureScope $this_Layout;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Flow.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FlowCrossAxisAlignment.values().length];
            iArr[FlowCrossAxisAlignment.Start.ordinal()] = 1;
            iArr[FlowCrossAxisAlignment.End.ordinal()] = 2;
            iArr[FlowCrossAxisAlignment.Center.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt$Flow$1$measure$1(List<List<Placeable>> list, MeasureScope measureScope, float f, MainAxisAlignment mainAxisAlignment, MainAxisAlignment mainAxisAlignment2, LayoutOrientation layoutOrientation, int i, FlowCrossAxisAlignment flowCrossAxisAlignment, List<Integer> list2, List<Integer> list3) {
        super(1);
        this.$sequences = list;
        this.$this_Layout = measureScope;
        this.$mainAxisSpacing = f;
        this.$mainAxisAlignment = mainAxisAlignment;
        this.$lastLineMainAxisAlignment = mainAxisAlignment2;
        this.$orientation = layoutOrientation;
        this.$mainAxisLayoutSize = i;
        this.$crossAxisAlignment = flowCrossAxisAlignment;
        this.$crossAxisSizes = list2;
        this.$crossAxisPositions = list3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Arrangement.Vertical vertical;
        int i;
        int i2;
        FlowCrossAxisAlignment flowCrossAxisAlignment;
        List<Integer> list;
        List<Integer> list2;
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        List<List<Placeable>> list3 = this.$sequences;
        MeasureScope measureScope = this.$this_Layout;
        float f = this.$mainAxisSpacing;
        MainAxisAlignment mainAxisAlignment = this.$mainAxisAlignment;
        MainAxisAlignment mainAxisAlignment2 = this.$lastLineMainAxisAlignment;
        LayoutOrientation layoutOrientation = this.$orientation;
        int i3 = this.$mainAxisLayoutSize;
        FlowCrossAxisAlignment flowCrossAxisAlignment2 = this.$crossAxisAlignment;
        List<Integer> list4 = this.$crossAxisSizes;
        List<Integer> list5 = this.$crossAxisPositions;
        int i4 = 0;
        for (Object next : list3) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            List list6 = (List) next;
            int size = list6.size();
            int[] iArr = new int[size];
            int i6 = 0;
            while (i6 < size) {
                List<Integer> list7 = list5;
                iArr[i6] = FlowKt.Flow_F4y8cZ0$mainAxisSize((Placeable) list6.get(i6), layoutOrientation) + (i6 < CollectionsKt.getLastIndex(list6) ? measureScope.m4643roundToPx0680j_4(f) : 0);
                i6++;
                Placeable.PlacementScope placementScope2 = placementScope;
                list5 = list7;
            }
            List<Integer> list8 = list5;
            if (i4 < CollectionsKt.getLastIndex(list3)) {
                vertical = mainAxisAlignment.getArrangement$flowlayout_release();
            } else {
                vertical = mainAxisAlignment2.getArrangement$flowlayout_release();
            }
            int[] iArr2 = new int[size];
            for (int i7 = 0; i7 < size; i7++) {
                iArr2[i7] = 0;
            }
            vertical.arrange(measureScope, i3, iArr, iArr2);
            int i8 = 0;
            for (Object next2 : list6) {
                int i9 = i8 + 1;
                if (i8 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Placeable placeable = (Placeable) next2;
                int i10 = WhenMappings.$EnumSwitchMapping$0[flowCrossAxisAlignment2.ordinal()];
                if (i10 == 1) {
                    i = 0;
                } else if (i10 == 2) {
                    i = list4.get(i4).intValue() - FlowKt.Flow_F4y8cZ0$crossAxisSize(placeable, layoutOrientation);
                } else if (i10 == 3) {
                    i = IntOffset.m4823getYimpl(Alignment.Companion.getCenter().m1561alignKFBX0sM(IntSize.Companion.m4869getZeroYbymL2g(), IntSizeKt.IntSize(0, list4.get(i4).intValue() - FlowKt.Flow_F4y8cZ0$crossAxisSize(placeable, layoutOrientation)), LayoutDirection.Ltr));
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                if (layoutOrientation == LayoutOrientation.Horizontal) {
                    int i11 = iArr2[i8];
                    List<Integer> list9 = list8;
                    list = list4;
                    flowCrossAxisAlignment = flowCrossAxisAlignment2;
                    Placeable.PlacementScope.place$default(placementScope, placeable, i11, list9.get(i4).intValue() + i, 0.0f, 4, (Object) null);
                    i2 = i4;
                    list2 = list9;
                } else {
                    flowCrossAxisAlignment = flowCrossAxisAlignment2;
                    List<Integer> list10 = list8;
                    list = list4;
                    int i12 = i4;
                    i2 = i12;
                    list2 = list10;
                    Placeable.PlacementScope.place$default(placementScope, placeable, list10.get(i12).intValue() + i, iArr2[i8], 0.0f, 4, (Object) null);
                }
                list4 = list;
                i8 = i9;
                flowCrossAxisAlignment2 = flowCrossAxisAlignment;
                i4 = i2;
                list8 = list2;
            }
            Placeable.PlacementScope placementScope3 = placementScope;
            i4 = i5;
            list5 = list8;
        }
    }
}
