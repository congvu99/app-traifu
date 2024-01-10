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

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 $2\u00020\u0001:\u0002#$B7\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0001\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001f\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\fJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J#\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J!\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÇ\u0001R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Lio/intercom/android/sdk/helpcenter/sections/HelpCenterSection;", "", "seen1", "", "helpCenterArticles", "", "Lio/intercom/android/sdk/helpcenter/sections/HelpCenterArticle;", "title", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Ljava/lang/String;)V", "getHelpCenterArticles$annotations", "()V", "getHelpCenterArticles", "()Ljava/util/List;", "getTitle$annotations", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* compiled from: HelpCenterCollectionContent.kt */
public final class HelpCenterSection {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<HelpCenterArticle> helpCenterArticles;
    private final String title;

    public HelpCenterSection() {
        this((List) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ HelpCenterSection copy$default(HelpCenterSection helpCenterSection, List<HelpCenterArticle> list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = helpCenterSection.helpCenterArticles;
        }
        if ((i & 2) != 0) {
            str = helpCenterSection.title;
        }
        return helpCenterSection.copy(list, str);
    }

    @SerialName("articles")
    public static /* synthetic */ void getHelpCenterArticles$annotations() {
    }

    @SerialName("name")
    public static /* synthetic */ void getTitle$annotations() {
    }

    public final List<HelpCenterArticle> component1() {
        return this.helpCenterArticles;
    }

    public final String component2() {
        return this.title;
    }

    public final HelpCenterSection copy(List<HelpCenterArticle> list, String str) {
        Intrinsics.checkNotNullParameter(list, "helpCenterArticles");
        Intrinsics.checkNotNullParameter(str, "title");
        return new HelpCenterSection(list, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HelpCenterSection)) {
            return false;
        }
        HelpCenterSection helpCenterSection = (HelpCenterSection) obj;
        return Intrinsics.areEqual((Object) this.helpCenterArticles, (Object) helpCenterSection.helpCenterArticles) && Intrinsics.areEqual((Object) this.title, (Object) helpCenterSection.title);
    }

    public int hashCode() {
        return (this.helpCenterArticles.hashCode() * 31) + this.title.hashCode();
    }

    public String toString() {
        return "HelpCenterSection(helpCenterArticles=" + this.helpCenterArticles + ", title=" + this.title + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lio/intercom/android/sdk/helpcenter/sections/HelpCenterSection$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/intercom/android/sdk/helpcenter/sections/HelpCenterSection;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HelpCenterCollectionContent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<HelpCenterSection> serializer() {
            return HelpCenterSection$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ HelpCenterSection(int i, @SerialName("articles") List<HelpCenterArticle> list, @SerialName("name") String str, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, HelpCenterSection$$serializer.INSTANCE.getDescriptor());
        }
        this.helpCenterArticles = (i & 1) == 0 ? CollectionsKt.emptyList() : list;
        if ((i & 2) == 0) {
            this.title = "";
        } else {
            this.title = str;
        }
    }

    public HelpCenterSection(List<HelpCenterArticle> list, String str) {
        Intrinsics.checkNotNullParameter(list, "helpCenterArticles");
        Intrinsics.checkNotNullParameter(str, "title");
        this.helpCenterArticles = list;
        this.title = str;
    }

    @JvmStatic
    public static final void write$Self(HelpCenterSection helpCenterSection, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        Intrinsics.checkNotNullParameter(helpCenterSection, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        boolean z2 = false;
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) && Intrinsics.areEqual((Object) helpCenterSection.helpCenterArticles, (Object) CollectionsKt.emptyList())) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 0, new ArrayListSerializer(HelpCenterArticle$$serializer.INSTANCE), helpCenterSection.helpCenterArticles);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || !Intrinsics.areEqual((Object) helpCenterSection.title, (Object) "")) {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.encodeStringElement(serialDescriptor, 1, helpCenterSection.title);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HelpCenterSection(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? "" : str);
    }

    public final List<HelpCenterArticle> getHelpCenterArticles() {
        return this.helpCenterArticles;
    }

    public final String getTitle() {
        return this.title;
    }
}
