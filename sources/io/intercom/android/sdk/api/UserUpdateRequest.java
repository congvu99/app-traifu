package io.intercom.android.sdk.api;

import java.util.HashMap;
import java.util.Map;

public abstract class UserUpdateRequest {
    public abstract Map<String, Object> getAttributes();

    public abstract boolean isInternalUpdate();

    public abstract boolean isNewSession();

    public abstract boolean isSentFromBackground();

    public static UserUpdateRequest create(boolean z, boolean z2, Map<String, Object> map, boolean z3) {
        return new Builder().isNewSession(z).isSentFromBackground(z2).withAttributes(map).isInternalUpdate(z3).build();
    }

    public static UserUpdateRequest create(boolean z, boolean z2, boolean z3) {
        return create(z, z2, (Map<String, Object>) null, z3);
    }

    public boolean isValidUpdate() {
        return isInternalUpdate() || !getAttributes().isEmpty();
    }

    public static final class Builder {
        Map<String, Object> attributes;
        boolean isInternalUpdate = false;
        boolean isNewSession = false;
        boolean isSentFromBackground = true;

        public Builder isNewSession(boolean z) {
            this.isNewSession = z;
            return this;
        }

        public Builder isSentFromBackground(boolean z) {
            this.isSentFromBackground = z;
            return this;
        }

        public Builder isInternalUpdate(boolean z) {
            this.isInternalUpdate = z;
            return this;
        }

        public Builder withAttributes(Map<String, Object> map) {
            this.attributes = map;
            return this;
        }

        public UserUpdateRequest build() {
            HashMap hashMap = new HashMap();
            Map<String, Object> map = this.attributes;
            if (map != null) {
                hashMap.putAll(map);
            }
            return new AutoValue_UserUpdateRequest(this.isNewSession, this.isSentFromBackground, this.isInternalUpdate, hashMap);
        }
    }
}
