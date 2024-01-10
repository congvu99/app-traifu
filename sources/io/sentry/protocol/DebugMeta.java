package io.sentry.protocol;

import io.sentry.IUnknownPropertiesConsumer;
import java.util.List;
import java.util.Map;

public final class DebugMeta implements IUnknownPropertiesConsumer {
    private List<DebugImage> images;
    private SdkInfo sdkInfo;
    private Map<String, Object> unknown;

    public List<DebugImage> getImages() {
        return this.images;
    }

    public void setImages(List<DebugImage> list) {
        this.images = list;
    }

    public SdkInfo getSdkInfo() {
        return this.sdkInfo;
    }

    public void setSdkInfo(SdkInfo sdkInfo2) {
        this.sdkInfo = sdkInfo2;
    }

    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = map;
    }
}
