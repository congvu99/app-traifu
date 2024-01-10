package com.uploadcare.android.library.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/uploadcare/android/library/data/ConvertStatusData;", "", "status", "", "result", "Lcom/uploadcare/android/library/data/ConvertStatusResultData;", "error", "(Ljava/lang/String;Lcom/uploadcare/android/library/data/ConvertStatusResultData;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "getResult", "()Lcom/uploadcare/android/library/data/ConvertStatusResultData;", "getStatus", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: ConvertData.kt */
public final class ConvertStatusData {
    private final String error;
    private final ConvertStatusResultData result;
    private final String status;

    public static /* synthetic */ ConvertStatusData copy$default(ConvertStatusData convertStatusData, String str, ConvertStatusResultData convertStatusResultData, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = convertStatusData.status;
        }
        if ((i & 2) != 0) {
            convertStatusResultData = convertStatusData.result;
        }
        if ((i & 4) != 0) {
            str2 = convertStatusData.error;
        }
        return convertStatusData.copy(str, convertStatusResultData, str2);
    }

    public final String component1() {
        return this.status;
    }

    public final ConvertStatusResultData component2() {
        return this.result;
    }

    public final String component3() {
        return this.error;
    }

    public final ConvertStatusData copy(String str, ConvertStatusResultData convertStatusResultData, String str2) {
        Intrinsics.checkNotNullParameter(str, "status");
        Intrinsics.checkNotNullParameter(convertStatusResultData, "result");
        return new ConvertStatusData(str, convertStatusResultData, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConvertStatusData)) {
            return false;
        }
        ConvertStatusData convertStatusData = (ConvertStatusData) obj;
        return Intrinsics.areEqual((Object) this.status, (Object) convertStatusData.status) && Intrinsics.areEqual((Object) this.result, (Object) convertStatusData.result) && Intrinsics.areEqual((Object) this.error, (Object) convertStatusData.error);
    }

    public int hashCode() {
        String str = this.status;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ConvertStatusResultData convertStatusResultData = this.result;
        int hashCode2 = (hashCode + (convertStatusResultData != null ? convertStatusResultData.hashCode() : 0)) * 31;
        String str2 = this.error;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ConvertStatusData(status=" + this.status + ", result=" + this.result + ", error=" + this.error + ")";
    }

    public ConvertStatusData(String str, ConvertStatusResultData convertStatusResultData, String str2) {
        Intrinsics.checkNotNullParameter(str, "status");
        Intrinsics.checkNotNullParameter(convertStatusResultData, "result");
        this.status = str;
        this.result = convertStatusResultData;
        this.error = str2;
    }

    public final String getStatus() {
        return this.status;
    }

    public final ConvertStatusResultData getResult() {
        return this.result;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConvertStatusData(String str, ConvertStatusResultData convertStatusResultData, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, convertStatusResultData, (i & 4) != 0 ? null : str2);
    }

    public final String getError() {
        return this.error;
    }
}
