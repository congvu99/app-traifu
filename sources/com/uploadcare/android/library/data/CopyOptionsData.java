package com.uploadcare.android.library.data;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JH\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/uploadcare/android/library/data/CopyOptionsData;", "", "source", "", "target", "store", "", "makePublic", "pattern", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getMakePublic", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPattern", "()Ljava/lang/String;", "getSource", "getStore", "getTarget", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/uploadcare/android/library/data/CopyOptionsData;", "equals", "other", "hashCode", "", "toString", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: CopyOptionsData.kt */
public final class CopyOptionsData {
    private final Boolean makePublic;
    private final String pattern;
    private final String source;
    private final Boolean store;
    private final String target;

    public static /* synthetic */ CopyOptionsData copy$default(CopyOptionsData copyOptionsData, String str, String str2, Boolean bool, Boolean bool2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = copyOptionsData.source;
        }
        if ((i & 2) != 0) {
            str2 = copyOptionsData.target;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            bool = copyOptionsData.store;
        }
        Boolean bool3 = bool;
        if ((i & 8) != 0) {
            bool2 = copyOptionsData.makePublic;
        }
        Boolean bool4 = bool2;
        if ((i & 16) != 0) {
            str3 = copyOptionsData.pattern;
        }
        return copyOptionsData.copy(str, str4, bool3, bool4, str3);
    }

    public final String component1() {
        return this.source;
    }

    public final String component2() {
        return this.target;
    }

    public final Boolean component3() {
        return this.store;
    }

    public final Boolean component4() {
        return this.makePublic;
    }

    public final String component5() {
        return this.pattern;
    }

    public final CopyOptionsData copy(String str, String str2, Boolean bool, @Json(name = "make_public") Boolean bool2, String str3) {
        Intrinsics.checkNotNullParameter(str, "source");
        return new CopyOptionsData(str, str2, bool, bool2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CopyOptionsData)) {
            return false;
        }
        CopyOptionsData copyOptionsData = (CopyOptionsData) obj;
        return Intrinsics.areEqual((Object) this.source, (Object) copyOptionsData.source) && Intrinsics.areEqual((Object) this.target, (Object) copyOptionsData.target) && Intrinsics.areEqual((Object) this.store, (Object) copyOptionsData.store) && Intrinsics.areEqual((Object) this.makePublic, (Object) copyOptionsData.makePublic) && Intrinsics.areEqual((Object) this.pattern, (Object) copyOptionsData.pattern);
    }

    public int hashCode() {
        String str = this.source;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.target;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.store;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.makePublic;
        int hashCode4 = (hashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        String str3 = this.pattern;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "CopyOptionsData(source=" + this.source + ", target=" + this.target + ", store=" + this.store + ", makePublic=" + this.makePublic + ", pattern=" + this.pattern + ")";
    }

    public CopyOptionsData(String str, String str2, Boolean bool, @Json(name = "make_public") Boolean bool2, String str3) {
        Intrinsics.checkNotNullParameter(str, "source");
        this.source = str;
        this.target = str2;
        this.store = bool;
        this.makePublic = bool2;
        this.pattern = str3;
    }

    public final String getSource() {
        return this.source;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CopyOptionsData(String str, String str2, Boolean bool, Boolean bool2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : bool2, (i & 16) != 0 ? null : str3);
    }

    public final String getTarget() {
        return this.target;
    }

    public final Boolean getStore() {
        return this.store;
    }

    public final Boolean getMakePublic() {
        return this.makePublic;
    }

    public final String getPattern() {
        return this.pattern;
    }
}
