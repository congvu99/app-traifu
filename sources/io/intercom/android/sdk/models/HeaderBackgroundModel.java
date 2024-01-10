package io.intercom.android.sdk.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lio/intercom/android/sdk/models/HeaderBackgroundModel;", "", "color", "", "gradient", "", "imageUrl", "fade", "", "type", "Lio/intercom/android/sdk/models/HeaderBackdropType;", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLio/intercom/android/sdk/models/HeaderBackdropType;)V", "getColor", "()Ljava/lang/String;", "getFade", "()Z", "getGradient", "()Ljava/util/List;", "getImageUrl", "getType", "()Lio/intercom/android/sdk/models/HeaderBackdropType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConfigModules.kt */
public final class HeaderBackgroundModel {
    @SerializedName("color")
    private final String color;
    @SerializedName("fade_to_white")
    private final boolean fade;
    @SerializedName("gradient")
    private final List<String> gradient;
    @SerializedName("image_url")
    private final String imageUrl;
    @SerializedName("type")
    private final HeaderBackdropType type;

    public HeaderBackgroundModel() {
        this((String) null, (List) null, (String) null, false, (HeaderBackdropType) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ HeaderBackgroundModel copy$default(HeaderBackgroundModel headerBackgroundModel, String str, List<String> list, String str2, boolean z, HeaderBackdropType headerBackdropType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = headerBackgroundModel.color;
        }
        if ((i & 2) != 0) {
            list = headerBackgroundModel.gradient;
        }
        List<String> list2 = list;
        if ((i & 4) != 0) {
            str2 = headerBackgroundModel.imageUrl;
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            z = headerBackgroundModel.fade;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            headerBackdropType = headerBackgroundModel.type;
        }
        return headerBackgroundModel.copy(str, list2, str3, z2, headerBackdropType);
    }

    public final String component1() {
        return this.color;
    }

    public final List<String> component2() {
        return this.gradient;
    }

    public final String component3() {
        return this.imageUrl;
    }

    public final boolean component4() {
        return this.fade;
    }

    public final HeaderBackdropType component5() {
        return this.type;
    }

    public final HeaderBackgroundModel copy(String str, List<String> list, String str2, boolean z, HeaderBackdropType headerBackdropType) {
        Intrinsics.checkNotNullParameter(str, "color");
        Intrinsics.checkNotNullParameter(headerBackdropType, "type");
        return new HeaderBackgroundModel(str, list, str2, z, headerBackdropType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeaderBackgroundModel)) {
            return false;
        }
        HeaderBackgroundModel headerBackgroundModel = (HeaderBackgroundModel) obj;
        return Intrinsics.areEqual((Object) this.color, (Object) headerBackgroundModel.color) && Intrinsics.areEqual((Object) this.gradient, (Object) headerBackgroundModel.gradient) && Intrinsics.areEqual((Object) this.imageUrl, (Object) headerBackgroundModel.imageUrl) && this.fade == headerBackgroundModel.fade && this.type == headerBackgroundModel.type;
    }

    public int hashCode() {
        int hashCode = this.color.hashCode() * 31;
        List<String> list = this.gradient;
        int i = 0;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.imageUrl;
        if (str != null) {
            i = str.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.fade;
        if (z) {
            z = true;
        }
        return ((i2 + (z ? 1 : 0)) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "HeaderBackgroundModel(color=" + this.color + ", gradient=" + this.gradient + ", imageUrl=" + this.imageUrl + ", fade=" + this.fade + ", type=" + this.type + ')';
    }

    public HeaderBackgroundModel(String str, List<String> list, String str2, boolean z, HeaderBackdropType headerBackdropType) {
        Intrinsics.checkNotNullParameter(str, "color");
        Intrinsics.checkNotNullParameter(headerBackdropType, "type");
        this.color = str;
        this.gradient = list;
        this.imageUrl = str2;
        this.fade = z;
        this.type = headerBackdropType;
    }

    public final String getColor() {
        return this.color;
    }

    public final List<String> getGradient() {
        return this.gradient;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final boolean getFade() {
        return this.fade;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HeaderBackgroundModel(java.lang.String r4, java.util.List r5, java.lang.String r6, boolean r7, io.intercom.android.sdk.models.HeaderBackdropType r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0006
            java.lang.String r4 = "#FFFFFF"
        L_0x0006:
            r10 = r9 & 2
            r0 = 0
            if (r10 == 0) goto L_0x000d
            r10 = r0
            goto L_0x000e
        L_0x000d:
            r10 = r5
        L_0x000e:
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r0 = r6
        L_0x0014:
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001b
            r7 = 1
            r1 = 1
            goto L_0x001c
        L_0x001b:
            r1 = r7
        L_0x001c:
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0022
            io.intercom.android.sdk.models.HeaderBackdropType r8 = io.intercom.android.sdk.models.HeaderBackdropType.SOLID
        L_0x0022:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.models.HeaderBackgroundModel.<init>(java.lang.String, java.util.List, java.lang.String, boolean, io.intercom.android.sdk.models.HeaderBackdropType, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final HeaderBackdropType getType() {
        return this.type;
    }
}
