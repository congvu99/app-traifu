package com.uploadcare.android.widget.fragment;

import android.net.Uri;
import androidx.lifecycle.Observer;
import com.uploadcare.android.widget.viewmodels.MediaType;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "mediaType", "Lkotlin/Pair;", "Landroid/net/Uri;", "Lcom/uploadcare/android/widget/viewmodels/MediaType;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 0})
/* compiled from: UploadcareFragment.kt */
final class UploadcareFragment$onCreateView$5<T> implements Observer<Pair<? extends Uri, ? extends MediaType>> {
    final /* synthetic */ UploadcareFragment this$0;

    UploadcareFragment$onCreateView$5(UploadcareFragment uploadcareFragment) {
        this.this$0 = uploadcareFragment;
    }

    public final void onChanged(Pair<? extends Uri, ? extends MediaType> pair) {
        this.this$0.launchCamera((Uri) pair.getFirst(), (MediaType) pair.getSecond());
    }
}
