package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.IntrinsicSizeModifier;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/layout/MinIntrinsicHeightModifier;", "Landroidx/compose/foundation/layout/IntrinsicSizeModifier;", "()V", "calculateContentConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "calculateContentConstraints-l58MMJ0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Intrinsic.kt */
final class MinIntrinsicHeightModifier implements IntrinsicSizeModifier {
    public static final MinIntrinsicHeightModifier INSTANCE = new MinIntrinsicHeightModifier();

    public /* synthetic */ boolean all(Function1<? super Modifier.Element, Boolean> function1) {
        return Modifier.Element.CC.$default$all(this, function1);
    }

    public /* synthetic */ boolean any(Function1<? super Modifier.Element, Boolean> function1) {
        return Modifier.Element.CC.$default$any(this, function1);
    }

    public /* synthetic */ <R> R foldIn(R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
        return Modifier.Element.CC.$default$foldIn(this, r, function2);
    }

    public /* synthetic */ <R> R foldOut(R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
        return Modifier.Element.CC.$default$foldOut(this, r, function2);
    }

    public /* synthetic */ boolean getEnforceIncoming() {
        return IntrinsicSizeModifier.CC.$default$getEnforceIncoming(this);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return IntrinsicSizeModifier.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public /* synthetic */ MeasureResult m491measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        return IntrinsicSizeModifier.CC.m484$default$measure3p2s80s(this, measureScope, measurable, j);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return IntrinsicSizeModifier.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return IntrinsicSizeModifier.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return Modifier.CC.$default$then(this, modifier);
    }

    private MinIntrinsicHeightModifier() {
    }

    /* renamed from: calculateContentConstraints-l58MMJ0  reason: not valid java name */
    public long m490calculateContentConstraintsl58MMJ0(MeasureScope measureScope, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$calculateContentConstraints");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return Constraints.Companion.m4633fixedHeightOenEA2s(measurable.minIntrinsicHeight(Constraints.m4624getMaxWidthimpl(j)));
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }
}
