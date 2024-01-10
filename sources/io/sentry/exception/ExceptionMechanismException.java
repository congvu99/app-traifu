package io.sentry.exception;

import io.sentry.protocol.Mechanism;

public final class ExceptionMechanismException extends RuntimeException {
    private static final long serialVersionUID = 142345454265713915L;
    private final Mechanism exceptionMechanism;
    private final Thread thread;
    private final Throwable throwable;

    public ExceptionMechanismException(Mechanism mechanism, Throwable th, Thread thread2) {
        this.exceptionMechanism = mechanism;
        this.throwable = th;
        this.thread = thread2;
    }

    public Mechanism getExceptionMechanism() {
        return this.exceptionMechanism;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public Thread getThread() {
        return this.thread;
    }
}
