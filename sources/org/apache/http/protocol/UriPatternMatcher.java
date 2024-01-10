package org.apache.http.protocol;

import androidx.webkit.ProxyConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.http.util.Args;

public class UriPatternMatcher<T> {
    private final Map<String, T> map = new HashMap();

    public synchronized Set<Map.Entry<String, T>> entrySet() {
        return new HashSet(this.map.entrySet());
    }

    public synchronized void register(String str, T t) {
        Args.notNull(str, "URI request pattern");
        this.map.put(str, t);
    }

    public synchronized void unregister(String str) {
        if (str != null) {
            this.map.remove(str);
        }
    }

    @Deprecated
    public synchronized void setHandlers(Map<String, T> map2) {
        Args.notNull(map2, "Map of handlers");
        this.map.clear();
        this.map.putAll(map2);
    }

    @Deprecated
    public synchronized void setObjects(Map<String, T> map2) {
        Args.notNull(map2, "Map of handlers");
        this.map.clear();
        this.map.putAll(map2);
    }

    @Deprecated
    public synchronized Map<String, T> getObjects() {
        return this.map;
    }

    public synchronized T lookup(String str) {
        T t;
        Args.notNull(str, "Request path");
        t = this.map.get(str);
        if (t == null) {
            String str2 = null;
            for (String next : this.map.keySet()) {
                if (matchUriRequestPattern(next, str) && (str2 == null || str2.length() < next.length() || (str2.length() == next.length() && next.endsWith(ProxyConfig.MATCH_ALL_SCHEMES)))) {
                    t = this.map.get(next);
                    str2 = next;
                }
            }
        }
        return t;
    }

    /* access modifiers changed from: protected */
    public boolean matchUriRequestPattern(String str, String str2) {
        if (str.equals(ProxyConfig.MATCH_ALL_SCHEMES)) {
            return true;
        }
        if (str.endsWith(ProxyConfig.MATCH_ALL_SCHEMES) && str2.startsWith(str.substring(0, str.length() - 1))) {
            return true;
        }
        if (!str.startsWith(ProxyConfig.MATCH_ALL_SCHEMES) || !str2.endsWith(str.substring(1, str.length()))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.map.toString();
    }
}
