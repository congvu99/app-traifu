package com.uploadcare.android.widget.fragment;

import androidx.lifecycle.Observer;
import com.uploadcare.android.widget.utils.RecyclerViewOnScrollListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "allowLoadMore", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 0})
/* compiled from: UploadcareChunkFragment.kt */
final class UploadcareChunkFragment$onCreateView$4<T> implements Observer<Boolean> {
    final /* synthetic */ UploadcareChunkFragment this$0;

    UploadcareChunkFragment$onCreateView$4(UploadcareChunkFragment uploadcareChunkFragment) {
        this.this$0 = uploadcareChunkFragment;
    }

    public final void onChanged(Boolean bool) {
        Intrinsics.checkNotNullExpressionValue(bool, "allowLoadMore");
        if (bool.booleanValue()) {
            RecyclerViewOnScrollListener access$getMOnScrollListener$p = this.this$0.mOnScrollListener;
            if (access$getMOnScrollListener$p != null) {
                access$getMOnScrollListener$p.clear();
                UploadcareChunkFragment.access$getBinding$p(this.this$0).ucwRecyclerView.addOnScrollListener(access$getMOnScrollListener$p);
                return;
            }
            return;
        }
        UploadcareChunkFragment.access$getBinding$p(this.this$0).ucwRecyclerView.clearOnScrollListeners();
    }
}
