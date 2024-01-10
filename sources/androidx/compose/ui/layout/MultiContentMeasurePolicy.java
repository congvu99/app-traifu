package androidx.compose.ui.layout;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ExperimentalComposeUiApi
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bç\u0001\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J(\u0010\t\u001a\u00020\u0003*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016J5\u0010\u000b\u001a\u00020\f*\u00020\r2\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00060\u00062\u0006\u0010\u000f\u001a\u00020\u0010H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J(\u0010\u0013\u001a\u00020\u0003*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J(\u0010\u0014\u001a\u00020\u0003*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016ø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MultiContentMeasurePolicy.kt */
public interface MultiContentMeasurePolicy {
    int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i);

    int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i);

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    MeasureResult m3677measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j);

    int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i);

    int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i);

    /* renamed from: androidx.compose.ui.layout.MultiContentMeasurePolicy$-CC  reason: invalid class name */
    /* compiled from: MultiContentMeasurePolicy.kt */
    public final /* synthetic */ class CC {
        public static int $default$minIntrinsicWidth(MultiContentMeasurePolicy _this, IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            IntrinsicMeasureScope intrinsicMeasureScope2 = intrinsicMeasureScope;
            List list2 = list;
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope2, "<this>");
            Intrinsics.checkNotNullParameter(list2, "measurables");
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Collection collection = arrayList;
                List list3 = (List) list2.get(i2);
                ArrayList arrayList2 = new ArrayList(list3.size());
                int size2 = list3.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    arrayList2.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) list3.get(i3), IntrinsicMinMax.Min, IntrinsicWidthHeight.Width));
                }
                collection.add(arrayList2);
            }
            long Constraints$default = ConstraintsKt.Constraints$default(0, 0, 0, i, 7, (Object) null);
            MeasureScope intrinsicsMeasureScope = new IntrinsicsMeasureScope(intrinsicMeasureScope2, intrinsicMeasureScope.getLayoutDirection());
            return _this.m3677measure3p2s80s(intrinsicsMeasureScope, arrayList, Constraints$default).getWidth();
        }

        public static int $default$minIntrinsicHeight(MultiContentMeasurePolicy _this, IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            IntrinsicMeasureScope intrinsicMeasureScope2 = intrinsicMeasureScope;
            List list2 = list;
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope2, "<this>");
            Intrinsics.checkNotNullParameter(list2, "measurables");
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Collection collection = arrayList;
                List list3 = (List) list2.get(i2);
                ArrayList arrayList2 = new ArrayList(list3.size());
                int size2 = list3.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    arrayList2.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) list3.get(i3), IntrinsicMinMax.Min, IntrinsicWidthHeight.Height));
                }
                collection.add(arrayList2);
            }
            long Constraints$default = ConstraintsKt.Constraints$default(0, i, 0, 0, 13, (Object) null);
            MeasureScope intrinsicsMeasureScope = new IntrinsicsMeasureScope(intrinsicMeasureScope2, intrinsicMeasureScope.getLayoutDirection());
            return _this.m3677measure3p2s80s(intrinsicsMeasureScope, arrayList, Constraints$default).getHeight();
        }

        public static int $default$maxIntrinsicWidth(MultiContentMeasurePolicy _this, IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            IntrinsicMeasureScope intrinsicMeasureScope2 = intrinsicMeasureScope;
            List list2 = list;
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope2, "<this>");
            Intrinsics.checkNotNullParameter(list2, "measurables");
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Collection collection = arrayList;
                List list3 = (List) list2.get(i2);
                ArrayList arrayList2 = new ArrayList(list3.size());
                int size2 = list3.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    arrayList2.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) list3.get(i3), IntrinsicMinMax.Max, IntrinsicWidthHeight.Width));
                }
                collection.add(arrayList2);
            }
            long Constraints$default = ConstraintsKt.Constraints$default(0, 0, 0, i, 7, (Object) null);
            MeasureScope intrinsicsMeasureScope = new IntrinsicsMeasureScope(intrinsicMeasureScope2, intrinsicMeasureScope.getLayoutDirection());
            return _this.m3677measure3p2s80s(intrinsicsMeasureScope, arrayList, Constraints$default).getWidth();
        }

        public static int $default$maxIntrinsicHeight(MultiContentMeasurePolicy _this, IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            IntrinsicMeasureScope intrinsicMeasureScope2 = intrinsicMeasureScope;
            List list2 = list;
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope2, "<this>");
            Intrinsics.checkNotNullParameter(list2, "measurables");
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Collection collection = arrayList;
                List list3 = (List) list2.get(i2);
                ArrayList arrayList2 = new ArrayList(list3.size());
                int size2 = list3.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    arrayList2.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) list3.get(i3), IntrinsicMinMax.Max, IntrinsicWidthHeight.Height));
                }
                collection.add(arrayList2);
            }
            long Constraints$default = ConstraintsKt.Constraints$default(0, i, 0, 0, 13, (Object) null);
            MeasureScope intrinsicsMeasureScope = new IntrinsicsMeasureScope(intrinsicMeasureScope2, intrinsicMeasureScope.getLayoutDirection());
            return _this.m3677measure3p2s80s(intrinsicsMeasureScope, arrayList, Constraints$default).getHeight();
        }
    }
}
