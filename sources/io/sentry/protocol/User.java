package io.sentry.protocol;

import io.sentry.IUnknownPropertiesConsumer;
import io.sentry.util.CollectionUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class User implements Cloneable, IUnknownPropertiesConsumer {
    private String email;
    private String id;
    private String ipAddress;
    private Map<String, String> other;
    private Map<String, Object> unknown;
    private String username;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setIpAddress(String str) {
        this.ipAddress = str;
    }

    public Map<String, String> getOthers() {
        return this.other;
    }

    public void setOthers(Map<String, String> map) {
        if (map != null) {
            this.other = new ConcurrentHashMap(map);
        } else {
            this.other = null;
        }
    }

    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = new ConcurrentHashMap(map);
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public User clone() throws CloneNotSupportedException {
        User user = (User) super.clone();
        user.other = CollectionUtils.shallowCopy(this.other);
        user.unknown = CollectionUtils.shallowCopy(this.unknown);
        return user;
    }
}
