package com.uploadcare.android.library.upload;

import com.uploadcare.android.library.callbacks.ProgressCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "bytesWritten", "", "contentLength", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: FileUploader.kt */
final class FileUploader$directUpload$countingRequestBody$1 extends Lambda implements Function2<Long, Long, Unit> {
    final /* synthetic */ ProgressCallback $progressCallback;
    final /* synthetic */ FileUploader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileUploader$directUpload$countingRequestBody$1(FileUploader fileUploader, ProgressCallback progressCallback) {
        super(2);
        this.this$0 = fileUploader;
        this.$progressCallback = progressCallback;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).longValue(), ((Number) obj2).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j, long j2) {
        this.this$0.checkUploadCanceled();
        double d = (((double) j) * 1.0d) / ((double) j2);
        ProgressCallback progressCallback = this.$progressCallback;
        if (progressCallback != null) {
            progressCallback.onProgressUpdate(j, j2, d);
        }
    }
}
