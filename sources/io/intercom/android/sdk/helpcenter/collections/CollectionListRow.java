package io.intercom.android.sdk.helpcenter.collections;

import io.intercom.android.sdk.helpcenter.articles.ArticleViewState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/CollectionListRow;", "", "()V", "BrowseAllHelpTopicsAsListItem", "CollectionRow", "FullHelpCenterRow", "SendMessageRow", "Lio/intercom/android/sdk/helpcenter/collections/CollectionListRow$BrowseAllHelpTopicsAsListItem;", "Lio/intercom/android/sdk/helpcenter/collections/CollectionListRow$CollectionRow;", "Lio/intercom/android/sdk/helpcenter/collections/CollectionListRow$FullHelpCenterRow;", "Lio/intercom/android/sdk/helpcenter/collections/CollectionListRow$SendMessageRow;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CollectionViewState.kt */
public abstract class CollectionListRow {
    public /* synthetic */ CollectionListRow(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/CollectionListRow$CollectionRow;", "Lio/intercom/android/sdk/helpcenter/collections/CollectionListRow;", "id", "", "titleText", "descriptionVisibility", "", "descriptionText", "articlesCount", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V", "getArticlesCount", "()I", "getDescriptionText", "()Ljava/lang/String;", "getDescriptionVisibility", "getId", "getTitleText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CollectionViewState.kt */
    public static final class CollectionRow extends CollectionListRow {
        public static final int $stable = 0;
        private final int articlesCount;
        private final String descriptionText;
        private final int descriptionVisibility;
        private final String id;
        private final String titleText;

        public static /* synthetic */ CollectionRow copy$default(CollectionRow collectionRow, String str, String str2, int i, String str3, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = collectionRow.id;
            }
            if ((i3 & 2) != 0) {
                str2 = collectionRow.titleText;
            }
            String str4 = str2;
            if ((i3 & 4) != 0) {
                i = collectionRow.descriptionVisibility;
            }
            int i4 = i;
            if ((i3 & 8) != 0) {
                str3 = collectionRow.descriptionText;
            }
            String str5 = str3;
            if ((i3 & 16) != 0) {
                i2 = collectionRow.articlesCount;
            }
            return collectionRow.copy(str, str4, i4, str5, i2);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.titleText;
        }

        public final int component3() {
            return this.descriptionVisibility;
        }

        public final String component4() {
            return this.descriptionText;
        }

        public final int component5() {
            return this.articlesCount;
        }

        public final CollectionRow copy(String str, String str2, int i, String str3, int i2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "titleText");
            Intrinsics.checkNotNullParameter(str3, "descriptionText");
            return new CollectionRow(str, str2, i, str3, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CollectionRow)) {
                return false;
            }
            CollectionRow collectionRow = (CollectionRow) obj;
            return Intrinsics.areEqual((Object) this.id, (Object) collectionRow.id) && Intrinsics.areEqual((Object) this.titleText, (Object) collectionRow.titleText) && this.descriptionVisibility == collectionRow.descriptionVisibility && Intrinsics.areEqual((Object) this.descriptionText, (Object) collectionRow.descriptionText) && this.articlesCount == collectionRow.articlesCount;
        }

        public int hashCode() {
            return (((((((this.id.hashCode() * 31) + this.titleText.hashCode()) * 31) + this.descriptionVisibility) * 31) + this.descriptionText.hashCode()) * 31) + this.articlesCount;
        }

        public String toString() {
            return "CollectionRow(id=" + this.id + ", titleText=" + this.titleText + ", descriptionVisibility=" + this.descriptionVisibility + ", descriptionText=" + this.descriptionText + ", articlesCount=" + this.articlesCount + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CollectionRow(String str, String str2, int i, String str3, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, i, str3, (i3 & 16) != 0 ? 0 : i2);
        }

        public final String getId() {
            return this.id;
        }

        public final String getTitleText() {
            return this.titleText;
        }

        public final int getDescriptionVisibility() {
            return this.descriptionVisibility;
        }

        public final String getDescriptionText() {
            return this.descriptionText;
        }

        public final int getArticlesCount() {
            return this.articlesCount;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CollectionRow(String str, String str2, int i, String str3, int i2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "titleText");
            Intrinsics.checkNotNullParameter(str3, "descriptionText");
            this.id = str;
            this.titleText = str2;
            this.descriptionVisibility = i;
            this.descriptionText = str3;
            this.articlesCount = i2;
        }
    }

    private CollectionListRow() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/CollectionListRow$FullHelpCenterRow;", "Lio/intercom/android/sdk/helpcenter/collections/CollectionListRow;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CollectionViewState.kt */
    public static final class FullHelpCenterRow extends CollectionListRow {
        public static final int $stable = 0;
        public static final FullHelpCenterRow INSTANCE = new FullHelpCenterRow();

        private FullHelpCenterRow() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/CollectionListRow$BrowseAllHelpTopicsAsListItem;", "Lio/intercom/android/sdk/helpcenter/collections/CollectionListRow;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CollectionViewState.kt */
    public static final class BrowseAllHelpTopicsAsListItem extends CollectionListRow {
        public static final int $stable = 0;
        public static final BrowseAllHelpTopicsAsListItem INSTANCE = new BrowseAllHelpTopicsAsListItem();

        private BrowseAllHelpTopicsAsListItem() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/CollectionListRow$SendMessageRow;", "Lio/intercom/android/sdk/helpcenter/collections/CollectionListRow;", "teamPresenceState", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;", "(Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;)V", "getTeamPresenceState", "()Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CollectionViewState.kt */
    public static final class SendMessageRow extends CollectionListRow {
        public static final int $stable = 8;
        private final ArticleViewState.TeamPresenceState teamPresenceState;

        public static /* synthetic */ SendMessageRow copy$default(SendMessageRow sendMessageRow, ArticleViewState.TeamPresenceState teamPresenceState2, int i, Object obj) {
            if ((i & 1) != 0) {
                teamPresenceState2 = sendMessageRow.teamPresenceState;
            }
            return sendMessageRow.copy(teamPresenceState2);
        }

        public final ArticleViewState.TeamPresenceState component1() {
            return this.teamPresenceState;
        }

        public final SendMessageRow copy(ArticleViewState.TeamPresenceState teamPresenceState2) {
            Intrinsics.checkNotNullParameter(teamPresenceState2, "teamPresenceState");
            return new SendMessageRow(teamPresenceState2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SendMessageRow) && Intrinsics.areEqual((Object) this.teamPresenceState, (Object) ((SendMessageRow) obj).teamPresenceState);
        }

        public int hashCode() {
            return this.teamPresenceState.hashCode();
        }

        public String toString() {
            return "SendMessageRow(teamPresenceState=" + this.teamPresenceState + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SendMessageRow(ArticleViewState.TeamPresenceState teamPresenceState2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(teamPresenceState2, "teamPresenceState");
            this.teamPresenceState = teamPresenceState2;
        }

        public final ArticleViewState.TeamPresenceState getTeamPresenceState() {
            return this.teamPresenceState;
        }
    }
}
