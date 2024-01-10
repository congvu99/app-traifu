package com.trainerfu.android;

public class AsyncTaskResult<T> {
    private Exception error;
    private T result;

    public T getResult() {
        return this.result;
    }

    public Exception getError() {
        return this.error;
    }

    public AsyncTaskResult(T t) {
        this.result = t;
    }

    public AsyncTaskResult(Exception exc) {
        this.error = exc;
    }
}
