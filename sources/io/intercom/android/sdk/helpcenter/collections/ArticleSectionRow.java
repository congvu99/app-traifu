package io.intercom.android.sdk.helpcenter.collections;

import io.intercom.android.sdk.helpcenter.articles.ArticleViewState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/ArticleSectionRow;", "", "()V", "ArticleRow", "FullHelpCenterRow", "SectionRow", "SendMessageRow", "Lio/intercom/android/sdk/helpcenter/collections/ArticleSectionRow$ArticleRow;", "Lio/intercom/android/sdk/helpcenter/collections/ArticleSectionRow$FullHelpCenterRow;", "Lio/intercom/android/sdk/helpcenter/collections/ArticleSectionRow$SectionRow;", "Lio/intercom/android/sdk/helpcenter/collections/ArticleSectionRow$SendMessageRow;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CollectionViewState.kt */
public abstract class ArticleSectionRow {
    public /* synthetic */ ArticleSectionRow(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/ArticleSectionRow$SectionRow;", "Lio/intercom/android/sdk/helpcenter/collections/ArticleSectionRow;", "title", "", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CollectionViewState.kt */
    public static final class SectionRow extends ArticleSectionRow {
        public static final int $stable = 0;
        private final String title;

        public static /* synthetic */ SectionRow copy$default(SectionRow sectionRow, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sectionRow.title;
            }
            return sectionRow.copy(str);
        }

        public final String component1() {
            return this.title;
        }

        public final SectionRow copy(String str) {
            Intrinsics.checkNotNullParameter(str, "title");
            return new SectionRow(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SectionRow) && Intrinsics.areEqual((Object) this.title, (Object) ((SectionRow) obj).title);
        }

        public int hashCode() {
            return this.title.hashCode();
        }

        public String toString() {
            return "SectionRow(title=" + this.title + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SectionRow(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    private ArticleSectionRow() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/ArticleSectionRow$ArticleRow;", "Lio/intercom/android/sdk/helpcenter/collections/ArticleSectionRow;", "id", "", "title", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTitle", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CollectionViewState.kt */
    public static final class ArticleRow extends ArticleSectionRow {
        public static final int $stable = 0;
        private final String id;
        private final String title;

        public static /* synthetic */ ArticleRow copy$default(ArticleRow articleRow, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = articleRow.id;
            }
            if ((i & 2) != 0) {
                str2 = articleRow.title;
            }
            return articleRow.copy(str, str2);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.title;
        }

        public final ArticleRow copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            return new ArticleRow(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ArticleRow)) {
                return false;
            }
            ArticleRow articleRow = (ArticleRow) obj;
            return Intrinsics.areEqual((Object) this.id, (Object) articleRow.id) && Intrinsics.areEqual((Object) this.title, (Object) articleRow.title);
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.title.hashCode();
        }

        public String toString() {
            return "ArticleRow(id=" + this.id + ", title=" + this.title + ')';
        }

        public final String getId() {
            return this.id;
        }

        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ArticleRow(String str, String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.id = str;
            this.title = str2;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/ArticleSectionRow$FullHelpCenterRow;", "Lio/intercom/android/sdk/helpcenter/collections/ArticleSectionRow;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CollectionViewState.kt */
    public static final class FullHelpCenterRow extends ArticleSectionRow {
        public static final int $stable = 0;
        public static final FullHelpCenterRow INSTANCE = new FullHelpCenterRow();

        private FullHelpCenterRow() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/ArticleSectionRow$SendMessageRow;", "Lio/intercom/android/sdk/helpcenter/collections/ArticleSectionRow;", "teamPresenceState", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;", "(Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;)V", "getTeamPresenceState", "()Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CollectionViewState.kt */
    public static final class SendMessageRow extends ArticleSectionRow {
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
