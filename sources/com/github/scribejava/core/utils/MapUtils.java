package com.github.scribejava.core.utils;

import java.util.Map;

public abstract class MapUtils {
    public static <K, V> String toString(Map<K, V> map) {
        if (map == null) {
            return "";
        }
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            sb.append(String.format(", %s -> %s ", new Object[]{next.getKey().toString(), next.getValue().toString()}));
        }
        return "{" + sb.substring(1) + "}";
    }
}
