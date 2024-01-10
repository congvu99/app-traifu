package com.sdsmdg.tastytoast;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class ErrorToastView extends View {
    /* access modifiers changed from: private */
    public float endAngle = 0.0f;
    /* access modifiers changed from: private */
    public boolean isJustVisible = false;
    /* access modifiers changed from: private */
    public boolean isSad = false;
    RectF leftEyeRectF = new RectF();
    float mAnimatedValue = 0.0f;
    private float mEyeWidth = 0.0f;
    private float mPadding = 0.0f;
    private Paint mPaint;
    private float mWidth = 0.0f;
    RectF rectF = new RectF();
    RectF rightEyeRectF = new RectF();
    ValueAnimator valueAnimator;

    public ErrorToastView(Context context) {
        super(context);
    }

    public ErrorToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ErrorToastView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        initPaint();
        initRect();
        this.mWidth = (float) getMeasuredWidth();
        this.mPadding = (float) dip2px(10.0f);
        this.mEyeWidth = (float) dip2px(3.0f);
    }

    private void initPaint() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(Color.parseColor("#d9534f"));
        this.mPaint.setStrokeWidth((float) dip2px(2.0f));
    }

    private void initRect() {
        float f = this.mPadding;
        float f2 = this.mWidth;
        this.rectF = new RectF(f / 2.0f, f2 / 2.0f, f2 - (f / 2.0f), (f2 * 3.0f) / 2.0f);
        float f3 = this.mPadding;
        float f4 = this.mEyeWidth;
        float f5 = this.mWidth;
        this.leftEyeRectF = new RectF((f3 + f4) - f4, (f5 / 3.0f) - f4, f3 + f4 + f4, (f5 / 3.0f) + f4);
        float f6 = this.mWidth;
        float f7 = this.mPadding;
        float f8 = this.mEyeWidth;
        this.rightEyeRectF = new RectF((f6 - f7) - ((5.0f * f8) / 2.0f), (f6 / 3.0f) - f8, (f6 - f7) - (f8 / 2.0f), (f6 / 3.0f) + f8);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(this.rectF, 210.0f, this.endAngle, false, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (this.isJustVisible) {
            float f = this.mPadding;
            float f2 = this.mEyeWidth;
            canvas.drawCircle(f + f2 + (f2 / 2.0f), this.mWidth / 3.0f, f2, this.mPaint);
            float f3 = this.mWidth;
            float f4 = this.mEyeWidth;
            canvas.drawCircle(((f3 - this.mPadding) - f4) - (f4 / 2.0f), f3 / 3.0f, f4, this.mPaint);
        }
        if (this.isSad) {
            canvas.drawArc(this.leftEyeRectF, 160.0f, -220.0f, false, this.mPaint);
            canvas.drawArc(this.rightEyeRectF, 20.0f, 220.0f, false, this.mPaint);
        }
    }

    public int dip2px(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void startAnim() {
        stopAnim();
        startViewAnim(0.0f, 1.0f, 2000);
    }

    public void stopAnim() {
        if (this.valueAnimator != null) {
            clearAnimation();
            this.isSad = false;
            this.endAngle = 0.0f;
            this.isJustVisible = false;
            this.mAnimatedValue = 0.0f;
            this.valueAnimator.end();
        }
    }

    private ValueAnimator startViewAnim(float f, float f2, long j) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        this.valueAnimator = ofFloat;
        ofFloat.setDuration(j);
        this.valueAnimator.setInterpolator(new LinearInterpolator());
        this.valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ErrorToastView.this.mAnimatedValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (((double) ErrorToastView.this.mAnimatedValue) < 0.5d) {
                    boolean unused = ErrorToastView.this.isSad = false;
                    boolean unused2 = ErrorToastView.this.isJustVisible = false;
                    ErrorToastView errorToastView = ErrorToastView.this;
                    float unused3 = errorToastView.endAngle = errorToastView.mAnimatedValue * 240.0f;
                    boolean unused4 = ErrorToastView.this.isJustVisible = true;
                } else if (((double) ErrorToastView.this.mAnimatedValue) <= 0.55d || ((double) ErrorToastView.this.mAnimatedValue) >= 0.7d) {
                    float unused5 = ErrorToastView.this.endAngle = 120.0f;
                    boolean unused6 = ErrorToastView.this.isSad = true;
                    boolean unused7 = ErrorToastView.this.isJustVisible = false;
                } else {
                    float unused8 = ErrorToastView.this.endAngle = 120.0f;
                    boolean unused9 = ErrorToastView.this.isSad = false;
                    boolean unused10 = ErrorToastView.this.isJustVisible = true;
                }
                ErrorToastView.this.postInvalidate();
            }
        });
        if (!this.valueAnimator.isRunning()) {
            this.valueAnimator.start();
        }
        return this.valueAnimator;
    }
}
