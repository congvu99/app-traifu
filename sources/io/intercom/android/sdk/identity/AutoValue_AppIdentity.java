package io.intercom.android.sdk.identity;

final class AutoValue_AppIdentity extends AppIdentity {
    private final String apiKey;
    private final String appId;

    AutoValue_AppIdentity(String str, String str2) {
        if (str != null) {
            this.apiKey = str;
            if (str2 != null) {
                this.appId = str2;
                return;
            }
            throw new NullPointerException("Null appId");
        }
        throw new NullPointerException("Null apiKey");
    }

    public String apiKey() {
        return this.apiKey;
    }

    public String appId() {
        return this.appId;
    }

    public String toString() {
        return "AppIdentity{apiKey=" + this.apiKey + ", appId=" + this.appId + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppIdentity)) {
            return false;
        }
        AppIdentity appIdentity = (AppIdentity) obj;
        if (!this.apiKey.equals(appIdentity.apiKey()) || !this.appId.equals(appIdentity.appId())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.apiKey.hashCode() ^ 1000003) * 1000003) ^ this.appId.hashCode();
    }
}
