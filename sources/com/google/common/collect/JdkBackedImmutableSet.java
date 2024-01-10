package com.google.common.collect;

import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class JdkBackedImmutableSet<E> extends IndexedImmutableSet<E> {
    private final Set<?> delegate;
    private final ImmutableList<E> delegateList;

    /* access modifiers changed from: package-private */
    public boolean isPartialView() {
        return false;
    }

    JdkBackedImmutableSet(Set<?> set, ImmutableList<E> immutableList) {
        this.delegate = set;
        this.delegateList = immutableList;
    }

    /* access modifiers changed from: package-private */
    public E get(int i) {
        return this.delegateList.get(i);
    }

    public boolean contains(@NullableDecl Object obj) {
        return this.delegate.contains(obj);
    }

    public int size() {
        return this.delegateList.size();
    }
}
