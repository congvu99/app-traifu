package io.sentry.android.core;

interface IHandler {
    Thread getThread();

    void post(Runnable runnable);
}
