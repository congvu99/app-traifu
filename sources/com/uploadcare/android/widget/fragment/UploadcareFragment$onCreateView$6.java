package com.uploadcare.android.widget.fragment;

import androidx.lifecycle.Observer;
import com.uploadcare.android.widget.controller.FileType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "fileType", "Lcom/uploadcare/android/widget/controller/FileType;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 0})
/* compiled from: UploadcareFragment.kt */
final class UploadcareFragment$onCreateView$6<T> implements Observer<FileType> {
    final /* synthetic */ UploadcareFragment this$0;

    UploadcareFragment$onCreateView$6(UploadcareFragment uploadcareFragment) {
        this.this$0 = uploadcareFragment;
    }

    public final void onChanged(FileType fileType) {
        UploadcareFragment uploadcareFragment = this.this$0;
        Intrinsics.checkNotNullExpressionValue(fileType, "fileType");
        uploadcareFragment.launchFilePicker(fileType);
    }
}
