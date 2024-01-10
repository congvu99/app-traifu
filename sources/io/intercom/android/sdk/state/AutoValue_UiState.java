package io.intercom.android.sdk.state;

import io.intercom.android.sdk.state.UiState;

final class AutoValue_UiState extends UiState {
    private final String conversationId;
    private final UiState.Screen screen;

    AutoValue_UiState(UiState.Screen screen2, String str) {
        if (screen2 != null) {
            this.screen = screen2;
            this.conversationId = str;
            return;
        }
        throw new NullPointerException("Null screen");
    }

    public UiState.Screen screen() {
        return this.screen;
    }

    public String conversationId() {
        return this.conversationId;
    }

    public String toString() {
        return "UiState{screen=" + this.screen + ", conversationId=" + this.conversationId + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UiState)) {
            return false;
        }
        UiState uiState = (UiState) obj;
        if (this.screen.equals(uiState.screen())) {
            String str = this.conversationId;
            if (str == null) {
                if (uiState.conversationId() == null) {
                    return true;
                }
            } else if (str.equals(uiState.conversationId())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.screen.hashCode() ^ 1000003) * 1000003;
        String str = this.conversationId;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }
}
