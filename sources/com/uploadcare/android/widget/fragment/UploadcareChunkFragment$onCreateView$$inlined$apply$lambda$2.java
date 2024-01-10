package com.uploadcare.android.widget.fragment;

import com.uploadcare.android.widget.data.SocialSource;
import com.uploadcare.android.widget.data.Thing;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "thing", "Lcom/uploadcare/android/widget/data/Thing;", "invoke", "com/uploadcare/android/widget/fragment/UploadcareChunkFragment$onCreateView$1$2"}, k = 3, mv = {1, 4, 0})
/* compiled from: UploadcareChunkFragment.kt */
final class UploadcareChunkFragment$onCreateView$$inlined$apply$lambda$2 extends Lambda implements Function1<Thing, Unit> {
    final /* synthetic */ SocialSource $socialSource$inlined;
    final /* synthetic */ UploadcareChunkFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UploadcareChunkFragment$onCreateView$$inlined$apply$lambda$2(UploadcareChunkFragment uploadcareChunkFragment, SocialSource socialSource) {
        super(1);
        this.this$0 = uploadcareChunkFragment;
        this.$socialSource$inlined = socialSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Thing) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Thing thing) {
        Intrinsics.checkNotNullParameter(thing, "thing");
        this.this$0.itemSelected(thing);
    }
}
