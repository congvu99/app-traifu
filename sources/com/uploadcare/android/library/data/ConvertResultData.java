package com.uploadcare.android.library.data;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J/\u0010\u000f\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/uploadcare/android/library/data/ConvertResultData;", "", "problems", "", "", "result", "", "Lcom/uploadcare/android/library/data/ConvertResult;", "(Ljava/util/Map;Ljava/util/List;)V", "getProblems", "()Ljava/util/Map;", "getResult", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: ConvertData.kt */
public final class ConvertResultData {
    private final Map<String, String> problems;
    private final List<ConvertResult> result;

    public static /* synthetic */ ConvertResultData copy$default(ConvertResultData convertResultData, Map<String, String> map, List<ConvertResult> list, int i, Object obj) {
        if ((i & 1) != 0) {
            map = convertResultData.problems;
        }
        if ((i & 2) != 0) {
            list = convertResultData.result;
        }
        return convertResultData.copy(map, list);
    }

    public final Map<String, String> component1() {
        return this.problems;
    }

    public final List<ConvertResult> component2() {
        return this.result;
    }

    public final ConvertResultData copy(Map<String, String> map, List<ConvertResult> list) {
        Intrinsics.checkNotNullParameter(map, "problems");
        Intrinsics.checkNotNullParameter(list, "result");
        return new ConvertResultData(map, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConvertResultData)) {
            return false;
        }
        ConvertResultData convertResultData = (ConvertResultData) obj;
        return Intrinsics.areEqual((Object) this.problems, (Object) convertResultData.problems) && Intrinsics.areEqual((Object) this.result, (Object) convertResultData.result);
    }

    public int hashCode() {
        Map<String, String> map = this.problems;
        int i = 0;
        int hashCode = (map != null ? map.hashCode() : 0) * 31;
        List<ConvertResult> list = this.result;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ConvertResultData(problems=" + this.problems + ", result=" + this.result + ")";
    }

    public ConvertResultData(Map<String, String> map, List<ConvertResult> list) {
        Intrinsics.checkNotNullParameter(map, "problems");
        Intrinsics.checkNotNullParameter(list, "result");
        this.problems = map;
        this.result = list;
    }

    public final Map<String, String> getProblems() {
        return this.problems;
    }

    public final List<ConvertResult> getResult() {
        return this.result;
    }
}
