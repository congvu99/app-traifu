package io.intercom.android.sdk.models;

import java.util.List;

final class AutoValue_ComposerSuggestions extends ComposerSuggestions {
    private final boolean composerDisabled;
    private final boolean loading;
    private final String prompt;
    private final List<Suggestion> suggestions;

    AutoValue_ComposerSuggestions(String str, List<Suggestion> list, boolean z, boolean z2) {
        if (str != null) {
            this.prompt = str;
            if (list != null) {
                this.suggestions = list;
                this.composerDisabled = z;
                this.loading = z2;
                return;
            }
            throw new NullPointerException("Null suggestions");
        }
        throw new NullPointerException("Null prompt");
    }

    public String getPrompt() {
        return this.prompt;
    }

    public List<Suggestion> getSuggestions() {
        return this.suggestions;
    }

    public boolean isComposerDisabled() {
        return this.composerDisabled;
    }

    public boolean isLoading() {
        return this.loading;
    }

    public String toString() {
        return "ComposerSuggestions{prompt=" + this.prompt + ", suggestions=" + this.suggestions + ", composerDisabled=" + this.composerDisabled + ", loading=" + this.loading + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ComposerSuggestions)) {
            return false;
        }
        ComposerSuggestions composerSuggestions = (ComposerSuggestions) obj;
        if (!this.prompt.equals(composerSuggestions.getPrompt()) || !this.suggestions.equals(composerSuggestions.getSuggestions()) || this.composerDisabled != composerSuggestions.isComposerDisabled() || this.loading != composerSuggestions.isLoading()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = 1231;
        int hashCode = (((((this.prompt.hashCode() ^ 1000003) * 1000003) ^ this.suggestions.hashCode()) * 1000003) ^ (this.composerDisabled ? 1231 : 1237)) * 1000003;
        if (!this.loading) {
            i = 1237;
        }
        return hashCode ^ i;
    }
}
