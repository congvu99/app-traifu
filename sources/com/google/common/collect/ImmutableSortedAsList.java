package com.google.common.collect;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.IntFunction;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class ImmutableSortedAsList<E> extends RegularImmutableAsList<E> implements SortedIterable<E> {
    ImmutableSortedAsList(ImmutableSortedSet<E> immutableSortedSet, ImmutableList<E> immutableList) {
        super(immutableSortedSet, immutableList);
    }

    /* access modifiers changed from: package-private */
    public ImmutableSortedSet<E> delegateCollection() {
        return (ImmutableSortedSet) super.delegateCollection();
    }

    public Comparator<? super E> comparator() {
        return delegateCollection().comparator();
    }

    public int indexOf(@NullableDecl Object obj) {
        int indexOf = delegateCollection().indexOf(obj);
        if (indexOf < 0 || !get(indexOf).equals(obj)) {
            return -1;
        }
        return indexOf;
    }

    public int lastIndexOf(@NullableDecl Object obj) {
        return indexOf(obj);
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    /* access modifiers changed from: package-private */
    public ImmutableList<E> subListUnchecked(int i, int i2) {
        return new RegularImmutableSortedSet(super.subListUnchecked(i, i2), comparator()).asList();
    }

    public Spliterator<E> spliterator() {
        int size = size();
        ImmutableList delegateList = delegateList();
        delegateList.getClass();
        return CollectSpliterators.indexed(size, 1301, new IntFunction() {
            public final Object apply(int i) {
                return ImmutableList.this.get(i);
            }
        }, comparator());
    }
}
