package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.util.Objects;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class SentryTransaction extends SentryBaseEvent implements ITransaction {
    private final transient SpanContext context;
    private final transient IHub hub;
    private final List<Span> spans;
    private final Date startTimestamp;
    private Date timestamp;
    private String transaction;
    private final String type;

    SentryTransaction(String str) {
        this(str, new SpanContext(), NoOpHub.getInstance());
    }

    SentryTransaction(TransactionContext transactionContext, IHub iHub) {
        this(transactionContext.getName(), transactionContext, iHub);
    }

    public SentryTransaction(String str, SpanContext spanContext, IHub iHub) {
        this.spans = new CopyOnWriteArrayList();
        this.type = "transaction";
        this.transaction = (String) Objects.requireNonNull(str, "name is required");
        this.startTimestamp = DateUtils.getCurrentDateTime();
        this.hub = (IHub) Objects.requireNonNull(iHub, "hub is required");
        this.context = (SpanContext) Objects.requireNonNull(spanContext, "contexts is required");
    }

    public void setName(String str) {
        Objects.requireNonNull(str, "name is required");
        this.transaction = str;
    }

    public String getName() {
        return this.transaction;
    }

    public ISpan startChild(String str) {
        return startChild(str, (String) null);
    }

    public ISpan startChild(String str, String str2) {
        return startChild(getSpanId(), str, str2);
    }

    private ISpan startChild(SpanId spanId) {
        Objects.requireNonNull(spanId, "parentSpanId is required");
        Span span = new Span(getTraceId(), spanId, this, this.hub);
        this.spans.add(span);
        return span;
    }

    /* access modifiers changed from: package-private */
    public ISpan startChild(SpanId spanId, String str, String str2) {
        ISpan startChild = startChild(spanId);
        startChild.setOperation(str);
        startChild.setDescription(str2);
        return startChild;
    }

    public SentryTraceHeader toSentryTrace() {
        return new SentryTraceHeader(getTraceId(), getSpanId(), isSampled());
    }

    /* access modifiers changed from: package-private */
    public SpanId getSpanId() {
        return this.context.getSpanId();
    }

    /* access modifiers changed from: package-private */
    public SentryId getTraceId() {
        return this.context.getTraceId();
    }

    public Boolean isSampled() {
        return this.context.getSampled();
    }

    public void finish() {
        this.timestamp = DateUtils.getCurrentDateTime();
        if (this.throwable != null) {
            this.hub.setSpanContext(this.throwable, this);
        }
        getContexts().setTrace(this.context);
        this.hub.captureTransaction(this, (Object) null);
    }

    public void finish(SpanStatus spanStatus) {
        setStatus(spanStatus);
        finish();
    }

    public void setOperation(String str) {
        this.context.setOperation(str);
    }

    public String getOperation() {
        return this.context.getOperation();
    }

    public void setDescription(String str) {
        this.context.setDescription(str);
    }

    public String getDescription() {
        return this.context.getDescription();
    }

    public SpanContext getSpanContext() {
        return this.context;
    }

    public void setStatus(SpanStatus spanStatus) {
        this.context.setStatus(spanStatus);
    }

    public String getTransaction() {
        return this.transaction;
    }

    /* access modifiers changed from: package-private */
    public Date getStartTimestamp() {
        return this.startTimestamp;
    }

    /* access modifiers changed from: package-private */
    public Date getTimestamp() {
        return this.timestamp;
    }

    public SpanStatus getStatus() {
        return getContexts().getTrace().getStatus();
    }

    public List<Span> getSpans() {
        return this.spans;
    }

    public Span getLatestActiveSpan() {
        ArrayList arrayList = new ArrayList(this.spans);
        if (arrayList.isEmpty()) {
            return null;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (!((Span) arrayList.get(size)).isFinished()) {
                return (Span) arrayList.get(size);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public SpanContext getContext() {
        return this.context;
    }

    public boolean isFinished() {
        return this.timestamp != null;
    }
}
