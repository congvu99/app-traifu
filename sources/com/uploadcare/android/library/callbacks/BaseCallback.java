package com.uploadcare.android.library.callbacks;

import com.uploadcare.android.library.exceptions.UploadcareApiException;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H&J\u001c\u0010\u0007\u001a\u00020\u00042\r\b\u0001\u0010\b\u001a\u00078\u0000¢\u0006\u0002\b\tH&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/uploadcare/android/library/callbacks/BaseCallback;", "T", "", "onFailure", "", "e", "Lcom/uploadcare/android/library/exceptions/UploadcareApiException;", "onSuccess", "result", "Lkotlin/jvm/JvmSuppressWildcards;", "(Ljava/lang/Object;)V", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: Callbacks.kt */
public interface BaseCallback<T> {
    void onFailure(UploadcareApiException uploadcareApiException);

    void onSuccess(T t);
}
