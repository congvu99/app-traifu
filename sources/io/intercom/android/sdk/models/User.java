package io.intercom.android.sdk.models;

import com.google.gson.annotations.SerializedName;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.utilities.NullSafety;

public class User {
    public static final User NULL = new User();
    @SerializedName("anonymous_id")
    private final String anonymousId;
    private final String email;
    @SerializedName("encrypted_user_id")
    private final String encryptedUserId;
    @SerializedName("intercom_id")
    private final String intercomId;
    @SerializedName("user_id")
    private final String userId;

    public User() {
        this.intercomId = "";
        this.encryptedUserId = "";
        this.anonymousId = "";
        this.userId = "";
        this.email = "";
    }

    User(Builder builder) {
        this.intercomId = NullSafety.valueOrEmpty(builder.intercom_id);
        this.encryptedUserId = NullSafety.valueOrEmpty(builder.encrypted_user_id);
        this.anonymousId = NullSafety.valueOrEmpty(builder.anonymous_id);
        this.userId = NullSafety.valueOrEmpty(builder.user_id);
        this.email = NullSafety.valueOrEmpty(builder.email);
    }

    public String getIntercomId() {
        return this.intercomId;
    }

    public String getEncryptedUserId() {
        return this.encryptedUserId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getEmail() {
        return this.email;
    }

    public String getAnonymousId() {
        return this.anonymousId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        if (this.intercomId.equals(user.intercomId) && this.encryptedUserId.equals(user.encryptedUserId) && this.anonymousId.equals(user.anonymousId) && this.userId.equals(user.userId)) {
            return this.email.equals(user.email);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.intercomId.hashCode() * 31) + this.encryptedUserId.hashCode()) * 31) + this.anonymousId.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.email.hashCode();
    }

    public static final class Builder {
        String anonymous_id;
        private Avatar.Builder avatar;
        String email;
        String encrypted_user_id;
        String intercom_id;
        String user_id;

        public Builder withIntercomId(String str) {
            this.intercom_id = str;
            return this;
        }

        public Builder withEncryptedUserId(String str) {
            this.encrypted_user_id = str;
            return this;
        }

        public Builder withAnonymousId(String str) {
            this.anonymous_id = str;
            return this;
        }

        public Builder withUserId(String str) {
            this.user_id = str;
            return this;
        }

        public Builder withEmail(String str) {
            this.email = str;
            return this;
        }

        public Builder withAvatar(Avatar.Builder builder) {
            this.avatar = builder;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
