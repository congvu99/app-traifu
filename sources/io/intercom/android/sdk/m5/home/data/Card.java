package io.intercom.android.sdk.m5.home.data;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006!"}, d2 = {"Lio/intercom/android/sdk/m5/home/data/Card;", "", "action", "Lio/intercom/android/sdk/m5/home/data/Action;", "cardTitle", "", "spaceItems", "", "Lio/intercom/android/sdk/m5/home/data/SpaceItem;", "suggestedArticles", "Lio/intercom/android/sdk/m5/home/data/SuggestedArticle;", "type", "(Lio/intercom/android/sdk/m5/home/data/Action;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getAction", "()Lio/intercom/android/sdk/m5/home/data/Action;", "getCardTitle", "()Ljava/lang/String;", "getSpaceItems", "()Ljava/util/List;", "getSuggestedArticles", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeV2Response.kt */
public final class Card {
    @SerializedName("action")
    private final Action action;
    @SerializedName("card_title")
    private final String cardTitle;
    @SerializedName("space_items")
    private final List<SpaceItem> spaceItems;
    @SerializedName("suggested_articles")
    private final List<SuggestedArticle> suggestedArticles;
    @SerializedName("type")
    private final String type;

    public static /* synthetic */ Card copy$default(Card card, Action action2, String str, List<SpaceItem> list, List<SuggestedArticle> list2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            action2 = card.action;
        }
        if ((i & 2) != 0) {
            str = card.cardTitle;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            list = card.spaceItems;
        }
        List<SpaceItem> list3 = list;
        if ((i & 8) != 0) {
            list2 = card.suggestedArticles;
        }
        List<SuggestedArticle> list4 = list2;
        if ((i & 16) != 0) {
            str2 = card.type;
        }
        return card.copy(action2, str3, list3, list4, str2);
    }

    public final Action component1() {
        return this.action;
    }

    public final String component2() {
        return this.cardTitle;
    }

    public final List<SpaceItem> component3() {
        return this.spaceItems;
    }

    public final List<SuggestedArticle> component4() {
        return this.suggestedArticles;
    }

    public final String component5() {
        return this.type;
    }

    public final Card copy(Action action2, String str, List<SpaceItem> list, List<SuggestedArticle> list2, String str2) {
        Intrinsics.checkNotNullParameter(action2, "action");
        Intrinsics.checkNotNullParameter(str, "cardTitle");
        Intrinsics.checkNotNullParameter(list, "spaceItems");
        Intrinsics.checkNotNullParameter(list2, "suggestedArticles");
        Intrinsics.checkNotNullParameter(str2, "type");
        return new Card(action2, str, list, list2, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Card)) {
            return false;
        }
        Card card = (Card) obj;
        return Intrinsics.areEqual((Object) this.action, (Object) card.action) && Intrinsics.areEqual((Object) this.cardTitle, (Object) card.cardTitle) && Intrinsics.areEqual((Object) this.spaceItems, (Object) card.spaceItems) && Intrinsics.areEqual((Object) this.suggestedArticles, (Object) card.suggestedArticles) && Intrinsics.areEqual((Object) this.type, (Object) card.type);
    }

    public int hashCode() {
        return (((((((this.action.hashCode() * 31) + this.cardTitle.hashCode()) * 31) + this.spaceItems.hashCode()) * 31) + this.suggestedArticles.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "Card(action=" + this.action + ", cardTitle=" + this.cardTitle + ", spaceItems=" + this.spaceItems + ", suggestedArticles=" + this.suggestedArticles + ", type=" + this.type + ')';
    }

    public Card(Action action2, String str, List<SpaceItem> list, List<SuggestedArticle> list2, String str2) {
        Intrinsics.checkNotNullParameter(action2, "action");
        Intrinsics.checkNotNullParameter(str, "cardTitle");
        Intrinsics.checkNotNullParameter(list, "spaceItems");
        Intrinsics.checkNotNullParameter(list2, "suggestedArticles");
        Intrinsics.checkNotNullParameter(str2, "type");
        this.action = action2;
        this.cardTitle = str;
        this.spaceItems = list;
        this.suggestedArticles = list2;
        this.type = str2;
    }

    public final Action getAction() {
        return this.action;
    }

    public final String getCardTitle() {
        return this.cardTitle;
    }

    public final List<SpaceItem> getSpaceItems() {
        return this.spaceItems;
    }

    public final List<SuggestedArticle> getSuggestedArticles() {
        return this.suggestedArticles;
    }

    public final String getType() {
        return this.type;
    }
}
