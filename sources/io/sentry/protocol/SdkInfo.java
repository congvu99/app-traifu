package io.sentry.protocol;

import io.sentry.IUnknownPropertiesConsumer;
import java.util.Map;

public final class SdkInfo implements IUnknownPropertiesConsumer {
    private String sdkName;
    private Map<String, Object> unknown;
    private Integer versionMajor;
    private Integer versionMinor;
    private Integer versionPatchlevel;

    public String getSdkName() {
        return this.sdkName;
    }

    public void setSdkName(String str) {
        this.sdkName = str;
    }

    public Integer getVersionMajor() {
        return this.versionMajor;
    }

    public void setVersionMajor(Integer num) {
        this.versionMajor = num;
    }

    public Integer getVersionMinor() {
        return this.versionMinor;
    }

    public void setVersionMinor(Integer num) {
        this.versionMinor = num;
    }

    public Integer getVersionPatchlevel() {
        return this.versionPatchlevel;
    }

    public void setVersionPatchlevel(Integer num) {
        this.versionPatchlevel = num;
    }

    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = map;
    }
}
