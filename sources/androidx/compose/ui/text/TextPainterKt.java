package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.facebook.internal.AnalyticsEvents;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001aU\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001aW\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a{\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u0014\b\u0002\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0$2\b\b\u0002\u0010'\u001a\u00020(H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*\u001ae\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020+2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010'\u001a\u00020(H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006."}, d2 = {"clip", "", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "drawText", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "brush", "Landroidx/compose/ui/graphics/Brush;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "alpha", "", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawText-712uMfE", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/graphics/Brush;JFLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawText-xIhfjkU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextLayoutResult;JJFLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "maxSize", "Landroidx/compose/ui/unit/IntSize;", "drawText-i2ZdXms", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextMeasurer;Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextStyle;IZILjava/util/List;J)V", "", "drawText-O6gbksU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextMeasurer;Ljava/lang/String;JLandroidx/compose/ui/text/TextStyle;IZIJ)V", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextPainter.kt */
public final class TextPainterKt {
    /* renamed from: drawText-i2ZdXms$default  reason: not valid java name */
    public static /* synthetic */ void m4205drawTexti2ZdXms$default(DrawScope drawScope, TextMeasurer textMeasurer, AnnotatedString annotatedString, long j, TextStyle textStyle, int i, boolean z, int i2, List list, long j2, int i3, Object obj) {
        long j3;
        int i4 = i3;
        long r6 = (i4 & 4) != 0 ? Offset.Companion.m1699getZeroF1C5BW0() : j;
        TextStyle textStyle2 = (i4 & 8) != 0 ? TextStyle.Companion.getDefault() : textStyle;
        int r9 = (i4 & 16) != 0 ? TextOverflow.Companion.m4590getClipgIe3tQ8() : i;
        boolean z2 = (i4 & 32) != 0 ? true : z;
        int i5 = (i4 & 64) != 0 ? Integer.MAX_VALUE : i2;
        List emptyList = (i4 & 128) != 0 ? CollectionsKt.emptyList() : list;
        if ((i4 & 256) != 0) {
            j3 = IntSizeKt.IntSize(MathKt.roundToInt((float) Math.ceil((double) (Size.m1752getWidthimpl(drawScope.m2478getSizeNHjbRc()) - Offset.m1683getXimpl(r6)))), MathKt.roundToInt((float) Math.ceil((double) (Size.m1749getHeightimpl(drawScope.m2478getSizeNHjbRc()) - Offset.m1684getYimpl(r6)))));
        } else {
            j3 = j2;
        }
        m4204drawTexti2ZdXms(drawScope, textMeasurer, annotatedString, r6, textStyle2, r9, z2, i5, emptyList, j3);
    }

    @ExperimentalTextApi
    /* renamed from: drawText-i2ZdXms  reason: not valid java name */
    public static final void m4204drawTexti2ZdXms(DrawScope drawScope, TextMeasurer textMeasurer, AnnotatedString annotatedString, long j, TextStyle textStyle, int i, boolean z, int i2, List<AnnotatedString.Range<Placeholder>> list, long j2) {
        DrawScope drawScope2 = drawScope;
        Intrinsics.checkNotNullParameter(drawScope2, "$this$drawText");
        TextMeasurer textMeasurer2 = textMeasurer;
        Intrinsics.checkNotNullParameter(textMeasurer2, "textMeasurer");
        AnnotatedString annotatedString2 = annotatedString;
        Intrinsics.checkNotNullParameter(annotatedString2, "text");
        TextStyle textStyle2 = textStyle;
        Intrinsics.checkNotNullParameter(textStyle2, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        List<AnnotatedString.Range<Placeholder>> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "placeholders");
        TextLayoutResult r1 = TextMeasurer.m4198measurexDpz5zY$default(textMeasurer2, annotatedString2, textStyle2, i, z, i2, list2, ConstraintsKt.Constraints$default(0, IntSize.m4864getWidthimpl(j2), 0, IntSize.m4863getHeightimpl(j2), 5, (Object) null), drawScope.getLayoutDirection(), drawScope2, (FontFamily.Resolver) null, false, 1536, (Object) null);
        DrawContext drawContext = drawScope.getDrawContext();
        long r3 = drawContext.m2456getSizeNHjbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        transform.translate(Offset.m1683getXimpl(j), Offset.m1684getYimpl(j));
        clip(transform, r1);
        MultiParagraph.m4121paintRPmYEkk$default(r1.getMultiParagraph(), drawScope.getDrawContext().getCanvas(), 0, (Shadow) null, (TextDecoration) null, 14, (Object) null);
        drawContext.getCanvas().restore();
        drawContext.m2457setSizeuvyYCjk(r3);
    }

    /* renamed from: drawText-O6gbksU$default  reason: not valid java name */
    public static /* synthetic */ void m4203drawTextO6gbksU$default(DrawScope drawScope, TextMeasurer textMeasurer, String str, long j, TextStyle textStyle, int i, boolean z, int i2, long j2, int i3, Object obj) {
        long j3;
        int i4 = i3;
        long r6 = (i4 & 4) != 0 ? Offset.Companion.m1699getZeroF1C5BW0() : j;
        TextStyle textStyle2 = (i4 & 8) != 0 ? TextStyle.Companion.getDefault() : textStyle;
        int r9 = (i4 & 16) != 0 ? TextOverflow.Companion.m4590getClipgIe3tQ8() : i;
        boolean z2 = (i4 & 32) != 0 ? true : z;
        int i5 = (i4 & 64) != 0 ? Integer.MAX_VALUE : i2;
        if ((i4 & 128) != 0) {
            j3 = IntSizeKt.IntSize(MathKt.roundToInt((float) Math.ceil((double) (Size.m1752getWidthimpl(drawScope.m2478getSizeNHjbRc()) - Offset.m1683getXimpl(r6)))), MathKt.roundToInt((float) Math.ceil((double) (Size.m1749getHeightimpl(drawScope.m2478getSizeNHjbRc()) - Offset.m1684getYimpl(r6)))));
        } else {
            j3 = j2;
        }
        m4202drawTextO6gbksU(drawScope, textMeasurer, str, r6, textStyle2, r9, z2, i5, j3);
    }

    @ExperimentalTextApi
    /* renamed from: drawText-O6gbksU  reason: not valid java name */
    public static final void m4202drawTextO6gbksU(DrawScope drawScope, TextMeasurer textMeasurer, String str, long j, TextStyle textStyle, int i, boolean z, int i2, long j2) {
        DrawScope drawScope2 = drawScope;
        Intrinsics.checkNotNullParameter(drawScope2, "$this$drawText");
        TextMeasurer textMeasurer2 = textMeasurer;
        Intrinsics.checkNotNullParameter(textMeasurer2, "textMeasurer");
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(textStyle, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        TextLayoutResult r1 = TextMeasurer.m4198measurexDpz5zY$default(textMeasurer2, new AnnotatedString(str2, (List) null, (List) null, 6, (DefaultConstructorMarker) null), textStyle, i, z, i2, (List) null, ConstraintsKt.Constraints$default(0, IntSize.m4864getWidthimpl(j2), 0, IntSize.m4863getHeightimpl(j2), 5, (Object) null), drawScope.getLayoutDirection(), drawScope2, (FontFamily.Resolver) null, false, 1568, (Object) null);
        DrawContext drawContext = drawScope.getDrawContext();
        long r3 = drawContext.m2456getSizeNHjbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        transform.translate(Offset.m1683getXimpl(j), Offset.m1684getYimpl(j));
        clip(transform, r1);
        MultiParagraph.m4121paintRPmYEkk$default(r1.getMultiParagraph(), drawScope.getDrawContext().getCanvas(), 0, (Shadow) null, (TextDecoration) null, 14, (Object) null);
        drawContext.getCanvas().restore();
        drawContext.m2457setSizeuvyYCjk(r3);
    }

    /* renamed from: drawText-xIhfjkU$default  reason: not valid java name */
    public static /* synthetic */ void m4207drawTextxIhfjkU$default(DrawScope drawScope, TextLayoutResult textLayoutResult, long j, long j2, float f, Shadow shadow, TextDecoration textDecoration, int i, Object obj) {
        long r0 = (i & 2) != 0 ? Color.Companion.m1968getUnspecified0d7_KjU() : j;
        long r2 = (i & 4) != 0 ? Offset.Companion.m1699getZeroF1C5BW0() : j2;
        float f2 = (i & 8) != 0 ? Float.NaN : f;
        TextDecoration textDecoration2 = null;
        Shadow shadow2 = (i & 16) != 0 ? null : shadow;
        if ((i & 32) == 0) {
            textDecoration2 = textDecoration;
        }
        m4206drawTextxIhfjkU(drawScope, textLayoutResult, r0, r2, f2, shadow2, textDecoration2);
    }

    @ExperimentalTextApi
    /* renamed from: drawText-xIhfjkU  reason: not valid java name */
    public static final void m4206drawTextxIhfjkU(DrawScope drawScope, TextLayoutResult textLayoutResult, long j, long j2, float f, Shadow shadow, TextDecoration textDecoration) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawText");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        if (shadow == null) {
            shadow = textLayoutResult.getLayoutInput().getStyle().getShadow();
        }
        if (textDecoration == null) {
            textDecoration = textLayoutResult.getLayoutInput().getStyle().getTextDecoration();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long r1 = drawContext.m2456getSizeNHjbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        transform.translate(Offset.m1683getXimpl(j2), Offset.m1684getYimpl(j2));
        clip(transform, textLayoutResult);
        Brush brush = textLayoutResult.getLayoutInput().getStyle().getBrush();
        boolean z = true;
        if (brush != null) {
            if (j == Color.Companion.m1968getUnspecified0d7_KjU()) {
                MultiParagraph multiParagraph = textLayoutResult.getMultiParagraph();
                Canvas canvas = drawScope.getDrawContext().getCanvas();
                if (Float.isNaN(f)) {
                    f = textLayoutResult.getLayoutInput().getStyle().getAlpha();
                }
                multiParagraph.paint(canvas, brush, f, shadow, textDecoration);
                drawContext.getCanvas().restore();
                drawContext.m2457setSizeuvyYCjk(r1);
            }
        }
        MultiParagraph multiParagraph2 = textLayoutResult.getMultiParagraph();
        Canvas canvas2 = drawScope.getDrawContext().getCanvas();
        if (j == Color.Companion.m1968getUnspecified0d7_KjU()) {
            z = false;
        }
        if (!z) {
            j = textLayoutResult.getLayoutInput().getStyle().m4238getColor0d7_KjU();
        }
        multiParagraph2.m4124paintRPmYEkk(canvas2, TextDrawStyleKt.m4572modulateDxMtmZc(j, f), shadow, textDecoration);
        drawContext.getCanvas().restore();
        drawContext.m2457setSizeuvyYCjk(r1);
    }

    /* renamed from: drawText-712uMfE$default  reason: not valid java name */
    public static /* synthetic */ void m4201drawText712uMfE$default(DrawScope drawScope, TextLayoutResult textLayoutResult, Brush brush, long j, float f, Shadow shadow, TextDecoration textDecoration, int i, Object obj) {
        m4200drawText712uMfE(drawScope, textLayoutResult, brush, (i & 4) != 0 ? Offset.Companion.m1699getZeroF1C5BW0() : j, (i & 8) != 0 ? Float.NaN : f, (i & 16) != 0 ? null : shadow, (i & 32) != 0 ? null : textDecoration);
    }

    @ExperimentalTextApi
    /* renamed from: drawText-712uMfE  reason: not valid java name */
    public static final void m4200drawText712uMfE(DrawScope drawScope, TextLayoutResult textLayoutResult, Brush brush, long j, float f, Shadow shadow, TextDecoration textDecoration) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawText");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Intrinsics.checkNotNullParameter(brush, "brush");
        if (shadow == null) {
            shadow = textLayoutResult.getLayoutInput().getStyle().getShadow();
        }
        Shadow shadow2 = shadow;
        if (textDecoration == null) {
            textDecoration = textLayoutResult.getLayoutInput().getStyle().getTextDecoration();
        }
        TextDecoration textDecoration2 = textDecoration;
        DrawContext drawContext = drawScope.getDrawContext();
        long r6 = drawContext.m2456getSizeNHjbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        transform.translate(Offset.m1683getXimpl(j), Offset.m1684getYimpl(j));
        clip(transform, textLayoutResult);
        MultiParagraph multiParagraph = textLayoutResult.getMultiParagraph();
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        if (Float.isNaN(f)) {
            f = textLayoutResult.getLayoutInput().getStyle().getAlpha();
        }
        multiParagraph.paint(canvas, brush, f, shadow2, textDecoration2);
        drawContext.getCanvas().restore();
        drawContext.m2457setSizeuvyYCjk(r6);
    }

    private static final void clip(DrawTransform drawTransform, TextLayoutResult textLayoutResult) {
        if (textLayoutResult.getHasVisualOverflow() && !TextOverflow.m4583equalsimpl0(textLayoutResult.getLayoutInput().m4192getOverflowgIe3tQ8(), TextOverflow.Companion.m4592getVisiblegIe3tQ8())) {
            DrawTransform.CC.m2575clipRectN_I0leg$default(drawTransform, 0.0f, 0.0f, (float) IntSize.m4864getWidthimpl(textLayoutResult.m4196getSizeYbymL2g()), (float) IntSize.m4863getHeightimpl(textLayoutResult.m4196getSizeYbymL2g()), 0, 16, (Object) null);
        }
    }
}
