package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.util.Objects;
import java.util.Date;

public final class Span extends SpanContext implements ISpan {
    private final transient IHub hub;
    private final Date startTimestamp = DateUtils.getCurrentDateTime();
    private transient Throwable throwable;
    private Date timestamp;
    private final transient SentryTransaction transaction;

    public SpanContext getSpanContext() {
        return this;
    }

    Span(SentryId sentryId, SpanId spanId, SentryTransaction sentryTransaction, IHub iHub) {
        super(sentryId, new SpanId(), spanId, sentryTransaction.isSampled());
        this.transaction = (SentryTransaction) Objects.requireNonNull(sentryTransaction, "transaction is required");
        this.hub = (IHub) Objects.requireNonNull(iHub, "hub is required");
    }

    public Date getStartTimestamp() {
        return this.startTimestamp;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public ISpan startChild(String str) {
        return startChild(str, (String) null);
    }

    public ISpan startChild(String str, String str2) {
        return this.transaction.startChild(super.getSpanId(), str, str2);
    }

    public SentryTraceHeader toSentryTrace() {
        return new SentryTraceHeader(getTraceId(), getSpanId(), getSampled());
    }

    public void finish() {
        this.timestamp = DateUtils.getCurrentDateTime();
        Throwable th = this.throwable;
        if (th != null) {
            this.hub.setSpanContext(th, this);
        }
    }

    public void finish(SpanStatus spanStatus) {
        this.status = spanStatus;
        finish();
    }

    public boolean isFinished() {
        return this.timestamp != null;
    }

    public void setThrowable(Throwable th) {
        this.throwable = th;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }
}
