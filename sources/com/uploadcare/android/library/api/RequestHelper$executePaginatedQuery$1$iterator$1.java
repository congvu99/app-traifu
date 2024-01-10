package com.uploadcare.android.library.api;

import android.net.Uri;
import com.uploadcare.android.library.api.RequestHelper;
import com.uploadcare.android.library.data.PageData;
import com.uploadcare.android.library.urls.UrlUtils;
import java.net.URI;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.RequestBody;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0007\u001a\u00020\bH\u0002J\t\u0010\t\u001a\u00020\u0003H\u0002J\u000e\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"com/uploadcare/android/library/api/RequestHelper$executePaginatedQuery$1$iterator$1", "", "more", "", "next", "Ljava/net/URI;", "pageIterator", "getNext", "", "hasNext", "()Ljava/lang/Object;", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: RequestHelper.kt */
public final class RequestHelper$executePaginatedQuery$1$iterator$1 implements Iterator<T>, KMappedMarker {
    private boolean more;
    private URI next;
    private Iterator<? extends T> pageIterator;
    final /* synthetic */ RequestHelper$executePaginatedQuery$1 this$0;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    RequestHelper$executePaginatedQuery$1$iterator$1(RequestHelper$executePaginatedQuery$1 requestHelper$executePaginatedQuery$1) {
        this.this$0 = requestHelper$executePaginatedQuery$1;
        getNext();
    }

    private final void getNext() {
        URI uri = this.next;
        if (uri == null) {
            Uri.Builder buildUpon = Uri.parse(this.this$0.$url.toString()).buildUpon();
            RequestHelper.Companion companion = RequestHelper.Companion;
            Intrinsics.checkNotNullExpressionValue(buildUpon, "builder");
            companion.setQueryParameters(buildUpon, this.this$0.$urlParameters);
            uri = UrlUtils.Companion.trustedBuild(buildUpon);
        }
        RequestHelper requestHelper = this.this$0.this$0;
        Intrinsics.checkNotNull(uri);
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "pageUrl!!.toString()");
        PageData pageData = (PageData) RequestHelper.executeQuery$default(requestHelper, "GET", uri2, this.this$0.$apiHeaders, this.this$0.$dataClass, (RequestBody) null, (String) null, (Collection) null, 96, (Object) null);
        boolean z = true;
        if (!pageData.hasMore()) {
            z = false;
        }
        this.more = z;
        this.next = pageData.getNextURI();
        this.pageIterator = pageData.getResultsData().iterator();
    }

    public boolean hasNext() {
        Iterator<? extends T> it = this.pageIterator;
        if (it != null && it.hasNext()) {
            return true;
        }
        if (!this.more) {
            return false;
        }
        getNext();
        return true;
    }

    public T next() {
        Iterator<? extends T> it = this.pageIterator;
        Intrinsics.checkNotNull(it);
        return it.next();
    }
}
