package com.google.common.collect;

interface FilteredSetMultimap<K, V> extends FilteredMultimap<K, V>, SetMultimap<K, V> {

    /* renamed from: com.google.common.collect.FilteredSetMultimap$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    SetMultimap<K, V> unfiltered();
}
