package com.intercom.composer.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.LinearLayout;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

public class EditTextLayoutAnimator {
    private static final long EDIT_TEXT_ANIMATION_MS = 350;
    AnimationStatus animationStatus = AnimationStatus.SHOWN;
    final ValueAnimator.AnimatorUpdateListener animationUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ((LinearLayout.LayoutParams) EditTextLayoutAnimator.this.editText.getLayoutParams()).bottomMargin = ((Float) valueAnimator.getAnimatedValue()).intValue();
            EditTextLayoutAnimator.this.editText.requestLayout();
        }
    };
    private ObjectAnimator animator;
    /* access modifiers changed from: private */
    public final View editText;
    /* access modifiers changed from: private */
    public EditTextLayoutAnimatorInternalListener editTextLayoutAnimatorListener;
    final Animator.AnimatorListener hideEditTextAnimationListener = new AnimatorListenerAdapter() {
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            EditTextLayoutAnimator.this.animationStatus = AnimationStatus.HIDDEN;
            if (EditTextLayoutAnimator.this.editTextLayoutAnimatorListener != null) {
                EditTextLayoutAnimator.this.editTextLayoutAnimatorListener.onEditTextLayoutAnimationEnd(AnimationStatus.HIDDEN);
            }
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            EditTextLayoutAnimator.this.animationStatus = AnimationStatus.HIDING;
        }
    };
    final Animator.AnimatorListener showEditTextAnimationListener = new AnimatorListenerAdapter() {
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            EditTextLayoutAnimator.this.animationStatus = AnimationStatus.SHOWN;
            if (EditTextLayoutAnimator.this.editTextLayoutAnimatorListener != null) {
                EditTextLayoutAnimator.this.editTextLayoutAnimatorListener.onEditTextLayoutAnimationEnd(AnimationStatus.SHOWN);
            }
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            EditTextLayoutAnimator.this.animationStatus = AnimationStatus.SHOWING;
        }
    };

    public EditTextLayoutAnimator(View view) {
        this.editText = view;
    }

    public void setEditTextLayoutAnimatorListener(EditTextLayoutAnimatorInternalListener editTextLayoutAnimatorInternalListener) {
        this.editTextLayoutAnimatorListener = editTextLayoutAnimatorInternalListener;
    }

    public void showEditText(boolean z) {
        ObjectAnimator objectAnimator;
        if (this.animationStatus == AnimationStatus.HIDING && (objectAnimator = this.animator) != null) {
            objectAnimator.cancel();
        }
        if (this.animationStatus == AnimationStatus.HIDDEN) {
            View view = this.editText;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "layout_marginBottom", new float[]{(float) (-view.getHeight()), 0.0f});
            this.animator = ofFloat;
            ofFloat.setDuration(z ? EDIT_TEXT_ANIMATION_MS : 0);
            this.animator.setInterpolator(new FastOutSlowInInterpolator());
            this.animator.addUpdateListener(this.animationUpdateListener);
            this.animator.addListener(this.showEditTextAnimationListener);
            this.animator.start();
        }
    }

    public void hideEditText() {
        ObjectAnimator objectAnimator;
        if (this.animationStatus == AnimationStatus.SHOWING && (objectAnimator = this.animator) != null) {
            objectAnimator.cancel();
        }
        if (this.animationStatus == AnimationStatus.SHOWN) {
            View view = this.editText;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "layout_marginBottom", new float[]{0.0f, (float) (-view.getHeight())});
            this.animator = ofFloat;
            ofFloat.setDuration(EDIT_TEXT_ANIMATION_MS);
            this.animator.setInterpolator(new FastOutSlowInInterpolator());
            this.animator.addUpdateListener(this.animationUpdateListener);
            this.animator.addListener(this.hideEditTextAnimationListener);
            this.animator.start();
        }
    }
}
