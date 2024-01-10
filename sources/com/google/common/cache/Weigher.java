package com.google.common.cache;

@FunctionalInterface
public interface Weigher<K, V> {
    int weigh(K k, V v);
}
