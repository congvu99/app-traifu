package io.intercom.android.sdk;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lio/intercom/android/sdk/IntercomContent;", "", "()V", "Article", "Carousel", "HelpCenterCollections", "Survey", "Lio/intercom/android/sdk/IntercomContent$Article;", "Lio/intercom/android/sdk/IntercomContent$Carousel;", "Lio/intercom/android/sdk/IntercomContent$HelpCenterCollections;", "Lio/intercom/android/sdk/IntercomContent$Survey;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Intercom.kt */
public abstract class IntercomContent {
    public static final int $stable = 0;

    public /* synthetic */ IntercomContent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lio/intercom/android/sdk/IntercomContent$HelpCenterCollections;", "Lio/intercom/android/sdk/IntercomContent;", "ids", "", "", "(Ljava/util/List;)V", "getIds", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Intercom.kt */
    public static final class HelpCenterCollections extends IntercomContent {
        public static final int $stable = 8;
        private final List<String> ids;

        public static /* synthetic */ HelpCenterCollections copy$default(HelpCenterCollections helpCenterCollections, List<String> list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = helpCenterCollections.ids;
            }
            return helpCenterCollections.copy(list);
        }

        public final List<String> component1() {
            return this.ids;
        }

        public final HelpCenterCollections copy(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "ids");
            return new HelpCenterCollections(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HelpCenterCollections) && Intrinsics.areEqual((Object) this.ids, (Object) ((HelpCenterCollections) obj).ids);
        }

        public int hashCode() {
            return this.ids.hashCode();
        }

        public String toString() {
            return "HelpCenterCollections(ids=" + this.ids + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HelpCenterCollections(List<String> list) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, "ids");
            this.ids = list;
        }

        public final List<String> getIds() {
            return this.ids;
        }
    }

    private IntercomContent() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/IntercomContent$Article;", "Lio/intercom/android/sdk/IntercomContent;", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Intercom.kt */
    public static final class Article extends IntercomContent {
        public static final int $stable = 0;
        private final String id;

        public static /* synthetic */ Article copy$default(Article article, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = article.id;
            }
            return article.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final Article copy(String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            return new Article(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Article) && Intrinsics.areEqual((Object) this.id, (Object) ((Article) obj).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "Article(id=" + this.id + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Article(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            this.id = str;
        }

        public final String getId() {
            return this.id;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/IntercomContent$Carousel;", "Lio/intercom/android/sdk/IntercomContent;", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Intercom.kt */
    public static final class Carousel extends IntercomContent {
        public static final int $stable = 0;
        private final String id;

        public static /* synthetic */ Carousel copy$default(Carousel carousel, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = carousel.id;
            }
            return carousel.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final Carousel copy(String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            return new Carousel(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Carousel) && Intrinsics.areEqual((Object) this.id, (Object) ((Carousel) obj).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "Carousel(id=" + this.id + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Carousel(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            this.id = str;
        }

        public final String getId() {
            return this.id;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/IntercomContent$Survey;", "Lio/intercom/android/sdk/IntercomContent;", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Intercom.kt */
    public static final class Survey extends IntercomContent {
        public static final int $stable = 0;
        private final String id;

        public static /* synthetic */ Survey copy$default(Survey survey, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = survey.id;
            }
            return survey.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final Survey copy(String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            return new Survey(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Survey) && Intrinsics.areEqual((Object) this.id, (Object) ((Survey) obj).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "Survey(id=" + this.id + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Survey(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            this.id = str;
        }

        public final String getId() {
            return this.id;
        }
    }
}
