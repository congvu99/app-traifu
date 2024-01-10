package io.intercom.android.sdk.helpcenter.search;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 /2\u00020\u0001:\u0003./0BU\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J;\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001J!\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-HÇ\u0001R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012¨\u00061"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/HelpCenterArticleSearchResponse;", "", "seen1", "", "articleId", "", "summary", "title", "url", "highlight", "Lio/intercom/android/sdk/helpcenter/search/HelpCenterArticleSearchResponse$Highlight;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/intercom/android/sdk/helpcenter/search/HelpCenterArticleSearchResponse$Highlight;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/intercom/android/sdk/helpcenter/search/HelpCenterArticleSearchResponse$Highlight;)V", "getArticleId$annotations", "()V", "getArticleId", "()Ljava/lang/String;", "getHighlight$annotations", "getHighlight", "()Lio/intercom/android/sdk/helpcenter/search/HelpCenterArticleSearchResponse$Highlight;", "getSummary$annotations", "getSummary", "getTitle$annotations", "getTitle", "getUrl$annotations", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "Highlight", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* compiled from: HelpCenterArticleSearchResponse.kt */
public final class HelpCenterArticleSearchResponse {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String articleId;
    private final Highlight highlight;
    private final String summary;
    private final String title;
    private final String url;

    public static /* synthetic */ HelpCenterArticleSearchResponse copy$default(HelpCenterArticleSearchResponse helpCenterArticleSearchResponse, String str, String str2, String str3, String str4, Highlight highlight2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = helpCenterArticleSearchResponse.articleId;
        }
        if ((i & 2) != 0) {
            str2 = helpCenterArticleSearchResponse.summary;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = helpCenterArticleSearchResponse.title;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = helpCenterArticleSearchResponse.url;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            highlight2 = helpCenterArticleSearchResponse.highlight;
        }
        return helpCenterArticleSearchResponse.copy(str, str5, str6, str7, highlight2);
    }

    @SerialName("id")
    public static /* synthetic */ void getArticleId$annotations() {
    }

    @SerialName("highlight")
    public static /* synthetic */ void getHighlight$annotations() {
    }

    @SerialName("summary")
    public static /* synthetic */ void getSummary$annotations() {
    }

    @SerialName("title")
    public static /* synthetic */ void getTitle$annotations() {
    }

    @SerialName("url")
    public static /* synthetic */ void getUrl$annotations() {
    }

    public final String component1() {
        return this.articleId;
    }

    public final String component2() {
        return this.summary;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.url;
    }

    public final Highlight component5() {
        return this.highlight;
    }

    public final HelpCenterArticleSearchResponse copy(String str, String str2, String str3, String str4, Highlight highlight2) {
        Intrinsics.checkNotNullParameter(str, "articleId");
        Intrinsics.checkNotNullParameter(str2, "summary");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(str4, "url");
        Intrinsics.checkNotNullParameter(highlight2, "highlight");
        return new HelpCenterArticleSearchResponse(str, str2, str3, str4, highlight2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HelpCenterArticleSearchResponse)) {
            return false;
        }
        HelpCenterArticleSearchResponse helpCenterArticleSearchResponse = (HelpCenterArticleSearchResponse) obj;
        return Intrinsics.areEqual((Object) this.articleId, (Object) helpCenterArticleSearchResponse.articleId) && Intrinsics.areEqual((Object) this.summary, (Object) helpCenterArticleSearchResponse.summary) && Intrinsics.areEqual((Object) this.title, (Object) helpCenterArticleSearchResponse.title) && Intrinsics.areEqual((Object) this.url, (Object) helpCenterArticleSearchResponse.url) && Intrinsics.areEqual((Object) this.highlight, (Object) helpCenterArticleSearchResponse.highlight);
    }

    public int hashCode() {
        return (((((((this.articleId.hashCode() * 31) + this.summary.hashCode()) * 31) + this.title.hashCode()) * 31) + this.url.hashCode()) * 31) + this.highlight.hashCode();
    }

    public String toString() {
        return "HelpCenterArticleSearchResponse(articleId=" + this.articleId + ", summary=" + this.summary + ", title=" + this.title + ", url=" + this.url + ", highlight=" + this.highlight + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/HelpCenterArticleSearchResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/intercom/android/sdk/helpcenter/search/HelpCenterArticleSearchResponse;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HelpCenterArticleSearchResponse.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<HelpCenterArticleSearchResponse> serializer() {
            return HelpCenterArticleSearchResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ HelpCenterArticleSearchResponse(int i, @SerialName("id") String str, @SerialName("summary") String str2, @SerialName("title") String str3, @SerialName("url") String str4, @SerialName("highlight") Highlight highlight2, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, HelpCenterArticleSearchResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.articleId = str;
        if ((i & 2) == 0) {
            this.summary = "";
        } else {
            this.summary = str2;
        }
        if ((i & 4) == 0) {
            this.title = "";
        } else {
            this.title = str3;
        }
        if ((i & 8) == 0) {
            this.url = "";
        } else {
            this.url = str4;
        }
        if ((i & 16) == 0) {
            this.highlight = new Highlight((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        } else {
            this.highlight = highlight2;
        }
    }

    public HelpCenterArticleSearchResponse(String str, String str2, String str3, String str4, Highlight highlight2) {
        Intrinsics.checkNotNullParameter(str, "articleId");
        Intrinsics.checkNotNullParameter(str2, "summary");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(str4, "url");
        Intrinsics.checkNotNullParameter(highlight2, "highlight");
        this.articleId = str;
        this.summary = str2;
        this.title = str3;
        this.url = str4;
        this.highlight = highlight2;
    }

    @JvmStatic
    public static final void write$Self(HelpCenterArticleSearchResponse helpCenterArticleSearchResponse, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(helpCenterArticleSearchResponse, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        boolean z = false;
        compositeEncoder.encodeStringElement(serialDescriptor, 0, helpCenterArticleSearchResponse.articleId);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || !Intrinsics.areEqual((Object) helpCenterArticleSearchResponse.summary, (Object) "")) {
            compositeEncoder.encodeStringElement(serialDescriptor, 1, helpCenterArticleSearchResponse.summary);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || !Intrinsics.areEqual((Object) helpCenterArticleSearchResponse.title, (Object) "")) {
            compositeEncoder.encodeStringElement(serialDescriptor, 2, helpCenterArticleSearchResponse.title);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || !Intrinsics.areEqual((Object) helpCenterArticleSearchResponse.url, (Object) "")) {
            compositeEncoder.encodeStringElement(serialDescriptor, 3, helpCenterArticleSearchResponse.url);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || !Intrinsics.areEqual((Object) helpCenterArticleSearchResponse.highlight, (Object) new Highlight((String) null, (String) null, 3, (DefaultConstructorMarker) null))) {
            z = true;
        }
        if (z) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 4, HelpCenterArticleSearchResponse$Highlight$$serializer.INSTANCE, helpCenterArticleSearchResponse.highlight);
        }
    }

    public final String getArticleId() {
        return this.articleId;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 !2\u00020\u0001:\u0002 !B1\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0019\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J!\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÇ\u0001R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\""}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/HelpCenterArticleSearchResponse$Highlight;", "", "seen1", "", "title", "", "summary", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getSummary$annotations", "()V", "getSummary", "()Ljava/lang/String;", "getTitle$annotations", "getTitle", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: HelpCenterArticleSearchResponse.kt */
    public static final class Highlight {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String summary;
        private final String title;

        public Highlight() {
            this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Highlight copy$default(Highlight highlight, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = highlight.title;
            }
            if ((i & 2) != 0) {
                str2 = highlight.summary;
            }
            return highlight.copy(str, str2);
        }

        @SerialName("summary")
        public static /* synthetic */ void getSummary$annotations() {
        }

        @SerialName("title")
        public static /* synthetic */ void getTitle$annotations() {
        }

        public final String component1() {
            return this.title;
        }

        public final String component2() {
            return this.summary;
        }

        public final Highlight copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "summary");
            return new Highlight(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Highlight)) {
                return false;
            }
            Highlight highlight = (Highlight) obj;
            return Intrinsics.areEqual((Object) this.title, (Object) highlight.title) && Intrinsics.areEqual((Object) this.summary, (Object) highlight.summary);
        }

        public int hashCode() {
            return (this.title.hashCode() * 31) + this.summary.hashCode();
        }

        public String toString() {
            return "Highlight(title=" + this.title + ", summary=" + this.summary + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/HelpCenterArticleSearchResponse$Highlight$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/intercom/android/sdk/helpcenter/search/HelpCenterArticleSearchResponse$Highlight;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: HelpCenterArticleSearchResponse.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Highlight> serializer() {
                return HelpCenterArticleSearchResponse$Highlight$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Highlight(int i, @SerialName("title") String str, @SerialName("summary") String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, HelpCenterArticleSearchResponse$Highlight$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.title = "";
            } else {
                this.title = str;
            }
            if ((i & 2) == 0) {
                this.summary = "";
            } else {
                this.summary = str2;
            }
        }

        public Highlight(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "summary");
            this.title = str;
            this.summary = str2;
        }

        @JvmStatic
        public static final void write$Self(Highlight highlight, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z;
            Intrinsics.checkNotNullParameter(highlight, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            boolean z2 = false;
            if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) && Intrinsics.areEqual((Object) highlight.title, (Object) "")) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                compositeEncoder.encodeStringElement(serialDescriptor, 0, highlight.title);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || !Intrinsics.areEqual((Object) highlight.summary, (Object) "")) {
                z2 = true;
            }
            if (z2) {
                compositeEncoder.encodeStringElement(serialDescriptor, 1, highlight.summary);
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Highlight(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getSummary() {
            return this.summary;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HelpCenterArticleSearchResponse(String str, String str2, String str3, String str4, Highlight highlight2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? new Highlight((String) null, (String) null, 3, (DefaultConstructorMarker) null) : highlight2);
    }

    public final Highlight getHighlight() {
        return this.highlight;
    }
}
