package com.google.common.collect;

import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public interface BiMap<K, V> extends Map<K, V> {

    /* renamed from: com.google.common.collect.BiMap$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    @NullableDecl
    V forcePut(@NullableDecl K k, @NullableDecl V v);

    BiMap<V, K> inverse();

    @NullableDecl
    V put(@NullableDecl K k, @NullableDecl V v);

    void putAll(Map<? extends K, ? extends V> map);

    Set<V> values();
}
