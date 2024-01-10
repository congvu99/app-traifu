package com.uploadcare.android.widget.fragment;

import androidx.lifecycle.Observer;
import com.uploadcare.android.widget.adapter.FilesAdapter;
import com.uploadcare.android.widget.data.Thing;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "things", "", "Lcom/uploadcare/android/widget/data/Thing;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 0})
/* compiled from: UploadcareChunkFragment.kt */
final class UploadcareChunkFragment$onCreateView$3<T> implements Observer<List<? extends Thing>> {
    final /* synthetic */ UploadcareChunkFragment this$0;

    UploadcareChunkFragment$onCreateView$3(UploadcareChunkFragment uploadcareChunkFragment) {
        this.this$0 = uploadcareChunkFragment;
    }

    public final void onChanged(List<Thing> list) {
        FilesAdapter access$getMAdapter$p = this.this$0.mAdapter;
        if (access$getMAdapter$p != null) {
            access$getMAdapter$p.updateItems(list);
        }
    }
}
