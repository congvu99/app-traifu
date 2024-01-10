package io.intercom.android.sdk.blocks.lib.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B+\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020\bHÖ\u0001J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0006H\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006%"}, d2 = {"Lio/intercom/android/sdk/blocks/lib/models/TicketType;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "name", "", "emoji", "attributes", "", "Lio/intercom/android/sdk/blocks/lib/models/TicketAttribute;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAttributes", "()Ljava/util/List;", "getEmoji", "()Ljava/lang/String;", "getId", "()I", "getName", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketType.kt */
public final class TicketType implements Parcelable {
    public static final Parcelable.Creator<TicketType> CREATOR = new TicketType$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final TicketType NULL = new TicketType(-1, "", "", CollectionsKt.emptyList());
    private final List<TicketAttribute> attributes;
    private final String emoji;
    private final int id;
    private final String name;

    public static /* synthetic */ TicketType copy$default(TicketType ticketType, int i, String str, String str2, List<TicketAttribute> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = ticketType.id;
        }
        if ((i2 & 2) != 0) {
            str = ticketType.name;
        }
        if ((i2 & 4) != 0) {
            str2 = ticketType.emoji;
        }
        if ((i2 & 8) != 0) {
            list = ticketType.attributes;
        }
        return ticketType.copy(i, str, str2, list);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.emoji;
    }

    public final List<TicketAttribute> component4() {
        return this.attributes;
    }

    public final TicketType copy(int i, String str, String str2, List<TicketAttribute> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "emoji");
        Intrinsics.checkNotNullParameter(list, "attributes");
        return new TicketType(i, str, str2, list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TicketType)) {
            return false;
        }
        TicketType ticketType = (TicketType) obj;
        return this.id == ticketType.id && Intrinsics.areEqual((Object) this.name, (Object) ticketType.name) && Intrinsics.areEqual((Object) this.emoji, (Object) ticketType.emoji) && Intrinsics.areEqual((Object) this.attributes, (Object) ticketType.attributes);
    }

    public int hashCode() {
        return (((((this.id * 31) + this.name.hashCode()) * 31) + this.emoji.hashCode()) * 31) + this.attributes.hashCode();
    }

    public String toString() {
        return "TicketType(id=" + this.id + ", name=" + this.name + ", emoji=" + this.emoji + ", attributes=" + this.attributes + ')';
    }

    public TicketType(int i, String str, String str2, List<TicketAttribute> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "emoji");
        Intrinsics.checkNotNullParameter(list, "attributes");
        this.id = i;
        this.name = str;
        this.emoji = str2;
        this.attributes = list;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getEmoji() {
        return this.emoji;
    }

    public final List<TicketAttribute> getAttributes() {
        return this.attributes;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TicketType(android.os.Parcel r5) {
        /*
            r4 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            int r0 = r5.readInt()
            java.lang.String r1 = r5.readString()
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x0012
            r1 = r2
        L_0x0012:
            java.lang.String r3 = r5.readString()
            if (r3 != 0) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            r2 = r3
        L_0x001a:
            io.intercom.android.sdk.blocks.lib.models.TicketAttribute$CREATOR r3 = io.intercom.android.sdk.blocks.lib.models.TicketAttribute.CREATOR
            android.os.Parcelable$Creator r3 = (android.os.Parcelable.Creator) r3
            java.util.ArrayList r5 = r5.createTypedArrayList(r3)
            if (r5 != 0) goto L_0x0029
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x002b
        L_0x0029:
            java.util.List r5 = (java.util.List) r5
        L_0x002b:
            r4.<init>(r0, r1, r2, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.blocks.lib.models.TicketType.<init>(android.os.Parcel):void");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.emoji);
        parcel.writeTypedList(this.attributes);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/intercom/android/sdk/blocks/lib/models/TicketType$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lio/intercom/android/sdk/blocks/lib/models/TicketType;", "NULL", "getNULL", "()Lio/intercom/android/sdk/blocks/lib/models/TicketType;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TicketType.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TicketType getNULL() {
            return TicketType.NULL;
        }
    }
}
