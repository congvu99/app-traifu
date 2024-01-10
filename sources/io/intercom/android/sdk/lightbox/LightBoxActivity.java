package io.intercom.android.sdk.lightbox;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Transition;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import coil.request.ImageRequest;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.utilities.IntercomCoilKt;

public class LightBoxActivity extends AppCompatActivity implements LightBoxListener {
    private static final int ANIMATION_TIME_MS = 300;
    private static final String EXTRA_ACTIVITY_FULLSCREEN = "extra_activity_fullscreen";
    private static final String EXTRA_IMAGE_URL = "extra_image_url";
    public static final String TRANSITION_KEY = "lightbox_image";
    private String imageUrl = "";
    ViewGroup rootView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.imageUrl = extras.getString(EXTRA_IMAGE_URL, "");
            if (extras.getBoolean(EXTRA_ACTIVITY_FULLSCREEN, false)) {
                requestWindowFeature(1);
                getWindow().setFlags(1024, 1024);
            }
        }
        super.onCreate(bundle);
        setContentView(R.layout.intercom_activity_lightbox);
        this.rootView = (ViewGroup) findViewById(R.id.root_view);
        LightBoxImageView lightBoxImageView = (LightBoxImageView) findViewById(R.id.full_image);
        lightBoxImageView.setTransitionName(TRANSITION_KEY);
        loadImage(lightBoxImageView);
        reloadAfterTransition(lightBoxImageView);
        lightBoxImageView.setLightBoxListener(this);
        fadeIn();
    }

    private void reloadAfterTransition(final LightBoxImageView lightBoxImageView) {
        getWindow().getSharedElementEnterTransition().addListener(new Transition.TransitionListener() {
            public void onTransitionCancel(Transition transition) {
            }

            public void onTransitionPause(Transition transition) {
            }

            public void onTransitionResume(Transition transition) {
            }

            public void onTransitionStart(Transition transition) {
            }

            public void onTransitionEnd(Transition transition) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        LightBoxActivity.this.loadImage(lightBoxImageView);
                    }
                }, 10);
            }
        });
    }

    /* access modifiers changed from: private */
    public void loadImage(ImageView imageView) {
        IntercomCoilKt.loadIntercomImage(imageView.getContext(), new ImageRequest.Builder(imageView.getContext()).data(this.imageUrl).crossfade(true).error(R.drawable.intercom_image_load_failed).target(imageView).build());
    }

    private void fadeIn() {
        int color = ContextCompat.getColor(this, R.color.intercom_full_transparent_full_black);
        int color2 = ContextCompat.getColor(this, R.color.intercom_transparent_black_lightbox);
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(color), Integer.valueOf(color2)});
        ofObject.setDuration(300);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LightBoxActivity.this.rootView.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofObject.start();
    }

    private void fadeOut() {
        int color = ContextCompat.getColor(this, R.color.intercom_transparent_black_lightbox);
        int color2 = ContextCompat.getColor(this, R.color.intercom_full_transparent_full_black);
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(color), Integer.valueOf(color2)});
        ofObject.setDuration(300);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LightBoxActivity.this.rootView.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofObject.start();
    }

    public static Intent imageIntent(Context context, String str, boolean z) {
        return new Intent(context, LightBoxActivity.class).putExtra(EXTRA_IMAGE_URL, str).putExtra(EXTRA_ACTIVITY_FULLSCREEN, z);
    }

    public void onBackPressed() {
        super.onBackPressed();
        closeLightBox();
    }

    public void closeLightBox() {
        fadeOut();
        supportFinishAfterTransition();
    }
}
