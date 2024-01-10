package com.uploadcare.android.library.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\u0002\u0010\u0012J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003Jz\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010/J\t\u00100\u001a\u00020\u0005HÖ\u0001J\u0013\u00101\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\u0005HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001J\u0019\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001d¨\u0006;"}, d2 = {"Lcom/uploadcare/android/library/api/ImageInfo;", "Landroid/os/Parcelable;", "format", "", "height", "", "width", "orientation", "sequence", "", "colorMode", "Lcom/uploadcare/android/library/api/ColorMode;", "geoLocation", "Lcom/uploadcare/android/library/api/GeoLocation;", "datetimeOriginal", "dpi", "", "", "(Ljava/lang/String;IILjava/lang/Integer;Ljava/lang/Boolean;Lcom/uploadcare/android/library/api/ColorMode;Lcom/uploadcare/android/library/api/GeoLocation;Ljava/lang/String;Ljava/util/List;)V", "getColorMode", "()Lcom/uploadcare/android/library/api/ColorMode;", "getDatetimeOriginal", "()Ljava/lang/String;", "getDpi", "()Ljava/util/List;", "getFormat", "getGeoLocation", "()Lcom/uploadcare/android/library/api/GeoLocation;", "getHeight", "()I", "getOrientation", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSequence", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;IILjava/lang/Integer;Ljava/lang/Boolean;Lcom/uploadcare/android/library/api/ColorMode;Lcom/uploadcare/android/library/api/GeoLocation;Ljava/lang/String;Ljava/util/List;)Lcom/uploadcare/android/library/api/ImageInfo;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareFile.kt */
public final class ImageInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final ColorMode colorMode;
    private final String datetimeOriginal;
    private final List<Float> dpi;
    private final String format;
    private final GeoLocation geoLocation;
    private final int height;
    private final Integer orientation;
    private final Boolean sequence;
    private final int width;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            ArrayList arrayList = null;
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            ColorMode colorMode = parcel.readInt() != 0 ? (ColorMode) Enum.valueOf(ColorMode.class, parcel.readString()) : null;
            GeoLocation geoLocation = parcel.readInt() != 0 ? (GeoLocation) GeoLocation.CREATOR.createFromParcel(parcel) : null;
            String readString2 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt3 = parcel.readInt();
                arrayList = new ArrayList(readInt3);
                while (readInt3 != 0) {
                    arrayList.add(Float.valueOf(parcel.readFloat()));
                    readInt3--;
                }
            }
            return new ImageInfo(readString, readInt, readInt2, valueOf, bool, colorMode, geoLocation, readString2, arrayList);
        }

        public final Object[] newArray(int i) {
            return new ImageInfo[i];
        }
    }

    public static /* synthetic */ ImageInfo copy$default(ImageInfo imageInfo, String str, int i, int i2, Integer num, Boolean bool, ColorMode colorMode2, GeoLocation geoLocation2, String str2, List list, int i3, Object obj) {
        ImageInfo imageInfo2 = imageInfo;
        int i4 = i3;
        return imageInfo.copy((i4 & 1) != 0 ? imageInfo2.format : str, (i4 & 2) != 0 ? imageInfo2.height : i, (i4 & 4) != 0 ? imageInfo2.width : i2, (i4 & 8) != 0 ? imageInfo2.orientation : num, (i4 & 16) != 0 ? imageInfo2.sequence : bool, (i4 & 32) != 0 ? imageInfo2.colorMode : colorMode2, (i4 & 64) != 0 ? imageInfo2.geoLocation : geoLocation2, (i4 & 128) != 0 ? imageInfo2.datetimeOriginal : str2, (i4 & 256) != 0 ? imageInfo2.dpi : list);
    }

    public final String component1() {
        return this.format;
    }

    public final int component2() {
        return this.height;
    }

    public final int component3() {
        return this.width;
    }

    public final Integer component4() {
        return this.orientation;
    }

    public final Boolean component5() {
        return this.sequence;
    }

    public final ColorMode component6() {
        return this.colorMode;
    }

    public final GeoLocation component7() {
        return this.geoLocation;
    }

    public final String component8() {
        return this.datetimeOriginal;
    }

    public final List<Float> component9() {
        return this.dpi;
    }

    public final ImageInfo copy(String str, int i, int i2, Integer num, Boolean bool, @Json(name = "color_mode") ColorMode colorMode2, @Json(name = "geo_location") GeoLocation geoLocation2, @Json(name = "datetime_original") String str2, List<Float> list) {
        Intrinsics.checkNotNullParameter(str, "format");
        return new ImageInfo(str, i, i2, num, bool, colorMode2, geoLocation2, str2, list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageInfo)) {
            return false;
        }
        ImageInfo imageInfo = (ImageInfo) obj;
        return Intrinsics.areEqual((Object) this.format, (Object) imageInfo.format) && this.height == imageInfo.height && this.width == imageInfo.width && Intrinsics.areEqual((Object) this.orientation, (Object) imageInfo.orientation) && Intrinsics.areEqual((Object) this.sequence, (Object) imageInfo.sequence) && Intrinsics.areEqual((Object) this.colorMode, (Object) imageInfo.colorMode) && Intrinsics.areEqual((Object) this.geoLocation, (Object) imageInfo.geoLocation) && Intrinsics.areEqual((Object) this.datetimeOriginal, (Object) imageInfo.datetimeOriginal) && Intrinsics.areEqual((Object) this.dpi, (Object) imageInfo.dpi);
    }

    public int hashCode() {
        String str = this.format;
        int i = 0;
        int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.height) * 31) + this.width) * 31;
        Integer num = this.orientation;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        Boolean bool = this.sequence;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        ColorMode colorMode2 = this.colorMode;
        int hashCode4 = (hashCode3 + (colorMode2 != null ? colorMode2.hashCode() : 0)) * 31;
        GeoLocation geoLocation2 = this.geoLocation;
        int hashCode5 = (hashCode4 + (geoLocation2 != null ? geoLocation2.hashCode() : 0)) * 31;
        String str2 = this.datetimeOriginal;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<Float> list = this.dpi;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "ImageInfo(format=" + this.format + ", height=" + this.height + ", width=" + this.width + ", orientation=" + this.orientation + ", sequence=" + this.sequence + ", colorMode=" + this.colorMode + ", geoLocation=" + this.geoLocation + ", datetimeOriginal=" + this.datetimeOriginal + ", dpi=" + this.dpi + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.format);
        parcel.writeInt(this.height);
        parcel.writeInt(this.width);
        Integer num = this.orientation;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        Boolean bool = this.sequence;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        ColorMode colorMode2 = this.colorMode;
        if (colorMode2 != null) {
            parcel.writeInt(1);
            parcel.writeString(colorMode2.name());
        } else {
            parcel.writeInt(0);
        }
        GeoLocation geoLocation2 = this.geoLocation;
        if (geoLocation2 != null) {
            parcel.writeInt(1);
            geoLocation2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.datetimeOriginal);
        List<Float> list = this.dpi;
        if (list != null) {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (Float floatValue : list) {
                parcel.writeFloat(floatValue.floatValue());
            }
            return;
        }
        parcel.writeInt(0);
    }

    public ImageInfo(String str, int i, int i2, Integer num, Boolean bool, @Json(name = "color_mode") ColorMode colorMode2, @Json(name = "geo_location") GeoLocation geoLocation2, @Json(name = "datetime_original") String str2, List<Float> list) {
        Intrinsics.checkNotNullParameter(str, "format");
        this.format = str;
        this.height = i;
        this.width = i2;
        this.orientation = num;
        this.sequence = bool;
        this.colorMode = colorMode2;
        this.geoLocation = geoLocation2;
        this.datetimeOriginal = str2;
        this.dpi = list;
    }

    public final String getFormat() {
        return this.format;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ImageInfo(java.lang.String r14, int r15, int r16, java.lang.Integer r17, java.lang.Boolean r18, com.uploadcare.android.library.api.ColorMode r19, com.uploadcare.android.library.api.GeoLocation r20, java.lang.String r21, java.util.List r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x000c
            r1 = r2
            java.lang.Integer r1 = (java.lang.Integer) r1
            r7 = r1
            goto L_0x000e
        L_0x000c:
            r7 = r17
        L_0x000e:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0019
            r1 = 0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r8 = r1
            goto L_0x001b
        L_0x0019:
            r8 = r18
        L_0x001b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0024
            r1 = r2
            com.uploadcare.android.library.api.ColorMode r1 = (com.uploadcare.android.library.api.ColorMode) r1
            r9 = r1
            goto L_0x0026
        L_0x0024:
            r9 = r19
        L_0x0026:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002f
            r1 = r2
            com.uploadcare.android.library.api.GeoLocation r1 = (com.uploadcare.android.library.api.GeoLocation) r1
            r10 = r1
            goto L_0x0031
        L_0x002f:
            r10 = r20
        L_0x0031:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x003a
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r11 = r1
            goto L_0x003c
        L_0x003a:
            r11 = r21
        L_0x003c:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0045
            r0 = r2
            java.util.List r0 = (java.util.List) r0
            r12 = r0
            goto L_0x0047
        L_0x0045:
            r12 = r22
        L_0x0047:
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uploadcare.android.library.api.ImageInfo.<init>(java.lang.String, int, int, java.lang.Integer, java.lang.Boolean, com.uploadcare.android.library.api.ColorMode, com.uploadcare.android.library.api.GeoLocation, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer getOrientation() {
        return this.orientation;
    }

    public final Boolean getSequence() {
        return this.sequence;
    }

    public final ColorMode getColorMode() {
        return this.colorMode;
    }

    public final GeoLocation getGeoLocation() {
        return this.geoLocation;
    }

    public final String getDatetimeOriginal() {
        return this.datetimeOriginal;
    }

    public final List<Float> getDpi() {
        return this.dpi;
    }
}
