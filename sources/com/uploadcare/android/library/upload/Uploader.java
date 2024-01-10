package com.uploadcare.android.library.upload;

import com.uploadcare.android.library.api.UploadcareFile;
import com.uploadcare.android.library.callbacks.ProgressCallback;
import com.uploadcare.android.library.callbacks.UploadFileCallback;
import com.uploadcare.android.library.exceptions.UploadFailureException;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0014\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/uploadcare/android/library/upload/Uploader;", "", "cancel", "", "store", "", "upload", "Lcom/uploadcare/android/library/api/UploadcareFile;", "progressCallback", "Lcom/uploadcare/android/library/callbacks/ProgressCallback;", "uploadAsync", "callback", "Lcom/uploadcare/android/library/callbacks/UploadFileCallback;", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: Uploader.kt */
public interface Uploader {
    void cancel();

    Uploader store(boolean z);

    UploadcareFile upload(ProgressCallback progressCallback) throws UploadFailureException;

    void uploadAsync(UploadFileCallback uploadFileCallback);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    /* compiled from: Uploader.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ UploadcareFile upload$default(Uploader uploader, ProgressCallback progressCallback, int i, Object obj) throws UploadFailureException {
            if (obj == null) {
                if ((i & 1) != 0) {
                    progressCallback = null;
                }
                return uploader.upload(progressCallback);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: upload");
        }
    }
}
