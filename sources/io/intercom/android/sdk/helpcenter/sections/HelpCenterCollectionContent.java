package io.intercom.android.sdk.helpcenter.sections;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 ;2\u00020\u0001:\u0002:;B}\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0001\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\u0010\b\u0001\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012BY\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\u0002\u0010\u0013J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\tHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0\tHÆ\u0003Ja\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t2\b\b\u0002\u0010\r\u001a\u00020\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\tHÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0003HÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001J!\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209HÇ\u0001R\u001c\u0010\r\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u001aR\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u001aR\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0015\u001a\u0004\b#\u0010\u001dR\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0015\u001a\u0004\b%\u0010\u001d¨\u0006<"}, d2 = {"Lio/intercom/android/sdk/helpcenter/sections/HelpCenterCollectionContent;", "", "seen1", "", "collectionId", "", "title", "summary", "helpCenterArticles", "", "Lio/intercom/android/sdk/helpcenter/sections/HelpCenterArticle;", "helpCenterSections", "Lio/intercom/android/sdk/helpcenter/sections/HelpCenterSection;", "articlesCount", "authors", "Lio/intercom/android/sdk/helpcenter/sections/Author;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ILjava/util/List;)V", "getArticlesCount$annotations", "()V", "getArticlesCount", "()I", "getAuthors$annotations", "getAuthors", "()Ljava/util/List;", "getCollectionId$annotations", "getCollectionId", "()Ljava/lang/String;", "getHelpCenterArticles$annotations", "getHelpCenterArticles", "getHelpCenterSections$annotations", "getHelpCenterSections", "getSummary$annotations", "getSummary", "getTitle$annotations", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* compiled from: HelpCenterCollectionContent.kt */
public final class HelpCenterCollectionContent {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int articlesCount;
    private final List<Author> authors;
    private final String collectionId;
    private final List<HelpCenterArticle> helpCenterArticles;
    private final List<HelpCenterSection> helpCenterSections;
    private final String summary;
    private final String title;

    public static /* synthetic */ HelpCenterCollectionContent copy$default(HelpCenterCollectionContent helpCenterCollectionContent, String str, String str2, String str3, List<HelpCenterArticle> list, List<HelpCenterSection> list2, int i, List<Author> list3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = helpCenterCollectionContent.collectionId;
        }
        if ((i2 & 2) != 0) {
            str2 = helpCenterCollectionContent.title;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = helpCenterCollectionContent.summary;
        }
        String str5 = str3;
        if ((i2 & 8) != 0) {
            list = helpCenterCollectionContent.helpCenterArticles;
        }
        List<HelpCenterArticle> list4 = list;
        if ((i2 & 16) != 0) {
            list2 = helpCenterCollectionContent.helpCenterSections;
        }
        List<HelpCenterSection> list5 = list2;
        if ((i2 & 32) != 0) {
            i = helpCenterCollectionContent.articlesCount;
        }
        int i3 = i;
        if ((i2 & 64) != 0) {
            list3 = helpCenterCollectionContent.authors;
        }
        return helpCenterCollectionContent.copy(str, str4, str5, list4, list5, i3, list3);
    }

    @SerialName("article_count")
    public static /* synthetic */ void getArticlesCount$annotations() {
    }

    @SerialName("authors")
    public static /* synthetic */ void getAuthors$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getCollectionId$annotations() {
    }

    @SerialName("articles")
    public static /* synthetic */ void getHelpCenterArticles$annotations() {
    }

    @SerialName("sections")
    public static /* synthetic */ void getHelpCenterSections$annotations() {
    }

    @SerialName("description")
    public static /* synthetic */ void getSummary$annotations() {
    }

    @SerialName("name")
    public static /* synthetic */ void getTitle$annotations() {
    }

    public final String component1() {
        return this.collectionId;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.summary;
    }

    public final List<HelpCenterArticle> component4() {
        return this.helpCenterArticles;
    }

    public final List<HelpCenterSection> component5() {
        return this.helpCenterSections;
    }

    public final int component6() {
        return this.articlesCount;
    }

    public final List<Author> component7() {
        return this.authors;
    }

    public final HelpCenterCollectionContent copy(String str, String str2, String str3, List<HelpCenterArticle> list, List<HelpCenterSection> list2, int i, List<Author> list3) {
        Intrinsics.checkNotNullParameter(str, "collectionId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "summary");
        Intrinsics.checkNotNullParameter(list, "helpCenterArticles");
        Intrinsics.checkNotNullParameter(list2, "helpCenterSections");
        List<Author> list4 = list3;
        Intrinsics.checkNotNullParameter(list4, "authors");
        return new HelpCenterCollectionContent(str, str2, str3, list, list2, i, list4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HelpCenterCollectionContent)) {
            return false;
        }
        HelpCenterCollectionContent helpCenterCollectionContent = (HelpCenterCollectionContent) obj;
        return Intrinsics.areEqual((Object) this.collectionId, (Object) helpCenterCollectionContent.collectionId) && Intrinsics.areEqual((Object) this.title, (Object) helpCenterCollectionContent.title) && Intrinsics.areEqual((Object) this.summary, (Object) helpCenterCollectionContent.summary) && Intrinsics.areEqual((Object) this.helpCenterArticles, (Object) helpCenterCollectionContent.helpCenterArticles) && Intrinsics.areEqual((Object) this.helpCenterSections, (Object) helpCenterCollectionContent.helpCenterSections) && this.articlesCount == helpCenterCollectionContent.articlesCount && Intrinsics.areEqual((Object) this.authors, (Object) helpCenterCollectionContent.authors);
    }

    public int hashCode() {
        return (((((((((((this.collectionId.hashCode() * 31) + this.title.hashCode()) * 31) + this.summary.hashCode()) * 31) + this.helpCenterArticles.hashCode()) * 31) + this.helpCenterSections.hashCode()) * 31) + this.articlesCount) * 31) + this.authors.hashCode();
    }

    public String toString() {
        return "HelpCenterCollectionContent(collectionId=" + this.collectionId + ", title=" + this.title + ", summary=" + this.summary + ", helpCenterArticles=" + this.helpCenterArticles + ", helpCenterSections=" + this.helpCenterSections + ", articlesCount=" + this.articlesCount + ", authors=" + this.authors + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lio/intercom/android/sdk/helpcenter/sections/HelpCenterCollectionContent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/intercom/android/sdk/helpcenter/sections/HelpCenterCollectionContent;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HelpCenterCollectionContent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<HelpCenterCollectionContent> serializer() {
            return HelpCenterCollectionContent$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ HelpCenterCollectionContent(int i, @SerialName("id") String str, @SerialName("name") String str2, @SerialName("description") String str3, @SerialName("articles") List list, @SerialName("sections") List list2, @SerialName("article_count") int i2, @SerialName("authors") List list3, SerializationConstructorMarker serializationConstructorMarker) {
        if (33 != (i & 33)) {
            PluginExceptionsKt.throwMissingFieldException(i, 33, HelpCenterCollectionContent$$serializer.INSTANCE.getDescriptor());
        }
        this.collectionId = str;
        if ((i & 2) == 0) {
            this.title = "";
        } else {
            this.title = str2;
        }
        if ((i & 4) == 0) {
            this.summary = "";
        } else {
            this.summary = str3;
        }
        if ((i & 8) == 0) {
            this.helpCenterArticles = CollectionsKt.emptyList();
        } else {
            this.helpCenterArticles = list;
        }
        if ((i & 16) == 0) {
            this.helpCenterSections = CollectionsKt.emptyList();
        } else {
            this.helpCenterSections = list2;
        }
        this.articlesCount = i2;
        if ((i & 64) == 0) {
            this.authors = CollectionsKt.emptyList();
        } else {
            this.authors = list3;
        }
    }

    public HelpCenterCollectionContent(String str, String str2, String str3, List<HelpCenterArticle> list, List<HelpCenterSection> list2, int i, List<Author> list3) {
        Intrinsics.checkNotNullParameter(str, "collectionId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "summary");
        Intrinsics.checkNotNullParameter(list, "helpCenterArticles");
        Intrinsics.checkNotNullParameter(list2, "helpCenterSections");
        Intrinsics.checkNotNullParameter(list3, "authors");
        this.collectionId = str;
        this.title = str2;
        this.summary = str3;
        this.helpCenterArticles = list;
        this.helpCenterSections = list2;
        this.articlesCount = i;
        this.authors = list3;
    }

    @JvmStatic
    public static final void write$Self(HelpCenterCollectionContent helpCenterCollectionContent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        Intrinsics.checkNotNullParameter(helpCenterCollectionContent, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        boolean z2 = false;
        compositeEncoder.encodeStringElement(serialDescriptor, 0, helpCenterCollectionContent.collectionId);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || !Intrinsics.areEqual((Object) helpCenterCollectionContent.title, (Object) "")) {
            compositeEncoder.encodeStringElement(serialDescriptor, 1, helpCenterCollectionContent.title);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || !Intrinsics.areEqual((Object) helpCenterCollectionContent.summary, (Object) "")) {
            compositeEncoder.encodeStringElement(serialDescriptor, 2, helpCenterCollectionContent.summary);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || !Intrinsics.areEqual((Object) helpCenterCollectionContent.helpCenterArticles, (Object) CollectionsKt.emptyList())) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 3, new ArrayListSerializer(HelpCenterArticle$$serializer.INSTANCE), helpCenterCollectionContent.helpCenterArticles);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) && Intrinsics.areEqual((Object) helpCenterCollectionContent.helpCenterSections, (Object) CollectionsKt.emptyList())) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 4, new ArrayListSerializer(HelpCenterSection$$serializer.INSTANCE), helpCenterCollectionContent.helpCenterSections);
        }
        compositeEncoder.encodeIntElement(serialDescriptor, 5, helpCenterCollectionContent.articlesCount);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) || !Intrinsics.areEqual((Object) helpCenterCollectionContent.authors, (Object) CollectionsKt.emptyList())) {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 6, new ArrayListSerializer(Author$$serializer.INSTANCE), helpCenterCollectionContent.authors);
        }
    }

    public final String getCollectionId() {
        return this.collectionId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSummary() {
        return this.summary;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HelpCenterCollectionContent(java.lang.String r11, java.lang.String r12, java.lang.String r13, java.util.List r14, java.util.List r15, int r16, java.util.List r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r10 = this;
            r0 = r18 & 2
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0008
            r4 = r1
            goto L_0x0009
        L_0x0008:
            r4 = r12
        L_0x0009:
            r0 = r18 & 4
            if (r0 == 0) goto L_0x000f
            r5 = r1
            goto L_0x0010
        L_0x000f:
            r5 = r13
        L_0x0010:
            r0 = r18 & 8
            if (r0 == 0) goto L_0x001a
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r6 = r0
            goto L_0x001b
        L_0x001a:
            r6 = r14
        L_0x001b:
            r0 = r18 & 16
            if (r0 == 0) goto L_0x0025
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r7 = r0
            goto L_0x0026
        L_0x0025:
            r7 = r15
        L_0x0026:
            r0 = r18 & 64
            if (r0 == 0) goto L_0x0030
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r9 = r0
            goto L_0x0032
        L_0x0030:
            r9 = r17
        L_0x0032:
            r2 = r10
            r3 = r11
            r8 = r16
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.helpcenter.sections.HelpCenterCollectionContent.<init>(java.lang.String, java.lang.String, java.lang.String, java.util.List, java.util.List, int, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<HelpCenterArticle> getHelpCenterArticles() {
        return this.helpCenterArticles;
    }

    public final List<HelpCenterSection> getHelpCenterSections() {
        return this.helpCenterSections;
    }

    public final int getArticlesCount() {
        return this.articlesCount;
    }

    public final List<Author> getAuthors() {
        return this.authors;
    }
}
