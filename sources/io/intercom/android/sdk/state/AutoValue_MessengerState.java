package io.intercom.android.sdk.state;

final class AutoValue_MessengerState extends MessengerState {
    private final boolean opened;

    AutoValue_MessengerState(boolean z) {
        this.opened = z;
    }

    public boolean isOpened() {
        return this.opened;
    }

    public String toString() {
        return "MessengerState{opened=" + this.opened + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MessengerState) || this.opened != ((MessengerState) obj).isOpened()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.opened ? 1231 : 1237) ^ 1000003;
    }
}
