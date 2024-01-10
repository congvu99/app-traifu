package io.intercom.android.sdk.models;

final class AutoValue_Prompt extends Prompt {
    private final String promptText;

    AutoValue_Prompt(String str) {
        if (str != null) {
            this.promptText = str;
            return;
        }
        throw new NullPointerException("Null promptText");
    }

    public String getPromptText() {
        return this.promptText;
    }

    public String toString() {
        return "Prompt{promptText=" + this.promptText + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Prompt) {
            return this.promptText.equals(((Prompt) obj).getPromptText());
        }
        return false;
    }

    public int hashCode() {
        return this.promptText.hashCode() ^ 1000003;
    }
}
