package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.GlideExperiments;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RequestManagerRetriever implements Handler.Callback {
    private static final RequestManagerFactory DEFAULT_FACTORY = new RequestManagerFactory() {
        public RequestManager build(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
            return new RequestManager(glide, lifecycle, requestManagerTreeNode, context);
        }
    };
    private static final String FRAGMENT_INDEX_KEY = "key";
    static final String FRAGMENT_TAG = "com.bumptech.glide.manager";
    private static final int ID_REMOVE_FRAGMENT_MANAGER = 1;
    private static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER = 2;
    private static final String TAG = "RMRetriever";
    private volatile RequestManager applicationManager;
    private final RequestManagerFactory factory;
    private final FrameWaiter frameWaiter;
    private final Handler handler;
    final Map<FragmentManager, RequestManagerFragment> pendingRequestManagerFragments = new HashMap();
    final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> pendingSupportRequestManagerFragments = new HashMap();
    private final Bundle tempBundle = new Bundle();
    private final ArrayMap<View, Fragment> tempViewToFragment = new ArrayMap<>();
    private final ArrayMap<View, androidx.fragment.app.Fragment> tempViewToSupportFragment = new ArrayMap<>();

    public interface RequestManagerFactory {
        RequestManager build(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context);
    }

    public RequestManagerRetriever(RequestManagerFactory requestManagerFactory, GlideExperiments glideExperiments) {
        this.factory = requestManagerFactory == null ? DEFAULT_FACTORY : requestManagerFactory;
        this.handler = new Handler(Looper.getMainLooper(), this);
        this.frameWaiter = buildFrameWaiter(glideExperiments);
    }

    private static FrameWaiter buildFrameWaiter(GlideExperiments glideExperiments) {
        if (!HardwareConfigState.HARDWARE_BITMAPS_SUPPORTED || !HardwareConfigState.BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED) {
            return new DoNothingFirstFrameWaiter();
        }
        if (glideExperiments.isEnabled(GlideBuilder.WaitForFramesAfterTrimMemory.class)) {
            return new FirstFrameAndAfterTrimMemoryWaiter();
        }
        return new FirstFrameWaiter();
    }

    private RequestManager getApplicationManager(Context context) {
        if (this.applicationManager == null) {
            synchronized (this) {
                if (this.applicationManager == null) {
                    this.applicationManager = this.factory.build(Glide.get(context.getApplicationContext()), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), context.getApplicationContext());
                }
            }
        }
        return this.applicationManager;
    }

    public RequestManager get(Context context) {
        if (context != null) {
            if (Util.isOnMainThread() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return get((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return get((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return get(contextWrapper.getBaseContext());
                    }
                }
            }
            return getApplicationManager(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public RequestManager get(FragmentActivity fragmentActivity) {
        if (Util.isOnBackgroundThread()) {
            return get(fragmentActivity.getApplicationContext());
        }
        assertNotDestroyed(fragmentActivity);
        this.frameWaiter.registerSelf(fragmentActivity);
        return supportFragmentGet(fragmentActivity, fragmentActivity.getSupportFragmentManager(), (androidx.fragment.app.Fragment) null, isActivityVisible(fragmentActivity));
    }

    public RequestManager get(androidx.fragment.app.Fragment fragment) {
        Preconditions.checkNotNull(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (Util.isOnBackgroundThread()) {
            return get(fragment.getContext().getApplicationContext());
        }
        if (fragment.getActivity() != null) {
            this.frameWaiter.registerSelf(fragment.getActivity());
        }
        return supportFragmentGet(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    public RequestManager get(Activity activity) {
        if (Util.isOnBackgroundThread()) {
            return get(activity.getApplicationContext());
        }
        if (activity instanceof FragmentActivity) {
            return get((FragmentActivity) activity);
        }
        assertNotDestroyed(activity);
        this.frameWaiter.registerSelf(activity);
        return fragmentGet(activity, activity.getFragmentManager(), (Fragment) null, isActivityVisible(activity));
    }

    public RequestManager get(View view) {
        if (Util.isOnBackgroundThread()) {
            return get(view.getContext().getApplicationContext());
        }
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity findActivity = findActivity(view.getContext());
        if (findActivity == null) {
            return get(view.getContext().getApplicationContext());
        }
        if (findActivity instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) findActivity;
            androidx.fragment.app.Fragment findSupportFragment = findSupportFragment(view, fragmentActivity);
            return findSupportFragment != null ? get(findSupportFragment) : get(fragmentActivity);
        }
        Fragment findFragment = findFragment(view, findActivity);
        if (findFragment == null) {
            return get(findActivity);
        }
        return get(findFragment);
    }

    private static void findAllSupportFragmentsWithViews(Collection<androidx.fragment.app.Fragment> collection, Map<View, androidx.fragment.app.Fragment> map) {
        if (collection != null) {
            for (androidx.fragment.app.Fragment next : collection) {
                if (!(next == null || next.getView() == null)) {
                    map.put(next.getView(), next);
                    findAllSupportFragmentsWithViews(next.getChildFragmentManager().getFragments(), map);
                }
            }
        }
    }

    private androidx.fragment.app.Fragment findSupportFragment(View view, FragmentActivity fragmentActivity) {
        this.tempViewToSupportFragment.clear();
        findAllSupportFragmentsWithViews(fragmentActivity.getSupportFragmentManager().getFragments(), this.tempViewToSupportFragment);
        View findViewById = fragmentActivity.findViewById(16908290);
        androidx.fragment.app.Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.tempViewToSupportFragment.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.tempViewToSupportFragment.clear();
        return fragment;
    }

    @Deprecated
    private Fragment findFragment(View view, Activity activity) {
        this.tempViewToFragment.clear();
        findAllFragmentsWithViews(activity.getFragmentManager(), this.tempViewToFragment);
        View findViewById = activity.findViewById(16908290);
        Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.tempViewToFragment.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.tempViewToFragment.clear();
        return fragment;
    }

    @Deprecated
    private void findAllFragmentsWithViews(FragmentManager fragmentManager, ArrayMap<View, Fragment> arrayMap) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (Fragment next : fragmentManager.getFragments()) {
                if (next.getView() != null) {
                    arrayMap.put(next.getView(), next);
                    findAllFragmentsWithViews(next.getChildFragmentManager(), arrayMap);
                }
            }
            return;
        }
        findAllFragmentsWithViewsPreO(fragmentManager, arrayMap);
    }

    @Deprecated
    private void findAllFragmentsWithViewsPreO(FragmentManager fragmentManager, ArrayMap<View, Fragment> arrayMap) {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            this.tempBundle.putInt("key", i);
            Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.tempBundle, "key");
            } catch (Exception unused) {
            }
            if (fragment != null) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    if (Build.VERSION.SDK_INT >= 17) {
                        findAllFragmentsWithViews(fragment.getChildFragmentManager(), arrayMap);
                    }
                }
                i = i2;
            } else {
                return;
            }
        }
    }

    private static Activity findActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return findActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private static void assertNotDestroyed(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @Deprecated
    public RequestManager get(Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        } else if (Util.isOnBackgroundThread() || Build.VERSION.SDK_INT < 17) {
            return get(fragment.getActivity().getApplicationContext());
        } else {
            if (fragment.getActivity() != null) {
                this.frameWaiter.registerSelf(fragment.getActivity());
            }
            return fragmentGet(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
        }
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public RequestManagerFragment getRequestManagerFragment(Activity activity) {
        return getRequestManagerFragment(activity.getFragmentManager(), (Fragment) null);
    }

    private RequestManagerFragment getRequestManagerFragment(FragmentManager fragmentManager, Fragment fragment) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (requestManagerFragment != null) {
            return requestManagerFragment;
        }
        RequestManagerFragment requestManagerFragment2 = this.pendingRequestManagerFragments.get(fragmentManager);
        if (requestManagerFragment2 != null) {
            return requestManagerFragment2;
        }
        RequestManagerFragment requestManagerFragment3 = new RequestManagerFragment();
        requestManagerFragment3.setParentFragmentHint(fragment);
        this.pendingRequestManagerFragments.put(fragmentManager, requestManagerFragment3);
        fragmentManager.beginTransaction().add(requestManagerFragment3, FRAGMENT_TAG).commitAllowingStateLoss();
        this.handler.obtainMessage(1, fragmentManager).sendToTarget();
        return requestManagerFragment3;
    }

    @Deprecated
    private RequestManager fragmentGet(Context context, FragmentManager fragmentManager, Fragment fragment, boolean z) {
        RequestManagerFragment requestManagerFragment = getRequestManagerFragment(fragmentManager, fragment);
        RequestManager requestManager = requestManagerFragment.getRequestManager();
        if (requestManager == null) {
            requestManager = this.factory.build(Glide.get(context), requestManagerFragment.getGlideLifecycle(), requestManagerFragment.getRequestManagerTreeNode(), context);
            if (z) {
                requestManager.onStart();
            }
            requestManagerFragment.setRequestManager(requestManager);
        }
        return requestManager;
    }

    /* access modifiers changed from: package-private */
    public SupportRequestManagerFragment getSupportRequestManagerFragment(androidx.fragment.app.FragmentManager fragmentManager) {
        return getSupportRequestManagerFragment(fragmentManager, (androidx.fragment.app.Fragment) null);
    }

    private static boolean isActivityVisible(Context context) {
        Activity findActivity = findActivity(context);
        return findActivity == null || !findActivity.isFinishing();
    }

    private SupportRequestManagerFragment getSupportRequestManagerFragment(androidx.fragment.app.FragmentManager fragmentManager, androidx.fragment.app.Fragment fragment) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (supportRequestManagerFragment != null) {
            return supportRequestManagerFragment;
        }
        SupportRequestManagerFragment supportRequestManagerFragment2 = this.pendingSupportRequestManagerFragments.get(fragmentManager);
        if (supportRequestManagerFragment2 != null) {
            return supportRequestManagerFragment2;
        }
        SupportRequestManagerFragment supportRequestManagerFragment3 = new SupportRequestManagerFragment();
        supportRequestManagerFragment3.setParentFragmentHint(fragment);
        this.pendingSupportRequestManagerFragments.put(fragmentManager, supportRequestManagerFragment3);
        fragmentManager.beginTransaction().add((androidx.fragment.app.Fragment) supportRequestManagerFragment3, FRAGMENT_TAG).commitAllowingStateLoss();
        this.handler.obtainMessage(2, fragmentManager).sendToTarget();
        return supportRequestManagerFragment3;
    }

    private RequestManager supportFragmentGet(Context context, androidx.fragment.app.FragmentManager fragmentManager, androidx.fragment.app.Fragment fragment, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = getSupportRequestManagerFragment(fragmentManager, fragment);
        RequestManager requestManager = supportRequestManagerFragment.getRequestManager();
        if (requestManager == null) {
            requestManager = this.factory.build(Glide.get(context), supportRequestManagerFragment.getGlideLifecycle(), supportRequestManagerFragment.getRequestManagerTreeNode(), context);
            if (z) {
                requestManager.onStart();
            }
            supportRequestManagerFragment.setRequestManager(requestManager);
        }
        return requestManager;
    }

    public boolean handleMessage(Message message) {
        Object obj;
        Object obj2;
        Object obj3;
        int i = message.what;
        Object obj4 = null;
        boolean z = true;
        if (i == 1) {
            obj3 = (FragmentManager) message.obj;
            obj2 = this.pendingRequestManagerFragments.remove(obj3);
        } else if (i != 2) {
            z = false;
            obj = null;
            if (z && obj4 == null && Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Failed to remove expected request manager fragment, manager: " + obj);
            }
            return z;
        } else {
            obj3 = (androidx.fragment.app.FragmentManager) message.obj;
            obj2 = this.pendingSupportRequestManagerFragments.remove(obj3);
        }
        Object obj5 = obj3;
        obj4 = obj2;
        obj = obj5;
        Log.w(TAG, "Failed to remove expected request manager fragment, manager: " + obj);
        return z;
    }
}
