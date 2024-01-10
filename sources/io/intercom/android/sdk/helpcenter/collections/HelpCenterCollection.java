package io.intercom.android.sdk.helpcenter.collections;

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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 *2\u00020\u0001:\u0002)*BG\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB+\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001J!\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(HÇ\u0001R\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0013¨\u0006+"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/HelpCenterCollection;", "", "seen1", "", "summary", "", "id", "title", "articlesCount", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getArticlesCount$annotations", "()V", "getArticlesCount", "()I", "getId$annotations", "getId", "()Ljava/lang/String;", "getSummary$annotations", "getSummary", "getTitle$annotations", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* compiled from: HelpCenterCollection.kt */
public final class HelpCenterCollection {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int articlesCount;
    private final String id;
    private final String summary;
    private final String title;

    public static /* synthetic */ HelpCenterCollection copy$default(HelpCenterCollection helpCenterCollection, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = helpCenterCollection.summary;
        }
        if ((i2 & 2) != 0) {
            str2 = helpCenterCollection.id;
        }
        if ((i2 & 4) != 0) {
            str3 = helpCenterCollection.title;
        }
        if ((i2 & 8) != 0) {
            i = helpCenterCollection.articlesCount;
        }
        return helpCenterCollection.copy(str, str2, str3, i);
    }

    @SerialName("article_count")
    public static /* synthetic */ void getArticlesCount$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("description")
    public static /* synthetic */ void getSummary$annotations() {
    }

    @SerialName("name")
    public static /* synthetic */ void getTitle$annotations() {
    }

    public final String component1() {
        return this.summary;
    }

    public final String component2() {
        return this.id;
    }

    public final String component3() {
        return this.title;
    }

    public final int component4() {
        return this.articlesCount;
    }

    public final HelpCenterCollection copy(String str, String str2, String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "summary");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str3, "title");
        return new HelpCenterCollection(str, str2, str3, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HelpCenterCollection)) {
            return false;
        }
        HelpCenterCollection helpCenterCollection = (HelpCenterCollection) obj;
        return Intrinsics.areEqual((Object) this.summary, (Object) helpCenterCollection.summary) && Intrinsics.areEqual((Object) this.id, (Object) helpCenterCollection.id) && Intrinsics.areEqual((Object) this.title, (Object) helpCenterCollection.title) && this.articlesCount == helpCenterCollection.articlesCount;
    }

    public int hashCode() {
        return (((((this.summary.hashCode() * 31) + this.id.hashCode()) * 31) + this.title.hashCode()) * 31) + this.articlesCount;
    }

    public String toString() {
        return "HelpCenterCollection(summary=" + this.summary + ", id=" + this.id + ", title=" + this.title + ", articlesCount=" + this.articlesCount + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/HelpCenterCollection$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/intercom/android/sdk/helpcenter/collections/HelpCenterCollection;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HelpCenterCollection.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<HelpCenterCollection> serializer() {
            return HelpCenterCollection$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ HelpCenterCollection(int i, @SerialName("description") String str, @SerialName("id") String str2, @SerialName("name") String str3, @SerialName("article_count") int i2, SerializationConstructorMarker serializationConstructorMarker) {
        if (2 != (i & 2)) {
            PluginExceptionsKt.throwMissingFieldException(i, 2, HelpCenterCollection$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.summary = "";
        } else {
            this.summary = str;
        }
        this.id = str2;
        if ((i & 4) == 0) {
            this.title = "";
        } else {
            this.title = str3;
        }
        if ((i & 8) == 0) {
            this.articlesCount = 0;
        } else {
            this.articlesCount = i2;
        }
    }

    public HelpCenterCollection(String str, String str2, String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "summary");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str3, "title");
        this.summary = str;
        this.id = str2;
        this.title = str3;
        this.articlesCount = i;
    }

    @JvmStatic
    public static final void write$Self(HelpCenterCollection helpCenterCollection, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        Intrinsics.checkNotNullParameter(helpCenterCollection, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        boolean z2 = false;
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) && Intrinsics.areEqual((Object) helpCenterCollection.summary, (Object) "")) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            compositeEncoder.encodeStringElement(serialDescriptor, 0, helpCenterCollection.summary);
        }
        compositeEncoder.encodeStringElement(serialDescriptor, 1, helpCenterCollection.id);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || !Intrinsics.areEqual((Object) helpCenterCollection.title, (Object) "")) {
            compositeEncoder.encodeStringElement(serialDescriptor, 2, helpCenterCollection.title);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || helpCenterCollection.articlesCount != 0) {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.encodeIntElement(serialDescriptor, 3, helpCenterCollection.articlesCount);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HelpCenterCollection(String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? 0 : i);
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getArticlesCount() {
        return this.articlesCount;
    }
}
