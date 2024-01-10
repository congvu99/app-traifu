package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BQ\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\u001a*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\u001c\u0010 \u001a\u00020\u001a*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001aH\u0016J)\u0010\"\u001a\u00020#*\u00020$2\u0006\u0010\u001d\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0012H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001c\u0010)\u001a\u00020\u001a*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\u001c\u0010*\u001a\u00020\u001a*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001aH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R\u0019\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R\u0019\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R!\u0010\u0011\u001a\u00020\u0012*\u00020\u00138BX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/foundation/layout/SizeModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "maxWidth", "maxHeight", "enforceIncoming", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "targetConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/unit/Density;", "getTargetConstraints-OenEA2s", "(Landroidx/compose/ui/unit/Density;)J", "equals", "other", "", "hashCode", "", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Size.kt */
final class SizeModifier extends InspectorValueInfo implements LayoutModifier {
    private final boolean enforceIncoming;
    private final float maxHeight;
    private final float maxWidth;
    private final float minHeight;
    private final float minWidth;

    public /* synthetic */ SizeModifier(float f, float f2, float f3, float f4, boolean z, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z, function1);
    }

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

    public /* synthetic */ Modifier then(Modifier modifier) {
        return Modifier.CC.$default$then(this, modifier);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SizeModifier(float f, float f2, float f3, float f4, boolean z, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.Companion.m4724getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Dp.Companion.m4724getUnspecifiedD9Ej5fM() : f2, (i & 4) != 0 ? Dp.Companion.m4724getUnspecifiedD9Ej5fM() : f3, (i & 8) != 0 ? Dp.Companion.m4724getUnspecifiedD9Ej5fM() : f4, z, function1, (DefaultConstructorMarker) null);
    }

    private SizeModifier(float f, float f2, float f3, float f4, boolean z, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.minWidth = f;
        this.minHeight = f2;
        this.maxWidth = f3;
        this.maxHeight = f4;
        this.enforceIncoming = z;
    }

    /* renamed from: getTargetConstraints-OenEA2s  reason: not valid java name */
    private final long m593getTargetConstraintsOenEA2s(Density density) {
        int i;
        int coerceAtLeast;
        int i2 = 0;
        int r0 = !Dp.m4709equalsimpl0(this.maxWidth, Dp.Companion.m4724getUnspecifiedD9Ej5fM()) ? density.m4643roundToPx0680j_4(((Dp) RangesKt.coerceAtLeast(Dp.m4702boximpl(this.maxWidth), Dp.m4702boximpl(Dp.m4704constructorimpl((float) 0)))).m4718unboximpl()) : Integer.MAX_VALUE;
        int r3 = !Dp.m4709equalsimpl0(this.maxHeight, Dp.Companion.m4724getUnspecifiedD9Ej5fM()) ? density.m4643roundToPx0680j_4(((Dp) RangesKt.coerceAtLeast(Dp.m4702boximpl(this.maxHeight), Dp.m4702boximpl(Dp.m4704constructorimpl((float) 0)))).m4718unboximpl()) : Integer.MAX_VALUE;
        if (Dp.m4709equalsimpl0(this.minWidth, Dp.Companion.m4724getUnspecifiedD9Ej5fM()) || (i = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(density.m4643roundToPx0680j_4(this.minWidth), r0), 0)) == Integer.MAX_VALUE) {
            i = 0;
        }
        if (!Dp.m4709equalsimpl0(this.minHeight, Dp.Companion.m4724getUnspecifiedD9Ej5fM()) && (coerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(density.m4643roundToPx0680j_4(this.minHeight), r3), 0)) != Integer.MAX_VALUE) {
            i2 = coerceAtLeast;
        }
        return ConstraintsKt.Constraints(i, r0, i2, r3);
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m594measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long j2;
        int i;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long r0 = m593getTargetConstraintsOenEA2s(measureScope);
        if (this.enforceIncoming) {
            j2 = ConstraintsKt.m4636constrainN9IONVI(j, r0);
        } else {
            if (!Dp.m4709equalsimpl0(this.minWidth, Dp.Companion.m4724getUnspecifiedD9Ej5fM())) {
                i = Constraints.m4626getMinWidthimpl(r0);
            } else {
                i = RangesKt.coerceAtMost(Constraints.m4626getMinWidthimpl(j), Constraints.m4624getMaxWidthimpl(r0));
            }
            if (!Dp.m4709equalsimpl0(this.maxWidth, Dp.Companion.m4724getUnspecifiedD9Ej5fM())) {
                i2 = Constraints.m4624getMaxWidthimpl(r0);
            } else {
                i2 = RangesKt.coerceAtLeast(Constraints.m4624getMaxWidthimpl(j), Constraints.m4626getMinWidthimpl(r0));
            }
            if (!Dp.m4709equalsimpl0(this.minHeight, Dp.Companion.m4724getUnspecifiedD9Ej5fM())) {
                i3 = Constraints.m4625getMinHeightimpl(r0);
            } else {
                i3 = RangesKt.coerceAtMost(Constraints.m4625getMinHeightimpl(j), Constraints.m4623getMaxHeightimpl(r0));
            }
            if (!Dp.m4709equalsimpl0(this.maxHeight, Dp.Companion.m4724getUnspecifiedD9Ej5fM())) {
                i4 = Constraints.m4623getMaxHeightimpl(r0);
            } else {
                i4 = RangesKt.coerceAtLeast(Constraints.m4623getMaxHeightimpl(j), Constraints.m4625getMinHeightimpl(r0));
            }
            j2 = ConstraintsKt.Constraints(i, i2, i3, i4);
        }
        Placeable r9 = measurable.m3649measureBRTryo0(j2);
        return MeasureScope.CC.layout$default(measureScope, r9.getWidth(), r9.getHeight(), (Map) null, new SizeModifier$measure$1(r9), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        long r0 = m593getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m4622getHasFixedWidthimpl(r0)) {
            return Constraints.m4624getMaxWidthimpl(r0);
        }
        return ConstraintsKt.m4638constrainWidthK40F9xA(r0, intrinsicMeasurable.minIntrinsicWidth(i));
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        long r0 = m593getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m4621getHasFixedHeightimpl(r0)) {
            return Constraints.m4623getMaxHeightimpl(r0);
        }
        return ConstraintsKt.m4637constrainHeightK40F9xA(r0, intrinsicMeasurable.minIntrinsicHeight(i));
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        long r0 = m593getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m4622getHasFixedWidthimpl(r0)) {
            return Constraints.m4624getMaxWidthimpl(r0);
        }
        return ConstraintsKt.m4638constrainWidthK40F9xA(r0, intrinsicMeasurable.maxIntrinsicWidth(i));
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        long r0 = m593getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m4621getHasFixedHeightimpl(r0)) {
            return Constraints.m4623getMaxHeightimpl(r0);
        }
        return ConstraintsKt.m4637constrainHeightK40F9xA(r0, intrinsicMeasurable.maxIntrinsicHeight(i));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SizeModifier)) {
            return false;
        }
        SizeModifier sizeModifier = (SizeModifier) obj;
        if (!Dp.m4709equalsimpl0(this.minWidth, sizeModifier.minWidth) || !Dp.m4709equalsimpl0(this.minHeight, sizeModifier.minHeight) || !Dp.m4709equalsimpl0(this.maxWidth, sizeModifier.maxWidth) || !Dp.m4709equalsimpl0(this.maxHeight, sizeModifier.maxHeight) || this.enforceIncoming != sizeModifier.enforceIncoming) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((Dp.m4710hashCodeimpl(this.minWidth) * 31) + Dp.m4710hashCodeimpl(this.minHeight)) * 31) + Dp.m4710hashCodeimpl(this.maxWidth)) * 31) + Dp.m4710hashCodeimpl(this.maxHeight)) * 31;
    }
}
