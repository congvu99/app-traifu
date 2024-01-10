package io.sentry;

import io.sentry.protocol.Message;
import io.sentry.protocol.SentryId;

public interface ISentryClient {
    SentryId captureEnvelope(SentryEnvelope sentryEnvelope);

    SentryId captureEnvelope(SentryEnvelope sentryEnvelope, Object obj);

    SentryId captureEvent(SentryEvent sentryEvent);

    SentryId captureEvent(SentryEvent sentryEvent, Scope scope);

    SentryId captureEvent(SentryEvent sentryEvent, Scope scope, Object obj);

    SentryId captureEvent(SentryEvent sentryEvent, Object obj);

    SentryId captureException(Throwable th);

    SentryId captureException(Throwable th, Scope scope);

    SentryId captureException(Throwable th, Scope scope, Object obj);

    SentryId captureException(Throwable th, Object obj);

    SentryId captureMessage(String str, SentryLevel sentryLevel);

    SentryId captureMessage(String str, SentryLevel sentryLevel, Scope scope);

    void captureSession(Session session);

    void captureSession(Session session, Object obj);

    SentryId captureTransaction(ITransaction iTransaction);

    SentryId captureTransaction(ITransaction iTransaction, Scope scope, Object obj);

    void captureUserFeedback(UserFeedback userFeedback);

    void close();

    void flush(long j);

    boolean isEnabled();

    /* renamed from: io.sentry.ISentryClient$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static SentryId $default$captureEvent(ISentryClient _this, SentryEvent sentryEvent) {
            return _this.captureEvent(sentryEvent, (Scope) null, (Object) null);
        }

        public static SentryId $default$captureEvent(ISentryClient _this, SentryEvent sentryEvent, Scope scope) {
            return _this.captureEvent(sentryEvent, scope, (Object) null);
        }

        public static SentryId $default$captureEvent(ISentryClient _this, SentryEvent sentryEvent, Object obj) {
            return _this.captureEvent(sentryEvent, (Scope) null, obj);
        }

        public static SentryId $default$captureMessage(ISentryClient _this, String str, SentryLevel sentryLevel, Scope scope) {
            SentryEvent sentryEvent = new SentryEvent();
            Message message = new Message();
            message.setFormatted(str);
            sentryEvent.setMessage(message);
            sentryEvent.setLevel(sentryLevel);
            return _this.captureEvent(sentryEvent, scope);
        }

        public static SentryId $default$captureMessage(ISentryClient _this, String str, SentryLevel sentryLevel) {
            return _this.captureMessage(str, sentryLevel, (Scope) null);
        }

        public static SentryId $default$captureException(ISentryClient _this, Throwable th) {
            return _this.captureException(th, (Scope) null, (Object) null);
        }

        public static SentryId $default$captureException(ISentryClient _this, Throwable th, Scope scope, Object obj) {
            return _this.captureEvent(new SentryEvent(th), scope, obj);
        }

        public static SentryId $default$captureException(ISentryClient _this, Throwable th, Object obj) {
            return _this.captureException(th, (Scope) null, obj);
        }

        public static SentryId $default$captureException(ISentryClient _this, Throwable th, Scope scope) {
            return _this.captureException(th, scope, (Object) null);
        }

        public static void $default$captureSession(ISentryClient _this, Session session) {
            _this.captureSession(session, (Object) null);
        }

        public static SentryId $default$captureEnvelope(ISentryClient _this, SentryEnvelope sentryEnvelope) {
            return _this.captureEnvelope(sentryEnvelope, (Object) null);
        }

        public static SentryId $default$captureTransaction(ISentryClient _this, ITransaction iTransaction) {
            return _this.captureTransaction(iTransaction, (Scope) null, (Object) null);
        }
    }
}
