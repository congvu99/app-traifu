package io.intercom.android.sdk.state;

final class AutoValue_ActiveConversationState extends ActiveConversationState {
    private final String getClientAssignedUuid;
    private final String getConversationId;
    private final boolean hasSwitchedInputType;
    private final boolean hasTextInComposer;

    AutoValue_ActiveConversationState(String str, boolean z, boolean z2, String str2) {
        if (str != null) {
            this.getConversationId = str;
            this.hasSwitchedInputType = z;
            this.hasTextInComposer = z2;
            if (str2 != null) {
                this.getClientAssignedUuid = str2;
                return;
            }
            throw new NullPointerException("Null getClientAssignedUuid");
        }
        throw new NullPointerException("Null getConversationId");
    }

    public String getConversationId() {
        return this.getConversationId;
    }

    public boolean hasSwitchedInputType() {
        return this.hasSwitchedInputType;
    }

    public boolean hasTextInComposer() {
        return this.hasTextInComposer;
    }

    public String getClientAssignedUuid() {
        return this.getClientAssignedUuid;
    }

    public String toString() {
        return "ActiveConversationState{getConversationId=" + this.getConversationId + ", hasSwitchedInputType=" + this.hasSwitchedInputType + ", hasTextInComposer=" + this.hasTextInComposer + ", getClientAssignedUuid=" + this.getClientAssignedUuid + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActiveConversationState)) {
            return false;
        }
        ActiveConversationState activeConversationState = (ActiveConversationState) obj;
        if (!this.getConversationId.equals(activeConversationState.getConversationId()) || this.hasSwitchedInputType != activeConversationState.hasSwitchedInputType() || this.hasTextInComposer != activeConversationState.hasTextInComposer() || !this.getClientAssignedUuid.equals(activeConversationState.getClientAssignedUuid())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = 1231;
        int hashCode = (((this.getConversationId.hashCode() ^ 1000003) * 1000003) ^ (this.hasSwitchedInputType ? 1231 : 1237)) * 1000003;
        if (!this.hasTextInComposer) {
            i = 1237;
        }
        return ((hashCode ^ i) * 1000003) ^ this.getClientAssignedUuid.hashCode();
    }
}
