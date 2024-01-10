package com.uploadcare.android.library.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/uploadcare/android/library/data/ConvertStatusResultData;", "", "uuid", "", "(Ljava/lang/String;)V", "getUuid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: ConvertData.kt */
public final class ConvertStatusResultData {
    private final String uuid;

    public static /* synthetic */ ConvertStatusResultData copy$default(ConvertStatusResultData convertStatusResultData, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = convertStatusResultData.uuid;
        }
        return convertStatusResultData.copy(str);
    }

    public final String component1() {
        return this.uuid;
    }

    public final ConvertStatusResultData copy(String str) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        return new ConvertStatusResultData(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ConvertStatusResultData) && Intrinsics.areEqual((Object) this.uuid, (Object) ((ConvertStatusResultData) obj).uuid);
        }
        return true;
    }

    public int hashCode() {
        String str = this.uuid;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ConvertStatusResultData(uuid=" + this.uuid + ")";
    }

    public ConvertStatusResultData(String str) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        this.uuid = str;
    }

    public final String getUuid() {
        return this.uuid;
    }
}
