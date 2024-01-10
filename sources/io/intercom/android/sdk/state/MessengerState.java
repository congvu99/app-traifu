package io.intercom.android.sdk.state;

public abstract class MessengerState {
    public abstract boolean isOpened();

    public static MessengerState create(boolean z) {
        return new AutoValue_MessengerState(z);
    }
}
