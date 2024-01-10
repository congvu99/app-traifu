package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public interface Multiset<E> extends Collection<E> {

    public interface Entry<E> {
        boolean equals(Object obj);

        int getCount();

        E getElement();

        int hashCode();

        String toString();
    }

    int add(@NullableDecl E e, int i);

    boolean add(E e);

    boolean contains(@NullableDecl Object obj);

    boolean containsAll(Collection<?> collection);

    int count(@NullableDecl Object obj);

    Set<E> elementSet();

    Set<Entry<E>> entrySet();

    boolean equals(@NullableDecl Object obj);

    void forEach(Consumer<? super E> consumer);

    void forEachEntry(ObjIntConsumer<? super E> objIntConsumer);

    int hashCode();

    Iterator<E> iterator();

    int remove(@NullableDecl Object obj, int i);

    boolean remove(@NullableDecl Object obj);

    boolean removeAll(Collection<?> collection);

    boolean retainAll(Collection<?> collection);

    int setCount(E e, int i);

    boolean setCount(E e, int i, int i2);

    int size();

    Spliterator<E> spliterator();

    String toString();

    /* renamed from: com.google.common.collect.Multiset$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$forEachEntry(Multiset _this, ObjIntConsumer objIntConsumer) {
            Preconditions.checkNotNull(objIntConsumer);
            _this.entrySet().forEach(new Consumer(objIntConsumer) {
                public final /* synthetic */ ObjIntConsumer f$0;

                {
                    this.f$0 = r1;
                }

                public final void accept(Object obj) {
                    this.f$0.accept(((Multiset.Entry) obj).getElement(), ((Multiset.Entry) obj).getCount());
                }
            });
        }

        public static void $default$forEach(Multiset _this, Consumer consumer) {
            Preconditions.checkNotNull(consumer);
            _this.entrySet().forEach(new Consumer(consumer) {
                public final /* synthetic */ Consumer f$0;

                {
                    this.f$0 = r1;
                }

                public final void accept(Object obj) {
                    Multiset.CC.lambda$forEach$1(this.f$0, (Multiset.Entry) obj);
                }
            });
        }

        public static /* synthetic */ void lambda$forEach$1(Consumer consumer, Entry entry) {
            Object element = entry.getElement();
            int count = entry.getCount();
            for (int i = 0; i < count; i++) {
                consumer.accept(element);
            }
        }

        public static Spliterator $default$spliterator(Multiset _this) {
            return Multisets.spliteratorImpl(_this);
        }
    }
}
