package com.google.common.base;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@FunctionalInterface
public interface Predicate<T> extends java.util.function.Predicate<T> {
    boolean apply(@NullableDecl T t);

    boolean equals(@NullableDecl Object obj);

    boolean test(@NullableDecl T t);

    /* renamed from: com.google.common.base.Predicate$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$test(@NullableDecl Predicate _this, Object obj) {
            return _this.apply(obj);
        }
    }
}
