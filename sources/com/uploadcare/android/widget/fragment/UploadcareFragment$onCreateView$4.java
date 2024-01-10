package com.uploadcare.android.widget.fragment;

import androidx.lifecycle.Observer;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.FragmentKt;
import com.uploadcare.android.widget.R;
import com.uploadcare.android.widget.viewmodels.SocialData;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "socialData", "Lcom/uploadcare/android/widget/viewmodels/SocialData;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 0})
/* compiled from: UploadcareFragment.kt */
final class UploadcareFragment$onCreateView$4<T> implements Observer<SocialData> {
    final /* synthetic */ UploadcareFragment this$0;

    UploadcareFragment$onCreateView$4(UploadcareFragment uploadcareFragment) {
        this.this$0 = uploadcareFragment;
    }

    public final void onChanged(SocialData socialData) {
        FragmentKt.findNavController(this.this$0).navigate(UploadcareFragmentDirections.Companion.actionUploadcareFragmentToUploadcareFilesFragment(socialData.getSocialSource(), socialData.getStoreUponUpload(), socialData.getCancelable(), socialData.getShowProgress(), socialData.getBackgroundUpload()), new NavOptions.Builder().setPopUpTo(R.id.uploadcareFragment, true).build());
    }
}
