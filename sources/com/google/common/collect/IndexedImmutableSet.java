package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

abstract class IndexedImmutableSet<E> extends ImmutableSet<E> {
    /* access modifiers changed from: package-private */
    public abstract E get(int i);

    IndexedImmutableSet() {
    }

    public UnmodifiableIterator<E> iterator() {
        return asList().iterator();
    }

    public Spliterator<E> spliterator() {
        return CollectSpliterators.indexed(size(), 1297, new IntFunction() {
            public final Object apply(int i) {
                return IndexedImmutableSet.this.get(i);
            }
        });
    }

    public void forEach(Consumer<? super E> consumer) {
        Preconditions.checkNotNull(consumer);
        int size = size();
        for (int i = 0; i < size; i++) {
            consumer.accept(get(i));
        }
    }

    /* access modifiers changed from: package-private */
    public int copyIntoArray(Object[] objArr, int i) {
        return asList().copyIntoArray(objArr, i);
    }

    /* access modifiers changed from: package-private */
    public ImmutableList<E> createAsList() {
        return new ImmutableAsList<E>() {
            public E get(int i) {
                return IndexedImmutableSet.this.get(i);
            }

            /* access modifiers changed from: package-private */
            public boolean isPartialView() {
                return IndexedImmutableSet.this.isPartialView();
            }

            public int size() {
                return IndexedImmutableSet.this.size();
            }

            /* access modifiers changed from: package-private */
            public ImmutableCollection<E> delegateCollection() {
                return IndexedImmutableSet.this;
            }
        };
    }
}
