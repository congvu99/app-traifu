package io.sentry;

public interface ISpan {
    void finish();

    void finish(SpanStatus spanStatus);

    String getDescription();

    String getOperation();

    SpanContext getSpanContext();

    SpanStatus getStatus();

    Throwable getThrowable();

    boolean isFinished();

    void setDescription(String str);

    void setOperation(String str);

    void setStatus(SpanStatus spanStatus);

    void setTag(String str, String str2);

    void setThrowable(Throwable th);

    ISpan startChild(String str);

    ISpan startChild(String str, String str2);

    SentryTraceHeader toSentryTrace();
}
