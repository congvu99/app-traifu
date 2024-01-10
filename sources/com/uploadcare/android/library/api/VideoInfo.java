package com.uploadcare.android.library.api;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/uploadcare/android/library/api/VideoInfo;", "Landroid/os/Parcelable;", "format", "", "duration", "", "bitrate", "audio", "Lcom/uploadcare/android/library/api/Audio;", "video", "Lcom/uploadcare/android/library/api/Video;", "(Ljava/lang/String;IILcom/uploadcare/android/library/api/Audio;Lcom/uploadcare/android/library/api/Video;)V", "getAudio", "()Lcom/uploadcare/android/library/api/Audio;", "getBitrate", "()I", "getDuration", "getFormat", "()Ljava/lang/String;", "getVideo", "()Lcom/uploadcare/android/library/api/Video;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareFile.kt */
public final class VideoInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final Audio audio;
    private final int bitrate;
    private final int duration;
    private final String format;
    private final Video video;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new VideoInfo(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (Audio) Audio.CREATOR.createFromParcel(parcel) : null, (Video) Video.CREATOR.createFromParcel(parcel));
        }

        public final Object[] newArray(int i) {
            return new VideoInfo[i];
        }
    }

    public static /* synthetic */ VideoInfo copy$default(VideoInfo videoInfo, String str, int i, int i2, Audio audio2, Video video2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = videoInfo.format;
        }
        if ((i3 & 2) != 0) {
            i = videoInfo.duration;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = videoInfo.bitrate;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            audio2 = videoInfo.audio;
        }
        Audio audio3 = audio2;
        if ((i3 & 16) != 0) {
            video2 = videoInfo.video;
        }
        return videoInfo.copy(str, i4, i5, audio3, video2);
    }

    public final String component1() {
        return this.format;
    }

    public final int component2() {
        return this.duration;
    }

    public final int component3() {
        return this.bitrate;
    }

    public final Audio component4() {
        return this.audio;
    }

    public final Video component5() {
        return this.video;
    }

    public final VideoInfo copy(String str, int i, int i2, Audio audio2, Video video2) {
        Intrinsics.checkNotNullParameter(str, "format");
        Intrinsics.checkNotNullParameter(video2, "video");
        return new VideoInfo(str, i, i2, audio2, video2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoInfo)) {
            return false;
        }
        VideoInfo videoInfo = (VideoInfo) obj;
        return Intrinsics.areEqual((Object) this.format, (Object) videoInfo.format) && this.duration == videoInfo.duration && this.bitrate == videoInfo.bitrate && Intrinsics.areEqual((Object) this.audio, (Object) videoInfo.audio) && Intrinsics.areEqual((Object) this.video, (Object) videoInfo.video);
    }

    public int hashCode() {
        String str = this.format;
        int i = 0;
        int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.duration) * 31) + this.bitrate) * 31;
        Audio audio2 = this.audio;
        int hashCode2 = (hashCode + (audio2 != null ? audio2.hashCode() : 0)) * 31;
        Video video2 = this.video;
        if (video2 != null) {
            i = video2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "VideoInfo(format=" + this.format + ", duration=" + this.duration + ", bitrate=" + this.bitrate + ", audio=" + this.audio + ", video=" + this.video + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.format);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.bitrate);
        Audio audio2 = this.audio;
        if (audio2 != null) {
            parcel.writeInt(1);
            audio2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        this.video.writeToParcel(parcel, 0);
    }

    public VideoInfo(String str, int i, int i2, Audio audio2, Video video2) {
        Intrinsics.checkNotNullParameter(str, "format");
        Intrinsics.checkNotNullParameter(video2, "video");
        this.format = str;
        this.duration = i;
        this.bitrate = i2;
        this.audio = audio2;
        this.video = video2;
    }

    public final String getFormat() {
        return this.format;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoInfo(String str, int i, int i2, Audio audio2, Video video2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, (i3 & 8) != 0 ? null : audio2, video2);
    }

    public final Audio getAudio() {
        return this.audio;
    }

    public final Video getVideo() {
        return this.video;
    }
}
