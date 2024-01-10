package io.intercom.android.sdk.api;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.intercom.commons.utilities.TimeProvider;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.identity.AppConfig;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DeDuper {
    private static final String CUSTOM_ATTRIBUTES = "custom_attributes";
    private static final String EMPTY_JSON = "{}";
    private static final String PREFS_CACHED_ATTRIBUTES = "CachedAttributes";
    private static final String PREFS_EARLIEST_UPDATE_AT = "EarliestUpdateAt";
    private final Provider<AppConfig> appConfigProvider;
    private final Map<String, Object> cachedAttributes = new HashMap();
    private long earliestUpdateAt = 0;
    private final Gson gson = new Gson();
    private final SharedPreferences prefs;

    public DeDuper(Provider<AppConfig> provider, SharedPreferences sharedPreferences) {
        this.appConfigProvider = provider;
        this.prefs = sharedPreferences;
    }

    public void update(Map<String, ?> map) {
        if (hasExpiredCache()) {
            this.cachedAttributes.clear();
            setEarliestUpdateAt(TimeProvider.SYSTEM.currentTimeMillis());
        }
        if (this.earliestUpdateAt == 0) {
            setEarliestUpdateAt(TimeProvider.SYSTEM.currentTimeMillis());
        }
        Map<String, Object> customAttributes = getCustomAttributes(this.cachedAttributes);
        Map<String, Object> customAttributes2 = getCustomAttributes(map);
        this.cachedAttributes.putAll(map);
        if (!(customAttributes == null || customAttributes2 == null)) {
            this.cachedAttributes.put(CUSTOM_ATTRIBUTES, mergeMaps(customAttributes, customAttributes2));
        }
        persistCachedAttributes();
    }

    public boolean shouldUpdateUser(Map<String, Object> map) {
        if (map.isEmpty() || containsOnlyEmptyCustomAttributes(map)) {
            return false;
        }
        if (hasNewAttributeValues(map) || isEmpty() || hasExpiredCache()) {
            return true;
        }
        return false;
    }

    private static boolean containsOnlyEmptyCustomAttributes(Map<String, Object> map) {
        return map.size() == 1 && Collections.EMPTY_MAP.equals(map.get(CUSTOM_ATTRIBUTES));
    }

    public void reset() {
        this.cachedAttributes.clear();
        this.earliestUpdateAt = 0;
        persistCachedAttributes();
    }

    public void readPersistedCachedAttributes() {
        if (this.prefs.contains(PREFS_CACHED_ATTRIBUTES) && this.prefs.contains(PREFS_EARLIEST_UPDATE_AT)) {
            try {
                this.cachedAttributes.putAll((Map) this.gson.fromJson(this.prefs.getString(PREFS_CACHED_ATTRIBUTES, EMPTY_JSON), Map.class));
                this.earliestUpdateAt = this.prefs.getLong(PREFS_EARLIEST_UPDATE_AT, 0);
            } catch (JsonSyntaxException unused) {
            }
        }
    }

    private void persistCachedAttributes() {
        this.prefs.edit().putString(PREFS_CACHED_ATTRIBUTES, this.gson.toJson((Object) new HashMap(this.cachedAttributes))).putLong(PREFS_EARLIEST_UPDATE_AT, this.earliestUpdateAt).apply();
    }

    private boolean isEmpty() {
        return this.cachedAttributes.isEmpty();
    }

    private boolean hasExpiredCache() {
        if (this.earliestUpdateAt == 0) {
            return false;
        }
        if (TimeProvider.SYSTEM.currentTimeMillis() - this.earliestUpdateAt > this.appConfigProvider.get().getUserUpdateCacheMaxAgeMs()) {
            return true;
        }
        return false;
    }

    private boolean hasNewAttributeValues(Map<String, Object> map) {
        Object value;
        Map<String, Object> customAttributes = getCustomAttributes(this.cachedAttributes);
        Map<String, Object> customAttributes2 = getCustomAttributes(map);
        if (customAttributes2 != null) {
            if (customAttributes == null) {
                return true;
            }
            for (Map.Entry next : customAttributes2.entrySet()) {
                Object value2 = next.getValue();
                if (value2 != null && !value2.equals(customAttributes.get(next.getKey()))) {
                    return true;
                }
            }
        }
        for (Map.Entry next2 : map.entrySet()) {
            if (!CUSTOM_ATTRIBUTES.equals(next2.getKey()) && (value = next2.getValue()) != null && !value.equals(this.cachedAttributes.get(next2.getKey()))) {
                return true;
            }
        }
        return false;
    }

    private static Map<String, Object> getCustomAttributes(Map<String, ?> map) {
        Object obj = map.get(CUSTOM_ATTRIBUTES);
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    private static Map<String, Object> mergeMaps(Map<String, ?> map, Map<String, ?> map2) {
        HashMap hashMap = new HashMap(map);
        hashMap.putAll(map2);
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getMap() {
        return this.cachedAttributes;
    }

    /* access modifiers changed from: package-private */
    public void setEarliestUpdateAt(long j) {
        this.earliestUpdateAt = j;
    }

    /* access modifiers changed from: package-private */
    public long getEarliestUpdateAt() {
        return this.earliestUpdateAt;
    }
}
