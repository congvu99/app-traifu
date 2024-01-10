package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BQ\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J)\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%R\u001c\u0010\u0007\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Landroidx/compose/foundation/layout/PaddingModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "rtlAware", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM", "()F", "F", "getEnd-D9Ej5fM", "getRtlAware", "()Z", "getStart-D9Ej5fM", "getTop-D9Ej5fM", "equals", "other", "", "hashCode", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Padding.kt */
final class PaddingModifier extends InspectorValueInfo implements LayoutModifier {
    private final float bottom;
    private final float end;
    private final boolean rtlAware;
    private final float start;
    private final float top;

    public /* synthetic */ PaddingModifier(float f, float f2, float f3, float f4, boolean z, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
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

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifier.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifier.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifier.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifier.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return Modifier.CC.$default$then(this, modifier);
    }

    /* renamed from: getStart-D9Ej5fM  reason: not valid java name */
    public final float m517getStartD9Ej5fM() {
        return this.start;
    }

    /* renamed from: getTop-D9Ej5fM  reason: not valid java name */
    public final float m518getTopD9Ej5fM() {
        return this.top;
    }

    /* renamed from: getEnd-D9Ej5fM  reason: not valid java name */
    public final float m516getEndD9Ej5fM() {
        return this.end;
    }

    /* renamed from: getBottom-D9Ej5fM  reason: not valid java name */
    public final float m515getBottomD9Ej5fM() {
        return this.bottom;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private PaddingModifier(float r1, float r2, float r3, float r4, boolean r5, kotlin.jvm.functions.Function1<? super androidx.compose.ui.platform.InspectorInfo, kotlin.Unit> r6) {
        /*
            r0 = this;
            r0.<init>(r6)
            r0.start = r1
            r0.top = r2
            r0.end = r3
            r0.bottom = r4
            r0.rtlAware = r5
            r2 = 0
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x001e
            androidx.compose.ui.unit.Dp$Companion r3 = androidx.compose.ui.unit.Dp.Companion
            float r3 = r3.m4724getUnspecifiedD9Ej5fM()
            boolean r1 = androidx.compose.ui.unit.Dp.m4709equalsimpl0(r1, r3)
            if (r1 == 0) goto L_0x0055
        L_0x001e:
            float r1 = r0.top
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0030
            androidx.compose.ui.unit.Dp$Companion r3 = androidx.compose.ui.unit.Dp.Companion
            float r3 = r3.m4724getUnspecifiedD9Ej5fM()
            boolean r1 = androidx.compose.ui.unit.Dp.m4709equalsimpl0(r1, r3)
            if (r1 == 0) goto L_0x0055
        L_0x0030:
            float r1 = r0.end
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0042
            androidx.compose.ui.unit.Dp$Companion r3 = androidx.compose.ui.unit.Dp.Companion
            float r3 = r3.m4724getUnspecifiedD9Ej5fM()
            boolean r1 = androidx.compose.ui.unit.Dp.m4709equalsimpl0(r1, r3)
            if (r1 == 0) goto L_0x0055
        L_0x0042:
            float r1 = r0.bottom
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0057
            androidx.compose.ui.unit.Dp$Companion r2 = androidx.compose.ui.unit.Dp.Companion
            float r2 = r2.m4724getUnspecifiedD9Ej5fM()
            boolean r1 = androidx.compose.ui.unit.Dp.m4709equalsimpl0(r1, r2)
            if (r1 == 0) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            r1 = 0
            goto L_0x0058
        L_0x0057:
            r1 = 1
        L_0x0058:
            if (r1 == 0) goto L_0x005b
            return
        L_0x005b:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Padding must be non-negative"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.PaddingModifier.<init>(float, float, float, float, boolean, kotlin.jvm.functions.Function1):void");
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m519measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        int r0 = measureScope.m4643roundToPx0680j_4(this.start) + measureScope.m4643roundToPx0680j_4(this.end);
        int r1 = measureScope.m4643roundToPx0680j_4(this.top) + measureScope.m4643roundToPx0680j_4(this.bottom);
        Placeable r12 = measurable.m3649measureBRTryo0(ConstraintsKt.m4640offsetNN6EwU(j, -r0, -r1));
        return MeasureScope.CC.layout$default(measureScope, ConstraintsKt.m4638constrainWidthK40F9xA(j, r12.getWidth() + r0), ConstraintsKt.m4637constrainHeightK40F9xA(j, r12.getHeight() + r1), (Map) null, new PaddingModifier$measure$1(this, r12, measureScope), 4, (Object) null);
    }

    public int hashCode() {
        return (((((((Dp.m4710hashCodeimpl(this.start) * 31) + Dp.m4710hashCodeimpl(this.top)) * 31) + Dp.m4710hashCodeimpl(this.end)) * 31) + Dp.m4710hashCodeimpl(this.bottom)) * 31) + C$r8$backportedMethods$utility$Boolean$1$hashCode.hashCode(this.rtlAware);
    }

    public boolean equals(Object obj) {
        PaddingModifier paddingModifier = obj instanceof PaddingModifier ? (PaddingModifier) obj : null;
        if (paddingModifier != null && Dp.m4709equalsimpl0(this.start, paddingModifier.start) && Dp.m4709equalsimpl0(this.top, paddingModifier.top) && Dp.m4709equalsimpl0(this.end, paddingModifier.end) && Dp.m4709equalsimpl0(this.bottom, paddingModifier.bottom) && this.rtlAware == paddingModifier.rtlAware) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaddingModifier(float r11, float r12, float r13, float r14, boolean r15, kotlin.jvm.functions.Function1 r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r10 = this;
            r0 = r17 & 1
            r1 = 0
            if (r0 == 0) goto L_0x000c
            float r0 = (float) r1
            float r0 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r0)
            r3 = r0
            goto L_0x000d
        L_0x000c:
            r3 = r11
        L_0x000d:
            r0 = r17 & 2
            if (r0 == 0) goto L_0x0018
            float r0 = (float) r1
            float r0 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r0)
            r4 = r0
            goto L_0x0019
        L_0x0018:
            r4 = r12
        L_0x0019:
            r0 = r17 & 4
            if (r0 == 0) goto L_0x0024
            float r0 = (float) r1
            float r0 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r0)
            r5 = r0
            goto L_0x0025
        L_0x0024:
            r5 = r13
        L_0x0025:
            r0 = r17 & 8
            if (r0 == 0) goto L_0x0030
            float r0 = (float) r1
            float r0 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r0)
            r6 = r0
            goto L_0x0031
        L_0x0030:
            r6 = r14
        L_0x0031:
            r9 = 0
            r2 = r10
            r7 = r15
            r8 = r16
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.PaddingModifier.<init>(float, float, float, float, boolean, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
