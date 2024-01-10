package io.sentry.protocol;

import io.sentry.IUnknownPropertiesConsumer;
import io.sentry.util.CollectionUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class OperatingSystem implements IUnknownPropertiesConsumer, Cloneable {
    public static final String TYPE = "os";
    private String build;
    private String kernelVersion;
    private String name;
    private String rawDescription;
    private Boolean rooted;
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

    public String getBuild() {
        return this.build;
    }

    public void setBuild(String str) {
        this.build = str;
    }

    public String getKernelVersion() {
        return this.kernelVersion;
    }

    public void setKernelVersion(String str) {
        this.kernelVersion = str;
    }

    public Boolean isRooted() {
        return this.rooted;
    }

    public void setRooted(Boolean bool) {
        this.rooted = bool;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = new ConcurrentHashMap(map);
    }

    public OperatingSystem clone() throws CloneNotSupportedException {
        OperatingSystem operatingSystem = (OperatingSystem) super.clone();
        operatingSystem.unknown = CollectionUtils.shallowCopy(this.unknown);
        return operatingSystem;
    }
}
