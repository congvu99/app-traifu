package io.intercom.android.sdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.conversation.UploadProgressListener;
import io.intercom.android.sdk.logger.LumberMill;

public class ProgressFrameLayout extends FrameLayout implements UploadProgressListener {
    private final Twig twig;
    final UploadProgressBar uploadProgressBar;

    public ProgressFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ProgressFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.twig = LumberMill.getLogger();
        UploadProgressBar uploadProgressBar2 = new UploadProgressBar(context, attributeSet);
        this.uploadProgressBar = uploadProgressBar2;
        addView(uploadProgressBar2);
    }

    public void uploadStarted() {
        this.uploadProgressBar.smoothStartAnimation();
    }

    public void uploadNotice(final byte b) {
        Twig twig2 = this.twig;
        twig2.internal("progress", "" + b);
        post(new Runnable() {
            public void run() {
                ProgressFrameLayout.this.uploadProgressBar.setProgress(b);
            }
        });
    }

    public void uploadSmoothEnd() {
        post(new Runnable() {
            public void run() {
                ProgressFrameLayout.this.uploadProgressBar.smoothEndAnimation();
            }
        });
    }

    public void uploadStopped() {
        this.uploadProgressBar.hideBar();
    }
}
