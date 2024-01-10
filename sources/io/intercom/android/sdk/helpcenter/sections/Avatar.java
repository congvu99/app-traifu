package io.intercom.android.sdk.helpcenter.sections;

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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 !2\u00020\u0001:\u0002 !B1\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0019\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J!\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÇ\u0001R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\""}, d2 = {"Lio/intercom/android/sdk/helpcenter/sections/Avatar;", "", "seen1", "", "initials", "", "imageUrl", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getImageUrl$annotations", "()V", "getImageUrl", "()Ljava/lang/String;", "getInitials$annotations", "getInitials", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* compiled from: HelpCenterCollectionContent.kt */
public final class Avatar {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String imageUrl;
    private final String initials;

    public Avatar() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Avatar copy$default(Avatar avatar, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = avatar.initials;
        }
        if ((i & 2) != 0) {
            str2 = avatar.imageUrl;
        }
        return avatar.copy(str, str2);
    }

    @SerialName("image_url")
    public static /* synthetic */ void getImageUrl$annotations() {
    }

    @SerialName("initials")
    public static /* synthetic */ void getInitials$annotations() {
    }

    public final String component1() {
        return this.initials;
    }

    public final String component2() {
        return this.imageUrl;
    }

    public final Avatar copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "initials");
        Intrinsics.checkNotNullParameter(str2, "imageUrl");
        return new Avatar(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Avatar)) {
            return false;
        }
        Avatar avatar = (Avatar) obj;
        return Intrinsics.areEqual((Object) this.initials, (Object) avatar.initials) && Intrinsics.areEqual((Object) this.imageUrl, (Object) avatar.imageUrl);
    }

    public int hashCode() {
        return (this.initials.hashCode() * 31) + this.imageUrl.hashCode();
    }

    public String toString() {
        return "Avatar(initials=" + this.initials + ", imageUrl=" + this.imageUrl + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lio/intercom/android/sdk/helpcenter/sections/Avatar$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/intercom/android/sdk/helpcenter/sections/Avatar;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HelpCenterCollectionContent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Avatar> serializer() {
            return Avatar$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ Avatar(int i, @SerialName("initials") String str, @SerialName("image_url") String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, Avatar$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.initials = "";
        } else {
            this.initials = str;
        }
        if ((i & 2) == 0) {
            this.imageUrl = "";
        } else {
            this.imageUrl = str2;
        }
    }

    public Avatar(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "initials");
        Intrinsics.checkNotNullParameter(str2, "imageUrl");
        this.initials = str;
        this.imageUrl = str2;
    }

    @JvmStatic
    public static final void write$Self(Avatar avatar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        Intrinsics.checkNotNullParameter(avatar, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        boolean z2 = false;
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) && Intrinsics.areEqual((Object) avatar.initials, (Object) "")) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            compositeEncoder.encodeStringElement(serialDescriptor, 0, avatar.initials);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || !Intrinsics.areEqual((Object) avatar.imageUrl, (Object) "")) {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.encodeStringElement(serialDescriptor, 1, avatar.imageUrl);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Avatar(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public final String getInitials() {
        return this.initials;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }
}
