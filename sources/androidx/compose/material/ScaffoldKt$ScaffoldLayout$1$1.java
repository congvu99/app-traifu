package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Scaffold.kt */
final class ScaffoldKt$ScaffoldLayout$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $bottomBar;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ Function2<Composer, Integer, Unit> $fab;
    final /* synthetic */ int $fabPosition;
    final /* synthetic */ boolean $isFabDocked;
    final /* synthetic */ Function2<Composer, Integer, Unit> $snackbar;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScaffoldKt$ScaffoldLayout$1$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i, boolean z, Function2<? super Composer, ? super Integer, Unit> function24, int i2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$topBar = function2;
        this.$snackbar = function22;
        this.$fab = function23;
        this.$fabPosition = i;
        this.$isFabDocked = z;
        this.$bottomBar = function24;
        this.$$dirty = i2;
        this.$content = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m1391invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m4630unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m1391invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
        final SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope2, "$this$SubcomposeLayout");
        int r15 = Constraints.m4624getMaxWidthimpl(j);
        int r16 = Constraints.m4623getMaxHeightimpl(j);
        final long r10 = Constraints.m4615copyZbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
        final Function2<Composer, Integer, Unit> function2 = this.$topBar;
        final Function2<Composer, Integer, Unit> function22 = this.$snackbar;
        final Function2<Composer, Integer, Unit> function23 = this.$fab;
        final int i = this.$fabPosition;
        final boolean z = this.$isFabDocked;
        final Function2<Composer, Integer, Unit> function24 = this.$bottomBar;
        final int i2 = this.$$dirty;
        final Function3<PaddingValues, Composer, Integer, Unit> function3 = this.$content;
        final int i3 = r15;
        final int i4 = r16;
        return MeasureScope.CC.layout$default(subcomposeMeasureScope2, r15, r16, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Object obj;
                Object obj2;
                FabPlacement fabPlacement;
                Object obj3;
                Integer num;
                int i;
                int i2;
                int height;
                int r3;
                Object obj4;
                Object obj5;
                int i3;
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                List<Measurable> subcompose = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.TopBar, function2);
                long j = r10;
                ArrayList arrayList = new ArrayList(subcompose.size());
                int size = subcompose.size();
                for (int i4 = 0; i4 < size; i4++) {
                    arrayList.add(subcompose.get(i4).m3649measureBRTryo0(j));
                }
                List list = arrayList;
                if (list.isEmpty()) {
                    obj = null;
                } else {
                    obj = list.get(0);
                    int height2 = ((Placeable) obj).getHeight();
                    int lastIndex = CollectionsKt.getLastIndex(list);
                    if (1 <= lastIndex) {
                        int i5 = 1;
                        while (true) {
                            Object obj6 = list.get(i5);
                            int height3 = ((Placeable) obj6).getHeight();
                            if (height2 < height3) {
                                obj = obj6;
                                height2 = height3;
                            }
                            if (i5 == lastIndex) {
                                break;
                            }
                            i5++;
                        }
                    }
                }
                Placeable placeable = (Placeable) obj;
                int height4 = placeable != null ? placeable.getHeight() : 0;
                List<Measurable> subcompose2 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.Snackbar, function22);
                long j2 = r10;
                ArrayList arrayList2 = new ArrayList(subcompose2.size());
                int size2 = subcompose2.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    arrayList2.add(subcompose2.get(i6).m3649measureBRTryo0(j2));
                }
                List list2 = arrayList2;
                if (list2.isEmpty()) {
                    obj2 = null;
                } else {
                    obj2 = list2.get(0);
                    int height5 = ((Placeable) obj2).getHeight();
                    int lastIndex2 = CollectionsKt.getLastIndex(list2);
                    if (1 <= lastIndex2) {
                        int i7 = 1;
                        while (true) {
                            Object obj7 = list2.get(i7);
                            int height6 = ((Placeable) obj7).getHeight();
                            if (height5 < height6) {
                                obj2 = obj7;
                                height5 = height6;
                            }
                            if (i7 == lastIndex2) {
                                break;
                            }
                            i7++;
                        }
                    }
                }
                Placeable placeable2 = (Placeable) obj2;
                int height7 = placeable2 != null ? placeable2.getHeight() : 0;
                long j3 = r10;
                Collection arrayList3 = new ArrayList();
                for (Measurable r13 : subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.Fab, function23)) {
                    Placeable r132 = r13.m3649measureBRTryo0(j3);
                    if (!((r132.getHeight() == 0 || r132.getWidth() == 0) ? false : true)) {
                        r132 = null;
                    }
                    if (r132 != null) {
                        arrayList3.add(r132);
                    }
                }
                List list3 = (List) arrayList3;
                if (!list3.isEmpty()) {
                    if (list3.isEmpty()) {
                        obj4 = null;
                    } else {
                        obj4 = list3.get(0);
                        int width = ((Placeable) obj4).getWidth();
                        int lastIndex3 = CollectionsKt.getLastIndex(list3);
                        if (1 <= lastIndex3) {
                            int i8 = 1;
                            while (true) {
                                Object obj8 = list3.get(i8);
                                int width2 = ((Placeable) obj8).getWidth();
                                if (width < width2) {
                                    obj4 = obj8;
                                    width = width2;
                                }
                                if (i8 == lastIndex3) {
                                    break;
                                }
                                i8++;
                            }
                        }
                    }
                    Intrinsics.checkNotNull(obj4);
                    int width3 = ((Placeable) obj4).getWidth();
                    if (list3.isEmpty()) {
                        obj5 = null;
                    } else {
                        obj5 = list3.get(0);
                        int height8 = ((Placeable) obj5).getHeight();
                        int lastIndex4 = CollectionsKt.getLastIndex(list3);
                        if (1 <= lastIndex4) {
                            int i9 = 1;
                            while (true) {
                                Object obj9 = list3.get(i9);
                                int height9 = ((Placeable) obj9).getHeight();
                                if (height8 < height9) {
                                    height8 = height9;
                                    obj5 = obj9;
                                }
                                if (i9 == lastIndex4) {
                                    break;
                                }
                                i9++;
                            }
                        }
                    }
                    Intrinsics.checkNotNull(obj5);
                    int height10 = ((Placeable) obj5).getHeight();
                    if (!FabPosition.m1299equalsimpl0(i, FabPosition.Companion.m1304getEnd5ygKITE())) {
                        i3 = (i3 - width3) / 2;
                    } else if (subcomposeMeasureScope2.getLayoutDirection() == LayoutDirection.Ltr) {
                        i3 = (i3 - subcomposeMeasureScope2.m4643roundToPx0680j_4(ScaffoldKt.FabSpacing)) - width3;
                    } else {
                        i3 = subcomposeMeasureScope2.m4643roundToPx0680j_4(ScaffoldKt.FabSpacing);
                    }
                    fabPlacement = new FabPlacement(z, i3, width3, height10);
                } else {
                    fabPlacement = null;
                }
                FabPlacement fabPlacement2 = fabPlacement;
                List<Measurable> subcompose3 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.BottomBar, ComposableLambdaKt.composableLambdaInstance(1529070963, true, new ScaffoldKt$ScaffoldLayout$1$1$1$bottomBarPlaceables$1(fabPlacement2, function24, i2)));
                long j4 = r10;
                ArrayList arrayList4 = new ArrayList(subcompose3.size());
                int size3 = subcompose3.size();
                for (int i10 = 0; i10 < size3; i10++) {
                    arrayList4.add(subcompose3.get(i10).m3649measureBRTryo0(j4));
                }
                List list4 = arrayList4;
                if (list4.isEmpty()) {
                    obj3 = null;
                } else {
                    obj3 = list4.get(0);
                    int height11 = ((Placeable) obj3).getHeight();
                    int lastIndex5 = CollectionsKt.getLastIndex(list4);
                    if (1 <= lastIndex5) {
                        int i11 = 1;
                        while (true) {
                            Object obj10 = list4.get(i11);
                            int height12 = ((Placeable) obj10).getHeight();
                            if (height11 < height12) {
                                obj3 = obj10;
                                height11 = height12;
                            }
                            if (i11 == lastIndex5) {
                                break;
                            }
                            i11++;
                        }
                    }
                }
                Placeable placeable3 = (Placeable) obj3;
                int height13 = placeable3 != null ? placeable3.getHeight() : 0;
                if (fabPlacement2 != null) {
                    SubcomposeMeasureScope subcomposeMeasureScope = subcomposeMeasureScope2;
                    boolean z = z;
                    if (height13 == 0) {
                        height = fabPlacement2.getHeight();
                        r3 = subcomposeMeasureScope.m4643roundToPx0680j_4(ScaffoldKt.FabSpacing);
                    } else if (z) {
                        i2 = height13 + (fabPlacement2.getHeight() / 2);
                        num = Integer.valueOf(i2);
                    } else {
                        height = fabPlacement2.getHeight() + height13;
                        r3 = subcomposeMeasureScope.m4643roundToPx0680j_4(ScaffoldKt.FabSpacing);
                    }
                    i2 = height + r3;
                    num = Integer.valueOf(i2);
                } else {
                    num = null;
                }
                if (height7 != 0) {
                    i = height7 + (num != null ? num.intValue() : height13);
                } else {
                    i = 0;
                }
                int i12 = i4 - height4;
                List<Measurable> subcompose4 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.MainContent, ComposableLambdaKt.composableLambdaInstance(-1132241596, true, new ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1(subcomposeMeasureScope2, height13, function3, i2)));
                long j5 = r10;
                ArrayList arrayList5 = new ArrayList(subcompose4.size());
                int size4 = subcompose4.size();
                int i13 = 0;
                while (i13 < size4) {
                    arrayList5.add(subcompose4.get(i13).m3649measureBRTryo0(Constraints.m4615copyZbe2FdA$default(j5, 0, 0, 0, i12, 7, (Object) null)));
                    i13++;
                    subcompose4 = subcompose4;
                    j5 = j5;
                }
                List list5 = arrayList5;
                int size5 = list5.size();
                int i14 = 0;
                while (i14 < size5) {
                    Placeable.PlacementScope.place$default(placementScope, (Placeable) list5.get(i14), 0, height4, 0.0f, 4, (Object) null);
                    i14++;
                    height13 = height13;
                }
                int i15 = height13;
                int size6 = list.size();
                for (int i16 = 0; i16 < size6; i16++) {
                    Placeable.PlacementScope.place$default(placementScope, (Placeable) list.get(i16), 0, 0, 0.0f, 4, (Object) null);
                }
                int i17 = i4;
                int size7 = list2.size();
                for (int i18 = 0; i18 < size7; i18++) {
                    Placeable.PlacementScope.place$default(placementScope, (Placeable) list2.get(i18), 0, i17 - i, 0.0f, 4, (Object) null);
                }
                int i19 = i4;
                int size8 = list4.size();
                for (int i20 = 0; i20 < size8; i20++) {
                    Placeable.PlacementScope.place$default(placementScope, (Placeable) list4.get(i20), 0, i19 - i15, 0.0f, 4, (Object) null);
                }
                if (fabPlacement2 != null) {
                    int i21 = i4;
                    int size9 = list3.size();
                    for (int i22 = 0; i22 < size9; i22++) {
                        int left = fabPlacement2.getLeft();
                        Intrinsics.checkNotNull(num);
                        Placeable.PlacementScope.place$default(placementScope, (Placeable) list3.get(i22), left, i21 - num.intValue(), 0.0f, 4, (Object) null);
                    }
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }, 4, (Object) null);
    }
}
