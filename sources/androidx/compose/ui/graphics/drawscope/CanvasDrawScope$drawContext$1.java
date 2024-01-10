package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.Canvas;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"androidx/compose/ui/graphics/drawscope/CanvasDrawScope$drawContext$1", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "getCanvas", "()Landroidx/compose/ui/graphics/Canvas;", "value", "Landroidx/compose/ui/geometry/Size;", "size", "getSize-NH-jbRc", "()J", "setSize-uvyYCjk", "(J)V", "transform", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "getTransform", "()Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CanvasDrawScope.kt */
public final class CanvasDrawScope$drawContext$1 implements DrawContext {
    final /* synthetic */ CanvasDrawScope this$0;
    private final DrawTransform transform = CanvasDrawScopeKt.asDrawTransform(this);

    CanvasDrawScope$drawContext$1(CanvasDrawScope canvasDrawScope) {
        this.this$0 = canvasDrawScope;
    }

    public Canvas getCanvas() {
        return this.this$0.getDrawParams().getCanvas();
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public long m2417getSizeNHjbRc() {
        return this.this$0.getDrawParams().m2415getSizeNHjbRc();
    }

    /* renamed from: setSize-uvyYCjk  reason: not valid java name */
    public void m2418setSizeuvyYCjk(long j) {
        this.this$0.getDrawParams().m2416setSizeuvyYCjk(j);
    }

    public DrawTransform getTransform() {
        return this.transform;
    }
}
