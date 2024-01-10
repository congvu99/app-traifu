package com.uploadcare.android.widget.fragment;

import androidx.lifecycle.Observer;
import com.uploadcare.android.library.exceptions.UploadcareApiException;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "exception", "Lcom/uploadcare/android/library/exceptions/UploadcareApiException;", "onChanged"}, k = 3, mv = {1, 4, 0})
/* compiled from: UploadcareChunkFragment.kt */
final class UploadcareChunkFragment$onCreateView$5<T> implements Observer<UploadcareApiException> {
    final /* synthetic */ UploadcareChunkFragment this$0;

    UploadcareChunkFragment$onCreateView$5(UploadcareChunkFragment uploadcareChunkFragment) {
        this.this$0 = uploadcareChunkFragment;
    }

    public final void onChanged(UploadcareApiException uploadcareApiException) {
        if (uploadcareApiException != null) {
            UploadcareChunkFragment.access$getMOnFileActionsListener$p(this.this$0).onError(uploadcareApiException);
        }
    }
}
