package io.sentry.exception;

public final class InvalidDsnException extends RuntimeException {
    private static final long serialVersionUID = 412945154259913013L;
    private final String dsn;

    public InvalidDsnException(String str) {
        this.dsn = str;
    }

    public InvalidDsnException(String str, String str2) {
        super(str2);
        this.dsn = str;
    }

    public InvalidDsnException(String str, String str2, Throwable th) {
        super(str2, th);
        this.dsn = str;
    }

    public InvalidDsnException(String str, Throwable th) {
        super(th);
        this.dsn = str;
    }

    public String getDsn() {
        return this.dsn;
    }
}
