package com.uploadcare.android.widget.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "result", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: UploadcareAuthFragment.kt */
final class UploadcareAuthFragment$onCreateView$2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ UploadcareAuthFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UploadcareAuthFragment$onCreateView$2(UploadcareAuthFragment uploadcareAuthFragment) {
        super(1);
        this.this$0 = uploadcareAuthFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        if (str != null) {
            UploadcareAuthFragment.access$getMOnAuthListener$p(this.this$0).onAuthSuccess(str);
        } else {
            UploadcareAuthFragment.access$getMOnAuthListener$p(this.this$0).onAuthError();
        }
    }
}