package io.intercom.android.sdk.models;

import io.intercom.android.sdk.models.BaseResponse;
import io.intercom.android.sdk.models.ConversationList;

public class UsersResponse extends BaseResponse {
    private final ConversationList unreadConversations;

    UsersResponse(Builder builder) {
        super(builder);
        ConversationList conversationList;
        if (builder.unread_conversations == null) {
            conversationList = new ConversationList.Builder().build();
        } else {
            conversationList = builder.unread_conversations.build();
        }
        this.unreadConversations = conversationList;
    }

    public ConversationList getUnreadConversations() {
        return this.unreadConversations;
    }

    public static class Builder extends BaseResponse.Builder {
        ConversationList.Builder unread_conversations;

        public UsersResponse build() {
            return new UsersResponse(this);
        }
    }
}
