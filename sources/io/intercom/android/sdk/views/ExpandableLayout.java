package io.intercom.android.sdk.views;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import io.intercom.android.sdk.R;

public class ExpandableLayout extends LinearLayout {
    private static final long ANIMATION_DURATION = 100;
    private boolean attachedToWindow;
    private ObjectAnimator expandAnimator;
    private ObjectAnimator fadeAnimator;
    private boolean firstLayout = true;
    private int heightMeasureSpec;
    private boolean inLayout;
    private int widthMeasureSpec;

    public ExpandableLayout(Context context) {
        super(context);
    }

    public ExpandableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ExpandableLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.widthMeasureSpec = i;
        this.heightMeasureSpec = i2;
        View findExpandableView = findExpandableView();
        if (findExpandableView != null) {
            LayoutParams layoutParams = (LayoutParams) findExpandableView.getLayoutParams();
            if (layoutParams.weight != 0.0f) {
                throw new IllegalArgumentException("ExpandableView can't use weight");
            } else if (layoutParams.isExpanded || layoutParams.isExpanding) {
                findExpandableView.setVisibility(0);
            } else {
                findExpandableView.setVisibility(8);
            }
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.inLayout = true;
        super.onLayout(z, i, i2, i3, i4);
        this.inLayout = false;
        this.firstLayout = false;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.attachedToWindow = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.attachedToWindow = false;
        View findExpandableView = findExpandableView();
        safeReleaseAnimator(this.expandAnimator);
        safeReleaseAnimator(this.fadeAnimator);
        if (findExpandableView != null) {
            LayoutParams layoutParams = (LayoutParams) findExpandableView.getLayoutParams();
            if (layoutParams.isExpanded) {
                layoutParams.height = layoutParams.originalHeight;
                findExpandableView.setVisibility(0);
            } else {
                layoutParams.height = layoutParams.originalHeight;
                findExpandableView.setVisibility(8);
            }
            layoutParams.isExpanding = false;
        }
    }

    private void safeReleaseAnimator(ObjectAnimator objectAnimator) {
        if (objectAnimator != null && objectAnimator.isRunning()) {
            objectAnimator.end();
        }
    }

    public void requestLayout() {
        if (!this.inLayout) {
            super.requestLayout();
        }
    }

    public View findExpandableView() {
        for (int i = 0; i < getChildCount(); i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).canExpand) {
                return getChildAt(i);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean checkExpandableView(View view) {
        return ((LayoutParams) view.getLayoutParams()).canExpand;
    }

    public boolean isExpanded() {
        View findExpandableView = findExpandableView();
        return findExpandableView != null && ((LayoutParams) findExpandableView.getLayoutParams()).isExpanded;
    }

    public boolean setExpanded(boolean z) {
        return setExpanded(z, false);
    }

    public boolean setExpanded(boolean z, boolean z2) {
        boolean z3;
        View findExpandableView = findExpandableView();
        if (findExpandableView == null || z == isExpanded()) {
            z3 = false;
        } else {
            z3 = z ? expand(findExpandableView, z2) : collapse(findExpandableView, z2);
        }
        requestLayout();
        return z3;
    }

    private boolean expand(View view, boolean z) {
        if (checkExpandableView(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.firstLayout || !this.attachedToWindow || !z) {
                layoutParams.isExpanded = true;
                layoutParams.isExpanding = false;
                layoutParams.height = layoutParams.originalHeight;
                view.setVisibility(0);
                return true;
            } else if (layoutParams.isExpanded || layoutParams.isExpanding) {
                return false;
            } else {
                playExpandAnimation(view);
                return true;
            }
        } else {
            throw new IllegalArgumentException("expand(), View is not expandableView");
        }
    }

    private void playExpandAnimation(final View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.isExpanding) {
            view.setVisibility(0);
            layoutParams.isExpanding = true;
            measure(this.widthMeasureSpec, this.heightMeasureSpec);
            int measuredHeight = view.getMeasuredHeight();
            layoutParams.height = 0;
            ObjectAnimator ofInt = ObjectAnimator.ofInt(layoutParams, "height", new int[]{0, measuredHeight});
            this.expandAnimator = ofInt;
            ofInt.setDuration(100);
            this.expandAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    view.requestLayout();
                }
            });
            this.expandAnimator.addListener(new AnimatorEndListener() {
                public void onAnimationEnd(Animator animator) {
                    ExpandableLayout.this.performToggleState(view);
                }
            });
            view.setAlpha(0.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.0f, 1.0f});
            this.fadeAnimator = ofFloat;
            ofFloat.setDuration(100);
            this.fadeAnimator.addListener(new AnimatorEndListener() {
                public void onAnimationEnd(Animator animator) {
                    view.setAlpha(1.0f);
                }
            });
            this.fadeAnimator.setStartDelay(200);
            this.expandAnimator.start();
            this.fadeAnimator.start();
        }
    }

    private boolean collapse(View view, boolean z) {
        if (checkExpandableView(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.firstLayout || !this.attachedToWindow || !z) {
                layoutParams.isExpanded = false;
                layoutParams.isExpanding = false;
                layoutParams.height = layoutParams.originalHeight;
                view.setVisibility(8);
                return true;
            } else if (!layoutParams.isExpanded || layoutParams.isExpanding) {
                return false;
            } else {
                playCollapseAnimation(view);
                return true;
            }
        } else {
            throw new IllegalArgumentException("collapse(), View is not expandableView");
        }
    }

    private void playCollapseAnimation(final View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.isExpanding) {
            view.setVisibility(0);
            layoutParams.isExpanding = true;
            measure(this.widthMeasureSpec, this.heightMeasureSpec);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(layoutParams, "height", new int[]{view.getMeasuredHeight(), 0});
            this.expandAnimator = ofInt;
            ofInt.setDuration(100);
            this.expandAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    view.requestLayout();
                }
            });
            this.expandAnimator.addListener(new AnimatorEndListener() {
                public void onAnimationEnd(Animator animator) {
                    ExpandableLayout.this.performToggleState(view);
                }
            });
            view.setAlpha(0.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{1.0f, 0.0f});
            this.fadeAnimator = ofFloat;
            ofFloat.setDuration(100);
            this.fadeAnimator.addListener(new AnimatorEndListener() {
                public void onAnimationEnd(Animator animator) {
                    view.setAlpha(0.0f);
                }
            });
            this.expandAnimator.setStartDelay(200);
            this.fadeAnimator.start();
            this.expandAnimator.start();
        }
    }

    /* access modifiers changed from: package-private */
    public void performToggleState(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.isExpanded) {
            layoutParams.isExpanded = false;
            view.setVisibility(8);
            layoutParams.height = layoutParams.originalHeight;
        } else {
            layoutParams.isExpanded = true;
        }
        layoutParams.isExpanding = false;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (isExpanded()) {
            savedState.isExpanded = true;
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isExpanded && findExpandableView() != null) {
            setExpanded(true);
        }
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean isExpanded;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.isExpanded = parcel.readInt() != 1 ? false : true;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.isExpanded ? 1 : 0);
        }
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    private static class LayoutParams extends LinearLayout.LayoutParams {
        private static final int NO_MEASURED_HEIGHT = -10;
        boolean canExpand;
        boolean isExpanded;
        boolean isExpanding;
        int originalHeight;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.originalHeight = NO_MEASURED_HEIGHT;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableLayout);
            this.canExpand = obtainStyledAttributes.getBoolean(R.styleable.ExpandableLayout_intercomCanExpand, false);
            this.originalHeight = this.height;
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
            this.originalHeight = NO_MEASURED_HEIGHT;
            this.originalHeight = this.height;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.originalHeight = NO_MEASURED_HEIGHT;
            this.originalHeight = this.height;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.originalHeight = NO_MEASURED_HEIGHT;
            this.originalHeight = this.height;
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.originalHeight = NO_MEASURED_HEIGHT;
            this.originalHeight = this.height;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.originalHeight = NO_MEASURED_HEIGHT;
            this.originalHeight = this.height;
        }

        public void setHeight(int i) {
            this.height = i;
        }
    }
}
