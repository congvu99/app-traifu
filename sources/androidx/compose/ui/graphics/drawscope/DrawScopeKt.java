package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.DegreesKt;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aH\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000b\u001ah\u0010\f\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a$\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\bH\bø\u0001\u0000\u001a1\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000\u001a=\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000\u001aI\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000\u001aH\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u001aH\u0010\u001f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b!\u0010\u001e\u001aH\u0010\"\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b#\u0010\u001e\u001aP\u0010\"\u001a\u00020\u0001*\u00020\u00022\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b&\u0010'\u001a=\u0010(\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000\u001aB\u0010)\u001a\u00020\u0001*\u00020\u00022\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\t2\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000\u0002\u0012\n\u0005\b20\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006-"}, d2 = {"clipPath", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "clipPath-KD09W0M", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;ILkotlin/jvm/functions/Function1;)V", "clipRect", "left", "", "top", "right", "bottom", "clipRect-rOu3jXo", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFFILkotlin/jvm/functions/Function1;)V", "drawIntoCanvas", "Landroidx/compose/ui/graphics/Canvas;", "inset", "horizontal", "vertical", "rotate", "degrees", "pivot", "Landroidx/compose/ui/geometry/Offset;", "rotate-Rg1IO4c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJLkotlin/jvm/functions/Function1;)V", "rotateRad", "radians", "rotateRad-Rg1IO4c", "scale", "scale-Rg1IO4c", "scaleX", "scaleY", "scale-Fgt4K4Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLkotlin/jvm/functions/Function1;)V", "translate", "withTransform", "transformBlock", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "drawBlock", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: DrawScope.kt */
public final class DrawScopeKt {
    public static final void inset(DrawScope drawScope, float f, float f2, float f3, float f4, Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        drawScope.getDrawContext().getTransform().inset(f, f2, f3, f4);
        function1.invoke(drawScope);
        drawScope.getDrawContext().getTransform().inset(-f, -f2, -f3, -f4);
    }

    public static final void inset(DrawScope drawScope, float f, Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        drawScope.getDrawContext().getTransform().inset(f, f, f, f);
        function1.invoke(drawScope);
        float f2 = -f;
        drawScope.getDrawContext().getTransform().inset(f2, f2, f2, f2);
    }

    public static /* synthetic */ void inset$default(DrawScope drawScope, float f, float f2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        drawScope.getDrawContext().getTransform().inset(f, f2, f, f2);
        function1.invoke(drawScope);
        float f3 = -f;
        float f4 = -f2;
        drawScope.getDrawContext().getTransform().inset(f3, f4, f3, f4);
    }

    public static /* synthetic */ void translate$default(DrawScope drawScope, float f, float f2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        drawScope.getDrawContext().getTransform().translate(f, f2);
        function1.invoke(drawScope);
        drawScope.getDrawContext().getTransform().translate(-f, -f2);
    }

    public static final void translate(DrawScope drawScope, float f, float f2, Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        drawScope.getDrawContext().getTransform().translate(f, f2);
        function1.invoke(drawScope);
        drawScope.getDrawContext().getTransform().translate(-f, -f2);
    }

    /* renamed from: rotate-Rg1IO4c$default  reason: not valid java name */
    public static /* synthetic */ void m2558rotateRg1IO4c$default(DrawScope drawScope, float f, long j, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawScope.m2477getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter(drawScope, "$this$rotate");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r0 = drawContext.m2456getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m2569rotateUv8p0NA(f, j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m2457setSizeuvyYCjk(r0);
    }

    /* renamed from: rotateRad-Rg1IO4c$default  reason: not valid java name */
    public static /* synthetic */ void m2560rotateRadRg1IO4c$default(DrawScope drawScope, float f, long j, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawScope.m2477getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter(drawScope, "$this$rotateRad");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r0 = drawContext.m2456getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m2569rotateUv8p0NA(DegreesKt.degrees(f), j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m2457setSizeuvyYCjk(r0);
    }

    /* renamed from: scale-Fgt4K4Q$default  reason: not valid java name */
    public static /* synthetic */ void m2562scaleFgt4K4Q$default(DrawScope drawScope, float f, float f2, long j, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            j = drawScope.m2477getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter(drawScope, "$this$scale");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r0 = drawContext.m2456getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m2570scale0AR0LA0(f, f2, j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m2457setSizeuvyYCjk(r0);
    }

    /* renamed from: scale-Rg1IO4c$default  reason: not valid java name */
    public static /* synthetic */ void m2564scaleRg1IO4c$default(DrawScope drawScope, float f, long j, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawScope.m2477getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter(drawScope, "$this$scale");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r0 = drawContext.m2456getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m2570scale0AR0LA0(f, f, j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m2457setSizeuvyYCjk(r0);
    }

    /* renamed from: clipRect-rOu3jXo$default  reason: not valid java name */
    public static /* synthetic */ void m2556clipRectrOu3jXo$default(DrawScope drawScope, float f, float f2, float f3, float f4, int i, Function1 function1, int i2, Object obj) {
        float f5 = (i2 & 1) != 0 ? 0.0f : f;
        float f6 = (i2 & 2) != 0 ? 0.0f : f2;
        if ((i2 & 4) != 0) {
            f3 = Size.m1752getWidthimpl(drawScope.m2478getSizeNHjbRc());
        }
        float f7 = f3;
        if ((i2 & 8) != 0) {
            f4 = Size.m1749getHeightimpl(drawScope.m2478getSizeNHjbRc());
        }
        float f8 = f4;
        if ((i2 & 16) != 0) {
            i = ClipOp.Companion.m1921getIntersectrtfAjoo();
        }
        Intrinsics.checkNotNullParameter(drawScope, "$this$clipRect");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r9 = drawContext.m2456getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m2566clipRectN_I0leg(f5, f6, f7, f8, i);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m2457setSizeuvyYCjk(r9);
    }

    /* renamed from: clipPath-KD09W0M$default  reason: not valid java name */
    public static /* synthetic */ void m2554clipPathKD09W0M$default(DrawScope drawScope, Path path, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = ClipOp.Companion.m1921getIntersectrtfAjoo();
        }
        Intrinsics.checkNotNullParameter(drawScope, "$this$clipPath");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r0 = drawContext.m2456getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m2565clipPathmtrdDE(path, i);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m2457setSizeuvyYCjk(r0);
    }

    public static final void drawIntoCanvas(DrawScope drawScope, Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        function1.invoke(drawScope.getDrawContext().getCanvas());
    }

    public static final void withTransform(DrawScope drawScope, Function1<? super DrawTransform, Unit> function1, Function1<? super DrawScope, Unit> function12) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transformBlock");
        Intrinsics.checkNotNullParameter(function12, "drawBlock");
        DrawContext drawContext = drawScope.getDrawContext();
        long r1 = drawContext.m2456getSizeNHjbRc();
        drawContext.getCanvas().save();
        function1.invoke(drawContext.getTransform());
        function12.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m2457setSizeuvyYCjk(r1);
    }

    public static final void inset(DrawScope drawScope, float f, float f2, Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        drawScope.getDrawContext().getTransform().inset(f, f2, f, f2);
        function1.invoke(drawScope);
        float f3 = -f;
        float f4 = -f2;
        drawScope.getDrawContext().getTransform().inset(f3, f4, f3, f4);
    }

    /* renamed from: rotate-Rg1IO4c  reason: not valid java name */
    public static final void m2557rotateRg1IO4c(DrawScope drawScope, float f, long j, Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$rotate");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r1 = drawContext.m2456getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m2569rotateUv8p0NA(f, j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m2457setSizeuvyYCjk(r1);
    }

    /* renamed from: rotateRad-Rg1IO4c  reason: not valid java name */
    public static final void m2559rotateRadRg1IO4c(DrawScope drawScope, float f, long j, Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$rotateRad");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r1 = drawContext.m2456getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m2569rotateUv8p0NA(DegreesKt.degrees(f), j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m2457setSizeuvyYCjk(r1);
    }

    /* renamed from: scale-Fgt4K4Q  reason: not valid java name */
    public static final void m2561scaleFgt4K4Q(DrawScope drawScope, float f, float f2, long j, Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$scale");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r1 = drawContext.m2456getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m2570scale0AR0LA0(f, f2, j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m2457setSizeuvyYCjk(r1);
    }

    /* renamed from: scale-Rg1IO4c  reason: not valid java name */
    public static final void m2563scaleRg1IO4c(DrawScope drawScope, float f, long j, Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$scale");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r1 = drawContext.m2456getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m2570scale0AR0LA0(f, f, j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m2457setSizeuvyYCjk(r1);
    }

    /* renamed from: clipRect-rOu3jXo  reason: not valid java name */
    public static final void m2555clipRectrOu3jXo(DrawScope drawScope, float f, float f2, float f3, float f4, int i, Function1<? super DrawScope, Unit> function1) {
        DrawScope drawScope2 = drawScope;
        Function1<? super DrawScope, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(drawScope, "$this$clipRect");
        Intrinsics.checkNotNullParameter(function12, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r3 = drawContext.m2456getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m2566clipRectN_I0leg(f, f2, f3, f4, i);
        function12.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m2457setSizeuvyYCjk(r3);
    }

    /* renamed from: clipPath-KD09W0M  reason: not valid java name */
    public static final void m2553clipPathKD09W0M(DrawScope drawScope, Path path, int i, Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$clipPath");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r1 = drawContext.m2456getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m2565clipPathmtrdDE(path, i);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m2457setSizeuvyYCjk(r1);
    }
}
