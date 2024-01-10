package com.uploadcare.android.library.api;

import java.net.URI;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004"}, d2 = {"com/uploadcare/android/library/api/RequestHelper$executePaginatedQuery$1", "", "iterator", "", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: RequestHelper.kt */
public final class RequestHelper$executePaginatedQuery$1 implements Iterable<T>, KMappedMarker {
    final /* synthetic */ boolean $apiHeaders;
    final /* synthetic */ Class $dataClass;
    final /* synthetic */ URI $url;
    final /* synthetic */ Collection $urlParameters;
    final /* synthetic */ RequestHelper this$0;

    RequestHelper$executePaginatedQuery$1(RequestHelper requestHelper, URI uri, Collection collection, boolean z, Class cls) {
        this.this$0 = requestHelper;
        this.$url = uri;
        this.$urlParameters = collection;
        this.$apiHeaders = z;
        this.$dataClass = cls;
    }

    public Iterator<T> iterator() {
        return new RequestHelper$executePaginatedQuery$1$iterator$1(this);
    }
}
