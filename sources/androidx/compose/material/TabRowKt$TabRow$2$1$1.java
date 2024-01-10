package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabRow.kt */
final class TabRowKt$TabRow$2$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $divider;
    final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> $indicator;
    final /* synthetic */ Function2<Composer, Integer, Unit> $tabs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabRowKt$TabRow$2$1$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, int i) {
        super(2);
        this.$tabs = function2;
        this.$divider = function22;
        this.$indicator = function3;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m1462invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m4630unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m1462invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
        Object obj;
        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope2, "$this$SubcomposeLayout");
        int r13 = Constraints.m4624getMaxWidthimpl(j);
        List<Measurable> subcompose = subcomposeMeasureScope2.subcompose(TabSlots.Tabs, this.$tabs);
        int size = subcompose.size();
        int i = r13 / size;
        Iterable<Measurable> iterable = subcompose;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Measurable r15 : iterable) {
            arrayList.add(r15.m3649measureBRTryo0(Constraints.m4615copyZbe2FdA$default(j, i, i, 0, 0, 12, (Object) null)));
        }
        List list = (List) arrayList;
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            obj = it.next();
            if (it.hasNext()) {
                int height = ((Placeable) obj).getHeight();
                do {
                    Object next = it.next();
                    int height2 = ((Placeable) next).getHeight();
                    if (height < height2) {
                        obj = next;
                        height = height2;
                    }
                } while (it.hasNext());
            }
        }
        Placeable placeable = (Placeable) obj;
        int height3 = placeable != null ? placeable.getHeight() : 0;
        ArrayList arrayList2 = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList2.add(new TabPosition(Dp.m4704constructorimpl(subcomposeMeasureScope2.m4646toDpu2uoSUM(i) * ((float) i2)), subcomposeMeasureScope2.m4646toDpu2uoSUM(i), (DefaultConstructorMarker) null));
        }
        final List list2 = arrayList2;
        Function2<Composer, Integer, Unit> function2 = this.$divider;
        final Function3<List<TabPosition>, Composer, Integer, Unit> function3 = this.$indicator;
        final int i3 = this.$$dirty;
        final List list3 = list;
        final SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
        final Function2<Composer, Integer, Unit> function22 = function2;
        final int i4 = i;
        final long j2 = j;
        final int i5 = height3;
        final int i6 = r13;
        return MeasureScope.CC.layout$default(subcomposeMeasureScope2, r13, height3, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                int i = i4;
                int i2 = 0;
                for (Object next : list3) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    int i4 = i2 * i;
                    Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) next, i4, 0, 0.0f, 4, (Object) null);
                    i2 = i3;
                }
                long j = j2;
                int i5 = i5;
                for (Measurable r2 : subcomposeMeasureScope3.subcompose(TabSlots.Divider, function22)) {
                    Placeable r3 = r2.m3649measureBRTryo0(Constraints.m4615copyZbe2FdA$default(j, 0, 0, 0, 0, 11, (Object) null));
                    Placeable.PlacementScope.placeRelative$default(placementScope, r3, 0, i5 - r3.getHeight(), 0.0f, 4, (Object) null);
                    i5 = i5;
                    j = j;
                }
                SubcomposeMeasureScope subcomposeMeasureScope = subcomposeMeasureScope3;
                TabSlots tabSlots = TabSlots.Indicator;
                final Function3<List<TabPosition>, Composer, Integer, Unit> function3 = function3;
                final List<TabPosition> list = list2;
                final int i6 = i3;
                int i7 = i6;
                int i8 = i5;
                for (Measurable r22 : subcomposeMeasureScope.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-1341594997, true, new Function2<Composer, Integer, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i) {
                        ComposerKt.sourceInformation(composer, "C176@8330L23:TabRow.kt#jmzs0o");
                        if ((i & 11) != 2 || !composer.getSkipping()) {
                            function3.invoke(list, composer, Integer.valueOf(((i6 >> 9) & 112) | 8));
                        } else {
                            composer.skipToGroupEnd();
                        }
                    }
                }))) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, r22.m3649measureBRTryo0(Constraints.Companion.m4632fixedJhjzzOo(i7, i8)), 0, 0, 0.0f, 4, (Object) null);
                }
            }
        }, 4, (Object) null);
    }
}
