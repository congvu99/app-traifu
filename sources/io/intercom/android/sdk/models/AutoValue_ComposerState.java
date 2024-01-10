package io.intercom.android.sdk.models;

final class AutoValue_ComposerState extends ComposerState {
    private final boolean visible;

    AutoValue_ComposerState(boolean z) {
        this.visible = z;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public String toString() {
        return "ComposerState{visible=" + this.visible + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ComposerState) || this.visible != ((ComposerState) obj).isVisible()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.visible ? 1231 : 1237) ^ 1000003;
    }
}
