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

public class InfoToastView extends View {
    private String TAG = BuildConfig.APPLICATION_ID;
    /* access modifiers changed from: private */
    public float endPoint = 0.0f;
    /* access modifiers changed from: private */
    public boolean isEyeLeft = false;
    /* access modifiers changed from: private */
    public boolean isEyeMiddle = false;
    /* access modifiers changed from: private */
    public boolean isEyeRight = false;
    float mAnimatedValue = 0.0f;
    private float mEyeWidth = 0.0f;
    /* access modifiers changed from: private */
    public float mPadding = 0.0f;
    private Paint mPaint;
    /* access modifiers changed from: private */
    public float mWidth = 0.0f;
    RectF rectF = new RectF();
    ValueAnimator valueAnimator;

    public InfoToastView(Context context) {
        super(context);
    }

    public InfoToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InfoToastView(Context context, AttributeSet attributeSet, int i) {
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
        this.endPoint = this.mPadding;
    }

    private void initPaint() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(Color.parseColor("#337ab7"));
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
        float f = this.mPadding;
        float f2 = this.mWidth;
        canvas.drawLine(f, f2 - ((f * 3.0f) / 2.0f), this.endPoint, f2 - ((f * 3.0f) / 2.0f), this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (this.isEyeLeft) {
            float f3 = this.mPadding;
            float f4 = this.mEyeWidth;
            canvas.drawCircle(f3 + f4, this.mWidth / 3.0f, f4, this.mPaint);
            float f5 = this.mWidth;
            float f6 = this.mEyeWidth;
            canvas.drawCircle((f5 - this.mPadding) - (f6 * 2.0f), f5 / 3.0f, f6, this.mPaint);
        }
        if (this.isEyeMiddle) {
            float f7 = this.mPadding;
            float f8 = this.mEyeWidth;
            canvas.drawCircle(f7 + ((f8 * 3.0f) / 2.0f), this.mWidth / 3.0f, f8, this.mPaint);
            float f9 = this.mWidth;
            float f10 = this.mEyeWidth;
            canvas.drawCircle((f9 - this.mPadding) - ((5.0f * f10) / 2.0f), f9 / 3.0f, f10, this.mPaint);
        }
        if (this.isEyeRight) {
            float f11 = this.mPadding;
            float f12 = this.mEyeWidth;
            canvas.drawCircle(f11 + (2.0f * f12), this.mWidth / 3.0f, f12, this.mPaint);
            float f13 = this.mWidth;
            float f14 = this.mEyeWidth;
            canvas.drawCircle((f13 - this.mPadding) - f14, f13 / 3.0f, f14, this.mPaint);
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
            this.isEyeLeft = false;
            this.isEyeMiddle = false;
            this.isEyeRight = false;
            this.endPoint = this.mPadding;
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
                InfoToastView.this.mAnimatedValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (((double) InfoToastView.this.mAnimatedValue) < 0.9d) {
                    InfoToastView infoToastView = InfoToastView.this;
                    float unused = infoToastView.endPoint = (((infoToastView.mWidth * 2.0f) - (InfoToastView.this.mPadding * 4.0f)) * (InfoToastView.this.mAnimatedValue / 2.0f)) + InfoToastView.this.mPadding;
                } else {
                    InfoToastView infoToastView2 = InfoToastView.this;
                    float unused2 = infoToastView2.endPoint = infoToastView2.mWidth - ((InfoToastView.this.mPadding * 5.0f) / 4.0f);
                }
                if (((double) InfoToastView.this.mAnimatedValue) < 0.16d) {
                    boolean unused3 = InfoToastView.this.isEyeRight = true;
                    boolean unused4 = InfoToastView.this.isEyeLeft = false;
                } else if (((double) InfoToastView.this.mAnimatedValue) < 0.32d) {
                    boolean unused5 = InfoToastView.this.isEyeRight = false;
                    boolean unused6 = InfoToastView.this.isEyeLeft = true;
                } else if (((double) InfoToastView.this.mAnimatedValue) < 0.48d) {
                    boolean unused7 = InfoToastView.this.isEyeRight = true;
                    boolean unused8 = InfoToastView.this.isEyeLeft = false;
                } else if (((double) InfoToastView.this.mAnimatedValue) < 0.64d) {
                    boolean unused9 = InfoToastView.this.isEyeRight = false;
                    boolean unused10 = InfoToastView.this.isEyeLeft = true;
                } else if (((double) InfoToastView.this.mAnimatedValue) < 0.8d) {
                    boolean unused11 = InfoToastView.this.isEyeRight = true;
                    boolean unused12 = InfoToastView.this.isEyeLeft = false;
                } else if (((double) InfoToastView.this.mAnimatedValue) < 0.96d) {
                    boolean unused13 = InfoToastView.this.isEyeRight = false;
                    boolean unused14 = InfoToastView.this.isEyeLeft = true;
                } else {
                    boolean unused15 = InfoToastView.this.isEyeLeft = false;
                    boolean unused16 = InfoToastView.this.isEyeMiddle = true;
                    boolean unused17 = InfoToastView.this.isEyeRight = false;
                }
                InfoToastView.this.postInvalidate();
            }
        });
        if (!this.valueAnimator.isRunning()) {
            this.valueAnimator.start();
        }
        return this.valueAnimator;
    }
}
