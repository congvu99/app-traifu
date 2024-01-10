package io.intercom.android.sdk.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ContentAwareScrollView extends ScrollView {
    private Listener listener;

    public interface Listener {
        void onBottomReached();

        void onScrollChanged(int i);
    }

    public ContentAwareScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ContentAwareScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ContentAwareScrollView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        notifyListenerIfAtBottom();
        notifyListenerScrollChanged(i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        notifyListenerIfAtBottom();
    }

    /* access modifiers changed from: protected */
    public void notifyListenerScrollChanged(int i) {
        Listener listener2 = this.listener;
        if (listener2 != null) {
            listener2.onScrollChanged(i);
        }
    }

    public boolean isAtBottom() {
        int bottom = getChildAt(0).getBottom();
        if (bottom != 0 && getBottom() + getScrollY() >= bottom) {
            return true;
        }
        return false;
    }

    public Listener getListener() {
        return this.listener;
    }

    public void setListener(Listener listener2) {
        this.listener = listener2;
        notifyListenerIfAtBottom();
    }

    /* access modifiers changed from: protected */
    public void notifyListenerIfAtBottom() {
        if (this.listener != null && isAtBottom()) {
            this.listener.onBottomReached();
        }
    }
}
