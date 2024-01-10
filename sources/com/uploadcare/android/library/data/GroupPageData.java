package com.uploadcare.android.library.data;

import com.squareup.moshi.Json;
import com.uploadcare.android.library.api.UploadcareGroup;
import java.net.URI;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B=\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\nHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\b\u0010 \u001a\u00020\u001bH\u0016J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006$"}, d2 = {"Lcom/uploadcare/android/library/data/GroupPageData;", "Lcom/uploadcare/android/library/data/PageData;", "Lcom/uploadcare/android/library/api/UploadcareGroup;", "next", "Ljava/net/URI;", "previous", "total", "", "perPage", "results", "", "(Ljava/net/URI;Ljava/net/URI;IILjava/util/List;)V", "getNext", "()Ljava/net/URI;", "getPerPage", "()I", "getPrevious", "getResults", "()Ljava/util/List;", "getTotal", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "getNextURI", "getResultsData", "hasMore", "hashCode", "toString", "", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: GroupPageData.kt */
public final class GroupPageData implements PageData<UploadcareGroup> {
    private final URI next;
    private final int perPage;
    private final URI previous;
    private final List<UploadcareGroup> results;
    private final int total;

    public static /* synthetic */ GroupPageData copy$default(GroupPageData groupPageData, URI uri, URI uri2, int i, int i2, List<UploadcareGroup> list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            uri = groupPageData.next;
        }
        if ((i3 & 2) != 0) {
            uri2 = groupPageData.previous;
        }
        URI uri3 = uri2;
        if ((i3 & 4) != 0) {
            i = groupPageData.total;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = groupPageData.perPage;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            list = groupPageData.results;
        }
        return groupPageData.copy(uri, uri3, i4, i5, list);
    }

    public final URI component1() {
        return this.next;
    }

    public final URI component2() {
        return this.previous;
    }

    public final int component3() {
        return this.total;
    }

    public final int component4() {
        return this.perPage;
    }

    public final List<UploadcareGroup> component5() {
        return this.results;
    }

    public final GroupPageData copy(URI uri, URI uri2, int i, @Json(name = "per_page") int i2, List<UploadcareGroup> list) {
        Intrinsics.checkNotNullParameter(list, "results");
        return new GroupPageData(uri, uri2, i, i2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GroupPageData)) {
            return false;
        }
        GroupPageData groupPageData = (GroupPageData) obj;
        return Intrinsics.areEqual((Object) this.next, (Object) groupPageData.next) && Intrinsics.areEqual((Object) this.previous, (Object) groupPageData.previous) && this.total == groupPageData.total && this.perPage == groupPageData.perPage && Intrinsics.areEqual((Object) this.results, (Object) groupPageData.results);
    }

    public int hashCode() {
        URI uri = this.next;
        int i = 0;
        int hashCode = (uri != null ? uri.hashCode() : 0) * 31;
        URI uri2 = this.previous;
        int hashCode2 = (((((hashCode + (uri2 != null ? uri2.hashCode() : 0)) * 31) + this.total) * 31) + this.perPage) * 31;
        List<UploadcareGroup> list = this.results;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "GroupPageData(next=" + this.next + ", previous=" + this.previous + ", total=" + this.total + ", perPage=" + this.perPage + ", results=" + this.results + ")";
    }

    public GroupPageData(URI uri, URI uri2, int i, @Json(name = "per_page") int i2, List<UploadcareGroup> list) {
        Intrinsics.checkNotNullParameter(list, "results");
        this.next = uri;
        this.previous = uri2;
        this.total = i;
        this.perPage = i2;
        this.results = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GroupPageData(URI uri, URI uri2, int i, int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : uri, (i3 & 2) != 0 ? null : uri2, i, i2, list);
    }

    public final URI getNext() {
        return this.next;
    }

    public final URI getPrevious() {
        return this.previous;
    }

    public final int getTotal() {
        return this.total;
    }

    public final int getPerPage() {
        return this.perPage;
    }

    public final List<UploadcareGroup> getResults() {
        return this.results;
    }

    public List<UploadcareGroup> getResultsData() {
        return this.results;
    }

    public boolean hasMore() {
        return this.next != null;
    }

    public URI getNextURI() {
        return this.next;
    }
}
