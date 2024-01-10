package io.sentry;

import java.util.concurrent.Future;

interface ISentryExecutorService {
    void close(long j);

    Future<?> submit(Runnable runnable);
}
