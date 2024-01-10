package com.uploadcare.android.widget.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J.\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0013HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0004\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/uploadcare/android/widget/data/SelectedFile;", "Landroid/os/Parcelable;", "objectType", "", "isImage", "", "url", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getObjectType", "()Ljava/lang/String;", "getUrl", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/uploadcare/android/widget/data/SelectedFile;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: SelectedFile.kt */
public final class SelectedFile implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final Boolean isImage;
    private final String objectType;
    private final String url;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            return new SelectedFile(readString, bool, parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new SelectedFile[i];
        }
    }

    public static /* synthetic */ SelectedFile copy$default(SelectedFile selectedFile, String str, Boolean bool, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = selectedFile.objectType;
        }
        if ((i & 2) != 0) {
            bool = selectedFile.isImage;
        }
        if ((i & 4) != 0) {
            str2 = selectedFile.url;
        }
        return selectedFile.copy(str, bool, str2);
    }

    public final String component1() {
        return this.objectType;
    }

    public final Boolean component2() {
        return this.isImage;
    }

    public final String component3() {
        return this.url;
    }

    public final SelectedFile copy(@Json(name = "obj_type") String str, @Json(name = "is_image") Boolean bool, String str2) {
        Intrinsics.checkNotNullParameter(str, "objectType");
        Intrinsics.checkNotNullParameter(str2, "url");
        return new SelectedFile(str, bool, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectedFile)) {
            return false;
        }
        SelectedFile selectedFile = (SelectedFile) obj;
        return Intrinsics.areEqual((Object) this.objectType, (Object) selectedFile.objectType) && Intrinsics.areEqual((Object) this.isImage, (Object) selectedFile.isImage) && Intrinsics.areEqual((Object) this.url, (Object) selectedFile.url);
    }

    public int hashCode() {
        String str = this.objectType;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Boolean bool = this.isImage;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        String str2 = this.url;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "SelectedFile(objectType=" + this.objectType + ", isImage=" + this.isImage + ", url=" + this.url + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.objectType);
        Boolean bool = this.isImage;
        if (bool != null) {
            parcel.writeInt(1);
            z = bool.booleanValue();
        } else {
            z = false;
        }
        parcel.writeInt(z ? 1 : 0);
        parcel.writeString(this.url);
    }

    public SelectedFile(@Json(name = "obj_type") String str, @Json(name = "is_image") Boolean bool, String str2) {
        Intrinsics.checkNotNullParameter(str, "objectType");
        Intrinsics.checkNotNullParameter(str2, "url");
        this.objectType = str;
        this.isImage = bool;
        this.url = str2;
    }

    public final String getObjectType() {
        return this.objectType;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectedFile(String str, Boolean bool, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : bool, str2);
    }

    public final Boolean isImage() {
        return this.isImage;
    }

    public final String getUrl() {
        return this.url;
    }
}
