package com.joanzapata.iconify.internal;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;
import com.joanzapata.iconify.Icon;

public class CustomTypefaceSpan extends ReplacementSpan {
    private static final float BASELINE_RATIO = 0.14285715f;
    private static final Paint LOCAL_PAINT = new Paint();
    private static final int ROTATION_DURATION = 2000;
    private static final Rect TEXT_BOUNDS = new Rect();
    private final boolean baselineAligned;
    private final String icon;
    private final int iconColor;
    private final float iconSizePx;
    private final float iconSizeRatio;
    private final boolean rotate;
    private final long rotationStartTime = System.currentTimeMillis();
    private final Typeface type;

    public CustomTypefaceSpan(Icon icon2, Typeface typeface, float f, float f2, int i, boolean z, boolean z2) {
        this.rotate = z;
        this.baselineAligned = z2;
        this.icon = String.valueOf(icon2.character());
        this.type = typeface;
        this.iconSizePx = f;
        this.iconSizeRatio = f2;
        this.iconColor = i;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        LOCAL_PAINT.set(paint);
        applyCustomTypeFace(LOCAL_PAINT, this.type);
        LOCAL_PAINT.getTextBounds(this.icon, 0, 1, TEXT_BOUNDS);
        if (fontMetricsInt != null) {
            fontMetricsInt.descent = (int) (((float) TEXT_BOUNDS.height()) * (this.baselineAligned ? 0.0f : BASELINE_RATIO));
            fontMetricsInt.ascent = -(TEXT_BOUNDS.height() - fontMetricsInt.descent);
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = fontMetricsInt.descent;
        }
        return TEXT_BOUNDS.width();
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        applyCustomTypeFace(paint, this.type);
        paint.getTextBounds(this.icon, 0, 1, TEXT_BOUNDS);
        canvas.save();
        float f2 = this.baselineAligned ? 0.0f : BASELINE_RATIO;
        if (this.rotate) {
            canvas.rotate((((float) (System.currentTimeMillis() - this.rotationStartTime)) / 2000.0f) * 360.0f, (((float) TEXT_BOUNDS.width()) / 2.0f) + f, (((float) i4) - (((float) TEXT_BOUNDS.height()) / 2.0f)) + (((float) TEXT_BOUNDS.height()) * f2));
        }
        canvas.drawText(this.icon, f - ((float) TEXT_BOUNDS.left), ((float) (i4 - TEXT_BOUNDS.bottom)) + (((float) TEXT_BOUNDS.height()) * f2), paint);
        canvas.restore();
    }

    public boolean isAnimated() {
        return this.rotate;
    }

    private void applyCustomTypeFace(Paint paint, Typeface typeface) {
        paint.setFakeBoldText(false);
        paint.setTextSkewX(0.0f);
        paint.setTypeface(typeface);
        if (this.rotate) {
            paint.clearShadowLayer();
        }
        if (this.iconSizeRatio > 0.0f) {
            paint.setTextSize(paint.getTextSize() * this.iconSizeRatio);
        } else {
            float f = this.iconSizePx;
            if (f > 0.0f) {
                paint.setTextSize(f);
            }
        }
        int i = this.iconColor;
        if (i < Integer.MAX_VALUE) {
            paint.setColor(i);
        }
    }
}
