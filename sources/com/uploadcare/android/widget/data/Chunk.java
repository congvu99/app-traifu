package com.uploadcare.android.widget.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/uploadcare/android/widget/data/Chunk;", "Landroid/os/Parcelable;", "objectType", "", "pathChunk", "title", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getObjectType", "()Ljava/lang/String;", "getPathChunk", "getTitle", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: Chunk.kt */
public final class Chunk implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String objectType;
    private final String pathChunk;
    private final String title;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new Chunk(parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new Chunk[i];
        }
    }

    public static /* synthetic */ Chunk copy$default(Chunk chunk, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chunk.objectType;
        }
        if ((i & 2) != 0) {
            str2 = chunk.pathChunk;
        }
        if ((i & 4) != 0) {
            str3 = chunk.title;
        }
        return chunk.copy(str, str2, str3);
    }

    public final String component1() {
        return this.objectType;
    }

    public final String component2() {
        return this.pathChunk;
    }

    public final String component3() {
        return this.title;
    }

    public final Chunk copy(@Json(name = "obj_type") String str, @Json(name = "path_chunk") String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "objectType");
        Intrinsics.checkNotNullParameter(str2, "pathChunk");
        Intrinsics.checkNotNullParameter(str3, "title");
        return new Chunk(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Chunk)) {
            return false;
        }
        Chunk chunk = (Chunk) obj;
        return Intrinsics.areEqual((Object) this.objectType, (Object) chunk.objectType) && Intrinsics.areEqual((Object) this.pathChunk, (Object) chunk.pathChunk) && Intrinsics.areEqual((Object) this.title, (Object) chunk.title);
    }

    public int hashCode() {
        String str = this.objectType;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.pathChunk;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.title;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "Chunk(objectType=" + this.objectType + ", pathChunk=" + this.pathChunk + ", title=" + this.title + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.objectType);
        parcel.writeString(this.pathChunk);
        parcel.writeString(this.title);
    }

    public Chunk(@Json(name = "obj_type") String str, @Json(name = "path_chunk") String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "objectType");
        Intrinsics.checkNotNullParameter(str2, "pathChunk");
        Intrinsics.checkNotNullParameter(str3, "title");
        this.objectType = str;
        this.pathChunk = str2;
        this.title = str3;
    }

    public final String getObjectType() {
        return this.objectType;
    }

    public final String getPathChunk() {
        return this.pathChunk;
    }

    public final String getTitle() {
        return this.title;
    }
}
