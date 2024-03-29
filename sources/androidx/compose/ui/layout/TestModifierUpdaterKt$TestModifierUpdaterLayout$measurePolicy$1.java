package androidx.compose.ui.layout;

import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TestModifierUpdater.kt */
final class TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1 implements MeasurePolicy {
    public static final TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1 INSTANCE = new TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1();

    TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1() {
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
    public final MeasureResult m3728measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$MeasurePolicy");
        Intrinsics.checkNotNullParameter(list, "<anonymous parameter 0>");
        return MeasureScope.CC.layout$default(measureScope, Constraints.m4624getMaxWidthimpl(j), Constraints.m4623getMaxHeightimpl(j), (Map) null, TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1$measure$1.INSTANCE, 4, (Object) null);
    }
}
