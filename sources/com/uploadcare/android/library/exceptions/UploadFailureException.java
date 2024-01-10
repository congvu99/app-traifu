package com.uploadcare.android.library.exceptions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/uploadcare/android/library/exceptions/UploadFailureException;", "Lcom/uploadcare/android/library/exceptions/UploadcareApiException;", "message", "", "(Ljava/lang/String;)V", "cause", "", "(Ljava/lang/Throwable;)V", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: Exceptions.kt */
public final class UploadFailureException extends UploadcareApiException {
    public UploadFailureException(String str) {
        super(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UploadFailureException(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "Upload failed" : str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UploadFailureException(Throwable th) {
        super(th);
        Intrinsics.checkNotNullParameter(th, "cause");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UploadFailureException(String str, Throwable th) {
        super(str, th);
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(th, "cause");
    }
}
