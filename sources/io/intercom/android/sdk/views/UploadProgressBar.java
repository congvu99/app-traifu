package io.intercom.android.sdk.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.logger.LumberMill;

public class UploadProgressBar extends View {
    private static final int MAX = 100;
    private static final int START_ANGLE = -90;
    private static final int STROKE_WIDTH = 8;
    private final Paint backgroundPaint;
    private final Paint foregroundPaint;
    private int progress;
    private final RectF rectF;
    private final Twig twig;

    public UploadProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public UploadProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.twig = LumberMill.getLogger();
        this.progress = 0;
        this.rectF = new RectF();
        Paint paint = new Paint(1);
        this.backgroundPaint = paint;
        paint.setColor(-2013265920);
        this.backgroundPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.backgroundPaint.setStrokeWidth(8.0f);
        Paint paint2 = new Paint(1);
        this.foregroundPaint = paint2;
        paint2.setColor(-1);
        this.foregroundPaint.setStyle(Paint.Style.STROKE);
        this.foregroundPaint.setStrokeWidth(8.0f);
    }

    public void setProgress(int i) {
        Twig twig2 = this.twig;
        twig2.internal("animation", "received progress of  " + i);
        if (i > this.progress) {
            this.progress = i;
            invalidate();
        }
    }

    private void showBar() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this, "alpha", new float[]{0.0f, 1.0f}).setDuration(300);
        duration.setInterpolator(new DecelerateInterpolator());
        duration.start();
    }

    public void hideBar() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.0f}).setDuration(300);
        duration.setInterpolator(new DecelerateInterpolator());
        duration.start();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = (float) ((this.progress * 360) / 100);
        canvas.drawOval(this.rectF, this.backgroundPaint);
        canvas.drawArc(this.rectF, -90.0f, f, false, this.foregroundPaint);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int min = Math.min(getDefaultSize(getSuggestedMinimumWidth(), i), getDefaultSize(getSuggestedMinimumHeight(), i2));
        setMeasuredDimension(min, min);
        float f = (float) (min - 4);
        this.rectF.set(4.0f, 4.0f, f, f);
    }

    public void smoothStartAnimation() {
        if (getAlpha() < 1.0f) {
            showBar();
        }
        this.twig.internal("animation", "starting upload start animation");
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "progress", new int[]{0, 10});
        ofInt.setDuration(1000);
        ofInt.start();
    }

    public void smoothEndAnimation() {
        ObjectAnimator objectAnimator = getObjectAnimator();
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                UploadProgressBar.this.hideBar();
            }
        });
        objectAnimator.start();
    }

    public void smoothEndAnimation(Animator.AnimatorListener animatorListener) {
        ObjectAnimator objectAnimator = getObjectAnimator();
        objectAnimator.addListener(animatorListener);
        objectAnimator.start();
    }

    private ObjectAnimator getObjectAnimator() {
        this.twig.internal("animation", "starting upload end animation");
        return ObjectAnimator.ofInt(this, "progress", new int[]{90, 99}).setDuration(1000);
    }
}
