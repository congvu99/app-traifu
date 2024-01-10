package io.sentry;

import io.sentry.UncaughtExceptionHandler;
import io.sentry.exception.ExceptionMechanismException;
import io.sentry.hints.DiskFlushNotification;
import io.sentry.hints.Flushable;
import io.sentry.hints.SessionEnd;
import io.sentry.protocol.Mechanism;
import io.sentry.util.Objects;
import java.io.Closeable;
import java.lang.Thread;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class UncaughtExceptionHandlerIntegration implements Integration, Thread.UncaughtExceptionHandler, Closeable {
    private Thread.UncaughtExceptionHandler defaultExceptionHandler;
    private IHub hub;
    private SentryOptions options;
    private boolean registered;
    private final UncaughtExceptionHandler threadAdapter;

    public UncaughtExceptionHandlerIntegration() {
        this(UncaughtExceptionHandler.Adapter.getInstance());
    }

    UncaughtExceptionHandlerIntegration(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.registered = false;
        this.threadAdapter = (UncaughtExceptionHandler) Objects.requireNonNull(uncaughtExceptionHandler, "threadAdapter is required.");
    }

    public final void register(IHub iHub, SentryOptions sentryOptions) {
        if (this.registered) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, "Attempt to register a UncaughtExceptionHandlerIntegration twice.", new Object[0]);
            return;
        }
        this.registered = true;
        this.hub = (IHub) Objects.requireNonNull(iHub, "Hub is required");
        SentryOptions sentryOptions2 = (SentryOptions) Objects.requireNonNull(sentryOptions, "SentryOptions is required");
        this.options = sentryOptions2;
        sentryOptions2.getLogger().log(SentryLevel.DEBUG, "UncaughtExceptionHandlerIntegration enabled: %s", Boolean.valueOf(this.options.isEnableUncaughtExceptionHandler()));
        if (this.options.isEnableUncaughtExceptionHandler()) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = this.threadAdapter.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                ILogger logger = this.options.getLogger();
                SentryLevel sentryLevel = SentryLevel.DEBUG;
                logger.log(sentryLevel, "default UncaughtExceptionHandler class='" + defaultUncaughtExceptionHandler.getClass().getName() + "'", new Object[0]);
                this.defaultExceptionHandler = defaultUncaughtExceptionHandler;
            }
            this.threadAdapter.setDefaultUncaughtExceptionHandler(this);
            this.options.getLogger().log(SentryLevel.DEBUG, "UncaughtExceptionHandlerIntegration installed.", new Object[0]);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        SentryOptions sentryOptions = this.options;
        if (sentryOptions != null && this.hub != null) {
            sentryOptions.getLogger().log(SentryLevel.INFO, "Uncaught exception received.", new Object[0]);
            try {
                UncaughtExceptionHint uncaughtExceptionHint = new UncaughtExceptionHint(this.options.getFlushTimeoutMillis(), this.options.getLogger());
                SentryEvent sentryEvent = new SentryEvent(getUnhandledThrowable(thread, th));
                sentryEvent.setLevel(SentryLevel.FATAL);
                this.hub.captureEvent(sentryEvent, uncaughtExceptionHint);
                if (!uncaughtExceptionHint.waitFlush()) {
                    this.options.getLogger().log(SentryLevel.WARNING, "Timed out waiting to flush event to disk before crashing. Event: %s", sentryEvent.getEventId());
                }
            } catch (Exception e) {
                this.options.getLogger().log(SentryLevel.ERROR, "Error sending uncaught exception to Sentry.", (Throwable) e);
            }
            if (this.defaultExceptionHandler != null) {
                this.options.getLogger().log(SentryLevel.INFO, "Invoking inner uncaught exception handler.", new Object[0]);
                this.defaultExceptionHandler.uncaughtException(thread, th);
            }
        }
    }

    static Throwable getUnhandledThrowable(Thread thread, Throwable th) {
        Mechanism mechanism = new Mechanism();
        mechanism.setHandled(false);
        mechanism.setType("UncaughtExceptionHandler");
        return new ExceptionMechanismException(mechanism, th, thread);
    }

    public void close() {
        if (this.defaultExceptionHandler != null && this == this.threadAdapter.getDefaultUncaughtExceptionHandler()) {
            this.threadAdapter.setDefaultUncaughtExceptionHandler(this.defaultExceptionHandler);
            SentryOptions sentryOptions = this.options;
            if (sentryOptions != null) {
                sentryOptions.getLogger().log(SentryLevel.DEBUG, "UncaughtExceptionHandlerIntegration removed.", new Object[0]);
            }
        }
    }

    private static final class UncaughtExceptionHint implements DiskFlushNotification, Flushable, SessionEnd {
        private final long flushTimeoutMillis;
        private final CountDownLatch latch = new CountDownLatch(1);
        private final ILogger logger;

        UncaughtExceptionHint(long j, ILogger iLogger) {
            this.flushTimeoutMillis = j;
            this.logger = iLogger;
        }

        public boolean waitFlush() {
            try {
                return this.latch.await(this.flushTimeoutMillis, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                this.logger.log(SentryLevel.ERROR, "Exception while awaiting for flush in UncaughtExceptionHint", (Throwable) e);
                return false;
            }
        }

        public void markFlushed() {
            this.latch.countDown();
        }
    }
}
