package io.intercom.android.sdk.helpcenter.collections;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/HelpCenterEffects;", "", "()V", "NavigateToArticle", "NavigateToCollectionContent", "Lio/intercom/android/sdk/helpcenter/collections/HelpCenterEffects$NavigateToArticle;", "Lio/intercom/android/sdk/helpcenter/collections/HelpCenterEffects$NavigateToCollectionContent;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CollectionViewState.kt */
public abstract class HelpCenterEffects {
    public /* synthetic */ HelpCenterEffects(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/HelpCenterEffects$NavigateToCollectionContent;", "Lio/intercom/android/sdk/helpcenter/collections/HelpCenterEffects;", "collectionId", "", "(Ljava/lang/String;)V", "getCollectionId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CollectionViewState.kt */
    public static final class NavigateToCollectionContent extends HelpCenterEffects {
        public static final int $stable = 0;
        private final String collectionId;

        public static /* synthetic */ NavigateToCollectionContent copy$default(NavigateToCollectionContent navigateToCollectionContent, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = navigateToCollectionContent.collectionId;
            }
            return navigateToCollectionContent.copy(str);
        }

        public final String component1() {
            return this.collectionId;
        }

        public final NavigateToCollectionContent copy(String str) {
            Intrinsics.checkNotNullParameter(str, "collectionId");
            return new NavigateToCollectionContent(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NavigateToCollectionContent) && Intrinsics.areEqual((Object) this.collectionId, (Object) ((NavigateToCollectionContent) obj).collectionId);
        }

        public int hashCode() {
            return this.collectionId.hashCode();
        }

        public String toString() {
            return "NavigateToCollectionContent(collectionId=" + this.collectionId + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NavigateToCollectionContent(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "collectionId");
            this.collectionId = str;
        }

        public final String getCollectionId() {
            return this.collectionId;
        }
    }

    private HelpCenterEffects() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/HelpCenterEffects$NavigateToArticle;", "Lio/intercom/android/sdk/helpcenter/collections/HelpCenterEffects;", "articleId", "", "(Ljava/lang/String;)V", "getArticleId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CollectionViewState.kt */
    public static final class NavigateToArticle extends HelpCenterEffects {
        public static final int $stable = 0;
        private final String articleId;

        public static /* synthetic */ NavigateToArticle copy$default(NavigateToArticle navigateToArticle, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = navigateToArticle.articleId;
            }
            return navigateToArticle.copy(str);
        }

        public final String component1() {
            return this.articleId;
        }

        public final NavigateToArticle copy(String str) {
            Intrinsics.checkNotNullParameter(str, "articleId");
            return new NavigateToArticle(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NavigateToArticle) && Intrinsics.areEqual((Object) this.articleId, (Object) ((NavigateToArticle) obj).articleId);
        }

        public int hashCode() {
            return this.articleId.hashCode();
        }

        public String toString() {
            return "NavigateToArticle(articleId=" + this.articleId + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NavigateToArticle(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "articleId");
            this.articleId = str;
        }

        public final String getArticleId() {
            return this.articleId;
        }
    }
}
