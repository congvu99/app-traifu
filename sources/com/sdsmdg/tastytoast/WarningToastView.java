package com.sdsmdg.tastytoast;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class WarningToastView extends View {
    private float endAngle = 0.0f;
    private float mHeight = 0.0f;
    private float mPadding = 0.0f;
    private float mPaddingBottom = 0.0f;
    private Paint mPaint;
    private float mStrokeWidth = 0.0f;
    private float mWidth = 0.0f;
    RectF rectFOne = new RectF();
    RectF rectFThree = new RectF();
    RectF rectFTwo = new RectF();

    public WarningToastView(Context context) {
        super(context);
    }

    public WarningToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WarningToastView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        initPaint();
        initRect();
        this.mHeight = (float) getMeasuredHeight();
        this.mWidth = (float) getMeasuredWidth();
        float convertDpToPixel = convertDpToPixel(2.0f);
        this.mPadding = convertDpToPixel;
        this.mPaddingBottom = convertDpToPixel * 2.0f;
        this.mStrokeWidth = convertDpToPixel(2.0f);
    }

    private void initPaint() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(Color.parseColor("#f0ad4e"));
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
    }

    private void initRect() {
        float f = this.mPadding;
        float f2 = this.mWidth;
        this.rectFOne = new RectF(f, 0.0f, f2 - f, f2 - this.mPaddingBottom);
        float convertDpToPixel = convertDpToPixel(6.0f);
        float f3 = this.mPadding;
        this.rectFTwo = new RectF((float) (((double) this.mPadding) * 1.5d), convertDpToPixel + f3 + (this.mHeight / 3.0f), f3 + convertDpToPixel(9.0f), convertDpToPixel(6.0f) + this.mPadding + (this.mHeight / 2.0f));
        float convertDpToPixel2 = this.mPadding + convertDpToPixel(9.0f);
        float convertDpToPixel3 = convertDpToPixel(3.0f);
        float f4 = this.mPadding;
        this.rectFThree = new RectF(convertDpToPixel2, convertDpToPixel3 + f4 + (this.mHeight / 3.0f), f4 + convertDpToPixel(18.0f), convertDpToPixel(3.0f) + this.mPadding + (this.mHeight / 2.0f));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(this.rectFOne, 170.0f, -144.0f, false, this.mPaint);
        canvas.drawLine((this.mWidth - convertDpToPixel(3.0f)) - this.mStrokeWidth, this.mPadding + (this.mHeight / 6.0f), (this.mWidth - convertDpToPixel(3.0f)) - this.mStrokeWidth, (this.mHeight - convertDpToPixel(2.0f)) - (this.mHeight / 4.0f), this.mPaint);
        Canvas canvas2 = canvas;
        canvas2.drawLine(((this.mWidth - convertDpToPixel(3.0f)) - this.mStrokeWidth) - convertDpToPixel(8.0f), (float) (((double) this.mPadding) + (((double) this.mHeight) / 8.5d)), ((this.mWidth - convertDpToPixel(3.0f)) - this.mStrokeWidth) - convertDpToPixel(8.0f), (float) (((double) (this.mHeight - convertDpToPixel(3.0f))) - (((double) this.mHeight) / 2.5d)), this.mPaint);
        canvas2.drawLine(((this.mWidth - convertDpToPixel(3.0f)) - this.mStrokeWidth) - convertDpToPixel(17.0f), this.mPadding + (this.mHeight / 10.0f), ((this.mWidth - convertDpToPixel(3.0f)) - this.mStrokeWidth) - convertDpToPixel(17.0f), (float) (((double) (this.mHeight - convertDpToPixel(3.0f))) - (((double) this.mHeight) / 2.5d)), this.mPaint);
        canvas2.drawLine(((this.mWidth - convertDpToPixel(3.0f)) - this.mStrokeWidth) - convertDpToPixel(26.0f), this.mPadding + (this.mHeight / 10.0f), ((this.mWidth - convertDpToPixel(3.0f)) - this.mStrokeWidth) - convertDpToPixel(26.0f), (float) (((double) (this.mHeight - convertDpToPixel(2.0f))) - (((double) this.mHeight) / 2.5d)), this.mPaint);
        canvas.drawArc(this.rectFTwo, 170.0f, 180.0f, false, this.mPaint);
        canvas.drawArc(this.rectFThree, 175.0f, -150.0f, false, this.mPaint);
    }

    public float convertDpToPixel(float f) {
        return f * (((float) getContext().getResources().getDisplayMetrics().densityDpi) / 160.0f);
    }
}
