package io.intercom.android.sdk.models;

import io.intercom.android.sdk.utilities.NullSafety;

public abstract class Prompt {
    public abstract String getPromptText();

    public static Prompt create(String str) {
        return new AutoValue_Prompt(str);
    }

    public static final class Builder {
        String text;

        public Builder withText(String str) {
            this.text = str;
            return this;
        }

        public Prompt build() {
            return Prompt.create(NullSafety.valueOrEmpty(this.text));
        }
    }
}
