package io.sentry.config;

import io.sentry.config.PropertiesProvider;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class CompositePropertiesProvider implements PropertiesProvider {
    private final List<PropertiesProvider> providers;

    public /* synthetic */ Boolean getBooleanProperty(String str) {
        return PropertiesProvider.CC.$default$getBooleanProperty(this, str);
    }

    public /* synthetic */ Double getDoubleProperty(String str) {
        return PropertiesProvider.CC.$default$getDoubleProperty(this, str);
    }

    public /* synthetic */ List<String> getList(String str) {
        return PropertiesProvider.CC.$default$getList(this, str);
    }

    public /* synthetic */ String getProperty(String str, String str2) {
        return PropertiesProvider.CC.$default$getProperty(this, str, str2);
    }

    public CompositePropertiesProvider(List<PropertiesProvider> list) {
        this.providers = list;
    }

    public String getProperty(String str) {
        for (PropertiesProvider property : this.providers) {
            String property2 = property.getProperty(str);
            if (property2 != null) {
                return property2;
            }
        }
        return null;
    }

    public Map<String, String> getMap(String str) {
        for (PropertiesProvider map : this.providers) {
            Map<String, String> map2 = map.getMap(str);
            if (!map2.isEmpty()) {
                return map2;
            }
        }
        return new ConcurrentHashMap();
    }
}
