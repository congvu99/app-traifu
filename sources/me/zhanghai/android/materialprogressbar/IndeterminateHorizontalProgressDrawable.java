package me.zhanghai.android.materialprogressbar;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import me.zhanghai.android.materialprogressbar.internal.ThemeUtils;

public class IndeterminateHorizontalProgressDrawable extends IndeterminateProgressDrawableBase implements ShowTrackDrawable {
    private static final float PADDED_INTRINSIC_HEIGHT_DP = 16.0f;
    private static final float PROGRESS_INTRINSIC_HEIGHT_DP = 3.2f;
    private static final RectTransformX RECT_1_TRANSFORM_X = new RectTransformX(-522.6f, 0.1f);
    private static final RectTransformX RECT_2_TRANSFORM_X = new RectTransformX(-197.6f, 0.1f);
    private static final RectF RECT_BOUND = new RectF(-180.0f, -1.0f, 180.0f, 1.0f);
    private static final RectF RECT_PADDED_BOUND = new RectF(-180.0f, -5.0f, 180.0f, 5.0f);
    private static final RectF RECT_PROGRESS = new RectF(-144.0f, -1.0f, 144.0f, 1.0f);
    private int mPaddedIntrinsicHeight;
    private int mProgressIntrinsicHeight;
    private RectTransformX mRect1TransformX = new RectTransformX(RECT_1_TRANSFORM_X);
    private RectTransformX mRect2TransformX = new RectTransformX(RECT_2_TRANSFORM_X);
    private boolean mShowTrack = true;
    private float mTrackAlpha;

    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ boolean getUseIntrinsicPadding() {
        return super.getUseIntrinsicPadding();
    }

    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public /* bridge */ /* synthetic */ void setTint(int i) {
        super.setTint(i);
    }

    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    public /* bridge */ /* synthetic */ void setUseIntrinsicPadding(boolean z) {
        super.setUseIntrinsicPadding(z);
    }

    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    public IndeterminateHorizontalProgressDrawable(Context context) {
        super(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.mProgressIntrinsicHeight = Math.round(PROGRESS_INTRINSIC_HEIGHT_DP * f);
        this.mPaddedIntrinsicHeight = Math.round(f * PADDED_INTRINSIC_HEIGHT_DP);
        this.mTrackAlpha = ThemeUtils.getFloatFromAttrRes(16842803, context);
        this.mAnimators = new Animator[]{Animators.createIndeterminateHorizontalRect1(this.mRect1TransformX), Animators.createIndeterminateHorizontalRect2(this.mRect2TransformX)};
    }

    public boolean getShowTrack() {
        return this.mShowTrack;
    }

    public void setShowTrack(boolean z) {
        if (this.mShowTrack != z) {
            this.mShowTrack = z;
            invalidateSelf();
        }
    }

    public int getIntrinsicHeight() {
        return this.mUseIntrinsicPadding ? this.mPaddedIntrinsicHeight : this.mProgressIntrinsicHeight;
    }

    public int getOpacity() {
        if (this.mAlpha == 0) {
            return -2;
        }
        if (this.mAlpha == 255) {
            return (!this.mShowTrack || this.mTrackAlpha == 1.0f) ? -1 : -3;
        }
        return -3;
    }

    /* access modifiers changed from: protected */
    public void onPreparePaint(Paint paint) {
        paint.setStyle(Paint.Style.FILL);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas, int i, int i2, Paint paint) {
        if (this.mUseIntrinsicPadding) {
            canvas.scale(((float) i) / RECT_PADDED_BOUND.width(), ((float) i2) / RECT_PADDED_BOUND.height());
            canvas.translate(RECT_PADDED_BOUND.width() / 2.0f, RECT_PADDED_BOUND.height() / 2.0f);
        } else {
            canvas.scale(((float) i) / RECT_BOUND.width(), ((float) i2) / RECT_BOUND.height());
            canvas.translate(RECT_BOUND.width() / 2.0f, RECT_BOUND.height() / 2.0f);
        }
        if (this.mShowTrack) {
            paint.setAlpha(Math.round(((float) this.mAlpha) * this.mTrackAlpha));
            drawTrackRect(canvas, paint);
            paint.setAlpha(this.mAlpha);
        }
        drawProgressRect(canvas, this.mRect2TransformX, paint);
        drawProgressRect(canvas, this.mRect1TransformX, paint);
    }

    private static void drawTrackRect(Canvas canvas, Paint paint) {
        canvas.drawRect(RECT_BOUND, paint);
    }

    private static void drawProgressRect(Canvas canvas, RectTransformX rectTransformX, Paint paint) {
        int save = canvas.save();
        canvas.translate(rectTransformX.mTranslateX, 0.0f);
        canvas.scale(rectTransformX.mScaleX, 1.0f);
        canvas.drawRect(RECT_PROGRESS, paint);
        canvas.restoreToCount(save);
    }

    private static class RectTransformX {
        public float mScaleX;
        public float mTranslateX;

        public RectTransformX(float f, float f2) {
            this.mTranslateX = f;
            this.mScaleX = f2;
        }

        public RectTransformX(RectTransformX rectTransformX) {
            this.mTranslateX = rectTransformX.mTranslateX;
            this.mScaleX = rectTransformX.mScaleX;
        }

        public void setTranslateX(float f) {
            this.mTranslateX = f;
        }

        public void setScaleX(float f) {
            this.mScaleX = f;
        }
    }
}