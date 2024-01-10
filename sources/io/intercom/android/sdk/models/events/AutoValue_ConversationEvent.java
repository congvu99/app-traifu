package io.intercom.android.sdk.models.events;

import io.intercom.android.sdk.models.Conversation;

final class AutoValue_ConversationEvent extends ConversationEvent {
    private final boolean attributeUpdated;
    private final Conversation response;

    AutoValue_ConversationEvent(Conversation conversation, boolean z) {
        if (conversation != null) {
            this.response = conversation;
            this.attributeUpdated = z;
            return;
        }
        throw new NullPointerException("Null response");
    }

    public Conversation getResponse() {
        return this.response;
    }

    public boolean isAttributeUpdated() {
        return this.attributeUpdated;
    }

    public String toString() {
        return "ConversationEvent{response=" + this.response + ", attributeUpdated=" + this.attributeUpdated + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConversationEvent)) {
            return false;
        }
        ConversationEvent conversationEvent = (ConversationEvent) obj;
        if (!this.response.equals(conversationEvent.getResponse()) || this.attributeUpdated != conversationEvent.isAttributeUpdated()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.response.hashCode() ^ 1000003) * 1000003) ^ (this.attributeUpdated ? 1231 : 1237);
    }
}
