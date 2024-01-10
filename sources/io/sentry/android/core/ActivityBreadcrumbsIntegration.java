package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.brentvatne.react.ReactVideoViewManager;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.sentry.Breadcrumb;
import io.sentry.IHub;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.util.Objects;
import java.io.Closeable;
import java.io.IOException;

public final class ActivityBreadcrumbsIntegration implements Integration, Closeable, Application.ActivityLifecycleCallbacks {
    private final Application application;
    private IHub hub;
    private SentryAndroidOptions options;

    public ActivityBreadcrumbsIntegration(Application application2) {
        this.application = (Application) Objects.requireNonNull(application2, "Application is required");
    }

    public void register(IHub iHub, SentryOptions sentryOptions) {
        this.options = (SentryAndroidOptions) Objects.requireNonNull(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        this.hub = (IHub) Objects.requireNonNull(iHub, "Hub is required");
        this.options.getLogger().log(SentryLevel.DEBUG, "ActivityBreadcrumbsIntegration enabled: %s", Boolean.valueOf(this.options.isEnableActivityLifecycleBreadcrumbs()));
        if (this.options.isEnableActivityLifecycleBreadcrumbs()) {
            this.application.registerActivityLifecycleCallbacks(this);
            sentryOptions.getLogger().log(SentryLevel.DEBUG, "ActivityBreadcrumbsIntegration installed.", new Object[0]);
        }
    }

    public void close() throws IOException {
        this.application.unregisterActivityLifecycleCallbacks(this);
        SentryAndroidOptions sentryAndroidOptions = this.options;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, "ActivityBreadcrumbsIntegration removed.", new Object[0]);
        }
    }

    private void addBreadcrumb(Activity activity, String str) {
        if (this.hub != null) {
            Breadcrumb breadcrumb = new Breadcrumb();
            breadcrumb.setType(NotificationCompat.CATEGORY_NAVIGATION);
            breadcrumb.setData("state", str);
            breadcrumb.setData("screen", activity.getClass().getSimpleName());
            breadcrumb.setCategory("ui.lifecycle");
            breadcrumb.setLevel(SentryLevel.INFO);
            this.hub.addBreadcrumb(breadcrumb);
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        addBreadcrumb(activity, "created");
    }

    public void onActivityStarted(Activity activity) {
        addBreadcrumb(activity, MetricTracker.Action.STARTED);
    }

    public void onActivityResumed(Activity activity) {
        addBreadcrumb(activity, "resumed");
    }

    public void onActivityPaused(Activity activity) {
        addBreadcrumb(activity, ReactVideoViewManager.PROP_PAUSED);
    }

    public void onActivityStopped(Activity activity) {
        addBreadcrumb(activity, "stopped");
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        addBreadcrumb(activity, "saveInstanceState");
    }

    public void onActivityDestroyed(Activity activity) {
        addBreadcrumb(activity, "destroyed");
    }
}
