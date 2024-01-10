package io.intercom.android.sdk.m5.home.data;

import com.google.gson.annotations.SerializedName;
import io.intercom.android.sdk.models.Conversation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0010\u0018\u00002\u00020\u0001:\u0007\u000b\f\r\u000e\u000f\u0010\u0011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lio/intercom/android/sdk/m5/home/data/HomeCards;", "", "cardTitle", "", "type", "Lio/intercom/android/sdk/m5/home/data/HomeCardType;", "(Ljava/lang/String;Lio/intercom/android/sdk/m5/home/data/HomeCardType;)V", "getCardTitle", "()Ljava/lang/String;", "getType", "()Lio/intercom/android/sdk/m5/home/data/HomeCardType;", "HomeExternalLinkData", "HomeHelpCenterData", "HomeMessengerAppData", "HomeNewConversationData", "HomeRecentConversationData", "HomeSpacesData", "UnSupported", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeV2Response.kt */
public class HomeCards {
    @SerializedName("card_title")
    private final String cardTitle;
    @SerializedName("type")
    private final HomeCardType type;

    public HomeCards(String str, HomeCardType homeCardType) {
        Intrinsics.checkNotNullParameter(str, "cardTitle");
        Intrinsics.checkNotNullParameter(homeCardType, "type");
        this.cardTitle = str;
        this.type = homeCardType;
    }

    public final String getCardTitle() {
        return this.cardTitle;
    }

    public final HomeCardType getType() {
        return this.type;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/intercom/android/sdk/m5/home/data/HomeCards$HomeSpacesData;", "Lio/intercom/android/sdk/m5/home/data/HomeCards;", "cardTitle", "", "type", "Lio/intercom/android/sdk/m5/home/data/HomeCardType;", "spaceItems", "", "Lio/intercom/android/sdk/m5/home/data/SpaceItem;", "(Ljava/lang/String;Lio/intercom/android/sdk/m5/home/data/HomeCardType;Ljava/util/List;)V", "getSpaceItems", "()Ljava/util/List;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HomeV2Response.kt */
    public static final class HomeSpacesData extends HomeCards {
        public static final int $stable = 8;
        @SerializedName("space_items")
        private final List<SpaceItem> spaceItems;

        public final List<SpaceItem> getSpaceItems() {
            return this.spaceItems;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HomeSpacesData(String str, HomeCardType homeCardType, List<SpaceItem> list) {
            super(str, homeCardType);
            Intrinsics.checkNotNullParameter(str, "cardTitle");
            Intrinsics.checkNotNullParameter(homeCardType, "type");
            Intrinsics.checkNotNullParameter(list, "spaceItems");
            this.spaceItems = list;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/intercom/android/sdk/m5/home/data/HomeCards$HomeNewConversationData;", "Lio/intercom/android/sdk/m5/home/data/HomeCards;", "cardTitle", "", "type", "Lio/intercom/android/sdk/m5/home/data/HomeCardType;", "action", "Lio/intercom/android/sdk/m5/home/data/Action;", "preventMultipleInboundConversationsEnabled", "", "openInboundConversationsIds", "", "(Ljava/lang/String;Lio/intercom/android/sdk/m5/home/data/HomeCardType;Lio/intercom/android/sdk/m5/home/data/Action;ZLjava/util/List;)V", "getAction", "()Lio/intercom/android/sdk/m5/home/data/Action;", "getOpenInboundConversationsIds", "()Ljava/util/List;", "getPreventMultipleInboundConversationsEnabled", "()Z", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HomeV2Response.kt */
    public static final class HomeNewConversationData extends HomeCards {
        public static final int $stable = 8;
        @SerializedName("action")
        private final Action action;
        @SerializedName("open_inbound_conversation_ids")
        private final List<String> openInboundConversationsIds;
        @SerializedName("prevent_multiple_inbound_conversations_enabled")
        private final boolean preventMultipleInboundConversationsEnabled;

        public final Action getAction() {
            return this.action;
        }

        public final boolean getPreventMultipleInboundConversationsEnabled() {
            return this.preventMultipleInboundConversationsEnabled;
        }

        public final List<String> getOpenInboundConversationsIds() {
            return this.openInboundConversationsIds;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HomeNewConversationData(String str, HomeCardType homeCardType, Action action2, boolean z, List<String> list) {
            super(str, homeCardType);
            Intrinsics.checkNotNullParameter(str, "cardTitle");
            Intrinsics.checkNotNullParameter(homeCardType, "type");
            Intrinsics.checkNotNullParameter(action2, "action");
            Intrinsics.checkNotNullParameter(list, "openInboundConversationsIds");
            this.action = action2;
            this.preventMultipleInboundConversationsEnabled = z;
            this.openInboundConversationsIds = list;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/intercom/android/sdk/m5/home/data/HomeCards$HomeRecentConversationData;", "Lio/intercom/android/sdk/m5/home/data/HomeCards;", "cardTitle", "", "type", "Lio/intercom/android/sdk/m5/home/data/HomeCardType;", "conversations", "", "Lio/intercom/android/sdk/models/Conversation$Builder;", "(Ljava/lang/String;Lio/intercom/android/sdk/m5/home/data/HomeCardType;Ljava/util/List;)V", "getConversations", "()Ljava/util/List;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HomeV2Response.kt */
    public static final class HomeRecentConversationData extends HomeCards {
        public static final int $stable = 8;
        @SerializedName("conversations")
        private final List<Conversation.Builder> conversations;

        public final List<Conversation.Builder> getConversations() {
            return this.conversations;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HomeRecentConversationData(String str, HomeCardType homeCardType, List<Conversation.Builder> list) {
            super(str, homeCardType);
            Intrinsics.checkNotNullParameter(str, "cardTitle");
            Intrinsics.checkNotNullParameter(homeCardType, "type");
            Intrinsics.checkNotNullParameter(list, "conversations");
            this.conversations = list;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/intercom/android/sdk/m5/home/data/HomeCards$HomeHelpCenterData;", "Lio/intercom/android/sdk/m5/home/data/HomeCards;", "cardTitle", "", "type", "Lio/intercom/android/sdk/m5/home/data/HomeCardType;", "suggestedArticles", "", "Lio/intercom/android/sdk/m5/home/data/SuggestedArticle;", "(Ljava/lang/String;Lio/intercom/android/sdk/m5/home/data/HomeCardType;Ljava/util/List;)V", "getSuggestedArticles", "()Ljava/util/List;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HomeV2Response.kt */
    public static final class HomeHelpCenterData extends HomeCards {
        public static final int $stable = 8;
        @SerializedName("suggested_articles")
        private final List<SuggestedArticle> suggestedArticles;

        public final List<SuggestedArticle> getSuggestedArticles() {
            return this.suggestedArticles;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HomeHelpCenterData(String str, HomeCardType homeCardType, List<SuggestedArticle> list) {
            super(str, homeCardType);
            Intrinsics.checkNotNullParameter(str, "cardTitle");
            Intrinsics.checkNotNullParameter(homeCardType, "type");
            Intrinsics.checkNotNullParameter(list, "suggestedArticles");
            this.suggestedArticles = list;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/intercom/android/sdk/m5/home/data/HomeCards$HomeExternalLinkData;", "Lio/intercom/android/sdk/m5/home/data/HomeCards;", "cardTitle", "", "type", "Lio/intercom/android/sdk/m5/home/data/HomeCardType;", "links", "", "Lio/intercom/android/sdk/m5/home/data/Link;", "(Ljava/lang/String;Lio/intercom/android/sdk/m5/home/data/HomeCardType;Ljava/util/List;)V", "getLinks", "()Ljava/util/List;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HomeV2Response.kt */
    public static final class HomeExternalLinkData extends HomeCards {
        public static final int $stable = 8;
        @SerializedName("links")
        private final List<Link> links;

        public final List<Link> getLinks() {
            return this.links;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HomeExternalLinkData(String str, HomeCardType homeCardType, List<Link> list) {
            super(str, homeCardType);
            Intrinsics.checkNotNullParameter(str, "cardTitle");
            Intrinsics.checkNotNullParameter(homeCardType, "type");
            Intrinsics.checkNotNullParameter(list, "links");
            this.links = list;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/intercom/android/sdk/m5/home/data/HomeCards$HomeMessengerAppData;", "Lio/intercom/android/sdk/m5/home/data/HomeCards;", "cardTitle", "", "type", "Lio/intercom/android/sdk/m5/home/data/HomeCardType;", "fallbackUrl", "(Ljava/lang/String;Lio/intercom/android/sdk/m5/home/data/HomeCardType;Ljava/lang/String;)V", "getFallbackUrl", "()Ljava/lang/String;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HomeV2Response.kt */
    public static final class HomeMessengerAppData extends HomeCards {
        public static final int $stable = 0;
        @SerializedName("fallback_url")
        private final String fallbackUrl;

        public final String getFallbackUrl() {
            return this.fallbackUrl;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HomeMessengerAppData(String str, HomeCardType homeCardType, String str2) {
            super(str, homeCardType);
            Intrinsics.checkNotNullParameter(str, "cardTitle");
            Intrinsics.checkNotNullParameter(homeCardType, "type");
            Intrinsics.checkNotNullParameter(str2, "fallbackUrl");
            this.fallbackUrl = str2;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/intercom/android/sdk/m5/home/data/HomeCards$UnSupported;", "Lio/intercom/android/sdk/m5/home/data/HomeCards;", "cardTitle", "", "type", "Lio/intercom/android/sdk/m5/home/data/HomeCardType;", "(Ljava/lang/String;Lio/intercom/android/sdk/m5/home/data/HomeCardType;)V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HomeV2Response.kt */
    public static final class UnSupported extends HomeCards {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UnSupported(String str, HomeCardType homeCardType) {
            super(str, homeCardType);
            Intrinsics.checkNotNullParameter(str, "cardTitle");
            Intrinsics.checkNotNullParameter(homeCardType, "type");
        }
    }
}
