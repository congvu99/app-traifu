package com.uploadcare.android.library.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0003\u0010\f\u001a\u00020\r\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0005¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010!\u001a\u00020\rHÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J[\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0003\u0010\u000e\u001a\u00020\u0005HÆ\u0001J\t\u0010$\u001a\u00020\rHÖ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\u0006\u0010)\u001a\u00020&J\t\u0010*\u001a\u00020\rHÖ\u0001J\u0010\u0010+\u001a\u0004\u0018\u00010\u00002\u0006\u0010,\u001a\u00020-J\b\u0010.\u001a\u00020\u0003H\u0016J\u0019\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\rHÖ\u0001R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u00064"}, d2 = {"Lcom/uploadcare/android/library/api/UploadcareGroup;", "Landroid/os/Parcelable;", "id", "", "url", "Ljava/net/URI;", "files", "", "Lcom/uploadcare/android/library/api/UploadcareFile;", "datetimeCreated", "Ljava/util/Date;", "datetimeStored", "filesCount", "", "cdnUrl", "(Ljava/lang/String;Ljava/net/URI;Ljava/util/List;Ljava/util/Date;Ljava/util/Date;ILjava/net/URI;)V", "getCdnUrl", "()Ljava/net/URI;", "getDatetimeCreated", "()Ljava/util/Date;", "getDatetimeStored", "getFiles", "()Ljava/util/List;", "getFilesCount", "()I", "getId", "()Ljava/lang/String;", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "", "other", "", "hasFiles", "hashCode", "store", "client", "Lcom/uploadcare/android/library/api/UploadcareClient;", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareGroup.kt */
public final class UploadcareGroup implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final URI cdnUrl;
    private final Date datetimeCreated;
    private final Date datetimeStored;
    private final List<UploadcareFile> files;
    private final int filesCount;
    private final String id;
    private final URI url;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            URI uri = (URI) parcel.readSerializable();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((UploadcareFile) UploadcareFile.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new UploadcareGroup(readString, uri, arrayList, (Date) parcel.readSerializable(), (Date) parcel.readSerializable(), parcel.readInt(), (URI) parcel.readSerializable());
        }

        public final Object[] newArray(int i) {
            return new UploadcareGroup[i];
        }
    }

    public static /* synthetic */ UploadcareGroup copy$default(UploadcareGroup uploadcareGroup, String str, URI uri, List<UploadcareFile> list, Date date, Date date2, int i, URI uri2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = uploadcareGroup.id;
        }
        if ((i2 & 2) != 0) {
            uri = uploadcareGroup.url;
        }
        URI uri3 = uri;
        if ((i2 & 4) != 0) {
            list = uploadcareGroup.files;
        }
        List<UploadcareFile> list2 = list;
        if ((i2 & 8) != 0) {
            date = uploadcareGroup.datetimeCreated;
        }
        Date date3 = date;
        if ((i2 & 16) != 0) {
            date2 = uploadcareGroup.datetimeStored;
        }
        Date date4 = date2;
        if ((i2 & 32) != 0) {
            i = uploadcareGroup.filesCount;
        }
        int i3 = i;
        if ((i2 & 64) != 0) {
            uri2 = uploadcareGroup.cdnUrl;
        }
        return uploadcareGroup.copy(str, uri3, list2, date3, date4, i3, uri2);
    }

    public final String component1() {
        return this.id;
    }

    public final URI component2() {
        return this.url;
    }

    public final List<UploadcareFile> component3() {
        return this.files;
    }

    public final Date component4() {
        return this.datetimeCreated;
    }

    public final Date component5() {
        return this.datetimeStored;
    }

    public final int component6() {
        return this.filesCount;
    }

    public final URI component7() {
        return this.cdnUrl;
    }

    public final UploadcareGroup copy(String str, URI uri, List<UploadcareFile> list, @Json(name = "datetime_created") Date date, @Json(name = "datetime_stored") Date date2, @Json(name = "files_count") int i, @Json(name = "cdn_url") URI uri2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(uri, "url");
        URI uri3 = uri2;
        Intrinsics.checkNotNullParameter(uri3, "cdnUrl");
        return new UploadcareGroup(str, uri, list, date, date2, i, uri3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadcareGroup)) {
            return false;
        }
        UploadcareGroup uploadcareGroup = (UploadcareGroup) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) uploadcareGroup.id) && Intrinsics.areEqual((Object) this.url, (Object) uploadcareGroup.url) && Intrinsics.areEqual((Object) this.files, (Object) uploadcareGroup.files) && Intrinsics.areEqual((Object) this.datetimeCreated, (Object) uploadcareGroup.datetimeCreated) && Intrinsics.areEqual((Object) this.datetimeStored, (Object) uploadcareGroup.datetimeStored) && this.filesCount == uploadcareGroup.filesCount && Intrinsics.areEqual((Object) this.cdnUrl, (Object) uploadcareGroup.cdnUrl);
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        URI uri = this.url;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        List<UploadcareFile> list = this.files;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Date date = this.datetimeCreated;
        int hashCode4 = (hashCode3 + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.datetimeStored;
        int hashCode5 = (((hashCode4 + (date2 != null ? date2.hashCode() : 0)) * 31) + this.filesCount) * 31;
        URI uri2 = this.cdnUrl;
        if (uri2 != null) {
            i = uri2.hashCode();
        }
        return hashCode5 + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeSerializable(this.url);
        List<UploadcareFile> list = this.files;
        if (list != null) {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (UploadcareFile writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeSerializable(this.datetimeCreated);
        parcel.writeSerializable(this.datetimeStored);
        parcel.writeInt(this.filesCount);
        parcel.writeSerializable(this.cdnUrl);
    }

    public UploadcareGroup(String str, URI uri, List<UploadcareFile> list, @Json(name = "datetime_created") Date date, @Json(name = "datetime_stored") Date date2, @Json(name = "files_count") int i, @Json(name = "cdn_url") URI uri2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(uri, "url");
        Intrinsics.checkNotNullParameter(uri2, "cdnUrl");
        this.id = str;
        this.url = uri;
        this.files = list;
        this.datetimeCreated = date;
        this.datetimeStored = date2;
        this.filesCount = i;
        this.cdnUrl = uri2;
    }

    public final String getId() {
        return this.id;
    }

    public final URI getUrl() {
        return this.url;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UploadcareGroup(String str, URI uri, List list, Date date, Date date2, int i, URI uri2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, uri, (i2 & 4) != 0 ? null : list, date, date2, (i2 & 32) != 0 ? 0 : i, uri2);
    }

    public final List<UploadcareFile> getFiles() {
        return this.files;
    }

    public final Date getDatetimeCreated() {
        return this.datetimeCreated;
    }

    public final Date getDatetimeStored() {
        return this.datetimeStored;
    }

    public final int getFilesCount() {
        return this.filesCount;
    }

    public final URI getCdnUrl() {
        return this.cdnUrl;
    }

    public final boolean hasFiles() {
        return this.files != null;
    }

    public final UploadcareGroup store(UploadcareClient uploadcareClient) {
        Intrinsics.checkNotNullParameter(uploadcareClient, "client");
        uploadcareClient.storeGroup(this.id);
        return uploadcareClient.getGroup(this.id);
    }

    public String toString() {
        String property = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append(Reflection.getOrCreateKotlinClass(UploadcareGroup.class).getSimpleName());
        sb.append(property);
        sb.append("Group id: " + this.id);
        sb.append(property);
        sb.append("Url: " + this.url);
        sb.append(property);
        sb.append("CDN url:: " + this.cdnUrl);
        sb.append(property);
        sb.append("Files count: : " + this.filesCount);
        sb.append(property);
        sb.append("Created: " + this.datetimeCreated);
        sb.append(property);
        sb.append("Stored: " + this.datetimeStored);
        sb.append(property);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply {\n…ine)\n        }.toString()");
        return sb2;
    }
}
