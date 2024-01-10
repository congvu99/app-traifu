package com.uploadcare.android.widget.viewmodels;

import com.uploadcare.android.library.api.UploadcareFile;
import com.uploadcare.android.library.callbacks.UploadFileCallback;
import com.uploadcare.android.library.exceptions.UploadcareApiException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/uploadcare/android/widget/viewmodels/UploadcareFilesViewModel$uploadFileFromUrl$1", "Lcom/uploadcare/android/library/callbacks/UploadFileCallback;", "onFailure", "", "e", "Lcom/uploadcare/android/library/exceptions/UploadcareApiException;", "onProgressUpdate", "bytesWritten", "", "contentLength", "progress", "", "onSuccess", "result", "Lcom/uploadcare/android/library/api/UploadcareFile;", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareFilesViewModel.kt */
public final class UploadcareFilesViewModel$uploadFileFromUrl$1 implements UploadFileCallback {
    final /* synthetic */ UploadcareFilesViewModel this$0;

    UploadcareFilesViewModel$uploadFileFromUrl$1(UploadcareFilesViewModel uploadcareFilesViewModel) {
        this.this$0 = uploadcareFilesViewModel;
    }

    public void onFailure(UploadcareApiException uploadcareApiException) {
        Intrinsics.checkNotNullParameter(uploadcareApiException, "e");
        this.this$0.error(uploadcareApiException);
    }

    public void onProgressUpdate(long j, long j2, double d) {
        if (this.this$0.showProgress) {
            this.this$0.getUploadProgress().setValue(Integer.valueOf(MathKt.roundToInt(d * ((double) 100))));
        }
    }

    public void onSuccess(UploadcareFile uploadcareFile) {
        Intrinsics.checkNotNullParameter(uploadcareFile, "result");
        this.this$0.getProgressDialogCommand().postValue(new ProgressData(false, (String) null, false, false, 14, (DefaultConstructorMarker) null));
        this.this$0.getUploadCompleteCommand().postValue(uploadcareFile);
        this.this$0.uploader = null;
    }
}
