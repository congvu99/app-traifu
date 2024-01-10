package com.facebook.react.views.scroll;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.FabricViewStateManager;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.ReactOverflowView;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import com.github.mikephil.charting.utils.Utils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReactHorizontalScrollView extends HorizontalScrollView implements ReactClippingViewGroup, FabricViewStateManager.HasFabricViewStateManager, ReactOverflowView {
    private static final String CONTENT_OFFSET_LEFT = "contentOffsetLeft";
    private static final String CONTENT_OFFSET_TOP = "contentOffsetTop";
    private static boolean DEBUG_MODE = false;
    private static int NO_SCROLL_POSITION = Integer.MIN_VALUE;
    private static final String SCROLL_AWAY_PADDING_TOP = "scrollAwayPaddingTop";
    private static String TAG = ReactHorizontalScrollView.class.getSimpleName();
    private static final int UNSET_CONTENT_OFFSET = -1;
    private static Field sScrollerField;
    private static boolean sTriedToGetScrollerField = false;
    /* access modifiers changed from: private */
    public boolean mActivelyScrolling;
    private Rect mClippingRect;
    private float mDecelerationRate;
    private boolean mDisableIntervalMomentum;
    private boolean mDragging;
    private Drawable mEndBackground;
    private int mEndFillColor;
    private final FabricViewStateManager mFabricViewStateManager;
    /* access modifiers changed from: private */
    public int mFinalAnimatedPositionScrollX;
    /* access modifiers changed from: private */
    public int mFinalAnimatedPositionScrollY;
    private FpsListener mFpsListener;
    private int mLastStateUpdateScrollX;
    private int mLastStateUpdateScrollY;
    private int mLayoutDirection;
    private final OnScrollDispatchHelper mOnScrollDispatchHelper;
    private String mOverflow;
    private boolean mPagedArrowScrolling;
    /* access modifiers changed from: private */
    public boolean mPagingEnabled;
    /* access modifiers changed from: private */
    public Runnable mPostTouchRunnable;
    private ReactViewBackgroundManager mReactBackgroundManager;
    private final Rect mRect;
    private boolean mRemoveClippedSubviews;
    /* access modifiers changed from: private */
    public ValueAnimator mScrollAnimator;
    /* access modifiers changed from: private */
    public boolean mScrollEnabled;
    private String mScrollPerfTag;
    private int mScrollXAfterMeasure;
    private final OverScroller mScroller;
    /* access modifiers changed from: private */
    public boolean mSendMomentumEvents;
    private int mSnapInterval;
    private List<Integer> mSnapOffsets;
    private boolean mSnapToEnd;
    private boolean mSnapToStart;
    private final Rect mTempRect;
    private final VelocityHelper mVelocityHelper;
    private int pendingContentOffsetX;
    private int pendingContentOffsetY;

    public ReactHorizontalScrollView(Context context) {
        this(context, (FpsListener) null);
    }

    public ReactHorizontalScrollView(Context context, FpsListener fpsListener) {
        super(context);
        this.mScrollXAfterMeasure = NO_SCROLL_POSITION;
        this.mOnScrollDispatchHelper = new OnScrollDispatchHelper();
        this.mVelocityHelper = new VelocityHelper();
        this.mRect = new Rect();
        this.mOverflow = ViewProps.HIDDEN;
        this.mPagingEnabled = false;
        this.mScrollEnabled = true;
        this.mFpsListener = null;
        this.mEndFillColor = 0;
        this.mDisableIntervalMomentum = false;
        this.mSnapInterval = 0;
        this.mDecelerationRate = 0.985f;
        this.mSnapToStart = true;
        this.mSnapToEnd = true;
        this.mPagedArrowScrolling = false;
        this.pendingContentOffsetX = -1;
        this.pendingContentOffsetY = -1;
        this.mFabricViewStateManager = new FabricViewStateManager();
        this.mFinalAnimatedPositionScrollX = 0;
        this.mFinalAnimatedPositionScrollY = 0;
        this.mLastStateUpdateScrollX = -1;
        this.mLastStateUpdateScrollY = -1;
        this.mTempRect = new Rect();
        this.mReactBackgroundManager = new ReactViewBackgroundManager(this);
        this.mFpsListener = fpsListener;
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setScrollable(ReactHorizontalScrollView.this.mScrollEnabled);
            }

            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setScrollable(ReactHorizontalScrollView.this.mScrollEnabled);
            }
        });
        this.mScroller = getOverScrollerFromParent();
        this.mLayoutDirection = I18nUtil.getInstance().isRTL(context) ? 1 : 0;
    }

    private OverScroller getOverScrollerFromParent() {
        if (!sTriedToGetScrollerField) {
            sTriedToGetScrollerField = true;
            try {
                Field declaredField = HorizontalScrollView.class.getDeclaredField("mScroller");
                sScrollerField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                FLog.w(TAG, "Failed to get mScroller field for HorizontalScrollView! This app will exhibit the bounce-back scrolling bug :(");
            }
        }
        Field field = sScrollerField;
        if (field == null) {
            return null;
        }
        try {
            Object obj = field.get(this);
            if (obj instanceof OverScroller) {
                return (OverScroller) obj;
            }
            FLog.w(TAG, "Failed to cast mScroller field in HorizontalScrollView (probably due to OEM changes to AOSP)! This app will exhibit the bounce-back scrolling bug :(");
            return null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to get mScroller from HorizontalScrollView!", e);
        }
    }

    public void setScrollPerfTag(String str) {
        this.mScrollPerfTag = str;
    }

    public void setRemoveClippedSubviews(boolean z) {
        if (z && this.mClippingRect == null) {
            this.mClippingRect = new Rect();
        }
        this.mRemoveClippedSubviews = z;
        updateClippingRect();
    }

    public boolean getRemoveClippedSubviews() {
        return this.mRemoveClippedSubviews;
    }

    public void setDisableIntervalMomentum(boolean z) {
        this.mDisableIntervalMomentum = z;
    }

    public void setSendMomentumEvents(boolean z) {
        this.mSendMomentumEvents = z;
    }

    public void setScrollEnabled(boolean z) {
        this.mScrollEnabled = z;
    }

    public void setPagingEnabled(boolean z) {
        this.mPagingEnabled = z;
    }

    public void setDecelerationRate(float f) {
        this.mDecelerationRate = f;
        OverScroller overScroller = this.mScroller;
        if (overScroller != null) {
            overScroller.setFriction(1.0f - f);
        }
    }

    public void setSnapInterval(int i) {
        this.mSnapInterval = i;
    }

    public void setSnapOffsets(List<Integer> list) {
        this.mSnapOffsets = list;
    }

    public void setSnapToStart(boolean z) {
        this.mSnapToStart = z;
    }

    public void setSnapToEnd(boolean z) {
        this.mSnapToEnd = z;
    }

    public void flashScrollIndicators() {
        awakenScrollBars();
    }

    public void setOverflow(String str) {
        this.mOverflow = str;
        invalidate();
    }

    public String getOverflow() {
        return this.mOverflow;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "onDraw[%d]", (Object) Integer.valueOf(getId()));
        }
        getDrawingRect(this.mRect);
        String str = this.mOverflow;
        char c = 65535;
        if (str.hashCode() == 466743410 && str.equals(ViewProps.VISIBLE)) {
            c = 0;
        }
        if (c != 0) {
            canvas.clipRect(this.mRect);
        }
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        OverScroller overScroller;
        MeasureSpecAssertions.assertExplicitMeasureSpec(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (DEBUG_MODE) {
            FLog.i(TAG, "onMeasure[%d] measured width: %d measured height: %d", (Object) Integer.valueOf(getId()), (Object) Integer.valueOf(size), (Object) Integer.valueOf(size2));
        }
        boolean z = getMeasuredHeight() != size2;
        setMeasuredDimension(size, size2);
        if (z && (overScroller = this.mScroller) != null) {
            this.mScrollXAfterMeasure = overScroller.getCurrX();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        OverScroller overScroller;
        if (DEBUG_MODE) {
            FLog.i(TAG, "onLayout[%d] l %d t %d r %d b %d", Integer.valueOf(getId()), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        }
        int i5 = this.mScrollXAfterMeasure;
        if (!(i5 == NO_SCROLL_POSITION || (overScroller = this.mScroller) == null || i5 == overScroller.getFinalX() || this.mScroller.isFinished())) {
            if (DEBUG_MODE) {
                FLog.i(TAG, "onLayout[%d] scroll hack enabled: reset to previous scrollX position of %d", (Object) Integer.valueOf(getId()), (Object) Integer.valueOf(this.mScrollXAfterMeasure));
            }
            OverScroller overScroller2 = this.mScroller;
            overScroller2.startScroll(this.mScrollXAfterMeasure, overScroller2.getFinalY(), 0, 0);
            this.mScroller.forceFinished(true);
            this.mScrollXAfterMeasure = NO_SCROLL_POSITION;
        }
        int i6 = this.pendingContentOffsetX;
        if (i6 == -1) {
            i6 = getScrollX();
        }
        int i7 = this.pendingContentOffsetY;
        if (i7 == -1) {
            i7 = getScrollY();
        }
        scrollTo(i6, i7);
        ReactScrollViewHelper.emitLayoutEvent(this);
    }

    public void requestChildFocus(View view, View view2) {
        if (view2 != null && !this.mPagingEnabled) {
            scrollToChild(view2);
        }
        super.requestChildFocus(view, view2);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (!this.mPagingEnabled || this.mPagedArrowScrolling) {
            super.addFocusables(arrayList, i, i2);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        super.addFocusables(arrayList2, i, i2);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            if (isScrolledInView(view) || isPartiallyScrolledInView(view) || view.isFocused()) {
                arrayList.add(view);
            }
        }
    }

    private int getScrollDelta(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        return computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
    }

    private boolean isScrolledInView(View view) {
        return getScrollDelta(view) == 0;
    }

    private boolean isPartiallyScrolledInView(View view) {
        int scrollDelta = getScrollDelta(view);
        view.getDrawingRect(this.mTempRect);
        return scrollDelta != 0 && Math.abs(scrollDelta) < this.mTempRect.width();
    }

    private boolean isMostlyScrolledInView(View view) {
        int scrollDelta = getScrollDelta(view);
        view.getDrawingRect(this.mTempRect);
        return scrollDelta != 0 && Math.abs(scrollDelta) < this.mTempRect.width() / 2;
    }

    private void scrollToChild(View view) {
        int scrollDelta = getScrollDelta(view);
        if (scrollDelta != 0) {
            scrollBy(scrollDelta, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "onScrollChanged[%d] x %d y %d oldx %d oldy %d", Integer.valueOf(getId()), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        }
        super.onScrollChanged(i, i2, i3, i4);
        this.mActivelyScrolling = true;
        if (this.mOnScrollDispatchHelper.onScrollChanged(i, i2)) {
            if (this.mRemoveClippedSubviews) {
                updateClippingRect();
            }
            updateStateOnScroll();
            ReactScrollViewHelper.emitScrollEvent(this, this.mOnScrollDispatchHelper.getXFlingVelocity(), this.mOnScrollDispatchHelper.getYFlingVelocity());
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollEnabled) {
            return false;
        }
        try {
            if (super.onInterceptTouchEvent(motionEvent)) {
                NativeGestureUtil.notifyNativeGestureStarted(this, motionEvent);
                ReactScrollViewHelper.emitScrollBeginDragEvent(this);
                this.mDragging = true;
                enableFpsListener();
                return true;
            }
        } catch (IllegalArgumentException e) {
            FLog.w(ReactConstants.TAG, "Error intercepting touch event.", (Throwable) e);
        }
        return false;
    }

    public boolean pageScroll(int i) {
        boolean pageScroll = super.pageScroll(i);
        if (this.mPagingEnabled && pageScroll) {
            handlePostTouchScrolling(0, 0);
        }
        return pageScroll;
    }

    public boolean arrowScroll(int i) {
        if (!this.mPagingEnabled) {
            return super.arrowScroll(i);
        }
        boolean z = true;
        this.mPagedArrowScrolling = true;
        if (getChildCount() > 0) {
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus(), i);
            View contentView = getContentView();
            if (contentView == null || findNextFocus == null || findNextFocus.getParent() != contentView) {
                smoothScrollToNextPage(i);
            } else {
                if (!isScrolledInView(findNextFocus) && !isMostlyScrolledInView(findNextFocus)) {
                    smoothScrollToNextPage(i);
                }
                findNextFocus.requestFocus();
            }
        } else {
            z = false;
        }
        this.mPagedArrowScrolling = false;
        return z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollEnabled) {
            return false;
        }
        this.mVelocityHelper.calculateVelocity(motionEvent);
        if ((motionEvent.getAction() & 255) == 1 && this.mDragging) {
            updateStateOnScroll();
            float xVelocity = this.mVelocityHelper.getXVelocity();
            float yVelocity = this.mVelocityHelper.getYVelocity();
            ReactScrollViewHelper.emitScrollEndDragEvent(this, xVelocity, yVelocity);
            this.mDragging = false;
            handlePostTouchScrolling(Math.round(xVelocity), Math.round(yVelocity));
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.mScrollEnabled || (keyCode != 21 && keyCode != 22)) {
            return super.executeKeyEvent(keyEvent);
        }
        return false;
    }

    public void fling(int i) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "fling[%d] velocityX %d", (Object) Integer.valueOf(getId()), (Object) Integer.valueOf(i));
        }
        int abs = (int) (((float) Math.abs(i)) * Math.signum(this.mOnScrollDispatchHelper.getXFlingVelocity()));
        if (this.mPagingEnabled) {
            flingAndSnap(abs);
        } else if (this.mScroller != null) {
            int width = (getWidth() - ViewCompat.getPaddingStart(this)) - ViewCompat.getPaddingEnd(this);
            this.mScroller.fling(getScrollX(), getScrollY(), abs, 0, 0, Integer.MAX_VALUE, 0, 0, width / 2, 0);
            ViewCompat.postInvalidateOnAnimation(this);
        } else {
            super.fling(abs);
        }
        handlePostTouchScrolling(abs, 0);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    public void updateClippingRect() {
        if (this.mRemoveClippedSubviews) {
            Assertions.assertNotNull(this.mClippingRect);
            ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
            View contentView = getContentView();
            if (contentView instanceof ReactClippingViewGroup) {
                ((ReactClippingViewGroup) contentView).updateClippingRect();
            }
        }
    }

    public void getClippingRect(Rect rect) {
        rect.set((Rect) Assertions.assertNotNull(this.mClippingRect));
    }

    public boolean getChildVisibleRect(View view, Rect rect, Point point) {
        return super.getChildVisibleRect(view, rect, point);
    }

    private int getSnapInterval() {
        int i = this.mSnapInterval;
        if (i != 0) {
            return i;
        }
        return getWidth();
    }

    private View getContentView() {
        return getChildAt(0);
    }

    public void setEndFillColor(int i) {
        if (i != this.mEndFillColor) {
            this.mEndFillColor = i;
            this.mEndBackground = new ColorDrawable(this.mEndFillColor);
        }
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        int computeHorizontalScrollRange;
        if (DEBUG_MODE) {
            FLog.i(TAG, "onOverScrolled[%d] scrollX %d scrollY %d clampedX %b clampedY %b", Integer.valueOf(getId()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2));
        }
        OverScroller overScroller = this.mScroller;
        if (overScroller != null && !overScroller.isFinished() && this.mScroller.getCurrX() != this.mScroller.getFinalX() && i >= (computeHorizontalScrollRange = computeHorizontalScrollRange() - getWidth())) {
            this.mScroller.abortAnimation();
            i = computeHorizontalScrollRange;
        }
        super.onOverScrolled(i, i2, z, z2);
    }

    private void enableFpsListener() {
        if (isScrollPerfLoggingEnabled()) {
            Assertions.assertNotNull(this.mFpsListener);
            Assertions.assertNotNull(this.mScrollPerfTag);
            this.mFpsListener.enable(this.mScrollPerfTag);
        }
    }

    /* access modifiers changed from: private */
    public void disableFpsListener() {
        if (isScrollPerfLoggingEnabled()) {
            Assertions.assertNotNull(this.mFpsListener);
            Assertions.assertNotNull(this.mScrollPerfTag);
            this.mFpsListener.disable(this.mScrollPerfTag);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.mScrollPerfTag;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isScrollPerfLoggingEnabled() {
        /*
            r1 = this;
            com.facebook.react.views.scroll.FpsListener r0 = r1.mFpsListener
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r1.mScrollPerfTag
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.scroll.ReactHorizontalScrollView.isScrollPerfLoggingEnabled():boolean");
    }

    public void draw(Canvas canvas) {
        if (this.mEndFillColor != 0) {
            View contentView = getContentView();
            if (!(this.mEndBackground == null || contentView == null || contentView.getRight() >= getWidth())) {
                this.mEndBackground.setBounds(contentView.getRight(), 0, getWidth(), getHeight());
                this.mEndBackground.draw(canvas);
            }
        }
        super.draw(canvas);
    }

    private void handlePostTouchScrolling(int i, int i2) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "handlePostTouchScrolling[%d] velocityX %d velocityY %d", (Object) Integer.valueOf(getId()), (Object) Integer.valueOf(i), (Object) Integer.valueOf(i2));
        }
        if (this.mPostTouchRunnable == null) {
            if (this.mSendMomentumEvents) {
                ReactScrollViewHelper.emitScrollMomentumBeginEvent(this, i, i2);
            }
            this.mActivelyScrolling = false;
            AnonymousClass2 r6 = new Runnable() {
                private boolean mRunning = true;
                private boolean mSnappingToPage = false;
                private int mStableFrames = 0;

                public void run() {
                    if (ReactHorizontalScrollView.this.mActivelyScrolling) {
                        boolean unused = ReactHorizontalScrollView.this.mActivelyScrolling = false;
                        this.mStableFrames = 0;
                        this.mRunning = true;
                    } else {
                        ReactHorizontalScrollView.this.updateStateOnScroll();
                        int i = this.mStableFrames + 1;
                        this.mStableFrames = i;
                        this.mRunning = i < 3;
                        if (!ReactHorizontalScrollView.this.mPagingEnabled || this.mSnappingToPage) {
                            if (ReactHorizontalScrollView.this.mSendMomentumEvents) {
                                ReactScrollViewHelper.emitScrollMomentumEndEvent(ReactHorizontalScrollView.this);
                            }
                            ReactHorizontalScrollView.this.disableFpsListener();
                        } else {
                            this.mSnappingToPage = true;
                            ReactHorizontalScrollView.this.flingAndSnap(0);
                            ViewCompat.postOnAnimationDelayed(ReactHorizontalScrollView.this, this, 20);
                        }
                    }
                    if (this.mRunning) {
                        ViewCompat.postOnAnimationDelayed(ReactHorizontalScrollView.this, this, 20);
                    } else {
                        Runnable unused2 = ReactHorizontalScrollView.this.mPostTouchRunnable = null;
                    }
                }
            };
            this.mPostTouchRunnable = r6;
            ViewCompat.postOnAnimationDelayed(this, r6, 20);
        }
    }

    private int getPostAnimationScrollX() {
        ValueAnimator valueAnimator = this.mScrollAnimator;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return getScrollX();
        }
        return this.mFinalAnimatedPositionScrollX;
    }

    private int getPostAnimationScrollY() {
        ValueAnimator valueAnimator = this.mScrollAnimator;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return getScrollY();
        }
        return this.mFinalAnimatedPositionScrollY;
    }

    private int predictFinalScrollPosition(int i) {
        OverScroller overScroller = new OverScroller(getContext());
        overScroller.setFriction(1.0f - this.mDecelerationRate);
        int max = Math.max(0, computeHorizontalScrollRange() - getWidth());
        int width = ((getWidth() - ViewCompat.getPaddingStart(this)) - ViewCompat.getPaddingEnd(this)) / 2;
        overScroller.fling(getPostAnimationScrollX(), getPostAnimationScrollY(), i, 0, 0, max, 0, 0, width, 0);
        return overScroller.getFinalX();
    }

    private void smoothScrollAndSnap(int i) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "smoothScrollAndSnap[%d] velocity %d", (Object) Integer.valueOf(getId()), (Object) Integer.valueOf(i));
        }
        double snapInterval = (double) getSnapInterval();
        double postAnimationScrollX = (double) getPostAnimationScrollX();
        double d = postAnimationScrollX / snapInterval;
        int floor = (int) Math.floor(d);
        int ceil = (int) Math.ceil(d);
        int round = (int) Math.round(d);
        int round2 = (int) Math.round(((double) predictFinalScrollPosition(i)) / snapInterval);
        if (i > 0 && ceil == floor) {
            ceil++;
        } else if (i < 0 && floor == ceil) {
            floor--;
        }
        if (i > 0 && round < ceil && round2 > floor) {
            round = ceil;
        } else if (i < 0 && round > floor && round2 < ceil) {
            round = floor;
        }
        double d2 = ((double) round) * snapInterval;
        if (d2 != postAnimationScrollX) {
            this.mActivelyScrolling = true;
            reactSmoothScrollTo((int) d2, getScrollY());
        }
    }

    /* access modifiers changed from: private */
    public void flingAndSnap(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (DEBUG_MODE) {
            FLog.i(TAG, "smoothScrollAndSnap[%d] velocityX %d", (Object) Integer.valueOf(getId()), (Object) Integer.valueOf(i));
        }
        if (getChildCount() > 0) {
            if (this.mSnapInterval == 0 && this.mSnapOffsets == null) {
                smoothScrollAndSnap(i);
                return;
            }
            int max = Math.max(0, computeHorizontalScrollRange() - getWidth());
            int predictFinalScrollPosition = predictFinalScrollPosition(i);
            if (this.mDisableIntervalMomentum) {
                predictFinalScrollPosition = getScrollX();
            }
            int width = (getWidth() - ViewCompat.getPaddingStart(this)) - ViewCompat.getPaddingEnd(this);
            if (this.mLayoutDirection == 1) {
                predictFinalScrollPosition = max - predictFinalScrollPosition;
                i2 = -i;
            } else {
                i2 = i;
            }
            List<Integer> list = this.mSnapOffsets;
            if (list == null || list.isEmpty()) {
                double snapInterval = (double) getSnapInterval();
                double d = ((double) predictFinalScrollPosition) / snapInterval;
                i5 = max;
                i4 = (int) (Math.floor(d) * snapInterval);
                i3 = Math.min((int) (Math.ceil(d) * snapInterval), max);
                i6 = 0;
            } else {
                i6 = this.mSnapOffsets.get(0).intValue();
                List<Integer> list2 = this.mSnapOffsets;
                i5 = list2.get(list2.size() - 1).intValue();
                i3 = max;
                i4 = 0;
                for (int i8 = 0; i8 < this.mSnapOffsets.size(); i8++) {
                    int intValue = this.mSnapOffsets.get(i8).intValue();
                    if (intValue <= predictFinalScrollPosition && predictFinalScrollPosition - intValue < predictFinalScrollPosition - i4) {
                        i4 = intValue;
                    }
                    if (intValue >= predictFinalScrollPosition && intValue - predictFinalScrollPosition < i3 - predictFinalScrollPosition) {
                        i3 = intValue;
                    }
                }
            }
            int i9 = predictFinalScrollPosition - i4;
            int i10 = i3 - predictFinalScrollPosition;
            int i11 = i9 < i10 ? i4 : i3;
            int scrollX = getScrollX();
            if (this.mLayoutDirection == 1) {
                scrollX = max - scrollX;
            }
            if (this.mSnapToEnd || predictFinalScrollPosition < i5) {
                if (this.mSnapToStart || predictFinalScrollPosition > i6) {
                    if (i2 > 0) {
                        i2 += (int) (((double) i10) * 10.0d);
                        predictFinalScrollPosition = i3;
                    } else if (i2 < 0) {
                        i2 -= (int) (((double) i9) * 10.0d);
                        predictFinalScrollPosition = i4;
                    } else {
                        predictFinalScrollPosition = i11;
                    }
                } else if (scrollX > i6) {
                    predictFinalScrollPosition = i6;
                }
            } else if (scrollX < i5) {
                predictFinalScrollPosition = i5;
            }
            int min = Math.min(Math.max(0, predictFinalScrollPosition), max);
            if (this.mLayoutDirection == 1) {
                min = max - min;
                i2 = -i2;
            }
            int i12 = min;
            OverScroller overScroller = this.mScroller;
            if (overScroller != null) {
                this.mActivelyScrolling = true;
                int scrollX2 = getScrollX();
                int scrollY = getScrollY();
                if (i2 != 0) {
                    i7 = i2;
                } else {
                    i7 = i12 - getScrollX();
                }
                overScroller.fling(scrollX2, scrollY, i7, 0, i12, i12, 0, 0, (i12 == 0 || i12 == max) ? width / 2 : 0, 0);
                postInvalidateOnAnimation();
                return;
            }
            reactSmoothScrollTo(i12, getScrollY());
        }
    }

    private void smoothScrollToNextPage(int i) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "smoothScrollToNextPage[%d] direction %d", (Object) Integer.valueOf(getId()), (Object) Integer.valueOf(i));
        }
        int width = getWidth();
        int scrollX = getScrollX();
        int i2 = scrollX / width;
        if (scrollX % width != 0) {
            i2++;
        }
        int i3 = i == 17 ? i2 - 1 : i2 + 1;
        if (i3 < 0) {
            i3 = 0;
        }
        reactSmoothScrollTo(i3 * width, getScrollY());
        handlePostTouchScrolling(0, 0);
    }

    public void setBackgroundColor(int i) {
        this.mReactBackgroundManager.setBackgroundColor(i);
    }

    public void setBorderWidth(int i, float f) {
        this.mReactBackgroundManager.setBorderWidth(i, f);
    }

    public void setBorderColor(int i, float f, float f2) {
        this.mReactBackgroundManager.setBorderColor(i, f, f2);
    }

    public void setBorderRadius(float f) {
        this.mReactBackgroundManager.setBorderRadius(f);
    }

    public void setBorderRadius(float f, int i) {
        this.mReactBackgroundManager.setBorderRadius(f, i);
    }

    public void setBorderStyle(String str) {
        this.mReactBackgroundManager.setBorderStyle(str);
    }

    public void reactSmoothScrollTo(int i, int i2) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "reactSmoothScrollTo[%d] x %d y %d", (Object) Integer.valueOf(getId()), (Object) Integer.valueOf(i), (Object) Integer.valueOf(i2));
        }
        ValueAnimator valueAnimator = this.mScrollAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mFinalAnimatedPositionScrollX = i;
        this.mFinalAnimatedPositionScrollY = i2;
        ValueAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofInt("scrollX", new int[]{getScrollX(), i}), PropertyValuesHolder.ofInt("scrollY", new int[]{getScrollY(), i2})});
        this.mScrollAnimator = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setDuration((long) ReactScrollViewHelper.getDefaultScrollAnimationDuration(getContext()));
        this.mScrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ReactHorizontalScrollView.this.scrollTo(((Integer) valueAnimator.getAnimatedValue("scrollX")).intValue(), ((Integer) valueAnimator.getAnimatedValue("scrollY")).intValue());
            }
        });
        this.mScrollAnimator.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                int unused = ReactHorizontalScrollView.this.mFinalAnimatedPositionScrollX = -1;
                int unused2 = ReactHorizontalScrollView.this.mFinalAnimatedPositionScrollY = -1;
                ValueAnimator unused3 = ReactHorizontalScrollView.this.mScrollAnimator = null;
                ReactHorizontalScrollView.this.updateStateOnScroll();
            }
        });
        this.mScrollAnimator.start();
        updateStateOnScroll(i, i2);
        setPendingContentOffsets(i, i2);
    }

    public void scrollTo(int i, int i2) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "scrollTo[%d] x %d y %d", (Object) Integer.valueOf(getId()), (Object) Integer.valueOf(i), (Object) Integer.valueOf(i2));
        }
        super.scrollTo(i, i2);
        updateStateOnScroll(i, i2);
        setPendingContentOffsets(i, i2);
    }

    private void setPendingContentOffsets(int i, int i2) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "setPendingContentOffsets[%d] x %d y %d", (Object) Integer.valueOf(getId()), (Object) Integer.valueOf(i), (Object) Integer.valueOf(i2));
        }
        View contentView = getContentView();
        if (contentView == null || contentView.getWidth() == 0 || contentView.getHeight() == 0) {
            this.pendingContentOffsetX = i;
            this.pendingContentOffsetY = i2;
            return;
        }
        this.pendingContentOffsetX = -1;
        this.pendingContentOffsetY = -1;
    }

    private void updateStateOnScroll(int i, final int i2) {
        final int i3;
        if (DEBUG_MODE) {
            FLog.i(TAG, "updateStateOnScroll[%d] scrollX %d scrollY %d", (Object) Integer.valueOf(getId()), (Object) Integer.valueOf(i), (Object) Integer.valueOf(i2));
        }
        if (i != this.mLastStateUpdateScrollX || i2 != this.mLastStateUpdateScrollY) {
            this.mLastStateUpdateScrollX = i;
            this.mLastStateUpdateScrollY = i2;
            if (this.mLayoutDirection == 1) {
                View contentView = getContentView();
                i3 = -(((contentView != null ? contentView.getWidth() : 0) - i) - getWidth());
            } else {
                i3 = i;
            }
            if (DEBUG_MODE) {
                FLog.i(TAG, "updateStateOnScroll[%d] scrollX %d scrollY %d fabricScrollX", (Object) Integer.valueOf(getId()), (Object) Integer.valueOf(i), (Object) Integer.valueOf(i2), (Object) Integer.valueOf(i3));
            }
            this.mFabricViewStateManager.setState(new FabricViewStateManager.StateUpdateCallback() {
                public WritableMap getStateUpdate() {
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.putDouble(ReactHorizontalScrollView.CONTENT_OFFSET_LEFT, (double) PixelUtil.toDIPFromPixel((float) i3));
                    writableNativeMap.putDouble(ReactHorizontalScrollView.CONTENT_OFFSET_TOP, (double) PixelUtil.toDIPFromPixel((float) i2));
                    writableNativeMap.putDouble(ReactHorizontalScrollView.SCROLL_AWAY_PADDING_TOP, Utils.DOUBLE_EPSILON);
                    return writableNativeMap;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void updateStateOnScroll() {
        updateStateOnScroll(getScrollX(), getScrollY());
    }

    public FabricViewStateManager getFabricViewStateManager() {
        return this.mFabricViewStateManager;
    }
}
