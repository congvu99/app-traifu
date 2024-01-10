package io.intercom.android.sdk.helpcenter.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lio/intercom/android/sdk/helpcenter/api/HelpCenterArticleSearchResult;", "", "articleId", "", "title", "summary", "matchingSnippet", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getArticleId", "()Ljava/lang/String;", "getMatchingSnippet", "getSummary", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterArticleSearchResult.kt */
public final class HelpCenterArticleSearchResult {
    public static final int $stable = 0;
    private final String articleId;
    private final String matchingSnippet;
    private final String summary;
    private final String title;

    public static /* synthetic */ HelpCenterArticleSearchResult copy$default(HelpCenterArticleSearchResult helpCenterArticleSearchResult, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = helpCenterArticleSearchResult.articleId;
        }
        if ((i & 2) != 0) {
            str2 = helpCenterArticleSearchResult.title;
        }
        if ((i & 4) != 0) {
            str3 = helpCenterArticleSearchResult.summary;
        }
        if ((i & 8) != 0) {
            str4 = helpCenterArticleSearchResult.matchingSnippet;
        }
        return helpCenterArticleSearchResult.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.articleId;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.summary;
    }

    public final String component4() {
        return this.matchingSnippet;
    }

    public final HelpCenterArticleSearchResult copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "articleId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "summary");
        Intrinsics.checkNotNullParameter(str4, "matchingSnippet");
        return new HelpCenterArticleSearchResult(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HelpCenterArticleSearchResult)) {
            return false;
        }
        HelpCenterArticleSearchResult helpCenterArticleSearchResult = (HelpCenterArticleSearchResult) obj;
        return Intrinsics.areEqual((Object) this.articleId, (Object) helpCenterArticleSearchResult.articleId) && Intrinsics.areEqual((Object) this.title, (Object) helpCenterArticleSearchResult.title) && Intrinsics.areEqual((Object) this.summary, (Object) helpCenterArticleSearchResult.summary) && Intrinsics.areEqual((Object) this.matchingSnippet, (Object) helpCenterArticleSearchResult.matchingSnippet);
    }

    public int hashCode() {
        return (((((this.articleId.hashCode() * 31) + this.title.hashCode()) * 31) + this.summary.hashCode()) * 31) + this.matchingSnippet.hashCode();
    }

    public String toString() {
        return "HelpCenterArticleSearchResult(articleId=" + this.articleId + ", title=" + this.title + ", summary=" + this.summary + ", matchingSnippet=" + this.matchingSnippet + ')';
    }

    public HelpCenterArticleSearchResult(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "articleId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "summary");
        Intrinsics.checkNotNullParameter(str4, "matchingSnippet");
        this.articleId = str;
        this.title = str2;
        this.summary = str3;
        this.matchingSnippet = str4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HelpCenterArticleSearchResult(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }

    public final String getArticleId() {
        return this.articleId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getMatchingSnippet() {
        return this.matchingSnippet;
    }
}
