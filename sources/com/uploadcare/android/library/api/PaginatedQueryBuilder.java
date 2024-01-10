package com.uploadcare.android.library.api;

import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/uploadcare/android/library/api/PaginatedQueryBuilder;", "T", "", "asIterable", "", "asList", "", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: PaginatedQueryBuilder.kt */
public interface PaginatedQueryBuilder<T> {
    Iterable<T> asIterable();

    List<T> asList();
}
