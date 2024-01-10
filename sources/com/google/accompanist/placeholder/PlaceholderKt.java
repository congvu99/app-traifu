package com.google.accompanist.placeholder;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a[\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0001\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2*\b\u0002\u0010\u0016\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00190\u0017¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2*\b\u0002\u0010\u001c\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00190\u0017¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001a.\u0010\u001f\u001a\u00020 *\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0017\u0010#\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020 0\u0017¢\u0006\u0002\b\u001bH\b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006$"}, d2 = {"drawPlaceholder", "Landroidx/compose/ui/graphics/Outline;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "highlight", "Lcom/google/accompanist/placeholder/PlaceholderHighlight;", "progress", "", "lastOutline", "lastLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastSize", "Landroidx/compose/ui/geometry/Size;", "drawPlaceholder-hpmOzss", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Shape;JLcom/google/accompanist/placeholder/PlaceholderHighlight;FLandroidx/compose/ui/graphics/Outline;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/geometry/Size;)Landroidx/compose/ui/graphics/Outline;", "placeholder", "Landroidx/compose/ui/Modifier;", "visible", "", "placeholderFadeTransitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "contentFadeTransitionSpec", "placeholder-cf5BqRc", "(Landroidx/compose/ui/Modifier;ZJLandroidx/compose/ui/graphics/Shape;Lcom/google/accompanist/placeholder/PlaceholderHighlight;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "withLayer", "", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawBlock", "placeholder_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Placeholder.kt */
public final class PlaceholderKt {
    /* renamed from: placeholder-cf5BqRc$default  reason: not valid java name */
    public static /* synthetic */ Modifier m5065placeholdercf5BqRc$default(Modifier modifier, boolean z, long j, Shape shape, PlaceholderHighlight placeholderHighlight, Function3 function3, Function3 function32, int i, Object obj) {
        Function3 function33;
        Shape rectangleShape = (i & 4) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        PlaceholderHighlight placeholderHighlight2 = (i & 8) != 0 ? null : placeholderHighlight;
        Function3 function34 = (i & 16) != 0 ? PlaceholderKt$placeholder$1.INSTANCE : function3;
        if ((i & 32) != 0) {
            function33 = PlaceholderKt$placeholder$2.INSTANCE;
        } else {
            function33 = function32;
        }
        return m5064placeholdercf5BqRc(modifier, z, j, rectangleShape, placeholderHighlight2, function34, function33);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawPlaceholder-hpmOzss  reason: not valid java name */
    public static final Outline m5063drawPlaceholderhpmOzss(DrawScope drawScope, Shape shape, long j, PlaceholderHighlight placeholderHighlight, float f, Outline outline, LayoutDirection layoutDirection, Size size) {
        Shape shape2 = shape;
        PlaceholderHighlight placeholderHighlight2 = placeholderHighlight;
        float f2 = f;
        Outline outline2 = null;
        if (shape2 == RectangleShapeKt.getRectangleShape()) {
            DrawScope.CC.m2514drawRectnJ9OG0$default(drawScope, j, 0, 0, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 126, (Object) null);
            if (placeholderHighlight2 != null) {
                DrawScope.CC.m2513drawRectAsUm42w$default(drawScope, placeholderHighlight2.m5057brushd16Qtg0(f2, drawScope.m2478getSizeNHjbRc()), 0, 0, placeholderHighlight.alpha(f), (DrawStyle) null, (ColorFilter) null, 0, 118, (Object) null);
            }
            return null;
        }
        if (Size.m1747equalsimpl(drawScope.m2478getSizeNHjbRc(), size) && drawScope.getLayoutDirection() == layoutDirection) {
            outline2 = outline;
        }
        if (outline2 == null) {
            outline2 = shape2.m2266createOutlinePq9zytI(drawScope.m2478getSizeNHjbRc(), drawScope.getLayoutDirection(), drawScope);
        }
        OutlineKt.m2161drawOutlinewDX37Ww$default(drawScope, outline2, j, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
        if (placeholderHighlight2 != null) {
            OutlineKt.m2159drawOutlinehn5TExg$default(drawScope, outline2, placeholderHighlight2.m5057brushd16Qtg0(f2, drawScope.m2478getSizeNHjbRc()), placeholderHighlight.alpha(f), (DrawStyle) null, (ColorFilter) null, 0, 56, (Object) null);
        }
        return outline2;
    }

    /* renamed from: placeholder-cf5BqRc  reason: not valid java name */
    public static final Modifier m5064placeholdercf5BqRc(Modifier modifier, boolean z, long j, Shape shape, PlaceholderHighlight placeholderHighlight, Function3<? super Transition.Segment<Boolean>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Float>> function3, Function3<? super Transition.Segment<Boolean>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Float>> function32) {
        Modifier modifier2 = modifier;
        Intrinsics.checkNotNullParameter(modifier, "$this$placeholder");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(function3, "placeholderFadeTransitionSpec");
        Intrinsics.checkNotNullParameter(function32, "contentFadeTransitionSpec");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new PlaceholderKt$placeholdercf5BqRc$$inlined$debugInspectorInfo$1(z, j, placeholderHighlight, shape) : InspectableValueKt.getNoInspectorInfo(), new PlaceholderKt$placeholder$4(function3, function32, placeholderHighlight, z, j, shape));
    }

    private static final void withLayer(DrawScope drawScope, Paint paint, Function1<? super DrawScope, Unit> function1) {
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        canvas.saveLayer(SizeKt.m1773toRectuvyYCjk(drawScope.m2478getSizeNHjbRc()), paint);
        function1.invoke(drawScope);
        canvas.restore();
    }
}
