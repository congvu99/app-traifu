package io.intercom.android.sdk.views;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.shimmer.Shimmer;
import com.facebook.shimmer.ShimmerFrameLayout;

public class IntercomShimmerLayout extends ShimmerFrameLayout {
    private static final Shimmer SHIMMER_CONFIG = ((Shimmer.AlphaHighlightBuilder) ((Shimmer.AlphaHighlightBuilder) ((Shimmer.AlphaHighlightBuilder) ((Shimmer.AlphaHighlightBuilder) ((Shimmer.AlphaHighlightBuilder) new Shimmer.AlphaHighlightBuilder().setTilt(0.0f)).setIntensity(0.01f)).setDuration(1500)).setHighlightAlpha(0.6f)).setRepeatDelay(100)).build();

    public IntercomShimmerLayout(Context context) {
        super(context);
        init();
    }

    public IntercomShimmerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public IntercomShimmerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public IntercomShimmerLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    private void init() {
        setShimmer(SHIMMER_CONFIG);
    }
}
