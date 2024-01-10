package io.intercom.android.sdk.models;

import io.intercom.android.sdk.models.BaseResponse;
import io.intercom.android.sdk.models.ConversationList;

public class ConversationsResponse extends BaseResponse {
    private final ConversationList conversationPage;

    ConversationsResponse(Builder builder) {
        super(builder);
        ConversationList conversationList;
        if (builder.conversation_page == null) {
            conversationList = new ConversationList.Builder().build();
        } else {
            conversationList = builder.conversation_page.build();
        }
        this.conversationPage = conversationList;
    }

    public ConversationList getConversationPage() {
        return this.conversationPage;
    }

    public static final class Builder extends BaseResponse.Builder {
        ConversationList.Builder conversation_page;

        public ConversationsResponse build() {
            return new ConversationsResponse(this);
        }

        public Builder withConversationPage(ConversationList.Builder builder) {
            this.conversation_page = builder;
            return this;
        }
    }
}
