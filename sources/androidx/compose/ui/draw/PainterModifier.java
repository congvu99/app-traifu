package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
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
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BX\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\u0010\u0015J\u001d\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J\u0013\u0010)\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\b\u0010,\u001a\u00020-H\u0016J\u001d\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u0010(J\b\u00102\u001a\u000203H\u0016J\f\u00104\u001a\u00020\u0013*\u000205H\u0016J\u0019\u00106\u001a\u00020\u0007*\u00020%H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b7\u00108J\u0019\u00109\u001a\u00020\u0007*\u00020%H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u00108J\u001c\u0010;\u001a\u00020-*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020-H\u0016J\u001c\u0010@\u001a\u00020-*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010A\u001a\u00020-H\u0016J)\u0010B\u001a\u00020C*\u00020D2\u0006\u0010=\u001a\u00020E2\u0006\u00100\u001a\u00020/H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bF\u0010GJ\u001c\u0010H\u001a\u00020-*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020-H\u0016J\u001c\u0010I\u001a\u00020-*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010A\u001a\u00020-H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006J"}, d2 = {"Landroidx/compose/ui/draw/PainterModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Lkotlin/jvm/functions/Function1;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getAlpha", "()F", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getSizeToIntrinsics", "()Z", "useIntrinsicSize", "getUseIntrinsicSize", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "equals", "other", "", "hashCode", "", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "toString", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "hasSpecifiedAndFiniteHeight", "hasSpecifiedAndFiniteHeight-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteWidth-uvyYCjk", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PainterModifier.kt */
final class PainterModifier extends InspectorValueInfo implements LayoutModifier, DrawModifier {
    private final Alignment alignment;
    private final float alpha;
    private final ColorFilter colorFilter;
    private final ContentScale contentScale;
    private final Painter painter;
    private final boolean sizeToIntrinsics;

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

    public final Painter getPainter() {
        return this.painter;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PainterModifier(Painter painter2, boolean z, Alignment alignment2, ContentScale contentScale2, float f, ColorFilter colorFilter2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter2, z, (i & 4) != 0 ? Alignment.Companion.getCenter() : alignment2, (i & 8) != 0 ? ContentScale.Companion.getInside() : contentScale2, (i & 16) != 0 ? 1.0f : f, (i & 32) != 0 ? null : colorFilter2, function1);
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PainterModifier(Painter painter2, boolean z, Alignment alignment2, ContentScale contentScale2, float f, ColorFilter colorFilter2, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(painter2, "painter");
        Intrinsics.checkNotNullParameter(alignment2, "alignment");
        Intrinsics.checkNotNullParameter(contentScale2, "contentScale");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.painter = painter2;
        this.sizeToIntrinsics = z;
        this.alignment = alignment2;
        this.contentScale = contentScale2;
        this.alpha = f;
        this.colorFilter = colorFilter2;
    }

    private final boolean getUseIntrinsicSize() {
        if (this.sizeToIntrinsics) {
            if (this.painter.m2613getIntrinsicSizeNHjbRc() != Size.Companion.m1760getUnspecifiedNHjbRc()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m1598measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Placeable r9 = measurable.m3649measureBRTryo0(m1597modifyConstraintsZezNO4M(j));
        return MeasureScope.CC.layout$default(measureScope, r9.getWidth(), r9.getHeight(), (Map) null, new PainterModifier$measure$1(r9), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        long r0 = m1597modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, (Object) null));
        return Math.max(Constraints.m4626getMinWidthimpl(r0), intrinsicMeasurable.minIntrinsicWidth(i));
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }
        long r0 = m1597modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, (Object) null));
        return Math.max(Constraints.m4626getMinWidthimpl(r0), intrinsicMeasurable.maxIntrinsicWidth(i));
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        long r0 = m1597modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, (Object) null));
        return Math.max(Constraints.m4625getMinHeightimpl(r0), intrinsicMeasurable.minIntrinsicHeight(i));
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }
        long r0 = m1597modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, (Object) null));
        return Math.max(Constraints.m4625getMinHeightimpl(r0), intrinsicMeasurable.maxIntrinsicHeight(i));
    }

    /* renamed from: calculateScaledSize-E7KxVPU  reason: not valid java name */
    private final long m1594calculateScaledSizeE7KxVPU(long j) {
        float f;
        float f2;
        if (!getUseIntrinsicSize()) {
            return j;
        }
        if (!m1596hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.m2613getIntrinsicSizeNHjbRc())) {
            f = Size.m1752getWidthimpl(j);
        } else {
            f = Size.m1752getWidthimpl(this.painter.m2613getIntrinsicSizeNHjbRc());
        }
        if (!m1595hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.m2613getIntrinsicSizeNHjbRc())) {
            f2 = Size.m1749getHeightimpl(j);
        } else {
            f2 = Size.m1749getHeightimpl(this.painter.m2613getIntrinsicSizeNHjbRc());
        }
        long Size = SizeKt.Size(f, f2);
        boolean z = true;
        if (!(Size.m1752getWidthimpl(j) == 0.0f)) {
            if (Size.m1749getHeightimpl(j) != 0.0f) {
                z = false;
            }
            if (!z) {
                return ScaleFactorKt.m3724timesUQTWf7w(Size, this.contentScale.m3579computeScaleFactorH7hwNQA(Size, j));
            }
        }
        return Size.Companion.m1761getZeroNHjbRc();
    }

    /* renamed from: modifyConstraints-ZezNO4M  reason: not valid java name */
    private final long m1597modifyConstraintsZezNO4M(long j) {
        int i;
        int i2;
        boolean z = true;
        boolean z2 = Constraints.m4620getHasBoundedWidthimpl(j) && Constraints.m4619getHasBoundedHeightimpl(j);
        if (!Constraints.m4622getHasFixedWidthimpl(j) || !Constraints.m4621getHasFixedHeightimpl(j)) {
            z = false;
        }
        if ((getUseIntrinsicSize() || !z2) && !z) {
            long r0 = this.painter.m2613getIntrinsicSizeNHjbRc();
            if (m1596hasSpecifiedAndFiniteWidthuvyYCjk(r0)) {
                i = MathKt.roundToInt(Size.m1752getWidthimpl(r0));
            } else {
                i = Constraints.m4626getMinWidthimpl(j);
            }
            if (m1595hasSpecifiedAndFiniteHeightuvyYCjk(r0)) {
                i2 = MathKt.roundToInt(Size.m1749getHeightimpl(r0));
            } else {
                i2 = Constraints.m4625getMinHeightimpl(j);
            }
            long r02 = m1594calculateScaledSizeE7KxVPU(SizeKt.Size((float) ConstraintsKt.m4638constrainWidthK40F9xA(j, i), (float) ConstraintsKt.m4637constrainHeightK40F9xA(j, i2)));
            return Constraints.m4615copyZbe2FdA$default(j, ConstraintsKt.m4638constrainWidthK40F9xA(j, MathKt.roundToInt(Size.m1752getWidthimpl(r02))), 0, ConstraintsKt.m4637constrainHeightK40F9xA(j, MathKt.roundToInt(Size.m1749getHeightimpl(r02))), 0, 10, (Object) null);
        }
        return Constraints.m4615copyZbe2FdA$default(j, Constraints.m4624getMaxWidthimpl(j), 0, Constraints.m4623getMaxHeightimpl(j), 0, 10, (Object) null);
    }

    public void draw(ContentDrawScope contentDrawScope) {
        float f;
        float f2;
        long j;
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        long r0 = this.painter.m2613getIntrinsicSizeNHjbRc();
        if (m1596hasSpecifiedAndFiniteWidthuvyYCjk(r0)) {
            f = Size.m1752getWidthimpl(r0);
        } else {
            f = Size.m1752getWidthimpl(contentDrawScope.m2478getSizeNHjbRc());
        }
        if (m1595hasSpecifiedAndFiniteHeightuvyYCjk(r0)) {
            f2 = Size.m1749getHeightimpl(r0);
        } else {
            f2 = Size.m1749getHeightimpl(contentDrawScope.m2478getSizeNHjbRc());
        }
        long Size = SizeKt.Size(f, f2);
        boolean z = true;
        if (!(Size.m1752getWidthimpl(contentDrawScope.m2478getSizeNHjbRc()) == 0.0f)) {
            if (Size.m1749getHeightimpl(contentDrawScope.m2478getSizeNHjbRc()) != 0.0f) {
                z = false;
            }
            if (!z) {
                j = ScaleFactorKt.m3724timesUQTWf7w(Size, this.contentScale.m3579computeScaleFactorH7hwNQA(Size, contentDrawScope.m2478getSizeNHjbRc()));
                long j2 = j;
                long r02 = this.alignment.m1561alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m1752getWidthimpl(j2)), MathKt.roundToInt(Size.m1749getHeightimpl(j2))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m1752getWidthimpl(contentDrawScope.m2478getSizeNHjbRc())), MathKt.roundToInt(Size.m1749getHeightimpl(contentDrawScope.m2478getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
                float r8 = (float) IntOffset.m4822getXimpl(r02);
                float r03 = (float) IntOffset.m4823getYimpl(r02);
                DrawScope drawScope = contentDrawScope;
                drawScope.getDrawContext().getTransform().translate(r8, r03);
                this.painter.m2612drawx_KDEd0(drawScope, j2, this.alpha, this.colorFilter);
                drawScope.getDrawContext().getTransform().translate(-r8, -r03);
                contentDrawScope.drawContent();
            }
        }
        j = Size.Companion.m1761getZeroNHjbRc();
        long j22 = j;
        long r022 = this.alignment.m1561alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m1752getWidthimpl(j22)), MathKt.roundToInt(Size.m1749getHeightimpl(j22))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m1752getWidthimpl(contentDrawScope.m2478getSizeNHjbRc())), MathKt.roundToInt(Size.m1749getHeightimpl(contentDrawScope.m2478getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
        float r82 = (float) IntOffset.m4822getXimpl(r022);
        float r032 = (float) IntOffset.m4823getYimpl(r022);
        DrawScope drawScope2 = contentDrawScope;
        drawScope2.getDrawContext().getTransform().translate(r82, r032);
        this.painter.m2612drawx_KDEd0(drawScope2, j22, this.alpha, this.colorFilter);
        drawScope2.getDrawContext().getTransform().translate(-r82, -r032);
        contentDrawScope.drawContent();
    }

    /* renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk  reason: not valid java name */
    private final boolean m1596hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        if (!Size.m1748equalsimpl0(j, Size.Companion.m1760getUnspecifiedNHjbRc())) {
            float r4 = Size.m1752getWidthimpl(j);
            if (!Float.isInfinite(r4) && !Float.isNaN(r4)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk  reason: not valid java name */
    private final boolean m1595hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        if (!Size.m1748equalsimpl0(j, Size.Companion.m1760getUnspecifiedNHjbRc())) {
            float r4 = Size.m1749getHeightimpl(j);
            if (!Float.isInfinite(r4) && !Float.isNaN(r4)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((this.painter.hashCode() * 31) + C$r8$backportedMethods$utility$Boolean$1$hashCode.hashCode(this.sizeToIntrinsics)) * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.floatToIntBits(this.alpha)) * 31;
        ColorFilter colorFilter2 = this.colorFilter;
        return hashCode + (colorFilter2 != null ? colorFilter2.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        PainterModifier painterModifier = obj instanceof PainterModifier ? (PainterModifier) obj : null;
        if (painterModifier == null || !Intrinsics.areEqual((Object) this.painter, (Object) painterModifier.painter) || this.sizeToIntrinsics != painterModifier.sizeToIntrinsics || !Intrinsics.areEqual((Object) this.alignment, (Object) painterModifier.alignment) || !Intrinsics.areEqual((Object) this.contentScale, (Object) painterModifier.contentScale)) {
            return false;
        }
        if (!(this.alpha == painterModifier.alpha) || !Intrinsics.areEqual((Object) this.colorFilter, (Object) painterModifier.colorFilter)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}
