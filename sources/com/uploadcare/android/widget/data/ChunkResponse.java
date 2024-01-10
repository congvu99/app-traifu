package com.uploadcare.android.widget.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003Ja\u0010!\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020#HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020#HÖ\u0001R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006/"}, d2 = {"Lcom/uploadcare/android/widget/data/ChunkResponse;", "Landroid/os/Parcelable;", "objectType", "", "loginLink", "nextPage", "Lcom/uploadcare/android/widget/data/Path;", "searchPath", "Lcom/uploadcare/android/widget/data/Chunk;", "things", "", "Lcom/uploadcare/android/widget/data/Thing;", "root", "error", "(Ljava/lang/String;Ljava/lang/String;Lcom/uploadcare/android/widget/data/Path;Lcom/uploadcare/android/widget/data/Chunk;Ljava/util/List;Lcom/uploadcare/android/widget/data/Chunk;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "getLoginLink", "getNextPage", "()Lcom/uploadcare/android/widget/data/Path;", "getObjectType", "getRoot", "()Lcom/uploadcare/android/widget/data/Chunk;", "getSearchPath", "getThings", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: ChunkResponse.kt */
public final class ChunkResponse implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String error;
    private final String loginLink;
    private final Path nextPage;
    private final String objectType;
    private final Chunk root;
    private final Chunk searchPath;
    private final List<Thing> things;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Path path = parcel.readInt() != 0 ? (Path) Path.CREATOR.createFromParcel(parcel) : null;
            Chunk chunk = parcel.readInt() != 0 ? (Chunk) Chunk.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((Thing) Thing.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new ChunkResponse(readString, readString2, path, chunk, arrayList, parcel.readInt() != 0 ? (Chunk) Chunk.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new ChunkResponse[i];
        }
    }

    public static /* synthetic */ ChunkResponse copy$default(ChunkResponse chunkResponse, String str, String str2, Path path, Chunk chunk, List<Thing> list, Chunk chunk2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chunkResponse.objectType;
        }
        if ((i & 2) != 0) {
            str2 = chunkResponse.loginLink;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            path = chunkResponse.nextPage;
        }
        Path path2 = path;
        if ((i & 8) != 0) {
            chunk = chunkResponse.searchPath;
        }
        Chunk chunk3 = chunk;
        if ((i & 16) != 0) {
            list = chunkResponse.things;
        }
        List<Thing> list2 = list;
        if ((i & 32) != 0) {
            chunk2 = chunkResponse.root;
        }
        Chunk chunk4 = chunk2;
        if ((i & 64) != 0) {
            str3 = chunkResponse.error;
        }
        return chunkResponse.copy(str, str4, path2, chunk3, list2, chunk4, str3);
    }

    public final String component1() {
        return this.objectType;
    }

    public final String component2() {
        return this.loginLink;
    }

    public final Path component3() {
        return this.nextPage;
    }

    public final Chunk component4() {
        return this.searchPath;
    }

    public final List<Thing> component5() {
        return this.things;
    }

    public final Chunk component6() {
        return this.root;
    }

    public final String component7() {
        return this.error;
    }

    public final ChunkResponse copy(@Json(name = "obj_type") String str, @Json(name = "login_link") String str2, @Json(name = "next_page") Path path, @Json(name = "search_path") Chunk chunk, List<Thing> list, Chunk chunk2, String str3) {
        Intrinsics.checkNotNullParameter(str, "objectType");
        return new ChunkResponse(str, str2, path, chunk, list, chunk2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChunkResponse)) {
            return false;
        }
        ChunkResponse chunkResponse = (ChunkResponse) obj;
        return Intrinsics.areEqual((Object) this.objectType, (Object) chunkResponse.objectType) && Intrinsics.areEqual((Object) this.loginLink, (Object) chunkResponse.loginLink) && Intrinsics.areEqual((Object) this.nextPage, (Object) chunkResponse.nextPage) && Intrinsics.areEqual((Object) this.searchPath, (Object) chunkResponse.searchPath) && Intrinsics.areEqual((Object) this.things, (Object) chunkResponse.things) && Intrinsics.areEqual((Object) this.root, (Object) chunkResponse.root) && Intrinsics.areEqual((Object) this.error, (Object) chunkResponse.error);
    }

    public int hashCode() {
        String str = this.objectType;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.loginLink;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Path path = this.nextPage;
        int hashCode3 = (hashCode2 + (path != null ? path.hashCode() : 0)) * 31;
        Chunk chunk = this.searchPath;
        int hashCode4 = (hashCode3 + (chunk != null ? chunk.hashCode() : 0)) * 31;
        List<Thing> list = this.things;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        Chunk chunk2 = this.root;
        int hashCode6 = (hashCode5 + (chunk2 != null ? chunk2.hashCode() : 0)) * 31;
        String str3 = this.error;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "ChunkResponse(objectType=" + this.objectType + ", loginLink=" + this.loginLink + ", nextPage=" + this.nextPage + ", searchPath=" + this.searchPath + ", things=" + this.things + ", root=" + this.root + ", error=" + this.error + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.objectType);
        parcel.writeString(this.loginLink);
        Path path = this.nextPage;
        if (path != null) {
            parcel.writeInt(1);
            path.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Chunk chunk = this.searchPath;
        if (chunk != null) {
            parcel.writeInt(1);
            chunk.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        List<Thing> list = this.things;
        if (list != null) {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (Thing writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        Chunk chunk2 = this.root;
        if (chunk2 != null) {
            parcel.writeInt(1);
            chunk2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.error);
    }

    public ChunkResponse(@Json(name = "obj_type") String str, @Json(name = "login_link") String str2, @Json(name = "next_page") Path path, @Json(name = "search_path") Chunk chunk, List<Thing> list, Chunk chunk2, String str3) {
        Intrinsics.checkNotNullParameter(str, "objectType");
        this.objectType = str;
        this.loginLink = str2;
        this.nextPage = path;
        this.searchPath = chunk;
        this.things = list;
        this.root = chunk2;
        this.error = str3;
    }

    public final String getObjectType() {
        return this.objectType;
    }

    public final String getLoginLink() {
        return this.loginLink;
    }

    public final Path getNextPage() {
        return this.nextPage;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChunkResponse(String str, String str2, Path path, Chunk chunk, List list, Chunk chunk2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, path, (i & 8) != 0 ? null : chunk, list, (i & 32) != 0 ? null : chunk2, (i & 64) != 0 ? null : str3);
    }

    public final Chunk getSearchPath() {
        return this.searchPath;
    }

    public final List<Thing> getThings() {
        return this.things;
    }

    public final Chunk getRoot() {
        return this.root;
    }

    public final String getError() {
        return this.error;
    }
}
