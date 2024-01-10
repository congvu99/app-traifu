package io.intercom.android.sdk.helpcenter.search;

import io.intercom.android.sdk.helpcenter.articles.ArticleViewState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/ArticleSearchState;", "", "()V", "Content", "Error", "Initial", "Loading", "NoResults", "NoResultsNoTeamHelp", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchState$Content;", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchState$Error;", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchState$Initial;", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchState$Loading;", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchState$NoResults;", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchState$NoResultsNoTeamHelp;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ArticleSearchState.kt */
public abstract class ArticleSearchState {
    public /* synthetic */ ArticleSearchState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/ArticleSearchState$Initial;", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchState;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleSearchState.kt */
    public static final class Initial extends ArticleSearchState {
        public static final int $stable = 0;
        public static final Initial INSTANCE = new Initial();

        private Initial() {
            super((DefaultConstructorMarker) null);
        }
    }

    private ArticleSearchState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/ArticleSearchState$Loading;", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchState;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleSearchState.kt */
    public static final class Loading extends ArticleSearchState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/ArticleSearchState$Content;", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchState;", "searchResults", "", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchResultRow;", "(Ljava/util/List;)V", "getSearchResults", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleSearchState.kt */
    public static final class Content extends ArticleSearchState {
        public static final int $stable = 8;
        private final List<ArticleSearchResultRow> searchResults;

        public static /* synthetic */ Content copy$default(Content content, List<ArticleSearchResultRow> list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = content.searchResults;
            }
            return content.copy(list);
        }

        public final List<ArticleSearchResultRow> component1() {
            return this.searchResults;
        }

        public final Content copy(List<? extends ArticleSearchResultRow> list) {
            Intrinsics.checkNotNullParameter(list, "searchResults");
            return new Content(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Content) && Intrinsics.areEqual((Object) this.searchResults, (Object) ((Content) obj).searchResults);
        }

        public int hashCode() {
            return this.searchResults.hashCode();
        }

        public String toString() {
            return "Content(searchResults=" + this.searchResults + ')';
        }

        public final List<ArticleSearchResultRow> getSearchResults() {
            return this.searchResults;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Content(List<? extends ArticleSearchResultRow> list) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, "searchResults");
            this.searchResults = list;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/ArticleSearchState$NoResults;", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchState;", "teamPresenceState", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;", "searchTerm", "", "(Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;Ljava/lang/String;)V", "getSearchTerm", "()Ljava/lang/String;", "getTeamPresenceState", "()Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleSearchState.kt */
    public static final class NoResults extends ArticleSearchState {
        public static final int $stable = 8;
        private final String searchTerm;
        private final ArticleViewState.TeamPresenceState teamPresenceState;

        public static /* synthetic */ NoResults copy$default(NoResults noResults, ArticleViewState.TeamPresenceState teamPresenceState2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                teamPresenceState2 = noResults.teamPresenceState;
            }
            if ((i & 2) != 0) {
                str = noResults.searchTerm;
            }
            return noResults.copy(teamPresenceState2, str);
        }

        public final ArticleViewState.TeamPresenceState component1() {
            return this.teamPresenceState;
        }

        public final String component2() {
            return this.searchTerm;
        }

        public final NoResults copy(ArticleViewState.TeamPresenceState teamPresenceState2, String str) {
            Intrinsics.checkNotNullParameter(teamPresenceState2, "teamPresenceState");
            Intrinsics.checkNotNullParameter(str, "searchTerm");
            return new NoResults(teamPresenceState2, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NoResults)) {
                return false;
            }
            NoResults noResults = (NoResults) obj;
            return Intrinsics.areEqual((Object) this.teamPresenceState, (Object) noResults.teamPresenceState) && Intrinsics.areEqual((Object) this.searchTerm, (Object) noResults.searchTerm);
        }

        public int hashCode() {
            return (this.teamPresenceState.hashCode() * 31) + this.searchTerm.hashCode();
        }

        public String toString() {
            return "NoResults(teamPresenceState=" + this.teamPresenceState + ", searchTerm=" + this.searchTerm + ')';
        }

        public final ArticleViewState.TeamPresenceState getTeamPresenceState() {
            return this.teamPresenceState;
        }

        public final String getSearchTerm() {
            return this.searchTerm;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NoResults(ArticleViewState.TeamPresenceState teamPresenceState2, String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(teamPresenceState2, "teamPresenceState");
            Intrinsics.checkNotNullParameter(str, "searchTerm");
            this.teamPresenceState = teamPresenceState2;
            this.searchTerm = str;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/ArticleSearchState$NoResultsNoTeamHelp;", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchState;", "searchTerm", "", "(Ljava/lang/String;)V", "getSearchTerm", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleSearchState.kt */
    public static final class NoResultsNoTeamHelp extends ArticleSearchState {
        public static final int $stable = 0;
        private final String searchTerm;

        public static /* synthetic */ NoResultsNoTeamHelp copy$default(NoResultsNoTeamHelp noResultsNoTeamHelp, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = noResultsNoTeamHelp.searchTerm;
            }
            return noResultsNoTeamHelp.copy(str);
        }

        public final String component1() {
            return this.searchTerm;
        }

        public final NoResultsNoTeamHelp copy(String str) {
            Intrinsics.checkNotNullParameter(str, "searchTerm");
            return new NoResultsNoTeamHelp(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NoResultsNoTeamHelp) && Intrinsics.areEqual((Object) this.searchTerm, (Object) ((NoResultsNoTeamHelp) obj).searchTerm);
        }

        public int hashCode() {
            return this.searchTerm.hashCode();
        }

        public String toString() {
            return "NoResultsNoTeamHelp(searchTerm=" + this.searchTerm + ')';
        }

        public final String getSearchTerm() {
            return this.searchTerm;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NoResultsNoTeamHelp(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "searchTerm");
            this.searchTerm = str;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/ArticleSearchState$Error;", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchState;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleSearchState.kt */
    public static final class Error extends ArticleSearchState {
        public static final int $stable = 0;
        public static final Error INSTANCE = new Error();

        private Error() {
            super((DefaultConstructorMarker) null);
        }
    }
}
