package io.intercom.android.sdk.state;

public abstract class ActiveConversationState {
    public abstract String getClientAssignedUuid();

    public abstract String getConversationId();

    public abstract boolean hasSwitchedInputType();

    public abstract boolean hasTextInComposer();

    public static ActiveConversationState create(String str, boolean z, boolean z2, String str2) {
        return new AutoValue_ActiveConversationState(str, z, z2, str2);
    }
}
