package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.util.Objects;

public final class TransactionContext extends SpanContext {
    private final String name;
    private Boolean parentSampled;

    public static TransactionContext fromSentryTrace(String str, SentryTraceHeader sentryTraceHeader) {
        return new TransactionContext(str, sentryTraceHeader.getTraceId(), new SpanId(), sentryTraceHeader.getSpanId(), sentryTraceHeader.isSampled());
    }

    public TransactionContext(String str) {
        this.name = (String) Objects.requireNonNull(str, "name is required");
        this.parentSampled = null;
    }

    public TransactionContext(String str, Boolean bool) {
        this.name = (String) Objects.requireNonNull(str, "name is required");
        setSampled(bool);
    }

    private TransactionContext(String str, SentryId sentryId, SpanId spanId, SpanId spanId2, Boolean bool) {
        super(sentryId, spanId, spanId2, (Boolean) null);
        this.name = (String) Objects.requireNonNull(str, "name is required");
        this.parentSampled = bool;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getParentSampled() {
        return this.parentSampled;
    }

    public void setParentSampled(Boolean bool) {
        this.parentSampled = bool;
    }
}
