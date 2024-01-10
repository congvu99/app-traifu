package io.intercom.android.sdk.helpcenter.collections;

import io.intercom.android.sdk.helpcenter.articles.ArticleViewState;
import io.intercom.android.sdk.helpcenter.collections.ArticleSectionRow;
import io.intercom.android.sdk.helpcenter.collections.CollectionListRow;
import io.intercom.android.sdk.helpcenter.sections.Author;
import io.intercom.android.sdk.m5.components.ErrorState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState;", "", "()V", "Content", "Error", "Initial", "Loading", "Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState$Content;", "Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState$Error;", "Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState$Initial;", "Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState$Loading;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CollectionViewState.kt */
public abstract class CollectionViewState {
    public /* synthetic */ CollectionViewState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState$Initial;", "Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CollectionViewState.kt */
    public static final class Initial extends CollectionViewState {
        public static final int $stable = 0;
        public static final Initial INSTANCE = new Initial();

        private Initial() {
            super((DefaultConstructorMarker) null);
        }
    }

    private CollectionViewState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState$Loading;", "Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CollectionViewState.kt */
    public static final class Loading extends CollectionViewState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0000H&J\b\u0010\u0007\u001a\u00020\bH&\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState$Content;", "Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState;", "()V", "copyWithSingleSendMessageRow", "teamPresenceState", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;", "copyWithoutSendMessageRow", "hasSendMessageRow", "", "CollectionContent", "CollectionListContent", "Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState$Content$CollectionContent;", "Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState$Content$CollectionListContent;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CollectionViewState.kt */
    public static abstract class Content extends CollectionViewState {
        public static final int $stable = 0;

        public /* synthetic */ Content(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract Content copyWithSingleSendMessageRow(ArticleViewState.TeamPresenceState teamPresenceState);

        public abstract Content copyWithoutSendMessageRow();

        public abstract boolean hasSendMessageRow();

        private Content() {
            super((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0000H\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState$Content$CollectionListContent;", "Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState$Content;", "collections", "", "Lio/intercom/android/sdk/helpcenter/collections/CollectionListRow;", "(Ljava/util/List;)V", "getCollections", "()Ljava/util/List;", "component1", "copy", "copyWithSingleSendMessageRow", "teamPresenceState", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;", "copyWithoutSendMessageRow", "equals", "", "other", "", "hasSendMessageRow", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: CollectionViewState.kt */
        public static final class CollectionListContent extends Content {
            public static final int $stable = 8;
            private final List<CollectionListRow> collections;

            public static /* synthetic */ CollectionListContent copy$default(CollectionListContent collectionListContent, List<CollectionListRow> list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = collectionListContent.collections;
                }
                return collectionListContent.copy(list);
            }

            public final List<CollectionListRow> component1() {
                return this.collections;
            }

            public final CollectionListContent copy(List<? extends CollectionListRow> list) {
                Intrinsics.checkNotNullParameter(list, "collections");
                return new CollectionListContent(list);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof CollectionListContent) && Intrinsics.areEqual((Object) this.collections, (Object) ((CollectionListContent) obj).collections);
            }

            public int hashCode() {
                return this.collections.hashCode();
            }

            public String toString() {
                return "CollectionListContent(collections=" + this.collections + ')';
            }

            public final List<CollectionListRow> getCollections() {
                return this.collections;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public CollectionListContent(List<? extends CollectionListRow> list) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(list, "collections");
                this.collections = list;
            }

            public boolean hasSendMessageRow() {
                Iterable<CollectionListRow> iterable = this.collections;
                if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
                    return false;
                }
                for (CollectionListRow collectionListRow : iterable) {
                    if (collectionListRow instanceof CollectionListRow.SendMessageRow) {
                        return true;
                    }
                }
                return false;
            }

            public CollectionListContent copyWithSingleSendMessageRow(ArticleViewState.TeamPresenceState teamPresenceState) {
                Intrinsics.checkNotNullParameter(teamPresenceState, "teamPresenceState");
                if (!hasSendMessageRow()) {
                    return copy(CollectionsKt.plus(this.collections, new CollectionListRow.SendMessageRow(teamPresenceState)));
                }
                Collection arrayList = new ArrayList();
                for (Object next : this.collections) {
                    if (!(((CollectionListRow) next) instanceof CollectionListRow.SendMessageRow)) {
                        arrayList.add(next);
                    }
                }
                return copy(CollectionsKt.plus((List) arrayList, new CollectionListRow.SendMessageRow(teamPresenceState)));
            }

            public CollectionListContent copyWithoutSendMessageRow() {
                Collection arrayList = new ArrayList();
                for (Object next : this.collections) {
                    if (!(((CollectionListRow) next) instanceof CollectionListRow.SendMessageRow)) {
                        arrayList.add(next);
                    }
                }
                return copy((List) arrayList);
            }
        }

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\bHÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bHÆ\u0001J\u0010\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0000H\u0016J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\b\u0010#\u001a\u00020 H\u0016J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006&"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState$Content$CollectionContent;", "Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState$Content;", "title", "", "summary", "articlesCount", "", "authors", "", "Lio/intercom/android/sdk/helpcenter/sections/Author;", "sectionsUiModel", "Lio/intercom/android/sdk/helpcenter/collections/ArticleSectionRow;", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;)V", "getArticlesCount", "()I", "getAuthors", "()Ljava/util/List;", "getSectionsUiModel", "getSummary", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "copyWithSingleSendMessageRow", "teamPresenceState", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;", "copyWithoutSendMessageRow", "equals", "", "other", "", "hasSendMessageRow", "hashCode", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: CollectionViewState.kt */
        public static final class CollectionContent extends Content {
            public static final int $stable = 8;
            private final int articlesCount;
            private final List<Author> authors;
            private final List<ArticleSectionRow> sectionsUiModel;
            private final String summary;
            private final String title;

            public static /* synthetic */ CollectionContent copy$default(CollectionContent collectionContent, String str, String str2, int i, List<Author> list, List<ArticleSectionRow> list2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = collectionContent.title;
                }
                if ((i2 & 2) != 0) {
                    str2 = collectionContent.summary;
                }
                String str3 = str2;
                if ((i2 & 4) != 0) {
                    i = collectionContent.articlesCount;
                }
                int i3 = i;
                if ((i2 & 8) != 0) {
                    list = collectionContent.authors;
                }
                List<Author> list3 = list;
                if ((i2 & 16) != 0) {
                    list2 = collectionContent.sectionsUiModel;
                }
                return collectionContent.copy(str, str3, i3, list3, list2);
            }

            public final String component1() {
                return this.title;
            }

            public final String component2() {
                return this.summary;
            }

            public final int component3() {
                return this.articlesCount;
            }

            public final List<Author> component4() {
                return this.authors;
            }

            public final List<ArticleSectionRow> component5() {
                return this.sectionsUiModel;
            }

            public final CollectionContent copy(String str, String str2, int i, List<Author> list, List<? extends ArticleSectionRow> list2) {
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(str2, "summary");
                Intrinsics.checkNotNullParameter(list, "authors");
                Intrinsics.checkNotNullParameter(list2, "sectionsUiModel");
                return new CollectionContent(str, str2, i, list, list2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof CollectionContent)) {
                    return false;
                }
                CollectionContent collectionContent = (CollectionContent) obj;
                return Intrinsics.areEqual((Object) this.title, (Object) collectionContent.title) && Intrinsics.areEqual((Object) this.summary, (Object) collectionContent.summary) && this.articlesCount == collectionContent.articlesCount && Intrinsics.areEqual((Object) this.authors, (Object) collectionContent.authors) && Intrinsics.areEqual((Object) this.sectionsUiModel, (Object) collectionContent.sectionsUiModel);
            }

            public int hashCode() {
                return (((((((this.title.hashCode() * 31) + this.summary.hashCode()) * 31) + this.articlesCount) * 31) + this.authors.hashCode()) * 31) + this.sectionsUiModel.hashCode();
            }

            public String toString() {
                return "CollectionContent(title=" + this.title + ", summary=" + this.summary + ", articlesCount=" + this.articlesCount + ", authors=" + this.authors + ", sectionsUiModel=" + this.sectionsUiModel + ')';
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getSummary() {
                return this.summary;
            }

            public final int getArticlesCount() {
                return this.articlesCount;
            }

            public final List<Author> getAuthors() {
                return this.authors;
            }

            public final List<ArticleSectionRow> getSectionsUiModel() {
                return this.sectionsUiModel;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public CollectionContent(String str, String str2, int i, List<Author> list, List<? extends ArticleSectionRow> list2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(str2, "summary");
                Intrinsics.checkNotNullParameter(list, "authors");
                Intrinsics.checkNotNullParameter(list2, "sectionsUiModel");
                this.title = str;
                this.summary = str2;
                this.articlesCount = i;
                this.authors = list;
                this.sectionsUiModel = list2;
            }

            public boolean hasSendMessageRow() {
                Iterable<ArticleSectionRow> iterable = this.sectionsUiModel;
                if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
                    return false;
                }
                for (ArticleSectionRow articleSectionRow : iterable) {
                    if (articleSectionRow instanceof ArticleSectionRow.SendMessageRow) {
                        return true;
                    }
                }
                return false;
            }

            public CollectionContent copyWithSingleSendMessageRow(ArticleViewState.TeamPresenceState teamPresenceState) {
                Intrinsics.checkNotNullParameter(teamPresenceState, "teamPresenceState");
                if (hasSendMessageRow()) {
                    Collection arrayList = new ArrayList();
                    for (Object next : this.sectionsUiModel) {
                        if (!(((ArticleSectionRow) next) instanceof ArticleSectionRow.SendMessageRow)) {
                            arrayList.add(next);
                        }
                    }
                    return copy$default(this, (String) null, (String) null, 0, (List) null, CollectionsKt.plus((List) arrayList, new ArticleSectionRow.SendMessageRow(teamPresenceState)), 15, (Object) null);
                }
                return copy$default(this, (String) null, (String) null, 0, (List) null, CollectionsKt.plus(this.sectionsUiModel, new ArticleSectionRow.SendMessageRow(teamPresenceState)), 15, (Object) null);
            }

            public CollectionContent copyWithoutSendMessageRow() {
                Collection arrayList = new ArrayList();
                for (Object next : this.sectionsUiModel) {
                    if (!(((ArticleSectionRow) next) instanceof ArticleSectionRow.SendMessageRow)) {
                        arrayList.add(next);
                    }
                }
                return copy$default(this, (String) null, (String) null, 0, (List) null, (List) arrayList, 15, (Object) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState$Error;", "Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState;", "errorState", "Lio/intercom/android/sdk/m5/components/ErrorState;", "(Lio/intercom/android/sdk/m5/components/ErrorState;)V", "getErrorState", "()Lio/intercom/android/sdk/m5/components/ErrorState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CollectionViewState.kt */
    public static final class Error extends CollectionViewState {
        public static final int $stable = 0;
        private final ErrorState errorState;

        public static /* synthetic */ Error copy$default(Error error, ErrorState errorState2, int i, Object obj) {
            if ((i & 1) != 0) {
                errorState2 = error.errorState;
            }
            return error.copy(errorState2);
        }

        public final ErrorState component1() {
            return this.errorState;
        }

        public final Error copy(ErrorState errorState2) {
            Intrinsics.checkNotNullParameter(errorState2, "errorState");
            return new Error(errorState2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual((Object) this.errorState, (Object) ((Error) obj).errorState);
        }

        public int hashCode() {
            return this.errorState.hashCode();
        }

        public String toString() {
            return "Error(errorState=" + this.errorState + ')';
        }

        public final ErrorState getErrorState() {
            return this.errorState;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(ErrorState errorState2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(errorState2, "errorState");
            this.errorState = errorState2;
        }
    }
}
