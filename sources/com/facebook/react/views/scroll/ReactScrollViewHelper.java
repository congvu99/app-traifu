package com.facebook.react.views.scroll;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class ReactScrollViewHelper {
    public static final String AUTO = "auto";
    public static final long MOMENTUM_DELAY = 20;
    public static final String OVER_SCROLL_ALWAYS = "always";
    public static final String OVER_SCROLL_NEVER = "never";
    private static int SMOOTH_SCROLL_DURATION = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
    private static boolean mSmoothScrollDurationInitialized = false;
    private static Set<ScrollListener> sScrollListeners = Collections.newSetFromMap(new WeakHashMap());

    public interface ScrollListener {
        void onLayout(ViewGroup viewGroup);

        void onScroll(ViewGroup viewGroup, ScrollEventType scrollEventType, float f, float f2);
    }

    public static void emitScrollEvent(ViewGroup viewGroup, float f, float f2) {
        emitScrollEvent(viewGroup, ScrollEventType.SCROLL, f, f2);
    }

    public static void emitScrollBeginDragEvent(ViewGroup viewGroup) {
        emitScrollEvent(viewGroup, ScrollEventType.BEGIN_DRAG);
    }

    public static void emitScrollEndDragEvent(ViewGroup viewGroup, float f, float f2) {
        emitScrollEvent(viewGroup, ScrollEventType.END_DRAG, f, f2);
    }

    public static void emitScrollMomentumBeginEvent(ViewGroup viewGroup, int i, int i2) {
        emitScrollEvent(viewGroup, ScrollEventType.MOMENTUM_BEGIN, (float) i, (float) i2);
    }

    public static void emitScrollMomentumEndEvent(ViewGroup viewGroup) {
        emitScrollEvent(viewGroup, ScrollEventType.MOMENTUM_END);
    }

    private static void emitScrollEvent(ViewGroup viewGroup, ScrollEventType scrollEventType) {
        emitScrollEvent(viewGroup, scrollEventType, 0.0f, 0.0f);
    }

    private static void emitScrollEvent(ViewGroup viewGroup, ScrollEventType scrollEventType, float f, float f2) {
        ViewGroup viewGroup2 = viewGroup;
        View childAt = viewGroup.getChildAt(0);
        if (childAt != null) {
            for (ScrollListener onScroll : sScrollListeners) {
                onScroll.onScroll(viewGroup, scrollEventType, f, f2);
            }
            ReactContext reactContext = (ReactContext) viewGroup.getContext();
            int surfaceId = UIManagerHelper.getSurfaceId((Context) reactContext);
            UIManagerHelper.getEventDispatcherForReactTag(reactContext, viewGroup.getId()).dispatchEvent(ScrollEvent.obtain(surfaceId, viewGroup.getId(), scrollEventType, viewGroup.getScrollX(), viewGroup.getScrollY(), f, f2, childAt.getWidth(), childAt.getHeight(), viewGroup.getWidth(), viewGroup.getHeight()));
        }
    }

    public static void emitLayoutEvent(ViewGroup viewGroup) {
        for (ScrollListener onLayout : sScrollListeners) {
            onLayout.onLayout(viewGroup);
        }
    }

    public static int parseOverScrollMode(String str) {
        if (str == null || str.equals("auto")) {
            return 1;
        }
        if (str.equals(OVER_SCROLL_ALWAYS)) {
            return 0;
        }
        if (str.equals(OVER_SCROLL_NEVER)) {
            return 2;
        }
        throw new JSApplicationIllegalArgumentException("wrong overScrollMode: " + str);
    }

    public static int getDefaultScrollAnimationDuration(Context context) {
        if (!mSmoothScrollDurationInitialized) {
            mSmoothScrollDurationInitialized = true;
            try {
                SMOOTH_SCROLL_DURATION = new OverScrollerDurationGetter(context).getScrollAnimationDuration();
            } catch (Throwable unused) {
            }
        }
        return SMOOTH_SCROLL_DURATION;
    }

    private static class OverScrollerDurationGetter extends OverScroller {
        private int mScrollAnimationDuration = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;

        OverScrollerDurationGetter(Context context) {
            super(context);
        }

        public int getScrollAnimationDuration() {
            super.startScroll(0, 0, 0, 0);
            return this.mScrollAnimationDuration;
        }

        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            this.mScrollAnimationDuration = i5;
        }
    }

    public static void addScrollListener(ScrollListener scrollListener) {
        sScrollListeners.add(scrollListener);
    }

    public static void removeScrollListener(ScrollListener scrollListener) {
        sScrollListeners.remove(scrollListener);
    }
}
