package com.facebook.react.fabric.mounting;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewManager;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.annotation.Nullable;

public class SurfaceMountingManager {
    private static final boolean SHOW_CHANGED_VIEW_HIERARCHIES = false;
    public static final String TAG = SurfaceMountingManager.class.getSimpleName();
    private volatile boolean mIsStopped = false;
    /* access modifiers changed from: private */
    public JSResponderHandler mJSResponderHandler;
    /* access modifiers changed from: private */
    public MountingManager.MountItemExecutor mMountItemExecutor;
    /* access modifiers changed from: private */
    public ConcurrentLinkedQueue<MountItem> mOnViewAttachItems = new ConcurrentLinkedQueue<>();
    /* access modifiers changed from: private */
    public volatile boolean mRootViewAttached = false;
    /* access modifiers changed from: private */
    public RootViewManager mRootViewManager;
    /* access modifiers changed from: private */
    public final int mSurfaceId;
    /* access modifiers changed from: private */
    public Set<Integer> mTagSetForStoppedSurface;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<Integer, ViewState> mTagToViewState = new ConcurrentHashMap<>();
    @Nullable
    private ThemedReactContext mThemedReactContext;
    private ViewManagerRegistry mViewManagerRegistry;

    public SurfaceMountingManager(int i, JSResponderHandler jSResponderHandler, ViewManagerRegistry viewManagerRegistry, RootViewManager rootViewManager, MountingManager.MountItemExecutor mountItemExecutor) {
        this.mSurfaceId = i;
        this.mJSResponderHandler = jSResponderHandler;
        this.mViewManagerRegistry = viewManagerRegistry;
        this.mRootViewManager = rootViewManager;
        this.mMountItemExecutor = mountItemExecutor;
    }

    public boolean isStopped() {
        return this.mIsStopped;
    }

    public void attachRootView(View view, ThemedReactContext themedReactContext) {
        this.mThemedReactContext = themedReactContext;
        addRootView(view);
    }

    public int getSurfaceId() {
        return this.mSurfaceId;
    }

    public boolean isRootViewAttached() {
        return this.mRootViewAttached;
    }

    @Nullable
    public ThemedReactContext getContext() {
        return this.mThemedReactContext;
    }

    private static void logViewHierarchy(ViewGroup viewGroup, boolean z) {
        int i;
        int id = viewGroup.getId();
        String str = TAG;
        FLog.e(str, "  <ViewGroup tag=" + id + " class=" + viewGroup.getClass().toString() + ">");
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            String str2 = TAG;
            FLog.e(str2, "     <View idx=" + i2 + " tag=" + viewGroup.getChildAt(i2).getId() + " class=" + viewGroup.getChildAt(i2).getClass().toString() + ">");
        }
        String str3 = TAG;
        FLog.e(str3, "  </ViewGroup tag=" + id + ">");
        if (z) {
            FLog.e(TAG, "Displaying Ancestors:");
            for (ViewParent parent = viewGroup.getParent(); parent != null; parent = parent.getParent()) {
                ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup2 == null) {
                    i = -1;
                } else {
                    i = viewGroup2.getId();
                }
                String str4 = TAG;
                FLog.e(str4, "<ViewParent tag=" + i + " class=" + parent.getClass().toString() + ">");
            }
        }
    }

    public boolean getViewExists(int i) {
        Set<Integer> set = this.mTagSetForStoppedSurface;
        if (set != null && set.contains(Integer.valueOf(i))) {
            return true;
        }
        ConcurrentHashMap<Integer, ViewState> concurrentHashMap = this.mTagToViewState;
        if (concurrentHashMap == null) {
            return false;
        }
        return concurrentHashMap.containsKey(Integer.valueOf(i));
    }

    public void executeOnViewAttach(MountItem mountItem) {
        this.mOnViewAttachItems.add(mountItem);
    }

    private void addRootView(final View view) {
        if (!isStopped()) {
            this.mTagToViewState.put(Integer.valueOf(this.mSurfaceId), new ViewState(this.mSurfaceId, view, this.mRootViewManager, true));
            AnonymousClass1 r0 = new Runnable() {
                public void run() {
                    if (!SurfaceMountingManager.this.isStopped()) {
                        if (view.getId() == SurfaceMountingManager.this.mSurfaceId) {
                            String str = SurfaceMountingManager.TAG;
                            ReactSoftExceptionLogger.logSoftException(str, new IllegalViewOperationException("Race condition in addRootView detected. Trying to set an id of [" + SurfaceMountingManager.this.mSurfaceId + "] on the RootView, but that id has already been set. "));
                        } else if (view.getId() != -1) {
                            FLog.e(SurfaceMountingManager.TAG, "Trying to add RootTag to RootView that already has a tag: existing tag: [%d] new tag: [%d]", Integer.valueOf(view.getId()), Integer.valueOf(SurfaceMountingManager.this.mSurfaceId));
                            throw new IllegalViewOperationException("Trying to add a root view with an explicit id already set. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID before calling addRootView.");
                        }
                        view.setId(SurfaceMountingManager.this.mSurfaceId);
                        View view = view;
                        if (view instanceof ReactRoot) {
                            ((ReactRoot) view).setRootViewTag(SurfaceMountingManager.this.mSurfaceId);
                        }
                        boolean unused = SurfaceMountingManager.this.mRootViewAttached = true;
                        SurfaceMountingManager.this.executeViewAttachMountItems();
                    }
                }
            };
            if (UiThreadUtil.isOnUiThread()) {
                r0.run();
            } else {
                UiThreadUtil.runOnUiThread(r0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void executeViewAttachMountItems() {
        this.mMountItemExecutor.executeItems(this.mOnViewAttachItems);
    }

    public void stopSurface() {
        if (!isStopped()) {
            this.mIsStopped = true;
            for (ViewState next : this.mTagToViewState.values()) {
                if (next.mStateWrapper != null) {
                    next.mStateWrapper.destroyState();
                    next.mStateWrapper = null;
                }
                if (ReactFeatureFlags.enableAggressiveEventEmitterCleanup && next.mEventEmitter != null) {
                    next.mEventEmitter.destroy();
                    next.mEventEmitter = null;
                }
            }
            AnonymousClass2 r0 = new Runnable() {
                public void run() {
                    for (ViewState access$500 : SurfaceMountingManager.this.mTagToViewState.values()) {
                        SurfaceMountingManager.this.onViewStateDeleted(access$500);
                    }
                    SurfaceMountingManager surfaceMountingManager = SurfaceMountingManager.this;
                    Set unused = surfaceMountingManager.mTagSetForStoppedSurface = surfaceMountingManager.mTagToViewState.keySet();
                    ConcurrentHashMap unused2 = SurfaceMountingManager.this.mTagToViewState = null;
                    JSResponderHandler unused3 = SurfaceMountingManager.this.mJSResponderHandler = null;
                    RootViewManager unused4 = SurfaceMountingManager.this.mRootViewManager = null;
                    MountingManager.MountItemExecutor unused5 = SurfaceMountingManager.this.mMountItemExecutor = null;
                    SurfaceMountingManager.this.mOnViewAttachItems.clear();
                }
            };
            if (UiThreadUtil.isOnUiThread()) {
                r0.run();
            } else {
                UiThreadUtil.runOnUiThread(r0);
            }
        }
    }

    public void addViewAt(int i, int i2, int i3) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState viewState = getViewState(i);
            if (viewState.mView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) viewState.mView;
                ViewState viewState2 = getViewState(i2);
                View view = viewState2.mView;
                if (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent != null) {
                        int id = parent instanceof ViewGroup ? ((ViewGroup) parent).getId() : -1;
                        ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("addViewAt: cannot insert view [" + i2 + "] into parent [" + i + "]: View already has a parent: [" + id + "] " + parent.getClass().getSimpleName()));
                    }
                    try {
                        getViewGroupManager(viewState).addView(viewGroup, view, i3);
                    } catch (IllegalStateException e) {
                        throw new IllegalStateException("addViewAt: failed to insert view [" + i2 + "] into parent [" + i + "] at index " + i3, e);
                    }
                } else {
                    throw new IllegalStateException("Unable to find view for viewState " + viewState2 + " and tag " + i2);
                }
            } else {
                String str = "Unable to add a view into a view that is not a ViewGroup. ParentTag: " + i + " - Tag: " + i2 + " - Index: " + i3;
                FLog.e(TAG, str);
                throw new IllegalStateException(str);
            }
        }
    }

    public void removeViewAt(int i, int i2, int i3) {
        if (!isStopped()) {
            UiThreadUtil.assertOnUiThread();
            ViewState nullableViewState = getNullableViewState(i2);
            if (nullableViewState == null) {
                ReactSoftExceptionLogger.logSoftException(MountingManager.TAG, new IllegalStateException("Unable to find viewState for tag: [" + i2 + "] for removeViewAt"));
            } else if (nullableViewState.mView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) nullableViewState.mView;
                if (viewGroup != null) {
                    ViewGroupManager<ViewGroup> viewGroupManager = getViewGroupManager(nullableViewState);
                    View childAt = viewGroupManager.getChildAt(viewGroup, i3);
                    int id = childAt != null ? childAt.getId() : -1;
                    if (id != i) {
                        int childCount = viewGroup.getChildCount();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= childCount) {
                                i4 = -1;
                                break;
                            } else if (viewGroup.getChildAt(i4).getId() == i) {
                                break;
                            } else {
                                i4++;
                            }
                        }
                        if (i4 == -1) {
                            FLog.e(TAG, "removeViewAt: [" + i + "] -> [" + i2 + "] @" + i3 + ": view already removed from parent! Children in parent: " + childCount);
                            return;
                        }
                        logViewHierarchy(viewGroup, true);
                        ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Tried to remove view [" + i + "] of parent [" + i2 + "] at index " + i3 + ", but got view tag " + id + " - actual index of view: " + i4));
                        i3 = i4;
                    }
                    try {
                        viewGroupManager.removeViewAt(viewGroup, i3);
                    } catch (RuntimeException e) {
                        int childCount2 = viewGroupManager.getChildCount(viewGroup);
                        logViewHierarchy(viewGroup, true);
                        throw new IllegalStateException("Cannot remove child at index " + i3 + " from parent ViewGroup [" + viewGroup.getId() + "], only " + childCount2 + " children in parent. Warning: childCount may be incorrect!", e);
                    }
                } else {
                    throw new IllegalStateException("Unable to find view for tag [" + i2 + "]");
                }
            } else {
                String str = "Unable to remove a view from a view that is not a ViewGroup. ParentTag: " + i2 + " - Tag: " + i + " - Index: " + i3;
                FLog.e(TAG, str);
                throw new IllegalStateException(str);
            }
        }
    }

    public void createView(String str, int i, @Nullable ReadableMap readableMap, @Nullable StateWrapper stateWrapper, @Nullable EventEmitterWrapper eventEmitterWrapper, boolean z) {
        if (!isStopped()) {
            if (getNullableViewState(i) != null) {
                String str2 = TAG;
                ReactSoftExceptionLogger.logSoftException(str2, new ReactNoCrashSoftException("Cannot CREATE view with tag [" + i + "], already exists."));
                return;
            }
            createViewUnsafe(str, i, readableMap, stateWrapper, eventEmitterWrapper, z);
        }
    }

    public void createViewUnsafe(String str, int i, @Nullable ReadableMap readableMap, @Nullable StateWrapper stateWrapper, @Nullable EventEmitterWrapper eventEmitterWrapper, boolean z) {
        View view;
        ViewManager viewManager;
        ReactStylesDiffMap reactStylesDiffMap = readableMap != null ? new ReactStylesDiffMap(readableMap) : null;
        if (z) {
            viewManager = this.mViewManagerRegistry.get(str);
            view = viewManager.createView(i, this.mThemedReactContext, reactStylesDiffMap, stateWrapper, this.mJSResponderHandler);
        } else {
            viewManager = null;
            view = null;
        }
        ViewState viewState = new ViewState(i, view, viewManager);
        viewState.mCurrentProps = reactStylesDiffMap;
        viewState.mStateWrapper = stateWrapper;
        viewState.mEventEmitter = eventEmitterWrapper;
        this.mTagToViewState.put(Integer.valueOf(i), viewState);
    }

    public void updateProps(int i, ReadableMap readableMap) {
        if (!isStopped()) {
            ViewState viewState = getViewState(i);
            viewState.mCurrentProps = new ReactStylesDiffMap(readableMap);
            View view = viewState.mView;
            if (view != null) {
                ((ViewManager) Assertions.assertNotNull(viewState.mViewManager)).updateProperties(view, viewState.mCurrentProps);
                return;
            }
            throw new IllegalStateException("Unable to find view for tag [" + i + "]");
        }
    }

    @Deprecated
    public void receiveCommand(int i, int i2, @Nullable ReadableArray readableArray) {
        if (!isStopped()) {
            ViewState nullableViewState = getNullableViewState(i);
            if (nullableViewState == null) {
                throw new RetryableMountingLayerException("Unable to find viewState for tag: [" + i + "] for commandId: " + i2);
            } else if (nullableViewState.mViewManager == null) {
                throw new RetryableMountingLayerException("Unable to find viewManager for tag " + i);
            } else if (nullableViewState.mView != null) {
                nullableViewState.mViewManager.receiveCommand(nullableViewState.mView, i2, readableArray);
            } else {
                throw new RetryableMountingLayerException("Unable to find viewState view for tag " + i);
            }
        }
    }

    public void receiveCommand(int i, String str, @Nullable ReadableArray readableArray) {
        if (!isStopped()) {
            ViewState nullableViewState = getNullableViewState(i);
            if (nullableViewState == null) {
                throw new RetryableMountingLayerException("Unable to find viewState for tag: " + i + " for commandId: " + str);
            } else if (nullableViewState.mViewManager == null) {
                throw new RetryableMountingLayerException("Unable to find viewState manager for tag " + i);
            } else if (nullableViewState.mView != null) {
                nullableViewState.mViewManager.receiveCommand(nullableViewState.mView, str, readableArray);
            } else {
                throw new RetryableMountingLayerException("Unable to find viewState view for tag " + i);
            }
        }
    }

    public void sendAccessibilityEvent(int i, int i2) {
        if (!isStopped()) {
            ViewState viewState = getViewState(i);
            if (viewState.mViewManager == null) {
                throw new RetryableMountingLayerException("Unable to find viewState manager for tag " + i);
            } else if (viewState.mView != null) {
                viewState.mView.sendAccessibilityEvent(i2);
            } else {
                throw new RetryableMountingLayerException("Unable to find viewState view for tag " + i);
            }
        }
    }

    public void updateLayout(int i, int i2, int i3, int i4, int i5, int i6) {
        if (!isStopped()) {
            ViewState viewState = getViewState(i);
            if (!viewState.mIsRoot) {
                View view = viewState.mView;
                if (view != null) {
                    view.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
                    ViewParent parent = view.getParent();
                    if (parent instanceof RootView) {
                        parent.requestLayout();
                    }
                    view.layout(i2, i3, i4 + i2, i5 + i3);
                    int i7 = i6 == 0 ? 4 : 0;
                    if (view.getVisibility() != i7) {
                        view.setVisibility(i7);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("Unable to find View for tag: " + i);
            }
        }
    }

    public void updatePadding(int i, int i2, int i3, int i4, int i5) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState viewState = getViewState(i);
            if (!viewState.mIsRoot) {
                View view = viewState.mView;
                if (view != null) {
                    ViewManager viewManager = viewState.mViewManager;
                    if (viewManager != null) {
                        viewManager.setPadding(view, i2, i3, i4, i5);
                        return;
                    }
                    throw new IllegalStateException("Unable to find ViewManager for view: " + viewState);
                }
                throw new IllegalStateException("Unable to find View for tag: " + i);
            }
        }
    }

    public void updateState(int i, @Nullable StateWrapper stateWrapper) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState viewState = getViewState(i);
            StateWrapper stateWrapper2 = viewState.mStateWrapper;
            viewState.mStateWrapper = stateWrapper;
            ViewManager viewManager = viewState.mViewManager;
            if (viewManager != null) {
                Object updateState = viewManager.updateState(viewState.mView, viewState.mCurrentProps, stateWrapper);
                if (updateState != null) {
                    viewManager.updateExtraData(viewState.mView, updateState);
                }
                if (stateWrapper2 != null) {
                    stateWrapper2.destroyState();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Unable to find ViewManager for tag: " + i);
        }
    }

    public void updateEventEmitter(int i, EventEmitterWrapper eventEmitterWrapper) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState viewState = this.mTagToViewState.get(Integer.valueOf(i));
            if (viewState == null) {
                viewState = new ViewState(i, (View) null, (ViewManager) null);
                this.mTagToViewState.put(Integer.valueOf(i), viewState);
            }
            EventEmitterWrapper eventEmitterWrapper2 = viewState.mEventEmitter;
            viewState.mEventEmitter = eventEmitterWrapper;
            if (eventEmitterWrapper2 != eventEmitterWrapper && eventEmitterWrapper2 != null) {
                eventEmitterWrapper2.destroy();
            }
        }
    }

    public synchronized void setJSResponder(int i, int i2, boolean z) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            if (!z) {
                this.mJSResponderHandler.setJSResponder(i2, (ViewParent) null);
                return;
            }
            ViewState viewState = getViewState(i);
            View view = viewState.mView;
            if (i2 != i && (view instanceof ViewParent)) {
                this.mJSResponderHandler.setJSResponder(i2, (ViewParent) view);
            } else if (view == null) {
                SoftAssertions.assertUnreachable("Cannot find view for tag [" + i + "].");
            } else {
                if (viewState.mIsRoot) {
                    SoftAssertions.assertUnreachable("Cannot block native responder on [" + i + "] that is a root view");
                }
                this.mJSResponderHandler.setJSResponder(i2, view.getParent());
            }
        }
    }

    /* access modifiers changed from: private */
    public void onViewStateDeleted(ViewState viewState) {
        if (viewState.mStateWrapper != null) {
            viewState.mStateWrapper.destroyState();
            viewState.mStateWrapper = null;
        }
        if (viewState.mEventEmitter != null) {
            viewState.mEventEmitter.destroy();
            viewState.mEventEmitter = null;
        }
        ViewManager viewManager = viewState.mViewManager;
        if (!viewState.mIsRoot && viewManager != null) {
            viewManager.onDropViewInstance(viewState.mView);
        }
    }

    public void deleteView(int i) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState nullableViewState = getNullableViewState(i);
            if (nullableViewState == null) {
                String str = MountingManager.TAG;
                ReactSoftExceptionLogger.logSoftException(str, new IllegalStateException("Unable to find viewState for tag: " + i + " for deleteView"));
                return;
            }
            this.mTagToViewState.remove(Integer.valueOf(i));
            onViewStateDeleted(nullableViewState);
        }
    }

    public void preallocateView(String str, int i, @Nullable ReadableMap readableMap, @Nullable StateWrapper stateWrapper, @Nullable EventEmitterWrapper eventEmitterWrapper, boolean z) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            if (getNullableViewState(i) != null) {
                String str2 = TAG;
                ReactSoftExceptionLogger.logSoftException(str2, new IllegalStateException("Cannot Preallocate view with tag [" + i + "], already exists."));
                return;
            }
            createViewUnsafe(str, i, readableMap, stateWrapper, eventEmitterWrapper, z);
        }
    }

    @Nullable
    public EventEmitterWrapper getEventEmitter(int i) {
        ViewState nullableViewState = getNullableViewState(i);
        if (nullableViewState == null) {
            return null;
        }
        return nullableViewState.mEventEmitter;
    }

    public View getView(int i) {
        View view;
        ViewState nullableViewState = getNullableViewState(i);
        if (nullableViewState == null) {
            view = null;
        } else {
            view = nullableViewState.mView;
        }
        if (view != null) {
            return view;
        }
        throw new IllegalViewOperationException("Trying to resolve view with tag " + i + " which doesn't exist");
    }

    private ViewState getViewState(int i) {
        ViewState viewState = this.mTagToViewState.get(Integer.valueOf(i));
        if (viewState != null) {
            return viewState;
        }
        throw new RetryableMountingLayerException("Unable to find viewState for tag " + i);
    }

    @Nullable
    private ViewState getNullableViewState(int i) {
        ConcurrentHashMap<Integer, ViewState> concurrentHashMap = this.mTagToViewState;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(Integer.valueOf(i));
    }

    private static ViewGroupManager<ViewGroup> getViewGroupManager(ViewState viewState) {
        if (viewState.mViewManager != null) {
            return (ViewGroupManager) viewState.mViewManager;
        }
        throw new IllegalStateException("Unable to find ViewManager for view: " + viewState);
    }

    private static class ViewState {
        @Nullable
        public ReadableMap mCurrentLocalData;
        @Nullable
        public ReactStylesDiffMap mCurrentProps;
        @Nullable
        public EventEmitterWrapper mEventEmitter;
        final boolean mIsRoot;
        final int mReactTag;
        @Nullable
        public StateWrapper mStateWrapper;
        @Nullable
        final View mView;
        @Nullable
        final ViewManager mViewManager;

        private ViewState(int i, @Nullable View view, @Nullable ViewManager viewManager) {
            this(i, view, viewManager, false);
        }

        private ViewState(int i, @Nullable View view, ViewManager viewManager, boolean z) {
            this.mCurrentProps = null;
            this.mCurrentLocalData = null;
            this.mStateWrapper = null;
            this.mEventEmitter = null;
            this.mReactTag = i;
            this.mView = view;
            this.mIsRoot = z;
            this.mViewManager = viewManager;
        }

        public String toString() {
            boolean z = this.mViewManager == null;
            return "ViewState [" + this.mReactTag + "] - isRoot: " + this.mIsRoot + " - props: " + this.mCurrentProps + " - localData: " + this.mCurrentLocalData + " - viewManager: " + this.mViewManager + " - isLayoutOnly: " + z;
        }
    }
}
