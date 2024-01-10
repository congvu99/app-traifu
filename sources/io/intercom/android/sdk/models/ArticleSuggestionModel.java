package io.intercom.android.sdk.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lio/intercom/android/sdk/models/ArticleSuggestionModel;", "", "id", "", "title", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTitle", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ArticleSuggestionModel.kt */
public final class ArticleSuggestionModel {
    @SerializedName("id")
    private final String id;
    @SerializedName("title")
    private final String title;

    public static /* synthetic */ ArticleSuggestionModel copy$default(ArticleSuggestionModel articleSuggestionModel, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = articleSuggestionModel.id;
        }
        if ((i & 2) != 0) {
            str2 = articleSuggestionModel.title;
        }
        return articleSuggestionModel.copy(str, str2);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final ArticleSuggestionModel copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new ArticleSuggestionModel(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArticleSuggestionModel)) {
            return false;
        }
        ArticleSuggestionModel articleSuggestionModel = (ArticleSuggestionModel) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) articleSuggestionModel.id) && Intrinsics.areEqual((Object) this.title, (Object) articleSuggestionModel.title);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.title.hashCode();
    }

    public String toString() {
        return "ArticleSuggestionModel(id=" + this.id + ", title=" + this.title + ')';
    }

    public ArticleSuggestionModel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }
}
