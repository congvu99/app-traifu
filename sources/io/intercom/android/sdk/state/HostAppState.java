package io.intercom.android.sdk.state;

public abstract class HostAppState {
    public abstract long backgroundedTimestamp();

    public abstract boolean isBackgrounded();

    public abstract boolean sessionStartedSinceLastBackgrounded();

    public static HostAppState create(boolean z, boolean z2, long j) {
        return new AutoValue_HostAppState(z, z2, j);
    }
}
