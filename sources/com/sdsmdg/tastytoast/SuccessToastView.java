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

public class SuccessToastView extends View {
    /* access modifiers changed from: private */
    public float endAngle = 0.0f;
    /* access modifiers changed from: private */
    public boolean isSmileLeft = false;
    /* access modifiers changed from: private */
    public boolean isSmileRight = false;
    float mAnimatedValue = 0.0f;
    private float mEyeWidth = 0.0f;
    private float mPadding = 0.0f;
    private Paint mPaint;
    private float mWidth = 0.0f;
    RectF rectF = new RectF();
    ValueAnimator valueAnimator;

    public SuccessToastView(Context context) {
        super(context);
    }

    public SuccessToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SuccessToastView(Context context, AttributeSet attributeSet, int i) {
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
        this.mPaint.setColor(Color.parseColor("#5cb85c"));
        this.mPaint.setStrokeWidth((float) dip2px(2.0f));
    }

    private void initRect() {
        float f = this.mPadding;
        float f2 = this.mWidth;
        this.rectF = new RectF(f, f, f2 - f, f2 - f);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(this.rectF, 180.0f, this.endAngle, false, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (this.isSmileLeft) {
            float f = this.mPadding;
            float f2 = this.mEyeWidth;
            canvas.drawCircle(f + f2 + (f2 / 2.0f), this.mWidth / 3.0f, f2, this.mPaint);
        }
        if (this.isSmileRight) {
            float f3 = this.mWidth;
            float f4 = this.mEyeWidth;
            canvas.drawCircle(((f3 - this.mPadding) - f4) - (f4 / 2.0f), f3 / 3.0f, f4, this.mPaint);
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
            this.isSmileLeft = false;
            this.isSmileRight = false;
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
                SuccessToastView.this.mAnimatedValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (((double) SuccessToastView.this.mAnimatedValue) < 0.5d) {
                    boolean unused = SuccessToastView.this.isSmileLeft = false;
                    boolean unused2 = SuccessToastView.this.isSmileRight = false;
                    SuccessToastView successToastView = SuccessToastView.this;
                    float unused3 = successToastView.endAngle = successToastView.mAnimatedValue * -360.0f;
                } else if (((double) SuccessToastView.this.mAnimatedValue) <= 0.55d || ((double) SuccessToastView.this.mAnimatedValue) >= 0.7d) {
                    float unused4 = SuccessToastView.this.endAngle = -180.0f;
                    boolean unused5 = SuccessToastView.this.isSmileLeft = true;
                    boolean unused6 = SuccessToastView.this.isSmileRight = true;
                } else {
                    float unused7 = SuccessToastView.this.endAngle = -180.0f;
                    boolean unused8 = SuccessToastView.this.isSmileLeft = true;
                    boolean unused9 = SuccessToastView.this.isSmileRight = false;
                }
                SuccessToastView.this.postInvalidate();
            }
        });
        if (!this.valueAnimator.isRunning()) {
            this.valueAnimator.start();
        }
        return this.valueAnimator;
    }
}
