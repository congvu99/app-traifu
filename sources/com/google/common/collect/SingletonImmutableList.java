package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Spliterator;
import kotlinx.serialization.json.internal.JsonLexerKt;

final class SingletonImmutableList<E> extends ImmutableList<E> {
    final transient E element;

    /* access modifiers changed from: package-private */
    public boolean isPartialView() {
        return false;
    }

    public int size() {
        return 1;
    }

    SingletonImmutableList(E e) {
        this.element = Preconditions.checkNotNull(e);
    }

    public E get(int i) {
        Preconditions.checkElementIndex(i, 1);
        return this.element;
    }

    public UnmodifiableIterator<E> iterator() {
        return Iterators.singletonIterator(this.element);
    }

    public Spliterator<E> spliterator() {
        return Collections.singleton(this.element).spliterator();
    }

    public ImmutableList<E> subList(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, 1);
        return i == i2 ? ImmutableList.of() : this;
    }

    public String toString() {
        return JsonLexerKt.BEGIN_LIST + this.element.toString() + JsonLexerKt.END_LIST;
    }
}
