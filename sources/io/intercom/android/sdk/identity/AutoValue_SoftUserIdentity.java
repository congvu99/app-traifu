package io.intercom.android.sdk.identity;

final class AutoValue_SoftUserIdentity extends SoftUserIdentity {
    private final String anonymousId;
    private final String email;
    private final String encryptedUserId;
    private final String fingerprint;
    private final String hmac;
    private final String intercomId;
    private final String userId;

    AutoValue_SoftUserIdentity(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (str != null) {
            this.anonymousId = str;
            if (str2 != null) {
                this.email = str2;
                if (str3 != null) {
                    this.fingerprint = str3;
                    if (str4 != null) {
                        this.hmac = str4;
                        if (str5 != null) {
                            this.intercomId = str5;
                            if (str6 != null) {
                                this.userId = str6;
                                if (str7 != null) {
                                    this.encryptedUserId = str7;
                                    return;
                                }
                                throw new NullPointerException("Null encryptedUserId");
                            }
                            throw new NullPointerException("Null userId");
                        }
                        throw new NullPointerException("Null intercomId");
                    }
                    throw new NullPointerException("Null hmac");
                }
                throw new NullPointerException("Null fingerprint");
            }
            throw new NullPointerException("Null email");
        }
        throw new NullPointerException("Null anonymousId");
    }

    /* access modifiers changed from: package-private */
    public String anonymousId() {
        return this.anonymousId;
    }

    /* access modifiers changed from: package-private */
    public String email() {
        return this.email;
    }

    /* access modifiers changed from: package-private */
    public String fingerprint() {
        return this.fingerprint;
    }

    /* access modifiers changed from: package-private */
    public String hmac() {
        return this.hmac;
    }

    /* access modifiers changed from: package-private */
    public String intercomId() {
        return this.intercomId;
    }

    /* access modifiers changed from: package-private */
    public String userId() {
        return this.userId;
    }

    /* access modifiers changed from: package-private */
    public String encryptedUserId() {
        return this.encryptedUserId;
    }

    public String toString() {
        return "SoftUserIdentity{anonymousId=" + this.anonymousId + ", email=" + this.email + ", fingerprint=" + this.fingerprint + ", hmac=" + this.hmac + ", intercomId=" + this.intercomId + ", userId=" + this.userId + ", encryptedUserId=" + this.encryptedUserId + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SoftUserIdentity)) {
            return false;
        }
        SoftUserIdentity softUserIdentity = (SoftUserIdentity) obj;
        if (!this.anonymousId.equals(softUserIdentity.anonymousId()) || !this.email.equals(softUserIdentity.email()) || !this.fingerprint.equals(softUserIdentity.fingerprint()) || !this.hmac.equals(softUserIdentity.hmac()) || !this.intercomId.equals(softUserIdentity.intercomId()) || !this.userId.equals(softUserIdentity.userId()) || !this.encryptedUserId.equals(softUserIdentity.encryptedUserId())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((((((((this.anonymousId.hashCode() ^ 1000003) * 1000003) ^ this.email.hashCode()) * 1000003) ^ this.fingerprint.hashCode()) * 1000003) ^ this.hmac.hashCode()) * 1000003) ^ this.intercomId.hashCode()) * 1000003) ^ this.userId.hashCode()) * 1000003) ^ this.encryptedUserId.hashCode();
    }
}
