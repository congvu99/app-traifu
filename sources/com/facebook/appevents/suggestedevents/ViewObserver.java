package com.facebook.appevents.suggestedevents;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import com.facebook.appevents.codeless.internal.SensitiveUserDataUtils;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

final class ViewObserver implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final int MAX_TEXT_LENGTH = 300;
    private static final String TAG = ViewObserver.class.getCanonicalName();
    private static final Map<Integer, ViewObserver> observers = new HashMap();
    private WeakReference<Activity> activityWeakReference;
    private AtomicBoolean isTracking = new AtomicBoolean(false);
    private final Handler uiThreadHandler = new Handler(Looper.getMainLooper());

    static /* synthetic */ WeakReference access$000(ViewObserver viewObserver) {
        Class<ViewObserver> cls = ViewObserver.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return viewObserver.activityWeakReference;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static void startTrackingActivity(Activity activity) {
        Class<ViewObserver> cls = ViewObserver.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                int hashCode = activity.hashCode();
                if (!observers.containsKey(Integer.valueOf(hashCode))) {
                    ViewObserver viewObserver = new ViewObserver(activity);
                    observers.put(Integer.valueOf(hashCode), viewObserver);
                    viewObserver.startTracking();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    static void stopTrackingActivity(Activity activity) {
        Class<ViewObserver> cls = ViewObserver.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                int hashCode = activity.hashCode();
                if (observers.containsKey(Integer.valueOf(hashCode))) {
                    observers.remove(Integer.valueOf(hashCode));
                    observers.get(Integer.valueOf(hashCode)).stopTracking();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private ViewObserver(Activity activity) {
        this.activityWeakReference = new WeakReference<>(activity);
    }

    private void startTracking() {
        View rootView;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (!this.isTracking.getAndSet(true) && (rootView = AppEventUtility.getRootView((Activity) this.activityWeakReference.get())) != null) {
                    ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.addOnGlobalLayoutListener(this);
                        process();
                        Activity activity = (Activity) this.activityWeakReference.get();
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private void stopTracking() {
        View rootView;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (this.isTracking.getAndSet(false) && (rootView = AppEventUtility.getRootView((Activity) this.activityWeakReference.get())) != null) {
                    ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        if (Build.VERSION.SDK_INT < 16) {
                            viewTreeObserver.removeGlobalOnLayoutListener(this);
                        } else {
                            viewTreeObserver.removeOnGlobalLayoutListener(this);
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void onGlobalLayout() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                process();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private void process() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                AnonymousClass1 r0 = new Runnable() {
                    public void run() {
                        if (!CrashShieldHandler.isObjectCrashing(this)) {
                            try {
                                View rootView = AppEventUtility.getRootView((Activity) ViewObserver.access$000(ViewObserver.this).get());
                                Activity activity = (Activity) ViewObserver.access$000(ViewObserver.this).get();
                                if (rootView == null) {
                                    return;
                                }
                                if (activity != null) {
                                    for (View next : SuggestedEventViewHierarchy.getAllClickableViews(rootView)) {
                                        if (!SensitiveUserDataUtils.isSensitiveUserData(next)) {
                                            String textOfViewRecursively = SuggestedEventViewHierarchy.getTextOfViewRecursively(next);
                                            if (!textOfViewRecursively.isEmpty() && textOfViewRecursively.length() <= 300) {
                                                ViewOnClickListener.attachListener(next, rootView, activity.getLocalClassName());
                                            }
                                        }
                                    }
                                }
                            } catch (Exception unused) {
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(th, this);
                            }
                        }
                    }
                };
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    r0.run();
                } else {
                    this.uiThreadHandler.post(r0);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
