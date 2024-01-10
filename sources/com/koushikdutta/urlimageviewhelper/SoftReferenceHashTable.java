package com.koushikdutta.urlimageviewhelper;

import java.lang.ref.SoftReference;
import java.util.Hashtable;

public class SoftReferenceHashTable<K, V> {
    Hashtable<K, SoftReference<V>> mTable = new Hashtable<>();

    public V put(K k, V v) {
        SoftReference put = this.mTable.put(k, new SoftReference(v));
        if (put == null) {
            return null;
        }
        return put.get();
    }

    public V get(K k) {
        SoftReference softReference = this.mTable.get(k);
        if (softReference == null) {
            return null;
        }
        V v = softReference.get();
        if (v == null) {
            this.mTable.remove(k);
        }
        return v;
    }

    public V remove(K k) {
        SoftReference remove = this.mTable.remove(k);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }
}
