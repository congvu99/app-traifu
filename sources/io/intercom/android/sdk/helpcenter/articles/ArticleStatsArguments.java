package io.intercom.android.sdk.helpcenter.articles;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0019"}, d2 = {"Lio/intercom/android/sdk/helpcenter/articles/ArticleStatsArguments;", "Landroid/os/Parcelable;", "articleId", "", "isFromSearchBrowse", "", "(Ljava/lang/String;Z)V", "getArticleId", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ArticleStatsArguments.kt */
public final class ArticleStatsArguments implements Parcelable {
    public static final Parcelable.Creator<ArticleStatsArguments> CREATOR = new Creator();
    private final String articleId;
    private final boolean isFromSearchBrowse;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleStatsArguments.kt */
    public static final class Creator implements Parcelable.Creator<ArticleStatsArguments> {
        public final ArticleStatsArguments createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ArticleStatsArguments(parcel.readString(), parcel.readInt() != 0);
        }

        public final ArticleStatsArguments[] newArray(int i) {
            return new ArticleStatsArguments[i];
        }
    }

    public ArticleStatsArguments() {
        this((String) null, false, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ArticleStatsArguments(String str) {
        this(str, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "articleId");
    }

    public static /* synthetic */ ArticleStatsArguments copy$default(ArticleStatsArguments articleStatsArguments, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = articleStatsArguments.articleId;
        }
        if ((i & 2) != 0) {
            z = articleStatsArguments.isFromSearchBrowse;
        }
        return articleStatsArguments.copy(str, z);
    }

    public final String component1() {
        return this.articleId;
    }

    public final boolean component2() {
        return this.isFromSearchBrowse;
    }

    public final ArticleStatsArguments copy(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "articleId");
        return new ArticleStatsArguments(str, z);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArticleStatsArguments)) {
            return false;
        }
        ArticleStatsArguments articleStatsArguments = (ArticleStatsArguments) obj;
        return Intrinsics.areEqual((Object) this.articleId, (Object) articleStatsArguments.articleId) && this.isFromSearchBrowse == articleStatsArguments.isFromSearchBrowse;
    }

    public int hashCode() {
        int hashCode = this.articleId.hashCode() * 31;
        boolean z = this.isFromSearchBrowse;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "ArticleStatsArguments(articleId=" + this.articleId + ", isFromSearchBrowse=" + this.isFromSearchBrowse + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.articleId);
        parcel.writeInt(this.isFromSearchBrowse ? 1 : 0);
    }

    public ArticleStatsArguments(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "articleId");
        this.articleId = str;
        this.isFromSearchBrowse = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ArticleStatsArguments(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z);
    }

    public final String getArticleId() {
        return this.articleId;
    }

    public final boolean isFromSearchBrowse() {
        return this.isFromSearchBrowse;
    }
}
