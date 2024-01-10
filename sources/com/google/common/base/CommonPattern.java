package com.google.common.base;

abstract class CommonPattern {
    public abstract boolean equals(Object obj);

    /* access modifiers changed from: package-private */
    public abstract int flags();

    public abstract int hashCode();

    /* access modifiers changed from: package-private */
    public abstract CommonMatcher matcher(CharSequence charSequence);

    /* access modifiers changed from: package-private */
    public abstract String pattern();

    public abstract String toString();

    CommonPattern() {
    }
}
