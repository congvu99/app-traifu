package com.uploadcare.android.widget.fragment;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.uploadcare.android.widget.utils.NavigationHelper;
import com.uploadcare.android.widget.viewmodels.ProgressData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "progressData", "Lcom/uploadcare/android/widget/viewmodels/ProgressData;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 0})
/* compiled from: UploadcareFilesFragment.kt */
final class UploadcareFilesFragment$onCreateView$3<T> implements Observer<ProgressData> {
    final /* synthetic */ UploadcareFilesFragment this$0;

    UploadcareFilesFragment$onCreateView$3(UploadcareFilesFragment uploadcareFilesFragment) {
        this.this$0 = uploadcareFilesFragment;
    }

    public final void onChanged(ProgressData progressData) {
        if (progressData.getShow()) {
            NavigationHelper.Companion companion = NavigationHelper.Companion;
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            Intrinsics.checkNotNullExpressionValue(progressData, "progressData");
            companion.showProgressDialog(childFragmentManager, progressData);
            return;
        }
        NavigationHelper.Companion companion2 = NavigationHelper.Companion;
        FragmentManager childFragmentManager2 = this.this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "childFragmentManager");
        companion2.dismissProgressDialog(childFragmentManager2);
    }
}
