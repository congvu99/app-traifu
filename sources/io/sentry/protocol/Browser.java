package io.sentry.protocol;

import io.sentry.IUnknownPropertiesConsumer;
import io.sentry.util.CollectionUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Browser implements IUnknownPropertiesConsumer, Cloneable {
    public static final String TYPE = "browser";
    private String name;
    private Map<String, Object> unknown;
    private String version;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = new ConcurrentHashMap(map);
    }

    public Browser clone() throws CloneNotSupportedException {
        Browser browser = (Browser) super.clone();
        browser.unknown = CollectionUtils.shallowCopy(this.unknown);
        return browser;
    }
}
