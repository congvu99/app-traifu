package io.sentry;

import io.sentry.ISentryClient;
import io.sentry.protocol.SentryId;

final class NoOpSentryClient implements ISentryClient {
    private static final NoOpSentryClient instance = new NoOpSentryClient();

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

    public void captureSession(Session session, Object obj) {
    }

    public /* synthetic */ SentryId captureTransaction(ITransaction iTransaction) {
        return ISentryClient.CC.$default$captureTransaction(this, iTransaction);
    }

    public void captureUserFeedback(UserFeedback userFeedback) {
    }

    public void close() {
    }

    public void flush(long j) {
    }

    public boolean isEnabled() {
        return false;
    }

    private NoOpSentryClient() {
    }

    public static NoOpSentryClient getInstance() {
        return instance;
    }

    public SentryId captureEvent(SentryEvent sentryEvent, Scope scope, Object obj) {
        return SentryId.EMPTY_ID;
    }

    public SentryId captureEnvelope(SentryEnvelope sentryEnvelope, Object obj) {
        return SentryId.EMPTY_ID;
    }

    public SentryId captureTransaction(ITransaction iTransaction, Scope scope, Object obj) {
        return SentryId.EMPTY_ID;
    }
}
