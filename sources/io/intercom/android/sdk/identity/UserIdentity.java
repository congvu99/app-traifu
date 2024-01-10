package io.intercom.android.sdk.identity;

import android.content.Context;
import android.content.SharedPreferences;
import io.intercom.android.sdk.models.User;
import io.intercom.android.sdk.utilities.PreferenceKeys;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserIdentity {
    public static final String ANONYMOUS_ID = "anonymous_id";
    public static final String EMAIL = "email";
    public static final String INTERCOM_ID = "intercom_id";
    private static final String KEY_ANONYMOUS_ID = "INTERCOM_SDK_ANONYMOUS_ID";
    private static final String KEY_EMAIL_ID = "INTERCOM_SDK_EMAIL_ID";
    private static final String KEY_INTERCOM_ID = "INTERCOM_SDK_INTERCOM_ID";
    private static final String KEY_PREFIX = "intercomsdk-session-";
    private static final String KEY_SECURE_HMAC = "SecureMode_HMAC";
    private static final String KEY_USER_ID = "INTERCOM_SDK_USER_ID";
    private static final String TYPE = "type";
    private static final String USER = "user";
    private static final String USER_ID = "user_id";
    private String anonymousId;
    private String email;
    private String encryptedUserId;
    private String fingerprint = "";
    private String hmac;
    private String intercomId;
    private final SharedPreferences prefs;
    private SoftUserIdentity softUserIdentity = SoftUserIdentity.NONE;
    private String userId;

    public UserIdentity(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PreferenceKeys.INTERCOM_USER_PREFS, 0);
        this.prefs = sharedPreferences;
        this.anonymousId = sharedPreferences.getString("intercomsdk-session-INTERCOM_SDK_ANONYMOUS_ID", "");
        this.intercomId = this.prefs.getString("intercomsdk-session-INTERCOM_SDK_INTERCOM_ID", "");
        this.userId = this.prefs.getString("intercomsdk-session-INTERCOM_SDK_USER_ID", "");
        this.email = this.prefs.getString("intercomsdk-session-INTERCOM_SDK_EMAIL_ID", "");
        this.hmac = this.prefs.getString("intercomsdk-session-SecureMode_HMAC", "");
        this.encryptedUserId = "";
        if (identityExists()) {
            this.fingerprint = generateFingerprint();
        }
    }

    public boolean canRegisterIdentifiedUser(Registration registration) {
        return registration.isValidRegistration() && !isIdentified();
    }

    public boolean canRegisterUnidentifiedUser() {
        return !identityExists();
    }

    public void registerIdentifiedUser(Registration registration) {
        this.intercomId = "";
        SharedPreferences.Editor putString = this.prefs.edit().putString("intercomsdk-session-INTERCOM_SDK_INTERCOM_ID", this.intercomId);
        if (!registration.getUserId().isEmpty()) {
            String userId2 = registration.getUserId();
            this.userId = userId2;
            putString.putString("intercomsdk-session-INTERCOM_SDK_USER_ID", userId2);
        }
        if (!registration.getEmail().isEmpty()) {
            String email2 = registration.getEmail();
            this.email = email2;
            putString.putString("intercomsdk-session-INTERCOM_SDK_EMAIL_ID", email2);
        }
        putString.apply();
        if (this.fingerprint.isEmpty()) {
            this.fingerprint = generateFingerprint();
        }
    }

    public void registerUnidentifiedUser() {
        this.anonymousId = UUID.randomUUID().toString();
        this.prefs.edit().putString("intercomsdk-session-INTERCOM_SDK_ANONYMOUS_ID", this.anonymousId).apply();
        if (this.fingerprint.isEmpty()) {
            this.fingerprint = generateFingerprint();
        }
    }

    public void update(User user) {
        if (user != User.NULL) {
            this.userId = user.getUserId();
            this.email = user.getEmail();
            this.anonymousId = user.getAnonymousId();
            this.encryptedUserId = user.getEncryptedUserId();
            SharedPreferences.Editor putString = this.prefs.edit().putString("intercomsdk-session-INTERCOM_SDK_USER_ID", this.userId).putString("intercomsdk-session-INTERCOM_SDK_EMAIL_ID", this.email).putString("intercomsdk-session-INTERCOM_SDK_ANONYMOUS_ID", this.anonymousId);
            if (!user.getIntercomId().isEmpty()) {
                String intercomId2 = user.getIntercomId();
                this.intercomId = intercomId2;
                putString.putString("intercomsdk-session-INTERCOM_SDK_INTERCOM_ID", intercomId2);
            }
            putString.apply();
        }
    }

    public void setUserHash(String str) {
        this.hmac = str;
        this.prefs.edit().putString("intercomsdk-session-SecureMode_HMAC", str).apply();
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

    public String getHmac() {
        return this.hmac;
    }

    public String getIntercomId() {
        return this.intercomId;
    }

    public String getEncryptedUserId() {
        return this.encryptedUserId;
    }

    public String getFingerprint() {
        return this.fingerprint;
    }

    public boolean hasIntercomId() {
        return !getIntercomId().isEmpty();
    }

    public boolean identityExists() {
        return !this.email.isEmpty() || !this.userId.isEmpty() || !this.intercomId.isEmpty() || !this.anonymousId.isEmpty();
    }

    public boolean isIdentified() {
        return identityExists() && !isUnidentified();
    }

    public boolean isUnidentified() {
        return !this.anonymousId.isEmpty() && this.email.isEmpty() && this.userId.isEmpty();
    }

    public void hardReset() {
        this.softUserIdentity = SoftUserIdentity.NONE;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        if (!this.anonymousId.isEmpty()) {
            hashMap.put(ANONYMOUS_ID, this.anonymousId);
        } else if (!this.intercomId.isEmpty()) {
            hashMap.put(INTERCOM_ID, this.intercomId);
        }
        if (!this.userId.isEmpty()) {
            hashMap.put("user_id", this.userId);
        }
        if (!this.email.isEmpty()) {
            hashMap.put("email", this.email);
        }
        hashMap.put("type", "user");
        return hashMap;
    }

    private String generateFingerprint() {
        return UUID.randomUUID().toString();
    }

    public boolean registrationHasAttributes(Registration registration) {
        return (registration == null || registration.getAttributes() == null || registration.getAttributes().isEmpty()) ? false : true;
    }

    public boolean isSameUser(Registration registration) {
        if (isUnidentified()) {
            return false;
        }
        return this.softUserIdentity.isSameUser(registration);
    }

    public boolean softUserIdentityHmacDiffers(String str) {
        return this.softUserIdentity.isPresent() && !getSoftUserIdentityHmac().equals(str);
    }

    public String getSoftUserIdentityHmac() {
        return this.softUserIdentity.hmac();
    }

    public void softReset() {
        if (!isSoftReset()) {
            this.softUserIdentity = SoftUserIdentity.create(this.anonymousId, this.email, this.fingerprint, this.hmac, this.intercomId, this.userId, this.encryptedUserId);
            this.prefs.edit().clear().apply();
            this.anonymousId = "";
            this.intercomId = "";
            this.encryptedUserId = "";
            this.userId = "";
            this.email = "";
            this.hmac = "";
            this.fingerprint = "";
        }
    }

    public boolean isSoftReset() {
        return this.softUserIdentity.isPresent();
    }

    public void softRestart() {
        this.userId = this.softUserIdentity.userId();
        this.email = this.softUserIdentity.email();
        this.anonymousId = this.softUserIdentity.anonymousId();
        this.intercomId = this.softUserIdentity.intercomId();
        this.encryptedUserId = this.softUserIdentity.encryptedUserId();
        this.hmac = this.softUserIdentity.hmac();
        this.fingerprint = this.softUserIdentity.fingerprint();
        this.prefs.edit().putString("intercomsdk-session-INTERCOM_SDK_USER_ID", this.userId).putString("intercomsdk-session-INTERCOM_SDK_EMAIL_ID", this.email).putString("intercomsdk-session-INTERCOM_SDK_ANONYMOUS_ID", this.anonymousId).putString("intercomsdk-session-INTERCOM_SDK_INTERCOM_ID", this.intercomId).apply();
        this.softUserIdentity = SoftUserIdentity.NONE;
    }
}
