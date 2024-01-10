package io.intercom.android.sdk.helpcenter.search;

import io.intercom.android.sdk.helpcenter.articles.ArticleViewState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/ArticleSearchResultRow;", "", "()V", "ArticleResultRow", "TeammateHelpRow", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchResultRow$ArticleResultRow;", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchResultRow$TeammateHelpRow;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ArticleSearchState.kt */
public abstract class ArticleSearchResultRow {
    public /* synthetic */ ArticleSearchResultRow(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/ArticleSearchResultRow$ArticleResultRow;", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchResultRow;", "id", "", "titleText", "summaryText", "summaryVisibility", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getSummaryText", "getSummaryVisibility", "()I", "getTitleText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleSearchState.kt */
    public static final class ArticleResultRow extends ArticleSearchResultRow {
        public static final int $stable = 0;
        private final String id;
        private final String summaryText;
        private final int summaryVisibility;
        private final String titleText;

        public static /* synthetic */ ArticleResultRow copy$default(ArticleResultRow articleResultRow, String str, String str2, String str3, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = articleResultRow.id;
            }
            if ((i2 & 2) != 0) {
                str2 = articleResultRow.titleText;
            }
            if ((i2 & 4) != 0) {
                str3 = articleResultRow.summaryText;
            }
            if ((i2 & 8) != 0) {
                i = articleResultRow.summaryVisibility;
            }
            return articleResultRow.copy(str, str2, str3, i);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.titleText;
        }

        public final String component3() {
            return this.summaryText;
        }

        public final int component4() {
            return this.summaryVisibility;
        }

        public final ArticleResultRow copy(String str, String str2, String str3, int i) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "titleText");
            Intrinsics.checkNotNullParameter(str3, "summaryText");
            return new ArticleResultRow(str, str2, str3, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ArticleResultRow)) {
                return false;
            }
            ArticleResultRow articleResultRow = (ArticleResultRow) obj;
            return Intrinsics.areEqual((Object) this.id, (Object) articleResultRow.id) && Intrinsics.areEqual((Object) this.titleText, (Object) articleResultRow.titleText) && Intrinsics.areEqual((Object) this.summaryText, (Object) articleResultRow.summaryText) && this.summaryVisibility == articleResultRow.summaryVisibility;
        }

        public int hashCode() {
            return (((((this.id.hashCode() * 31) + this.titleText.hashCode()) * 31) + this.summaryText.hashCode()) * 31) + this.summaryVisibility;
        }

        public String toString() {
            return "ArticleResultRow(id=" + this.id + ", titleText=" + this.titleText + ", summaryText=" + this.summaryText + ", summaryVisibility=" + this.summaryVisibility + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ArticleResultRow(String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? 8 : i);
        }

        public final String getId() {
            return this.id;
        }

        public final String getTitleText() {
            return this.titleText;
        }

        public final String getSummaryText() {
            return this.summaryText;
        }

        public final int getSummaryVisibility() {
            return this.summaryVisibility;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ArticleResultRow(String str, String str2, String str3, int i) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "titleText");
            Intrinsics.checkNotNullParameter(str3, "summaryText");
            this.id = str;
            this.titleText = str2;
            this.summaryText = str3;
            this.summaryVisibility = i;
        }
    }

    private ArticleSearchResultRow() {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/ArticleSearchResultRow$TeammateHelpRow;", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchResultRow;", "teamPresenceState", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;", "(Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;)V", "getTeamPresenceState", "()Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleSearchState.kt */
    public static final class TeammateHelpRow extends ArticleSearchResultRow {
        public static final int $stable = 8;
        private final ArticleViewState.TeamPresenceState teamPresenceState;

        public static /* synthetic */ TeammateHelpRow copy$default(TeammateHelpRow teammateHelpRow, ArticleViewState.TeamPresenceState teamPresenceState2, int i, Object obj) {
            if ((i & 1) != 0) {
                teamPresenceState2 = teammateHelpRow.teamPresenceState;
            }
            return teammateHelpRow.copy(teamPresenceState2);
        }

        public final ArticleViewState.TeamPresenceState component1() {
            return this.teamPresenceState;
        }

        public final TeammateHelpRow copy(ArticleViewState.TeamPresenceState teamPresenceState2) {
            Intrinsics.checkNotNullParameter(teamPresenceState2, "teamPresenceState");
            return new TeammateHelpRow(teamPresenceState2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TeammateHelpRow) && Intrinsics.areEqual((Object) this.teamPresenceState, (Object) ((TeammateHelpRow) obj).teamPresenceState);
        }

        public int hashCode() {
            return this.teamPresenceState.hashCode();
        }

        public String toString() {
            return "TeammateHelpRow(teamPresenceState=" + this.teamPresenceState + ')';
        }

        public final ArticleViewState.TeamPresenceState getTeamPresenceState() {
            return this.teamPresenceState;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TeammateHelpRow(ArticleViewState.TeamPresenceState teamPresenceState2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(teamPresenceState2, "teamPresenceState");
            this.teamPresenceState = teamPresenceState2;
        }
    }
}
