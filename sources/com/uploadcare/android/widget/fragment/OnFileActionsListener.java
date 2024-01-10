package com.uploadcare.android.widget.fragment;

import com.uploadcare.android.library.exceptions.UploadcareApiException;
import com.uploadcare.android.widget.data.Chunk;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001e\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0005H&¨\u0006\u0010"}, d2 = {"Lcom/uploadcare/android/widget/fragment/OnFileActionsListener;", "", "onAuthorizationNeeded", "", "loginLink", "", "onChunkSelected", "chunks", "", "Lcom/uploadcare/android/widget/data/Chunk;", "title", "onError", "exception", "Lcom/uploadcare/android/library/exceptions/UploadcareApiException;", "onFileSelected", "fileUrl", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareChunkFragment.kt */
public interface OnFileActionsListener {
    void onAuthorizationNeeded(String str);

    void onChunkSelected(List<Chunk> list, String str);

    void onError(UploadcareApiException uploadcareApiException);

    void onFileSelected(String str);
}
