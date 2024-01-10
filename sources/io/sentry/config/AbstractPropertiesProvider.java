package io.sentry.config;

import io.sentry.config.PropertiesProvider;
import io.sentry.util.Objects;
import io.sentry.util.StringUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

abstract class AbstractPropertiesProvider implements PropertiesProvider {
    private final String prefix;
    private final Properties properties;

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

    protected AbstractPropertiesProvider(String str, Properties properties2) {
        this.prefix = (String) Objects.requireNonNull(str, "prefix is required");
        this.properties = (Properties) Objects.requireNonNull(properties2, "properties are required");
    }

    protected AbstractPropertiesProvider(Properties properties2) {
        this("", properties2);
    }

    public String getProperty(String str) {
        Properties properties2 = this.properties;
        return StringUtils.removeSurrounding(properties2.getProperty(this.prefix + str), "\"");
    }

    public Map<String, String> getMap(String str) {
        String str2 = this.prefix + str + ".";
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.properties.entrySet()) {
            if ((entry.getKey() instanceof String) && (entry.getValue() instanceof String)) {
                String str3 = (String) entry.getKey();
                if (str3.startsWith(str2)) {
                    hashMap.put(str3.substring(str2.length()), StringUtils.removeSurrounding((String) entry.getValue(), "\""));
                }
            }
        }
        return hashMap;
    }
}
