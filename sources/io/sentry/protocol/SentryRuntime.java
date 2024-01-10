package io.sentry.protocol;

import io.sentry.IUnknownPropertiesConsumer;
import io.sentry.util.CollectionUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class SentryRuntime implements IUnknownPropertiesConsumer, Cloneable {
    public static final String TYPE = "runtime";
    private String name;
    private String rawDescription;
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

    public String getRawDescription() {
        return this.rawDescription;
    }

    public void setRawDescription(String str) {
        this.rawDescription = str;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = new ConcurrentHashMap(map);
    }

    public SentryRuntime clone() throws CloneNotSupportedException {
        SentryRuntime sentryRuntime = (SentryRuntime) super.clone();
        sentryRuntime.unknown = CollectionUtils.shallowCopy(this.unknown);
        return sentryRuntime;
    }
}
