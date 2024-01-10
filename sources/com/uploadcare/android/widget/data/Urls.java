package com.uploadcare.android.widget.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import io.sentry.cache.EnvelopeCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/uploadcare/android/widget/data/Urls;", "Landroid/os/Parcelable;", "sourceBase", "", "session", "done", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDone", "()Ljava/lang/String;", "getSession", "getSourceBase", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: SocialSource.kt */
public final class Urls implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String done;
    private final String session;
    private final String sourceBase;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new Urls(parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new Urls[i];
        }
    }

    public static /* synthetic */ Urls copy$default(Urls urls, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = urls.sourceBase;
        }
        if ((i & 2) != 0) {
            str2 = urls.session;
        }
        if ((i & 4) != 0) {
            str3 = urls.done;
        }
        return urls.copy(str, str2, str3);
    }

    public final String component1() {
        return this.sourceBase;
    }

    public final String component2() {
        return this.session;
    }

    public final String component3() {
        return this.done;
    }

    public final Urls copy(@Json(name = "source_base") String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "sourceBase");
        Intrinsics.checkNotNullParameter(str2, EnvelopeCache.PREFIX_CURRENT_SESSION_FILE);
        Intrinsics.checkNotNullParameter(str3, "done");
        return new Urls(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Urls)) {
            return false;
        }
        Urls urls = (Urls) obj;
        return Intrinsics.areEqual((Object) this.sourceBase, (Object) urls.sourceBase) && Intrinsics.areEqual((Object) this.session, (Object) urls.session) && Intrinsics.areEqual((Object) this.done, (Object) urls.done);
    }

    public int hashCode() {
        String str = this.sourceBase;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.session;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.done;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "Urls(sourceBase=" + this.sourceBase + ", session=" + this.session + ", done=" + this.done + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.sourceBase);
        parcel.writeString(this.session);
        parcel.writeString(this.done);
    }

    public Urls(@Json(name = "source_base") String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "sourceBase");
        Intrinsics.checkNotNullParameter(str2, EnvelopeCache.PREFIX_CURRENT_SESSION_FILE);
        Intrinsics.checkNotNullParameter(str3, "done");
        this.sourceBase = str;
        this.session = str2;
        this.done = str3;
    }

    public final String getSourceBase() {
        return this.sourceBase;
    }

    public final String getSession() {
        return this.session;
    }

    public final String getDone() {
        return this.done;
    }
}
