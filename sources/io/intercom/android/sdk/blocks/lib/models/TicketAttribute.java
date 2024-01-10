package io.intercom.android.sdk.blocks.lib.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 *2\u00020\u0001:\u0001*B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B?\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u000eHÆ\u0003JM\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eHÆ\u0001J\b\u0010!\u001a\u00020\u0006H\u0016J\u0013\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\t\u0010&\u001a\u00020\bHÖ\u0001J\u0018\u0010'\u001a\u00020(2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0006H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013¨\u0006+"}, d2 = {"Lio/intercom/android/sdk/blocks/lib/models/TicketAttribute;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "name", "", "type", "required", "", "identifier", "options", "", "(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;)V", "getId", "()I", "getIdentifier", "()Ljava/lang/String;", "getName", "getOptions", "()Ljava/util/List;", "getRequired", "()Z", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketType.kt */
public final class TicketAttribute implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private final int id;
    private final String identifier;
    private final String name;
    private final List<String> options;
    private final boolean required;
    private final String type;

    public static /* synthetic */ TicketAttribute copy$default(TicketAttribute ticketAttribute, int i, String str, String str2, boolean z, String str3, List<String> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = ticketAttribute.id;
        }
        if ((i2 & 2) != 0) {
            str = ticketAttribute.name;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            str2 = ticketAttribute.type;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            z = ticketAttribute.required;
        }
        boolean z2 = z;
        if ((i2 & 16) != 0) {
            str3 = ticketAttribute.identifier;
        }
        String str6 = str3;
        if ((i2 & 32) != 0) {
            list = ticketAttribute.options;
        }
        return ticketAttribute.copy(i, str4, str5, z2, str6, list);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.type;
    }

    public final boolean component4() {
        return this.required;
    }

    public final String component5() {
        return this.identifier;
    }

    public final List<String> component6() {
        return this.options;
    }

    public final TicketAttribute copy(int i, String str, String str2, boolean z, String str3, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        return new TicketAttribute(i, str, str2, z, str3, list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TicketAttribute)) {
            return false;
        }
        TicketAttribute ticketAttribute = (TicketAttribute) obj;
        return this.id == ticketAttribute.id && Intrinsics.areEqual((Object) this.name, (Object) ticketAttribute.name) && Intrinsics.areEqual((Object) this.type, (Object) ticketAttribute.type) && this.required == ticketAttribute.required && Intrinsics.areEqual((Object) this.identifier, (Object) ticketAttribute.identifier) && Intrinsics.areEqual((Object) this.options, (Object) ticketAttribute.options);
    }

    public int hashCode() {
        int hashCode = ((((this.id * 31) + this.name.hashCode()) * 31) + this.type.hashCode()) * 31;
        boolean z = this.required;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        String str = this.identifier;
        return ((i + (str == null ? 0 : str.hashCode())) * 31) + this.options.hashCode();
    }

    public String toString() {
        return "TicketAttribute(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", required=" + this.required + ", identifier=" + this.identifier + ", options=" + this.options + ')';
    }

    public TicketAttribute(int i, String str, String str2, boolean z, String str3, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        this.id = i;
        this.name = str;
        this.type = str2;
        this.required = z;
        this.identifier = str3;
        this.options = list;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TicketAttribute(int i, String str, String str2, boolean z, String str3, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, z, str3, (i2 & 32) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<String> getOptions() {
        return this.options;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TicketAttribute(android.os.Parcel r9) {
        /*
            r8 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            int r2 = r9.readInt()
            java.lang.String r0 = r9.readString()
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0013
            r3 = r1
            goto L_0x0014
        L_0x0013:
            r3 = r0
        L_0x0014:
            java.lang.String r0 = r9.readString()
            if (r0 != 0) goto L_0x001c
            r4 = r1
            goto L_0x001d
        L_0x001c:
            r4 = r0
        L_0x001d:
            java.lang.String r0 = r9.readString()
            boolean r5 = java.lang.Boolean.parseBoolean(r0)
            java.lang.String r6 = r9.readString()
            java.util.ArrayList r9 = r9.createStringArrayList()
            if (r9 != 0) goto L_0x0034
            java.util.List r9 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0036
        L_0x0034:
            java.util.List r9 = (java.util.List) r9
        L_0x0036:
            r7 = r9
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.blocks.lib.models.TicketAttribute.<init>(android.os.Parcel):void");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.type);
        parcel.writeString(String.valueOf(this.required));
        parcel.writeString(this.identifier);
        parcel.writeStringList(this.options);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lio/intercom/android/sdk/blocks/lib/models/TicketAttribute$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lio/intercom/android/sdk/blocks/lib/models/TicketAttribute;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lio/intercom/android/sdk/blocks/lib/models/TicketAttribute;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TicketType.kt */
    public static final class CREATOR implements Parcelable.Creator<TicketAttribute> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public TicketAttribute createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TicketAttribute(parcel);
        }

        public TicketAttribute[] newArray(int i) {
            return new TicketAttribute[i];
        }
    }
}
