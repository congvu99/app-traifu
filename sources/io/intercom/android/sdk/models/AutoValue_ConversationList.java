package io.intercom.android.sdk.models;

import java.util.List;
import java.util.Set;

final class AutoValue_ConversationList extends ConversationList {
    private final List<Conversation> getConversations;
    private final EmptyState getEmptyState;
    private final Set<String> getUnreadConversationIds;
    private final boolean hasMorePages;

    AutoValue_ConversationList(List<Conversation> list, Set<String> set, EmptyState emptyState, boolean z) {
        if (list != null) {
            this.getConversations = list;
            if (set != null) {
                this.getUnreadConversationIds = set;
                if (emptyState != null) {
                    this.getEmptyState = emptyState;
                    this.hasMorePages = z;
                    return;
                }
                throw new NullPointerException("Null getEmptyState");
            }
            throw new NullPointerException("Null getUnreadConversationIds");
        }
        throw new NullPointerException("Null getConversations");
    }

    public List<Conversation> getConversations() {
        return this.getConversations;
    }

    public Set<String> getUnreadConversationIds() {
        return this.getUnreadConversationIds;
    }

    public EmptyState getEmptyState() {
        return this.getEmptyState;
    }

    public boolean hasMorePages() {
        return this.hasMorePages;
    }

    public String toString() {
        return "ConversationList{getConversations=" + this.getConversations + ", getUnreadConversationIds=" + this.getUnreadConversationIds + ", getEmptyState=" + this.getEmptyState + ", hasMorePages=" + this.hasMorePages + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConversationList)) {
            return false;
        }
        ConversationList conversationList = (ConversationList) obj;
        if (!this.getConversations.equals(conversationList.getConversations()) || !this.getUnreadConversationIds.equals(conversationList.getUnreadConversationIds()) || !this.getEmptyState.equals(conversationList.getEmptyState()) || this.hasMorePages != conversationList.hasMorePages()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((this.getConversations.hashCode() ^ 1000003) * 1000003) ^ this.getUnreadConversationIds.hashCode()) * 1000003) ^ this.getEmptyState.hashCode()) * 1000003) ^ (this.hasMorePages ? 1231 : 1237);
    }
}
