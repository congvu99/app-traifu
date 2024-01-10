package com.gigamole.navigationtabstrip;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Random;

public class NavigationTabStrip extends View implements ViewPager.OnPageChangeListener {
    private static final int DEFAULT_ACTIVE_COLOR = -1;
    private static final int DEFAULT_ANIMATION_DURATION = 350;
    private static final float DEFAULT_CORNER_RADIUS = 5.0f;
    private static final int DEFAULT_INACTIVE_COLOR = -7829368;
    private static final int DEFAULT_STRIP_COLOR = -65536;
    private static final float DEFAULT_STRIP_FACTOR = 2.5f;
    private static final float DEFAULT_STRIP_WEIGHT = 10.0f;
    private static final int DEFAULT_TITLE_SIZE = 0;
    private static final int HIGH_QUALITY_FLAGS = 5;
    private static final int INVALID_INDEX = -1;
    private static final float MAX_FRACTION = 1.0f;
    private static final float MIN_FRACTION = 0.0f;
    private static final String PREVIEW_TITLE = "Title";
    private static final float TITLE_SIZE_FRACTION = 0.35f;
    private int mActiveColor;
    /* access modifiers changed from: private */
    public int mAnimationDuration;
    private final ValueAnimator mAnimator;
    private Animator.AnimatorListener mAnimatorListener;
    private final RectF mBounds;
    private final ArgbEvaluator mColorEvaluator;
    private float mCornersRadius;
    private float mEndStripX;
    private float mFraction;
    private int mInactiveColor;
    /* access modifiers changed from: private */
    public int mIndex;
    private boolean mIsActionDown;
    private boolean mIsResizeIn;
    private boolean mIsSetIndexFromTabBar;
    private boolean mIsTabActionDown;
    /* access modifiers changed from: private */
    public boolean mIsViewPagerMode;
    private int mLastIndex;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    /* access modifiers changed from: private */
    public OnTabStripSelectedIndexListener mOnTabStripSelectedIndexListener;
    private final ResizeInterpolator mResizeInterpolator;
    private int mScrollState;
    private float mStartStripX;
    private final RectF mStripBounds;
    private StripGravity mStripGravity;
    private float mStripLeft;
    private final Paint mStripPaint;
    private float mStripRight;
    private StripType mStripType;
    private float mStripWeight;
    private float mTabSize;
    private final Rect mTitleBounds;
    private final Paint mTitlePaint;
    private float mTitleSize;
    /* access modifiers changed from: private */
    public String[] mTitles;
    private Typeface mTypeface;
    private ViewPager mViewPager;

    public interface OnTabStripSelectedIndexListener {
        void onEndTabSelected(String str, int i);

        void onStartTabSelected(String str, int i);
    }

    public enum StripGravity {
        BOTTOM,
        TOP;
        
        private static final int BOTTOM_INDEX = 0;
        private static final int TOP_INDEX = 1;
    }

    public enum StripType {
        LINE,
        POINT;
        
        private static final int LINE_INDEX = 0;
        private static final int POINT_INDEX = 1;
    }

    public void onPageSelected(int i) {
    }

    public NavigationTabStrip(Context context) {
        this(context, (AttributeSet) null);
    }

    public NavigationTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        String[] strArr;
        String[] strArr2;
        this.mBounds = new RectF();
        this.mStripBounds = new RectF();
        this.mTitleBounds = new Rect();
        this.mStripPaint = new Paint(5) {
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.mTitlePaint = new TextPaint(5) {
            {
                setTextAlign(Paint.Align.CENTER);
            }
        };
        this.mAnimator = new ValueAnimator();
        this.mColorEvaluator = new ArgbEvaluator();
        String[] strArr3 = null;
        this.mResizeInterpolator = new ResizeInterpolator();
        this.mLastIndex = -1;
        this.mIndex = -1;
        setWillNotDraw(false);
        ViewCompat.setLayerType(this, 1, (Paint) null);
        setLayerType(1, (Paint) null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NavigationTabStrip);
        try {
            setStripColor(obtainStyledAttributes.getColor(R.styleable.NavigationTabStrip_nts_color, -65536));
            setTitleSize(obtainStyledAttributes.getDimension(R.styleable.NavigationTabStrip_nts_size, 0.0f));
            setStripWeight(obtainStyledAttributes.getDimension(R.styleable.NavigationTabStrip_nts_weight, 10.0f));
            setStripFactor(obtainStyledAttributes.getFloat(R.styleable.NavigationTabStrip_nts_factor, DEFAULT_STRIP_FACTOR));
            setStripType(obtainStyledAttributes.getInt(R.styleable.NavigationTabStrip_nts_type, 0));
            setStripGravity(obtainStyledAttributes.getInt(R.styleable.NavigationTabStrip_nts_gravity, 0));
            setTypeface(obtainStyledAttributes.getString(R.styleable.NavigationTabStrip_nts_typeface));
            setInactiveColor(obtainStyledAttributes.getColor(R.styleable.NavigationTabStrip_nts_inactive_color, DEFAULT_INACTIVE_COLOR));
            setActiveColor(obtainStyledAttributes.getColor(R.styleable.NavigationTabStrip_nts_active_color, -1));
            setAnimationDuration(obtainStyledAttributes.getInteger(R.styleable.NavigationTabStrip_nts_animation_duration, DEFAULT_ANIMATION_DURATION));
            setCornersRadius(obtainStyledAttributes.getDimension(R.styleable.NavigationTabStrip_nts_corners_radius, DEFAULT_CORNER_RADIUS));
            try {
                int resourceId = obtainStyledAttributes.getResourceId(R.styleable.NavigationTabStrip_nts_titles, 0);
                if (resourceId != 0) {
                    strArr3 = obtainStyledAttributes.getResources().getStringArray(resourceId);
                }
                if (strArr3 == null) {
                    if (isInEditMode()) {
                        strArr3 = new String[(new Random().nextInt(5) + 1)];
                        Arrays.fill(strArr3, PREVIEW_TITLE);
                    } else {
                        strArr3 = new String[0];
                    }
                }
                setTitles(strArr3);
            } catch (Exception e) {
                e.printStackTrace();
                if (isInEditMode()) {
                    strArr = new String[(new Random().nextInt(5) + 1)];
                    Arrays.fill(strArr, PREVIEW_TITLE);
                } else {
                    strArr = new String[0];
                }
                setTitles(strArr);
            }
            this.mAnimator.setFloatValues(new float[]{0.0f, 1.0f});
            this.mAnimator.setInterpolator(new LinearInterpolator());
            this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    NavigationTabStrip.this.updateIndicatorPosition(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public int getAnimationDuration() {
        return this.mAnimationDuration;
    }

    public void setAnimationDuration(int i) {
        this.mAnimationDuration = i;
        this.mAnimator.setDuration((long) i);
        resetScroller();
    }

    public String[] getTitles() {
        return this.mTitles;
    }

    public void setTitles(int... iArr) {
        String[] strArr = new String[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            strArr[i] = getResources().getString(iArr[i]);
        }
        setTitles(strArr);
    }

    public void setTitles(String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = strArr[i].toUpperCase();
        }
        this.mTitles = strArr;
        requestLayout();
    }

    public int getStripColor() {
        return this.mStripPaint.getColor();
    }

    public void setStripColor(int i) {
        this.mStripPaint.setColor(i);
        postInvalidate();
    }

    public void setStripWeight(float f) {
        this.mStripWeight = f;
        requestLayout();
    }

    public StripGravity getStripGravity() {
        return this.mStripGravity;
    }

    private void setStripGravity(int i) {
        if (i != 1) {
            setStripGravity(StripGravity.BOTTOM);
        } else {
            setStripGravity(StripGravity.TOP);
        }
    }

    public void setStripGravity(StripGravity stripGravity) {
        this.mStripGravity = stripGravity;
        requestLayout();
    }

    public StripType getStripType() {
        return this.mStripType;
    }

    private void setStripType(int i) {
        if (i != 1) {
            setStripType(StripType.LINE);
        } else {
            setStripType(StripType.POINT);
        }
    }

    public void setStripType(StripType stripType) {
        this.mStripType = stripType;
        requestLayout();
    }

    public float getStripFactor() {
        return this.mResizeInterpolator.getFactor();
    }

    public void setStripFactor(float f) {
        this.mResizeInterpolator.setFactor(f);
    }

    public Typeface getTypeface() {
        return this.mTypeface;
    }

    public void setTypeface(String str) {
        Typeface typeface;
        if (!TextUtils.isEmpty(str)) {
            try {
                typeface = Typeface.createFromAsset(getContext().getAssets(), str);
            } catch (Exception e) {
                Typeface create = Typeface.create(Typeface.DEFAULT, 0);
                e.printStackTrace();
                typeface = create;
            }
            setTypeface(typeface);
        }
    }

    public void setTypeface(Typeface typeface) {
        this.mTypeface = typeface;
        this.mTitlePaint.setTypeface(typeface);
        postInvalidate();
    }

    public int getActiveColor() {
        return this.mActiveColor;
    }

    public void setActiveColor(int i) {
        this.mActiveColor = i;
        postInvalidate();
    }

    public int getInactiveColor() {
        return this.mInactiveColor;
    }

    public void setInactiveColor(int i) {
        this.mInactiveColor = i;
        postInvalidate();
    }

    public float getCornersRadius() {
        return this.mCornersRadius;
    }

    public void setCornersRadius(float f) {
        this.mCornersRadius = f;
        postInvalidate();
    }

    public float getTitleSize() {
        return this.mTitleSize;
    }

    public void setTitleSize(float f) {
        this.mTitleSize = f;
        this.mTitlePaint.setTextSize(f);
        postInvalidate();
    }

    public OnTabStripSelectedIndexListener getOnTabStripSelectedIndexListener() {
        return this.mOnTabStripSelectedIndexListener;
    }

    public void setOnTabStripSelectedIndexListener(OnTabStripSelectedIndexListener onTabStripSelectedIndexListener) {
        this.mOnTabStripSelectedIndexListener = onTabStripSelectedIndexListener;
        if (this.mAnimatorListener == null) {
            this.mAnimatorListener = new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    if (NavigationTabStrip.this.mOnTabStripSelectedIndexListener != null) {
                        NavigationTabStrip.this.mOnTabStripSelectedIndexListener.onStartTabSelected(NavigationTabStrip.this.mTitles[NavigationTabStrip.this.mIndex], NavigationTabStrip.this.mIndex);
                    }
                    animator.removeListener(this);
                    animator.addListener(this);
                }

                public void onAnimationEnd(Animator animator) {
                    if (!NavigationTabStrip.this.mIsViewPagerMode) {
                        animator.removeListener(this);
                        animator.addListener(this);
                        if (NavigationTabStrip.this.mOnTabStripSelectedIndexListener != null) {
                            NavigationTabStrip.this.mOnTabStripSelectedIndexListener.onEndTabSelected(NavigationTabStrip.this.mTitles[NavigationTabStrip.this.mIndex], NavigationTabStrip.this.mIndex);
                        }
                    }
                }
            };
        }
        this.mAnimator.removeListener(this.mAnimatorListener);
        this.mAnimator.addListener(this.mAnimatorListener);
    }

    public void setViewPager(ViewPager viewPager) {
        if (viewPager == null) {
            this.mIsViewPagerMode = false;
        } else if (!viewPager.equals(this.mViewPager)) {
            ViewPager viewPager2 = this.mViewPager;
            if (viewPager2 != null) {
                viewPager2.setOnPageChangeListener((ViewPager.OnPageChangeListener) null);
            }
            if (viewPager.getAdapter() != null) {
                this.mIsViewPagerMode = true;
                this.mViewPager = viewPager;
                viewPager.addOnPageChangeListener(this);
                resetScroller();
                postInvalidate();
                return;
            }
            throw new IllegalStateException("ViewPager does not provide adapter instance.");
        }
    }

    public void setViewPager(ViewPager viewPager, int i) {
        setViewPager(viewPager);
        this.mIndex = i;
        if (this.mIsViewPagerMode) {
            this.mViewPager.setCurrentItem(i, true);
        }
        postInvalidate();
    }

    private void resetScroller() {
        if (this.mViewPager != null) {
            try {
                Field declaredField = ViewPager.class.getDeclaredField("mScroller");
                declaredField.setAccessible(true);
                declaredField.set(this.mViewPager, new ResizeViewPagerScroller(getContext()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public int getTabIndex() {
        return this.mIndex;
    }

    public void setTabIndex(int i) {
        setTabIndex(i, false);
    }

    public void setTabIndex(int i, boolean z) {
        if (!this.mAnimator.isRunning() && this.mTitles.length != 0) {
            if (this.mIndex == -1) {
                z = true;
            }
            if (i != this.mIndex) {
                boolean z2 = false;
                int max = Math.max(0, Math.min(i, this.mTitles.length - 1));
                if (max < this.mIndex) {
                    z2 = true;
                }
                this.mIsResizeIn = z2;
                this.mLastIndex = this.mIndex;
                this.mIndex = max;
                this.mIsSetIndexFromTabBar = true;
                if (this.mIsViewPagerMode) {
                    ViewPager viewPager = this.mViewPager;
                    if (viewPager != null) {
                        viewPager.setCurrentItem(max, !z);
                    } else {
                        throw new IllegalStateException("ViewPager is null.");
                    }
                }
                this.mStartStripX = this.mStripLeft;
                this.mEndStripX = (((float) this.mIndex) * this.mTabSize) + (this.mStripType == StripType.POINT ? this.mTabSize * 0.5f : 0.0f);
                if (z) {
                    updateIndicatorPosition(1.0f);
                    if (this.mIsViewPagerMode) {
                        if (!this.mViewPager.isFakeDragging()) {
                            this.mViewPager.beginFakeDrag();
                        }
                        if (this.mViewPager.isFakeDragging()) {
                            this.mViewPager.fakeDragBy(0.0f);
                            this.mViewPager.endFakeDrag();
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.mAnimator.start();
            }
        }
    }

    public void deselect() {
        this.mLastIndex = -1;
        this.mIndex = -1;
        float f = this.mTabSize * -1.0f;
        this.mStartStripX = f;
        this.mEndStripX = f;
        updateIndicatorPosition(0.0f);
    }

    /* access modifiers changed from: private */
    public void updateIndicatorPosition(float f) {
        this.mFraction = f;
        float f2 = this.mStartStripX;
        float resizeInterpolation = this.mResizeInterpolator.getResizeInterpolation(f, this.mIsResizeIn);
        float f3 = this.mEndStripX;
        float f4 = this.mStartStripX;
        this.mStripLeft = f2 + (resizeInterpolation * (f3 - f4));
        this.mStripRight = f4 + (this.mStripType == StripType.LINE ? this.mTabSize : this.mStripWeight) + (this.mResizeInterpolator.getResizeInterpolation(f, !this.mIsResizeIn) * (this.mEndStripX - this.mStartStripX));
        postInvalidate();
    }

    private void notifyDataSetChanged() {
        requestLayout();
        postInvalidate();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
        if (r4.mIsActionDown != false) goto L_0x005d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            android.animation.ValueAnimator r0 = r4.mAnimator
            boolean r0 = r0.isRunning()
            r1 = 1
            if (r0 == 0) goto L_0x000a
            return r1
        L_0x000a:
            int r0 = r4.mScrollState
            if (r0 == 0) goto L_0x000f
            return r1
        L_0x000f:
            int r0 = r5.getAction()
            r2 = 0
            if (r0 == 0) goto L_0x0047
            if (r0 == r1) goto L_0x0033
            r3 = 2
            if (r0 == r3) goto L_0x001c
            goto L_0x0042
        L_0x001c:
            boolean r0 = r4.mIsTabActionDown
            if (r0 == 0) goto L_0x002e
            androidx.viewpager.widget.ViewPager r0 = r4.mViewPager
            float r5 = r5.getX()
            float r2 = r4.mTabSize
            float r5 = r5 / r2
            int r5 = (int) r5
            r0.setCurrentItem(r5, r1)
            goto L_0x005d
        L_0x002e:
            boolean r0 = r4.mIsActionDown
            if (r0 == 0) goto L_0x0033
            goto L_0x005d
        L_0x0033:
            boolean r0 = r4.mIsActionDown
            if (r0 == 0) goto L_0x0042
            float r5 = r5.getX()
            float r0 = r4.mTabSize
            float r5 = r5 / r0
            int r5 = (int) r5
            r4.setTabIndex(r5)
        L_0x0042:
            r4.mIsTabActionDown = r2
            r4.mIsActionDown = r2
            goto L_0x005d
        L_0x0047:
            r4.mIsActionDown = r1
            boolean r0 = r4.mIsViewPagerMode
            if (r0 != 0) goto L_0x004e
            goto L_0x005d
        L_0x004e:
            float r5 = r5.getX()
            float r0 = r4.mTabSize
            float r5 = r5 / r0
            int r5 = (int) r5
            int r0 = r4.mIndex
            if (r5 != r0) goto L_0x005b
            r2 = 1
        L_0x005b:
            r4.mIsTabActionDown = r2
        L_0x005d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gigamole.navigationtabstrip.NavigationTabStrip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        float size = (float) View.MeasureSpec.getSize(i);
        float size2 = (float) View.MeasureSpec.getSize(i2);
        float f = 0.0f;
        this.mBounds.set(0.0f, 0.0f, size, size2);
        String[] strArr = this.mTitles;
        if (strArr.length != 0 && size != 0.0f && size2 != 0.0f) {
            this.mTabSize = size / ((float) strArr.length);
            if (((int) this.mTitleSize) == 0) {
                setTitleSize((size2 - this.mStripWeight) * TITLE_SIZE_FRACTION);
            }
            if (isInEditMode() || !this.mIsViewPagerMode) {
                this.mIsSetIndexFromTabBar = true;
                if (isInEditMode()) {
                    this.mIndex = new Random().nextInt(this.mTitles.length);
                }
                float f2 = ((float) this.mIndex) * this.mTabSize;
                if (this.mStripType == StripType.POINT) {
                    f = this.mTabSize * 0.5f;
                }
                float f3 = f2 + f;
                this.mStartStripX = f3;
                this.mEndStripX = f3;
                updateIndicatorPosition(1.0f);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.mStripBounds.set(this.mStripLeft - (this.mStripType == StripType.POINT ? this.mStripWeight * 0.5f : 0.0f), this.mStripGravity == StripGravity.BOTTOM ? this.mBounds.height() - this.mStripWeight : 0.0f, this.mStripRight - (this.mStripType == StripType.POINT ? this.mStripWeight * 0.5f : 0.0f), this.mStripGravity == StripGravity.BOTTOM ? this.mBounds.height() : this.mStripWeight);
        float f = this.mCornersRadius;
        if (f == 0.0f) {
            canvas.drawRect(this.mStripBounds, this.mStripPaint);
        } else {
            canvas.drawRoundRect(this.mStripBounds, f, f, this.mStripPaint);
        }
        int i = 0;
        while (true) {
            String[] strArr = this.mTitles;
            if (i < strArr.length) {
                String str = strArr[i];
                float f2 = this.mTabSize;
                float f3 = (((float) i) * f2) + (f2 * 0.5f);
                this.mTitlePaint.getTextBounds(str, 0, str.length(), this.mTitleBounds);
                float height = (((this.mBounds.height() - this.mStripWeight) * 0.5f) + (((float) this.mTitleBounds.height()) * 0.5f)) - ((float) this.mTitleBounds.bottom);
                float resizeInterpolation = this.mResizeInterpolator.getResizeInterpolation(this.mFraction, true);
                float resizeInterpolation2 = this.mResizeInterpolator.getResizeInterpolation(this.mFraction, false);
                if (!this.mIsSetIndexFromTabBar) {
                    int i2 = this.mIndex;
                    if (i == i2 || i == i2 + 1) {
                        int i3 = this.mIndex;
                        if (i == i3 + 1) {
                            updateCurrentTitle(resizeInterpolation);
                        } else if (i == i3) {
                            updateLastTitle(resizeInterpolation2);
                        }
                    } else {
                        updateInactiveTitle();
                    }
                } else if (this.mIndex == i) {
                    updateCurrentTitle(resizeInterpolation);
                } else if (this.mLastIndex == i) {
                    updateLastTitle(resizeInterpolation2);
                } else {
                    updateInactiveTitle();
                }
                canvas.drawText(str, f3, height + (this.mStripGravity == StripGravity.TOP ? this.mStripWeight : 0.0f), this.mTitlePaint);
                i++;
            } else {
                return;
            }
        }
    }

    private void updateCurrentTitle(float f) {
        this.mTitlePaint.setColor(((Integer) this.mColorEvaluator.evaluate(f, Integer.valueOf(this.mInactiveColor), Integer.valueOf(this.mActiveColor))).intValue());
    }

    private void updateLastTitle(float f) {
        this.mTitlePaint.setColor(((Integer) this.mColorEvaluator.evaluate(f, Integer.valueOf(this.mActiveColor), Integer.valueOf(this.mInactiveColor))).intValue());
    }

    private void updateInactiveTitle() {
        this.mTitlePaint.setColor(this.mInactiveColor);
    }

    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f, i2);
        }
        if (!this.mIsSetIndexFromTabBar) {
            this.mIsResizeIn = i < this.mIndex;
            this.mLastIndex = this.mIndex;
            this.mIndex = i;
            float f2 = (((float) i) * this.mTabSize) + (this.mStripType == StripType.POINT ? this.mTabSize * 0.5f : 0.0f);
            this.mStartStripX = f2;
            this.mEndStripX = f2 + this.mTabSize;
            updateIndicatorPosition(f);
        }
        if (!this.mAnimator.isRunning() && this.mIsSetIndexFromTabBar) {
            this.mFraction = 0.0f;
            this.mIsSetIndexFromTabBar = false;
        }
    }

    public void onPageScrollStateChanged(int i) {
        OnTabStripSelectedIndexListener onTabStripSelectedIndexListener;
        this.mScrollState = i;
        if (i == 0) {
            ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(this.mIndex);
            }
            if (this.mIsViewPagerMode && (onTabStripSelectedIndexListener = this.mOnTabStripSelectedIndexListener) != null) {
                String[] strArr = this.mTitles;
                int i2 = this.mIndex;
                onTabStripSelectedIndexListener.onEndTabSelected(strArr[i2], i2);
            }
        }
        ViewPager.OnPageChangeListener onPageChangeListener2 = this.mOnPageChangeListener;
        if (onPageChangeListener2 != null) {
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mIndex = savedState.index;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int unused = savedState.index = this.mIndex;
        return savedState;
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
        /* access modifiers changed from: private */
        public int index;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.index = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.index);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        requestLayout();
        final int i = this.mIndex;
        deselect();
        post(new Runnable() {
            public void run() {
                NavigationTabStrip.this.setTabIndex(i, true);
            }
        });
    }

    private class ResizeViewPagerScroller extends Scroller {
        public ResizeViewPagerScroller(Context context) {
            super(context, new AccelerateDecelerateInterpolator());
        }

        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, NavigationTabStrip.this.mAnimationDuration);
        }

        public void startScroll(int i, int i2, int i3, int i4) {
            super.startScroll(i, i2, i3, i4, NavigationTabStrip.this.mAnimationDuration);
        }
    }

    private static class ResizeInterpolator implements Interpolator {
        private float mFactor;
        private boolean mResizeIn;

        private ResizeInterpolator() {
        }

        public float getFactor() {
            return this.mFactor;
        }

        public void setFactor(float f) {
            this.mFactor = f;
        }

        public float getInterpolation(float f) {
            if (this.mResizeIn) {
                return (float) (1.0d - Math.pow((double) (1.0f - f), (double) (this.mFactor * 2.0f)));
            }
            return (float) Math.pow((double) f, (double) (this.mFactor * 2.0f));
        }

        public float getResizeInterpolation(float f, boolean z) {
            this.mResizeIn = z;
            return getInterpolation(f);
        }
    }
}
