package io.sentry.android.core;

import androidx.lifecycle.ProcessLifecycleOwner;
import io.sentry.IHub;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.util.MainThreadChecker;
import io.sentry.util.Objects;
import java.io.Closeable;
import java.io.IOException;

public final class AppLifecycleIntegration implements Integration, Closeable {
    private final IHandler handler;
    private SentryAndroidOptions options;
    LifecycleWatcher watcher;

    public AppLifecycleIntegration() {
        this(new MainLooperHandler());
    }

    AppLifecycleIntegration(IHandler iHandler) {
        this.handler = iHandler;
    }

    public void register(IHub iHub, SentryOptions sentryOptions) {
        Objects.requireNonNull(iHub, "Hub is required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) Objects.requireNonNull(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        this.options = sentryAndroidOptions;
        sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, "enableSessionTracking enabled: %s", Boolean.valueOf(this.options.isEnableSessionTracking()));
        this.options.getLogger().log(SentryLevel.DEBUG, "enableAppLifecycleBreadcrumbs enabled: %s", Boolean.valueOf(this.options.isEnableAppLifecycleBreadcrumbs()));
        if (this.options.isEnableSessionTracking() || this.options.isEnableAppLifecycleBreadcrumbs()) {
            try {
                Class.forName("androidx.lifecycle.DefaultLifecycleObserver");
                Class.forName("androidx.lifecycle.ProcessLifecycleOwner");
                if (MainThreadChecker.isMainThread()) {
                    lambda$register$0$AppLifecycleIntegration(iHub);
                } else {
                    this.handler.post(new Runnable(iHub) {
                        public final /* synthetic */ IHub f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            AppLifecycleIntegration.this.lambda$register$0$AppLifecycleIntegration(this.f$1);
                        }
                    });
                }
            } catch (ClassNotFoundException e) {
                sentryOptions.getLogger().log(SentryLevel.INFO, "androidx.lifecycle is not available, AppLifecycleIntegration won't be installed", (Throwable) e);
            } catch (IllegalStateException e2) {
                sentryOptions.getLogger().log(SentryLevel.ERROR, "AppLifecycleIntegration could not be installed", (Throwable) e2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addObserver */
    public void lambda$register$0$AppLifecycleIntegration(IHub iHub) {
        this.watcher = new LifecycleWatcher(iHub, this.options.getSessionTrackingIntervalMillis(), this.options.isEnableSessionTracking(), this.options.isEnableAppLifecycleBreadcrumbs());
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this.watcher);
        this.options.getLogger().log(SentryLevel.DEBUG, "AppLifecycleIntegration installed.", new Object[0]);
    }

    public void close() throws IOException {
        if (this.watcher != null) {
            ProcessLifecycleOwner.get().getLifecycle().removeObserver(this.watcher);
            this.watcher = null;
            SentryAndroidOptions sentryAndroidOptions = this.options;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, "AppLifecycleIntegration removed.", new Object[0]);
            }
        }
    }
}
