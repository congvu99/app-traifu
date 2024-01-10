package io.intercom.android.sdk.views;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.conversation.UploadProgressListener;
import io.intercom.android.sdk.logger.LumberMill;

public class ProgressLinearLayout extends LinearLayout implements UploadProgressListener {
    ImageView attachmentIcon;
    private final Twig twig;
    UploadProgressBar uploadProgressBar;

    public ProgressLinearLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ProgressLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.twig = LumberMill.getLogger();
    }

    public void setUploadProgressBar(UploadProgressBar uploadProgressBar2) {
        this.uploadProgressBar = uploadProgressBar2;
    }

    public void setAttachmentIcon(ImageView imageView) {
        this.attachmentIcon = imageView;
    }

    public void uploadStarted() {
        this.uploadProgressBar.smoothStartAnimation();
    }

    public void uploadNotice(final byte b) {
        Twig twig2 = this.twig;
        twig2.internal("progress", "" + b);
        post(new Runnable() {
            public void run() {
                if (ProgressLinearLayout.this.uploadProgressBar != null) {
                    ProgressLinearLayout.this.uploadProgressBar.setProgress(b);
                }
            }
        });
    }

    public void uploadSmoothEnd() {
        post(new Runnable() {
            public void run() {
                if (ProgressLinearLayout.this.uploadProgressBar != null) {
                    ProgressLinearLayout.this.uploadProgressBar.smoothEndAnimation(new Animator.AnimatorListener() {
                        public void onAnimationCancel(Animator animator) {
                        }

                        public void onAnimationRepeat(Animator animator) {
                        }

                        public void onAnimationStart(Animator animator) {
                        }

                        public void onAnimationEnd(Animator animator) {
                            ProgressLinearLayout.this.uploadProgressBar.hideBar();
                            if (ProgressLinearLayout.this.attachmentIcon != null) {
                                ProgressLinearLayout.this.attachmentIcon.setVisibility(0);
                                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(ProgressLinearLayout.this.attachmentIcon, "alpha", new float[]{0.0f, 1.0f});
                                ofFloat.setDuration(300);
                                ofFloat.setInterpolator(new DecelerateInterpolator());
                                ofFloat.start();
                            }
                        }
                    });
                }
            }
        });
    }

    public void uploadStopped() {
        this.uploadProgressBar.hideBar();
    }
}
