package com.uploadcare.android.library.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import com.uploadcare.android.library.urls.CdnPathBuilder;
import java.net.URI;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BÓ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0016\b\u0003\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018¢\u0006\u0002\u0010\u001bJ\u0006\u00104\u001a\u000205J\t\u00106\u001a\u00020\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0017\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0003J\u0017\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0007HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010A\u001a\u00020\nHÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jà\u0001\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\t\u001a\u00020\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0016\b\u0003\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018HÆ\u0001¢\u0006\u0002\u0010GJ\u0010\u0010H\u001a\u0004\u0018\u00010\u00002\u0006\u0010I\u001a\u00020JJ\t\u0010K\u001a\u00020\u0007HÖ\u0001J\u0013\u0010L\u001a\u00020\n2\b\u0010M\u001a\u0004\u0018\u00010NHÖ\u0003J\u0006\u0010O\u001a\u00020\nJ\t\u0010P\u001a\u00020\u0007HÖ\u0001J\u0006\u0010Q\u001a\u00020\nJ\u0006\u0010R\u001a\u00020\nJ\u0010\u0010S\u001a\u0004\u0018\u00010\u00002\u0006\u0010I\u001a\u00020JJ\b\u0010T\u001a\u00020\u0003H\u0016J\u0010\u0010U\u001a\u0004\u0018\u00010\u00002\u0006\u0010I\u001a\u00020JJ\u0019\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010#\u001a\u0004\b\u000b\u0010\"R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010$R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u001f\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010&R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u001f\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b1\u0010+R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b2\u00103¨\u0006["}, d2 = {"Lcom/uploadcare/android/library/api/UploadcareFile;", "Landroid/os/Parcelable;", "uuid", "", "url", "Ljava/net/URI;", "size", "", "source", "isReady", "", "isImage", "mimeType", "originalFilename", "originalFileUrl", "datetimeUploaded", "Ljava/util/Date;", "datetimeStored", "datetimeRemoved", "imageInfo", "Lcom/uploadcare/android/library/api/ImageInfo;", "videoInfo", "Lcom/uploadcare/android/library/api/VideoInfo;", "rekognitionInfo", "", "", "variations", "(Ljava/lang/String;Ljava/net/URI;ILjava/lang/String;ZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/net/URI;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/uploadcare/android/library/api/ImageInfo;Lcom/uploadcare/android/library/api/VideoInfo;Ljava/util/Map;Ljava/util/Map;)V", "getDatetimeRemoved", "()Ljava/util/Date;", "getDatetimeStored", "getDatetimeUploaded", "getImageInfo", "()Lcom/uploadcare/android/library/api/ImageInfo;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "()Z", "getMimeType", "()Ljava/lang/String;", "getOriginalFileUrl", "()Ljava/net/URI;", "getOriginalFilename", "getRekognitionInfo", "()Ljava/util/Map;", "getSize", "()I", "getSource", "getUrl", "getUuid", "getVariations", "getVideoInfo", "()Lcom/uploadcare/android/library/api/VideoInfo;", "cdnPath", "Lcom/uploadcare/android/library/urls/CdnPathBuilder;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/net/URI;ILjava/lang/String;ZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/net/URI;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/uploadcare/android/library/api/ImageInfo;Lcom/uploadcare/android/library/api/VideoInfo;Ljava/util/Map;Ljava/util/Map;)Lcom/uploadcare/android/library/api/UploadcareFile;", "delete", "client", "Lcom/uploadcare/android/library/api/UploadcareClient;", "describeContents", "equals", "other", "", "hasOriginalFileUrl", "hashCode", "isRemoved", "isStored", "save", "toString", "update", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareFile.kt */
public final class UploadcareFile implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final Date datetimeRemoved;
    private final Date datetimeStored;
    private final Date datetimeUploaded;
    private final ImageInfo imageInfo;
    private final Boolean isImage;
    private final boolean isReady;
    private final String mimeType;
    private final URI originalFileUrl;
    private final String originalFilename;
    private final Map<String, Float> rekognitionInfo;
    private final int size;
    private final String source;
    private final URI url;
    private final String uuid;
    private final Map<String, String> variations;
    private final VideoInfo videoInfo;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Boolean bool;
            LinkedHashMap linkedHashMap;
            LinkedHashMap linkedHashMap2;
            LinkedHashMap linkedHashMap3;
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "in");
            String readString = parcel.readString();
            URI uri = (URI) parcel.readSerializable();
            int readInt = parcel.readInt();
            String readString2 = parcel.readString();
            boolean z = true;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool = Boolean.valueOf(z);
            } else {
                bool = null;
            }
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            URI uri2 = (URI) parcel.readSerializable();
            Date date = (Date) parcel.readSerializable();
            Date date2 = (Date) parcel.readSerializable();
            Date date3 = (Date) parcel.readSerializable();
            ImageInfo imageInfo = parcel.readInt() != 0 ? (ImageInfo) ImageInfo.CREATOR.createFromParcel(parcel2) : null;
            VideoInfo videoInfo = parcel.readInt() != 0 ? (VideoInfo) VideoInfo.CREATOR.createFromParcel(parcel2) : null;
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                LinkedHashMap linkedHashMap4 = new LinkedHashMap(readInt2);
                while (readInt2 != 0) {
                    linkedHashMap4.put(parcel.readString(), Float.valueOf(parcel.readFloat()));
                    readInt2--;
                    Parcel parcel3 = parcel;
                }
                linkedHashMap = linkedHashMap4;
            } else {
                linkedHashMap = null;
            }
            if (parcel.readInt() != 0) {
                int readInt3 = parcel.readInt();
                LinkedHashMap linkedHashMap5 = new LinkedHashMap(readInt3);
                while (readInt3 != 0) {
                    linkedHashMap5.put(parcel.readString(), parcel.readString());
                    readInt3--;
                    linkedHashMap = linkedHashMap;
                }
                linkedHashMap2 = linkedHashMap;
                linkedHashMap3 = linkedHashMap5;
            } else {
                linkedHashMap2 = linkedHashMap;
                linkedHashMap3 = null;
            }
            return new UploadcareFile(readString, uri, readInt, readString2, z2, bool, readString3, readString4, uri2, date, date2, date3, imageInfo, videoInfo, linkedHashMap2, linkedHashMap3);
        }

        public final Object[] newArray(int i) {
            return new UploadcareFile[i];
        }
    }

    public static /* synthetic */ UploadcareFile copy$default(UploadcareFile uploadcareFile, String str, URI uri, int i, String str2, boolean z, Boolean bool, String str3, String str4, URI uri2, Date date, Date date2, Date date3, ImageInfo imageInfo2, VideoInfo videoInfo2, Map map, Map map2, int i2, Object obj) {
        UploadcareFile uploadcareFile2 = uploadcareFile;
        int i3 = i2;
        return uploadcareFile.copy((i3 & 1) != 0 ? uploadcareFile2.uuid : str, (i3 & 2) != 0 ? uploadcareFile2.url : uri, (i3 & 4) != 0 ? uploadcareFile2.size : i, (i3 & 8) != 0 ? uploadcareFile2.source : str2, (i3 & 16) != 0 ? uploadcareFile2.isReady : z, (i3 & 32) != 0 ? uploadcareFile2.isImage : bool, (i3 & 64) != 0 ? uploadcareFile2.mimeType : str3, (i3 & 128) != 0 ? uploadcareFile2.originalFilename : str4, (i3 & 256) != 0 ? uploadcareFile2.originalFileUrl : uri2, (i3 & 512) != 0 ? uploadcareFile2.datetimeUploaded : date, (i3 & 1024) != 0 ? uploadcareFile2.datetimeStored : date2, (i3 & 2048) != 0 ? uploadcareFile2.datetimeRemoved : date3, (i3 & 4096) != 0 ? uploadcareFile2.imageInfo : imageInfo2, (i3 & 8192) != 0 ? uploadcareFile2.videoInfo : videoInfo2, (i3 & 16384) != 0 ? uploadcareFile2.rekognitionInfo : map, (i3 & 32768) != 0 ? uploadcareFile2.variations : map2);
    }

    public final String component1() {
        return this.uuid;
    }

    public final Date component10() {
        return this.datetimeUploaded;
    }

    public final Date component11() {
        return this.datetimeStored;
    }

    public final Date component12() {
        return this.datetimeRemoved;
    }

    public final ImageInfo component13() {
        return this.imageInfo;
    }

    public final VideoInfo component14() {
        return this.videoInfo;
    }

    public final Map<String, Float> component15() {
        return this.rekognitionInfo;
    }

    public final Map<String, String> component16() {
        return this.variations;
    }

    public final URI component2() {
        return this.url;
    }

    public final int component3() {
        return this.size;
    }

    public final String component4() {
        return this.source;
    }

    public final boolean component5() {
        return this.isReady;
    }

    public final Boolean component6() {
        return this.isImage;
    }

    public final String component7() {
        return this.mimeType;
    }

    public final String component8() {
        return this.originalFilename;
    }

    public final URI component9() {
        return this.originalFileUrl;
    }

    public final UploadcareFile copy(String str, URI uri, int i, String str2, @Json(name = "is_ready") boolean z, @Json(name = "is_image") Boolean bool, @Json(name = "mime_type") String str3, @Json(name = "original_filename") String str4, @Json(name = "original_file_url") URI uri2, @Json(name = "datetime_uploaded") Date date, @Json(name = "datetime_stored") Date date2, @Json(name = "datetime_removed") Date date3, @Json(name = "image_info") ImageInfo imageInfo2, @Json(name = "video_info") VideoInfo videoInfo2, @Json(name = "rekognition_info") Map<String, Float> map, Map<String, String> map2) {
        String str5 = str;
        String str6 = str5;
        Intrinsics.checkNotNullParameter(str5, "uuid");
        return new UploadcareFile(str5, uri, i, str2, z, bool, str3, str4, uri2, date, date2, date3, imageInfo2, videoInfo2, map, map2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadcareFile)) {
            return false;
        }
        UploadcareFile uploadcareFile = (UploadcareFile) obj;
        return Intrinsics.areEqual((Object) this.uuid, (Object) uploadcareFile.uuid) && Intrinsics.areEqual((Object) this.url, (Object) uploadcareFile.url) && this.size == uploadcareFile.size && Intrinsics.areEqual((Object) this.source, (Object) uploadcareFile.source) && this.isReady == uploadcareFile.isReady && Intrinsics.areEqual((Object) this.isImage, (Object) uploadcareFile.isImage) && Intrinsics.areEqual((Object) this.mimeType, (Object) uploadcareFile.mimeType) && Intrinsics.areEqual((Object) this.originalFilename, (Object) uploadcareFile.originalFilename) && Intrinsics.areEqual((Object) this.originalFileUrl, (Object) uploadcareFile.originalFileUrl) && Intrinsics.areEqual((Object) this.datetimeUploaded, (Object) uploadcareFile.datetimeUploaded) && Intrinsics.areEqual((Object) this.datetimeStored, (Object) uploadcareFile.datetimeStored) && Intrinsics.areEqual((Object) this.datetimeRemoved, (Object) uploadcareFile.datetimeRemoved) && Intrinsics.areEqual((Object) this.imageInfo, (Object) uploadcareFile.imageInfo) && Intrinsics.areEqual((Object) this.videoInfo, (Object) uploadcareFile.videoInfo) && Intrinsics.areEqual((Object) this.rekognitionInfo, (Object) uploadcareFile.rekognitionInfo) && Intrinsics.areEqual((Object) this.variations, (Object) uploadcareFile.variations);
    }

    public int hashCode() {
        String str = this.uuid;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        URI uri = this.url;
        int hashCode2 = (((hashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.size) * 31;
        String str2 = this.source;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.isReady;
        if (z) {
            z = true;
        }
        int i2 = (hashCode3 + (z ? 1 : 0)) * 31;
        Boolean bool = this.isImage;
        int hashCode4 = (i2 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str3 = this.mimeType;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.originalFilename;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        URI uri2 = this.originalFileUrl;
        int hashCode7 = (hashCode6 + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        Date date = this.datetimeUploaded;
        int hashCode8 = (hashCode7 + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.datetimeStored;
        int hashCode9 = (hashCode8 + (date2 != null ? date2.hashCode() : 0)) * 31;
        Date date3 = this.datetimeRemoved;
        int hashCode10 = (hashCode9 + (date3 != null ? date3.hashCode() : 0)) * 31;
        ImageInfo imageInfo2 = this.imageInfo;
        int hashCode11 = (hashCode10 + (imageInfo2 != null ? imageInfo2.hashCode() : 0)) * 31;
        VideoInfo videoInfo2 = this.videoInfo;
        int hashCode12 = (hashCode11 + (videoInfo2 != null ? videoInfo2.hashCode() : 0)) * 31;
        Map<String, Float> map = this.rekognitionInfo;
        int hashCode13 = (hashCode12 + (map != null ? map.hashCode() : 0)) * 31;
        Map<String, String> map2 = this.variations;
        if (map2 != null) {
            i = map2.hashCode();
        }
        return hashCode13 + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.uuid);
        parcel.writeSerializable(this.url);
        parcel.writeInt(this.size);
        parcel.writeString(this.source);
        parcel.writeInt(this.isReady ? 1 : 0);
        Boolean bool = this.isImage;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.mimeType);
        parcel.writeString(this.originalFilename);
        parcel.writeSerializable(this.originalFileUrl);
        parcel.writeSerializable(this.datetimeUploaded);
        parcel.writeSerializable(this.datetimeStored);
        parcel.writeSerializable(this.datetimeRemoved);
        ImageInfo imageInfo2 = this.imageInfo;
        if (imageInfo2 != null) {
            parcel.writeInt(1);
            imageInfo2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        VideoInfo videoInfo2 = this.videoInfo;
        if (videoInfo2 != null) {
            parcel.writeInt(1);
            videoInfo2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Map<String, Float> map = this.rekognitionInfo;
        if (map != null) {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Map.Entry<String, Float> next : map.entrySet()) {
                parcel.writeString(next.getKey());
                parcel.writeFloat(next.getValue().floatValue());
            }
        } else {
            parcel.writeInt(0);
        }
        Map<String, String> map2 = this.variations;
        if (map2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(map2.size());
            for (Map.Entry<String, String> next2 : map2.entrySet()) {
                parcel.writeString(next2.getKey());
                parcel.writeString(next2.getValue());
            }
            return;
        }
        parcel.writeInt(0);
    }

    public UploadcareFile(String str, URI uri, int i, String str2, @Json(name = "is_ready") boolean z, @Json(name = "is_image") Boolean bool, @Json(name = "mime_type") String str3, @Json(name = "original_filename") String str4, @Json(name = "original_file_url") URI uri2, @Json(name = "datetime_uploaded") Date date, @Json(name = "datetime_stored") Date date2, @Json(name = "datetime_removed") Date date3, @Json(name = "image_info") ImageInfo imageInfo2, @Json(name = "video_info") VideoInfo videoInfo2, @Json(name = "rekognition_info") Map<String, Float> map, Map<String, String> map2) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        this.uuid = str;
        this.url = uri;
        this.size = i;
        this.source = str2;
        this.isReady = z;
        this.isImage = bool;
        this.mimeType = str3;
        this.originalFilename = str4;
        this.originalFileUrl = uri2;
        this.datetimeUploaded = date;
        this.datetimeStored = date2;
        this.datetimeRemoved = date3;
        this.imageInfo = imageInfo2;
        this.videoInfo = videoInfo2;
        this.rekognitionInfo = map;
        this.variations = map2;
    }

    public final String getUuid() {
        return this.uuid;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UploadcareFile(java.lang.String r21, java.net.URI r22, int r23, java.lang.String r24, boolean r25, java.lang.Boolean r26, java.lang.String r27, java.lang.String r28, java.net.URI r29, java.util.Date r30, java.util.Date r31, java.util.Date r32, com.uploadcare.android.library.api.ImageInfo r33, com.uploadcare.android.library.api.VideoInfo r34, java.util.Map r35, java.util.Map r36, int r37, kotlin.jvm.internal.DefaultConstructorMarker r38) {
        /*
            r20 = this;
            r0 = r37
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x000c
            r1 = r2
            java.net.URI r1 = (java.net.URI) r1
            r5 = r1
            goto L_0x000e
        L_0x000c:
            r5 = r22
        L_0x000e:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0017
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r7 = r1
            goto L_0x0019
        L_0x0017:
            r7 = r24
        L_0x0019:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0024
            r1 = 0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r9 = r1
            goto L_0x0026
        L_0x0024:
            r9 = r26
        L_0x0026:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002f
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r10 = r1
            goto L_0x0031
        L_0x002f:
            r10 = r27
        L_0x0031:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x003a
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r11 = r1
            goto L_0x003c
        L_0x003a:
            r11 = r28
        L_0x003c:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0045
            r1 = r2
            java.net.URI r1 = (java.net.URI) r1
            r12 = r1
            goto L_0x0047
        L_0x0045:
            r12 = r29
        L_0x0047:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0050
            r1 = r2
            java.util.Date r1 = (java.util.Date) r1
            r13 = r1
            goto L_0x0052
        L_0x0050:
            r13 = r30
        L_0x0052:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x005b
            r1 = r2
            java.util.Date r1 = (java.util.Date) r1
            r14 = r1
            goto L_0x005d
        L_0x005b:
            r14 = r31
        L_0x005d:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0066
            r1 = r2
            java.util.Date r1 = (java.util.Date) r1
            r15 = r1
            goto L_0x0068
        L_0x0066:
            r15 = r32
        L_0x0068:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0072
            r1 = r2
            com.uploadcare.android.library.api.ImageInfo r1 = (com.uploadcare.android.library.api.ImageInfo) r1
            r16 = r1
            goto L_0x0074
        L_0x0072:
            r16 = r33
        L_0x0074:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x007e
            r1 = r2
            com.uploadcare.android.library.api.VideoInfo r1 = (com.uploadcare.android.library.api.VideoInfo) r1
            r17 = r1
            goto L_0x0080
        L_0x007e:
            r17 = r34
        L_0x0080:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x008a
            r1 = r2
            java.util.Map r1 = (java.util.Map) r1
            r18 = r1
            goto L_0x008c
        L_0x008a:
            r18 = r35
        L_0x008c:
            r1 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0098
            r0 = r2
            java.util.Map r0 = (java.util.Map) r0
            r19 = r0
            goto L_0x009a
        L_0x0098:
            r19 = r36
        L_0x009a:
            r3 = r20
            r4 = r21
            r6 = r23
            r8 = r25
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uploadcare.android.library.api.UploadcareFile.<init>(java.lang.String, java.net.URI, int, java.lang.String, boolean, java.lang.Boolean, java.lang.String, java.lang.String, java.net.URI, java.util.Date, java.util.Date, java.util.Date, com.uploadcare.android.library.api.ImageInfo, com.uploadcare.android.library.api.VideoInfo, java.util.Map, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final URI getUrl() {
        return this.url;
    }

    public final int getSize() {
        return this.size;
    }

    public final String getSource() {
        return this.source;
    }

    public final boolean isReady() {
        return this.isReady;
    }

    public final Boolean isImage() {
        return this.isImage;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getOriginalFilename() {
        return this.originalFilename;
    }

    public final URI getOriginalFileUrl() {
        return this.originalFileUrl;
    }

    public final Date getDatetimeUploaded() {
        return this.datetimeUploaded;
    }

    public final Date getDatetimeStored() {
        return this.datetimeStored;
    }

    public final Date getDatetimeRemoved() {
        return this.datetimeRemoved;
    }

    public final ImageInfo getImageInfo() {
        return this.imageInfo;
    }

    public final VideoInfo getVideoInfo() {
        return this.videoInfo;
    }

    public final Map<String, Float> getRekognitionInfo() {
        return this.rekognitionInfo;
    }

    public final Map<String, String> getVariations() {
        return this.variations;
    }

    public final boolean hasOriginalFileUrl() {
        return this.originalFileUrl != null;
    }

    public final boolean isStored() {
        return this.datetimeStored != null;
    }

    public final boolean isRemoved() {
        return this.datetimeRemoved != null;
    }

    public final UploadcareFile update(UploadcareClient uploadcareClient) {
        Intrinsics.checkNotNullParameter(uploadcareClient, "client");
        return uploadcareClient.getFile(this.uuid);
    }

    public final UploadcareFile delete(UploadcareClient uploadcareClient) {
        Intrinsics.checkNotNullParameter(uploadcareClient, "client");
        uploadcareClient.deleteFile(this.uuid);
        return update(uploadcareClient);
    }

    public final UploadcareFile save(UploadcareClient uploadcareClient) {
        Intrinsics.checkNotNullParameter(uploadcareClient, "client");
        uploadcareClient.saveFile(this.uuid);
        return update(uploadcareClient);
    }

    public final CdnPathBuilder cdnPath() {
        return new CdnPathBuilder(this);
    }

    public String toString() {
        String property = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append(Reflection.getOrCreateKotlinClass(UploadcareFile.class).getSimpleName());
        sb.append(property);
        sb.append("File id: " + this.uuid);
        sb.append(property);
        sb.append("Url: " + this.url);
        sb.append(property);
        sb.append("Size: " + this.size);
        sb.append(property);
        sb.append("Mime type: " + this.mimeType);
        sb.append(property);
        sb.append("is Ready: " + this.isReady);
        sb.append(property);
        sb.append("is Image: " + this.isImage);
        sb.append(property);
        sb.append("Original Filename: " + this.originalFilename);
        sb.append(property);
        sb.append("Original File Url: " + this.originalFileUrl);
        sb.append(property);
        sb.append("Date uploaded: " + this.datetimeUploaded);
        sb.append(property);
        sb.append("is Stored: " + isStored());
        sb.append(property);
        sb.append("Date stored: " + this.datetimeStored);
        sb.append(property);
        sb.append("is Removed: " + isRemoved());
        sb.append(property);
        sb.append("Date removed: " + this.datetimeRemoved);
        sb.append(property);
        sb.append("Source: " + this.source);
        sb.append(property);
        sb.append("Image Info: " + this.imageInfo);
        sb.append(property);
        sb.append("Video Info: " + this.videoInfo);
        sb.append(property);
        sb.append("Variations: " + this.variations);
        sb.append(property);
        sb.append("Rekognition Info: " + this.rekognitionInfo);
        sb.append(property);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply {\n…ine)\n        }.toString()");
        return sb2;
    }
}
