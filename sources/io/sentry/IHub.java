package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import java.util.List;

public interface IHub {
    void addBreadcrumb(Breadcrumb breadcrumb);

    void addBreadcrumb(Breadcrumb breadcrumb, Object obj);

    void addBreadcrumb(String str);

    void addBreadcrumb(String str, String str2);

    void bindClient(ISentryClient iSentryClient);

    SentryId captureEnvelope(SentryEnvelope sentryEnvelope);

    SentryId captureEnvelope(SentryEnvelope sentryEnvelope, Object obj);

    SentryId captureEvent(SentryEvent sentryEvent);

    SentryId captureEvent(SentryEvent sentryEvent, Object obj);

    SentryId captureException(Throwable th);

    SentryId captureException(Throwable th, Object obj);

    SentryId captureMessage(String str);

    SentryId captureMessage(String str, SentryLevel sentryLevel);

    SentryId captureTransaction(ITransaction iTransaction);

    SentryId captureTransaction(ITransaction iTransaction, Object obj);

    void captureUserFeedback(UserFeedback userFeedback);

    void clearBreadcrumbs();

    IHub clone();

    void close();

    void configureScope(ScopeCallback scopeCallback);

    void endSession();

    void flush(long j);

    SentryId getLastEventId();

    SentryOptions getOptions();

    ISpan getSpan();

    boolean isEnabled();

    void popScope();

    void pushScope();

    void removeExtra(String str);

    void removeTag(String str);

    void setExtra(String str, String str2);

    void setFingerprint(List<String> list);

    void setLevel(SentryLevel sentryLevel);

    void setSpanContext(Throwable th, ISpan iSpan);

    void setTag(String str, String str2);

    void setTransaction(String str);

    void setUser(User user);

    void startSession();

    ITransaction startTransaction(TransactionContext transactionContext);

    ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext);

    ITransaction startTransaction(String str);

    ITransaction startTransaction(String str, CustomSamplingContext customSamplingContext);

    SentryTraceHeader traceHeaders();

    void withScope(ScopeCallback scopeCallback);

    /* renamed from: io.sentry.IHub$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static SentryId $default$captureEvent(IHub _this, SentryEvent sentryEvent) {
            return _this.captureEvent(sentryEvent, (Object) null);
        }

        public static SentryId $default$captureMessage(IHub _this, String str) {
            return _this.captureMessage(str, SentryLevel.INFO);
        }

        public static SentryId $default$captureEnvelope(IHub _this, SentryEnvelope sentryEnvelope) {
            return _this.captureEnvelope(sentryEnvelope, (Object) null);
        }

        public static SentryId $default$captureException(IHub _this, Throwable th) {
            return _this.captureException(th, (Object) null);
        }

        public static void $default$addBreadcrumb(IHub _this, Breadcrumb breadcrumb) {
            _this.addBreadcrumb(breadcrumb, (Object) null);
        }

        public static void $default$addBreadcrumb(IHub _this, String str) {
            _this.addBreadcrumb(new Breadcrumb(str));
        }

        public static void $default$addBreadcrumb(IHub _this, String str, String str2) {
            Breadcrumb breadcrumb = new Breadcrumb(str);
            breadcrumb.setCategory(str2);
            _this.addBreadcrumb(breadcrumb);
        }

        public static SentryId $default$captureTransaction(IHub _this, ITransaction iTransaction) {
            return _this.captureTransaction(iTransaction, (Object) null);
        }

        public static ITransaction $default$startTransaction(IHub _this, String str, CustomSamplingContext customSamplingContext) {
            return _this.startTransaction(new TransactionContext(str), customSamplingContext);
        }

        public static ITransaction $default$startTransaction(IHub _this, String str) {
            return _this.startTransaction(str, (CustomSamplingContext) null);
        }
    }
}
