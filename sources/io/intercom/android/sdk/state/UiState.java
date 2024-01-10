package io.intercom.android.sdk.state;

public abstract class UiState {

    public enum Screen {
        NONE,
        INBOX,
        HOME,
        COMPOSER,
        CONVERSATION
    }

    public abstract String conversationId();

    public abstract Screen screen();

    public static UiState create(Screen screen, String str) {
        return new AutoValue_UiState(screen, str);
    }
}
