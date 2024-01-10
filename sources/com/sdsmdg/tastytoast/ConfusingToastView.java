package com.sdsmdg.tastytoast;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class ConfusingToastView extends View {
    float angle = 0.0f;
    Bitmap eye;
    private float mHeight = 0.0f;
    private Paint mPaint;
    private float mWidth = 0.0f;
    ValueAnimator valueAnimator;

    public ConfusingToastView(Context context) {
        super(context);
    }

    public ConfusingToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ConfusingToastView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = (float) getMeasuredWidth();
        this.mHeight = (float) getMeasuredHeight();
        initPaint();
        initPath();
    }

    private void initPaint() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(Color.parseColor("#FE9D4D"));
    }

    private void initPath() {
        Path path = new Path();
        RectF rectF = new RectF((this.mWidth / 2.0f) - dip2px(1.5f), (this.mHeight / 2.0f) - dip2px(1.5f), (this.mWidth / 2.0f) + dip2px(1.5f), (this.mHeight / 2.0f) + dip2px(1.5f));
        path.addArc(rectF, 180.0f, 180.0f);
        rectF.set(rectF.left - dip2px(3.0f), rectF.top - dip2px(1.5f), rectF.right, rectF.bottom + dip2px(1.5f));
        path.addArc(rectF, 0.0f, 180.0f);
        rectF.set(rectF.left, rectF.top - dip2px(1.5f), rectF.right + dip2px(3.0f), rectF.bottom + dip2px(1.5f));
        path.addArc(rectF, 180.0f, 180.0f);
        rectF.set(rectF.left - dip2px(3.0f), rectF.top - dip2px(1.5f), rectF.right, rectF.bottom + dip2px(1.5f));
        path.addArc(rectF, 0.0f, 180.0f);
        this.eye = Bitmap.createBitmap((int) this.mWidth, (int) this.mHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.eye);
        this.mPaint.setStrokeWidth(dip2px(1.7f));
        canvas.drawPath(path, this.mPaint);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.angle, this.mWidth / 4.0f, (this.mHeight * 2.0f) / 5.0f);
        Bitmap bitmap = this.eye;
        canvas.drawBitmap(bitmap, (this.mWidth / 4.0f) - (((float) bitmap.getWidth()) / 2.0f), ((this.mHeight * 2.0f) / 5.0f) - (((float) this.eye.getHeight()) / 2.0f), this.mPaint);
        canvas.restore();
        canvas.save();
        canvas.rotate(this.angle, (this.mWidth * 3.0f) / 4.0f, (this.mHeight * 2.0f) / 5.0f);
        Bitmap bitmap2 = this.eye;
        canvas.drawBitmap(bitmap2, ((this.mWidth * 3.0f) / 4.0f) - (((float) bitmap2.getWidth()) / 2.0f), ((this.mHeight * 2.0f) / 5.0f) - (((float) this.eye.getHeight()) / 2.0f), this.mPaint);
        canvas.restore();
        this.mPaint.setStrokeWidth(dip2px(2.0f));
        float f = this.mWidth;
        float f2 = this.mHeight;
        canvas.drawLine(f / 4.0f, (f2 * 3.0f) / 4.0f, (f * 3.0f) / 4.0f, (f2 * 3.0f) / 4.0f, this.mPaint);
    }

    public float dip2px(float f) {
        return f * getContext().getResources().getDisplayMetrics().density;
    }

    public void startAnim() {
        stopAnim();
        startViewAnim(0.0f, 1.0f, 2000);
    }

    public void stopAnim() {
        if (this.valueAnimator != null) {
            clearAnimation();
            this.valueAnimator.end();
            postInvalidate();
        }
    }

    private ValueAnimator startViewAnim(float f, float f2, long j) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        this.valueAnimator = ofFloat;
        ofFloat.setDuration(j);
        this.valueAnimator.setInterpolator(new LinearInterpolator());
        this.valueAnimator.setRepeatCount(-1);
        this.valueAnimator.setRepeatMode(1);
        this.valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ConfusingToastView.this.angle += 4.0f;
                ConfusingToastView.this.postInvalidate();
            }
        });
        if (!this.valueAnimator.isRunning()) {
            this.valueAnimator.start();
        }
        return this.valueAnimator;
    }
}
