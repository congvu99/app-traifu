package androidx.compose.ui.text.platform;

import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextPaint;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPathEffect_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J/\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020\u0005ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u001b\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010(\u001a\u00020\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010)\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR&\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR/\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidTextPaint;", "Landroid/text/TextPaint;", "flags", "", "density", "", "(IF)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush$ui_text_release$annotations", "()V", "getBrush$ui_text_release", "()Landroidx/compose/ui/graphics/Brush;", "setBrush$ui_text_release", "(Landroidx/compose/ui/graphics/Brush;)V", "brushSize", "Landroidx/compose/ui/geometry/Size;", "getBrushSize-VsRJwc0$ui_text_release$annotations", "getBrushSize-VsRJwc0$ui_text_release", "()Landroidx/compose/ui/geometry/Size;", "setBrushSize-iaC8Vc4$ui_text_release", "(Landroidx/compose/ui/geometry/Size;)V", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "setBrush", "", "size", "alpha", "setBrush-12SF9DM", "(Landroidx/compose/ui/graphics/Brush;JF)V", "setColor", "color", "Landroidx/compose/ui/graphics/Color;", "setColor-8_81llA", "(J)V", "setDrawStyle", "setShadow", "setTextDecoration", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidTextPaint.android.kt */
public final class AndroidTextPaint extends TextPaint {
    private Brush brush;
    private Size brushSize;
    private DrawStyle drawStyle;
    private Shadow shadow = Shadow.Companion.getNone();
    private TextDecoration textDecoration = TextDecoration.Companion.getNone();

    public static /* synthetic */ void getBrush$ui_text_release$annotations() {
    }

    /* renamed from: getBrushSize-VsRJwc0$ui_text_release$annotations  reason: not valid java name */
    public static /* synthetic */ void m4435getBrushSizeVsRJwc0$ui_text_release$annotations() {
    }

    public AndroidTextPaint(int i, float f) {
        super(i);
        this.density = f;
    }

    public final Brush getBrush$ui_text_release() {
        return this.brush;
    }

    public final void setBrush$ui_text_release(Brush brush2) {
        this.brush = brush2;
    }

    /* renamed from: getBrushSize-VsRJwc0$ui_text_release  reason: not valid java name */
    public final Size m4437getBrushSizeVsRJwc0$ui_text_release() {
        return this.brushSize;
    }

    /* renamed from: setBrushSize-iaC8Vc4$ui_text_release  reason: not valid java name */
    public final void m4439setBrushSizeiaC8Vc4$ui_text_release(Size size) {
        this.brushSize = size;
    }

    public final void setTextDecoration(TextDecoration textDecoration2) {
        if (textDecoration2 != null && !Intrinsics.areEqual((Object) this.textDecoration, (Object) textDecoration2)) {
            this.textDecoration = textDecoration2;
            setUnderlineText(textDecoration2.contains(TextDecoration.Companion.getUnderline()));
            setStrikeThruText(this.textDecoration.contains(TextDecoration.Companion.getLineThrough()));
        }
    }

    public final void setShadow(Shadow shadow2) {
        if (shadow2 != null && !Intrinsics.areEqual((Object) this.shadow, (Object) shadow2)) {
            this.shadow = shadow2;
            if (Intrinsics.areEqual((Object) shadow2, (Object) Shadow.Companion.getNone())) {
                clearShadowLayer();
            } else {
                setShadowLayer(TextPaintExtensions_androidKt.correctBlurRadius(this.shadow.getBlurRadius()), Offset.m1683getXimpl(this.shadow.m2265getOffsetF1C5BW0()), Offset.m1684getYimpl(this.shadow.m2265getOffsetF1C5BW0()), ColorKt.m1987toArgb8_81llA(this.shadow.m2264getColor0d7_KjU()));
            }
        }
    }

    /* renamed from: setBrush-12SF9DM$default  reason: not valid java name */
    public static /* synthetic */ void m4436setBrush12SF9DM$default(AndroidTextPaint androidTextPaint, Brush brush2, long j, float f, int i, Object obj) {
        if ((i & 4) != 0) {
            f = Float.NaN;
        }
        androidTextPaint.m4438setBrush12SF9DM(brush2, j, f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
        if ((r0 == null ? false : androidx.compose.ui.geometry.Size.m1748equalsimpl0(r0.m1757unboximpl(), r6)) == false) goto L_0x0040;
     */
    /* renamed from: setBrush-12SF9DM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m4438setBrush12SF9DM(androidx.compose.ui.graphics.Brush r5, long r6, float r8) {
        /*
            r4 = this;
            if (r5 != 0) goto L_0x000b
            r5 = 0
            r4.setShader(r5)
            r4.brush = r5
            r4.brushSize = r5
            goto L_0x0064
        L_0x000b:
            boolean r0 = r5 instanceof androidx.compose.ui.graphics.SolidColor
            if (r0 == 0) goto L_0x001d
            androidx.compose.ui.graphics.SolidColor r5 = (androidx.compose.ui.graphics.SolidColor) r5
            long r5 = r5.m2269getValue0d7_KjU()
            long r5 = androidx.compose.ui.text.style.TextDrawStyleKt.m4572modulateDxMtmZc(r5, r8)
            r4.m4440setColor8_81llA(r5)
            goto L_0x0064
        L_0x001d:
            boolean r0 = r5 instanceof androidx.compose.ui.graphics.ShaderBrush
            if (r0 == 0) goto L_0x0064
            android.graphics.Shader r0 = r4.getShader()
            r1 = 0
            if (r0 == 0) goto L_0x0040
            androidx.compose.ui.graphics.Brush r0 = r4.brush
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r5)
            if (r0 == 0) goto L_0x0040
            androidx.compose.ui.geometry.Size r0 = r4.brushSize
            if (r0 != 0) goto L_0x0036
            r0 = 0
            goto L_0x003e
        L_0x0036:
            long r2 = r0.m1757unboximpl()
            boolean r0 = androidx.compose.ui.geometry.Size.m1748equalsimpl0(r2, r6)
        L_0x003e:
            if (r0 != 0) goto L_0x005e
        L_0x0040:
            androidx.compose.ui.geometry.Size$Companion r0 = androidx.compose.ui.geometry.Size.Companion
            long r2 = r0.m1760getUnspecifiedNHjbRc()
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x004b
            r1 = 1
        L_0x004b:
            if (r1 == 0) goto L_0x005e
            r4.brush = r5
            androidx.compose.ui.geometry.Size r0 = androidx.compose.ui.geometry.Size.m1740boximpl(r6)
            r4.brushSize = r0
            androidx.compose.ui.graphics.ShaderBrush r5 = (androidx.compose.ui.graphics.ShaderBrush) r5
            android.graphics.Shader r5 = r5.m2251createShaderuvyYCjk(r6)
            r4.setShader(r5)
        L_0x005e:
            r5 = r4
            android.text.TextPaint r5 = (android.text.TextPaint) r5
            androidx.compose.ui.text.platform.AndroidTextPaint_androidKt.setAlpha(r5, r8)
        L_0x0064:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidTextPaint.m4438setBrush12SF9DM(androidx.compose.ui.graphics.Brush, long, float):void");
    }

    public final void setDrawStyle(DrawStyle drawStyle2) {
        if (drawStyle2 != null && !Intrinsics.areEqual((Object) this.drawStyle, (Object) drawStyle2)) {
            this.drawStyle = drawStyle2;
            if (Intrinsics.areEqual((Object) drawStyle2, (Object) Fill.INSTANCE)) {
                setStyle(Paint.Style.FILL);
            } else if (drawStyle2 instanceof Stroke) {
                setStyle(Paint.Style.STROKE);
                Stroke stroke = (Stroke) drawStyle2;
                setStrokeWidth(stroke.getWidth());
                setStrokeMiter(stroke.getMiter());
                setStrokeJoin(AndroidTextPaint_androidKt.m4444toAndroidJoinWw9F2mQ(stroke.m2599getJoinLxFBmk8()));
                setStrokeCap(AndroidTextPaint_androidKt.m4443toAndroidCapBeK7IIE(stroke.m2598getCapKaPHkGw()));
                PathEffect pathEffect = stroke.getPathEffect();
                setPathEffect(pathEffect != null ? AndroidPathEffect_androidKt.asAndroidPathEffect(pathEffect) : null);
            }
        }
    }

    /* renamed from: setColor-8_81llA  reason: not valid java name */
    public final void m4440setColor8_81llA(long j) {
        if (j != Color.Companion.m1968getUnspecified0d7_KjU()) {
            int r4 = ColorKt.m1987toArgb8_81llA(j);
            if (getColor() != r4) {
                setColor(r4);
            }
            setShader((Shader) null);
            this.brush = null;
            this.brushSize = null;
        }
    }
}
