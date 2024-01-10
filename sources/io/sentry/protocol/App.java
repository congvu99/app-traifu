package io.sentry.protocol;

import io.sentry.IUnknownPropertiesConsumer;
import io.sentry.util.CollectionUtils;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class App implements IUnknownPropertiesConsumer, Cloneable {
    public static final String TYPE = "app";
    private String appBuild;
    private String appIdentifier;
    private String appName;
    private Date appStartTime;
    private String appVersion;
    private String buildType;
    private String deviceAppHash;
    private Map<String, Object> unknown;

    public String getAppIdentifier() {
        return this.appIdentifier;
    }

    public void setAppIdentifier(String str) {
        this.appIdentifier = str;
    }

    public Date getAppStartTime() {
        Date date = this.appStartTime;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void setAppStartTime(Date date) {
        this.appStartTime = date;
    }

    public String getDeviceAppHash() {
        return this.deviceAppHash;
    }

    public void setDeviceAppHash(String str) {
        this.deviceAppHash = str;
    }

    public String getBuildType() {
        return this.buildType;
    }

    public void setBuildType(String str) {
        this.buildType = str;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public String getAppBuild() {
        return this.appBuild;
    }

    public void setAppBuild(String str) {
        this.appBuild = str;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = new ConcurrentHashMap(map);
    }

    public App clone() throws CloneNotSupportedException {
        App app = (App) super.clone();
        app.unknown = CollectionUtils.shallowCopy(this.unknown);
        return app;
    }
}
