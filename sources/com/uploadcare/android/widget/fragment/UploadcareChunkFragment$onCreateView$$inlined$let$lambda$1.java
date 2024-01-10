package com.uploadcare.android.widget.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/uploadcare/android/widget/fragment/UploadcareChunkFragment$onCreateView$2$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: UploadcareChunkFragment.kt */
final class UploadcareChunkFragment$onCreateView$$inlined$let$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UploadcareChunkFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UploadcareChunkFragment$onCreateView$$inlined$let$lambda$1(UploadcareChunkFragment uploadcareChunkFragment) {
        super(0);
        this.this$0 = uploadcareChunkFragment;
    }

    public final void invoke() {
        UploadcareChunkFragment.access$getViewModel$p(this.this$0).loadMore();
    }
}
