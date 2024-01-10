package com.uploadcare.android.widget.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\""}, d2 = {"Lcom/uploadcare/android/widget/data/Action;", "Landroid/os/Parcelable;", "objectType", "", "action", "url", "path", "Lcom/uploadcare/android/widget/data/Path;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/uploadcare/android/widget/data/Path;)V", "getAction", "()Ljava/lang/String;", "getObjectType", "getPath", "()Lcom/uploadcare/android/widget/data/Path;", "getUrl", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: Action.kt */
public final class Action implements Parcelable {
    public static final String ACTION_OPEN_PATH = "open_path";
    public static final String ACTION_SELECT_FILE = "select_file";
    public static final Parcelable.Creator CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String action;
    private final String objectType;
    private final Path path;
    private final String url;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new Action(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Path) Path.CREATOR.createFromParcel(parcel) : null);
        }

        public final Object[] newArray(int i) {
            return new Action[i];
        }
    }

    public static /* synthetic */ Action copy$default(Action action2, String str, String str2, String str3, Path path2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = action2.objectType;
        }
        if ((i & 2) != 0) {
            str2 = action2.action;
        }
        if ((i & 4) != 0) {
            str3 = action2.url;
        }
        if ((i & 8) != 0) {
            path2 = action2.path;
        }
        return action2.copy(str, str2, str3, path2);
    }

    public final String component1() {
        return this.objectType;
    }

    public final String component2() {
        return this.action;
    }

    public final String component3() {
        return this.url;
    }

    public final Path component4() {
        return this.path;
    }

    public final Action copy(@Json(name = "obj_type") String str, String str2, String str3, Path path2) {
        Intrinsics.checkNotNullParameter(str, "objectType");
        return new Action(str, str2, str3, path2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Action)) {
            return false;
        }
        Action action2 = (Action) obj;
        return Intrinsics.areEqual((Object) this.objectType, (Object) action2.objectType) && Intrinsics.areEqual((Object) this.action, (Object) action2.action) && Intrinsics.areEqual((Object) this.url, (Object) action2.url) && Intrinsics.areEqual((Object) this.path, (Object) action2.path);
    }

    public int hashCode() {
        String str = this.objectType;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.action;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.url;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Path path2 = this.path;
        if (path2 != null) {
            i = path2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "Action(objectType=" + this.objectType + ", action=" + this.action + ", url=" + this.url + ", path=" + this.path + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.objectType);
        parcel.writeString(this.action);
        parcel.writeString(this.url);
        Path path2 = this.path;
        if (path2 != null) {
            parcel.writeInt(1);
            path2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public Action(@Json(name = "obj_type") String str, String str2, String str3, Path path2) {
        Intrinsics.checkNotNullParameter(str, "objectType");
        this.objectType = str;
        this.action = str2;
        this.url = str3;
        this.path = path2;
    }

    public final String getObjectType() {
        return this.objectType;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getUrl() {
        return this.url;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/uploadcare/android/widget/data/Action$Companion;", "", "()V", "ACTION_OPEN_PATH", "", "ACTION_SELECT_FILE", "widget_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Action.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final Path getPath() {
        return this.path;
    }
}
