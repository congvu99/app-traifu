package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import fr.castorflex.android.smoothprogressbar.SmoothProgressDrawable;

public class SmoothProgressBar extends ProgressBar {
    private static final int INTERPOLATOR_ACCELERATE = 0;
    private static final int INTERPOLATOR_ACCELERATEDECELERATE = 2;
    private static final int INTERPOLATOR_DECELERATE = 3;
    private static final int INTERPOLATOR_LINEAR = 1;

    public SmoothProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public SmoothProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.spbStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmoothProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interpolator interpolator;
        Context context2 = context;
        if (isInEditMode()) {
            setIndeterminateDrawable(new SmoothProgressDrawable.Builder(context2, true).build());
            return;
        }
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.SmoothProgressBar, i, 0);
        int color = obtainStyledAttributes.getColor(R.styleable.SmoothProgressBar_spb_color, resources.getColor(R.color.spb_default_color));
        int integer = obtainStyledAttributes.getInteger(R.styleable.SmoothProgressBar_spb_sections_count, resources.getInteger(R.integer.spb_default_sections_count));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SmoothProgressBar_spb_stroke_separator_length, resources.getDimensionPixelSize(R.dimen.spb_default_stroke_separator_length));
        float dimension = obtainStyledAttributes.getDimension(R.styleable.SmoothProgressBar_spb_stroke_width, resources.getDimension(R.dimen.spb_default_stroke_width));
        float f = obtainStyledAttributes.getFloat(R.styleable.SmoothProgressBar_spb_speed, Float.parseFloat(resources.getString(R.string.spb_default_speed)));
        float f2 = obtainStyledAttributes.getFloat(R.styleable.SmoothProgressBar_spb_progressiveStart_speed, f);
        float f3 = obtainStyledAttributes.getFloat(R.styleable.SmoothProgressBar_spb_progressiveStop_speed, f);
        int integer2 = obtainStyledAttributes.getInteger(R.styleable.SmoothProgressBar_spb_interpolator, -1);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SmoothProgressBar_spb_reversed, resources.getBoolean(R.bool.spb_default_reversed));
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SmoothProgressBar_spb_mirror_mode, resources.getBoolean(R.bool.spb_default_mirror_mode));
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SmoothProgressBar_spb_colors, 0);
        boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.SmoothProgressBar_spb_progressiveStart_activated, resources.getBoolean(R.bool.spb_default_progressiveStart_activated));
        int i2 = color;
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.SmoothProgressBar_spb_background);
        boolean z4 = obtainStyledAttributes.getBoolean(R.styleable.SmoothProgressBar_spb_generate_background_with_colors, false);
        boolean z5 = obtainStyledAttributes.getBoolean(R.styleable.SmoothProgressBar_spb_gradients, false);
        obtainStyledAttributes.recycle();
        int[] iArr = null;
        if (integer2 == -1) {
            interpolator = getInterpolator();
        } else {
            interpolator = null;
        }
        if (interpolator == null) {
            if (integer2 == 1) {
                interpolator = new LinearInterpolator();
            } else if (integer2 != 2) {
                interpolator = integer2 != 3 ? new AccelerateInterpolator() : new DecelerateInterpolator();
            } else {
                interpolator = new AccelerateDecelerateInterpolator();
            }
        }
        iArr = resourceId != 0 ? resources.getIntArray(resourceId) : iArr;
        SmoothProgressDrawable.Builder gradients = new SmoothProgressDrawable.Builder(context2).speed(f).progressiveStartSpeed(f2).progressiveStopSpeed(f3).interpolator(interpolator).sectionsCount(integer).separatorLength(dimensionPixelSize).strokeWidth(dimension).reversed(z).mirrorMode(z2).progressiveStart(z3).gradients(z5);
        if (drawable != null) {
            gradients.backgroundDrawable(drawable);
        }
        if (z4) {
            gradients.generateBackgroundUsingColors();
        }
        if (iArr == null || iArr.length <= 0) {
            gradients.color(i2);
        } else {
            gradients.colors(iArr);
        }
        setIndeterminateDrawable(gradients.build());
    }

    public void applyStyle(int i) {
        int resourceId;
        int[] intArray;
        Interpolator interpolator = null;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.SmoothProgressBar, 0, i);
        if (obtainStyledAttributes.hasValue(R.styleable.SmoothProgressBar_spb_color)) {
            setSmoothProgressDrawableColor(obtainStyledAttributes.getColor(R.styleable.SmoothProgressBar_spb_color, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SmoothProgressBar_spb_colors) && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.SmoothProgressBar_spb_colors, 0)) != 0 && (intArray = getResources().getIntArray(resourceId)) != null && intArray.length > 0) {
            setSmoothProgressDrawableColors(intArray);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SmoothProgressBar_spb_sections_count)) {
            setSmoothProgressDrawableSectionsCount(obtainStyledAttributes.getInteger(R.styleable.SmoothProgressBar_spb_sections_count, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SmoothProgressBar_spb_stroke_separator_length)) {
            setSmoothProgressDrawableSeparatorLength(obtainStyledAttributes.getDimensionPixelSize(R.styleable.SmoothProgressBar_spb_stroke_separator_length, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SmoothProgressBar_spb_stroke_width)) {
            setSmoothProgressDrawableStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.SmoothProgressBar_spb_stroke_width, 0.0f));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SmoothProgressBar_spb_speed)) {
            setSmoothProgressDrawableSpeed(obtainStyledAttributes.getFloat(R.styleable.SmoothProgressBar_spb_speed, 0.0f));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SmoothProgressBar_spb_progressiveStart_speed)) {
            setSmoothProgressDrawableProgressiveStartSpeed(obtainStyledAttributes.getFloat(R.styleable.SmoothProgressBar_spb_progressiveStart_speed, 0.0f));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SmoothProgressBar_spb_progressiveStop_speed)) {
            setSmoothProgressDrawableProgressiveStopSpeed(obtainStyledAttributes.getFloat(R.styleable.SmoothProgressBar_spb_progressiveStop_speed, 0.0f));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SmoothProgressBar_spb_reversed)) {
            setSmoothProgressDrawableReversed(obtainStyledAttributes.getBoolean(R.styleable.SmoothProgressBar_spb_reversed, false));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SmoothProgressBar_spb_mirror_mode)) {
            setSmoothProgressDrawableMirrorMode(obtainStyledAttributes.getBoolean(R.styleable.SmoothProgressBar_spb_mirror_mode, false));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SmoothProgressBar_spb_progressiveStart_activated)) {
            setProgressiveStartActivated(obtainStyledAttributes.getBoolean(R.styleable.SmoothProgressBar_spb_progressiveStart_activated, false));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SmoothProgressBar_spb_progressiveStart_activated)) {
            setProgressiveStartActivated(obtainStyledAttributes.getBoolean(R.styleable.SmoothProgressBar_spb_progressiveStart_activated, false));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SmoothProgressBar_spb_gradients)) {
            setSmoothProgressDrawableUseGradients(obtainStyledAttributes.getBoolean(R.styleable.SmoothProgressBar_spb_gradients, false));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SmoothProgressBar_spb_generate_background_with_colors) && obtainStyledAttributes.getBoolean(R.styleable.SmoothProgressBar_spb_generate_background_with_colors, false)) {
            setSmoothProgressDrawableBackgroundDrawable(SmoothProgressBarUtils.generateDrawableWithColors(checkIndeterminateDrawable().getColors(), checkIndeterminateDrawable().getStrokeWidth()));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SmoothProgressBar_spb_interpolator)) {
            int integer = obtainStyledAttributes.getInteger(R.styleable.SmoothProgressBar_spb_interpolator, -1);
            if (integer == 0) {
                interpolator = new AccelerateInterpolator();
            } else if (integer == 1) {
                interpolator = new LinearInterpolator();
            } else if (integer == 2) {
                interpolator = new AccelerateDecelerateInterpolator();
            } else if (integer == 3) {
                interpolator = new DecelerateInterpolator();
            }
            if (interpolator != null) {
                setInterpolator(interpolator);
            }
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isIndeterminate() && (getIndeterminateDrawable() instanceof SmoothProgressDrawable) && !((SmoothProgressDrawable) getIndeterminateDrawable()).isRunning()) {
            getIndeterminateDrawable().draw(canvas);
        }
    }

    private SmoothProgressDrawable checkIndeterminateDrawable() {
        Drawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null && (indeterminateDrawable instanceof SmoothProgressDrawable)) {
            return (SmoothProgressDrawable) indeterminateDrawable;
        }
        throw new RuntimeException("The drawable is not a SmoothProgressDrawable");
    }

    public void setInterpolator(Interpolator interpolator) {
        super.setInterpolator(interpolator);
        Drawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null && (indeterminateDrawable instanceof SmoothProgressDrawable)) {
            ((SmoothProgressDrawable) indeterminateDrawable).setInterpolator(interpolator);
        }
    }

    public void setSmoothProgressDrawableInterpolator(Interpolator interpolator) {
        checkIndeterminateDrawable().setInterpolator(interpolator);
    }

    public void setSmoothProgressDrawableColors(int[] iArr) {
        checkIndeterminateDrawable().setColors(iArr);
    }

    public void setSmoothProgressDrawableColor(int i) {
        checkIndeterminateDrawable().setColor(i);
    }

    public void setSmoothProgressDrawableSpeed(float f) {
        checkIndeterminateDrawable().setSpeed(f);
    }

    public void setSmoothProgressDrawableProgressiveStartSpeed(float f) {
        checkIndeterminateDrawable().setProgressiveStartSpeed(f);
    }

    public void setSmoothProgressDrawableProgressiveStopSpeed(float f) {
        checkIndeterminateDrawable().setProgressiveStopSpeed(f);
    }

    public void setSmoothProgressDrawableSectionsCount(int i) {
        checkIndeterminateDrawable().setSectionsCount(i);
    }

    public void setSmoothProgressDrawableSeparatorLength(int i) {
        checkIndeterminateDrawable().setSeparatorLength(i);
    }

    public void setSmoothProgressDrawableStrokeWidth(float f) {
        checkIndeterminateDrawable().setStrokeWidth(f);
    }

    public void setSmoothProgressDrawableReversed(boolean z) {
        checkIndeterminateDrawable().setReversed(z);
    }

    public void setSmoothProgressDrawableMirrorMode(boolean z) {
        checkIndeterminateDrawable().setMirrorMode(z);
    }

    public void setProgressiveStartActivated(boolean z) {
        checkIndeterminateDrawable().setProgressiveStartActivated(z);
    }

    public void setSmoothProgressDrawableCallbacks(SmoothProgressDrawable.Callbacks callbacks) {
        checkIndeterminateDrawable().setCallbacks(callbacks);
    }

    public void setSmoothProgressDrawableBackgroundDrawable(Drawable drawable) {
        checkIndeterminateDrawable().setBackgroundDrawable(drawable);
    }

    public void setSmoothProgressDrawableUseGradients(boolean z) {
        checkIndeterminateDrawable().setUseGradients(z);
    }

    public void progressiveStart() {
        checkIndeterminateDrawable().progressiveStart();
    }

    public void progressiveStop() {
        checkIndeterminateDrawable().progressiveStop();
    }
}
