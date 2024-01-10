package com.uploadcare.android.widget.fragment;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.uploadcare.android.widget.R;
import com.uploadcare.android.widget.controller.FileType;
import com.uploadcare.android.widget.data.SocialSource;
import com.uploadcare.android.widget.utils.NavigationHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u000122\u0010\u0002\u001a.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u0006 \u0007*\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "pair", "Lkotlin/Pair;", "", "Lcom/uploadcare/android/widget/data/SocialSource;", "Lcom/uploadcare/android/widget/controller/FileType;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 0})
/* compiled from: UploadcareFragment.kt */
final class UploadcareFragment$onCreateView$3<T> implements Observer<Pair<? extends List<? extends SocialSource>, ? extends FileType>> {
    final /* synthetic */ UploadcareFragment this$0;

    UploadcareFragment$onCreateView$3(UploadcareFragment uploadcareFragment) {
        this.this$0 = uploadcareFragment;
    }

    public final void onChanged(Pair<? extends List<SocialSource>, ? extends FileType> pair) {
        NavigationHelper.Companion companion = NavigationHelper.Companion;
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        String string = this.this$0.getString(R.string.ucw_action_select_network);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.ucw_action_select_network)");
        companion.showSocialSourcesDialog(childFragmentManager, (List) pair.getFirst(), string, (FileType) pair.getSecond());
    }
}
