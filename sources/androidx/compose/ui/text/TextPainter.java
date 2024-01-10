package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/TextPainter;", "", "()V", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextPainter.kt */
public final class TextPainter {
    public static final int $stable = 0;
    public static final TextPainter INSTANCE = new TextPainter();

    private TextPainter() {
    }

    public final void paint(Canvas canvas, TextLayoutResult textLayoutResult) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        boolean z = textLayoutResult.getHasVisualOverflow() && !TextOverflow.m4583equalsimpl0(textLayoutResult.getLayoutInput().m4192getOverflowgIe3tQ8(), TextOverflow.Companion.m4592getVisiblegIe3tQ8());
        if (z) {
            Rect r2 = RectKt.m1723Recttz77jQw(Offset.Companion.m1699getZeroF1C5BW0(), SizeKt.Size((float) IntSize.m4864getWidthimpl(textLayoutResult.m4196getSizeYbymL2g()), (float) IntSize.m4863getHeightimpl(textLayoutResult.m4196getSizeYbymL2g())));
            canvas.save();
            Canvas.CC.m1906clipRectmtrdDE$default(canvas, r2, 0, 2, (Object) null);
        }
        try {
            Brush brush = textLayoutResult.getLayoutInput().getStyle().getBrush();
            if (brush != null) {
                textLayoutResult.getMultiParagraph().paint(canvas, brush, textLayoutResult.getLayoutInput().getStyle().getAlpha(), textLayoutResult.getLayoutInput().getStyle().getShadow(), textLayoutResult.getLayoutInput().getStyle().getTextDecoration());
            } else {
                textLayoutResult.getMultiParagraph().m4124paintRPmYEkk(canvas, textLayoutResult.getLayoutInput().getStyle().m4238getColor0d7_KjU(), textLayoutResult.getLayoutInput().getStyle().getShadow(), textLayoutResult.getLayoutInput().getStyle().getTextDecoration());
            }
        } finally {
            if (z) {
                canvas.restore();
            }
        }
    }
}
