package io.sentry;

import io.sentry.IHub;
import io.sentry.Scope;
import io.sentry.Stack;
import io.sentry.hints.SessionEndHint;
import io.sentry.hints.SessionStartHint;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import io.sentry.util.Objects;
import java.io.Closeable;
import java.util.List;
import java.util.WeakHashMap;

public final class Hub implements IHub {
    private volatile boolean isEnabled;
    private volatile SentryId lastEventId;
    private final SentryOptions options;
    private final Stack stack;
    private final WeakHashMap<Throwable, ISpan> throwableToSpan;
    private final TracesSampler tracesSampler;

    public /* synthetic */ void addBreadcrumb(Breadcrumb breadcrumb) {
        IHub.CC.$default$addBreadcrumb((IHub) this, breadcrumb);
    }

    public /* synthetic */ void addBreadcrumb(String str) {
        IHub.CC.$default$addBreadcrumb((IHub) this, str);
    }

    public /* synthetic */ void addBreadcrumb(String str, String str2) {
        IHub.CC.$default$addBreadcrumb(this, str, str2);
    }

    public /* synthetic */ SentryId captureEnvelope(SentryEnvelope sentryEnvelope) {
        return IHub.CC.$default$captureEnvelope(this, sentryEnvelope);
    }

    public /* synthetic */ SentryId captureEvent(SentryEvent sentryEvent) {
        return IHub.CC.$default$captureEvent(this, sentryEvent);
    }

    public /* synthetic */ SentryId captureException(Throwable th) {
        return IHub.CC.$default$captureException(this, th);
    }

    public /* synthetic */ SentryId captureMessage(String str) {
        return IHub.CC.$default$captureMessage(this, str);
    }

    public /* synthetic */ SentryId captureTransaction(ITransaction iTransaction) {
        return IHub.CC.$default$captureTransaction(this, iTransaction);
    }

    public /* synthetic */ ITransaction startTransaction(String str) {
        return IHub.CC.$default$startTransaction(this, str);
    }

    public /* synthetic */ ITransaction startTransaction(String str, CustomSamplingContext customSamplingContext) {
        return IHub.CC.$default$startTransaction(this, str, customSamplingContext);
    }

    public Hub(SentryOptions sentryOptions) {
        this(sentryOptions, createRootStackItem(sentryOptions));
    }

    private Hub(SentryOptions sentryOptions, Stack stack2) {
        this.throwableToSpan = new WeakHashMap<>();
        validateOptions(sentryOptions);
        this.options = sentryOptions;
        this.tracesSampler = new TracesSampler(sentryOptions);
        this.stack = stack2;
        this.lastEventId = SentryId.EMPTY_ID;
        this.isEnabled = true;
    }

    private Hub(SentryOptions sentryOptions, Stack.StackItem stackItem) {
        this(sentryOptions, new Stack(sentryOptions.getLogger(), stackItem));
    }

    private static void validateOptions(SentryOptions sentryOptions) {
        Objects.requireNonNull(sentryOptions, "SentryOptions is required.");
        if (sentryOptions.getDsn() == null || sentryOptions.getDsn().isEmpty()) {
            throw new IllegalArgumentException("Hub requires a DSN to be instantiated. Considering using the NoOpHub is no DSN is available.");
        }
    }

    private static Stack.StackItem createRootStackItem(SentryOptions sentryOptions) {
        validateOptions(sentryOptions);
        return new Stack.StackItem(sentryOptions, new SentryClient(sentryOptions), new Scope(sentryOptions));
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public SentryId captureEvent(SentryEvent sentryEvent, Object obj) {
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureEvent' call is a no-op.", new Object[0]);
        } else if (sentryEvent == null) {
            this.options.getLogger().log(SentryLevel.WARNING, "captureEvent called with null parameter.", new Object[0]);
        } else {
            try {
                assignTraceContext(sentryEvent);
                Stack.StackItem peek = this.stack.peek();
                sentryId = peek.getClient().captureEvent(sentryEvent, peek.getScope(), obj);
            } catch (Exception e) {
                ILogger logger = this.options.getLogger();
                SentryLevel sentryLevel = SentryLevel.ERROR;
                logger.log(sentryLevel, "Error while capturing event with id: " + sentryEvent.getEventId(), (Throwable) e);
            }
        }
        this.lastEventId = sentryId;
        return sentryId;
    }

    public SentryId captureMessage(String str, SentryLevel sentryLevel) {
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureMessage' call is a no-op.", new Object[0]);
        } else if (str == null) {
            this.options.getLogger().log(SentryLevel.WARNING, "captureMessage called with null parameter.", new Object[0]);
        } else {
            try {
                Stack.StackItem peek = this.stack.peek();
                sentryId = peek.getClient().captureMessage(str, sentryLevel, peek.getScope());
            } catch (Exception e) {
                ILogger logger = this.options.getLogger();
                SentryLevel sentryLevel2 = SentryLevel.ERROR;
                logger.log(sentryLevel2, "Error while capturing message: " + str, (Throwable) e);
            }
        }
        this.lastEventId = sentryId;
        return sentryId;
    }

    public SentryId captureEnvelope(SentryEnvelope sentryEnvelope, Object obj) {
        Objects.requireNonNull(sentryEnvelope, "SentryEnvelope is required.");
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureEnvelope' call is a no-op.", new Object[0]);
        } else {
            try {
                sentryId = this.stack.peek().getClient().captureEnvelope(sentryEnvelope, obj);
            } catch (Exception e) {
                this.options.getLogger().log(SentryLevel.ERROR, "Error while capturing envelope.", (Throwable) e);
            }
        }
        this.lastEventId = sentryId;
        return sentryId;
    }

    public SentryId captureException(Throwable th, Object obj) {
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureException' call is a no-op.", new Object[0]);
        } else if (th == null) {
            this.options.getLogger().log(SentryLevel.WARNING, "captureException called with null parameter.", new Object[0]);
        } else {
            try {
                Stack.StackItem peek = this.stack.peek();
                SentryEvent sentryEvent = new SentryEvent(th);
                assignTraceContext(sentryEvent);
                sentryId = peek.getClient().captureEvent(sentryEvent, peek.getScope(), obj);
            } catch (Exception e) {
                ILogger logger = this.options.getLogger();
                SentryLevel sentryLevel = SentryLevel.ERROR;
                logger.log(sentryLevel, "Error while capturing exception: " + th.getMessage(), (Throwable) e);
            }
        }
        this.lastEventId = sentryId;
        return sentryId;
    }

    private void assignTraceContext(SentryEvent sentryEvent) {
        ISpan iSpan;
        if (sentryEvent.getThrowable() != null && (iSpan = this.throwableToSpan.get(sentryEvent.getThrowable())) != null && sentryEvent.getContexts().getTrace() == null) {
            sentryEvent.getContexts().setTrace(iSpan.getSpanContext());
        }
    }

    public void captureUserFeedback(UserFeedback userFeedback) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureUserFeedback' call is a no-op.", new Object[0]);
            return;
        }
        try {
            this.stack.peek().getClient().captureUserFeedback(userFeedback);
        } catch (Exception e) {
            ILogger logger = this.options.getLogger();
            SentryLevel sentryLevel = SentryLevel.ERROR;
            logger.log(sentryLevel, "Error while capturing captureUserFeedback: " + userFeedback.toString(), (Throwable) e);
        }
    }

    public void startSession() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'startSession' call is a no-op.", new Object[0]);
            return;
        }
        Stack.StackItem peek = this.stack.peek();
        Scope.SessionPair startSession = peek.getScope().startSession();
        if (startSession.getPrevious() != null) {
            peek.getClient().captureSession(startSession.getPrevious(), new SessionEndHint());
        }
        peek.getClient().captureSession(startSession.getCurrent(), new SessionStartHint());
    }

    public void endSession() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'endSession' call is a no-op.", new Object[0]);
            return;
        }
        Stack.StackItem peek = this.stack.peek();
        Session endSession = peek.getScope().endSession();
        if (endSession != null) {
            peek.getClient().captureSession(endSession, new SessionEndHint());
        }
    }

    public void close() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'close' call is a no-op.", new Object[0]);
            return;
        }
        try {
            for (Integration next : this.options.getIntegrations()) {
                if (next instanceof Closeable) {
                    ((Closeable) next).close();
                }
            }
            this.options.getExecutorService().close(this.options.getShutdownTimeout());
            this.stack.peek().getClient().close();
        } catch (Exception e) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error while closing the Hub.", (Throwable) e);
        }
        this.isEnabled = false;
    }

    public void addBreadcrumb(Breadcrumb breadcrumb, Object obj) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'addBreadcrumb' call is a no-op.", new Object[0]);
        } else if (breadcrumb == null) {
            this.options.getLogger().log(SentryLevel.WARNING, "addBreadcrumb called with null parameter.", new Object[0]);
        } else {
            this.stack.peek().getScope().addBreadcrumb(breadcrumb, obj);
        }
    }

    public void setLevel(SentryLevel sentryLevel) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'setLevel' call is a no-op.", new Object[0]);
        } else {
            this.stack.peek().getScope().setLevel(sentryLevel);
        }
    }

    public void setTransaction(String str) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'setTransaction' call is a no-op.", new Object[0]);
        } else {
            this.stack.peek().getScope().setTransaction(str);
        }
    }

    public void setUser(User user) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'setUser' call is a no-op.", new Object[0]);
            return;
        }
        this.stack.peek().getScope().setUser(user);
        this.options.getLogger().log(SentryLevel.FATAL, "Stack peek was null when setUser", new Object[0]);
    }

    public void setFingerprint(List<String> list) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'setFingerprint' call is a no-op.", new Object[0]);
        } else if (list == null) {
            this.options.getLogger().log(SentryLevel.WARNING, "setFingerprint called with null parameter.", new Object[0]);
        } else {
            this.stack.peek().getScope().setFingerprint(list);
            this.options.getLogger().log(SentryLevel.FATAL, "Stack peek was null when setFingerprint", new Object[0]);
        }
    }

    public void clearBreadcrumbs() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'clearBreadcrumbs' call is a no-op.", new Object[0]);
            return;
        }
        this.stack.peek().getScope().clearBreadcrumbs();
        this.options.getLogger().log(SentryLevel.FATAL, "Stack peek was null when clearBreadcrumbs", new Object[0]);
    }

    public void setTag(String str, String str2) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'setTag' call is a no-op.", new Object[0]);
        } else if (str == null || str2 == null) {
            this.options.getLogger().log(SentryLevel.WARNING, "setTag called with null parameter.", new Object[0]);
        } else {
            this.stack.peek().getScope().setTag(str, str2);
        }
    }

    public void removeTag(String str) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'removeTag' call is a no-op.", new Object[0]);
        } else if (str == null) {
            this.options.getLogger().log(SentryLevel.WARNING, "removeTag called with null parameter.", new Object[0]);
        } else {
            this.stack.peek().getScope().removeTag(str);
        }
    }

    public void setExtra(String str, String str2) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'setExtra' call is a no-op.", new Object[0]);
        } else if (str == null || str2 == null) {
            this.options.getLogger().log(SentryLevel.WARNING, "setExtra called with null parameter.", new Object[0]);
        } else {
            this.stack.peek().getScope().setExtra(str, str2);
        }
    }

    public void removeExtra(String str) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'removeExtra' call is a no-op.", new Object[0]);
        } else if (str == null) {
            this.options.getLogger().log(SentryLevel.WARNING, "removeExtra called with null parameter.", new Object[0]);
        } else {
            this.stack.peek().getScope().removeExtra(str);
        }
    }

    public SentryId getLastEventId() {
        return this.lastEventId;
    }

    public void pushScope() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'pushScope' call is a no-op.", new Object[0]);
            return;
        }
        Stack.StackItem peek = this.stack.peek();
        Scope scope = null;
        try {
            scope = peek.getScope().clone();
        } catch (CloneNotSupportedException e) {
            this.options.getLogger().log(SentryLevel.ERROR, "An error has occurred when cloning a Scope", (Throwable) e);
        }
        if (scope != null) {
            this.stack.push(new Stack.StackItem(this.options, peek.getClient(), scope));
        }
    }

    public SentryOptions getOptions() {
        return this.stack.peek().getOptions();
    }

    public void popScope() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'popScope' call is a no-op.", new Object[0]);
        } else {
            this.stack.pop();
        }
    }

    public void withScope(ScopeCallback scopeCallback) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'withScope' call is a no-op.", new Object[0]);
            return;
        }
        pushScope();
        try {
            scopeCallback.run(this.stack.peek().getScope());
        } catch (Exception e) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error in the 'withScope' callback.", (Throwable) e);
        }
        popScope();
    }

    public void configureScope(ScopeCallback scopeCallback) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'configureScope' call is a no-op.", new Object[0]);
            return;
        }
        try {
            scopeCallback.run(this.stack.peek().getScope());
        } catch (Exception e) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error in the 'configureScope' callback.", (Throwable) e);
        }
    }

    public void bindClient(ISentryClient iSentryClient) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'bindClient' call is a no-op.", new Object[0]);
            return;
        }
        Stack.StackItem peek = this.stack.peek();
        if (iSentryClient != null) {
            this.options.getLogger().log(SentryLevel.DEBUG, "New client bound to scope.", new Object[0]);
            peek.setClient(iSentryClient);
            return;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "NoOp client bound to scope.", new Object[0]);
        peek.setClient(NoOpSentryClient.getInstance());
    }

    public void flush(long j) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'flush' call is a no-op.", new Object[0]);
            return;
        }
        try {
            this.stack.peek().getClient().flush(j);
        } catch (Exception e) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error in the 'client.flush'.", (Throwable) e);
        }
    }

    public IHub clone() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Disabled Hub cloned.", new Object[0]);
        }
        return new Hub(this.options, new Stack(this.stack));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0070, code lost:
        if (r1 != null) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0072, code lost:
        r1.getScope().clearTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x009d, code lost:
        if (r1 == null) goto L_0x00a0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.sentry.protocol.SentryId captureTransaction(io.sentry.ITransaction r8, java.lang.Object r9) {
        /*
            r7 = this;
            java.lang.String r0 = "transaction is required"
            io.sentry.util.Objects.requireNonNull(r8, r0)
            io.sentry.protocol.SentryId r0 = io.sentry.protocol.SentryId.EMPTY_ID
            boolean r1 = r7.isEnabled()
            r2 = 0
            if (r1 != 0) goto L_0x001f
            io.sentry.SentryOptions r8 = r7.options
            io.sentry.ILogger r8 = r8.getLogger()
            io.sentry.SentryLevel r9 = io.sentry.SentryLevel.WARNING
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.String r2 = "Instance is disabled and this 'captureTransaction' call is a no-op."
            r8.log((io.sentry.SentryLevel) r9, (java.lang.String) r2, (java.lang.Object[]) r1)
            goto L_0x00a0
        L_0x001f:
            boolean r1 = r8.isFinished()
            r3 = 1
            if (r1 != 0) goto L_0x003b
            io.sentry.SentryOptions r1 = r7.options
            io.sentry.ILogger r1 = r1.getLogger()
            io.sentry.SentryLevel r4 = io.sentry.SentryLevel.WARNING
            java.lang.Object[] r5 = new java.lang.Object[r3]
            io.sentry.protocol.SentryId r6 = r8.getEventId()
            r5[r2] = r6
            java.lang.String r6 = "Capturing unfinished transaction: %s"
            r1.log((io.sentry.SentryLevel) r4, (java.lang.String) r6, (java.lang.Object[]) r5)
        L_0x003b:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            java.lang.Boolean r4 = r8.isSampled()
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x005d
            io.sentry.SentryOptions r9 = r7.options
            io.sentry.ILogger r9 = r9.getLogger()
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r3 = new java.lang.Object[r3]
            io.sentry.protocol.SentryId r8 = r8.getEventId()
            r3[r2] = r8
            java.lang.String r8 = "Transaction %s was dropped due to sampling decision."
            r9.log((io.sentry.SentryLevel) r1, (java.lang.String) r8, (java.lang.Object[]) r3)
            goto L_0x00a0
        L_0x005d:
            r1 = 0
            io.sentry.Stack r2 = r7.stack     // Catch:{ Exception -> 0x007c }
            io.sentry.Stack$StackItem r1 = r2.peek()     // Catch:{ Exception -> 0x007c }
            io.sentry.ISentryClient r2 = r1.getClient()     // Catch:{ Exception -> 0x007c }
            io.sentry.Scope r3 = r1.getScope()     // Catch:{ Exception -> 0x007c }
            io.sentry.protocol.SentryId r0 = r2.captureTransaction(r8, r3, r9)     // Catch:{ Exception -> 0x007c }
            if (r1 == 0) goto L_0x00a0
        L_0x0072:
            io.sentry.Scope r8 = r1.getScope()
            r8.clearTransaction()
            goto L_0x00a0
        L_0x007a:
            r8 = move-exception
            goto L_0x00a3
        L_0x007c:
            r9 = move-exception
            io.sentry.SentryOptions r2 = r7.options     // Catch:{ all -> 0x007a }
            io.sentry.ILogger r2 = r2.getLogger()     // Catch:{ all -> 0x007a }
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x007a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x007a }
            r4.<init>()     // Catch:{ all -> 0x007a }
            java.lang.String r5 = "Error while capturing transaction with id: "
            r4.append(r5)     // Catch:{ all -> 0x007a }
            io.sentry.protocol.SentryId r8 = r8.getEventId()     // Catch:{ all -> 0x007a }
            r4.append(r8)     // Catch:{ all -> 0x007a }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x007a }
            r2.log((io.sentry.SentryLevel) r3, (java.lang.String) r8, (java.lang.Throwable) r9)     // Catch:{ all -> 0x007a }
            if (r1 == 0) goto L_0x00a0
            goto L_0x0072
        L_0x00a0:
            r7.lastEventId = r0
            return r0
        L_0x00a3:
            if (r1 == 0) goto L_0x00ac
            io.sentry.Scope r9 = r1.getScope()
            r9.clearTransaction()
        L_0x00ac:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.Hub.captureTransaction(io.sentry.ITransaction, java.lang.Object):io.sentry.protocol.SentryId");
    }

    public ITransaction startTransaction(TransactionContext transactionContext) {
        return startTransaction(transactionContext, (CustomSamplingContext) null);
    }

    public ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext) {
        Objects.requireNonNull(transactionContext, "transactionContext is required");
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
            return NoOpTransaction.getInstance();
        }
        transactionContext.setSampled(Boolean.valueOf(this.tracesSampler.sample(new SamplingContext(transactionContext, customSamplingContext))));
        return new SentryTransaction(transactionContext, this);
    }

    public SentryTraceHeader traceHeaders() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'traceHeaders' call is a no-op.", new Object[0]);
        } else {
            ISpan span = this.stack.peek().getScope().getSpan();
            if (span != null) {
                return span.toSentryTrace();
            }
        }
        return null;
    }

    public ISpan getSpan() {
        if (isEnabled()) {
            return this.stack.peek().getScope().getSpan();
        }
        this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'getSpan' call is a no-op.", new Object[0]);
        return null;
    }

    public void setSpanContext(Throwable th, ISpan iSpan) {
        Objects.requireNonNull(th, "throwable is required");
        Objects.requireNonNull(iSpan, "span is required");
        this.throwableToSpan.put(th, iSpan);
    }

    /* access modifiers changed from: package-private */
    public SpanContext getSpanContext(Throwable th) {
        Objects.requireNonNull(th, "throwable is required");
        ISpan iSpan = this.throwableToSpan.get(th);
        if (iSpan != null) {
            return iSpan.getSpanContext();
        }
        return null;
    }
}
