package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

public final class AtomicLongMap<K> implements Serializable {
    @MonotonicNonNullDecl
    private transient Map<K, Long> asMap;
    private final ConcurrentHashMap<K, Long> map;

    static /* synthetic */ long lambda$put$4(long j, long j2) {
        return j;
    }

    private AtomicLongMap(ConcurrentHashMap<K, Long> concurrentHashMap) {
        this.map = (ConcurrentHashMap) Preconditions.checkNotNull(concurrentHashMap);
    }

    public static <K> AtomicLongMap<K> create() {
        return new AtomicLongMap<>(new ConcurrentHashMap());
    }

    public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> map2) {
        AtomicLongMap<K> create = create();
        create.putAll(map2);
        return create;
    }

    public long get(K k) {
        return this.map.getOrDefault(k, 0L).longValue();
    }

    public long incrementAndGet(K k) {
        return addAndGet(k, 1);
    }

    public long decrementAndGet(K k) {
        return addAndGet(k, -1);
    }

    public long addAndGet(K k, long j) {
        return accumulateAndGet(k, j, $$Lambda$dplkPhACWDPIy18ogwdupEQaN40.INSTANCE);
    }

    public long getAndIncrement(K k) {
        return getAndAdd(k, 1);
    }

    public long getAndDecrement(K k) {
        return getAndAdd(k, -1);
    }

    public long getAndAdd(K k, long j) {
        return getAndAccumulate(k, j, $$Lambda$dplkPhACWDPIy18ogwdupEQaN40.INSTANCE);
    }

    public long updateAndGet(K k, LongUnaryOperator longUnaryOperator) {
        Preconditions.checkNotNull(longUnaryOperator);
        return this.map.compute(k, new BiFunction(longUnaryOperator) {
            public final /* synthetic */ LongUnaryOperator f$0;

            {
                this.f$0 = r1;
            }

            public final Object apply(Object obj, Object obj2) {
                return AtomicLongMap.lambda$updateAndGet$0(this.f$0, obj, (Long) obj2);
            }
        }).longValue();
    }

    static /* synthetic */ Long lambda$updateAndGet$0(LongUnaryOperator longUnaryOperator, Object obj, Long l) {
        return Long.valueOf(longUnaryOperator.applyAsLong(l == null ? 0 : l.longValue()));
    }

    public long getAndUpdate(K k, LongUnaryOperator longUnaryOperator) {
        Preconditions.checkNotNull(longUnaryOperator);
        AtomicLong atomicLong = new AtomicLong();
        this.map.compute(k, new BiFunction(atomicLong, longUnaryOperator) {
            public final /* synthetic */ AtomicLong f$0;
            public final /* synthetic */ LongUnaryOperator f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Object apply(Object obj, Object obj2) {
                return AtomicLongMap.lambda$getAndUpdate$1(this.f$0, this.f$1, obj, (Long) obj2);
            }
        });
        return atomicLong.get();
    }

    static /* synthetic */ Long lambda$getAndUpdate$1(AtomicLong atomicLong, LongUnaryOperator longUnaryOperator, Object obj, Long l) {
        long longValue = l == null ? 0 : l.longValue();
        atomicLong.set(longValue);
        return Long.valueOf(longUnaryOperator.applyAsLong(longValue));
    }

    public long accumulateAndGet(K k, long j, LongBinaryOperator longBinaryOperator) {
        Preconditions.checkNotNull(longBinaryOperator);
        return updateAndGet(k, new LongUnaryOperator(longBinaryOperator, j) {
            public final /* synthetic */ LongBinaryOperator f$0;
            public final /* synthetic */ long f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final long applyAsLong(long j) {
                return this.f$0.applyAsLong(j, this.f$1);
            }
        });
    }

    public long getAndAccumulate(K k, long j, LongBinaryOperator longBinaryOperator) {
        Preconditions.checkNotNull(longBinaryOperator);
        return getAndUpdate(k, new LongUnaryOperator(longBinaryOperator, j) {
            public final /* synthetic */ LongBinaryOperator f$0;
            public final /* synthetic */ long f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final long applyAsLong(long j) {
                return this.f$0.applyAsLong(j, this.f$1);
            }
        });
    }

    public long put(K k, long j) {
        return getAndUpdate(k, new LongUnaryOperator(j) {
            public final /* synthetic */ long f$0;

            {
                this.f$0 = r1;
            }

            public final long applyAsLong(long j) {
                return AtomicLongMap.lambda$put$4(this.f$0, j);
            }
        });
    }

    public void putAll(Map<? extends K, ? extends Long> map2) {
        map2.forEach(new BiConsumer() {
            public final void accept(Object obj, Object obj2) {
                AtomicLongMap.this.put(obj, ((Long) obj2).longValue());
            }
        });
    }

    public long remove(K k) {
        Long remove = this.map.remove(k);
        if (remove == null) {
            return 0;
        }
        return remove.longValue();
    }

    /* access modifiers changed from: package-private */
    public boolean remove(K k, long j) {
        return this.map.remove(k, Long.valueOf(j));
    }

    public boolean removeIfZero(K k) {
        return remove(k, 0);
    }

    static /* synthetic */ boolean lambda$removeAllZeros$5(Long l) {
        return l.longValue() == 0;
    }

    public void removeAllZeros() {
        this.map.values().removeIf($$Lambda$AtomicLongMap$49jqsgGfolS7k5Y0w5CKFvjzFZk.INSTANCE);
    }

    public long sum() {
        return this.map.values().stream().mapToLong($$Lambda$ELHKvd8JMVRD8rbALqYPKbDX2mM.INSTANCE).sum();
    }

    public Map<K, Long> asMap() {
        Map<K, Long> map2 = this.asMap;
        if (map2 != null) {
            return map2;
        }
        Map<K, Long> createAsMap = createAsMap();
        this.asMap = createAsMap;
        return createAsMap;
    }

    private Map<K, Long> createAsMap() {
        return Collections.unmodifiableMap(this.map);
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public void clear() {
        this.map.clear();
    }

    public String toString() {
        return this.map.toString();
    }

    /* access modifiers changed from: package-private */
    public long putIfAbsent(K k, long j) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Long compute = this.map.compute(k, new BiFunction(atomicBoolean, j) {
            public final /* synthetic */ AtomicBoolean f$0;
            public final /* synthetic */ long f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Object apply(Object obj, Object obj2) {
                return AtomicLongMap.lambda$putIfAbsent$6(this.f$0, this.f$1, obj, (Long) obj2);
            }
        });
        if (atomicBoolean.get()) {
            return 0;
        }
        return compute.longValue();
    }

    static /* synthetic */ Long lambda$putIfAbsent$6(AtomicBoolean atomicBoolean, long j, Object obj, Long l) {
        if (l != null && l.longValue() != 0) {
            return l;
        }
        atomicBoolean.set(true);
        return Long.valueOf(j);
    }

    /* access modifiers changed from: package-private */
    public boolean replace(K k, long j, long j2) {
        if (j == 0) {
            return putIfAbsent(k, j2) == 0;
        }
        return this.map.replace(k, Long.valueOf(j), Long.valueOf(j2));
    }
}
