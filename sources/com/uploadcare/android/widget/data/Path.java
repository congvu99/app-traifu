package com.uploadcare.android.widget.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/uploadcare/android/widget/data/Path;", "Landroid/os/Parcelable;", "objectType", "", "chunks", "", "Lcom/uploadcare/android/widget/data/Chunk;", "(Ljava/lang/String;Ljava/util/List;)V", "getChunks", "()Ljava/util/List;", "getObjectType", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: Action.kt */
public final class Path implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final List<Chunk> chunks;
    private final String objectType;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((Chunk) Chunk.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new Path(readString, arrayList);
        }

        public final Object[] newArray(int i) {
            return new Path[i];
        }
    }

    public static /* synthetic */ Path copy$default(Path path, String str, List<Chunk> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = path.objectType;
        }
        if ((i & 2) != 0) {
            list = path.chunks;
        }
        return path.copy(str, list);
    }

    public final String component1() {
        return this.objectType;
    }

    public final List<Chunk> component2() {
        return this.chunks;
    }

    public final Path copy(@Json(name = "obj_type") String str, List<Chunk> list) {
        Intrinsics.checkNotNullParameter(str, "objectType");
        return new Path(str, list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Path)) {
            return false;
        }
        Path path = (Path) obj;
        return Intrinsics.areEqual((Object) this.objectType, (Object) path.objectType) && Intrinsics.areEqual((Object) this.chunks, (Object) path.chunks);
    }

    public int hashCode() {
        String str = this.objectType;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Chunk> list = this.chunks;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Path(objectType=" + this.objectType + ", chunks=" + this.chunks + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.objectType);
        List<Chunk> list = this.chunks;
        if (list != null) {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (Chunk writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public Path(@Json(name = "obj_type") String str, List<Chunk> list) {
        Intrinsics.checkNotNullParameter(str, "objectType");
        this.objectType = str;
        this.chunks = list;
    }

    public final String getObjectType() {
        return this.objectType;
    }

    public final List<Chunk> getChunks() {
        return this.chunks;
    }
}
