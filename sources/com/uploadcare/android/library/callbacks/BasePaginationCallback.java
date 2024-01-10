package com.uploadcare.android.library.callbacks;

import com.uploadcare.android.library.exceptions.UploadcareApiException;
import java.net.URI;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H&J'\u0010\u0007\u001a\u00020\u00042\u0013\b\u0001\u0010\b\u001a\r\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\n0\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&¨\u0006\r"}, d2 = {"Lcom/uploadcare/android/library/callbacks/BasePaginationCallback;", "T", "", "onFailure", "", "e", "Lcom/uploadcare/android/library/exceptions/UploadcareApiException;", "onSuccess", "result", "", "Lkotlin/jvm/JvmSuppressWildcards;", "next", "Ljava/net/URI;", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: Callbacks.kt */
public interface BasePaginationCallback<T> {
    void onFailure(UploadcareApiException uploadcareApiException);

    void onSuccess(List<T> list, URI uri);
}
