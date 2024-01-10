package io.intercom.android.sdk.video;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.widget.MediaController;
import io.intercom.android.sdk.views.IntercomToolbar;

public class IntercomMediaController extends MediaController {
    private static final int ANIMATE_DURATION = 200;
    private Animator.AnimatorListener animateInListener = new Animator.AnimatorListener() {
        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            IntercomMediaController.this.showMediaPlayer();
        }
    };
    private Animator.AnimatorListener animateOutListener = new Animator.AnimatorListener() {
        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            IntercomMediaController.this.hideMediaPlayer();
        }
    };
    private final IntercomToolbar intercomToolbar;

    public IntercomMediaController(Context context, IntercomToolbar intercomToolbar2) {
        super(context);
        this.intercomToolbar = intercomToolbar2;
    }

    public void show() {
        animateToolbarToAlpha(1.0f);
        animate().alpha(1.0f).setDuration(200).setListener(this.animateInListener).start();
    }

    public void hide() {
        animateToolbarToAlpha(0.0f);
        animate().alpha(0.0f).setDuration(200).setListener(this.animateOutListener).start();
    }

    /* access modifiers changed from: private */
    public void hideMediaPlayer() {
        if (!((Activity) getContext()).isFinishing()) {
            this.intercomToolbar.setVisibility(8);
            super.hide();
        }
    }

    /* access modifiers changed from: private */
    public void showMediaPlayer() {
        if (!((Activity) getContext()).isFinishing()) {
            this.intercomToolbar.setVisibility(0);
            super.show(0);
        }
    }

    public void animateToolbarToAlpha(float f) {
        this.intercomToolbar.animate().alpha(f).setDuration(200).start();
    }
}
