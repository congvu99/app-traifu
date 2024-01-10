package io.intercom.android.sdk.overlay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import coil.request.ImageRequest;
import com.intercom.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.utilities.BackgroundUtils;
import io.intercom.android.sdk.utilities.IntercomCoilKt;

class DefaultLauncher implements View.OnTouchListener {
    private static final int ANIMATION_DURATION_MS = 300;
    private static final int CUSTOM_LAUNCHER_SIZE_DP = 34;
    private final ImageButton badge = ((ImageButton) this.launcherRoot.findViewById(R.id.launcher_icon));
    private final TextView badgeCount = ((TextView) this.launcherRoot.findViewById(R.id.launcher_badge_count));
    final View launcherRoot;
    final Listener listener;

    public interface Listener {
        void onLauncherClicked(Context context);
    }

    public DefaultLauncher(ViewGroup viewGroup, LayoutInflater layoutInflater, Listener listener2, int i) {
        this.listener = listener2;
        layoutInflater.inflate(R.layout.intercom_default_launcher, viewGroup, true);
        View findViewById = viewGroup.findViewById(R.id.launcher_root);
        this.launcherRoot = findViewById;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, i);
        this.launcherRoot.setLayoutParams(marginLayoutParams);
        this.launcherRoot.setOnTouchListener(this);
    }

    public void setLauncherColor(int i, int i2) {
        Context context = this.badge.getContext();
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.intercom_solid_circle);
        drawable.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
        Drawable newDrawable = drawable.getConstantState().newDrawable();
        newDrawable.setColorFilter(ContextCompat.getColor(context, R.color.intercom_inbox_count_background), PorterDuff.Mode.SRC_IN);
        BackgroundUtils.setBackground(this.badgeCount, newDrawable);
        BackgroundUtils.setBackground(this.badge, drawable);
        Drawable drawable2 = this.badge.getDrawable();
        if (drawable2 != null) {
            drawable2.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        }
    }

    public void setLauncherLogo(AppConfig appConfig) {
        Context context = this.badge.getContext();
        int dpToPx = ScreenUtils.dpToPx(34.0f, context);
        IntercomCoilKt.loadIntercomImage(context, new ImageRequest.Builder(context).data(appConfig.getLauncherLogoUrl()).error(R.drawable.intercom_launcher_icon).target((ImageView) this.badge).size(dpToPx, dpToPx).build());
    }

    public void setBadgeCount(String str) {
        this.badgeCount.setVisibility(0);
        this.badgeCount.setText(str);
    }

    public void hideBadgeCount() {
        this.badgeCount.setVisibility(8);
    }

    public void fadeOnScreen() {
        this.launcherRoot.setAlpha(0.0f);
        this.launcherRoot.animate().alpha(1.0f).setDuration(100).start();
    }

    public void fadeOffScreen(Animator.AnimatorListener animatorListener) {
        this.launcherRoot.animate().alpha(0.0f).setDuration(100).setListener(animatorListener).start();
    }

    public void pulseForTransformation(final Animator.AnimatorListener animatorListener) {
        this.launcherRoot.animate().scaleX(1.1f).scaleY(1.1f).setDuration(100).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                animatorListener.onAnimationEnd(animator);
                DefaultLauncher.this.launcherRoot.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
            }
        }).start();
    }

    public void removeView() {
        if (this.launcherRoot.getParent() != null) {
            ((ViewGroup) this.launcherRoot.getParent()).removeView(this.launcherRoot);
        }
    }

    public boolean isAttachedToRoot(ViewGroup viewGroup) {
        return this.launcherRoot.getParent() == viewGroup;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            view.setScaleX(0.9f);
            view.setScaleY(0.9f);
        } else if (action == 1) {
            callListenerWithFadeOut();
        }
        return true;
    }

    private void callListenerWithFadeOut() {
        this.launcherRoot.setAlpha(1.0f);
        this.launcherRoot.animate().alpha(0.0f).setDuration(50).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                DefaultLauncher.this.listener.onLauncherClicked(DefaultLauncher.this.launcherRoot.getContext());
            }
        }).start();
    }

    public void updateBottomPadding(int i) {
        final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.launcherRoot.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{marginLayoutParams.bottomMargin, i});
        ofInt.setDuration(300);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.MarginLayoutParams marginLayoutParams = marginLayoutParams;
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                DefaultLauncher.this.launcherRoot.setLayoutParams(marginLayoutParams);
            }
        });
        ofInt.start();
    }
}
