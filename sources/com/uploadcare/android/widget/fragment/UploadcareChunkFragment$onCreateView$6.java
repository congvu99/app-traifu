package com.uploadcare.android.widget.fragment;

import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "loginLink", "", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 0})
/* compiled from: UploadcareChunkFragment.kt */
final class UploadcareChunkFragment$onCreateView$6<T> implements Observer<String> {
    final /* synthetic */ UploadcareChunkFragment this$0;

    UploadcareChunkFragment$onCreateView$6(UploadcareChunkFragment uploadcareChunkFragment) {
        this.this$0 = uploadcareChunkFragment;
    }

    public final void onChanged(String str) {
        if (str != null) {
            UploadcareChunkFragment.access$getMOnFileActionsListener$p(this.this$0).onAuthorizationNeeded(str);
        }
    }
}
