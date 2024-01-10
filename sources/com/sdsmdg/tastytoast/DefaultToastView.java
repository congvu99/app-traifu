package com.sdsmdg.tastytoast;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class DefaultToastView extends View {
    float mAnimatedValue = 0.0f;
    private float mPadding = 0.0f;
    private Paint mPaint;
    private float mSpikeLength;
    private Paint mSpikePaint;
    private float mWidth = 0.0f;
    ValueAnimator valueAnimator;

    public DefaultToastView(Context context) {
        super(context);
    }

    public DefaultToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DefaultToastView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        initPaint();
        this.mWidth = (float) getMeasuredWidth();
        this.mPadding = (float) dip2px(5.0f);
    }

    private void initPaint() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(Color.parseColor("#222222"));
        this.mPaint.setStrokeWidth((float) dip2px(2.0f));
        Paint paint2 = new Paint();
        this.mSpikePaint = paint2;
        paint2.setAntiAlias(true);
        this.mSpikePaint.setStyle(Paint.Style.STROKE);
        this.mSpikePaint.setColor(Color.parseColor("#222222"));
        this.mSpikePaint.setStrokeWidth((float) dip2px(4.0f));
        this.mSpikeLength = (float) dip2px(4.0f);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        float f = this.mWidth;
        canvas.drawCircle(f / 2.0f, f / 2.0f, f / 4.0f, this.mPaint);
        for (int i = 0; i < 360; i += 40) {
            double d = (((double) ((int) ((this.mAnimatedValue * 40.0f) + ((float) i)))) * 3.141592653589793d) / 180.0d;
            float sin = (float) (((double) ((this.mWidth / 4.0f) + this.mSpikeLength)) * Math.sin(d));
            float f2 = this.mWidth;
            float cos = (f2 / 2.0f) - ((float) (((double) (this.mWidth / 4.0f)) * Math.cos(d)));
            Canvas canvas2 = canvas;
            float f3 = cos;
            canvas2.drawLine(f3, (f2 / 2.0f) - ((float) (((double) (this.mWidth / 4.0f)) * Math.sin(d))), (f2 / 2.0f) - ((float) (((double) ((this.mWidth / 4.0f) + this.mSpikeLength)) * Math.cos(d))), (f2 / 2.0f) - sin, this.mSpikePaint);
        }
        canvas.restore();
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
                DefaultToastView.this.mAnimatedValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                DefaultToastView.this.postInvalidate();
            }
        });
        if (!this.valueAnimator.isRunning()) {
            this.valueAnimator.start();
        }
        return this.valueAnimator;
    }

    public int dip2px(float f) {
        return (int) (f * getContext().getResources().getDisplayMetrics().density);
    }
}
