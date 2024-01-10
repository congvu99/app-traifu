package io.intercom.android.sdk.models;

final class AutoValue_Attachments extends Attachments {
    private final String contentType;
    private final String name;
    private final String url;

    AutoValue_Attachments(String str, String str2, String str3) {
        if (str != null) {
            this.name = str;
            if (str2 != null) {
                this.url = str2;
                if (str3 != null) {
                    this.contentType = str3;
                    return;
                }
                throw new NullPointerException("Null contentType");
            }
            throw new NullPointerException("Null url");
        }
        throw new NullPointerException("Null name");
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String toString() {
        return "Attachments{name=" + this.name + ", url=" + this.url + ", contentType=" + this.contentType + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Attachments)) {
            return false;
        }
        Attachments attachments = (Attachments) obj;
        if (!this.name.equals(attachments.getName()) || !this.url.equals(attachments.getUrl()) || !this.contentType.equals(attachments.getContentType())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((this.name.hashCode() ^ 1000003) * 1000003) ^ this.url.hashCode()) * 1000003) ^ this.contentType.hashCode();
    }
}
