package io.intercom.android.sdk.models;

final class AutoValue_ReplyOption extends ReplyOption {
    private final String text;
    private final String uuid;

    AutoValue_ReplyOption(String str, String str2) {
        if (str != null) {
            this.text = str;
            if (str2 != null) {
                this.uuid = str2;
                return;
            }
            throw new NullPointerException("Null uuid");
        }
        throw new NullPointerException("Null text");
    }

    public String text() {
        return this.text;
    }

    public String uuid() {
        return this.uuid;
    }

    public String toString() {
        return "ReplyOption{text=" + this.text + ", uuid=" + this.uuid + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReplyOption)) {
            return false;
        }
        ReplyOption replyOption = (ReplyOption) obj;
        if (!this.text.equals(replyOption.text()) || !this.uuid.equals(replyOption.uuid())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.text.hashCode() ^ 1000003) * 1000003) ^ this.uuid.hashCode();
    }
}
