package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.ObjIntConsumer;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {
    private static final long serialVersionUID = -2250766705698539974L;
    /* access modifiers changed from: private */
    public transient Map<E, Count> backingMap;
    /* access modifiers changed from: private */
    public transient long size;

    static /* synthetic */ long access$010(AbstractMapBasedMultiset abstractMapBasedMultiset) {
        long j = abstractMapBasedMultiset.size;
        abstractMapBasedMultiset.size = j - 1;
        return j;
    }

    protected AbstractMapBasedMultiset(Map<E, Count> map) {
        Preconditions.checkArgument(map.isEmpty());
        this.backingMap = map;
    }

    /* access modifiers changed from: package-private */
    public void setBackingMap(Map<E, Count> map) {
        this.backingMap = map;
    }

    public Set<Multiset.Entry<E>> entrySet() {
        return super.entrySet();
    }

    /* access modifiers changed from: package-private */
    public Iterator<E> elementIterator() {
        final Iterator<Map.Entry<E, Count>> it = this.backingMap.entrySet().iterator();
        return new Iterator<E>() {
            @NullableDecl
            Map.Entry<E, Count> toRemove;

            public boolean hasNext() {
                return it.hasNext();
            }

            public E next() {
                Map.Entry<E, Count> entry = (Map.Entry) it.next();
                this.toRemove = entry;
                return entry.getKey();
            }

            public void remove() {
                CollectPreconditions.checkRemove(this.toRemove != null);
                AbstractMapBasedMultiset abstractMapBasedMultiset = AbstractMapBasedMultiset.this;
                long unused = abstractMapBasedMultiset.size = abstractMapBasedMultiset.size - ((long) this.toRemove.getValue().getAndSet(0));
                it.remove();
                this.toRemove = null;
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Iterator<Multiset.Entry<E>> entryIterator() {
        final Iterator<Map.Entry<E, Count>> it = this.backingMap.entrySet().iterator();
        return new Iterator<Multiset.Entry<E>>() {
            @NullableDecl
            Map.Entry<E, Count> toRemove;

            public boolean hasNext() {
                return it.hasNext();
            }

            public Multiset.Entry<E> next() {
                final Map.Entry<E, Count> entry = (Map.Entry) it.next();
                this.toRemove = entry;
                return new Multisets.AbstractEntry<E>() {
                    public E getElement() {
                        return entry.getKey();
                    }

                    public int getCount() {
                        Count count;
                        Count count2 = (Count) entry.getValue();
                        if ((count2 == null || count2.get() == 0) && (count = (Count) AbstractMapBasedMultiset.this.backingMap.get(getElement())) != null) {
                            return count.get();
                        }
                        if (count2 == null) {
                            return 0;
                        }
                        return count2.get();
                    }
                };
            }

            public void remove() {
                CollectPreconditions.checkRemove(this.toRemove != null);
                AbstractMapBasedMultiset abstractMapBasedMultiset = AbstractMapBasedMultiset.this;
                long unused = abstractMapBasedMultiset.size = abstractMapBasedMultiset.size - ((long) this.toRemove.getValue().getAndSet(0));
                it.remove();
                this.toRemove = null;
            }
        };
    }

    public void forEachEntry(ObjIntConsumer<? super E> objIntConsumer) {
        Preconditions.checkNotNull(objIntConsumer);
        this.backingMap.forEach(new BiConsumer(objIntConsumer) {
            public final /* synthetic */ ObjIntConsumer f$0;

            {
                this.f$0 = r1;
            }

            public final void accept(Object obj, Object obj2) {
                this.f$0.accept(obj, ((Count) obj2).get());
            }
        });
    }

    public void clear() {
        for (Count count : this.backingMap.values()) {
            count.set(0);
        }
        this.backingMap.clear();
        this.size = 0;
    }

    /* access modifiers changed from: package-private */
    public int distinctElements() {
        return this.backingMap.size();
    }

    public int size() {
        return Ints.saturatedCast(this.size);
    }

    public Iterator<E> iterator() {
        return new MapBasedMultisetIterator();
    }

    private class MapBasedMultisetIterator implements Iterator<E> {
        boolean canRemove;
        @MonotonicNonNullDecl
        Map.Entry<E, Count> currentEntry;
        final Iterator<Map.Entry<E, Count>> entryIterator;
        int occurrencesLeft;

        MapBasedMultisetIterator() {
            this.entryIterator = AbstractMapBasedMultiset.this.backingMap.entrySet().iterator();
        }

        public boolean hasNext() {
            return this.occurrencesLeft > 0 || this.entryIterator.hasNext();
        }

        public E next() {
            if (this.occurrencesLeft == 0) {
                Map.Entry<E, Count> next = this.entryIterator.next();
                this.currentEntry = next;
                this.occurrencesLeft = next.getValue().get();
            }
            this.occurrencesLeft--;
            this.canRemove = true;
            return this.currentEntry.getKey();
        }

        public void remove() {
            CollectPreconditions.checkRemove(this.canRemove);
            if (this.currentEntry.getValue().get() > 0) {
                if (this.currentEntry.getValue().addAndGet(-1) == 0) {
                    this.entryIterator.remove();
                }
                AbstractMapBasedMultiset.access$010(AbstractMapBasedMultiset.this);
                this.canRemove = false;
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    public int count(@NullableDecl Object obj) {
        Count count = (Count) Maps.safeGet(this.backingMap, obj);
        if (count == null) {
            return 0;
        }
        return count.get();
    }

    public int add(@NullableDecl E e, int i) {
        if (i == 0) {
            return count(e);
        }
        boolean z = true;
        int i2 = 0;
        Preconditions.checkArgument(i > 0, "occurrences cannot be negative: %s", i);
        Count count = this.backingMap.get(e);
        if (count == null) {
            this.backingMap.put(e, new Count(i));
        } else {
            int i3 = count.get();
            long j = ((long) i3) + ((long) i);
            if (j > 2147483647L) {
                z = false;
            }
            Preconditions.checkArgument(z, "too many occurrences: %s", j);
            count.add(i);
            i2 = i3;
        }
        this.size += (long) i;
        return i2;
    }

    public int remove(@NullableDecl Object obj, int i) {
        if (i == 0) {
            return count(obj);
        }
        Preconditions.checkArgument(i > 0, "occurrences cannot be negative: %s", i);
        Count count = this.backingMap.get(obj);
        if (count == null) {
            return 0;
        }
        int i2 = count.get();
        if (i2 <= i) {
            this.backingMap.remove(obj);
            i = i2;
        }
        count.add(-i);
        this.size -= (long) i;
        return i2;
    }

    public int setCount(@NullableDecl E e, int i) {
        int i2;
        CollectPreconditions.checkNonnegative(i, "count");
        if (i == 0) {
            i2 = getAndSet(this.backingMap.remove(e), i);
        } else {
            Count count = this.backingMap.get(e);
            int andSet = getAndSet(count, i);
            if (count == null) {
                this.backingMap.put(e, new Count(i));
            }
            i2 = andSet;
        }
        this.size += (long) (i - i2);
        return i2;
    }

    private static int getAndSet(@NullableDecl Count count, int i) {
        if (count == null) {
            return 0;
        }
        return count.getAndSet(i);
    }

    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("Stream data required");
    }
}
