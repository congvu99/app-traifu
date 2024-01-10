package io.sentry;

import io.sentry.IHub;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import java.util.List;

final class NoOpHub implements IHub {
    private static final NoOpHub instance = new NoOpHub();

    public /* synthetic */ void addBreadcrumb(Breadcrumb breadcrumb) {
        IHub.CC.$default$addBreadcrumb((IHub) this, breadcrumb);
    }

    public void addBreadcrumb(Breadcrumb breadcrumb, Object obj) {
    }

    public /* synthetic */ void addBreadcrumb(String str) {
        IHub.CC.$default$addBreadcrumb((IHub) this, str);
    }

    public /* synthetic */ void addBreadcrumb(String str, String str2) {
        IHub.CC.$default$addBreadcrumb(this, str, str2);
    }

    public void bindClient(ISentryClient iSentryClient) {
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

    public void captureUserFeedback(UserFeedback userFeedback) {
    }

    public void clearBreadcrumbs() {
    }

    public void close() {
    }

    public void configureScope(ScopeCallback scopeCallback) {
    }

    public void endSession() {
    }

    public void flush(long j) {
    }

    public ISpan getSpan() {
        return null;
    }

    public boolean isEnabled() {
        return false;
    }

    public void popScope() {
    }

    public void pushScope() {
    }

    public void removeExtra(String str) {
    }

    public void removeTag(String str) {
    }

    public void setExtra(String str, String str2) {
    }

    public void setFingerprint(List<String> list) {
    }

    public void setLevel(SentryLevel sentryLevel) {
    }

    public void setSpanContext(Throwable th, ISpan iSpan) {
    }

    public void setTag(String str, String str2) {
    }

    public void setTransaction(String str) {
    }

    public void setUser(User user) {
    }

    public void startSession() {
    }

    public /* synthetic */ ITransaction startTransaction(String str) {
        return IHub.CC.$default$startTransaction(this, str);
    }

    public /* synthetic */ ITransaction startTransaction(String str, CustomSamplingContext customSamplingContext) {
        return IHub.CC.$default$startTransaction(this, str, customSamplingContext);
    }

    public void withScope(ScopeCallback scopeCallback) {
    }

    private NoOpHub() {
    }

    public static NoOpHub getInstance() {
        return instance;
    }

    public SentryId captureEvent(SentryEvent sentryEvent, Object obj) {
        return SentryId.EMPTY_ID;
    }

    public SentryId captureMessage(String str, SentryLevel sentryLevel) {
        return SentryId.EMPTY_ID;
    }

    public SentryId captureEnvelope(SentryEnvelope sentryEnvelope, Object obj) {
        return SentryId.EMPTY_ID;
    }

    public SentryId captureException(Throwable th, Object obj) {
        return SentryId.EMPTY_ID;
    }

    public SentryId getLastEventId() {
        return SentryId.EMPTY_ID;
    }

    public IHub clone() {
        return instance;
    }

    public SentryId captureTransaction(ITransaction iTransaction, Object obj) {
        return SentryId.EMPTY_ID;
    }

    public ITransaction startTransaction(TransactionContext transactionContext) {
        return new SentryTransaction(transactionContext, getInstance());
    }

    public ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext) {
        return new SentryTransaction(transactionContext, getInstance());
    }

    public SentryTraceHeader traceHeaders() {
        return new SentryTraceHeader(SentryId.EMPTY_ID, SpanId.EMPTY_ID, true);
    }

    public SentryOptions getOptions() {
        return new SentryOptions();
    }
}
