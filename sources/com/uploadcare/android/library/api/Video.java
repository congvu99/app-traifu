package com.uploadcare.android.library.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\tHÆ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006%"}, d2 = {"Lcom/uploadcare/android/library/api/Video;", "Landroid/os/Parcelable;", "bitrate", "", "codec", "", "height", "width", "frameRate", "", "(ILjava/lang/String;IIF)V", "getBitrate", "()I", "getCodec", "()Ljava/lang/String;", "getFrameRate", "()F", "getHeight", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareFile.kt */
public final class Video implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final int bitrate;
    private final String codec;
    private final float frameRate;
    private final int height;
    private final int width;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new Video(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readFloat());
        }

        public final Object[] newArray(int i) {
            return new Video[i];
        }
    }

    public static /* synthetic */ Video copy$default(Video video, int i, String str, int i2, int i3, float f, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = video.bitrate;
        }
        if ((i4 & 2) != 0) {
            str = video.codec;
        }
        String str2 = str;
        if ((i4 & 4) != 0) {
            i2 = video.height;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            i3 = video.width;
        }
        int i6 = i3;
        if ((i4 & 16) != 0) {
            f = video.frameRate;
        }
        return video.copy(i, str2, i5, i6, f);
    }

    public final int component1() {
        return this.bitrate;
    }

    public final String component2() {
        return this.codec;
    }

    public final int component3() {
        return this.height;
    }

    public final int component4() {
        return this.width;
    }

    public final float component5() {
        return this.frameRate;
    }

    public final Video copy(int i, String str, int i2, int i3, @Json(name = "frame_rate") float f) {
        Intrinsics.checkNotNullParameter(str, "codec");
        return new Video(i, str, i2, i3, f);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Video)) {
            return false;
        }
        Video video = (Video) obj;
        return this.bitrate == video.bitrate && Intrinsics.areEqual((Object) this.codec, (Object) video.codec) && this.height == video.height && this.width == video.width && Float.compare(this.frameRate, video.frameRate) == 0;
    }

    public int hashCode() {
        int i = this.bitrate * 31;
        String str = this.codec;
        return ((((((i + (str != null ? str.hashCode() : 0)) * 31) + this.height) * 31) + this.width) * 31) + Float.floatToIntBits(this.frameRate);
    }

    public String toString() {
        return "Video(bitrate=" + this.bitrate + ", codec=" + this.codec + ", height=" + this.height + ", width=" + this.width + ", frameRate=" + this.frameRate + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.bitrate);
        parcel.writeString(this.codec);
        parcel.writeInt(this.height);
        parcel.writeInt(this.width);
        parcel.writeFloat(this.frameRate);
    }

    public Video(int i, String str, int i2, int i3, @Json(name = "frame_rate") float f) {
        Intrinsics.checkNotNullParameter(str, "codec");
        this.bitrate = i;
        this.codec = str;
        this.height = i2;
        this.width = i3;
        this.frameRate = f;
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    public final String getCodec() {
        return this.codec;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public final float getFrameRate() {
        return this.frameRate;
    }
}
