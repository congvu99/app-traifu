package io.sentry.config;

import io.sentry.config.PropertiesProvider;
import io.sentry.util.StringUtils;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class EnvironmentVariablePropertiesProvider implements PropertiesProvider {
    private static final String PREFIX = "SENTRY";

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

    EnvironmentVariablePropertiesProvider() {
    }

    public String getProperty(String str) {
        return StringUtils.removeSurrounding(System.getenv(propertyToEnvironmentVariableName(str)), "\"");
    }

    public Map<String, String> getMap(String str) {
        String str2 = propertyToEnvironmentVariableName(str) + "_";
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry next : System.getenv().entrySet()) {
            String str3 = (String) next.getKey();
            if (str3.startsWith(str2)) {
                concurrentHashMap.put(str3.substring(str2.length()).toLowerCase(Locale.ROOT), StringUtils.removeSurrounding((String) next.getValue(), "\""));
            }
        }
        return concurrentHashMap;
    }

    private String propertyToEnvironmentVariableName(String str) {
        return "SENTRY_" + str.replace(".", "_").replace("-", "_").toUpperCase(Locale.ROOT);
    }
}
