package io.intercom.android.sdk.views;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public final class FullscreenFrameLayout extends FrameLayout {
    public FullscreenFrameLayout(Context context) {
        super(context);
    }

    public FullscreenFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FullscreenFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public final boolean fitSystemWindows(Rect rect) {
        rect.top = 0;
        return super.fitSystemWindows(rect);
    }
}
