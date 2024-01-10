package com.uploadcare.android.widget.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B9\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006%"}, d2 = {"Lcom/uploadcare/android/widget/data/Thing;", "Landroid/os/Parcelable;", "objectType", "", "mimetype", "title", "action", "Lcom/uploadcare/android/widget/data/Action;", "thumbnail", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/uploadcare/android/widget/data/Action;Ljava/lang/String;)V", "getAction", "()Lcom/uploadcare/android/widget/data/Action;", "getMimetype", "()Ljava/lang/String;", "getObjectType", "getThumbnail", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: ChunkResponse.kt */
public final class Thing implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_ALBUM = "album";
    public static final String TYPE_FILE = "file";
    public static final String TYPE_FOLDER = "folder";
    public static final String TYPE_FRIEND = "friend";
    public static final String TYPE_PHOTO = "photo";
    private final Action action;
    private final String mimetype;
    private final String objectType;
    private final String thumbnail;
    private final String title;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new Thing(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Action) Action.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new Thing[i];
        }
    }

    public static /* synthetic */ Thing copy$default(Thing thing, String str, String str2, String str3, Action action2, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = thing.objectType;
        }
        if ((i & 2) != 0) {
            str2 = thing.mimetype;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = thing.title;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            action2 = thing.action;
        }
        Action action3 = action2;
        if ((i & 16) != 0) {
            str4 = thing.thumbnail;
        }
        return thing.copy(str, str5, str6, action3, str4);
    }

    public final String component1() {
        return this.objectType;
    }

    public final String component2() {
        return this.mimetype;
    }

    public final String component3() {
        return this.title;
    }

    public final Action component4() {
        return this.action;
    }

    public final String component5() {
        return this.thumbnail;
    }

    public final Thing copy(@Json(name = "obj_type") String str, String str2, String str3, Action action2, String str4) {
        Intrinsics.checkNotNullParameter(str, "objectType");
        return new Thing(str, str2, str3, action2, str4);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Thing)) {
            return false;
        }
        Thing thing = (Thing) obj;
        return Intrinsics.areEqual((Object) this.objectType, (Object) thing.objectType) && Intrinsics.areEqual((Object) this.mimetype, (Object) thing.mimetype) && Intrinsics.areEqual((Object) this.title, (Object) thing.title) && Intrinsics.areEqual((Object) this.action, (Object) thing.action) && Intrinsics.areEqual((Object) this.thumbnail, (Object) thing.thumbnail);
    }

    public int hashCode() {
        String str = this.objectType;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mimetype;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.title;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Action action2 = this.action;
        int hashCode4 = (hashCode3 + (action2 != null ? action2.hashCode() : 0)) * 31;
        String str4 = this.thumbnail;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "Thing(objectType=" + this.objectType + ", mimetype=" + this.mimetype + ", title=" + this.title + ", action=" + this.action + ", thumbnail=" + this.thumbnail + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.objectType);
        parcel.writeString(this.mimetype);
        parcel.writeString(this.title);
        Action action2 = this.action;
        if (action2 != null) {
            parcel.writeInt(1);
            action2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.thumbnail);
    }

    public Thing(@Json(name = "obj_type") String str, String str2, String str3, Action action2, String str4) {
        Intrinsics.checkNotNullParameter(str, "objectType");
        this.objectType = str;
        this.mimetype = str2;
        this.title = str3;
        this.action = action2;
        this.thumbnail = str4;
    }

    public final String getObjectType() {
        return this.objectType;
    }

    public final String getMimetype() {
        return this.mimetype;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Action getAction() {
        return this.action;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Thing(String str, String str2, String str3, Action action2, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, action2, (i & 16) != 0 ? null : str4);
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/uploadcare/android/widget/data/Thing$Companion;", "", "()V", "TYPE_ALBUM", "", "TYPE_FILE", "TYPE_FOLDER", "TYPE_FRIEND", "TYPE_PHOTO", "widget_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ChunkResponse.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
