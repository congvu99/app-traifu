package com.uploadcare.android.library.data;

import java.net.URI;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&J\b\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/uploadcare/android/library/data/PageData;", "T", "", "getNextURI", "Ljava/net/URI;", "getResultsData", "", "hasMore", "", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: PageData.kt */
public interface PageData<T> {
    URI getNextURI();

    List<T> getResultsData();

    boolean hasMore();
}
