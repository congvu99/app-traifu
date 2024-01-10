package com.uploadcare.android.library.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\n¨\u0006\""}, d2 = {"Lcom/uploadcare/android/library/api/Audio;", "Landroid/os/Parcelable;", "bitrate", "", "codec", "", "channels", "sampleRate", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getBitrate", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getChannels", "()Ljava/lang/String;", "getCodec", "getSampleRate", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/uploadcare/android/library/api/Audio;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareFile.kt */
public final class Audio implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final Integer bitrate;
    private final String channels;
    private final String codec;
    private final Integer sampleRate;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            Integer num = null;
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            if (parcel.readInt() != 0) {
                num = Integer.valueOf(parcel.readInt());
            }
            return new Audio(valueOf, readString, readString2, num);
        }

        public final Object[] newArray(int i) {
            return new Audio[i];
        }
    }

    public Audio() {
        this((Integer) null, (String) null, (String) null, (Integer) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Audio copy$default(Audio audio, Integer num, String str, String str2, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = audio.bitrate;
        }
        if ((i & 2) != 0) {
            str = audio.codec;
        }
        if ((i & 4) != 0) {
            str2 = audio.channels;
        }
        if ((i & 8) != 0) {
            num2 = audio.sampleRate;
        }
        return audio.copy(num, str, str2, num2);
    }

    public final Integer component1() {
        return this.bitrate;
    }

    public final String component2() {
        return this.codec;
    }

    public final String component3() {
        return this.channels;
    }

    public final Integer component4() {
        return this.sampleRate;
    }

    public final Audio copy(Integer num, String str, String str2, @Json(name = "sample_rate") Integer num2) {
        return new Audio(num, str, str2, num2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Audio)) {
            return false;
        }
        Audio audio = (Audio) obj;
        return Intrinsics.areEqual((Object) this.bitrate, (Object) audio.bitrate) && Intrinsics.areEqual((Object) this.codec, (Object) audio.codec) && Intrinsics.areEqual((Object) this.channels, (Object) audio.channels) && Intrinsics.areEqual((Object) this.sampleRate, (Object) audio.sampleRate);
    }

    public int hashCode() {
        Integer num = this.bitrate;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.codec;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.channels;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num2 = this.sampleRate;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "Audio(bitrate=" + this.bitrate + ", codec=" + this.codec + ", channels=" + this.channels + ", sampleRate=" + this.sampleRate + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Integer num = this.bitrate;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.codec);
        parcel.writeString(this.channels);
        Integer num2 = this.sampleRate;
        if (num2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
            return;
        }
        parcel.writeInt(0);
    }

    public Audio(Integer num, String str, String str2, @Json(name = "sample_rate") Integer num2) {
        this.bitrate = num;
        this.codec = str;
        this.channels = str2;
        this.sampleRate = num2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Audio(Integer num, String str, String str2, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num2);
    }

    public final Integer getBitrate() {
        return this.bitrate;
    }

    public final String getCodec() {
        return this.codec;
    }

    public final String getChannels() {
        return this.channels;
    }

    public final Integer getSampleRate() {
        return this.sampleRate;
    }
}
