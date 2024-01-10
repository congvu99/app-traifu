package com.uploadcare.android.widget.fragment;

import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onBackStackChanged"}, k = 3, mv = {1, 4, 0})
/* compiled from: UploadcareFilesFragment.kt */
final class UploadcareFilesFragment$onCreateView$8 implements FragmentManager.OnBackStackChangedListener {
    final /* synthetic */ UploadcareFilesFragment this$0;

    UploadcareFilesFragment$onCreateView$8(UploadcareFilesFragment uploadcareFilesFragment) {
        this.this$0 = uploadcareFilesFragment;
    }

    public final void onBackStackChanged() {
        UploadcareChunkFragment uploadcareChunkFragment = (UploadcareChunkFragment) this.this$0.getChildFragmentManager().findFragmentByTag("latest");
        if (uploadcareChunkFragment != null && uploadcareChunkFragment.isAdded()) {
            this.this$0.updateTitle(uploadcareChunkFragment.getTitle());
        }
    }
}
