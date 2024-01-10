package io.sentry.transport;

import io.sentry.ILogger;
import io.sentry.SentryLevel;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

final class QueuedThreadPoolExecutor extends ThreadPoolExecutor {
    private final AtomicInteger currentlyRunning = new AtomicInteger();
    private final ILogger logger;
    private final int maxQueueSize;

    public QueuedThreadPoolExecutor(int i, int i2, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler, ILogger iLogger) {
        super(i, i, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory, rejectedExecutionHandler);
        this.maxQueueSize = i2;
        this.logger = iLogger;
    }

    public Future<?> submit(Runnable runnable) {
        if (isSchedulingAllowed()) {
            return super.submit(runnable);
        }
        this.logger.log(SentryLevel.WARNING, "Submit cancelled", new Object[0]);
        return new CancelledFuture();
    }

    /* access modifiers changed from: protected */
    public void beforeExecute(Thread thread, Runnable runnable) {
        try {
            super.beforeExecute(thread, runnable);
        } finally {
            this.currentlyRunning.incrementAndGet();
        }
    }

    /* access modifiers changed from: protected */
    public void afterExecute(Runnable runnable, Throwable th) {
        try {
            super.afterExecute(runnable, th);
        } finally {
            this.currentlyRunning.decrementAndGet();
        }
    }

    private boolean isSchedulingAllowed() {
        return getQueue().size() + this.currentlyRunning.get() < this.maxQueueSize;
    }

    private static final class CancelledFuture<T> implements Future<T> {
        public boolean cancel(boolean z) {
            return true;
        }

        public boolean isCancelled() {
            return true;
        }

        public boolean isDone() {
            return true;
        }

        private CancelledFuture() {
        }

        public T get() {
            throw new CancellationException();
        }

        public T get(long j, TimeUnit timeUnit) {
            throw new CancellationException();
        }
    }
}
