package coil.compose;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0005HÂ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÂ\u0003J\t\u0010\u0016\u001a\u00020\tHÂ\u0003J\t\u0010\u0017\u001a\u00020\u000bHÂ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\rHÂ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u001d\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0013J\t\u0010$\u001a\u00020%HÖ\u0001J\f\u0010&\u001a\u00020'*\u00020(H\u0016J\u001c\u0010)\u001a\u00020\u001f*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001fH\u0016J\u001c\u0010.\u001a\u00020\u001f*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010/\u001a\u00020\u001fH\u0016J)\u00100\u001a\u000201*\u0002022\u0006\u0010+\u001a\u0002032\u0006\u0010\"\u001a\u00020!H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105J\u001c\u00106\u001a\u00020\u001f*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001fH\u0016J\u001c\u00107\u001a\u00020\u001f*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010/\u001a\u00020\u001fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00068"}, d2 = {"Lcoil/compose/ContentPainterModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "toString", "", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "coil-compose-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ContentPainterModifier.kt */
public final class ContentPainterModifier extends InspectorValueInfo implements LayoutModifier, DrawModifier {
    private final Alignment alignment;
    private final float alpha;
    private final ColorFilter colorFilter;
    private final ContentScale contentScale;
    private final Painter painter;

    private final Painter component1() {
        return this.painter;
    }

    private final Alignment component2() {
        return this.alignment;
    }

    private final ContentScale component3() {
        return this.contentScale;
    }

    private final float component4() {
        return this.alpha;
    }

    private final ColorFilter component5() {
        return this.colorFilter;
    }

    public static /* synthetic */ ContentPainterModifier copy$default(ContentPainterModifier contentPainterModifier, Painter painter2, Alignment alignment2, ContentScale contentScale2, float f, ColorFilter colorFilter2, int i, Object obj) {
        if ((i & 1) != 0) {
            painter2 = contentPainterModifier.painter;
        }
        if ((i & 2) != 0) {
            alignment2 = contentPainterModifier.alignment;
        }
        Alignment alignment3 = alignment2;
        if ((i & 4) != 0) {
            contentScale2 = contentPainterModifier.contentScale;
        }
        ContentScale contentScale3 = contentScale2;
        if ((i & 8) != 0) {
            f = contentPainterModifier.alpha;
        }
        float f2 = f;
        if ((i & 16) != 0) {
            colorFilter2 = contentPainterModifier.colorFilter;
        }
        return contentPainterModifier.copy(painter2, alignment3, contentScale3, f2, colorFilter2);
    }

    public final ContentPainterModifier copy(Painter painter2, Alignment alignment2, ContentScale contentScale2, float f, ColorFilter colorFilter2) {
        return new ContentPainterModifier(painter2, alignment2, contentScale2, f, colorFilter2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContentPainterModifier)) {
            return false;
        }
        ContentPainterModifier contentPainterModifier = (ContentPainterModifier) obj;
        return Intrinsics.areEqual((Object) this.painter, (Object) contentPainterModifier.painter) && Intrinsics.areEqual((Object) this.alignment, (Object) contentPainterModifier.alignment) && Intrinsics.areEqual((Object) this.contentScale, (Object) contentPainterModifier.contentScale) && Intrinsics.areEqual((Object) Float.valueOf(this.alpha), (Object) Float.valueOf(contentPainterModifier.alpha)) && Intrinsics.areEqual((Object) this.colorFilter, (Object) contentPainterModifier.colorFilter);
    }

    public int hashCode() {
        int hashCode = ((((((this.painter.hashCode() * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.floatToIntBits(this.alpha)) * 31;
        ColorFilter colorFilter2 = this.colorFilter;
        return hashCode + (colorFilter2 == null ? 0 : colorFilter2.hashCode());
    }

    public String toString() {
        return "ContentPainterModifier(painter=" + this.painter + ", alignment=" + this.alignment + ", contentScale=" + this.contentScale + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }

    public boolean all(Function1<? super Modifier.Element, Boolean> function1) {
        return LayoutModifier.DefaultImpls.all(this, function1);
    }

    public boolean any(Function1<? super Modifier.Element, Boolean> function1) {
        return LayoutModifier.DefaultImpls.any(this, function1);
    }

    public <R> R foldIn(R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
        return LayoutModifier.DefaultImpls.foldIn(this, r, function2);
    }

    public <R> R foldOut(R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
        return LayoutModifier.DefaultImpls.foldOut(this, r, function2);
    }

    public Modifier then(Modifier modifier) {
        return LayoutModifier.DefaultImpls.then(this, modifier);
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m5005measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable r9 = measurable.m3649measureBRTryo0(m5004modifyConstraintsZezNO4M(j));
        return MeasureScope.CC.layout$default(measureScope, r9.getWidth(), r9.getHeight(), (Map) null, new ContentPainterModifier$measure$1(r9), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!(this.painter.m2613getIntrinsicSizeNHjbRc() != Size.Companion.m1760getUnspecifiedNHjbRc())) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        int minIntrinsicWidth = intrinsicMeasurable.minIntrinsicWidth(Constraints.m4623getMaxHeightimpl(m5004modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, (Object) null))));
        return Math.max(MathKt.roundToInt(Size.m1752getWidthimpl(m5003calculateScaledSizeE7KxVPU(SizeKt.Size((float) minIntrinsicWidth, (float) i)))), minIntrinsicWidth);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!(this.painter.m2613getIntrinsicSizeNHjbRc() != Size.Companion.m1760getUnspecifiedNHjbRc())) {
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }
        int maxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(Constraints.m4623getMaxHeightimpl(m5004modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, (Object) null))));
        return Math.max(MathKt.roundToInt(Size.m1752getWidthimpl(m5003calculateScaledSizeE7KxVPU(SizeKt.Size((float) maxIntrinsicWidth, (float) i)))), maxIntrinsicWidth);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!(this.painter.m2613getIntrinsicSizeNHjbRc() != Size.Companion.m1760getUnspecifiedNHjbRc())) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        int minIntrinsicHeight = intrinsicMeasurable.minIntrinsicHeight(Constraints.m4624getMaxWidthimpl(m5004modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, (Object) null))));
        return Math.max(MathKt.roundToInt(Size.m1749getHeightimpl(m5003calculateScaledSizeE7KxVPU(SizeKt.Size((float) i, (float) minIntrinsicHeight)))), minIntrinsicHeight);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!(this.painter.m2613getIntrinsicSizeNHjbRc() != Size.Companion.m1760getUnspecifiedNHjbRc())) {
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }
        int maxIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(Constraints.m4624getMaxWidthimpl(m5004modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, (Object) null))));
        return Math.max(MathKt.roundToInt(Size.m1749getHeightimpl(m5003calculateScaledSizeE7KxVPU(SizeKt.Size((float) i, (float) maxIntrinsicHeight)))), maxIntrinsicHeight);
    }

    /* renamed from: calculateScaledSize-E7KxVPU  reason: not valid java name */
    private final long m5003calculateScaledSizeE7KxVPU(long j) {
        if (Size.m1754isEmptyimpl(j)) {
            return Size.Companion.m1761getZeroNHjbRc();
        }
        long r0 = this.painter.m2613getIntrinsicSizeNHjbRc();
        boolean z = true;
        if (r0 == Size.Companion.m1760getUnspecifiedNHjbRc()) {
            return j;
        }
        float r2 = Size.m1752getWidthimpl(r0);
        if (!(!Float.isInfinite(r2) && !Float.isNaN(r2))) {
            r2 = Size.m1752getWidthimpl(j);
        }
        float r02 = Size.m1749getHeightimpl(r0);
        if (Float.isInfinite(r02) || Float.isNaN(r02)) {
            z = false;
        }
        if (!z) {
            r02 = Size.m1749getHeightimpl(j);
        }
        long Size = SizeKt.Size(r2, r02);
        return ScaleFactorKt.m3724timesUQTWf7w(Size, this.contentScale.m3579computeScaleFactorH7hwNQA(Size, j));
    }

    /* renamed from: modifyConstraints-ZezNO4M  reason: not valid java name */
    private final long m5004modifyConstraintsZezNO4M(long j) {
        float f;
        float f2;
        int r3;
        boolean r2 = Constraints.m4622getHasFixedWidthimpl(j);
        boolean r32 = Constraints.m4621getHasFixedHeightimpl(j);
        if (r2 && r32) {
            return j;
        }
        boolean z = true;
        boolean z2 = Constraints.m4620getHasBoundedWidthimpl(j) && Constraints.m4619getHasBoundedHeightimpl(j);
        long r7 = this.painter.m2613getIntrinsicSizeNHjbRc();
        if (!(r7 == Size.Companion.m1760getUnspecifiedNHjbRc())) {
            if (!z2 || (!r2 && !r32)) {
                float r22 = Size.m1752getWidthimpl(r7);
                float r33 = Size.m1749getHeightimpl(r7);
                if (!Float.isInfinite(r22) && !Float.isNaN(r22)) {
                    f2 = UtilsKt.m5027constrainWidthK40F9xA(j, r22);
                } else {
                    f2 = (float) Constraints.m4626getMinWidthimpl(j);
                }
                if (Float.isInfinite(r33) || Float.isNaN(r33)) {
                    z = false;
                }
                if (z) {
                    f = UtilsKt.m5026constrainHeightK40F9xA(j, r33);
                    long r23 = m5003calculateScaledSizeE7KxVPU(SizeKt.Size(f2, f));
                    return Constraints.m4615copyZbe2FdA$default(j, ConstraintsKt.m4638constrainWidthK40F9xA(j, MathKt.roundToInt(Size.m1752getWidthimpl(r23))), 0, ConstraintsKt.m4637constrainHeightK40F9xA(j, MathKt.roundToInt(Size.m1749getHeightimpl(r23))), 0, 10, (Object) null);
                }
                r3 = Constraints.m4625getMinHeightimpl(j);
            } else {
                f2 = (float) Constraints.m4624getMaxWidthimpl(j);
                r3 = Constraints.m4623getMaxHeightimpl(j);
            }
            f = (float) r3;
            long r232 = m5003calculateScaledSizeE7KxVPU(SizeKt.Size(f2, f));
            return Constraints.m4615copyZbe2FdA$default(j, ConstraintsKt.m4638constrainWidthK40F9xA(j, MathKt.roundToInt(Size.m1752getWidthimpl(r232))), 0, ConstraintsKt.m4637constrainHeightK40F9xA(j, MathKt.roundToInt(Size.m1749getHeightimpl(r232))), 0, 10, (Object) null);
        } else if (!z2) {
            return j;
        } else {
            return Constraints.m4615copyZbe2FdA$default(j, Constraints.m4624getMaxWidthimpl(j), 0, Constraints.m4623getMaxHeightimpl(j), 0, 10, (Object) null);
        }
    }

    public void draw(ContentDrawScope contentDrawScope) {
        long r4 = m5003calculateScaledSizeE7KxVPU(contentDrawScope.m2478getSizeNHjbRc());
        long r0 = this.alignment.m1561alignKFBX0sM(UtilsKt.m5028toIntSizeuvyYCjk(r4), UtilsKt.m5028toIntSizeuvyYCjk(contentDrawScope.m2478getSizeNHjbRc()), contentDrawScope.getLayoutDirection());
        DrawScope drawScope = contentDrawScope;
        float r8 = (float) IntOffset.m4814component1impl(r0);
        float r02 = (float) IntOffset.m4815component2impl(r0);
        drawScope.getDrawContext().getTransform().translate(r8, r02);
        this.painter.m2612drawx_KDEd0(drawScope, r4, this.alpha, this.colorFilter);
        drawScope.getDrawContext().getTransform().translate(-r8, -r02);
        contentDrawScope.drawContent();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContentPainterModifier(Painter painter2, Alignment alignment2, ContentScale contentScale2, float f, ColorFilter colorFilter2) {
        super(InspectableValueKt.isDebugInspectorInfoEnabled() ? new ContentPainterModifier$special$$inlined$debugInspectorInfo$1(painter2, alignment2, contentScale2, f, colorFilter2) : InspectableValueKt.getNoInspectorInfo());
        this.painter = painter2;
        this.alignment = alignment2;
        this.contentScale = contentScale2;
        this.alpha = f;
        this.colorFilter = colorFilter2;
    }
}
