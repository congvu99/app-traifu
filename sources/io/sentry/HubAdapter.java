package io.sentry;

import io.sentry.IHub;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import java.util.List;

public final class HubAdapter implements IHub {
    private static final HubAdapter INSTANCE = new HubAdapter();

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

    private HubAdapter() {
    }

    public static HubAdapter getInstance() {
        return INSTANCE;
    }

    public boolean isEnabled() {
        return Sentry.isEnabled();
    }

    public SentryId captureEvent(SentryEvent sentryEvent, Object obj) {
        return Sentry.captureEvent(sentryEvent, obj);
    }

    public SentryId captureMessage(String str, SentryLevel sentryLevel) {
        return Sentry.captureMessage(str, sentryLevel);
    }

    public SentryId captureEnvelope(SentryEnvelope sentryEnvelope, Object obj) {
        return Sentry.getCurrentHub().captureEnvelope(sentryEnvelope, obj);
    }

    public SentryId captureException(Throwable th, Object obj) {
        return Sentry.captureException(th, obj);
    }

    public void captureUserFeedback(UserFeedback userFeedback) {
        Sentry.captureUserFeedback(userFeedback);
    }

    public void startSession() {
        Sentry.startSession();
    }

    public void endSession() {
        Sentry.endSession();
    }

    public void close() {
        Sentry.close();
    }

    public void addBreadcrumb(Breadcrumb breadcrumb, Object obj) {
        Sentry.addBreadcrumb(breadcrumb, obj);
    }

    public void setLevel(SentryLevel sentryLevel) {
        Sentry.setLevel(sentryLevel);
    }

    public void setTransaction(String str) {
        Sentry.setTransaction(str);
    }

    public void setUser(User user) {
        Sentry.setUser(user);
    }

    public void setFingerprint(List<String> list) {
        Sentry.setFingerprint(list);
    }

    public void clearBreadcrumbs() {
        Sentry.clearBreadcrumbs();
    }

    public void setTag(String str, String str2) {
        Sentry.setTag(str, str2);
    }

    public void removeTag(String str) {
        Sentry.removeTag(str);
    }

    public void setExtra(String str, String str2) {
        Sentry.setExtra(str, str2);
    }

    public void removeExtra(String str) {
        Sentry.removeExtra(str);
    }

    public SentryId getLastEventId() {
        return Sentry.getLastEventId();
    }

    public void pushScope() {
        Sentry.pushScope();
    }

    public void popScope() {
        Sentry.popScope();
    }

    public void withScope(ScopeCallback scopeCallback) {
        Sentry.withScope(scopeCallback);
    }

    public void configureScope(ScopeCallback scopeCallback) {
        Sentry.configureScope(scopeCallback);
    }

    public void bindClient(ISentryClient iSentryClient) {
        Sentry.bindClient(iSentryClient);
    }

    public void flush(long j) {
        Sentry.flush(j);
    }

    public IHub clone() {
        return Sentry.getCurrentHub().clone();
    }

    public SentryId captureTransaction(ITransaction iTransaction, Object obj) {
        return Sentry.getCurrentHub().captureTransaction(iTransaction, obj);
    }

    public ITransaction startTransaction(TransactionContext transactionContext) {
        return Sentry.startTransaction(transactionContext);
    }

    public ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext) {
        return Sentry.startTransaction(transactionContext, customSamplingContext);
    }

    public ITransaction startTransaction(String str, CustomSamplingContext customSamplingContext) {
        return Sentry.startTransaction(str, customSamplingContext);
    }

    public SentryTraceHeader traceHeaders() {
        return Sentry.traceHeaders();
    }

    public void setSpanContext(Throwable th, ISpan iSpan) {
        Sentry.getCurrentHub().setSpanContext(th, iSpan);
    }

    public ISpan getSpan() {
        return Sentry.getCurrentHub().getSpan();
    }

    public SentryOptions getOptions() {
        return Sentry.getCurrentHub().getOptions();
    }
}
