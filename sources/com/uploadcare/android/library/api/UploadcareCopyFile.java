package com.uploadcare.android.library.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.uploadcare.android.library.exceptions.UploadcareApiException;
import com.uploadcare.android.library.utils.AsString;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\nHÖ\u0001J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0006\u0010\u0002\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0011\u001a\u00020\u0012J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\nHÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/uploadcare/android/library/api/UploadcareCopyFile;", "Landroid/os/Parcelable;", "type", "", "result", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "file", "Lcom/uploadcare/android/library/api/UploadcareFile;", "client", "Lcom/uploadcare/android/library/api/UploadcareClient;", "hashCode", "toString", "Lcom/uploadcare/android/library/api/CopyFileType;", "uri", "Ljava/net/URI;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareCopyFile.kt */
public final class UploadcareCopyFile implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String result;
    private final String type;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new UploadcareCopyFile(parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new UploadcareCopyFile[i];
        }
    }

    private final String component1() {
        return this.type;
    }

    private final String component2() {
        return this.result;
    }

    public static /* synthetic */ UploadcareCopyFile copy$default(UploadcareCopyFile uploadcareCopyFile, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uploadcareCopyFile.type;
        }
        if ((i & 2) != 0) {
            str2 = uploadcareCopyFile.result;
        }
        return uploadcareCopyFile.copy(str, str2);
    }

    public final UploadcareCopyFile copy(String str, @AsString String str2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "result");
        return new UploadcareCopyFile(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadcareCopyFile)) {
            return false;
        }
        UploadcareCopyFile uploadcareCopyFile = (UploadcareCopyFile) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) uploadcareCopyFile.type) && Intrinsics.areEqual((Object) this.result, (Object) uploadcareCopyFile.result);
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.result;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.type);
        parcel.writeString(this.result);
    }

    public UploadcareCopyFile(String str, @AsString String str2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "result");
        this.type = str;
        this.result = str2;
    }

    public final CopyFileType type() {
        return CopyFileType.valueOf(this.type);
    }

    public final UploadcareFile file(UploadcareClient uploadcareClient) throws UploadcareApiException {
        Intrinsics.checkNotNullParameter(uploadcareClient, "client");
        if (type() != CopyFileType.FILE) {
            return null;
        }
        return (UploadcareFile) uploadcareClient.getObjectMapper().fromJson(this.result, UploadcareFile.class);
    }

    public final URI uri(UploadcareClient uploadcareClient) throws UploadcareApiException {
        Intrinsics.checkNotNullParameter(uploadcareClient, "client");
        if (type() != CopyFileType.URL) {
            return null;
        }
        return (URI) uploadcareClient.getObjectMapper().fromJson(this.result, URI.class);
    }

    public String toString() {
        String property = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append(Reflection.getOrCreateKotlinClass(UploadcareCopyFile.class).getSimpleName());
        sb.append(property);
        sb.append("type: " + this.type);
        sb.append(property);
        sb.append("result: " + this.result);
        sb.append(property);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply {\n…ine)\n        }.toString()");
        return sb2;
    }
}
