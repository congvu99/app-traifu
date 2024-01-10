package com.uploadcare.android.library.upload;

import com.uploadcare.android.library.api.UploadcareFile;
import com.uploadcare.android.library.callbacks.ProgressCallback;
import com.uploadcare.android.library.callbacks.UploadFilesCallback;
import com.uploadcare.android.library.exceptions.UploadFailureException;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/uploadcare/android/library/upload/MultipleUploader;", "", "cancel", "", "store", "", "upload", "", "Lcom/uploadcare/android/library/api/UploadcareFile;", "progressCallback", "Lcom/uploadcare/android/library/callbacks/ProgressCallback;", "uploadAsync", "callback", "Lcom/uploadcare/android/library/callbacks/UploadFilesCallback;", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: MultipleUploader.kt */
public interface MultipleUploader {
    void cancel();

    MultipleUploader store(boolean z);

    List<UploadcareFile> upload(ProgressCallback progressCallback) throws UploadFailureException;

    void uploadAsync(UploadFilesCallback uploadFilesCallback);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    /* compiled from: MultipleUploader.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ List upload$default(MultipleUploader multipleUploader, ProgressCallback progressCallback, int i, Object obj) throws UploadFailureException {
            if (obj == null) {
                if ((i & 1) != 0) {
                    progressCallback = null;
                }
                return multipleUploader.upload(progressCallback);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: upload");
        }
    }
}
