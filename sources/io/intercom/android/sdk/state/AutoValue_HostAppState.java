package io.intercom.android.sdk.state;

final class AutoValue_HostAppState extends HostAppState {
    private final long backgroundedTimestamp;
    private final boolean isBackgrounded;
    private final boolean sessionStartedSinceLastBackgrounded;

    AutoValue_HostAppState(boolean z, boolean z2, long j) {
        this.isBackgrounded = z;
        this.sessionStartedSinceLastBackgrounded = z2;
        this.backgroundedTimestamp = j;
    }

    public boolean isBackgrounded() {
        return this.isBackgrounded;
    }

    public boolean sessionStartedSinceLastBackgrounded() {
        return this.sessionStartedSinceLastBackgrounded;
    }

    public long backgroundedTimestamp() {
        return this.backgroundedTimestamp;
    }

    public String toString() {
        return "HostAppState{isBackgrounded=" + this.isBackgrounded + ", sessionStartedSinceLastBackgrounded=" + this.sessionStartedSinceLastBackgrounded + ", backgroundedTimestamp=" + this.backgroundedTimestamp + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HostAppState)) {
            return false;
        }
        HostAppState hostAppState = (HostAppState) obj;
        if (this.isBackgrounded == hostAppState.isBackgrounded() && this.sessionStartedSinceLastBackgrounded == hostAppState.sessionStartedSinceLastBackgrounded() && this.backgroundedTimestamp == hostAppState.backgroundedTimestamp()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 1231;
        int i2 = ((this.isBackgrounded ? 1231 : 1237) ^ 1000003) * 1000003;
        if (!this.sessionStartedSinceLastBackgrounded) {
            i = 1237;
        }
        long j = this.backgroundedTimestamp;
        return ((i2 ^ i) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }
}
