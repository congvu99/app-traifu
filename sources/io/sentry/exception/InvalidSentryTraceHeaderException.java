package io.sentry.exception;

public final class InvalidSentryTraceHeaderException extends Exception {
    private static final long serialVersionUID = 1;
    private final String sentryTraceHeader;

    public InvalidSentryTraceHeaderException(String str) {
        super("sentry-trace header does not conform to expected format: " + str);
        this.sentryTraceHeader = str;
    }

    public String getSentryTraceHeader() {
        return this.sentryTraceHeader;
    }
}
