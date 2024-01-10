package com.github.scribejava.core.model;

public interface OAuthAsyncRequestCallback<T> {
    void onCompleted(T t);

    void onThrowable(Throwable th);
}
