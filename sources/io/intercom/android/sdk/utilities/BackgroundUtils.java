package io.intercom.android.sdk.utilities;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.widget.TextView;
import io.intercom.android.sdk.R;

public class BackgroundUtils {
    public static void setBackground(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void animateBackground(int i, int i2, int i3, View view, Animator.AnimatorListener animatorListener) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        ofObject.setDuration((long) i3);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(view) {
            public final /* synthetic */ View f$0;

            {
                this.f$0 = r1;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        if (animatorListener != null) {
            ofObject.addListener(animatorListener);
        }
        ofObject.start();
    }

    public static void setRippleButtonStroke(Context context, Drawable drawable, int i, int i2) {
        updateStroke((GradientDrawable) ((RippleDrawable) drawable).findDrawableByLayerId(i), context, i2);
    }

    public static void setRippleButtonBackgroundColor(Drawable drawable, int i, int i2) {
        ((GradientDrawable) ((RippleDrawable) drawable).findDrawableByLayerId(i)).setColor(i2);
    }

    private static void updateStroke(GradientDrawable gradientDrawable, Context context, int i) {
        gradientDrawable.setStroke(context.getResources().getDimensionPixelSize(R.dimen.intercom_home_button_stroke_size), i);
    }

    public static void setButtonColor(TextView textView, int i) {
        int buttonTextColorVariant = ColorUtils.buttonTextColorVariant(i);
        int buttonBackgroundColorVariant = ColorUtils.buttonBackgroundColorVariant(i);
        textView.setTextColor(buttonTextColorVariant);
        textView.getBackground().setColorFilter(buttonBackgroundColorVariant, PorterDuff.Mode.SRC_ATOP);
    }
}
