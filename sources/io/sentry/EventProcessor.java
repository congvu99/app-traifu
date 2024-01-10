package io.sentry;

public interface EventProcessor {
    SentryEvent process(SentryEvent sentryEvent, Object obj);
}
