package io.intercom.android.sdk.models;

final class AutoValue_Upload extends Upload {
    private final String acl;
    private final String awsAccessKey;
    private final String contentType;
    private final int id;
    private final String key;
    private final String policy;
    private final String publicUrl;
    private final String signature;
    private final String successActionStatus;
    private final String uploadDestination;

    AutoValue_Upload(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.id = i;
        if (str != null) {
            this.acl = str;
            if (str2 != null) {
                this.awsAccessKey = str2;
                if (str3 != null) {
                    this.contentType = str3;
                    if (str4 != null) {
                        this.key = str4;
                        if (str5 != null) {
                            this.policy = str5;
                            if (str6 != null) {
                                this.publicUrl = str6;
                                if (str7 != null) {
                                    this.signature = str7;
                                    if (str8 != null) {
                                        this.successActionStatus = str8;
                                        if (str9 != null) {
                                            this.uploadDestination = str9;
                                            return;
                                        }
                                        throw new NullPointerException("Null uploadDestination");
                                    }
                                    throw new NullPointerException("Null successActionStatus");
                                }
                                throw new NullPointerException("Null signature");
                            }
                            throw new NullPointerException("Null publicUrl");
                        }
                        throw new NullPointerException("Null policy");
                    }
                    throw new NullPointerException("Null key");
                }
                throw new NullPointerException("Null contentType");
            }
            throw new NullPointerException("Null awsAccessKey");
        }
        throw new NullPointerException("Null acl");
    }

    public int getId() {
        return this.id;
    }

    public String getAcl() {
        return this.acl;
    }

    public String getAwsAccessKey() {
        return this.awsAccessKey;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getKey() {
        return this.key;
    }

    public String getPolicy() {
        return this.policy;
    }

    public String getPublicUrl() {
        return this.publicUrl;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getSuccessActionStatus() {
        return this.successActionStatus;
    }

    public String getUploadDestination() {
        return this.uploadDestination;
    }

    public String toString() {
        return "Upload{id=" + this.id + ", acl=" + this.acl + ", awsAccessKey=" + this.awsAccessKey + ", contentType=" + this.contentType + ", key=" + this.key + ", policy=" + this.policy + ", publicUrl=" + this.publicUrl + ", signature=" + this.signature + ", successActionStatus=" + this.successActionStatus + ", uploadDestination=" + this.uploadDestination + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Upload)) {
            return false;
        }
        Upload upload = (Upload) obj;
        if (this.id != upload.getId() || !this.acl.equals(upload.getAcl()) || !this.awsAccessKey.equals(upload.getAwsAccessKey()) || !this.contentType.equals(upload.getContentType()) || !this.key.equals(upload.getKey()) || !this.policy.equals(upload.getPolicy()) || !this.publicUrl.equals(upload.getPublicUrl()) || !this.signature.equals(upload.getSignature()) || !this.successActionStatus.equals(upload.getSuccessActionStatus()) || !this.uploadDestination.equals(upload.getUploadDestination())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((((((((((((((this.id ^ 1000003) * 1000003) ^ this.acl.hashCode()) * 1000003) ^ this.awsAccessKey.hashCode()) * 1000003) ^ this.contentType.hashCode()) * 1000003) ^ this.key.hashCode()) * 1000003) ^ this.policy.hashCode()) * 1000003) ^ this.publicUrl.hashCode()) * 1000003) ^ this.signature.hashCode()) * 1000003) ^ this.successActionStatus.hashCode()) * 1000003) ^ this.uploadDestination.hashCode();
    }
}
