package com.uploadcare.android.widget.fragment;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.uploadcare.android.widget.utils.NavigationHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "progress", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 0})
/* compiled from: UploadcareFragment.kt */
final class UploadcareFragment$onCreateView$2<T> implements Observer<Integer> {
    final /* synthetic */ UploadcareFragment this$0;

    UploadcareFragment$onCreateView$2(UploadcareFragment uploadcareFragment) {
        this.this$0 = uploadcareFragment;
    }

    public final void onChanged(Integer num) {
        NavigationHelper.Companion companion = NavigationHelper.Companion;
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        Intrinsics.checkNotNullExpressionValue(num, "progress");
        companion.updateProgressDialogProgress(childFragmentManager, num.intValue());
    }
}
