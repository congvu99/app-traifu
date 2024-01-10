package androidx.compose.material;

import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Snackbar.kt */
final class SnackbarKt$OneRowSnackbar$2 implements MeasurePolicy {
    final /* synthetic */ String $actionTag;
    final /* synthetic */ String $textTag;

    SnackbarKt$OneRowSnackbar$2(String str, String str2) {
        this.$actionTag = str;
        this.$textTag = str2;
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
    public final MeasureResult m1401measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int i;
        int i2;
        int i3;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        Intrinsics.checkNotNullParameter(measureScope2, "$this$Layout");
        Intrinsics.checkNotNullParameter(list2, "measurables");
        Iterable<Measurable> iterable = list2;
        String str = this.$actionTag;
        for (Measurable measurable : iterable) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), (Object) str)) {
                Placeable r5 = measurable.m3649measureBRTryo0(j);
                int coerceAtLeast = RangesKt.coerceAtLeast((Constraints.m4624getMaxWidthimpl(j) - r5.getWidth()) - measureScope2.m4643roundToPx0680j_4(SnackbarKt.TextEndExtraSpacing), Constraints.m4626getMinWidthimpl(j));
                String str2 = this.$textTag;
                for (Measurable measurable2 : iterable) {
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), (Object) str2)) {
                        Placeable r8 = measurable2.m3649measureBRTryo0(Constraints.m4615copyZbe2FdA$default(j, 0, coerceAtLeast, 0, 0, 9, (Object) null));
                        int i4 = r8.get(AlignmentLineKt.getFirstBaseline());
                        boolean z = true;
                        int i5 = 0;
                        if (i4 != Integer.MIN_VALUE) {
                            int i6 = r8.get(AlignmentLineKt.getLastBaseline());
                            if (i6 != Integer.MIN_VALUE) {
                                if (i4 != i6) {
                                    z = false;
                                }
                                int r11 = Constraints.m4624getMaxWidthimpl(j) - r5.getWidth();
                                if (z) {
                                    i3 = Math.max(measureScope2.m4643roundToPx0680j_4(SnackbarKt.SnackbarMinHeightOneLine), r5.getHeight());
                                    int height = (i3 - r8.getHeight()) / 2;
                                    int i7 = r5.get(AlignmentLineKt.getFirstBaseline());
                                    if (i7 != Integer.MIN_VALUE) {
                                        i5 = (i4 + height) - i7;
                                    }
                                    i = i5;
                                    i2 = height;
                                } else {
                                    int r6 = measureScope2.m4643roundToPx0680j_4(SnackbarKt.HeightToFirstLine) - i4;
                                    int max = Math.max(measureScope2.m4643roundToPx0680j_4(SnackbarKt.SnackbarMinHeightTwoLines), r8.getHeight() + r6);
                                    i2 = r6;
                                    i = (max - r5.getHeight()) / 2;
                                    i3 = max;
                                }
                                return MeasureScope.CC.layout$default(measureScope, Constraints.m4624getMaxWidthimpl(j), i3, (Map) null, new SnackbarKt$OneRowSnackbar$2$measure$4(r8, i2, r5, r11, i), 4, (Object) null);
                            }
                            throw new IllegalArgumentException("No baselines for text".toString());
                        }
                        throw new IllegalArgumentException("No baselines for text".toString());
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
