package com.uploadcare.android.library.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J%\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/uploadcare/android/library/data/ConvertData;", "", "paths", "", "", "store", "(Ljava/util/List;Ljava/lang/String;)V", "getPaths", "()Ljava/util/List;", "getStore", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: ConvertData.kt */
public final class ConvertData {
    private final List<String> paths;
    private final String store;

    public static /* synthetic */ ConvertData copy$default(ConvertData convertData, List<String> list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = convertData.paths;
        }
        if ((i & 2) != 0) {
            str = convertData.store;
        }
        return convertData.copy(list, str);
    }

    public final List<String> component1() {
        return this.paths;
    }

    public final String component2() {
        return this.store;
    }

    public final ConvertData copy(List<String> list, String str) {
        Intrinsics.checkNotNullParameter(list, "paths");
        return new ConvertData(list, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConvertData)) {
            return false;
        }
        ConvertData convertData = (ConvertData) obj;
        return Intrinsics.areEqual((Object) this.paths, (Object) convertData.paths) && Intrinsics.areEqual((Object) this.store, (Object) convertData.store);
    }

    public int hashCode() {
        List<String> list = this.paths;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.store;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ConvertData(paths=" + this.paths + ", store=" + this.store + ")";
    }

    public ConvertData(List<String> list, String str) {
        Intrinsics.checkNotNullParameter(list, "paths");
        this.paths = list;
        this.store = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConvertData(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : str);
    }

    public final List<String> getPaths() {
        return this.paths;
    }

    public final String getStore() {
        return this.store;
    }
}
