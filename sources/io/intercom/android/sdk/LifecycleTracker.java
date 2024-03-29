package io.intercom.android.sdk;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Looper;
import com.intercom.commons.utilities.TimeProvider;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.api.DeDuper;
import io.intercom.android.sdk.api.UserUpdater;
import io.intercom.android.sdk.errorreporting.ErrorReporter;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.MetricsStore;
import io.intercom.android.sdk.push.SystemNotificationManager;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.utilities.SimpleActivityLifecycleCallbacks;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class LifecycleTracker extends SimpleActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private final DeDuper deDuper;
    private final ErrorReporter errorReporter;
    private final ActivityLifecycleHandler handler;
    private final MetricsStore metricsStore;
    private final ResetManager resetManager;
    private final Set<Integer> startedActivities = new HashSet();
    final Store<State> store;
    private final SystemNotificationManager systemNotificationManager;
    private final TimeProvider timeProvider;
    private final Twig twig = LumberMill.getLogger();
    private final UserUpdater userUpdater;

    static LifecycleTracker create(SystemNotificationManager systemNotificationManager2, MetricsStore metricsStore2, ErrorReporter errorReporter2, DeDuper deDuper2, TimeProvider timeProvider2, UserUpdater userUpdater2, Store<State> store2, ResetManager resetManager2, float f) {
        Store<State> store3 = store2;
        return new LifecycleTracker(systemNotificationManager2, metricsStore2, errorReporter2, deDuper2, timeProvider2, userUpdater2, store3, resetManager2, new ActivityLifecycleHandler(Looper.getMainLooper(), store3, f));
    }

    LifecycleTracker(SystemNotificationManager systemNotificationManager2, MetricsStore metricsStore2, ErrorReporter errorReporter2, DeDuper deDuper2, TimeProvider timeProvider2, UserUpdater userUpdater2, Store<State> store2, ResetManager resetManager2, ActivityLifecycleHandler activityLifecycleHandler) {
        this.systemNotificationManager = systemNotificationManager2;
        this.metricsStore = metricsStore2;
        this.errorReporter = errorReporter2;
        this.deDuper = deDuper2;
        this.timeProvider = timeProvider2;
        this.userUpdater = userUpdater2;
        this.store = store2;
        this.resetManager = resetManager2;
        this.handler = activityLifecycleHandler;
    }

    public void onActivityStarted(Activity activity) {
        registerActivity(activity);
        if (((Boolean) this.store.select(Selectors.APP_IS_BACKGROUNDED)).booleanValue()) {
            this.store.dispatch(Actions.appEnteredForeground(this.timeProvider.currentTimeMillis()));
            this.metricsStore.loadAndSendMetrics();
            this.errorReporter.sendSavedReport();
            this.systemNotificationManager.clear();
        }
    }

    public void onActivityResumed(Activity activity) {
        this.handler.removeMessages(1, activity);
        this.handler.sendMessage(ActivityLifecycleHandler.getMessage(0, activity));
    }

    public void onActivityPaused(Activity activity) {
        this.handler.sendMessage(ActivityLifecycleHandler.getMessage(2, activity));
    }

    public void onActivityStopped(Activity activity) {
        unregisterActivity(activity);
        this.handler.removeMessages(1, activity);
        this.handler.sendMessage(ActivityLifecycleHandler.getMessage(3, activity));
        if (hasApplicationBecomeBackgrounded(activity)) {
            if (this.resetManager.isSoftReset()) {
                this.resetManager.hardReset();
            }
            this.store.dispatch(Actions.appEnteredBackground(this.timeProvider.currentTimeMillis()));
            this.deDuper.reset();
            this.metricsStore.loadAndSendMetrics();
        }
    }

    /* access modifiers changed from: package-private */
    public void registerActivities(Collection<Integer> collection) {
        this.startedActivities.addAll(collection);
    }

    private void registerActivity(Activity activity) {
        this.startedActivities.add(Integer.valueOf(System.identityHashCode(activity)));
        Twig twig2 = this.twig;
        twig2.i("Started observing " + activity, new Object[0]);
    }

    private void unregisterActivity(Activity activity) {
        this.startedActivities.remove(Integer.valueOf(System.identityHashCode(activity)));
        Twig twig2 = this.twig;
        twig2.i("Stopped observing " + activity, new Object[0]);
    }

    private boolean hasApplicationBecomeBackgrounded(Activity activity) {
        return isApplicationInBackground(activity) && !((Boolean) this.store.select(Selectors.APP_IS_BACKGROUNDED)).booleanValue();
    }

    /* access modifiers changed from: package-private */
    public boolean isApplicationInBackground(Activity activity) {
        return isScreenLocked(activity) || (this.startedActivities.isEmpty() && !activity.isChangingConfigurations());
    }

    private static boolean isScreenLocked(Context context) {
        return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }
}
