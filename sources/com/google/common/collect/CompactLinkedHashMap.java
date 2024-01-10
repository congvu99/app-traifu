package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    private static final int ENDPOINT = -2;
    private final boolean accessOrder;
    /* access modifiers changed from: private */
    public transient int firstEntry;
    private transient int lastEntry;
    @MonotonicNonNullDecl
    transient long[] links;

    public static <K, V> CompactLinkedHashMap<K, V> create() {
        return new CompactLinkedHashMap<>();
    }

    public static <K, V> CompactLinkedHashMap<K, V> createWithExpectedSize(int i) {
        return new CompactLinkedHashMap<>(i);
    }

    CompactLinkedHashMap() {
        this(3);
    }

    CompactLinkedHashMap(int i) {
        this(i, 1.0f, false);
    }

    CompactLinkedHashMap(int i, float f, boolean z) {
        super(i, f);
        this.accessOrder = z;
    }

    /* access modifiers changed from: package-private */
    public void init(int i, float f) {
        super.init(i, f);
        this.firstEntry = -2;
        this.lastEntry = -2;
        long[] jArr = new long[i];
        this.links = jArr;
        Arrays.fill(jArr, -1);
    }

    private int getPredecessor(int i) {
        return (int) (this.links[i] >>> 32);
    }

    /* access modifiers changed from: package-private */
    public int getSuccessor(int i) {
        return (int) this.links[i];
    }

    private void setSuccessor(int i, int i2) {
        long[] jArr = this.links;
        jArr[i] = (jArr[i] & -4294967296L) | (((long) i2) & 4294967295L);
    }

    private void setPredecessor(int i, int i2) {
        long[] jArr = this.links;
        jArr[i] = (jArr[i] & 4294967295L) | (((long) i2) << 32);
    }

    private void setSucceeds(int i, int i2) {
        if (i == -2) {
            this.firstEntry = i2;
        } else {
            setSuccessor(i, i2);
        }
        if (i2 == -2) {
            this.lastEntry = i;
        } else {
            setPredecessor(i2, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void insertEntry(int i, K k, V v, int i2) {
        super.insertEntry(i, k, v, i2);
        setSucceeds(this.lastEntry, i);
        setSucceeds(i, -2);
    }

    /* access modifiers changed from: package-private */
    public void accessEntry(int i) {
        if (this.accessOrder) {
            setSucceeds(getPredecessor(i), getSuccessor(i));
            setSucceeds(this.lastEntry, i);
            setSucceeds(i, -2);
            this.modCount++;
        }
    }

    /* access modifiers changed from: package-private */
    public void moveLastEntry(int i) {
        int size = size() - 1;
        setSucceeds(getPredecessor(i), getSuccessor(i));
        if (i < size) {
            setSucceeds(getPredecessor(size), i);
            setSucceeds(i, getSuccessor(size));
        }
        super.moveLastEntry(i);
    }

    /* access modifiers changed from: package-private */
    public void resizeEntries(int i) {
        super.resizeEntries(i);
        this.links = Arrays.copyOf(this.links, i);
    }

    /* access modifiers changed from: package-private */
    public int firstEntryIndex() {
        return this.firstEntry;
    }

    /* access modifiers changed from: package-private */
    public int adjustAfterRemove(int i, int i2) {
        return i >= size() ? i2 : i;
    }

    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        Preconditions.checkNotNull(biConsumer);
        int i = this.firstEntry;
        while (i != -2) {
            biConsumer.accept(this.keys[i], this.values[i]);
            i = getSuccessor(i);
        }
    }

    /* access modifiers changed from: package-private */
    public Set<Map.Entry<K, V>> createEntrySet() {
        return new CompactHashMap<K, V>.EntrySetView() {
            public Spliterator<Map.Entry<K, V>> spliterator() {
                return Spliterators.spliterator(this, 17);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Set<K> createKeySet() {
        return new CompactHashMap<K, V>.KeySetView() {
            public Object[] toArray() {
                return ObjectArrays.toArrayImpl(this);
            }

            public <T> T[] toArray(T[] tArr) {
                return ObjectArrays.toArrayImpl(this, tArr);
            }

            public Spliterator<K> spliterator() {
                return Spliterators.spliterator(this, 17);
            }

            public void forEach(Consumer<? super K> consumer) {
                Preconditions.checkNotNull(consumer);
                int access$000 = CompactLinkedHashMap.this.firstEntry;
                while (access$000 != -2) {
                    consumer.accept(CompactLinkedHashMap.this.keys[access$000]);
                    access$000 = CompactLinkedHashMap.this.getSuccessor(access$000);
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Collection<V> createValues() {
        return new CompactHashMap<K, V>.ValuesView() {
            public Object[] toArray() {
                return ObjectArrays.toArrayImpl(this);
            }

            public <T> T[] toArray(T[] tArr) {
                return ObjectArrays.toArrayImpl(this, tArr);
            }

            public Spliterator<V> spliterator() {
                return Spliterators.spliterator(this, 16);
            }

            public void forEach(Consumer<? super V> consumer) {
                Preconditions.checkNotNull(consumer);
                int access$000 = CompactLinkedHashMap.this.firstEntry;
                while (access$000 != -2) {
                    consumer.accept(CompactLinkedHashMap.this.values[access$000]);
                    access$000 = CompactLinkedHashMap.this.getSuccessor(access$000);
                }
            }
        };
    }

    public void clear() {
        super.clear();
        this.firstEntry = -2;
        this.lastEntry = -2;
    }
}
