package io.intercom.android.sdk.models;

import io.intercom.android.sdk.models.BaseResponse;
import io.intercom.android.sdk.models.Conversation;
import java.util.ArrayList;
import java.util.List;

public class HomeCardsResponse extends BaseResponse {
    private final List<ArticleSuggestionModel> articleSuggestions;
    private final List<HomeCard> cards;
    private final List<Conversation> conversations = new ArrayList();
    private final boolean hasMoreConversations;
    private final List<String> openInboundConversationIds;

    HomeCardsResponse(Builder builder) {
        super(builder);
        if (builder.conversations != null) {
            for (Conversation.Builder build : builder.conversations) {
                this.conversations.add(build.build());
            }
        }
        this.cards = new ArrayList();
        if (builder.cards != null) {
            this.cards.addAll(builder.cards);
        }
        this.openInboundConversationIds = new ArrayList();
        this.articleSuggestions = new ArrayList();
        if (builder.open_inbound_conversation_ids != null) {
            this.openInboundConversationIds.addAll(builder.open_inbound_conversation_ids);
        }
        if (builder.article_suggestions != null) {
            this.articleSuggestions.addAll(builder.article_suggestions);
        }
        this.hasMoreConversations = builder.has_more_conversations;
    }

    public List<Conversation> getConversations() {
        return this.conversations;
    }

    public List<HomeCard> getCards() {
        return this.cards;
    }

    public List<ArticleSuggestionModel> getArticleSuggestions() {
        return this.articleSuggestions;
    }

    public List<String> getOpenInboundConversationIds() {
        return this.openInboundConversationIds;
    }

    public boolean hasMoreConversations() {
        return this.hasMoreConversations;
    }

    public static class Builder extends BaseResponse.Builder {
        List<ArticleSuggestionModel> article_suggestions;
        List<HomeCard> cards;
        List<Conversation.Builder> conversations;
        boolean has_more_conversations;
        List<String> open_inbound_conversation_ids;

        public HomeCardsResponse build() {
            return new HomeCardsResponse(this);
        }
    }
}
