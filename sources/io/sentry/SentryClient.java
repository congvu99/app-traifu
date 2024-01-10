package io.sentry;

import io.sentry.ISentryClient;
import io.sentry.Scope;
import io.sentry.SentryOptions;
import io.sentry.Session;
import io.sentry.hints.DiskFlushNotification;
import io.sentry.protocol.SentryId;
import io.sentry.transport.ITransport;
import io.sentry.util.ApplyScopeUtils;
import io.sentry.util.Objects;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class SentryClient implements ISentryClient {
    static final String SENTRY_PROTOCOL_VERSION = "7";
    private boolean enabled;
    private final SentryOptions options;
    private final Random random;
    private final SortBreadcrumbsByDate sortBreadcrumbsByDate = new SortBreadcrumbsByDate();
    private final ITransport transport;

    public /* synthetic */ SentryId captureEnvelope(SentryEnvelope sentryEnvelope) {
        return ISentryClient.CC.$default$captureEnvelope(this, sentryEnvelope);
    }

    public /* synthetic */ SentryId captureEvent(SentryEvent sentryEvent) {
        return ISentryClient.CC.$default$captureEvent(this, sentryEvent);
    }

    public /* synthetic */ SentryId captureEvent(SentryEvent sentryEvent, Scope scope) {
        return ISentryClient.CC.$default$captureEvent((ISentryClient) this, sentryEvent, scope);
    }

    public /* synthetic */ SentryId captureEvent(SentryEvent sentryEvent, Object obj) {
        return ISentryClient.CC.$default$captureEvent((ISentryClient) this, sentryEvent, obj);
    }

    public /* synthetic */ SentryId captureException(Throwable th) {
        return ISentryClient.CC.$default$captureException(this, th);
    }

    public /* synthetic */ SentryId captureException(Throwable th, Scope scope) {
        return ISentryClient.CC.$default$captureException((ISentryClient) this, th, scope);
    }

    public /* synthetic */ SentryId captureException(Throwable th, Scope scope, Object obj) {
        return ISentryClient.CC.$default$captureException(this, th, scope, obj);
    }

    public /* synthetic */ SentryId captureException(Throwable th, Object obj) {
        return ISentryClient.CC.$default$captureException((ISentryClient) this, th, obj);
    }

    public /* synthetic */ SentryId captureMessage(String str, SentryLevel sentryLevel) {
        return ISentryClient.CC.$default$captureMessage(this, str, sentryLevel);
    }

    public /* synthetic */ SentryId captureMessage(String str, SentryLevel sentryLevel, Scope scope) {
        return ISentryClient.CC.$default$captureMessage(this, str, sentryLevel, scope);
    }

    public /* synthetic */ void captureSession(Session session) {
        ISentryClient.CC.$default$captureSession(this, session);
    }

    public /* synthetic */ SentryId captureTransaction(ITransaction iTransaction) {
        return ISentryClient.CC.$default$captureTransaction(this, iTransaction);
    }

    public void flush(long j) {
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    SentryClient(SentryOptions sentryOptions) {
        Random random2 = null;
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "SentryOptions is required.");
        this.enabled = true;
        ITransportFactory transportFactory = sentryOptions.getTransportFactory();
        if (transportFactory instanceof NoOpTransportFactory) {
            transportFactory = new AsyncHttpTransportFactory();
            sentryOptions.setTransportFactory(transportFactory);
        }
        this.transport = transportFactory.create(sentryOptions, new RequestDetailsResolver(sentryOptions).resolve());
        this.random = sentryOptions.getSampleRate() != null ? new Random() : random2;
    }

    public SentryId captureEvent(SentryEvent sentryEvent, Scope scope, Object obj) {
        Objects.requireNonNull(sentryEvent, "SentryEvent is required.");
        this.options.getLogger().log(SentryLevel.DEBUG, "Capturing event: %s", sentryEvent.getEventId());
        if (ApplyScopeUtils.shouldApplyScopeData(obj)) {
            sentryEvent = applyScope(sentryEvent, scope, obj);
            if (sentryEvent == null) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Event was dropped by applyScope", new Object[0]);
            }
        } else {
            this.options.getLogger().log(SentryLevel.DEBUG, "Event was cached so not applying scope: %s", sentryEvent.getEventId());
        }
        SentryEvent processEvent = processEvent(sentryEvent, obj, this.options.getEventProcessors());
        Session session = null;
        if (processEvent != null) {
            Session updateSessionData = updateSessionData(processEvent, obj, scope);
            if (!sample()) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Event %s was dropped due to sampling decision.", processEvent.getEventId());
                processEvent = null;
            }
            session = updateSessionData;
        }
        if (processEvent != null && (processEvent = executeBeforeSend(processEvent, obj)) == null) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Event was dropped by beforeSend", new Object[0]);
        }
        SentryId sentryId = SentryId.EMPTY_ID;
        if (processEvent != null) {
            sentryId = processEvent.getEventId();
        }
        try {
            SentryEnvelope buildEnvelope = buildEnvelope(processEvent, getAttachmentsFromScope(scope), session);
            if (buildEnvelope == null) {
                return sentryId;
            }
            this.transport.send(buildEnvelope, obj);
            return sentryId;
        } catch (IOException e) {
            this.options.getLogger().log(SentryLevel.WARNING, e, "Capturing event %s failed.", sentryId);
            return SentryId.EMPTY_ID;
        }
    }

    private List<Attachment> getAttachmentsFromScope(Scope scope) {
        if (scope != null) {
            return scope.getAttachments();
        }
        return null;
    }

    private SentryEnvelope buildEnvelope(SentryBaseEvent sentryBaseEvent, List<Attachment> list) throws IOException {
        return buildEnvelope(sentryBaseEvent, list, (Session) null);
    }

    private SentryEnvelope buildEnvelope(SentryBaseEvent sentryBaseEvent, List<Attachment> list, Session session) throws IOException {
        SentryId sentryId;
        ArrayList arrayList = new ArrayList();
        if (sentryBaseEvent != null) {
            arrayList.add(SentryEnvelopeItem.fromEvent(this.options.getSerializer(), sentryBaseEvent));
            sentryId = sentryBaseEvent.getEventId();
        } else {
            sentryId = null;
        }
        if (session != null) {
            arrayList.add(SentryEnvelopeItem.fromSession(this.options.getSerializer(), session));
        }
        if (list != null) {
            for (Attachment fromAttachment : list) {
                arrayList.add(SentryEnvelopeItem.fromAttachment(fromAttachment, this.options.getMaxAttachmentSize()));
            }
        }
        if (!arrayList.isEmpty()) {
            return new SentryEnvelope(new SentryEnvelopeHeader(sentryId, this.options.getSdkVersion()), arrayList);
        }
        return null;
    }

    private SentryEvent processEvent(SentryEvent sentryEvent, Object obj, List<EventProcessor> list) {
        Iterator<EventProcessor> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            EventProcessor next = it.next();
            try {
                sentryEvent = next.process(sentryEvent, obj);
                continue;
            } catch (Exception e) {
                this.options.getLogger().log(SentryLevel.ERROR, e, "An exception occurred while processing event by processor: %s", next.getClass().getName());
                continue;
            }
            if (sentryEvent == null) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Event was dropped by a processor: %s", next.getClass().getName());
                break;
            }
        }
        return sentryEvent;
    }

    public void captureUserFeedback(UserFeedback userFeedback) {
        Objects.requireNonNull(userFeedback, "SentryEvent is required.");
        if (SentryId.EMPTY_ID.equals(userFeedback.getEventId())) {
            this.options.getLogger().log(SentryLevel.WARNING, "Capturing userFeedback without a Sentry Id.", new Object[0]);
            return;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "Capturing userFeedback: %s", userFeedback.getEventId());
        try {
            this.transport.send(buildEnvelope(userFeedback));
        } catch (IOException e) {
            this.options.getLogger().log(SentryLevel.WARNING, e, "Capturing user feedback %s failed.", userFeedback.getEventId());
        }
    }

    private SentryEnvelope buildEnvelope(UserFeedback userFeedback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SentryEnvelopeItem.fromUserFeedback(this.options.getSerializer(), userFeedback));
        return new SentryEnvelope(new SentryEnvelopeHeader(userFeedback.getEventId(), this.options.getSdkVersion()), arrayList);
    }

    /* access modifiers changed from: package-private */
    public Session updateSessionData(SentryEvent sentryEvent, Object obj, Scope scope) {
        if (ApplyScopeUtils.shouldApplyScopeData(obj)) {
            if (scope != null) {
                return scope.withSession(new Scope.IWithSession(sentryEvent, obj) {
                    public final /* synthetic */ SentryEvent f$1;
                    public final /* synthetic */ Object f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void accept(Session session) {
                        SentryClient.this.lambda$updateSessionData$0$SentryClient(this.f$1, this.f$2, session);
                    }
                });
            }
            this.options.getLogger().log(SentryLevel.INFO, "Scope is null on client.captureEvent", new Object[0]);
        }
        return null;
    }

    public /* synthetic */ void lambda$updateSessionData$0$SentryClient(SentryEvent sentryEvent, Object obj, Session session) {
        boolean z = false;
        if (session != null) {
            String str = null;
            Session.State state = sentryEvent.isCrashed() ? Session.State.Crashed : null;
            if (Session.State.Crashed == state || sentryEvent.isErrored()) {
                z = true;
            }
            if (!(sentryEvent.getRequest() == null || sentryEvent.getRequest().getHeaders() == null || !sentryEvent.getRequest().getHeaders().containsKey("user-agent"))) {
                str = sentryEvent.getRequest().getHeaders().get("user-agent");
            }
            if (session.update(state, str, z) && (obj instanceof DiskFlushNotification)) {
                session.end();
                return;
            }
            return;
        }
        this.options.getLogger().log(SentryLevel.INFO, "Session is null on scope.withSession", new Object[0]);
    }

    public void captureSession(Session session, Object obj) {
        Objects.requireNonNull(session, "Session is required.");
        if (session.getRelease() == null || session.getRelease().isEmpty()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Sessions can't be captured without setting a release.", new Object[0]);
            return;
        }
        try {
            captureEnvelope(SentryEnvelope.from(this.options.getSerializer(), session, this.options.getSdkVersion()), obj);
        } catch (IOException e) {
            this.options.getLogger().log(SentryLevel.ERROR, "Failed to capture session.", (Throwable) e);
        }
    }

    public SentryId captureEnvelope(SentryEnvelope sentryEnvelope, Object obj) {
        Objects.requireNonNull(sentryEnvelope, "SentryEnvelope is required.");
        try {
            this.transport.send(sentryEnvelope, obj);
            return sentryEnvelope.getHeader().getEventId();
        } catch (IOException e) {
            this.options.getLogger().log(SentryLevel.ERROR, "Failed to capture envelope.", (Throwable) e);
            return SentryId.EMPTY_ID;
        }
    }

    public SentryId captureTransaction(ITransaction iTransaction, Scope scope, Object obj) {
        Objects.requireNonNull(iTransaction, "Transaction is required.");
        this.options.getLogger().log(SentryLevel.DEBUG, "Capturing transaction: %s", iTransaction.getEventId());
        SentryId eventId = iTransaction.getEventId();
        if (iTransaction instanceof SentryTransaction) {
            try {
                SentryEnvelope buildEnvelope = buildEnvelope(processTransaction((SentryTransaction) iTransaction), filterForTransaction(getAttachmentsFromScope(scope)));
                if (buildEnvelope == null) {
                    return SentryId.EMPTY_ID;
                }
                this.transport.send(buildEnvelope, obj);
                return eventId;
            } catch (IOException e) {
                this.options.getLogger().log(SentryLevel.WARNING, e, "Capturing transaction %s failed.", eventId);
                return SentryId.EMPTY_ID;
            }
        } else {
            this.options.getLogger().log(SentryLevel.DEBUG, "Captured a NoOpTransaction %s", eventId);
            return eventId;
        }
    }

    private List<Attachment> filterForTransaction(List<Attachment> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Attachment next : list) {
            if (next.isAddToTransactions()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private SentryTransaction processTransaction(SentryTransaction sentryTransaction) {
        if (sentryTransaction.getRelease() == null) {
            sentryTransaction.setRelease(this.options.getRelease());
        }
        if (sentryTransaction.getEnvironment() == null) {
            sentryTransaction.setEnvironment(this.options.getEnvironment());
        }
        if (sentryTransaction.getTags() == null) {
            sentryTransaction.setTags(new HashMap(this.options.getTags()));
        } else {
            for (Map.Entry next : this.options.getTags().entrySet()) {
                if (!sentryTransaction.getTags().containsKey(next.getKey())) {
                    sentryTransaction.setTag((String) next.getKey(), (String) next.getValue());
                }
            }
        }
        return sentryTransaction;
    }

    private SentryEvent applyScope(SentryEvent sentryEvent, Scope scope, Object obj) {
        if (scope == null) {
            return sentryEvent;
        }
        if (sentryEvent.getTransaction() == null) {
            sentryEvent.setTransaction(scope.getTransactionName());
        }
        if (sentryEvent.getUser() == null) {
            sentryEvent.setUser(scope.getUser());
        }
        if (sentryEvent.getFingerprints() == null) {
            sentryEvent.setFingerprints(scope.getFingerprint());
        }
        if (sentryEvent.getBreadcrumbs() == null) {
            sentryEvent.setBreadcrumbs(new ArrayList(scope.getBreadcrumbs()));
        } else {
            sortBreadcrumbsByDate(sentryEvent, scope.getBreadcrumbs());
        }
        if (sentryEvent.getTags() == null) {
            sentryEvent.setTags(new HashMap(scope.getTags()));
        } else {
            for (Map.Entry next : scope.getTags().entrySet()) {
                if (!sentryEvent.getTags().containsKey(next.getKey())) {
                    sentryEvent.getTags().put((String) next.getKey(), (String) next.getValue());
                }
            }
        }
        if (sentryEvent.getExtras() == null) {
            sentryEvent.setExtras(new HashMap(scope.getExtras()));
        } else {
            for (Map.Entry next2 : scope.getExtras().entrySet()) {
                if (!sentryEvent.getExtras().containsKey(next2.getKey())) {
                    sentryEvent.getExtras().put((String) next2.getKey(), next2.getValue());
                }
            }
        }
        try {
            for (Map.Entry entry : scope.getContexts().clone().entrySet()) {
                if (!sentryEvent.getContexts().containsKey(entry.getKey())) {
                    sentryEvent.getContexts().put((String) entry.getKey(), entry.getValue());
                }
            }
        } catch (CloneNotSupportedException e) {
            this.options.getLogger().log(SentryLevel.ERROR, "An error has occurred when cloning Contexts", (Throwable) e);
        }
        if (scope.getLevel() != null) {
            sentryEvent.setLevel(scope.getLevel());
        }
        ISpan span = scope.getSpan();
        if (sentryEvent.getContexts().getTrace() == null && span != null) {
            sentryEvent.getContexts().setTrace(span.getSpanContext());
        }
        return processEvent(sentryEvent, obj, scope.getEventProcessors());
    }

    private void sortBreadcrumbsByDate(SentryEvent sentryEvent, Collection<Breadcrumb> collection) {
        List<Breadcrumb> breadcrumbs = sentryEvent.getBreadcrumbs();
        if (!collection.isEmpty()) {
            breadcrumbs.addAll(collection);
            Collections.sort(breadcrumbs, this.sortBreadcrumbsByDate);
        }
    }

    private SentryEvent executeBeforeSend(SentryEvent sentryEvent, Object obj) {
        SentryOptions.BeforeSendCallback beforeSend = this.options.getBeforeSend();
        if (beforeSend == null) {
            return sentryEvent;
        }
        try {
            return beforeSend.execute(sentryEvent, obj);
        } catch (Exception e) {
            this.options.getLogger().log(SentryLevel.ERROR, "The BeforeSend callback threw an exception. It will be added as breadcrumb and continue.", (Throwable) e);
            Breadcrumb breadcrumb = new Breadcrumb();
            breadcrumb.setMessage("BeforeSend callback failed.");
            breadcrumb.setCategory("SentryClient");
            breadcrumb.setLevel(SentryLevel.ERROR);
            breadcrumb.setData("sentry:message", e.getMessage());
            sentryEvent.addBreadcrumb(breadcrumb);
            return sentryEvent;
        }
    }

    public void close() {
        this.options.getLogger().log(SentryLevel.INFO, "Closing SentryClient.", new Object[0]);
        try {
            flush(this.options.getShutdownTimeout());
            this.transport.close();
        } catch (IOException e) {
            this.options.getLogger().log(SentryLevel.WARNING, "Failed to close the connection to the Sentry Server.", (Throwable) e);
        }
        this.enabled = false;
    }

    private boolean sample() {
        if (this.options.getSampleRate() == null || this.random == null || this.options.getSampleRate().doubleValue() >= this.random.nextDouble()) {
            return true;
        }
        return false;
    }

    private static final class SortBreadcrumbsByDate implements Comparator<Breadcrumb> {
        private SortBreadcrumbsByDate() {
        }

        public int compare(Breadcrumb breadcrumb, Breadcrumb breadcrumb2) {
            return breadcrumb.getTimestamp().compareTo(breadcrumb2.getTimestamp());
        }
    }
}
