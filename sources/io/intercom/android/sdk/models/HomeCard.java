package io.intercom.android.sdk.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lio/intercom/android/sdk/models/HomeCard;", "", "fallbackUrl", "", "slotType", "(Ljava/lang/String;Ljava/lang/String;)V", "getFallbackUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "getSlotType", "Lio/intercom/android/sdk/models/HomeCardSlotType;", "hashCode", "", "toString", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeCard.kt */
public final class HomeCard {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String SLOT_TYPE_ARTICLE_SEARCH = "help_center";
    public static final String SLOT_TYPE_MESSENGER_APP = "messenger_app";
    public static final String SLOT_TYPE_NEW_CONVERSATION = "new_conversation_card";
    @SerializedName("fallback_url")
    private final String fallbackUrl;
    @SerializedName("slot_type")
    private final String slotType;

    public HomeCard() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    private final String component2() {
        return this.slotType;
    }

    public static /* synthetic */ HomeCard copy$default(HomeCard homeCard, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = homeCard.fallbackUrl;
        }
        if ((i & 2) != 0) {
            str2 = homeCard.slotType;
        }
        return homeCard.copy(str, str2);
    }

    public final String component1() {
        return this.fallbackUrl;
    }

    public final HomeCard copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "fallbackUrl");
        Intrinsics.checkNotNullParameter(str2, "slotType");
        return new HomeCard(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeCard)) {
            return false;
        }
        HomeCard homeCard = (HomeCard) obj;
        return Intrinsics.areEqual((Object) this.fallbackUrl, (Object) homeCard.fallbackUrl) && Intrinsics.areEqual((Object) this.slotType, (Object) homeCard.slotType);
    }

    public int hashCode() {
        return (this.fallbackUrl.hashCode() * 31) + this.slotType.hashCode();
    }

    public String toString() {
        return "HomeCard(fallbackUrl=" + this.fallbackUrl + ", slotType=" + this.slotType + ')';
    }

    public HomeCard(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "fallbackUrl");
        Intrinsics.checkNotNullParameter(str2, "slotType");
        this.fallbackUrl = str;
        this.slotType = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeCard(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public final String getFallbackUrl() {
        return this.fallbackUrl;
    }

    public final HomeCardSlotType getSlotType() {
        String str = this.slotType;
        int hashCode = str.hashCode();
        if (hashCode != -2046223251) {
            if (hashCode != 761757459) {
                if (hashCode == 1405723381 && str.equals(SLOT_TYPE_MESSENGER_APP)) {
                    return HomeCardSlotType.MESSENGER_APP;
                }
            } else if (str.equals("help_center")) {
                return HomeCardSlotType.ARTICLE_SEARCH;
            }
        } else if (str.equals(SLOT_TYPE_NEW_CONVERSATION)) {
            return HomeCardSlotType.NEW_CONVERSATION;
        }
        return HomeCardSlotType.UNKNOWN_CARD;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lio/intercom/android/sdk/models/HomeCard$Companion;", "", "()V", "SLOT_TYPE_ARTICLE_SEARCH", "", "SLOT_TYPE_MESSENGER_APP", "SLOT_TYPE_NEW_CONVERSATION", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HomeCard.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
