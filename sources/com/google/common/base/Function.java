package com.google.common.base;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@FunctionalInterface
public interface Function<F, T> extends java.util.function.Function<F, T> {
    @NullableDecl
    T apply(@NullableDecl F f);

    boolean equals(@NullableDecl Object obj);
}
