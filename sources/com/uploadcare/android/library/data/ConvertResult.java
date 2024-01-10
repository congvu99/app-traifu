package com.uploadcare.android.library.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B!\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/uploadcare/android/library/data/ConvertResult;", "", "originalSource", "", "uuid", "token", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getOriginalSource", "()Ljava/lang/String;", "getToken", "()I", "getUuid", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: ConvertData.kt */
public final class ConvertResult {
    private final String originalSource;
    private final int token;
    private final String uuid;

    public static /* synthetic */ ConvertResult copy$default(ConvertResult convertResult, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = convertResult.originalSource;
        }
        if ((i2 & 2) != 0) {
            str2 = convertResult.uuid;
        }
        if ((i2 & 4) != 0) {
            i = convertResult.token;
        }
        return convertResult.copy(str, str2, i);
    }

    public final String component1() {
        return this.originalSource;
    }

    public final String component2() {
        return this.uuid;
    }

    public final int component3() {
        return this.token;
    }

    public final ConvertResult copy(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str2, "uuid");
        return new ConvertResult(str, str2, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConvertResult)) {
            return false;
        }
        ConvertResult convertResult = (ConvertResult) obj;
        return Intrinsics.areEqual((Object) this.originalSource, (Object) convertResult.originalSource) && Intrinsics.areEqual((Object) this.uuid, (Object) convertResult.uuid) && this.token == convertResult.token;
    }

    public int hashCode() {
        String str = this.originalSource;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.uuid;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + this.token;
    }

    public String toString() {
        return "ConvertResult(originalSource=" + this.originalSource + ", uuid=" + this.uuid + ", token=" + this.token + ")";
    }

    public ConvertResult(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str2, "uuid");
        this.originalSource = str;
        this.uuid = str2;
        this.token = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConvertResult(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, str2, i);
    }

    public final String getOriginalSource() {
        return this.originalSource;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final int getToken() {
        return this.token;
    }
}
