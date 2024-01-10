package io.intercom.android.sdk.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import io.intercom.android.sdk.R;

public class LockableScrollView extends ScrollView {
    private boolean interceptTouch = false;
    private boolean isExpanded = true;
    private int maxHeight = 0;
    private boolean scrollable = true;

    public LockableScrollView(Context context) {
        super(context);
    }

    public LockableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setUp(attributeSet);
    }

    public LockableScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setUp(attributeSet);
    }

    public void setUp(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LockableScrollView);
        this.maxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.LockableScrollView_intercomHeightLimit, 0);
        this.isExpanded = obtainStyledAttributes.getBoolean(R.styleable.LockableScrollView_intercomExpanded, true);
        this.interceptTouch = obtainStyledAttributes.getBoolean(R.styleable.LockableScrollView_intercomInterceptTouch, true);
        obtainStyledAttributes.recycle();
    }

    public void setScrollingEnabled(boolean z) {
        this.scrollable = z;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (!this.isExpanded) {
            int mode = View.MeasureSpec.getMode(i2);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), this.maxHeight), mode);
            } else {
                i2 = View.MeasureSpec.makeMeasureSpec(this.maxHeight, Integer.MIN_VALUE);
            }
        }
        super.onMeasure(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.scrollable && super.onTouchEvent(motionEvent);
    }

    public void scrollTo(int i, int i2) {
        if (this.scrollable) {
            super.scrollTo(i, i2);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.interceptTouch;
    }

    public void toggleExpanded() {
        setExpanded(!this.isExpanded);
    }

    public void setExpanded(boolean z) {
        if (z != this.isExpanded) {
            this.isExpanded = z;
            requestLayout();
            invalidate();
        }
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public boolean isExpanded() {
        return this.isExpanded;
    }
}
