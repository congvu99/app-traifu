package io.intercom.android.sdk.models;

final class AutoValue_Suggestion extends Suggestion {
    private final String preAction;
    private final String text;
    private final String uuid;

    AutoValue_Suggestion(String str, String str2, String str3) {
        if (str != null) {
            this.preAction = str;
            if (str2 != null) {
                this.text = str2;
                if (str3 != null) {
                    this.uuid = str3;
                    return;
                }
                throw new NullPointerException("Null uuid");
            }
            throw new NullPointerException("Null text");
        }
        throw new NullPointerException("Null preAction");
    }

    public String getPreAction() {
        return this.preAction;
    }

    public String getText() {
        return this.text;
    }

    public String getUuid() {
        return this.uuid;
    }

    public String toString() {
        return "Suggestion{preAction=" + this.preAction + ", text=" + this.text + ", uuid=" + this.uuid + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Suggestion)) {
            return false;
        }
        Suggestion suggestion = (Suggestion) obj;
        if (!this.preAction.equals(suggestion.getPreAction()) || !this.text.equals(suggestion.getText()) || !this.uuid.equals(suggestion.getUuid())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((this.preAction.hashCode() ^ 1000003) * 1000003) ^ this.text.hashCode()) * 1000003) ^ this.uuid.hashCode();
    }
}
