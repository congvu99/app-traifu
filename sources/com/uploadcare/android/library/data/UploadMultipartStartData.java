package com.uploadcare.android.library.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/uploadcare/android/library/data/UploadMultipartStartData;", "", "uuid", "", "parts", "", "(Ljava/lang/String;Ljava/util/List;)V", "getParts", "()Ljava/util/List;", "getUuid", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadMultipartStartData.kt */
public final class UploadMultipartStartData {
    private final List<String> parts;
    private final String uuid;

    public static /* synthetic */ UploadMultipartStartData copy$default(UploadMultipartStartData uploadMultipartStartData, String str, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uploadMultipartStartData.uuid;
        }
        if ((i & 2) != 0) {
            list = uploadMultipartStartData.parts;
        }
        return uploadMultipartStartData.copy(str, list);
    }

    public final String component1() {
        return this.uuid;
    }

    public final List<String> component2() {
        return this.parts;
    }

    public final UploadMultipartStartData copy(String str, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        Intrinsics.checkNotNullParameter(list, "parts");
        return new UploadMultipartStartData(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadMultipartStartData)) {
            return false;
        }
        UploadMultipartStartData uploadMultipartStartData = (UploadMultipartStartData) obj;
        return Intrinsics.areEqual((Object) this.uuid, (Object) uploadMultipartStartData.uuid) && Intrinsics.areEqual((Object) this.parts, (Object) uploadMultipartStartData.parts);
    }

    public int hashCode() {
        String str = this.uuid;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.parts;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "UploadMultipartStartData(uuid=" + this.uuid + ", parts=" + this.parts + ")";
    }

    public UploadMultipartStartData(String str, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        Intrinsics.checkNotNullParameter(list, "parts");
        this.uuid = str;
        this.parts = list;
    }

    public final List<String> getParts() {
        return this.parts;
    }

    public final String getUuid() {
        return this.uuid;
    }
}
