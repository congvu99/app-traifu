package com.facebook.bolts;

public class UnobservedTaskException extends RuntimeException {
    public UnobservedTaskException(Throwable th) {
        super(th);
    }
}
