package com.uploadcare.android.library.conversion;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/uploadcare/android/library/conversion/ConversionJob;", "", "fileId", "", "(Ljava/lang/String;)V", "getFileId", "()Ljava/lang/String;", "getPath", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: ConversionJob.kt */
public abstract class ConversionJob {
    private final String fileId;

    public abstract String getPath();

    public ConversionJob(String str) {
        Intrinsics.checkNotNullParameter(str, "fileId");
        this.fileId = str;
    }

    public final String getFileId() {
        return this.fileId;
    }
}
