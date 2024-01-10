package com.uploadcare.android.library.data;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/uploadcare/android/library/data/UploadFromUrlStatusData;", "", "status", "", "done", "", "total", "error", "fileId", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;)V", "getDone", "()J", "getError", "()Ljava/lang/String;", "getFileId", "getStatus", "getTotal", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadFromUrlStatusData.kt */
public final class UploadFromUrlStatusData {
    private final long done;
    private final String error;
    private final String fileId;
    private final String status;
    private final long total;

    public static /* synthetic */ UploadFromUrlStatusData copy$default(UploadFromUrlStatusData uploadFromUrlStatusData, String str, long j, long j2, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uploadFromUrlStatusData.status;
        }
        if ((i & 2) != 0) {
            j = uploadFromUrlStatusData.done;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = uploadFromUrlStatusData.total;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            str2 = uploadFromUrlStatusData.error;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            str3 = uploadFromUrlStatusData.fileId;
        }
        return uploadFromUrlStatusData.copy(str, j3, j4, str4, str3);
    }

    public final String component1() {
        return this.status;
    }

    public final long component2() {
        return this.done;
    }

    public final long component3() {
        return this.total;
    }

    public final String component4() {
        return this.error;
    }

    public final String component5() {
        return this.fileId;
    }

    public final UploadFromUrlStatusData copy(String str, long j, long j2, String str2, @Json(name = "file_id") String str3) {
        Intrinsics.checkNotNullParameter(str, "status");
        return new UploadFromUrlStatusData(str, j, j2, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadFromUrlStatusData)) {
            return false;
        }
        UploadFromUrlStatusData uploadFromUrlStatusData = (UploadFromUrlStatusData) obj;
        return Intrinsics.areEqual((Object) this.status, (Object) uploadFromUrlStatusData.status) && this.done == uploadFromUrlStatusData.done && this.total == uploadFromUrlStatusData.total && Intrinsics.areEqual((Object) this.error, (Object) uploadFromUrlStatusData.error) && Intrinsics.areEqual((Object) this.fileId, (Object) uploadFromUrlStatusData.fileId);
    }

    public int hashCode() {
        String str = this.status;
        int i = 0;
        int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.done)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.total)) * 31;
        String str2 = this.error;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.fileId;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "UploadFromUrlStatusData(status=" + this.status + ", done=" + this.done + ", total=" + this.total + ", error=" + this.error + ", fileId=" + this.fileId + ")";
    }

    public UploadFromUrlStatusData(String str, long j, long j2, String str2, @Json(name = "file_id") String str3) {
        Intrinsics.checkNotNullParameter(str, "status");
        this.status = str;
        this.done = j;
        this.total = j2;
        this.error = str2;
        this.fileId = str3;
    }

    public final String getStatus() {
        return this.status;
    }

    public final long getDone() {
        return this.done;
    }

    public final long getTotal() {
        return this.total;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UploadFromUrlStatusData(String str, long j, long j2, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 0 : j, (i & 4) != 0 ? 0 : j2, (i & 8) != 0 ? null : str2, str3);
    }

    public final String getError() {
        return this.error;
    }

    public final String getFileId() {
        return this.fileId;
    }
}
